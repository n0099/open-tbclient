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
    private SystemHelpSettingActivity iUr;
    private TbSettingTextTipView iUs;
    private TbSettingTextTipView iUt;
    private BdSwitchView iUu;
    private BdSwitchView iUv;
    private TbSettingTextNewDotView iUw;
    private MsgSettingItemView iUx;
    private BdSwitchView.a iUy;
    private final CustomMessageListener iUz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iUr = null;
        this.mParent = null;
        this.iUs = null;
        this.iUt = null;
        this.iUu = null;
        this.iUv = null;
        this.iUw = null;
        this.iUy = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iUx.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iUz = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iUr = systemHelpSettingActivity;
        this.iUr.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iUr.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iUr.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iUs = (TbSettingTextTipView) this.iUr.findViewById(R.id.clear_cache);
        this.iUs.hideArrow();
        this.iUs.setOnClickListener(this.iUr);
        this.iUs.setBottomLineVisibility(true);
        this.iUt = (TbSettingTextTipView) this.iUr.findViewById(R.id.clear_im);
        this.iUt.hideArrow();
        this.iUt.setBottomLineVisibility(true);
        this.iUt.setOnClickListener(this.iUr);
        this.iUu = (BdSwitchView) this.iUr.findViewById(R.id.item_switch);
        l.b(this.iUr.getPageContext().getPageActivity(), this.iUu, 10, 10, 10, 10);
        this.iUu.setOnSwitchStateChangeListener(this.iUr);
        this.iUv = (BdSwitchView) this.iUr.findViewById(R.id.setting_save_video_switch);
        l.b(this.iUr.getPageContext().getPageActivity(), this.iUv, 10, 10, 10, 10);
        this.iUv.setOnSwitchStateChangeListener(this.iUr);
        this.mParent = this.iUr.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iUt.setVisibility(0);
        } else {
            this.iUt.setVisibility(8);
        }
        this.iUw = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iUw.setOnClickListener(this.iUr);
        if (this.iUr != null) {
            this.iUz.setTag(this.iUr.getUniqueId());
            MessageManager.getInstance().registerListener(this.iUz);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iUw.setVisibility(0);
        } else {
            this.iUw.setVisibility(8);
        }
        this.iUx = (MsgSettingItemView) this.iUr.findViewById(R.id.recently_bar_switch);
        this.iUx.setLineVisibility(false);
        this.iUx.setSpaceView(8);
        this.iUx.setText(R.string.privacy_hide_recently_bar_text);
        this.iUx.setOnSwitchStateChangeListener(this.iUy);
        qL(com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qL(boolean z) {
        if (!z) {
            this.iUx.getSwitchView().nk();
        } else {
            this.iUx.getSwitchView().nl();
        }
    }

    public BdSwitchView clU() {
        return this.iUv;
    }

    public BdSwitchView clV() {
        return this.iUu;
    }

    public TbSettingTextTipView clW() {
        return this.iUs;
    }

    public TbSettingTextTipView clX() {
        return this.iUt;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iUr.getLayoutMode().setNightMode(i == 1);
        this.iUr.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iUu.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iUv.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iUx.onChangeSkinType(this.iUr.getPageContext(), i);
        am.k(this.iUs, R.drawable.more_all);
    }

    public TbSettingTextNewDotView clY() {
        return this.iUw;
    }
}
