package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private View iLA;
    private View iLB;
    private View iLC;
    private RelativeLayout iLD;
    private BdSwitchView iLE;
    private MoreActivity iLe;
    private d iLf;
    private i iLg;
    private k iLh;
    private SettingTextNormalImageView iLi;
    private SettingTextImageView iLj;
    private TbSettingTextTipView iLk;
    private TbSettingTextTipView iLl;
    private TbSettingTextTipView iLm;
    private TbSettingTextTipView iLn;
    private TbSettingTextTipView iLo;
    private TbSettingTextTipView iLp;
    private SettingTextVersionView iLq;
    private TbSettingTextTipView iLr;
    private TbSettingTextTipView iLs;
    private TbSettingTextNewDotView iLt;
    private TextView iLu;
    private RelativeLayout iLv;
    private View iLw;
    private View iLx;
    private View iLy;
    private View iLz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iLy = null;
        this.iLz = null;
        this.iLA = null;
        this.iLB = null;
        this.iLC = null;
        this.iLD = null;
        this.iLE = null;
        this.iLe = moreActivity;
        this.iLf = dVar;
        this.iLe.setContentView(R.layout.more_activity);
        apq();
        chG();
    }

    public void chE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iLj.setVisibility(8);
        } else {
            this.iLj.setVisibility(0);
        }
    }

    public void av(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iLj != null) {
                this.iLj.ciF();
                return;
            }
            return;
        }
        this.iLj.ciG();
        this.iLj.setIcon(str, z);
    }

    public void chF() {
        if (this.iLq != null) {
            this.iLq.refresh();
        }
        if (this.iLt != null) {
            this.iLt.refresh();
        }
    }

    public void chG() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iLE.mV();
        } else {
            this.iLE.mW();
        }
    }

    public void zG(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").bT("obj_type", "1").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").bT("obj_type", "0").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void cgJ() {
        this.iLj.recycle();
        this.iLk.recycle();
        this.iLl.recycle();
        this.iLm.recycle();
        this.iLo.recycle();
        this.iLp.recycle();
        this.iLq.recycle();
        this.iLr.recycle();
        this.iLs.recycle();
    }

    public void onChangeSkinType(int i) {
        jT(i);
        if (this.iLh != null) {
            this.iLe.getLayoutMode().setNightMode(i == 1);
            this.iLe.getLayoutMode().onModeChanged(this.iLh.afX());
        }
    }

    public void jT(int i) {
        al.l(this.iLv, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iLj.jT(i);
        this.iLe.getLayoutMode().setNightMode(i == 1);
        this.iLe.getLayoutMode().onModeChanged(this.iLv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        chF();
        this.iLE.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this.iLw, R.color.cp_bg_line_d);
        this.iLi.setLocalIcon(al.ih(R.drawable.icon_mine_list_baidu));
        if (this.iLh != null) {
            this.iLh.onChangeSkinType();
        }
    }

    private void apq() {
        View.OnClickListener clickListener = getClickListener();
        this.iLv = (RelativeLayout) this.iLe.findViewById(R.id.parent);
        this.iLw = this.iLe.findViewById(R.id.scroll);
        this.iLe.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iLe.findViewById(R.id.view_navigation_bar);
        this.iLx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iLe.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iLi = (SettingTextNormalImageView) this.iLe.findViewById(R.id.accountSafeSetting);
        this.iLj = (SettingTextImageView) this.iLe.findViewById(R.id.personInfo);
        this.iLk = (TbSettingTextTipView) this.iLe.findViewById(R.id.interest_label_setting);
        this.iLk.setTopLineVisibility(true);
        this.iLl = (TbSettingTextTipView) this.iLe.findViewById(R.id.accountManager);
        this.iLl.setTopLineVisibility(true);
        this.iLm = (TbSettingTextTipView) this.iLe.findViewById(R.id.browseSetting);
        this.iLm.setBottomLineVisibility(true);
        this.iLn = (TbSettingTextTipView) this.iLe.findViewById(R.id.adSetting);
        this.iLn.setBottomLineVisibility(true);
        this.iLo = (TbSettingTextTipView) this.iLe.findViewById(R.id.messageSetting);
        this.iLo.setBottomLineVisibility(true);
        this.iLm.setBottomLineVisibility(true);
        this.iLp = (TbSettingTextTipView) this.iLe.findViewById(R.id.secretSetting);
        this.iLp.setBottomLineVisibility(true);
        this.iLq = (SettingTextVersionView) this.iLe.findViewById(R.id.versionInfo);
        this.iLr = (TbSettingTextTipView) this.iLe.findViewById(R.id.feedBack);
        this.iLr.setTopLineVisibility(true);
        this.iLr.setBottomLineVisibility(true);
        this.iLs = (TbSettingTextTipView) this.iLe.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iLs.setVisibility(8);
            this.iLs.setBottomLineVisibility(false);
        } else {
            this.iLs.setVisibility(0);
            this.iLs.setBottomLineVisibility(true);
        }
        this.iLt = (TbSettingTextNewDotView) this.iLe.findViewById(R.id.systemhelpsetting);
        this.iLu = (TextView) this.iLe.findViewById(R.id.quit);
        this.iLD = (RelativeLayout) this.iLe.findViewById(R.id.eyeshield_mode);
        this.iLE = (BdSwitchView) this.iLe.findViewById(R.id.item_switch);
        l.b(this.iLe.getPageContext().getPageActivity(), this.iLE, 10, 10, 10, 10);
        this.iLy = this.iLe.findViewById(R.id.divide_view2);
        this.iLz = this.iLe.findViewById(R.id.divide_view1);
        this.iLA = this.iLe.findViewById(R.id.divide_view3);
        this.iLB = this.iLe.findViewById(R.id.divide_view4);
        this.iLC = this.iLe.findViewById(R.id.divide_view5);
        chF();
        chE();
        this.iLj.ciF();
        jT(TbadkCoreApplication.getInst().getSkinType());
        this.iLz.setVisibility(0);
        this.iLA.setVisibility(0);
        this.iLB.setVisibility(0);
        this.iLC.setVisibility(0);
        X(clickListener);
        if (!chH()) {
            this.iLm.setTip(this.iLe.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iLy.setVisibility(8);
            this.iLD.setVisibility(8);
            return;
        }
        this.iLy.setVisibility(0);
        this.iLD.setVisibility(0);
    }

    private boolean chH() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void Am() {
        this.iLh = new k(getPageContext().getPageActivity());
        this.iLh.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iLh);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iLe.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iLe.getLayoutMode().onModeChanged(this.iLh.afX());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.ayA();
                    e.this.iLf.zB(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.ayA();
            }
        };
        this.iLh.W(arrayList);
        this.iLh.a(cVar);
        this.iLh.a(aVar);
        this.iLg = new i(this.mContext);
        this.iLg.setCanceledOnTouchOutside(true);
        this.iLg.setContentView(this.iLh.afZ());
    }

    private void X(View.OnClickListener onClickListener) {
        this.iLi.setOnClickListener(onClickListener);
        this.iLx.setOnClickListener(onClickListener);
        this.iLj.setOnClickListener(onClickListener);
        this.iLk.setOnClickListener(onClickListener);
        this.iLl.setOnClickListener(onClickListener);
        this.iLm.setOnClickListener(onClickListener);
        this.iLn.setOnClickListener(onClickListener);
        this.iLo.setOnClickListener(onClickListener);
        this.iLp.setOnClickListener(onClickListener);
        this.iLq.setOnClickListener(onClickListener);
        this.iLr.setOnClickListener(onClickListener);
        this.iLs.setOnClickListener(onClickListener);
        this.iLt.setOnClickListener(onClickListener);
        this.iLu.setOnClickListener(onClickListener);
        this.iLE.setOnSwitchStateChangeListener(this.iLe);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iLx) {
                    e.this.iLf.zB(0);
                } else if (view == e.this.iLj) {
                    e.this.iLf.zB(1);
                } else if (view == e.this.iLk) {
                    e.this.iLf.zB(15);
                } else if (view == e.this.iLl) {
                    e.this.iLf.zB(2);
                } else if (view == e.this.iLm) {
                    e.this.iLf.zB(3);
                } else if (view == e.this.iLo) {
                    e.this.iLf.zB(4);
                } else if (view == e.this.iLp) {
                    e.this.iLf.zB(9);
                } else if (view == e.this.iLq) {
                    e.this.iLf.zB(6);
                } else if (view == e.this.iLr) {
                    e.this.iLf.zB(7);
                } else if (view == e.this.iLs) {
                    e.this.iLf.zB(8);
                } else if (view == e.this.iLt) {
                    e.this.iLf.zB(5);
                } else if (view == e.this.iLu) {
                    e.this.iLf.zB(10);
                } else if (view == e.this.iLi) {
                    e.this.iLf.zB(13);
                } else if (view == e.this.iLn) {
                    e.this.iLf.zB(16);
                }
            }
        };
    }

    public void chI() {
        if (this.iLg == null) {
            Am();
        }
        this.iLg.showDialog();
    }

    public void ayA() {
        if (this.iLg != null) {
            this.iLg.dismiss();
        }
    }

    public BdSwitchView chJ() {
        return this.iLE;
    }
}
