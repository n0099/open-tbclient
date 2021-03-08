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
/* loaded from: classes7.dex */
public class h extends com.baidu.adp.base.d<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity nkQ;
    private TbSettingTextTipView nkR;
    private TbSettingTextTipView nkS;
    private BdSwitchView nkT;
    private BdSwitchView nkU;
    private TbSettingTextNewDotView nkV;
    private MsgSettingItemView nkW;
    private TbSettingTextTipView nkX;
    private BdSwitchView.a nkY;
    private final CustomMessageListener nkZ;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.nkQ = null;
        this.mParent = null;
        this.nkR = null;
        this.nkS = null;
        this.nkT = null;
        this.nkU = null;
        this.nkV = null;
        this.nkX = null;
        this.nkY = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.nkW.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.nkZ = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.nkQ = systemHelpSettingActivity;
        this.nkQ.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.nkQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.nkQ.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nkR = (TbSettingTextTipView) this.nkQ.findViewById(R.id.clear_cache);
        this.nkR.hideArrow();
        this.nkR.setOnClickListener(this.nkQ);
        this.nkR.setBottomLineVisibility(true);
        this.nkS = (TbSettingTextTipView) this.nkQ.findViewById(R.id.clear_im);
        this.nkS.hideArrow();
        this.nkS.setBottomLineVisibility(true);
        this.nkS.setOnClickListener(this.nkQ);
        this.nkT = (BdSwitchView) this.nkQ.findViewById(R.id.item_switch);
        l.addToParentArea(this.nkQ.getPageContext().getPageActivity(), this.nkT, 10, 10, 10, 10);
        this.nkT.setOnSwitchStateChangeListener(this.nkQ);
        this.nkU = (BdSwitchView) this.nkQ.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.nkQ.getPageContext().getPageActivity(), this.nkU, 10, 10, 10, 10);
        this.nkU.setOnSwitchStateChangeListener(this.nkQ);
        this.nkX = (TbSettingTextTipView) this.nkQ.findViewById(R.id.debug_tool_launch);
        this.nkX.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.nkX.setVisibility(0);
        } else {
            this.nkX.setVisibility(8);
        }
        this.nkX.setOnClickListener(this.nkQ);
        this.mParent = this.nkQ.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.nkS.setVisibility(0);
        } else {
            this.nkS.setVisibility(8);
        }
        this.nkV = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.nkV.setOnClickListener(this.nkQ);
        if (this.nkQ != null) {
            this.nkZ.setTag(this.nkQ.getUniqueId());
            MessageManager.getInstance().registerListener(this.nkZ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.nkV.setVisibility(0);
        } else {
            this.nkV.setVisibility(8);
        }
        this.nkW = (MsgSettingItemView) this.nkQ.findViewById(R.id.recently_bar_switch);
        this.nkW.setLineVisibility(false);
        this.nkW.setSpaceView(8);
        this.nkW.setText(R.string.privacy_hide_recently_bar_text);
        this.nkW.setOnSwitchStateChangeListener(this.nkY);
        xW(com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xW(boolean z) {
        if (!z) {
            this.nkW.getSwitchView().turnOnNoCallback();
        } else {
            this.nkW.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dIP() {
        return this.nkU;
    }

    public BdSwitchView dIQ() {
        return this.nkT;
    }

    public TbSettingTextTipView dIR() {
        return this.nkR;
    }

    public TbSettingTextTipView dIS() {
        return this.nkS;
    }

    public TbSettingTextTipView dHe() {
        return this.nkX;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.nkQ.getLayoutMode().setNightMode(i == 1);
        this.nkQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nkT.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.nkU.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.nkW.onChangeSkinType(this.nkQ.getPageContext(), i);
        ap.setBackgroundResource(this.nkR, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dIT() {
        return this.nkV;
    }
}
