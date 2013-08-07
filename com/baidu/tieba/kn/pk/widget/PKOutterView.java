package com.baidu.tieba.kn.pk.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.Random;
/* loaded from: classes.dex */
public class PKOutterView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static int f1229a = 50;
    private long b;
    private long c;
    private e d;
    private float e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private Button j;
    private Button k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private ImageView o;
    private i p;
    private TextView q;
    private h r;
    private h s;
    private TextView t;
    private boolean u;
    private boolean v;
    private boolean w;

    public PKOutterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public PKOutterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PKOutterView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        this.e = context.getResources().getDisplayMetrics().density;
        this.t = new TextView(context);
        this.t.setTextColor(-1);
        this.t.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#9a000000"), Color.parseColor("#00000000")}));
        this.t.setGravity(17);
        this.t.setSingleLine();
        this.t.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (40.0f * this.e)));
        this.t.setEllipsize(TextUtils.TruncateAt.END);
        this.t.setTextColor(-1);
        this.t.setPadding((int) (15.0f * this.e), 0, (int) (15.0f * this.e), 0);
        addView(this.t);
        this.d = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        addView(this.d, 0);
        this.f = new ImageView(context);
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f);
        this.g = new ImageView(context);
        this.g.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.g);
        this.h = new ImageView(context);
        this.h.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.h);
        this.i = new ImageView(context);
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.i);
        this.h.setImageResource(R.drawable.pk_pop_loading);
        this.i.setImageResource(R.drawable.pk_pop_loading);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = (int) (10.0f * this.e);
        layoutParams2.bottomMargin = (int) (5.0f * this.e);
        layoutParams2.gravity = 80;
        linearLayout.setLayoutParams(layoutParams2);
        addView(linearLayout);
        this.j = new Button(context);
        this.j.setText(R.string.pk_support);
        this.j.setId(R.id.star1);
        this.j.setBackgroundResource(R.drawable.support_blue);
        this.j.setTextColor(new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{Color.parseColor("#0062bd"), Color.parseColor("#535353")}));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.j.setLayoutParams(layoutParams3);
        linearLayout.addView(this.j);
        this.l = new TextView(context);
        this.l.setText(String.format(context.getString(R.string.pk_ticket_count), 0));
        this.l.setTextColor(Color.parseColor("#69e2f5"));
        this.l.setGravity(17);
        this.l.setSingleLine();
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.l.setLayoutParams(layoutParams4);
        linearLayout.addView(this.l);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.rightMargin = (int) (10.0f * this.e);
        layoutParams5.bottomMargin = (int) (5.0f * this.e);
        layoutParams5.gravity = 85;
        linearLayout2.setLayoutParams(layoutParams5);
        addView(linearLayout2);
        this.k = new Button(context);
        this.k.setId(R.id.star2);
        this.k.setText(R.string.pk_support);
        this.k.setBackgroundResource(R.drawable.support_yellow);
        this.k.setTextColor(new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{Color.parseColor("#8c4410"), Color.parseColor("#535353")}));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 17;
        this.k.setLayoutParams(layoutParams6);
        linearLayout2.addView(this.k);
        this.m = new TextView(context);
        this.m.setText(String.format(context.getString(R.string.pk_ticket_count), 0));
        this.m.setTextColor(Color.parseColor("#fce9ab"));
        this.m.setGravity(17);
        this.m.setSingleLine();
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.gravity = 17;
        this.m.setLayoutParams(layoutParams7);
        linearLayout2.addView(this.m);
        this.n = new ImageView(context);
        this.n.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.n);
        this.o = new ImageView(context);
        this.o.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.o);
        this.p = new i(context);
        addView(this.p, new FrameLayout.LayoutParams(-1, -1));
        this.q = new TextView(context);
        this.q.setBackgroundResource(R.drawable.pk_time);
        this.q.setGravity(17);
        this.q.setTextColor(-1);
        this.q.setSingleLine(true);
        addView(this.q);
        this.r = new h(this);
        this.r.f1238a = new Point(0, 0);
        this.r.c = new Point(0, 0);
        this.r.b = new Point(0, 0);
        this.r.d = new Point(0, 0);
        this.s = new h(this);
        this.s.f1238a = new Point(0, 0);
        this.s.c = new Point(0, 0);
        this.s.b = new Point(0, 0);
        this.s.d = new Point(0, 0);
        int nextInt = new Random().nextInt(12);
        if (nextInt < 4) {
            this.f.setBackgroundResource(R.drawable.pk_people_boxing_white);
            this.g.setBackgroundResource(R.drawable.pk_people_boxing_red);
        } else if (nextInt >= 4 && nextInt < 8) {
            this.f.setBackgroundResource(R.drawable.pk_people_kungfu_white);
            this.g.setBackgroundResource(R.drawable.pk_people_kungfu_red);
        } else {
            this.f.setBackgroundResource(R.drawable.pk_people_ninjutsu_blue);
            this.g.setBackgroundResource(R.drawable.pk_people_ninjutsu_red);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = (int) (10.0f * this.e);
        int i6 = i3 - i;
        int i7 = i4 - i2;
        this.d.measure(View.MeasureSpec.makeMeasureSpec((i6 * 2) / 3, 1073741824), View.MeasureSpec.makeMeasureSpec(i7 / 3, 1073741824));
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredHeight = this.d.getMeasuredHeight();
        int i8 = (i6 / 2) - (measuredWidth / 2);
        int i9 = (i7 / 2) - (measuredHeight / 2);
        this.d.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        int measuredWidth2 = this.f.getMeasuredWidth();
        int measuredHeight2 = this.f.getMeasuredHeight();
        int i10 = (i6 / 6) - (measuredWidth2 / 2);
        int i11 = ((i7 / 2) - (measuredHeight2 / 2)) - i5;
        this.f.layout(i10, i11, measuredWidth2 + i10, measuredHeight2 + i11);
        int measuredWidth3 = this.g.getMeasuredWidth();
        int measuredHeight3 = this.g.getMeasuredHeight();
        int i12 = i7 / 2;
        int i13 = ((i6 * 5) / 6) - (measuredWidth3 / 2);
        int i14 = (i12 - (measuredHeight3 / 2)) - i5;
        this.g.layout(i13, i14, measuredWidth3 + i13, measuredHeight3 + i14);
        int measuredHeight4 = this.f.getMeasuredHeight() / 2;
        if (measuredHeight4 > this.f.getMeasuredWidth()) {
            measuredHeight4 = this.f.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight4, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight4, 1073741824);
        this.h.measure(makeMeasureSpec, makeMeasureSpec2);
        int i15 = (i6 / 6) - (measuredHeight4 / 2);
        int i16 = ((i7 / 2) - measuredHeight4) + ((int) (1.0f * this.e));
        this.h.layout(i15, i16, i15 + measuredHeight4, i16 + measuredHeight4);
        this.i.measure(makeMeasureSpec, makeMeasureSpec2);
        int i17 = ((i6 * 5) / 6) - (measuredHeight4 / 2);
        int i18 = ((i7 / 2) - measuredHeight4) + ((int) (1.0f * this.e));
        this.i.layout(i17, i18, i17 + measuredHeight4, i18 + measuredHeight4);
        this.n.measure(makeMeasureSpec, makeMeasureSpec2);
        int left = this.h.getLeft();
        int top = (this.h.getTop() - measuredHeight4) + i5;
        this.n.layout(left, top, left + measuredHeight4, top + measuredHeight4);
        this.o.measure(makeMeasureSpec, makeMeasureSpec2);
        int left2 = this.i.getLeft();
        int top2 = (this.i.getTop() - measuredHeight4) + i5;
        this.o.layout(left2, top2, left2 + measuredHeight4, top2 + measuredHeight4);
        this.p.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        this.p.layout(0, 0, i6, i7);
        this.r.f1238a.set((i6 / 6) - (measuredHeight4 / 3), 0);
        this.r.c.set((i6 / 6) + (measuredHeight4 / 3), 0);
        this.r.b.set((i6 / 6) - measuredHeight4, (measuredHeight4 / 2) + i12 + i5);
        this.r.d.set((i6 / 6) + measuredHeight4, (measuredHeight4 / 2) + i12 + i5);
        this.s.f1238a.set(((i6 * 5) / 6) - (measuredHeight4 / 3), 0);
        this.s.c.set(((i6 * 5) / 6) + (measuredHeight4 / 3), 0);
        this.s.b.set(((i6 * 5) / 6) - measuredHeight4, (measuredHeight4 / 2) + i12 + i5);
        this.s.d.set(((i6 * 5) / 6) + measuredHeight4, (measuredHeight4 / 2) + i12 + i5);
        if (this.b > this.c) {
            this.n.setImageResource(R.drawable.icon_top_crown);
            this.p.a(this.r.f1238a, this.r.c, this.r.b, this.r.d);
        } else if (this.c > this.b) {
            this.o.setImageResource(R.drawable.icon_top_crown);
            this.p.a(this.s.f1238a, this.s.c, this.s.b, this.s.d);
        }
        this.q.measure(View.MeasureSpec.makeMeasureSpec(i6 / 3, 1073741824), View.MeasureSpec.makeMeasureSpec(i7 / 5, 1073741824));
        int i19 = i7 / 2;
        int measuredWidth4 = (i6 / 2) - (this.q.getMeasuredWidth() / 2);
        int i20 = (i7 * 3) / 4;
        this.q.layout(measuredWidth4, i20, this.q.getMeasuredWidth() + measuredWidth4, this.q.getMeasuredHeight() + i20);
    }

    public void a() {
        this.q.setText("");
        this.n.setVisibility(4);
        this.o.setVisibility(4);
        this.p.setVisibility(4);
        this.j.setEnabled(false);
        this.k.setEnabled(false);
        this.d.c();
        this.u = true;
        this.w = false;
        this.v = false;
    }

    public void b() {
        this.q.setText(R.string.pk_will_start);
        this.n.setVisibility(4);
        this.o.setVisibility(4);
        this.p.setVisibility(4);
        this.j.setEnabled(false);
        this.k.setEnabled(false);
        this.d.c();
        this.u = true;
        this.w = false;
        this.v = false;
    }

    public void c() {
        this.n.setVisibility(4);
        this.o.setVisibility(4);
        this.p.setVisibility(4);
        this.j.setEnabled(true);
        this.k.setEnabled(true);
        this.d.d();
        this.u = false;
        this.w = false;
        this.v = true;
    }

    public void d() {
        this.q.setText(R.string.pk_end);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.j.setEnabled(false);
        this.k.setEnabled(false);
        e();
        this.d.e();
        this.u = false;
        this.w = true;
        this.v = false;
    }

    private void e() {
        if (this.b > this.c && this.r != null) {
            this.n.setImageResource(R.drawable.icon_top_crown);
            this.p.a(this.r.f1238a, this.r.c, this.r.b, this.r.d);
        } else if (this.c > this.b && this.s != null) {
            this.o.setImageResource(R.drawable.icon_top_crown);
            this.p.a(this.s.f1238a, this.s.c, this.s.b, this.s.d);
        }
    }

    public long getLeftCount() {
        return this.b;
    }

    public void setLeftCount(long j) {
        if (this.b != j) {
            this.b = j;
            this.l.setText(String.format(getContext().getString(R.string.pk_ticket_count), Long.valueOf(j)));
            this.d.setLeftCount(j);
            if (this.w) {
                e();
            }
        }
    }

    public long getRightCount() {
        return this.c;
    }

    public void setRightCount(long j) {
        if (this.c != j) {
            this.c = j;
            this.m.setText(String.format(getContext().getString(R.string.pk_ticket_count), Long.valueOf(j)));
            this.d.setRightCount(j);
            if (this.w) {
                e();
            }
        }
    }

    public void setLeftHeadImg(Bitmap bitmap) {
        this.h.setImageBitmap(bitmap);
    }

    public void setRightHeadImg(Bitmap bitmap) {
        this.i.setImageBitmap(bitmap);
    }

    public void a(int i, int i2, int i3) {
        this.q.setText(b(i, i2, i3));
    }

    public void setTitle(String str) {
        this.t.setText(str);
    }

    private SpannableString b(int i, int i2, int i3) {
        String sb;
        String sb2;
        String sb3;
        if (i < 10) {
            sb = "0" + i;
        } else {
            sb = new StringBuilder(String.valueOf(i)).toString();
        }
        if (i2 < 10) {
            sb2 = "0" + i2;
        } else {
            sb2 = new StringBuilder(String.valueOf(i2)).toString();
        }
        if (i3 < 10) {
            sb3 = "0" + i3;
        } else {
            sb3 = new StringBuilder(String.valueOf(i3)).toString();
        }
        String format = String.format(" %s  :  %s  :  %s ", sb, sb2, sb3);
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#88ffffff")), 0, 4, 17);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#88ffffff")), 7, 11, 17);
        spannableString.setSpan(new BackgroundColorSpan(Color.parseColor("#88ffffff")), 14, format.length(), 17);
        return spannableString;
    }
}
