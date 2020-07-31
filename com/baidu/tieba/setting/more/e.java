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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private k lyA;
    private SettingTextNormalImageView lyB;
    private SettingTextImageView lyC;
    private TbSettingTextTipView lyD;
    private TbSettingTextTipView lyE;
    private TbSettingTextTipView lyF;
    private TbSettingTextTipView lyG;
    private TbSettingTextTipView lyH;
    private TbSettingTextTipView lyI;
    private SettingTextVersionView lyJ;
    private TbSettingTextTipView lyK;
    private TbSettingTextTipView lyL;
    private TbSettingTextNewDotView lyM;
    private TextView lyN;
    private RelativeLayout lyO;
    private View lyP;
    private View lyQ;
    private View lyR;
    private View lyS;
    private View lyT;
    private View lyU;
    private View lyV;
    private RelativeLayout lyW;
    private BdSwitchView lyX;
    private RelativeLayout lyY;
    private BdSwitchView lyZ;
    private MoreActivity lyx;
    private d lyy;
    private com.baidu.tbadk.core.dialog.i lyz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lyR = null;
        this.lyS = null;
        this.lyT = null;
        this.lyU = null;
        this.lyV = null;
        this.lyW = null;
        this.lyX = null;
        this.lyY = null;
        this.lyZ = null;
        this.lyx = moreActivity;
        this.lyy = dVar;
        this.lyx.setContentView(R.layout.more_activity);
        bhm();
        dfI();
    }

    public void dfG() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lyC.setVisibility(8);
        } else {
            this.lyC.setVisibility(0);
        }
    }

    public void aR(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lyC != null) {
                this.lyC.dgL();
                return;
            }
            return;
        }
        this.lyC.dgM();
        this.lyC.setIcon(str, z);
    }

    public void dfH() {
        if (this.lyJ != null) {
            this.lyJ.refresh();
        }
        if (this.lyM != null) {
            this.lyM.refresh();
        }
    }

    public void dfI() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lyX.turnOn();
        } else {
            this.lyX.turnOff();
        }
    }

    public void Ez(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).dn("obj_type", "1").dn("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.SET_NIGHT_MODE).dn("obj_type", "0").dn("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void deK() {
        this.lyC.recycle();
        this.lyD.recycle();
        this.lyE.recycle();
        this.lyF.recycle();
        this.lyH.recycle();
        this.lyI.recycle();
        this.lyJ.recycle();
        this.lyK.recycle();
        this.lyL.recycle();
    }

    public void onChangeSkinType(int i) {
        nI(i);
        if (this.lyA != null) {
            this.lyx.getLayoutMode().setNightMode(i == 1);
            this.lyx.getLayoutMode().onModeChanged(this.lyA.getView());
        }
        if (i == 1) {
            this.lyX.turnOnNoCallback();
        } else {
            this.lyX.turnOffNoCallback();
        }
    }

    public void nI(int i) {
        ao.setBackgroundColor(this.lyO, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lyC.nI(i);
        this.lyx.getLayoutMode().setNightMode(i == 1);
        this.lyx.getLayoutMode().onModeChanged(this.lyO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dfH();
        this.lyX.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lyZ.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setBackgroundColor(this.lyP, R.color.cp_bg_line_d);
        this.lyB.setLocalIcon(ao.lL(R.drawable.icon_mine_list_baidu));
        if (this.lyA != null) {
            this.lyA.onChangeSkinType();
        }
        this.lyB.nI(i);
        this.lyC.nI(i);
        this.lyD.onChangeSkinType(i);
        this.lyE.onChangeSkinType(i);
        this.lyF.onChangeSkinType(i);
        this.lyG.onChangeSkinType(i);
        this.lyH.onChangeSkinType(i);
        this.lyI.onChangeSkinType(i);
        this.lyJ.onChangeSkinType(i);
        this.lyK.onChangeSkinType(i);
        this.lyL.onChangeSkinType(i);
        this.lyM.onChangeSkinType(i);
    }

    private void bhm() {
        View.OnClickListener clickListener = getClickListener();
        this.lyO = (RelativeLayout) this.lyx.findViewById(R.id.parent);
        this.lyP = this.lyx.findViewById(R.id.scroll);
        this.lyx.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lyx.findViewById(R.id.view_navigation_bar);
        this.lyQ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lyx.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lyB = (SettingTextNormalImageView) this.lyx.findViewById(R.id.accountSafeSetting);
        this.lyC = (SettingTextImageView) this.lyx.findViewById(R.id.personInfo);
        this.lyD = (TbSettingTextTipView) this.lyx.findViewById(R.id.interest_label_setting);
        this.lyD.setTopLineVisibility(true);
        this.lyE = (TbSettingTextTipView) this.lyx.findViewById(R.id.accountManager);
        this.lyE.setTopLineVisibility(true);
        this.lyF = (TbSettingTextTipView) this.lyx.findViewById(R.id.browseSetting);
        this.lyF.setBottomLineVisibility(true);
        this.lyG = (TbSettingTextTipView) this.lyx.findViewById(R.id.adSetting);
        this.lyG.setBottomLineVisibility(true);
        this.lyH = (TbSettingTextTipView) this.lyx.findViewById(R.id.messageSetting);
        this.lyH.setBottomLineVisibility(true);
        this.lyF.setBottomLineVisibility(true);
        this.lyI = (TbSettingTextTipView) this.lyx.findViewById(R.id.secretSetting);
        this.lyI.setBottomLineVisibility(true);
        this.lyJ = (SettingTextVersionView) this.lyx.findViewById(R.id.versionInfo);
        this.lyK = (TbSettingTextTipView) this.lyx.findViewById(R.id.feedBack);
        this.lyK.setTopLineVisibility(true);
        this.lyK.setBottomLineVisibility(true);
        this.lyL = (TbSettingTextTipView) this.lyx.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lyL.setVisibility(8);
            this.lyL.setBottomLineVisibility(false);
        } else {
            this.lyL.setVisibility(0);
            this.lyL.setBottomLineVisibility(true);
        }
        this.lyM = (TbSettingTextNewDotView) this.lyx.findViewById(R.id.systemhelpsetting);
        this.lyN = (TextView) this.lyx.findViewById(R.id.quit);
        this.lyW = (RelativeLayout) this.lyx.findViewById(R.id.eyeshield_mode);
        this.lyX = (BdSwitchView) this.lyx.findViewById(R.id.item_switch);
        l.addToParentArea(this.lyx.getPageContext().getPageActivity(), this.lyX, 10, 10, 10, 10);
        this.lyY = (RelativeLayout) this.lyx.findViewById(R.id.follow_system_day_night_mode);
        this.lyZ = (BdSwitchView) this.lyx.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lyx.getPageContext().getPageActivity(), this.lyZ, 10, 10, 10, 10);
        this.lyR = this.lyx.findViewById(R.id.divide_view2);
        this.lyS = this.lyx.findViewById(R.id.divide_view1);
        this.lyT = this.lyx.findViewById(R.id.divide_view3);
        this.lyU = this.lyx.findViewById(R.id.divide_view4);
        this.lyV = this.lyx.findViewById(R.id.divide_view5);
        dfH();
        dfG();
        this.lyC.dgL();
        nI(TbadkCoreApplication.getInst().getSkinType());
        this.lyS.setVisibility(0);
        this.lyT.setVisibility(0);
        this.lyU.setVisibility(0);
        this.lyV.setVisibility(0);
        ac(clickListener);
        if (!dfJ()) {
            this.lyF.setTip(this.lyx.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lyR.setVisibility(8);
            this.lyW.setVisibility(8);
        } else {
            this.lyR.setVisibility(0);
            this.lyW.setVisibility(0);
        }
        this.lyY.setVisibility(dfK() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_is_follow_system_mode", false)) {
            this.lyZ.turnOnNoCallback();
        } else {
            this.lyZ.turnOffNoCallback();
        }
    }

    private boolean dfJ() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean dfK() {
        if (dfJ()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void abJ() {
        this.lyA = new k(getPageContext().getPageActivity());
        this.lyA.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lyA);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lyx.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lyx.getLayoutMode().onModeChanged(this.lyA.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.zA();
                    e.this.lyy.Eu(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.zA();
            }
        };
        this.lyA.aS(arrayList);
        this.lyA.a(cVar);
        this.lyA.a(aVar);
        this.lyz = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lyz.setCanceledOnTouchOutside(true);
        this.lyz.a(this.lyA);
    }

    private void ac(View.OnClickListener onClickListener) {
        this.lyB.setOnClickListener(onClickListener);
        this.lyQ.setOnClickListener(onClickListener);
        this.lyC.setOnClickListener(onClickListener);
        this.lyD.setOnClickListener(onClickListener);
        this.lyE.setOnClickListener(onClickListener);
        this.lyF.setOnClickListener(onClickListener);
        this.lyG.setOnClickListener(onClickListener);
        this.lyH.setOnClickListener(onClickListener);
        this.lyI.setOnClickListener(onClickListener);
        this.lyJ.setOnClickListener(onClickListener);
        this.lyK.setOnClickListener(onClickListener);
        this.lyL.setOnClickListener(onClickListener);
        this.lyM.setOnClickListener(onClickListener);
        this.lyN.setOnClickListener(onClickListener);
        this.lyX.setOnSwitchStateChangeListener(this.lyx);
        this.lyZ.setOnSwitchStateChangeListener(this.lyx);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lyQ) {
                    e.this.lyy.Eu(0);
                } else if (view == e.this.lyC) {
                    e.this.lyy.Eu(1);
                } else if (view == e.this.lyD) {
                    e.this.lyy.Eu(15);
                } else if (view == e.this.lyE) {
                    e.this.lyy.Eu(2);
                } else if (view == e.this.lyF) {
                    e.this.lyy.Eu(3);
                } else if (view == e.this.lyH) {
                    e.this.lyy.Eu(4);
                } else if (view == e.this.lyI) {
                    e.this.lyy.Eu(9);
                } else if (view == e.this.lyJ) {
                    e.this.lyy.Eu(6);
                } else if (view == e.this.lyK) {
                    e.this.lyy.Eu(7);
                } else if (view == e.this.lyL) {
                    e.this.lyy.Eu(8);
                } else if (view == e.this.lyM) {
                    e.this.lyy.Eu(5);
                } else if (view == e.this.lyN) {
                    e.this.lyy.Eu(10);
                } else if (view == e.this.lyB) {
                    e.this.lyy.Eu(13);
                } else if (view == e.this.lyG) {
                    e.this.lyy.Eu(16);
                }
            }
        };
    }

    public void dfL() {
        if (this.lyz == null) {
            abJ();
        }
        this.lyz.showDialog();
    }

    public void zA() {
        if (this.lyz != null) {
            this.lyz.dismiss();
        }
    }

    public BdSwitchView dfM() {
        return this.lyX;
    }

    public BdSwitchView dfN() {
        return this.lyZ;
    }
}
