package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private SystemHelpSettingActivity f2003a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextTipView e;
    private SettingTextTipView f;
    private NavigationBar g;

    public bb(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.f2003a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f2003a = systemHelpSettingActivity;
        this.f2003a.setContentView(R.layout.system_help_activity);
        this.g = (NavigationBar) this.f2003a.findViewById(R.id.view_navigation_bar);
        this.g.a(this.f2003a.getString(R.string.systemhelpsetting));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.f2003a.findViewById(R.id.sv_earphone);
        this.e = (SettingTextTipView) this.f2003a.findViewById(R.id.clear_cache);
        this.e.b();
        this.e.setOnClickListener(this.f2003a);
        this.f = (SettingTextTipView) this.f2003a.findViewById(R.id.clear_im);
        this.f.b();
        this.f.setOnClickListener(this.f2003a);
        this.d.setSwitchStateChangeListener(this.f2003a);
        this.c = (RelativeLayout) this.f2003a.findViewById(R.id.parent);
        if (TiebaApplication.D()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public BdSwitchView a() {
        return this.d.getSwitchView();
    }

    public SettingTextTipView e() {
        return this.e;
    }

    public SettingTextTipView f() {
        return this.f;
    }

    public void a(int i) {
        this.g.b(i);
        this.d.a(i);
        this.e.a(i);
        this.f.a(i);
        this.f2003a.m().a(i == 1);
        this.f2003a.m().a(this.c);
    }
}
