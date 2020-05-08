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
    private SystemHelpSettingActivity kFJ;
    private TbSettingTextTipView kFK;
    private TbSettingTextTipView kFL;
    private BdSwitchView kFM;
    private BdSwitchView kFN;
    private TbSettingTextNewDotView kFO;
    private MsgSettingItemView kFP;
    private BdSwitchView.a kFQ;
    private final CustomMessageListener kFR;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.kFJ = null;
        this.mParent = null;
        this.kFK = null;
        this.kFL = null;
        this.kFM = null;
        this.kFN = null;
        this.kFO = null;
        this.kFQ = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.kFP.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.kFR = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.kFJ = systemHelpSettingActivity;
        this.kFJ.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.kFJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.kFJ.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFK = (TbSettingTextTipView) this.kFJ.findViewById(R.id.clear_cache);
        this.kFK.hideArrow();
        this.kFK.setOnClickListener(this.kFJ);
        this.kFK.setBottomLineVisibility(true);
        this.kFL = (TbSettingTextTipView) this.kFJ.findViewById(R.id.clear_im);
        this.kFL.hideArrow();
        this.kFL.setBottomLineVisibility(true);
        this.kFL.setOnClickListener(this.kFJ);
        this.kFM = (BdSwitchView) this.kFJ.findViewById(R.id.item_switch);
        l.addToParentArea(this.kFJ.getPageContext().getPageActivity(), this.kFM, 10, 10, 10, 10);
        this.kFM.setOnSwitchStateChangeListener(this.kFJ);
        this.kFN = (BdSwitchView) this.kFJ.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.kFJ.getPageContext().getPageActivity(), this.kFN, 10, 10, 10, 10);
        this.kFN.setOnSwitchStateChangeListener(this.kFJ);
        this.mParent = this.kFJ.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.kFL.setVisibility(0);
        } else {
            this.kFL.setVisibility(8);
        }
        this.kFO = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.kFO.setOnClickListener(this.kFJ);
        if (this.kFJ != null) {
            this.kFR.setTag(this.kFJ.getUniqueId());
            MessageManager.getInstance().registerListener(this.kFR);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.kFO.setVisibility(0);
        } else {
            this.kFO.setVisibility(8);
        }
        this.kFP = (MsgSettingItemView) this.kFJ.findViewById(R.id.recently_bar_switch);
        this.kFP.setLineVisibility(false);
        this.kFP.setSpaceView(8);
        this.kFP.setText(R.string.privacy_hide_recently_bar_text);
        this.kFP.setOnSwitchStateChangeListener(this.kFQ);
        tB(com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void tB(boolean z) {
        if (!z) {
            this.kFP.getSwitchView().turnOnNoCallback();
        } else {
            this.kFP.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView cRW() {
        return this.kFN;
    }

    public BdSwitchView cRX() {
        return this.kFM;
    }

    public TbSettingTextTipView cRY() {
        return this.kFK;
    }

    public TbSettingTextTipView cRZ() {
        return this.kFL;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kFJ.getLayoutMode().setNightMode(i == 1);
        this.kFJ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kFM.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kFN.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.kFP.onChangeSkinType(this.kFJ.getPageContext(), i);
        am.setBackgroundResource(this.kFK, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cSa() {
        return this.kFO;
    }
}
