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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class h extends com.baidu.adp.base.d<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity ndi;
    private TbSettingTextTipView ndj;
    private TbSettingTextTipView ndk;
    private BdSwitchView ndl;
    private BdSwitchView ndm;
    private TbSettingTextNewDotView ndn;
    private MsgSettingItemView ndo;
    private TbSettingTextTipView ndp;
    private BdSwitchView.a ndq;
    private final CustomMessageListener ndr;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.ndi = null;
        this.mParent = null;
        this.ndj = null;
        this.ndk = null;
        this.ndl = null;
        this.ndm = null;
        this.ndn = null;
        this.ndp = null;
        this.ndq = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.ndo.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.ndr = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.ndi = systemHelpSettingActivity;
        this.ndi.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.ndi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ndi.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ndj = (TbSettingTextTipView) this.ndi.findViewById(R.id.clear_cache);
        this.ndj.hideArrow();
        this.ndj.setOnClickListener(this.ndi);
        this.ndj.setBottomLineVisibility(true);
        this.ndk = (TbSettingTextTipView) this.ndi.findViewById(R.id.clear_im);
        this.ndk.hideArrow();
        this.ndk.setBottomLineVisibility(true);
        this.ndk.setOnClickListener(this.ndi);
        this.ndl = (BdSwitchView) this.ndi.findViewById(R.id.item_switch);
        l.addToParentArea(this.ndi.getPageContext().getPageActivity(), this.ndl, 10, 10, 10, 10);
        this.ndl.setOnSwitchStateChangeListener(this.ndi);
        this.ndm = (BdSwitchView) this.ndi.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.ndi.getPageContext().getPageActivity(), this.ndm, 10, 10, 10, 10);
        this.ndm.setOnSwitchStateChangeListener(this.ndi);
        this.ndp = (TbSettingTextTipView) this.ndi.findViewById(R.id.debug_tool_launch);
        this.ndp.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.ndp.setVisibility(0);
        } else {
            this.ndp.setVisibility(8);
        }
        this.ndp.setOnClickListener(this.ndi);
        this.mParent = this.ndi.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.ndk.setVisibility(0);
        } else {
            this.ndk.setVisibility(8);
        }
        this.ndn = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.ndn.setOnClickListener(this.ndi);
        if (this.ndi != null) {
            this.ndr.setTag(this.ndi.getUniqueId());
            MessageManager.getInstance().registerListener(this.ndr);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.ndn.setVisibility(0);
        } else {
            this.ndn.setVisibility(8);
        }
        this.ndo = (MsgSettingItemView) this.ndi.findViewById(R.id.recently_bar_switch);
        this.ndo.setLineVisibility(false);
        this.ndo.setSpaceView(8);
        this.ndo.setText(R.string.privacy_hide_recently_bar_text);
        this.ndo.setOnSwitchStateChangeListener(this.ndq);
        xH(com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xH(boolean z) {
        if (!z) {
            this.ndo.getSwitchView().turnOnNoCallback();
        } else {
            this.ndo.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dKg() {
        return this.ndm;
    }

    public BdSwitchView dKh() {
        return this.ndl;
    }

    public TbSettingTextTipView dKi() {
        return this.ndj;
    }

    public TbSettingTextTipView dKj() {
        return this.ndk;
    }

    public TbSettingTextTipView dIv() {
        return this.ndp;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ndi.getLayoutMode().setNightMode(i == 1);
        this.ndi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ndl.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.ndm.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.ndo.onChangeSkinType(this.ndi.getPageContext(), i);
        ao.setBackgroundResource(this.ndj, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dKk() {
        return this.ndn;
    }
}
