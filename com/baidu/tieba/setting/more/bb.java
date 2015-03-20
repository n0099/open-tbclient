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
    private RelativeLayout aWN;
    private SystemHelpSettingActivity ccc;
    private TbSettingTextTipView ccd;
    private TbSettingTextTipView cce;
    private BdSwitchView ccf;
    private TbSettingTextNewDotView ccg;
    private View cch;
    private final CustomMessageListener cci;
    private NavigationBar mNavigationBar;

    public bb(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.ccc = null;
        this.aWN = null;
        this.ccd = null;
        this.cce = null;
        this.ccf = null;
        this.ccg = null;
        this.cch = null;
        this.cci = new bc(this, 2001310);
        this.ccc = systemHelpSettingActivity;
        this.ccc.setContentView(com.baidu.tieba.w.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.ccc.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ccc.getPageContext().getString(com.baidu.tieba.y.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ccd = (TbSettingTextTipView) this.ccc.findViewById(com.baidu.tieba.v.clear_cache);
        this.ccd.hideArrow();
        this.ccd.setOnClickListener(this.ccc);
        this.cce = (TbSettingTextTipView) this.ccc.findViewById(com.baidu.tieba.v.clear_im);
        this.cce.hideArrow();
        this.cce.setOnClickListener(this.ccc);
        this.ccf = (BdSwitchView) this.ccc.findViewById(com.baidu.tieba.v.item_switch);
        com.baidu.adp.lib.util.n.a(this.ccc.getPageContext().getPageActivity(), this.ccf, 10, 10, 10, 10);
        this.ccf.setOnSwitchStateChangeListener(this.ccc);
        this.aWN = (RelativeLayout) this.ccc.findViewById(com.baidu.tieba.v.parent);
        this.cch = this.ccc.findViewById(com.baidu.tieba.v.line1);
        if (TbadkCoreApplication.isLogin()) {
            this.cce.setVisibility(0);
        } else {
            this.cce.setVisibility(8);
        }
        this.ccg = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.v.sv_plugin_center);
        this.ccg.setOnClickListener(this.ccc);
        if (this.ccc != null) {
            this.cci.setTag(this.ccc.getUniqueId());
            MessageManager.getInstance().registerListener(this.cci);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.ccg.setVisibility(0);
            this.cch.setVisibility(0);
            return;
        }
        this.ccg.setVisibility(8);
        this.cch.setVisibility(8);
    }

    public BdSwitchView ahQ() {
        return this.ccf;
    }

    public TbSettingTextTipView ahR() {
        return this.ccd;
    }

    public TbSettingTextTipView ahS() {
        return this.cce;
    }

    public void onChangeSkinType(int i) {
        this.ccc.getLayoutMode().X(i == 1);
        this.ccc.getLayoutMode().h(this.aWN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccf.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        com.baidu.tbadk.core.util.ba.i(this.ccd, com.baidu.tieba.u.more_all);
    }

    public TbSettingTextNewDotView ahT() {
        return this.ccg;
    }
}
