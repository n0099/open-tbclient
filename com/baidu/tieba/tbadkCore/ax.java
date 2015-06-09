package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class ax {
    private ay crJ;
    private String mFrom = "bar_detail";

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(ay ayVar) {
        this.crJ = ayVar;
    }

    public void k(String str, long j) {
        new az(str, j, this.mFrom, this.crJ).execute(new Integer[0]);
    }
}
