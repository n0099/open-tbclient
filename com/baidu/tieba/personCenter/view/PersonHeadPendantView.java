package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PersonHeadPendantView extends HeadPendantView {
    public int q;
    public View r;

    public PersonHeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = 0;
    }

    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void d() {
        super.d();
        this.q = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.r = new View(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        addView(this.r, 0, layoutParams);
    }

    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        int measuredWidth = ((int) (getMeasuredWidth() * 0.13f)) - this.q;
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.r.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.r.setBackgroundDrawable(drawable);
    }

    public void setBorderColor(int i) {
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(i).into(this.r);
    }

    public void setBorderWidth(int i) {
        getHeadView().setBorderWidth(0);
        this.q = i;
    }

    public PersonHeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = 0;
    }

    public PersonHeadPendantView(Context context) {
        super(context);
        this.q = 0;
    }
}
