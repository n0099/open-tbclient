package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ExperimentalCronetEngine;
import com.baidu.turbonet.net.ICronetEngineBuilder;
/* loaded from: classes7.dex */
public class o0b extends e0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.e0b, com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder a(String str) {
        super.g(str);
        return this;
    }

    @Override // com.baidu.tieba.e0b, com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder d(String str) {
        super.y(str);
        return this;
    }

    @Override // com.baidu.tieba.e0b, com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder e(String str) {
        super.z(str);
        return this;
    }

    @Override // com.baidu.tieba.e0b, com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder f(String str) {
        super.B(str);
        return this;
    }

    @Override // com.baidu.turbonet.net.ICronetEngineBuilder
    public ExperimentalCronetEngine b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (r() == null) {
                C(q());
            }
            return new n0b(this);
        }
        return (ExperimentalCronetEngine) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e0b, com.baidu.turbonet.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder c(boolean z, String str) {
        super.l(z, str);
        return this;
    }
}
