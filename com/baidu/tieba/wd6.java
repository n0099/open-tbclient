package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.offline.data.OfflineBridgeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class wd6 implements se6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.se6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        re6.a(this, webView, str, jSONObject);
    }

    public wd6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.se6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (TextUtils.equals("requestByNative", str2)) {
                try {
                    OfflineBridgeData offlineBridgeData = (OfflineBridgeData) OrmObject.objectWithJsonStr(str3, OfflineBridgeData.class);
                    offlineBridgeData.begin = System.currentTimeMillis();
                    vd6.g().j(webView, offlineBridgeData, offlineBridgeData.callBack);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public sm9 d(final WebView webView, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jSONObject)) == null) {
            sm9 sm9Var = new sm9();
            final OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
            offlineBridgeData.url = str;
            offlineBridgeData.type = str2;
            offlineBridgeData.module = str3;
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                offlineBridgeData.data = hashMap;
            }
            offlineBridgeData.begin = System.currentTimeMillis();
            jg.a().post(new Runnable() { // from class: com.baidu.tieba.rd6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        vd6.g().k(webView, r1, offlineBridgeData.callBack, true);
                    }
                }
            });
            sm9Var.w(str);
            return sm9Var;
        }
        return (sm9) invokeLLLLL.objValue;
    }

    public sm9 e(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            sm9 sm9Var = new sm9();
            if (hashMap != null && hashMap.get("result") != null) {
                sm9Var.o(hashMap.get("result"));
                sm9Var.w(hashMap.get("NotificationKey"));
            }
            sm9Var.z(true);
            return sm9Var;
        }
        return (sm9) invokeLL.objValue;
    }
}
