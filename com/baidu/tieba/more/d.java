package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private RelativeLayout bqi;
    private TextView bqj;
    protected ImageView bqk;
    protected TextView bql;
    private SettingTextTestNewView bqm;
    private TbSettingTextTipView bqn;
    private SettingTextFunctionIntroView bqo;
    private ProgressBar bqp;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, r rVar) {
        super(baseActivity);
        this.mActivity = baseActivity;
        qk();
        a(rVar);
    }

    public void Uf() {
        if (this.bqp != null) {
            this.bqp.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.bqp != null) {
            this.bqp.setVisibility(8);
        }
    }

    private void qk() {
        this.mActivity.setContentView(com.baidu.tieba.w.about_activity);
        this.bqi = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getString(com.baidu.tieba.y.version_info));
        this.bqj = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_versioninfo);
        this.bqk = (ImageView) this.mActivity.findViewById(com.baidu.tieba.v.text_description);
        this.bqm = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.v.about_version_update);
        this.bqm.qn();
        this.bqo = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.v.about_function_intro);
        this.bqn = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.about_guide);
        this.bqp = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.v.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !az.aA(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.bqj.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.setting_version_text)) + " " + version);
        this.bql = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_version_protoco);
        cu(TbadkApplication.m251getInst().getSkinType());
    }

    private void a(r rVar) {
        e eVar = new e(this, rVar);
        this.bqm.setOnClickListener(eVar);
        this.bqn.setOnClickListener(eVar);
        this.bqo.setOnClickListener(eVar);
    }

    public void Ug() {
        if (this.bqm != null) {
            this.bqm.refresh();
        }
        if (this.bqo != null) {
            this.bqo.refresh();
        }
    }

    public void cu(int i) {
        com.baidu.tbadk.core.util.aw.i(this.bqi, com.baidu.tieba.s.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(i);
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.bqi);
        Ug();
    }
}
