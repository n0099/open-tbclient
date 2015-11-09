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
    private int cNH;
    private AboutActivity cNI;
    private RelativeLayout cNJ;
    private TextView cNK;
    private SettingTextTestNewView cNL;
    private TbSettingTextTipView cNM;
    protected TextView cNN;
    private ProgressBar cNO;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, r rVar) {
        super(aboutActivity.getPageContext());
        this.cNH = 0;
        this.lastClickTime = 0L;
        this.cNI = aboutActivity;
        zm();
        a(rVar);
    }

    public void arW() {
        if (this.cNO != null) {
            this.cNO.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cNO != null) {
            this.cNO.setVisibility(8);
        }
    }

    private void zm() {
        this.cNI.setContentView(i.g.about_activity);
        this.cNJ = (RelativeLayout) this.cNI.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) this.cNI.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cNI.getPageContext().getString(i.h.version_info));
        this.cNK = (TextView) this.cNI.findViewById(i.f.text_versioninfo);
        this.cNL = (SettingTextTestNewView) this.cNI.findViewById(i.f.about_version_update);
        this.cNM = (TbSettingTextTipView) this.cNI.findViewById(i.f.about_guide);
        this.cNM.hideArrow();
        this.cNO = (ProgressBar) this.cNI.findViewById(i.f.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.as.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cNK.setText(String.valueOf(this.cNI.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.cNI.getPageContext().getString(i.h.setting_version_text) + " " + version);
        this.cNN = (TextView) this.cNI.findViewById(i.f.text_version_protoco);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.cNM.setVisibility(4);
            this.cNI.findViewById(i.f.line_about_guide).setVisibility(8);
        }
    }

    private void a(r rVar) {
        d dVar = new d(this, rVar);
        this.cNL.setOnClickListener(dVar);
        this.cNM.setOnClickListener(dVar);
        this.cNK.setOnClickListener(dVar);
    }

    public void arX() {
        if (this.cNL != null) {
            this.cNL.refresh();
        }
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.an.j(this.cNJ, i.c.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cNI.getLayoutMode().ad(i == 1);
        this.cNI.getLayoutMode().k(this.cNJ);
        arX();
    }
}
