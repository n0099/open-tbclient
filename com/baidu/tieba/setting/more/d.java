package com.baidu.tieba.setting.more;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.g {
    private int bZM;
    private long bZN;
    private RelativeLayout bZO;
    private TextView bZP;
    protected ImageView bZQ;
    protected TextView bZR;
    private SettingTextTestNewView bZS;
    private TbSettingTextTipView bZT;
    private SettingTextFunctionIntroView bZU;
    private ProgressBar bZV;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, q qVar) {
        super(baseActivity.getPageContext());
        this.bZM = 0;
        this.bZN = 0L;
        this.mActivity = baseActivity;
        xi();
        a(qVar);
    }

    public void agj() {
        if (this.bZV != null) {
            this.bZV.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.bZV != null) {
            this.bZV.setVisibility(8);
        }
    }

    private void xi() {
        this.mActivity.setContentView(com.baidu.tieba.w.about_activity);
        this.bZO = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getPageContext().getString(com.baidu.tieba.y.version_info));
        this.bZP = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_versioninfo);
        this.bZQ = (ImageView) this.mActivity.findViewById(com.baidu.tieba.v.text_description);
        this.bZS = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.v.about_version_update);
        this.bZU = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.v.about_function_intro);
        this.bZT = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.about_guide);
        this.bZT.hideArrow();
        this.bZV = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.v.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !bd.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.bZP.setText(String.valueOf(this.mActivity.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.mActivity.getPageContext().getString(com.baidu.tieba.y.setting_version_text) + " " + version);
        this.bZR = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_version_protoco);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015000) == null) {
            this.bZT.setVisibility(4);
        }
        if (!TbConfig.MAIN_PACKAGE_NAME.equals(TbadkCoreApplication.m411getInst().getApplicationInfo().packageName)) {
            this.bZU.setVisibility(4);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.bZS.setOnClickListener(eVar);
        this.bZT.setOnClickListener(eVar);
        this.bZU.setOnClickListener(eVar);
        this.bZP.setOnClickListener(eVar);
    }

    public void agk() {
        if (this.bZS != null) {
            this.bZS.refresh();
        }
        if (this.bZU != null) {
            this.bZU.refresh();
        }
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.j(this.bZO, com.baidu.tieba.s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mActivity.getLayoutMode().X(i == 1);
        this.mActivity.getLayoutMode().h(this.bZO);
        agk();
    }
}
