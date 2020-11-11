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
    private SystemHelpSettingActivity mJm;
    private TbSettingTextTipView mJn;
    private TbSettingTextTipView mJo;
    private BdSwitchView mJp;
    private BdSwitchView mJq;
    private TbSettingTextNewDotView mJr;
    private MsgSettingItemView mJs;
    private BdSwitchView.a mJt;
    private final CustomMessageListener mJu;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mJm = null;
        this.mParent = null;
        this.mJn = null;
        this.mJo = null;
        this.mJp = null;
        this.mJq = null;
        this.mJr = null;
        this.mJt = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mJs.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mJu = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mJm = systemHelpSettingActivity;
        this.mJm.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mJm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mJm.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mJn = (TbSettingTextTipView) this.mJm.findViewById(R.id.clear_cache);
        this.mJn.hideArrow();
        this.mJn.setOnClickListener(this.mJm);
        this.mJn.setBottomLineVisibility(true);
        this.mJo = (TbSettingTextTipView) this.mJm.findViewById(R.id.clear_im);
        this.mJo.hideArrow();
        this.mJo.setBottomLineVisibility(true);
        this.mJo.setOnClickListener(this.mJm);
        this.mJp = (BdSwitchView) this.mJm.findViewById(R.id.item_switch);
        l.addToParentArea(this.mJm.getPageContext().getPageActivity(), this.mJp, 10, 10, 10, 10);
        this.mJp.setOnSwitchStateChangeListener(this.mJm);
        this.mJq = (BdSwitchView) this.mJm.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mJm.getPageContext().getPageActivity(), this.mJq, 10, 10, 10, 10);
        this.mJq.setOnSwitchStateChangeListener(this.mJm);
        this.mParent = this.mJm.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mJo.setVisibility(0);
        } else {
            this.mJo.setVisibility(8);
        }
        this.mJr = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mJr.setOnClickListener(this.mJm);
        if (this.mJm != null) {
            this.mJu.setTag(this.mJm.getUniqueId());
            MessageManager.getInstance().registerListener(this.mJu);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mJr.setVisibility(0);
        } else {
            this.mJr.setVisibility(8);
        }
        this.mJs = (MsgSettingItemView) this.mJm.findViewById(R.id.recently_bar_switch);
        this.mJs.setLineVisibility(false);
        this.mJs.setSpaceView(8);
        this.mJs.setText(R.string.privacy_hide_recently_bar_text);
        this.mJs.setOnSwitchStateChangeListener(this.mJt);
        wY(com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void wY(boolean z) {
        if (!z) {
            this.mJs.getSwitchView().turnOnNoCallback();
        } else {
            this.mJs.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dFz() {
        return this.mJq;
    }

    public BdSwitchView dFA() {
        return this.mJp;
    }

    public TbSettingTextTipView dFB() {
        return this.mJn;
    }

    public TbSettingTextTipView dFC() {
        return this.mJo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mJm.getLayoutMode().setNightMode(i == 1);
        this.mJm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mJp.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mJq.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mJs.onChangeSkinType(this.mJm.getPageContext(), i);
        ap.setBackgroundResource(this.mJn, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dFD() {
        return this.mJr;
    }
}
