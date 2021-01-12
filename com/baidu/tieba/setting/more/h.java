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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.base.d<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity mYD;
    private TbSettingTextTipView mYE;
    private TbSettingTextTipView mYF;
    private BdSwitchView mYG;
    private BdSwitchView mYH;
    private TbSettingTextNewDotView mYI;
    private MsgSettingItemView mYJ;
    private TbSettingTextTipView mYK;
    private BdSwitchView.a mYL;
    private final CustomMessageListener mYM;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mYD = null;
        this.mParent = null;
        this.mYE = null;
        this.mYF = null;
        this.mYG = null;
        this.mYH = null;
        this.mYI = null;
        this.mYK = null;
        this.mYL = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mYJ.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mYM = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mYD = systemHelpSettingActivity;
        this.mYD.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mYD.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mYD.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mYE = (TbSettingTextTipView) this.mYD.findViewById(R.id.clear_cache);
        this.mYE.hideArrow();
        this.mYE.setOnClickListener(this.mYD);
        this.mYE.setBottomLineVisibility(true);
        this.mYF = (TbSettingTextTipView) this.mYD.findViewById(R.id.clear_im);
        this.mYF.hideArrow();
        this.mYF.setBottomLineVisibility(true);
        this.mYF.setOnClickListener(this.mYD);
        this.mYG = (BdSwitchView) this.mYD.findViewById(R.id.item_switch);
        l.addToParentArea(this.mYD.getPageContext().getPageActivity(), this.mYG, 10, 10, 10, 10);
        this.mYG.setOnSwitchStateChangeListener(this.mYD);
        this.mYH = (BdSwitchView) this.mYD.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mYD.getPageContext().getPageActivity(), this.mYH, 10, 10, 10, 10);
        this.mYH.setOnSwitchStateChangeListener(this.mYD);
        this.mYK = (TbSettingTextTipView) this.mYD.findViewById(R.id.debug_tool_launch);
        this.mYK.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.mYK.setVisibility(0);
        } else {
            this.mYK.setVisibility(8);
        }
        this.mYK.setOnClickListener(this.mYD);
        this.mParent = this.mYD.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mYF.setVisibility(0);
        } else {
            this.mYF.setVisibility(8);
        }
        this.mYI = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mYI.setOnClickListener(this.mYD);
        if (this.mYD != null) {
            this.mYM.setTag(this.mYD.getUniqueId());
            MessageManager.getInstance().registerListener(this.mYM);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mYI.setVisibility(0);
        } else {
            this.mYI.setVisibility(8);
        }
        this.mYJ = (MsgSettingItemView) this.mYD.findViewById(R.id.recently_bar_switch);
        this.mYJ.setLineVisibility(false);
        this.mYJ.setSpaceView(8);
        this.mYJ.setText(R.string.privacy_hide_recently_bar_text);
        this.mYJ.setOnSwitchStateChangeListener(this.mYL);
        xD(com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xD(boolean z) {
        if (!z) {
            this.mYJ.getSwitchView().turnOnNoCallback();
        } else {
            this.mYJ.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dGo() {
        return this.mYH;
    }

    public BdSwitchView dGp() {
        return this.mYG;
    }

    public TbSettingTextTipView dGq() {
        return this.mYE;
    }

    public TbSettingTextTipView dGr() {
        return this.mYF;
    }

    public TbSettingTextTipView dED() {
        return this.mYK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mYD.getLayoutMode().setNightMode(i == 1);
        this.mYD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mYG.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.mYH.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.mYJ.onChangeSkinType(this.mYD.getPageContext(), i);
        ao.setBackgroundResource(this.mYE, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dGs() {
        return this.mYI;
    }
}
