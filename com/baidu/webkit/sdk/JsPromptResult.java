package com.baidu.webkit.sdk;

import com.baidu.webkit.sdk.JsResult;
/* loaded from: classes8.dex */
public class JsPromptResult extends JsResult {
    private String mStringResult;

    public JsPromptResult(JsResult.ResultReceiver resultReceiver) {
        super(resultReceiver);
    }

    public void confirm(String str) {
        this.mStringResult = str;
        confirm();
    }

    public String getStringResult() {
        return this.mStringResult;
    }
}
