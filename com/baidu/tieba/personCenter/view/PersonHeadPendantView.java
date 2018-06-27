package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PersonHeadPendantView extends HeadPendantView {
    private View fVn;

    public PersonHeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PersonHeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonHeadPendantView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void init() {
        super.init();
        this.fVn = new View(getContext());
        addView(this.fVn, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fVn.getLayoutParams();
        int measuredWidth = (int) ((getMeasuredWidth() * 0.13f) - getResources().getDimensionPixelSize(d.e.ds4));
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.fVn.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.fVn.setBackgroundDrawable(drawable);
    }
}
