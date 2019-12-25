package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes10.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity jQd;
    private TbSettingTextTipView jQe;
    private TbSettingTextTipView jQf;
    private BdSwitchView jQg;
    private BdSwitchView jQh;
    private TbSettingTextNewDotView jQi;
    private MsgSettingItemView jQj;
    private BdSwitchView.a jQk;
    private final CustomMessageListener jQl;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jQd = null;
        this.mParent = null;
        this.jQe = null;
        this.jQf = null;
        this.jQg = null;
        this.jQh = null;
        this.jQi = null;
        this.jQk = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jQj.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jQl = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jQd = systemHelpSettingActivity;
        this.jQd.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jQd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jQd.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jQe = (TbSettingTextTipView) this.jQd.findViewById(R.id.clear_cache);
        this.jQe.hideArrow();
        this.jQe.setOnClickListener(this.jQd);
        this.jQe.setBottomLineVisibility(true);
        this.jQf = (TbSettingTextTipView) this.jQd.findViewById(R.id.clear_im);
        this.jQf.hideArrow();
        this.jQf.setBottomLineVisibility(true);
        this.jQf.setOnClickListener(this.jQd);
        this.jQg = (BdSwitchView) this.jQd.findViewById(R.id.item_switch);
        l.addToParentArea(this.jQd.getPageContext().getPageActivity(), this.jQg, 10, 10, 10, 10);
        this.jQg.setOnSwitchStateChangeListener(this.jQd);
        this.jQh = (BdSwitchView) this.jQd.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jQd.getPageContext().getPageActivity(), this.jQh, 10, 10, 10, 10);
        this.jQh.setOnSwitchStateChangeListener(this.jQd);
        this.mParent = this.jQd.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jQf.setVisibility(0);
        } else {
            this.jQf.setVisibility(8);
        }
        this.jQi = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jQi.setOnClickListener(this.jQd);
        if (this.jQd != null) {
            this.jQl.setTag(this.jQd.getUniqueId());
            MessageManager.getInstance().registerListener(this.jQl);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jQi.setVisibility(0);
        } else {
            this.jQi.setVisibility(8);
        }
        this.jQj = (MsgSettingItemView) this.jQd.findViewById(R.id.recently_bar_switch);
        this.jQj.setLineVisibility(false);
        this.jQj.setSpaceView(8);
        this.jQj.setText(R.string.privacy_hide_recently_bar_text);
        this.jQj.setOnSwitchStateChangeListener(this.jQk);
        sf(com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void sf(boolean z) {
        if (!z) {
            this.jQj.getSwitchView().turnOnNoCallback();
        } else {
            this.jQj.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cEx() {
        return this.jQh;
    }

    public BdSwitchView cEy() {
        return this.jQg;
    }

    public TbSettingTextTipView cEz() {
        return this.jQe;
    }

    public TbSettingTextTipView cEA() {
        return this.jQf;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jQd.getLayoutMode().setNightMode(i == 1);
        this.jQd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jQg.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jQh.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jQj.onChangeSkinType(this.jQd.getPageContext(), i);
        am.setBackgroundResource(this.jQe, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cEB() {
        return this.jQi;
    }
}
