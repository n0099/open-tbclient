package com.baidu.tieba.pb.c.a;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class g implements c {
    private SpannableStringBuilder cIo;
    private int cIp;
    private String color;
    private int textSize;

    public g() {
        this.cIp = 0;
        this.textSize = -1;
        this.cIo = new SpannableStringBuilder();
    }

    public g(Context context, ExcContent excContent) {
        this.cIp = 0;
        this.textSize = -1;
        this.cIo = new SpannableStringBuilder();
        if (excContent != null) {
            this.cIo.append((CharSequence) excContent.text);
        }
        if (excContent.align != null) {
            this.cIp = excContent.align.intValue();
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

    public void g(CharSequence charSequence) {
        if (charSequence != null) {
            this.cIo.append(charSequence);
        }
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 0;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence amV() {
        return this.cIo;
    }

    public int amX() {
        return this.cIp;
    }

    public String amY() {
        return this.color;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean amW() {
        return (this.cIp > 0 && this.cIp < 3) || !StringUtils.isNull(this.color);
    }

    public int getTextSize() {
        return this.textSize;
    }
}
