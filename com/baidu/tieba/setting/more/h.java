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
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity iWA;
    private TbSettingTextTipView iWB;
    private TbSettingTextTipView iWC;
    private BdSwitchView iWD;
    private BdSwitchView iWE;
    private TbSettingTextNewDotView iWF;
    private MsgSettingItemView iWG;
    private BdSwitchView.a iWH;
    private final CustomMessageListener iWI;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iWA = null;
        this.mParent = null;
        this.iWB = null;
        this.iWC = null;
        this.iWD = null;
        this.iWE = null;
        this.iWF = null;
        this.iWH = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iWG.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iWI = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iWA = systemHelpSettingActivity;
        this.iWA.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iWA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iWA.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWB = (TbSettingTextTipView) this.iWA.findViewById(R.id.clear_cache);
        this.iWB.hideArrow();
        this.iWB.setOnClickListener(this.iWA);
        this.iWB.setBottomLineVisibility(true);
        this.iWC = (TbSettingTextTipView) this.iWA.findViewById(R.id.clear_im);
        this.iWC.hideArrow();
        this.iWC.setBottomLineVisibility(true);
        this.iWC.setOnClickListener(this.iWA);
        this.iWD = (BdSwitchView) this.iWA.findViewById(R.id.item_switch);
        l.addToParentArea(this.iWA.getPageContext().getPageActivity(), this.iWD, 10, 10, 10, 10);
        this.iWD.setOnSwitchStateChangeListener(this.iWA);
        this.iWE = (BdSwitchView) this.iWA.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.iWA.getPageContext().getPageActivity(), this.iWE, 10, 10, 10, 10);
        this.iWE.setOnSwitchStateChangeListener(this.iWA);
        this.mParent = this.iWA.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iWC.setVisibility(0);
        } else {
            this.iWC.setVisibility(8);
        }
        this.iWF = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iWF.setOnClickListener(this.iWA);
        if (this.iWA != null) {
            this.iWI.setTag(this.iWA.getUniqueId());
            MessageManager.getInstance().registerListener(this.iWI);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iWF.setVisibility(0);
        } else {
            this.iWF.setVisibility(8);
        }
        this.iWG = (MsgSettingItemView) this.iWA.findViewById(R.id.recently_bar_switch);
        this.iWG.setLineVisibility(false);
        this.iWG.setSpaceView(8);
        this.iWG.setText(R.string.privacy_hide_recently_bar_text);
        this.iWG.setOnSwitchStateChangeListener(this.iWH);
        qx(com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qx(boolean z) {
        if (!z) {
            this.iWG.getSwitchView().turnOnNoCallback();
        } else {
            this.iWG.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView ckt() {
        return this.iWE;
    }

    public BdSwitchView cku() {
        return this.iWD;
    }

    public TbSettingTextTipView ckv() {
        return this.iWB;
    }

    public TbSettingTextTipView ckw() {
        return this.iWC;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iWA.getLayoutMode().setNightMode(i == 1);
        this.iWA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iWD.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iWE.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iWG.onChangeSkinType(this.iWA.getPageContext(), i);
        am.setBackgroundResource(this.iWB, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ckx() {
        return this.iWF;
    }
}
