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
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity mqF;
    private TbSettingTextTipView mqG;
    private TbSettingTextTipView mqH;
    private BdSwitchView mqI;
    private BdSwitchView mqJ;
    private TbSettingTextNewDotView mqK;
    private MsgSettingItemView mqL;
    private BdSwitchView.a mqM;
    private final CustomMessageListener mqN;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mqF = null;
        this.mParent = null;
        this.mqG = null;
        this.mqH = null;
        this.mqI = null;
        this.mqJ = null;
        this.mqK = null;
        this.mqM = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mqL.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mqN = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mqF = systemHelpSettingActivity;
        this.mqF.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mqF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mqF.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mqG = (TbSettingTextTipView) this.mqF.findViewById(R.id.clear_cache);
        this.mqG.hideArrow();
        this.mqG.setOnClickListener(this.mqF);
        this.mqG.setBottomLineVisibility(true);
        this.mqH = (TbSettingTextTipView) this.mqF.findViewById(R.id.clear_im);
        this.mqH.hideArrow();
        this.mqH.setBottomLineVisibility(true);
        this.mqH.setOnClickListener(this.mqF);
        this.mqI = (BdSwitchView) this.mqF.findViewById(R.id.item_switch);
        l.addToParentArea(this.mqF.getPageContext().getPageActivity(), this.mqI, 10, 10, 10, 10);
        this.mqI.setOnSwitchStateChangeListener(this.mqF);
        this.mqJ = (BdSwitchView) this.mqF.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mqF.getPageContext().getPageActivity(), this.mqJ, 10, 10, 10, 10);
        this.mqJ.setOnSwitchStateChangeListener(this.mqF);
        this.mParent = this.mqF.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mqH.setVisibility(0);
        } else {
            this.mqH.setVisibility(8);
        }
        this.mqK = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mqK.setOnClickListener(this.mqF);
        if (this.mqF != null) {
            this.mqN.setTag(this.mqF.getUniqueId());
            MessageManager.getInstance().registerListener(this.mqN);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mqK.setVisibility(0);
        } else {
            this.mqK.setVisibility(8);
        }
        this.mqL = (MsgSettingItemView) this.mqF.findViewById(R.id.recently_bar_switch);
        this.mqL.setLineVisibility(false);
        this.mqL.setSpaceView(8);
        this.mqL.setText(R.string.privacy_hide_recently_bar_text);
        this.mqL.setOnSwitchStateChangeListener(this.mqM);
        wy(com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void wy(boolean z) {
        if (!z) {
            this.mqL.getSwitchView().turnOnNoCallback();
        } else {
            this.mqL.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dzP() {
        return this.mqJ;
    }

    public BdSwitchView dzQ() {
        return this.mqI;
    }

    public TbSettingTextTipView dzR() {
        return this.mqG;
    }

    public TbSettingTextTipView dzS() {
        return this.mqH;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mqF.getLayoutMode().setNightMode(i == 1);
        this.mqF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mqI.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mqJ.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mqL.onChangeSkinType(this.mqF.getPageContext(), i);
        ap.setBackgroundResource(this.mqG, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dzT() {
        return this.mqK;
    }
}
