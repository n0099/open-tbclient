package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vs0 implements ss0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    @NonNull
    public tp0 b;
    public ViewGroup c;

    public vs0(@NonNull tp0 tp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tp0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = tp0Var;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null) {
            lx0.b("NormalSwitchHelper", "SCREEN_ORIENTATION_PORTRAIT ");
            activity.setRequestedOrientation(1);
            activity.getWindow().clearFlags(1024);
            nx0.l(activity);
        }
    }

    public void a(boolean z, @Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, activity) == null) {
            if (z) {
                int i = this.a;
                if (i != -1) {
                    m21.d(activity, i);
                    return;
                }
                return;
            }
            m21.f(activity);
        }
    }

    @Override // com.baidu.tieba.ss0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = this.b.o();
            this.b.T0(true);
            Activity m = this.b.m();
            a(true, m);
            mx0.b(m, this.b.S0());
            mx0.c(m, true);
            nx0.b(m, this.b.w());
        }
    }

    @Override // com.baidu.tieba.ss0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c == null) {
            return;
        }
        this.c = this.b.o();
        this.b.T0(false);
        Activity m = this.b.m();
        a(false, m);
        b(m);
        nx0.k(this.b.w());
        nx0.j(this.b.o());
        nx0.c(this.b.w(), this.c);
    }
}
