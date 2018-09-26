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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gIK;
    private TbSettingTextTipView gIL;
    private TbSettingTextTipView gIM;
    private BdSwitchView gIN;
    private BdSwitchView gIO;
    private TbSettingTextNewDotView gIP;
    private final CustomMessageListener gIQ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gIK = null;
        this.mParent = null;
        this.gIL = null;
        this.gIM = null;
        this.gIN = null;
        this.gIO = null;
        this.gIP = null;
        this.gIQ = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gIK = systemHelpSettingActivity;
        this.gIK.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gIK.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gIK.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIL = (TbSettingTextTipView) this.gIK.findViewById(e.g.clear_cache);
        this.gIL.hideArrow();
        this.gIL.setOnClickListener(this.gIK);
        this.gIL.setBottomLineVisibility(true);
        this.gIM = (TbSettingTextTipView) this.gIK.findViewById(e.g.clear_im);
        this.gIM.hideArrow();
        this.gIM.setBottomLineVisibility(true);
        this.gIM.setOnClickListener(this.gIK);
        this.gIN = (BdSwitchView) this.gIK.findViewById(e.g.item_switch);
        l.a(this.gIK.getPageContext().getPageActivity(), this.gIN, 10, 10, 10, 10);
        this.gIN.setOnSwitchStateChangeListener(this.gIK);
        this.gIO = (BdSwitchView) this.gIK.findViewById(e.g.setting_save_video_switch);
        l.a(this.gIK.getPageContext().getPageActivity(), this.gIO, 10, 10, 10, 10);
        this.gIO.setOnSwitchStateChangeListener(this.gIK);
        this.mParent = this.gIK.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gIM.setVisibility(0);
        } else {
            this.gIM.setVisibility(8);
        }
        this.gIP = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.gIP.setOnClickListener(this.gIK);
        if (this.gIK != null) {
            this.gIQ.setTag(this.gIK.getUniqueId());
            MessageManager.getInstance().registerListener(this.gIQ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gIP.setVisibility(0);
        } else {
            this.gIP.setVisibility(8);
        }
    }

    public BdSwitchView btO() {
        return this.gIO;
    }

    public BdSwitchView btP() {
        return this.gIN;
    }

    public TbSettingTextTipView btQ() {
        return this.gIL;
    }

    public TbSettingTextTipView btR() {
        return this.gIM;
    }

    public void onChangeSkinType(int i) {
        this.gIK.getLayoutMode().setNightMode(i == 1);
        this.gIK.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gIN.setBackgroundRes(al.dc(e.f.bg_switch_open), al.dc(e.f.bg_switch_close), al.dc(e.f.btn_handle));
        this.gIO.setBackgroundRes(al.dc(e.f.bg_switch_open), al.dc(e.f.bg_switch_close), al.dc(e.f.btn_handle));
        al.i(this.gIL, e.f.more_all);
    }

    public TbSettingTextNewDotView btS() {
        return this.gIP;
    }
}
