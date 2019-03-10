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
    private BdSwitchView iuB;
    private TbSettingTextNewDotView iuC;
    private MsgSettingItemView iuD;
    private BdSwitchView.a iuE;
    private final CustomMessageListener iuF;
    private SystemHelpSettingActivity iux;
    private TbSettingTextTipView iuy;
    private TbSettingTextTipView iuz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iux = null;
        this.mParent = null;
        this.iuy = null;
        this.iuz = null;
        this.iuA = null;
        this.iuB = null;
        this.iuC = null;
        this.iuE = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iuD.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iuF = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iux = systemHelpSettingActivity;
        this.iux.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iux.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iux.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iuy = (TbSettingTextTipView) this.iux.findViewById(d.g.clear_cache);
        this.iuy.hideArrow();
        this.iuy.setOnClickListener(this.iux);
        this.iuy.setBottomLineVisibility(true);
        this.iuz = (TbSettingTextTipView) this.iux.findViewById(d.g.clear_im);
        this.iuz.hideArrow();
        this.iuz.setBottomLineVisibility(true);
        this.iuz.setOnClickListener(this.iux);
        this.iuA = (BdSwitchView) this.iux.findViewById(d.g.item_switch);
        l.b(this.iux.getPageContext().getPageActivity(), this.iuA, 10, 10, 10, 10);
        this.iuA.setOnSwitchStateChangeListener(this.iux);
        this.iuB = (BdSwitchView) this.iux.findViewById(d.g.setting_save_video_switch);
        l.b(this.iux.getPageContext().getPageActivity(), this.iuB, 10, 10, 10, 10);
        this.iuB.setOnSwitchStateChangeListener(this.iux);
        this.mParent = this.iux.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iuz.setVisibility(0);
        } else {
            this.iuz.setVisibility(8);
        }
        this.iuC = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.iuC.setOnClickListener(this.iux);
        if (this.iux != null) {
            this.iuF.setTag(this.iux.getUniqueId());
            MessageManager.getInstance().registerListener(this.iuF);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iuC.setVisibility(0);
        } else {
            this.iuC.setVisibility(8);
        }
        this.iuD = (MsgSettingItemView) this.iux.findViewById(d.g.recently_bar_switch);
        this.iuD.setLineVisibility(false);
        this.iuD.setSpaceView(8);
        this.iuD.setText(d.j.privacy_hide_recently_bar_text);
        this.iuD.setOnSwitchStateChangeListener(this.iuE);
        pF(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void pF(boolean z) {
        if (!z) {
            this.iuD.getSwitchView().nY();
        } else {
            this.iuD.getSwitchView().nZ();
        }
    }

    public BdSwitchView caF() {
        return this.iuB;
    }

    public BdSwitchView caG() {
        return this.iuA;
    }

    public TbSettingTextTipView caH() {
        return this.iuy;
    }

    public TbSettingTextTipView caI() {
        return this.iuz;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iux.getLayoutMode().setNightMode(i == 1);
        this.iux.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iuA.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuB.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuD.onChangeSkinType(this.iux.getPageContext(), i);
        al.k(this.iuy, d.f.more_all);
    }

    public TbSettingTextNewDotView caJ() {
        return this.iuC;
    }
}
