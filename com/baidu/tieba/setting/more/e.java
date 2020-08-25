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
/* loaded from: classes20.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity lPM;
    private d lPN;
    private com.baidu.tbadk.core.dialog.i lPO;
    private k lPP;
    private SettingTextNormalImageView lPQ;
    private SettingTextImageView lPR;
    private TbSettingTextTipView lPS;
    private TbSettingTextTipView lPT;
    private TbSettingTextTipView lPU;
    private TbSettingTextTipView lPV;
    private TbSettingTextTipView lPW;
    private TbSettingTextTipView lPX;
    private TbSettingTextTipView lPY;
    private SettingTextVersionView lPZ;
    private TbSettingTextTipView lQa;
    private TbSettingTextTipView lQb;
    private TbSettingTextNewDotView lQc;
    private TextView lQd;
    private RelativeLayout lQe;
    private View lQf;
    private View lQg;
    private View lQh;
    private View lQi;
    private View lQj;
    private View lQk;
    private View lQl;
    private RelativeLayout lQm;
    private BdSwitchView lQn;
    private RelativeLayout lQo;
    private BdSwitchView lQp;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lQh = null;
        this.lQi = null;
        this.lQj = null;
        this.lQk = null;
        this.lQl = null;
        this.lQm = null;
        this.lQn = null;
        this.lQo = null;
        this.lQp = null;
        this.lPM = moreActivity;
        this.lPN = dVar;
        this.lPM.setContentView(R.layout.more_activity);
        bpY();
        drc();
    }

    public void dra() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lPR.setVisibility(8);
        } else {
            this.lPR.setVisibility(0);
        }
    }

    public void aV(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lPR != null) {
                this.lPR.dsh();
                return;
            }
            return;
        }
        this.lPR.dsi();
        this.lPR.setIcon(str, z);
    }

    public void drb() {
        if (this.lPZ != null) {
            this.lPZ.refresh();
        }
        if (this.lQc != null) {
            this.lQc.refresh();
        }
    }

    public void drc() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lQn.turnOn();
        } else {
            this.lQn.turnOff();
        }
    }

    public void GW(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dD("obj_type", "1").dD("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).dD("obj_type", "0").dD("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void dqd() {
        this.lPR.recycle();
        this.lPS.recycle();
        this.lPT.recycle();
        this.lPU.recycle();
        this.lPV.recycle();
        this.lPX.recycle();
        this.lPY.recycle();
        this.lPZ.recycle();
        this.lQa.recycle();
        this.lQb.recycle();
    }

    public void onChangeSkinType(int i) {
        pT(i);
        if (this.lPP != null) {
            this.lPM.getLayoutMode().setNightMode(i == 1);
            this.lPM.getLayoutMode().onModeChanged(this.lPP.getView());
        }
        if (i == 1) {
            this.lQn.turnOnNoCallback();
        } else {
            this.lQn.turnOffNoCallback();
        }
    }

    public void pT(int i) {
        ap.setBackgroundColor(this.lQe, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lPR.pT(i);
        this.lPM.getLayoutMode().setNightMode(i == 1);
        this.lPM.getLayoutMode().onModeChanged(this.lQe);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        drb();
        this.lQn.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lQp.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        ap.setBackgroundColor(this.lQf, R.color.cp_bg_line_d);
        this.lPQ.setLocalIcon(ap.nS(R.drawable.icon_mine_list_baidu));
        if (this.lPP != null) {
            this.lPP.onChangeSkinType();
        }
        this.lPQ.pT(i);
        this.lPR.pT(i);
        this.lPS.onChangeSkinType(i);
        this.lPT.onChangeSkinType(i);
        this.lPU.onChangeSkinType(i);
        this.lPV.onChangeSkinType(i);
        this.lPW.onChangeSkinType(i);
        this.lPX.onChangeSkinType(i);
        this.lPY.onChangeSkinType(i);
        this.lPZ.onChangeSkinType(i);
        this.lQa.onChangeSkinType(i);
        this.lQb.onChangeSkinType(i);
        this.lQc.onChangeSkinType(i);
    }

    private void bpY() {
        View.OnClickListener clickListener = getClickListener();
        this.lQe = (RelativeLayout) this.lPM.findViewById(R.id.parent);
        this.lQf = this.lPM.findViewById(R.id.scroll);
        this.lPM.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lPM.findViewById(R.id.view_navigation_bar);
        this.lQg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lPM.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lPQ = (SettingTextNormalImageView) this.lPM.findViewById(R.id.accountSafeSetting);
        this.lPR = (SettingTextImageView) this.lPM.findViewById(R.id.personInfo);
        this.lPS = (TbSettingTextTipView) this.lPM.findViewById(R.id.interest_label_setting);
        this.lPS.setTopLineVisibility(true);
        this.lPT = (TbSettingTextTipView) this.lPM.findViewById(R.id.accountManager);
        this.lPT.setTopLineVisibility(true);
        this.lPU = (TbSettingTextTipView) this.lPM.findViewById(R.id.browseSetting);
        this.lPU.setBottomLineVisibility(true);
        this.lPV = (TbSettingTextTipView) this.lPM.findViewById(R.id.youngsterSetting);
        this.lPV.setBottomLineVisibility(true);
        if (com.baidu.tbadk.youngster.b.b.bze()) {
            this.lPV.setTip(this.lPM.getString(R.string.youngster_settings_tip_open));
        } else {
            this.lPV.setTip(this.lPM.getString(R.string.youngster_settings_tip_close));
        }
        this.lPW = (TbSettingTextTipView) this.lPM.findViewById(R.id.adSetting);
        this.lPW.setBottomLineVisibility(true);
        this.lPX = (TbSettingTextTipView) this.lPM.findViewById(R.id.messageSetting);
        this.lPX.setBottomLineVisibility(true);
        this.lPU.setBottomLineVisibility(true);
        this.lPY = (TbSettingTextTipView) this.lPM.findViewById(R.id.secretSetting);
        this.lPY.setBottomLineVisibility(true);
        this.lPZ = (SettingTextVersionView) this.lPM.findViewById(R.id.versionInfo);
        this.lQa = (TbSettingTextTipView) this.lPM.findViewById(R.id.feedBack);
        this.lQa.setTopLineVisibility(true);
        this.lQa.setBottomLineVisibility(true);
        this.lQb = (TbSettingTextTipView) this.lPM.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lQb.setVisibility(8);
            this.lQb.setBottomLineVisibility(false);
        } else {
            this.lQb.setVisibility(0);
            this.lQb.setBottomLineVisibility(true);
        }
        this.lQc = (TbSettingTextNewDotView) this.lPM.findViewById(R.id.systemhelpsetting);
        this.lQd = (TextView) this.lPM.findViewById(R.id.quit);
        this.lQm = (RelativeLayout) this.lPM.findViewById(R.id.eyeshield_mode);
        this.lQn = (BdSwitchView) this.lPM.findViewById(R.id.item_switch);
        l.addToParentArea(this.lPM.getPageContext().getPageActivity(), this.lQn, 10, 10, 10, 10);
        this.lQo = (RelativeLayout) this.lPM.findViewById(R.id.follow_system_day_night_mode);
        this.lQp = (BdSwitchView) this.lPM.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lPM.getPageContext().getPageActivity(), this.lQp, 10, 10, 10, 10);
        this.lQh = this.lPM.findViewById(R.id.divide_view2);
        this.lQi = this.lPM.findViewById(R.id.divide_view1);
        this.lQj = this.lPM.findViewById(R.id.divide_view3);
        this.lQk = this.lPM.findViewById(R.id.divide_view4);
        this.lQl = this.lPM.findViewById(R.id.divide_view5);
        drb();
        dra();
        this.lPR.dsh();
        pT(TbadkCoreApplication.getInst().getSkinType());
        this.lQi.setVisibility(0);
        this.lQj.setVisibility(0);
        this.lQk.setVisibility(0);
        this.lQl.setVisibility(0);
        ad(clickListener);
        if (!drd()) {
            this.lPU.setTip(this.lPM.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lQh.setVisibility(8);
            this.lQm.setVisibility(8);
        } else {
            this.lQh.setVisibility(0);
            this.lQm.setVisibility(0);
        }
        this.lQo.setVisibility(dre() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_is_follow_system_mode", false)) {
            this.lQp.turnOnNoCallback();
        } else {
            this.lQp.turnOffNoCallback();
        }
    }

    private boolean drd() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dre() {
        if (drd()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ahV() {
        this.lPP = new k(getPageContext().getPageActivity());
        this.lPP.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lPP);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lPM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lPM.getLayoutMode().onModeChanged(this.lPP.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.Fd();
                    e.this.lPN.GR(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.Fd();
            }
        };
        this.lPP.aT(arrayList);
        this.lPP.a(cVar);
        this.lPP.a(aVar);
        this.lPO = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lPO.setCanceledOnTouchOutside(true);
        this.lPO.a(this.lPP);
    }

    private void ad(View.OnClickListener onClickListener) {
        this.lPQ.setOnClickListener(onClickListener);
        this.lQg.setOnClickListener(onClickListener);
        this.lPR.setOnClickListener(onClickListener);
        this.lPS.setOnClickListener(onClickListener);
        this.lPT.setOnClickListener(onClickListener);
        this.lPU.setOnClickListener(onClickListener);
        this.lPV.setOnClickListener(onClickListener);
        this.lPW.setOnClickListener(onClickListener);
        this.lPX.setOnClickListener(onClickListener);
        this.lPY.setOnClickListener(onClickListener);
        this.lPZ.setOnClickListener(onClickListener);
        this.lQa.setOnClickListener(onClickListener);
        this.lQb.setOnClickListener(onClickListener);
        this.lQc.setOnClickListener(onClickListener);
        this.lQd.setOnClickListener(onClickListener);
        this.lQn.setOnSwitchStateChangeListener(this.lPM);
        this.lQp.setOnSwitchStateChangeListener(this.lPM);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lQg) {
                    e.this.lPN.GR(0);
                } else if (view == e.this.lPR) {
                    e.this.lPN.GR(1);
                } else if (view == e.this.lPS) {
                    e.this.lPN.GR(15);
                } else if (view == e.this.lPT) {
                    e.this.lPN.GR(2);
                } else if (view == e.this.lPU) {
                    e.this.lPN.GR(3);
                } else if (view == e.this.lPV) {
                    e.this.lPN.GR(17);
                } else if (view == e.this.lPX) {
                    e.this.lPN.GR(4);
                } else if (view == e.this.lPY) {
                    e.this.lPN.GR(9);
                } else if (view == e.this.lPZ) {
                    e.this.lPN.GR(6);
                } else if (view == e.this.lQa) {
                    e.this.lPN.GR(7);
                } else if (view == e.this.lQb) {
                    e.this.lPN.GR(8);
                } else if (view == e.this.lQc) {
                    e.this.lPN.GR(5);
                } else if (view == e.this.lQd) {
                    e.this.lPN.GR(10);
                } else if (view == e.this.lPQ) {
                    e.this.lPN.GR(13);
                } else if (view == e.this.lPW) {
                    e.this.lPN.GR(16);
                }
            }
        };
    }

    public void drf() {
        if (this.lPO == null) {
            ahV();
        }
        this.lPO.Nv();
    }

    public void Fd() {
        if (this.lPO != null) {
            this.lPO.dismiss();
        }
    }

    public BdSwitchView drg() {
        return this.lQn;
    }

    public BdSwitchView drh() {
        return this.lQp;
    }

    public void onResume() {
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.lPM).areNotificationsEnabled();
        if (this.lPX != null) {
            this.lPX.setTipViewColor(R.color.cp_cont_b);
            this.lPX.setTip(areNotificationsEnabled ? "" : this.lPM.getString(R.string.may_lose_important_msg));
        }
    }
}
