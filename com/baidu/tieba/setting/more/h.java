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
    private SystemHelpSettingActivity jUU;
    private TbSettingTextTipView jUV;
    private TbSettingTextTipView jUW;
    private BdSwitchView jUX;
    private BdSwitchView jUY;
    private TbSettingTextNewDotView jUZ;
    private MsgSettingItemView jVa;
    private BdSwitchView.a jVb;
    private final CustomMessageListener jVc;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.jUU = null;
        this.mParent = null;
        this.jUV = null;
        this.jUW = null;
        this.jUX = null;
        this.jUY = null;
        this.jUZ = null;
        this.jVb = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.jVa.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.jVc = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.jUU = systemHelpSettingActivity;
        this.jUU.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.jUU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.jUU.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUV = (TbSettingTextTipView) this.jUU.findViewById(R.id.clear_cache);
        this.jUV.hideArrow();
        this.jUV.setOnClickListener(this.jUU);
        this.jUV.setBottomLineVisibility(true);
        this.jUW = (TbSettingTextTipView) this.jUU.findViewById(R.id.clear_im);
        this.jUW.hideArrow();
        this.jUW.setBottomLineVisibility(true);
        this.jUW.setOnClickListener(this.jUU);
        this.jUX = (BdSwitchView) this.jUU.findViewById(R.id.item_switch);
        l.addToParentArea(this.jUU.getPageContext().getPageActivity(), this.jUX, 10, 10, 10, 10);
        this.jUX.setOnSwitchStateChangeListener(this.jUU);
        this.jUY = (BdSwitchView) this.jUU.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.jUU.getPageContext().getPageActivity(), this.jUY, 10, 10, 10, 10);
        this.jUY.setOnSwitchStateChangeListener(this.jUU);
        this.mParent = this.jUU.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.jUW.setVisibility(0);
        } else {
            this.jUW.setVisibility(8);
        }
        this.jUZ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.jUZ.setOnClickListener(this.jUU);
        if (this.jUU != null) {
            this.jVc.setTag(this.jUU.getUniqueId());
            MessageManager.getInstance().registerListener(this.jVc);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.jUZ.setVisibility(0);
        } else {
            this.jUZ.setVisibility(8);
        }
        this.jVa = (MsgSettingItemView) this.jUU.findViewById(R.id.recently_bar_switch);
        this.jVa.setLineVisibility(false);
        this.jVa.setSpaceView(8);
        this.jVa.setText(R.string.privacy_hide_recently_bar_text);
        this.jVa.setOnSwitchStateChangeListener(this.jVb);
        su(com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void su(boolean z) {
        if (!z) {
            this.jVa.getSwitchView().turnOnNoCallback();
        } else {
            this.jVa.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cHh() {
        return this.jUY;
    }

    public BdSwitchView cHi() {
        return this.jUX;
    }

    public TbSettingTextTipView cHj() {
        return this.jUV;
    }

    public TbSettingTextTipView cHk() {
        return this.jUW;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jUU.getLayoutMode().setNightMode(i == 1);
        this.jUU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jUX.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jUY.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.jVa.onChangeSkinType(this.jUU.getPageContext(), i);
        am.setBackgroundResource(this.jUV, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cHl() {
        return this.jUZ;
    }
}
