package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder hVB;
    private int hVC;
    private int textSize;

    public g() {
        this.hVC = 0;
        this.textSize = -1;
        this.hVB = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.hVC = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.hVB = new SpannableStringBuilder();
            if (excContent != null) {
                this.hVB.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.hVC = excContent.align.intValue();
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
            this.hVB.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bWN() {
        return this.hVB;
    }

    public int bWP() {
        return this.hVC;
    }

    public String bWQ() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bWO() {
        return (this.hVC > 0 && this.hVC < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
