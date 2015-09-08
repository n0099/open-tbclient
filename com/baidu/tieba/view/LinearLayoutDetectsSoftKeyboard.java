package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect arc;
    private a cYd;

    /* loaded from: classes.dex */
    public interface a {
        void dM(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arc = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.cYd = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.arc);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.arc.top) - size;
        if (this.cYd != null) {
            this.cYd.dM(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
