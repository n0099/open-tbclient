package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kvq;
    private int kvr;
    private int textSize;

    public g() {
        this.kvr = 0;
        this.textSize = -1;
        this.kvq = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kvr = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kvq = new SpannableStringBuilder();
            if (excContent != null) {
                this.kvq.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kvr = excContent.align.intValue();
            }
            if (!StringUtils.isNull(excContent.color)) {
                this.color = excContent.color;
            }
            if (excContent.size != null && excContent.size.intValue() > 0 && context != null && context.getResources() != null) {
                int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
                if (identifier > 0) {
                    this.textSize = context.getResources().getDimensionPixelSize(identifier);
                }
            }
        }
    }

    public void r(CharSequence charSequence) {
        if (charSequence != null) {
            this.kvq.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cOM() {
        return this.kvq;
    }

    public int cOO() {
        return this.kvr;
    }

    public String cOP() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cON() {
        return (this.kvr > 0 && this.kvr < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
