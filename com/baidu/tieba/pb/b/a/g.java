package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder gbb;
    private int gbc;
    private int textSize;

    public g() {
        this.gbc = 0;
        this.textSize = -1;
        this.gbb = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.gbc = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.gbb = new SpannableStringBuilder();
            if (excContent != null) {
                this.gbb.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.gbc = excContent.align.intValue();
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

    public void t(CharSequence charSequence) {
        if (charSequence != null) {
            this.gbb.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhf() {
        return this.gbb;
    }

    public int bhh() {
        return this.gbc;
    }

    public String bhi() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhg() {
        return (this.gbc > 0 && this.gbc < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
