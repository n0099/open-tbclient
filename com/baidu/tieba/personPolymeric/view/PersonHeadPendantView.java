package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PersonHeadPendantView extends HeadPendantView {
    private View fiw;

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
        this.fiw = new View(getContext());
        addView(this.fiw, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.HeadPendantView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ajX.setIconMargin((int) (getMeasuredWidth() * 0.13f));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fiw.getLayoutParams();
        int measuredWidth = (int) ((getMeasuredWidth() * 0.13f) - getResources().getDimensionPixelSize(d.f.ds4));
        layoutParams.leftMargin = measuredWidth;
        layoutParams.topMargin = measuredWidth;
        layoutParams.rightMargin = measuredWidth;
        layoutParams.bottomMargin = measuredWidth;
        this.fiw.setLayoutParams(layoutParams);
    }

    public void setBackgroundViewDrawable(Drawable drawable) {
        this.fiw.setBackgroundDrawable(drawable);
    }
}
