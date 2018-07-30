package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fMn;
    private int fMo;
    private int textSize;

    public g() {
        this.fMo = 0;
        this.textSize = -1;
        this.fMn = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fMo = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fMn = new SpannableStringBuilder();
            if (excContent != null) {
                this.fMn.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fMo = excContent.align.intValue();
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
            this.fMn.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bgf() {
        return this.fMn;
    }

    public int bgh() {
        return this.fMo;
    }

    public String bgi() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bgg() {
        return (this.fMo > 0 && this.fMo < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
