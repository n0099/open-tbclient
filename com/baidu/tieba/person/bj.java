package com.baidu.tieba.person;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.a.d {
    protected UserData A;
    protected LinearLayout B;
    protected LinearLayout C;
    PersonInfoActivity b;
    protected ImageView c;
    protected ImageView d;
    protected Button e;
    protected LinearLayout f;
    protected LinearLayout g;
    protected TextView h;
    protected BdPullRefreshScrollView i;
    protected com.baidu.tieba.view.ag j;
    protected FrameLayout k;
    protected LinearLayout l;
    protected ImageView m;
    protected FrameLayout n;
    protected TextView o;
    protected ImageView p;
    protected TextView q;
    protected ImageView r;
    protected ImageView s;
    protected ProgressBar t;
    protected LinearLayout u;
    protected Button v;
    protected Button w;
    protected ImageView x;
    protected TextView y;
    protected String z;

    public bj(PersonInfoActivity personInfoActivity, com.baidu.tieba.model.bm bmVar) {
        super(personInfoActivity);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.b = personInfoActivity;
        personInfoActivity.setContentView(R.layout.person_info_main);
        this.z = bmVar.a();
        this.A = bmVar.c();
        this.t = (ProgressBar) personInfoActivity.findViewById(R.id.progress);
        this.f = (LinearLayout) personInfoActivity.findViewById(R.id.parent);
        this.g = (LinearLayout) personInfoActivity.findViewById(R.id.title);
        this.i = (BdPullRefreshScrollView) personInfoActivity.findViewById(R.id.scrollview);
        this.j = new com.baidu.tieba.view.ag(personInfoActivity);
        this.i.setCustomHeaderView(this.j);
        this.B = (LinearLayout) personInfoActivity.findViewById(R.id.operation_buttons);
        this.C = (LinearLayout) personInfoActivity.findViewById(R.id.sudoku_buttons_container);
        this.k = (FrameLayout) personInfoActivity.findViewById(R.id.info);
        this.h = (TextView) personInfoActivity.findViewById(R.id.title_text);
        this.m = (ImageView) personInfoActivity.findViewById(R.id.photo);
        this.n = (FrameLayout) personInfoActivity.findViewById(R.id.photo_frame);
        this.c = (ImageView) personInfoActivity.findViewById(R.id.back);
        this.c.setOnClickListener(personInfoActivity);
        this.d = (ImageView) personInfoActivity.findViewById(R.id.home);
        this.d.setOnClickListener(personInfoActivity);
        this.e = (Button) personInfoActivity.findViewById(R.id.settings);
        this.e.setOnClickListener(personInfoActivity);
        this.l = (LinearLayout) personInfoActivity.findViewById(R.id.person_info_view);
        this.o = (TextView) personInfoActivity.findViewById(R.id.name);
        this.p = (ImageView) personInfoActivity.findViewById(R.id.sex);
        this.q = (TextView) personInfoActivity.findViewById(R.id.intro);
        this.r = (ImageView) personInfoActivity.findViewById(R.id.background_bottom);
        this.s = (ImageView) personInfoActivity.findViewById(R.id.background_image);
        this.u = (LinearLayout) personInfoActivity.findViewById(R.id.not_login_view);
        this.x = (ImageView) personInfoActivity.findViewById(R.id.not_login_img);
        this.y = (TextView) personInfoActivity.findViewById(R.id.not_login_text);
        this.v = (Button) personInfoActivity.findViewById(R.id.login_btn);
        this.v.setOnClickListener(personInfoActivity);
        this.w = (Button) personInfoActivity.findViewById(R.id.reg_btn);
        this.w.setOnClickListener(personInfoActivity);
    }

    public void d(com.baidu.tieba.model.bm bmVar) {
        this.z = bmVar.a();
        if (this.z == null || this.z.length() < 0) {
            this.l.setVisibility(8);
            this.u.setVisibility(0);
            this.h.setText(R.string.person_info);
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            this.c.setVisibility(4);
            int a2 = UtilHelper.a((Context) this.b, 7.0f);
            this.u.setPadding(a2, 0, a2, 0);
        } else {
            this.l.setVisibility(0);
            this.u.setVisibility(8);
        }
        a(bmVar);
        e(bmVar);
        b(bmVar);
    }

    public void a(com.baidu.tieba.model.bm bmVar) {
    }

    public void e(com.baidu.tieba.model.bm bmVar) {
        this.z = bmVar.a();
        if (this.z != null && this.z.length() > 0) {
            this.A = bmVar.c();
            if (this.A == null) {
                this.o.setText(bmVar.f());
                return;
            }
            this.o.setText(this.A.getName_show());
            if (this.A.getSex() == 1) {
                this.p.setImageResource(R.drawable.cent_icon_boy_n);
            } else if (this.A.getSex() == 2) {
                this.p.setImageResource(R.drawable.cent_icon_girl_n);
            }
            this.q.setText(this.A.getIntro());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tieba.model.bm bmVar) {
    }

    public void a(boolean z) {
        if (!z) {
            this.i.setMode(BdPullRefreshScrollView.Mode.DISABLED);
        } else {
            this.i.setMode(BdPullRefreshScrollView.Mode.PULL_FROM_START);
        }
    }

    public void a(com.baidu.adp.widget.ScrollView.n nVar) {
        this.i.setOnPullDownListener(nVar);
    }

    public void a(int i, com.baidu.tieba.model.bm bmVar) {
        this.z = bmVar.a();
        com.baidu.tieba.util.ao.a(this.f, i);
        com.baidu.tieba.util.ao.f(this.h, i);
        com.baidu.tieba.util.ao.d(this.g, i);
        com.baidu.tieba.util.ao.g((TextView) this.e, i);
        com.baidu.tieba.util.ao.a(this.c, i);
        com.baidu.tieba.util.ao.c(this.d, i);
        this.j.a(i);
        if (i == 1) {
            com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.person_seperator_1);
            if (this.z != null && this.z.length() > 0) {
                this.i.setBackgroundColor(-13618114);
            }
            this.j.setBackgroundColor(-13618114);
            this.o.setTextColor(-5524539);
            this.q.setTextColor(-8352873);
            this.r.setBackgroundColor(-13618114);
            this.n.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n_1));
            this.y.setTextColor(-8815226);
            this.v.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.w.setBackgroundResource(R.drawable.btn_w_square_1);
            this.v.setTextColor(-5454368);
            this.w.setTextColor(-9207399);
            this.x.setImageResource(R.drawable.pic_inset_login_1);
        } else {
            com.baidu.tieba.util.ao.g(this.k, (int) R.drawable.person_seperator);
            if (this.z != null && this.z.length() > 0) {
                this.i.setBackgroundColor(-1644051);
            }
            this.j.setBackgroundColor(-1644051);
            this.o.setTextColor(-1);
            this.q.setTextColor(-4802890);
            this.r.setBackgroundColor(-1644051);
            this.n.setForeground(this.b.getResources().getDrawable(R.drawable.pic_bj_touxiang_n));
            this.y.setTextColor(-5065030);
            this.v.setBackgroundResource(R.drawable.btn_blue_square);
            this.w.setBackgroundResource(R.drawable.btn_w_square);
            this.v.setTextColor(-1);
            this.w.setTextColor(-14277082);
            this.x.setImageResource(R.drawable.pic_inset_login);
        }
        this.s.setImageResource(R.drawable.pic_banner_pic);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, TextView textView, TextView textView2) {
        if (i == 1) {
            if (textView != null) {
                textView.setTextColor(com.baidu.tieba.util.ao.a(i));
            }
            if (textView2 != null) {
                textView2.setTextColor(com.baidu.tieba.util.ao.c(i));
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setTextColor(-14277082);
        }
        if (textView2 != null) {
            textView2.setTextColor(-7566196);
        }
    }

    public void b() {
        this.x.setImageResource(0);
        this.s.setImageDrawable(null);
    }

    public void f(com.baidu.tieba.model.bm bmVar) {
        this.A = bmVar.c();
        if (this.A == null) {
            this.t.setVisibility(0);
        }
    }

    public void j() {
        this.m.setImageResource(R.drawable.person_photo);
    }

    public void g(com.baidu.tieba.model.bm bmVar) {
        String portrait;
        if (bmVar != null && bmVar.c() != null && (portrait = bmVar.c().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.a.b c = bmVar.e().c(portrait);
            if (c == null) {
                bmVar.e().c(portrait, new bk(this));
            } else {
                c.a(this.m);
            }
        }
    }

    public void c() {
        if (this.t != null) {
            this.t.setVisibility(8);
        }
    }

    public ImageView k() {
        return this.c;
    }

    public ImageView l() {
        return this.d;
    }

    public Button m() {
        return this.e;
    }

    public Button n() {
        return this.v;
    }

    public Button o() {
        return this.w;
    }
}
