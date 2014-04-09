package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public final class an extends com.baidu.adp.a.f {
    private SystemHelpSettingActivity a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextSwitchView e;
    private TbSettingTextTipView f;
    private TbSettingTextTipView g;
    private NavigationBar h;

    public an(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = systemHelpSettingActivity;
        this.a.setContentView(com.baidu.tieba.a.i.system_help_activity);
        this.h = (NavigationBar) this.a.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.h.a(this.a.getString(com.baidu.tieba.a.k.systemhelpsetting));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.a.h.sv_shared_location);
        this.d.setSwitchStateChangeListener(this.a);
        this.e = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.a.h.sv_earphone);
        this.f = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.clear_cache);
        this.f.d();
        this.f.setOnClickListener(this.a);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.a.h.clear_im);
        this.g.d();
        this.g.setOnClickListener(this.a);
        this.e.setSwitchStateChangeListener(this.a);
        this.c = (RelativeLayout) this.a.findViewById(com.baidu.tieba.a.h.parent);
        if (TbadkApplication.F()) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public final BdSwitchView a() {
        return this.d.getSwitchView();
    }

    public final BdSwitchView d() {
        return this.e.getSwitchView();
    }

    public final TbSettingTextTipView e() {
        return this.f;
    }

    public final TbSettingTextTipView f() {
        return this.g;
    }

    public final void a(int i) {
        this.h.b(i);
        this.e.a(i);
        this.d.a(i);
        if (i == 1) {
            ba.e(this.e, com.baidu.tieba.a.g.more_all_1);
            ba.e(this.f, com.baidu.tieba.a.g.more_all_1);
        } else {
            ba.e(this.e, com.baidu.tieba.a.g.more_all);
            ba.e(this.f, com.baidu.tieba.a.g.more_all);
        }
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
    }
}
