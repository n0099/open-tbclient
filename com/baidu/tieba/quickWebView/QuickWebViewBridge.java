package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import d.a.j0.q2.a;
/* loaded from: classes3.dex */
public class QuickWebViewBridge extends CommonTbJsBridge {
    public final String REQUEST_BY_NATIVE;
    public a mProxy;

    public QuickWebViewBridge(Context context, a aVar) {
        super(context);
        this.REQUEST_BY_NATIVE = "requestByNative";
        this.mProxy = aVar;
    }

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, d.a.j0.d3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str) && "requestByNative".equals(str2)) {
            try {
                QuickWebViewBridgeData quickWebViewBridgeData = (QuickWebViewBridgeData) OrmObject.objectWithJsonStr(str3, QuickWebViewBridgeData.class);
                quickWebViewBridgeData.begin = System.currentTimeMillis();
                if (this.mProxy != null) {
                    this.mProxy.f(quickWebViewBridgeData, quickWebViewBridgeData.callBack);
                }
                jsPromptResult.confirm();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
        return super.dealJsInterface(str, str2, str3, jsPromptResult);
    }
}
