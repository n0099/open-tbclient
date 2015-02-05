package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class au {
    private String KQ = "bar_detail";
    private av bXz;

    public void setFrom(String str) {
        this.KQ = str;
    }

    public void a(av avVar) {
        this.bXz = avVar;
    }

    public void i(String str, long j) {
        new aw(str, j, this.KQ, this.bXz).execute(new Integer[0]);
    }
}
