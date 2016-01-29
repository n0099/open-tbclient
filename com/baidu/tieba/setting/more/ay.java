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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View MQ;
    private SystemHelpSettingActivity dLZ;
    private TbSettingTextTipView dMa;
    private TbSettingTextTipView dMb;
    private BdSwitchView dMc;
    private TbSettingTextNewDotView dMd;
    private TbSettingTextTipView dMe;
    private final CustomMessageListener dMf;
    private NavigationBar mNavigationBar;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.dLZ = null;
        this.MQ = null;
        this.dMa = null;
        this.dMb = null;
        this.dMc = null;
        this.dMd = null;
        this.dMf = new az(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.dLZ = systemHelpSettingActivity;
        this.dLZ.setContentView(t.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.dLZ.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dLZ.getPageContext().getString(t.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dMa = (TbSettingTextTipView) this.dLZ.findViewById(t.g.clear_cache);
        this.dMa.hideArrow();
        this.dMa.setOnClickListener(this.dLZ);
        this.dMb = (TbSettingTextTipView) this.dLZ.findViewById(t.g.clear_im);
        this.dMb.hideArrow();
        this.dMb.setOnClickListener(this.dLZ);
        this.dMc = (BdSwitchView) this.dLZ.findViewById(t.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.dLZ.getPageContext().getPageActivity(), this.dMc, 10, 10, 10, 10);
        this.dMc.setOnSwitchStateChangeListener(this.dLZ);
        this.MQ = this.dLZ.findViewById(t.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.dMb.setVisibility(0);
        } else {
            this.dMb.setVisibility(8);
        }
        this.dMd = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(t.g.sv_plugin_center);
        this.dMd.setOnClickListener(this.dLZ);
        if (this.dLZ != null) {
            this.dMf.setTag(this.dLZ.getUniqueId());
            MessageManager.getInstance().registerListener(this.dMf);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.dMd.setVisibility(0);
        } else {
            this.dMd.setVisibility(8);
        }
        this.dMe = (TbSettingTextTipView) this.dLZ.findViewById(t.g.baidu_wallet);
        this.dMe.setOnClickListener(this.dLZ);
        if (!com.baidu.tbadk.pay.e.FB().FC()) {
            this.dMe.setVisibility(8);
        }
    }

    public BdSwitchView aIw() {
        return this.dMc;
    }

    public TbSettingTextTipView aIx() {
        return this.dMa;
    }

    public TbSettingTextTipView aIy() {
        return this.dMb;
    }

    public TbSettingTextTipView aIz() {
        return this.dMe;
    }

    public void onChangeSkinType(int i) {
        this.dLZ.getLayoutMode().ac(i == 1);
        this.dLZ.getLayoutMode().x(this.MQ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dMc.a(com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_open), com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_close), com.baidu.tbadk.core.util.ar.cO(t.f.btn_handle));
        com.baidu.tbadk.core.util.ar.k(this.dMa, t.f.more_all);
    }

    public TbSettingTextNewDotView aIA() {
        return this.dMd;
    }
}
