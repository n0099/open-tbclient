package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect Rt;
    private u bRr;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Rt = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(u uVar) {
        this.bRr = uVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.Rt);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.Rt.top) - size;
        if (this.bRr != null) {
            this.bRr.dz(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
