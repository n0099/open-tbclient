package com.baidu.tieba.pb.richview.a;

import android.text.SpannableStringBuilder;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class f implements b {
    private SpannableStringBuilder bOn = new SpannableStringBuilder();

    public f() {
    }

    public f(Content content) {
        if (content != null) {
            this.bOn.append((CharSequence) content.text);
        }
    }

    public void d(CharSequence charSequence) {
        this.bOn.append(charSequence);
    }

    @Override // com.baidu.tieba.pb.richview.a.c
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.richview.a.b
    public CharSequence acw() {
        return this.bOn.toString();
    }
}
