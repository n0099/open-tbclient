package com.baidu.tieba;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.v51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class t41 implements m51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean c(@NonNull v41 v41Var, @NonNull String str);

    public abstract void d(@NonNull v41 v41Var, @NonNull String str);

    /* loaded from: classes8.dex */
    public static class a implements v41 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final l51 a;

        public a(l51 l51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l51Var;
        }

        @Override // com.baidu.tieba.l51
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return this.a.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.l51
        @Nullable
        public Activity b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.b();
            }
            return (Activity) invokeV.objValue;
        }

        @Override // com.baidu.tieba.l51
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.c();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.l51
        @Nullable
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.d();
            }
            return (LinearLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.l51
        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.h();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.l51
        @Nullable
        public FrameLayout j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.j();
            }
            return (FrameLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.l51
        @Nullable
        public v51.d l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.l();
            }
            return (v51.d) invokeV.objValue;
        }

        @Override // com.baidu.tieba.l51
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

    public t41() {
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

    @Override // com.baidu.tieba.m51
    public final boolean a(@NonNull l51 l51Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l51Var, str)) == null) {
            return c(new a(l51Var), str);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.m51
    public final void b(@NonNull l51 l51Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l51Var, str) == null) {
            d(new a(l51Var), str);
        }
    }
}
