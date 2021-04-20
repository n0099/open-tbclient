package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class FollowUserSpinnerBtn extends LinearLayout implements d.b.h0.r.f0.q.b {
    public static final int t = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds224);
    public static final int u = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds58);
    public static final int v = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f21758e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f21759f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21760g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21761h;
    public Paint i;
    public int j;
    public int k;
    public RectF l;
    public Path m;
    public String n;
    public Drawable o;
    public boolean p;
    public boolean q;
    public boolean r;
    public b s;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21762e;

        public a(b bVar) {
            this.f21762e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = this.f21762e;
            if (bVar != null) {
                bVar.a(!FollowUserSpinnerBtn.this.p, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, boolean z2);
    }

    public FollowUserSpinnerBtn(Context context) {
        this(context, null);
    }

    @Override // d.b.h0.r.f0.q.b
    public void a(boolean z, int i) {
        i(z);
    }

    @Override // d.b.h0.r.f0.q.b
    public void b(View view) {
    }

    @Override // d.b.h0.r.f0.q.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // d.b.h0.r.f0.q.b
    public void d(boolean z, int i, boolean z2) {
        a(z, i);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.l.set(0.0f, 0.0f, getWidth(), getHeight());
        this.m.reset();
        this.m.addRoundRect(this.l, getHeight() / 2, getHeight() / 2, Path.Direction.CW);
        canvas.clipPath(this.m);
        super.draw(canvas);
        if (this.r) {
            this.i.setColor(SkinManager.getColor(this.j));
            float right = this.f21758e.getRight();
            canvas.drawLine(right, this.f21761h.getTop(), right, this.f21761h.getBottom(), this.i);
        }
    }

    @Override // d.b.h0.r.f0.q.b
    public void e(int i) {
    }

    public final void g(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_user_spinner_btn_layout, this);
        setOrientation(0);
        this.f21758e = (FrameLayout) findViewById(R.id.leftBox);
        this.f21759f = (FrameLayout) findViewById(R.id.rightBox);
        this.f21760g = (TextView) findViewById(R.id.title);
        this.f21761h = (ImageView) findViewById(R.id.arrow);
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.i.setStrokeCap(Paint.Cap.ROUND);
        this.i.setStrokeWidth(l.g(context, R.dimen.tbds3));
        this.l = new RectF();
        this.m = new Path();
        this.j = R.color.CAM_X0105;
        Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.j, null);
        this.o = pureDrawable;
        this.f21761h.setImageDrawable(pureDrawable);
    }

    public ImageView getArrow() {
        return this.f21761h;
    }

    public void h(int i) {
        setBackgroundColor(SkinManager.getColor(this.k));
        SkinManager.setViewTextColor(this.f21760g, this.j);
        Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.icon_pure_unfold12_svg, this.j, null);
        this.o = pureDrawable;
        this.f21761h.setImageDrawable(pureDrawable);
        invalidate();
    }

    public void i(boolean z) {
        b bVar;
        if (z) {
            this.n = getResources().getString(R.string.followed);
            this.j = R.color.CAM_X0101;
            this.k = R.color.CAM_X0904;
        } else {
            this.n = getResources().getString(R.string.attention);
            this.j = R.color.CAM_X0105;
            this.k = R.color.CAM_X0901;
        }
        this.f21760g.setText(this.n);
        requestLayout();
        h(0);
        if (this.r && !this.q && z && !this.p && (bVar = this.s) != null) {
            bVar.a(true, true);
        }
        this.q = false;
    }

    public void setFirstUpdate(boolean z) {
        this.q = z;
    }

    public void setOpen(boolean z) {
        this.p = z;
    }

    public void setOpenListener(b bVar) {
        this.s = bVar;
        this.f21759f.setOnClickListener(new a(bVar));
    }

    public void setShowPullBtn(boolean z) {
        this.r = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21760g.getLayoutParams();
        if (z) {
            this.f21759f.setVisibility(0);
            layoutParams.leftMargin = u;
            layoutParams.rightMargin = v;
            layoutParams.gravity = 16;
            layoutParams.width = -2;
        } else {
            this.f21759f.setVisibility(8);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.gravity = 17;
            layoutParams.width = t;
        }
        this.f21760g.setLayoutParams(layoutParams);
        requestLayout();
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserSpinnerBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = true;
        g(context);
    }
}
