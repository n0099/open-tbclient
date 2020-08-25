package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kTS;
    private int kTT;
    private int textSize;

    public g() {
        this.kTT = 0;
        this.textSize = -1;
        this.kTS = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kTT = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kTS = new SpannableStringBuilder();
            if (excContent != null) {
                this.kTS.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kTT = excContent.align.intValue();
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
            this.kTS.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence ddr() {
        return this.kTS;
    }

    public int ddt() {
        return this.kTT;
    }

    public String ddu() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dds() {
        return (this.kTT > 0 && this.kTT < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
