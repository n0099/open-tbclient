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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View MA;
    private SystemHelpSettingActivity dvV;
    private TbSettingTextTipView dvW;
    private TbSettingTextTipView dvX;
    private BdSwitchView dvY;
    private TbSettingTextNewDotView dvZ;
    private TbSettingTextTipView dwa;
    private final CustomMessageListener dwb;
    private NavigationBar mNavigationBar;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.dvV = null;
        this.MA = null;
        this.dvW = null;
        this.dvX = null;
        this.dvY = null;
        this.dvZ = null;
        this.dwb = new az(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.dvV = systemHelpSettingActivity;
        this.dvV.setContentView(n.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.dvV.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dvV.getPageContext().getString(n.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dvW = (TbSettingTextTipView) this.dvV.findViewById(n.g.clear_cache);
        this.dvW.hideArrow();
        this.dvW.setOnClickListener(this.dvV);
        this.dvX = (TbSettingTextTipView) this.dvV.findViewById(n.g.clear_im);
        this.dvX.hideArrow();
        this.dvX.setOnClickListener(this.dvV);
        this.dvY = (BdSwitchView) this.dvV.findViewById(n.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.dvV.getPageContext().getPageActivity(), this.dvY, 10, 10, 10, 10);
        this.dvY.setOnSwitchStateChangeListener(this.dvV);
        this.MA = this.dvV.findViewById(n.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.dvX.setVisibility(0);
        } else {
            this.dvX.setVisibility(8);
        }
        this.dvZ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(n.g.sv_plugin_center);
        this.dvZ.setOnClickListener(this.dvV);
        if (this.dvV != null) {
            this.dwb.setTag(this.dvV.getUniqueId());
            MessageManager.getInstance().registerListener(this.dwb);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.dvZ.setVisibility(0);
        } else {
            this.dvZ.setVisibility(8);
        }
        this.dwa = (TbSettingTextTipView) this.dvV.findViewById(n.g.baidu_wallet);
        this.dwa.setOnClickListener(this.dvV);
        if (!com.baidu.tbadk.pay.e.Eg().Eh()) {
            this.dwa.setVisibility(8);
        }
    }

    public BdSwitchView aBp() {
        return this.dvY;
    }

    public TbSettingTextTipView aBq() {
        return this.dvW;
    }

    public TbSettingTextTipView aBr() {
        return this.dvX;
    }

    public TbSettingTextTipView aBs() {
        return this.dwa;
    }

    public void onChangeSkinType(int i) {
        this.dvV.getLayoutMode().ac(i == 1);
        this.dvV.getLayoutMode().k(this.MA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvY.a(com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_open), com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_close), com.baidu.tbadk.core.util.as.cx(n.f.btn_handle));
        com.baidu.tbadk.core.util.as.i(this.dvW, n.f.more_all);
    }

    public TbSettingTextNewDotView aBt() {
        return this.dvZ;
    }
}
