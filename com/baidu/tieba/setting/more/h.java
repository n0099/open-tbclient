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
    private SystemHelpSettingActivity ndj;
    private TbSettingTextTipView ndk;
    private TbSettingTextTipView ndl;
    private BdSwitchView ndm;
    private BdSwitchView ndn;
    private TbSettingTextNewDotView ndo;
    private MsgSettingItemView ndp;
    private TbSettingTextTipView ndq;
    private BdSwitchView.a ndr;
    private final CustomMessageListener nds;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.ndj = null;
        this.mParent = null;
        this.ndk = null;
        this.ndl = null;
        this.ndm = null;
        this.ndn = null;
        this.ndo = null;
        this.ndq = null;
        this.ndr = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.ndp.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.nds = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.ndj = systemHelpSettingActivity;
        this.ndj.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.ndj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ndj.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ndk = (TbSettingTextTipView) this.ndj.findViewById(R.id.clear_cache);
        this.ndk.hideArrow();
        this.ndk.setOnClickListener(this.ndj);
        this.ndk.setBottomLineVisibility(true);
        this.ndl = (TbSettingTextTipView) this.ndj.findViewById(R.id.clear_im);
        this.ndl.hideArrow();
        this.ndl.setBottomLineVisibility(true);
        this.ndl.setOnClickListener(this.ndj);
        this.ndm = (BdSwitchView) this.ndj.findViewById(R.id.item_switch);
        l.addToParentArea(this.ndj.getPageContext().getPageActivity(), this.ndm, 10, 10, 10, 10);
        this.ndm.setOnSwitchStateChangeListener(this.ndj);
        this.ndn = (BdSwitchView) this.ndj.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.ndj.getPageContext().getPageActivity(), this.ndn, 10, 10, 10, 10);
        this.ndn.setOnSwitchStateChangeListener(this.ndj);
        this.ndq = (TbSettingTextTipView) this.ndj.findViewById(R.id.debug_tool_launch);
        this.ndq.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.ndq.setVisibility(0);
        } else {
            this.ndq.setVisibility(8);
        }
        this.ndq.setOnClickListener(this.ndj);
        this.mParent = this.ndj.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.ndl.setVisibility(0);
        } else {
            this.ndl.setVisibility(8);
        }
        this.ndo = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.ndo.setOnClickListener(this.ndj);
        if (this.ndj != null) {
            this.nds.setTag(this.ndj.getUniqueId());
            MessageManager.getInstance().registerListener(this.nds);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.ndo.setVisibility(0);
        } else {
            this.ndo.setVisibility(8);
        }
        this.ndp = (MsgSettingItemView) this.ndj.findViewById(R.id.recently_bar_switch);
        this.ndp.setLineVisibility(false);
        this.ndp.setSpaceView(8);
        this.ndp.setText(R.string.privacy_hide_recently_bar_text);
        this.ndp.setOnSwitchStateChangeListener(this.ndr);
        xH(com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xH(boolean z) {
        if (!z) {
            this.ndp.getSwitchView().turnOnNoCallback();
        } else {
            this.ndp.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dKf() {
        return this.ndn;
    }

    public BdSwitchView dKg() {
        return this.ndm;
    }

    public TbSettingTextTipView dKh() {
        return this.ndk;
    }

    public TbSettingTextTipView dKi() {
        return this.ndl;
    }

    public TbSettingTextTipView dIu() {
        return this.ndq;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ndj.getLayoutMode().setNightMode(i == 1);
        this.ndj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ndm.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.ndn.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.ndp.onChangeSkinType(this.ndj.getPageContext(), i);
        ao.setBackgroundResource(this.ndk, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dKj() {
        return this.ndo;
    }
}
