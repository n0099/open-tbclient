package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class GuideScrollView extends ScrollView {
    private a nZd;

    /* loaded from: classes.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public GuideScrollView(Context context) {
        super(context);
    }

    public GuideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.nZd != null) {
            this.nZd.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollChangedListener(a aVar) {
        this.nZd = aVar;
    }

    public a getScrollChangedListener() {
        return this.nZd;
    }
}
