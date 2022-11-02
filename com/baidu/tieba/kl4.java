package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j93;
import com.baidu.tieba.ml4;
import com.baidu.tieba.pm2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes4.dex */
public class kl4 extends jl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ml4 z;

    @Override // com.baidu.tieba.jl4
    public void B0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
        }
    }

    @Override // com.baidu.tieba.jl4
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pm2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // com.baidu.tieba.jl4, com.baidu.tieba.pm2
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jl4, com.baidu.tieba.pm2
    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.pm2
    public ZeusPluginFactory.Invoker e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements ml4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl4 a;

        public a(kl4 kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kl4Var;
        }

        @Override // com.baidu.tieba.ml4.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.y0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements xi3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl4 a;

        public b(kl4 kl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kl4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 2) {
                    if (jl4.x) {
                        Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    pm2.a aVar = this.a.i;
                    if (aVar != null) {
                        aVar.onError(0);
                        return;
                    }
                    return;
                }
                if (jl4.x) {
                    Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " real do prepareAsync");
                }
                kl4.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;
        public final /* synthetic */ kl4 b;

        public c(kl4 kl4Var, xi3 xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl4Var, xi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kl4Var;
            this.a = xi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                boolean h = c93.h(h93Var);
                if (jl4.x) {
                    Log.d("SwanInlineLiveWidget", this.b.f + "-" + hashCode() + " authorize: " + h);
                }
                kl4 kl4Var = this.b;
                if (h) {
                    i = 1;
                } else {
                    i = 2;
                }
                kl4Var.A = i;
                this.a.a(Integer.valueOf(this.b.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kl4(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 0;
        ml4 ml4Var = new ml4();
        this.z = ml4Var;
        ml4Var.e(this.c);
        this.z.f(new a(this));
    }

    public final void L0(@NonNull Context context, @NonNull xi3<Integer> xi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, xi3Var) == null) {
            if (jl4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start authorize");
            }
            e43 b0 = e43.b0();
            if (b0 == null) {
                if (!jl4.x) {
                    xi3Var.a(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (d03.r()) {
                this.A = 1;
                if (jl4.x) {
                    Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " authorize debug: true");
                }
                xi3Var.a(Integer.valueOf(this.A));
            } else {
                b0.e0().g(context, "mapp_i_live_player", new c(this, xi3Var));
            }
        }
    }

    @Override // com.baidu.tieba.jl4, com.baidu.tieba.pm2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jl4, com.baidu.tieba.pm2
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            ml4 ml4Var = this.z;
            if (ml4Var != null) {
                ml4Var.g();
                this.z = null;
            }
        }
    }

    @Override // com.baidu.tieba.jl4, com.baidu.tieba.pm2
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (jl4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start prepareAsync");
            }
            L0(this.c, new b(this));
            return true;
        }
        return invokeV.booleanValue;
    }
}
