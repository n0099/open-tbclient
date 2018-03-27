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
    private SystemHelpSettingActivity gOJ;
    private TbSettingTextTipView gOK;
    private TbSettingTextTipView gOL;
    private BdSwitchView gOM;
    private BdSwitchView gON;
    private TbSettingTextNewDotView gOO;
    private final CustomMessageListener gOP;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gOJ = null;
        this.mParent = null;
        this.gOK = null;
        this.gOL = null;
        this.gOM = null;
        this.gON = null;
        this.gOO = null;
        this.gOP = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gOJ = systemHelpSettingActivity;
        this.gOJ.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gOJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gOJ.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOK = (TbSettingTextTipView) this.gOJ.findViewById(d.g.clear_cache);
        this.gOK.hideArrow();
        this.gOK.setOnClickListener(this.gOJ);
        this.gOK.setBottomLineVisibility(true);
        this.gOL = (TbSettingTextTipView) this.gOJ.findViewById(d.g.clear_im);
        this.gOL.hideArrow();
        this.gOL.setBottomLineVisibility(true);
        this.gOL.setOnClickListener(this.gOJ);
        this.gOM = (BdSwitchView) this.gOJ.findViewById(d.g.item_switch);
        l.a(this.gOJ.getPageContext().getPageActivity(), this.gOM, 10, 10, 10, 10);
        this.gOM.setOnSwitchStateChangeListener(this.gOJ);
        this.gON = (BdSwitchView) this.gOJ.findViewById(d.g.setting_save_video_switch);
        l.a(this.gOJ.getPageContext().getPageActivity(), this.gON, 10, 10, 10, 10);
        this.gON.setOnSwitchStateChangeListener(this.gOJ);
        this.mParent = this.gOJ.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gOL.setVisibility(0);
        } else {
            this.gOL.setVisibility(8);
        }
        this.gOO = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gOO.setOnClickListener(this.gOJ);
        if (this.gOJ != null) {
            this.gOP.setTag(this.gOJ.getUniqueId());
            MessageManager.getInstance().registerListener(this.gOP);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gOO.setVisibility(0);
        } else {
            this.gOO.setVisibility(8);
        }
    }

    public BdSwitchView brY() {
        return this.gON;
    }

    public BdSwitchView brZ() {
        return this.gOM;
    }

    public TbSettingTextTipView bsa() {
        return this.gOK;
    }

    public TbSettingTextTipView bsb() {
        return this.gOL;
    }

    public void onChangeSkinType(int i) {
        this.gOJ.getLayoutMode().aQ(i == 1);
        this.gOJ.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOM.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.gON.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.s(this.gOK, d.f.more_all);
    }

    public TbSettingTextNewDotView bsc() {
        return this.gOO;
    }
}
