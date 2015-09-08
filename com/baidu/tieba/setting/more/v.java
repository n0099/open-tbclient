package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity cFZ;
    private r cGa;
    private AlertDialog cGb;
    private View cGc;
    private TbSettingTextTipView cGd;
    private SettingTextImageView cGe;
    private TbSettingTextTipView cGf;
    private TbSettingTextTipView cGg;
    private TbSettingTextTipView cGh;
    private TbSettingTextTipView cGi;
    private SettingTextVersionView cGj;
    private TbSettingTextTipView cGk;
    private TbSettingTextTipView cGl;
    private View cGm;
    private TbSettingTextNewDotView cGn;
    private TextView cGo;
    private RelativeLayout cGp;
    private View cGq;
    private NavigationBar mNavigationBar;

    public v(MoreActivity moreActivity, r rVar) {
        super(moreActivity.getPageContext());
        this.cFZ = moreActivity;
        this.cGa = rVar;
        this.cFZ.setContentView(i.g.more_activity);
        zy();
    }

    public void apH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cGe.setVisibility(8);
        } else {
            this.cGe.setVisibility(0);
        }
    }

    public void E(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cGe != null) {
                this.cGe.aqE();
                return;
            }
            return;
        }
        this.cGe.aqF();
        this.cGe.F(str, z);
    }

    public void refreshNewVersion() {
        if (this.cGj != null) {
            this.cGj.refresh();
        }
        if (this.cGn != null) {
            this.cGn.refresh();
        }
    }

    public void aoM() {
        this.cGe.recycle();
        this.cGf.recycle();
        this.cGg.recycle();
        this.cGh.recycle();
        this.cGi.recycle();
        this.cGj.recycle();
        this.cGk.recycle();
        this.cGl.recycle();
    }

    public void onChangeSkinType(int i) {
        dE(i);
        if (this.cGc != null) {
            this.cFZ.getLayoutMode().ad(i == 1);
            this.cFZ.getLayoutMode().k(this.cGc);
        }
    }

    public void dE(int i) {
        com.baidu.tbadk.core.util.al.i(this.cGp, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cGe.dE(i);
        this.cFZ.getLayoutMode().ad(i == 1);
        this.cFZ.getLayoutMode().k(this.cGp);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zy() {
        View.OnClickListener apI = apI();
        this.cGp = (RelativeLayout) this.cFZ.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cFZ.findViewById(i.f.view_navigation_bar);
        this.cGq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cFZ.getPageContext().getString(i.h.setup));
        this.cGd = (TbSettingTextTipView) this.cFZ.findViewById(i.f.accountSafeSetting);
        this.cGe = (SettingTextImageView) this.cFZ.findViewById(i.f.personInfo);
        this.cGf = (TbSettingTextTipView) this.cFZ.findViewById(i.f.accountManager);
        this.cGg = (TbSettingTextTipView) this.cFZ.findViewById(i.f.browseSetting);
        this.cGh = (TbSettingTextTipView) this.cFZ.findViewById(i.f.messageSetting);
        this.cGi = (TbSettingTextTipView) this.cFZ.findViewById(i.f.secretSetting);
        this.cGj = (SettingTextVersionView) this.cFZ.findViewById(i.f.versionInfo);
        this.cGk = (TbSettingTextTipView) this.cFZ.findViewById(i.f.feedBack);
        this.cGl = (TbSettingTextTipView) this.cFZ.findViewById(i.f.recommend);
        this.cGm = this.cFZ.findViewById(i.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cGl.setVisibility(8);
            this.cGm.setVisibility(8);
        } else {
            this.cGl.setVisibility(0);
            this.cGm.setVisibility(0);
        }
        this.cGn = (TbSettingTextNewDotView) this.cFZ.findViewById(i.f.systemhelpsetting);
        this.cGo = (TextView) this.cFZ.findViewById(i.f.quit);
        refreshNewVersion();
        apH();
        this.cGe.aqE();
        dE(TbadkCoreApplication.m411getInst().getSkinType());
        H(apI);
        if (!MA()) {
            this.cGg.setTip(this.cFZ.getResources().getString(i.h.browsing_settings_tip_no_night));
        }
    }

    private boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.cGc = LayoutInflater.from(this.cFZ.getPageContext().getPageActivity()).inflate(i.g.quit_dialog, (ViewGroup) null);
        this.cFZ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cFZ.getLayoutMode().k(this.cGc);
        ((TextView) this.cGc.findViewById(i.f.id_close_tv)).setOnClickListener(new w(this));
        ((TextView) this.cGc.findViewById(i.f.id_quit_tv)).setOnClickListener(new x(this));
        this.cGb = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.g.j.a(this.cGb, this.mContext.getPageActivity());
        if (this.cGb.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cGb.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cGb.getWindow().setAttributes(attributes);
            this.cGb.getWindow().setContentView(this.cGc);
        }
    }

    private void H(View.OnClickListener onClickListener) {
        this.cGd.setOnClickListener(onClickListener);
        this.cGq.setOnClickListener(onClickListener);
        this.cGe.setOnClickListener(onClickListener);
        this.cGf.setOnClickListener(onClickListener);
        this.cGg.setOnClickListener(onClickListener);
        this.cGh.setOnClickListener(onClickListener);
        this.cGi.setOnClickListener(onClickListener);
        this.cGj.setOnClickListener(onClickListener);
        this.cGk.setOnClickListener(onClickListener);
        this.cGl.setOnClickListener(onClickListener);
        this.cGn.setOnClickListener(onClickListener);
        this.cGo.setOnClickListener(onClickListener);
    }

    private View.OnClickListener apI() {
        return new y(this);
    }

    public void apJ() {
        if (this.cGb == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.j.a(this.cGb, this.cFZ.getPageContext());
    }

    public void apK() {
        if (this.cGb == null) {
            com.baidu.adp.lib.g.j.b(this.cGb, this.cFZ.getPageContext());
        }
    }
}
