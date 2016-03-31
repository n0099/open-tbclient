package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View MW;
    private TbSettingTextTipView eeA;
    private TbSettingTextTipView eeB;
    private BdSwitchView eeC;
    private TbSettingTextNewDotView eeD;
    private TbSettingTextTipView eeE;
    private final CustomMessageListener eeF;
    private SystemHelpSettingActivity eez;
    private NavigationBar mNavigationBar;

    public ba(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.eez = null;
        this.MW = null;
        this.eeA = null;
        this.eeB = null;
        this.eeC = null;
        this.eeD = null;
        this.eeF = new bb(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.eez = systemHelpSettingActivity;
        this.eez.setContentView(t.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.eez.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.eez.getPageContext().getString(t.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eeA = (TbSettingTextTipView) this.eez.findViewById(t.g.clear_cache);
        this.eeA.hideArrow();
        this.eeA.setOnClickListener(this.eez);
        this.eeB = (TbSettingTextTipView) this.eez.findViewById(t.g.clear_im);
        this.eeB.hideArrow();
        this.eeB.setOnClickListener(this.eez);
        this.eeC = (BdSwitchView) this.eez.findViewById(t.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.eez.getPageContext().getPageActivity(), this.eeC, 10, 10, 10, 10);
        this.eeC.setOnSwitchStateChangeListener(this.eez);
        this.MW = this.eez.findViewById(t.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.eeB.setVisibility(0);
        } else {
            this.eeB.setVisibility(8);
        }
        this.eeD = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(t.g.sv_plugin_center);
        this.eeD.setOnClickListener(this.eez);
        if (this.eez != null) {
            this.eeF.setTag(this.eez.getUniqueId());
            MessageManager.getInstance().registerListener(this.eeF);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.eeD.setVisibility(0);
        } else {
            this.eeD.setVisibility(8);
        }
        this.eeE = (TbSettingTextTipView) this.eez.findViewById(t.g.baidu_wallet);
        this.eeE.setOnClickListener(this.eez);
        if (!com.baidu.tbadk.pay.e.Gx().Gy()) {
            this.eeE.setVisibility(8);
        }
    }

    public BdSwitchView aPl() {
        return this.eeC;
    }

    public TbSettingTextTipView aPm() {
        return this.eeA;
    }

    public TbSettingTextTipView aPn() {
        return this.eeB;
    }

    public TbSettingTextTipView aPo() {
        return this.eeE;
    }

    public void onChangeSkinType(int i) {
        this.eez.getLayoutMode().ab(i == 1);
        this.eez.getLayoutMode().x(this.MW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eeC.a(com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_open), com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_close), com.baidu.tbadk.core.util.at.cR(t.f.btn_handle));
        com.baidu.tbadk.core.util.at.k(this.eeA, t.f.more_all);
    }

    public TbSettingTextNewDotView aPp() {
        return this.eeD;
    }
}
