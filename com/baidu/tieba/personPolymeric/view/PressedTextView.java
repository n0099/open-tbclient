package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes18.dex */
public class PressedTextView extends TextView {
    public PressedTextView(Context context) {
        super(context);
    }

    public PressedTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PressedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        if (z) {
            setAlpha(0.5f);
        } else {
            setAlpha(1.0f);
        }
    }
}
