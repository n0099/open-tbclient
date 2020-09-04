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
    private SystemHelpSettingActivity lRR;
    private TbSettingTextTipView lRS;
    private TbSettingTextTipView lRT;
    private BdSwitchView lRU;
    private BdSwitchView lRV;
    private TbSettingTextNewDotView lRW;
    private MsgSettingItemView lRX;
    private BdSwitchView.a lRY;
    private final CustomMessageListener lRZ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.lRR = null;
        this.mParent = null;
        this.lRS = null;
        this.lRT = null;
        this.lRU = null;
        this.lRV = null;
        this.lRW = null;
        this.lRY = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.lRX.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.lRZ = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.lRR = systemHelpSettingActivity;
        this.lRR.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.lRR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.lRR.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lRS = (TbSettingTextTipView) this.lRR.findViewById(R.id.clear_cache);
        this.lRS.hideArrow();
        this.lRS.setOnClickListener(this.lRR);
        this.lRS.setBottomLineVisibility(true);
        this.lRT = (TbSettingTextTipView) this.lRR.findViewById(R.id.clear_im);
        this.lRT.hideArrow();
        this.lRT.setBottomLineVisibility(true);
        this.lRT.setOnClickListener(this.lRR);
        this.lRU = (BdSwitchView) this.lRR.findViewById(R.id.item_switch);
        l.addToParentArea(this.lRR.getPageContext().getPageActivity(), this.lRU, 10, 10, 10, 10);
        this.lRU.setOnSwitchStateChangeListener(this.lRR);
        this.lRV = (BdSwitchView) this.lRR.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.lRR.getPageContext().getPageActivity(), this.lRV, 10, 10, 10, 10);
        this.lRV.setOnSwitchStateChangeListener(this.lRR);
        this.mParent = this.lRR.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.lRT.setVisibility(0);
        } else {
            this.lRT.setVisibility(8);
        }
        this.lRW = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.lRW.setOnClickListener(this.lRR);
        if (this.lRR != null) {
            this.lRZ.setTag(this.lRR.getUniqueId());
            MessageManager.getInstance().registerListener(this.lRZ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.lRW.setVisibility(0);
        } else {
            this.lRW.setVisibility(8);
        }
        this.lRX = (MsgSettingItemView) this.lRR.findViewById(R.id.recently_bar_switch);
        this.lRX.setLineVisibility(false);
        this.lRX.setSpaceView(8);
        this.lRX.setText(R.string.privacy_hide_recently_bar_text);
        this.lRX.setOnSwitchStateChangeListener(this.lRY);
        vJ(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void vJ(boolean z) {
        if (!z) {
            this.lRX.getSwitchView().turnOnNoCallback();
        } else {
            this.lRX.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dso() {
        return this.lRV;
    }

    public BdSwitchView dsp() {
        return this.lRU;
    }

    public TbSettingTextTipView dsq() {
        return this.lRS;
    }

    public TbSettingTextTipView dsr() {
        return this.lRT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lRR.getLayoutMode().setNightMode(i == 1);
        this.lRR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lRU.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lRV.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.lRX.onChangeSkinType(this.lRR.getPageContext(), i);
        ap.setBackgroundResource(this.lRS, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dss() {
        return this.lRW;
    }
}
