package com.baidu.tieba.kn.pk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.kn.pk.s;
import com.baidu.tieba.kn.pk.y;
import com.baidu.tieba.util.at;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PullAndPull extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1297a;
    private int b;
    private int c;
    private float d;
    private Scroller e;
    private LinkedList<y> f;
    private float g;
    private int h;
    private boolean i;
    private s j;
    private Context k;
    private ArrayList<View> l;
    private int m;
    private int n;
    private Camera o;
    private Matrix p;
    private Runnable q;

    public PullAndPull(Context context) {
        super(context);
        this.f1297a = 10;
        this.f = new LinkedList<>();
        this.l = new ArrayList<>();
        this.m = 600;
        this.n = -100;
        this.q = new j(this);
        b();
    }

    public PullAndPull(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1297a = 10;
        this.f = new LinkedList<>();
        this.l = new ArrayList<>();
        this.m = 600;
        this.n = -100;
        this.q = new j(this);
        b();
    }

    public PullAndPull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1297a = 10;
        this.f = new LinkedList<>();
        this.l = new ArrayList<>();
        this.m = 600;
        this.n = -100;
        this.q = new j(this);
        b();
    }

    private void b() {
        this.g = getResources().getDisplayMetrics().density;
        this.e = new Scroller(getContext(), new DecelerateInterpolator());
        this.c = (int) (this.g * 45.0f);
        this.k = getContext();
        this.o = new Camera();
        this.p = new Matrix();
        this.h = (int) (this.g * 1.0f);
        if (this.h == 0) {
            this.h = 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = this.f.size();
        if (size > this.f1297a) {
            size = this.f1297a;
        }
        this.b = ((size - 1) * this.h) + (this.c * size);
        if (this.b < 0) {
            this.b = 0;
        }
        setMeasuredDimension(getMeasuredWidth(), this.b);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int i;
        if (this.e.computeScrollOffset()) {
            this.d = this.e.getCurrX();
            invalidate();
        } else {
            while (this.f.size() > this.f1297a) {
                y removeFirst = this.f.removeFirst();
                if (removeFirst != null) {
                    this.l.add(removeFirst.f);
                    removeFirst.f = null;
                }
            }
        }
        int i2 = (int) this.d;
        int size = this.f.size() - 1;
        int i3 = i2;
        while (size >= 0) {
            y yVar = this.f.get(size);
            if (!yVar.e) {
                yVar.f = getView();
                TextView textView = (TextView) yVar.f.findViewById(R.id.name);
                TextView textView2 = (TextView) yVar.f.findViewById(R.id.time);
                TextView textView3 = (TextView) yVar.f.findViewById(R.id.score);
                TextView textView4 = (TextView) yVar.f.findViewById(R.id.highlight);
                textView.setText(yVar.f1309a);
                textView2.setText(at.a(new Date(this.j.e()), new Date(yVar.c * 1000)));
                textView3.setText("+" + String.format(this.k.getString(R.string.pk_ticket_count), Integer.valueOf(yVar.b)));
                int parseColor = Color.parseColor("#FCFCFC");
                if (!TextUtils.isEmpty(yVar.f1309a) && yVar.f1309a.equalsIgnoreCase(TiebaApplication.G())) {
                    if (this.i) {
                        int parseColor2 = Color.parseColor("#e3f1ff");
                        textView4.setBackgroundResource(R.drawable.icon_me_blue_line);
                        i = parseColor2;
                    } else {
                        int parseColor3 = Color.parseColor("#ffeee7");
                        textView4.setBackgroundResource(R.drawable.icon_me_orange_line);
                        i = parseColor3;
                    }
                } else {
                    textView4.setBackgroundColor(parseColor);
                    i = parseColor;
                }
                textView3.setBackgroundColor(i);
                textView.setBackgroundColor(i);
                textView2.setBackgroundColor(i);
                yVar.f.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
                yVar.f.layout(0, 0, getWidth(), this.c);
                yVar.e = true;
            } else {
                ((TextView) yVar.f.findViewById(R.id.time)).setText(at.a(new Date(this.j.e()), new Date(yVar.c * 1000)));
            }
            int paddingLeft = getPaddingLeft();
            int save = canvas.save();
            this.p.reset();
            if (size == this.f.size() - 1) {
                int abs = Math.abs(i3);
                this.o.save();
                this.o.translate(0.0f, 0.0f, (abs * this.n) / (this.c + this.h));
                this.o.getMatrix(this.p);
                this.o.restore();
                int width = getWidth() / 2;
                int i4 = this.c / 2;
                this.p.preTranslate(-width, -i4);
                this.p.postTranslate(width, i4);
                canvas.concat(this.p);
            }
            canvas.translate(paddingLeft, i3);
            yVar.f.draw(canvas);
            canvas.restoreToCount(save);
            size--;
            i3 += this.c + this.h;
        }
        postDelayed(this.q, 30000L);
    }

    private View getView() {
        View view = null;
        if (this.l.size() > 0) {
            view = this.l.remove(0);
        }
        if (view == null) {
            return c();
        }
        return view;
    }

    private View c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        TextView textView = new TextView(this.k);
        textView.setId(R.id.highlight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(this.k);
        textView2.setGravity(17);
        textView2.setId(R.id.score);
        textView2.setPadding(0, 0, (int) (this.g * 10.0f), 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(textView2, layoutParams2);
        if (this.i) {
            textView2.setTextColor(-13135118);
        } else {
            textView2.setTextColor(-691656);
        }
        TextView textView3 = new TextView(this.k);
        textView3.setId(R.id.name);
        textView3.setTextColor(Color.parseColor("#262626"));
        textView3.setSingleLine(true);
        textView3.setTextSize(12.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(1, R.id.highlight);
        layoutParams3.addRule(0, R.id.score);
        textView3.setPadding((int) (this.g * 10.0f), 0, 0, 0);
        relativeLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(this.k);
        textView4.setId(R.id.time);
        textView4.setTextColor(Color.parseColor("#979899"));
        textView4.setSingleLine(true);
        textView4.setTextSize(10.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(1, R.id.highlight);
        layoutParams4.addRule(0, R.id.score);
        layoutParams4.addRule(3, R.id.name);
        textView4.setPadding((int) (this.g * 10.0f), (int) (6.0f * this.g), 0, 0);
        relativeLayout.addView(textView4, layoutParams4);
        return relativeLayout;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.q);
        if (this.o != null) {
            this.o = null;
        }
    }

    public void a(y yVar, boolean z, boolean z2) {
        this.i = z;
        this.f.add(yVar);
        if (this.f.size() <= this.f1297a) {
            requestLayout();
        }
        removeCallbacks(this.q);
        while (this.f.size() > this.f1297a + 1) {
            y removeFirst = this.f.removeFirst();
            if (removeFirst != null) {
                this.l.add(removeFirst.f);
                removeFirst.f = null;
            }
        }
        if (z2) {
            this.d = (-this.c) - this.h;
            if (!this.e.isFinished()) {
                this.e.forceFinished(true);
            }
            this.e.startScroll((-this.c) - this.h, 0, this.c + this.h, 0, this.m);
        }
        invalidate();
    }

    public void a() {
        this.f.clear();
        requestLayout();
    }

    public s getData() {
        return this.j;
    }

    public void setData(s sVar) {
        this.j = sVar;
    }
}
