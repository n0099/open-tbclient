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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.base.f<SystemHelpSettingActivity> {
    private View Mk;
    private SystemHelpSettingActivity doI;
    private TbSettingTextTipView doJ;
    private TbSettingTextTipView doK;
    private BdSwitchView doL;
    private TbSettingTextNewDotView doM;
    private TbSettingTextTipView doN;
    private final CustomMessageListener doO;
    private NavigationBar mNavigationBar;

    public ax(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.doI = null;
        this.Mk = null;
        this.doJ = null;
        this.doK = null;
        this.doL = null;
        this.doM = null;
        this.doO = new ay(this, CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED);
        this.doI = systemHelpSettingActivity;
        this.doI.setContentView(n.g.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.doI.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.doI.getPageContext().getString(n.i.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.doJ = (TbSettingTextTipView) this.doI.findViewById(n.f.clear_cache);
        this.doJ.hideArrow();
        this.doJ.setOnClickListener(this.doI);
        this.doK = (TbSettingTextTipView) this.doI.findViewById(n.f.clear_im);
        this.doK.hideArrow();
        this.doK.setOnClickListener(this.doI);
        this.doL = (BdSwitchView) this.doI.findViewById(n.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.doI.getPageContext().getPageActivity(), this.doL, 10, 10, 10, 10);
        this.doL.setOnSwitchStateChangeListener(this.doI);
        this.Mk = this.doI.findViewById(n.f.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.doK.setVisibility(0);
        } else {
            this.doK.setVisibility(8);
        }
        this.doM = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(n.f.sv_plugin_center);
        this.doM.setOnClickListener(this.doI);
        if (this.doI != null) {
            this.doO.setTag(this.doI.getUniqueId());
            MessageManager.getInstance().registerListener(this.doO);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.doM.setVisibility(0);
        } else {
            this.doM.setVisibility(8);
        }
        this.doN = (TbSettingTextTipView) this.doI.findViewById(n.f.baidu_wallet);
        this.doN.setOnClickListener(this.doI);
        if (!com.baidu.tbadk.pay.e.Er().Es()) {
            this.doN.setVisibility(8);
        }
    }

    public BdSwitchView azj() {
        return this.doL;
    }

    public TbSettingTextTipView azk() {
        return this.doJ;
    }

    public TbSettingTextTipView azl() {
        return this.doK;
    }

    public TbSettingTextTipView azm() {
        return this.doN;
    }

    public void onChangeSkinType(int i) {
        this.doI.getLayoutMode().af(i == 1);
        this.doI.getLayoutMode().k(this.Mk);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.doL.a(com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_open), com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_close), com.baidu.tbadk.core.util.as.cE(n.e.btn_handle));
        com.baidu.tbadk.core.util.as.i(this.doJ, n.e.more_all);
    }

    public TbSettingTextNewDotView azn() {
        return this.doM;
    }
}
