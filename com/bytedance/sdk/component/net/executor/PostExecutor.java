package com.bytedance.sdk.component.net.executor;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.e;
import com.bytedance.sdk.component.b.b.f;
import com.bytedance.sdk.component.b.b.q;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.v;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.utils.NetLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PostExecutor extends NetExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json; charset=utf-8";
    public static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String TAG = "PostExecutor";
    public transient /* synthetic */ FieldHolder $fh;
    public aa requestBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostExecutor(w wVar) {
        super(wVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((w) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestBody = null;
    }

    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    public void enqueue(NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, netCallback) == null) {
            z.a aVar = new z.a();
            if (TextUtils.isEmpty(this.url)) {
                netCallback.onFailure(this, new IOException("Url is Empty"));
                return;
            }
            try {
                aVar.a(this.url);
                if (this.requestBody == null) {
                    if (netCallback != null) {
                        netCallback.onFailure(this, new IOException("RequestBody is null, content type is not support!!"));
                        return;
                    }
                    return;
                }
                for (Map.Entry<String, String> entry : this.requestHeadsMap.entrySet()) {
                    aVar.b(entry.getKey(), entry.getValue());
                }
                aVar.a((Object) getTag());
                this.okHttpClient.a(aVar.a(this.requestBody).d()).a(new f(this, netCallback) { // from class: com.bytedance.sdk.component.net.executor.PostExecutor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PostExecutor this$0;
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
            } catch (IllegalArgumentException unused) {
                netCallback.onFailure(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
            }
        }
    }

    @Override // com.bytedance.sdk.component.net.executor.NetExecutor
    public NetResponse execute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            z.a aVar = new z.a();
            if (TextUtils.isEmpty(this.url)) {
                NetLog.i(TAG, "execute: Url is Empty");
                return null;
            }
            try {
                aVar.a(this.url);
                if (this.requestBody == null) {
                    NetLog.i(TAG, "RequestBody is null, content type is not support!!");
                    return null;
                }
                for (Map.Entry<String, String> entry : this.requestHeadsMap.entrySet()) {
                    aVar.b(entry.getKey(), entry.getValue());
                }
                aVar.a((Object) getTag());
                try {
                    ab b2 = this.okHttpClient.a(aVar.a(this.requestBody).d()).b();
                    if (b2 != null) {
                        HashMap hashMap = new HashMap();
                        s g2 = b2.g();
                        if (g2 != null) {
                            for (int i2 = 0; i2 < g2.a(); i2++) {
                                hashMap.put(g2.a(i2), g2.b(i2));
                            }
                            return new NetResponse(b2.d(), b2.c(), b2.e(), hashMap, b2.h().f(), b2.l(), b2.m());
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } catch (IllegalArgumentException unused) {
                NetLog.i(TAG, "execute: Url is not a valid HTTP or HTTPS URL");
                return null;
            }
        }
        return (NetResponse) invokeV.objValue;
    }

    public void setJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = StringUtil.EMPTY_ARRAY;
            }
            this.requestBody = aa.a(v.a("application/json; charset=utf-8"), str);
        }
    }

    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            q.a aVar = new q.a();
            if (map != null && !map.isEmpty()) {
                for (String str : map.keySet()) {
                    aVar.a(str, map.get(str));
                }
            }
            this.requestBody = aVar.a();
        }
    }

    public void setRequestBody(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bArr) == null) {
            this.requestBody = aa.a(v.a(str), bArr);
        }
    }

    public void setJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            this.requestBody = aa.a(v.a("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : StringUtil.EMPTY_ARRAY);
        }
    }
}
