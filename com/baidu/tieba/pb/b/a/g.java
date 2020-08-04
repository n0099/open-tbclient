package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kEl;
    private int kEm;
    private int textSize;

    public g() {
        this.kEm = 0;
        this.textSize = -1;
        this.kEl = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kEm = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kEl = new SpannableStringBuilder();
            if (excContent != null) {
                this.kEl.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kEm = excContent.align.intValue();
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
            this.kEl.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cSz() {
        return this.kEl;
    }

    public int cSB() {
        return this.kEm;
    }

    public String cSC() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cSA() {
        return (this.kEm > 0 && this.kEm < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
