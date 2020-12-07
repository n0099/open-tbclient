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
    private SystemHelpSettingActivity mXM;
    private TbSettingTextTipView mXN;
    private TbSettingTextTipView mXO;
    private BdSwitchView mXP;
    private BdSwitchView mXQ;
    private TbSettingTextNewDotView mXR;
    private MsgSettingItemView mXS;
    private TbSettingTextTipView mXT;
    private BdSwitchView.a mXU;
    private final CustomMessageListener mXV;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mXM = null;
        this.mParent = null;
        this.mXN = null;
        this.mXO = null;
        this.mXP = null;
        this.mXQ = null;
        this.mXR = null;
        this.mXT = null;
        this.mXU = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mXS.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mXV = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mXM = systemHelpSettingActivity;
        this.mXM.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mXM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mXM.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mXN = (TbSettingTextTipView) this.mXM.findViewById(R.id.clear_cache);
        this.mXN.hideArrow();
        this.mXN.setOnClickListener(this.mXM);
        this.mXN.setBottomLineVisibility(true);
        this.mXO = (TbSettingTextTipView) this.mXM.findViewById(R.id.clear_im);
        this.mXO.hideArrow();
        this.mXO.setBottomLineVisibility(true);
        this.mXO.setOnClickListener(this.mXM);
        this.mXP = (BdSwitchView) this.mXM.findViewById(R.id.item_switch);
        l.addToParentArea(this.mXM.getPageContext().getPageActivity(), this.mXP, 10, 10, 10, 10);
        this.mXP.setOnSwitchStateChangeListener(this.mXM);
        this.mXQ = (BdSwitchView) this.mXM.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mXM.getPageContext().getPageActivity(), this.mXQ, 10, 10, 10, 10);
        this.mXQ.setOnSwitchStateChangeListener(this.mXM);
        this.mXT = (TbSettingTextTipView) this.mXM.findViewById(R.id.debug_tool_launch);
        this.mXT.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.mXT.setVisibility(0);
        } else {
            this.mXT.setVisibility(8);
        }
        this.mXT.setOnClickListener(this.mXM);
        this.mParent = this.mXM.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mXO.setVisibility(0);
        } else {
            this.mXO.setVisibility(8);
        }
        this.mXR = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mXR.setOnClickListener(this.mXM);
        if (this.mXM != null) {
            this.mXV.setTag(this.mXM.getUniqueId());
            MessageManager.getInstance().registerListener(this.mXV);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mXR.setVisibility(0);
        } else {
            this.mXR.setVisibility(8);
        }
        this.mXS = (MsgSettingItemView) this.mXM.findViewById(R.id.recently_bar_switch);
        this.mXS.setLineVisibility(false);
        this.mXS.setSpaceView(8);
        this.mXS.setText(R.string.privacy_hide_recently_bar_text);
        this.mXS.setOnSwitchStateChangeListener(this.mXU);
        xF(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xF(boolean z) {
        if (!z) {
            this.mXS.getSwitchView().turnOnNoCallback();
        } else {
            this.mXS.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dKp() {
        return this.mXQ;
    }

    public BdSwitchView dKq() {
        return this.mXP;
    }

    public TbSettingTextTipView dKr() {
        return this.mXN;
    }

    public TbSettingTextTipView dKs() {
        return this.mXO;
    }

    public TbSettingTextTipView dIE() {
        return this.mXT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mXM.getLayoutMode().setNightMode(i == 1);
        this.mXM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mXP.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mXQ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mXS.onChangeSkinType(this.mXM.getPageContext(), i);
        ap.setBackgroundResource(this.mXN, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dKt() {
        return this.mXR;
    }
}
