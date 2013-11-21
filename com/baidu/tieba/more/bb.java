package com.baidu.tieba.more;

import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private SystemHelpSettingActivity f1978a;
    private RelativeLayout c;
    private SettingTextSwitchView d;
    private SettingTextTipView e;
    private SettingTextTipView f;
    private NavigationBar g;

    public bb(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity);
        this.f1978a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f1978a = systemHelpSettingActivity;
        this.f1978a.setContentView(R.layout.system_help_activity);
        this.g = (NavigationBar) this.f1978a.findViewById(R.id.view_navigation_bar);
        this.g.a(this.f1978a.getString(R.string.systemhelpsetting));
        this.g.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (SettingTextSwitchView) this.f1978a.findViewById(R.id.sv_earphone);
        this.e = (SettingTextTipView) this.f1978a.findViewById(R.id.clear_cache);
        this.e.d();
        this.e.setOnClickListener(this.f1978a);
        this.f = (SettingTextTipView) this.f1978a.findViewById(R.id.clear_im);
        this.f.d();
        this.f.setOnClickListener(this.f1978a);
        this.d.setSwitchStateChangeListener(this.f1978a);
        this.c = (RelativeLayout) this.f1978a.findViewById(R.id.parent);
        if (TiebaApplication.B()) {
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
            bd.e(this.d, (int) R.drawable.more_all_1);
            bd.e(this.e, (int) R.drawable.more_all_1);
        } else {
            bd.e(this.d, (int) R.drawable.more_all);
            bd.e(this.e, (int) R.drawable.more_all);
        }
        this.e.a(i);
        this.f.a(i);
        this.f1978a.getLayoutMode().a(i == 1);
        this.f1978a.getLayoutMode().a(this.c);
    }
}
