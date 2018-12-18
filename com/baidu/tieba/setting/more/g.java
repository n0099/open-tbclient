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
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private TbSettingTextNewDotView gYA;
    private MsgSettingItemView gYB;
    private BdSwitchView.a gYC;
    private final CustomMessageListener gYD;
    private SystemHelpSettingActivity gYv;
    private TbSettingTextTipView gYw;
    private TbSettingTextTipView gYx;
    private BdSwitchView gYy;
    private BdSwitchView gYz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gYv = null;
        this.mParent = null;
        this.gYw = null;
        this.gYx = null;
        this.gYy = null;
        this.gYz = null;
        this.gYA = null;
        this.gYC = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.g.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == g.this.gYB.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.gYD = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gYv = systemHelpSettingActivity;
        this.gYv.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gYv.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gYv.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gYw = (TbSettingTextTipView) this.gYv.findViewById(e.g.clear_cache);
        this.gYw.hideArrow();
        this.gYw.setOnClickListener(this.gYv);
        this.gYw.setBottomLineVisibility(true);
        this.gYx = (TbSettingTextTipView) this.gYv.findViewById(e.g.clear_im);
        this.gYx.hideArrow();
        this.gYx.setBottomLineVisibility(true);
        this.gYx.setOnClickListener(this.gYv);
        this.gYy = (BdSwitchView) this.gYv.findViewById(e.g.item_switch);
        l.b(this.gYv.getPageContext().getPageActivity(), this.gYy, 10, 10, 10, 10);
        this.gYy.setOnSwitchStateChangeListener(this.gYv);
        this.gYz = (BdSwitchView) this.gYv.findViewById(e.g.setting_save_video_switch);
        l.b(this.gYv.getPageContext().getPageActivity(), this.gYz, 10, 10, 10, 10);
        this.gYz.setOnSwitchStateChangeListener(this.gYv);
        this.mParent = this.gYv.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gYx.setVisibility(0);
        } else {
            this.gYx.setVisibility(8);
        }
        this.gYA = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.gYA.setOnClickListener(this.gYv);
        if (this.gYv != null) {
            this.gYD.setTag(this.gYv.getUniqueId());
            MessageManager.getInstance().registerListener(this.gYD);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gYA.setVisibility(0);
        } else {
            this.gYA.setVisibility(8);
        }
        this.gYB = (MsgSettingItemView) this.gYv.findViewById(e.g.recently_bar_switch);
        this.gYB.setLineVisibility(false);
        this.gYB.setSpaceView(8);
        this.gYB.setText(e.j.privacy_hide_recently_bar_text);
        this.gYB.setOnSwitchStateChangeListener(this.gYC);
        nb(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void nb(boolean z) {
        if (!z) {
            this.gYB.getSwitchView().nP();
        } else {
            this.gYB.getSwitchView().nQ();
        }
    }

    public BdSwitchView byr() {
        return this.gYz;
    }

    public BdSwitchView bys() {
        return this.gYy;
    }

    public TbSettingTextTipView byt() {
        return this.gYw;
    }

    public TbSettingTextTipView byu() {
        return this.gYx;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gYv.getLayoutMode().setNightMode(i == 1);
        this.gYv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gYy.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.gYz.setBackgroundRes(al.dO(e.f.bg_switch_open), al.dO(e.f.bg_switch_close), al.dO(e.f.btn_handle));
        this.gYB.d(this.gYv.getPageContext(), i);
        al.i(this.gYw, e.f.more_all);
    }

    public TbSettingTextNewDotView byv() {
        return this.gYA;
    }
}
