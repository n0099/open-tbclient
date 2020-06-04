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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes13.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity kYU;
    private TbSettingTextTipView kYV;
    private TbSettingTextTipView kYW;
    private BdSwitchView kYX;
    private BdSwitchView kYY;
    private TbSettingTextNewDotView kYZ;
    private MsgSettingItemView kZa;
    private BdSwitchView.a kZb;
    private final CustomMessageListener kZc;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.kYU = null;
        this.mParent = null;
        this.kYV = null;
        this.kYW = null;
        this.kYX = null;
        this.kYY = null;
        this.kYZ = null;
        this.kZb = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.kZa.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.kZc = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.kYU = systemHelpSettingActivity;
        this.kYU.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.kYU.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kYU.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kYV = (TbSettingTextTipView) this.kYU.findViewById(R.id.clear_cache);
        this.kYV.hideArrow();
        this.kYV.setOnClickListener(this.kYU);
        this.kYV.setBottomLineVisibility(true);
        this.kYW = (TbSettingTextTipView) this.kYU.findViewById(R.id.clear_im);
        this.kYW.hideArrow();
        this.kYW.setBottomLineVisibility(true);
        this.kYW.setOnClickListener(this.kYU);
        this.kYX = (BdSwitchView) this.kYU.findViewById(R.id.item_switch);
        l.addToParentArea(this.kYU.getPageContext().getPageActivity(), this.kYX, 10, 10, 10, 10);
        this.kYX.setOnSwitchStateChangeListener(this.kYU);
        this.kYY = (BdSwitchView) this.kYU.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.kYU.getPageContext().getPageActivity(), this.kYY, 10, 10, 10, 10);
        this.kYY.setOnSwitchStateChangeListener(this.kYU);
        this.mParent = this.kYU.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.kYW.setVisibility(0);
        } else {
            this.kYW.setVisibility(8);
        }
        this.kYZ = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.kYZ.setOnClickListener(this.kYU);
        if (this.kYU != null) {
            this.kZc.setTag(this.kYU.getUniqueId());
            MessageManager.getInstance().registerListener(this.kZc);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.kYZ.setVisibility(0);
        } else {
            this.kYZ.setVisibility(8);
        }
        this.kZa = (MsgSettingItemView) this.kYU.findViewById(R.id.recently_bar_switch);
        this.kZa.setLineVisibility(false);
        this.kZa.setSpaceView(8);
        this.kZa.setText(R.string.privacy_hide_recently_bar_text);
        this.kZa.setOnSwitchStateChangeListener(this.kZb);
        tZ(com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void tZ(boolean z) {
        if (!z) {
            this.kZa.getSwitchView().turnOnNoCallback();
        } else {
            this.kZa.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cZq() {
        return this.kYY;
    }

    public BdSwitchView cZr() {
        return this.kYX;
    }

    public TbSettingTextTipView cZs() {
        return this.kYV;
    }

    public TbSettingTextTipView cZt() {
        return this.kYW;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kYU.getLayoutMode().setNightMode(i == 1);
        this.kYU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kYX.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kYY.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kZa.onChangeSkinType(this.kYU.getPageContext(), i);
        am.setBackgroundResource(this.kYV, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cZu() {
        return this.kYZ;
    }
}
