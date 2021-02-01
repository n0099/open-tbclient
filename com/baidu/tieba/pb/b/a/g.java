package com.baidu.tieba.pb.b.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class g implements c {
    private int aJO;
    private String color;
    private SpannableStringBuilder miw;
    private int textSize;

    public g() {
        this.aJO = 0;
        this.textSize = -1;
        this.miw = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.aJO = 0;
        this.textSize = -1;
        if (excContent != null) {
            this.miw = new SpannableStringBuilder();
            if (excContent != null) {
                this.miw.append((CharSequence) excContent.text);
            }
            if (excContent.align != null) {
                this.aJO = excContent.align.intValue();
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
            this.miw.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dtw() {
        return this.miw;
    }

    public int dty() {
        return this.aJO;
    }

    public String Bs() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dtx() {
        return (this.aJO > 0 && this.aJO < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
