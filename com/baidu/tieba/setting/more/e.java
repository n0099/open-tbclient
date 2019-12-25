package com.baidu.tieba.setting.more;

import android.os.Build;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private TbSettingTextTipView jOA;
    private TbSettingTextTipView jOB;
    private TbSettingTextTipView jOC;
    private TbSettingTextTipView jOD;
    private SettingTextVersionView jOE;
    private TbSettingTextTipView jOF;
    private TbSettingTextTipView jOG;
    private TbSettingTextNewDotView jOH;
    private TextView jOI;
    private RelativeLayout jOJ;
    private View jOK;
    private View jOL;
    private View jOM;
    private View jON;
    private View jOO;
    private View jOP;
    private View jOQ;
    private RelativeLayout jOR;
    private BdSwitchView jOS;
    private RelativeLayout jOT;
    private BdSwitchView jOU;
    private MoreActivity jOs;
    private d jOt;
    private com.baidu.tbadk.core.dialog.i jOu;
    private k jOv;
    private SettingTextNormalImageView jOw;
    private SettingTextImageView jOx;
    private TbSettingTextTipView jOy;
    private TbSettingTextTipView jOz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jOM = null;
        this.jON = null;
        this.jOO = null;
        this.jOP = null;
        this.jOQ = null;
        this.jOR = null;
        this.jOS = null;
        this.jOT = null;
        this.jOU = null;
        this.jOs = moreActivity;
        this.jOt = dVar;
        this.jOs.setContentView(R.layout.more_activity);
        aKa();
        cDs();
    }

    public void cDq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jOx.setVisibility(8);
        } else {
            this.jOx.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jOx != null) {
                this.jOx.cEv();
                return;
            }
            return;
        }
        this.jOx.cEw();
        this.jOx.setIcon(str, z);
    }

    public void cDr() {
        if (this.jOE != null) {
            this.jOE.refresh();
        }
        if (this.jOH != null) {
            this.jOH.refresh();
        }
    }

    public void cDs() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jOS.turnOn();
        } else {
            this.jOS.turnOff();
        }
    }

    public void Bt(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cp("obj_type", "1").cp("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cp("obj_type", "0").cp("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cCu() {
        this.jOx.recycle();
        this.jOy.recycle();
        this.jOz.recycle();
        this.jOA.recycle();
        this.jOC.recycle();
        this.jOD.recycle();
        this.jOE.recycle();
        this.jOF.recycle();
        this.jOG.recycle();
    }

    public void onChangeSkinType(int i) {
        lM(i);
        if (this.jOv != null) {
            this.jOs.getLayoutMode().setNightMode(i == 1);
            this.jOs.getLayoutMode().onModeChanged(this.jOv.aCk());
        }
        if (i == 1) {
            this.jOS.turnOnNoCallback();
        } else {
            this.jOS.turnOffNoCallback();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jOJ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jOx.lM(i);
        this.jOs.getLayoutMode().setNightMode(i == 1);
        this.jOs.getLayoutMode().onModeChanged(this.jOJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cDr();
        this.jOS.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jOU.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jOK, R.color.cp_bg_line_d);
        this.jOw.setLocalIcon(am.kd(R.drawable.icon_mine_list_baidu));
        if (this.jOv != null) {
            this.jOv.onChangeSkinType();
        }
        this.jOw.lM(i);
        this.jOx.lM(i);
        this.jOy.onChangeSkinType(i);
        this.jOz.onChangeSkinType(i);
        this.jOA.onChangeSkinType(i);
        this.jOB.onChangeSkinType(i);
        this.jOC.onChangeSkinType(i);
        this.jOD.onChangeSkinType(i);
        this.jOE.onChangeSkinType(i);
        this.jOF.onChangeSkinType(i);
        this.jOG.onChangeSkinType(i);
        this.jOH.onChangeSkinType(i);
    }

    private void aKa() {
        View.OnClickListener clickListener = getClickListener();
        this.jOJ = (RelativeLayout) this.jOs.findViewById(R.id.parent);
        this.jOK = this.jOs.findViewById(R.id.scroll);
        this.jOs.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jOs.findViewById(R.id.view_navigation_bar);
        this.jOL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jOs.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jOw = (SettingTextNormalImageView) this.jOs.findViewById(R.id.accountSafeSetting);
        this.jOx = (SettingTextImageView) this.jOs.findViewById(R.id.personInfo);
        this.jOy = (TbSettingTextTipView) this.jOs.findViewById(R.id.interest_label_setting);
        this.jOy.setTopLineVisibility(true);
        this.jOz = (TbSettingTextTipView) this.jOs.findViewById(R.id.accountManager);
        this.jOz.setTopLineVisibility(true);
        this.jOA = (TbSettingTextTipView) this.jOs.findViewById(R.id.browseSetting);
        this.jOA.setBottomLineVisibility(true);
        this.jOB = (TbSettingTextTipView) this.jOs.findViewById(R.id.adSetting);
        this.jOB.setBottomLineVisibility(true);
        this.jOC = (TbSettingTextTipView) this.jOs.findViewById(R.id.messageSetting);
        this.jOC.setBottomLineVisibility(true);
        this.jOA.setBottomLineVisibility(true);
        this.jOD = (TbSettingTextTipView) this.jOs.findViewById(R.id.secretSetting);
        this.jOD.setBottomLineVisibility(true);
        this.jOE = (SettingTextVersionView) this.jOs.findViewById(R.id.versionInfo);
        this.jOF = (TbSettingTextTipView) this.jOs.findViewById(R.id.feedBack);
        this.jOF.setTopLineVisibility(true);
        this.jOF.setBottomLineVisibility(true);
        this.jOG = (TbSettingTextTipView) this.jOs.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jOG.setVisibility(8);
            this.jOG.setBottomLineVisibility(false);
        } else {
            this.jOG.setVisibility(0);
            this.jOG.setBottomLineVisibility(true);
        }
        this.jOH = (TbSettingTextNewDotView) this.jOs.findViewById(R.id.systemhelpsetting);
        this.jOI = (TextView) this.jOs.findViewById(R.id.quit);
        this.jOR = (RelativeLayout) this.jOs.findViewById(R.id.eyeshield_mode);
        this.jOS = (BdSwitchView) this.jOs.findViewById(R.id.item_switch);
        l.addToParentArea(this.jOs.getPageContext().getPageActivity(), this.jOS, 10, 10, 10, 10);
        this.jOT = (RelativeLayout) this.jOs.findViewById(R.id.follow_system_day_night_mode);
        this.jOU = (BdSwitchView) this.jOs.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jOs.getPageContext().getPageActivity(), this.jOU, 10, 10, 10, 10);
        this.jOM = this.jOs.findViewById(R.id.divide_view2);
        this.jON = this.jOs.findViewById(R.id.divide_view1);
        this.jOO = this.jOs.findViewById(R.id.divide_view3);
        this.jOP = this.jOs.findViewById(R.id.divide_view4);
        this.jOQ = this.jOs.findViewById(R.id.divide_view5);
        cDr();
        cDq();
        this.jOx.cEv();
        lM(TbadkCoreApplication.getInst().getSkinType());
        this.jON.setVisibility(0);
        this.jOO.setVisibility(0);
        this.jOP.setVisibility(0);
        this.jOQ.setVisibility(0);
        ab(clickListener);
        if (!cDt()) {
            this.jOA.setTip(this.jOs.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jOM.setVisibility(8);
            this.jOR.setVisibility(8);
        } else {
            this.jOM.setVisibility(0);
            this.jOR.setVisibility(0);
        }
        this.jOT.setVisibility(cDu() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_is_follow_system_mode", false)) {
            this.jOU.turnOnNoCallback();
        } else {
            this.jOU.turnOffNoCallback();
        }
    }

    private boolean cDt() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cDu() {
        if (cDt()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void Mm() {
        this.jOv = new k(getPageContext().getPageActivity());
        this.jOv.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jOv);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jOs.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jOs.getLayoutMode().onModeChanged(this.jOv.aCk());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.wN();
                    e.this.jOt.Bo(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.wN();
            }
        };
        this.jOv.aA(arrayList);
        this.jOv.a(cVar);
        this.jOv.a(aVar);
        this.jOu = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jOu.setCanceledOnTouchOutside(true);
        this.jOu.a(this.jOv);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.jOw.setOnClickListener(onClickListener);
        this.jOL.setOnClickListener(onClickListener);
        this.jOx.setOnClickListener(onClickListener);
        this.jOy.setOnClickListener(onClickListener);
        this.jOz.setOnClickListener(onClickListener);
        this.jOA.setOnClickListener(onClickListener);
        this.jOB.setOnClickListener(onClickListener);
        this.jOC.setOnClickListener(onClickListener);
        this.jOD.setOnClickListener(onClickListener);
        this.jOE.setOnClickListener(onClickListener);
        this.jOF.setOnClickListener(onClickListener);
        this.jOG.setOnClickListener(onClickListener);
        this.jOH.setOnClickListener(onClickListener);
        this.jOI.setOnClickListener(onClickListener);
        this.jOS.setOnSwitchStateChangeListener(this.jOs);
        this.jOU.setOnSwitchStateChangeListener(this.jOs);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jOL) {
                    e.this.jOt.Bo(0);
                } else if (view == e.this.jOx) {
                    e.this.jOt.Bo(1);
                } else if (view == e.this.jOy) {
                    e.this.jOt.Bo(15);
                } else if (view == e.this.jOz) {
                    e.this.jOt.Bo(2);
                } else if (view == e.this.jOA) {
                    e.this.jOt.Bo(3);
                } else if (view == e.this.jOC) {
                    e.this.jOt.Bo(4);
                } else if (view == e.this.jOD) {
                    e.this.jOt.Bo(9);
                } else if (view == e.this.jOE) {
                    e.this.jOt.Bo(6);
                } else if (view == e.this.jOF) {
                    e.this.jOt.Bo(7);
                } else if (view == e.this.jOG) {
                    e.this.jOt.Bo(8);
                } else if (view == e.this.jOH) {
                    e.this.jOt.Bo(5);
                } else if (view == e.this.jOI) {
                    e.this.jOt.Bo(10);
                } else if (view == e.this.jOw) {
                    e.this.jOt.Bo(13);
                } else if (view == e.this.jOB) {
                    e.this.jOt.Bo(16);
                }
            }
        };
    }

    public void cDv() {
        if (this.jOu == null) {
            Mm();
        }
        this.jOu.showDialog();
    }

    public void wN() {
        if (this.jOu != null) {
            this.jOu.dismiss();
        }
    }

    public BdSwitchView cDw() {
        return this.jOS;
    }

    public BdSwitchView cDx() {
        return this.jOU;
    }
}
