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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gRF;
    private TbSettingTextTipView gRG;
    private TbSettingTextTipView gRH;
    private BdSwitchView gRI;
    private BdSwitchView gRJ;
    private TbSettingTextNewDotView gRK;
    private MsgSettingItemView gRL;
    private BdSwitchView.a gRM;
    private final CustomMessageListener gRN;
    private NavigationBar mNavigationBar;
    private View mParent;

    public g(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gRF = null;
        this.mParent = null;
        this.gRG = null;
        this.gRH = null;
        this.gRI = null;
        this.gRJ = null;
        this.gRK = null;
        this.gRM = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.g.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == g.this.gRL.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.gRN = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gRF = systemHelpSettingActivity;
        this.gRF.setContentView(e.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gRF.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gRF.getPageContext().getString(e.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gRG = (TbSettingTextTipView) this.gRF.findViewById(e.g.clear_cache);
        this.gRG.hideArrow();
        this.gRG.setOnClickListener(this.gRF);
        this.gRG.setBottomLineVisibility(true);
        this.gRH = (TbSettingTextTipView) this.gRF.findViewById(e.g.clear_im);
        this.gRH.hideArrow();
        this.gRH.setBottomLineVisibility(true);
        this.gRH.setOnClickListener(this.gRF);
        this.gRI = (BdSwitchView) this.gRF.findViewById(e.g.item_switch);
        l.b(this.gRF.getPageContext().getPageActivity(), this.gRI, 10, 10, 10, 10);
        this.gRI.setOnSwitchStateChangeListener(this.gRF);
        this.gRJ = (BdSwitchView) this.gRF.findViewById(e.g.setting_save_video_switch);
        l.b(this.gRF.getPageContext().getPageActivity(), this.gRJ, 10, 10, 10, 10);
        this.gRJ.setOnSwitchStateChangeListener(this.gRF);
        this.mParent = this.gRF.findViewById(e.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gRH.setVisibility(0);
        } else {
            this.gRH.setVisibility(8);
        }
        this.gRK = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(e.g.sv_plugin_center);
        this.gRK.setOnClickListener(this.gRF);
        if (this.gRF != null) {
            this.gRN.setTag(this.gRF.getUniqueId());
            MessageManager.getInstance().registerListener(this.gRN);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gRK.setVisibility(0);
        } else {
            this.gRK.setVisibility(8);
        }
        this.gRL = (MsgSettingItemView) this.gRF.findViewById(e.g.recently_bar_switch);
        this.gRL.setLineVisibility(false);
        this.gRL.setSpaceView(8);
        this.gRL.setText(e.j.privacy_hide_recently_bar_text);
        this.gRL.setOnSwitchStateChangeListener(this.gRM);
        mY(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void mY(boolean z) {
        if (!z) {
            this.gRL.getSwitchView().nQ();
        } else {
            this.gRL.getSwitchView().nR();
        }
    }

    public BdSwitchView bwz() {
        return this.gRJ;
    }

    public BdSwitchView bwA() {
        return this.gRI;
    }

    public TbSettingTextTipView bwB() {
        return this.gRG;
    }

    public TbSettingTextTipView bwC() {
        return this.gRH;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gRF.getLayoutMode().setNightMode(i == 1);
        this.gRF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gRI.setBackgroundRes(al.dA(e.f.bg_switch_open), al.dA(e.f.bg_switch_close), al.dA(e.f.btn_handle));
        this.gRJ.setBackgroundRes(al.dA(e.f.bg_switch_open), al.dA(e.f.bg_switch_close), al.dA(e.f.btn_handle));
        this.gRL.d(this.gRF.getPageContext(), i);
        al.i(this.gRG, e.f.more_all);
    }

    public TbSettingTextNewDotView bwD() {
        return this.gRK;
    }
}
