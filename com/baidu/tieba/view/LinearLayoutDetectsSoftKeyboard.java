package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect Ya;
    private p cfh;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ya = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(p pVar) {
        this.cfh = pVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.Ya);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.Ya.top) - size;
        if (this.cfh != null) {
            this.cfh.dq(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
