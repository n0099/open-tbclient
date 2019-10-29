package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {
    private String color;
    private SpannableStringBuilder idw;
    private int idx;
    private int textSize;

    public g() {
        this.idx = 0;
        this.textSize = -1;
        this.idw = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.idx = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.idw = new SpannableStringBuilder();
            if (excContent != null) {
                this.idw.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.idx = excContent.align.intValue();
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

    public void j(CharSequence charSequence) {
        if (charSequence != null) {
            this.idw.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bXL() {
        return this.idw;
    }

    public int bXN() {
        return this.idx;
    }

    public String bXO() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bXM() {
        return (this.idx > 0 && this.idx < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
