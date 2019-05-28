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
    private View iLD;
    private View iLE;
    private RelativeLayout iLF;
    private BdSwitchView iLG;
    private MoreActivity iLg;
    private d iLh;
    private i iLi;
    private k iLj;
    private SettingTextNormalImageView iLk;
    private SettingTextImageView iLl;
    private TbSettingTextTipView iLm;
    private TbSettingTextTipView iLn;
    private TbSettingTextTipView iLo;
    private TbSettingTextTipView iLp;
    private TbSettingTextTipView iLq;
    private TbSettingTextTipView iLr;
    private SettingTextVersionView iLs;
    private TbSettingTextTipView iLt;
    private TbSettingTextTipView iLu;
    private TbSettingTextNewDotView iLv;
    private TextView iLw;
    private RelativeLayout iLx;
    private View iLy;
    private View iLz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iLA = null;
        this.iLB = null;
        this.iLC = null;
        this.iLD = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = null;
        this.iLg = moreActivity;
        this.iLh = dVar;
        this.iLg.setContentView(R.layout.more_activity);
        apq();
        chI();
    }

    public void chG() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iLl.setVisibility(8);
        } else {
            this.iLl.setVisibility(0);
        }
    }

    public void av(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iLl != null) {
                this.iLl.ciH();
                return;
            }
            return;
        }
        this.iLl.ciI();
        this.iLl.setIcon(str, z);
    }

    public void chH() {
        if (this.iLs != null) {
            this.iLs.refresh();
        }
        if (this.iLv != null) {
            this.iLv.refresh();
        }
    }

    public void chI() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iLG.mV();
        } else {
            this.iLG.mW();
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

    public void cgL() {
        this.iLl.recycle();
        this.iLm.recycle();
        this.iLn.recycle();
        this.iLo.recycle();
        this.iLq.recycle();
        this.iLr.recycle();
        this.iLs.recycle();
        this.iLt.recycle();
        this.iLu.recycle();
    }

    public void onChangeSkinType(int i) {
        jT(i);
        if (this.iLj != null) {
            this.iLg.getLayoutMode().setNightMode(i == 1);
            this.iLg.getLayoutMode().onModeChanged(this.iLj.afX());
        }
    }

    public void jT(int i) {
        al.l(this.iLx, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iLl.jT(i);
        this.iLg.getLayoutMode().setNightMode(i == 1);
        this.iLg.getLayoutMode().onModeChanged(this.iLx);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        chH();
        this.iLG.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this.iLy, R.color.cp_bg_line_d);
        this.iLk.setLocalIcon(al.ih(R.drawable.icon_mine_list_baidu));
        if (this.iLj != null) {
            this.iLj.onChangeSkinType();
        }
    }

    private void apq() {
        View.OnClickListener clickListener = getClickListener();
        this.iLx = (RelativeLayout) this.iLg.findViewById(R.id.parent);
        this.iLy = this.iLg.findViewById(R.id.scroll);
        this.iLg.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iLg.findViewById(R.id.view_navigation_bar);
        this.iLz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iLg.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iLk = (SettingTextNormalImageView) this.iLg.findViewById(R.id.accountSafeSetting);
        this.iLl = (SettingTextImageView) this.iLg.findViewById(R.id.personInfo);
        this.iLm = (TbSettingTextTipView) this.iLg.findViewById(R.id.interest_label_setting);
        this.iLm.setTopLineVisibility(true);
        this.iLn = (TbSettingTextTipView) this.iLg.findViewById(R.id.accountManager);
        this.iLn.setTopLineVisibility(true);
        this.iLo = (TbSettingTextTipView) this.iLg.findViewById(R.id.browseSetting);
        this.iLo.setBottomLineVisibility(true);
        this.iLp = (TbSettingTextTipView) this.iLg.findViewById(R.id.adSetting);
        this.iLp.setBottomLineVisibility(true);
        this.iLq = (TbSettingTextTipView) this.iLg.findViewById(R.id.messageSetting);
        this.iLq.setBottomLineVisibility(true);
        this.iLo.setBottomLineVisibility(true);
        this.iLr = (TbSettingTextTipView) this.iLg.findViewById(R.id.secretSetting);
        this.iLr.setBottomLineVisibility(true);
        this.iLs = (SettingTextVersionView) this.iLg.findViewById(R.id.versionInfo);
        this.iLt = (TbSettingTextTipView) this.iLg.findViewById(R.id.feedBack);
        this.iLt.setTopLineVisibility(true);
        this.iLt.setBottomLineVisibility(true);
        this.iLu = (TbSettingTextTipView) this.iLg.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iLu.setVisibility(8);
            this.iLu.setBottomLineVisibility(false);
        } else {
            this.iLu.setVisibility(0);
            this.iLu.setBottomLineVisibility(true);
        }
        this.iLv = (TbSettingTextNewDotView) this.iLg.findViewById(R.id.systemhelpsetting);
        this.iLw = (TextView) this.iLg.findViewById(R.id.quit);
        this.iLF = (RelativeLayout) this.iLg.findViewById(R.id.eyeshield_mode);
        this.iLG = (BdSwitchView) this.iLg.findViewById(R.id.item_switch);
        l.b(this.iLg.getPageContext().getPageActivity(), this.iLG, 10, 10, 10, 10);
        this.iLA = this.iLg.findViewById(R.id.divide_view2);
        this.iLB = this.iLg.findViewById(R.id.divide_view1);
        this.iLC = this.iLg.findViewById(R.id.divide_view3);
        this.iLD = this.iLg.findViewById(R.id.divide_view4);
        this.iLE = this.iLg.findViewById(R.id.divide_view5);
        chH();
        chG();
        this.iLl.ciH();
        jT(TbadkCoreApplication.getInst().getSkinType());
        this.iLB.setVisibility(0);
        this.iLC.setVisibility(0);
        this.iLD.setVisibility(0);
        this.iLE.setVisibility(0);
        X(clickListener);
        if (!chJ()) {
            this.iLo.setTip(this.iLg.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iLA.setVisibility(8);
            this.iLF.setVisibility(8);
            return;
        }
        this.iLA.setVisibility(0);
        this.iLF.setVisibility(0);
    }

    private boolean chJ() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void Am() {
        this.iLj = new k(getPageContext().getPageActivity());
        this.iLj.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iLj);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iLg.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iLg.getLayoutMode().onModeChanged(this.iLj.afX());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.ayB();
                    e.this.iLh.zB(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.ayB();
            }
        };
        this.iLj.W(arrayList);
        this.iLj.a(cVar);
        this.iLj.a(aVar);
        this.iLi = new i(this.mContext);
        this.iLi.setCanceledOnTouchOutside(true);
        this.iLi.setContentView(this.iLj.afZ());
    }

    private void X(View.OnClickListener onClickListener) {
        this.iLk.setOnClickListener(onClickListener);
        this.iLz.setOnClickListener(onClickListener);
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
        this.iLv.setOnClickListener(onClickListener);
        this.iLw.setOnClickListener(onClickListener);
        this.iLG.setOnSwitchStateChangeListener(this.iLg);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iLz) {
                    e.this.iLh.zB(0);
                } else if (view == e.this.iLl) {
                    e.this.iLh.zB(1);
                } else if (view == e.this.iLm) {
                    e.this.iLh.zB(15);
                } else if (view == e.this.iLn) {
                    e.this.iLh.zB(2);
                } else if (view == e.this.iLo) {
                    e.this.iLh.zB(3);
                } else if (view == e.this.iLq) {
                    e.this.iLh.zB(4);
                } else if (view == e.this.iLr) {
                    e.this.iLh.zB(9);
                } else if (view == e.this.iLs) {
                    e.this.iLh.zB(6);
                } else if (view == e.this.iLt) {
                    e.this.iLh.zB(7);
                } else if (view == e.this.iLu) {
                    e.this.iLh.zB(8);
                } else if (view == e.this.iLv) {
                    e.this.iLh.zB(5);
                } else if (view == e.this.iLw) {
                    e.this.iLh.zB(10);
                } else if (view == e.this.iLk) {
                    e.this.iLh.zB(13);
                } else if (view == e.this.iLp) {
                    e.this.iLh.zB(16);
                }
            }
        };
    }

    public void chK() {
        if (this.iLi == null) {
            Am();
        }
        this.iLi.showDialog();
    }

    public void ayB() {
        if (this.iLi != null) {
            this.iLi.dismiss();
        }
    }

    public BdSwitchView chL() {
        return this.iLG;
    }
}
