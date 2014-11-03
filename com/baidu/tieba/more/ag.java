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
    private TbSettingTextTipView brA;
    private RelativeLayout brB;
    private View brC;
    private r bro;
    private AlertDialog brp;
    private SettingTextImageView brq;
    private TbSettingTextTipView brr;
    private TbSettingTextTipView brs;
    private TbSettingTextTipView brt;
    private TbSettingTextTipView bru;
    private SettingTextVersionView brv;
    private TbSettingTextTipView brw;
    private TbSettingTextTipView brx;
    private View bry;
    private TbSettingTextNewDotView brz;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public ag(BaseActivity baseActivity, r rVar) {
        super(baseActivity);
        this.mActivity = baseActivity;
        this.bro = rVar;
        this.mActivity.setContentView(com.baidu.tieba.w.more_activity);
        qk();
    }

    public void Va() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.brq.setVisibility(8);
        } else {
            this.brq.setVisibility(0);
        }
    }

    public void w(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.brq != null) {
                this.brq.Vw();
                return;
            }
            return;
        }
        this.brq.Vx();
        this.brq.x(str, z);
    }

    public void refreshNewVersion() {
        if (this.brv != null) {
            this.brv.refresh();
        }
        if (this.brz != null) {
            this.brz.refresh();
        }
    }

    public void QR() {
        this.brq.recycle();
        this.brr.recycle();
        this.brs.recycle();
        this.brt.recycle();
        this.bru.recycle();
        this.brv.recycle();
        this.brw.recycle();
        this.brx.recycle();
        this.brA.recycle();
    }

    public void onChangeSkinType(int i) {
        cu(i);
    }

    public void cu(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.brq.cu(i);
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.brB);
        this.mNavigationBar.onChangeSkinType(i);
        refreshNewVersion();
    }

    private void qk() {
        View.OnClickListener Vb = Vb();
        this.brB = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.brC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.setup));
        this.brq = (SettingTextImageView) this.mActivity.findViewById(com.baidu.tieba.v.personInfo);
        this.brr = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.accountManager);
        this.brs = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.browseSetting);
        this.brt = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.messageSetting);
        this.bru = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.secretSetting);
        this.brv = (SettingTextVersionView) this.mActivity.findViewById(com.baidu.tieba.v.versionInfo);
        this.brw = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.feedBack);
        this.brx = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.recommend);
        this.bry = this.mActivity.findViewById(com.baidu.tieba.v.line_recommend_layout);
        if (!com.baidu.tieba.aj.wm().wx()) {
            this.brx.setVisibility(8);
            this.bry.setVisibility(8);
        } else {
            this.brx.setVisibility(0);
            this.bry.setVisibility(0);
        }
        this.brz = (TbSettingTextNewDotView) this.mActivity.findViewById(com.baidu.tieba.v.systemhelpsetting);
        this.brA = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.quit);
        refreshNewVersion();
        Va();
        this.brq.Vw();
        cu(TbadkApplication.m251getInst().getSkinType());
        r(Vb);
        MX();
    }

    private void MX() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_close_ll)).setOnClickListener(new ah(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_quit_ll)).setOnClickListener(new ai(this));
        this.brp = new AlertDialog.Builder(this.mContext).create();
        this.brp.setView(inflate, 0, 0, 0, 0);
    }

    private void r(View.OnClickListener onClickListener) {
        this.brC.setOnClickListener(onClickListener);
        this.brq.setOnClickListener(onClickListener);
        this.brr.setOnClickListener(onClickListener);
        this.brs.setOnClickListener(onClickListener);
        this.brt.setOnClickListener(onClickListener);
        this.bru.setOnClickListener(onClickListener);
        this.brv.setOnClickListener(onClickListener);
        this.brw.setOnClickListener(onClickListener);
        this.brx.setOnClickListener(onClickListener);
        this.brz.setOnClickListener(onClickListener);
        this.brA.setOnClickListener(onClickListener);
    }

    private View.OnClickListener Vb() {
        return new aj(this);
    }

    public void Vc() {
        if (this.brp != null) {
            com.baidu.adp.lib.g.j.a(this.brp, this.mActivity);
        }
    }
}
