package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder mdW;
    private int mdX;
    private int textSize;

    public g() {
        this.mdX = 0;
        this.textSize = -1;
        this.mdW = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.mdX = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.mdW = new SpannableStringBuilder();
            if (excContent != null) {
                this.mdW.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.mdX = excContent.align.intValue();
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
            this.mdW.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence duY() {
        return this.mdW;
    }

    public int dva() {
        return this.mdX;
    }

    public String dvb() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean duZ() {
        return (this.mdX > 0 && this.mdX < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
