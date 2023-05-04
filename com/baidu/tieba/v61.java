package com.baidu.tieba;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.x71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class v61 implements o71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean c(@NonNull x61 x61Var, @NonNull String str);

    public abstract void d(@NonNull x61 x61Var, @NonNull String str);

    /* loaded from: classes6.dex */
    public static class a implements x61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final n71 a;

        public a(n71 n71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n71Var;
        }

        @Override // com.baidu.tieba.n71
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return this.a.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.n71
        @Nullable
        public Activity c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.c();
            }
            return (Activity) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n71
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.d();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.n71
        @Nullable
        public LinearLayout e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.e();
            }
            return (LinearLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n71
        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.g();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.n71
        @Nullable
        public FrameLayout i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.i();
            }
            return (FrameLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n71
        @Nullable
        public x71.d l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.l();
            }
            return (x71.d) invokeV.objValue;
        }

        @Override // com.baidu.tieba.n71
        @Nullable
        public AbsNadBrowserView m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a.m();
            }
            return (AbsNadBrowserView) invokeV.objValue;
        }
    }

    public v61() {
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

    @Override // com.baidu.tieba.o71
    public final boolean a(@NonNull n71 n71Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n71Var, str)) == null) {
            return c(new a(n71Var), str);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.o71
    public final void b(@NonNull n71 n71Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n71Var, str) == null) {
            d(new a(n71Var), str);
        }
    }
}
