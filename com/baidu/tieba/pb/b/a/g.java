package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder hDy;
    private int hDz;
    private int textSize;

    public g() {
        this.hDz = 0;
        this.textSize = -1;
        this.hDy = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.hDz = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.hDy = new SpannableStringBuilder();
            if (excContent != null) {
                this.hDy.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.hDz = excContent.align.intValue();
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
            this.hDy.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bOR() {
        return this.hDy;
    }

    public int bOT() {
        return this.hDz;
    }

    public String bOU() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bOS() {
        return (this.hDz > 0 && this.hDz < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
