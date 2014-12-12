package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.base.g {
    private SettingTextSwitchView bwA;
    private TbSettingTextTipView bwB;
    private TbSettingTextTipView bwC;
    private TbSettingTextNewDotView bwD;
    private SystemHelpSettingActivity bwy;
    private SettingTextSwitchView bwz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public aw(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.bwy = null;
        this.mParent = null;
        this.bwz = null;
        this.bwA = null;
        this.bwB = null;
        this.bwC = null;
        this.bwD = null;
        this.bwy = systemHelpSettingActivity;
        this.bwy.setContentView(com.baidu.tieba.x.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.bwy.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bwy.getPageContext().getString(com.baidu.tieba.z.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bwz = (SettingTextSwitchView) this.bwy.findViewById(com.baidu.tieba.w.tieba_helper_open);
        this.bwz.setSwitchStateChangeListener(this.bwy);
        this.bwA = (SettingTextSwitchView) this.bwy.findViewById(com.baidu.tieba.w.sv_earphone);
        this.bwB = (TbSettingTextTipView) this.bwy.findViewById(com.baidu.tieba.w.clear_cache);
        this.bwB.tG();
        this.bwB.setOnClickListener(this.bwy);
        this.bwC = (TbSettingTextTipView) this.bwy.findViewById(com.baidu.tieba.w.clear_im);
        this.bwC.tG();
        this.bwC.setOnClickListener(this.bwy);
        this.bwA.setSwitchStateChangeListener(this.bwy);
        this.mParent = (RelativeLayout) this.bwy.findViewById(com.baidu.tieba.w.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.bwC.setVisibility(0);
        } else {
            this.bwC.setVisibility(8);
        }
        this.bwD = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.w.sv_plugin_center);
        this.bwD.setOnClickListener(this.bwy);
        if (((Hao123Plugin) PluginCenter.gX().hc()) == null) {
            this.bwz.setVisibility(8);
        }
    }

    public BdSwitchView VQ() {
        return this.bwz.getSwitchView();
    }

    public SettingTextSwitchView VR() {
        return this.bwz;
    }

    public BdSwitchView VS() {
        return this.bwA.getSwitchView();
    }

    public TbSettingTextTipView VT() {
        return this.bwB;
    }

    public TbSettingTextTipView VU() {
        return this.bwC;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bwA.cT(i);
        this.bwz.cT(i);
        ax.i(this.bwA, com.baidu.tieba.v.more_all);
        ax.i(this.bwB, com.baidu.tieba.v.more_all);
        this.bwy.getLayoutMode().ab(i == 1);
        this.bwy.getLayoutMode().h(this.mParent);
    }

    public TbSettingTextNewDotView VV() {
        return this.bwD;
    }
}
