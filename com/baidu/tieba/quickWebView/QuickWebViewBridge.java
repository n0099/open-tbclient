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
import com.repackage.ho;
import com.repackage.li8;
import com.repackage.qg;
import com.repackage.u78;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
@ho
/* loaded from: classes3.dex */
public class QuickWebViewBridge extends CommonTbJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String REQUEST_BY_NATIVE;
    public u78 mProxy;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QuickWebViewBridgeData a;
        public final /* synthetic */ QuickWebViewBridge b;

        public a(QuickWebViewBridge quickWebViewBridge, QuickWebViewBridgeData quickWebViewBridgeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebViewBridge, quickWebViewBridgeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = quickWebViewBridge;
            this.a = quickWebViewBridgeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u78 u78Var = this.b.mProxy;
                QuickWebViewBridgeData quickWebViewBridgeData = this.a;
                u78Var.j(quickWebViewBridgeData, quickWebViewBridgeData.callBack, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickWebViewBridge(Context context, u78 u78Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, u78Var};
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
        this.mProxy = u78Var;
    }

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, com.repackage.hi8
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
            return super.dealJsInterface(str, str2, str3, jsPromptResult);
        }
        return invokeLLLL.booleanValue;
    }

    public li8 requestByNative(String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, jSONObject)) == null) {
            li8 li8Var = new li8();
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
            if (this.mProxy != null) {
                qg.a().post(new a(this, quickWebViewBridgeData));
            }
            li8Var.w(str);
            return li8Var;
        }
        return (li8) invokeLLLL.objValue;
    }

    public li8 requestByNativeToH5(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap)) == null) {
            li8 li8Var = new li8();
            if (hashMap != null && hashMap.get("result") != null) {
                li8Var.o(hashMap.get("result"));
                li8Var.w(hashMap.get("NotificationKey"));
            }
            li8Var.z(true);
            return li8Var;
        }
        return (li8) invokeL.objValue;
    }
}
