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
    private TextView iLA;
    private RelativeLayout iLB;
    private View iLC;
    private View iLD;
    private View iLE;
    private View iLF;
    private View iLG;
    private View iLH;
    private View iLI;
    private RelativeLayout iLJ;
    private BdSwitchView iLK;
    private MoreActivity iLk;
    private d iLl;
    private i iLm;
    private k iLn;
    private SettingTextNormalImageView iLo;
    private SettingTextImageView iLp;
    private TbSettingTextTipView iLq;
    private TbSettingTextTipView iLr;
    private TbSettingTextTipView iLs;
    private TbSettingTextTipView iLt;
    private TbSettingTextTipView iLu;
    private TbSettingTextTipView iLv;
    private SettingTextVersionView iLw;
    private TbSettingTextTipView iLx;
    private TbSettingTextTipView iLy;
    private TbSettingTextNewDotView iLz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iLE = null;
        this.iLF = null;
        this.iLG = null;
        this.iLH = null;
        this.iLI = null;
        this.iLJ = null;
        this.iLK = null;
        this.iLk = moreActivity;
        this.iLl = dVar;
        this.iLk.setContentView(R.layout.more_activity);
        apq();
        chJ();
    }

    public void chH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iLp.setVisibility(8);
        } else {
            this.iLp.setVisibility(0);
        }
    }

    public void av(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iLp != null) {
                this.iLp.ciI();
                return;
            }
            return;
        }
        this.iLp.ciJ();
        this.iLp.setIcon(str, z);
    }

    public void chI() {
        if (this.iLw != null) {
            this.iLw.refresh();
        }
        if (this.iLz != null) {
            this.iLz.refresh();
        }
    }

    public void chJ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iLK.mV();
        } else {
            this.iLK.mW();
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

    public void cgM() {
        this.iLp.recycle();
        this.iLq.recycle();
        this.iLr.recycle();
        this.iLs.recycle();
        this.iLu.recycle();
        this.iLv.recycle();
        this.iLw.recycle();
        this.iLx.recycle();
        this.iLy.recycle();
    }

    public void onChangeSkinType(int i) {
        jT(i);
        if (this.iLn != null) {
            this.iLk.getLayoutMode().setNightMode(i == 1);
            this.iLk.getLayoutMode().onModeChanged(this.iLn.afX());
        }
    }

    public void jT(int i) {
        al.l(this.iLB, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iLp.jT(i);
        this.iLk.getLayoutMode().setNightMode(i == 1);
        this.iLk.getLayoutMode().onModeChanged(this.iLB);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        chI();
        this.iLK.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        al.l(this.iLC, R.color.cp_bg_line_d);
        this.iLo.setLocalIcon(al.ih(R.drawable.icon_mine_list_baidu));
        if (this.iLn != null) {
            this.iLn.onChangeSkinType();
        }
    }

    private void apq() {
        View.OnClickListener clickListener = getClickListener();
        this.iLB = (RelativeLayout) this.iLk.findViewById(R.id.parent);
        this.iLC = this.iLk.findViewById(R.id.scroll);
        this.iLk.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iLk.findViewById(R.id.view_navigation_bar);
        this.iLD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iLk.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iLo = (SettingTextNormalImageView) this.iLk.findViewById(R.id.accountSafeSetting);
        this.iLp = (SettingTextImageView) this.iLk.findViewById(R.id.personInfo);
        this.iLq = (TbSettingTextTipView) this.iLk.findViewById(R.id.interest_label_setting);
        this.iLq.setTopLineVisibility(true);
        this.iLr = (TbSettingTextTipView) this.iLk.findViewById(R.id.accountManager);
        this.iLr.setTopLineVisibility(true);
        this.iLs = (TbSettingTextTipView) this.iLk.findViewById(R.id.browseSetting);
        this.iLs.setBottomLineVisibility(true);
        this.iLt = (TbSettingTextTipView) this.iLk.findViewById(R.id.adSetting);
        this.iLt.setBottomLineVisibility(true);
        this.iLu = (TbSettingTextTipView) this.iLk.findViewById(R.id.messageSetting);
        this.iLu.setBottomLineVisibility(true);
        this.iLs.setBottomLineVisibility(true);
        this.iLv = (TbSettingTextTipView) this.iLk.findViewById(R.id.secretSetting);
        this.iLv.setBottomLineVisibility(true);
        this.iLw = (SettingTextVersionView) this.iLk.findViewById(R.id.versionInfo);
        this.iLx = (TbSettingTextTipView) this.iLk.findViewById(R.id.feedBack);
        this.iLx.setTopLineVisibility(true);
        this.iLx.setBottomLineVisibility(true);
        this.iLy = (TbSettingTextTipView) this.iLk.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iLy.setVisibility(8);
            this.iLy.setBottomLineVisibility(false);
        } else {
            this.iLy.setVisibility(0);
            this.iLy.setBottomLineVisibility(true);
        }
        this.iLz = (TbSettingTextNewDotView) this.iLk.findViewById(R.id.systemhelpsetting);
        this.iLA = (TextView) this.iLk.findViewById(R.id.quit);
        this.iLJ = (RelativeLayout) this.iLk.findViewById(R.id.eyeshield_mode);
        this.iLK = (BdSwitchView) this.iLk.findViewById(R.id.item_switch);
        l.b(this.iLk.getPageContext().getPageActivity(), this.iLK, 10, 10, 10, 10);
        this.iLE = this.iLk.findViewById(R.id.divide_view2);
        this.iLF = this.iLk.findViewById(R.id.divide_view1);
        this.iLG = this.iLk.findViewById(R.id.divide_view3);
        this.iLH = this.iLk.findViewById(R.id.divide_view4);
        this.iLI = this.iLk.findViewById(R.id.divide_view5);
        chI();
        chH();
        this.iLp.ciI();
        jT(TbadkCoreApplication.getInst().getSkinType());
        this.iLF.setVisibility(0);
        this.iLG.setVisibility(0);
        this.iLH.setVisibility(0);
        this.iLI.setVisibility(0);
        X(clickListener);
        if (!chK()) {
            this.iLs.setTip(this.iLk.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iLE.setVisibility(8);
            this.iLJ.setVisibility(8);
            return;
        }
        this.iLE.setVisibility(0);
        this.iLJ.setVisibility(0);
    }

    private boolean chK() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void Am() {
        this.iLn = new k(getPageContext().getPageActivity());
        this.iLn.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iLn);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iLk.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iLk.getLayoutMode().onModeChanged(this.iLn.afX());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.ayB();
                    e.this.iLl.zB(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.ayB();
            }
        };
        this.iLn.W(arrayList);
        this.iLn.a(cVar);
        this.iLn.a(aVar);
        this.iLm = new i(this.mContext);
        this.iLm.setCanceledOnTouchOutside(true);
        this.iLm.setContentView(this.iLn.afZ());
    }

    private void X(View.OnClickListener onClickListener) {
        this.iLo.setOnClickListener(onClickListener);
        this.iLD.setOnClickListener(onClickListener);
        this.iLp.setOnClickListener(onClickListener);
        this.iLq.setOnClickListener(onClickListener);
        this.iLr.setOnClickListener(onClickListener);
        this.iLs.setOnClickListener(onClickListener);
        this.iLt.setOnClickListener(onClickListener);
        this.iLu.setOnClickListener(onClickListener);
        this.iLv.setOnClickListener(onClickListener);
        this.iLw.setOnClickListener(onClickListener);
        this.iLx.setOnClickListener(onClickListener);
        this.iLy.setOnClickListener(onClickListener);
        this.iLz.setOnClickListener(onClickListener);
        this.iLA.setOnClickListener(onClickListener);
        this.iLK.setOnSwitchStateChangeListener(this.iLk);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iLD) {
                    e.this.iLl.zB(0);
                } else if (view == e.this.iLp) {
                    e.this.iLl.zB(1);
                } else if (view == e.this.iLq) {
                    e.this.iLl.zB(15);
                } else if (view == e.this.iLr) {
                    e.this.iLl.zB(2);
                } else if (view == e.this.iLs) {
                    e.this.iLl.zB(3);
                } else if (view == e.this.iLu) {
                    e.this.iLl.zB(4);
                } else if (view == e.this.iLv) {
                    e.this.iLl.zB(9);
                } else if (view == e.this.iLw) {
                    e.this.iLl.zB(6);
                } else if (view == e.this.iLx) {
                    e.this.iLl.zB(7);
                } else if (view == e.this.iLy) {
                    e.this.iLl.zB(8);
                } else if (view == e.this.iLz) {
                    e.this.iLl.zB(5);
                } else if (view == e.this.iLA) {
                    e.this.iLl.zB(10);
                } else if (view == e.this.iLo) {
                    e.this.iLl.zB(13);
                } else if (view == e.this.iLt) {
                    e.this.iLl.zB(16);
                }
            }
        };
    }

    public void chL() {
        if (this.iLm == null) {
            Am();
        }
        this.iLm.showDialog();
    }

    public void ayB() {
        if (this.iLm != null) {
            this.iLm.dismiss();
        }
    }

    public BdSwitchView chM() {
        return this.iLK;
    }
}
