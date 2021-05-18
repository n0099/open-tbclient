package com.baidu.tieba.quickWebView.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes5.dex */
public class QuickWebViewHttpReqMsg extends HttpMessage {
    public long begin;
    public String jsCallbackMethod;
    public String module;
    public String url;

    public QuickWebViewHttpReqMsg() {
        super(CmdConfigHttp.CMD_WEB_HTTP_PROXY);
        this.url = null;
        this.module = null;
    }
}
