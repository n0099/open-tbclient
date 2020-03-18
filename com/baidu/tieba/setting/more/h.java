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
    private BdSwitchView jWA;
    private TbSettingTextNewDotView jWB;
    private MsgSettingItemView jWC;
    private BdSwitchView.a jWD;
    private final CustomMessageListener jWE;
    private SystemHelpSettingActivity jWw;
    private TbSettingTextTipView jWx;
    private TbSettingTextTipView jWy;
    private BdSwitchView jWz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jWw = null;
        this.mParent = null;
        this.jWx = null;
        this.jWy = null;
        this.jWz = null;
        this.jWA = null;
        this.jWB = null;
        this.jWD = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jWC.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jWE = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jWw = systemHelpSettingActivity;
        this.jWw.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jWw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jWw.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jWx = (TbSettingTextTipView) this.jWw.findViewById(R.id.clear_cache);
        this.jWx.hideArrow();
        this.jWx.setOnClickListener(this.jWw);
        this.jWx.setBottomLineVisibility(true);
        this.jWy = (TbSettingTextTipView) this.jWw.findViewById(R.id.clear_im);
        this.jWy.hideArrow();
        this.jWy.setBottomLineVisibility(true);
        this.jWy.setOnClickListener(this.jWw);
        this.jWz = (BdSwitchView) this.jWw.findViewById(R.id.item_switch);
        l.addToParentArea(this.jWw.getPageContext().getPageActivity(), this.jWz, 10, 10, 10, 10);
        this.jWz.setOnSwitchStateChangeListener(this.jWw);
        this.jWA = (BdSwitchView) this.jWw.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jWw.getPageContext().getPageActivity(), this.jWA, 10, 10, 10, 10);
        this.jWA.setOnSwitchStateChangeListener(this.jWw);
        this.mParent = this.jWw.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jWy.setVisibility(0);
        } else {
            this.jWy.setVisibility(8);
        }
        this.jWB = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jWB.setOnClickListener(this.jWw);
        if (this.jWw != null) {
            this.jWE.setTag(this.jWw.getUniqueId());
            MessageManager.getInstance().registerListener(this.jWE);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jWB.setVisibility(0);
        } else {
            this.jWB.setVisibility(8);
        }
        this.jWC = (MsgSettingItemView) this.jWw.findViewById(R.id.recently_bar_switch);
        this.jWC.setLineVisibility(false);
        this.jWC.setSpaceView(8);
        this.jWC.setText(R.string.privacy_hide_recently_bar_text);
        this.jWC.setOnSwitchStateChangeListener(this.jWD);
        sA(com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void sA(boolean z) {
        if (!z) {
            this.jWC.getSwitchView().turnOnNoCallback();
        } else {
            this.jWC.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cHB() {
        return this.jWA;
    }

    public BdSwitchView cHC() {
        return this.jWz;
    }

    public TbSettingTextTipView cHD() {
        return this.jWx;
    }

    public TbSettingTextTipView cHE() {
        return this.jWy;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jWw.getLayoutMode().setNightMode(i == 1);
        this.jWw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jWz.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jWA.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jWC.onChangeSkinType(this.jWw.getPageContext(), i);
        am.setBackgroundResource(this.jWx, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cHF() {
        return this.jWB;
    }
}
