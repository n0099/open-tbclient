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
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity hcE;
    private TbSettingTextTipView hcF;
    private TbSettingTextTipView hcG;
    private BdSwitchView hcH;
    private BdSwitchView hcI;
    private TbSettingTextNewDotView hcJ;
    private MsgSettingItemView hcK;
    private BdSwitchView.a hcL;
    private final CustomMessageListener hcM;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.hcE = null;
        this.mParent = null;
        this.hcF = null;
        this.hcG = null;
        this.hcH = null;
        this.hcI = null;
        this.hcJ = null;
        this.hcL = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.hcK.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.hcM = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.hcE = systemHelpSettingActivity;
        this.hcE.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.hcE.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hcE.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hcF = (TbSettingTextTipView) this.hcE.findViewById(e.g.clear_cache);
        this.hcF.hideArrow();
        this.hcF.setOnClickListener(this.hcE);
        this.hcF.setBottomLineVisibility(true);
        this.hcG = (TbSettingTextTipView) this.hcE.findViewById(e.g.clear_im);
        this.hcG.hideArrow();
        this.hcG.setBottomLineVisibility(true);
        this.hcG.setOnClickListener(this.hcE);
        this.hcH = (BdSwitchView) this.hcE.findViewById(e.g.item_switch);
        l.b(this.hcE.getPageContext().getPageActivity(), this.hcH, 10, 10, 10, 10);
        this.hcH.setOnSwitchStateChangeListener(this.hcE);
        this.hcI = (BdSwitchView) this.hcE.findViewById(e.g.setting_save_video_switch);
        l.b(this.hcE.getPageContext().getPageActivity(), this.hcI, 10, 10, 10, 10);
        this.hcI.setOnSwitchStateChangeListener(this.hcE);
        this.mParent = this.hcE.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.hcG.setVisibility(0);
        } else {
            this.hcG.setVisibility(8);
        }
        this.hcJ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.hcJ.setOnClickListener(this.hcE);
        if (this.hcE != null) {
            this.hcM.setTag(this.hcE.getUniqueId());
            MessageManager.getInstance().registerListener(this.hcM);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.hcJ.setVisibility(0);
        } else {
            this.hcJ.setVisibility(8);
        }
        this.hcK = (MsgSettingItemView) this.hcE.findViewById(e.g.recently_bar_switch);
        this.hcK.setLineVisibility(false);
        this.hcK.setSpaceView(8);
        this.hcK.setText(e.j.privacy_hide_recently_bar_text);
        this.hcK.setOnSwitchStateChangeListener(this.hcL);
        nf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void nf(boolean z) {
        if (!z) {
            this.hcK.getSwitchView().nT();
        } else {
            this.hcK.getSwitchView().nU();
        }
    }

    public BdSwitchView bzQ() {
        return this.hcI;
    }

    public BdSwitchView bzR() {
        return this.hcH;
    }

    public TbSettingTextTipView bzS() {
        return this.hcF;
    }

    public TbSettingTextTipView bzT() {
        return this.hcG;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.hcE.getLayoutMode().setNightMode(i == 1);
        this.hcE.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hcH.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hcI.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hcK.d(this.hcE.getPageContext(), i);
        al.i(this.hcF, e.f.more_all);
    }

    public TbSettingTextNewDotView bzU() {
        return this.hcJ;
    }
}
