package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.Cdo;
import com.repackage.n68;
import com.repackage.th8;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
@Cdo
/* loaded from: classes3.dex */
public class SingleQuickWebViewBridge extends CommonTbJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String REQUEST_BY_NATIVE;
    public n68 mProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleQuickWebViewBridge(Context context, n68 n68Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, n68Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.REQUEST_BY_NATIVE = "requestByNative";
        this.mProxy = n68Var;
    }

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, com.repackage.ph8
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public th8 requestByNative(String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, jSONObject)) == null) {
            th8 th8Var = new th8();
            QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
            quickWebViewBridgeData.url = str;
            quickWebViewBridgeData.type = str2;
            quickWebViewBridgeData.module = str3;
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                quickWebViewBridgeData.data = hashMap;
            }
            quickWebViewBridgeData.begin = System.currentTimeMillis();
            n68 n68Var = this.mProxy;
            if (n68Var != null) {
                n68Var.j(quickWebViewBridgeData, quickWebViewBridgeData.callBack, true);
            }
            th8Var.w(str);
            return th8Var;
        }
        return (th8) invokeLLLL.objValue;
    }

    public th8 requestByNativeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            th8 th8Var = new th8();
            if (hashMap != null && hashMap.get("result") != null) {
                th8Var.o(hashMap.get("result"));
                th8Var.w(hashMap.get("NotificationKey"));
            }
            th8Var.z(true);
            return th8Var;
        }
        return (th8) invokeL.objValue;
    }
}
