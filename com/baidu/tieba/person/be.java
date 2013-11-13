package com.baidu.tieba.person;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.model.bx;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.a.e {
    protected String A;
    protected UserData B;
    protected LinearLayout C;
    protected LinearLayout D;
    protected UserIconBox E;
    protected LinkedList<com.baidu.tieba.data.aa> F;

    /* renamed from: a  reason: collision with root package name */
    BaseFragmentActivity f2235a;
    BaseFragment c;
    View d;
    protected NavigationBar e;
    protected ImageView f;
    protected ImageView g;
    protected TextView h;
    protected LinearLayout i;
    protected TextView j;
    protected BdPullRefreshScrollView k;
    protected com.baidu.tieba.view.bk l;
    protected LinearLayout m;
    protected HeadImageView n;
    protected HeadImageView o;
    protected FrameLayout p;
    protected TextView q;
    protected TextView r;
    protected ImageView s;
    protected ImageView t;
    protected ProgressBar u;
    protected LinearLayout v;
    protected Button w;
    protected Button x;
    protected ImageView y;
    protected TextView z;

    public be(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, bx bxVar) {
        super(baseFragmentActivity);
        this.f2235a = null;
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
        this.D = null;
        this.E = null;
        this.F = null;
        this.f2235a = baseFragmentActivity;
        this.c = baseFragment;
        this.d = this.c.q();
        this.A = bxVar.b();
        this.B = bxVar.d();
        this.e = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.j = this.e.a(baseFragmentActivity.getResources().getString(R.id.title_text));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, baseFragment);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.HOME_BUTTON, baseFragment);
        this.h = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseFragmentActivity.getResources().getString(R.string.setup), baseFragment);
        this.u = (ProgressBar) this.d.findViewById(R.id.progress);
        this.i = (LinearLayout) this.d.findViewById(R.id.parent);
        this.k = (BdPullRefreshScrollView) this.d.findViewById(R.id.scrollview);
        this.l = new com.baidu.tieba.view.bk(baseFragmentActivity);
        this.k.setCustomHeaderView(this.l);
        this.C = (LinearLayout) this.d.findViewById(R.id.operation_buttons);
        this.n = (HeadImageView) this.d.findViewById(R.id.photo);
        this.n.setIsRound(true);
        this.n.setDrawBorder(false);
        this.o = (HeadImageView) this.d.findViewById(R.id.photo_bg);
        this.o.setIsRound(true);
        this.o.setDrawBorder(false);
        this.o.setImageBitmap(BitmapFactory.decodeResource(this.f2235a.getResources(), R.drawable.bg_pop));
        this.p = (FrameLayout) this.d.findViewById(R.id.photo_frame);
        this.m = (LinearLayout) this.d.findViewById(R.id.person_info_view);
        this.q = (TextView) this.d.findViewById(R.id.name);
        this.r = (TextView) this.d.findViewById(R.id.intro);
        this.s = (ImageView) this.d.findViewById(R.id.background_bottom);
        this.t = (ImageView) this.d.findViewById(R.id.background_image);
        this.E = (UserIconBox) this.d.findViewById(R.id.user_icon_box);
        this.E.setClickable(true);
        this.E.setFocusable(true);
        this.E.setOnClickListener(baseFragment);
        this.v = (LinearLayout) this.d.findViewById(R.id.not_login_view);
        this.y = (ImageView) this.d.findViewById(R.id.not_login_img);
        this.z = (TextView) this.d.findViewById(R.id.not_login_text);
        this.w = (Button) this.d.findViewById(R.id.login_btn);
        this.w.setOnClickListener(baseFragment);
        this.x = (Button) this.d.findViewById(R.id.reg_btn);
        this.x.setOnClickListener(baseFragment);
        l();
    }

    public void d(bx bxVar) {
        this.A = bxVar.b();
        if (this.A == null || this.A.length() < 0) {
            this.m.setVisibility(8);
            this.v.setVisibility(0);
            this.j.setText(R.string.person_info);
            this.h.setVisibility(0);
            this.g.setVisibility(8);
            this.f.setVisibility(4);
            int a2 = UtilHelper.a(this.f2235a, this.b.getResources().getDimension(R.dimen.person_notlogin_edge));
            this.v.setPadding(a2, 0, a2, 0);
        } else {
            this.m.setVisibility(0);
            this.v.setVisibility(8);
        }
        a(bxVar);
        c(bxVar);
        b(bxVar);
    }

    public void l() {
        this.n.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.n.setDefaultResource(0);
        this.n.setNightDefaultResource(0);
        this.n.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
    }

    public void a(bx bxVar) {
    }

    public void c(bx bxVar) {
        int i = 3;
        this.A = bxVar.b();
        if (this.A != null && this.A.length() > 0) {
            this.B = bxVar.d();
            if (this.B == null) {
                this.q.setText(bxVar.g());
                return;
            }
            this.q.setText(this.B.getName_show());
            this.F = this.B.getIconInfo();
            if (this.B.getSex() == 1) {
                this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else if (this.B.getSex() != 2) {
                i = 4;
            } else if (this.F.size() > 0 && this.F.get(0).b().equals(com.baidu.tieba.data.aa.f1155a)) {
                this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
            this.r.setText(this.B.getIntro());
            if (this.E != null) {
                this.E.a(this.F, i, this.f2235a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.f2235a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.f2235a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(bx bxVar) {
    }

    public void a(boolean z) {
        if (!z) {
            this.k.setMode(BdPullRefreshScrollView.Mode.DISABLED);
        } else {
            this.k.setMode(BdPullRefreshScrollView.Mode.PULL_FROM_START);
        }
    }

    public void a(com.baidu.adp.widget.ScrollView.n nVar) {
        this.k.setOnPullDownListener(nVar);
    }

    public void a(int i, bx bxVar) {
        this.A = bxVar.b();
        this.f2235a.a().a(i == 1);
        this.f2235a.a().a(this.i);
        this.e.c(i);
        this.n.d();
        this.l.a(i);
        if (i == 1) {
            this.k.setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg_1));
            this.n.invalidate();
            this.o.setImageBitmap(BitmapFactory.decodeResource(this.f2235a.getResources(), R.drawable.bg_pop_1));
            this.o.invalidate();
            if (this.l.b() != null) {
                this.l.b().setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg_1));
            }
            this.w.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.x.setBackgroundResource(R.drawable.btn_w_square_1);
        } else {
            this.k.setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg));
            this.n.invalidate();
            this.o.setImageBitmap(BitmapFactory.decodeResource(this.f2235a.getResources(), R.drawable.bg_pop));
            this.o.invalidate();
            if (this.l.b() != null) {
                this.l.b().setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg));
            }
            this.w.setBackgroundResource(R.drawable.btn_blue_square);
            this.x.setBackgroundResource(R.drawable.btn_w_square);
        }
        this.t.setImageResource(R.drawable.pic_banner_pic);
    }

    public void e(bx bxVar) {
        this.B = bxVar.d();
        if (this.B == null) {
            this.u.setVisibility(0);
        }
        this.k.setRefreshing(1);
    }

    public void m() {
        this.n.setImageResource(R.drawable.person_photo);
    }

    public void f(bx bxVar) {
        String portrait;
        if (bxVar != null && bxVar.d() != null && (portrait = bxVar.d().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.ImageView.e c = bxVar.f().c(portrait);
            if (c == null) {
                bxVar.f().c(portrait, new bf(this));
                return;
            }
            this.n.setImageResource(0);
            c.a(this.n);
        }
    }

    public void a() {
        if (this.u != null) {
            this.u.setVisibility(8);
        }
    }

    public ImageView n() {
        return this.f;
    }

    public ImageView o() {
        return this.g;
    }

    public TextView p() {
        return this.h;
    }

    public Button q() {
        return this.w;
    }

    public Button r() {
        return this.x;
    }

    public UserIconBox s() {
        return this.E;
    }
}
