package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder kTZ;
    private int kUa;
    private int textSize;

    public g() {
        this.kUa = 0;
        this.textSize = -1;
        this.kTZ = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.kUa = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.kTZ = new SpannableStringBuilder();
            if (excContent != null) {
                this.kTZ.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.kUa = excContent.align.intValue();
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

    public void r(CharSequence charSequence) {
        if (charSequence != null) {
            this.kTZ.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dds() {
        return this.kTZ;
    }

    public int ddu() {
        return this.kUa;
    }

    public String ddv() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean ddt() {
        return (this.kUa > 0 && this.kUa < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
