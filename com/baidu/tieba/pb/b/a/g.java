package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder gjL;
    private int gjM;
    private int textSize;

    public g() {
        this.gjM = 0;
        this.textSize = -1;
        this.gjL = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.gjM = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.gjL = new SpannableStringBuilder();
            if (excContent != null) {
                this.gjL.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.gjM = excContent.align.intValue();
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

    public void g(CharSequence charSequence) {
        if (charSequence != null) {
            this.gjL.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bne() {
        return this.gjL;
    }

    public int bng() {
        return this.gjM;
    }

    public String bnh() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bnf() {
        return (this.gjM > 0 && this.gjM < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
