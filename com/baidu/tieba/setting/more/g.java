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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gjM;
    private TbSettingTextTipView gjN;
    private TbSettingTextTipView gjO;
    private BdSwitchView gjP;
    private BdSwitchView gjQ;
    private TbSettingTextNewDotView gjR;
    private final CustomMessageListener gjS;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gjM = null;
        this.mParent = null;
        this.gjN = null;
        this.gjO = null;
        this.gjP = null;
        this.gjQ = null;
        this.gjR = null;
        this.gjS = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gjM = systemHelpSettingActivity;
        this.gjM.setContentView(d.i.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gjM.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gjM.getPageContext().getString(d.k.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjN = (TbSettingTextTipView) this.gjM.findViewById(d.g.clear_cache);
        this.gjN.hideArrow();
        this.gjN.setOnClickListener(this.gjM);
        this.gjN.setBottomLineVisibility(true);
        this.gjO = (TbSettingTextTipView) this.gjM.findViewById(d.g.clear_im);
        this.gjO.hideArrow();
        this.gjO.setBottomLineVisibility(true);
        this.gjO.setOnClickListener(this.gjM);
        this.gjP = (BdSwitchView) this.gjM.findViewById(d.g.item_switch);
        l.a(this.gjM.getPageContext().getPageActivity(), this.gjP, 10, 10, 10, 10);
        this.gjP.setOnSwitchStateChangeListener(this.gjM);
        this.gjQ = (BdSwitchView) this.gjM.findViewById(d.g.setting_save_video_switch);
        l.a(this.gjM.getPageContext().getPageActivity(), this.gjQ, 10, 10, 10, 10);
        this.gjQ.setOnSwitchStateChangeListener(this.gjM);
        this.mParent = this.gjM.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gjO.setVisibility(0);
        } else {
            this.gjO.setVisibility(8);
        }
        this.gjR = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gjR.setOnClickListener(this.gjM);
        if (this.gjM != null) {
            this.gjS.setTag(this.gjM.getUniqueId());
            MessageManager.getInstance().registerListener(this.gjS);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gjR.setVisibility(0);
        } else {
            this.gjR.setVisibility(8);
        }
    }

    public BdSwitchView bnh() {
        return this.gjQ;
    }

    public BdSwitchView bni() {
        return this.gjP;
    }

    public TbSettingTextTipView bnj() {
        return this.gjN;
    }

    public TbSettingTextTipView bnk() {
        return this.gjO;
    }

    public void onChangeSkinType(int i) {
        this.gjM.getLayoutMode().setNightMode(i == 1);
        this.gjM.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjP.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        this.gjQ.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        ak.i(this.gjN, d.f.more_all);
    }

    public TbSettingTextNewDotView bnl() {
        return this.gjR;
    }
}
