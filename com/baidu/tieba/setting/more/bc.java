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
    private SystemHelpSettingActivity cgV;
    private TbSettingTextTipView cgW;
    private TbSettingTextTipView cgX;
    private BdSwitchView cgY;
    private TbSettingTextNewDotView cgZ;
    private final CustomMessageListener cha;
    private NavigationBar mNavigationBar;

    public bc(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cgV = null;
        this.LG = null;
        this.cgW = null;
        this.cgX = null;
        this.cgY = null;
        this.cgZ = null;
        this.cha = new bd(this, 2001310);
        this.cgV = systemHelpSettingActivity;
        this.cgV.setContentView(com.baidu.tieba.r.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cgV.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cgV.getPageContext().getString(com.baidu.tieba.t.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cgW = (TbSettingTextTipView) this.cgV.findViewById(com.baidu.tieba.q.clear_cache);
        this.cgW.hideArrow();
        this.cgW.setOnClickListener(this.cgV);
        this.cgX = (TbSettingTextTipView) this.cgV.findViewById(com.baidu.tieba.q.clear_im);
        this.cgX.hideArrow();
        this.cgX.setOnClickListener(this.cgV);
        this.cgY = (BdSwitchView) this.cgV.findViewById(com.baidu.tieba.q.item_switch);
        com.baidu.adp.lib.util.n.a(this.cgV.getPageContext().getPageActivity(), this.cgY, 10, 10, 10, 10);
        this.cgY.setOnSwitchStateChangeListener(this.cgV);
        this.LG = this.cgV.findViewById(com.baidu.tieba.q.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cgX.setVisibility(0);
        } else {
            this.cgX.setVisibility(8);
        }
        this.cgZ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.q.sv_plugin_center);
        this.cgZ.setOnClickListener(this.cgV);
        if (this.cgV != null) {
            this.cha.setTag(this.cgV.getUniqueId());
            MessageManager.getInstance().registerListener(this.cha);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cgZ.setVisibility(0);
        } else {
            this.cgZ.setVisibility(8);
        }
    }

    public BdSwitchView ajX() {
        return this.cgY;
    }

    public TbSettingTextTipView ajY() {
        return this.cgW;
    }

    public TbSettingTextTipView ajZ() {
        return this.cgX;
    }

    public void onChangeSkinType(int i) {
        this.cgV.getLayoutMode().ab(i == 1);
        this.cgV.getLayoutMode().j(this.LG);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cgY.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        com.baidu.tbadk.core.util.ay.i(this.cgW, com.baidu.tieba.p.more_all);
    }

    public TbSettingTextNewDotView aka() {
        return this.cgZ;
    }
}
