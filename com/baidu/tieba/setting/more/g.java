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
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private final CustomMessageListener gBA;
    private SystemHelpSettingActivity gBu;
    private TbSettingTextTipView gBv;
    private TbSettingTextTipView gBw;
    private BdSwitchView gBx;
    private BdSwitchView gBy;
    private TbSettingTextNewDotView gBz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gBu = null;
        this.mParent = null;
        this.gBv = null;
        this.gBw = null;
        this.gBx = null;
        this.gBy = null;
        this.gBz = null;
        this.gBA = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gBu = systemHelpSettingActivity;
        this.gBu.setContentView(f.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gBu.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gBu.getPageContext().getString(f.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gBv = (TbSettingTextTipView) this.gBu.findViewById(f.g.clear_cache);
        this.gBv.hideArrow();
        this.gBv.setOnClickListener(this.gBu);
        this.gBv.setBottomLineVisibility(true);
        this.gBw = (TbSettingTextTipView) this.gBu.findViewById(f.g.clear_im);
        this.gBw.hideArrow();
        this.gBw.setBottomLineVisibility(true);
        this.gBw.setOnClickListener(this.gBu);
        this.gBx = (BdSwitchView) this.gBu.findViewById(f.g.item_switch);
        l.a(this.gBu.getPageContext().getPageActivity(), this.gBx, 10, 10, 10, 10);
        this.gBx.setOnSwitchStateChangeListener(this.gBu);
        this.gBy = (BdSwitchView) this.gBu.findViewById(f.g.setting_save_video_switch);
        l.a(this.gBu.getPageContext().getPageActivity(), this.gBy, 10, 10, 10, 10);
        this.gBy.setOnSwitchStateChangeListener(this.gBu);
        this.mParent = this.gBu.findViewById(f.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gBw.setVisibility(0);
        } else {
            this.gBw.setVisibility(8);
        }
        this.gBz = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(f.g.sv_plugin_center);
        this.gBz.setOnClickListener(this.gBu);
        if (this.gBu != null) {
            this.gBA.setTag(this.gBu.getUniqueId());
            MessageManager.getInstance().registerListener(this.gBA);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gBz.setVisibility(0);
        } else {
            this.gBz.setVisibility(8);
        }
    }

    public BdSwitchView brk() {
        return this.gBy;
    }

    public BdSwitchView brl() {
        return this.gBx;
    }

    public TbSettingTextTipView brm() {
        return this.gBv;
    }

    public TbSettingTextTipView brn() {
        return this.gBw;
    }

    public void onChangeSkinType(int i) {
        this.gBu.getLayoutMode().setNightMode(i == 1);
        this.gBu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gBx.setBackgroundRes(am.cT(f.C0146f.bg_switch_open), am.cT(f.C0146f.bg_switch_close), am.cT(f.C0146f.btn_handle));
        this.gBy.setBackgroundRes(am.cT(f.C0146f.bg_switch_open), am.cT(f.C0146f.bg_switch_close), am.cT(f.C0146f.btn_handle));
        am.i(this.gBv, f.C0146f.more_all);
    }

    public TbSettingTextNewDotView bro() {
        return this.gBz;
    }
}
