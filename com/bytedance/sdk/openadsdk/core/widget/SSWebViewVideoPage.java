package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
/* loaded from: classes6.dex */
public class SSWebViewVideoPage extends SSWebView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f28823a;

    /* renamed from: b  reason: collision with root package name */
    public float f28824b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28825c;

    /* renamed from: d  reason: collision with root package name */
    public ViewParent f28826d;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.f28823a = true;
        this.f28824b = -1.0f;
        this.f28825c = false;
    }

    public void a(boolean z) {
        if (((ScrollView) this.f28826d).getScrollY() == 0) {
            if (z) {
                a();
            } else {
                b();
            }
        } else if (!this.f28823a) {
            a();
        } else if (z) {
            b();
        } else {
            a();
        }
    }

    public void b() {
        if (this.f28825c) {
            return;
        }
        this.f28826d.requestDisallowInterceptTouchEvent(false);
        this.f28825c = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.f28823a = true;
        } else {
            this.f28823a = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f28826d == null) {
            this.f28826d = a(this);
        }
        if (motionEvent.getAction() == 0) {
            this.f28824b = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.f28824b;
            int i = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
            if (i > 0) {
                a(true);
            } else if (i != 0 && y < 0.0f) {
                a(false);
            }
            this.f28824b = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            a();
            this.f28825c = false;
        } else if (motionEvent.getAction() == 3) {
            a();
            this.f28825c = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28823a = true;
        this.f28824b = -1.0f;
        this.f28825c = false;
    }

    public void a() {
        if (this.f28825c) {
            return;
        }
        this.f28826d.requestDisallowInterceptTouchEvent(true);
        this.f28825c = true;
    }

    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28823a = true;
        this.f28824b = -1.0f;
        this.f28825c = false;
    }

    private ViewParent a(View view) {
        ViewParent parent = view.getParent();
        return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
    }
}
