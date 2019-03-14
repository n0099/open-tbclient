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
    private SystemHelpSettingActivity iuq;
    private TbSettingTextTipView iur;
    private TbSettingTextTipView ius;
    private BdSwitchView iut;
    private BdSwitchView iuu;
    private TbSettingTextNewDotView iuv;
    private MsgSettingItemView iuw;
    private BdSwitchView.a iux;
    private final CustomMessageListener iuy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iuq = null;
        this.mParent = null;
        this.iur = null;
        this.ius = null;
        this.iut = null;
        this.iuu = null;
        this.iuv = null;
        this.iux = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iuw.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iuy = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iuq = systemHelpSettingActivity;
        this.iuq.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iuq.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iuq.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iur = (TbSettingTextTipView) this.iuq.findViewById(d.g.clear_cache);
        this.iur.hideArrow();
        this.iur.setOnClickListener(this.iuq);
        this.iur.setBottomLineVisibility(true);
        this.ius = (TbSettingTextTipView) this.iuq.findViewById(d.g.clear_im);
        this.ius.hideArrow();
        this.ius.setBottomLineVisibility(true);
        this.ius.setOnClickListener(this.iuq);
        this.iut = (BdSwitchView) this.iuq.findViewById(d.g.item_switch);
        l.b(this.iuq.getPageContext().getPageActivity(), this.iut, 10, 10, 10, 10);
        this.iut.setOnSwitchStateChangeListener(this.iuq);
        this.iuu = (BdSwitchView) this.iuq.findViewById(d.g.setting_save_video_switch);
        l.b(this.iuq.getPageContext().getPageActivity(), this.iuu, 10, 10, 10, 10);
        this.iuu.setOnSwitchStateChangeListener(this.iuq);
        this.mParent = this.iuq.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.ius.setVisibility(0);
        } else {
            this.ius.setVisibility(8);
        }
        this.iuv = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.iuv.setOnClickListener(this.iuq);
        if (this.iuq != null) {
            this.iuy.setTag(this.iuq.getUniqueId());
            MessageManager.getInstance().registerListener(this.iuy);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iuv.setVisibility(0);
        } else {
            this.iuv.setVisibility(8);
        }
        this.iuw = (MsgSettingItemView) this.iuq.findViewById(d.g.recently_bar_switch);
        this.iuw.setLineVisibility(false);
        this.iuw.setSpaceView(8);
        this.iuw.setText(d.j.privacy_hide_recently_bar_text);
        this.iuw.setOnSwitchStateChangeListener(this.iux);
        pF(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void pF(boolean z) {
        if (!z) {
            this.iuw.getSwitchView().nY();
        } else {
            this.iuw.getSwitchView().nZ();
        }
    }

    public BdSwitchView caH() {
        return this.iuu;
    }

    public BdSwitchView caI() {
        return this.iut;
    }

    public TbSettingTextTipView caJ() {
        return this.iur;
    }

    public TbSettingTextTipView caK() {
        return this.ius;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iuq.getLayoutMode().setNightMode(i == 1);
        this.iuq.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iut.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuu.setBackgroundRes(al.hq(d.f.bg_switch_open), al.hq(d.f.bg_switch_close), al.hq(d.f.btn_handle));
        this.iuw.onChangeSkinType(this.iuq.getPageContext(), i);
        al.k(this.iur, d.f.more_all);
    }

    public TbSettingTextNewDotView caL() {
        return this.iuv;
    }
}
