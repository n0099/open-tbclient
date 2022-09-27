package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q83;
import com.baidu.tieba.tk4;
import com.baidu.tieba.wl2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes5.dex */
public class rk4 extends qk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public tk4 z;

    /* loaded from: classes5.dex */
    public class a implements tk4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk4 a;

        public a(rk4 rk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk4Var;
        }

        @Override // com.baidu.tieba.tk4.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.z0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ei3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk4 a;

        public b(rk4 rk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 2) {
                    if (qk4.x) {
                        Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    wl2.a aVar = this.a.i;
                    if (aVar != null) {
                        aVar.onError(0);
                        return;
                    }
                    return;
                }
                if (qk4.x) {
                    Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " real do prepareAsync");
                }
                rk4.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;
        public final /* synthetic */ rk4 b;

        public c(rk4 rk4Var, ei3 ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk4Var, ei3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rk4Var;
            this.a = ei3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                boolean h = j83.h(o83Var);
                if (qk4.x) {
                    Log.d("SwanInlineLiveWidget", this.b.f + "-" + hashCode() + " authorize: " + h);
                }
                this.b.A = h ? 1 : 2;
                this.a.a(Integer.valueOf(this.b.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk4(ZeusPluginFactory.Invoker invoker, String str) {
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
        tk4 tk4Var = new tk4();
        this.z = tk4Var;
        tk4Var.e(this.c);
        this.z.f(new a(this));
    }

    @Override // com.baidu.tieba.qk4
    public void C0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
        }
    }

    @Override // com.baidu.tieba.qk4
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void M0(@NonNull Context context, @NonNull ei3<Integer> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, ei3Var) == null) {
            if (qk4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start authorize");
            }
            l33 b0 = l33.b0();
            if (b0 == null) {
                if (!qk4.x) {
                    ei3Var.a(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (kz2.r()) {
                this.A = 1;
                if (qk4.x) {
                    Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " authorize debug: true");
                }
                ei3Var.a(Integer.valueOf(this.A));
            } else {
                b0.e0().g(context, "mapp_i_live_player", new c(this, ei3Var));
            }
        }
    }

    @Override // com.baidu.tieba.wl2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // com.baidu.tieba.qk4, com.baidu.tieba.wl2
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.qk4, com.baidu.tieba.wl2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // com.baidu.tieba.qk4, com.baidu.tieba.wl2
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.wl2
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qk4, com.baidu.tieba.wl2
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (qk4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start prepareAsync");
            }
            M0(this.c, new b(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qk4, com.baidu.tieba.wl2
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            tk4 tk4Var = this.z;
            if (tk4Var != null) {
                tk4Var.g();
                this.z = null;
            }
        }
    }
}
