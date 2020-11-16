package com.baidu.tieba.setting.more;

import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes25.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity mHP;
    private d mHQ;
    private com.baidu.tbadk.core.dialog.i mHR;
    private k mHS;
    private SettingTextNormalImageView mHT;
    private SettingTextImageView mHU;
    private TbSettingTextTipView mHV;
    private TbSettingTextTipView mHW;
    private TbSettingTextTipView mHX;
    private TbSettingTextTipView mHY;
    private TbSettingTextTipView mHZ;
    private TbSettingTextTipView mIa;
    private TbSettingTextTipView mIb;
    private SettingTextVersionView mIc;
    private TbSettingTextTipView mIe;
    private TbSettingTextTipView mIf;
    private TbSettingTextNewDotView mIg;
    private TextView mIh;
    private RelativeLayout mIi;
    private View mIj;
    private View mIk;
    private View mIl;
    private View mIm;
    private View mIn;
    private View mIo;
    private View mIq;
    private RelativeLayout mIr;
    private BdSwitchView mIt;
    private RelativeLayout mIu;
    private BdSwitchView mIv;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mIl = null;
        this.mIm = null;
        this.mIn = null;
        this.mIo = null;
        this.mIq = null;
        this.mIr = null;
        this.mIt = null;
        this.mIu = null;
        this.mIv = null;
        this.mHP = moreActivity;
        this.mHQ = dVar;
        this.mHP.setContentView(R.layout.more_activity);
        bxl();
        dDV();
    }

    public void dDT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mHU.setVisibility(8);
        } else {
            this.mHU.setVisibility(0);
        }
    }

    public void bb(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mHU != null) {
                this.mHU.dFc();
                return;
            }
            return;
        }
        this.mHU.dFd();
        this.mHU.setIcon(str, z);
    }

    public void dDU() {
        if (this.mIc != null) {
            this.mIc.refresh();
        }
        if (this.mIg != null) {
            this.mIg.refresh();
        }
    }

    public void dDV() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mIt.turnOn();
        } else {
            this.mIt.turnOff();
        }
    }

    public void Jm(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "1").dR("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "0").dR("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dCT() {
        this.mHU.recycle();
        this.mHV.recycle();
        this.mHW.recycle();
        this.mHX.recycle();
        this.mHY.recycle();
        this.mIa.recycle();
        this.mIb.recycle();
        this.mIc.recycle();
        this.mIe.recycle();
        this.mIf.recycle();
    }

    public void onChangeSkinType(int i) {
        rx(i);
        if (this.mHS != null) {
            this.mHP.getLayoutMode().setNightMode(i == 1);
            this.mHP.getLayoutMode().onModeChanged(this.mHS.getView());
        }
        if (i == 1) {
            this.mIt.turnOnNoCallback();
        } else {
            this.mIt.turnOffNoCallback();
        }
    }

    public void rx(int i) {
        ap.setBackgroundColor(this.mIi, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mHU.rx(i);
        this.mHP.getLayoutMode().setNightMode(i == 1);
        this.mHP.getLayoutMode().onModeChanged(this.mIi);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dDU();
        this.mIt.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mIv.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mIj, R.color.CAM_X0201);
        this.mHT.setLocalIcon(ap.ps(R.drawable.icon_mine_list_baidu));
        if (this.mHS != null) {
            this.mHS.onChangeSkinType();
        }
        this.mHT.rx(i);
        this.mHU.rx(i);
        this.mHV.onChangeSkinType(i);
        this.mHW.onChangeSkinType(i);
        this.mHX.onChangeSkinType(i);
        this.mHY.onChangeSkinType(i);
        this.mHZ.onChangeSkinType(i);
        this.mIa.onChangeSkinType(i);
        this.mIb.onChangeSkinType(i);
        this.mIc.onChangeSkinType(i);
        this.mIe.onChangeSkinType(i);
        this.mIf.onChangeSkinType(i);
        this.mIg.onChangeSkinType(i);
    }

    private void bxl() {
        View.OnClickListener clickListener = getClickListener();
        this.mIi = (RelativeLayout) this.mHP.findViewById(R.id.parent);
        this.mIj = this.mHP.findViewById(R.id.scroll);
        this.mHP.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mHP.findViewById(R.id.view_navigation_bar);
        this.mIk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mHP.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mHT = (SettingTextNormalImageView) this.mHP.findViewById(R.id.accountSafeSetting);
        this.mHU = (SettingTextImageView) this.mHP.findViewById(R.id.personInfo);
        this.mHV = (TbSettingTextTipView) this.mHP.findViewById(R.id.interest_label_setting);
        this.mHV.setTopLineVisibility(true);
        this.mHW = (TbSettingTextTipView) this.mHP.findViewById(R.id.accountManager);
        this.mHW.setTopLineVisibility(true);
        this.mHX = (TbSettingTextTipView) this.mHP.findViewById(R.id.browseSetting);
        this.mHX.setBottomLineVisibility(true);
        this.mHY = (TbSettingTextTipView) this.mHP.findViewById(R.id.youngsterSetting);
        this.mHY.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bGL()) {
            this.mHY.setTip(this.mHP.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mHY.setTip(this.mHP.getString(R.string.youngster_settings_tip_close));
        }
        this.mHZ = (TbSettingTextTipView) this.mHP.findViewById(R.id.adSetting);
        this.mHZ.setBottomLineVisibility(true);
        this.mIa = (TbSettingTextTipView) this.mHP.findViewById(R.id.messageSetting);
        this.mIa.setBottomLineVisibility(true);
        this.mHX.setBottomLineVisibility(true);
        this.mIb = (TbSettingTextTipView) this.mHP.findViewById(R.id.secretSetting);
        this.mIb.setBottomLineVisibility(true);
        this.mIc = (SettingTextVersionView) this.mHP.findViewById(R.id.versionInfo);
        this.mIe = (TbSettingTextTipView) this.mHP.findViewById(R.id.feedBack);
        this.mIe.setTopLineVisibility(true);
        this.mIe.setBottomLineVisibility(true);
        this.mIf = (TbSettingTextTipView) this.mHP.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mIf.setVisibility(8);
            this.mIf.setBottomLineVisibility(false);
        } else {
            this.mIf.setVisibility(0);
            this.mIf.setBottomLineVisibility(true);
        }
        this.mIg = (TbSettingTextNewDotView) this.mHP.findViewById(R.id.systemhelpsetting);
        this.mIh = (TextView) this.mHP.findViewById(R.id.quit);
        this.mIr = (RelativeLayout) this.mHP.findViewById(R.id.eyeshield_mode);
        this.mIt = (BdSwitchView) this.mHP.findViewById(R.id.item_switch);
        l.addToParentArea(this.mHP.getPageContext().getPageActivity(), this.mIt, 10, 10, 10, 10);
        this.mIu = (RelativeLayout) this.mHP.findViewById(R.id.follow_system_day_night_mode);
        this.mIv = (BdSwitchView) this.mHP.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mHP.getPageContext().getPageActivity(), this.mIv, 10, 10, 10, 10);
        this.mIl = this.mHP.findViewById(R.id.divide_view2);
        this.mIm = this.mHP.findViewById(R.id.divide_view1);
        this.mIn = this.mHP.findViewById(R.id.divide_view3);
        this.mIo = this.mHP.findViewById(R.id.divide_view4);
        this.mIq = this.mHP.findViewById(R.id.divide_view5);
        dDU();
        dDT();
        this.mHU.dFc();
        rx(TbadkCoreApplication.getInst().getSkinType());
        this.mIm.setVisibility(0);
        this.mIn.setVisibility(0);
        this.mIo.setVisibility(0);
        this.mIq.setVisibility(0);
        ae(clickListener);
        if (!dDW()) {
            this.mHX.setTip(this.mHP.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mIl.setVisibility(8);
            this.mIr.setVisibility(8);
        } else {
            this.mIl.setVisibility(0);
            this.mIr.setVisibility(0);
        }
        this.mIu.setVisibility(dDX() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_is_follow_system_mode", false)) {
            this.mIv.turnOnNoCallback();
        } else {
            this.mIv.turnOffNoCallback();
        }
    }

    private boolean dDW() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dDX() {
        if (dDW()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void apc() {
        this.mHS = new k(getPageContext().getPageActivity());
        this.mHS.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mHS);
        gVar.setTextColor(R.color.CAM_X0301);
        arrayList.add(gVar);
        this.mHP.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mHP.getLayoutMode().onModeChanged(this.mHS.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.GM();
                    e.this.mHQ.Jh(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.GM();
            }
        };
        this.mHS.br(arrayList);
        this.mHS.a(cVar);
        this.mHS.a(aVar);
        this.mHR = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mHR.setCanceledOnTouchOutside(true);
        this.mHR.a(this.mHS);
    }

    private void ae(View.OnClickListener onClickListener) {
        this.mHT.setOnClickListener(onClickListener);
        this.mIk.setOnClickListener(onClickListener);
        this.mHU.setOnClickListener(onClickListener);
        this.mHV.setOnClickListener(onClickListener);
        this.mHW.setOnClickListener(onClickListener);
        this.mHX.setOnClickListener(onClickListener);
        this.mHY.setOnClickListener(onClickListener);
        this.mHZ.setOnClickListener(onClickListener);
        this.mIa.setOnClickListener(onClickListener);
        this.mIb.setOnClickListener(onClickListener);
        this.mIc.setOnClickListener(onClickListener);
        this.mIe.setOnClickListener(onClickListener);
        this.mIf.setOnClickListener(onClickListener);
        this.mIg.setOnClickListener(onClickListener);
        this.mIh.setOnClickListener(onClickListener);
        this.mIt.setOnSwitchStateChangeListener(this.mHP);
        this.mIv.setOnSwitchStateChangeListener(this.mHP);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mIk) {
                    e.this.mHQ.Jh(0);
                } else if (view == e.this.mHU) {
                    e.this.mHQ.Jh(1);
                } else if (view == e.this.mHV) {
                    e.this.mHQ.Jh(15);
                } else if (view == e.this.mHW) {
                    e.this.mHQ.Jh(2);
                } else if (view == e.this.mHX) {
                    e.this.mHQ.Jh(3);
                } else if (view == e.this.mHY) {
                    e.this.mHQ.Jh(17);
                } else if (view == e.this.mIa) {
                    e.this.mHQ.Jh(4);
                } else if (view == e.this.mIb) {
                    e.this.mHQ.Jh(9);
                } else if (view == e.this.mIc) {
                    e.this.mHQ.Jh(6);
                } else if (view == e.this.mIe) {
                    e.this.mHQ.Jh(7);
                } else if (view == e.this.mIf) {
                    e.this.mHQ.Jh(8);
                } else if (view == e.this.mIg) {
                    e.this.mHQ.Jh(5);
                } else if (view == e.this.mIh) {
                    e.this.mHQ.Jh(10);
                } else if (view == e.this.mHT) {
                    e.this.mHQ.Jh(13);
                } else if (view == e.this.mHZ) {
                    e.this.mHQ.Jh(16);
                }
            }
        };
    }

    public void dDY() {
        if (this.mHR == null) {
            apc();
        }
        this.mHR.PA();
    }

    public void GM() {
        if (this.mHR != null) {
            this.mHR.dismiss();
        }
    }

    public BdSwitchView dDZ() {
        return this.mIt;
    }

    public BdSwitchView dEa() {
        return this.mIv;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mHP).areNotificationsEnabled();
        if (this.mIa != null) {
            this.mIa.setTipViewColor(R.color.CAM_X0105);
            this.mIa.setTip(areNotificationsEnabled ? "" : this.mHP.getString(R.string.may_lose_important_msg));
        }
    }
}
