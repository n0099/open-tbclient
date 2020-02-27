package com.baidu.tieba.live.tbean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
/* loaded from: classes3.dex */
public class TBeanEditText extends EditText {
    public TBeanEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TBeanEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TBeanEditText(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            dispatchKeyEvent(keyEvent);
            clearFocus();
            return false;
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}
