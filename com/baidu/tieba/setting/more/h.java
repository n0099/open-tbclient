package com.baidu.tieba.setting.more;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity iWM;
    private TbSettingTextTipView iWN;
    private TbSettingTextTipView iWO;
    private BdSwitchView iWP;
    private BdSwitchView iWQ;
    private TbSettingTextNewDotView iWR;
    private MsgSettingItemView iWS;
    private BdSwitchView.a iWT;
    private final CustomMessageListener iWU;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iWM = null;
        this.mParent = null;
        this.iWN = null;
        this.iWO = null;
        this.iWP = null;
        this.iWQ = null;
        this.iWR = null;
        this.iWT = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iWS.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iWU = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iWM = systemHelpSettingActivity;
        this.iWM.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iWM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iWM.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWN = (TbSettingTextTipView) this.iWM.findViewById(R.id.clear_cache);
        this.iWN.hideArrow();
        this.iWN.setOnClickListener(this.iWM);
        this.iWN.setBottomLineVisibility(true);
        this.iWO = (TbSettingTextTipView) this.iWM.findViewById(R.id.clear_im);
        this.iWO.hideArrow();
        this.iWO.setBottomLineVisibility(true);
        this.iWO.setOnClickListener(this.iWM);
        this.iWP = (BdSwitchView) this.iWM.findViewById(R.id.item_switch);
        l.b(this.iWM.getPageContext().getPageActivity(), this.iWP, 10, 10, 10, 10);
        this.iWP.setOnSwitchStateChangeListener(this.iWM);
        this.iWQ = (BdSwitchView) this.iWM.findViewById(R.id.setting_save_video_switch);
        l.b(this.iWM.getPageContext().getPageActivity(), this.iWQ, 10, 10, 10, 10);
        this.iWQ.setOnSwitchStateChangeListener(this.iWM);
        this.mParent = this.iWM.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iWO.setVisibility(0);
        } else {
            this.iWO.setVisibility(8);
        }
        this.iWR = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iWR.setOnClickListener(this.iWM);
        if (this.iWM != null) {
            this.iWU.setTag(this.iWM.getUniqueId());
            MessageManager.getInstance().registerListener(this.iWU);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iWR.setVisibility(0);
        } else {
            this.iWR.setVisibility(8);
        }
        this.iWS = (MsgSettingItemView) this.iWM.findViewById(R.id.recently_bar_switch);
        this.iWS.setLineVisibility(false);
        this.iWS.setSpaceView(8);
        this.iWS.setText(R.string.privacy_hide_recently_bar_text);
        this.iWS.setOnSwitchStateChangeListener(this.iWT);
        qO(com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qO(boolean z) {
        if (!z) {
            this.iWS.getSwitchView().nk();
        } else {
            this.iWS.getSwitchView().nl();
        }
    }

    public BdSwitchView cmG() {
        return this.iWQ;
    }

    public BdSwitchView cmH() {
        return this.iWP;
    }

    public TbSettingTextTipView cmI() {
        return this.iWN;
    }

    public TbSettingTextTipView cmJ() {
        return this.iWO;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iWM.getLayoutMode().setNightMode(i == 1);
        this.iWM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iWP.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iWQ.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iWS.onChangeSkinType(this.iWM.getPageContext(), i);
        am.k(this.iWN, R.drawable.more_all);
    }

    public TbSettingTextNewDotView cmK() {
        return this.iWR;
    }
}
