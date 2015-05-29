package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect aji;
    private d cxT;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aji = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(d dVar) {
        this.cxT = dVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.aji);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.aji.top) - size;
        if (this.cxT != null) {
            this.cxT.dC(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
