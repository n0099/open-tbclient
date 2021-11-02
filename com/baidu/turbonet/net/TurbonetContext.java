package com.baidu.turbonet.net;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes10.dex */
public final class TurbonetContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TurbonetEngine f56577a;

    /* renamed from: b  reason: collision with root package name */
    public Context f56578b;

    /* renamed from: c  reason: collision with root package name */
    public String f56579c;

    /* renamed from: d  reason: collision with root package name */
    public String f56580d;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, turbonetConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56578b = context;
        this.f56579c = str;
        this.f56580d = str2;
        a(turbonetConfig);
    }

    public final void a(TurbonetConfig turbonetConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, turbonetConfig) == null) {
            TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.f56578b);
            if (turbonetConfig == null) {
                builder.q(this.f56579c);
                builder.p(this.f56580d);
                this.f56577a = builder.b();
                return;
            }
            if (turbonetConfig.h()) {
                builder.t(turbonetConfig.l());
            }
            try {
                if (turbonetConfig.g().has("nq") && turbonetConfig.g().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.e(true, "");
                }
            } catch (JSONException e2) {
                String str = "JSON expcetion: " + e2;
            }
            builder.q(this.f56579c);
            builder.p(this.f56580d);
            builder.a(turbonetConfig.g().toString());
            this.f56577a = builder.b();
        }
    }

    public TurbonetEngine b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56577a : (TurbonetEngine) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56577a.d() : invokeV.longValue;
    }
}
