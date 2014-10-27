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
    private SystemHelpSettingActivity bsN;
    private SettingTextSwitchView bsO;
    private SettingTextSwitchView bsP;
    private TbSettingTextTipView bsQ;
    private TbSettingTextTipView bsR;
    private TbSettingTextNewDotView bsS;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.bsN = null;
        this.mParent = null;
        this.bsO = null;
        this.bsP = null;
        this.bsQ = null;
        this.bsR = null;
        this.bsS = null;
        this.bsN = systemHelpSettingActivity;
        this.bsN.setContentView(com.baidu.tieba.w.system_help_activity);
        this.mNavigationBar = (NavigationBar) this.bsN.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bsN.getString(com.baidu.tieba.y.systemhelpsetting));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bsO = (SettingTextSwitchView) this.bsN.findViewById(com.baidu.tieba.v.tieba_helper_open);
        this.bsO.setSwitchStateChangeListener(this.bsN);
        this.bsP = (SettingTextSwitchView) this.bsN.findViewById(com.baidu.tieba.v.sv_earphone);
        this.bsQ = (TbSettingTextTipView) this.bsN.findViewById(com.baidu.tieba.v.clear_cache);
        this.bsQ.ql();
        this.bsQ.setOnClickListener(this.bsN);
        this.bsR = (TbSettingTextTipView) this.bsN.findViewById(com.baidu.tieba.v.clear_im);
        this.bsR.ql();
        this.bsR.setOnClickListener(this.bsN);
        this.bsP.setSwitchStateChangeListener(this.bsN);
        this.mParent = (RelativeLayout) this.bsN.findViewById(com.baidu.tieba.v.parent);
        if (TbadkApplication.isLogin()) {
            this.bsR.setVisibility(0);
        } else {
            this.bsR.setVisibility(8);
        }
        this.bsS = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.v.sv_plugin_center);
        this.bsS.setOnClickListener(this.bsN);
    }

    public BdSwitchView Vy() {
        return this.bsO.getSwitchView();
    }

    public SettingTextSwitchView Vz() {
        return this.bsO;
    }

    public BdSwitchView VA() {
        return this.bsP.getSwitchView();
    }

    public TbSettingTextTipView VB() {
        return this.bsQ;
    }

    public TbSettingTextTipView VC() {
        return this.bsR;
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.bsP.cu(i);
        this.bsO.cu(i);
        com.baidu.tbadk.core.util.aw.h(this.bsP, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.aw.h(this.bsQ, com.baidu.tieba.u.more_all);
        this.bsN.getLayoutMode().L(i == 1);
        this.bsN.getLayoutMode().h(this.mParent);
    }

    public TbSettingTextNewDotView VD() {
        return this.bsS;
    }
}
