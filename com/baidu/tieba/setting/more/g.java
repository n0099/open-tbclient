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
    private SystemHelpSettingActivity gkS;
    private TbSettingTextTipView gkT;
    private TbSettingTextTipView gkU;
    private BdSwitchView gkV;
    private BdSwitchView gkW;
    private TbSettingTextNewDotView gkX;
    private final CustomMessageListener gkY;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gkS = null;
        this.mParent = null;
        this.gkT = null;
        this.gkU = null;
        this.gkV = null;
        this.gkW = null;
        this.gkX = null;
        this.gkY = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gkS = systemHelpSettingActivity;
        this.gkS.setContentView(d.i.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gkS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gkS.getPageContext().getString(d.k.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gkT = (TbSettingTextTipView) this.gkS.findViewById(d.g.clear_cache);
        this.gkT.hideArrow();
        this.gkT.setOnClickListener(this.gkS);
        this.gkT.setBottomLineVisibility(true);
        this.gkU = (TbSettingTextTipView) this.gkS.findViewById(d.g.clear_im);
        this.gkU.hideArrow();
        this.gkU.setBottomLineVisibility(true);
        this.gkU.setOnClickListener(this.gkS);
        this.gkV = (BdSwitchView) this.gkS.findViewById(d.g.item_switch);
        l.a(this.gkS.getPageContext().getPageActivity(), this.gkV, 10, 10, 10, 10);
        this.gkV.setOnSwitchStateChangeListener(this.gkS);
        this.gkW = (BdSwitchView) this.gkS.findViewById(d.g.setting_save_video_switch);
        l.a(this.gkS.getPageContext().getPageActivity(), this.gkW, 10, 10, 10, 10);
        this.gkW.setOnSwitchStateChangeListener(this.gkS);
        this.mParent = this.gkS.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gkU.setVisibility(0);
        } else {
            this.gkU.setVisibility(8);
        }
        this.gkX = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gkX.setOnClickListener(this.gkS);
        if (this.gkS != null) {
            this.gkY.setTag(this.gkS.getUniqueId());
            MessageManager.getInstance().registerListener(this.gkY);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gkX.setVisibility(0);
        } else {
            this.gkX.setVisibility(8);
        }
    }

    public BdSwitchView bng() {
        return this.gkW;
    }

    public BdSwitchView bnh() {
        return this.gkV;
    }

    public TbSettingTextTipView bni() {
        return this.gkT;
    }

    public TbSettingTextTipView bnj() {
        return this.gkU;
    }

    public void onChangeSkinType(int i) {
        this.gkS.getLayoutMode().setNightMode(i == 1);
        this.gkS.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gkV.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        this.gkW.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        ak.i(this.gkT, d.f.more_all);
    }

    public TbSettingTextNewDotView bnk() {
        return this.gkX;
    }
}
