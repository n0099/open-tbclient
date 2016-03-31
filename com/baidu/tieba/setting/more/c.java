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
    private int ebD;
    private int ebE;
    private long ebF;
    private AboutActivity ebG;
    private RelativeLayout ebH;
    private TextView ebI;
    private TextView ebJ;
    private SettingTextTestNewView ebK;
    private SettingTextTestNewView ebL;
    private ImageView ebM;
    private TbSettingTextTipView ebN;
    protected TextView ebO;
    private ProgressBar ebP;
    private long lastClickTime;
    private NavigationBar mNavigationBar;

    public c(AboutActivity aboutActivity, s sVar) {
        super(aboutActivity.getPageContext());
        this.ebD = 0;
        this.lastClickTime = 0L;
        this.ebE = 0;
        this.ebF = 0L;
        this.ebG = aboutActivity;
        BN();
        a(sVar);
    }

    public void aNr() {
        if (this.ebP != null) {
            this.ebP.setVisibility(0);
        }
    }

    public void Qo() {
        if (this.ebP != null) {
            this.ebP.setVisibility(8);
        }
    }

    private void BN() {
        this.ebG.setContentView(t.h.about_activity);
        this.ebH = (RelativeLayout) this.ebG.findViewById(t.g.parent);
        this.ebM = (ImageView) this.ebG.findViewById(t.g.image_logo);
        this.ebJ = (TextView) this.ebG.findViewById(t.g.text_debug);
        this.mNavigationBar = (NavigationBar) this.ebG.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ebG.getPageContext().getString(t.j.version_info));
        this.ebI = (TextView) this.ebG.findViewById(t.g.text_versioninfo);
        this.ebK = (SettingTextTestNewView) this.ebG.findViewById(t.g.about_version_update);
        this.ebL = (SettingTextTestNewView) this.ebG.findViewById(t.g.about_debuger);
        this.ebN = (TbSettingTextTipView) this.ebG.findViewById(t.g.about_guide);
        this.ebN.hideArrow();
        this.ebP = (ProgressBar) this.ebG.findViewById(t.g.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.ay.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.ebI.setText(String.valueOf(this.ebG.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.ebG.getPageContext().getString(t.j.setting_version_text) + " " + version);
        this.ebO = (TextView) this.ebG.findViewById(t.g.text_version_protoco);
        em(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) == null) {
            this.ebN.setVisibility(4);
            this.ebG.findViewById(t.g.line_about_guide).setVisibility(8);
        }
        if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("debug_plugin_switcher", false)) {
            oO(0);
        }
    }

    private void a(s sVar) {
        d dVar = new d(this, sVar);
        this.ebK.setOnClickListener(dVar);
        this.ebN.setOnClickListener(dVar);
        this.ebI.setOnClickListener(dVar);
        this.ebM.setOnClickListener(dVar);
        this.ebL.setOnClickListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO(int i) {
        this.ebJ.setVisibility(i);
        this.ebL.setVisibility(i);
        this.ebG.findViewById(t.g.line0).setVisibility(i);
    }

    public void aNs() {
        if (this.ebK != null) {
            this.ebK.refresh();
        }
    }

    public void em(int i) {
        com.baidu.tbadk.core.util.at.l(this.ebH, t.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ebG.getLayoutMode().ab(i == 1);
        this.ebG.getLayoutMode().x(this.ebH);
        aNs();
    }
}
