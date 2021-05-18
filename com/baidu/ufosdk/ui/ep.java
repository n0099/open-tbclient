package com.baidu.ufosdk.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes5.dex */
public final class ep extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public int f22878a = -11821318;

    /* renamed from: b  reason: collision with root package name */
    public String f22879b;

    /* renamed from: c  reason: collision with root package name */
    public eq f22880c;

    public ep(String str, eq eqVar) {
        this.f22879b = str;
        this.f22880c = eqVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("text clicked!!!" + this.f22879b);
        eq eqVar = this.f22880c;
        if (eqVar != null) {
            eqVar.a(this.f22879b);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f22878a);
    }
}
