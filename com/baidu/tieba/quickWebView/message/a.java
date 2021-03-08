package com.baidu.tieba.quickWebView.message;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes.dex */
public class a {
    private String mMd5;
    private String mSE;
    private boolean mSF = true;
    private boolean mSG = false;
    private boolean mSH = false;
    private String mVersion;

    public void a(Offpack offpack) {
        if (offpack != null) {
            this.mSE = offpack.src;
            this.mMd5 = offpack.md5;
            this.mVersion = offpack.webview_version;
            this.mSF = offpack.is_use.intValue() == 1;
        }
    }

    public boolean dDe() {
        return this.mSF;
    }

    public String dDf() {
        return this.mSE;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
