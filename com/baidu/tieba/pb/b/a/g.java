package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes22.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lcD;
    private int lcE;
    private int textSize;

    public g() {
        this.lcE = 0;
        this.textSize = -1;
        this.lcD = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lcE = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lcD = new SpannableStringBuilder();
            if (excContent != null) {
                this.lcD.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lcE = excContent.align.intValue();
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

    public void q(CharSequence charSequence) {
        if (charSequence != null) {
            this.lcD.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dgW() {
        return this.lcD;
    }

    public int dgY() {
        return this.lcE;
    }

    public String dgZ() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dgX() {
        return (this.lcE > 0 && this.lcE < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
