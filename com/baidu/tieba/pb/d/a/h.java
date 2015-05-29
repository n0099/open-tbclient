package com.baidu.tieba.pb.d.a;

import android.text.SpannableStringBuilder;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class h implements d {
    private SpannableStringBuilder bQH = new SpannableStringBuilder();

    public h() {
    }

    public h(Content content) {
        if (content != null) {
            this.bQH.append((CharSequence) content.text);
        }
    }

    public void d(CharSequence charSequence) {
        if (charSequence != null) {
            this.bQH.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.d.a.e
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public CharSequence adM() {
        return this.bQH;
    }
}
