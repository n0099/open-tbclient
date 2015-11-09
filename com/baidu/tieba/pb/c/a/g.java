package com.baidu.tieba.pb.c.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder cpc;
    private int cpd;
    private int textSize;

    public g() {
        this.cpd = 0;
        this.textSize = -1;
        this.cpc = new SpannableStringBuilder();
    }

    public g(Context context, Content content) {
        this.cpd = 0;
        this.textSize = -1;
        this.cpc = new SpannableStringBuilder();
        if (content != null) {
            this.cpc.append((CharSequence) content.text);
        }
        if (content.align != null) {
            this.cpd = content.align.intValue();
        }
        if (!StringUtils.isNull(content.color)) {
            this.color = content.color;
        }
        if (content.size != null && content.size.intValue() > 0 && context != null && context.getResources() != null) {
            int identifier = context.getResources().getIdentifier("fontsize" + content.size, "dimen", context.getPackageName());
            if (identifier > 0) {
                this.textSize = context.getResources().getDimensionPixelSize(identifier);
            }
        }
    }

    public void e(CharSequence charSequence) {
        if (charSequence != null) {
            this.cpc.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence ais() {
        return this.cpc;
    }

    public int aiu() {
        return this.cpd;
    }

    public String aiv() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean ait() {
        return (this.cpd > 0 && this.cpd < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
