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
    private int cLM;
    private AboutActivity cLN;
    private RelativeLayout cLO;
    private TextView cLP;
    private SettingTextTestNewView cLQ;
    private TbSettingTextTipView cLR;
    protected TextView cLS;
    private ProgressBar cLT;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, r rVar) {
        super(aboutActivity.getPageContext());
        this.cLM = 0;
        this.lastClickTime = 0L;
        this.cLN = aboutActivity;
        zk();
        a(rVar);
    }

    public void aro() {
        if (this.cLT != null) {
            this.cLT.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cLT != null) {
            this.cLT.setVisibility(8);
        }
    }

    private void zk() {
        this.cLN.setContentView(i.g.about_activity);
        this.cLO = (RelativeLayout) this.cLN.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cLN.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cLN.getPageContext().getString(i.h.version_info));
        this.cLP = (TextView) this.cLN.findViewById(i.f.text_versioninfo);
        this.cLQ = (SettingTextTestNewView) this.cLN.findViewById(i.f.about_version_update);
        this.cLR = (TbSettingTextTipView) this.cLN.findViewById(i.f.about_guide);
        this.cLR.hideArrow();
        this.cLT = (ProgressBar) this.cLN.findViewById(i.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.ar.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cLP.setText(String.valueOf(this.cLN.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.cLN.getPageContext().getString(i.h.setting_version_text) + " " + version);
        this.cLS = (TextView) this.cLN.findViewById(i.f.text_version_protoco);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.cLR.setVisibility(4);
            this.cLN.findViewById(i.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(r rVar) {
        d dVar = new d(this, rVar);
        this.cLQ.setOnClickListener(dVar);
        this.cLR.setOnClickListener(dVar);
        this.cLP.setOnClickListener(dVar);
    }

    public void arp() {
        if (this.cLQ != null) {
            this.cLQ.refresh();
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.am.j(this.cLO, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cLN.getLayoutMode().ad(i == 1);
        this.cLN.getLayoutMode().k(this.cLO);
        arp();
    }
}
