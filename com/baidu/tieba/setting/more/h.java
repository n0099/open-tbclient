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
    private SystemHelpSettingActivity lAj;
    private TbSettingTextTipView lAk;
    private TbSettingTextTipView lAl;
    private BdSwitchView lAm;
    private BdSwitchView lAn;
    private TbSettingTextNewDotView lAo;
    private MsgSettingItemView lAp;
    private BdSwitchView.a lAq;
    private final CustomMessageListener lAr;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.lAj = null;
        this.mParent = null;
        this.lAk = null;
        this.lAl = null;
        this.lAm = null;
        this.lAn = null;
        this.lAo = null;
        this.lAq = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.lAp.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.lAr = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.lAj = systemHelpSettingActivity;
        this.lAj.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.lAj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.lAj.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lAk = (TbSettingTextTipView) this.lAj.findViewById(R.id.clear_cache);
        this.lAk.hideArrow();
        this.lAk.setOnClickListener(this.lAj);
        this.lAk.setBottomLineVisibility(true);
        this.lAl = (TbSettingTextTipView) this.lAj.findViewById(R.id.clear_im);
        this.lAl.hideArrow();
        this.lAl.setBottomLineVisibility(true);
        this.lAl.setOnClickListener(this.lAj);
        this.lAm = (BdSwitchView) this.lAj.findViewById(R.id.item_switch);
        l.addToParentArea(this.lAj.getPageContext().getPageActivity(), this.lAm, 10, 10, 10, 10);
        this.lAm.setOnSwitchStateChangeListener(this.lAj);
        this.lAn = (BdSwitchView) this.lAj.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.lAj.getPageContext().getPageActivity(), this.lAn, 10, 10, 10, 10);
        this.lAn.setOnSwitchStateChangeListener(this.lAj);
        this.mParent = this.lAj.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.lAl.setVisibility(0);
        } else {
            this.lAl.setVisibility(8);
        }
        this.lAo = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.lAo.setOnClickListener(this.lAj);
        if (this.lAj != null) {
            this.lAr.setTag(this.lAj.getUniqueId());
            MessageManager.getInstance().registerListener(this.lAr);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.lAo.setVisibility(0);
        } else {
            this.lAo.setVisibility(8);
        }
        this.lAp = (MsgSettingItemView) this.lAj.findViewById(R.id.recently_bar_switch);
        this.lAp.setLineVisibility(false);
        this.lAp.setSpaceView(8);
        this.lAp.setText(R.string.privacy_hide_recently_bar_text);
        this.lAp.setOnSwitchStateChangeListener(this.lAq);
        uS(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void uS(boolean z) {
        if (!z) {
            this.lAp.getSwitchView().turnOnNoCallback();
        } else {
            this.lAp.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dgN() {
        return this.lAn;
    }

    public BdSwitchView dgO() {
        return this.lAm;
    }

    public TbSettingTextTipView dgP() {
        return this.lAk;
    }

    public TbSettingTextTipView dgQ() {
        return this.lAl;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lAj.getLayoutMode().setNightMode(i == 1);
        this.lAj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lAm.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lAn.setBackgroundRes(ao.getBitmap(R.drawable.bg_switch_open), ao.getBitmap(R.drawable.bg_switch_close), ao.getBitmap(R.drawable.btn_handle));
        this.lAp.onChangeSkinType(this.lAj.getPageContext(), i);
        ao.setBackgroundResource(this.lAk, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dgR() {
        return this.lAo;
    }
}
