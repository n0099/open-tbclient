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
/* loaded from: classes11.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity jTG;
    private TbSettingTextTipView jTH;
    private TbSettingTextTipView jTI;
    private BdSwitchView jTJ;
    private BdSwitchView jTK;
    private TbSettingTextNewDotView jTL;
    private MsgSettingItemView jTM;
    private BdSwitchView.a jTN;
    private final CustomMessageListener jTO;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jTG = null;
        this.mParent = null;
        this.jTH = null;
        this.jTI = null;
        this.jTJ = null;
        this.jTK = null;
        this.jTL = null;
        this.jTN = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jTM.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jTO = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jTG = systemHelpSettingActivity;
        this.jTG.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jTG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jTG.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTH = (TbSettingTextTipView) this.jTG.findViewById(R.id.clear_cache);
        this.jTH.hideArrow();
        this.jTH.setOnClickListener(this.jTG);
        this.jTH.setBottomLineVisibility(true);
        this.jTI = (TbSettingTextTipView) this.jTG.findViewById(R.id.clear_im);
        this.jTI.hideArrow();
        this.jTI.setBottomLineVisibility(true);
        this.jTI.setOnClickListener(this.jTG);
        this.jTJ = (BdSwitchView) this.jTG.findViewById(R.id.item_switch);
        l.addToParentArea(this.jTG.getPageContext().getPageActivity(), this.jTJ, 10, 10, 10, 10);
        this.jTJ.setOnSwitchStateChangeListener(this.jTG);
        this.jTK = (BdSwitchView) this.jTG.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jTG.getPageContext().getPageActivity(), this.jTK, 10, 10, 10, 10);
        this.jTK.setOnSwitchStateChangeListener(this.jTG);
        this.mParent = this.jTG.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jTI.setVisibility(0);
        } else {
            this.jTI.setVisibility(8);
        }
        this.jTL = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jTL.setOnClickListener(this.jTG);
        if (this.jTG != null) {
            this.jTO.setTag(this.jTG.getUniqueId());
            MessageManager.getInstance().registerListener(this.jTO);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jTL.setVisibility(0);
        } else {
            this.jTL.setVisibility(8);
        }
        this.jTM = (MsgSettingItemView) this.jTG.findViewById(R.id.recently_bar_switch);
        this.jTM.setLineVisibility(false);
        this.jTM.setSpaceView(8);
        this.jTM.setText(R.string.privacy_hide_recently_bar_text);
        this.jTM.setOnSwitchStateChangeListener(this.jTN);
        sr(com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void sr(boolean z) {
        if (!z) {
            this.jTM.getSwitchView().turnOnNoCallback();
        } else {
            this.jTM.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cFB() {
        return this.jTK;
    }

    public BdSwitchView cFC() {
        return this.jTJ;
    }

    public TbSettingTextTipView cFD() {
        return this.jTH;
    }

    public TbSettingTextTipView cFE() {
        return this.jTI;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jTG.getLayoutMode().setNightMode(i == 1);
        this.jTG.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTJ.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTK.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTM.onChangeSkinType(this.jTG.getPageContext(), i);
        am.setBackgroundResource(this.jTH, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cFF() {
        return this.jTL;
    }
}
