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
    private SystemHelpSettingActivity iub;
    private TbSettingTextTipView iuc;
    private TbSettingTextTipView iud;
    private BdSwitchView iue;
    private BdSwitchView iuf;
    private TbSettingTextNewDotView iug;
    private MsgSettingItemView iuh;
    private BdSwitchView.a iui;
    private final CustomMessageListener iuj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iub = null;
        this.mParent = null;
        this.iuc = null;
        this.iud = null;
        this.iue = null;
        this.iuf = null;
        this.iug = null;
        this.iui = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iuh.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iuj = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iub = systemHelpSettingActivity;
        this.iub.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iub.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iub.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iuc = (TbSettingTextTipView) this.iub.findViewById(d.g.clear_cache);
        this.iuc.hideArrow();
        this.iuc.setOnClickListener(this.iub);
        this.iuc.setBottomLineVisibility(true);
        this.iud = (TbSettingTextTipView) this.iub.findViewById(d.g.clear_im);
        this.iud.hideArrow();
        this.iud.setBottomLineVisibility(true);
        this.iud.setOnClickListener(this.iub);
        this.iue = (BdSwitchView) this.iub.findViewById(d.g.item_switch);
        l.b(this.iub.getPageContext().getPageActivity(), this.iue, 10, 10, 10, 10);
        this.iue.setOnSwitchStateChangeListener(this.iub);
        this.iuf = (BdSwitchView) this.iub.findViewById(d.g.setting_save_video_switch);
        l.b(this.iub.getPageContext().getPageActivity(), this.iuf, 10, 10, 10, 10);
        this.iuf.setOnSwitchStateChangeListener(this.iub);
        this.mParent = this.iub.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iud.setVisibility(0);
        } else {
            this.iud.setVisibility(8);
        }
        this.iug = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.iug.setOnClickListener(this.iub);
        if (this.iub != null) {
            this.iuj.setTag(this.iub.getUniqueId());
            MessageManager.getInstance().registerListener(this.iuj);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iug.setVisibility(0);
        } else {
            this.iug.setVisibility(8);
        }
        this.iuh = (MsgSettingItemView) this.iub.findViewById(d.g.recently_bar_switch);
        this.iuh.setLineVisibility(false);
        this.iuh.setSpaceView(8);
        this.iuh.setText(d.j.privacy_hide_recently_bar_text);
        this.iuh.setOnSwitchStateChangeListener(this.iui);
        pF(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void pF(boolean z) {
        if (!z) {
            this.iuh.getSwitchView().nY();
        } else {
            this.iuh.getSwitchView().nZ();
        }
    }

    public BdSwitchView caD() {
        return this.iuf;
    }

    public BdSwitchView caE() {
        return this.iue;
    }

    public TbSettingTextTipView caF() {
        return this.iuc;
    }

    public TbSettingTextTipView caG() {
        return this.iud;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iub.getLayoutMode().setNightMode(i == 1);
        this.iub.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iue.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        this.iuf.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        this.iuh.onChangeSkinType(this.iub.getPageContext(), i);
        al.k(this.iuc, d.f.more_all);
    }

    public TbSettingTextNewDotView caH() {
        return this.iug;
    }
}
