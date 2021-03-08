package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class TTScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private int f4593a;
    private boolean b;
    private a c;
    private boolean d;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.b = false;
        this.d = false;
    }

    public TTScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.d = false;
    }

    public TTScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.d = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.b) {
            try {
                this.b = true;
                View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = getHeight();
                childAt.setLayoutParams(layoutParams);
            } catch (Throwable th) {
                u.f("TTScrollView", "onLayout error" + th.toString());
            }
        }
    }

    public void setListener(a aVar) {
        this.c = aVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 1 && getScrollY() < this.f4593a) {
            if (getScrollY() > this.f4593a / 2) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView.this.smoothScrollTo(0, TTScrollView.this.f4593a);
                    }
                });
            } else if (getScrollY() > 0) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView.this.smoothScrollTo(0, 0);
                    }
                });
                z = true;
            } else if (getScrollY() == 0) {
                z = true;
            }
            if (this.c != null && z != this.d) {
                this.c.a(z);
            }
            this.d = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4593a = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView.this.smoothScrollTo(0, TTScrollView.this.f4593a);
            }
        });
    }

    public boolean a() {
        return this.d;
    }
}
