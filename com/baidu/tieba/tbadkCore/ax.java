package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class ax {
    private ay crI;
    private String mFrom = "bar_detail";

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(ay ayVar) {
        this.crI = ayVar;
    }

    public void k(String str, long j) {
        new az(str, j, this.mFrom, this.crI).execute(new Integer[0]);
    }
}
