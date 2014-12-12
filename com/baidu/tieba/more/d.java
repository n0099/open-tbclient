package com.baidu.tieba.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.g {
    private SettingTextTestNewView btA;
    private TbSettingTextTipView btB;
    private SettingTextFunctionIntroView btC;
    private ProgressBar btD;
    private RelativeLayout btw;
    private TextView btx;
    protected ImageView bty;
    protected TextView btz;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, q qVar) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        tD();
        a(qVar);
    }

    public void Ut() {
        if (this.btD != null) {
            this.btD.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.btD != null) {
            this.btD.setVisibility(8);
        }
    }

    private void tD() {
        this.mActivity.setContentView(com.baidu.tieba.x.about_activity);
        this.btw = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getPageContext().getString(com.baidu.tieba.z.version_info));
        this.btx = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_versioninfo);
        this.bty = (ImageView) this.mActivity.findViewById(com.baidu.tieba.w.text_description);
        this.btA = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.w.about_version_update);
        this.btA.tG();
        this.btC = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.w.about_function_intro);
        this.btB = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.w.about_guide);
        this.btD = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.w.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !ba.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.btx.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.setting_version_text)) + " " + version);
        this.btz = (TextView) this.mActivity.findViewById(com.baidu.tieba.w.text_version_protoco);
        cT(TbadkCoreApplication.m255getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015000) == null) {
            this.btB.setVisibility(4);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.btA.setOnClickListener(eVar);
        this.btB.setOnClickListener(eVar);
        this.btC.setOnClickListener(eVar);
    }

    public void Uu() {
        if (this.btA != null) {
            this.btA.refresh();
        }
        if (this.btC != null) {
            this.btC.refresh();
        }
    }

    public void cT(int i) {
        ax.j(this.btw, com.baidu.tieba.t.bg_page_setting);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.btw);
        Uu();
    }
}
