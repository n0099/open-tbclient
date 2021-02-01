package com.baidu.tieba.quickWebView.data;
/* loaded from: classes.dex */
public class b {
    private String mQl;
    private boolean isUpload = false;
    private boolean isClear = false;

    public String getModName() {
        return this.mQl;
    }

    public void Ri(String str) {
        this.mQl = str;
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }

    public boolean dCO() {
        return this.isUpload;
    }

    public void xz(boolean z) {
        this.isUpload = z;
    }
}
