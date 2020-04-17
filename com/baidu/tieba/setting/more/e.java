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
/* loaded from: classes13.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity kDT;
    private d kDU;
    private com.baidu.tbadk.core.dialog.i kDV;
    private k kDW;
    private SettingTextNormalImageView kDX;
    private SettingTextImageView kDY;
    private TbSettingTextTipView kDZ;
    private TbSettingTextTipView kEa;
    private TbSettingTextTipView kEb;
    private TbSettingTextTipView kEc;
    private TbSettingTextTipView kEd;
    private TbSettingTextTipView kEe;
    private SettingTextVersionView kEf;
    private TbSettingTextTipView kEg;
    private TbSettingTextTipView kEh;
    private TbSettingTextNewDotView kEi;
    private TextView kEj;
    private RelativeLayout kEk;
    private View kEl;
    private View kEm;
    private View kEn;
    private View kEo;
    private View kEp;
    private View kEq;
    private View kEr;
    private RelativeLayout kEs;
    private BdSwitchView kEt;
    private RelativeLayout kEu;
    private BdSwitchView kEv;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.kEn = null;
        this.kEo = null;
        this.kEp = null;
        this.kEq = null;
        this.kEr = null;
        this.kEs = null;
        this.kEt = null;
        this.kEu = null;
        this.kEv = null;
        this.kDT = moreActivity;
        this.kDU = dVar;
        this.kDT.setContentView(R.layout.more_activity);
        aVt();
        cQU();
    }

    public void cQS() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kDY.setVisibility(8);
        } else {
            this.kDY.setVisibility(0);
        }
    }

    public void aF(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.kDY != null) {
                this.kDY.cRX();
                return;
            }
            return;
        }
        this.kDY.cRY();
        this.kDY.setIcon(str, z);
    }

    public void cQT() {
        if (this.kEf != null) {
            this.kEf.refresh();
        }
        if (this.kEi != null) {
            this.kEi.refresh();
        }
    }

    public void cQU() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kEt.turnOn();
        } else {
            this.kEt.turnOff();
        }
    }

    public void Cp(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cI("obj_type", "1").cI("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cI("obj_type", "0").cI("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cPW() {
        this.kDY.recycle();
        this.kDZ.recycle();
        this.kEa.recycle();
        this.kEb.recycle();
        this.kEd.recycle();
        this.kEe.recycle();
        this.kEf.recycle();
        this.kEg.recycle();
        this.kEh.recycle();
    }

    public void onChangeSkinType(int i) {
        ms(i);
        if (this.kDW != null) {
            this.kDT.getLayoutMode().setNightMode(i == 1);
            this.kDT.getLayoutMode().onModeChanged(this.kDW.getView());
        }
        if (i == 1) {
            this.kEt.turnOnNoCallback();
        } else {
            this.kEt.turnOffNoCallback();
        }
    }

    public void ms(int i) {
        am.setBackgroundColor(this.kEk, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kDY.ms(i);
        this.kDT.getLayoutMode().setNightMode(i == 1);
        this.kDT.getLayoutMode().onModeChanged(this.kEk);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cQT();
        this.kEt.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kEv.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.kEl, R.color.cp_bg_line_d);
        this.kDX.setLocalIcon(am.kB(R.drawable.icon_mine_list_baidu));
        if (this.kDW != null) {
            this.kDW.onChangeSkinType();
        }
        this.kDX.ms(i);
        this.kDY.ms(i);
        this.kDZ.onChangeSkinType(i);
        this.kEa.onChangeSkinType(i);
        this.kEb.onChangeSkinType(i);
        this.kEc.onChangeSkinType(i);
        this.kEd.onChangeSkinType(i);
        this.kEe.onChangeSkinType(i);
        this.kEf.onChangeSkinType(i);
        this.kEg.onChangeSkinType(i);
        this.kEh.onChangeSkinType(i);
        this.kEi.onChangeSkinType(i);
    }

    private void aVt() {
        View.OnClickListener clickListener = getClickListener();
        this.kEk = (RelativeLayout) this.kDT.findViewById(R.id.parent);
        this.kEl = this.kDT.findViewById(R.id.scroll);
        this.kDT.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.kDT.findViewById(R.id.view_navigation_bar);
        this.kEm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kDT.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.kDX = (SettingTextNormalImageView) this.kDT.findViewById(R.id.accountSafeSetting);
        this.kDY = (SettingTextImageView) this.kDT.findViewById(R.id.personInfo);
        this.kDZ = (TbSettingTextTipView) this.kDT.findViewById(R.id.interest_label_setting);
        this.kDZ.setTopLineVisibility(true);
        this.kEa = (TbSettingTextTipView) this.kDT.findViewById(R.id.accountManager);
        this.kEa.setTopLineVisibility(true);
        this.kEb = (TbSettingTextTipView) this.kDT.findViewById(R.id.browseSetting);
        this.kEb.setBottomLineVisibility(true);
        this.kEc = (TbSettingTextTipView) this.kDT.findViewById(R.id.adSetting);
        this.kEc.setBottomLineVisibility(true);
        this.kEd = (TbSettingTextTipView) this.kDT.findViewById(R.id.messageSetting);
        this.kEd.setBottomLineVisibility(true);
        this.kEb.setBottomLineVisibility(true);
        this.kEe = (TbSettingTextTipView) this.kDT.findViewById(R.id.secretSetting);
        this.kEe.setBottomLineVisibility(true);
        this.kEf = (SettingTextVersionView) this.kDT.findViewById(R.id.versionInfo);
        this.kEg = (TbSettingTextTipView) this.kDT.findViewById(R.id.feedBack);
        this.kEg.setTopLineVisibility(true);
        this.kEg.setBottomLineVisibility(true);
        this.kEh = (TbSettingTextTipView) this.kDT.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.kEh.setVisibility(8);
            this.kEh.setBottomLineVisibility(false);
        } else {
            this.kEh.setVisibility(0);
            this.kEh.setBottomLineVisibility(true);
        }
        this.kEi = (TbSettingTextNewDotView) this.kDT.findViewById(R.id.systemhelpsetting);
        this.kEj = (TextView) this.kDT.findViewById(R.id.quit);
        this.kEs = (RelativeLayout) this.kDT.findViewById(R.id.eyeshield_mode);
        this.kEt = (BdSwitchView) this.kDT.findViewById(R.id.item_switch);
        l.addToParentArea(this.kDT.getPageContext().getPageActivity(), this.kEt, 10, 10, 10, 10);
        this.kEu = (RelativeLayout) this.kDT.findViewById(R.id.follow_system_day_night_mode);
        this.kEv = (BdSwitchView) this.kDT.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.kDT.getPageContext().getPageActivity(), this.kEv, 10, 10, 10, 10);
        this.kEn = this.kDT.findViewById(R.id.divide_view2);
        this.kEo = this.kDT.findViewById(R.id.divide_view1);
        this.kEp = this.kDT.findViewById(R.id.divide_view3);
        this.kEq = this.kDT.findViewById(R.id.divide_view4);
        this.kEr = this.kDT.findViewById(R.id.divide_view5);
        cQT();
        cQS();
        this.kDY.cRX();
        ms(TbadkCoreApplication.getInst().getSkinType());
        this.kEo.setVisibility(0);
        this.kEp.setVisibility(0);
        this.kEq.setVisibility(0);
        this.kEr.setVisibility(0);
        ab(clickListener);
        if (!cQV()) {
            this.kEb.setTip(this.kDT.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.kEn.setVisibility(8);
            this.kEs.setVisibility(8);
        } else {
            this.kEn.setVisibility(0);
            this.kEs.setVisibility(0);
        }
        this.kEu.setVisibility(cQW() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_is_follow_system_mode", false)) {
            this.kEv.turnOnNoCallback();
        } else {
            this.kEv.turnOffNoCallback();
        }
    }

    private boolean cQV() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cQW() {
        if (cQV()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void WQ() {
        this.kDW = new k(getPageContext().getPageActivity());
        this.kDW.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.kDW);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.kDT.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kDT.getLayoutMode().onModeChanged(this.kDW.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.xl();
                    e.this.kDU.Ck(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.xl();
            }
        };
        this.kDW.aI(arrayList);
        this.kDW.a(cVar);
        this.kDW.a(aVar);
        this.kDV = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.kDV.setCanceledOnTouchOutside(true);
        this.kDV.a(this.kDW);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.kDX.setOnClickListener(onClickListener);
        this.kEm.setOnClickListener(onClickListener);
        this.kDY.setOnClickListener(onClickListener);
        this.kDZ.setOnClickListener(onClickListener);
        this.kEa.setOnClickListener(onClickListener);
        this.kEb.setOnClickListener(onClickListener);
        this.kEc.setOnClickListener(onClickListener);
        this.kEd.setOnClickListener(onClickListener);
        this.kEe.setOnClickListener(onClickListener);
        this.kEf.setOnClickListener(onClickListener);
        this.kEg.setOnClickListener(onClickListener);
        this.kEh.setOnClickListener(onClickListener);
        this.kEi.setOnClickListener(onClickListener);
        this.kEj.setOnClickListener(onClickListener);
        this.kEt.setOnSwitchStateChangeListener(this.kDT);
        this.kEv.setOnSwitchStateChangeListener(this.kDT);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.kEm) {
                    e.this.kDU.Ck(0);
                } else if (view == e.this.kDY) {
                    e.this.kDU.Ck(1);
                } else if (view == e.this.kDZ) {
                    e.this.kDU.Ck(15);
                } else if (view == e.this.kEa) {
                    e.this.kDU.Ck(2);
                } else if (view == e.this.kEb) {
                    e.this.kDU.Ck(3);
                } else if (view == e.this.kEd) {
                    e.this.kDU.Ck(4);
                } else if (view == e.this.kEe) {
                    e.this.kDU.Ck(9);
                } else if (view == e.this.kEf) {
                    e.this.kDU.Ck(6);
                } else if (view == e.this.kEg) {
                    e.this.kDU.Ck(7);
                } else if (view == e.this.kEh) {
                    e.this.kDU.Ck(8);
                } else if (view == e.this.kEi) {
                    e.this.kDU.Ck(5);
                } else if (view == e.this.kEj) {
                    e.this.kDU.Ck(10);
                } else if (view == e.this.kDX) {
                    e.this.kDU.Ck(13);
                } else if (view == e.this.kEc) {
                    e.this.kDU.Ck(16);
                }
            }
        };
    }

    public void cQX() {
        if (this.kDV == null) {
            WQ();
        }
        this.kDV.showDialog();
    }

    public void xl() {
        if (this.kDV != null) {
            this.kDV.dismiss();
        }
    }

    public BdSwitchView cQY() {
        return this.kEt;
    }

    public BdSwitchView cQZ() {
        return this.kEv;
    }
}
