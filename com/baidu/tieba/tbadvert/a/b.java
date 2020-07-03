package com.baidu.tieba.tbadvert.a;
/* loaded from: classes13.dex */
public class b {
    public int dMR;
    public int id;
    public String linkUrl;
    public long showTime = 3000;
    public int showType;

    public boolean djA() {
        return this.showType == 1;
    }

    public boolean bqc() {
        return this.showType == 3 || this.showType == 4;
    }

    public boolean isFullScreen() {
        return this.showType == 2 || this.showType == 4;
    }
}
