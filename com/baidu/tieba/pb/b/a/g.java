package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder icM;
    private int icN;
    private int textSize;

    public g() {
        this.icN = 0;
        this.textSize = -1;
        this.icM = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.icN = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.icM = new SpannableStringBuilder();
            if (excContent != null) {
                this.icM.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.icN = excContent.align.intValue();
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
            this.icM.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bZU() {
        return this.icM;
    }

    public int bZW() {
        return this.icN;
    }

    public String bZX() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bZV() {
        return (this.icN > 0 && this.icN < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
