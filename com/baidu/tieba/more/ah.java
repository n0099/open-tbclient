package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1975a;
    private ac c;
    private com.baidu.tieba.util.i d;
    private NavigationBar e;
    private SettingTextImageView f;
    private SettingTextTipView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextVersionView j;
    private SettingTextTipView k;
    private SettingTextTipView l;
    private SettingTextTipView m;
    private RelativeLayout n;
    private ImageView o;

    public ah(com.baidu.tieba.j jVar, ac acVar) {
        super(jVar);
        this.f1975a = jVar;
        this.c = acVar;
        this.f1975a.setContentView(R.layout.more_activity);
        k();
    }

    public void a() {
        this.g.setFocusable(false);
        this.g.setClickable(false);
        this.g.setText(TiebaApplication.F());
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
            this.d = new com.baidu.tieba.util.i(this.f1975a);
        }
        this.f.b();
        h();
        com.baidu.adp.widget.ImageView.e c = this.d.c(str);
        if (c != null) {
            this.f.setIcon(c);
            return;
        }
        com.baidu.adp.widget.ImageView.e c2 = this.d.c(str, new ai(this));
        if (c2 != null) {
            this.f.setIcon(c2);
        }
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar) {
        if (this.f != null) {
            this.f.setIcon(eVar);
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
        if (this.j != null) {
            this.j.a();
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
        if (i == 1) {
            this.n.setBackgroundColor(this.f1975a.getResources().getColor(R.color.bg_page_setting_1));
            m();
            return;
        }
        this.n.setBackgroundColor(this.f1975a.getResources().getColor(R.color.bg_page_setting));
        l();
    }

    private void k() {
        View.OnClickListener n = n();
        this.n = (RelativeLayout) this.f1975a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.f1975a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.f1975a.getString(R.string.setup));
        this.o = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (SettingTextImageView) this.f1975a.findViewById(R.id.personInfo);
        this.g = (SettingTextTipView) this.f1975a.findViewById(R.id.accountManager);
        this.h = (SettingTextTipView) this.f1975a.findViewById(R.id.browseSetting);
        this.i = (SettingTextTipView) this.f1975a.findViewById(R.id.messageSetting);
        this.j = (SettingTextVersionView) this.f1975a.findViewById(R.id.versionInfo);
        this.k = (SettingTextTipView) this.f1975a.findViewById(R.id.feedBack);
        this.l = (SettingTextTipView) this.f1975a.findViewById(R.id.recommend);
        if (!TiebaApplication.g().x()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.m = (SettingTextTipView) this.f1975a.findViewById(R.id.systemhelpsetting);
        i();
        g();
        this.f.a();
        b(TiebaApplication.g().ap());
        a(n);
    }

    private void l() {
        bd.e(this.f, (int) R.drawable.more_up);
        if (this.f.getVisibility() == 0) {
            bd.e(this.g, (int) R.drawable.more_down);
        } else {
            bd.e(this.g, (int) R.drawable.more_all);
        }
        bd.e(this.h, (int) R.drawable.more_all);
        bd.e(this.i, (int) R.drawable.more_all);
        bd.e(this.j, (int) R.drawable.more_up);
        if (this.l.getVisibility() == 0) {
            bd.e(this.k, (int) R.drawable.more_middle);
        } else {
            bd.e(this.k, (int) R.drawable.more_down);
        }
        bd.e(this.l, (int) R.drawable.more_down);
        this.m.a(0);
        bd.e(this.m, (int) R.drawable.more_all);
    }

    private void m() {
        bd.e(this.f, (int) R.drawable.more_up_1);
        if (this.f.getVisibility() == 0) {
            bd.e(this.g, (int) R.drawable.more_down_1);
        } else {
            bd.e(this.g, (int) R.drawable.more_all_1);
        }
        bd.e(this.h, (int) R.drawable.more_all_1);
        bd.e(this.i, (int) R.drawable.more_all_1);
        bd.e(this.j, (int) R.drawable.more_up_1);
        if (this.l.getVisibility() == 0) {
            bd.e(this.k, (int) R.drawable.more_middle_1);
        } else {
            bd.e(this.k, (int) R.drawable.more_down_1);
        }
        bd.e(this.l, (int) R.drawable.more_down_1);
        this.m.a(1);
        bd.e(this.m, (int) R.drawable.more_all_1);
        i();
    }

    private void a(View.OnClickListener onClickListener) {
        this.o.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
    }

    private View.OnClickListener n() {
        return new aj(this);
    }
}
