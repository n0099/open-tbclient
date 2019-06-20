package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PersonHeadPendantView extends HeadPendantView {
    private View bML;

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
        this.bML = new View(getContext());
        addView(this.bML, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bML.getLayoutParams();
        int measuredWidth = (int) ((getMeasuredWidth() * 0.13f) - getResources().getDimensionPixelSize(R.dimen.ds4));
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.bML.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.bML.setBackgroundDrawable(drawable);
    }
}
