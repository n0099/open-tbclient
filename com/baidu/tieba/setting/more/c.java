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
    private int cMl;
    private AboutActivity cMm;
    private RelativeLayout cMn;
    private TextView cMo;
    private SettingTextTestNewView cMp;
    private TbSettingTextTipView cMq;
    protected TextView cMr;
    private ProgressBar cMs;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, r rVar) {
        super(aboutActivity.getPageContext());
        this.cMl = 0;
        this.lastClickTime = 0L;
        this.cMm = aboutActivity;
        zh();
        a(rVar);
    }

    public void arq() {
        if (this.cMs != null) {
            this.cMs.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cMs != null) {
            this.cMs.setVisibility(8);
        }
    }

    private void zh() {
        this.cMm.setContentView(i.g.about_activity);
        this.cMn = (RelativeLayout) this.cMm.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cMm.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cMm.getPageContext().getString(i.h.version_info));
        this.cMo = (TextView) this.cMm.findViewById(i.f.text_versioninfo);
        this.cMp = (SettingTextTestNewView) this.cMm.findViewById(i.f.about_version_update);
        this.cMq = (TbSettingTextTipView) this.cMm.findViewById(i.f.about_guide);
        this.cMq.hideArrow();
        this.cMs = (ProgressBar) this.cMm.findViewById(i.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.as.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cMo.setText(String.valueOf(this.cMm.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.cMm.getPageContext().getString(i.h.setting_version_text) + " " + version);
        this.cMr = (TextView) this.cMm.findViewById(i.f.text_version_protoco);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.cMq.setVisibility(4);
            this.cMm.findViewById(i.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(r rVar) {
        d dVar = new d(this, rVar);
        this.cMp.setOnClickListener(dVar);
        this.cMq.setOnClickListener(dVar);
        this.cMo.setOnClickListener(dVar);
    }

    public void arr() {
        if (this.cMp != null) {
            this.cMp.refresh();
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.an.j(this.cMn, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cMm.getLayoutMode().ad(i == 1);
        this.cMm.getLayoutMode().k(this.cMn);
        arr();
    }
}
