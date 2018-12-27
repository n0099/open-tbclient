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
    private TbSettingTextTipView hbA;
    private TbSettingTextTipView hbB;
    private BdSwitchView hbC;
    private BdSwitchView hbD;
    private TbSettingTextNewDotView hbE;
    private MsgSettingItemView hbF;
    private BdSwitchView.a hbG;
    private final CustomMessageListener hbH;
    private SystemHelpSettingActivity hbz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.hbz = null;
        this.mParent = null;
        this.hbA = null;
        this.hbB = null;
        this.hbC = null;
        this.hbD = null;
        this.hbE = null;
        this.hbG = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.hbF.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.hbH = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.hbz = systemHelpSettingActivity;
        this.hbz.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.hbz.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.hbz.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hbA = (TbSettingTextTipView) this.hbz.findViewById(e.g.clear_cache);
        this.hbA.hideArrow();
        this.hbA.setOnClickListener(this.hbz);
        this.hbA.setBottomLineVisibility(true);
        this.hbB = (TbSettingTextTipView) this.hbz.findViewById(e.g.clear_im);
        this.hbB.hideArrow();
        this.hbB.setBottomLineVisibility(true);
        this.hbB.setOnClickListener(this.hbz);
        this.hbC = (BdSwitchView) this.hbz.findViewById(e.g.item_switch);
        l.b(this.hbz.getPageContext().getPageActivity(), this.hbC, 10, 10, 10, 10);
        this.hbC.setOnSwitchStateChangeListener(this.hbz);
        this.hbD = (BdSwitchView) this.hbz.findViewById(e.g.setting_save_video_switch);
        l.b(this.hbz.getPageContext().getPageActivity(), this.hbD, 10, 10, 10, 10);
        this.hbD.setOnSwitchStateChangeListener(this.hbz);
        this.mParent = this.hbz.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.hbB.setVisibility(0);
        } else {
            this.hbB.setVisibility(8);
        }
        this.hbE = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.hbE.setOnClickListener(this.hbz);
        if (this.hbz != null) {
            this.hbH.setTag(this.hbz.getUniqueId());
            MessageManager.getInstance().registerListener(this.hbH);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.hbE.setVisibility(0);
        } else {
            this.hbE.setVisibility(8);
        }
        this.hbF = (MsgSettingItemView) this.hbz.findViewById(e.g.recently_bar_switch);
        this.hbF.setLineVisibility(false);
        this.hbF.setSpaceView(8);
        this.hbF.setText(e.j.privacy_hide_recently_bar_text);
        this.hbF.setOnSwitchStateChangeListener(this.hbG);
        ne(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void ne(boolean z) {
        if (!z) {
            this.hbF.getSwitchView().nP();
        } else {
            this.hbF.getSwitchView().nQ();
        }
    }

    public BdSwitchView bzh() {
        return this.hbD;
    }

    public BdSwitchView bzi() {
        return this.hbC;
    }

    public TbSettingTextTipView bzj() {
        return this.hbA;
    }

    public TbSettingTextTipView bzk() {
        return this.hbB;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.hbz.getLayoutMode().setNightMode(i == 1);
        this.hbz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hbC.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hbD.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.hbF.d(this.hbz.getPageContext(), i);
        al.i(this.hbA, e.f.more_all);
    }

    public TbSettingTextNewDotView bzl() {
        return this.hbE;
    }
}
