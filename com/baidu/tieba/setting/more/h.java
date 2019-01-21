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
    private SystemHelpSettingActivity hcF;
    private TbSettingTextTipView hcG;
    private TbSettingTextTipView hcH;
    private BdSwitchView hcI;
    private BdSwitchView hcJ;
    private TbSettingTextNewDotView hcK;
    private MsgSettingItemView hcL;
    private BdSwitchView.a hcM;
    private final CustomMessageListener hcN;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.hcF = null;
        this.mParent = null;
        this.hcG = null;
        this.hcH = null;
        this.hcI = null;
        this.hcJ = null;
        this.hcK = null;
        this.hcM = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.hcL.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.hcN = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.hcF = systemHelpSettingActivity;
        this.hcF.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.hcF.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hcF.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hcG = (TbSettingTextTipView) this.hcF.findViewById(e.g.clear_cache);
        this.hcG.hideArrow();
        this.hcG.setOnClickListener(this.hcF);
        this.hcG.setBottomLineVisibility(true);
        this.hcH = (TbSettingTextTipView) this.hcF.findViewById(e.g.clear_im);
        this.hcH.hideArrow();
        this.hcH.setBottomLineVisibility(true);
        this.hcH.setOnClickListener(this.hcF);
        this.hcI = (BdSwitchView) this.hcF.findViewById(e.g.item_switch);
        l.b(this.hcF.getPageContext().getPageActivity(), this.hcI, 10, 10, 10, 10);
        this.hcI.setOnSwitchStateChangeListener(this.hcF);
        this.hcJ = (BdSwitchView) this.hcF.findViewById(e.g.setting_save_video_switch);
        l.b(this.hcF.getPageContext().getPageActivity(), this.hcJ, 10, 10, 10, 10);
        this.hcJ.setOnSwitchStateChangeListener(this.hcF);
        this.mParent = this.hcF.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.hcH.setVisibility(0);
        } else {
            this.hcH.setVisibility(8);
        }
        this.hcK = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.hcK.setOnClickListener(this.hcF);
        if (this.hcF != null) {
            this.hcN.setTag(this.hcF.getUniqueId());
            MessageManager.getInstance().registerListener(this.hcN);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.hcK.setVisibility(0);
        } else {
            this.hcK.setVisibility(8);
        }
        this.hcL = (MsgSettingItemView) this.hcF.findViewById(e.g.recently_bar_switch);
        this.hcL.setLineVisibility(false);
        this.hcL.setSpaceView(8);
        this.hcL.setText(e.j.privacy_hide_recently_bar_text);
        this.hcL.setOnSwitchStateChangeListener(this.hcM);
        nf(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void nf(boolean z) {
        if (!z) {
            this.hcL.getSwitchView().nT();
        } else {
            this.hcL.getSwitchView().nU();
        }
    }

    public BdSwitchView bzQ() {
        return this.hcJ;
    }

    public BdSwitchView bzR() {
        return this.hcI;
    }

    public TbSettingTextTipView bzS() {
        return this.hcG;
    }

    public TbSettingTextTipView bzT() {
        return this.hcH;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.hcF.getLayoutMode().setNightMode(i == 1);
        this.hcF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hcI.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hcJ.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hcL.d(this.hcF.getPageContext(), i);
        al.i(this.hcG, e.f.more_all);
    }

    public TbSettingTextNewDotView bzU() {
        return this.hcK;
    }
}
