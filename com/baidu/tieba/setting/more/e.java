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
    private View kXA;
    private View kXB;
    private View kXC;
    private View kXD;
    private View kXE;
    private View kXF;
    private View kXG;
    private RelativeLayout kXH;
    private BdSwitchView kXI;
    private RelativeLayout kXJ;
    private BdSwitchView kXK;
    private MoreActivity kXi;
    private d kXj;
    private com.baidu.tbadk.core.dialog.i kXk;
    private k kXl;
    private SettingTextNormalImageView kXm;
    private SettingTextImageView kXn;
    private TbSettingTextTipView kXo;
    private TbSettingTextTipView kXp;
    private TbSettingTextTipView kXq;
    private TbSettingTextTipView kXr;
    private TbSettingTextTipView kXs;
    private TbSettingTextTipView kXt;
    private SettingTextVersionView kXu;
    private TbSettingTextTipView kXv;
    private TbSettingTextTipView kXw;
    private TbSettingTextNewDotView kXx;
    private TextView kXy;
    private RelativeLayout kXz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.kXC = null;
        this.kXD = null;
        this.kXE = null;
        this.kXF = null;
        this.kXG = null;
        this.kXH = null;
        this.kXI = null;
        this.kXJ = null;
        this.kXK = null;
        this.kXi = moreActivity;
        this.kXj = dVar;
        this.kXi.setContentView(R.layout.more_activity);
        bbB();
        cYl();
    }

    public void cYj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kXn.setVisibility(8);
        } else {
            this.kXn.setVisibility(0);
        }
    }

    public void aS(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.kXn != null) {
                this.kXn.cZo();
                return;
            }
            return;
        }
        this.kXn.cZp();
        this.kXn.setIcon(str, z);
    }

    public void cYk() {
        if (this.kXu != null) {
            this.kXu.refresh();
        }
        if (this.kXx != null) {
            this.kXx.refresh();
        }
    }

    public void cYl() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.kXI.turnOn();
        } else {
            this.kXI.turnOff();
        }
    }

    public void Db(int i) {
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

    public void cXn() {
        this.kXn.recycle();
        this.kXo.recycle();
        this.kXp.recycle();
        this.kXq.recycle();
        this.kXs.recycle();
        this.kXt.recycle();
        this.kXu.recycle();
        this.kXv.recycle();
        this.kXw.recycle();
    }

    public void onChangeSkinType(int i) {
        mW(i);
        if (this.kXl != null) {
            this.kXi.getLayoutMode().setNightMode(i == 1);
            this.kXi.getLayoutMode().onModeChanged(this.kXl.getView());
        }
        if (i == 1) {
            this.kXI.turnOnNoCallback();
        } else {
            this.kXI.turnOffNoCallback();
        }
    }

    public void mW(int i) {
        am.setBackgroundColor(this.kXz, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kXn.mW(i);
        this.kXi.getLayoutMode().setNightMode(i == 1);
        this.kXi.getLayoutMode().onModeChanged(this.kXz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cYk();
        this.kXI.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kXK.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.kXA, R.color.cp_bg_line_d);
        this.kXm.setLocalIcon(am.ld(R.drawable.icon_mine_list_baidu));
        if (this.kXl != null) {
            this.kXl.onChangeSkinType();
        }
        this.kXm.mW(i);
        this.kXn.mW(i);
        this.kXo.onChangeSkinType(i);
        this.kXp.onChangeSkinType(i);
        this.kXq.onChangeSkinType(i);
        this.kXr.onChangeSkinType(i);
        this.kXs.onChangeSkinType(i);
        this.kXt.onChangeSkinType(i);
        this.kXu.onChangeSkinType(i);
        this.kXv.onChangeSkinType(i);
        this.kXw.onChangeSkinType(i);
        this.kXx.onChangeSkinType(i);
    }

    private void bbB() {
        View.OnClickListener clickListener = getClickListener();
        this.kXz = (RelativeLayout) this.kXi.findViewById(R.id.parent);
        this.kXA = this.kXi.findViewById(R.id.scroll);
        this.kXi.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.kXi.findViewById(R.id.view_navigation_bar);
        this.kXB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kXi.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.kXm = (SettingTextNormalImageView) this.kXi.findViewById(R.id.accountSafeSetting);
        this.kXn = (SettingTextImageView) this.kXi.findViewById(R.id.personInfo);
        this.kXo = (TbSettingTextTipView) this.kXi.findViewById(R.id.interest_label_setting);
        this.kXo.setTopLineVisibility(true);
        this.kXp = (TbSettingTextTipView) this.kXi.findViewById(R.id.accountManager);
        this.kXp.setTopLineVisibility(true);
        this.kXq = (TbSettingTextTipView) this.kXi.findViewById(R.id.browseSetting);
        this.kXq.setBottomLineVisibility(true);
        this.kXr = (TbSettingTextTipView) this.kXi.findViewById(R.id.adSetting);
        this.kXr.setBottomLineVisibility(true);
        this.kXs = (TbSettingTextTipView) this.kXi.findViewById(R.id.messageSetting);
        this.kXs.setBottomLineVisibility(true);
        this.kXq.setBottomLineVisibility(true);
        this.kXt = (TbSettingTextTipView) this.kXi.findViewById(R.id.secretSetting);
        this.kXt.setBottomLineVisibility(true);
        this.kXu = (SettingTextVersionView) this.kXi.findViewById(R.id.versionInfo);
        this.kXv = (TbSettingTextTipView) this.kXi.findViewById(R.id.feedBack);
        this.kXv.setTopLineVisibility(true);
        this.kXv.setBottomLineVisibility(true);
        this.kXw = (TbSettingTextTipView) this.kXi.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.kXw.setVisibility(8);
            this.kXw.setBottomLineVisibility(false);
        } else {
            this.kXw.setVisibility(0);
            this.kXw.setBottomLineVisibility(true);
        }
        this.kXx = (TbSettingTextNewDotView) this.kXi.findViewById(R.id.systemhelpsetting);
        this.kXy = (TextView) this.kXi.findViewById(R.id.quit);
        this.kXH = (RelativeLayout) this.kXi.findViewById(R.id.eyeshield_mode);
        this.kXI = (BdSwitchView) this.kXi.findViewById(R.id.item_switch);
        l.addToParentArea(this.kXi.getPageContext().getPageActivity(), this.kXI, 10, 10, 10, 10);
        this.kXJ = (RelativeLayout) this.kXi.findViewById(R.id.follow_system_day_night_mode);
        this.kXK = (BdSwitchView) this.kXi.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.kXi.getPageContext().getPageActivity(), this.kXK, 10, 10, 10, 10);
        this.kXC = this.kXi.findViewById(R.id.divide_view2);
        this.kXD = this.kXi.findViewById(R.id.divide_view1);
        this.kXE = this.kXi.findViewById(R.id.divide_view3);
        this.kXF = this.kXi.findViewById(R.id.divide_view4);
        this.kXG = this.kXi.findViewById(R.id.divide_view5);
        cYk();
        cYj();
        this.kXn.cZo();
        mW(TbadkCoreApplication.getInst().getSkinType());
        this.kXD.setVisibility(0);
        this.kXE.setVisibility(0);
        this.kXF.setVisibility(0);
        this.kXG.setVisibility(0);
        ab(clickListener);
        if (!cYm()) {
            this.kXq.setTip(this.kXi.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.kXC.setVisibility(8);
            this.kXH.setVisibility(8);
        } else {
            this.kXC.setVisibility(0);
            this.kXH.setVisibility(0);
        }
        this.kXJ.setVisibility(cYn() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_is_follow_system_mode", false)) {
            this.kXK.turnOnNoCallback();
        } else {
            this.kXK.turnOffNoCallback();
        }
    }

    private boolean cYm() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cYn() {
        if (cYm()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void ZB() {
        this.kXl = new k(getPageContext().getPageActivity());
        this.kXl.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.kXl);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.kXi.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kXi.getLayoutMode().onModeChanged(this.kXl.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.yy();
                    e.this.kXj.CW(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.yy();
            }
        };
        this.kXl.aD(arrayList);
        this.kXl.a(cVar);
        this.kXl.a(aVar);
        this.kXk = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.kXk.setCanceledOnTouchOutside(true);
        this.kXk.a(this.kXl);
    }

    private void ab(View.OnClickListener onClickListener) {
        this.kXm.setOnClickListener(onClickListener);
        this.kXB.setOnClickListener(onClickListener);
        this.kXn.setOnClickListener(onClickListener);
        this.kXo.setOnClickListener(onClickListener);
        this.kXp.setOnClickListener(onClickListener);
        this.kXq.setOnClickListener(onClickListener);
        this.kXr.setOnClickListener(onClickListener);
        this.kXs.setOnClickListener(onClickListener);
        this.kXt.setOnClickListener(onClickListener);
        this.kXu.setOnClickListener(onClickListener);
        this.kXv.setOnClickListener(onClickListener);
        this.kXw.setOnClickListener(onClickListener);
        this.kXx.setOnClickListener(onClickListener);
        this.kXy.setOnClickListener(onClickListener);
        this.kXI.setOnSwitchStateChangeListener(this.kXi);
        this.kXK.setOnSwitchStateChangeListener(this.kXi);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.kXB) {
                    e.this.kXj.CW(0);
                } else if (view == e.this.kXn) {
                    e.this.kXj.CW(1);
                } else if (view == e.this.kXo) {
                    e.this.kXj.CW(15);
                } else if (view == e.this.kXp) {
                    e.this.kXj.CW(2);
                } else if (view == e.this.kXq) {
                    e.this.kXj.CW(3);
                } else if (view == e.this.kXs) {
                    e.this.kXj.CW(4);
                } else if (view == e.this.kXt) {
                    e.this.kXj.CW(9);
                } else if (view == e.this.kXu) {
                    e.this.kXj.CW(6);
                } else if (view == e.this.kXv) {
                    e.this.kXj.CW(7);
                } else if (view == e.this.kXw) {
                    e.this.kXj.CW(8);
                } else if (view == e.this.kXx) {
                    e.this.kXj.CW(5);
                } else if (view == e.this.kXy) {
                    e.this.kXj.CW(10);
                } else if (view == e.this.kXm) {
                    e.this.kXj.CW(13);
                } else if (view == e.this.kXr) {
                    e.this.kXj.CW(16);
                }
            }
        };
    }

    public void cYo() {
        if (this.kXk == null) {
            ZB();
        }
        this.kXk.showDialog();
    }

    public void yy() {
        if (this.kXk != null) {
            this.kXk.dismiss();
        }
    }

    public BdSwitchView cYp() {
        return this.kXI;
    }

    public BdSwitchView cYq() {
        return this.kXK;
    }
}
