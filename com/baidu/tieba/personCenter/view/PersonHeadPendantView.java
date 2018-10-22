package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class PersonHeadPendantView extends HeadPendantView {
    private View gks;

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
        this.gks = new View(getContext());
        addView(this.gks, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gks.getLayoutParams();
        int measuredWidth = (int) ((getMeasuredWidth() * 0.13f) - getResources().getDimensionPixelSize(e.C0175e.ds4));
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.gks.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.gks.setBackgroundDrawable(drawable);
    }
}
