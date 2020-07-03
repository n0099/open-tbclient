package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class AdCriusCloseView extends AdCloseView {
    private int lkK;

    public AdCriusCloseView(Context context) {
        super(context);
        this.lkK = R.drawable.icon_home_card_delete;
    }

    public AdCriusCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lkK = R.drawable.icon_home_card_delete;
    }

    public AdCriusCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lkK = R.drawable.icon_home_card_delete;
    }

    public void resetSkin(int i) {
        if (i == 1 || i == 2) {
            this.lkK = R.drawable.ic_icon_pure_card_delete_svg;
        }
    }

    @Override // com.baidu.tieba.recapp.view.AdCloseView
    protected void init() {
        this.lky = new ImageView(getContext());
        this.lky.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds31), getContext().getResources().getDimensionPixelSize(R.dimen.tbds31));
        layoutParams.gravity = 21;
        addView(this.lky, layoutParams);
        this.mXOffset = l.getDimens(this.mContext, R.dimen.ds32);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.ds10);
        this.mWindowHeight = l.getDimens(this.mContext, R.dimen.ds278);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.eTU = l.getDimens(this.mContext, R.dimen.ds120);
        setOnClickListener(this.eTO);
        an.setImageResource(this.lky, this.lkK);
    }

    @Override // com.baidu.tieba.recapp.view.AdCloseView
    public void onChangeSkinType() {
        an.setImageResource(this.lky, this.lkK);
    }
}
