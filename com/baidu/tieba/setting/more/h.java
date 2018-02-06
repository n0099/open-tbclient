package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gOI;
    private TbSettingTextTipView gOJ;
    private TbSettingTextTipView gOK;
    private BdSwitchView gOL;
    private BdSwitchView gOM;
    private TbSettingTextNewDotView gON;
    private final CustomMessageListener gOO;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gOI = null;
        this.mParent = null;
        this.gOJ = null;
        this.gOK = null;
        this.gOL = null;
        this.gOM = null;
        this.gON = null;
        this.gOO = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gOI = systemHelpSettingActivity;
        this.gOI.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gOI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gOI.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOJ = (TbSettingTextTipView) this.gOI.findViewById(d.g.clear_cache);
        this.gOJ.hideArrow();
        this.gOJ.setOnClickListener(this.gOI);
        this.gOJ.setBottomLineVisibility(true);
        this.gOK = (TbSettingTextTipView) this.gOI.findViewById(d.g.clear_im);
        this.gOK.hideArrow();
        this.gOK.setBottomLineVisibility(true);
        this.gOK.setOnClickListener(this.gOI);
        this.gOL = (BdSwitchView) this.gOI.findViewById(d.g.item_switch);
        l.a(this.gOI.getPageContext().getPageActivity(), this.gOL, 10, 10, 10, 10);
        this.gOL.setOnSwitchStateChangeListener(this.gOI);
        this.gOM = (BdSwitchView) this.gOI.findViewById(d.g.setting_save_video_switch);
        l.a(this.gOI.getPageContext().getPageActivity(), this.gOM, 10, 10, 10, 10);
        this.gOM.setOnSwitchStateChangeListener(this.gOI);
        this.mParent = this.gOI.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gOK.setVisibility(0);
        } else {
            this.gOK.setVisibility(8);
        }
        this.gON = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gON.setOnClickListener(this.gOI);
        if (this.gOI != null) {
            this.gOO.setTag(this.gOI.getUniqueId());
            MessageManager.getInstance().registerListener(this.gOO);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gON.setVisibility(0);
        } else {
            this.gON.setVisibility(8);
        }
    }

    public BdSwitchView brY() {
        return this.gOM;
    }

    public BdSwitchView brZ() {
        return this.gOL;
    }

    public TbSettingTextTipView bsa() {
        return this.gOJ;
    }

    public TbSettingTextTipView bsb() {
        return this.gOK;
    }

    public void onChangeSkinType(int i) {
        this.gOI.getLayoutMode().aQ(i == 1);
        this.gOI.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOL.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.gOM.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.s(this.gOJ, d.f.more_all);
    }

    public TbSettingTextNewDotView bsc() {
        return this.gON;
    }
}
