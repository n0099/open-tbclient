package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.base.g {
    private SystemHelpSettingActivity byi;
    private SettingTextSwitchView byj;
    private TbSettingTextTipView byk;
    private TbSettingTextTipView byl;
    private TbSettingTextNewDotView bym;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public bi(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.byi = null;
        this.mParent = null;
        this.byj = null;
        this.byk = null;
        this.byl = null;
        this.bym = null;
        this.byi = systemHelpSettingActivity;
        this.byi.setContentView(com.baidu.tieba.x.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.byi.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.byi.getPageContext().getString(com.baidu.tieba.z.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.byj = (SettingTextSwitchView) this.byi.findViewById(com.baidu.tieba.w.sv_earphone);
        this.byk = (TbSettingTextTipView) this.byi.findViewById(com.baidu.tieba.w.clear_cache);
        this.byk.tX();
        this.byk.setOnClickListener(this.byi);
        this.byl = (TbSettingTextTipView) this.byi.findViewById(com.baidu.tieba.w.clear_im);
        this.byl.tX();
        this.byl.setOnClickListener(this.byi);
        this.byj.setSwitchStateChangeListener(this.byi);
        this.mParent = (RelativeLayout) this.byi.findViewById(com.baidu.tieba.w.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.byl.setVisibility(0);
        } else {
            this.byl.setVisibility(8);
        }
        this.bym = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.w.sv_plugin_center);
        this.bym.setOnClickListener(this.byi);
    }

    public BdSwitchView Wx() {
        return this.byj.getSwitchView();
    }

    public TbSettingTextTipView Wy() {
        return this.byk;
    }

    public TbSettingTextTipView Wz() {
        return this.byl;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.byj.da(i);
        com.baidu.tbadk.core.util.bc.i(this.byj, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.byk, com.baidu.tieba.v.more_all);
        this.byi.getLayoutMode().ab(i == 1);
        this.byi.getLayoutMode().h(this.mParent);
    }

    public TbSettingTextNewDotView WA() {
        return this.bym;
    }
}
