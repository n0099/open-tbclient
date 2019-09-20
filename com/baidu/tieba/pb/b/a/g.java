package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder ieO;
    private int ieP;
    private int textSize;

    public g() {
        this.ieP = 0;
        this.textSize = -1;
        this.ieO = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.ieP = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.ieO = new SpannableStringBuilder();
            if (excContent != null) {
                this.ieO.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.ieP = excContent.align.intValue();
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

    public void l(CharSequence charSequence) {
        if (charSequence != null) {
            this.ieO.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence caI() {
        return this.ieO;
    }

    public int caK() {
        return this.ieP;
    }

    public String caL() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean caJ() {
        return (this.ieP > 0 && this.ieP < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
