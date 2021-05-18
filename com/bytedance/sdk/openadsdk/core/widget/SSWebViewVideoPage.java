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
    public boolean f28635a;

    /* renamed from: b  reason: collision with root package name */
    public float f28636b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28637c;

    /* renamed from: d  reason: collision with root package name */
    public ViewParent f28638d;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.f28635a = true;
        this.f28636b = -1.0f;
        this.f28637c = false;
    }

    public void a(boolean z) {
        if (((ScrollView) this.f28638d).getScrollY() == 0) {
            if (z) {
                a();
            } else {
                b();
            }
        } else if (!this.f28635a) {
            a();
        } else if (z) {
            b();
        } else {
            a();
        }
    }

    public void b() {
        if (this.f28637c) {
            return;
        }
        this.f28638d.requestDisallowInterceptTouchEvent(false);
        this.f28637c = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
        if (i3 == 0 && z2) {
            this.f28635a = true;
        } else {
            this.f28635a = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f28638d == null) {
            this.f28638d = a(this);
        }
        if (motionEvent.getAction() == 0) {
            this.f28636b = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.f28636b;
            int i2 = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
            if (i2 > 0) {
                a(true);
            } else if (i2 != 0 && y < 0.0f) {
                a(false);
            }
            this.f28636b = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            a();
            this.f28637c = false;
        } else if (motionEvent.getAction() == 3) {
            a();
            this.f28637c = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28635a = true;
        this.f28636b = -1.0f;
        this.f28637c = false;
    }

    public void a() {
        if (this.f28637c) {
            return;
        }
        this.f28638d.requestDisallowInterceptTouchEvent(true);
        this.f28637c = true;
    }

    public SSWebViewVideoPage(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28635a = true;
        this.f28636b = -1.0f;
        this.f28637c = false;
    }

    private ViewParent a(View view) {
        ViewParent parent = view.getParent();
        return ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof ScrollingView) || !(parent instanceof View)) ? parent : a((View) parent);
    }
}
