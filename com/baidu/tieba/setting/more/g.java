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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gBr;
    private TbSettingTextTipView gBs;
    private TbSettingTextTipView gBt;
    private BdSwitchView gBu;
    private BdSwitchView gBv;
    private TbSettingTextNewDotView gBw;
    private final CustomMessageListener gBx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gBr = null;
        this.mParent = null;
        this.gBs = null;
        this.gBt = null;
        this.gBu = null;
        this.gBv = null;
        this.gBw = null;
        this.gBx = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gBr = systemHelpSettingActivity;
        this.gBr.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gBr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gBr.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gBs = (TbSettingTextTipView) this.gBr.findViewById(d.g.clear_cache);
        this.gBs.hideArrow();
        this.gBs.setOnClickListener(this.gBr);
        this.gBs.setBottomLineVisibility(true);
        this.gBt = (TbSettingTextTipView) this.gBr.findViewById(d.g.clear_im);
        this.gBt.hideArrow();
        this.gBt.setBottomLineVisibility(true);
        this.gBt.setOnClickListener(this.gBr);
        this.gBu = (BdSwitchView) this.gBr.findViewById(d.g.item_switch);
        l.a(this.gBr.getPageContext().getPageActivity(), this.gBu, 10, 10, 10, 10);
        this.gBu.setOnSwitchStateChangeListener(this.gBr);
        this.gBv = (BdSwitchView) this.gBr.findViewById(d.g.setting_save_video_switch);
        l.a(this.gBr.getPageContext().getPageActivity(), this.gBv, 10, 10, 10, 10);
        this.gBv.setOnSwitchStateChangeListener(this.gBr);
        this.mParent = this.gBr.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gBt.setVisibility(0);
        } else {
            this.gBt.setVisibility(8);
        }
        this.gBw = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gBw.setOnClickListener(this.gBr);
        if (this.gBr != null) {
            this.gBx.setTag(this.gBr.getUniqueId());
            MessageManager.getInstance().registerListener(this.gBx);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gBw.setVisibility(0);
        } else {
            this.gBw.setVisibility(8);
        }
    }

    public BdSwitchView brj() {
        return this.gBv;
    }

    public BdSwitchView brk() {
        return this.gBu;
    }

    public TbSettingTextTipView brl() {
        return this.gBs;
    }

    public TbSettingTextTipView brm() {
        return this.gBt;
    }

    public void onChangeSkinType(int i) {
        this.gBr.getLayoutMode().setNightMode(i == 1);
        this.gBr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gBu.setBackgroundRes(am.cT(d.f.bg_switch_open), am.cT(d.f.bg_switch_close), am.cT(d.f.btn_handle));
        this.gBv.setBackgroundRes(am.cT(d.f.bg_switch_open), am.cT(d.f.bg_switch_close), am.cT(d.f.btn_handle));
        am.i(this.gBs, d.f.more_all);
    }

    public TbSettingTextNewDotView brn() {
        return this.gBw;
    }
}
