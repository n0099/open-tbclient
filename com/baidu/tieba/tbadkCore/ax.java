package com.baidu.tieba.tbadkCore;
/* loaded from: classes.dex */
public class ax {
    private String Wu = "bar_detail";
    private ay cnK;

    public void setFrom(String str) {
        this.Wu = str;
    }

    public void a(ay ayVar) {
        this.cnK = ayVar;
    }

    public void i(String str, long j) {
        new az(str, j, this.Wu, this.cnK).execute(new Integer[0]);
    }
}
