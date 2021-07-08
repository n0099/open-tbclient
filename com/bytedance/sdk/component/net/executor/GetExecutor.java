package com.bytedance.sdk.component.net.executor;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.d;
import com.bytedance.sdk.component.b.b.e;
import com.bytedance.sdk.component.b.b.f;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.t;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.utils.NetLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class GetExecutor extends NetExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final d FORCE_NET;
    public static final d Not_FORCE_NET;
    public static final String TAG = "GetExecutor";
    public transient /* synthetic */ FieldHolder $fh;
    public d cacheControl;
    public Map<String, String> paramsMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(883794391, "Lcom/bytedance/sdk/component/net/executor/GetExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(883794391, "Lcom/bytedance/sdk/component/net/executor/GetExecutor;");
                return;
            }
        }
        FORCE_NET = new d.a().a().c();
        Not_FORCE_NET = new d.a().c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetExecutor(w wVar) {
        super(wVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((w) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cacheControl = FORCE_NET;
        this.paramsMap = new HashMap();
    }

    public void addParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (str == null) {
                NetLog.i(TAG, "name cannot be null !!!");
            } else {
                this.paramsMap.put(str, str2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    public void enqueue(NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netCallback) == null) {
            z.a aVar = new z.a();
            t.a aVar2 = new t.a();
            try {
                Uri parse = Uri.parse(this.url);
                aVar2.a(parse.getScheme());
                aVar2.d(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar2.e(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.paramsMap.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.paramsMap.entrySet()) {
                    aVar2.a(entry.getKey(), entry.getValue());
                }
                for (Map.Entry<String, String> entry2 : this.requestHeadsMap.entrySet()) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
                aVar.a(this.cacheControl);
                aVar.a((Object) getTag());
                this.okHttpClient.a(aVar.a(aVar2.c()).a().d()).a(new f(this, netCallback) { // from class: com.bytedance.sdk.component.net.executor.GetExecutor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GetExecutor this$0;
                    public final /* synthetic */ NetCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, netCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = netCallback;
                    }

                    @Override // com.bytedance.sdk.component.b.b.f
                    public void onFailure(e eVar, IOException iOException) {
                        NetCallback netCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, eVar, iOException) == null) || (netCallback2 = this.val$callback) == null) {
                            return;
                        }
                        netCallback2.onFailure(this.this$0, iOException);
                    }

                    @Override // com.bytedance.sdk.component.b.b.f
                    public void onResponse(e eVar, ab abVar) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, abVar) == null) || this.val$callback == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        if (abVar != null) {
                            s g2 = abVar.g();
                            if (g2 != null) {
                                for (int i2 = 0; i2 < g2.a(); i2++) {
                                    hashMap.put(g2.a(i2), g2.b(i2));
                                }
                            }
                            this.val$callback.onResponse(this.this$0, new NetResponse(abVar.d(), abVar.c(), abVar.e(), hashMap, abVar.h().f(), abVar.l(), abVar.m()));
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
                netCallback.onFailure(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
            }
        }
    }

    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    public NetResponse execute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            z.a aVar = new z.a();
            t.a aVar2 = new t.a();
            try {
                Uri parse = Uri.parse(this.url);
                aVar2.a(parse.getScheme());
                aVar2.d(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    aVar2.e(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.paramsMap.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.paramsMap.entrySet()) {
                    aVar2.a(entry.getKey(), entry.getValue());
                }
                for (Map.Entry<String, String> entry2 : this.requestHeadsMap.entrySet()) {
                    aVar.b(entry2.getKey(), entry2.getValue());
                }
                aVar.a(this.cacheControl);
                aVar.a((Object) getTag());
                try {
                    ab b2 = this.okHttpClient.a(aVar.a(aVar2.c()).a().d()).b();
                    if (b2 != null) {
                        HashMap hashMap = new HashMap();
                        s g2 = b2.g();
                        if (g2 != null) {
                            for (int i2 = 0; i2 < g2.a(); i2++) {
                                hashMap.put(g2.a(i2), g2.b(i2));
                            }
                        }
                        return new NetResponse(b2.d(), b2.c(), b2.e(), hashMap, b2.h().f(), b2.l(), b2.m());
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (NetResponse) invokeV.objValue;
    }

    public void removeParams(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null) {
            return;
        }
        this.paramsMap.remove(str);
    }

    public void setShouldCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.cacheControl = Not_FORCE_NET;
            } else {
                this.cacheControl = FORCE_NET;
            }
        }
    }
}
