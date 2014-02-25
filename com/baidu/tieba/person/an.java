package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.SettingTextFunctionIntroView;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class an {
    protected UserIconBox a;
    private com.baidu.tieba.k b;
    private UserData c;
    private NavigationBar d;
    private View e;
    private View f;
    private ColumnLayout g;
    private LinearLayout h;
    private TextView i;
    private HeadImageView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private ProgressBar n;
    private MoreDiscoveryWidget o;
    private MoreDiscoveryWidget p;
    private MoreDiscoveryWidget q;
    private MoreDiscoveryWidget r;
    private LinkedList<IconData> s;

    public an(com.baidu.tieba.k kVar, ai aiVar) {
        this.a = null;
        this.b = kVar;
        this.e = aiVar.getView();
        this.f = this.e.findViewById(R.id.parent);
        this.d = (NavigationBar) this.f.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.more));
        this.a = (UserIconBox) this.e.findViewById(R.id.user_tshow_icon_box);
        this.g = (ColumnLayout) this.f.findViewById(R.id.user_info);
        this.g.setOnClickListener(aiVar);
        this.h = (LinearLayout) this.f.findViewById(R.id.user_layout);
        this.i = (TextView) this.f.findViewById(R.id.user_login);
        this.j = (HeadImageView) this.f.findViewById(R.id.user_photo);
        this.j.setAutoChangeStyle(true);
        this.j.setIsRound(true);
        this.k = (TextView) this.f.findViewById(R.id.user_name);
        this.l = (TextView) this.f.findViewById(R.id.user_signature);
        this.m = (ImageView) this.f.findViewById(R.id.user_remind);
        this.n = (ProgressBar) this.f.findViewById(R.id.progress);
        this.o = (MoreDiscoveryWidget) this.f.findViewById(R.id.my_collection);
        this.o.setOnClickListener(aiVar);
        this.p = (MoreDiscoveryWidget) this.f.findViewById(R.id.member_benefits);
        this.p.setOnClickListener(aiVar);
        this.q = (MoreDiscoveryWidget) this.f.findViewById(R.id.face_store);
        this.q.setOnClickListener(aiVar);
        this.r = (MoreDiscoveryWidget) this.f.findViewById(R.id.settings);
        this.r.setOnClickListener(aiVar);
        a();
    }

    public void a() {
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setDefaultResource(0);
        this.j.setNightDefaultResource(0);
        this.j.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.person_photo));
    }

    public void a(al alVar) {
        if (alVar != null) {
            this.n.setVisibility(0);
        }
    }

    public void a(al alVar, boolean z) {
        this.n.setVisibility(8);
        if (z) {
            if (alVar.b() != null && alVar.b().length() > 0) {
                f();
            } else {
                e();
            }
            b(alVar);
            d(alVar);
        }
        if (alVar.getErrorString() != null && !alVar.h()) {
            this.b.a(alVar.getErrorString());
        }
    }

    public void b(al alVar) {
        if (alVar != null) {
            this.c = alVar.a();
            if (this.c != null) {
                this.k.setText(this.c.getName_show());
                this.s = this.c.getTShowInfo();
                if (this.a != null) {
                    this.a.removeAllViews();
                    this.a.a(this.s, 4, this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.b.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
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

    public void c(al alVar) {
        if (alVar != null) {
            if (alVar.c() > 0 && !alVar.f()) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (alVar.d() > 0 && !alVar.e()) {
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
        boolean z = true;
        VersionData as = TiebaApplication.g().as();
        if (as == null || as.getHas_new_ver() != 1) {
            z = false;
        }
        boolean a = com.baidu.tieba.sharedPref.b.a().a(SettingTextFunctionIntroView.a, false);
        if (z || !a) {
            this.r.c();
        } else {
            this.r.d();
        }
    }

    public void d() {
        if (!com.baidu.tieba.sharedPref.b.a().a("has_shown_member_benifit", false)) {
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

    public void d(al alVar) {
        String portrait;
        if (alVar != null && alVar.a() != null && (portrait = alVar.a().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.ImageView.b c = alVar.g().c(portrait);
            if (c == null) {
                alVar.g().c(portrait, new ao(this));
                return;
            }
            this.j.setImageResource(0);
            c.a(this.j);
        }
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.f);
        this.j.f();
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
