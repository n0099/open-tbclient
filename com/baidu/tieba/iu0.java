package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class iu0 implements au0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nr0 a;
    public ViewGroup b;

    public iu0(@NonNull nr0 nr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nr0Var;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int M = this.a.M();
            int J = this.a.J();
            return M <= 0 || J <= 0 || M > J;
        }
        return invokeV.booleanValue;
    }

    public final void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        activity.getWindow().addFlags(128);
    }

    @Override // com.baidu.tieba.au0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = this.a.n();
            this.a.Y0(true);
            Activity activity = this.a.getActivity();
            if (a()) {
                vy0.a(activity, this.a.X0());
            }
            b(activity);
            fz0.b(activity, this.a.v());
        }
    }

    @Override // com.baidu.tieba.au0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b == null) {
            return;
        }
        this.b = this.a.n();
        this.a.Y0(false);
        vy0.b(this.a.getActivity());
        fz0.k(this.a.v());
        fz0.j(this.a.n());
        fz0.c(this.a.v(), this.b);
    }
}
