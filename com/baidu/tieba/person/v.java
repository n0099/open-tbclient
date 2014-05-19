package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.SettingTextFunctionIntroView;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class v {
    protected UserIconBox a;
    private final com.baidu.tbadk.core.e b;
    private UserData c;
    private final NavigationBar d;
    private final View e;
    private final View f;
    private final ColumnLayout g;
    private final LinearLayout h;
    private final TextView i;
    private final HeadImageView j;
    private final TextView k;
    private final TextView l;
    private final ImageView m;
    private final ProgressBar n;
    private final MoreDiscoveryWidget o;
    private final MoreDiscoveryWidget p;
    private final MoreDiscoveryWidget q;
    private final MoreDiscoveryWidget r;
    private LinkedList<IconData> s;

    public v(com.baidu.tbadk.core.e eVar, r rVar) {
        this.a = null;
        this.b = eVar;
        this.e = rVar.getView();
        this.f = this.e.findViewById(com.baidu.tieba.r.parent);
        this.d = (NavigationBar) this.f.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.d.a(this.b.getString(com.baidu.tieba.u.more));
        this.a = (UserIconBox) this.e.findViewById(com.baidu.tieba.r.user_tshow_icon_box);
        this.g = (ColumnLayout) this.f.findViewById(com.baidu.tieba.r.user_info);
        this.g.setOnClickListener(rVar);
        this.h = (LinearLayout) this.f.findViewById(com.baidu.tieba.r.user_layout);
        this.i = (TextView) this.f.findViewById(com.baidu.tieba.r.user_login);
        this.j = (HeadImageView) this.f.findViewById(com.baidu.tieba.r.user_photo);
        this.j.setAutoChangeStyle(true);
        this.j.setIsRound(true);
        this.k = (TextView) this.f.findViewById(com.baidu.tieba.r.user_name);
        this.l = (TextView) this.f.findViewById(com.baidu.tieba.r.user_signature);
        this.m = (ImageView) this.f.findViewById(com.baidu.tieba.r.user_remind);
        this.n = (ProgressBar) this.f.findViewById(com.baidu.tieba.r.progress);
        this.o = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.r.my_collection);
        this.o.setOnClickListener(rVar);
        this.p = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.r.member_benefits);
        this.p.setOnClickListener(rVar);
        this.q = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.r.face_store);
        this.q.setOnClickListener(rVar);
        this.r = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.r.settings);
        this.r.setOnClickListener(rVar);
        a();
    }

    public void a() {
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setDefaultResource(0);
        this.j.setNightDefaultResource(0);
        this.j.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.person_photo));
    }

    public void a(t tVar) {
        if (tVar != null) {
            this.n.setVisibility(0);
        }
    }

    public void a(t tVar, boolean z) {
        this.n.setVisibility(8);
        if (z) {
            if (tVar.b() != null && tVar.b().length() > 0) {
                f();
            } else {
                e();
            }
            b(tVar);
            d(tVar);
        }
        if (tVar.getErrorString() != null && !tVar.h()) {
            this.b.a(tVar.getErrorString());
        }
    }

    public void b(t tVar) {
        if (tVar != null) {
            this.c = tVar.a();
            if (this.c != null) {
                this.k.setText(this.c.getName_show());
                this.s = this.c.getTShowInfo();
                if (this.a != null) {
                    this.a.removeAllViews();
                    this.a.a(this.s, 4, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.big_icon_margin), true);
                }
                String intro = this.c.getIntro();
                if (intro != null && intro.length() > 0) {
                    this.l.setVisibility(0);
                    this.l.setText(this.c.getIntro());
                    return;
                }
                this.l.setVisibility(8);
            }
        }
    }

    public void c(t tVar) {
        if (tVar != null) {
            if (tVar.c() > 0 && !tVar.f()) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (tVar.d() > 0 && !tVar.e()) {
                this.o.c();
            } else {
                this.o.d();
            }
        }
    }

    public void b() {
        c();
        d();
    }

    public void c() {
        VersionData B = com.baidu.tieba.ad.c().B();
        boolean z = B != null && B.hasNewVer();
        boolean a = com.baidu.tbadk.core.sharedPref.b.a().a(SettingTextFunctionIntroView.f, false);
        if (z || !a) {
            this.r.c();
        } else {
            this.r.d();
        }
    }

    public void d() {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_member_benifit", false)) {
            this.p.a();
        } else {
            this.p.b();
        }
    }

    public void e() {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
    }

    public void f() {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void d(t tVar) {
        String portrait;
        if (tVar != null && tVar.a() != null && (portrait = tVar.a().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.a.a c = tVar.g().c(portrait);
            if (c == null) {
                tVar.g().c(portrait, new w(this));
                return;
            }
            this.j.setImageResource(0);
            c.a(this.j);
        }
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.f);
        this.j.b();
        this.d.c(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
        this.r.a(i);
    }

    public void g() {
        if (this.n != null) {
            this.n.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.q.a();
        } else {
            this.q.b();
        }
    }
}
