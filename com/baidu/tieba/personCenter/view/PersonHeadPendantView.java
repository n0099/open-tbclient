package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PersonHeadPendantView extends HeadPendantView {
    private View dBD;
    private int mBorderWidth;

    public PersonHeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBorderWidth = 0;
    }

    public PersonHeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBorderWidth = 0;
    }

    public PersonHeadPendantView(Context context) {
        super(context);
        this.mBorderWidth = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void init() {
        super.init();
        this.mBorderWidth = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.dBD = new View(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        addView(this.dBD, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dBD.getLayoutParams();
        int measuredWidth = ((int) (getMeasuredWidth() * 0.13f)) - this.mBorderWidth;
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.dBD.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.dBD.setBackgroundDrawable(drawable);
    }

    public void setBorderWidth(int i) {
        getHeadView().setBorderWidth(0);
        this.mBorderWidth = i;
    }

    public void setBorderColor(int i) {
        com.baidu.tbadk.core.util.e.a.bkL().oq(1).or(i).bb(this.dBD);
    }
}
