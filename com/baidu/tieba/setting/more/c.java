package com.baidu.tieba.setting.more;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<AboutActivity> {
    private int cwo;
    private AboutActivity cwp;
    private RelativeLayout cwq;
    private TextView cwr;
    private SettingTextTestNewView cws;
    private TbSettingTextTipView cwt;
    protected TextView cwu;
    private ProgressBar cwv;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, r rVar) {
        super(aboutActivity.getPageContext());
        this.cwo = 0;
        this.lastClickTime = 0L;
        this.cwp = aboutActivity;
        zl();
        a(rVar);
    }

    public void akP() {
        if (this.cwv != null) {
            this.cwv.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cwv != null) {
            this.cwv.setVisibility(8);
        }
    }

    private void zl() {
        this.cwp.setContentView(i.g.about_activity);
        this.cwq = (RelativeLayout) this.cwp.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cwp.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cwp.getPageContext().getString(i.C0057i.version_info));
        this.cwr = (TextView) this.cwp.findViewById(i.f.text_versioninfo);
        this.cws = (SettingTextTestNewView) this.cwp.findViewById(i.f.about_version_update);
        this.cwt = (TbSettingTextTipView) this.cwp.findViewById(i.f.about_guide);
        this.cwt.hideArrow();
        this.cwv = (ProgressBar) this.cwp.findViewById(i.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.aq.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cwr.setText(String.valueOf(this.cwp.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.cwp.getPageContext().getString(i.C0057i.setting_version_text) + " " + version);
        this.cwu = (TextView) this.cwp.findViewById(i.f.text_version_protoco);
        dw(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.cwt.setVisibility(4);
            this.cwp.findViewById(i.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(r rVar) {
        d dVar = new d(this, rVar);
        this.cws.setOnClickListener(dVar);
        this.cwt.setOnClickListener(dVar);
        this.cwr.setOnClickListener(dVar);
    }

    public void akQ() {
        if (this.cws != null) {
            this.cws.refresh();
        }
    }

    public void dw(int i) {
        com.baidu.tbadk.core.util.al.j(this.cwq, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cwp.getLayoutMode().ad(i == 1);
        this.cwp.getLayoutMode().k(this.cwq);
        akQ();
    }
}
