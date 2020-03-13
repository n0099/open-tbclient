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
    private RelativeLayout jTA;
    private View jTB;
    private View jTC;
    private View jTD;
    private View jTE;
    private View jTF;
    private View jTG;
    private View jTH;
    private RelativeLayout jTI;
    private BdSwitchView jTJ;
    private RelativeLayout jTK;
    private BdSwitchView jTL;
    private MoreActivity jTj;
    private d jTk;
    private com.baidu.tbadk.core.dialog.i jTl;
    private k jTm;
    private SettingTextNormalImageView jTn;
    private SettingTextImageView jTo;
    private TbSettingTextTipView jTp;
    private TbSettingTextTipView jTq;
    private TbSettingTextTipView jTr;
    private TbSettingTextTipView jTs;
    private TbSettingTextTipView jTt;
    private TbSettingTextTipView jTu;
    private SettingTextVersionView jTv;
    private TbSettingTextTipView jTw;
    private TbSettingTextTipView jTx;
    private TbSettingTextNewDotView jTy;
    private TextView jTz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.jTD = null;
        this.jTE = null;
        this.jTF = null;
        this.jTG = null;
        this.jTH = null;
        this.jTI = null;
        this.jTJ = null;
        this.jTK = null;
        this.jTL = null;
        this.jTj = moreActivity;
        this.jTk = dVar;
        this.jTj.setContentView(R.layout.more_activity);
        aMS();
        cGc();
    }

    public void cGa() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jTo.setVisibility(8);
        } else {
            this.jTo.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.jTo != null) {
                this.jTo.cHf();
                return;
            }
            return;
        }
        this.jTo.cHg();
        this.jTo.setIcon(str, z);
    }

    public void cGb() {
        if (this.jTv != null) {
            this.jTv.refresh();
        }
        if (this.jTy != null) {
            this.jTy.refresh();
        }
    }

    public void cGc() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.jTJ.turnOn();
        } else {
            this.jTJ.turnOff();
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

    public void cFe() {
        this.jTo.recycle();
        this.jTp.recycle();
        this.jTq.recycle();
        this.jTr.recycle();
        this.jTt.recycle();
        this.jTu.recycle();
        this.jTv.recycle();
        this.jTw.recycle();
        this.jTx.recycle();
    }

    public void onChangeSkinType(int i) {
        me(i);
        if (this.jTm != null) {
            this.jTj.getLayoutMode().setNightMode(i == 1);
            this.jTj.getLayoutMode().onModeChanged(this.jTm.getView());
        }
        if (i == 1) {
            this.jTJ.turnOnNoCallback();
        } else {
            this.jTJ.turnOffNoCallback();
        }
    }

    public void me(int i) {
        am.setBackgroundColor(this.jTA, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTo.me(i);
        this.jTj.getLayoutMode().setNightMode(i == 1);
        this.jTj.getLayoutMode().onModeChanged(this.jTA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        cGb();
        this.jTJ.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTL.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        am.setBackgroundColor(this.jTB, R.color.cp_bg_line_d);
        this.jTn.setLocalIcon(am.ku(R.drawable.icon_mine_list_baidu));
        if (this.jTm != null) {
            this.jTm.onChangeSkinType();
        }
        this.jTn.me(i);
        this.jTo.me(i);
        this.jTp.onChangeSkinType(i);
        this.jTq.onChangeSkinType(i);
        this.jTr.onChangeSkinType(i);
        this.jTs.onChangeSkinType(i);
        this.jTt.onChangeSkinType(i);
        this.jTu.onChangeSkinType(i);
        this.jTv.onChangeSkinType(i);
        this.jTw.onChangeSkinType(i);
        this.jTx.onChangeSkinType(i);
        this.jTy.onChangeSkinType(i);
    }

    private void aMS() {
        View.OnClickListener clickListener = getClickListener();
        this.jTA = (RelativeLayout) this.jTj.findViewById(R.id.parent);
        this.jTB = this.jTj.findViewById(R.id.scroll);
        this.jTj.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.jTj.findViewById(R.id.view_navigation_bar);
        this.jTC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.jTj.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.jTn = (SettingTextNormalImageView) this.jTj.findViewById(R.id.accountSafeSetting);
        this.jTo = (SettingTextImageView) this.jTj.findViewById(R.id.personInfo);
        this.jTp = (TbSettingTextTipView) this.jTj.findViewById(R.id.interest_label_setting);
        this.jTp.setTopLineVisibility(true);
        this.jTq = (TbSettingTextTipView) this.jTj.findViewById(R.id.accountManager);
        this.jTq.setTopLineVisibility(true);
        this.jTr = (TbSettingTextTipView) this.jTj.findViewById(R.id.browseSetting);
        this.jTr.setBottomLineVisibility(true);
        this.jTs = (TbSettingTextTipView) this.jTj.findViewById(R.id.adSetting);
        this.jTs.setBottomLineVisibility(true);
        this.jTt = (TbSettingTextTipView) this.jTj.findViewById(R.id.messageSetting);
        this.jTt.setBottomLineVisibility(true);
        this.jTr.setBottomLineVisibility(true);
        this.jTu = (TbSettingTextTipView) this.jTj.findViewById(R.id.secretSetting);
        this.jTu.setBottomLineVisibility(true);
        this.jTv = (SettingTextVersionView) this.jTj.findViewById(R.id.versionInfo);
        this.jTw = (TbSettingTextTipView) this.jTj.findViewById(R.id.feedBack);
        this.jTw.setTopLineVisibility(true);
        this.jTw.setBottomLineVisibility(true);
        this.jTx = (TbSettingTextTipView) this.jTj.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.jTx.setVisibility(8);
            this.jTx.setBottomLineVisibility(false);
        } else {
            this.jTx.setVisibility(0);
            this.jTx.setBottomLineVisibility(true);
        }
        this.jTy = (TbSettingTextNewDotView) this.jTj.findViewById(R.id.systemhelpsetting);
        this.jTz = (TextView) this.jTj.findViewById(R.id.quit);
        this.jTI = (RelativeLayout) this.jTj.findViewById(R.id.eyeshield_mode);
        this.jTJ = (BdSwitchView) this.jTj.findViewById(R.id.item_switch);
        l.addToParentArea(this.jTj.getPageContext().getPageActivity(), this.jTJ, 10, 10, 10, 10);
        this.jTK = (RelativeLayout) this.jTj.findViewById(R.id.follow_system_day_night_mode);
        this.jTL = (BdSwitchView) this.jTj.findViewById(R.id.follow_system_item_switch);
        l.addToParentArea(this.jTj.getPageContext().getPageActivity(), this.jTL, 10, 10, 10, 10);
        this.jTD = this.jTj.findViewById(R.id.divide_view2);
        this.jTE = this.jTj.findViewById(R.id.divide_view1);
        this.jTF = this.jTj.findViewById(R.id.divide_view3);
        this.jTG = this.jTj.findViewById(R.id.divide_view4);
        this.jTH = this.jTj.findViewById(R.id.divide_view5);
        cGb();
        cGa();
        this.jTo.cHf();
        me(TbadkCoreApplication.getInst().getSkinType());
        this.jTE.setVisibility(0);
        this.jTF.setVisibility(0);
        this.jTG.setVisibility(0);
        this.jTH.setVisibility(0);
        aa(clickListener);
        if (!cGd()) {
            this.jTr.setTip(this.jTj.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.jTD.setVisibility(8);
            this.jTI.setVisibility(8);
        } else {
            this.jTD.setVisibility(0);
            this.jTI.setVisibility(0);
        }
        this.jTK.setVisibility(cGe() ? 0 : 8);
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_follow_system_mode", false)) {
            this.jTL.turnOnNoCallback();
        } else {
            this.jTL.turnOffNoCallback();
        }
    }

    private boolean cGd() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private boolean cGe() {
        if (cGd()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return true;
            }
            return com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_dark_mode_notify_shown", false);
        }
        return false;
    }

    private void OY() {
        this.jTm = new k(getPageContext().getPageActivity());
        this.jTm.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.jTm);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.jTj.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jTj.getLayoutMode().onModeChanged(this.jTm.getView());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.sN();
                    e.this.jTk.BC(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.sN();
            }
        };
        this.jTm.az(arrayList);
        this.jTm.a(cVar);
        this.jTm.a(aVar);
        this.jTl = new com.baidu.tbadk.core.dialog.i(this.mContext);
        this.jTl.setCanceledOnTouchOutside(true);
        this.jTl.a(this.jTm);
    }

    private void aa(View.OnClickListener onClickListener) {
        this.jTn.setOnClickListener(onClickListener);
        this.jTC.setOnClickListener(onClickListener);
        this.jTo.setOnClickListener(onClickListener);
        this.jTp.setOnClickListener(onClickListener);
        this.jTq.setOnClickListener(onClickListener);
        this.jTr.setOnClickListener(onClickListener);
        this.jTs.setOnClickListener(onClickListener);
        this.jTt.setOnClickListener(onClickListener);
        this.jTu.setOnClickListener(onClickListener);
        this.jTv.setOnClickListener(onClickListener);
        this.jTw.setOnClickListener(onClickListener);
        this.jTx.setOnClickListener(onClickListener);
        this.jTy.setOnClickListener(onClickListener);
        this.jTz.setOnClickListener(onClickListener);
        this.jTJ.setOnSwitchStateChangeListener(this.jTj);
        this.jTL.setOnSwitchStateChangeListener(this.jTj);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.jTC) {
                    e.this.jTk.BC(0);
                } else if (view == e.this.jTo) {
                    e.this.jTk.BC(1);
                } else if (view == e.this.jTp) {
                    e.this.jTk.BC(15);
                } else if (view == e.this.jTq) {
                    e.this.jTk.BC(2);
                } else if (view == e.this.jTr) {
                    e.this.jTk.BC(3);
                } else if (view == e.this.jTt) {
                    e.this.jTk.BC(4);
                } else if (view == e.this.jTu) {
                    e.this.jTk.BC(9);
                } else if (view == e.this.jTv) {
                    e.this.jTk.BC(6);
                } else if (view == e.this.jTw) {
                    e.this.jTk.BC(7);
                } else if (view == e.this.jTx) {
                    e.this.jTk.BC(8);
                } else if (view == e.this.jTy) {
                    e.this.jTk.BC(5);
                } else if (view == e.this.jTz) {
                    e.this.jTk.BC(10);
                } else if (view == e.this.jTn) {
                    e.this.jTk.BC(13);
                } else if (view == e.this.jTs) {
                    e.this.jTk.BC(16);
                }
            }
        };
    }

    public void cGf() {
        if (this.jTl == null) {
            OY();
        }
        this.jTl.showDialog();
    }

    public void sN() {
        if (this.jTl != null) {
            this.jTl.dismiss();
        }
    }

    public BdSwitchView cGg() {
        return this.jTJ;
    }

    public BdSwitchView cGh() {
        return this.jTL;
    }
}
