package com.baidu.tieba.more;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.a.e {
    private SystemHelpSettingActivity a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextSwitchView e;
    private SettingTextTipView f;
    private SettingTextTipView g;
    private NavigationBar h;

    public az(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = systemHelpSettingActivity;
        this.a.setContentView(R.layout.system_help_activity);
        this.h = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.h.a(this.a.getString(R.string.systemhelpsetting));
        this.h.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.a.findViewById(R.id.sv_shared_location);
        this.d.setSwitchStateChangeListener(this.a);
        this.e = (SettingTextSwitchView) this.a.findViewById(R.id.sv_earphone);
        this.f = (SettingTextTipView) this.a.findViewById(R.id.clear_cache);
        this.f.d();
        this.f.setOnClickListener(this.a);
        this.g = (SettingTextTipView) this.a.findViewById(R.id.clear_im);
        this.g.d();
        this.g.setOnClickListener(this.a);
        this.e.setSwitchStateChangeListener(this.a);
        this.c = (RelativeLayout) this.a.findViewById(R.id.parent);
        if (TiebaApplication.B()) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public BdSwitchView a() {
        return this.d.getSwitchView();
    }

    public BdSwitchView e() {
        return this.e.getSwitchView();
    }

    public SettingTextTipView f() {
        return this.f;
    }

    public SettingTextTipView g() {
        return this.g;
    }

    public void a(int i) {
        this.h.c(i);
        this.e.a(i);
        this.d.a(i);
        if (i == 1) {
            bs.e(this.e, (int) R.drawable.more_all_1);
            bs.e(this.f, (int) R.drawable.more_all_1);
        } else {
            bs.e(this.e, (int) R.drawable.more_all);
            bs.e(this.f, (int) R.drawable.more_all);
        }
        this.f.a(i);
        this.g.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
    }
}
