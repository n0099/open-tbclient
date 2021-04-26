package com.baidu.tieba.tbean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
/* loaded from: classes5.dex */
public class TBeanEditText extends EditText {
    public TBeanEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            dispatchKeyEvent(keyEvent);
            clearFocus();
            return false;
        }
        return super.onKeyPreIme(i2, keyEvent);
    }

    public TBeanEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TBeanEditText(Context context) {
        super(context);
    }
}
