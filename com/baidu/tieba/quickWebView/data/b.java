package com.baidu.tieba.quickWebView.data;
/* loaded from: classes.dex */
public class b {
    private String mSD;
    private boolean isUpload = false;
    private boolean isClear = false;

    public String getModName() {
        return this.mSD;
    }

    public void Rp(String str) {
        this.mSD = str;
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }

    public boolean dDd() {
        return this.isUpload;
    }

    public void xz(boolean z) {
        this.isUpload = z;
    }
}
