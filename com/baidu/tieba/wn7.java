package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.fp5;
import com.baidu.tieba.gs5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final View b;
    public Function0<Unit> c;
    public Context d;
    public LoadingView e;
    public zr5 f;
    public fk5 g;

    public wn7(View rootView, View containerView, Function0<Unit> function0) {
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

    public static /* synthetic */ void h(wn7 wn7Var, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        wn7Var.g(str, z);
    }

    public static final void i(wn7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function0<Unit> function0 = this$0.c;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final void k(wn7 this$0, View view2) {
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
            zr5 zr5Var = this.f;
            if (zr5Var != null) {
                zr5Var.dettachView(this.b);
            }
            this.f = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fk5 fk5Var = this.g;
            if (fk5Var != null) {
                fk5Var.dettachView(this.b);
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
            zr5 zr5Var = new zr5(this.d);
            gs5.a aVar = new gs5.a();
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            aVar.b = !z2;
            aVar.a = str;
            aVar.f = z;
            aVar.g = 0;
            aVar.h = new View.OnClickListener() { // from class: com.baidu.tieba.qn7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        wn7.i(wn7.this, view2);
                    }
                }
            };
            zr5Var.a(aVar);
            zr5Var.setWrapStyle(true);
            zr5Var.attachView(this.b);
            this.f = zr5Var;
            fp5.a aVar2 = fp5.a;
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
            fk5 fk5Var = new fk5(this.d, new View.OnClickListener() { // from class: com.baidu.tieba.sn7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        wn7.k(wn7.this, view2);
                    }
                }
            });
            fk5Var.m(str);
            fk5Var.setWrapStyle(true);
            fk5Var.attachView(this.b);
            fk5Var.k(0);
            fk5Var.q();
            this.g = fk5Var;
            fp5.a aVar = fp5.a;
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
