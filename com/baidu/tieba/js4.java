package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ig3;
import com.baidu.tieba.ls4;
import com.baidu.tieba.ot2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes6.dex */
public class js4 extends is4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ls4 z;

    @Override // com.baidu.tieba.is4
    public void B0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
        }
    }

    @Override // com.baidu.tieba.is4
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ot2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // com.baidu.tieba.is4, com.baidu.tieba.ot2
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.is4, com.baidu.tieba.ot2
    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.ot2
    public ZeusPluginFactory.Invoker e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ls4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js4 a;

        public a(js4 js4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js4Var;
        }

        @Override // com.baidu.tieba.ls4.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements wp3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js4 a;

        public b(js4 js4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
                if (num.intValue() == 2) {
                    if (is4.x) {
                        Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    ot2.a aVar = this.a.i;
                    if (aVar != null) {
                        aVar.onError(0);
                        return;
                    }
                    return;
                }
                if (is4.x) {
                    Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " real do prepareAsync");
                }
                js4.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ js4 b;

        public c(js4 js4Var, wp3 wp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js4Var, wp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = js4Var;
            this.a = wp3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                boolean h = bg3.h(gg3Var);
                if (is4.x) {
                    Log.d("SwanInlineLiveWidget", this.b.f + "-" + hashCode() + " authorize: " + h);
                }
                js4 js4Var = this.b;
                if (h) {
                    i = 1;
                } else {
                    i = 2;
                }
                js4Var.A = i;
                this.a.a(Integer.valueOf(this.b.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public js4(ZeusPluginFactory.Invoker invoker, String str) {
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
        ls4 ls4Var = new ls4();
        this.z = ls4Var;
        ls4Var.e(this.c);
        this.z.f(new a(this));
    }

    public final void L0(@NonNull Context context, @NonNull wp3<Integer> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, wp3Var) == null) {
            if (is4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start authorize");
            }
            db3 b0 = db3.b0();
            if (b0 == null) {
                if (!is4.x) {
                    wp3Var.a(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (c73.r()) {
                this.A = 1;
                if (is4.x) {
                    Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " authorize debug: true");
                }
                wp3Var.a(Integer.valueOf(this.A));
            } else {
                b0.e0().g(context, "mapp_i_live_player", new c(this, wp3Var));
            }
        }
    }

    @Override // com.baidu.tieba.is4, com.baidu.tieba.ot2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.is4, com.baidu.tieba.ot2
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            ls4 ls4Var = this.z;
            if (ls4Var != null) {
                ls4Var.g();
                this.z = null;
            }
        }
    }

    @Override // com.baidu.tieba.is4, com.baidu.tieba.ot2
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (is4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start prepareAsync");
            }
            L0(this.c, new b(this));
            return true;
        }
        return invokeV.booleanValue;
    }
}
