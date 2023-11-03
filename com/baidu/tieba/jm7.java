package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class jm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityForumBinding a;
    public boolean b;
    public yk7 c;

    /* loaded from: classes6.dex */
    public static final class a implements oj6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm7 a;

        @Override // com.baidu.tieba.oj6
        public /* synthetic */ void d(int i, int i2, int i3, int i4) {
            nj6.a(this, i, i2, i3, i4);
        }

        public a(jm7 jm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm7Var;
        }

        @Override // com.baidu.tieba.oj6
        public void b(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                nj6.b(this, i, i2, i3, i4);
                yk7 yk7Var = this.a.c;
                if (yk7Var != null) {
                    yk7Var.I(0);
                }
            }
        }

        @Override // com.baidu.tieba.oj6
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            yk7 yk7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) && (yk7Var = this.a.c) != null) {
                yk7Var.I(i2);
            }
        }
    }

    public jm7(ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {binding};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.a = binding;
    }

    public final void f(int i) {
        yk7 yk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (yk7Var = this.c) != null) {
            yk7Var.onChangeSkinType(i);
        }
    }

    public static final void c(jm7 this$0, Function0 function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, function0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            yk7 yk7Var = this$0.c;
            if (yk7Var != null) {
                yk7Var.K();
            }
            this$0.b = true;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void k(pe7 data, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, data, z) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            yk7 yk7Var = this.c;
            if (yk7Var != null) {
                yk7Var.J(data, z);
            }
        }
    }

    public static /* synthetic */ void l(jm7 jm7Var, pe7 pe7Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        jm7Var.k(pe7Var, z);
    }

    public final void b(yk7 strategy, final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, strategy, function0) == null) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.b = false;
            yk7 yk7Var = this.c;
            if (yk7Var != null) {
                yk7Var.onDestroy();
            }
            this.c = strategy;
            this.a.d.setOnScrollChangeListener(new a(this));
            this.a.m.post(new Runnable() { // from class: com.baidu.tieba.em7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        jm7.c(jm7.this, function0);
                    }
                }
            });
        }
    }

    public final void d() {
        yk7 yk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yk7Var = this.c) != null) {
            yk7Var.G();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.t.setInterceptSelfScroll(false);
        }
    }

    public final void g() {
        yk7 yk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b && (yk7Var = this.c) != null) {
            yk7Var.onDestroy();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            yk7 yk7Var = this.c;
            if (yk7Var != null) {
                return yk7Var.c();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        yk7 yk7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.b || (yk7Var = this.c) == null) {
                return false;
            }
            return yk7Var.F();
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        yk7 yk7Var = this.c;
        if (yk7Var != null) {
            yk7Var.F();
        }
        this.a.t.setInterceptSelfScroll(true);
    }
}
