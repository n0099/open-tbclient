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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes26.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity mXO;
    private TbSettingTextTipView mXP;
    private TbSettingTextTipView mXQ;
    private BdSwitchView mXR;
    private BdSwitchView mXS;
    private TbSettingTextNewDotView mXT;
    private MsgSettingItemView mXU;
    private TbSettingTextTipView mXV;
    private BdSwitchView.a mXW;
    private final CustomMessageListener mXX;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mXO = null;
        this.mParent = null;
        this.mXP = null;
        this.mXQ = null;
        this.mXR = null;
        this.mXS = null;
        this.mXT = null;
        this.mXV = null;
        this.mXW = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mXU.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mXX = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mXO = systemHelpSettingActivity;
        this.mXO.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mXO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mXO.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mXP = (TbSettingTextTipView) this.mXO.findViewById(R.id.clear_cache);
        this.mXP.hideArrow();
        this.mXP.setOnClickListener(this.mXO);
        this.mXP.setBottomLineVisibility(true);
        this.mXQ = (TbSettingTextTipView) this.mXO.findViewById(R.id.clear_im);
        this.mXQ.hideArrow();
        this.mXQ.setBottomLineVisibility(true);
        this.mXQ.setOnClickListener(this.mXO);
        this.mXR = (BdSwitchView) this.mXO.findViewById(R.id.item_switch);
        l.addToParentArea(this.mXO.getPageContext().getPageActivity(), this.mXR, 10, 10, 10, 10);
        this.mXR.setOnSwitchStateChangeListener(this.mXO);
        this.mXS = (BdSwitchView) this.mXO.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mXO.getPageContext().getPageActivity(), this.mXS, 10, 10, 10, 10);
        this.mXS.setOnSwitchStateChangeListener(this.mXO);
        this.mXV = (TbSettingTextTipView) this.mXO.findViewById(R.id.debug_tool_launch);
        this.mXV.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.mXV.setVisibility(0);
        } else {
            this.mXV.setVisibility(8);
        }
        this.mXV.setOnClickListener(this.mXO);
        this.mParent = this.mXO.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mXQ.setVisibility(0);
        } else {
            this.mXQ.setVisibility(8);
        }
        this.mXT = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mXT.setOnClickListener(this.mXO);
        if (this.mXO != null) {
            this.mXX.setTag(this.mXO.getUniqueId());
            MessageManager.getInstance().registerListener(this.mXX);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mXT.setVisibility(0);
        } else {
            this.mXT.setVisibility(8);
        }
        this.mXU = (MsgSettingItemView) this.mXO.findViewById(R.id.recently_bar_switch);
        this.mXU.setLineVisibility(false);
        this.mXU.setSpaceView(8);
        this.mXU.setText(R.string.privacy_hide_recently_bar_text);
        this.mXU.setOnSwitchStateChangeListener(this.mXW);
        xF(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xF(boolean z) {
        if (!z) {
            this.mXU.getSwitchView().turnOnNoCallback();
        } else {
            this.mXU.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dKq() {
        return this.mXS;
    }

    public BdSwitchView dKr() {
        return this.mXR;
    }

    public TbSettingTextTipView dKs() {
        return this.mXP;
    }

    public TbSettingTextTipView dKt() {
        return this.mXQ;
    }

    public TbSettingTextTipView dIF() {
        return this.mXV;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mXO.getLayoutMode().setNightMode(i == 1);
        this.mXO.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mXR.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mXS.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mXU.onChangeSkinType(this.mXO.getPageContext(), i);
        ap.setBackgroundResource(this.mXP, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dKu() {
        return this.mXT;
    }
}
