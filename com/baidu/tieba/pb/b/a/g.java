package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.config.FontSizeConfig;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder iWN;
    private int iWO;
    private int textSize;

    public g() {
        this.iWO = 0;
        this.textSize = -1;
        this.iWN = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.iWO = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.iWN = new SpannableStringBuilder();
            if (excContent != null) {
                this.iWN.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.iWO = excContent.align.intValue();
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
            this.iWN.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence csg() {
        return this.iWN;
    }

    public int csi() {
        return this.iWO;
    }

    public String csj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csh() {
        return (this.iWO > 0 && this.iWO < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
