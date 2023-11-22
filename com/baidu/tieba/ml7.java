package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.to5;
import com.baidu.tieba.ur5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ml7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final View b;
    public Function0<Unit> c;
    public Context d;
    public LoadingView e;
    public nr5 f;
    public wj5 g;

    public ml7(View rootView, View containerView, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rootView, containerView, function0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.a = rootView;
        this.b = containerView;
        this.c = function0;
        this.d = containerView.getContext();
    }

    public static /* synthetic */ void h(ml7 ml7Var, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        ml7Var.g(str, z);
    }

    public static final void i(ml7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.c;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void k(ml7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.c;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = null;
            d();
            b();
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            nr5 nr5Var = this.f;
            if (nr5Var != null) {
                nr5Var.dettachView(this.b);
            }
            this.f = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wj5 wj5Var = this.g;
            if (wj5Var != null) {
                wj5Var.dettachView(this.b);
            }
            this.g = null;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LoadingView loadingView = this.e;
            if (loadingView != null) {
                loadingView.dettachView(this.b);
            }
            this.e = null;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LoadingView loadingView = new LoadingView(this.d);
            loadingView.setWrapStyle(true);
            loadingView.attachView(this.b);
            loadingView.onChangeSkinType();
            this.e = loadingView;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.setVisibility(0);
            l();
            b();
            c();
        }
    }

    public final void e(boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
            this.a.setVisibility(0);
            d();
            if (z2) {
                h(this, str, false, 2, null);
            } else {
                j(str);
            }
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.a.setVisibility(0);
                d();
                g(TbadkCoreApplication.getInst().getString(R.string.no_data_common_txt), false);
                return;
            }
            this.a.setVisibility(8);
            d();
        }
    }

    public final void g(String str, boolean z) {
        boolean z2;
        z4 z4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            nr5 nr5Var = new nr5(this.d);
            ur5.a aVar = new ur5.a();
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            aVar.b = !z2;
            aVar.a = str;
            aVar.f = z;
            aVar.g = 0;
            aVar.h = new View.OnClickListener() { // from class: com.baidu.tieba.cl7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ml7.i(ml7.this, view2);
                    }
                }
            };
            nr5Var.a(aVar);
            nr5Var.setWrapStyle(true);
            nr5Var.attachView(this.b);
            this.f = nr5Var;
            to5.a aVar2 = to5.a;
            Context context = this.d;
            BdUniqueId bdUniqueId = null;
            if (context instanceof z4) {
                z4Var = (z4) context;
            } else {
                z4Var = null;
            }
            if (z4Var != null) {
                bdUniqueId = z4Var.getUniqueId();
            }
            aVar2.a(bdUniqueId, new Pair<>(PushMessageHelper.ERROR_TYPE, "new_frs_page"), new Pair<>("error_info", "new frs page full empty"));
        }
    }

    public final void j(String str) {
        z4 z4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            wj5 wj5Var = new wj5(this.d, new View.OnClickListener() { // from class: com.baidu.tieba.kl7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ml7.k(ml7.this, view2);
                    }
                }
            });
            wj5Var.l(str);
            wj5Var.setWrapStyle(true);
            wj5Var.attachView(this.b);
            wj5Var.j(0);
            wj5Var.o();
            this.g = wj5Var;
            to5.a aVar = to5.a;
            Context context = this.d;
            BdUniqueId bdUniqueId = null;
            if (context instanceof z4) {
                z4Var = (z4) context;
            } else {
                z4Var = null;
            }
            if (z4Var != null) {
                bdUniqueId = z4Var.getUniqueId();
            }
            aVar.a(bdUniqueId, new Pair<>(PushMessageHelper.ERROR_TYPE, "new_frs_page"), new Pair<>("error_info", "new frs page full error"));
        }
    }
}
