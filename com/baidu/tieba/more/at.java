package com.baidu.tieba.more;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.base.f {
    private SystemHelpSettingActivity a;
    private RelativeLayout b;
    private SettingTextSwitchView c;
    private SettingTextSwitchView d;
    private SettingTextSwitchView e;
    private TbSettingTextTipView f;
    private TbSettingTextTipView g;
    private TbSettingTextNewDotView h;
    private NavigationBar i;

    public at(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = systemHelpSettingActivity;
        this.a.setContentView(com.baidu.tieba.w.system_help_activity);
        this.i = (NavigationBar) this.a.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.i.a(this.a.getString(com.baidu.tieba.y.systemhelpsetting));
        this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.v.sv_shared_location);
        this.c.setSwitchStateChangeListener(this.a);
        this.d = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.v.tieba_helper_open);
        this.d.setSwitchStateChangeListener(this.a);
        this.e = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.v.sv_earphone);
        this.f = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.clear_cache);
        this.f.e();
        this.f.setOnClickListener(this.a);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.v.clear_im);
        this.g.e();
        this.g.setOnClickListener(this.a);
        this.e.setSwitchStateChangeListener(this.a);
        this.b = (RelativeLayout) this.a.findViewById(com.baidu.tieba.v.parent);
        if (TbadkApplication.isLogin()) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
        this.h = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.v.sv_plugin_center);
        this.h.setOnClickListener(this.a);
    }

    public BdSwitchView a() {
        return this.c.getSwitchView();
    }

    public BdSwitchView b() {
        return this.d.getSwitchView();
    }

    public SettingTextSwitchView c() {
        return this.d;
    }

    public BdSwitchView d() {
        return this.e.getSwitchView();
    }

    public TbSettingTextTipView e() {
        return this.f;
    }

    public TbSettingTextTipView f() {
        return this.g;
    }

    public void a(int i) {
        this.i.c(i);
        this.e.a(i);
        this.c.a(i);
        this.d.a(i);
        if (i == 1) {
            bk.e(this.e, com.baidu.tieba.u.more_all_1);
            bk.e(this.f, com.baidu.tieba.u.more_all_1);
        } else {
            bk.e(this.e, com.baidu.tieba.u.more_all);
            bk.e(this.f, com.baidu.tieba.u.more_all);
        }
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.b);
    }

    public TbSettingTextNewDotView g() {
        return this.h;
    }
}
