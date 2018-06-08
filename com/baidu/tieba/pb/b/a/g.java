package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fHX;
    private int fHY;
    private int textSize;

    public g() {
        this.fHY = 0;
        this.textSize = -1;
        this.fHX = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fHY = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fHX = new SpannableStringBuilder();
            if (excContent != null) {
                this.fHX.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fHY = excContent.align.intValue();
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
            this.fHX.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhg() {
        return this.fHX;
    }

    public int bhi() {
        return this.fHY;
    }

    public String bhj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhh() {
        return (this.fHY > 0 && this.fHY < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
