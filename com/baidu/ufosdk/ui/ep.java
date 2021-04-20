package com.baidu.ufosdk.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes5.dex */
public final class ep extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public int f22914a = -11821318;

    /* renamed from: b  reason: collision with root package name */
    public String f22915b;

    /* renamed from: c  reason: collision with root package name */
    public eq f22916c;

    public ep(String str, eq eqVar) {
        this.f22915b = str;
        this.f22916c = eqVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        com.baidu.ufosdk.f.c.a("text clicked!!!" + this.f22915b);
        eq eqVar = this.f22916c;
        if (eqVar != null) {
            eqVar.a(this.f22915b);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f22914a);
    }
}
