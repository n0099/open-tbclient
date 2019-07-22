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
    private SystemHelpSettingActivity iTn;
    private TbSettingTextTipView iTo;
    private TbSettingTextTipView iTp;
    private BdSwitchView iTq;
    private BdSwitchView iTr;
    private TbSettingTextNewDotView iTs;
    private MsgSettingItemView iTt;
    private BdSwitchView.a iTu;
    private final CustomMessageListener iTv;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iTn = null;
        this.mParent = null;
        this.iTo = null;
        this.iTp = null;
        this.iTq = null;
        this.iTr = null;
        this.iTs = null;
        this.iTu = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iTt.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iTv = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iTn = systemHelpSettingActivity;
        this.iTn.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iTn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iTn.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTo = (TbSettingTextTipView) this.iTn.findViewById(R.id.clear_cache);
        this.iTo.hideArrow();
        this.iTo.setOnClickListener(this.iTn);
        this.iTo.setBottomLineVisibility(true);
        this.iTp = (TbSettingTextTipView) this.iTn.findViewById(R.id.clear_im);
        this.iTp.hideArrow();
        this.iTp.setBottomLineVisibility(true);
        this.iTp.setOnClickListener(this.iTn);
        this.iTq = (BdSwitchView) this.iTn.findViewById(R.id.item_switch);
        l.b(this.iTn.getPageContext().getPageActivity(), this.iTq, 10, 10, 10, 10);
        this.iTq.setOnSwitchStateChangeListener(this.iTn);
        this.iTr = (BdSwitchView) this.iTn.findViewById(R.id.setting_save_video_switch);
        l.b(this.iTn.getPageContext().getPageActivity(), this.iTr, 10, 10, 10, 10);
        this.iTr.setOnSwitchStateChangeListener(this.iTn);
        this.mParent = this.iTn.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iTp.setVisibility(0);
        } else {
            this.iTp.setVisibility(8);
        }
        this.iTs = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iTs.setOnClickListener(this.iTn);
        if (this.iTn != null) {
            this.iTv.setTag(this.iTn.getUniqueId());
            MessageManager.getInstance().registerListener(this.iTv);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iTs.setVisibility(0);
        } else {
            this.iTs.setVisibility(8);
        }
        this.iTt = (MsgSettingItemView) this.iTn.findViewById(R.id.recently_bar_switch);
        this.iTt.setLineVisibility(false);
        this.iTt.setSpaceView(8);
        this.iTt.setText(R.string.privacy_hide_recently_bar_text);
        this.iTt.setOnSwitchStateChangeListener(this.iTu);
        qK(com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qK(boolean z) {
        if (!z) {
            this.iTt.getSwitchView().nk();
        } else {
            this.iTt.getSwitchView().nl();
        }
    }

    public BdSwitchView clC() {
        return this.iTr;
    }

    public BdSwitchView clD() {
        return this.iTq;
    }

    public TbSettingTextTipView clE() {
        return this.iTo;
    }

    public TbSettingTextTipView clF() {
        return this.iTp;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iTn.getLayoutMode().setNightMode(i == 1);
        this.iTn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iTq.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iTr.setBackgroundRes(am.ij(R.drawable.bg_switch_open), am.ij(R.drawable.bg_switch_close), am.ij(R.drawable.btn_handle));
        this.iTt.onChangeSkinType(this.iTn.getPageContext(), i);
        am.k(this.iTo, R.drawable.more_all);
    }

    public TbSettingTextNewDotView clG() {
        return this.iTs;
    }
}
