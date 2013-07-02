package com.baidu.tieba.nearby;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
class ag extends ClickableSpan {
    final /* synthetic */ ae a;
    private String b;
    private String c;

    public ag(ae aeVar, String str, String str2) {
        this.a = aeVar;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(-9989158);
        textPaint.setUnderlineText(false);
        textPaint.setFakeBoldText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Context context;
        if (this.b != null && this.c != null) {
            context = this.a.a;
            PersonInfoActivity.a(context, this.c, this.b);
        }
    }
}
