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
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f<MoreActivity> {
    private MoreActivity cNa;
    private r cNb;
    private AlertDialog cNc;
    private View cNd;
    private TbSettingTextTipView cNe;
    private SettingTextImageView cNf;
    private TbSettingTextTipView cNg;
    private TbSettingTextTipView cNh;
    private TbSettingTextTipView cNi;
    private TbSettingTextTipView cNj;
    private SettingTextVersionView cNk;
    private TbSettingTextTipView cNl;
    private TbSettingTextTipView cNm;
    private View cNn;
    private TbSettingTextNewDotView cNo;
    private TextView cNp;
    private RelativeLayout cNq;
    private View cNr;
    private NavigationBar mNavigationBar;

    public v(MoreActivity moreActivity, r rVar) {
        super(moreActivity.getPageContext());
        this.cNa = moreActivity;
        this.cNb = rVar;
        this.cNa.setContentView(i.g.more_activity);
        zk();
    }

    public void arZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cNf.setVisibility(8);
        } else {
            this.cNf.setVisibility(0);
        }
    }

    public void F(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cNf != null) {
                this.cNf.asW();
                return;
            }
            return;
        }
        this.cNf.asX();
        this.cNf.G(str, z);
    }

    public void refreshNewVersion() {
        if (this.cNk != null) {
            this.cNk.refresh();
        }
        if (this.cNo != null) {
            this.cNo.refresh();
        }
    }

    public void are() {
        this.cNf.recycle();
        this.cNg.recycle();
        this.cNh.recycle();
        this.cNi.recycle();
        this.cNj.recycle();
        this.cNk.recycle();
        this.cNl.recycle();
        this.cNm.recycle();
    }

    public void onChangeSkinType(int i) {
        dF(i);
        if (this.cNd != null) {
            this.cNa.getLayoutMode().ad(i == 1);
            this.cNa.getLayoutMode().k(this.cNd);
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.am.j(this.cNq, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cNf.dF(i);
        this.cNa.getLayoutMode().ad(i == 1);
        this.cNa.getLayoutMode().k(this.cNq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void zk() {
        View.OnClickListener asa = asa();
        this.cNq = (RelativeLayout) this.cNa.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cNa.findViewById(i.f.view_navigation_bar);
        this.cNr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cNa.getPageContext().getString(i.h.setup));
        this.cNe = (TbSettingTextTipView) this.cNa.findViewById(i.f.accountSafeSetting);
        this.cNf = (SettingTextImageView) this.cNa.findViewById(i.f.personInfo);
        this.cNg = (TbSettingTextTipView) this.cNa.findViewById(i.f.accountManager);
        this.cNh = (TbSettingTextTipView) this.cNa.findViewById(i.f.browseSetting);
        this.cNi = (TbSettingTextTipView) this.cNa.findViewById(i.f.messageSetting);
        this.cNj = (TbSettingTextTipView) this.cNa.findViewById(i.f.secretSetting);
        this.cNk = (SettingTextVersionView) this.cNa.findViewById(i.f.versionInfo);
        this.cNl = (TbSettingTextTipView) this.cNa.findViewById(i.f.feedBack);
        this.cNm = (TbSettingTextTipView) this.cNa.findViewById(i.f.recommend);
        this.cNn = this.cNa.findViewById(i.f.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cNm.setVisibility(8);
            this.cNn.setVisibility(8);
        } else {
            this.cNm.setVisibility(0);
            this.cNn.setVisibility(0);
        }
        this.cNo = (TbSettingTextNewDotView) this.cNa.findViewById(i.f.systemhelpsetting);
        this.cNp = (TextView) this.cNa.findViewById(i.f.quit);
        refreshNewVersion();
        arZ();
        this.cNf.asW();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        I(asa);
        if (!Mz()) {
            this.cNh.setTip(this.cNa.getResources().getString(i.h.browsing_settings_tip_no_night));
        }
    }

    private boolean Mz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void createDialog() {
        this.cNd = LayoutInflater.from(this.cNa.getPageContext().getPageActivity()).inflate(i.g.quit_dialog, (ViewGroup) null);
        this.cNa.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cNa.getLayoutMode().k(this.cNd);
        ((TextView) this.cNd.findViewById(i.f.id_close_tv)).setOnClickListener(new w(this));
        ((TextView) this.cNd.findViewById(i.f.id_quit_tv)).setOnClickListener(new x(this));
        this.cNc = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        com.baidu.adp.lib.g.j.a(this.cNc, this.mContext.getPageActivity());
        if (this.cNc.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cNc.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cNc.getWindow().setAttributes(attributes);
            this.cNc.getWindow().setContentView(this.cNd);
        }
    }

    private void I(View.OnClickListener onClickListener) {
        this.cNe.setOnClickListener(onClickListener);
        this.cNr.setOnClickListener(onClickListener);
        this.cNf.setOnClickListener(onClickListener);
        this.cNg.setOnClickListener(onClickListener);
        this.cNh.setOnClickListener(onClickListener);
        this.cNi.setOnClickListener(onClickListener);
        this.cNj.setOnClickListener(onClickListener);
        this.cNk.setOnClickListener(onClickListener);
        this.cNl.setOnClickListener(onClickListener);
        this.cNm.setOnClickListener(onClickListener);
        this.cNo.setOnClickListener(onClickListener);
        this.cNp.setOnClickListener(onClickListener);
    }

    private View.OnClickListener asa() {
        return new y(this);
    }

    public void asb() {
        if (this.cNc == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.j.a(this.cNc, this.cNa.getPageContext());
    }

    public void asc() {
        if (this.cNc == null) {
            com.baidu.adp.lib.g.j.b(this.cNc, this.cNa.getPageContext());
        }
    }
}
