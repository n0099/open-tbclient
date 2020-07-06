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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes13.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity lsR;
    private TbSettingTextTipView lsS;
    private TbSettingTextTipView lsT;
    private BdSwitchView lsU;
    private BdSwitchView lsV;
    private TbSettingTextNewDotView lsW;
    private MsgSettingItemView lsX;
    private BdSwitchView.a lsY;
    private final CustomMessageListener lsZ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.lsR = null;
        this.mParent = null;
        this.lsS = null;
        this.lsT = null;
        this.lsU = null;
        this.lsV = null;
        this.lsW = null;
        this.lsY = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.lsX.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.lsZ = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.lsR = systemHelpSettingActivity;
        this.lsR.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.lsR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.lsR.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lsS = (TbSettingTextTipView) this.lsR.findViewById(R.id.clear_cache);
        this.lsS.hideArrow();
        this.lsS.setOnClickListener(this.lsR);
        this.lsS.setBottomLineVisibility(true);
        this.lsT = (TbSettingTextTipView) this.lsR.findViewById(R.id.clear_im);
        this.lsT.hideArrow();
        this.lsT.setBottomLineVisibility(true);
        this.lsT.setOnClickListener(this.lsR);
        this.lsU = (BdSwitchView) this.lsR.findViewById(R.id.item_switch);
        l.addToParentArea(this.lsR.getPageContext().getPageActivity(), this.lsU, 10, 10, 10, 10);
        this.lsU.setOnSwitchStateChangeListener(this.lsR);
        this.lsV = (BdSwitchView) this.lsR.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.lsR.getPageContext().getPageActivity(), this.lsV, 10, 10, 10, 10);
        this.lsV.setOnSwitchStateChangeListener(this.lsR);
        this.mParent = this.lsR.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.lsT.setVisibility(0);
        } else {
            this.lsT.setVisibility(8);
        }
        this.lsW = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.lsW.setOnClickListener(this.lsR);
        if (this.lsR != null) {
            this.lsZ.setTag(this.lsR.getUniqueId());
            MessageManager.getInstance().registerListener(this.lsZ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.lsW.setVisibility(0);
        } else {
            this.lsW.setVisibility(8);
        }
        this.lsX = (MsgSettingItemView) this.lsR.findViewById(R.id.recently_bar_switch);
        this.lsX.setLineVisibility(false);
        this.lsX.setSpaceView(8);
        this.lsX.setText(R.string.privacy_hide_recently_bar_text);
        this.lsX.setOnSwitchStateChangeListener(this.lsY);
        uo(com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void uo(boolean z) {
        if (!z) {
            this.lsX.getSwitchView().turnOnNoCallback();
        } else {
            this.lsX.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView ddG() {
        return this.lsV;
    }

    public BdSwitchView ddH() {
        return this.lsU;
    }

    public TbSettingTextTipView ddI() {
        return this.lsS;
    }

    public TbSettingTextTipView ddJ() {
        return this.lsT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lsR.getLayoutMode().setNightMode(i == 1);
        this.lsR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lsU.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        this.lsV.setBackgroundRes(an.getBitmap(R.drawable.bg_switch_open), an.getBitmap(R.drawable.bg_switch_close), an.getBitmap(R.drawable.btn_handle));
        this.lsX.onChangeSkinType(this.lsR.getPageContext(), i);
        an.setBackgroundResource(this.lsS, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ddK() {
        return this.lsW;
    }
}
