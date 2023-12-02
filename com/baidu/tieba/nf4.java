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
/* loaded from: classes7.dex */
public class nf4 {
    public static /* synthetic */ Interceptable $ic;
    public static CookieManager a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface c {
        void a(Map<String, String> map, byte[] bArr, String str);
    }

    /* loaded from: classes7.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ rf4 b;

        public a(Map map, rf4 rf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rf4Var};
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
            this.b = rf4Var;
        }

        @Override // com.baidu.tieba.nf4.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = od4.g().postByteRequest();
                wd4.a(postByteRequest, this.a);
                postByteRequest.url(sf4.j(str, this.a)).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(nf4.b)) {
                    postByteRequest.userAgent(nf4.b);
                }
                postByteRequest.cookieManager(nf4.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ rf4 b;

        public b(Map map, rf4 rf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, rf4Var};
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
            this.b = rf4Var;
        }

        @Override // com.baidu.tieba.nf4.c
        public void a(Map<String, String> map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder requestSubFrom = od4.g().getRequest().url(sf4.j(str, this.a)).requestSubFrom(10);
                if (!TextUtils.isEmpty(nf4.b)) {
                    requestSubFrom.userAgent(nf4.b);
                }
                if (map != null) {
                    requestSubFrom.addHeaders(map);
                }
                requestSubFrom.cookieManager(nf4.a).enableStat(true).build().executeStat(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948000525, "Lcom/baidu/tieba/nf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948000525, "Lcom/baidu/tieba/nf4;");
                return;
            }
        }
        a = vd4.b().f();
        bd4 b2 = cd4.b();
        if (b2 != null && od4.g().c()) {
            b = b2.getUserAgent();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void a(String str, Map<String, String> map, Map<String, String> map2, rf4<String> rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65537, null, str, map, map2, rf4Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (rf4Var != null) {
            rf4Var.onStart();
        }
        td4 b2 = vd4.b();
        if (PMSConstants.a(b2)) {
            b2.m(sf4.j(str, map), null, new b(map, rf4Var));
            return;
        }
        GetRequest.GetRequestBuilder requestSubFrom = od4.g().getRequest().url(sf4.j(str, map)).requestSubFrom(10);
        if (!TextUtils.isEmpty(b)) {
            requestSubFrom.userAgent(b);
        }
        if (map2 != null) {
            requestSubFrom.addHeaders(map2);
        }
        requestSubFrom.cookieManager(a).enableStat(true).build().executeStat(rf4Var);
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static void b(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, rf4<String> rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, rf4Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (rf4Var != null) {
            rf4Var.onStart();
        }
        td4 b2 = vd4.b();
        if (PMSConstants.a(b2)) {
            b2.m(sf4.j(str, map), jSONObject.toString(), new a(map, rf4Var));
            return;
        }
        kd4 postStringRequest = od4.g().postStringRequest();
        wd4.a(postStringRequest, map);
        postStringRequest.url(sf4.j(str, map)).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(b)) {
            postStringRequest.userAgent(b);
        }
        postStringRequest.cookieManager(a).enableStat(true).build().executeStat(rf4Var);
    }
}
