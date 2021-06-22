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
    public long f21592e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21593f;

    /* renamed from: g  reason: collision with root package name */
    public b f21594g;

    /* renamed from: h  reason: collision with root package name */
    public float f21595h;

    /* renamed from: i  reason: collision with root package name */
    public float f21596i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DealEventView.this.f21593f || !DealEventView.this.j || DealEventView.this.f21594g == null) {
                return;
            }
            DealEventView.this.f21594g.m();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void k();

        void m();
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
            this.f21595h = motionEvent.getX();
            this.f21596i = motionEvent.getY();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f21592e < 300) {
                this.f21593f = true;
                b bVar2 = this.f21594g;
                if (bVar2 != null) {
                    bVar2.a();
                }
            } else {
                this.f21593f = false;
            }
            this.f21592e = currentTimeMillis;
        } else if (action != 1) {
            if (action == 2 && this.f21595h - motionEvent.getX() > 60.0f && (this.f21595h - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.f21596i) && !this.f21593f && (bVar = this.f21594g) != null) {
                bVar.k();
            }
        } else {
            if (this.f21595h - motionEvent.getX() < 10.0f && this.f21596i - motionEvent.getY() < 10.0f) {
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
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getTag() instanceof AnimatorSet) {
                ((AnimatorSet) childAt.getTag()).cancel();
            }
        }
        super.removeAllViews();
    }

    public void setOnViewClickListener(b bVar) {
        this.f21594g = bVar;
    }

    public DealEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DealEventView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d();
    }
}
