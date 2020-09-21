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
/* loaded from: classes25.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private SystemHelpSettingActivity mbb;
    private TbSettingTextTipView mbc;
    private TbSettingTextTipView mbd;
    private BdSwitchView mbe;
    private BdSwitchView mbf;
    private TbSettingTextNewDotView mbg;
    private MsgSettingItemView mbh;
    private BdSwitchView.a mbi;
    private final CustomMessageListener mbj;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.mbb = null;
        this.mParent = null;
        this.mbc = null;
        this.mbd = null;
        this.mbe = null;
        this.mbf = null;
        this.mbg = null;
        this.mbi = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.mbh.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Boolean.valueOf(z)));
                }
            }
        };
        this.mbj = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.mbb = systemHelpSettingActivity;
        this.mbb.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.mbb.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.mbb.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mbc = (TbSettingTextTipView) this.mbb.findViewById(R.id.clear_cache);
        this.mbc.hideArrow();
        this.mbc.setOnClickListener(this.mbb);
        this.mbc.setBottomLineVisibility(true);
        this.mbd = (TbSettingTextTipView) this.mbb.findViewById(R.id.clear_im);
        this.mbd.hideArrow();
        this.mbd.setBottomLineVisibility(true);
        this.mbd.setOnClickListener(this.mbb);
        this.mbe = (BdSwitchView) this.mbb.findViewById(R.id.item_switch);
        l.addToParentArea(this.mbb.getPageContext().getPageActivity(), this.mbe, 10, 10, 10, 10);
        this.mbe.setOnSwitchStateChangeListener(this.mbb);
        this.mbf = (BdSwitchView) this.mbb.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.mbb.getPageContext().getPageActivity(), this.mbf, 10, 10, 10, 10);
        this.mbf.setOnSwitchStateChangeListener(this.mbb);
        this.mParent = this.mbb.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.mbd.setVisibility(0);
        } else {
            this.mbd.setVisibility(8);
        }
        this.mbg = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.mbg.setOnClickListener(this.mbb);
        if (this.mbb != null) {
            this.mbj.setTag(this.mbb.getUniqueId());
            MessageManager.getInstance().registerListener(this.mbj);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.mbg.setVisibility(0);
        } else {
            this.mbg.setVisibility(8);
        }
        this.mbh = (MsgSettingItemView) this.mbb.findViewById(R.id.recently_bar_switch);
        this.mbh.setLineVisibility(false);
        this.mbh.setSpaceView(8);
        this.mbh.setText(R.string.privacy_hide_recently_bar_text);
        this.mbh.setOnSwitchStateChangeListener(this.mbi);
        vR(com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void vR(boolean z) {
        if (!z) {
            this.mbh.getSwitchView().turnOnNoCallback();
        } else {
            this.mbh.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView dwe() {
        return this.mbf;
    }

    public BdSwitchView dwf() {
        return this.mbe;
    }

    public TbSettingTextTipView dwg() {
        return this.mbc;
    }

    public TbSettingTextTipView dwh() {
        return this.mbd;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mbb.getLayoutMode().setNightMode(i == 1);
        this.mbb.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mbe.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mbf.setBackgroundRes(ap.getBitmap(R.drawable.bg_switch_open), ap.getBitmap(R.drawable.bg_switch_close), ap.getBitmap(R.drawable.btn_handle));
        this.mbh.onChangeSkinType(this.mbb.getPageContext(), i);
        ap.setBackgroundResource(this.mbc, R.drawable.more_all);
    }

    public TbSettingTextNewDotView dwi() {
        return this.mbg;
    }
}
