package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bl;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.a.e {
    private com.baidu.tieba.j a;
    private ac c;
    private com.baidu.tieba.util.i d;
    private NavigationBar e;
    private SettingTextImageView f;
    private SettingTextTipView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextTipView j;
    private SettingTextVersionView k;
    private SettingTextTipView l;
    private SettingTextTipView m;
    private SettingTextTipView n;
    private RelativeLayout o;
    private ImageView p;

    public ah(com.baidu.tieba.j jVar, ac acVar) {
        super(jVar);
        this.a = jVar;
        this.c = acVar;
        this.a.setContentView(R.layout.more_activity);
        k();
    }

    public void a() {
        this.g.setFocusable(false);
        this.g.setClickable(false);
        this.g.setText(TiebaApplication.G());
    }

    public void e() {
        this.g.setFocusable(true);
        this.g.setClickable(true);
        this.g.setText(R.string.putin_account);
    }

    public void f() {
        this.g.d();
    }

    public void g() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
    }

    public void a(String str) {
        if (str == null || str.length() <= 0) {
            if (this.f != null) {
                this.f.a();
                return;
            }
            return;
        }
        if (this.d == null) {
            this.d = new com.baidu.tieba.util.i(this.a);
        }
        this.f.b();
        h();
        com.baidu.adp.widget.ImageView.d c = this.d.c(str);
        if (c != null) {
            this.f.setIcon(c);
            return;
        }
        com.baidu.adp.widget.ImageView.d c2 = this.d.c(str, new ai(this));
        if (c2 != null) {
            this.f.setIcon(c2);
        }
    }

    public void a(com.baidu.adp.widget.ImageView.d dVar) {
        if (this.f != null) {
            this.f.setIcon(dVar);
        }
    }

    public void h() {
        if (this.f != null) {
            this.f.setIcon(R.drawable.person_photo);
        }
    }

    public void b(String str) {
        if (this.d != null) {
            this.d.e(str);
        }
    }

    public void i() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public void j() {
        this.f.c();
        this.g.c();
        this.h.c();
        this.i.c();
        this.j.c();
        this.k.c();
        this.l.c();
        this.m.c();
    }

    public void a(int i) {
        b(i);
    }

    public void b(int i) {
        this.e.c(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
        this.l.a(i);
        this.m.a(i);
        if (i == 1) {
            this.o.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting_1));
            m();
            return;
        }
        this.o.setBackgroundColor(this.a.getResources().getColor(R.color.bg_page_setting));
        l();
    }

    private void k() {
        View.OnClickListener n = n();
        this.o = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.a.getString(R.string.setup));
        this.p = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (SettingTextImageView) this.a.findViewById(R.id.personInfo);
        this.g = (SettingTextTipView) this.a.findViewById(R.id.accountManager);
        this.h = (SettingTextTipView) this.a.findViewById(R.id.browseSetting);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.messageSetting);
        this.j = (SettingTextTipView) this.a.findViewById(R.id.secretSetting);
        this.k = (SettingTextVersionView) this.a.findViewById(R.id.versionInfo);
        this.l = (SettingTextTipView) this.a.findViewById(R.id.feedBack);
        this.m = (SettingTextTipView) this.a.findViewById(R.id.recommend);
        if (!TiebaApplication.g().x()) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
        }
        this.n = (SettingTextTipView) this.a.findViewById(R.id.systemhelpsetting);
        i();
        g();
        this.f.a();
        b(TiebaApplication.g().an());
        a(n);
    }

    private void l() {
        bl.e(this.f, (int) R.drawable.more_up);
        if (this.f.getVisibility() == 0) {
            bl.e(this.g, (int) R.drawable.more_down);
        } else {
            bl.e(this.g, (int) R.drawable.more_all);
        }
        bl.e(this.h, (int) R.drawable.more_all);
        bl.e(this.i, (int) R.drawable.more_all);
        bl.e(this.j, (int) R.drawable.more_all);
        bl.e(this.k, (int) R.drawable.more_up);
        if (this.m.getVisibility() == 0) {
            bl.e(this.l, (int) R.drawable.more_middle);
        } else {
            bl.e(this.l, (int) R.drawable.more_down);
        }
        bl.e(this.m, (int) R.drawable.more_down);
        this.n.a(0);
        bl.e(this.n, (int) R.drawable.more_all);
    }

    private void m() {
        bl.e(this.f, (int) R.drawable.more_up_1);
        if (this.f.getVisibility() == 0) {
            bl.e(this.g, (int) R.drawable.more_down_1);
        } else {
            bl.e(this.g, (int) R.drawable.more_all_1);
        }
        bl.e(this.h, (int) R.drawable.more_all_1);
        bl.e(this.i, (int) R.drawable.more_all_1);
        bl.e(this.j, (int) R.drawable.more_all_1);
        bl.e(this.k, (int) R.drawable.more_up_1);
        if (this.m.getVisibility() == 0) {
            bl.e(this.l, (int) R.drawable.more_middle_1);
        } else {
            bl.e(this.l, (int) R.drawable.more_down_1);
        }
        bl.e(this.m, (int) R.drawable.more_down_1);
        this.n.a(1);
        bl.e(this.n, (int) R.drawable.more_all_1);
        i();
    }

    private void a(View.OnClickListener onClickListener) {
        this.p.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        this.n.setOnClickListener(onClickListener);
    }

    private View.OnClickListener n() {
        return new aj(this);
    }
}
