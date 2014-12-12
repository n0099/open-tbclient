package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class au {
    private av bVI;
    private String mFrom = "bar_detail";

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(av avVar) {
        this.bVI = avVar;
    }

    public void i(String str, long j) {
        new aw(str, j, this.mFrom, this.bVI).execute(new Integer[0]);
    }
}
