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
    private RelativeLayout buS;
    private TextView buT;
    protected ImageView buU;
    protected TextView buV;
    private SettingTextTestNewView buW;
    private TbSettingTextTipView buX;
    private SettingTextFunctionIntroView buY;
    private ProgressBar buZ;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, q qVar) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        tO();
        a(qVar);
    }

    public void UM() {
        if (this.buZ != null) {
            this.buZ.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.buZ != null) {
            this.buZ.setVisibility(8);
        }
    }

    private void tO() {
        this.mActivity.setContentView(com.baidu.tieba.x.about_activity);
        this.buS = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getPageContext().getString(com.baidu.tieba.z.version_info));
        this.buT = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_versioninfo);
        this.buU = (ImageView) this.mActivity.findViewById(com.baidu.tieba.w.text_description);
        this.buW = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.w.about_version_update);
        this.buW.tR();
        this.buY = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.w.about_function_intro);
        this.buX = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.w.about_guide);
        this.buZ = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.w.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !com.baidu.tbadk.core.util.bf.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.buT.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.setting_version_text)) + " " + version);
        this.buV = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_version_protoco);
        da(TbadkCoreApplication.m255getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015000) == null) {
            this.buX.setVisibility(4);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.buW.setOnClickListener(eVar);
        this.buX.setOnClickListener(eVar);
        this.buY.setOnClickListener(eVar);
    }

    public void UN() {
        if (this.buW != null) {
            this.buW.refresh();
        }
        if (this.buY != null) {
            this.buY.refresh();
        }
    }

    public void da(int i) {
        com.baidu.tbadk.core.util.bc.j(this.buS, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.buS);
        UN();
    }
}
