package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class RecordLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f21513e;

    /* renamed from: f  reason: collision with root package name */
    public int f21514f;

    /* renamed from: g  reason: collision with root package name */
    public int f21515g;

    /* renamed from: h  reason: collision with root package name */
    public int f21516h;
    public float i;
    public a j;

    /* loaded from: classes5.dex */
    public interface a {
        void onTouchToLeft();

        void onTouchToRight();
    }

    public RecordLayout(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f21515g = ViewConfiguration.getMaximumFlingVelocity();
        this.f21514f = ViewConfiguration.getMinimumFlingVelocity();
        this.f21516h = l.g(getContext(), R.dimen.ds150);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f21513e == null) {
            this.f21513e = VelocityTracker.obtain();
        }
        this.f21513e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && this.j != null) {
                this.f21513e.computeCurrentVelocity(1000, this.f21515g);
                float xVelocity = this.f21513e.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.i);
                if (Math.abs(xVelocity) <= this.f21514f || Math.abs(rawX) <= this.f21516h) {
                    if (Math.abs(rawX) > l.k(getContext()) * 0.5d) {
                        if (rawX > 0) {
                            this.j.onTouchToRight();
                        } else {
                            this.j.onTouchToRight();
                        }
                    }
                } else if (rawX > 0) {
                    this.j.onTouchToRight();
                } else {
                    this.j.onTouchToLeft();
                }
                this.f21513e.clear();
                this.f21513e.recycle();
                this.f21513e = null;
            }
        } else {
            this.i = motionEvent.getRawX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.j = aVar;
    }

    public RecordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RecordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
