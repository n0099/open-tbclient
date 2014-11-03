package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.f {
    private SystemHelpSettingActivity btb;
    private SettingTextSwitchView btc;
    private SettingTextSwitchView btd;
    private TbSettingTextTipView bte;
    private TbSettingTextTipView btf;
    private TbSettingTextNewDotView btg;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.btb = null;
        this.mParent = null;
        this.btc = null;
        this.btd = null;
        this.bte = null;
        this.btf = null;
        this.btg = null;
        this.btb = systemHelpSettingActivity;
        this.btb.setContentView(com.baidu.tieba.w.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.btb.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.btb.getString(com.baidu.tieba.y.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.btc = (SettingTextSwitchView) this.btb.findViewById(com.baidu.tieba.v.tieba_helper_open);
        this.btc.setSwitchStateChangeListener(this.btb);
        this.btd = (SettingTextSwitchView) this.btb.findViewById(com.baidu.tieba.v.sv_earphone);
        this.bte = (TbSettingTextTipView) this.btb.findViewById(com.baidu.tieba.v.clear_cache);
        this.bte.qn();
        this.bte.setOnClickListener(this.btb);
        this.btf = (TbSettingTextTipView) this.btb.findViewById(com.baidu.tieba.v.clear_im);
        this.btf.qn();
        this.btf.setOnClickListener(this.btb);
        this.btd.setSwitchStateChangeListener(this.btb);
        this.mParent = (RelativeLayout) this.btb.findViewById(com.baidu.tieba.v.parent);
        if (TbadkApplication.isLogin()) {
            this.btf.setVisibility(0);
        } else {
            this.btf.setVisibility(8);
        }
        this.btg = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.v.sv_plugin_center);
        this.btg.setOnClickListener(this.btb);
    }

    public BdSwitchView VB() {
        return this.btc.getSwitchView();
    }

    public SettingTextSwitchView VC() {
        return this.btc;
    }

    public BdSwitchView VD() {
        return this.btd.getSwitchView();
    }

    public TbSettingTextTipView VE() {
        return this.bte;
    }

    public TbSettingTextTipView VF() {
        return this.btf;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.btd.cu(i);
        this.btc.cu(i);
        com.baidu.tbadk.core.util.aw.h(this.btd, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.bte, com.baidu.tieba.u.more_all);
        this.btb.getLayoutMode().L(i == 1);
        this.btb.getLayoutMode().h(this.mParent);
    }

    public TbSettingTextNewDotView VG() {
        return this.btg;
    }
}
