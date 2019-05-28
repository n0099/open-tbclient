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
    private SystemHelpSettingActivity iMR;
    private TbSettingTextTipView iMS;
    private TbSettingTextTipView iMT;
    private BdSwitchView iMU;
    private BdSwitchView iMV;
    private TbSettingTextNewDotView iMW;
    private MsgSettingItemView iMX;
    private BdSwitchView.a iMY;
    private final CustomMessageListener iMZ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iMR = null;
        this.mParent = null;
        this.iMS = null;
        this.iMT = null;
        this.iMU = null;
        this.iMV = null;
        this.iMW = null;
        this.iMY = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iMX.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iMZ = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iMR = systemHelpSettingActivity;
        this.iMR.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iMR.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iMR.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMS = (TbSettingTextTipView) this.iMR.findViewById(R.id.clear_cache);
        this.iMS.hideArrow();
        this.iMS.setOnClickListener(this.iMR);
        this.iMS.setBottomLineVisibility(true);
        this.iMT = (TbSettingTextTipView) this.iMR.findViewById(R.id.clear_im);
        this.iMT.hideArrow();
        this.iMT.setBottomLineVisibility(true);
        this.iMT.setOnClickListener(this.iMR);
        this.iMU = (BdSwitchView) this.iMR.findViewById(R.id.item_switch);
        l.b(this.iMR.getPageContext().getPageActivity(), this.iMU, 10, 10, 10, 10);
        this.iMU.setOnSwitchStateChangeListener(this.iMR);
        this.iMV = (BdSwitchView) this.iMR.findViewById(R.id.setting_save_video_switch);
        l.b(this.iMR.getPageContext().getPageActivity(), this.iMV, 10, 10, 10, 10);
        this.iMV.setOnSwitchStateChangeListener(this.iMR);
        this.mParent = this.iMR.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iMT.setVisibility(0);
        } else {
            this.iMT.setVisibility(8);
        }
        this.iMW = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iMW.setOnClickListener(this.iMR);
        if (this.iMR != null) {
            this.iMZ.setTag(this.iMR.getUniqueId());
            MessageManager.getInstance().registerListener(this.iMZ);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iMW.setVisibility(0);
        } else {
            this.iMW.setVisibility(8);
        }
        this.iMX = (MsgSettingItemView) this.iMR.findViewById(R.id.recently_bar_switch);
        this.iMX.setLineVisibility(false);
        this.iMX.setSpaceView(8);
        this.iMX.setText(R.string.privacy_hide_recently_bar_text);
        this.iMX.setOnSwitchStateChangeListener(this.iMY);
        qu(com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qu(boolean z) {
        if (!z) {
            this.iMX.getSwitchView().mT();
        } else {
            this.iMX.getSwitchView().mU();
        }
    }

    public BdSwitchView ciJ() {
        return this.iMV;
    }

    public BdSwitchView ciK() {
        return this.iMU;
    }

    public TbSettingTextTipView ciL() {
        return this.iMS;
    }

    public TbSettingTextTipView ciM() {
        return this.iMT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iMR.getLayoutMode().setNightMode(i == 1);
        this.iMR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iMU.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iMV.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iMX.onChangeSkinType(this.iMR.getPageContext(), i);
        al.k(this.iMS, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ciN() {
        return this.iMW;
    }
}
