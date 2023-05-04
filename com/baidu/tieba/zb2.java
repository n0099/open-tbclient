package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class zb2 implements gc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<lc2> b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final zb2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-237459391, "Lcom/baidu/tieba/zb2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-237459391, "Lcom/baidu/tieba/zb2$b;");
                    return;
                }
            }
            a = new zb2(null);
        }
    }

    public zb2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new CopyOnWriteArrayList<>();
    }

    public static zb2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (zb2) invokeV.objValue;
    }

    public /* synthetic */ zb2(a aVar) {
        this();
    }

    public void a(lc2 lc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lc2Var) == null) && lc2Var != null && !this.b.contains(lc2Var)) {
            this.b.add(lc2Var);
        }
    }

    @RequiresApi(api = 21)
    public WebResourceResponse c(WebResourceRequest webResourceRequest, boolean z) {
        InterceptResult invokeLZ;
        Uri url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webResourceRequest, z)) == null) {
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
                return null;
            }
            return d(url.toString(), webResourceRequest.getRequestHeaders(), z);
        }
        return (WebResourceResponse) invokeLZ.objValue;
    }

    public final WebResourceResponse d(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, map, z)) == null) {
            if (this.b.isEmpty() || TextUtils.isEmpty(str) || str.startsWith("file://")) {
                return null;
            }
            return new oc2(this.b, str, map, 0, z).b(str, map, z);
        }
        return (WebResourceResponse) invokeLLZ.objValue;
    }
}
