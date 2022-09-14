package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.jc8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.xo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
@xo
/* loaded from: classes5.dex */
public class SingleQuickWebViewBridge extends CommonTbJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String REQUEST_BY_NATIVE;
    public jc8 mProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleQuickWebViewBridge(Context context, jc8 jc8Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jc8Var};
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
        this.mProxy = jc8Var;
    }

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, com.baidu.tieba.in8
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

    public mn8 requestByNative(String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, jSONObject)) == null) {
            mn8 mn8Var = new mn8();
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
            jc8 jc8Var = this.mProxy;
            if (jc8Var != null) {
                jc8Var.j(quickWebViewBridgeData, quickWebViewBridgeData.callBack, true);
            }
            mn8Var.w(str);
            return mn8Var;
        }
        return (mn8) invokeLLLL.objValue;
    }

    public mn8 requestByNativeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            mn8 mn8Var = new mn8();
            if (hashMap != null && hashMap.get(TiebaStatic.LogFields.RESULT) != null) {
                mn8Var.o(hashMap.get(TiebaStatic.LogFields.RESULT));
                mn8Var.w(hashMap.get("NotificationKey"));
            }
            mn8Var.z(true);
            return mn8Var;
        }
        return (mn8) invokeL.objValue;
    }
}
