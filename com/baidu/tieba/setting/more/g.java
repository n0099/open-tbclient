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
    private SystemHelpSettingActivity gAj;
    private TbSettingTextTipView gAk;
    private TbSettingTextTipView gAl;
    private BdSwitchView gAm;
    private BdSwitchView gAn;
    private TbSettingTextNewDotView gAo;
    private final CustomMessageListener gAp;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gAj = null;
        this.mParent = null;
        this.gAk = null;
        this.gAl = null;
        this.gAm = null;
        this.gAn = null;
        this.gAo = null;
        this.gAp = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gAj = systemHelpSettingActivity;
        this.gAj.setContentView(d.i.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gAj.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gAj.getPageContext().getString(d.k.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAk = (TbSettingTextTipView) this.gAj.findViewById(d.g.clear_cache);
        this.gAk.hideArrow();
        this.gAk.setOnClickListener(this.gAj);
        this.gAk.setBottomLineVisibility(true);
        this.gAl = (TbSettingTextTipView) this.gAj.findViewById(d.g.clear_im);
        this.gAl.hideArrow();
        this.gAl.setBottomLineVisibility(true);
        this.gAl.setOnClickListener(this.gAj);
        this.gAm = (BdSwitchView) this.gAj.findViewById(d.g.item_switch);
        l.a(this.gAj.getPageContext().getPageActivity(), this.gAm, 10, 10, 10, 10);
        this.gAm.setOnSwitchStateChangeListener(this.gAj);
        this.gAn = (BdSwitchView) this.gAj.findViewById(d.g.setting_save_video_switch);
        l.a(this.gAj.getPageContext().getPageActivity(), this.gAn, 10, 10, 10, 10);
        this.gAn.setOnSwitchStateChangeListener(this.gAj);
        this.mParent = this.gAj.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gAl.setVisibility(0);
        } else {
            this.gAl.setVisibility(8);
        }
        this.gAo = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gAo.setOnClickListener(this.gAj);
        if (this.gAj != null) {
            this.gAp.setTag(this.gAj.getUniqueId());
            MessageManager.getInstance().registerListener(this.gAp);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gAo.setVisibility(0);
        } else {
            this.gAo.setVisibility(8);
        }
    }

    public BdSwitchView bsG() {
        return this.gAn;
    }

    public BdSwitchView bsH() {
        return this.gAm;
    }

    public TbSettingTextTipView bsI() {
        return this.gAk;
    }

    public TbSettingTextTipView bsJ() {
        return this.gAl;
    }

    public void onChangeSkinType(int i) {
        this.gAj.getLayoutMode().setNightMode(i == 1);
        this.gAj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gAm.setBackgroundRes(am.cR(d.f.bg_switch_open), am.cR(d.f.bg_switch_close), am.cR(d.f.btn_handle));
        this.gAn.setBackgroundRes(am.cR(d.f.bg_switch_open), am.cR(d.f.bg_switch_close), am.cR(d.f.btn_handle));
        am.i(this.gAk, d.f.more_all);
    }

    public TbSettingTextNewDotView bsK() {
        return this.gAo;
    }
}
