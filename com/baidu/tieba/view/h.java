package com.baidu.tieba.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes.dex */
public abstract class h extends ClickableSpan {
    private boolean hos;

    public abstract void a(TextPaint textPaint, boolean z);

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.hos);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
