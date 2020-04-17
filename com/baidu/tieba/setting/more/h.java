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
    private SystemHelpSettingActivity kFF;
    private TbSettingTextTipView kFG;
    private TbSettingTextTipView kFH;
    private BdSwitchView kFI;
    private BdSwitchView kFJ;
    private TbSettingTextNewDotView kFK;
    private MsgSettingItemView kFL;
    private BdSwitchView.a kFM;
    private final CustomMessageListener kFN;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.kFF = null;
        this.mParent = null;
        this.kFG = null;
        this.kFH = null;
        this.kFI = null;
        this.kFJ = null;
        this.kFK = null;
        this.kFM = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.kFL.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.kFN = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.kFF = systemHelpSettingActivity;
        this.kFF.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.kFF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kFF.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFG = (TbSettingTextTipView) this.kFF.findViewById(R.id.clear_cache);
        this.kFG.hideArrow();
        this.kFG.setOnClickListener(this.kFF);
        this.kFG.setBottomLineVisibility(true);
        this.kFH = (TbSettingTextTipView) this.kFF.findViewById(R.id.clear_im);
        this.kFH.hideArrow();
        this.kFH.setBottomLineVisibility(true);
        this.kFH.setOnClickListener(this.kFF);
        this.kFI = (BdSwitchView) this.kFF.findViewById(R.id.item_switch);
        l.addToParentArea(this.kFF.getPageContext().getPageActivity(), this.kFI, 10, 10, 10, 10);
        this.kFI.setOnSwitchStateChangeListener(this.kFF);
        this.kFJ = (BdSwitchView) this.kFF.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.kFF.getPageContext().getPageActivity(), this.kFJ, 10, 10, 10, 10);
        this.kFJ.setOnSwitchStateChangeListener(this.kFF);
        this.mParent = this.kFF.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.kFH.setVisibility(0);
        } else {
            this.kFH.setVisibility(8);
        }
        this.kFK = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.kFK.setOnClickListener(this.kFF);
        if (this.kFF != null) {
            this.kFN.setTag(this.kFF.getUniqueId());
            MessageManager.getInstance().registerListener(this.kFN);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.kFK.setVisibility(0);
        } else {
            this.kFK.setVisibility(8);
        }
        this.kFL = (MsgSettingItemView) this.kFF.findViewById(R.id.recently_bar_switch);
        this.kFL.setLineVisibility(false);
        this.kFL.setSpaceView(8);
        this.kFL.setText(R.string.privacy_hide_recently_bar_text);
        this.kFL.setOnSwitchStateChangeListener(this.kFM);
        tB(com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void tB(boolean z) {
        if (!z) {
            this.kFL.getSwitchView().turnOnNoCallback();
        } else {
            this.kFL.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cRZ() {
        return this.kFJ;
    }

    public BdSwitchView cSa() {
        return this.kFI;
    }

    public TbSettingTextTipView cSb() {
        return this.kFG;
    }

    public TbSettingTextTipView cSc() {
        return this.kFH;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kFF.getLayoutMode().setNightMode(i == 1);
        this.kFF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kFI.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kFJ.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kFL.onChangeSkinType(this.kFF.getPageContext(), i);
        am.setBackgroundResource(this.kFG, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cSd() {
        return this.kFK;
    }
}
