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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gwq;
    private TbSettingTextTipView gwr;
    private TbSettingTextTipView gws;
    private BdSwitchView gwt;
    private BdSwitchView gwu;
    private TbSettingTextNewDotView gwv;
    private final CustomMessageListener gww;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gwq = null;
        this.mParent = null;
        this.gwr = null;
        this.gws = null;
        this.gwt = null;
        this.gwu = null;
        this.gwv = null;
        this.gww = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gwq = systemHelpSettingActivity;
        this.gwq.setContentView(d.i.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gwq.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gwq.getPageContext().getString(d.k.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gwr = (TbSettingTextTipView) this.gwq.findViewById(d.g.clear_cache);
        this.gwr.hideArrow();
        this.gwr.setOnClickListener(this.gwq);
        this.gwr.setBottomLineVisibility(true);
        this.gws = (TbSettingTextTipView) this.gwq.findViewById(d.g.clear_im);
        this.gws.hideArrow();
        this.gws.setBottomLineVisibility(true);
        this.gws.setOnClickListener(this.gwq);
        this.gwt = (BdSwitchView) this.gwq.findViewById(d.g.item_switch);
        l.a(this.gwq.getPageContext().getPageActivity(), this.gwt, 10, 10, 10, 10);
        this.gwt.setOnSwitchStateChangeListener(this.gwq);
        this.gwu = (BdSwitchView) this.gwq.findViewById(d.g.setting_save_video_switch);
        l.a(this.gwq.getPageContext().getPageActivity(), this.gwu, 10, 10, 10, 10);
        this.gwu.setOnSwitchStateChangeListener(this.gwq);
        this.mParent = this.gwq.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gws.setVisibility(0);
        } else {
            this.gws.setVisibility(8);
        }
        this.gwv = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gwv.setOnClickListener(this.gwq);
        if (this.gwq != null) {
            this.gww.setTag(this.gwq.getUniqueId());
            MessageManager.getInstance().registerListener(this.gww);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gwv.setVisibility(0);
        } else {
            this.gwv.setVisibility(8);
        }
    }

    public BdSwitchView bsf() {
        return this.gwu;
    }

    public BdSwitchView bsg() {
        return this.gwt;
    }

    public TbSettingTextTipView bsh() {
        return this.gwr;
    }

    public TbSettingTextTipView bsi() {
        return this.gws;
    }

    public void onChangeSkinType(int i) {
        this.gwq.getLayoutMode().setNightMode(i == 1);
        this.gwq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gwt.setBackgroundRes(al.cQ(d.f.bg_switch_open), al.cQ(d.f.bg_switch_close), al.cQ(d.f.btn_handle));
        this.gwu.setBackgroundRes(al.cQ(d.f.bg_switch_open), al.cQ(d.f.bg_switch_close), al.cQ(d.f.btn_handle));
        al.i(this.gwr, d.f.more_all);
    }

    public TbSettingTextNewDotView bsj() {
        return this.gwv;
    }
}
