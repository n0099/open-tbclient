package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.g {
    private RelativeLayout aXd;
    private SystemHelpSettingActivity ccr;
    private TbSettingTextTipView ccs;
    private TbSettingTextTipView cct;
    private BdSwitchView ccu;
    private TbSettingTextNewDotView ccv;
    private View ccw;
    private final CustomMessageListener ccx;
    private NavigationBar mNavigationBar;

    public bb(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.ccr = null;
        this.aXd = null;
        this.ccs = null;
        this.cct = null;
        this.ccu = null;
        this.ccv = null;
        this.ccw = null;
        this.ccx = new bc(this, 2001310);
        this.ccr = systemHelpSettingActivity;
        this.ccr.setContentView(com.baidu.tieba.w.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.ccr.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ccr.getPageContext().getString(com.baidu.tieba.y.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ccs = (TbSettingTextTipView) this.ccr.findViewById(com.baidu.tieba.v.clear_cache);
        this.ccs.hideArrow();
        this.ccs.setOnClickListener(this.ccr);
        this.cct = (TbSettingTextTipView) this.ccr.findViewById(com.baidu.tieba.v.clear_im);
        this.cct.hideArrow();
        this.cct.setOnClickListener(this.ccr);
        this.ccu = (BdSwitchView) this.ccr.findViewById(com.baidu.tieba.v.item_switch);
        com.baidu.adp.lib.util.n.a(this.ccr.getPageContext().getPageActivity(), this.ccu, 10, 10, 10, 10);
        this.ccu.setOnSwitchStateChangeListener(this.ccr);
        this.aXd = (RelativeLayout) this.ccr.findViewById(com.baidu.tieba.v.parent);
        this.ccw = this.ccr.findViewById(com.baidu.tieba.v.line1);
        if (TbadkCoreApplication.isLogin()) {
            this.cct.setVisibility(0);
        } else {
            this.cct.setVisibility(8);
        }
        this.ccv = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.v.sv_plugin_center);
        this.ccv.setOnClickListener(this.ccr);
        if (this.ccr != null) {
            this.ccx.setTag(this.ccr.getUniqueId());
            MessageManager.getInstance().registerListener(this.ccx);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.ccv.setVisibility(0);
            this.ccw.setVisibility(0);
            return;
        }
        this.ccv.setVisibility(8);
        this.ccw.setVisibility(8);
    }

    public BdSwitchView aif() {
        return this.ccu;
    }

    public TbSettingTextTipView aig() {
        return this.ccs;
    }

    public TbSettingTextTipView aih() {
        return this.cct;
    }

    public void onChangeSkinType(int i) {
        this.ccr.getLayoutMode().X(i == 1);
        this.ccr.getLayoutMode().h(this.aXd);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccu.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        com.baidu.tbadk.core.util.ba.i(this.ccs, com.baidu.tieba.u.more_all);
    }

    public TbSettingTextNewDotView aii() {
        return this.ccv;
    }
}
