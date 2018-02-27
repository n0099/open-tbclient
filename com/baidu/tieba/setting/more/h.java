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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class h extends com.baidu.adp.base.c<SystemHelpSettingActivity> {
    private SystemHelpSettingActivity gOt;
    private TbSettingTextTipView gOu;
    private TbSettingTextTipView gOv;
    private BdSwitchView gOw;
    private BdSwitchView gOx;
    private TbSettingTextNewDotView gOy;
    private final CustomMessageListener gOz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.gOt = null;
        this.mParent = null;
        this.gOu = null;
        this.gOv = null;
        this.gOw = null;
        this.gOx = null;
        this.gOy = null;
        this.gOz = new CustomMessageListener(2001303) { // from class: com.baidu.tieba.setting.more.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
                }
            }
        };
        this.gOt = systemHelpSettingActivity;
        this.gOt.setContentView(d.h.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.gOt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.gOt.getPageContext().getString(d.j.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOu = (TbSettingTextTipView) this.gOt.findViewById(d.g.clear_cache);
        this.gOu.hideArrow();
        this.gOu.setOnClickListener(this.gOt);
        this.gOu.setBottomLineVisibility(true);
        this.gOv = (TbSettingTextTipView) this.gOt.findViewById(d.g.clear_im);
        this.gOv.hideArrow();
        this.gOv.setBottomLineVisibility(true);
        this.gOv.setOnClickListener(this.gOt);
        this.gOw = (BdSwitchView) this.gOt.findViewById(d.g.item_switch);
        l.a(this.gOt.getPageContext().getPageActivity(), this.gOw, 10, 10, 10, 10);
        this.gOw.setOnSwitchStateChangeListener(this.gOt);
        this.gOx = (BdSwitchView) this.gOt.findViewById(d.g.setting_save_video_switch);
        l.a(this.gOt.getPageContext().getPageActivity(), this.gOx, 10, 10, 10, 10);
        this.gOx.setOnSwitchStateChangeListener(this.gOt);
        this.mParent = this.gOt.findViewById(d.g.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.gOv.setVisibility(0);
        } else {
            this.gOv.setVisibility(8);
        }
        this.gOy = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(d.g.sv_plugin_center);
        this.gOy.setOnClickListener(this.gOt);
        if (this.gOt != null) {
            this.gOz.setTag(this.gOt.getUniqueId());
            MessageManager.getInstance().registerListener(this.gOz);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(PluginCenterActivityConfig.class)) {
            this.gOy.setVisibility(0);
        } else {
            this.gOy.setVisibility(8);
        }
    }

    public BdSwitchView brX() {
        return this.gOx;
    }

    public BdSwitchView brY() {
        return this.gOw;
    }

    public TbSettingTextTipView brZ() {
        return this.gOu;
    }

    public TbSettingTextTipView bsa() {
        return this.gOv;
    }

    public void onChangeSkinType(int i) {
        this.gOt.getLayoutMode().aQ(i == 1);
        this.gOt.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gOw.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.gOx.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        aj.s(this.gOu, d.f.more_all);
    }

    public TbSettingTextNewDotView bsb() {
        return this.gOy;
    }
}
