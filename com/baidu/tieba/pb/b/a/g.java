package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes22.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lKH;
    private int lKI;
    private int textSize;

    public g() {
        this.lKI = 0;
        this.textSize = -1;
        this.lKH = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lKI = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lKH = new SpannableStringBuilder();
            if (excContent != null) {
                this.lKH.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lKI = excContent.align.intValue();
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

    public void s(CharSequence charSequence) {
        if (charSequence != null) {
            this.lKH.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dpP() {
        return this.lKH;
    }

    public int dpR() {
        return this.lKI;
    }

    public String dpS() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dpQ() {
        return (this.lKI > 0 && this.lKI < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
