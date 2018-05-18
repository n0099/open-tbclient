package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fwD;
    private int fwE;
    private int textSize;

    public g() {
        this.fwE = 0;
        this.textSize = -1;
        this.fwD = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fwE = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fwD = new SpannableStringBuilder();
            if (excContent != null) {
                this.fwD.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fwE = excContent.align.intValue();
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
            this.fwD.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bcg() {
        return this.fwD;
    }

    public int bci() {
        return this.fwE;
    }

    public String bcj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bch() {
        return (this.fwE > 0 && this.fwE < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
