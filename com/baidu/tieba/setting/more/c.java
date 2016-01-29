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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<AboutActivity> {
    private int dJj;
    private int dJk;
    private long dJl;
    private AboutActivity dJm;
    private RelativeLayout dJn;
    private TextView dJo;
    private TextView dJp;
    private SettingTextTestNewView dJq;
    private SettingTextTestNewView dJr;
    private ImageView dJs;
    private TbSettingTextTipView dJt;
    protected TextView dJu;
    private ProgressBar dJv;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, s sVar) {
        super(aboutActivity.getPageContext());
        this.dJj = 0;
        this.lastClickTime = 0L;
        this.dJk = 0;
        this.dJl = 0L;
        this.dJm = aboutActivity;
        Bk();
        a(sVar);
    }

    public void aGH() {
        if (this.dJv != null) {
            this.dJv.setVisibility(0);
        }
    }

    public void Oz() {
        if (this.dJv != null) {
            this.dJv.setVisibility(8);
        }
    }

    private void Bk() {
        this.dJm.setContentView(t.h.about_activity);
        this.dJn = (RelativeLayout) this.dJm.findViewById(t.g.parent);
        this.dJs = (ImageView) this.dJm.findViewById(t.g.image_logo);
        this.dJp = (TextView) this.dJm.findViewById(t.g.text_debug);
        this.mNavigationBar = (NavigationBar) this.dJm.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dJm.getPageContext().getString(t.j.version_info));
        this.dJo = (TextView) this.dJm.findViewById(t.g.text_versioninfo);
        this.dJq = (SettingTextTestNewView) this.dJm.findViewById(t.g.about_version_update);
        this.dJr = (SettingTextTestNewView) this.dJm.findViewById(t.g.about_debuger);
        this.dJt = (TbSettingTextTipView) this.dJm.findViewById(t.g.about_guide);
        this.dJt.hideArrow();
        this.dJv = (ProgressBar) this.dJm.findViewById(t.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.aw.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.dJo.setText(String.valueOf(this.dJm.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.dJm.getPageContext().getString(t.j.setting_version_text) + " " + version);
        this.dJu = (TextView) this.dJm.findViewById(t.g.text_version_protoco);
        ej(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.dJt.setVisibility(4);
            this.dJm.findViewById(t.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("debug_plugin_switcher", false)) {
            nJ(0);
        }
    }

    private void a(s sVar) {
        d dVar = new d(this, sVar);
        this.dJq.setOnClickListener(dVar);
        this.dJt.setOnClickListener(dVar);
        this.dJo.setOnClickListener(dVar);
        this.dJs.setOnClickListener(dVar);
        this.dJr.setOnClickListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(int i) {
        this.dJp.setVisibility(i);
        this.dJr.setVisibility(i);
        this.dJm.findViewById(t.g.line0).setVisibility(i);
    }

    public void aGI() {
        if (this.dJq != null) {
            this.dJq.refresh();
        }
    }

    public void ej(int i) {
        com.baidu.tbadk.core.util.ar.l(this.dJn, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dJm.getLayoutMode().ac(i == 1);
        this.dJm.getLayoutMode().x(this.dJn);
        aGI();
    }
}
