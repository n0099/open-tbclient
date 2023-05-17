package com.baidu.ufosdk;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public p(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uri.getScheme();
        this.b = uri.getHost();
        String path = uri.getPath();
        this.c = path;
        if (!TextUtils.isEmpty(path)) {
            this.c = this.c.replace("/", "");
        }
        this.d = uri.getQueryParameter("params");
        this.e = uri.getQueryParameter(WebChromeClient.KEY_ARG_CALLBACK);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ClientProtocol{mProtocolScheme='" + this.a + "', mProtocolApiName='" + this.b + "', mProtocolMethodName='" + this.c + "', mProtocolParams='" + this.d + "', mProtocolCallBack='" + this.e + "'}";
        }
        return (String) invokeV.objValue;
    }
}
