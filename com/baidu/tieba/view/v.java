package com.baidu.tieba.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
/* loaded from: classes.dex */
public abstract class v extends ClickableSpan {
    private boolean gaI;

    public abstract void a(TextPaint textPaint, boolean z);

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        a(textPaint, this.gaI);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
