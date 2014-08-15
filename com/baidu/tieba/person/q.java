package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.SettingTextFunctionIntroView;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q {
    protected UserIconBox a;
    private final BaseFragmentActivity b;
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
    private final ProgressBar m;
    private final MoreDiscoveryWidget n;
    private final MoreDiscoveryWidget o;
    private final MoreDiscoveryWidget p;
    private final MoreDiscoveryWidget q;
    private LinkedList<IconData> r;

    public q(BaseFragmentActivity baseFragmentActivity, m mVar) {
        this.a = null;
        this.b = baseFragmentActivity;
        this.e = mVar.getView();
        this.f = this.e.findViewById(com.baidu.tieba.u.parent);
        this.d = (NavigationBar) this.f.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(this.b.getString(com.baidu.tieba.x.more));
        this.a = (UserIconBox) this.e.findViewById(com.baidu.tieba.u.user_tshow_icon_box);
        this.g = (ColumnLayout) this.f.findViewById(com.baidu.tieba.u.user_info);
        this.g.setOnClickListener(mVar);
        this.h = (LinearLayout) this.f.findViewById(com.baidu.tieba.u.user_layout);
        this.i = (TextView) this.f.findViewById(com.baidu.tieba.u.user_login);
        this.j = (HeadImageView) this.f.findViewById(com.baidu.tieba.u.user_photo);
        this.j.setAutoChangeStyle(true);
        this.j.setIsRound(true);
        this.k = (TextView) this.f.findViewById(com.baidu.tieba.u.user_name);
        this.l = (TextView) this.f.findViewById(com.baidu.tieba.u.user_signature);
        this.m = (ProgressBar) this.f.findViewById(com.baidu.tieba.u.progress);
        this.n = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.u.my_collection);
        this.n.setOnClickListener(mVar);
        this.o = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.u.member_benefits);
        this.o.setOnClickListener(mVar);
        this.p = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.u.face_store);
        this.p.setOnClickListener(mVar);
        this.q = (MoreDiscoveryWidget) this.f.findViewById(com.baidu.tieba.u.settings);
        this.q.setOnClickListener(mVar);
        a();
    }

    public void a() {
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setDefaultResource(com.baidu.tieba.t.icon_default_avatar100);
        this.j.setNightDefaultResource(com.baidu.tieba.t.icon_default_avatar100_1);
    }

    public void a(o oVar) {
        if (oVar != null) {
            this.m.setVisibility(0);
        }
    }

    public void a(o oVar, boolean z) {
        this.m.setVisibility(8);
        if (z) {
            if (oVar.b() != null && oVar.b().length() > 0) {
                f();
            } else {
                e();
            }
            b(oVar);
            d(oVar);
        }
        if (oVar.getErrorString() != null && !oVar.e()) {
            this.b.a(oVar.getErrorString());
        }
    }

    public void b(o oVar) {
        if (oVar != null) {
            this.c = oVar.a();
            if (this.c != null) {
                this.k.setText(this.c.getName_show());
                this.r = this.c.getTShowInfo();
                if (this.a != null) {
                    this.a.removeAllViews();
                    this.a.a(this.r, 4, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
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

    public void c(o oVar) {
        if (oVar != null) {
            if (oVar.c() > 0 && !oVar.d()) {
                this.n.c();
            } else {
                this.n.d();
            }
        }
    }

    public void b() {
        c();
        d();
    }

    public void c() {
        VersionData A = com.baidu.tieba.ai.c().A();
        boolean z = A != null && A.hasNewVer();
        boolean a = com.baidu.tbadk.core.sharedPref.b.a().a(SettingTextFunctionIntroView.f, false);
        if (z || !a) {
            this.q.c();
        } else {
            this.q.d();
        }
    }

    public void d() {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_member_benifit", false)) {
            this.o.a();
        } else {
            this.o.b();
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

    public void d(o oVar) {
        String portrait;
        if (oVar != null && oVar.a() != null && (portrait = oVar.a().getPortrait()) != null && portrait.length() > 0) {
            this.j.a(portrait, 12, false);
        }
    }

    public void a(int i) {
        this.b.c().a(i == 1);
        this.b.c().a(this.f);
        this.j.b();
        this.d.c(i);
        this.n.a(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
    }

    public void g() {
        if (this.m != null) {
            this.m.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.p.a();
        } else {
            this.p.b();
        }
    }
}
