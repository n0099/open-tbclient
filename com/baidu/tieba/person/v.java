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
public final class v {
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
        this.f = this.e.findViewById(com.baidu.tieba.a.h.parent);
        this.d = (NavigationBar) this.f.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.d.a(this.b.getString(com.baidu.tieba.a.k.more));
        this.a = (UserIconBox) this.e.findViewById(com.baidu.tieba.a.h.user_tshow_icon_box);
        this.g = (ColumnLayout) this.f.findViewById(com.baidu.tieba.a.h.user_info);
        this.g.setOnClickListener(rVar);
        this.h = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.user_layout);
        this.i = (TextView) this.f.findViewById(com.baidu.tieba.a.h.user_login);
        this.j = (HeadImageView) this.f.findViewById(com.baidu.tieba.a.h.user_photo);
        this.j.setAutoChangeStyle(true);
        this.j.setIsRound(true);
        this.k = (TextView) this.f.findViewById(com.baidu.tieba.a.h.user_name);
        this.l = (TextView) this.f.findViewById(com.baidu.tieba.a.h.user_signature);
        this.m = (ImageView) this.f.findViewById(com.baidu.tieba.a.h.user_remind);
        this.n = (ProgressBar) this.f.findViewById(com.baidu.tieba.a.h.progress);
        this.o = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.a.h.my_collection);
        this.o.setOnClickListener(rVar);
        this.p = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.a.h.member_benefits);
        this.p.setOnClickListener(rVar);
        this.q = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.a.h.face_store);
        this.q.setOnClickListener(rVar);
        this.r = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.a.h.settings);
        this.r.setOnClickListener(rVar);
        a();
    }

    public final void a() {
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setDefaultResource(0);
        this.j.setNightDefaultResource(0);
        this.j.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.person_photo));
    }

    public final void a(t tVar) {
        if (tVar != null) {
            this.n.setVisibility(0);
        }
    }

    public final void a(t tVar, boolean z) {
        String portrait;
        this.n.setVisibility(8);
        if (z) {
            if (tVar.b() != null && tVar.b().length() > 0) {
                e();
            } else {
                d();
            }
            b(tVar);
            if (tVar != null && tVar.a() != null && (portrait = tVar.a().getPortrait()) != null && portrait.length() > 0) {
                tVar.g();
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                if (b == null) {
                    tVar.g().c(portrait, new w(this));
                } else {
                    this.j.setImageResource(0);
                    b.a(this.j);
                }
            }
        }
        if (tVar.getErrorString() != null && !tVar.h()) {
            this.b.a(tVar.getErrorString());
        }
    }

    public final void b(t tVar) {
        if (tVar != null) {
            this.c = tVar.a();
            if (this.c != null) {
                this.k.setText(this.c.getName_show());
                this.s = this.c.getTShowInfo();
                if (this.a != null) {
                    this.a.removeAllViews();
                    this.a.a(this.s, 4, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.big_icon_margin), true);
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

    public final void c(t tVar) {
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

    public final void b() {
        boolean z = true;
        VersionData y = com.baidu.tieba.p.c().y();
        if (y == null || y.getHas_new_ver() != 1) {
            z = false;
        }
        boolean a = com.baidu.tbadk.core.sharedPref.b.a().a(SettingTextFunctionIntroView.f, false);
        if (z || !a) {
            this.r.c();
        } else {
            this.r.d();
        }
    }

    public final void c() {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_member_benifit", false)) {
            this.p.a();
        } else {
            this.p.b();
        }
    }

    public final void d() {
        this.i.setVisibility(0);
        this.h.setVisibility(8);
    }

    public final void e() {
        this.i.setVisibility(8);
        this.h.setVisibility(0);
    }

    public final void a(int i) {
        this.b.b().a(i == 1);
        this.b.b().a(this.f);
        this.j.c();
        this.d.b(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
        this.r.a(i);
    }

    public final void f() {
        if (this.n != null) {
            this.n.setVisibility(8);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.q.a();
        } else {
            this.q.b();
        }
    }
}
