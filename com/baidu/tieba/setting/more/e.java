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
    private d lyA;
    private com.baidu.tbadk.core.dialog.i lyB;
    private k lyC;
    private SettingTextNormalImageView lyD;
    private SettingTextImageView lyE;
    private TbSettingTextTipView lyF;
    private TbSettingTextTipView lyG;
    private TbSettingTextTipView lyH;
    private TbSettingTextTipView lyI;
    private TbSettingTextTipView lyJ;
    private TbSettingTextTipView lyK;
    private SettingTextVersionView lyL;
    private TbSettingTextTipView lyM;
    private TbSettingTextTipView lyN;
    private TbSettingTextNewDotView lyO;
    private TextView lyP;
    private RelativeLayout lyQ;
    private View lyR;
    private View lyS;
    private View lyT;
    private View lyU;
    private View lyV;
    private View lyW;
    private View lyX;
    private RelativeLayout lyY;
    private BdSwitchView lyZ;
    private MoreActivity lyz;
    private RelativeLayout lza;
    private BdSwitchView lzb;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.lyT = null;
        this.lyU = null;
        this.lyV = null;
        this.lyW = null;
        this.lyX = null;
        this.lyY = null;
        this.lyZ = null;
        this.lza = null;
        this.lzb = null;
        this.lyz = moreActivity;
        this.lyA = dVar;
        this.lyz.setContentView(R.layout.more_activity);
        bhm();
        dfI();
    }

    public void dfG() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lyE.setVisibility(8);
        } else {
            this.lyE.setVisibility(0);
        }
    }

    public void aR(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.lyE != null) {
                this.lyE.dgL();
                return;
            }
            return;
        }
        this.lyE.dgM();
        this.lyE.setIcon(str, z);
    }

    public void dfH() {
        if (this.lyL != null) {
            this.lyL.refresh();
        }
        if (this.lyO != null) {
            this.lyO.refresh();
        }
    }

    public void dfI() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.lyZ.turnOn();
        } else {
            this.lyZ.turnOff();
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
        this.lyE.recycle();
        this.lyF.recycle();
        this.lyG.recycle();
        this.lyH.recycle();
        this.lyJ.recycle();
        this.lyK.recycle();
        this.lyL.recycle();
        this.lyM.recycle();
        this.lyN.recycle();
    }

    public void onChangeSkinType(int i) {
        nI(i);
        if (this.lyC != null) {
            this.lyz.getLayoutMode().setNightMode(i == 1);
            this.lyz.getLayoutMode().onModeChanged(this.lyC.getView());
        }
        if (i == 1) {
            this.lyZ.turnOnNoCallback();
        } else {
            this.lyZ.turnOffNoCallback();
        }
    }

    public void nI(int i) {
        ao.setBackgroundColor(this.lyQ, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lyE.nI(i);
        this.lyz.getLayoutMode().setNightMode(i == 1);
        this.lyz.getLayoutMode().onModeChanged(this.lyQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        dfH();
        this.lyZ.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lzb.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        ao.setBackgroundColor(this.lyR, R.color.cp_bg_line_d);
        this.lyD.setLocalIcon(ao.lL(R.drawable.icon_mine_list_baidu));
        if (this.lyC != null) {
            this.lyC.onChangeSkinType();
        }
        this.lyD.nI(i);
        this.lyE.nI(i);
        this.lyF.onChangeSkinType(i);
        this.lyG.onChangeSkinType(i);
        this.lyH.onChangeSkinType(i);
        this.lyI.onChangeSkinType(i);
        this.lyJ.onChangeSkinType(i);
        this.lyK.onChangeSkinType(i);
        this.lyL.onChangeSkinType(i);
        this.lyM.onChangeSkinType(i);
        this.lyN.onChangeSkinType(i);
        this.lyO.onChangeSkinType(i);
    }

    private void bhm() {
        View.OnClickListener clickListener = getClickListener();
        this.lyQ = (RelativeLayout) this.lyz.findViewById(R.id.parent);
        this.lyR = this.lyz.findViewById(R.id.scroll);
        this.lyz.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.lyz.findViewById(R.id.view_navigation_bar);
        this.lyS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lyz.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.lyD = (SettingTextNormalImageView) this.lyz.findViewById(R.id.accountSafeSetting);
        this.lyE = (SettingTextImageView) this.lyz.findViewById(R.id.personInfo);
        this.lyF = (TbSettingTextTipView) this.lyz.findViewById(R.id.interest_label_setting);
        this.lyF.setTopLineVisibility(true);
        this.lyG = (TbSettingTextTipView) this.lyz.findViewById(R.id.accountManager);
        this.lyG.setTopLineVisibility(true);
        this.lyH = (TbSettingTextTipView) this.lyz.findViewById(R.id.browseSetting);
        this.lyH.setBottomLineVisibility(true);
        this.lyI = (TbSettingTextTipView) this.lyz.findViewById(R.id.adSetting);
        this.lyI.setBottomLineVisibility(true);
        this.lyJ = (TbSettingTextTipView) this.lyz.findViewById(R.id.messageSetting);
        this.lyJ.setBottomLineVisibility(true);
        this.lyH.setBottomLineVisibility(true);
        this.lyK = (TbSettingTextTipView) this.lyz.findViewById(R.id.secretSetting);
        this.lyK.setBottomLineVisibility(true);
        this.lyL = (SettingTextVersionView) this.lyz.findViewById(R.id.versionInfo);
        this.lyM = (TbSettingTextTipView) this.lyz.findViewById(R.id.feedBack);
        this.lyM.setTopLineVisibility(true);
        this.lyM.setBottomLineVisibility(true);
        this.lyN = (TbSettingTextTipView) this.lyz.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.lyN.setVisibility(8);
            this.lyN.setBottomLineVisibility(false);
        } else {
            this.lyN.setVisibility(0);
            this.lyN.setBottomLineVisibility(true);
        }
        this.lyO = (TbSettingTextNewDotView) this.lyz.findViewById(R.id.systemhelpsetting);
        this.lyP = (TextView) this.lyz.findViewById(R.id.quit);
        this.lyY = (RelativeLayout) this.lyz.findViewById(R.id.eyeshield_mode);
        this.lyZ = (BdSwitchView) this.lyz.findViewById(R.id.item_switch);
        l.addToParentArea(this.lyz.getPageContext().getPageActivity(), this.lyZ, 10, 10, 10, 10);
        this.lza = (RelativeLayout) this.lyz.findViewById(R.id.follow_system_day_night_mode);
        this.lzb = (BdSwitchView) this.lyz.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.lyz.getPageContext().getPageActivity(), this.lzb, 10, 10, 10, 10);
        this.lyT = this.lyz.findViewById(R.id.divide_view2);
        this.lyU = this.lyz.findViewById(R.id.divide_view1);
        this.lyV = this.lyz.findViewById(R.id.divide_view3);
        this.lyW = this.lyz.findViewById(R.id.divide_view4);
        this.lyX = this.lyz.findViewById(R.id.divide_view5);
        dfH();
        dfG();
        this.lyE.dgL();
        nI(TbadkCoreApplication.getInst().getSkinType());
        this.lyU.setVisibility(0);
        this.lyV.setVisibility(0);
        this.lyW.setVisibility(0);
        this.lyX.setVisibility(0);
        ac(clickListener);
        if (!dfJ()) {
            this.lyH.setTip(this.lyz.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.lyT.setVisibility(8);
            this.lyY.setVisibility(8);
        } else {
            this.lyT.setVisibility(0);
            this.lyY.setVisibility(0);
        }
        this.lza.setVisibility(dfK() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_is_follow_system_mode", false)) {
            this.lzb.turnOnNoCallback();
        } else {
            this.lzb.turnOffNoCallback();
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
        this.lyC = new k(getPageContext().getPageActivity());
        this.lyC.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.lyC);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.lyz.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.lyz.getLayoutMode().onModeChanged(this.lyC.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.zA();
                    e.this.lyA.Eu(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.zA();
            }
        };
        this.lyC.aS(arrayList);
        this.lyC.a(cVar);
        this.lyC.a(aVar);
        this.lyB = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.lyB.setCanceledOnTouchOutside(true);
        this.lyB.a(this.lyC);
    }

    private void ac(View.OnClickListener onClickListener) {
        this.lyD.setOnClickListener(onClickListener);
        this.lyS.setOnClickListener(onClickListener);
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
        this.lyO.setOnClickListener(onClickListener);
        this.lyP.setOnClickListener(onClickListener);
        this.lyZ.setOnSwitchStateChangeListener(this.lyz);
        this.lzb.setOnSwitchStateChangeListener(this.lyz);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.lyS) {
                    e.this.lyA.Eu(0);
                } else if (view == e.this.lyE) {
                    e.this.lyA.Eu(1);
                } else if (view == e.this.lyF) {
                    e.this.lyA.Eu(15);
                } else if (view == e.this.lyG) {
                    e.this.lyA.Eu(2);
                } else if (view == e.this.lyH) {
                    e.this.lyA.Eu(3);
                } else if (view == e.this.lyJ) {
                    e.this.lyA.Eu(4);
                } else if (view == e.this.lyK) {
                    e.this.lyA.Eu(9);
                } else if (view == e.this.lyL) {
                    e.this.lyA.Eu(6);
                } else if (view == e.this.lyM) {
                    e.this.lyA.Eu(7);
                } else if (view == e.this.lyN) {
                    e.this.lyA.Eu(8);
                } else if (view == e.this.lyO) {
                    e.this.lyA.Eu(5);
                } else if (view == e.this.lyP) {
                    e.this.lyA.Eu(10);
                } else if (view == e.this.lyD) {
                    e.this.lyA.Eu(13);
                } else if (view == e.this.lyI) {
                    e.this.lyA.Eu(16);
                }
            }
        };
    }

    public void dfL() {
        if (this.lyB == null) {
            abJ();
        }
        this.lyB.showDialog();
    }

    public void zA() {
        if (this.lyB != null) {
            this.lyB.dismiss();
        }
    }

    public BdSwitchView dfM() {
        return this.lyZ;
    }

    public BdSwitchView dfN() {
        return this.lzb;
    }
}
