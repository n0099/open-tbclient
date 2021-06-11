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
    public final String f24711a;

    /* renamed from: b  reason: collision with root package name */
    public int f24712b;

    /* renamed from: c  reason: collision with root package name */
    public int f24713c;
    public boolean isTop;

    public LightappBrowserWebView(Context context) {
        super(context);
        this.f24711a = LightappBrowserWebView.class.getSimpleName();
        this.f24712b = -1;
        this.f24713c = -1;
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
        return this.f24712b > 0 && this.f24713c > 0 && a();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f24712b < 0 && measuredWidth > 0) {
            this.f24712b = measuredWidth;
        }
        if (this.f24713c < 0 && measuredHeight > 10) {
            this.f24713c = measuredHeight;
        }
        String str = this.f24711a;
        LogUtil.d(str, "onMeasure current:(" + measuredWidth + "," + measuredHeight + SmallTailInfo.EMOTION_SUFFIX);
        if (b()) {
            String str2 = this.f24711a;
            LogUtil.d(str2, "onMeasure force to:(" + this.f24712b + "," + this.f24713c + SmallTailInfo.EMOTION_SUFFIX);
            setMeasuredDimension(this.f24712b, this.f24713c);
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
