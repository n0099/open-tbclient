package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect a;
    private t b;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(t tVar) {
        this.b = tVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.a);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.a.top) - size;
        if (this.b != null) {
            this.b.a(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
