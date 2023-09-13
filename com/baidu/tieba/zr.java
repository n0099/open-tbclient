package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes9.dex */
public class zr<T> extends as {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public ResponseCallback<T> e;
    public int f;

    @Override // com.baidu.tieba.as
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;
        public final /* synthetic */ zr b;

        public a(zr zrVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zrVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zrVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, response, i)) == null) {
                Headers headers = response.headers();
                if (headers != null && TextUtils.equals(headers.get("Bdtls"), Constants.RECOVERY_DIRECTORY)) {
                    ds.b().i().b(0);
                    return Constants.RECOVERY_DIRECTORY;
                }
                zr zrVar = this.b;
                if (zrVar.a) {
                    ResponseBody body = response.body();
                    String g = this.b.g(body.bytes());
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("BdtlsPostRequest parseResponse=" + g);
                    if (this.b.b == 1) {
                        Buffer buffer = new Buffer();
                        buffer.writeString(g, Charset.forName("utf-8"));
                        Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                        if (this.b.e != null) {
                            this.a = (T) this.b.e.parseResponse(build, i);
                        }
                    }
                    return g;
                } else if (zrVar.e != null) {
                    this.a = (T) this.b.e.parseResponse(response, i);
                    return "";
                } else {
                    return "";
                }
            }
            return (String) invokeLI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onSuccess=" + str);
                if (TextUtils.equals(str, Constants.RECOVERY_DIRECTORY)) {
                    if (ds.b().i().m()) {
                        ds.b().i().f();
                        this.b.e(true);
                        this.b.k();
                        return;
                    }
                    this.b.e.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                    return;
                }
                ds.b().i().n();
                zr zrVar = this.b;
                if (zrVar.a) {
                    if (zrVar.b == 1) {
                        if (zrVar.e != null) {
                            this.b.e.onSuccess(this.a, i);
                        }
                        this.b.f = 0;
                    } else if (zr.m(zrVar) >= 3) {
                        ResponseCallback responseCallback = this.b.e;
                        responseCallback.onFail(new IOException("request fail : " + this.a));
                        this.b.f = 0;
                    } else {
                        zr zrVar2 = this.b;
                        zrVar2.j(zrVar2.c, this.b.d, this.b.e);
                    }
                } else if (zrVar.e != null) {
                    this.b.e.onSuccess(this.a, i);
                    this.b.f = 0;
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("BdtlsPostRequest onFail=" + exc.getMessage());
                if (this.b.e != null) {
                    this.b.e.onFail(exc);
                }
            }
        }
    }

    public zr() {
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
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j(this.c, this.d, this.e);
        }
    }

    public static /* synthetic */ int m(zr zrVar) {
        int i = zrVar.f;
        zrVar.f = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.as
    public void c(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, iOException) == null) && (responseCallback = this.e) != null) {
            responseCallback.onFail(iOException);
        }
    }

    @Override // com.baidu.tieba.as
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("onRequestError=" + i);
            ResponseCallback<T> responseCallback = this.e;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i));
            }
        }
    }

    @Override // com.baidu.tieba.as
    public void f(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.c;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
                hashMap.put("Bdtls-Content-Type", "json");
            }
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("BdtlsPostRequest url=" + str);
            HttpManager.getDefault(hr.c.h().getAppContext()).postByteRequest().mediaType("application/json").url(str).cookieManager(CookieManager.WEBKIT_COOKIES).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public void j(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, str, str2, responseCallback) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
        this.d = str2;
        this.e = responseCallback;
        DebugTrace debugTrace = DebugTrace.a;
        debugTrace.a("requestPost url=" + str);
        DebugTrace debugTrace2 = DebugTrace.a;
        debugTrace2.a("requestPost body=" + str2);
        d(this.d);
    }
}
