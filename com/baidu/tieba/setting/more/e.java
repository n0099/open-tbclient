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
    private MoreActivity jSV;
    private d jSW;
    private com.baidu.tbadk.core.dialog.i jSX;
    private k jSY;
    private SettingTextNormalImageView jSZ;
    private SettingTextImageView jTa;
    private TbSettingTextTipView jTb;
    private TbSettingTextTipView jTc;
    private TbSettingTextTipView jTd;
    private TbSettingTextTipView jTe;
    private TbSettingTextTipView jTf;
    private TbSettingTextTipView jTg;
    private SettingTextVersionView jTh;
    private TbSettingTextTipView jTi;
    private TbSettingTextTipView jTj;
    private TbSettingTextNewDotView jTk;
    private TextView jTl;
    private RelativeLayout jTm;
    private View jTn;
    private View jTo;
    private View jTp;
    private View jTq;
    private View jTr;
    private View jTs;
    private View jTt;
    private RelativeLayout jTu;
    private BdSwitchView jTv;
    private RelativeLayout jTw;
    private BdSwitchView jTx;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jTp = null;
        this.jTq = null;
        this.jTr = null;
        this.jTs = null;
        this.jTt = null;
        this.jTu = null;
        this.jTv = null;
        this.jTw = null;
        this.jTx = null;
        this.jSV = moreActivity;
        this.jSW = dVar;
        this.jSV.setContentView(R.layout.more_activity);
        aMP();
        cFZ();
    }

    public void cFX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jTa.setVisibility(8);
        } else {
            this.jTa.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jTa != null) {
                this.jTa.cHc();
                return;
            }
            return;
        }
        this.jTa.cHd();
        this.jTa.setIcon(str, z);
    }

    public void cFY() {
        if (this.jTh != null) {
            this.jTh.refresh();
        }
        if (this.jTk != null) {
            this.jTk.refresh();
        }
    }

    public void cFZ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jTv.turnOn();
        } else {
            this.jTv.turnOff();
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

    public void cFb() {
        this.jTa.recycle();
        this.jTb.recycle();
        this.jTc.recycle();
        this.jTd.recycle();
        this.jTf.recycle();
        this.jTg.recycle();
        this.jTh.recycle();
        this.jTi.recycle();
        this.jTj.recycle();
    }

    public void onChangeSkinType(int i) {
        me(i);
        if (this.jSY != null) {
            this.jSV.getLayoutMode().setNightMode(i == 1);
            this.jSV.getLayoutMode().onModeChanged(this.jSY.getView());
        }
        if (i == 1) {
            this.jTv.turnOnNoCallback();
        } else {
            this.jTv.turnOffNoCallback();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jTm, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTa.me(i);
        this.jSV.getLayoutMode().setNightMode(i == 1);
        this.jSV.getLayoutMode().onModeChanged(this.jTm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cFY();
        this.jTv.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTx.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jTn, R.color.cp_bg_line_d);
        this.jSZ.setLocalIcon(am.ku(R.drawable.icon_mine_list_baidu));
        if (this.jSY != null) {
            this.jSY.onChangeSkinType();
        }
        this.jSZ.me(i);
        this.jTa.me(i);
        this.jTb.onChangeSkinType(i);
        this.jTc.onChangeSkinType(i);
        this.jTd.onChangeSkinType(i);
        this.jTe.onChangeSkinType(i);
        this.jTf.onChangeSkinType(i);
        this.jTg.onChangeSkinType(i);
        this.jTh.onChangeSkinType(i);
        this.jTi.onChangeSkinType(i);
        this.jTj.onChangeSkinType(i);
        this.jTk.onChangeSkinType(i);
    }

    private void aMP() {
        View.OnClickListener clickListener = getClickListener();
        this.jTm = (RelativeLayout) this.jSV.findViewById(R.id.parent);
        this.jTn = this.jSV.findViewById(R.id.scroll);
        this.jSV.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jSV.findViewById(R.id.view_navigation_bar);
        this.jTo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jSV.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jSZ = (SettingTextNormalImageView) this.jSV.findViewById(R.id.accountSafeSetting);
        this.jTa = (SettingTextImageView) this.jSV.findViewById(R.id.personInfo);
        this.jTb = (TbSettingTextTipView) this.jSV.findViewById(R.id.interest_label_setting);
        this.jTb.setTopLineVisibility(true);
        this.jTc = (TbSettingTextTipView) this.jSV.findViewById(R.id.accountManager);
        this.jTc.setTopLineVisibility(true);
        this.jTd = (TbSettingTextTipView) this.jSV.findViewById(R.id.browseSetting);
        this.jTd.setBottomLineVisibility(true);
        this.jTe = (TbSettingTextTipView) this.jSV.findViewById(R.id.adSetting);
        this.jTe.setBottomLineVisibility(true);
        this.jTf = (TbSettingTextTipView) this.jSV.findViewById(R.id.messageSetting);
        this.jTf.setBottomLineVisibility(true);
        this.jTd.setBottomLineVisibility(true);
        this.jTg = (TbSettingTextTipView) this.jSV.findViewById(R.id.secretSetting);
        this.jTg.setBottomLineVisibility(true);
        this.jTh = (SettingTextVersionView) this.jSV.findViewById(R.id.versionInfo);
        this.jTi = (TbSettingTextTipView) this.jSV.findViewById(R.id.feedBack);
        this.jTi.setTopLineVisibility(true);
        this.jTi.setBottomLineVisibility(true);
        this.jTj = (TbSettingTextTipView) this.jSV.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jTj.setVisibility(8);
            this.jTj.setBottomLineVisibility(false);
        } else {
            this.jTj.setVisibility(0);
            this.jTj.setBottomLineVisibility(true);
        }
        this.jTk = (TbSettingTextNewDotView) this.jSV.findViewById(R.id.systemhelpsetting);
        this.jTl = (TextView) this.jSV.findViewById(R.id.quit);
        this.jTu = (RelativeLayout) this.jSV.findViewById(R.id.eyeshield_mode);
        this.jTv = (BdSwitchView) this.jSV.findViewById(R.id.item_switch);
        l.addToParentArea(this.jSV.getPageContext().getPageActivity(), this.jTv, 10, 10, 10, 10);
        this.jTw = (RelativeLayout) this.jSV.findViewById(R.id.follow_system_day_night_mode);
        this.jTx = (BdSwitchView) this.jSV.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jSV.getPageContext().getPageActivity(), this.jTx, 10, 10, 10, 10);
        this.jTp = this.jSV.findViewById(R.id.divide_view2);
        this.jTq = this.jSV.findViewById(R.id.divide_view1);
        this.jTr = this.jSV.findViewById(R.id.divide_view3);
        this.jTs = this.jSV.findViewById(R.id.divide_view4);
        this.jTt = this.jSV.findViewById(R.id.divide_view5);
        cFY();
        cFX();
        this.jTa.cHc();
        me(TbadkCoreApplication.getInst().getSkinType());
        this.jTq.setVisibility(0);
        this.jTr.setVisibility(0);
        this.jTs.setVisibility(0);
        this.jTt.setVisibility(0);
        aa(clickListener);
        if (!cGa()) {
            this.jTd.setTip(this.jSV.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jTp.setVisibility(8);
            this.jTu.setVisibility(8);
        } else {
            this.jTp.setVisibility(0);
            this.jTu.setVisibility(0);
        }
        this.jTw.setVisibility(cGb() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_is_follow_system_mode", false)) {
            this.jTx.turnOnNoCallback();
        } else {
            this.jTx.turnOffNoCallback();
        }
    }

    private boolean cGa() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cGb() {
        if (cGa()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void OW() {
        this.jSY = new k(getPageContext().getPageActivity());
        this.jSY.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jSY);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jSV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jSV.getLayoutMode().onModeChanged(this.jSY.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.sN();
                    e.this.jSW.BC(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.sN();
            }
        };
        this.jSY.az(arrayList);
        this.jSY.a(cVar);
        this.jSY.a(aVar);
        this.jSX = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jSX.setCanceledOnTouchOutside(true);
        this.jSX.a(this.jSY);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jSZ.setOnClickListener(onClickListener);
        this.jTo.setOnClickListener(onClickListener);
        this.jTa.setOnClickListener(onClickListener);
        this.jTb.setOnClickListener(onClickListener);
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
        this.jTv.setOnSwitchStateChangeListener(this.jSV);
        this.jTx.setOnSwitchStateChangeListener(this.jSV);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jTo) {
                    e.this.jSW.BC(0);
                } else if (view == e.this.jTa) {
                    e.this.jSW.BC(1);
                } else if (view == e.this.jTb) {
                    e.this.jSW.BC(15);
                } else if (view == e.this.jTc) {
                    e.this.jSW.BC(2);
                } else if (view == e.this.jTd) {
                    e.this.jSW.BC(3);
                } else if (view == e.this.jTf) {
                    e.this.jSW.BC(4);
                } else if (view == e.this.jTg) {
                    e.this.jSW.BC(9);
                } else if (view == e.this.jTh) {
                    e.this.jSW.BC(6);
                } else if (view == e.this.jTi) {
                    e.this.jSW.BC(7);
                } else if (view == e.this.jTj) {
                    e.this.jSW.BC(8);
                } else if (view == e.this.jTk) {
                    e.this.jSW.BC(5);
                } else if (view == e.this.jTl) {
                    e.this.jSW.BC(10);
                } else if (view == e.this.jSZ) {
                    e.this.jSW.BC(13);
                } else if (view == e.this.jTe) {
                    e.this.jSW.BC(16);
                }
            }
        };
    }

    public void cGc() {
        if (this.jSX == null) {
            OW();
        }
        this.jSX.showDialog();
    }

    public void sN() {
        if (this.jSX != null) {
            this.jSX.dismiss();
        }
    }

    public BdSwitchView cGd() {
        return this.jTv;
    }

    public BdSwitchView cGe() {
        return this.jTx;
    }
}
