package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder jIM;
    private int jIN;
    private int textSize;

    public g() {
        this.jIN = 0;
        this.textSize = -1;
        this.jIM = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.jIN = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.jIM = new SpannableStringBuilder();
            if (excContent != null) {
                this.jIM.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.jIN = excContent.align.intValue();
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

    public void m(CharSequence charSequence) {
        if (charSequence != null) {
            this.jIM.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cDf() {
        return this.jIM;
    }

    public int cDh() {
        return this.jIN;
    }

    public String cDi() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cDg() {
        return (this.jIN > 0 && this.jIN < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
