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
    private int cEL;
    private AboutActivity cEM;
    private RelativeLayout cEN;
    private TextView cEO;
    private SettingTextTestNewView cEP;
    private TbSettingTextTipView cEQ;
    protected TextView cER;
    private ProgressBar cES;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, r rVar) {
        super(aboutActivity.getPageContext());
        this.cEL = 0;
        this.lastClickTime = 0L;
        this.cEM = aboutActivity;
        zy();
        a(rVar);
    }

    public void aoW() {
        if (this.cES != null) {
            this.cES.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cES != null) {
            this.cES.setVisibility(8);
        }
    }

    private void zy() {
        this.cEM.setContentView(i.g.about_activity);
        this.cEN = (RelativeLayout) this.cEM.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cEM.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cEM.getPageContext().getString(i.h.version_info));
        this.cEO = (TextView) this.cEM.findViewById(i.f.text_versioninfo);
        this.cEP = (SettingTextTestNewView) this.cEM.findViewById(i.f.about_version_update);
        this.cEQ = (TbSettingTextTipView) this.cEM.findViewById(i.f.about_guide);
        this.cEQ.hideArrow();
        this.cES = (ProgressBar) this.cEM.findViewById(i.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.aq.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cEO.setText(String.valueOf(this.cEM.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.cEM.getPageContext().getString(i.h.setting_version_text) + " " + version);
        this.cER = (TextView) this.cEM.findViewById(i.f.text_version_protoco);
        dE(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.cEQ.setVisibility(4);
            this.cEM.findViewById(i.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(r rVar) {
        d dVar = new d(this, rVar);
        this.cEP.setOnClickListener(dVar);
        this.cEQ.setOnClickListener(dVar);
        this.cEO.setOnClickListener(dVar);
    }

    public void aoX() {
        if (this.cEP != null) {
            this.cEP.refresh();
        }
    }

    public void dE(int i) {
        com.baidu.tbadk.core.util.al.i(this.cEN, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cEM.getLayoutMode().ad(i == 1);
        this.cEM.getLayoutMode().k(this.cEN);
        aoX();
    }
}
