package com.baidu.tieba.person;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.more.SettingTextFunctionIntroView;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ah {
    protected UserIconBox a;
    private BaseFragmentActivity b;
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

    public ah(BaseFragmentActivity baseFragmentActivity, MoreDiscoveryActivity moreDiscoveryActivity) {
        this.a = null;
        this.b = baseFragmentActivity;
        this.e = moreDiscoveryActivity.q();
        this.f = this.e.findViewById(R.id.parent);
        this.d = (NavigationBar) this.f.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.more));
        this.a = (UserIconBox) this.e.findViewById(R.id.user_tshow_icon_box);
        this.g = (ColumnLayout) this.f.findViewById(R.id.user_info);
        this.g.setOnClickListener(moreDiscoveryActivity);
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
        this.o.setOnClickListener(moreDiscoveryActivity);
        this.p = (MoreDiscoveryWidget) this.f.findViewById(R.id.member_benefits);
        this.p.setOnClickListener(moreDiscoveryActivity);
        this.q = (MoreDiscoveryWidget) this.f.findViewById(R.id.face_store);
        this.q.setOnClickListener(moreDiscoveryActivity);
        this.r = (MoreDiscoveryWidget) this.f.findViewById(R.id.settings);
        this.r.setOnClickListener(moreDiscoveryActivity);
        a();
    }

    public void a() {
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setDefaultResource(0);
        this.j.setNightDefaultResource(0);
        this.j.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.n.setVisibility(0);
        }
    }

    public void a(ae aeVar, boolean z) {
        this.n.setVisibility(8);
        if (z) {
            if (aeVar.b() != null && aeVar.b().length() > 0) {
                f();
            } else {
                e();
            }
            b(aeVar);
            d(aeVar);
        }
        if (aeVar.getErrorString() != null && !aeVar.h()) {
            this.b.a(aeVar.getErrorString());
        }
    }

    public void b(ae aeVar) {
        if (aeVar != null) {
            this.c = aeVar.a();
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

    public void c(ae aeVar) {
        if (aeVar != null) {
            if (aeVar.c() > 0 && !aeVar.f()) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (aeVar.d() > 0 && !aeVar.e()) {
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
        VersionData au = TiebaApplication.g().au();
        if (au == null || au.getHas_new_ver() != 1) {
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

    public void d(ae aeVar) {
        String portrait;
        if (aeVar != null && aeVar.a() != null && (portrait = aeVar.a().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.ImageView.d c = aeVar.g().c(portrait);
            if (c == null) {
                aeVar.g().b(portrait, new ai(this));
                return;
            }
            this.j.setImageResource(0);
            c.a(this.j);
        }
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.f);
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
