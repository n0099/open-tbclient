package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    Rect aps;
    private a cPt;

    /* loaded from: classes.dex */
    public interface a {
        void dH(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aps = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.cPt = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.aps);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.aps.top) - size;
        if (this.cPt != null) {
            this.cPt.dH(height > 128);
        }
        super.onMeasure(i, i2);
    }
}
