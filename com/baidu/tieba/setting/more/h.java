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
    private SystemHelpSettingActivity iMV;
    private TbSettingTextTipView iMW;
    private TbSettingTextTipView iMX;
    private BdSwitchView iMY;
    private BdSwitchView iMZ;
    private TbSettingTextNewDotView iNa;
    private MsgSettingItemView iNb;
    private BdSwitchView.a iNc;
    private final CustomMessageListener iNd;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iMV = null;
        this.mParent = null;
        this.iMW = null;
        this.iMX = null;
        this.iMY = null;
        this.iMZ = null;
        this.iNa = null;
        this.iNc = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iNb.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iNd = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iMV = systemHelpSettingActivity;
        this.iMV.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iMV.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iMV.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMW = (TbSettingTextTipView) this.iMV.findViewById(R.id.clear_cache);
        this.iMW.hideArrow();
        this.iMW.setOnClickListener(this.iMV);
        this.iMW.setBottomLineVisibility(true);
        this.iMX = (TbSettingTextTipView) this.iMV.findViewById(R.id.clear_im);
        this.iMX.hideArrow();
        this.iMX.setBottomLineVisibility(true);
        this.iMX.setOnClickListener(this.iMV);
        this.iMY = (BdSwitchView) this.iMV.findViewById(R.id.item_switch);
        l.b(this.iMV.getPageContext().getPageActivity(), this.iMY, 10, 10, 10, 10);
        this.iMY.setOnSwitchStateChangeListener(this.iMV);
        this.iMZ = (BdSwitchView) this.iMV.findViewById(R.id.setting_save_video_switch);
        l.b(this.iMV.getPageContext().getPageActivity(), this.iMZ, 10, 10, 10, 10);
        this.iMZ.setOnSwitchStateChangeListener(this.iMV);
        this.mParent = this.iMV.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iMX.setVisibility(0);
        } else {
            this.iMX.setVisibility(8);
        }
        this.iNa = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iNa.setOnClickListener(this.iMV);
        if (this.iMV != null) {
            this.iNd.setTag(this.iMV.getUniqueId());
            MessageManager.getInstance().registerListener(this.iNd);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iNa.setVisibility(0);
        } else {
            this.iNa.setVisibility(8);
        }
        this.iNb = (MsgSettingItemView) this.iMV.findViewById(R.id.recently_bar_switch);
        this.iNb.setLineVisibility(false);
        this.iNb.setSpaceView(8);
        this.iNb.setText(R.string.privacy_hide_recently_bar_text);
        this.iNb.setOnSwitchStateChangeListener(this.iNc);
        qv(com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qv(boolean z) {
        if (!z) {
            this.iNb.getSwitchView().mT();
        } else {
            this.iNb.getSwitchView().mU();
        }
    }

    public BdSwitchView ciK() {
        return this.iMZ;
    }

    public BdSwitchView ciL() {
        return this.iMY;
    }

    public TbSettingTextTipView ciM() {
        return this.iMW;
    }

    public TbSettingTextTipView ciN() {
        return this.iMX;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iMV.getLayoutMode().setNightMode(i == 1);
        this.iMV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iMY.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iMZ.setBackgroundRes(al.id(R.drawable.bg_switch_open), al.id(R.drawable.bg_switch_close), al.id(R.drawable.btn_handle));
        this.iNb.onChangeSkinType(this.iMV.getPageContext(), i);
        al.k(this.iMW, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ciO() {
        return this.iNa;
    }
}
