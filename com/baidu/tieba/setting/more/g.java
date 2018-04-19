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
    private SystemHelpSettingActivity gjP;
    private TbSettingTextTipView gjQ;
    private TbSettingTextTipView gjR;
    private BdSwitchView gjS;
    private BdSwitchView gjT;
    private TbSettingTextNewDotView gjU;
    private final CustomMessageListener gjV;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gjP = null;
        this.mParent = null;
        this.gjQ = null;
        this.gjR = null;
        this.gjS = null;
        this.gjT = null;
        this.gjU = null;
        this.gjV = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gjP = systemHelpSettingActivity;
        this.gjP.setContentView(d.i.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gjP.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gjP.getPageContext().getString(d.k.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjQ = (TbSettingTextTipView) this.gjP.findViewById(d.g.clear_cache);
        this.gjQ.hideArrow();
        this.gjQ.setOnClickListener(this.gjP);
        this.gjQ.setBottomLineVisibility(true);
        this.gjR = (TbSettingTextTipView) this.gjP.findViewById(d.g.clear_im);
        this.gjR.hideArrow();
        this.gjR.setBottomLineVisibility(true);
        this.gjR.setOnClickListener(this.gjP);
        this.gjS = (BdSwitchView) this.gjP.findViewById(d.g.item_switch);
        l.a(this.gjP.getPageContext().getPageActivity(), this.gjS, 10, 10, 10, 10);
        this.gjS.setOnSwitchStateChangeListener(this.gjP);
        this.gjT = (BdSwitchView) this.gjP.findViewById(d.g.setting_save_video_switch);
        l.a(this.gjP.getPageContext().getPageActivity(), this.gjT, 10, 10, 10, 10);
        this.gjT.setOnSwitchStateChangeListener(this.gjP);
        this.mParent = this.gjP.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gjR.setVisibility(0);
        } else {
            this.gjR.setVisibility(8);
        }
        this.gjU = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gjU.setOnClickListener(this.gjP);
        if (this.gjP != null) {
            this.gjV.setTag(this.gjP.getUniqueId());
            MessageManager.getInstance().registerListener(this.gjV);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gjU.setVisibility(0);
        } else {
            this.gjU.setVisibility(8);
        }
    }

    public BdSwitchView bnh() {
        return this.gjT;
    }

    public BdSwitchView bni() {
        return this.gjS;
    }

    public TbSettingTextTipView bnj() {
        return this.gjQ;
    }

    public TbSettingTextTipView bnk() {
        return this.gjR;
    }

    public void onChangeSkinType(int i) {
        this.gjP.getLayoutMode().setNightMode(i == 1);
        this.gjP.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjS.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        this.gjT.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        ak.i(this.gjQ, d.f.more_all);
    }

    public TbSettingTextNewDotView bnl() {
        return this.gjU;
    }
}
