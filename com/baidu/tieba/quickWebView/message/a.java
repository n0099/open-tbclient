package com.baidu.tieba.quickWebView.message;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes.dex */
public class a {
    private String mMd5;
    private String mQB;
    private boolean mQC = true;
    private boolean mQD = false;
    private boolean mQE = false;
    private String mVersion;

    public void a(Offpack offpack) {
        if (offpack != null) {
            this.mQB = offpack.src;
            this.mMd5 = offpack.md5;
            this.mVersion = offpack.webview_version;
            this.mQC = offpack.is_use.intValue() == 1;
        }
    }

    public boolean dCW() {
        return this.mQC;
    }

    public String dCX() {
        return this.mQB;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
