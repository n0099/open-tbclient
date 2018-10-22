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
    private SystemHelpSettingActivity gQh;
    private TbSettingTextTipView gQi;
    private TbSettingTextTipView gQj;
    private BdSwitchView gQk;
    private BdSwitchView gQl;
    private TbSettingTextNewDotView gQm;
    private MsgSettingItemView gQn;
    private BdSwitchView.a gQo;
    private final CustomMessageListener gQp;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gQh = null;
        this.mParent = null;
        this.gQi = null;
        this.gQj = null;
        this.gQk = null;
        this.gQl = null;
        this.gQm = null;
        this.gQo = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.g.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == g.this.gQn.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.gQp = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gQh = systemHelpSettingActivity;
        this.gQh.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gQh.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQh.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gQi = (TbSettingTextTipView) this.gQh.findViewById(e.g.clear_cache);
        this.gQi.hideArrow();
        this.gQi.setOnClickListener(this.gQh);
        this.gQi.setBottomLineVisibility(true);
        this.gQj = (TbSettingTextTipView) this.gQh.findViewById(e.g.clear_im);
        this.gQj.hideArrow();
        this.gQj.setBottomLineVisibility(true);
        this.gQj.setOnClickListener(this.gQh);
        this.gQk = (BdSwitchView) this.gQh.findViewById(e.g.item_switch);
        l.a(this.gQh.getPageContext().getPageActivity(), this.gQk, 10, 10, 10, 10);
        this.gQk.setOnSwitchStateChangeListener(this.gQh);
        this.gQl = (BdSwitchView) this.gQh.findViewById(e.g.setting_save_video_switch);
        l.a(this.gQh.getPageContext().getPageActivity(), this.gQl, 10, 10, 10, 10);
        this.gQl.setOnSwitchStateChangeListener(this.gQh);
        this.mParent = this.gQh.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gQj.setVisibility(0);
        } else {
            this.gQj.setVisibility(8);
        }
        this.gQm = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.gQm.setOnClickListener(this.gQh);
        if (this.gQh != null) {
            this.gQp.setTag(this.gQh.getUniqueId());
            MessageManager.getInstance().registerListener(this.gQp);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gQm.setVisibility(0);
        } else {
            this.gQm.setVisibility(8);
        }
        this.gQn = (MsgSettingItemView) this.gQh.findViewById(e.g.recently_bar_switch);
        this.gQn.setLineVisibility(false);
        this.gQn.setSpaceView(8);
        this.gQn.setText(e.j.privacy_hide_recently_bar_text);
        this.gQn.setOnSwitchStateChangeListener(this.gQo);
        mN(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void mN(boolean z) {
        if (!z) {
            this.gQn.getSwitchView().nS();
        } else {
            this.gQn.getSwitchView().nT();
        }
    }

    public BdSwitchView bxd() {
        return this.gQl;
    }

    public BdSwitchView bxe() {
        return this.gQk;
    }

    public TbSettingTextTipView bxf() {
        return this.gQi;
    }

    public TbSettingTextTipView bxg() {
        return this.gQj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gQh.getLayoutMode().setNightMode(i == 1);
        this.gQh.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gQk.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        this.gQl.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        this.gQn.d(this.gQh.getPageContext(), i);
        al.i(this.gQi, e.f.more_all);
    }

    public TbSettingTextNewDotView bxh() {
        return this.gQm;
    }
}
