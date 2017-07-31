package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeclareItemView extends LinearLayout {
    private int dFT;
    private boolean eYD;

    public DeclareItemView(Context context) {
        super(context);
        this.eYD = false;
        this.dFT = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYD = false;
        this.dFT = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYD = false;
        this.dFT = 0;
    }

    public void setNeedTranslate(boolean z) {
        this.eYD = z;
    }

    public void setOffSet(int i) {
        this.dFT = i;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eYD) {
            setTranslationX(((((View) getParent()).getMeasuredWidth() - getX()) - getMeasuredWidth()) + this.dFT);
            this.eYD = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
