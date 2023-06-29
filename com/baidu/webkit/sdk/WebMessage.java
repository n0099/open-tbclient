package com.baidu.webkit.sdk;
/* loaded from: classes9.dex */
public class WebMessage {
    public String mData;
    public WebMessagePort[] mPorts;

    public WebMessage(String str) {
        this.mData = str;
    }

    public WebMessage(String str, WebMessagePort[] webMessagePortArr) {
        this.mData = str;
        this.mPorts = webMessagePortArr;
    }

    public String getData() {
        return this.mData;
    }

    public WebMessagePort[] getPorts() {
        return this.mPorts;
    }
}
