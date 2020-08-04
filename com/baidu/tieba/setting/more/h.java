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
/* loaded from: classes20.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity lAl;
    private TbSettingTextTipView lAm;
    private TbSettingTextTipView lAn;
    private BdSwitchView lAo;
    private BdSwitchView lAp;
    private TbSettingTextNewDotView lAq;
    private MsgSettingItemView lAr;
    private BdSwitchView.a lAs;
    private final CustomMessageListener lAt;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.lAl = null;
        this.mParent = null;
        this.lAm = null;
        this.lAn = null;
        this.lAo = null;
        this.lAp = null;
        this.lAq = null;
        this.lAs = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.lAr.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.lAt = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.lAl = systemHelpSettingActivity;
        this.lAl.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.lAl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.lAl.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lAm = (TbSettingTextTipView) this.lAl.findViewById(R.id.clear_cache);
        this.lAm.hideArrow();
        this.lAm.setOnClickListener(this.lAl);
        this.lAm.setBottomLineVisibility(true);
        this.lAn = (TbSettingTextTipView) this.lAl.findViewById(R.id.clear_im);
        this.lAn.hideArrow();
        this.lAn.setBottomLineVisibility(true);
        this.lAn.setOnClickListener(this.lAl);
        this.lAo = (BdSwitchView) this.lAl.findViewById(R.id.item_switch);
        l.addToParentArea(this.lAl.getPageContext().getPageActivity(), this.lAo, 10, 10, 10, 10);
        this.lAo.setOnSwitchStateChangeListener(this.lAl);
        this.lAp = (BdSwitchView) this.lAl.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.lAl.getPageContext().getPageActivity(), this.lAp, 10, 10, 10, 10);
        this.lAp.setOnSwitchStateChangeListener(this.lAl);
        this.mParent = this.lAl.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.lAn.setVisibility(0);
        } else {
            this.lAn.setVisibility(8);
        }
        this.lAq = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.lAq.setOnClickListener(this.lAl);
        if (this.lAl != null) {
            this.lAt.setTag(this.lAl.getUniqueId());
            MessageManager.getInstance().registerListener(this.lAt);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.lAq.setVisibility(0);
        } else {
            this.lAq.setVisibility(8);
        }
        this.lAr = (MsgSettingItemView) this.lAl.findViewById(R.id.recently_bar_switch);
        this.lAr.setLineVisibility(false);
        this.lAr.setSpaceView(8);
        this.lAr.setText(R.string.privacy_hide_recently_bar_text);
        this.lAr.setOnSwitchStateChangeListener(this.lAs);
        uS(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void uS(boolean z) {
        if (!z) {
            this.lAr.getSwitchView().turnOnNoCallback();
        } else {
            this.lAr.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dgN() {
        return this.lAp;
    }

    public BdSwitchView dgO() {
        return this.lAo;
    }

    public TbSettingTextTipView dgP() {
        return this.lAm;
    }

    public TbSettingTextTipView dgQ() {
        return this.lAn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lAl.getLayoutMode().setNightMode(i == 1);
        this.lAl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lAo.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lAp.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lAr.onChangeSkinType(this.lAl.getPageContext(), i);
        ao.setBackgroundResource(this.lAm, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dgR() {
        return this.lAq;
    }
}
