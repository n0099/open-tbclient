package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class au {
    private String KT = "bar_detail";
    private av bXA;

    public void setFrom(String str) {
        this.KT = str;
    }

    public void a(av avVar) {
        this.bXA = avVar;
    }

    public void i(String str, long j) {
        new aw(str, j, this.KT, this.bXA).execute(new Integer[0]);
    }
}
