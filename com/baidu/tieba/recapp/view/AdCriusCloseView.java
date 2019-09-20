package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class AdCriusCloseView extends AdCloseView {
    public AdCriusCloseView(Context context) {
        super(context);
    }

    public AdCriusCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdCriusCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.recapp.view.AdCloseView
    protected void init() {
        this.dJd = new ImageView(getContext());
        this.dJd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds31), getContext().getResources().getDimensionPixelSize(R.dimen.tbds31));
        layoutParams.gravity = 21;
        addView(this.dJd, layoutParams);
        this.mXOffset = l.g(this.mContext, R.dimen.ds32);
        this.mYOffset = l.g(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.g(this.mContext, R.dimen.ds278);
        this.cTz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cTB = l.g(this.mContext, R.dimen.ds120);
        setOnClickListener(this.cTv);
        am.c(this.dJd, (int) R.drawable.icon_home_card_delete);
        aBE();
    }

    @Override // com.baidu.tieba.recapp.view.AdCloseView
    public void onChangeSkinType() {
        am.c(this.dJd, (int) R.drawable.icon_home_card_delete);
    }
}
