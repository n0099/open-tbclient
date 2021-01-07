package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
/* loaded from: classes8.dex */
public class AdThreadUserInfoLayout extends CardUserInfoLayout {
    private AfterAdjustChildWidthListener mTR;

    /* loaded from: classes8.dex */
    public interface AfterAdjustChildWidthListener {
        void afterChildWidth();
    }

    public AdThreadUserInfoLayout(Context context) {
        super(context);
    }

    public AdThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addAdTagView(View view) {
        if (view != null) {
            this.ali.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            view.setLayoutParams(layoutParams);
            this.ali.addView(view);
        }
    }

    public HeadPendantClickableView getHeaderImg() {
        return getAvatar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.view.CardUserInfoLayout
    public void tP() {
        super.tP();
        if (this.mTR != null) {
            this.mTR.afterChildWidth();
        }
    }

    public void setAfterAdjustChildWidthListener(AfterAdjustChildWidthListener afterAdjustChildWidthListener) {
        this.mTR = afterAdjustChildWidthListener;
    }
}
