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
/* loaded from: classes20.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity lRC;
    private TbSettingTextTipView lRD;
    private TbSettingTextTipView lRE;
    private BdSwitchView lRF;
    private BdSwitchView lRG;
    private TbSettingTextNewDotView lRH;
    private MsgSettingItemView lRI;
    private BdSwitchView.a lRJ;
    private final CustomMessageListener lRK;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.lRC = null;
        this.mParent = null;
        this.lRD = null;
        this.lRE = null;
        this.lRF = null;
        this.lRG = null;
        this.lRH = null;
        this.lRJ = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.lRI.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.lRK = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.lRC = systemHelpSettingActivity;
        this.lRC.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.lRC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.lRC.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lRD = (TbSettingTextTipView) this.lRC.findViewById(R.id.clear_cache);
        this.lRD.hideArrow();
        this.lRD.setOnClickListener(this.lRC);
        this.lRD.setBottomLineVisibility(true);
        this.lRE = (TbSettingTextTipView) this.lRC.findViewById(R.id.clear_im);
        this.lRE.hideArrow();
        this.lRE.setBottomLineVisibility(true);
        this.lRE.setOnClickListener(this.lRC);
        this.lRF = (BdSwitchView) this.lRC.findViewById(R.id.item_switch);
        l.addToParentArea(this.lRC.getPageContext().getPageActivity(), this.lRF, 10, 10, 10, 10);
        this.lRF.setOnSwitchStateChangeListener(this.lRC);
        this.lRG = (BdSwitchView) this.lRC.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.lRC.getPageContext().getPageActivity(), this.lRG, 10, 10, 10, 10);
        this.lRG.setOnSwitchStateChangeListener(this.lRC);
        this.mParent = this.lRC.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.lRE.setVisibility(0);
        } else {
            this.lRE.setVisibility(8);
        }
        this.lRH = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.lRH.setOnClickListener(this.lRC);
        if (this.lRC != null) {
            this.lRK.setTag(this.lRC.getUniqueId());
            MessageManager.getInstance().registerListener(this.lRK);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.lRH.setVisibility(0);
        } else {
            this.lRH.setVisibility(8);
        }
        this.lRI = (MsgSettingItemView) this.lRC.findViewById(R.id.recently_bar_switch);
        this.lRI.setLineVisibility(false);
        this.lRI.setSpaceView(8);
        this.lRI.setText(R.string.privacy_hide_recently_bar_text);
        this.lRI.setOnSwitchStateChangeListener(this.lRJ);
        vH(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void vH(boolean z) {
        if (!z) {
            this.lRI.getSwitchView().turnOnNoCallback();
        } else {
            this.lRI.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dsj() {
        return this.lRG;
    }

    public BdSwitchView dsk() {
        return this.lRF;
    }

    public TbSettingTextTipView dsl() {
        return this.lRD;
    }

    public TbSettingTextTipView dsm() {
        return this.lRE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lRC.getLayoutMode().setNightMode(i == 1);
        this.lRC.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lRF.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lRG.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lRI.onChangeSkinType(this.lRC.getPageContext(), i);
        ap.setBackgroundResource(this.lRD, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dsn() {
        return this.lRH;
    }
}
