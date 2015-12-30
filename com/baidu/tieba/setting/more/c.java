package com.baidu.tieba.setting.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<AboutActivity> {
    private int dtf;
    private int dtg;
    private long dth;
    private AboutActivity dti;
    private RelativeLayout dtj;
    private TextView dtk;
    private TextView dtl;
    private SettingTextTestNewView dtm;
    private SettingTextTestNewView dtn;
    private ImageView dto;
    private TbSettingTextTipView dtp;
    protected TextView dtq;
    private ProgressBar dtr;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, s sVar) {
        super(aboutActivity.getPageContext());
        this.dtf = 0;
        this.lastClickTime = 0L;
        this.dtg = 0;
        this.dth = 0L;
        this.dti = aboutActivity;
        zU();
        a(sVar);
    }

    public void azA() {
        if (this.dtr != null) {
            this.dtr.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.dtr != null) {
            this.dtr.setVisibility(8);
        }
    }

    private void zU() {
        this.dti.setContentView(n.h.about_activity);
        this.dtj = (RelativeLayout) this.dti.findViewById(n.g.parent);
        this.dto = (ImageView) this.dti.findViewById(n.g.image_logo);
        this.dtl = (TextView) this.dti.findViewById(n.g.text_debug);
        this.mNavigationBar = (NavigationBar) this.dti.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dti.getPageContext().getString(n.j.version_info));
        this.dtk = (TextView) this.dti.findViewById(n.g.text_versioninfo);
        this.dtm = (SettingTextTestNewView) this.dti.findViewById(n.g.about_version_update);
        this.dtn = (SettingTextTestNewView) this.dti.findViewById(n.g.about_debuger);
        this.dtp = (TbSettingTextTipView) this.dti.findViewById(n.g.about_guide);
        this.dtp.hideArrow();
        this.dtr = (ProgressBar) this.dti.findViewById(n.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.ax.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.dtk.setText(String.valueOf(this.dti.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.dti.getPageContext().getString(n.j.setting_version_text) + " " + version);
        this.dtq = (TextView) this.dti.findViewById(n.g.text_version_protoco);
        dO(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.dtp.setVisibility(4);
            this.dti.findViewById(n.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("debug_plugin_switcher", false)) {
            mx(0);
        }
    }

    private void a(s sVar) {
        d dVar = new d(this, sVar);
        this.dtm.setOnClickListener(dVar);
        this.dtp.setOnClickListener(dVar);
        this.dtk.setOnClickListener(dVar);
        this.dto.setOnClickListener(dVar);
        this.dtn.setOnClickListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(int i) {
        this.dtl.setVisibility(i);
        this.dtn.setVisibility(i);
        this.dti.findViewById(n.g.line0).setVisibility(i);
    }

    public void azB() {
        if (this.dtm != null) {
            this.dtm.refresh();
        }
    }

    public void dO(int i) {
        com.baidu.tbadk.core.util.as.j(this.dtj, n.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dti.getLayoutMode().ac(i == 1);
        this.dti.getLayoutMode().k(this.dtj);
        azB();
    }
}
