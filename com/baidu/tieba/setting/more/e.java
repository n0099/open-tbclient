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
    private MoreActivity kDX;
    private d kDY;
    private com.baidu.tbadk.core.dialog.i kDZ;
    private k kEa;
    private SettingTextNormalImageView kEb;
    private SettingTextImageView kEc;
    private TbSettingTextTipView kEd;
    private TbSettingTextTipView kEe;
    private TbSettingTextTipView kEf;
    private TbSettingTextTipView kEg;
    private TbSettingTextTipView kEh;
    private TbSettingTextTipView kEi;
    private SettingTextVersionView kEj;
    private TbSettingTextTipView kEk;
    private TbSettingTextTipView kEl;
    private TbSettingTextNewDotView kEm;
    private TextView kEn;
    private RelativeLayout kEo;
    private View kEp;
    private View kEq;
    private View kEr;
    private View kEs;
    private View kEt;
    private View kEu;
    private View kEv;
    private RelativeLayout kEw;
    private BdSwitchView kEx;
    private RelativeLayout kEy;
    private BdSwitchView kEz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.kEr = null;
        this.kEs = null;
        this.kEt = null;
        this.kEu = null;
        this.kEv = null;
        this.kEw = null;
        this.kEx = null;
        this.kEy = null;
        this.kEz = null;
        this.kDX = moreActivity;
        this.kDY = dVar;
        this.kDX.setContentView(R.layout.more_activity);
        aVr();
        cQR();
    }

    public void cQP() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kEc.setVisibility(8);
        } else {
            this.kEc.setVisibility(0);
        }
    }

    public void aF(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.kEc != null) {
                this.kEc.cRU();
                return;
            }
            return;
        }
        this.kEc.cRV();
        this.kEc.setIcon(str, z);
    }

    public void cQQ() {
        if (this.kEj != null) {
            this.kEj.refresh();
        }
        if (this.kEm != null) {
            this.kEm.refresh();
        }
    }

    public void cQR() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kEx.turnOn();
        } else {
            this.kEx.turnOff();
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

    public void cPT() {
        this.kEc.recycle();
        this.kEd.recycle();
        this.kEe.recycle();
        this.kEf.recycle();
        this.kEh.recycle();
        this.kEi.recycle();
        this.kEj.recycle();
        this.kEk.recycle();
        this.kEl.recycle();
    }

    public void onChangeSkinType(int i) {
        ms(i);
        if (this.kEa != null) {
            this.kDX.getLayoutMode().setNightMode(i == 1);
            this.kDX.getLayoutMode().onModeChanged(this.kEa.getView());
        }
        if (i == 1) {
            this.kEx.turnOnNoCallback();
        } else {
            this.kEx.turnOffNoCallback();
        }
    }

    public void ms(int i) {
        am.setBackgroundColor(this.kEo, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kEc.ms(i);
        this.kDX.getLayoutMode().setNightMode(i == 1);
        this.kDX.getLayoutMode().onModeChanged(this.kEo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cQQ();
        this.kEx.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kEz.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.kEp, R.color.cp_bg_line_d);
        this.kEb.setLocalIcon(am.kB(R.drawable.icon_mine_list_baidu));
        if (this.kEa != null) {
            this.kEa.onChangeSkinType();
        }
        this.kEb.ms(i);
        this.kEc.ms(i);
        this.kEd.onChangeSkinType(i);
        this.kEe.onChangeSkinType(i);
        this.kEf.onChangeSkinType(i);
        this.kEg.onChangeSkinType(i);
        this.kEh.onChangeSkinType(i);
        this.kEi.onChangeSkinType(i);
        this.kEj.onChangeSkinType(i);
        this.kEk.onChangeSkinType(i);
        this.kEl.onChangeSkinType(i);
        this.kEm.onChangeSkinType(i);
    }

    private void aVr() {
        View.OnClickListener clickListener = getClickListener();
        this.kEo = (RelativeLayout) this.kDX.findViewById(R.id.parent);
        this.kEp = this.kDX.findViewById(R.id.scroll);
        this.kDX.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.kDX.findViewById(R.id.view_navigation_bar);
        this.kEq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kDX.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.kEb = (SettingTextNormalImageView) this.kDX.findViewById(R.id.accountSafeSetting);
        this.kEc = (SettingTextImageView) this.kDX.findViewById(R.id.personInfo);
        this.kEd = (TbSettingTextTipView) this.kDX.findViewById(R.id.interest_label_setting);
        this.kEd.setTopLineVisibility(true);
        this.kEe = (TbSettingTextTipView) this.kDX.findViewById(R.id.accountManager);
        this.kEe.setTopLineVisibility(true);
        this.kEf = (TbSettingTextTipView) this.kDX.findViewById(R.id.browseSetting);
        this.kEf.setBottomLineVisibility(true);
        this.kEg = (TbSettingTextTipView) this.kDX.findViewById(R.id.adSetting);
        this.kEg.setBottomLineVisibility(true);
        this.kEh = (TbSettingTextTipView) this.kDX.findViewById(R.id.messageSetting);
        this.kEh.setBottomLineVisibility(true);
        this.kEf.setBottomLineVisibility(true);
        this.kEi = (TbSettingTextTipView) this.kDX.findViewById(R.id.secretSetting);
        this.kEi.setBottomLineVisibility(true);
        this.kEj = (SettingTextVersionView) this.kDX.findViewById(R.id.versionInfo);
        this.kEk = (TbSettingTextTipView) this.kDX.findViewById(R.id.feedBack);
        this.kEk.setTopLineVisibility(true);
        this.kEk.setBottomLineVisibility(true);
        this.kEl = (TbSettingTextTipView) this.kDX.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.kEl.setVisibility(8);
            this.kEl.setBottomLineVisibility(false);
        } else {
            this.kEl.setVisibility(0);
            this.kEl.setBottomLineVisibility(true);
        }
        this.kEm = (TbSettingTextNewDotView) this.kDX.findViewById(R.id.systemhelpsetting);
        this.kEn = (TextView) this.kDX.findViewById(R.id.quit);
        this.kEw = (RelativeLayout) this.kDX.findViewById(R.id.eyeshield_mode);
        this.kEx = (BdSwitchView) this.kDX.findViewById(R.id.item_switch);
        l.addToParentArea(this.kDX.getPageContext().getPageActivity(), this.kEx, 10, 10, 10, 10);
        this.kEy = (RelativeLayout) this.kDX.findViewById(R.id.follow_system_day_night_mode);
        this.kEz = (BdSwitchView) this.kDX.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.kDX.getPageContext().getPageActivity(), this.kEz, 10, 10, 10, 10);
        this.kEr = this.kDX.findViewById(R.id.divide_view2);
        this.kEs = this.kDX.findViewById(R.id.divide_view1);
        this.kEt = this.kDX.findViewById(R.id.divide_view3);
        this.kEu = this.kDX.findViewById(R.id.divide_view4);
        this.kEv = this.kDX.findViewById(R.id.divide_view5);
        cQQ();
        cQP();
        this.kEc.cRU();
        ms(TbadkCoreApplication.getInst().getSkinType());
        this.kEs.setVisibility(0);
        this.kEt.setVisibility(0);
        this.kEu.setVisibility(0);
        this.kEv.setVisibility(0);
        ab(clickListener);
        if (!cQS()) {
            this.kEf.setTip(this.kDX.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.kEr.setVisibility(8);
            this.kEw.setVisibility(8);
        } else {
            this.kEr.setVisibility(0);
            this.kEw.setVisibility(0);
        }
        this.kEy.setVisibility(cQT() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_is_follow_system_mode", false)) {
            this.kEz.turnOnNoCallback();
        } else {
            this.kEz.turnOffNoCallback();
        }
    }

    private boolean cQS() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cQT() {
        if (cQS()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void WP() {
        this.kEa = new k(getPageContext().getPageActivity());
        this.kEa.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.kEa);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.kDX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kDX.getLayoutMode().onModeChanged(this.kEa.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.xk();
                    e.this.kDY.Ck(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.xk();
            }
        };
        this.kEa.aI(arrayList);
        this.kEa.a(cVar);
        this.kEa.a(aVar);
        this.kDZ = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.kDZ.setCanceledOnTouchOutside(true);
        this.kDZ.a(this.kEa);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.kEb.setOnClickListener(onClickListener);
        this.kEq.setOnClickListener(onClickListener);
        this.kEc.setOnClickListener(onClickListener);
        this.kEd.setOnClickListener(onClickListener);
        this.kEe.setOnClickListener(onClickListener);
        this.kEf.setOnClickListener(onClickListener);
        this.kEg.setOnClickListener(onClickListener);
        this.kEh.setOnClickListener(onClickListener);
        this.kEi.setOnClickListener(onClickListener);
        this.kEj.setOnClickListener(onClickListener);
        this.kEk.setOnClickListener(onClickListener);
        this.kEl.setOnClickListener(onClickListener);
        this.kEm.setOnClickListener(onClickListener);
        this.kEn.setOnClickListener(onClickListener);
        this.kEx.setOnSwitchStateChangeListener(this.kDX);
        this.kEz.setOnSwitchStateChangeListener(this.kDX);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.kEq) {
                    e.this.kDY.Ck(0);
                } else if (view == e.this.kEc) {
                    e.this.kDY.Ck(1);
                } else if (view == e.this.kEd) {
                    e.this.kDY.Ck(15);
                } else if (view == e.this.kEe) {
                    e.this.kDY.Ck(2);
                } else if (view == e.this.kEf) {
                    e.this.kDY.Ck(3);
                } else if (view == e.this.kEh) {
                    e.this.kDY.Ck(4);
                } else if (view == e.this.kEi) {
                    e.this.kDY.Ck(9);
                } else if (view == e.this.kEj) {
                    e.this.kDY.Ck(6);
                } else if (view == e.this.kEk) {
                    e.this.kDY.Ck(7);
                } else if (view == e.this.kEl) {
                    e.this.kDY.Ck(8);
                } else if (view == e.this.kEm) {
                    e.this.kDY.Ck(5);
                } else if (view == e.this.kEn) {
                    e.this.kDY.Ck(10);
                } else if (view == e.this.kEb) {
                    e.this.kDY.Ck(13);
                } else if (view == e.this.kEg) {
                    e.this.kDY.Ck(16);
                }
            }
        };
    }

    public void cQU() {
        if (this.kDZ == null) {
            WP();
        }
        this.kDZ.showDialog();
    }

    public void xk() {
        if (this.kDZ != null) {
            this.kDZ.dismiss();
        }
    }

    public BdSwitchView cQV() {
        return this.kEx;
    }

    public BdSwitchView cQW() {
        return this.kEz;
    }
}
