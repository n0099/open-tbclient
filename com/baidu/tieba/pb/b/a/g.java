package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder hDL;
    private int hDM;
    private int textSize;

    public g() {
        this.hDM = 0;
        this.textSize = -1;
        this.hDL = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.hDM = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.hDL = new SpannableStringBuilder();
            if (excContent != null) {
                this.hDL.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.hDM = excContent.align.intValue();
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
            this.hDL.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bOU() {
        return this.hDL;
    }

    public int bOW() {
        return this.hDM;
    }

    public String bOX() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bOV() {
        return (this.hDM > 0 && this.hDM < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
