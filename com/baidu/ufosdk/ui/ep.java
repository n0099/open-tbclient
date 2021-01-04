package com.baidu.ufosdk.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes8.dex */
public final class ep extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private int f5854a = -11821318;

    /* renamed from: b  reason: collision with root package name */
    private String f5855b;
    private eq c;

    public ep(String str, eq eqVar) {
        this.f5855b = str;
        this.c = eqVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("text clicked!!!" + this.f5855b);
        if (this.c != null) {
            this.c.a(this.f5855b);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f5854a);
    }
}
