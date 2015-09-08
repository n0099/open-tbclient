package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View LR;
    private SystemHelpSettingActivity cHq;
    private TbSettingTextTipView cHr;
    private TbSettingTextTipView cHs;
    private BdSwitchView cHt;
    private TbSettingTextNewDotView cHu;
    private TbSettingTextTipView cHv;
    private final CustomMessageListener cHw;
    private NavigationBar mNavigationBar;

    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cHq = null;
        this.LR = null;
        this.cHr = null;
        this.cHs = null;
        this.cHt = null;
        this.cHu = null;
        this.cHw = new aw(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.cHq = systemHelpSettingActivity;
        this.cHq.setContentView(i.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cHq.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cHq.getPageContext().getString(i.h.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cHr = (TbSettingTextTipView) this.cHq.findViewById(i.f.clear_cache);
        this.cHr.hideArrow();
        this.cHr.setOnClickListener(this.cHq);
        this.cHs = (TbSettingTextTipView) this.cHq.findViewById(i.f.clear_im);
        this.cHs.hideArrow();
        this.cHs.setOnClickListener(this.cHq);
        this.cHt = (BdSwitchView) this.cHq.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cHq.getPageContext().getPageActivity(), this.cHt, 10, 10, 10, 10);
        this.cHt.setOnSwitchStateChangeListener(this.cHq);
        this.LR = this.cHq.findViewById(i.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cHs.setVisibility(0);
        } else {
            this.cHs.setVisibility(8);
        }
        this.cHu = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(i.f.sv_plugin_center);
        this.cHu.setOnClickListener(this.cHq);
        if (this.cHq != null) {
            this.cHw.setTag(this.cHq.getUniqueId());
            MessageManager.getInstance().registerListener(this.cHw);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cHu.setVisibility(0);
        } else {
            this.cHu.setVisibility(8);
        }
        this.cHv = (TbSettingTextTipView) this.cHq.findViewById(i.f.baidu_wallet);
        this.cHv.setOnClickListener(this.cHq);
        if (!com.baidu.tbadk.pay.e.DN().DO()) {
            this.cHv.setVisibility(8);
        }
    }

    public BdSwitchView aqH() {
        return this.cHt;
    }

    public TbSettingTextTipView aqI() {
        return this.cHr;
    }

    public TbSettingTextTipView aqJ() {
        return this.cHs;
    }

    public TbSettingTextTipView aqK() {
        return this.cHv;
    }

    public void onChangeSkinType(int i) {
        this.cHq.getLayoutMode().ad(i == 1);
        this.cHq.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cHt.a(com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cu(i.e.btn_handle));
        com.baidu.tbadk.core.util.al.h(this.cHr, i.e.more_all);
    }

    public TbSettingTextNewDotView aqL() {
        return this.cHu;
    }
}
