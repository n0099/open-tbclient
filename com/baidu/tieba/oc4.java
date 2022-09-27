package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.util.Map;
import okhttp3.MediaType;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes5.dex */
public class oc4 {
    public static /* synthetic */ Interceptable $ic;
    public static CookieManager a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ sc4 b;

        public a(Map map, sc4 sc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, sc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = sc4Var;
        }

        @Override // com.baidu.tieba.oc4.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = pa4.g().postByteRequest();
                xa4.a(postByteRequest, this.a);
                postByteRequest.url(tc4.j(str, this.a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(oc4.b)) {
                    postByteRequest.userAgent(oc4.b);
                }
                postByteRequest.cookieManager(oc4.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ sc4 b;

        public b(Map map, sc4 sc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, sc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = sc4Var;
        }

        @Override // com.baidu.tieba.oc4.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = pa4.g().getRequest().url(tc4.j(str, this.a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(oc4.b)) {
                    requestSubFrom.userAgent(oc4.b);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(oc4.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948027433, "Lcom/baidu/tieba/oc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948027433, "Lcom/baidu/tieba/oc4;");
                return;
            }
        }
        a = wa4.b().f();
        ca4 b2 = da4.b();
        if (b2 == null || !pa4.g().c()) {
            return;
        }
        b = b2.getUserAgent();
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, sc4<String> sc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, str, map, map2, sc4Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (sc4Var != null) {
            sc4Var.onStart();
        }
        ua4 b2 = wa4.b();
        if (PMSConstants.a(b2)) {
            b2.m(tc4.j(str, map), null, new b(map, sc4Var));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = pa4.g().getRequest().url(tc4.j(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(b)) {
            requestSubFrom.userAgent(b);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(a).enableStat(true).build().executeStat(sc4Var);
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, sc4<String> sc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, sc4Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (sc4Var != null) {
            sc4Var.onStart();
        }
        ua4 b2 = wa4.b();
        if (PMSConstants.a(b2)) {
            b2.m(tc4.j(str, map), jSONObject.toString(), new a(map, sc4Var));
            return;
        }
        la4 postStringRequest = pa4.g().postStringRequest();
        xa4.a(postStringRequest, map);
        postStringRequest.url(tc4.j(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(b)) {
            postStringRequest.userAgent(b);
        }
        postStringRequest.cookieManager(a).enableStat(true).build().executeStat(sc4Var);
    }
}
