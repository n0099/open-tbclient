package com.baidu.tieba.kn.pk.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1299a;
    private PKOutterView b;
    private LinearLayout c;
    private int d;
    private Scroller f;
    private boolean h;
    private View i;
    private View j;
    private int e = -1;
    private Handler g = new Handler();
    private int k = BdWebErrorView.ERROR_CODE_500;
    private Runnable l = new c(this);
    private Runnable m = new d(this);

    public boolean a() {
        return this.h;
    }

    public b(Activity activity, View.OnClickListener onClickListener) {
        this.b = (PKOutterView) activity.findViewById(R.id.pkview);
        this.b.a();
        this.c = (LinearLayout) activity.findViewById(R.id.pk_header_bottom);
        this.d = this.c.getPaddingTop();
        this.i = this.c.findViewById(R.id.pk_left_bar_container);
        this.j = this.c.findViewById(R.id.pk_right_bar_container);
        this.f1299a = activity;
        this.f = new Scroller(this.f1299a, new DecelerateInterpolator());
    }

    public void a(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void b() {
        this.b.b();
    }

    public void c() {
        this.b.c();
    }

    public void d() {
        this.b.d();
    }

    public void a(long j) {
        this.b.setLeftCount(Math.max(0L, j));
    }

    public void b(long j) {
        this.b.setRightCount(Math.max(0L, j));
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.b.setLeftHeadImg(bitmap);
        }
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            this.b.setRightHeadImg(bitmap);
        }
    }

    public void a(int i, int i2, int i3) {
        this.b.a(i, i2, i3);
    }

    public void a(String str) {
        this.b.setTitle(str);
    }

    public void e() {
        if (!this.h && this.c.getVisibility() != 0) {
            this.h = true;
            this.c.setVisibility(0);
            if (this.e == -1) {
                this.e = this.c.getMeasuredHeight();
            }
            this.c.setPadding(this.c.getPaddingLeft(), -this.e, this.c.getPaddingRight(), this.c.getPaddingBottom());
            this.f.startScroll(0, -this.e, 0, this.e + this.d, this.k);
            this.g.post(this.l);
        }
    }

    public void f() {
        if (!this.h && this.c.getVisibility() != 8) {
            this.h = true;
            this.f.startScroll(0, this.d, 0, (-this.d) - this.e, this.k);
            this.g.post(this.m);
        }
    }

    public void a(String str, String str2, View.OnClickListener onClickListener) {
        ((TextView) this.i.findViewById(R.id.pk_left_bar_name)).setText(str);
        ((TextView) this.i.findViewById(R.id.pk_left_bar_number)).setText(str2);
        this.i.setOnClickListener(onClickListener);
    }

    public void b(String str, String str2, View.OnClickListener onClickListener) {
        ((TextView) this.j.findViewById(R.id.pk_right_bar_name)).setText(str);
        ((TextView) this.j.findViewById(R.id.pk_right_bar_number)).setText(str2);
        this.j.setOnClickListener(onClickListener);
    }

    public void a(String str, String str2) {
        ((TextView) this.c.findViewById(R.id.pk_rules_title)).setText(str);
        ((TextView) this.c.findViewById(R.id.pk_rules_content)).setText(str2);
    }

    public boolean g() {
        return this.c.getVisibility() == 8;
    }

    public void a(int i) {
        this.b.setBackgroundResource(i);
    }
}
