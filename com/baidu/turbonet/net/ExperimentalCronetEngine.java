package com.baidu.turbonet.net;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.ExperimentalUrlRequest;
import com.baidu.turbonet.net.TurbonetEngine;
import com.baidu.turbonet.net.UrlRequest;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public abstract class ExperimentalCronetEngine extends TurbonetEngine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.turbonet.net.TurbonetEngine
    /* renamed from: f */
    public abstract ExperimentalUrlRequest.Builder d(String str, UrlRequest.Callback callback, Executor executor);

    /* loaded from: classes9.dex */
    public static class Builder extends TurbonetEngine.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            super(iCronetEngineBuilder);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iCronetEngineBuilder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ICronetEngineBuilder) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.turbonet.net.TurbonetEngine.Builder
        public /* bridge */ /* synthetic */ TurbonetEngine.Builder a(String str) {
            i(str);
            return this;
        }

        @Override // com.baidu.turbonet.net.TurbonetEngine.Builder
        public /* bridge */ /* synthetic */ TurbonetEngine.Builder f(String str) {
            l(str);
            return this;
        }

        @Override // com.baidu.turbonet.net.TurbonetEngine.Builder
        public /* bridge */ /* synthetic */ TurbonetEngine.Builder g(String str) {
            m(str);
            return this;
        }

        @Override // com.baidu.turbonet.net.TurbonetEngine.Builder
        public /* bridge */ /* synthetic */ TurbonetEngine.Builder h(String str) {
            n(str);
            return this;
        }

        public Builder i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                super.a(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                super.f(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder m(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                super.g(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                super.h(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.turbonet.net.TurbonetEngine.Builder
        /* renamed from: j */
        public ExperimentalCronetEngine b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.b();
            }
            return (ExperimentalCronetEngine) invokeV.objValue;
        }

        public Builder k(boolean z, String str) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048583, this, z, str)) == null) {
                this.a.c(z, str);
                return this;
            }
            return (Builder) invokeZL.objValue;
        }
    }

    public ExperimentalCronetEngine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
