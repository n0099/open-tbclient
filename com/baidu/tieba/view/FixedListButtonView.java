package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class FixedListButtonView extends ImageView {
    public FixedListButtonView(Context context) {
        super(context);
    }

    public FixedListButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedListButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z) {
            return;
        }
        super.setPressed(z);
    }
}
