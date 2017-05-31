package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class DeclareItemView extends LinearLayout {
    private int dof;
    private boolean eBs;

    public DeclareItemView(Context context) {
        super(context);
        this.eBs = false;
        this.dof = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eBs = false;
        this.dof = 0;
    }

    public DeclareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBs = false;
        this.dof = 0;
    }

    public void setNeedTranslate(boolean z) {
        this.eBs = z;
    }

    public void setOffSet(int i) {
        this.dof = i;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.eBs) {
            setTranslationX(((((View) getParent()).getMeasuredWidth() - getX()) - getMeasuredWidth()) + this.dof);
            this.eBs = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }
}
