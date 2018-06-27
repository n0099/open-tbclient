package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fLZ;
    private int fMa;
    private int textSize;

    public g() {
        this.fMa = 0;
        this.textSize = -1;
        this.fLZ = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fMa = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fLZ = new SpannableStringBuilder();
            if (excContent != null) {
                this.fLZ.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fMa = excContent.align.intValue();
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
            this.fLZ.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhM() {
        return this.fLZ;
    }

    public int bhO() {
        return this.fMa;
    }

    public String bhP() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhN() {
        return (this.fMa > 0 && this.fMa < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
