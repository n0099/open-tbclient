package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ExperimentalCronetEngine;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import org.json.JSONException;
/* loaded from: classes7.dex */
public final class o7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TurbonetEngine a;
    public Context b;
    public String c;
    public String d;

    public o7b(Context context, String str, String str2, n7b n7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, n7bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = str;
        this.d = str2;
        a(n7bVar);
    }

    public final void a(n7b n7bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, n7bVar) == null) {
            ExperimentalCronetEngine.Builder builder = new ExperimentalCronetEngine.Builder(this.b);
            if (n7bVar == null) {
                builder.g(this.c);
                builder.f(this.d);
                this.a = builder.b();
            } else {
                if (n7bVar.h()) {
                    builder.h(n7bVar.l());
                }
                try {
                    if (n7bVar.g().has("nq") && n7bVar.g().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                        builder.k(true, "");
                    }
                } catch (JSONException e) {
                    Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
                }
                builder.g(this.c);
                builder.f(this.d);
                builder.a(n7bVar.g().toString());
                this.a = builder.b();
            }
            Log.v("cr_TurbonetContext", "Turbonet init context success.");
        }
    }

    public TurbonetEngine b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (TurbonetEngine) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new VersionSafeCallbacks.f(this.a).a();
        }
        return invokeV.longValue;
    }
}
