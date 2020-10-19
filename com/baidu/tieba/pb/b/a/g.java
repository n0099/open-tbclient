package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lrU;
    private int lrV;
    private int textSize;

    public g() {
        this.lrV = 0;
        this.textSize = -1;
        this.lrU = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lrV = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lrU = new SpannableStringBuilder();
            if (excContent != null) {
                this.lrU.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lrV = excContent.align.intValue();
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
            this.lrU.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dkF() {
        return this.lrU;
    }

    public int dkH() {
        return this.lrV;
    }

    public String dkI() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dkG() {
        return (this.lrV > 0 && this.lrV < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
