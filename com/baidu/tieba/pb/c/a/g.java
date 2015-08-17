package com.baidu.tieba.pb.c.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class g implements c {
    private SpannableStringBuilder chg;
    private int chh;
    private String color;
    private int textSize;

    public g() {
        this.chh = 0;
        this.textSize = -1;
        this.chg = new SpannableStringBuilder();
    }

    public g(Context context, Content content) {
        this.chh = 0;
        this.textSize = -1;
        this.chg = new SpannableStringBuilder();
        if (content != null) {
            this.chg.append((CharSequence) content.text);
        }
        if (content.align != null) {
            this.chh = content.align.intValue();
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

    public void d(CharSequence charSequence) {
        if (charSequence != null) {
            this.chg.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence afA() {
        return this.chg;
    }

    public int afC() {
        return this.chh;
    }

    public String afD() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean afB() {
        return (this.chh > 0 && this.chh < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
