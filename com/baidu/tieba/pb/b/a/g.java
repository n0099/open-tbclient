package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fTW;
    private int fTX;
    private int textSize;

    public g() {
        this.fTX = 0;
        this.textSize = -1;
        this.fTW = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fTX = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fTW = new SpannableStringBuilder();
            if (excContent != null) {
                this.fTW.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fTX = excContent.align.intValue();
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
            this.fTW.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence biD() {
        return this.fTW;
    }

    public int biF() {
        return this.fTX;
    }

    public String biG() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean biE() {
        return (this.fTX > 0 && this.fTX < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
