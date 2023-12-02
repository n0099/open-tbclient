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
/* loaded from: classes9.dex */
public final class zo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityForumBinding a;
    public boolean b;
    public in7 c;

    /* loaded from: classes9.dex */
    public static final class a implements ck6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo7 a;

        @Override // com.baidu.tieba.ck6
        public /* synthetic */ void d(int i, int i2, int i3, int i4) {
            bk6.a(this, i, i2, i3, i4);
        }

        public a(zo7 zo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo7Var;
        }

        @Override // com.baidu.tieba.ck6
        public void b(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                bk6.b(this, i, i2, i3, i4);
                in7 in7Var = this.a.c;
                if (in7Var != null) {
                    in7Var.J(0);
                }
            }
        }

        @Override // com.baidu.tieba.ck6
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            in7 in7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) && (in7Var = this.a.c) != null) {
                in7Var.J(i2);
            }
        }
    }

    public zo7(ActivityForumBinding binding) {
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
        in7 in7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (in7Var = this.c) != null) {
            in7Var.onChangeSkinType(i);
        }
    }

    public static final void c(zo7 this$0, Function0 function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, function0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            in7 in7Var = this$0.c;
            if (in7Var != null) {
                in7Var.L();
            }
            this$0.b = true;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void k(hf7 data, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, data, z) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            in7 in7Var = this.c;
            if (in7Var != null) {
                in7Var.K(data, z);
            }
        }
    }

    public final void b(in7 strategy, final Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, strategy, function0) == null) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.b = false;
            in7 in7Var = this.c;
            if (in7Var != null) {
                in7Var.onDestroy();
            }
            this.c = strategy;
            this.a.d.setOnScrollChangeListener(new a(this));
            this.a.m.post(new Runnable() { // from class: com.baidu.tieba.so7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        zo7.c(zo7.this, function0);
                    }
                }
            });
        }
    }

    public final void d() {
        in7 in7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (in7Var = this.c) != null) {
            in7Var.G();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.t.setInterceptSelfScroll(false);
        }
    }

    public final void g() {
        in7 in7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b && (in7Var = this.c) != null) {
            in7Var.onDestroy();
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            in7 in7Var = this.c;
            if (in7Var != null) {
                return in7Var.c();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        in7 in7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.b || (in7Var = this.c) == null) {
                return false;
            }
            return in7Var.F();
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.b) {
            return;
        }
        in7 in7Var = this.c;
        if (in7Var != null) {
            in7Var.F();
        }
        this.a.t.setInterceptSelfScroll(true);
    }
}
