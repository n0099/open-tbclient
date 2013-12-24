package com.baidu.tieba.person;

import android.content.Context;
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
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.a.e {
    protected TextView A;
    protected String B;
    protected UserData C;
    protected LinearLayout D;
    protected LinearLayout E;
    protected UserIconBox F;
    protected LinkedList<IconData> G;
    BaseFragmentActivity a;
    BaseFragment c;
    View d;
    protected NavigationBar e;
    protected ImageView f;
    protected ImageView g;
    protected TextView h;
    protected TextView i;
    protected LinearLayout j;
    protected TextView k;
    protected BdPullRefreshScrollView l;
    protected com.baidu.tieba.view.bt m;
    protected LinearLayout n;
    protected HeadImageView o;
    protected HeadImageView p;
    protected FrameLayout q;
    protected TextView r;
    protected TextView s;
    protected ImageView t;
    protected ImageView u;
    protected ProgressBar v;
    protected LinearLayout w;
    protected Button x;
    protected Button y;
    protected ImageView z;

    public bn(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, com.baidu.tieba.model.bx bxVar) {
        super(baseFragmentActivity);
        this.a = null;
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
        this.G = null;
        this.a = baseFragmentActivity;
        this.c = baseFragment;
        this.d = this.c.q();
        this.B = bxVar.b();
        this.C = bxVar.d();
        this.e = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.k = this.e.a(baseFragmentActivity.getResources().getString(R.id.title_text));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, baseFragment);
        this.h = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseFragmentActivity.getResources().getString(R.string.data_more), baseFragment);
        this.i = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseFragmentActivity.getResources().getString(R.string.setup), baseFragment);
        this.v = (ProgressBar) this.d.findViewById(R.id.progress);
        this.j = (LinearLayout) this.d.findViewById(R.id.parent);
        this.l = (BdPullRefreshScrollView) this.d.findViewById(R.id.scrollview);
        this.m = new com.baidu.tieba.view.bt(baseFragmentActivity);
        this.l.setCustomHeaderView(this.m);
        this.D = (LinearLayout) this.d.findViewById(R.id.operation_buttons);
        this.o = (HeadImageView) this.d.findViewById(R.id.photo);
        this.o.setIsRound(true);
        this.o.setDrawBorder(false);
        this.o.setOnClickListener(baseFragment);
        this.p = (HeadImageView) this.d.findViewById(R.id.photo_bg);
        this.p.setIsRound(true);
        this.p.setDrawBorder(false);
        this.p.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), R.drawable.bg_pop));
        this.q = (FrameLayout) this.d.findViewById(R.id.photo_frame);
        this.n = (LinearLayout) this.d.findViewById(R.id.person_info_view);
        this.r = (TextView) this.d.findViewById(R.id.name);
        this.s = (TextView) this.d.findViewById(R.id.intro);
        this.t = (ImageView) this.d.findViewById(R.id.background_bottom);
        this.u = (ImageView) this.d.findViewById(R.id.background_image);
        this.F = (UserIconBox) this.d.findViewById(R.id.user_icon_box);
        this.F.setClickable(true);
        this.F.setFocusable(true);
        this.F.setOnClickListener(baseFragment);
        this.w = (LinearLayout) this.d.findViewById(R.id.not_login_view);
        this.z = (ImageView) this.d.findViewById(R.id.not_login_img);
        this.A = (TextView) this.d.findViewById(R.id.not_login_text);
        this.x = (Button) this.d.findViewById(R.id.login_btn);
        this.x.setOnClickListener(baseFragment);
        this.y = (Button) this.d.findViewById(R.id.reg_btn);
        this.y.setOnClickListener(baseFragment);
        m();
    }

    public void e(com.baidu.tieba.model.bx bxVar) {
        this.B = bxVar.b();
        if (this.B == null || this.B.length() < 0) {
            this.n.setVisibility(8);
            this.w.setVisibility(0);
            this.k.setText(R.string.person_info);
            this.i.setVisibility(0);
            this.h.setVisibility(8);
            this.f.setVisibility(4);
            int a = com.baidu.adp.lib.h.g.a((Context) this.a, 7.0f);
            this.w.setPadding(a, 0, a, 0);
        } else {
            this.n.setVisibility(0);
            this.w.setVisibility(8);
        }
        a(bxVar);
        d(bxVar);
        b(bxVar);
    }

    public void m() {
        this.o.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.o.setDefaultResource(0);
        this.o.setNightDefaultResource(0);
        this.o.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.person_photo));
    }

    public void a(com.baidu.tieba.model.bx bxVar) {
    }

    public void d(com.baidu.tieba.model.bx bxVar) {
        int i = 3;
        this.B = bxVar.b();
        if (this.B != null && this.B.length() > 0) {
            this.C = bxVar.d();
            if (this.C == null) {
                this.r.setText(bxVar.g());
                return;
            }
            this.r.setText(this.C.getName_show());
            this.G = this.C.getIconInfo();
            if (this.C.getSex() == 1) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else if (this.C.getSex() != 2) {
                i = 4;
            } else if (this.G.size() > 0 && this.G.get(0).getIconName().equals(IconData.meizhi_icon_name)) {
                this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
            }
            this.s.setText(this.C.getIntro());
            if (this.F != null) {
                this.F.a(this.G, i, this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tieba.model.bx bxVar) {
    }

    public void a(boolean z) {
        if (!z) {
            this.l.setMode(BdPullRefreshScrollView.Mode.DISABLED);
        } else {
            this.l.setMode(BdPullRefreshScrollView.Mode.PULL_FROM_START);
        }
    }

    public void a(com.baidu.adp.widget.ScrollView.n nVar) {
        this.l.setOnPullDownListener(nVar);
    }

    public void a(int i, com.baidu.tieba.model.bx bxVar) {
        this.B = bxVar.b();
        this.a.a().a(i == 1);
        this.a.a().a(this.j);
        this.e.c(i);
        this.o.e();
        this.m.a(i);
        if (i == 1) {
            this.l.setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg_1));
            this.o.invalidate();
            this.p.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), R.drawable.bg_pop_1));
            this.p.invalidate();
            if (this.m.b() != null) {
                this.m.b().setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg_1));
            }
            this.x.setBackgroundResource(R.drawable.btn_blue_square_1);
            this.y.setBackgroundResource(R.drawable.btn_w_square_1);
        } else {
            this.l.setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg));
            this.o.invalidate();
            this.p.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), R.drawable.bg_pop));
            this.p.invalidate();
            if (this.m.b() != null) {
                this.m.b().setBackgroundColor(this.b.getResources().getColor(R.color.person_scrollview_bg));
            }
            this.x.setBackgroundResource(R.drawable.btn_blue_square);
            this.y.setBackgroundResource(R.drawable.btn_w_square);
        }
        this.u.setImageResource(R.drawable.pic_banner_pic);
    }

    public void c(com.baidu.tieba.model.bx bxVar) {
        this.C = bxVar.d();
        if (this.C == null) {
            this.v.setVisibility(0);
        }
        this.l.setRefreshing(1);
    }

    public void n() {
        m();
    }

    public void f(com.baidu.tieba.model.bx bxVar) {
        String portrait;
        if (bxVar != null && bxVar.d() != null && (portrait = bxVar.d().getPortrait()) != null && portrait.length() > 0) {
            com.baidu.adp.widget.ImageView.e c = bxVar.f().c(portrait);
            if (c == null) {
                bxVar.f().c(portrait, new bo(this));
                return;
            }
            this.o.setImageResource(0);
            c.a(this.o);
            this.l.c();
        }
    }

    public void a() {
        if (this.v != null) {
            this.v.setVisibility(8);
        }
    }

    public ImageView o() {
        return this.f;
    }

    public ImageView p() {
        return this.g;
    }

    public TextView q() {
        return this.h;
    }

    public TextView r() {
        return this.i;
    }

    public Button s() {
        return this.x;
    }

    public Button t() {
        return this.y;
    }

    public UserIconBox u() {
        return this.F;
    }

    public HeadImageView v() {
        return this.o;
    }
}
