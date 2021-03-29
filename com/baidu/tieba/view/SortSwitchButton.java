package com.baidu.tieba.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.i0.c3.h0.r;
import d.b.i0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    public RectF A;
    public Path B;
    public RectF C;
    public Path D;
    public d.b.i0.f E;
    public float F;
    public float G;
    public boolean H;
    public boolean I;
    public boolean J;
    public List<r> K;
    public List<Float> L;
    public GestureDetector M;
    public f N;
    public ValueAnimator O;
    public float P;
    public float Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public BdUniqueId U;
    public BdUniqueId V;
    public CustomMessageListener W;
    public f.a a0;
    public GestureDetector.SimpleOnGestureListener b0;

    /* renamed from: e  reason: collision with root package name */
    public float f22197e;

    /* renamed from: f  reason: collision with root package name */
    public float f22198f;

    /* renamed from: g  reason: collision with root package name */
    public float f22199g;

    /* renamed from: h  reason: collision with root package name */
    public int f22200h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public int r;
    public Paint s;
    public Paint t;
    public Paint u;
    public Paint v;
    public RectF w;
    public Path x;
    public RectF y;
    public Path z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                if (tag == null || bdUniqueId == null || SortSwitchButton.this.U == null) {
                    return;
                }
                Integer num = (Integer) customResponsedMessage.getData();
                if (tag.getId() != SortSwitchButton.this.U.getId() || bdUniqueId.getId() == SortSwitchButton.this.V.getId() || SortSwitchButton.this.E.a() == num.intValue() || ListUtils.isEmpty(SortSwitchButton.this.K) || ListUtils.isEmpty(SortSwitchButton.this.L) || SortSwitchButton.this.L.size() <= num.intValue()) {
                    return;
                }
                SortSwitchButton.this.E.d(num.intValue());
                SortSwitchButton sortSwitchButton = SortSwitchButton.this;
                sortSwitchButton.F = ((Float) sortSwitchButton.L.get(num.intValue())).floatValue();
                SortSwitchButton.this.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.a {
        public b() {
        }

        @Override // d.b.i0.f.a
        public void a(int i, int i2) {
            ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i2));
            CustomMessage customMessage = new CustomMessage(2921458);
            customMessage.setTag(SortSwitchButton.this.U);
            customMessage.setData(SortSwitchButton.this.V);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (!SortSwitchButton.this.I && motionEvent.getX() <= SortSwitchButton.this.f22197e && motionEvent.getY() <= SortSwitchButton.this.f22198f) {
                if (SortSwitchButton.this.getParent() != null) {
                    SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (SortSwitchButton.this.H) {
                SortSwitchButton.this.F -= f2;
                if (SortSwitchButton.this.F < 0.0f) {
                    SortSwitchButton.this.F = 0.0f;
                }
                Float f4 = (Float) ListUtils.getItem(SortSwitchButton.this.L, SortSwitchButton.this.L.size() - 1);
                float floatValue = f4 != null ? f4.floatValue() : 0.0f;
                if (SortSwitchButton.this.F > floatValue) {
                    SortSwitchButton.this.F = floatValue;
                }
                SortSwitchButton.this.invalidate();
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int a2 = SortSwitchButton.this.E.a();
            SortSwitchButton.this.F = motionEvent.getX();
            SortSwitchButton.this.E.c(SortSwitchButton.this.t());
            SortSwitchButton.this.I = true;
            if (SortSwitchButton.this.E.a() != a2) {
                SortSwitchButton.this.G(a2);
                if (SortSwitchButton.this.O != null) {
                    SortSwitchButton.this.O.start();
                }
                SortSwitchButton.this.y(a2);
            }
            SortSwitchButton.this.I = false;
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.P;
            if (SortSwitchButton.this.R) {
                SortSwitchButton sortSwitchButton = SortSwitchButton.this;
                sortSwitchButton.F = sortSwitchButton.Q - floatValue;
            } else {
                SortSwitchButton sortSwitchButton2 = SortSwitchButton.this;
                sortSwitchButton2.F = sortSwitchButton2.Q + floatValue;
            }
            SortSwitchButton.this.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (SortSwitchButton.this.L.size() > SortSwitchButton.this.E.a()) {
                SortSwitchButton sortSwitchButton = SortSwitchButton.this;
                sortSwitchButton.F = ((Float) sortSwitchButton.L.get(SortSwitchButton.this.E.a())).floatValue();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        boolean a(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public final void A() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.O = duration;
        duration.addUpdateListener(new d());
        this.O.addListener(new e());
    }

    public final void B(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SortSwitchButton);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.f22200h = resourceId;
        this.i = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_background_border_color, resourceId);
        this.j = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_background_border_width, 0.0f);
        this.k = obtainStyledAttributes.getFloat(R$styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.l = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.m = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.n = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.o = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_text_size, 5.0f);
        this.p = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.f22199g = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_slide_height, 0.0f);
        this.q = obtainStyledAttributes.getDimension(R$styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.r = obtainStyledAttributes.getResourceId(R$styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.T = obtainStyledAttributes.getBoolean(R$styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    public final void C() {
        RectF rectF = this.w;
        float f2 = this.j;
        rectF.set(f2, f2, this.f22197e - f2, this.f22198f - f2);
        this.x.reset();
        Path path = this.x;
        RectF rectF2 = this.w;
        float f3 = this.f22198f;
        path.addRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, Path.Direction.CW);
        RectF rectF3 = this.y;
        if (rectF3 != null && this.t != null) {
            rectF3.set(0.0f, 0.0f, this.f22197e, this.f22198f);
            float f4 = this.j * 0.5f;
            float f5 = -f4;
            this.A.set(f5, f5, this.f22197e + f4, this.f22198f + f4);
            this.z.reset();
            this.B.reset();
            Path path2 = this.z;
            RectF rectF4 = this.y;
            float f6 = this.f22198f;
            path2.addRoundRect(rectF4, f6 / 2.0f, f6 / 2.0f, Path.Direction.CW);
            Path path3 = this.B;
            RectF rectF5 = this.A;
            float f7 = this.f22198f;
            path3.addRoundRect(rectF5, (f7 + f4) * 0.5f, (f7 + f4) * 0.5f, Path.Direction.CW);
        }
        Float f8 = (Float) ListUtils.getItem(this.L, this.E.a());
        this.F = f8 != null ? f8.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.v.getFontMetrics();
        this.G = (this.f22198f / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
    }

    public final boolean D(List<r> list) {
        if (!ListUtils.isEmpty(list) && list.size() == this.K.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (!E(list.get(i), this.K.get(i))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean E(r rVar, r rVar2) {
        if (rVar == null && rVar2 == null) {
            return true;
        }
        if (rVar != null && rVar2 != null) {
            if (rVar.a() == rVar2.a() && rVar.b() != null && rVar.b().equals(rVar2.b())) {
                return true;
            }
            if (rVar.a() == rVar2.a() && rVar.b() == null && rVar2.b() == null) {
                return true;
            }
        }
        return false;
    }

    public void F() {
        if (this.S) {
            this.s.setColor(SkinManager.getColor(this.f22200h));
            Paint paint = this.t;
            if (paint != null) {
                paint.setColor(d.b.i0.c3.c.a(SkinManager.getColor(this.f22200h), this.k));
            }
            invalidate();
        }
    }

    public final void G(int i) {
        if (this.L.size() > i) {
            this.Q = this.L.get(i).floatValue();
        }
        this.P = Math.abs((this.L.size() > this.E.a() ? this.L.get(this.E.a()).floatValue() : 0.0f) - this.Q);
        this.R = this.E.a() < i;
    }

    public void H() {
        this.E.c(0);
        this.F = 0.0f;
        this.I = false;
        this.K.clear();
        this.L.clear();
        this.J = true;
    }

    public int getState() {
        return this.E.a();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path path = this.B;
        if (path != null) {
            canvas.clipPath(path);
        } else {
            canvas.clipPath(this.x);
        }
        super.onDraw(canvas);
        v(canvas);
        w(canvas);
        int i = 0;
        while (i < this.K.size() && i < this.L.size()) {
            x(canvas, this.K.get(i).b(), this.L.get(i).floatValue() + this.p, this.G, this.E.a() == i);
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = ListUtils.getCount(this.K);
        float f2 = 0.0f;
        if (mode == Integer.MIN_VALUE) {
            this.f22197e = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                r rVar = (r) ListUtils.getItem(this.K, i3);
                if (rVar != null) {
                    float measureText = this.v.measureText(rVar.b() == null ? "" : rVar.b()) + (this.p * 2.0f);
                    if (this.J) {
                        this.L.add(Float.valueOf(this.f22197e));
                    }
                    this.f22197e += measureText;
                }
            }
        } else {
            this.f22197e = size;
            if (count > 0) {
                size /= count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.J) {
                    this.L.add(Float.valueOf(f2));
                }
                f2 += size;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.f22198f = this.f22199g;
        } else {
            this.f22198f = size2;
            this.f22199g = size2;
        }
        this.J = false;
        C();
        setMeasuredDimension((int) this.f22197e, (int) this.f22198f);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.M.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.H && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int a2 = this.E.a();
            int t = t();
            if (Math.abs(t - a2) >= 2 || t > a2) {
                this.E.d(t);
            } else if (t < a2) {
                float floatValue = this.L.size() > t ? this.L.get(t).floatValue() : 0.0f;
                int i = t + 1;
                float floatValue2 = i < this.L.size() ? this.L.get(i).floatValue() : floatValue;
                float f2 = this.F;
                if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                    this.E.d(t);
                }
            } else {
                float floatValue3 = this.L.size() > t ? this.L.get(t).floatValue() : 0.0f;
                int i2 = t + 1;
                if (this.F >= floatValue3 + (((i2 < this.L.size() ? this.L.get(i2).floatValue() : floatValue3) - floatValue3) / 2.0f) && i2 < this.L.size()) {
                    this.E.d(i2);
                }
            }
            this.I = true;
            this.Q = this.F;
            float floatValue4 = this.L.size() > this.E.a() ? this.L.get(this.E.a()).floatValue() : 0.0f;
            this.P = Math.abs(this.Q - floatValue4);
            if (this.E.a() < a2) {
                this.R = true;
            } else if (this.E.a() > a2) {
                this.R = false;
            } else {
                this.R = this.Q > floatValue4;
            }
            ValueAnimator valueAnimator = this.O;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
            if (this.E.a() != a2) {
                y(a2);
            }
            this.I = false;
            return true;
        }
        return false;
    }

    public void setCanScroll(boolean z) {
        this.H = z;
    }

    public void setCommenId(BdUniqueId bdUniqueId) {
        this.U = bdUniqueId;
    }

    public void setData(List<r> list) {
        if (D(list)) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.K = list;
            requestLayout();
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.T) {
            this.W.setTag(bdUniqueId);
        }
    }

    public void setNeedDayNight(boolean z) {
        this.S = z;
        if (z) {
            return;
        }
        this.s.setColor(SkinManager.getColor(0, this.f22200h));
        Paint paint = this.t;
        if (paint != null) {
            paint.setColor(d.b.i0.c3.c.a(SkinManager.getColor(0, this.i), this.k));
        }
    }

    public void setOnSwitchChangeListener(f fVar) {
        this.N = fVar;
    }

    public final int t() {
        float floatValue;
        int a2 = this.E.a();
        int i = 0;
        while (i < this.L.size()) {
            float floatValue2 = ((Float) ListUtils.getItem(this.L, i)).floatValue();
            int i2 = i + 1;
            if (i2 == this.L.size()) {
                floatValue = this.f22197e;
            } else {
                floatValue = ((Float) ListUtils.getItem(this.L, i2)).floatValue();
            }
            float f2 = this.F;
            if (f2 <= floatValue2 || f2 >= floatValue) {
                float f3 = this.F;
                if (f3 == floatValue2) {
                    if (a2 - 1 >= 0) {
                        return a2 - 1;
                    }
                } else if (f3 == floatValue && (i = a2 + 1) < ListUtils.getCount(this.L)) {
                }
                i = i2;
            }
            return i;
        }
        return a2;
    }

    public void u(int i) {
        if (ListUtils.isEmpty(this.K) || ListUtils.isEmpty(this.L)) {
            return;
        }
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            if (this.K.get(i2).a() == i) {
                this.E.c(i2);
                if (this.L.size() > i2) {
                    this.F = this.L.get(i2).floatValue();
                }
                invalidate();
                return;
            }
        }
    }

    public final void v(Canvas canvas) {
        Paint paint;
        canvas.drawPath(this.x, this.s);
        if (this.i <= 0 || this.j <= 0.0f || (paint = this.t) == null) {
            return;
        }
        canvas.drawPath(this.z, paint);
    }

    public final void w(Canvas canvas) {
        float f2;
        if (this.F < 0.0f) {
            this.F = 0.0f;
        }
        float floatValue = !ListUtils.isEmpty(this.L) ? ((Float) ListUtils.getItem(this.L, this.E.a())).floatValue() : 0.0f;
        if (this.E.a() + 1 < this.L.size()) {
            f2 = this.L.get(this.E.a() + 1).floatValue();
        } else {
            f2 = this.E.a() + 1 == this.L.size() ? this.f22197e : 0.0f;
        }
        float f3 = this.F + (f2 - floatValue);
        float f4 = this.f22197e;
        if (f3 > f4) {
            f3 = f4;
        }
        this.C.set(this.F, 0.0f, f3, this.f22198f);
        this.D.reset();
        Path path = this.D;
        RectF rectF = this.C;
        float f5 = this.f22199g;
        path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
        this.u.reset();
        this.u.setAntiAlias(true);
        this.u.setColor(this.S ? SkinManager.getColor(this.l) : SkinManager.getColor(0, this.l));
        canvas.drawPath(this.D, this.u);
        this.u.reset();
        this.u.setAntiAlias(true);
        this.u.setColor(this.S ? SkinManager.getColor(this.r) : SkinManager.getColor(0, this.r));
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth(this.q);
        RectF rectF2 = this.C;
        float f6 = this.F;
        float f7 = this.q;
        rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.f22199g - (f7 / 2.0f));
        float f8 = (this.f22199g - this.q) / 2.0f;
        canvas.drawRoundRect(this.C, f8, f8, this.u);
    }

    public final void x(Canvas canvas, String str, float f2, float f3, boolean z) {
        if (z) {
            this.v.setColor(this.S ? SkinManager.getColor(this.n) : SkinManager.getColor(0, this.n));
        } else {
            this.v.setColor(this.S ? SkinManager.getColor(this.m) : SkinManager.getColor(0, this.m));
        }
        canvas.drawText(str, f2, f3, this.v);
    }

    public final void y(int i) {
        f fVar = this.N;
        if (fVar == null || fVar.a(this.E.a())) {
            return;
        }
        ValueAnimator valueAnimator = this.O;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.E.c(i);
        if (this.L.size() > this.E.a()) {
            this.F = this.L.get(this.E.a()).floatValue();
        }
        invalidate();
    }

    public final void z(Context context) {
        this.w = new RectF();
        this.x = new Path();
        this.C = new RectF();
        this.D = new Path();
        Paint paint = new Paint(1);
        this.s = paint;
        paint.setColor(SkinManager.getColor(this.f22200h));
        if (this.i > 0 && this.j > 0.0f) {
            this.y = new RectF();
            this.z = new Path();
            this.A = new RectF();
            this.B = new Path();
            Paint paint2 = new Paint(1);
            this.t = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.t.setStrokeWidth(this.j);
            this.t.setColor(d.b.i0.c3.c.a(SkinManager.getColor(this.f22200h), this.k));
        }
        this.u = new Paint(1);
        Paint paint3 = new Paint(1);
        this.v = paint3;
        paint3.setTextSize(this.o);
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.E.d(0);
        this.M = new GestureDetector(context, this.b0);
        A();
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = new d.b.i0.f();
        this.H = false;
        this.I = false;
        this.J = true;
        this.S = true;
        this.T = false;
        this.V = BdUniqueId.gen();
        this.W = new a(2921458);
        this.a0 = new b();
        this.b0 = new c();
        B(context, attributeSet);
        z(context);
        setOnTouchListener(this);
        if (this.T) {
            this.E.b(this.a0);
            MessageManager.getInstance().registerListener(this.W);
        }
    }

    public void setData(List<r> list, int i) {
        d.b.i0.f fVar;
        if (D(list) || (fVar = this.E) == null || fVar.a() != i) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            H();
            setVisibility(0);
            this.E.c(i);
            this.K = list;
            requestLayout();
        }
    }
}
