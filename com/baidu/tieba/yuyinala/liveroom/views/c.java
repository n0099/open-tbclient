package com.baidu.tieba.yuyinala.liveroom.views;

import android.app.Activity;
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
/* loaded from: classes4.dex */
public class c {
    private int count;
    private ViewGroup hGq;
    private ImageView hGr;
    private TextView hGs;
    private String hGt;
    private Runnable hGu = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.mHandler.removeCallbacks(this);
            if (c.this.count > 2) {
                c.this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            c.this.isShowLocation = c.this.clC();
            c.this.clH();
            c.this.mHandler.postDelayed(this, IMConnection.RETRY_DELAY_TIMES);
            c.d(c.this);
        }
    };
    private CustomMessageListener hGv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
                c.this.isShowLocation = c.this.clC();
                if (c.this.isShowLocation) {
                    c.this.hGs.setText(a.h.ala_live_prepare_locating);
                } else {
                    c.this.hGs.setText(a.h.yuyin_ala_live_prepare_locate_title);
                }
            }
            c.this.mHandler.postDelayed(c.this.hGu, IMConnection.RETRY_DELAY_TIMES);
        }
    };
    private CustomMessageListener hGw = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.isShowLocation = c.this.clC();
            c.this.clH();
            if (c.this.clC()) {
                LocationInfo locationInfo = c.this.mLocation.getLocationInfo();
                if (locationInfo == null || StringUtils.isNull(locationInfo.getCurCityName())) {
                    c.this.hGs.setText(a.h.ala_live_prepare_locate_fail);
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
        this.isShowLocation = clC();
        MessageManager.getInstance().registerListener(this.hGv);
        MessageManager.getInstance().registerListener(this.hGw);
        this.mHandler = new Handler();
    }

    public void aC(ViewGroup viewGroup) {
        this.hGq = viewGroup;
        this.hGr = (ImageView) viewGroup.findViewById(a.f.ala_live_prepare_locate_img);
        this.hGs = (TextView) viewGroup.findViewById(a.f.ala_live_prepare_locate_tv);
        this.mLocation = LocationManager.getInstance().buildLocation();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
            if (!checkPermission()) {
                clG();
            } else {
                clH();
            }
        } else {
            clH();
        }
        this.hGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.clE();
            }
        });
    }

    public boolean clC() {
        return UtilHelper.isSystemLocationProviderEnabled(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgQ() {
        boolean z = false;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba()) {
            com.baidu.live.d.BM().getBoolean("has_request_location", false);
            com.baidu.live.d.BM().putBoolean("has_request_location", true);
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
    public void clE() {
        if (this.isShowLocation) {
            LogManager.getLiveRecordLogger().doClickLiveLocationAlreadyButtonLog("");
        } else {
            LogManager.getLiveRecordLogger().doClickLiveLocationAllowButtonLog("");
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.LIVE_ACTION, "location"));
        if (!cgQ()) {
            this.isShowLocation = !this.isShowLocation;
            clF();
        }
    }

    private void clF() {
        clH();
    }

    private void clG() {
        if (!com.baidu.live.d.BM().getBoolean("has_master_show_location_dialog", false)) {
            com.baidu.live.d.BM().putBoolean("has_master_show_location_dialog", true);
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
                    c.this.cgQ();
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
    public void clH() {
        if (this.isShowLocation) {
            if (this.mLocation != null) {
                LocationInfo locationInfo = this.mLocation.getLocationInfo();
                if (locationInfo != null && !StringUtils.isNull(locationInfo.getCurCityName())) {
                    this.hGs.setText(locationInfo.getCurCityName());
                    this.hGt = locationInfo.getCurCityName();
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.hGs.setText(a.h.ala_live_prepare_locating);
                } else {
                    this.hGs.setText(a.h.ala_live_prepare_locate_opened_title);
                }
            } else {
                this.hGs.setText(a.h.ala_live_prepare_locate_opened_title);
            }
        } else {
            this.hGs.setText(a.h.yuyin_ala_live_prepare_locate_title);
        }
        this.hGr.setSelected(!this.isShowLocation);
        this.hGs.setTextColor(this.isShowLocation ? this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_g) : this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_i_alpha50));
    }

    public boolean isShowLocation() {
        return this.isShowLocation;
    }
}
