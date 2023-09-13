package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mg3;
import com.baidu.tieba.ps4;
import com.baidu.tieba.st2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes7.dex */
public class ns4 extends ms4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ps4 z;

    @Override // com.baidu.tieba.ms4
    public void B0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ms4
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.st2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // com.baidu.tieba.ms4, com.baidu.tieba.st2
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ms4, com.baidu.tieba.st2
    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.st2
    public ZeusPluginFactory.Invoker e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements ps4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ns4 a;

        public a(ns4 ns4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ns4Var;
        }

        @Override // com.baidu.tieba.ps4.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.y0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements aq3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ns4 a;

        public b(ns4 ns4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ns4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 2) {
                    if (ms4.x) {
                        Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    st2.a aVar = this.a.i;
                    if (aVar != null) {
                        aVar.onError(0);
                        return;
                    }
                    return;
                }
                if (ms4.x) {
                    Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " real do prepareAsync");
                }
                ns4.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;
        public final /* synthetic */ ns4 b;

        public c(ns4 ns4Var, aq3 aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ns4Var, aq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ns4Var;
            this.a = aq3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                boolean h = fg3.h(kg3Var);
                if (ms4.x) {
                    Log.d("SwanInlineLiveWidget", this.b.f + "-" + hashCode() + " authorize: " + h);
                }
                ns4 ns4Var = this.b;
                if (h) {
                    i = 1;
                } else {
                    i = 2;
                }
                ns4Var.A = i;
                this.a.a(Integer.valueOf(this.b.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns4(ZeusPluginFactory.Invoker invoker, String str) {
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
        ps4 ps4Var = new ps4();
        this.z = ps4Var;
        ps4Var.e(this.c);
        this.z.f(new a(this));
    }

    public final void L0(@NonNull Context context, @NonNull aq3<Integer> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aq3Var) == null) {
            if (ms4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start authorize");
            }
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                if (!ms4.x) {
                    aq3Var.a(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (g73.r()) {
                this.A = 1;
                if (ms4.x) {
                    Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " authorize debug: true");
                }
                aq3Var.a(Integer.valueOf(this.A));
            } else {
                b0.e0().g(context, "mapp_i_live_player", new c(this, aq3Var));
            }
        }
    }

    @Override // com.baidu.tieba.ms4, com.baidu.tieba.st2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ms4, com.baidu.tieba.st2
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            ps4 ps4Var = this.z;
            if (ps4Var != null) {
                ps4Var.g();
                this.z = null;
            }
        }
    }

    @Override // com.baidu.tieba.ms4, com.baidu.tieba.st2
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ms4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start prepareAsync");
            }
            L0(this.c, new b(this));
            return true;
        }
        return invokeV.booleanValue;
    }
}
