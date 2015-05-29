package com.baidu.tieba.setting.more;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.g {
    private View LG;
    private SystemHelpSettingActivity cgU;
    private TbSettingTextTipView cgV;
    private TbSettingTextTipView cgW;
    private BdSwitchView cgX;
    private TbSettingTextNewDotView cgY;
    private final CustomMessageListener cgZ;
    private NavigationBar mNavigationBar;

    public bc(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cgU = null;
        this.LG = null;
        this.cgV = null;
        this.cgW = null;
        this.cgX = null;
        this.cgY = null;
        this.cgZ = new bd(this, 2001310);
        this.cgU = systemHelpSettingActivity;
        this.cgU.setContentView(com.baidu.tieba.r.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cgU.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cgU.getPageContext().getString(com.baidu.tieba.t.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cgV = (TbSettingTextTipView) this.cgU.findViewById(com.baidu.tieba.q.clear_cache);
        this.cgV.hideArrow();
        this.cgV.setOnClickListener(this.cgU);
        this.cgW = (TbSettingTextTipView) this.cgU.findViewById(com.baidu.tieba.q.clear_im);
        this.cgW.hideArrow();
        this.cgW.setOnClickListener(this.cgU);
        this.cgX = (BdSwitchView) this.cgU.findViewById(com.baidu.tieba.q.item_switch);
        com.baidu.adp.lib.util.n.a(this.cgU.getPageContext().getPageActivity(), this.cgX, 10, 10, 10, 10);
        this.cgX.setOnSwitchStateChangeListener(this.cgU);
        this.LG = this.cgU.findViewById(com.baidu.tieba.q.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cgW.setVisibility(0);
        } else {
            this.cgW.setVisibility(8);
        }
        this.cgY = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.q.sv_plugin_center);
        this.cgY.setOnClickListener(this.cgU);
        if (this.cgU != null) {
            this.cgZ.setTag(this.cgU.getUniqueId());
            MessageManager.getInstance().registerListener(this.cgZ);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cgY.setVisibility(0);
        } else {
            this.cgY.setVisibility(8);
        }
    }

    public BdSwitchView ajW() {
        return this.cgX;
    }

    public TbSettingTextTipView ajX() {
        return this.cgV;
    }

    public TbSettingTextTipView ajY() {
        return this.cgW;
    }

    public void onChangeSkinType(int i) {
        this.cgU.getLayoutMode().ab(i == 1);
        this.cgU.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cgX.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        com.baidu.tbadk.core.util.ay.i(this.cgV, com.baidu.tieba.p.more_all);
    }

    public TbSettingTextNewDotView ajZ() {
        return this.cgY;
    }
}
