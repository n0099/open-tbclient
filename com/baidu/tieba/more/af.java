package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.a.d {
    private com.baidu.tieba.j b;
    private aa c;
    private com.baidu.tieba.util.a d;
    private NavigationBar e;
    private SettingTextImageView f;
    private SettingTextTipView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextVersionView j;
    private SettingTextTipView k;
    private SettingTextTipView l;
    private TextView m;
    private RelativeLayout n;
    private ImageView o;

    public af(com.baidu.tieba.j jVar, aa aaVar) {
        super(jVar);
        this.b = jVar;
        this.c = aaVar;
        this.b.setContentView(R.layout.more_activity);
        i();
    }

    public void b() {
        this.g.setFocusable(false);
        this.g.setClickable(false);
        this.g.setText(TiebaApplication.G());
    }

    public void c() {
        this.g.setFocusable(true);
        this.g.setClickable(true);
        this.g.setText(R.string.putin_account);
    }

    public void d() {
        this.g.b();
    }

    public void e() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
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
            this.d = new com.baidu.tieba.util.a(this.b);
        }
        this.f.b();
        f();
        com.baidu.adp.widget.a.c c = this.d.c(str);
        if (c != null) {
            this.f.setIcon(c);
            return;
        }
        com.baidu.adp.widget.a.c c2 = this.d.c(str, new ag(this));
        if (c2 != null) {
            this.f.setIcon(c2);
        }
    }

    public void a(com.baidu.adp.widget.a.c cVar) {
        if (this.f != null) {
            this.f.setIcon(cVar);
        }
    }

    public void f() {
        if (this.f != null) {
            this.f.setIcon(R.drawable.person_photo);
        }
    }

    public void b(String str) {
        if (this.d != null) {
            this.d.e(str);
        }
    }

    public void g() {
        if (this.j != null) {
            this.j.d();
        }
    }

    public void h() {
        this.f.c();
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.l.a();
    }

    public void a(int i) {
        b(i);
    }

    public void b(int i) {
        this.e.b(i);
        as.b(this.n, i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
        this.l.a(i);
        if (i == 1) {
            k();
        } else {
            j();
        }
    }

    private void i() {
        View.OnClickListener l = l();
        this.n = (RelativeLayout) this.b.findViewById(R.id.parent);
        this.e = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.e.a(this.b.getString(R.string.setup));
        this.o = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (SettingTextImageView) this.b.findViewById(R.id.personInfo);
        this.g = (SettingTextTipView) this.b.findViewById(R.id.accountManager);
        this.h = (SettingTextTipView) this.b.findViewById(R.id.browseSetting);
        this.i = (SettingTextTipView) this.b.findViewById(R.id.messageSetting);
        this.j = (SettingTextVersionView) this.b.findViewById(R.id.versionInfo);
        this.k = (SettingTextTipView) this.b.findViewById(R.id.feedBack);
        this.l = (SettingTextTipView) this.b.findViewById(R.id.recommend);
        if (!TiebaApplication.g().x()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.m = (TextView) this.b.findViewById(R.id.clear_cache);
        g();
        e();
        this.f.a();
        b(TiebaApplication.g().ap());
        a(l);
    }

    private void j() {
        as.e(this.f, (int) R.drawable.more_up);
        if (this.f.getVisibility() == 0) {
            as.e(this.g, (int) R.drawable.more_down);
        } else {
            as.e(this.g, (int) R.drawable.more_all);
        }
        as.e(this.h, (int) R.drawable.more_all);
        as.e(this.i, (int) R.drawable.more_all);
        as.e(this.j, (int) R.drawable.more_up);
        if (this.l.getVisibility() == 0) {
            as.e(this.k, (int) R.drawable.more_middle);
        } else {
            as.e(this.k, (int) R.drawable.more_down);
        }
        as.e(this.l, (int) R.drawable.more_down);
        this.m.setTextColor(this.b.getResources().getColor(R.color.more_color));
        as.e((View) this.m, (int) R.drawable.more_all);
    }

    private void k() {
        as.e(this.f, (int) R.drawable.more_up_1);
        if (this.f.getVisibility() == 0) {
            as.e(this.g, (int) R.drawable.more_down_1);
        } else {
            as.e(this.g, (int) R.drawable.more_all_1);
        }
        as.e(this.h, (int) R.drawable.more_all_1);
        as.e(this.i, (int) R.drawable.more_all_1);
        as.e(this.j, (int) R.drawable.more_up_1);
        if (this.l.getVisibility() == 0) {
            as.e(this.k, (int) R.drawable.more_middle_1);
        } else {
            as.e(this.k, (int) R.drawable.more_down_1);
        }
        as.e(this.l, (int) R.drawable.more_down_1);
        this.m.setTextColor(this.b.getResources().getColor(R.color.skin_1_common_color));
        as.e((View) this.m, (int) R.drawable.more_all_1);
        g();
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

    private View.OnClickListener l() {
        return new ah(this);
    }
}
