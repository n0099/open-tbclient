package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class e {
    private Fragment TC;
    private String ccr;
    private b ccs;

    public e(Context context, com.baidu.tieba.recommendfrs.control.a.b bVar, String str, float f) {
        com.baidu.tieba.recommendfrs.b bVar2 = new com.baidu.tieba.recommendfrs.b();
        bVar2.iV(str);
        bVar2.a(bVar);
        this.TC = bVar2;
        this.ccr = str;
        b bVar3 = new b(context);
        bVar3.setText(str);
        bVar3.setTextSize(0, f);
        bVar3.rU();
        this.ccs = bVar3;
    }

    public String ahK() {
        return this.ccr;
    }

    public boolean je(String str) {
        return TextUtils.equals(str, this.ccr);
    }

    public Fragment ahL() {
        return this.TC;
    }

    public b ahM() {
        return this.ccs;
    }
}
