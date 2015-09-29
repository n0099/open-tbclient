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
    private View LR;
    private SystemHelpSettingActivity cOr;
    private TbSettingTextTipView cOs;
    private TbSettingTextTipView cOt;
    private BdSwitchView cOu;
    private TbSettingTextNewDotView cOv;
    private TbSettingTextTipView cOw;
    private final CustomMessageListener cOx;
    private NavigationBar mNavigationBar;

    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cOr = null;
        this.LR = null;
        this.cOs = null;
        this.cOt = null;
        this.cOu = null;
        this.cOv = null;
        this.cOx = new aw(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.cOr = systemHelpSettingActivity;
        this.cOr.setContentView(i.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cOr.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cOr.getPageContext().getString(i.h.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOs = (TbSettingTextTipView) this.cOr.findViewById(i.f.clear_cache);
        this.cOs.hideArrow();
        this.cOs.setOnClickListener(this.cOr);
        this.cOt = (TbSettingTextTipView) this.cOr.findViewById(i.f.clear_im);
        this.cOt.hideArrow();
        this.cOt.setOnClickListener(this.cOr);
        this.cOu = (BdSwitchView) this.cOr.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cOr.getPageContext().getPageActivity(), this.cOu, 10, 10, 10, 10);
        this.cOu.setOnSwitchStateChangeListener(this.cOr);
        this.LR = this.cOr.findViewById(i.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cOt.setVisibility(0);
        } else {
            this.cOt.setVisibility(8);
        }
        this.cOv = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(i.f.sv_plugin_center);
        this.cOv.setOnClickListener(this.cOr);
        if (this.cOr != null) {
            this.cOx.setTag(this.cOr.getUniqueId());
            MessageManager.getInstance().registerListener(this.cOx);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cOv.setVisibility(0);
        } else {
            this.cOv.setVisibility(8);
        }
        this.cOw = (TbSettingTextTipView) this.cOr.findViewById(i.f.baidu_wallet);
        this.cOw.setOnClickListener(this.cOr);
        if (!com.baidu.tbadk.pay.e.DA().DB()) {
            this.cOw.setVisibility(8);
        }
    }

    public BdSwitchView asZ() {
        return this.cOu;
    }

    public TbSettingTextTipView ata() {
        return this.cOs;
    }

    public TbSettingTextTipView atb() {
        return this.cOt;
    }

    public TbSettingTextTipView atc() {
        return this.cOw;
    }

    public void onChangeSkinType(int i) {
        this.cOr.getLayoutMode().ad(i == 1);
        this.cOr.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cOu.a(com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.am.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.am.i(this.cOs, i.e.more_all);
    }

    public TbSettingTextNewDotView atd() {
        return this.cOv;
    }
}
