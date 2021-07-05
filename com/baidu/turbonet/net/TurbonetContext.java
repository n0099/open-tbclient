package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class TurbonetContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TurbonetEngine f23108a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23109b;

    /* renamed from: c  reason: collision with root package name */
    public String f23110c;

    /* renamed from: d  reason: collision with root package name */
    public String f23111d;

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
        this.f23109b = context;
        this.f23110c = str;
        this.f23111d = str2;
        a(turbonetConfig);
    }

    public final void a(TurbonetConfig turbonetConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, turbonetConfig) == null) {
            TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.f23109b);
            if (turbonetConfig == null) {
                builder.r(this.f23110c);
                builder.q(this.f23111d);
                this.f23108a = builder.b();
            } else {
                if (turbonetConfig.h()) {
                    builder.u(turbonetConfig.l());
                }
                try {
                    if (turbonetConfig.g().has("nq") && turbonetConfig.g().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                        builder.e(true, "");
                    }
                } catch (JSONException e2) {
                    Log.e("cr_TurbonetContext", "JSON expcetion: " + e2);
                }
                builder.r(this.f23110c);
                builder.q(this.f23111d);
                builder.a(turbonetConfig.g().toString());
                this.f23108a = builder.b();
            }
            Log.v("cr_TurbonetContext", "Turbonet init context success.");
        }
    }

    public TurbonetEngine b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23108a : (TurbonetEngine) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23108a.d() : invokeV.longValue;
    }
}
