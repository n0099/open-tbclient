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
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity iVJ;
    private TbSettingTextTipView iVK;
    private TbSettingTextTipView iVL;
    private BdSwitchView iVM;
    private BdSwitchView iVN;
    private TbSettingTextNewDotView iVO;
    private MsgSettingItemView iVP;
    private BdSwitchView.a iVQ;
    private final CustomMessageListener iVR;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.iVJ = null;
        this.mParent = null;
        this.iVK = null;
        this.iVL = null;
        this.iVM = null;
        this.iVN = null;
        this.iVO = null;
        this.iVQ = new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.h.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (view == h.this.iVP.getSwitchView()) {
                    boolean z = BdSwitchView.SwitchState.ON == switchState;
                    com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), z ? false : true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                }
            }
        };
        this.iVR = new CustomMessageListener(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED) { // from class: com.baidu.tieba.setting.more.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.iVJ = systemHelpSettingActivity;
        this.iVJ.setContentView(R.layout.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.iVJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.iVJ.getPageContext().getString(R.string.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVK = (TbSettingTextTipView) this.iVJ.findViewById(R.id.clear_cache);
        this.iVK.hideArrow();
        this.iVK.setOnClickListener(this.iVJ);
        this.iVK.setBottomLineVisibility(true);
        this.iVL = (TbSettingTextTipView) this.iVJ.findViewById(R.id.clear_im);
        this.iVL.hideArrow();
        this.iVL.setBottomLineVisibility(true);
        this.iVL.setOnClickListener(this.iVJ);
        this.iVM = (BdSwitchView) this.iVJ.findViewById(R.id.item_switch);
        l.addToParentArea(this.iVJ.getPageContext().getPageActivity(), this.iVM, 10, 10, 10, 10);
        this.iVM.setOnSwitchStateChangeListener(this.iVJ);
        this.iVN = (BdSwitchView) this.iVJ.findViewById(R.id.setting_save_video_switch);
        l.addToParentArea(this.iVJ.getPageContext().getPageActivity(), this.iVN, 10, 10, 10, 10);
        this.iVN.setOnSwitchStateChangeListener(this.iVJ);
        this.mParent = this.iVJ.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.iVL.setVisibility(0);
        } else {
            this.iVL.setVisibility(8);
        }
        this.iVO = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.iVO.setOnClickListener(this.iVJ);
        if (this.iVJ != null) {
            this.iVR.setTag(this.iVJ.getUniqueId());
            MessageManager.getInstance().registerListener(this.iVR);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.iVO.setVisibility(0);
        } else {
            this.iVO.setVisibility(8);
        }
        this.iVP = (MsgSettingItemView) this.iVJ.findViewById(R.id.recently_bar_switch);
        this.iVP.setLineVisibility(false);
        this.iVP.setSpaceView(8);
        this.iVP.setText(R.string.privacy_hide_recently_bar_text);
        this.iVP.setOnSwitchStateChangeListener(this.iVQ);
        qx(com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public void qx(boolean z) {
        if (!z) {
            this.iVP.getSwitchView().turnOnNoCallback();
        } else {
            this.iVP.getSwitchView().turnOffNoCallback();
        }
    }

    public BdSwitchView ckr() {
        return this.iVN;
    }

    public BdSwitchView cks() {
        return this.iVM;
    }

    public TbSettingTextTipView ckt() {
        return this.iVK;
    }

    public TbSettingTextTipView cku() {
        return this.iVL;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.setting.more.SystemHelpSettingActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iVJ.getLayoutMode().setNightMode(i == 1);
        this.iVJ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iVM.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iVN.setBackgroundRes(am.getBitmap(R.drawable.bg_switch_open), am.getBitmap(R.drawable.bg_switch_close), am.getBitmap(R.drawable.btn_handle));
        this.iVP.onChangeSkinType(this.iVJ.getPageContext(), i);
        am.setBackgroundResource(this.iVK, R.drawable.more_all);
    }

    public TbSettingTextNewDotView ckv() {
        return this.iVO;
    }
}
