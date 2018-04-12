package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fvA;
    private int fvB;
    private int textSize;

    public g() {
        this.fvB = 0;
        this.textSize = -1;
        this.fvA = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fvB = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fvA = new SpannableStringBuilder();
            if (excContent != null) {
                this.fvA.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fvB = excContent.align.intValue();
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

    public void k(CharSequence charSequence) {
        if (charSequence != null) {
            this.fvA.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bcg() {
        return this.fvA;
    }

    public int bci() {
        return this.fvB;
    }

    public String bcj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bch() {
        return (this.fvB > 0 && this.fvB < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
