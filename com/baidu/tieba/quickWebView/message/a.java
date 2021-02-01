package com.baidu.tieba.quickWebView.message;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes.dex */
public class a {
    private String mMd5;
    private String mQm;
    private boolean mQn = true;
    private boolean mQo = false;
    private boolean mQp = false;
    private String mVersion;

    public void a(Offpack offpack) {
        if (offpack != null) {
            this.mQm = offpack.src;
            this.mMd5 = offpack.md5;
            this.mVersion = offpack.webview_version;
            this.mQn = offpack.is_use.intValue() == 1;
        }
    }

    public boolean dCP() {
        return this.mQn;
    }

    public String dCQ() {
        return this.mQm;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
