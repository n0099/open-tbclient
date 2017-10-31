package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeclareItemView extends LinearLayout {
    private boolean fcl;
    private int fcm;

    public DeclareItemView(Context context) {
        super(context);
        this.fcl = false;
        this.fcm = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fcl = false;
        this.fcm = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcl = false;
        this.fcm = 0;
    }

    public void setNeedTranslate(boolean z) {
        this.fcl = z;
    }

    public void setOffSet(int i) {
        this.fcm = i;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.fcl) {
            setTranslationX(((((View) getParent()).getMeasuredWidth() - getX()) - getMeasuredWidth()) + this.fcm);
            this.fcl = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
