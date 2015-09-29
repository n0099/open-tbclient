package com.baidu.tieba.pb.c.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class g implements c {
    private SpannableStringBuilder cnA;
    private int cnB;
    private String color;
    private int textSize;

    public g() {
        this.cnB = 0;
        this.textSize = -1;
        this.cnA = new SpannableStringBuilder();
    }

    public g(Context context, Content content) {
        this.cnB = 0;
        this.textSize = -1;
        this.cnA = new SpannableStringBuilder();
        if (content != null) {
            this.cnA.append((CharSequence) content.text);
        }
        if (content.align != null) {
            this.cnB = content.align.intValue();
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
            this.cnA.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence ahQ() {
        return this.cnA;
    }

    public int ahS() {
        return this.cnB;
    }

    public String ahT() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean ahR() {
        return (this.cnB > 0 && this.cnB < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
