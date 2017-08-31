package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.browser.b {
    private b fDi;
    private final String fDm;

    public a(Context context, b bVar) {
        super(context);
        this.fDm = "requestByNative";
        this.fDi = bVar;
    }

    @Override // com.baidu.tbadk.browser.b, com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str) && "requestByNative".equals(str2)) {
            try {
                QuickWebViewBridgeData quickWebViewBridgeData = (QuickWebViewBridgeData) OrmObject.objectWithJsonStr(str3, QuickWebViewBridgeData.class);
                quickWebViewBridgeData.begin = System.currentTimeMillis();
                if (this.fDi != null) {
                    this.fDi.a(quickWebViewBridgeData, quickWebViewBridgeData.callBack);
                }
                jsPromptResult.confirm();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return super.dealJsInterface(str, str2, str3, jsPromptResult);
    }
}
