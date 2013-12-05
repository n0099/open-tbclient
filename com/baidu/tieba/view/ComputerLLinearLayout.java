package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ComputerLLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f2626a;

    public int getChildLeft() {
        return this.f2626a;
    }

    public ComputerLLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ComputerLLinearLayout(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getChildAt(1) instanceof ImageView) {
            this.f2626a = ((ImageView) getChildAt(1)).getLeft();
        }
    }
}
