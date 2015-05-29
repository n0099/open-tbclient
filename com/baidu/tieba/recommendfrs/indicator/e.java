package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class e {
    private Fragment TC;
    private String ccq;
    private b ccr;

    public e(Context context, com.baidu.tieba.recommendfrs.control.a.b bVar, String str, float f) {
        com.baidu.tieba.recommendfrs.b bVar2 = new com.baidu.tieba.recommendfrs.b();
        bVar2.iV(str);
        bVar2.a(bVar);
        this.TC = bVar2;
        this.ccq = str;
        b bVar3 = new b(context);
        bVar3.setText(str);
        bVar3.setTextSize(0, f);
        bVar3.rU();
        this.ccr = bVar3;
    }

    public String ahJ() {
        return this.ccq;
    }

    public boolean je(String str) {
        return TextUtils.equals(str, this.ccq);
    }

    public Fragment ahK() {
        return this.TC;
    }

    public b ahL() {
        return this.ccr;
    }
}
