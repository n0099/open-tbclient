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
    private MoreActivity jSX;
    private d jSY;
    private com.baidu.tbadk.core.dialog.i jSZ;
    private k jTa;
    private SettingTextNormalImageView jTb;
    private SettingTextImageView jTc;
    private TbSettingTextTipView jTd;
    private TbSettingTextTipView jTe;
    private TbSettingTextTipView jTf;
    private TbSettingTextTipView jTg;
    private TbSettingTextTipView jTh;
    private TbSettingTextTipView jTi;
    private SettingTextVersionView jTj;
    private TbSettingTextTipView jTk;
    private TbSettingTextTipView jTl;
    private TbSettingTextNewDotView jTm;
    private TextView jTn;
    private RelativeLayout jTo;
    private View jTp;
    private View jTq;
    private View jTr;
    private View jTs;
    private View jTt;
    private View jTu;
    private View jTv;
    private RelativeLayout jTw;
    private BdSwitchView jTx;
    private RelativeLayout jTy;
    private BdSwitchView jTz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jTr = null;
        this.jTs = null;
        this.jTt = null;
        this.jTu = null;
        this.jTv = null;
        this.jTw = null;
        this.jTx = null;
        this.jTy = null;
        this.jTz = null;
        this.jSX = moreActivity;
        this.jSY = dVar;
        this.jSX.setContentView(R.layout.more_activity);
        aMR();
        cGb();
    }

    public void cFZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jTc.setVisibility(8);
        } else {
            this.jTc.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jTc != null) {
                this.jTc.cHe();
                return;
            }
            return;
        }
        this.jTc.cHf();
        this.jTc.setIcon(str, z);
    }

    public void cGa() {
        if (this.jTj != null) {
            this.jTj.refresh();
        }
        if (this.jTm != null) {
            this.jTm.refresh();
        }
    }

    public void cGb() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jTx.turnOn();
        } else {
            this.jTx.turnOff();
        }
    }

    public void BH(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cy("obj_type", "1").cy("obj_source", "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).cy("obj_type", "0").cy("obj_source", "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void cFd() {
        this.jTc.recycle();
        this.jTd.recycle();
        this.jTe.recycle();
        this.jTf.recycle();
        this.jTh.recycle();
        this.jTi.recycle();
        this.jTj.recycle();
        this.jTk.recycle();
        this.jTl.recycle();
    }

    public void onChangeSkinType(int i) {
        me(i);
        if (this.jTa != null) {
            this.jSX.getLayoutMode().setNightMode(i == 1);
            this.jSX.getLayoutMode().onModeChanged(this.jTa.getView());
        }
        if (i == 1) {
            this.jTx.turnOnNoCallback();
        } else {
            this.jTx.turnOffNoCallback();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jTo, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTc.me(i);
        this.jSX.getLayoutMode().setNightMode(i == 1);
        this.jSX.getLayoutMode().onModeChanged(this.jTo);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cGa();
        this.jTx.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTz.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jTp, R.color.cp_bg_line_d);
        this.jTb.setLocalIcon(am.ku(R.drawable.icon_mine_list_baidu));
        if (this.jTa != null) {
            this.jTa.onChangeSkinType();
        }
        this.jTb.me(i);
        this.jTc.me(i);
        this.jTd.onChangeSkinType(i);
        this.jTe.onChangeSkinType(i);
        this.jTf.onChangeSkinType(i);
        this.jTg.onChangeSkinType(i);
        this.jTh.onChangeSkinType(i);
        this.jTi.onChangeSkinType(i);
        this.jTj.onChangeSkinType(i);
        this.jTk.onChangeSkinType(i);
        this.jTl.onChangeSkinType(i);
        this.jTm.onChangeSkinType(i);
    }

    private void aMR() {
        View.OnClickListener clickListener = getClickListener();
        this.jTo = (RelativeLayout) this.jSX.findViewById(R.id.parent);
        this.jTp = this.jSX.findViewById(R.id.scroll);
        this.jSX.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jSX.findViewById(R.id.view_navigation_bar);
        this.jTq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jSX.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jTb = (SettingTextNormalImageView) this.jSX.findViewById(R.id.accountSafeSetting);
        this.jTc = (SettingTextImageView) this.jSX.findViewById(R.id.personInfo);
        this.jTd = (TbSettingTextTipView) this.jSX.findViewById(R.id.interest_label_setting);
        this.jTd.setTopLineVisibility(true);
        this.jTe = (TbSettingTextTipView) this.jSX.findViewById(R.id.accountManager);
        this.jTe.setTopLineVisibility(true);
        this.jTf = (TbSettingTextTipView) this.jSX.findViewById(R.id.browseSetting);
        this.jTf.setBottomLineVisibility(true);
        this.jTg = (TbSettingTextTipView) this.jSX.findViewById(R.id.adSetting);
        this.jTg.setBottomLineVisibility(true);
        this.jTh = (TbSettingTextTipView) this.jSX.findViewById(R.id.messageSetting);
        this.jTh.setBottomLineVisibility(true);
        this.jTf.setBottomLineVisibility(true);
        this.jTi = (TbSettingTextTipView) this.jSX.findViewById(R.id.secretSetting);
        this.jTi.setBottomLineVisibility(true);
        this.jTj = (SettingTextVersionView) this.jSX.findViewById(R.id.versionInfo);
        this.jTk = (TbSettingTextTipView) this.jSX.findViewById(R.id.feedBack);
        this.jTk.setTopLineVisibility(true);
        this.jTk.setBottomLineVisibility(true);
        this.jTl = (TbSettingTextTipView) this.jSX.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jTl.setVisibility(8);
            this.jTl.setBottomLineVisibility(false);
        } else {
            this.jTl.setVisibility(0);
            this.jTl.setBottomLineVisibility(true);
        }
        this.jTm = (TbSettingTextNewDotView) this.jSX.findViewById(R.id.systemhelpsetting);
        this.jTn = (TextView) this.jSX.findViewById(R.id.quit);
        this.jTw = (RelativeLayout) this.jSX.findViewById(R.id.eyeshield_mode);
        this.jTx = (BdSwitchView) this.jSX.findViewById(R.id.item_switch);
        l.addToParentArea(this.jSX.getPageContext().getPageActivity(), this.jTx, 10, 10, 10, 10);
        this.jTy = (RelativeLayout) this.jSX.findViewById(R.id.follow_system_day_night_mode);
        this.jTz = (BdSwitchView) this.jSX.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jSX.getPageContext().getPageActivity(), this.jTz, 10, 10, 10, 10);
        this.jTr = this.jSX.findViewById(R.id.divide_view2);
        this.jTs = this.jSX.findViewById(R.id.divide_view1);
        this.jTt = this.jSX.findViewById(R.id.divide_view3);
        this.jTu = this.jSX.findViewById(R.id.divide_view4);
        this.jTv = this.jSX.findViewById(R.id.divide_view5);
        cGa();
        cFZ();
        this.jTc.cHe();
        me(TbadkCoreApplication.getInst().getSkinType());
        this.jTs.setVisibility(0);
        this.jTt.setVisibility(0);
        this.jTu.setVisibility(0);
        this.jTv.setVisibility(0);
        aa(clickListener);
        if (!cGc()) {
            this.jTf.setTip(this.jSX.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jTr.setVisibility(8);
            this.jTw.setVisibility(8);
        } else {
            this.jTr.setVisibility(0);
            this.jTw.setVisibility(0);
        }
        this.jTy.setVisibility(cGd() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_follow_system_mode", false)) {
            this.jTz.turnOnNoCallback();
        } else {
            this.jTz.turnOffNoCallback();
        }
    }

    private boolean cGc() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cGd() {
        if (cGc()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void OY() {
        this.jTa = new k(getPageContext().getPageActivity());
        this.jTa.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jTa);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jSX.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jSX.getLayoutMode().onModeChanged(this.jTa.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.sN();
                    e.this.jSY.BC(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.sN();
            }
        };
        this.jTa.az(arrayList);
        this.jTa.a(cVar);
        this.jTa.a(aVar);
        this.jSZ = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jSZ.setCanceledOnTouchOutside(true);
        this.jSZ.a(this.jTa);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jTb.setOnClickListener(onClickListener);
        this.jTq.setOnClickListener(onClickListener);
        this.jTc.setOnClickListener(onClickListener);
        this.jTd.setOnClickListener(onClickListener);
        this.jTe.setOnClickListener(onClickListener);
        this.jTf.setOnClickListener(onClickListener);
        this.jTg.setOnClickListener(onClickListener);
        this.jTh.setOnClickListener(onClickListener);
        this.jTi.setOnClickListener(onClickListener);
        this.jTj.setOnClickListener(onClickListener);
        this.jTk.setOnClickListener(onClickListener);
        this.jTl.setOnClickListener(onClickListener);
        this.jTm.setOnClickListener(onClickListener);
        this.jTn.setOnClickListener(onClickListener);
        this.jTx.setOnSwitchStateChangeListener(this.jSX);
        this.jTz.setOnSwitchStateChangeListener(this.jSX);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jTq) {
                    e.this.jSY.BC(0);
                } else if (view == e.this.jTc) {
                    e.this.jSY.BC(1);
                } else if (view == e.this.jTd) {
                    e.this.jSY.BC(15);
                } else if (view == e.this.jTe) {
                    e.this.jSY.BC(2);
                } else if (view == e.this.jTf) {
                    e.this.jSY.BC(3);
                } else if (view == e.this.jTh) {
                    e.this.jSY.BC(4);
                } else if (view == e.this.jTi) {
                    e.this.jSY.BC(9);
                } else if (view == e.this.jTj) {
                    e.this.jSY.BC(6);
                } else if (view == e.this.jTk) {
                    e.this.jSY.BC(7);
                } else if (view == e.this.jTl) {
                    e.this.jSY.BC(8);
                } else if (view == e.this.jTm) {
                    e.this.jSY.BC(5);
                } else if (view == e.this.jTn) {
                    e.this.jSY.BC(10);
                } else if (view == e.this.jTb) {
                    e.this.jSY.BC(13);
                } else if (view == e.this.jTg) {
                    e.this.jSY.BC(16);
                }
            }
        };
    }

    public void cGe() {
        if (this.jSZ == null) {
            OY();
        }
        this.jSZ.showDialog();
    }

    public void sN() {
        if (this.jSZ != null) {
            this.jSZ.dismiss();
        }
    }

    public BdSwitchView cGf() {
        return this.jTx;
    }

    public BdSwitchView cGg() {
        return this.jTz;
    }
}
