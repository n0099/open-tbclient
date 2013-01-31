package com.baidu.zeus;
/* loaded from: classes.dex */
public class JsPromptResult extends JsResult {
    private String mStringResult;

    public void confirm(String str) {
        this.mStringResult = str;
        confirm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsPromptResult(CallbackProxy callbackProxy) {
        super(callbackProxy, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStringResult() {
        return this.mStringResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.JsResult
    public void handleDefault() {
        this.mStringResult = null;
        super.handleDefault();
    }
}
