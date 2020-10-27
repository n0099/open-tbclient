package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lEt;
    private int lEu;
    private int textSize;

    public g() {
        this.lEu = 0;
        this.textSize = -1;
        this.lEt = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lEu = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lEt = new SpannableStringBuilder();
            if (excContent != null) {
                this.lEt.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lEu = excContent.align.intValue();
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
            this.lEt.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dnN() {
        return this.lEt;
    }

    public int dnP() {
        return this.lEu;
    }

    public String dnQ() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dnO() {
        return (this.lEu > 0 && this.lEu < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
