package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.FontSizeConfig;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder iVr;
    private int iVs;
    private int textSize;

    public g() {
        this.iVs = 0;
        this.textSize = -1;
        this.iVr = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.iVs = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.iVr = new SpannableStringBuilder();
            if (excContent != null) {
                this.iVr.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.iVs = excContent.align.intValue();
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
            this.iVr.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cqM() {
        return this.iVr;
    }

    public int cqO() {
        return this.iVs;
    }

    public String cqP() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cqN() {
        return (this.iVs > 0 && this.iVs < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
