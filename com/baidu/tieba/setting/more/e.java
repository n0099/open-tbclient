package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e extends com.baidu.adp.base.c<MoreActivity> {
    private MoreActivity haV;
    private d haW;
    private AlertDialog haX;
    private View haY;
    private TbSettingTextTipView haZ;
    private SettingTextImageView hba;
    private TbSettingTextTipView hbb;
    private TbSettingTextTipView hbc;
    private TbSettingTextTipView hbd;
    private TbSettingTextTipView hbe;
    private TbSettingTextTipView hbf;
    private TbSettingTextTipView hbg;
    private SettingTextVersionView hbh;
    private TbSettingTextTipView hbi;
    private TbSettingTextTipView hbj;
    private TbSettingTextNewDotView hbk;
    private TextView hbl;
    private RelativeLayout hbm;
    private View hbn;
    private View hbo;
    private View hbp;
    private View hbq;
    private View hbr;
    private View hbs;
    private View hbt;
    private RelativeLayout hbu;
    private BdSwitchView hbv;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.hbp = null;
        this.hbq = null;
        this.hbr = null;
        this.hbs = null;
        this.hbt = null;
        this.hbu = null;
        this.hbv = null;
        this.haV = moreActivity;
        this.haW = dVar;
        this.haV.setContentView(e.h.more_activity);
        KN();
        byP();
    }

    public void byN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.hba.setVisibility(8);
        } else {
            this.hba.setVisibility(0);
        }
    }

    public void ab(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.hba != null) {
                this.hba.bzO();
                return;
            }
            return;
        }
        this.hba.bzP();
        this.hba.setIcon(str, z);
    }

    public void byO() {
        if (this.hbh != null) {
            this.hbh.refresh();
        }
        if (this.hbk != null) {
            this.hbk.refresh();
        }
    }

    public void byP() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.hbv.nV();
        } else {
            this.hbv.nW();
        }
    }

    public void uO(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new am("c10647").aB("obj_type", "1").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new am("c10647").aB("obj_type", "0").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void bxR() {
        this.hba.recycle();
        this.hbb.recycle();
        this.hbc.recycle();
        this.hbd.recycle();
        this.hbf.recycle();
        this.hbg.recycle();
        this.hbh.recycle();
        this.hbi.recycle();
        this.hbj.recycle();
    }

    public void onChangeSkinType(int i) {
        fv(i);
        if (this.haY != null) {
            this.haV.getLayoutMode().setNightMode(i == 1);
            this.haV.getLayoutMode().onModeChanged(this.haY);
        }
    }

    public void fv(int i) {
        al.j(this.hbm, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hba.fv(i);
        this.haV.getLayoutMode().setNightMode(i == 1);
        this.haV.getLayoutMode().onModeChanged(this.hbm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        byO();
        this.hbv.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this.hbn, e.d.cp_bg_line_d);
    }

    private void KN() {
        View.OnClickListener clickListener = getClickListener();
        this.hbm = (RelativeLayout) this.haV.findViewById(e.g.parent);
        this.hbn = this.haV.findViewById(e.g.scroll);
        this.haV.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.haV.findViewById(e.g.view_navigation_bar);
        this.hbo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.haV.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.haZ = (TbSettingTextTipView) this.haV.findViewById(e.g.accountSafeSetting);
        this.hba = (SettingTextImageView) this.haV.findViewById(e.g.personInfo);
        this.hbb = (TbSettingTextTipView) this.haV.findViewById(e.g.interest_label_setting);
        this.hbb.setTopLineVisibility(true);
        this.hbc = (TbSettingTextTipView) this.haV.findViewById(e.g.accountManager);
        this.hbc.setTopLineVisibility(true);
        this.hbd = (TbSettingTextTipView) this.haV.findViewById(e.g.browseSetting);
        this.hbd.setBottomLineVisibility(true);
        this.hbe = (TbSettingTextTipView) this.haV.findViewById(e.g.adSetting);
        this.hbe.setBottomLineVisibility(true);
        this.hbf = (TbSettingTextTipView) this.haV.findViewById(e.g.messageSetting);
        this.hbf.setBottomLineVisibility(true);
        this.hbd.setBottomLineVisibility(true);
        this.hbg = (TbSettingTextTipView) this.haV.findViewById(e.g.secretSetting);
        this.hbg.setBottomLineVisibility(true);
        this.hbh = (SettingTextVersionView) this.haV.findViewById(e.g.versionInfo);
        this.hbi = (TbSettingTextTipView) this.haV.findViewById(e.g.feedBack);
        this.hbi.setTopLineVisibility(true);
        this.hbi.setBottomLineVisibility(true);
        this.hbj = (TbSettingTextTipView) this.haV.findViewById(e.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.hbj.setVisibility(8);
            this.hbj.setBottomLineVisibility(false);
        } else {
            this.hbj.setVisibility(0);
            this.hbj.setBottomLineVisibility(true);
        }
        this.hbk = (TbSettingTextNewDotView) this.haV.findViewById(e.g.systemhelpsetting);
        this.hbl = (TextView) this.haV.findViewById(e.g.quit);
        this.hbu = (RelativeLayout) this.haV.findViewById(e.g.eyeshield_mode);
        this.hbv = (BdSwitchView) this.haV.findViewById(e.g.item_switch);
        l.b(this.haV.getPageContext().getPageActivity(), this.hbv, 10, 10, 10, 10);
        this.hbp = this.haV.findViewById(e.g.divide_view2);
        this.hbq = this.haV.findViewById(e.g.divide_view1);
        this.hbr = this.haV.findViewById(e.g.divide_view3);
        this.hbs = this.haV.findViewById(e.g.divide_view4);
        this.hbt = this.haV.findViewById(e.g.divide_view5);
        byO();
        byN();
        this.hba.bzO();
        fv(TbadkCoreApplication.getInst().getSkinType());
        this.hbq.setVisibility(0);
        this.hbr.setVisibility(0);
        this.hbs.setVisibility(0);
        this.hbt.setVisibility(0);
        U(clickListener);
        if (!byQ()) {
            this.hbd.setTip(this.haV.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.hbp.setVisibility(8);
            this.hbu.setVisibility(8);
            return;
        }
        this.hbp.setVisibility(0);
        this.hbu.setVisibility(0);
    }

    private boolean byQ() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.haY = LayoutInflater.from(this.haV.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.haV.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.haV.getLayoutMode().onModeChanged(this.haY);
        ((TextView) this.haY.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Tz();
                e.this.haW.uJ(11);
            }
        });
        ((TextView) this.haY.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Tz();
                e.this.haW.uJ(12);
            }
        });
        this.haX = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.haX.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.haX, this.mContext.getPageActivity());
        if (this.haX.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.haX.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.haX.getWindow().setAttributes(attributes);
            this.haX.getWindow().setContentView(this.haY);
        }
    }

    private void U(View.OnClickListener onClickListener) {
        this.haZ.setOnClickListener(onClickListener);
        this.hbo.setOnClickListener(onClickListener);
        this.hba.setOnClickListener(onClickListener);
        this.hbb.setOnClickListener(onClickListener);
        this.hbc.setOnClickListener(onClickListener);
        this.hbd.setOnClickListener(onClickListener);
        this.hbe.setOnClickListener(onClickListener);
        this.hbf.setOnClickListener(onClickListener);
        this.hbg.setOnClickListener(onClickListener);
        this.hbh.setOnClickListener(onClickListener);
        this.hbi.setOnClickListener(onClickListener);
        this.hbj.setOnClickListener(onClickListener);
        this.hbk.setOnClickListener(onClickListener);
        this.hbl.setOnClickListener(onClickListener);
        this.hbv.setOnSwitchStateChangeListener(this.haV);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.hbo) {
                    e.this.haW.uJ(0);
                } else if (view == e.this.hba) {
                    e.this.haW.uJ(1);
                } else if (view == e.this.hbb) {
                    e.this.haW.uJ(15);
                } else if (view == e.this.hbc) {
                    e.this.haW.uJ(2);
                } else if (view == e.this.hbd) {
                    e.this.haW.uJ(3);
                } else if (view == e.this.hbf) {
                    e.this.haW.uJ(4);
                } else if (view == e.this.hbg) {
                    e.this.haW.uJ(9);
                } else if (view == e.this.hbh) {
                    e.this.haW.uJ(6);
                } else if (view == e.this.hbi) {
                    e.this.haW.uJ(7);
                } else if (view == e.this.hbj) {
                    e.this.haW.uJ(8);
                } else if (view == e.this.hbk) {
                    e.this.haW.uJ(5);
                } else if (view == e.this.hbl) {
                    e.this.haW.uJ(10);
                } else if (view == e.this.haZ) {
                    e.this.haW.uJ(13);
                } else if (view == e.this.hbe) {
                    e.this.haW.uJ(16);
                }
            }
        };
    }

    public void byR() {
        if (this.haX == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.haX, this.haV.getPageContext());
    }

    public void Tz() {
        if (this.haX != null) {
            com.baidu.adp.lib.g.g.b(this.haX, this.haV.getPageContext());
        }
    }

    public BdSwitchView byS() {
        return this.hbv;
    }
}
