package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class ax {
    private String Ws = "bar_detail";
    private ay cnu;

    public void setFrom(String str) {
        this.Ws = str;
    }

    public void a(ay ayVar) {
        this.cnu = ayVar;
    }

    public void i(String str, long j) {
        new az(str, j, this.Ws, this.cnu).execute(new Integer[0]);
    }
}
