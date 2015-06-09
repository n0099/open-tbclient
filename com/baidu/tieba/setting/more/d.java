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
    private long ceA;
    private AboutActivity ceB;
    private RelativeLayout ceC;
    private TextView ceD;
    private SettingTextTestNewView ceE;
    private TbSettingTextTipView ceF;
    protected TextView ceG;
    private ProgressBar ceH;
    private int cez;
    private NavigationBar mNavigationBar;

    public d(AboutActivity aboutActivity, q qVar) {
        super(aboutActivity.getPageContext());
        this.cez = 0;
        this.ceA = 0L;
        this.ceB = aboutActivity;
        yc();
        a(qVar);
    }

    public void ais() {
        if (this.ceH != null) {
            this.ceH.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.ceH != null) {
            this.ceH.setVisibility(8);
        }
    }

    private void yc() {
        this.ceB.setContentView(com.baidu.tieba.r.about_activity);
        this.ceC = (RelativeLayout) this.ceB.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) this.ceB.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ceB.getPageContext().getString(com.baidu.tieba.t.version_info));
        this.ceD = (TextView) this.ceB.findViewById(com.baidu.tieba.q.text_versioninfo);
        this.ceE = (SettingTextTestNewView) this.ceB.findViewById(com.baidu.tieba.q.about_version_update);
        this.ceF = (TbSettingTextTipView) this.ceB.findViewById(com.baidu.tieba.q.about_guide);
        this.ceF.hideArrow();
        this.ceH = (ProgressBar) this.ceB.findViewById(com.baidu.tieba.q.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.bb.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.ceD.setText(String.valueOf(this.ceB.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.ceB.getPageContext().getString(com.baidu.tieba.t.setting_version_text) + " " + version);
        this.ceG = (TextView) this.ceB.findViewById(com.baidu.tieba.q.text_version_protoco);
        dl(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.ceF.setVisibility(4);
            this.ceB.findViewById(com.baidu.tieba.q.line_about_guide).setVisibility(8);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.ceE.setOnClickListener(eVar);
        this.ceF.setOnClickListener(eVar);
        this.ceD.setOnClickListener(eVar);
    }

    public void ait() {
        if (this.ceE != null) {
            this.ceE.refresh();
        }
    }

    public void dl(int i) {
        com.baidu.tbadk.core.util.ay.j(this.ceC, com.baidu.tieba.n.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ceB.getLayoutMode().ab(i == 1);
        this.ceB.getLayoutMode().j(this.ceC);
        ait();
    }
}
