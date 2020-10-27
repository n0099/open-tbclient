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
/* loaded from: classes26.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity mDi;
    private TbSettingTextTipView mDj;
    private TbSettingTextTipView mDk;
    private BdSwitchView mDl;
    private BdSwitchView mDm;
    private TbSettingTextNewDotView mDn;
    private MsgSettingItemView mDo;
    private BdSwitchView.a mDp;
    private final CustomMessageListener mDq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mDi = null;
        this.mParent = null;
        this.mDj = null;
        this.mDk = null;
        this.mDl = null;
        this.mDm = null;
        this.mDn = null;
        this.mDp = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mDo.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mDq = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mDi = systemHelpSettingActivity;
        this.mDi.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mDi.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mDi.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mDj = (TbSettingTextTipView) this.mDi.findViewById(R.id.clear_cache);
        this.mDj.hideArrow();
        this.mDj.setOnClickListener(this.mDi);
        this.mDj.setBottomLineVisibility(true);
        this.mDk = (TbSettingTextTipView) this.mDi.findViewById(R.id.clear_im);
        this.mDk.hideArrow();
        this.mDk.setBottomLineVisibility(true);
        this.mDk.setOnClickListener(this.mDi);
        this.mDl = (BdSwitchView) this.mDi.findViewById(R.id.item_switch);
        l.addToParentArea(this.mDi.getPageContext().getPageActivity(), this.mDl, 10, 10, 10, 10);
        this.mDl.setOnSwitchStateChangeListener(this.mDi);
        this.mDm = (BdSwitchView) this.mDi.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mDi.getPageContext().getPageActivity(), this.mDm, 10, 10, 10, 10);
        this.mDm.setOnSwitchStateChangeListener(this.mDi);
        this.mParent = this.mDi.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mDk.setVisibility(0);
        } else {
            this.mDk.setVisibility(8);
        }
        this.mDn = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mDn.setOnClickListener(this.mDi);
        if (this.mDi != null) {
            this.mDq.setTag(this.mDi.getUniqueId());
            MessageManager.getInstance().registerListener(this.mDq);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mDn.setVisibility(0);
        } else {
            this.mDn.setVisibility(8);
        }
        this.mDo = (MsgSettingItemView) this.mDi.findViewById(R.id.recently_bar_switch);
        this.mDo.setLineVisibility(false);
        this.mDo.setSpaceView(8);
        this.mDo.setText(R.string.privacy_hide_recently_bar_text);
        this.mDo.setOnSwitchStateChangeListener(this.mDp);
        wP(com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void wP(boolean z) {
        if (!z) {
            this.mDo.getSwitchView().turnOnNoCallback();
        } else {
            this.mDo.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dCX() {
        return this.mDm;
    }

    public BdSwitchView dCY() {
        return this.mDl;
    }

    public TbSettingTextTipView dCZ() {
        return this.mDj;
    }

    public TbSettingTextTipView dDa() {
        return this.mDk;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mDi.getLayoutMode().setNightMode(i == 1);
        this.mDi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mDl.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mDm.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mDo.onChangeSkinType(this.mDi.getPageContext(), i);
        ap.setBackgroundResource(this.mDj, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dDb() {
        return this.mDn;
    }
}
