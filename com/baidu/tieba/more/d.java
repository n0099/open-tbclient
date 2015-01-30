package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.g {
    private RelativeLayout buT;
    private TextView buU;
    protected ImageView buV;
    protected TextView buW;
    private SettingTextTestNewView buX;
    private TbSettingTextTipView buY;
    private SettingTextFunctionIntroView buZ;
    private ProgressBar bva;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, q qVar) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        tU();
        a(qVar);
    }

    public void UR() {
        if (this.bva != null) {
            this.bva.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.bva != null) {
            this.bva.setVisibility(8);
        }
    }

    private void tU() {
        this.mActivity.setContentView(com.baidu.tieba.x.about_activity);
        this.buT = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getPageContext().getString(com.baidu.tieba.z.version_info));
        this.buU = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_versioninfo);
        this.buV = (ImageView) this.mActivity.findViewById(com.baidu.tieba.w.text_description);
        this.buX = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.w.about_version_update);
        this.buX.tX();
        this.buZ = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.w.about_function_intro);
        this.buY = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.w.about_guide);
        this.bva = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.w.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.bf.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.buU.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.setting_version_text)) + " " + version);
        this.buW = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_version_protoco);
        da(TbadkCoreApplication.m255getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015000) == null) {
            this.buY.setVisibility(4);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.buX.setOnClickListener(eVar);
        this.buY.setOnClickListener(eVar);
        this.buZ.setOnClickListener(eVar);
    }

    public void US() {
        if (this.buX != null) {
            this.buX.refresh();
        }
        if (this.buZ != null) {
            this.buZ.refresh();
        }
    }

    public void da(int i) {
        com.baidu.tbadk.core.util.bc.j(this.buT, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.buT);
        US();
    }
}
