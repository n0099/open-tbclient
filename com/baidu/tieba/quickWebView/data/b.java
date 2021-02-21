package com.baidu.tieba.quickWebView.data;
/* loaded from: classes.dex */
public class b {
    private String mQA;
    private boolean isUpload = false;
    private boolean isClear = false;

    public String getModName() {
        return this.mQA;
    }

    public void Rj(String str) {
        this.mQA = str;
    }

    public boolean isClear() {
        return this.isClear;
    }

    public void setClear(boolean z) {
        this.isClear = z;
    }

    public boolean dCV() {
        return this.isUpload;
    }

    public void xz(boolean z) {
        this.isUpload = z;
    }
}
