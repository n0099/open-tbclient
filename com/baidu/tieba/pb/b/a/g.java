package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kax;
    private int kay;
    private int textSize;

    public g() {
        this.kay = 0;
        this.textSize = -1;
        this.kax = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kay = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kax = new SpannableStringBuilder();
            if (excContent != null) {
                this.kax.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kay = excContent.align.intValue();
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
            this.kax.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cKe() {
        return this.kax;
    }

    public int cKg() {
        return this.kay;
    }

    public String cKh() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cKf() {
        return (this.kay > 0 && this.kay < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
