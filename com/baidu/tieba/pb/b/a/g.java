package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder lZo;
    private int lZp;
    private int textSize;

    public g() {
        this.lZp = 0;
        this.textSize = -1;
        this.lZo = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.lZp = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.lZo = new SpannableStringBuilder();
            if (excContent != null) {
                this.lZo.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.lZp = excContent.align.intValue();
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
            this.lZo.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence drh() {
        return this.lZo;
    }

    public int drj() {
        return this.lZp;
    }

    public String drk() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dri() {
        return (this.lZp > 0 && this.lZp < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
