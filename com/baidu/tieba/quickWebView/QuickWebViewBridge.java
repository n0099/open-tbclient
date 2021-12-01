package com.baidu.tieba.quickWebView;

import android.content.Context;
import android.webkit.JsPromptResult;
import c.a.d.f.m.e;
import c.a.r0.t3.n0.d.c;
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
@c.a.f.a.a
/* loaded from: classes11.dex */
public class QuickWebViewBridge extends CommonTbJsBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String REQUEST_BY_NATIVE;
    public c.a.r0.f3.a mProxy;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ QuickWebViewBridgeData f48622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ QuickWebViewBridge f48623f;

        public a(QuickWebViewBridge quickWebViewBridge, QuickWebViewBridgeData quickWebViewBridgeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {quickWebViewBridge, quickWebViewBridgeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48623f = quickWebViewBridge;
            this.f48622e = quickWebViewBridgeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.f3.a aVar = this.f48623f.mProxy;
                QuickWebViewBridgeData quickWebViewBridgeData = this.f48622e;
                aVar.j(quickWebViewBridgeData, quickWebViewBridgeData.callBack, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickWebViewBridge(Context context, c.a.r0.f3.a aVar) {
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

    @Override // com.baidu.tbadk.browser.CommonTbJsBridge, c.a.r0.t3.n0.b
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
            return super.dealJsInterface(str, str2, str3, jsPromptResult);
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
            if (this.mProxy != null) {
                e.a().post(new a(this, quickWebViewBridgeData));
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
            cVar.z(true);
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
