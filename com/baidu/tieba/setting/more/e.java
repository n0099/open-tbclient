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
/* loaded from: classes11.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private BdSwitchView jSA;
    private RelativeLayout jSB;
    private BdSwitchView jSC;
    private MoreActivity jSa;
    private d jSb;
    private com.baidu.tbadk.core.dialog.i jSc;
    private k jSd;
    private SettingTextNormalImageView jSe;
    private SettingTextImageView jSf;
    private TbSettingTextTipView jSg;
    private TbSettingTextTipView jSh;
    private TbSettingTextTipView jSi;
    private TbSettingTextTipView jSj;
    private TbSettingTextTipView jSk;
    private TbSettingTextTipView jSl;
    private SettingTextVersionView jSm;
    private TbSettingTextTipView jSn;
    private TbSettingTextTipView jSo;
    private TbSettingTextNewDotView jSp;
    private TextView jSq;
    private RelativeLayout jSr;
    private View jSs;
    private View jSt;
    private View jSu;
    private View jSv;
    private View jSw;
    private View jSx;
    private View jSy;
    private RelativeLayout jSz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jSu = null;
        this.jSv = null;
        this.jSw = null;
        this.jSx = null;
        this.jSy = null;
        this.jSz = null;
        this.jSA = null;
        this.jSB = null;
        this.jSC = null;
        this.jSa = moreActivity;
        this.jSb = dVar;
        this.jSa.setContentView(R.layout.more_activity);
        aKt();
        cEy();
    }

    public void cEw() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jSf.setVisibility(8);
        } else {
            this.jSf.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jSf != null) {
                this.jSf.cFB();
                return;
            }
            return;
        }
        this.jSf.cFC();
        this.jSf.setIcon(str, z);
    }

    public void cEx() {
        if (this.jSm != null) {
            this.jSm.refresh();
        }
        if (this.jSp != null) {
            this.jSp.refresh();
        }
    }

    public void cEy() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jSA.turnOn();
        } else {
            this.jSA.turnOff();
        }
    }

    public void By(int i) {
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

    public void cDA() {
        this.jSf.recycle();
        this.jSg.recycle();
        this.jSh.recycle();
        this.jSi.recycle();
        this.jSk.recycle();
        this.jSl.recycle();
        this.jSm.recycle();
        this.jSn.recycle();
        this.jSo.recycle();
    }

    public void onChangeSkinType(int i) {
        lM(i);
        if (this.jSd != null) {
            this.jSa.getLayoutMode().setNightMode(i == 1);
            this.jSa.getLayoutMode().onModeChanged(this.jSd.aCD());
        }
        if (i == 1) {
            this.jSA.turnOnNoCallback();
        } else {
            this.jSA.turnOffNoCallback();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jSr, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jSf.lM(i);
        this.jSa.getLayoutMode().setNightMode(i == 1);
        this.jSa.getLayoutMode().onModeChanged(this.jSr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cEx();
        this.jSA.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jSC.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jSs, R.color.cp_bg_line_d);
        this.jSe.setLocalIcon(am.kd(R.drawable.icon_mine_list_baidu));
        if (this.jSd != null) {
            this.jSd.onChangeSkinType();
        }
        this.jSe.lM(i);
        this.jSf.lM(i);
        this.jSg.onChangeSkinType(i);
        this.jSh.onChangeSkinType(i);
        this.jSi.onChangeSkinType(i);
        this.jSj.onChangeSkinType(i);
        this.jSk.onChangeSkinType(i);
        this.jSl.onChangeSkinType(i);
        this.jSm.onChangeSkinType(i);
        this.jSn.onChangeSkinType(i);
        this.jSo.onChangeSkinType(i);
        this.jSp.onChangeSkinType(i);
    }

    private void aKt() {
        View.OnClickListener clickListener = getClickListener();
        this.jSr = (RelativeLayout) this.jSa.findViewById(R.id.parent);
        this.jSs = this.jSa.findViewById(R.id.scroll);
        this.jSa.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jSa.findViewById(R.id.view_navigation_bar);
        this.jSt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jSa.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jSe = (SettingTextNormalImageView) this.jSa.findViewById(R.id.accountSafeSetting);
        this.jSf = (SettingTextImageView) this.jSa.findViewById(R.id.personInfo);
        this.jSg = (TbSettingTextTipView) this.jSa.findViewById(R.id.interest_label_setting);
        this.jSg.setTopLineVisibility(true);
        this.jSh = (TbSettingTextTipView) this.jSa.findViewById(R.id.accountManager);
        this.jSh.setTopLineVisibility(true);
        this.jSi = (TbSettingTextTipView) this.jSa.findViewById(R.id.browseSetting);
        this.jSi.setBottomLineVisibility(true);
        this.jSj = (TbSettingTextTipView) this.jSa.findViewById(R.id.adSetting);
        this.jSj.setBottomLineVisibility(true);
        this.jSk = (TbSettingTextTipView) this.jSa.findViewById(R.id.messageSetting);
        this.jSk.setBottomLineVisibility(true);
        this.jSi.setBottomLineVisibility(true);
        this.jSl = (TbSettingTextTipView) this.jSa.findViewById(R.id.secretSetting);
        this.jSl.setBottomLineVisibility(true);
        this.jSm = (SettingTextVersionView) this.jSa.findViewById(R.id.versionInfo);
        this.jSn = (TbSettingTextTipView) this.jSa.findViewById(R.id.feedBack);
        this.jSn.setTopLineVisibility(true);
        this.jSn.setBottomLineVisibility(true);
        this.jSo = (TbSettingTextTipView) this.jSa.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jSo.setVisibility(8);
            this.jSo.setBottomLineVisibility(false);
        } else {
            this.jSo.setVisibility(0);
            this.jSo.setBottomLineVisibility(true);
        }
        this.jSp = (TbSettingTextNewDotView) this.jSa.findViewById(R.id.systemhelpsetting);
        this.jSq = (TextView) this.jSa.findViewById(R.id.quit);
        this.jSz = (RelativeLayout) this.jSa.findViewById(R.id.eyeshield_mode);
        this.jSA = (BdSwitchView) this.jSa.findViewById(R.id.item_switch);
        l.addToParentArea(this.jSa.getPageContext().getPageActivity(), this.jSA, 10, 10, 10, 10);
        this.jSB = (RelativeLayout) this.jSa.findViewById(R.id.follow_system_day_night_mode);
        this.jSC = (BdSwitchView) this.jSa.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jSa.getPageContext().getPageActivity(), this.jSC, 10, 10, 10, 10);
        this.jSu = this.jSa.findViewById(R.id.divide_view2);
        this.jSv = this.jSa.findViewById(R.id.divide_view1);
        this.jSw = this.jSa.findViewById(R.id.divide_view3);
        this.jSx = this.jSa.findViewById(R.id.divide_view4);
        this.jSy = this.jSa.findViewById(R.id.divide_view5);
        cEx();
        cEw();
        this.jSf.cFB();
        lM(TbadkCoreApplication.getInst().getSkinType());
        this.jSv.setVisibility(0);
        this.jSw.setVisibility(0);
        this.jSx.setVisibility(0);
        this.jSy.setVisibility(0);
        aa(clickListener);
        if (!cEz()) {
            this.jSi.setTip(this.jSa.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jSu.setVisibility(8);
            this.jSz.setVisibility(8);
        } else {
            this.jSu.setVisibility(0);
            this.jSz.setVisibility(0);
        }
        this.jSB.setVisibility(cEA() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_is_follow_system_mode", false)) {
            this.jSC.turnOnNoCallback();
        } else {
            this.jSC.turnOffNoCallback();
        }
    }

    private boolean cEz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cEA() {
        if (cEz()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void MI() {
        this.jSd = new k(getPageContext().getPageActivity());
        this.jSd.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jSd);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jSa.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jSa.getLayoutMode().onModeChanged(this.jSd.aCD());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.xe();
                    e.this.jSb.Bt(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.xe();
            }
        };
        this.jSd.az(arrayList);
        this.jSd.a(cVar);
        this.jSd.a(aVar);
        this.jSc = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jSc.setCanceledOnTouchOutside(true);
        this.jSc.a(this.jSd);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jSe.setOnClickListener(onClickListener);
        this.jSt.setOnClickListener(onClickListener);
        this.jSf.setOnClickListener(onClickListener);
        this.jSg.setOnClickListener(onClickListener);
        this.jSh.setOnClickListener(onClickListener);
        this.jSi.setOnClickListener(onClickListener);
        this.jSj.setOnClickListener(onClickListener);
        this.jSk.setOnClickListener(onClickListener);
        this.jSl.setOnClickListener(onClickListener);
        this.jSm.setOnClickListener(onClickListener);
        this.jSn.setOnClickListener(onClickListener);
        this.jSo.setOnClickListener(onClickListener);
        this.jSp.setOnClickListener(onClickListener);
        this.jSq.setOnClickListener(onClickListener);
        this.jSA.setOnSwitchStateChangeListener(this.jSa);
        this.jSC.setOnSwitchStateChangeListener(this.jSa);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jSt) {
                    e.this.jSb.Bt(0);
                } else if (view == e.this.jSf) {
                    e.this.jSb.Bt(1);
                } else if (view == e.this.jSg) {
                    e.this.jSb.Bt(15);
                } else if (view == e.this.jSh) {
                    e.this.jSb.Bt(2);
                } else if (view == e.this.jSi) {
                    e.this.jSb.Bt(3);
                } else if (view == e.this.jSk) {
                    e.this.jSb.Bt(4);
                } else if (view == e.this.jSl) {
                    e.this.jSb.Bt(9);
                } else if (view == e.this.jSm) {
                    e.this.jSb.Bt(6);
                } else if (view == e.this.jSn) {
                    e.this.jSb.Bt(7);
                } else if (view == e.this.jSo) {
                    e.this.jSb.Bt(8);
                } else if (view == e.this.jSp) {
                    e.this.jSb.Bt(5);
                } else if (view == e.this.jSq) {
                    e.this.jSb.Bt(10);
                } else if (view == e.this.jSe) {
                    e.this.jSb.Bt(13);
                } else if (view == e.this.jSj) {
                    e.this.jSb.Bt(16);
                }
            }
        };
    }

    public void cEB() {
        if (this.jSc == null) {
            MI();
        }
        this.jSc.showDialog();
    }

    public void xe() {
        if (this.jSc != null) {
            this.jSc.dismiss();
        }
    }

    public BdSwitchView cEC() {
        return this.jSA;
    }

    public BdSwitchView cED() {
        return this.jSC;
    }
}
