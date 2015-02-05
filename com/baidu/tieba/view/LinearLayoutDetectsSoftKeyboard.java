package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect XX;
    private p cfg;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XX = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(p pVar) {
        this.cfg = pVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.XX);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.XX.top) - size;
        if (this.cfg != null) {
            this.cfg.dq(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
