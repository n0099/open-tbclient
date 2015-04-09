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
    private int cab;
    private long cac;
    private RelativeLayout cad;
    private TextView cae;
    protected ImageView caf;
    protected TextView cag;
    private SettingTextTestNewView cah;
    private TbSettingTextTipView cai;
    private SettingTextFunctionIntroView caj;
    private ProgressBar cak;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;

    public d(BaseActivity baseActivity, q qVar) {
        super(baseActivity.getPageContext());
        this.cab = 0;
        this.cac = 0L;
        this.mActivity = baseActivity;
        xo();
        a(qVar);
    }

    public void agy() {
        if (this.cak != null) {
            this.cak.setVisibility(0);
        }
    }

    public void hideProgress() {
        if (this.cak != null) {
            this.cak.setVisibility(8);
        }
    }

    private void xo() {
        this.mActivity.setContentView(com.baidu.tieba.w.about_activity);
        this.cad = (RelativeLayout) this.mActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mActivity.getPageContext().getString(com.baidu.tieba.y.version_info));
        this.cae = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_versioninfo);
        this.caf = (ImageView) this.mActivity.findViewById(com.baidu.tieba.v.text_description);
        this.cah = (SettingTextTestNewView) this.mActivity.findViewById(com.baidu.tieba.v.about_version_update);
        this.caj = (SettingTextFunctionIntroView) this.mActivity.findViewById(com.baidu.tieba.v.about_function_intro);
        this.cai = (TbSettingTextTipView) this.mActivity.findViewById(com.baidu.tieba.v.about_guide);
        this.cai.hideArrow();
        this.cak = (ProgressBar) this.mActivity.findViewById(com.baidu.tieba.v.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !bd.isEmpty(TbConfig.getSubVersion())) {
            version = String.valueOf(version) + "." + TbConfig.getSubVersion();
        }
        this.cae.setText(String.valueOf(this.mActivity.getPageContext().getString(TbadkCoreApplication.m411getInst().getApplicationInfo().labelRes)) + this.mActivity.getPageContext().getString(com.baidu.tieba.y.setting_version_text) + " " + version);
        this.cag = (TextView) this.mActivity.findViewById(com.baidu.tieba.v.text_version_protoco);
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015000) == null) {
            this.cai.setVisibility(4);
        }
        if (!TbConfig.MAIN_PACKAGE_NAME.equals(TbadkCoreApplication.m411getInst().getApplicationInfo().packageName)) {
            this.caj.setVisibility(4);
        }
    }

    private void a(q qVar) {
        e eVar = new e(this, qVar);
        this.cah.setOnClickListener(eVar);
        this.cai.setOnClickListener(eVar);
        this.caj.setOnClickListener(eVar);
        this.cae.setOnClickListener(eVar);
    }

    public void agz() {
        if (this.cah != null) {
            this.cah.refresh();
        }
        if (this.caj != null) {
            this.caj.refresh();
        }
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.j(this.cad, com.baidu.tieba.s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mActivity.getLayoutMode().X(i == 1);
        this.mActivity.getLayoutMode().h(this.cad);
        agz();
    }
}
