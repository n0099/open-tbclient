package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AdThreadUserInfoLayout extends CardUserInfoLayout {
    private RelativeLayout inH;
    private AfterAdjustChildWidthListener inI;

    /* loaded from: classes3.dex */
    public interface AfterAdjustChildWidthListener {
        void afterChildWidth();
    }

    public AdThreadUserInfoLayout(Context context) {
        super(context);
        init();
    }

    public AdThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.inH = (RelativeLayout) findViewById(d.g.suffix_container);
    }

    public void addAdTagView(View view) {
        if (view != null) {
            this.inH.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            view.setLayoutParams(layoutParams);
            this.inH.addView(view);
        }
    }

    public HeadPendantClickableView getHeaderImg() {
        return getAvatar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.card.view.CardUserInfoLayout
    public void rH() {
        super.rH();
        if (this.inI != null) {
            this.inI.afterChildWidth();
        }
    }

    public void setAfterAdjustChildWidthListener(AfterAdjustChildWidthListener afterAdjustChildWidthListener) {
        this.inI = afterAdjustChildWidthListener;
    }
}
