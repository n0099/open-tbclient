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
    private View LT;
    private SystemHelpSettingActivity cQm;
    private TbSettingTextTipView cQn;
    private TbSettingTextTipView cQo;
    private BdSwitchView cQp;
    private TbSettingTextNewDotView cQq;
    private TbSettingTextTipView cQr;
    private final CustomMessageListener cQs;
    private NavigationBar mNavigationBar;

    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cQm = null;
        this.LT = null;
        this.cQn = null;
        this.cQo = null;
        this.cQp = null;
        this.cQq = null;
        this.cQs = new aw(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.cQm = systemHelpSettingActivity;
        this.cQm.setContentView(i.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cQm.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cQm.getPageContext().getString(i.h.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cQn = (TbSettingTextTipView) this.cQm.findViewById(i.f.clear_cache);
        this.cQn.hideArrow();
        this.cQn.setOnClickListener(this.cQm);
        this.cQo = (TbSettingTextTipView) this.cQm.findViewById(i.f.clear_im);
        this.cQo.hideArrow();
        this.cQo.setOnClickListener(this.cQm);
        this.cQp = (BdSwitchView) this.cQm.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cQm.getPageContext().getPageActivity(), this.cQp, 10, 10, 10, 10);
        this.cQp.setOnSwitchStateChangeListener(this.cQm);
        this.LT = this.cQm.findViewById(i.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cQo.setVisibility(0);
        } else {
            this.cQo.setVisibility(8);
        }
        this.cQq = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(i.f.sv_plugin_center);
        this.cQq.setOnClickListener(this.cQm);
        if (this.cQm != null) {
            this.cQs.setTag(this.cQm.getUniqueId());
            MessageManager.getInstance().registerListener(this.cQs);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cQq.setVisibility(0);
        } else {
            this.cQq.setVisibility(8);
        }
        this.cQr = (TbSettingTextTipView) this.cQm.findViewById(i.f.baidu_wallet);
        this.cQr.setOnClickListener(this.cQm);
        if (!com.baidu.tbadk.pay.e.Dq().Dr()) {
            this.cQr.setVisibility(8);
        }
    }

    public BdSwitchView atH() {
        return this.cQp;
    }

    public TbSettingTextTipView atI() {
        return this.cQn;
    }

    public TbSettingTextTipView atJ() {
        return this.cQo;
    }

    public TbSettingTextTipView atK() {
        return this.cQr;
    }

    public void onChangeSkinType(int i) {
        this.cQm.getLayoutMode().ad(i == 1);
        this.cQm.getLayoutMode().k(this.LT);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cQp.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        com.baidu.tbadk.core.util.an.i(this.cQn, i.e.more_all);
    }

    public TbSettingTextNewDotView atL() {
        return this.cQq;
    }
}
