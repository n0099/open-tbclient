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
    public int f28701a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28702b;

    /* renamed from: c  reason: collision with root package name */
    public a f28703c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28704d;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.f28702b = false;
        this.f28704d = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f28702b) {
            return;
        }
        try {
            this.f28702b = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            u.f("TTScrollView", "onLayout error" + th.toString());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f28701a = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.f28701a);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (getScrollY() == 0) goto L9;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.f28701a) {
            if (getScrollY() > this.f28701a / 2) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.f28701a);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTScrollView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                }
                aVar = this.f28703c;
                if (aVar != null && z != this.f28704d) {
                    aVar.a(z);
                }
                this.f28704d = z;
            }
            z = false;
            aVar = this.f28703c;
            if (aVar != null) {
                aVar.a(z);
            }
            this.f28704d = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.f28703c = aVar;
    }

    public boolean a() {
        return this.f28704d;
    }

    public TTScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28702b = false;
        this.f28704d = false;
    }

    public TTScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28702b = false;
        this.f28704d = false;
    }
}
