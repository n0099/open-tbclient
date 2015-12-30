package com.baidu.tieba.pb.c.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class g implements c {
    private SpannableStringBuilder cMr;
    private int cMs;
    private String color;
    private int textSize;

    public g() {
        this.cMs = 0;
        this.textSize = -1;
        this.cMr = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.cMs = 0;
        this.textSize = -1;
        this.cMr = new SpannableStringBuilder();
        if (excContent != null) {
            this.cMr.append((CharSequence) excContent.text);
        }
        if (excContent.align != null) {
            this.cMs = excContent.align.intValue();
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
            this.cMr.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence aog() {
        return this.cMr;
    }

    public int aoi() {
        return this.cMs;
    }

    public String aoj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean aoh() {
        return (this.cMs > 0 && this.cMs < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
