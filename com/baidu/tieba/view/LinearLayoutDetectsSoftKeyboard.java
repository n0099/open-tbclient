package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect aia;
    private e ctl;

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aia = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(e eVar) {
        this.ctl = eVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.aia);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.aia.top) - size;
        if (this.ctl != null) {
            this.ctl.dt(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
