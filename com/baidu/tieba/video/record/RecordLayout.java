package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class RecordLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public VelocityTracker f22151e;

    /* renamed from: f  reason: collision with root package name */
    public int f22152f;

    /* renamed from: g  reason: collision with root package name */
    public int f22153g;

    /* renamed from: h  reason: collision with root package name */
    public int f22154h;

    /* renamed from: i  reason: collision with root package name */
    public float f22155i;
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
        this.f22153g = ViewConfiguration.getMaximumFlingVelocity();
        this.f22152f = ViewConfiguration.getMinimumFlingVelocity();
        this.f22154h = l.g(getContext(), R.dimen.ds150);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22151e == null) {
            this.f22151e = VelocityTracker.obtain();
        }
        this.f22151e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && this.j != null) {
                this.f22151e.computeCurrentVelocity(1000, this.f22153g);
                float xVelocity = this.f22151e.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.f22155i);
                if (Math.abs(xVelocity) <= this.f22152f || Math.abs(rawX) <= this.f22154h) {
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
                this.f22151e.clear();
                this.f22151e.recycle();
                this.f22151e = null;
            }
        } else {
            this.f22155i = motionEvent.getRawX();
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

    public RecordLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
