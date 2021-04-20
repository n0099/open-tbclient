package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes5.dex */
public class GuideScrollView extends ScrollView {

    /* renamed from: e  reason: collision with root package name */
    public a f21805e;

    /* loaded from: classes5.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public GuideScrollView(Context context) {
        super(context);
    }

    public a getScrollChangedListener() {
        return this.f21805e;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f21805e;
        if (aVar != null) {
            aVar.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollChangedListener(a aVar) {
        this.f21805e = aVar;
    }

    public GuideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
