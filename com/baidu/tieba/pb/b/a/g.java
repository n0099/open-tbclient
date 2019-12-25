package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.FontSizeConfig;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder iRO;
    private int iRP;
    private int textSize;

    public g() {
        this.iRP = 0;
        this.textSize = -1;
        this.iRO = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.iRP = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.iRO = new SpannableStringBuilder();
            if (excContent != null) {
                this.iRO.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.iRP = excContent.align.intValue();
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
            this.iRO.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cpF() {
        return this.iRO;
    }

    public int cpH() {
        return this.iRP;
    }

    public String cpI() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cpG() {
        return (this.iRP > 0 && this.iRP < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
