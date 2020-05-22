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
    private MoreActivity kVZ;
    private RelativeLayout kWA;
    private BdSwitchView kWB;
    private d kWa;
    private com.baidu.tbadk.core.dialog.i kWb;
    private k kWc;
    private SettingTextNormalImageView kWd;
    private SettingTextImageView kWe;
    private TbSettingTextTipView kWf;
    private TbSettingTextTipView kWg;
    private TbSettingTextTipView kWh;
    private TbSettingTextTipView kWi;
    private TbSettingTextTipView kWj;
    private TbSettingTextTipView kWk;
    private SettingTextVersionView kWl;
    private TbSettingTextTipView kWm;
    private TbSettingTextTipView kWn;
    private TbSettingTextNewDotView kWo;
    private TextView kWp;
    private RelativeLayout kWq;
    private View kWr;
    private View kWs;
    private View kWt;
    private View kWu;
    private View kWv;
    private View kWw;
    private View kWx;
    private RelativeLayout kWy;
    private BdSwitchView kWz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.kWt = null;
        this.kWu = null;
        this.kWv = null;
        this.kWw = null;
        this.kWx = null;
        this.kWy = null;
        this.kWz = null;
        this.kWA = null;
        this.kWB = null;
        this.kVZ = moreActivity;
        this.kWa = dVar;
        this.kVZ.setContentView(R.layout.more_activity);
        bbA();
        cXV();
    }

    public void cXT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kWe.setVisibility(8);
        } else {
            this.kWe.setVisibility(0);
        }
    }

    public void aS(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.kWe != null) {
                this.kWe.cYY();
                return;
            }
            return;
        }
        this.kWe.cYZ();
        this.kWe.setIcon(str, z);
    }

    public void cXU() {
        if (this.kWl != null) {
            this.kWl.refresh();
        }
        if (this.kWo != null) {
            this.kWo.refresh();
        }
    }

    public void cXV() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kWz.turnOn();
        } else {
            this.kWz.turnOff();
        }
    }

    public void CZ(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).dh("obj_type", "1").dh("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).dh("obj_type", "0").dh("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cWX() {
        this.kWe.recycle();
        this.kWf.recycle();
        this.kWg.recycle();
        this.kWh.recycle();
        this.kWj.recycle();
        this.kWk.recycle();
        this.kWl.recycle();
        this.kWm.recycle();
        this.kWn.recycle();
    }

    public void onChangeSkinType(int i) {
        mU(i);
        if (this.kWc != null) {
            this.kVZ.getLayoutMode().setNightMode(i == 1);
            this.kVZ.getLayoutMode().onModeChanged(this.kWc.getView());
        }
        if (i == 1) {
            this.kWz.turnOnNoCallback();
        } else {
            this.kWz.turnOffNoCallback();
        }
    }

    public void mU(int i) {
        am.setBackgroundColor(this.kWq, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kWe.mU(i);
        this.kVZ.getLayoutMode().setNightMode(i == 1);
        this.kVZ.getLayoutMode().onModeChanged(this.kWq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cXU();
        this.kWz.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kWB.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.kWr, R.color.cp_bg_line_d);
        this.kWd.setLocalIcon(am.lb(R.drawable.icon_mine_list_baidu));
        if (this.kWc != null) {
            this.kWc.onChangeSkinType();
        }
        this.kWd.mU(i);
        this.kWe.mU(i);
        this.kWf.onChangeSkinType(i);
        this.kWg.onChangeSkinType(i);
        this.kWh.onChangeSkinType(i);
        this.kWi.onChangeSkinType(i);
        this.kWj.onChangeSkinType(i);
        this.kWk.onChangeSkinType(i);
        this.kWl.onChangeSkinType(i);
        this.kWm.onChangeSkinType(i);
        this.kWn.onChangeSkinType(i);
        this.kWo.onChangeSkinType(i);
    }

    private void bbA() {
        View.OnClickListener clickListener = getClickListener();
        this.kWq = (RelativeLayout) this.kVZ.findViewById(R.id.parent);
        this.kWr = this.kVZ.findViewById(R.id.scroll);
        this.kVZ.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.kVZ.findViewById(R.id.view_navigation_bar);
        this.kWs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kVZ.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.kWd = (SettingTextNormalImageView) this.kVZ.findViewById(R.id.accountSafeSetting);
        this.kWe = (SettingTextImageView) this.kVZ.findViewById(R.id.personInfo);
        this.kWf = (TbSettingTextTipView) this.kVZ.findViewById(R.id.interest_label_setting);
        this.kWf.setTopLineVisibility(true);
        this.kWg = (TbSettingTextTipView) this.kVZ.findViewById(R.id.accountManager);
        this.kWg.setTopLineVisibility(true);
        this.kWh = (TbSettingTextTipView) this.kVZ.findViewById(R.id.browseSetting);
        this.kWh.setBottomLineVisibility(true);
        this.kWi = (TbSettingTextTipView) this.kVZ.findViewById(R.id.adSetting);
        this.kWi.setBottomLineVisibility(true);
        this.kWj = (TbSettingTextTipView) this.kVZ.findViewById(R.id.messageSetting);
        this.kWj.setBottomLineVisibility(true);
        this.kWh.setBottomLineVisibility(true);
        this.kWk = (TbSettingTextTipView) this.kVZ.findViewById(R.id.secretSetting);
        this.kWk.setBottomLineVisibility(true);
        this.kWl = (SettingTextVersionView) this.kVZ.findViewById(R.id.versionInfo);
        this.kWm = (TbSettingTextTipView) this.kVZ.findViewById(R.id.feedBack);
        this.kWm.setTopLineVisibility(true);
        this.kWm.setBottomLineVisibility(true);
        this.kWn = (TbSettingTextTipView) this.kVZ.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.kWn.setVisibility(8);
            this.kWn.setBottomLineVisibility(false);
        } else {
            this.kWn.setVisibility(0);
            this.kWn.setBottomLineVisibility(true);
        }
        this.kWo = (TbSettingTextNewDotView) this.kVZ.findViewById(R.id.systemhelpsetting);
        this.kWp = (TextView) this.kVZ.findViewById(R.id.quit);
        this.kWy = (RelativeLayout) this.kVZ.findViewById(R.id.eyeshield_mode);
        this.kWz = (BdSwitchView) this.kVZ.findViewById(R.id.item_switch);
        l.addToParentArea(this.kVZ.getPageContext().getPageActivity(), this.kWz, 10, 10, 10, 10);
        this.kWA = (RelativeLayout) this.kVZ.findViewById(R.id.follow_system_day_night_mode);
        this.kWB = (BdSwitchView) this.kVZ.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.kVZ.getPageContext().getPageActivity(), this.kWB, 10, 10, 10, 10);
        this.kWt = this.kVZ.findViewById(R.id.divide_view2);
        this.kWu = this.kVZ.findViewById(R.id.divide_view1);
        this.kWv = this.kVZ.findViewById(R.id.divide_view3);
        this.kWw = this.kVZ.findViewById(R.id.divide_view4);
        this.kWx = this.kVZ.findViewById(R.id.divide_view5);
        cXU();
        cXT();
        this.kWe.cYY();
        mU(TbadkCoreApplication.getInst().getSkinType());
        this.kWu.setVisibility(0);
        this.kWv.setVisibility(0);
        this.kWw.setVisibility(0);
        this.kWx.setVisibility(0);
        ab(clickListener);
        if (!cXW()) {
            this.kWh.setTip(this.kVZ.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.kWt.setVisibility(8);
            this.kWy.setVisibility(8);
        } else {
            this.kWt.setVisibility(0);
            this.kWy.setVisibility(0);
        }
        this.kWA.setVisibility(cXX() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_is_follow_system_mode", false)) {
            this.kWB.turnOnNoCallback();
        } else {
            this.kWB.turnOffNoCallback();
        }
    }

    private boolean cXW() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cXX() {
        if (cXW()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ZB() {
        this.kWc = new k(getPageContext().getPageActivity());
        this.kWc.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.kWc);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.kVZ.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kVZ.getLayoutMode().onModeChanged(this.kWc.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.yy();
                    e.this.kWa.CU(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.yy();
            }
        };
        this.kWc.aD(arrayList);
        this.kWc.a(cVar);
        this.kWc.a(aVar);
        this.kWb = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.kWb.setCanceledOnTouchOutside(true);
        this.kWb.a(this.kWc);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.kWd.setOnClickListener(onClickListener);
        this.kWs.setOnClickListener(onClickListener);
        this.kWe.setOnClickListener(onClickListener);
        this.kWf.setOnClickListener(onClickListener);
        this.kWg.setOnClickListener(onClickListener);
        this.kWh.setOnClickListener(onClickListener);
        this.kWi.setOnClickListener(onClickListener);
        this.kWj.setOnClickListener(onClickListener);
        this.kWk.setOnClickListener(onClickListener);
        this.kWl.setOnClickListener(onClickListener);
        this.kWm.setOnClickListener(onClickListener);
        this.kWn.setOnClickListener(onClickListener);
        this.kWo.setOnClickListener(onClickListener);
        this.kWp.setOnClickListener(onClickListener);
        this.kWz.setOnSwitchStateChangeListener(this.kVZ);
        this.kWB.setOnSwitchStateChangeListener(this.kVZ);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.kWs) {
                    e.this.kWa.CU(0);
                } else if (view == e.this.kWe) {
                    e.this.kWa.CU(1);
                } else if (view == e.this.kWf) {
                    e.this.kWa.CU(15);
                } else if (view == e.this.kWg) {
                    e.this.kWa.CU(2);
                } else if (view == e.this.kWh) {
                    e.this.kWa.CU(3);
                } else if (view == e.this.kWj) {
                    e.this.kWa.CU(4);
                } else if (view == e.this.kWk) {
                    e.this.kWa.CU(9);
                } else if (view == e.this.kWl) {
                    e.this.kWa.CU(6);
                } else if (view == e.this.kWm) {
                    e.this.kWa.CU(7);
                } else if (view == e.this.kWn) {
                    e.this.kWa.CU(8);
                } else if (view == e.this.kWo) {
                    e.this.kWa.CU(5);
                } else if (view == e.this.kWp) {
                    e.this.kWa.CU(10);
                } else if (view == e.this.kWd) {
                    e.this.kWa.CU(13);
                } else if (view == e.this.kWi) {
                    e.this.kWa.CU(16);
                }
            }
        };
    }

    public void cXY() {
        if (this.kWb == null) {
            ZB();
        }
        this.kWb.showDialog();
    }

    public void yy() {
        if (this.kWb != null) {
            this.kWb.dismiss();
        }
    }

    public BdSwitchView cXZ() {
        return this.kWz;
    }

    public BdSwitchView cYa() {
        return this.kWB;
    }
}
