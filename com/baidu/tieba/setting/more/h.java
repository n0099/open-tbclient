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
/* loaded from: classes25.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity mJL;
    private TbSettingTextTipView mJM;
    private TbSettingTextTipView mJN;
    private BdSwitchView mJO;
    private BdSwitchView mJP;
    private TbSettingTextNewDotView mJQ;
    private MsgSettingItemView mJR;
    private BdSwitchView.a mJS;
    private final CustomMessageListener mJT;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mJL = null;
        this.mParent = null;
        this.mJM = null;
        this.mJN = null;
        this.mJO = null;
        this.mJP = null;
        this.mJQ = null;
        this.mJS = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mJR.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mJT = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mJL = systemHelpSettingActivity;
        this.mJL.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mJL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mJL.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mJM = (TbSettingTextTipView) this.mJL.findViewById(R.id.clear_cache);
        this.mJM.hideArrow();
        this.mJM.setOnClickListener(this.mJL);
        this.mJM.setBottomLineVisibility(true);
        this.mJN = (TbSettingTextTipView) this.mJL.findViewById(R.id.clear_im);
        this.mJN.hideArrow();
        this.mJN.setBottomLineVisibility(true);
        this.mJN.setOnClickListener(this.mJL);
        this.mJO = (BdSwitchView) this.mJL.findViewById(R.id.item_switch);
        l.addToParentArea(this.mJL.getPageContext().getPageActivity(), this.mJO, 10, 10, 10, 10);
        this.mJO.setOnSwitchStateChangeListener(this.mJL);
        this.mJP = (BdSwitchView) this.mJL.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mJL.getPageContext().getPageActivity(), this.mJP, 10, 10, 10, 10);
        this.mJP.setOnSwitchStateChangeListener(this.mJL);
        this.mParent = this.mJL.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mJN.setVisibility(0);
        } else {
            this.mJN.setVisibility(8);
        }
        this.mJQ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mJQ.setOnClickListener(this.mJL);
        if (this.mJL != null) {
            this.mJT.setTag(this.mJL.getUniqueId());
            MessageManager.getInstance().registerListener(this.mJT);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mJQ.setVisibility(0);
        } else {
            this.mJQ.setVisibility(8);
        }
        this.mJR = (MsgSettingItemView) this.mJL.findViewById(R.id.recently_bar_switch);
        this.mJR.setLineVisibility(false);
        this.mJR.setSpaceView(8);
        this.mJR.setText(R.string.privacy_hide_recently_bar_text);
        this.mJR.setOnSwitchStateChangeListener(this.mJS);
        xb(com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xb(boolean z) {
        if (!z) {
            this.mJR.getSwitchView().turnOnNoCallback();
        } else {
            this.mJR.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dFe() {
        return this.mJP;
    }

    public BdSwitchView dFf() {
        return this.mJO;
    }

    public TbSettingTextTipView dFg() {
        return this.mJM;
    }

    public TbSettingTextTipView dFh() {
        return this.mJN;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mJL.getLayoutMode().setNightMode(i == 1);
        this.mJL.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mJO.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mJP.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mJR.onChangeSkinType(this.mJL.getPageContext(), i);
        ap.setBackgroundResource(this.mJM, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dFi() {
        return this.mJQ;
    }
}
