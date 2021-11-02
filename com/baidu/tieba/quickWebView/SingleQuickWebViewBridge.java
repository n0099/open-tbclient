package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import b.a.g.a.a;
import b.a.r0.l3.n0.d.c;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
@a
/* loaded from: classes9.dex */
public class SingleQuickWebViewBridge extends CommonTbJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String REQUEST_BY_NATIVE;
    public b.a.r0.x2.a mProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleQuickWebViewBridge(Context context, b.a.r0.x2.a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.REQUEST_BY_NATIVE = "requestByNative";
        this.mProxy = aVar;
    }

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, b.a.r0.l3.n0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str) && "requestByNative".equals(str2)) {
                try {
                    QuickWebViewBridgeData quickWebViewBridgeData = (QuickWebViewBridgeData) OrmObject.objectWithJsonStr(str3, QuickWebViewBridgeData.class);
                    quickWebViewBridgeData.begin = System.currentTimeMillis();
                    if (this.mProxy != null) {
                        this.mProxy.i(quickWebViewBridgeData, quickWebViewBridgeData.callBack);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public c requestByNative(String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, jSONObject)) == null) {
            c cVar = new c();
            QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
            quickWebViewBridgeData.url = str;
            quickWebViewBridgeData.type = str2;
            quickWebViewBridgeData.module = str3;
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    hashMap.put(keys.next(), jSONObject.optString(keys.next()));
                }
                quickWebViewBridgeData.data = hashMap;
            }
            quickWebViewBridgeData.begin = System.currentTimeMillis();
            b.a.r0.x2.a aVar = this.mProxy;
            if (aVar != null) {
                aVar.j(quickWebViewBridgeData, quickWebViewBridgeData.callBack, true);
            }
            cVar.w(str);
            return cVar;
        }
        return (c) invokeLLLL.objValue;
    }

    public c requestByNativeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            c cVar = new c();
            if (hashMap != null && hashMap.get("result") != null) {
                cVar.o(hashMap.get("result"));
                cVar.w(hashMap.get("NotificationKey"));
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
