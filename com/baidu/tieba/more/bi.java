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
    private SystemHelpSettingActivity byh;
    private SettingTextSwitchView byi;
    private TbSettingTextTipView byj;
    private TbSettingTextTipView byk;
    private TbSettingTextNewDotView byl;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public bi(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.byh = null;
        this.mParent = null;
        this.byi = null;
        this.byj = null;
        this.byk = null;
        this.byl = null;
        this.byh = systemHelpSettingActivity;
        this.byh.setContentView(com.baidu.tieba.x.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.byh.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.byh.getPageContext().getString(com.baidu.tieba.z.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.byi = (SettingTextSwitchView) this.byh.findViewById(com.baidu.tieba.w.sv_earphone);
        this.byj = (TbSettingTextTipView) this.byh.findViewById(com.baidu.tieba.w.clear_cache);
        this.byj.tR();
        this.byj.setOnClickListener(this.byh);
        this.byk = (TbSettingTextTipView) this.byh.findViewById(com.baidu.tieba.w.clear_im);
        this.byk.tR();
        this.byk.setOnClickListener(this.byh);
        this.byi.setSwitchStateChangeListener(this.byh);
        this.mParent = (RelativeLayout) this.byh.findViewById(com.baidu.tieba.w.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.byk.setVisibility(0);
        } else {
            this.byk.setVisibility(8);
        }
        this.byl = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.w.sv_plugin_center);
        this.byl.setOnClickListener(this.byh);
    }

    public BdSwitchView Ws() {
        return this.byi.getSwitchView();
    }

    public TbSettingTextTipView Wt() {
        return this.byj;
    }

    public TbSettingTextTipView Wu() {
        return this.byk;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.byi.da(i);
        com.baidu.tbadk.core.util.bc.i(this.byi, com.baidu.tieba.v.more_all);
        com.baidu.tbadk.core.util.bc.i(this.byj, com.baidu.tieba.v.more_all);
        this.byh.getLayoutMode().ab(i == 1);
        this.byh.getLayoutMode().h(this.mParent);
    }

    public TbSettingTextNewDotView Wv() {
        return this.byl;
    }
}
