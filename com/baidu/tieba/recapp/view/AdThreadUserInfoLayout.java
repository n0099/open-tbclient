package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
/* loaded from: classes13.dex */
public class AdThreadUserInfoLayout extends CardUserInfoLayout {
    private AfterAdjustChildWidthListener kQa;

    /* loaded from: classes13.dex */
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
            this.agE.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            view.setLayoutParams(layoutParams);
            this.agE.addView(view);
        }
    }

    public HeadPendantClickableView getHeaderImg() {
        return getAvatar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.view.CardUserInfoLayout
    public void rX() {
        super.rX();
        if (this.kQa != null) {
            this.kQa.afterChildWidth();
        }
    }

    public void setAfterAdjustChildWidthListener(AfterAdjustChildWidthListener afterAdjustChildWidthListener) {
        this.kQa = afterAdjustChildWidthListener;
    }
}
