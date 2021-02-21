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
/* loaded from: classes8.dex */
public class h extends com.baidu.adp.base.d<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity niM;
    private TbSettingTextTipView niN;
    private TbSettingTextTipView niO;
    private BdSwitchView niP;
    private BdSwitchView niQ;
    private TbSettingTextNewDotView niR;
    private MsgSettingItemView niS;
    private TbSettingTextTipView niT;
    private BdSwitchView.a niU;
    private final CustomMessageListener niV;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.niM = null;
        this.mParent = null;
        this.niN = null;
        this.niO = null;
        this.niP = null;
        this.niQ = null;
        this.niR = null;
        this.niT = null;
        this.niU = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.niS.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.niV = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.niM = systemHelpSettingActivity;
        this.niM.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.niM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.niM.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.niN = (TbSettingTextTipView) this.niM.findViewById(R.id.clear_cache);
        this.niN.hideArrow();
        this.niN.setOnClickListener(this.niM);
        this.niN.setBottomLineVisibility(true);
        this.niO = (TbSettingTextTipView) this.niM.findViewById(R.id.clear_im);
        this.niO.hideArrow();
        this.niO.setBottomLineVisibility(true);
        this.niO.setOnClickListener(this.niM);
        this.niP = (BdSwitchView) this.niM.findViewById(R.id.item_switch);
        l.addToParentArea(this.niM.getPageContext().getPageActivity(), this.niP, 10, 10, 10, 10);
        this.niP.setOnSwitchStateChangeListener(this.niM);
        this.niQ = (BdSwitchView) this.niM.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.niM.getPageContext().getPageActivity(), this.niQ, 10, 10, 10, 10);
        this.niQ.setOnSwitchStateChangeListener(this.niM);
        this.niT = (TbSettingTextTipView) this.niM.findViewById(R.id.debug_tool_launch);
        this.niT.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.niT.setVisibility(0);
        } else {
            this.niT.setVisibility(8);
        }
        this.niT.setOnClickListener(this.niM);
        this.mParent = this.niM.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.niO.setVisibility(0);
        } else {
            this.niO.setVisibility(8);
        }
        this.niR = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.niR.setOnClickListener(this.niM);
        if (this.niM != null) {
            this.niV.setTag(this.niM.getUniqueId());
            MessageManager.getInstance().registerListener(this.niV);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.niR.setVisibility(0);
        } else {
            this.niR.setVisibility(8);
        }
        this.niS = (MsgSettingItemView) this.niM.findViewById(R.id.recently_bar_switch);
        this.niS.setLineVisibility(false);
        this.niS.setSpaceView(8);
        this.niS.setText(R.string.privacy_hide_recently_bar_text);
        this.niS.setOnSwitchStateChangeListener(this.niU);
        xW(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xW(boolean z) {
        if (!z) {
            this.niS.getSwitchView().turnOnNoCallback();
        } else {
            this.niS.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dIH() {
        return this.niQ;
    }

    public BdSwitchView dII() {
        return this.niP;
    }

    public TbSettingTextTipView dIJ() {
        return this.niN;
    }

    public TbSettingTextTipView dIK() {
        return this.niO;
    }

    public TbSettingTextTipView dGW() {
        return this.niT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.niM.getLayoutMode().setNightMode(i == 1);
        this.niM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.niP.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.niQ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.niS.onChangeSkinType(this.niM.getPageContext(), i);
        ap.setBackgroundResource(this.niN, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dIL() {
        return this.niR;
    }
}
