package com.baidu.tieba.more;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class an extends com.baidu.adp.base.e {
    private SystemHelpSettingActivity a;
    private RelativeLayout b;
    private SettingTextSwitchView c;
    private SettingTextSwitchView d;
    private TbSettingTextTipView e;
    private TbSettingTextTipView f;
    private TbSettingTextNewDotView g;
    private NavigationBar h;

    public an(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = systemHelpSettingActivity;
        this.a.setContentView(com.baidu.tieba.s.system_help_activity);
        this.h = (NavigationBar) this.a.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.h.a(this.a.getString(com.baidu.tieba.u.systemhelpsetting));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.r.sv_shared_location);
        this.c.setSwitchStateChangeListener(this.a);
        this.d = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.r.sv_earphone);
        this.e = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.r.clear_cache);
        this.e.e();
        this.e.setOnClickListener(this.a);
        this.f = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.r.clear_im);
        this.f.e();
        this.f.setOnClickListener(this.a);
        this.d.setSwitchStateChangeListener(this.a);
        this.b = (RelativeLayout) this.a.findViewById(com.baidu.tieba.r.parent);
        if (TbadkApplication.isLogin()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        this.g = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(com.baidu.tieba.r.sv_plugin_center);
        this.g.setOnClickListener(this.a);
    }

    public BdSwitchView a() {
        return this.c.getSwitchView();
    }

    public BdSwitchView b() {
        return this.d.getSwitchView();
    }

    public TbSettingTextTipView c() {
        return this.e;
    }

    public TbSettingTextTipView d() {
        return this.f;
    }

    public void a(int i) {
        this.h.c(i);
        this.d.a(i);
        this.c.a(i);
        if (i == 1) {
            bc.e(this.d, com.baidu.tieba.q.more_all_1);
            bc.e(this.e, com.baidu.tieba.q.more_all_1);
        } else {
            bc.e(this.d, com.baidu.tieba.q.more_all);
            bc.e(this.e, com.baidu.tieba.q.more_all);
        }
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.b);
    }

    public TbSettingTextNewDotView e() {
        return this.g;
    }
}
