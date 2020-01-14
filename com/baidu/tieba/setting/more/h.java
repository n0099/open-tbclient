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
    private SystemHelpSettingActivity jTL;
    private TbSettingTextTipView jTM;
    private TbSettingTextTipView jTN;
    private BdSwitchView jTO;
    private BdSwitchView jTP;
    private TbSettingTextNewDotView jTQ;
    private MsgSettingItemView jTR;
    private BdSwitchView.a jTS;
    private final CustomMessageListener jTT;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jTL = null;
        this.mParent = null;
        this.jTM = null;
        this.jTN = null;
        this.jTO = null;
        this.jTP = null;
        this.jTQ = null;
        this.jTS = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jTR.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jTT = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jTL = systemHelpSettingActivity;
        this.jTL.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jTL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jTL.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTM = (TbSettingTextTipView) this.jTL.findViewById(R.id.clear_cache);
        this.jTM.hideArrow();
        this.jTM.setOnClickListener(this.jTL);
        this.jTM.setBottomLineVisibility(true);
        this.jTN = (TbSettingTextTipView) this.jTL.findViewById(R.id.clear_im);
        this.jTN.hideArrow();
        this.jTN.setBottomLineVisibility(true);
        this.jTN.setOnClickListener(this.jTL);
        this.jTO = (BdSwitchView) this.jTL.findViewById(R.id.item_switch);
        l.addToParentArea(this.jTL.getPageContext().getPageActivity(), this.jTO, 10, 10, 10, 10);
        this.jTO.setOnSwitchStateChangeListener(this.jTL);
        this.jTP = (BdSwitchView) this.jTL.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jTL.getPageContext().getPageActivity(), this.jTP, 10, 10, 10, 10);
        this.jTP.setOnSwitchStateChangeListener(this.jTL);
        this.mParent = this.jTL.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jTN.setVisibility(0);
        } else {
            this.jTN.setVisibility(8);
        }
        this.jTQ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jTQ.setOnClickListener(this.jTL);
        if (this.jTL != null) {
            this.jTT.setTag(this.jTL.getUniqueId());
            MessageManager.getInstance().registerListener(this.jTT);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jTQ.setVisibility(0);
        } else {
            this.jTQ.setVisibility(8);
        }
        this.jTR = (MsgSettingItemView) this.jTL.findViewById(R.id.recently_bar_switch);
        this.jTR.setLineVisibility(false);
        this.jTR.setSpaceView(8);
        this.jTR.setText(R.string.privacy_hide_recently_bar_text);
        this.jTR.setOnSwitchStateChangeListener(this.jTS);
        sr(com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void sr(boolean z) {
        if (!z) {
            this.jTR.getSwitchView().turnOnNoCallback();
        } else {
            this.jTR.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cFD() {
        return this.jTP;
    }

    public BdSwitchView cFE() {
        return this.jTO;
    }

    public TbSettingTextTipView cFF() {
        return this.jTM;
    }

    public TbSettingTextTipView cFG() {
        return this.jTN;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jTL.getLayoutMode().setNightMode(i == 1);
        this.jTL.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jTO.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTP.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jTR.onChangeSkinType(this.jTL.getPageContext(), i);
        am.setBackgroundResource(this.jTM, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cFH() {
        return this.jTQ;
    }
}
