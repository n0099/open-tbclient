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
    private SystemHelpSettingActivity jUG;
    private TbSettingTextTipView jUH;
    private TbSettingTextTipView jUI;
    private BdSwitchView jUJ;
    private BdSwitchView jUK;
    private TbSettingTextNewDotView jUL;
    private MsgSettingItemView jUM;
    private BdSwitchView.a jUN;
    private final CustomMessageListener jUO;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jUG = null;
        this.mParent = null;
        this.jUH = null;
        this.jUI = null;
        this.jUJ = null;
        this.jUK = null;
        this.jUL = null;
        this.jUN = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jUM.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jUO = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jUG = systemHelpSettingActivity;
        this.jUG.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jUG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jUG.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUH = (TbSettingTextTipView) this.jUG.findViewById(R.id.clear_cache);
        this.jUH.hideArrow();
        this.jUH.setOnClickListener(this.jUG);
        this.jUH.setBottomLineVisibility(true);
        this.jUI = (TbSettingTextTipView) this.jUG.findViewById(R.id.clear_im);
        this.jUI.hideArrow();
        this.jUI.setBottomLineVisibility(true);
        this.jUI.setOnClickListener(this.jUG);
        this.jUJ = (BdSwitchView) this.jUG.findViewById(R.id.item_switch);
        l.addToParentArea(this.jUG.getPageContext().getPageActivity(), this.jUJ, 10, 10, 10, 10);
        this.jUJ.setOnSwitchStateChangeListener(this.jUG);
        this.jUK = (BdSwitchView) this.jUG.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jUG.getPageContext().getPageActivity(), this.jUK, 10, 10, 10, 10);
        this.jUK.setOnSwitchStateChangeListener(this.jUG);
        this.mParent = this.jUG.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jUI.setVisibility(0);
        } else {
            this.jUI.setVisibility(8);
        }
        this.jUL = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jUL.setOnClickListener(this.jUG);
        if (this.jUG != null) {
            this.jUO.setTag(this.jUG.getUniqueId());
            MessageManager.getInstance().registerListener(this.jUO);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jUL.setVisibility(0);
        } else {
            this.jUL.setVisibility(8);
        }
        this.jUM = (MsgSettingItemView) this.jUG.findViewById(R.id.recently_bar_switch);
        this.jUM.setLineVisibility(false);
        this.jUM.setSpaceView(8);
        this.jUM.setText(R.string.privacy_hide_recently_bar_text);
        this.jUM.setOnSwitchStateChangeListener(this.jUN);
        su(com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void su(boolean z) {
        if (!z) {
            this.jUM.getSwitchView().turnOnNoCallback();
        } else {
            this.jUM.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cHe() {
        return this.jUK;
    }

    public BdSwitchView cHf() {
        return this.jUJ;
    }

    public TbSettingTextTipView cHg() {
        return this.jUH;
    }

    public TbSettingTextTipView cHh() {
        return this.jUI;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jUG.getLayoutMode().setNightMode(i == 1);
        this.jUG.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jUJ.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jUK.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jUM.onChangeSkinType(this.jUG.getPageContext(), i);
        am.setBackgroundResource(this.jUH, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cHi() {
        return this.jUL;
    }
}
