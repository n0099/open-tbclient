package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kbD;
    private int kbE;
    private int textSize;

    public g() {
        this.kbE = 0;
        this.textSize = -1;
        this.kbD = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kbE = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kbD = new SpannableStringBuilder();
            if (excContent != null) {
                this.kbD.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kbE = excContent.align.intValue();
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

    public void n(CharSequence charSequence) {
        if (charSequence != null) {
            this.kbD.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cKu() {
        return this.kbD;
    }

    public int cKw() {
        return this.kbE;
    }

    public String cKx() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cKv() {
        return (this.kbE > 0 && this.kbE < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
