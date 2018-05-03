package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder fvx;
    private int fvy;
    private int textSize;

    public g() {
        this.fvy = 0;
        this.textSize = -1;
        this.fvx = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.fvy = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.fvx = new SpannableStringBuilder();
            if (excContent != null) {
                this.fvx.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.fvy = excContent.align.intValue();
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
            this.fvx.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bcg() {
        return this.fvx;
    }

    public int bci() {
        return this.fvy;
    }

    public String bcj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bch() {
        return (this.fvy > 0 && this.fvy < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
