package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nt1 implements NetRequest.RequestInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nt1() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF, IF] complete} */
    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RequestInterceptor
    public boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, netRequestResult, netRequestParam)) == null) {
            if (netRequestParam == null) {
                return false;
            }
            String url = netRequestParam.getUrl();
            if (TextUtils.isEmpty(url)) {
                if (netRequestResult != null) {
                    netRequestResult.setStatusCodeAndMsg(1001, "illegal url");
                }
                return true;
            }
            String str = null;
            JsObject jsObject = netRequestParam.getJsObject();
            if (jsObject != null) {
                try {
                    int propertyIndex = jsObject.getPropertyIndex("__plugin__");
                    if (propertyIndex > 0) {
                        str = jsObject.toString(propertyIndex);
                    }
                    int c = v43.c("request", url, str);
                    if (c != 0) {
                        ew1 Y = st1.Y(c);
                        netRequestResult.setStatusCodeAndMsg(Y.b, Y.c);
                        return true;
                    }
                } finally {
                    if (ot1.e() && jsObject != null) {
                        jsObject.release();
                    }
                }
            }
            if (ot1.e() && jsObject != null) {
                jsObject.release();
            }
            if (!TextUtils.isEmpty(str)) {
                netRequestParam.addHeader("X-SWAN-HOSTSIGN", b03.b(c03.h(str)));
            }
            netRequestParam.addHeader("Referer", tt1.d());
            netRequestParam.addHeader("User-Agent", wa4.b().getUserAgent());
            return false;
        }
        return invokeLL.booleanValue;
    }
}
