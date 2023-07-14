package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class r88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment a;
    public boolean b;
    public String c;

    public r88(BaseFragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
    }

    @SuppressLint({"UseRequireInsteadOfGet"})
    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (this.a.getArguments() != null) {
                Bundle arguments = this.a.getArguments();
                Intrinsics.checkNotNull(arguments);
                this.b = arguments.getBoolean("tab_is_second_tab");
                Bundle arguments2 = this.a.getArguments();
                Intrinsics.checkNotNull(arguments2);
                this.c = arguments2.getString("tab_code");
            } else if (bundle != null) {
                this.b = bundle.getBoolean("tab_is_second_tab");
                this.c = bundle.getString("tab_code");
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m65.o(l65.h);
            m65.o(l65.a(this.c));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.b) {
            return;
        }
        if (this.a.isPrimary()) {
            c();
        } else {
            b();
        }
    }

    @SuppressLint({"UseRequireInsteadOfGet"})
    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a.getContext() == null) {
            return;
        }
        Context context = this.a.getContext();
        Intrinsics.checkNotNull(context);
        m65.p(context, l65.h);
        Context context2 = this.a.getContext();
        Intrinsics.checkNotNull(context2);
        m65.p(context2, l65.a(this.c));
    }
}
