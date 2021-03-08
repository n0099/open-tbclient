package com.baidu.tieba.yuyinala.liveroom.views;

import android.app.Activity;
import android.net.http.Headers;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.live.tbadk.location.LocationInfo;
import com.baidu.live.tbadk.location.LocationManager;
import com.baidu.live.tbadk.location.interfaces.ILocation;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class c {
    private int count;
    private ViewGroup hUd;
    private ImageView hUe;
    private TextView hUf;
    private String hUg;
    private Runnable hUh = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mHandler.removeCallbacks(this);
            if (c.this.count > 2) {
                c.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            c.this.isShowLocation = c.this.clN();
            c.this.clS();
            c.this.mHandler.postDelayed(this, IMConnection.RETRY_DELAY_TIMES);
            c.d(c.this);
        }
    };
    private CustomMessageListener hUi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                c.this.isShowLocation = c.this.clN();
                if (c.this.isShowLocation) {
                    c.this.hUf.setText(a.h.ala_live_prepare_locating);
                } else {
                    c.this.hUf.setText(a.h.yuyin_ala_live_prepare_locate_title);
                }
            }
            c.this.mHandler.postDelayed(c.this.hUh, IMConnection.RETRY_DELAY_TIMES);
        }
    };
    private CustomMessageListener hUj = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.isShowLocation = c.this.clN();
            c.this.clS();
            if (c.this.clN()) {
                LocationInfo locationInfo = c.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    c.this.hUf.setText(a.h.ala_live_prepare_locate_fail);
                }
            }
        }
    };
    private boolean isShowLocation;
    private Handler mHandler;
    private ILocation mLocation;
    private TbPageContext mPageContext;

    static /* synthetic */ int d(c cVar) {
        int i = cVar.count;
        cVar.count = i + 1;
        return i;
    }

    public c(TbPageContext tbPageContext) {
        this.isShowLocation = true;
        this.mPageContext = tbPageContext;
        this.isShowLocation = clN();
        MessageManager.getInstance().registerListener(this.hUi);
        MessageManager.getInstance().registerListener(this.hUj);
        this.mHandler = new Handler();
    }

    public void aO(ViewGroup viewGroup) {
        this.hUd = viewGroup;
        this.hUe = (ImageView) viewGroup.findViewById(a.f.ala_live_prepare_locate_img);
        this.hUf = (TextView) viewGroup.findViewById(a.f.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
            if (!checkPermission()) {
                clR();
            } else {
                clS();
            }
        } else {
            clS();
        }
        this.hUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.clP();
            }
        });
    }

    public boolean clN() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgT() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.d.xf().getBoolean("has_request_location", false);
            com.baidu.live.d.xf().putBoolean("has_request_location", true);
            z = true;
        }
        Activity pageActivity = this.mPageContext.getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_FINE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_COARSE_LOCATION");
        return permissionJudgePolicy.startRequestPermission(pageActivity, z, true);
    }

    private boolean checkPermission() {
        Activity pageActivity = this.mPageContext.getPageActivity();
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_FINE_LOCATION");
        permissionJudgePolicy.appendRequestPermission(pageActivity, "android.permission.ACCESS_COARSE_LOCATION");
        return permissionJudgePolicy.checkPermissionListGranted(pageActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clP() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, Headers.LOCATION));
        if (!cgT()) {
            this.isShowLocation = !this.isShowLocation;
            clQ();
        }
    }

    private void clQ() {
        clS();
    }

    private void clR() {
        if (!com.baidu.live.d.xf().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.d.xf().putBoolean("has_master_show_location_dialog", true);
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.setTitle(a.h.sdk_open_permission_title);
            bdAlertDialog.setMessageId(a.h.sdk_open_permission_content);
            bdAlertDialog.setTitleShowCenter(true);
            bdAlertDialog.setMessageShowCenter(true);
            bdAlertDialog.isShowTitleAndMessage();
            bdAlertDialog.setPositiveButton(a.h.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.6
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    c.this.cgT();
                }
            }).setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            }).create(this.mPageContext);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clS() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.hUf.setText(locationInfo.getCurCityName());
                    this.hUg = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.hUf.setText(a.h.ala_live_prepare_locating);
                } else {
                    this.hUf.setText(a.h.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.hUf.setText(a.h.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.hUf.setText(a.h.yuyin_ala_live_prepare_locate_title);
        }
        this.hUe.setSelected(!this.isShowLocation);
        this.hUf.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }
}
