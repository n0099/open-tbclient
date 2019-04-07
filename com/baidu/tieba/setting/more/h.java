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
    private SystemHelpSettingActivity iua;
    private TbSettingTextTipView iub;
    private TbSettingTextTipView iuc;
    private BdSwitchView iud;
    private BdSwitchView iue;
    private TbSettingTextNewDotView iuf;
    private MsgSettingItemView iug;
    private BdSwitchView.a iuh;
    private final CustomMessageListener iui;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iua = null;
        this.mParent = null;
        this.iub = null;
        this.iuc = null;
        this.iud = null;
        this.iue = null;
        this.iuf = null;
        this.iuh = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iug.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iui = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iua = systemHelpSettingActivity;
        this.iua.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iua.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iua.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iub = (TbSettingTextTipView) this.iua.findViewById(d.g.clear_cache);
        this.iub.hideArrow();
        this.iub.setOnClickListener(this.iua);
        this.iub.setBottomLineVisibility(true);
        this.iuc = (TbSettingTextTipView) this.iua.findViewById(d.g.clear_im);
        this.iuc.hideArrow();
        this.iuc.setBottomLineVisibility(true);
        this.iuc.setOnClickListener(this.iua);
        this.iud = (BdSwitchView) this.iua.findViewById(d.g.item_switch);
        l.b(this.iua.getPageContext().getPageActivity(), this.iud, 10, 10, 10, 10);
        this.iud.setOnSwitchStateChangeListener(this.iua);
        this.iue = (BdSwitchView) this.iua.findViewById(d.g.setting_save_video_switch);
        l.b(this.iua.getPageContext().getPageActivity(), this.iue, 10, 10, 10, 10);
        this.iue.setOnSwitchStateChangeListener(this.iua);
        this.mParent = this.iua.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iuc.setVisibility(0);
        } else {
            this.iuc.setVisibility(8);
        }
        this.iuf = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.iuf.setOnClickListener(this.iua);
        if (this.iua != null) {
            this.iui.setTag(this.iua.getUniqueId());
            MessageManager.getInstance().registerListener(this.iui);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iuf.setVisibility(0);
        } else {
            this.iuf.setVisibility(8);
        }
        this.iug = (MsgSettingItemView) this.iua.findViewById(d.g.recently_bar_switch);
        this.iug.setLineVisibility(false);
        this.iug.setSpaceView(8);
        this.iug.setText(d.j.privacy_hide_recently_bar_text);
        this.iug.setOnSwitchStateChangeListener(this.iuh);
        pF(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void pF(boolean z) {
        if (!z) {
            this.iug.getSwitchView().nY();
        } else {
            this.iug.getSwitchView().nZ();
        }
    }

    public BdSwitchView caD() {
        return this.iue;
    }

    public BdSwitchView caE() {
        return this.iud;
    }

    public TbSettingTextTipView caF() {
        return this.iub;
    }

    public TbSettingTextTipView caG() {
        return this.iuc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iua.getLayoutMode().setNightMode(i == 1);
        this.iua.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iud.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        this.iue.setBackgroundRes(al.hp(d.f.bg_switch_open), al.hp(d.f.bg_switch_close), al.hp(d.f.btn_handle));
        this.iug.onChangeSkinType(this.iua.getPageContext(), i);
        al.k(this.iub, d.f.more_all);
    }

    public TbSettingTextNewDotView caH() {
        return this.iuf;
    }
}
