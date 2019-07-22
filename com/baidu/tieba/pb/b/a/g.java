package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder ibP;
    private int ibQ;
    private int textSize;

    public g() {
        this.ibQ = 0;
        this.textSize = -1;
        this.ibP = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.ibQ = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.ibP = new SpannableStringBuilder();
            if (excContent != null) {
                this.ibP.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.ibQ = excContent.align.intValue();
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

    public void l(CharSequence charSequence) {
        if (charSequence != null) {
            this.ibP.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bZD() {
        return this.ibP;
    }

    public int bZF() {
        return this.ibQ;
    }

    public String bZG() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bZE() {
        return (this.ibQ > 0 && this.ibQ < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
