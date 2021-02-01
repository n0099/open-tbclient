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
    private SystemHelpSettingActivity nim;
    private TbSettingTextTipView nin;
    private TbSettingTextTipView nio;
    private BdSwitchView nip;
    private BdSwitchView niq;
    private TbSettingTextNewDotView nir;
    private MsgSettingItemView nis;
    private TbSettingTextTipView nit;
    private BdSwitchView.a niu;
    private final CustomMessageListener niv;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.nim = null;
        this.mParent = null;
        this.nin = null;
        this.nio = null;
        this.nip = null;
        this.niq = null;
        this.nir = null;
        this.nit = null;
        this.niu = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.nis.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.niv = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.nim = systemHelpSettingActivity;
        this.nim.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.nim.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.nim.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nin = (TbSettingTextTipView) this.nim.findViewById(R.id.clear_cache);
        this.nin.hideArrow();
        this.nin.setOnClickListener(this.nim);
        this.nin.setBottomLineVisibility(true);
        this.nio = (TbSettingTextTipView) this.nim.findViewById(R.id.clear_im);
        this.nio.hideArrow();
        this.nio.setBottomLineVisibility(true);
        this.nio.setOnClickListener(this.nim);
        this.nip = (BdSwitchView) this.nim.findViewById(R.id.item_switch);
        l.addToParentArea(this.nim.getPageContext().getPageActivity(), this.nip, 10, 10, 10, 10);
        this.nip.setOnSwitchStateChangeListener(this.nim);
        this.niq = (BdSwitchView) this.nim.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.nim.getPageContext().getPageActivity(), this.niq, 10, 10, 10, 10);
        this.niq.setOnSwitchStateChangeListener(this.nim);
        this.nit = (TbSettingTextTipView) this.nim.findViewById(R.id.debug_tool_launch);
        this.nit.hideArrow();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.nit.setVisibility(0);
        } else {
            this.nit.setVisibility(8);
        }
        this.nit.setOnClickListener(this.nim);
        this.mParent = this.nim.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.nio.setVisibility(0);
        } else {
            this.nio.setVisibility(8);
        }
        this.nir = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.nir.setOnClickListener(this.nim);
        if (this.nim != null) {
            this.niv.setTag(this.nim.getUniqueId());
            MessageManager.getInstance().registerListener(this.niv);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.nir.setVisibility(0);
        } else {
            this.nir.setVisibility(8);
        }
        this.nis = (MsgSettingItemView) this.nim.findViewById(R.id.recently_bar_switch);
        this.nis.setLineVisibility(false);
        this.nis.setSpaceView(8);
        this.nis.setText(R.string.privacy_hide_recently_bar_text);
        this.nis.setOnSwitchStateChangeListener(this.niu);
        xW(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void xW(boolean z) {
        if (!z) {
            this.nis.getSwitchView().turnOnNoCallback();
        } else {
            this.nis.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dIz() {
        return this.niq;
    }

    public BdSwitchView dIA() {
        return this.nip;
    }

    public TbSettingTextTipView dIB() {
        return this.nin;
    }

    public TbSettingTextTipView dIC() {
        return this.nio;
    }

    public TbSettingTextTipView dGO() {
        return this.nit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.nim.getLayoutMode().setNightMode(i == 1);
        this.nim.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nip.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.niq.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.nis.onChangeSkinType(this.nim.getPageContext(), i);
        ap.setBackgroundResource(this.nin, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dID() {
        return this.nir;
    }
}
