package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private RelativeLayout bpU;
    private TextView bpV;
    protected ImageView bpW;
    protected TextView bpX;
    private SettingTextTestNewView bpY;
    private TbSettingTextTipView bpZ;
    private SettingTextFunctionIntroView bqa;
    private ProgressBar bqb;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, r rVar) {
        super(baseActivity);
        this.mActivity = baseActivity;
        qi();
        a(rVar);
    }

    public void Uc() {
        if (this.bqb != null) {
            this.bqb.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.bqb != null) {
            this.bqb.setVisibility(8);
        }
    }

    private void qi() {
        this.mActivity.setContentView(com.baidu.tieba.w.about_activity);
        this.bpU = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.version_info));
        this.bpV = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_versioninfo);
        this.bpW = (ImageView) this.mActivity.findViewById(com.baidu.tieba.v.text_description);
        this.bpY = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.v.about_version_update);
        this.bpY.ql();
        this.bqa = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.v.about_function_intro);
        this.bpZ = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.about_guide);
        this.bqb = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.v.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.ay.aA(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.bpV.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.setting_version_text)) + " " + version);
        this.bpX = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_version_protoco);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    private void a(r rVar) {
        e eVar = new e(this, rVar);
        this.bpY.setOnClickListener(eVar);
        this.bpZ.setOnClickListener(eVar);
        this.bqa.setOnClickListener(eVar);
    }

    public void Ud() {
        if (this.bpY != null) {
            this.bpY.refresh();
        }
        if (this.bqa != null) {
            this.bqa.refresh();
        }
    }

    public void cu(int i) {
        com.baidu.tbadk.core.util.aw.i(this.bpU, com.baidu.tieba.s.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(i);
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.bpU);
        Ud();
    }
}
