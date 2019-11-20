package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder icC;
    private int icD;
    private int textSize;

    public g() {
        this.icD = 0;
        this.textSize = -1;
        this.icC = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.icD = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.icC = new SpannableStringBuilder();
            if (excContent != null) {
                this.icC.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.icD = excContent.align.intValue();
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

    public void j(CharSequence charSequence) {
        if (charSequence != null) {
            this.icC.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bXJ() {
        return this.icC;
    }

    public int bXL() {
        return this.icD;
    }

    public String bXM() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bXK() {
        return (this.icD > 0 && this.icD < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
