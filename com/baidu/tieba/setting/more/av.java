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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View LS;
    private SystemHelpSettingActivity cOQ;
    private TbSettingTextTipView cOR;
    private TbSettingTextTipView cOS;
    private BdSwitchView cOT;
    private TbSettingTextNewDotView cOU;
    private TbSettingTextTipView cOV;
    private final CustomMessageListener cOW;
    private NavigationBar mNavigationBar;

    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cOQ = null;
        this.LS = null;
        this.cOR = null;
        this.cOS = null;
        this.cOT = null;
        this.cOU = null;
        this.cOW = new aw(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.cOQ = systemHelpSettingActivity;
        this.cOQ.setContentView(i.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cOQ.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cOQ.getPageContext().getString(i.h.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOR = (TbSettingTextTipView) this.cOQ.findViewById(i.f.clear_cache);
        this.cOR.hideArrow();
        this.cOR.setOnClickListener(this.cOQ);
        this.cOS = (TbSettingTextTipView) this.cOQ.findViewById(i.f.clear_im);
        this.cOS.hideArrow();
        this.cOS.setOnClickListener(this.cOQ);
        this.cOT = (BdSwitchView) this.cOQ.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cOQ.getPageContext().getPageActivity(), this.cOT, 10, 10, 10, 10);
        this.cOT.setOnSwitchStateChangeListener(this.cOQ);
        this.LS = this.cOQ.findViewById(i.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cOS.setVisibility(0);
        } else {
            this.cOS.setVisibility(8);
        }
        this.cOU = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(i.f.sv_plugin_center);
        this.cOU.setOnClickListener(this.cOQ);
        if (this.cOQ != null) {
            this.cOW.setTag(this.cOQ.getUniqueId());
            MessageManager.getInstance().registerListener(this.cOW);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cOU.setVisibility(0);
        } else {
            this.cOU.setVisibility(8);
        }
        this.cOV = (TbSettingTextTipView) this.cOQ.findViewById(i.f.baidu_wallet);
        this.cOV.setOnClickListener(this.cOQ);
        if (!com.baidu.tbadk.pay.e.Dx().Dy()) {
            this.cOV.setVisibility(8);
        }
    }

    public BdSwitchView atb() {
        return this.cOT;
    }

    public TbSettingTextTipView atc() {
        return this.cOR;
    }

    public TbSettingTextTipView atd() {
        return this.cOS;
    }

    public TbSettingTextTipView ate() {
        return this.cOV;
    }

    public void onChangeSkinType(int i) {
        this.cOQ.getLayoutMode().ad(i == 1);
        this.cOQ.getLayoutMode().k(this.LS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cOT.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.an.i(this.cOR, i.e.more_all);
    }

    public TbSettingTextNewDotView atf() {
        return this.cOU;
    }
}
