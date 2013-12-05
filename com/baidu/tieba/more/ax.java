package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private SystemHelpSettingActivity f2084a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextTipView e;
    private SettingTextTipView f;
    private NavigationBar g;

    public ax(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.f2084a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f2084a = systemHelpSettingActivity;
        this.f2084a.setContentView(R.layout.system_help_activity);
        this.g = (NavigationBar) this.f2084a.findViewById(R.id.view_navigation_bar);
        this.g.a(this.f2084a.getString(R.string.systemhelpsetting));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.f2084a.findViewById(R.id.sv_earphone);
        this.e = (SettingTextTipView) this.f2084a.findViewById(R.id.clear_cache);
        this.e.d();
        this.e.setOnClickListener(this.f2084a);
        this.f = (SettingTextTipView) this.f2084a.findViewById(R.id.clear_im);
        this.f.d();
        this.f.setOnClickListener(this.f2084a);
        this.d.setSwitchStateChangeListener(this.f2084a);
        this.c = (RelativeLayout) this.f2084a.findViewById(R.id.parent);
        if (TiebaApplication.C()) {
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
        this.g.c(i);
        this.d.a(i);
        if (i == 1) {
            ba.e(this.d, (int) R.drawable.more_all_1);
            ba.e(this.e, (int) R.drawable.more_all_1);
        } else {
            ba.e(this.d, (int) R.drawable.more_all);
            ba.e(this.e, (int) R.drawable.more_all);
        }
        this.e.a(i);
        this.f.a(i);
        this.f2084a.getLayoutMode().a(i == 1);
        this.f2084a.getLayoutMode().a(this.c);
    }
}
