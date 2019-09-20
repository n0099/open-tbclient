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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private RelativeLayout iVA;
    private BdSwitchView iVB;
    private MoreActivity iVb;
    private d iVc;
    private i iVd;
    private k iVe;
    private SettingTextNormalImageView iVf;
    private SettingTextImageView iVg;
    private TbSettingTextTipView iVh;
    private TbSettingTextTipView iVi;
    private TbSettingTextTipView iVj;
    private TbSettingTextTipView iVk;
    private TbSettingTextTipView iVl;
    private TbSettingTextTipView iVm;
    private SettingTextVersionView iVn;
    private TbSettingTextTipView iVo;
    private TbSettingTextTipView iVp;
    private TbSettingTextNewDotView iVq;
    private TextView iVr;
    private RelativeLayout iVs;
    private View iVt;
    private View iVu;
    private View iVv;
    private View iVw;
    private View iVx;
    private View iVy;
    private View iVz;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.iVv = null;
        this.iVw = null;
        this.iVx = null;
        this.iVy = null;
        this.iVz = null;
        this.iVA = null;
        this.iVB = null;
        this.iVb = moreActivity;
        this.iVc = dVar;
        this.iVb.setContentView(R.layout.more_activity);
        aqJ();
        clE();
    }

    public void clC() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iVg.setVisibility(8);
        } else {
            this.iVg.setVisibility(0);
        }
    }

    public void az(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.iVg != null) {
                this.iVg.cmE();
                return;
            }
            return;
        }
        this.iVg.cmF();
        this.iVg.setIcon(str, z);
    }

    public void clD() {
        if (this.iVn != null) {
            this.iVn.refresh();
        }
        if (this.iVq != null) {
            this.iVq.refresh();
        }
    }

    public void clE() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.iVB.nm();
        } else {
            this.iVB.nn();
        }
    }

    public void Ar(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != i) {
            if (i == 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new an("c10647").bT("obj_type", "1").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else if (i == 0 || i == 4) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new an("c10647").bT("obj_type", "0").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            }
            BitmapHelper.clearCashBitmap();
        }
    }

    public void ckH() {
        this.iVg.recycle();
        this.iVh.recycle();
        this.iVi.recycle();
        this.iVj.recycle();
        this.iVl.recycle();
        this.iVm.recycle();
        this.iVn.recycle();
        this.iVo.recycle();
        this.iVp.recycle();
    }

    public void onChangeSkinType(int i) {
        kd(i);
        if (this.iVe != null) {
            this.iVb.getLayoutMode().setNightMode(i == 1);
            this.iVb.getLayoutMode().onModeChanged(this.iVe.ahf());
        }
        if (i == 1) {
            this.iVB.nk();
        } else {
            this.iVB.nl();
        }
    }

    public void kd(int i) {
        am.l(this.iVs, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iVg.kd(i);
        this.iVb.getLayoutMode().setNightMode(i == 1);
        this.iVb.getLayoutMode().onModeChanged(this.iVs);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        clD();
        this.iVB.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        am.l(this.iVt, R.color.cp_bg_line_d);
        this.iVf.setLocalIcon(am.in(R.drawable.icon_mine_list_baidu));
        if (this.iVe != null) {
            this.iVe.onChangeSkinType();
        }
    }

    private void aqJ() {
        View.OnClickListener clickListener = getClickListener();
        this.iVs = (RelativeLayout) this.iVb.findViewById(R.id.parent);
        this.iVt = this.iVb.findViewById(R.id.scroll);
        this.iVb.findViewById(R.id.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.iVb.findViewById(R.id.view_navigation_bar);
        this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.iVb.getPageContext().getString(R.string.setup));
        this.mNavigationBar.showBottomLine();
        this.iVf = (SettingTextNormalImageView) this.iVb.findViewById(R.id.accountSafeSetting);
        this.iVg = (SettingTextImageView) this.iVb.findViewById(R.id.personInfo);
        this.iVh = (TbSettingTextTipView) this.iVb.findViewById(R.id.interest_label_setting);
        this.iVh.setTopLineVisibility(true);
        this.iVi = (TbSettingTextTipView) this.iVb.findViewById(R.id.accountManager);
        this.iVi.setTopLineVisibility(true);
        this.iVj = (TbSettingTextTipView) this.iVb.findViewById(R.id.browseSetting);
        this.iVj.setBottomLineVisibility(true);
        this.iVk = (TbSettingTextTipView) this.iVb.findViewById(R.id.adSetting);
        this.iVk.setBottomLineVisibility(true);
        this.iVl = (TbSettingTextTipView) this.iVb.findViewById(R.id.messageSetting);
        this.iVl.setBottomLineVisibility(true);
        this.iVj.setBottomLineVisibility(true);
        this.iVm = (TbSettingTextTipView) this.iVb.findViewById(R.id.secretSetting);
        this.iVm.setBottomLineVisibility(true);
        this.iVn = (SettingTextVersionView) this.iVb.findViewById(R.id.versionInfo);
        this.iVo = (TbSettingTextTipView) this.iVb.findViewById(R.id.feedBack);
        this.iVo.setTopLineVisibility(true);
        this.iVo.setBottomLineVisibility(true);
        this.iVp = (TbSettingTextTipView) this.iVb.findViewById(R.id.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.iVp.setVisibility(8);
            this.iVp.setBottomLineVisibility(false);
        } else {
            this.iVp.setVisibility(0);
            this.iVp.setBottomLineVisibility(true);
        }
        this.iVq = (TbSettingTextNewDotView) this.iVb.findViewById(R.id.systemhelpsetting);
        this.iVr = (TextView) this.iVb.findViewById(R.id.quit);
        this.iVA = (RelativeLayout) this.iVb.findViewById(R.id.eyeshield_mode);
        this.iVB = (BdSwitchView) this.iVb.findViewById(R.id.item_switch);
        l.b(this.iVb.getPageContext().getPageActivity(), this.iVB, 10, 10, 10, 10);
        this.iVv = this.iVb.findViewById(R.id.divide_view2);
        this.iVw = this.iVb.findViewById(R.id.divide_view1);
        this.iVx = this.iVb.findViewById(R.id.divide_view3);
        this.iVy = this.iVb.findViewById(R.id.divide_view4);
        this.iVz = this.iVb.findViewById(R.id.divide_view5);
        clD();
        clC();
        this.iVg.cmE();
        kd(TbadkCoreApplication.getInst().getSkinType());
        this.iVw.setVisibility(0);
        this.iVx.setVisibility(0);
        this.iVy.setVisibility(0);
        this.iVz.setVisibility(0);
        Z(clickListener);
        if (!clF()) {
            this.iVj.setTip(this.iVb.getResources().getString(R.string.browsing_settings_tip_no_night));
            this.iVv.setVisibility(8);
            this.iVA.setVisibility(8);
            return;
        }
        this.iVv.setVisibility(0);
        this.iVA.setVisibility(0);
    }

    private boolean clF() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void AX() {
        this.iVe = new k(getPageContext().getPageActivity());
        this.iVe.setTitleText(getPageContext().getString(R.string.quit_account_tip));
        ArrayList arrayList = new ArrayList();
        final com.baidu.tbadk.core.dialog.g gVar = new com.baidu.tbadk.core.dialog.g(getPageContext().getString(R.string.quite_current_account), this.iVe);
        gVar.setTextColor(R.color.cp_cont_h);
        arrayList.add(gVar);
        this.iVb.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.iVb.getLayoutMode().onModeChanged(this.iVe.ahf());
        k.c cVar = new k.c() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (i == gVar.getId()) {
                    e.this.aAd();
                    e.this.iVc.Am(12);
                }
            }
        };
        k.a aVar = new k.a() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // com.baidu.tbadk.core.dialog.k.a
            public void onClick() {
                e.this.aAd();
            }
        };
        this.iVe.W(arrayList);
        this.iVe.a(cVar);
        this.iVe.a(aVar);
        this.iVd = new i(this.mContext);
        this.iVd.setCanceledOnTouchOutside(true);
        this.iVd.a(this.iVe);
    }

    private void Z(View.OnClickListener onClickListener) {
        this.iVf.setOnClickListener(onClickListener);
        this.iVu.setOnClickListener(onClickListener);
        this.iVg.setOnClickListener(onClickListener);
        this.iVh.setOnClickListener(onClickListener);
        this.iVi.setOnClickListener(onClickListener);
        this.iVj.setOnClickListener(onClickListener);
        this.iVk.setOnClickListener(onClickListener);
        this.iVl.setOnClickListener(onClickListener);
        this.iVm.setOnClickListener(onClickListener);
        this.iVn.setOnClickListener(onClickListener);
        this.iVo.setOnClickListener(onClickListener);
        this.iVp.setOnClickListener(onClickListener);
        this.iVq.setOnClickListener(onClickListener);
        this.iVr.setOnClickListener(onClickListener);
        this.iVB.setOnSwitchStateChangeListener(this.iVb);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.iVu) {
                    e.this.iVc.Am(0);
                } else if (view == e.this.iVg) {
                    e.this.iVc.Am(1);
                } else if (view == e.this.iVh) {
                    e.this.iVc.Am(15);
                } else if (view == e.this.iVi) {
                    e.this.iVc.Am(2);
                } else if (view == e.this.iVj) {
                    e.this.iVc.Am(3);
                } else if (view == e.this.iVl) {
                    e.this.iVc.Am(4);
                } else if (view == e.this.iVm) {
                    e.this.iVc.Am(9);
                } else if (view == e.this.iVn) {
                    e.this.iVc.Am(6);
                } else if (view == e.this.iVo) {
                    e.this.iVc.Am(7);
                } else if (view == e.this.iVp) {
                    e.this.iVc.Am(8);
                } else if (view == e.this.iVq) {
                    e.this.iVc.Am(5);
                } else if (view == e.this.iVr) {
                    e.this.iVc.Am(10);
                } else if (view == e.this.iVf) {
                    e.this.iVc.Am(13);
                } else if (view == e.this.iVk) {
                    e.this.iVc.Am(16);
                }
            }
        };
    }

    public void clG() {
        if (this.iVd == null) {
            AX();
        }
        this.iVd.showDialog();
    }

    public void aAd() {
        if (this.iVd != null) {
            this.iVd.dismiss();
        }
    }

    public BdSwitchView clH() {
        return this.iVB;
    }
}
