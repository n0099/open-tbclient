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
    private SystemHelpSettingActivity gQg;
    private TbSettingTextTipView gQh;
    private TbSettingTextTipView gQi;
    private BdSwitchView gQj;
    private BdSwitchView gQk;
    private TbSettingTextNewDotView gQl;
    private MsgSettingItemView gQm;
    private BdSwitchView.a gQn;
    private final CustomMessageListener gQo;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gQg = null;
        this.mParent = null;
        this.gQh = null;
        this.gQi = null;
        this.gQj = null;
        this.gQk = null;
        this.gQl = null;
        this.gQn = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.g.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == g.this.gQm.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.gQo = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gQg = systemHelpSettingActivity;
        this.gQg.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gQg.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gQg.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gQh = (TbSettingTextTipView) this.gQg.findViewById(e.g.clear_cache);
        this.gQh.hideArrow();
        this.gQh.setOnClickListener(this.gQg);
        this.gQh.setBottomLineVisibility(true);
        this.gQi = (TbSettingTextTipView) this.gQg.findViewById(e.g.clear_im);
        this.gQi.hideArrow();
        this.gQi.setBottomLineVisibility(true);
        this.gQi.setOnClickListener(this.gQg);
        this.gQj = (BdSwitchView) this.gQg.findViewById(e.g.item_switch);
        l.a(this.gQg.getPageContext().getPageActivity(), this.gQj, 10, 10, 10, 10);
        this.gQj.setOnSwitchStateChangeListener(this.gQg);
        this.gQk = (BdSwitchView) this.gQg.findViewById(e.g.setting_save_video_switch);
        l.a(this.gQg.getPageContext().getPageActivity(), this.gQk, 10, 10, 10, 10);
        this.gQk.setOnSwitchStateChangeListener(this.gQg);
        this.mParent = this.gQg.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gQi.setVisibility(0);
        } else {
            this.gQi.setVisibility(8);
        }
        this.gQl = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.gQl.setOnClickListener(this.gQg);
        if (this.gQg != null) {
            this.gQo.setTag(this.gQg.getUniqueId());
            MessageManager.getInstance().registerListener(this.gQo);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gQl.setVisibility(0);
        } else {
            this.gQl.setVisibility(8);
        }
        this.gQm = (MsgSettingItemView) this.gQg.findViewById(e.g.recently_bar_switch);
        this.gQm.setLineVisibility(false);
        this.gQm.setSpaceView(8);
        this.gQm.setText(e.j.privacy_hide_recently_bar_text);
        this.gQm.setOnSwitchStateChangeListener(this.gQn);
        mN(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void mN(boolean z) {
        if (!z) {
            this.gQm.getSwitchView().nS();
        } else {
            this.gQm.getSwitchView().nT();
        }
    }

    public BdSwitchView bxd() {
        return this.gQk;
    }

    public BdSwitchView bxe() {
        return this.gQj;
    }

    public TbSettingTextTipView bxf() {
        return this.gQh;
    }

    public TbSettingTextTipView bxg() {
        return this.gQi;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gQg.getLayoutMode().setNightMode(i == 1);
        this.gQg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gQj.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        this.gQk.setBackgroundRes(al.dm(e.f.bg_switch_open), al.dm(e.f.bg_switch_close), al.dm(e.f.btn_handle));
        this.gQm.d(this.gQg.getPageContext(), i);
        al.i(this.gQh, e.f.more_all);
    }

    public TbSettingTextNewDotView bxh() {
        return this.gQl;
    }
}
