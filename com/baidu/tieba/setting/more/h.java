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
/* loaded from: classes13.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity jUI;
    private TbSettingTextTipView jUJ;
    private TbSettingTextTipView jUK;
    private BdSwitchView jUL;
    private BdSwitchView jUM;
    private TbSettingTextNewDotView jUN;
    private MsgSettingItemView jUO;
    private BdSwitchView.a jUP;
    private final CustomMessageListener jUQ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jUI = null;
        this.mParent = null;
        this.jUJ = null;
        this.jUK = null;
        this.jUL = null;
        this.jUM = null;
        this.jUN = null;
        this.jUP = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jUO.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jUQ = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jUI = systemHelpSettingActivity;
        this.jUI.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jUI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jUI.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUJ = (TbSettingTextTipView) this.jUI.findViewById(R.id.clear_cache);
        this.jUJ.hideArrow();
        this.jUJ.setOnClickListener(this.jUI);
        this.jUJ.setBottomLineVisibility(true);
        this.jUK = (TbSettingTextTipView) this.jUI.findViewById(R.id.clear_im);
        this.jUK.hideArrow();
        this.jUK.setBottomLineVisibility(true);
        this.jUK.setOnClickListener(this.jUI);
        this.jUL = (BdSwitchView) this.jUI.findViewById(R.id.item_switch);
        l.addToParentArea(this.jUI.getPageContext().getPageActivity(), this.jUL, 10, 10, 10, 10);
        this.jUL.setOnSwitchStateChangeListener(this.jUI);
        this.jUM = (BdSwitchView) this.jUI.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jUI.getPageContext().getPageActivity(), this.jUM, 10, 10, 10, 10);
        this.jUM.setOnSwitchStateChangeListener(this.jUI);
        this.mParent = this.jUI.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jUK.setVisibility(0);
        } else {
            this.jUK.setVisibility(8);
        }
        this.jUN = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jUN.setOnClickListener(this.jUI);
        if (this.jUI != null) {
            this.jUQ.setTag(this.jUI.getUniqueId());
            MessageManager.getInstance().registerListener(this.jUQ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jUN.setVisibility(0);
        } else {
            this.jUN.setVisibility(8);
        }
        this.jUO = (MsgSettingItemView) this.jUI.findViewById(R.id.recently_bar_switch);
        this.jUO.setLineVisibility(false);
        this.jUO.setSpaceView(8);
        this.jUO.setText(R.string.privacy_hide_recently_bar_text);
        this.jUO.setOnSwitchStateChangeListener(this.jUP);
        su(com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void su(boolean z) {
        if (!z) {
            this.jUO.getSwitchView().turnOnNoCallback();
        } else {
            this.jUO.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cHg() {
        return this.jUM;
    }

    public BdSwitchView cHh() {
        return this.jUL;
    }

    public TbSettingTextTipView cHi() {
        return this.jUJ;
    }

    public TbSettingTextTipView cHj() {
        return this.jUK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jUI.getLayoutMode().setNightMode(i == 1);
        this.jUI.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jUL.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jUM.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jUO.onChangeSkinType(this.jUI.getPageContext(), i);
        am.setBackgroundResource(this.jUJ, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cHk() {
        return this.jUN;
    }
}
