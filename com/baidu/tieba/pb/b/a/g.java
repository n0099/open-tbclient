package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class g implements c {
    private int aLo;
    private String color;
    private SpannableStringBuilder mkN;
    private int textSize;

    public g() {
        this.aLo = 0;
        this.textSize = -1;
        this.mkN = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.aLo = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.mkN = new SpannableStringBuilder();
            if (excContent != null) {
                this.mkN.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.aLo = excContent.align.intValue();
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

    public void t(CharSequence charSequence) {
        if (charSequence != null) {
            this.mkN.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dtM() {
        return this.mkN;
    }

    public int dtO() {
        return this.aLo;
    }

    public String Bv() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dtN() {
        return (this.aLo > 0 && this.aLo < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
