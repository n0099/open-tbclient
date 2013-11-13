package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
/* loaded from: classes.dex */
public class SquareHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private av f2367a;
    private Runnable b;

    public SquareHorizontalScrollView(Context context) {
        super(context);
        this.b = new au(this);
    }

    public SquareHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new au(this);
    }

    public SquareHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new au(this);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        removeCallbacks(this.b);
        postDelayed(this.b, 100L);
        if (this.f2367a != null) {
            this.f2367a.a(this);
        }
    }

    public av getOnScrollListener() {
        return this.f2367a;
    }

    public void setOnScrollListener(av avVar) {
        this.f2367a = avVar;
    }
}
