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
    private MoreActivity jRV;
    private d jRW;
    private com.baidu.tbadk.core.dialog.i jRX;
    private k jRY;
    private SettingTextNormalImageView jRZ;
    private SettingTextImageView jSa;
    private TbSettingTextTipView jSb;
    private TbSettingTextTipView jSc;
    private TbSettingTextTipView jSd;
    private TbSettingTextTipView jSe;
    private TbSettingTextTipView jSf;
    private TbSettingTextTipView jSg;
    private SettingTextVersionView jSh;
    private TbSettingTextTipView jSi;
    private TbSettingTextTipView jSj;
    private TbSettingTextNewDotView jSk;
    private TextView jSl;
    private RelativeLayout jSm;
    private View jSn;
    private View jSo;
    private View jSp;
    private View jSq;
    private View jSr;
    private View jSs;
    private View jSt;
    private RelativeLayout jSu;
    private BdSwitchView jSv;
    private RelativeLayout jSw;
    private BdSwitchView jSx;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jSp = null;
        this.jSq = null;
        this.jSr = null;
        this.jSs = null;
        this.jSt = null;
        this.jSu = null;
        this.jSv = null;
        this.jSw = null;
        this.jSx = null;
        this.jRV = moreActivity;
        this.jRW = dVar;
        this.jRV.setContentView(R.layout.more_activity);
        aKt();
        cEw();
    }

    public void cEu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jSa.setVisibility(8);
        } else {
            this.jSa.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jSa != null) {
                this.jSa.cFz();
                return;
            }
            return;
        }
        this.jSa.cFA();
        this.jSa.setIcon(str, z);
    }

    public void cEv() {
        if (this.jSh != null) {
            this.jSh.refresh();
        }
        if (this.jSk != null) {
            this.jSk.refresh();
        }
    }

    public void cEw() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jSv.turnOn();
        } else {
            this.jSv.turnOff();
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

    public void cDy() {
        this.jSa.recycle();
        this.jSb.recycle();
        this.jSc.recycle();
        this.jSd.recycle();
        this.jSf.recycle();
        this.jSg.recycle();
        this.jSh.recycle();
        this.jSi.recycle();
        this.jSj.recycle();
    }

    public void onChangeSkinType(int i) {
        lM(i);
        if (this.jRY != null) {
            this.jRV.getLayoutMode().setNightMode(i == 1);
            this.jRV.getLayoutMode().onModeChanged(this.jRY.aCD());
        }
        if (i == 1) {
            this.jSv.turnOnNoCallback();
        } else {
            this.jSv.turnOffNoCallback();
        }
    }

    public void lM(int i) {
        am.setBackgroundColor(this.jSm, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jSa.lM(i);
        this.jRV.getLayoutMode().setNightMode(i == 1);
        this.jRV.getLayoutMode().onModeChanged(this.jSm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cEv();
        this.jSv.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jSx.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jSn, R.color.cp_bg_line_d);
        this.jRZ.setLocalIcon(am.kd(R.drawable.icon_mine_list_baidu));
        if (this.jRY != null) {
            this.jRY.onChangeSkinType();
        }
        this.jRZ.lM(i);
        this.jSa.lM(i);
        this.jSb.onChangeSkinType(i);
        this.jSc.onChangeSkinType(i);
        this.jSd.onChangeSkinType(i);
        this.jSe.onChangeSkinType(i);
        this.jSf.onChangeSkinType(i);
        this.jSg.onChangeSkinType(i);
        this.jSh.onChangeSkinType(i);
        this.jSi.onChangeSkinType(i);
        this.jSj.onChangeSkinType(i);
        this.jSk.onChangeSkinType(i);
    }

    private void aKt() {
        View.OnClickListener clickListener = getClickListener();
        this.jSm = (RelativeLayout) this.jRV.findViewById(R.id.parent);
        this.jSn = this.jRV.findViewById(R.id.scroll);
        this.jRV.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jRV.findViewById(R.id.view_navigation_bar);
        this.jSo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jRV.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jRZ = (SettingTextNormalImageView) this.jRV.findViewById(R.id.accountSafeSetting);
        this.jSa = (SettingTextImageView) this.jRV.findViewById(R.id.personInfo);
        this.jSb = (TbSettingTextTipView) this.jRV.findViewById(R.id.interest_label_setting);
        this.jSb.setTopLineVisibility(true);
        this.jSc = (TbSettingTextTipView) this.jRV.findViewById(R.id.accountManager);
        this.jSc.setTopLineVisibility(true);
        this.jSd = (TbSettingTextTipView) this.jRV.findViewById(R.id.browseSetting);
        this.jSd.setBottomLineVisibility(true);
        this.jSe = (TbSettingTextTipView) this.jRV.findViewById(R.id.adSetting);
        this.jSe.setBottomLineVisibility(true);
        this.jSf = (TbSettingTextTipView) this.jRV.findViewById(R.id.messageSetting);
        this.jSf.setBottomLineVisibility(true);
        this.jSd.setBottomLineVisibility(true);
        this.jSg = (TbSettingTextTipView) this.jRV.findViewById(R.id.secretSetting);
        this.jSg.setBottomLineVisibility(true);
        this.jSh = (SettingTextVersionView) this.jRV.findViewById(R.id.versionInfo);
        this.jSi = (TbSettingTextTipView) this.jRV.findViewById(R.id.feedBack);
        this.jSi.setTopLineVisibility(true);
        this.jSi.setBottomLineVisibility(true);
        this.jSj = (TbSettingTextTipView) this.jRV.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jSj.setVisibility(8);
            this.jSj.setBottomLineVisibility(false);
        } else {
            this.jSj.setVisibility(0);
            this.jSj.setBottomLineVisibility(true);
        }
        this.jSk = (TbSettingTextNewDotView) this.jRV.findViewById(R.id.systemhelpsetting);
        this.jSl = (TextView) this.jRV.findViewById(R.id.quit);
        this.jSu = (RelativeLayout) this.jRV.findViewById(R.id.eyeshield_mode);
        this.jSv = (BdSwitchView) this.jRV.findViewById(R.id.item_switch);
        l.addToParentArea(this.jRV.getPageContext().getPageActivity(), this.jSv, 10, 10, 10, 10);
        this.jSw = (RelativeLayout) this.jRV.findViewById(R.id.follow_system_day_night_mode);
        this.jSx = (BdSwitchView) this.jRV.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jRV.getPageContext().getPageActivity(), this.jSx, 10, 10, 10, 10);
        this.jSp = this.jRV.findViewById(R.id.divide_view2);
        this.jSq = this.jRV.findViewById(R.id.divide_view1);
        this.jSr = this.jRV.findViewById(R.id.divide_view3);
        this.jSs = this.jRV.findViewById(R.id.divide_view4);
        this.jSt = this.jRV.findViewById(R.id.divide_view5);
        cEv();
        cEu();
        this.jSa.cFz();
        lM(TbadkCoreApplication.getInst().getSkinType());
        this.jSq.setVisibility(0);
        this.jSr.setVisibility(0);
        this.jSs.setVisibility(0);
        this.jSt.setVisibility(0);
        aa(clickListener);
        if (!cEx()) {
            this.jSd.setTip(this.jRV.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jSp.setVisibility(8);
            this.jSu.setVisibility(8);
        } else {
            this.jSp.setVisibility(0);
            this.jSu.setVisibility(0);
        }
        this.jSw.setVisibility(cEy() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_is_follow_system_mode", false)) {
            this.jSx.turnOnNoCallback();
        } else {
            this.jSx.turnOffNoCallback();
        }
    }

    private boolean cEx() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cEy() {
        if (cEx()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void MI() {
        this.jRY = new k(getPageContext().getPageActivity());
        this.jRY.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jRY);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jRV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jRV.getLayoutMode().onModeChanged(this.jRY.aCD());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.xe();
                    e.this.jRW.Bt(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.xe();
            }
        };
        this.jRY.az(arrayList);
        this.jRY.a(cVar);
        this.jRY.a(aVar);
        this.jRX = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jRX.setCanceledOnTouchOutside(true);
        this.jRX.a(this.jRY);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jRZ.setOnClickListener(onClickListener);
        this.jSo.setOnClickListener(onClickListener);
        this.jSa.setOnClickListener(onClickListener);
        this.jSb.setOnClickListener(onClickListener);
        this.jSc.setOnClickListener(onClickListener);
        this.jSd.setOnClickListener(onClickListener);
        this.jSe.setOnClickListener(onClickListener);
        this.jSf.setOnClickListener(onClickListener);
        this.jSg.setOnClickListener(onClickListener);
        this.jSh.setOnClickListener(onClickListener);
        this.jSi.setOnClickListener(onClickListener);
        this.jSj.setOnClickListener(onClickListener);
        this.jSk.setOnClickListener(onClickListener);
        this.jSl.setOnClickListener(onClickListener);
        this.jSv.setOnSwitchStateChangeListener(this.jRV);
        this.jSx.setOnSwitchStateChangeListener(this.jRV);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jSo) {
                    e.this.jRW.Bt(0);
                } else if (view == e.this.jSa) {
                    e.this.jRW.Bt(1);
                } else if (view == e.this.jSb) {
                    e.this.jRW.Bt(15);
                } else if (view == e.this.jSc) {
                    e.this.jRW.Bt(2);
                } else if (view == e.this.jSd) {
                    e.this.jRW.Bt(3);
                } else if (view == e.this.jSf) {
                    e.this.jRW.Bt(4);
                } else if (view == e.this.jSg) {
                    e.this.jRW.Bt(9);
                } else if (view == e.this.jSh) {
                    e.this.jRW.Bt(6);
                } else if (view == e.this.jSi) {
                    e.this.jRW.Bt(7);
                } else if (view == e.this.jSj) {
                    e.this.jRW.Bt(8);
                } else if (view == e.this.jSk) {
                    e.this.jRW.Bt(5);
                } else if (view == e.this.jSl) {
                    e.this.jRW.Bt(10);
                } else if (view == e.this.jRZ) {
                    e.this.jRW.Bt(13);
                } else if (view == e.this.jSe) {
                    e.this.jRW.Bt(16);
                }
            }
        };
    }

    public void cEz() {
        if (this.jRX == null) {
            MI();
        }
        this.jRX.showDialog();
    }

    public void xe() {
        if (this.jRX != null) {
            this.jRX.dismiss();
        }
    }

    public BdSwitchView cEA() {
        return this.jSv;
    }

    public BdSwitchView cEB() {
        return this.jSx;
    }
}
