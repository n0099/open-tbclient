package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
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
public class pc4 {
    public static /* synthetic */ Interceptable $ic;
    public static CookieManager a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Map map, byte[] bArr, String str);
    }

    /* loaded from: classes5.dex */
    public final class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ tc4 b;

        public a(Map map, tc4 tc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, tc4Var};
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
            this.b = tc4Var;
        }

        @Override // com.baidu.tieba.pc4.c
        public void a(Map map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                PostByteRequest.PostByteRequestBuilder postByteRequest = qa4.g().postByteRequest();
                ya4.a(postByteRequest, this.a);
                ((PostByteRequest.PostByteRequestBuilder) ((PostByteRequest.PostByteRequestBuilder) postByteRequest.url(uc4.j(str, this.a))).content(bArr).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6)).requestSubFrom(10);
                if (map != null) {
                    postByteRequest.addHeaders(map);
                }
                if (!TextUtils.isEmpty(pc4.b)) {
                    postByteRequest.userAgent(pc4.b);
                }
                ((PostByteRequest.PostByteRequestBuilder) ((PostByteRequest.PostByteRequestBuilder) postByteRequest.cookieManager(pc4.a)).enableStat(true)).build().executeStat(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ tc4 b;

        public b(Map map, tc4 tc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, tc4Var};
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
            this.b = tc4Var;
        }

        @Override // com.baidu.tieba.pc4.c
        public void a(Map map, byte[] bArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, map, bArr, str) == null) {
                GetRequest.GetRequestBuilder getRequestBuilder = (GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) qa4.g().getRequest().url(uc4.j(str, this.a))).requestSubFrom(10);
                if (!TextUtils.isEmpty(pc4.b)) {
                    getRequestBuilder.userAgent(pc4.b);
                }
                if (map != null) {
                    getRequestBuilder.addHeaders(map);
                }
                ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) getRequestBuilder.cookieManager(pc4.a)).enableStat(true)).build().executeStat(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948057224, "Lcom/baidu/tieba/pc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948057224, "Lcom/baidu/tieba/pc4;");
                return;
            }
        }
        a = xa4.b().f();
        da4 b2 = ea4.b();
        if (b2 != null && qa4.g().c()) {
            b = b2.getUserAgent();
        }
    }

    @Deprecated
    public static void a(String str, Map map, Map map2, tc4 tc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65537, null, str, map, map2, tc4Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (tc4Var != null) {
            tc4Var.onStart();
        }
        va4 b2 = xa4.b();
        if (PMSConstants.a(b2)) {
            b2.m(uc4.j(str, map), null, new b(map, tc4Var));
            return;
        }
        GetRequest.GetRequestBuilder getRequestBuilder = (GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) qa4.g().getRequest().url(uc4.j(str, map))).requestSubFrom(10);
        if (!TextUtils.isEmpty(b)) {
            getRequestBuilder.userAgent(b);
        }
        if (map2 != null) {
            getRequestBuilder.addHeaders(map2);
        }
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) getRequestBuilder.cookieManager(a)).enableStat(true)).build().executeStat(tc4Var);
    }

    @Deprecated
    public static void b(String str, Map map, Map map2, JSONObject jSONObject, tc4 tc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65538, null, str, map, map2, jSONObject, tc4Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (tc4Var != null) {
            tc4Var.onStart();
        }
        va4 b2 = xa4.b();
        if (PMSConstants.a(b2)) {
            b2.m(uc4.j(str, map), jSONObject.toString(), new a(map, tc4Var));
            return;
        }
        ma4 postStringRequest = qa4.g().postStringRequest();
        ya4.a(postStringRequest, map);
        ((PostStringRequest.PostStringRequestBuilder) ((PostStringRequest.PostStringRequestBuilder) postStringRequest.url(uc4.j(str, map))).content(jSONObject.toString()).mediaType(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE)).requestFrom(6)).requestSubFrom(10);
        if (map2 != null) {
            postStringRequest.addHeaders(map2);
        }
        if (!TextUtils.isEmpty(b)) {
            postStringRequest.userAgent(b);
        }
        ((PostStringRequest.PostStringRequestBuilder) ((PostStringRequest.PostStringRequestBuilder) postStringRequest.cookieManager(a)).enableStat(true)).build().executeStat(tc4Var);
    }
}
