package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebView;
/* loaded from: classes5.dex */
public class LightappBrowserWebView extends LightappWebView {

    /* renamed from: a  reason: collision with root package name */
    public final String f25434a;

    /* renamed from: b  reason: collision with root package name */
    public int f25435b;

    /* renamed from: c  reason: collision with root package name */
    public int f25436c;
    public boolean isTop;

    public LightappBrowserWebView(Context context) {
        super(context);
        this.f25434a = LightappBrowserWebView.class.getSimpleName();
        this.f25435b = -1;
        this.f25436c = -1;
        this.isTop = true;
    }

    private boolean a() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        int childCount = frameLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (frameLayout.getChildAt(i2) instanceof EditText) {
                return true;
            }
        }
        return false;
    }

    private boolean b() {
        return this.f25435b > 0 && this.f25436c > 0 && a();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f25435b < 0 && measuredWidth > 0) {
            this.f25435b = measuredWidth;
        }
        if (this.f25436c < 0 && measuredHeight > 10) {
            this.f25436c = measuredHeight;
        }
        String str = this.f25434a;
        LogUtil.d(str, "onMeasure current:(" + measuredWidth + "," + measuredHeight + SmallTailInfo.EMOTION_SUFFIX);
        if (b()) {
            String str2 = this.f25434a;
            LogUtil.d(str2, "onMeasure force to:(" + this.f25435b + "," + this.f25436c + SmallTailInfo.EMOTION_SUFFIX);
            setMeasuredDimension(this.f25435b, this.f25436c);
        }
    }

    @Override // com.baidu.wallet.lightapp.base.LightappWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (i3 == 0) {
            this.isTop = true;
        } else if (i3 != 0) {
            this.isTop = false;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getScrollY() <= 0) {
            scrollTo(0, 1);
        }
        return super.onTouchEvent(motionEvent);
    }
}
