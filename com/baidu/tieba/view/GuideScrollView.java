package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes5.dex */
public class GuideScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public a f21826e;

    /* loaded from: classes5.dex */
    public interface a {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    public GuideScrollView(Context context) {
        super(context);
    }

    public a getScrollChangedListener() {
        return this.f21826e;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f21826e;
        if (aVar != null) {
            aVar.onScrollChanged(i2, i3, i4, i5);
        }
    }

    public void setScrollChangedListener(a aVar) {
        this.f21826e = aVar;
    }

    public GuideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
