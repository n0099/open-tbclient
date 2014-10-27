package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f {
    private r bra;
    private AlertDialog brb;
    private SettingTextImageView brc;
    private TbSettingTextTipView brd;
    private TbSettingTextTipView bre;
    private TbSettingTextTipView brf;
    private TbSettingTextTipView brg;
    private SettingTextVersionView brh;
    private TbSettingTextTipView bri;
    private TbSettingTextTipView brj;
    private View brk;
    private TbSettingTextNewDotView brl;
    private TbSettingTextTipView brm;
    private RelativeLayout brn;
    private View bro;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public ag(BaseActivity baseActivity, r rVar) {
        super(baseActivity);
        this.mActivity = baseActivity;
        this.bra = rVar;
        this.mActivity.setContentView(com.baidu.tieba.w.more_activity);
        qi();
    }

    public void UX() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.brc.setVisibility(8);
        } else {
            this.brc.setVisibility(0);
        }
    }

    public void w(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.brc != null) {
                this.brc.Vt();
                return;
            }
            return;
        }
        this.brc.Vu();
        this.brc.x(str, z);
    }

    public void refreshNewVersion() {
        if (this.brh != null) {
            this.brh.refresh();
        }
        if (this.brl != null) {
            this.brl.refresh();
        }
    }

    public void QO() {
        this.brc.recycle();
        this.brd.recycle();
        this.bre.recycle();
        this.brf.recycle();
        this.brg.recycle();
        this.brh.recycle();
        this.bri.recycle();
        this.brj.recycle();
        this.brm.recycle();
    }

    public void onChangeSkinType(int i) {
        cu(i);
    }

    public void cu(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.brc.cu(i);
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.brn);
        this.mNavigationBar.onChangeSkinType(i);
        refreshNewVersion();
    }

    private void qi() {
        View.OnClickListener UY = UY();
        this.brn = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bro = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.setup));
        this.brc = (SettingTextImageView) this.mActivity.findViewById(com.baidu.tieba.v.personInfo);
        this.brd = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.accountManager);
        this.bre = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.browseSetting);
        this.brf = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.messageSetting);
        this.brg = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.secretSetting);
        this.brh = (SettingTextVersionView) this.mActivity.findViewById(com.baidu.tieba.v.versionInfo);
        this.bri = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.feedBack);
        this.brj = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.recommend);
        this.brk = this.mActivity.findViewById(com.baidu.tieba.v.line_recommend_layout);
        if (!com.baidu.tieba.aj.wk().wv()) {
            this.brj.setVisibility(8);
            this.brk.setVisibility(8);
        } else {
            this.brj.setVisibility(0);
            this.brk.setVisibility(0);
        }
        this.brl = (TbSettingTextNewDotView) this.mActivity.findViewById(com.baidu.tieba.v.systemhelpsetting);
        this.brm = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.quit);
        refreshNewVersion();
        UX();
        this.brc.Vt();
        cu(TbadkApplication.m251getInst().getSkinType());
        r(UY);
        MT();
    }

    private void MT() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_close_ll)).setOnClickListener(new ah(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_quit_ll)).setOnClickListener(new ai(this));
        this.brb = new AlertDialog.Builder(this.mContext).create();
        this.brb.setView(inflate, 0, 0, 0, 0);
    }

    private void r(View.OnClickListener onClickListener) {
        this.bro.setOnClickListener(onClickListener);
        this.brc.setOnClickListener(onClickListener);
        this.brd.setOnClickListener(onClickListener);
        this.bre.setOnClickListener(onClickListener);
        this.brf.setOnClickListener(onClickListener);
        this.brg.setOnClickListener(onClickListener);
        this.brh.setOnClickListener(onClickListener);
        this.bri.setOnClickListener(onClickListener);
        this.brj.setOnClickListener(onClickListener);
        this.brl.setOnClickListener(onClickListener);
        this.brm.setOnClickListener(onClickListener);
    }

    private View.OnClickListener UY() {
        return new aj(this);
    }

    public void UZ() {
        if (this.brb != null) {
            com.baidu.adp.lib.g.j.a(this.brb, this.mActivity);
        }
    }
}
