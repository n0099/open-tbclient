package com.baidu.tieba.pb.richview.a;

import android.text.SpannableStringBuilder;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class f implements b {
    private SpannableStringBuilder bOD = new SpannableStringBuilder();

    public f() {
    }

    public f(Content content) {
        if (content != null) {
            this.bOD.append((CharSequence) content.text);
        }
    }

    public void d(CharSequence charSequence) {
        this.bOD.append(charSequence);
    }

    @Override // com.baidu.tieba.pb.richview.a.c
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.richview.a.b
    public CharSequence acL() {
        return this.bOD.toString();
    }
}
