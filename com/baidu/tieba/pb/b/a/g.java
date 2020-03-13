package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.FontSizeConfig;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder iWZ;
    private int iXa;
    private int textSize;

    public g() {
        this.iXa = 0;
        this.textSize = -1;
        this.iWZ = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.iXa = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.iWZ = new SpannableStringBuilder();
            if (excContent != null) {
                this.iWZ.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.iXa = excContent.align.intValue();
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
            this.iWZ.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence csh() {
        return this.iWZ;
    }

    public int csj() {
        return this.iXa;
    }

    public String csk() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csi() {
        return (this.iXa > 0 && this.iXa < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
