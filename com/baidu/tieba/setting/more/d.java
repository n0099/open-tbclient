package com.baidu.tieba.setting.more;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.g<AboutActivity> {
    private AboutActivity ceA;
    private RelativeLayout ceB;
    private TextView ceC;
    private SettingTextTestNewView ceD;
    private TbSettingTextTipView ceE;
    protected TextView ceF;
    private ProgressBar ceG;
    private int cey;
    private long cez;
    private NavigationBar mNavigationBar;

    public d(AboutActivity aboutActivity, q qVar) {
        super(aboutActivity.getPageContext());
        this.cey = 0;
        this.cez = 0L;
        this.ceA = aboutActivity;
        yb();
        a(qVar);
    }

    public void air() {
        if (this.ceG != null) {
            this.ceG.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.ceG != null) {
            this.ceG.setVisibility(8);
        }
    }

    private void yb() {
        this.ceA.setContentView(com.baidu.tieba.r.about_activity);
        this.ceB = (RelativeLayout) this.ceA.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) this.ceA.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ceA.getPageContext().getString(com.baidu.tieba.t.version_info));
        this.ceC = (TextView) this.ceA.findViewById(com.baidu.tieba.q.text_versioninfo);
        this.ceD = (SettingTextTestNewView) this.ceA.findViewById(com.baidu.tieba.q.about_version_update);
        this.ceE = (TbSettingTextTipView) this.ceA.findViewById(com.baidu.tieba.q.about_guide);
        this.ceE.hideArrow();
        this.ceG = (ProgressBar) this.ceA.findViewById(com.baidu.tieba.q.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.bb.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.ceC.setText(String.valueOf(this.ceA.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.ceA.getPageContext().getString(com.baidu.tieba.t.setting_version_text) + " " + version);
        this.ceF = (TextView) this.ceA.findViewById(com.baidu.tieba.q.text_version_protoco);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.ceE.setVisibility(4);
            this.ceA.findViewById(com.baidu.tieba.q.line_about_guide).setVisibility(8);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.ceD.setOnClickListener(eVar);
        this.ceE.setOnClickListener(eVar);
        this.ceC.setOnClickListener(eVar);
    }

    public void ais() {
        if (this.ceD != null) {
            this.ceD.refresh();
        }
    }

    public void dl(int i) {
        com.baidu.tbadk.core.util.ay.j(this.ceB, com.baidu.tieba.n.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ceA.getLayoutMode().ab(i == 1);
        this.ceA.getLayoutMode().j(this.ceB);
        ais();
    }
}
