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
    private MoreActivity bvY;
    private q bvZ;
    private AlertDialog bwa;
    private SettingTextImageView bwb;
    private TbSettingTextTipView bwc;
    private TbSettingTextTipView bwd;
    private TbSettingTextTipView bwe;
    private TbSettingTextTipView bwf;
    private SettingTextVersionView bwg;
    private TbSettingTextTipView bwh;
    private TbSettingTextTipView bwi;
    private View bwj;
    private TbSettingTextNewDotView bwk;
    private TbSettingTextTipView bwl;
    private RelativeLayout bwm;
    private View bwn;
    private NavigationBar mNavigationBar;

    public af(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.bvY = moreActivity;
        this.bvZ = qVar;
        this.bvY.setContentView(com.baidu.tieba.x.more_activity);
        tU();
    }

    public void VL() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.bwb.setVisibility(8);
        } else {
            this.bwb.setVisibility(0);
        }
    }

    public void u(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.bwb != null) {
                this.bwb.Ws();
                return;
            }
            return;
        }
        this.bwb.Wt();
        this.bwb.v(str, z);
    }

    public void refreshNewVersion() {
        if (this.bwg != null) {
            this.bwg.refresh();
        }
        if (this.bwk != null) {
            this.bwk.refresh();
        }
    }

    public void RM() {
        this.bwc.recycle();
        this.bwd.recycle();
        this.bwe.recycle();
        this.bwf.recycle();
        this.bwg.recycle();
        this.bwh.recycle();
        this.bwi.recycle();
        this.bwl.recycle();
    }

    public void onChangeSkinType(int i) {
        da(i);
    }

    public void da(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bwb.da(i);
        this.bvY.getLayoutMode().ab(i == 1);
        this.bvY.getLayoutMode().h(this.bwm);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void tU() {
        View.OnClickListener VM = VM();
        this.bwm = (RelativeLayout) this.bvY.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.bvY.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.bwn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvY.getPageContext().getString(com.baidu.tieba.z.setup));
        this.bwb = (SettingTextImageView) this.bvY.findViewById(com.baidu.tieba.w.personInfo);
        this.bwc = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.accountManager);
        this.bwd = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.browseSetting);
        this.bwe = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.messageSetting);
        this.bwf = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.secretSetting);
        this.bwg = (SettingTextVersionView) this.bvY.findViewById(com.baidu.tieba.w.versionInfo);
        this.bwh = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.feedBack);
        this.bwi = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.recommend);
        this.bwj = this.bvY.findViewById(com.baidu.tieba.w.line_recommend_layout);
        if (!TbadkCoreApplication.m255getInst().getIsAppOn()) {
            this.bwi.setVisibility(8);
            this.bwj.setVisibility(8);
        } else {
            this.bwi.setVisibility(0);
            this.bwj.setVisibility(0);
        }
        this.bwk = (TbSettingTextNewDotView) this.bvY.findViewById(com.baidu.tieba.w.systemhelpsetting);
        this.bwl = (TbSettingTextTipView) this.bvY.findViewById(com.baidu.tieba.w.quit);
        refreshNewVersion();
        VL();
        this.bwb.Ws();
        da(TbadkCoreApplication.m255getInst().getSkinType());
        x(VM);
        OD();
    }

    private void OD() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bvY.getPageContext().getPageActivity(), com.baidu.tieba.x.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_close_ll)).setOnClickListener(new ag(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.w.id_quit_ll)).setOnClickListener(new ah(this));
        this.bwa = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.bwa.setView(inflate, 0, 0, 0, 0);
    }

    private void x(View.OnClickListener onClickListener) {
        this.bwn.setOnClickListener(onClickListener);
        this.bwb.setOnClickListener(onClickListener);
        this.bwc.setOnClickListener(onClickListener);
        this.bwd.setOnClickListener(onClickListener);
        this.bwe.setOnClickListener(onClickListener);
        this.bwf.setOnClickListener(onClickListener);
        this.bwg.setOnClickListener(onClickListener);
        this.bwh.setOnClickListener(onClickListener);
        this.bwi.setOnClickListener(onClickListener);
        this.bwk.setOnClickListener(onClickListener);
        this.bwl.setOnClickListener(onClickListener);
    }

    private View.OnClickListener VM() {
        return new ai(this);
    }

    public void VN() {
        if (this.bwa != null) {
            com.baidu.adp.lib.g.k.a(this.bwa, this.bvY.getPageContext());
        }
    }
}
