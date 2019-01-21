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
    private MoreActivity haW;
    private d haX;
    private AlertDialog haY;
    private View haZ;
    private TbSettingTextTipView hba;
    private SettingTextImageView hbb;
    private TbSettingTextTipView hbc;
    private TbSettingTextTipView hbd;
    private TbSettingTextTipView hbe;
    private TbSettingTextTipView hbf;
    private TbSettingTextTipView hbg;
    private TbSettingTextTipView hbh;
    private SettingTextVersionView hbi;
    private TbSettingTextTipView hbj;
    private TbSettingTextTipView hbk;
    private TbSettingTextNewDotView hbl;
    private TextView hbm;
    private RelativeLayout hbn;
    private View hbo;
    private View hbp;
    private View hbq;
    private View hbr;
    private View hbs;
    private View hbt;
    private View hbu;
    private RelativeLayout hbv;
    private BdSwitchView hbw;
    private NavigationBar mNavigationBar;

    public e(MoreActivity moreActivity, d dVar) {
        super(moreActivity.getPageContext());
        this.hbq = null;
        this.hbr = null;
        this.hbs = null;
        this.hbt = null;
        this.hbu = null;
        this.hbv = null;
        this.hbw = null;
        this.haW = moreActivity;
        this.haX = dVar;
        this.haW.setContentView(e.h.more_activity);
        KN();
        byP();
    }

    public void byN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.hbb.setVisibility(8);
        } else {
            this.hbb.setVisibility(0);
        }
    }

    public void ab(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.hbb != null) {
                this.hbb.bzO();
                return;
            }
            return;
        }
        this.hbb.bzP();
        this.hbb.setIcon(str, z);
    }

    public void byO() {
        if (this.hbi != null) {
            this.hbi.refresh();
        }
        if (this.hbl != null) {
            this.hbl.refresh();
        }
    }

    public void byP() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.hbw.nV();
        } else {
            this.hbw.nW();
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
        this.hbb.recycle();
        this.hbc.recycle();
        this.hbd.recycle();
        this.hbe.recycle();
        this.hbg.recycle();
        this.hbh.recycle();
        this.hbi.recycle();
        this.hbj.recycle();
        this.hbk.recycle();
    }

    public void onChangeSkinType(int i) {
        fv(i);
        if (this.haZ != null) {
            this.haW.getLayoutMode().setNightMode(i == 1);
            this.haW.getLayoutMode().onModeChanged(this.haZ);
        }
    }

    public void fv(int i) {
        al.j(this.hbn, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hbb.fv(i);
        this.haW.getLayoutMode().setNightMode(i == 1);
        this.haW.getLayoutMode().onModeChanged(this.hbn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        byO();
        this.hbw.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        al.j(this.hbo, e.d.cp_bg_line_d);
    }

    private void KN() {
        View.OnClickListener clickListener = getClickListener();
        this.hbn = (RelativeLayout) this.haW.findViewById(e.g.parent);
        this.hbo = this.haW.findViewById(e.g.scroll);
        this.haW.findViewById(e.g.head_top_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) this.haW.findViewById(e.g.view_navigation_bar);
        this.hbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.haW.getPageContext().getString(e.j.setup));
        this.mNavigationBar.showBottomLine();
        this.hba = (TbSettingTextTipView) this.haW.findViewById(e.g.accountSafeSetting);
        this.hbb = (SettingTextImageView) this.haW.findViewById(e.g.personInfo);
        this.hbc = (TbSettingTextTipView) this.haW.findViewById(e.g.interest_label_setting);
        this.hbc.setTopLineVisibility(true);
        this.hbd = (TbSettingTextTipView) this.haW.findViewById(e.g.accountManager);
        this.hbd.setTopLineVisibility(true);
        this.hbe = (TbSettingTextTipView) this.haW.findViewById(e.g.browseSetting);
        this.hbe.setBottomLineVisibility(true);
        this.hbf = (TbSettingTextTipView) this.haW.findViewById(e.g.adSetting);
        this.hbf.setBottomLineVisibility(true);
        this.hbg = (TbSettingTextTipView) this.haW.findViewById(e.g.messageSetting);
        this.hbg.setBottomLineVisibility(true);
        this.hbe.setBottomLineVisibility(true);
        this.hbh = (TbSettingTextTipView) this.haW.findViewById(e.g.secretSetting);
        this.hbh.setBottomLineVisibility(true);
        this.hbi = (SettingTextVersionView) this.haW.findViewById(e.g.versionInfo);
        this.hbj = (TbSettingTextTipView) this.haW.findViewById(e.g.feedBack);
        this.hbj.setTopLineVisibility(true);
        this.hbj.setBottomLineVisibility(true);
        this.hbk = (TbSettingTextTipView) this.haW.findViewById(e.g.recommend);
        if (!TbadkCoreApplication.getInst().getIsAppOn()) {
            this.hbk.setVisibility(8);
            this.hbk.setBottomLineVisibility(false);
        } else {
            this.hbk.setVisibility(0);
            this.hbk.setBottomLineVisibility(true);
        }
        this.hbl = (TbSettingTextNewDotView) this.haW.findViewById(e.g.systemhelpsetting);
        this.hbm = (TextView) this.haW.findViewById(e.g.quit);
        this.hbv = (RelativeLayout) this.haW.findViewById(e.g.eyeshield_mode);
        this.hbw = (BdSwitchView) this.haW.findViewById(e.g.item_switch);
        l.b(this.haW.getPageContext().getPageActivity(), this.hbw, 10, 10, 10, 10);
        this.hbq = this.haW.findViewById(e.g.divide_view2);
        this.hbr = this.haW.findViewById(e.g.divide_view1);
        this.hbs = this.haW.findViewById(e.g.divide_view3);
        this.hbt = this.haW.findViewById(e.g.divide_view4);
        this.hbu = this.haW.findViewById(e.g.divide_view5);
        byO();
        byN();
        this.hbb.bzO();
        fv(TbadkCoreApplication.getInst().getSkinType());
        this.hbr.setVisibility(0);
        this.hbs.setVisibility(0);
        this.hbt.setVisibility(0);
        this.hbu.setVisibility(0);
        U(clickListener);
        if (!byQ()) {
            this.hbe.setTip(this.haW.getResources().getString(e.j.browsing_settings_tip_no_night));
            this.hbq.setVisibility(8);
            this.hbv.setVisibility(8);
            return;
        }
        this.hbq.setVisibility(0);
        this.hbv.setVisibility(0);
    }

    private boolean byQ() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void createDialog() {
        this.haZ = LayoutInflater.from(this.haW.getPageContext().getPageActivity()).inflate(e.h.quit_dialog, (ViewGroup) null);
        this.haW.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.haW.getLayoutMode().onModeChanged(this.haZ);
        ((TextView) this.haZ.findViewById(e.g.id_close_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Tz();
                e.this.haX.uJ(11);
            }
        });
        ((TextView) this.haZ.findViewById(e.g.id_quit_tv)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.Tz();
                e.this.haX.uJ(12);
            }
        });
        this.haY = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.haY.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.g.a(this.haY, this.mContext.getPageActivity());
        if (this.haY.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.haY.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.haY.getWindow().setAttributes(attributes);
            this.haY.getWindow().setContentView(this.haZ);
        }
    }

    private void U(View.OnClickListener onClickListener) {
        this.hba.setOnClickListener(onClickListener);
        this.hbp.setOnClickListener(onClickListener);
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
        this.hbm.setOnClickListener(onClickListener);
        this.hbw.setOnSwitchStateChangeListener(this.haW);
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == e.this.hbp) {
                    e.this.haX.uJ(0);
                } else if (view == e.this.hbb) {
                    e.this.haX.uJ(1);
                } else if (view == e.this.hbc) {
                    e.this.haX.uJ(15);
                } else if (view == e.this.hbd) {
                    e.this.haX.uJ(2);
                } else if (view == e.this.hbe) {
                    e.this.haX.uJ(3);
                } else if (view == e.this.hbg) {
                    e.this.haX.uJ(4);
                } else if (view == e.this.hbh) {
                    e.this.haX.uJ(9);
                } else if (view == e.this.hbi) {
                    e.this.haX.uJ(6);
                } else if (view == e.this.hbj) {
                    e.this.haX.uJ(7);
                } else if (view == e.this.hbk) {
                    e.this.haX.uJ(8);
                } else if (view == e.this.hbl) {
                    e.this.haX.uJ(5);
                } else if (view == e.this.hbm) {
                    e.this.haX.uJ(10);
                } else if (view == e.this.hba) {
                    e.this.haX.uJ(13);
                } else if (view == e.this.hbf) {
                    e.this.haX.uJ(16);
                }
            }
        };
    }

    public void byR() {
        if (this.haY == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.g.a(this.haY, this.haW.getPageContext());
    }

    public void Tz() {
        if (this.haY != null) {
            com.baidu.adp.lib.g.g.b(this.haY, this.haW.getPageContext());
        }
    }

    public BdSwitchView byS() {
        return this.hbw;
    }
}
