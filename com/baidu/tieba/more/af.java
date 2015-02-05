package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.g<MoreActivity> {
    private MoreActivity bvX;
    private q bvY;
    private AlertDialog bvZ;
    private SettingTextImageView bwa;
    private TbSettingTextTipView bwb;
    private TbSettingTextTipView bwc;
    private TbSettingTextTipView bwd;
    private TbSettingTextTipView bwe;
    private SettingTextVersionView bwf;
    private TbSettingTextTipView bwg;
    private TbSettingTextTipView bwh;
    private View bwi;
    private TbSettingTextNewDotView bwj;
    private TbSettingTextTipView bwk;
    private RelativeLayout bwl;
    private View bwm;
    private NavigationBar mNavigationBar;

    public af(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.bvX = moreActivity;
        this.bvY = qVar;
        this.bvX.setContentView(com.baidu.tieba.x.more_activity);
        tO();
    }

    public void VG() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bwa.setVisibility(8);
        } else {
            this.bwa.setVisibility(0);
        }
    }

    public void u(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.bwa != null) {
                this.bwa.Wn();
                return;
            }
            return;
        }
        this.bwa.Wo();
        this.bwa.v(str, z);
    }

    public void refreshNewVersion() {
        if (this.bwf != null) {
            this.bwf.refresh();
        }
        if (this.bwj != null) {
            this.bwj.refresh();
        }
    }

    public void RH() {
        this.bwb.recycle();
        this.bwc.recycle();
        this.bwd.recycle();
        this.bwe.recycle();
        this.bwf.recycle();
        this.bwg.recycle();
        this.bwh.recycle();
        this.bwk.recycle();
    }

    public void onChangeSkinType(int i) {
        da(i);
    }

    public void da(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bwa.da(i);
        this.bvX.getLayoutMode().ab(i == 1);
        this.bvX.getLayoutMode().h(this.bwl);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void tO() {
        View.OnClickListener VH = VH();
        this.bwl = (RelativeLayout) this.bvX.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.bvX.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.bwm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvX.getPageContext().getString(com.baidu.tieba.z.setup));
        this.bwa = (SettingTextImageView) this.bvX.findViewById(com.baidu.tieba.w.personInfo);
        this.bwb = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.accountManager);
        this.bwc = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.browseSetting);
        this.bwd = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.messageSetting);
        this.bwe = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.secretSetting);
        this.bwf = (SettingTextVersionView) this.bvX.findViewById(com.baidu.tieba.w.versionInfo);
        this.bwg = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.feedBack);
        this.bwh = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.recommend);
        this.bwi = this.bvX.findViewById(com.baidu.tieba.w.line_recommend_layout);
        if (!TbadkCoreApplication.m255getInst().getIsAppOn()) {
            this.bwh.setVisibility(8);
            this.bwi.setVisibility(8);
        } else {
            this.bwh.setVisibility(0);
            this.bwi.setVisibility(0);
        }
        this.bwj = (TbSettingTextNewDotView) this.bvX.findViewById(com.baidu.tieba.w.systemhelpsetting);
        this.bwk = (TbSettingTextTipView) this.bvX.findViewById(com.baidu.tieba.w.quit);
        refreshNewVersion();
        VG();
        this.bwa.Wn();
        da(TbadkCoreApplication.m255getInst().getSkinType());
        x(VH);
        Oy();
    }

    private void Oy() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bvX.getPageContext().getPageActivity(), com.baidu.tieba.x.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_close_ll)).setOnClickListener(new ag(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_quit_ll)).setOnClickListener(new ah(this));
        this.bvZ = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.bvZ.setView(inflate, 0, 0, 0, 0);
    }

    private void x(View.OnClickListener onClickListener) {
        this.bwm.setOnClickListener(onClickListener);
        this.bwa.setOnClickListener(onClickListener);
        this.bwb.setOnClickListener(onClickListener);
        this.bwc.setOnClickListener(onClickListener);
        this.bwd.setOnClickListener(onClickListener);
        this.bwe.setOnClickListener(onClickListener);
        this.bwf.setOnClickListener(onClickListener);
        this.bwg.setOnClickListener(onClickListener);
        this.bwh.setOnClickListener(onClickListener);
        this.bwj.setOnClickListener(onClickListener);
        this.bwk.setOnClickListener(onClickListener);
    }

    private View.OnClickListener VH() {
        return new ai(this);
    }

    public void VI() {
        if (this.bvZ != null) {
            com.baidu.adp.lib.g.k.a(this.bvZ, this.bvX.getPageContext());
        }
    }
}
