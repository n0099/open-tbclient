package com.baidu.tieba.pb.d.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class g implements c {
    private SpannableStringBuilder cVf;
    private int cVg;
    private String color;
    private int textSize;

    public g() {
        this.cVg = 0;
        this.textSize = -1;
        this.cVf = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.cVg = 0;
        this.textSize = -1;
        this.cVf = new SpannableStringBuilder();
        if (excContent != null) {
            this.cVf.append((CharSequence) excContent.text);
        }
        if (excContent.align != null) {
            this.cVg = excContent.align.intValue();
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

    public void f(CharSequence charSequence) {
        if (charSequence != null) {
            this.cVf.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public CharSequence asP() {
        return this.cVf;
    }

    public int asR() {
        return this.cVg;
    }

    public String asS() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public boolean asQ() {
        return (this.cVg > 0 && this.cVg < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
