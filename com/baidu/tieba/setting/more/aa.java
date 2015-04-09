package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.g<MoreActivity> {
    private View bNY;
    private MoreActivity caX;
    private q caY;
    private AlertDialog caZ;
    private SettingTextImageView cba;
    private TbSettingTextTipView cbb;
    private TbSettingTextTipView cbc;
    private TbSettingTextTipView cbd;
    private TbSettingTextTipView cbe;
    private SettingTextVersionView cbf;
    private TbSettingTextTipView cbg;
    private TbSettingTextTipView cbh;
    private View cbi;
    private TbSettingTextNewDotView cbj;
    private TextView cbk;
    private RelativeLayout cbl;
    private NavigationBar mNavigationBar;

    public aa(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.caX = moreActivity;
        this.caY = qVar;
        this.caX.setContentView(com.baidu.tieba.w.more_activity);
        xo();
    }

    public void ahf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cba.setVisibility(8);
        } else {
            this.cba.setVisibility(0);
        }
    }

    public void B(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cba != null) {
                this.cba.aia();
                return;
            }
            return;
        }
        this.cba.aib();
        this.cba.C(str, z);
    }

    public void refreshNewVersion() {
        if (this.cbf != null) {
            this.cbf.refresh();
        }
        if (this.cbj != null) {
            this.cbj.refresh();
        }
    }

    public void agu() {
        this.cba.recycle();
        this.cbb.recycle();
        this.cbc.recycle();
        this.cbd.recycle();
        this.cbe.recycle();
        this.cbf.recycle();
        this.cbg.recycle();
        this.cbh.recycle();
    }

    public void onChangeSkinType(int i) {
        dc(i);
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.j(this.cbl, com.baidu.tieba.s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cba.dc(i);
        this.caX.getLayoutMode().X(i == 1);
        this.caX.getLayoutMode().h(this.cbl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void xo() {
        View.OnClickListener ahh = ahh();
        this.cbl = (RelativeLayout) this.caX.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.caX.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bNY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.caX.getPageContext().getString(com.baidu.tieba.y.setup));
        this.cba = (SettingTextImageView) this.caX.findViewById(com.baidu.tieba.v.personInfo);
        this.cbb = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.accountManager);
        this.cbc = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.browseSetting);
        this.cbd = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.messageSetting);
        this.cbe = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.secretSetting);
        this.cbf = (SettingTextVersionView) this.caX.findViewById(com.baidu.tieba.v.versionInfo);
        this.cbg = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.feedBack);
        this.cbh = (TbSettingTextTipView) this.caX.findViewById(com.baidu.tieba.v.recommend);
        this.cbi = this.caX.findViewById(com.baidu.tieba.v.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cbh.setVisibility(8);
            this.cbi.setVisibility(8);
        } else {
            this.cbh.setVisibility(0);
            this.cbi.setVisibility(0);
        }
        this.cbj = (TbSettingTextNewDotView) this.caX.findViewById(com.baidu.tieba.v.systemhelpsetting);
        this.cbk = (TextView) this.caX.findViewById(com.baidu.tieba.v.quit);
        refreshNewVersion();
        ahf();
        this.cba.aia();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        A(ahh);
        ahg();
        if (!KF()) {
            this.cbc.setTip(this.caX.getResources().getString(com.baidu.tieba.y.browsing_settings_tip_no_night));
        }
    }

    private boolean KF() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void ahg() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.caX.getPageContext().getPageActivity(), com.baidu.tieba.w.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_close_ll)).setOnClickListener(new ab(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_quit_ll)).setOnClickListener(new ac(this));
        this.caZ = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.caZ.setView(inflate, 0, 0, 0, 0);
    }

    private void A(View.OnClickListener onClickListener) {
        this.bNY.setOnClickListener(onClickListener);
        this.cba.setOnClickListener(onClickListener);
        this.cbb.setOnClickListener(onClickListener);
        this.cbc.setOnClickListener(onClickListener);
        this.cbd.setOnClickListener(onClickListener);
        this.cbe.setOnClickListener(onClickListener);
        this.cbf.setOnClickListener(onClickListener);
        this.cbg.setOnClickListener(onClickListener);
        this.cbh.setOnClickListener(onClickListener);
        this.cbj.setOnClickListener(onClickListener);
        this.cbk.setOnClickListener(onClickListener);
    }

    private View.OnClickListener ahh() {
        return new ad(this);
    }

    public void ahi() {
        if (this.caZ != null) {
            com.baidu.adp.lib.g.k.a(this.caZ, this.caX.getPageContext());
        }
    }
}
