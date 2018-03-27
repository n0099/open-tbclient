package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder gbr;
    private int gbs;
    private int textSize;

    public g() {
        this.gbs = 0;
        this.textSize = -1;
        this.gbr = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.gbs = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.gbr = new SpannableStringBuilder();
            if (excContent != null) {
                this.gbr.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.gbs = excContent.align.intValue();
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
            this.gbr.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhg() {
        return this.gbr;
    }

    public int bhi() {
        return this.gbs;
    }

    public String bhj() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhh() {
        return (this.gbs > 0 && this.gbs < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
