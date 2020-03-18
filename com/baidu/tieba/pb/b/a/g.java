package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.FontSizeConfig;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder iYA;
    private int iYB;
    private int textSize;

    public g() {
        this.iYB = 0;
        this.textSize = -1;
        this.iYA = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.iYB = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.iYA = new SpannableStringBuilder();
            if (excContent != null) {
                this.iYA.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.iYB = excContent.align.intValue();
            }
            if (!StringUtils.isNull(excContent.color)) {
                this.color = excContent.color;
            }
            if (excContent.size != null && excContent.size.intValue() > 0 && context != null && context.getResources() != null) {
                int identifier = context.getResources().getIdentifier(FontSizeConfig.FONT_SIZE_COOKIE + excContent.size, "dimen", context.getPackageName());
                if (identifier > 0) {
                    this.textSize = context.getResources().getDimensionPixelSize(identifier);
                }
            }
        }
    }

    public void l(CharSequence charSequence) {
        if (charSequence != null) {
            this.iYA.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence csC() {
        return this.iYA;
    }

    public int csE() {
        return this.iYB;
    }

    public String csF() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csD() {
        return (this.iYB > 0 && this.iYB < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
