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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f<AboutActivity> {
    private int dlY;
    private AboutActivity dlZ;
    private RelativeLayout dma;
    private TextView dmb;
    private SettingTextTestNewView dmc;
    private TbSettingTextTipView dmd;
    protected TextView dme;
    private ProgressBar dmf;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, s sVar) {
        super(aboutActivity.getPageContext());
        this.dlY = 0;
        this.lastClickTime = 0L;
        this.dlZ = aboutActivity;
        Ai();
        a(sVar);
    }

    public void axu() {
        if (this.dmf != null) {
            this.dmf.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.dmf != null) {
            this.dmf.setVisibility(8);
        }
    }

    private void Ai() {
        this.dlZ.setContentView(n.g.about_activity);
        this.dma = (RelativeLayout) this.dlZ.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) this.dlZ.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dlZ.getPageContext().getString(n.i.version_info));
        this.dmb = (TextView) this.dlZ.findViewById(n.f.text_versioninfo);
        this.dmc = (SettingTextTestNewView) this.dlZ.findViewById(n.f.about_version_update);
        this.dmd = (TbSettingTextTipView) this.dlZ.findViewById(n.f.about_guide);
        this.dmd.hideArrow();
        this.dmf = (ProgressBar) this.dlZ.findViewById(n.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.ax.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.dmb.setText(String.valueOf(this.dlZ.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.dlZ.getPageContext().getString(n.i.setting_version_text) + " " + version);
        this.dme = (TextView) this.dlZ.findViewById(n.f.text_version_protoco);
        dU(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.dmd.setVisibility(4);
            this.dlZ.findViewById(n.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(s sVar) {
        d dVar = new d(this, sVar);
        this.dmc.setOnClickListener(dVar);
        this.dmd.setOnClickListener(dVar);
        this.dmb.setOnClickListener(dVar);
    }

    public void axv() {
        if (this.dmc != null) {
            this.dmc.refresh();
        }
    }

    public void dU(int i) {
        com.baidu.tbadk.core.util.as.j(this.dma, n.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlZ.getLayoutMode().af(i == 1);
        this.dlZ.getLayoutMode().k(this.dma);
        axv();
    }
}
