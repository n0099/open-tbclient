package com.baidu.tieba.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes.dex */
public abstract class q extends ClickableSpan {
    private boolean fuK;

    public abstract void a(TextPaint textPaint, boolean z);

    public void setPressed(boolean z) {
        this.fuK = z;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.fuK);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
