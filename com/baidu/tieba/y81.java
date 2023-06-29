package com.baidu.tieba;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.aa1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class y81 implements r91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean c(@NonNull a91 a91Var, @NonNull String str);

    public abstract void d(@NonNull a91 a91Var, @NonNull String str);

    /* loaded from: classes8.dex */
    public static class a implements a91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final q91 a;

        public a(q91 q91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q91Var;
        }

        @Override // com.baidu.tieba.q91
        public boolean a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return this.a.a(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.q91
        @Nullable
        public Activity c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.c();
            }
            return (Activity) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q91
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.d();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.q91
        @Nullable
        public LinearLayout e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.e();
            }
            return (LinearLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q91
        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.f();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.q91
        @Nullable
        public FrameLayout h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.h();
            }
            return (FrameLayout) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q91
        @Nullable
        public aa1.d l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.l();
            }
            return (aa1.d) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q91
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

    public y81() {
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

    @Override // com.baidu.tieba.r91
    public final boolean a(@NonNull q91 q91Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, q91Var, str)) == null) {
            return c(new a(q91Var), str);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.r91
    public final void b(@NonNull q91 q91Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q91Var, str) == null) {
            d(new a(q91Var), str);
        }
    }
}
