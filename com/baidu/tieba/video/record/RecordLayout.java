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
    public VelocityTracker f21828e;

    /* renamed from: f  reason: collision with root package name */
    public int f21829f;

    /* renamed from: g  reason: collision with root package name */
    public int f21830g;

    /* renamed from: h  reason: collision with root package name */
    public int f21831h;
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
        this.f21830g = ViewConfiguration.getMaximumFlingVelocity();
        this.f21829f = ViewConfiguration.getMinimumFlingVelocity();
        this.f21831h = l.g(getContext(), R.dimen.ds150);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f21828e == null) {
            this.f21828e = VelocityTracker.obtain();
        }
        this.f21828e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && this.j != null) {
                this.f21828e.computeCurrentVelocity(1000, this.f21830g);
                float xVelocity = this.f21828e.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.i);
                if (Math.abs(xVelocity) <= this.f21829f || Math.abs(rawX) <= this.f21831h) {
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
                this.f21828e.clear();
                this.f21828e.recycle();
                this.f21828e = null;
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
