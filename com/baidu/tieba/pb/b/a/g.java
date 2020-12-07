package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lYF;
    private int lYG;
    private int textSize;

    public g() {
        this.lYG = 0;
        this.textSize = -1;
        this.lYF = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lYG = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lYF = new SpannableStringBuilder();
            if (excContent != null) {
                this.lYF.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lYG = excContent.align.intValue();
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
            this.lYF.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dvi() {
        return this.lYF;
    }

    public int dvk() {
        return this.lYG;
    }

    public String dvl() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dvj() {
        return (this.lYG > 0 && this.lYG < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
