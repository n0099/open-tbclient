package com.baidu.tieba.quickWebView.message;

import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes.dex */
public class QuickWebViewHttpReqMsg extends HttpMessage {
    public long begin;
    public String jsCallbackMethod;
    public String url;

    public QuickWebViewHttpReqMsg() {
        super(1003364);
        this.url = null;
    }
}
