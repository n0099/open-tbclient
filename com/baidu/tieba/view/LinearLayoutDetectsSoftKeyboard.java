package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect Rx;
    private u bRG;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rx = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(u uVar) {
        this.bRG = uVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.Rx);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.Rx.top) - size;
        if (this.bRG != null) {
            this.bRG.dz(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
