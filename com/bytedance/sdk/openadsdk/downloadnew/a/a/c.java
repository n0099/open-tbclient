package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import c.p.a.a.a.c.g;
import c.p.a.a.a.c.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.executor.PostExecutor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f67947a;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67947a = new WeakReference<>(context);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x009c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.bytedance.sdk.component.net.executor.PostExecutor] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.sdk.component.net.executor.GetExecutor] */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.bytedance.sdk.component.net.executor.NetExecutor] */
    @Override // c.p.a.a.a.c.g
    public void a(String str, String str2, Map<String, Object> map, r rVar) {
        char c2;
        ?? getExecutor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, map, rVar) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 70454) {
                if (hashCode == 2461856 && str.equals("POST")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("GET")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                getExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getGetExecutor();
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        getExecutor.addParams(entry.getKey(), entry.getValue().toString());
                    }
                }
            } else if (c2 != 1) {
                getExecutor = 0;
            } else {
                getExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    hashMap.put(entry2.getKey(), entry2.getValue().toString());
                }
                getExecutor.setParams(hashMap);
            }
            if (getExecutor != 0) {
                getExecutor.setUrl(str2);
                a(getExecutor.execute(), rVar);
            }
        }
    }

    @Override // c.p.a.a.a.c.g
    public void a(String str, byte[] bArr, String str2, int i2, r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), rVar}) == null) {
            if (bArr == null) {
                if (rVar != null) {
                    rVar.a(new Exception("request data is null"));
                    return;
                }
                return;
            }
            PostExecutor postExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getPostExecutor();
            postExecutor.setUrl(str);
            postExecutor.setRequestBody(str2, bArr);
            a(postExecutor.execute(), rVar);
        }
    }

    private void a(NetResponse netResponse, r rVar) {
        String valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, netResponse, rVar) == null) {
            if (netResponse != null && netResponse.isSuccess()) {
                if (rVar != null) {
                    rVar.a(netResponse.getBody());
                    return;
                }
                return;
            }
            boolean isEmpty = true ^ TextUtils.isEmpty(netResponse != null && netResponse.getMessage() != null ? netResponse.getMessage() : null);
            if (rVar != null) {
                if (isEmpty) {
                    valueOf = netResponse.getMessage();
                } else {
                    valueOf = netResponse != null ? String.valueOf(netResponse.getCode()) : "";
                }
                rVar.a(new Exception(valueOf));
            }
        }
    }
}
