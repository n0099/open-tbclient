package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class DealEventView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public long f21620e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21621f;

    /* renamed from: g  reason: collision with root package name */
    public b f21622g;

    /* renamed from: h  reason: collision with root package name */
    public float f21623h;
    public float i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DealEventView.this.f21621f || !DealEventView.this.j || DealEventView.this.f21622g == null) {
                return;
            }
            DealEventView.this.f21622g.k();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void k();

        void l();
    }

    public DealEventView(Context context) {
        this(context, null);
    }

    public final void d() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f21623h = motionEvent.getX();
            this.i = motionEvent.getY();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f21620e < 300) {
                this.f21621f = true;
                b bVar2 = this.f21622g;
                if (bVar2 != null) {
                    bVar2.a();
                }
            } else {
                this.f21621f = false;
            }
            this.f21620e = currentTimeMillis;
        } else if (action != 1) {
            if (action == 2 && this.f21623h - motionEvent.getX() > 60.0f && (this.f21623h - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.i) && !this.f21621f && (bVar = this.f21622g) != null) {
                bVar.l();
            }
        } else {
            if (this.f21623h - motionEvent.getX() < 10.0f && this.i - motionEvent.getY() < 10.0f) {
                this.j = true;
            } else {
                this.j = false;
            }
            postDelayed(new a(), 300L);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getTag() instanceof AnimatorSet) {
                ((AnimatorSet) childAt.getTag()).cancel();
            }
        }
        super.removeAllViews();
    }

    public void setOnViewClickListener(b bVar) {
        this.f21622g = bVar;
    }

    public DealEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DealEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }
}
