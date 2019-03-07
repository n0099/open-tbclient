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
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private BdSwitchView iuA;
    private TbSettingTextNewDotView iuB;
    private MsgSettingItemView iuC;
    private BdSwitchView.a iuD;
    private final CustomMessageListener iuE;
    private SystemHelpSettingActivity iuw;
    private TbSettingTextTipView iux;
    private TbSettingTextTipView iuy;
    private BdSwitchView iuz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iuw = null;
        this.mParent = null;
        this.iux = null;
        this.iuy = null;
        this.iuz = null;
        this.iuA = null;
        this.iuB = null;
        this.iuD = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iuC.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iuE = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iuw = systemHelpSettingActivity;
        this.iuw.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iuw.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iuw.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iux = (TbSettingTextTipView) this.iuw.findViewById(d.g.clear_cache);
        this.iux.hideArrow();
        this.iux.setOnClickListener(this.iuw);
        this.iux.setBottomLineVisibility(true);
        this.iuy = (TbSettingTextTipView) this.iuw.findViewById(d.g.clear_im);
        this.iuy.hideArrow();
        this.iuy.setBottomLineVisibility(true);
        this.iuy.setOnClickListener(this.iuw);
        this.iuz = (BdSwitchView) this.iuw.findViewById(d.g.item_switch);
        l.b(this.iuw.getPageContext().getPageActivity(), this.iuz, 10, 10, 10, 10);
        this.iuz.setOnSwitchStateChangeListener(this.iuw);
        this.iuA = (BdSwitchView) this.iuw.findViewById(d.g.setting_save_video_switch);
        l.b(this.iuw.getPageContext().getPageActivity(), this.iuA, 10, 10, 10, 10);
        this.iuA.setOnSwitchStateChangeListener(this.iuw);
        this.mParent = this.iuw.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iuy.setVisibility(0);
        } else {
            this.iuy.setVisibility(8);
        }
        this.iuB = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.iuB.setOnClickListener(this.iuw);
        if (this.iuw != null) {
            this.iuE.setTag(this.iuw.getUniqueId());
            MessageManager.getInstance().registerListener(this.iuE);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iuB.setVisibility(0);
        } else {
            this.iuB.setVisibility(8);
        }
        this.iuC = (MsgSettingItemView) this.iuw.findViewById(d.g.recently_bar_switch);
        this.iuC.setLineVisibility(false);
        this.iuC.setSpaceView(8);
        this.iuC.setText(d.j.privacy_hide_recently_bar_text);
        this.iuC.setOnSwitchStateChangeListener(this.iuD);
        pF(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void pF(boolean z) {
        if (!z) {
            this.iuC.getSwitchView().nY();
        } else {
            this.iuC.getSwitchView().nZ();
        }
    }

    public BdSwitchView caE() {
        return this.iuA;
    }

    public BdSwitchView caF() {
        return this.iuz;
    }

    public TbSettingTextTipView caG() {
        return this.iux;
    }

    public TbSettingTextTipView caH() {
        return this.iuy;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iuw.getLayoutMode().setNightMode(i == 1);
        this.iuw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iuz.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuA.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuC.onChangeSkinType(this.iuw.getPageContext(), i);
        al.k(this.iux, d.f.more_all);
    }

    public TbSettingTextNewDotView caI() {
        return this.iuB;
    }
}
