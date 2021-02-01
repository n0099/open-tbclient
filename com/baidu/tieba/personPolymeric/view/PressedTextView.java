package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
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
