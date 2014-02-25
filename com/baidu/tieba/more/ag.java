package com.baidu.tieba.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.e {
    private com.baidu.tieba.f a;
    private ab c;
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
    private View n;
    private SettingTextTipView o;
    private RelativeLayout p;
    private ImageView q;

    public ag(com.baidu.tieba.f fVar, ab abVar) {
        super(fVar);
        this.a = fVar;
        this.c = abVar;
        this.a.setContentView(R.layout.more_activity);
        h();
    }

    public void a() {
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
        e();
        com.baidu.adp.widget.ImageView.b c = this.d.c(str);
        if (c != null) {
            this.f.setIcon(c);
            return;
        }
        com.baidu.adp.widget.ImageView.b a = this.d.a(str, new ah(this));
        if (a != null) {
            this.f.setIcon(a);
        }
    }

    public void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (this.f != null) {
            this.f.setIcon(bVar);
        }
    }

    public void e() {
        if (this.f != null) {
            this.f.setIcon(R.drawable.person_photo);
        }
    }

    public void b(String str) {
        if (this.d != null) {
            this.d.e(str);
        }
    }

    public void f() {
        if (this.k != null) {
            this.k.a();
        }
    }

    public void g() {
        this.f.c();
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        this.l.d();
        this.m.d();
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
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.p);
        this.e.c(i);
        f();
        this.o.a(i);
    }

    private void h() {
        View.OnClickListener i = i();
        this.p = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.a.getString(R.string.setup));
        this.q = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (SettingTextImageView) this.a.findViewById(R.id.personInfo);
        this.g = (SettingTextTipView) this.a.findViewById(R.id.accountManager);
        this.h = (SettingTextTipView) this.a.findViewById(R.id.browseSetting);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.messageSetting);
        this.j = (SettingTextTipView) this.a.findViewById(R.id.secretSetting);
        this.k = (SettingTextVersionView) this.a.findViewById(R.id.versionInfo);
        this.l = (SettingTextTipView) this.a.findViewById(R.id.feedBack);
        this.m = (SettingTextTipView) this.a.findViewById(R.id.recommend);
        this.n = this.a.findViewById(R.id.line_recommend_layout);
        if (!TiebaApplication.g().x()) {
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
        }
        this.o = (SettingTextTipView) this.a.findViewById(R.id.systemhelpsetting);
        f();
        a();
        this.f.a();
        b(TiebaApplication.g().al());
        a(i);
    }

    private void a(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
        this.f.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
        this.m.setOnClickListener(onClickListener);
        this.o.setOnClickListener(onClickListener);
    }

    private View.OnClickListener i() {
        return new ai(this);
    }
}
