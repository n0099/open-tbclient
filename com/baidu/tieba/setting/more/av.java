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
    private SystemHelpSettingActivity cyS;
    private TbSettingTextTipView cyT;
    private TbSettingTextTipView cyU;
    private BdSwitchView cyV;
    private TbSettingTextNewDotView cyW;
    private TbSettingTextTipView cyX;
    private final CustomMessageListener cyY;
    private NavigationBar mNavigationBar;

    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.cyS = null;
        this.LR = null;
        this.cyT = null;
        this.cyU = null;
        this.cyV = null;
        this.cyW = null;
        this.cyY = new aw(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.cyS = systemHelpSettingActivity;
        this.cyS.setContentView(i.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.cyS.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cyS.getPageContext().getString(i.C0057i.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cyT = (TbSettingTextTipView) this.cyS.findViewById(i.f.clear_cache);
        this.cyT.hideArrow();
        this.cyT.setOnClickListener(this.cyS);
        this.cyU = (TbSettingTextTipView) this.cyS.findViewById(i.f.clear_im);
        this.cyU.hideArrow();
        this.cyU.setOnClickListener(this.cyS);
        this.cyV = (BdSwitchView) this.cyS.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cyS.getPageContext().getPageActivity(), this.cyV, 10, 10, 10, 10);
        this.cyV.setOnSwitchStateChangeListener(this.cyS);
        this.LR = this.cyS.findViewById(i.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.cyU.setVisibility(0);
        } else {
            this.cyU.setVisibility(8);
        }
        this.cyW = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(i.f.sv_plugin_center);
        this.cyW.setOnClickListener(this.cyS);
        if (this.cyS != null) {
            this.cyY.setTag(this.cyS.getUniqueId());
            MessageManager.getInstance().registerListener(this.cyY);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.cyW.setVisibility(0);
        } else {
            this.cyW.setVisibility(8);
        }
        this.cyX = (TbSettingTextTipView) this.cyS.findViewById(i.f.baidu_wallet);
        this.cyX.setOnClickListener(this.cyS);
        if (!com.baidu.tbadk.pay.e.DD().DE()) {
            this.cyX.setVisibility(8);
        }
    }

    public BdSwitchView amy() {
        return this.cyV;
    }

    public TbSettingTextTipView amz() {
        return this.cyT;
    }

    public TbSettingTextTipView amA() {
        return this.cyU;
    }

    public TbSettingTextTipView amB() {
        return this.cyX;
    }

    public void onChangeSkinType(int i) {
        this.cyS.getLayoutMode().ad(i == 1);
        this.cyS.getLayoutMode().k(this.LR);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cyV.a(com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cq(i.e.btn_handle));
        com.baidu.tbadk.core.util.al.i(this.cyT, i.e.more_all);
    }

    public TbSettingTextNewDotView amC() {
        return this.cyW;
    }
}
