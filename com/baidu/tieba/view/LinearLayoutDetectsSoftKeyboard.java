package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect Xu;
    private k cdI;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xu = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(k kVar) {
        this.cdI = kVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.Xu);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.Xu.top) - size;
        if (this.cdI != null) {
            this.cdI.dk(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
