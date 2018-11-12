package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder gcT;
    private int gcU;
    private int textSize;

    public g() {
        this.gcU = 0;
        this.textSize = -1;
        this.gcT = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.gcU = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.gcT = new SpannableStringBuilder();
            if (excContent != null) {
                this.gcT.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.gcU = excContent.align.intValue();
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

    public void g(CharSequence charSequence) {
        if (charSequence != null) {
            this.gcT.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bll() {
        return this.gcT;
    }

    public int bln() {
        return this.gcU;
    }

    public String blo() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean blm() {
        return (this.gcU > 0 && this.gcU < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
