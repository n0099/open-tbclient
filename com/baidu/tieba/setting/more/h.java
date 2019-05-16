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
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity iMP;
    private TbSettingTextTipView iMQ;
    private TbSettingTextTipView iMR;
    private BdSwitchView iMS;
    private BdSwitchView iMT;
    private TbSettingTextNewDotView iMU;
    private MsgSettingItemView iMV;
    private BdSwitchView.a iMW;
    private final CustomMessageListener iMX;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iMP = null;
        this.mParent = null;
        this.iMQ = null;
        this.iMR = null;
        this.iMS = null;
        this.iMT = null;
        this.iMU = null;
        this.iMW = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iMV.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iMX = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iMP = systemHelpSettingActivity;
        this.iMP.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iMP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iMP.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMQ = (TbSettingTextTipView) this.iMP.findViewById(R.id.clear_cache);
        this.iMQ.hideArrow();
        this.iMQ.setOnClickListener(this.iMP);
        this.iMQ.setBottomLineVisibility(true);
        this.iMR = (TbSettingTextTipView) this.iMP.findViewById(R.id.clear_im);
        this.iMR.hideArrow();
        this.iMR.setBottomLineVisibility(true);
        this.iMR.setOnClickListener(this.iMP);
        this.iMS = (BdSwitchView) this.iMP.findViewById(R.id.item_switch);
        l.b(this.iMP.getPageContext().getPageActivity(), this.iMS, 10, 10, 10, 10);
        this.iMS.setOnSwitchStateChangeListener(this.iMP);
        this.iMT = (BdSwitchView) this.iMP.findViewById(R.id.setting_save_video_switch);
        l.b(this.iMP.getPageContext().getPageActivity(), this.iMT, 10, 10, 10, 10);
        this.iMT.setOnSwitchStateChangeListener(this.iMP);
        this.mParent = this.iMP.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iMR.setVisibility(0);
        } else {
            this.iMR.setVisibility(8);
        }
        this.iMU = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iMU.setOnClickListener(this.iMP);
        if (this.iMP != null) {
            this.iMX.setTag(this.iMP.getUniqueId());
            MessageManager.getInstance().registerListener(this.iMX);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iMU.setVisibility(0);
        } else {
            this.iMU.setVisibility(8);
        }
        this.iMV = (MsgSettingItemView) this.iMP.findViewById(R.id.recently_bar_switch);
        this.iMV.setLineVisibility(false);
        this.iMV.setSpaceView(8);
        this.iMV.setText(R.string.privacy_hide_recently_bar_text);
        this.iMV.setOnSwitchStateChangeListener(this.iMW);
        qu(com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qu(boolean z) {
        if (!z) {
            this.iMV.getSwitchView().mT();
        } else {
            this.iMV.getSwitchView().mU();
        }
    }

    public BdSwitchView ciH() {
        return this.iMT;
    }

    public BdSwitchView ciI() {
        return this.iMS;
    }

    public TbSettingTextTipView ciJ() {
        return this.iMQ;
    }

    public TbSettingTextTipView ciK() {
        return this.iMR;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iMP.getLayoutMode().setNightMode(i == 1);
        this.iMP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iMS.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iMT.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iMV.onChangeSkinType(this.iMP.getPageContext(), i);
        al.k(this.iMQ, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ciL() {
        return this.iMU;
    }
}
