package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class FixedListButtonView extends ImageView {
    public FixedListButtonView(Context ctx) {
        super(ctx);
    }

    public FixedListButtonView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    public FixedListButtonView(Context ctx, AttributeSet attrs, int defStyle) {
        super(ctx, attrs, defStyle);
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        if (!pressed) {
            super.setPressed(pressed);
        }
    }
}
