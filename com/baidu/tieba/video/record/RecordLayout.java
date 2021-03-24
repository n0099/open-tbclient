package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class RecordLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f21827e;

    /* renamed from: f  reason: collision with root package name */
    public int f21828f;

    /* renamed from: g  reason: collision with root package name */
    public int f21829g;

    /* renamed from: h  reason: collision with root package name */
    public int f21830h;
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
        this.f21829g = ViewConfiguration.getMaximumFlingVelocity();
        this.f21828f = ViewConfiguration.getMinimumFlingVelocity();
        this.f21830h = l.g(getContext(), R.dimen.ds150);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f21827e == null) {
            this.f21827e = VelocityTracker.obtain();
        }
        this.f21827e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && this.j != null) {
                this.f21827e.computeCurrentVelocity(1000, this.f21829g);
                float xVelocity = this.f21827e.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.i);
                if (Math.abs(xVelocity) <= this.f21828f || Math.abs(rawX) <= this.f21830h) {
                    double abs = Math.abs(rawX);
                    double k = l.k(getContext());
                    Double.isNaN(k);
                    if (abs > k * 0.5d) {
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
                this.f21827e.clear();
                this.f21827e.recycle();
                this.f21827e = null;
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
