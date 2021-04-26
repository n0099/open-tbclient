package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
/* loaded from: classes5.dex */
public class AdThreadUserInfoLayout extends CardUserInfoLayout {
    public AfterAdjustChildWidthListener J;

    /* loaded from: classes5.dex */
    public interface AfterAdjustChildWidthListener {
        void afterChildWidth();
    }

    public AdThreadUserInfoLayout(Context context) {
        super(context);
    }

    public void addAdTagView(View view) {
        if (view == null) {
            return;
        }
        this.q.removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        view.setLayoutParams(layoutParams);
        this.q.addView(view);
    }

    @Override // com.baidu.card.view.CardUserInfoLayout
    public void f() {
        super.f();
        AfterAdjustChildWidthListener afterAdjustChildWidthListener = this.J;
        if (afterAdjustChildWidthListener != null) {
            afterAdjustChildWidthListener.afterChildWidth();
        }
    }

    public HeadPendantClickableView getHeaderImg() {
        return getAvatar();
    }

    public void setAfterAdjustChildWidthListener(AfterAdjustChildWidthListener afterAdjustChildWidthListener) {
        this.J = afterAdjustChildWidthListener;
    }

    public AdThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
