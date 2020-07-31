package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kEj;
    private int kEk;
    private int textSize;

    public g() {
        this.kEk = 0;
        this.textSize = -1;
        this.kEj = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kEk = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kEj = new SpannableStringBuilder();
            if (excContent != null) {
                this.kEj.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kEk = excContent.align.intValue();
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
            this.kEj.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cSz() {
        return this.kEj;
    }

    public int cSB() {
        return this.kEk;
    }

    public String cSC() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cSA() {
        return (this.kEk > 0 && this.kEk < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
