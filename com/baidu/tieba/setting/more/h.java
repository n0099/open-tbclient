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
    private SystemHelpSettingActivity kXL;
    private TbSettingTextTipView kXM;
    private TbSettingTextTipView kXN;
    private BdSwitchView kXO;
    private BdSwitchView kXP;
    private TbSettingTextNewDotView kXQ;
    private MsgSettingItemView kXR;
    private BdSwitchView.a kXS;
    private final CustomMessageListener kXT;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.kXL = null;
        this.mParent = null;
        this.kXM = null;
        this.kXN = null;
        this.kXO = null;
        this.kXP = null;
        this.kXQ = null;
        this.kXS = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.kXR.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.kXT = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.kXL = systemHelpSettingActivity;
        this.kXL.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.kXL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kXL.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kXM = (TbSettingTextTipView) this.kXL.findViewById(R.id.clear_cache);
        this.kXM.hideArrow();
        this.kXM.setOnClickListener(this.kXL);
        this.kXM.setBottomLineVisibility(true);
        this.kXN = (TbSettingTextTipView) this.kXL.findViewById(R.id.clear_im);
        this.kXN.hideArrow();
        this.kXN.setBottomLineVisibility(true);
        this.kXN.setOnClickListener(this.kXL);
        this.kXO = (BdSwitchView) this.kXL.findViewById(R.id.item_switch);
        l.addToParentArea(this.kXL.getPageContext().getPageActivity(), this.kXO, 10, 10, 10, 10);
        this.kXO.setOnSwitchStateChangeListener(this.kXL);
        this.kXP = (BdSwitchView) this.kXL.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.kXL.getPageContext().getPageActivity(), this.kXP, 10, 10, 10, 10);
        this.kXP.setOnSwitchStateChangeListener(this.kXL);
        this.mParent = this.kXL.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.kXN.setVisibility(0);
        } else {
            this.kXN.setVisibility(8);
        }
        this.kXQ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.kXQ.setOnClickListener(this.kXL);
        if (this.kXL != null) {
            this.kXT.setTag(this.kXL.getUniqueId());
            MessageManager.getInstance().registerListener(this.kXT);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.kXQ.setVisibility(0);
        } else {
            this.kXQ.setVisibility(8);
        }
        this.kXR = (MsgSettingItemView) this.kXL.findViewById(R.id.recently_bar_switch);
        this.kXR.setLineVisibility(false);
        this.kXR.setSpaceView(8);
        this.kXR.setText(R.string.privacy_hide_recently_bar_text);
        this.kXR.setOnSwitchStateChangeListener(this.kXS);
        tZ(com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void tZ(boolean z) {
        if (!z) {
            this.kXR.getSwitchView().turnOnNoCallback();
        } else {
            this.kXR.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cZa() {
        return this.kXP;
    }

    public BdSwitchView cZb() {
        return this.kXO;
    }

    public TbSettingTextTipView cZc() {
        return this.kXM;
    }

    public TbSettingTextTipView cZd() {
        return this.kXN;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kXL.getLayoutMode().setNightMode(i == 1);
        this.kXL.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kXO.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kXP.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kXR.onChangeSkinType(this.kXL.getPageContext(), i);
        am.setBackgroundResource(this.kXM, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cZe() {
        return this.kXQ;
    }
}
