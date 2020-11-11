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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView mHA;
    private TbSettingTextTipView mHB;
    private TbSettingTextTipView mHC;
    private SettingTextVersionView mHD;
    private TbSettingTextTipView mHE;
    private TbSettingTextTipView mHF;
    private TbSettingTextNewDotView mHG;
    private TextView mHH;
    private RelativeLayout mHI;
    private View mHJ;
    private View mHK;
    private View mHL;
    private View mHM;
    private View mHN;
    private View mHO;
    private View mHP;
    private RelativeLayout mHQ;
    private BdSwitchView mHR;
    private RelativeLayout mHS;
    private BdSwitchView mHT;
    private MoreActivity mHq;
    private d mHr;
    private com.baidu.tbadk.core.dialog.i mHs;
    private k mHt;
    private SettingTextNormalImageView mHu;
    private SettingTextImageView mHv;
    private TbSettingTextTipView mHw;
    private TbSettingTextTipView mHx;
    private TbSettingTextTipView mHy;
    private TbSettingTextTipView mHz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.mHL = null;
        this.mHM = null;
        this.mHN = null;
        this.mHO = null;
        this.mHP = null;
        this.mHQ = null;
        this.mHR = null;
        this.mHS = null;
        this.mHT = null;
        this.mHq = moreActivity;
        this.mHr = dVar;
        this.mHq.setContentView(R.layout.more_activity);
        bxV();
        dEq();
    }

    public void dEo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mHv.setVisibility(8);
        } else {
            this.mHv.setVisibility(0);
        }
    }

    public void bb(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.mHv != null) {
                this.mHv.dFx();
                return;
            }
            return;
        }
        this.mHv.dFy();
        this.mHv.setIcon(str, z);
    }

    public void dEp() {
        if (this.mHD != null) {
            this.mHD.refresh();
        }
        if (this.mHG != null) {
            this.mHG.refresh();
        }
    }

    public void dEq() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.mHR.turnOn();
        } else {
            this.mHR.turnOff();
        }
    }

    public void IL(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "1").dR("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dR("obj_type", "0").dR("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dDp() {
        this.mHv.recycle();
        this.mHw.recycle();
        this.mHx.recycle();
        this.mHy.recycle();
        this.mHz.recycle();
        this.mHB.recycle();
        this.mHC.recycle();
        this.mHD.recycle();
        this.mHE.recycle();
        this.mHF.recycle();
    }

    public void onChangeSkinType(int i) {
        qZ(i);
        if (this.mHt != null) {
            this.mHq.getLayoutMode().setNightMode(i == 1);
            this.mHq.getLayoutMode().onModeChanged(this.mHt.getView());
        }
        if (i == 1) {
            this.mHR.turnOnNoCallback();
        } else {
            this.mHR.turnOffNoCallback();
        }
    }

    public void qZ(int i) {
        ap.setBackgroundColor(this.mHI, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mHv.qZ(i);
        this.mHq.getLayoutMode().setNightMode(i == 1);
        this.mHq.getLayoutMode().onModeChanged(this.mHI);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dEp();
        this.mHR.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mHT.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.mHJ, R.color.cp_bg_line_d);
        this.mHu.setLocalIcon(ap.oW(R.drawable.icon_mine_list_baidu));
        if (this.mHt != null) {
            this.mHt.onChangeSkinType();
        }
        this.mHu.qZ(i);
        this.mHv.qZ(i);
        this.mHw.onChangeSkinType(i);
        this.mHx.onChangeSkinType(i);
        this.mHy.onChangeSkinType(i);
        this.mHz.onChangeSkinType(i);
        this.mHA.onChangeSkinType(i);
        this.mHB.onChangeSkinType(i);
        this.mHC.onChangeSkinType(i);
        this.mHD.onChangeSkinType(i);
        this.mHE.onChangeSkinType(i);
        this.mHF.onChangeSkinType(i);
        this.mHG.onChangeSkinType(i);
    }

    private void bxV() {
        View.OnClickListener clickListener = getClickListener();
        this.mHI = (RelativeLayout) this.mHq.findViewById(R.id.parent);
        this.mHJ = this.mHq.findViewById(R.id.scroll);
        this.mHq.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.mHq.findViewById(R.id.view_navigation_bar);
        this.mHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.mHq.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.mHu = (SettingTextNormalImageView) this.mHq.findViewById(R.id.accountSafeSetting);
        this.mHv = (SettingTextImageView) this.mHq.findViewById(R.id.personInfo);
        this.mHw = (TbSettingTextTipView) this.mHq.findViewById(R.id.interest_label_setting);
        this.mHw.setTopLineVisibility(true);
        this.mHx = (TbSettingTextTipView) this.mHq.findViewById(R.id.accountManager);
        this.mHx.setTopLineVisibility(true);
        this.mHy = (TbSettingTextTipView) this.mHq.findViewById(R.id.browseSetting);
        this.mHy.setBottomLineVisibility(true);
        this.mHz = (TbSettingTextTipView) this.mHq.findViewById(R.id.youngsterSetting);
        this.mHz.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.c.bHs()) {
            this.mHz.setTip(this.mHq.getString(R.string.youngster_settings_tip_open));
        } else {
            this.mHz.setTip(this.mHq.getString(R.string.youngster_settings_tip_close));
        }
        this.mHA = (TbSettingTextTipView) this.mHq.findViewById(R.id.adSetting);
        this.mHA.setBottomLineVisibility(true);
        this.mHB = (TbSettingTextTipView) this.mHq.findViewById(R.id.messageSetting);
        this.mHB.setBottomLineVisibility(true);
        this.mHy.setBottomLineVisibility(true);
        this.mHC = (TbSettingTextTipView) this.mHq.findViewById(R.id.secretSetting);
        this.mHC.setBottomLineVisibility(true);
        this.mHD = (SettingTextVersionView) this.mHq.findViewById(R.id.versionInfo);
        this.mHE = (TbSettingTextTipView) this.mHq.findViewById(R.id.feedBack);
        this.mHE.setTopLineVisibility(true);
        this.mHE.setBottomLineVisibility(true);
        this.mHF = (TbSettingTextTipView) this.mHq.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.mHF.setVisibility(8);
            this.mHF.setBottomLineVisibility(false);
        } else {
            this.mHF.setVisibility(0);
            this.mHF.setBottomLineVisibility(true);
        }
        this.mHG = (TbSettingTextNewDotView) this.mHq.findViewById(R.id.systemhelpsetting);
        this.mHH = (TextView) this.mHq.findViewById(R.id.quit);
        this.mHQ = (RelativeLayout) this.mHq.findViewById(R.id.eyeshield_mode);
        this.mHR = (BdSwitchView) this.mHq.findViewById(R.id.item_switch);
        l.addToParentArea(this.mHq.getPageContext().getPageActivity(), this.mHR, 10, 10, 10, 10);
        this.mHS = (RelativeLayout) this.mHq.findViewById(R.id.follow_system_day_night_mode);
        this.mHT = (BdSwitchView) this.mHq.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.mHq.getPageContext().getPageActivity(), this.mHT, 10, 10, 10, 10);
        this.mHL = this.mHq.findViewById(R.id.divide_view2);
        this.mHM = this.mHq.findViewById(R.id.divide_view1);
        this.mHN = this.mHq.findViewById(R.id.divide_view3);
        this.mHO = this.mHq.findViewById(R.id.divide_view4);
        this.mHP = this.mHq.findViewById(R.id.divide_view5);
        dEp();
        dEo();
        this.mHv.dFx();
        qZ(TbadkCoreApplication.getInst().getSkinType());
        this.mHM.setVisibility(0);
        this.mHN.setVisibility(0);
        this.mHO.setVisibility(0);
        this.mHP.setVisibility(0);
        ae(clickListener);
        if (!dEr()) {
            this.mHy.setTip(this.mHq.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.mHL.setVisibility(8);
            this.mHQ.setVisibility(8);
        } else {
            this.mHL.setVisibility(0);
            this.mHQ.setVisibility(0);
        }
        this.mHS.setVisibility(dEs() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_is_follow_system_mode", false)) {
            this.mHT.turnOnNoCallback();
        } else {
            this.mHT.turnOffNoCallback();
        }
    }

    private boolean dEr() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dEs() {
        if (dEr()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void apL() {
        this.mHt = new k(getPageContext().getPageActivity());
        this.mHt.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.mHt);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.mHq.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.mHq.getLayoutMode().onModeChanged(this.mHt.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.Hv();
                    e.this.mHr.IG(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.Hv();
            }
        };
        this.mHt.br(arrayList);
        this.mHt.a(cVar);
        this.mHt.a(aVar);
        this.mHs = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.mHs.setCanceledOnTouchOutside(true);
        this.mHs.a(this.mHt);
    }

    private void ae(View.OnClickListener onClickListener) {
        this.mHu.setOnClickListener(onClickListener);
        this.mHK.setOnClickListener(onClickListener);
        this.mHv.setOnClickListener(onClickListener);
        this.mHw.setOnClickListener(onClickListener);
        this.mHx.setOnClickListener(onClickListener);
        this.mHy.setOnClickListener(onClickListener);
        this.mHz.setOnClickListener(onClickListener);
        this.mHA.setOnClickListener(onClickListener);
        this.mHB.setOnClickListener(onClickListener);
        this.mHC.setOnClickListener(onClickListener);
        this.mHD.setOnClickListener(onClickListener);
        this.mHE.setOnClickListener(onClickListener);
        this.mHF.setOnClickListener(onClickListener);
        this.mHG.setOnClickListener(onClickListener);
        this.mHH.setOnClickListener(onClickListener);
        this.mHR.setOnSwitchStateChangeListener(this.mHq);
        this.mHT.setOnSwitchStateChangeListener(this.mHq);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.mHK) {
                    e.this.mHr.IG(0);
                } else if (view == e.this.mHv) {
                    e.this.mHr.IG(1);
                } else if (view == e.this.mHw) {
                    e.this.mHr.IG(15);
                } else if (view == e.this.mHx) {
                    e.this.mHr.IG(2);
                } else if (view == e.this.mHy) {
                    e.this.mHr.IG(3);
                } else if (view == e.this.mHz) {
                    e.this.mHr.IG(17);
                } else if (view == e.this.mHB) {
                    e.this.mHr.IG(4);
                } else if (view == e.this.mHC) {
                    e.this.mHr.IG(9);
                } else if (view == e.this.mHD) {
                    e.this.mHr.IG(6);
                } else if (view == e.this.mHE) {
                    e.this.mHr.IG(7);
                } else if (view == e.this.mHF) {
                    e.this.mHr.IG(8);
                } else if (view == e.this.mHG) {
                    e.this.mHr.IG(5);
                } else if (view == e.this.mHH) {
                    e.this.mHr.IG(10);
                } else if (view == e.this.mHu) {
                    e.this.mHr.IG(13);
                } else if (view == e.this.mHA) {
                    e.this.mHr.IG(16);
                }
            }
        };
    }

    public void dEt() {
        if (this.mHs == null) {
            apL();
        }
        this.mHs.Qj();
    }

    public void Hv() {
        if (this.mHs != null) {
            this.mHs.dismiss();
        }
    }

    public BdSwitchView dEu() {
        return this.mHR;
    }

    public BdSwitchView dEv() {
        return this.mHT;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mHq).areNotificationsEnabled();
        if (this.mHB != null) {
            this.mHB.setTipViewColor(R.color.cp_cont_b);
            this.mHB.setTip(areNotificationsEnabled ? "" : this.mHq.getString(R.string.may_lose_important_msg));
        }
    }
}
