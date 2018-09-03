package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fMg;
    private int fMh;
    private int textSize;

    public g() {
        this.fMh = 0;
        this.textSize = -1;
        this.fMg = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fMh = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fMg = new SpannableStringBuilder();
            if (excContent != null) {
                this.fMg.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fMh = excContent.align.intValue();
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

    public void g(CharSequence charSequence) {
        if (charSequence != null) {
            this.fMg.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bga() {
        return this.fMg;
    }

    public int bgc() {
        return this.fMh;
    }

    public String bgd() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bgb() {
        return (this.fMh > 0 && this.fMh < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
