package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l03 implements by2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vw1 a;
    public String b;
    public n03 c;
    public boolean d;
    public Context e;

    @Override // com.baidu.tieba.by2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public l03(Context context, @NonNull n03 n03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, n03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        this.c = n03Var;
        this.b = n03Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.b)) {
            cy2.a(this);
        }
    }

    @Override // com.baidu.tieba.by2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public n03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (n03) invokeV.objValue;
    }

    public vw1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                d82.i("VrVideo", "create player");
                this.a = ku2.D0().create();
            }
            return this.a;
        }
        return (vw1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            n03 n03Var = this.c;
            if (n03Var != null) {
                return n03Var.t;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.by2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d82.i("VrVideo", "onBackPressed");
            vw1 vw1Var = this.a;
            if (vw1Var != null && vw1Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.by2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d82.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            vw1 vw1Var = this.a;
            if (vw1Var != null) {
                vw1Var.stop();
                this.a = null;
            }
            cy2.k(this);
        }
    }

    public void g(n03 n03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, n03Var) == null) {
            d82.i("VrVideo", "Open Player " + n03Var.j);
            vw1 vw1Var = this.a;
            if (vw1Var != null) {
                vw1Var.e(n03Var, this.e);
            }
            this.c = n03Var;
        }
    }

    @Override // com.baidu.tieba.by2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.d) {
                    e().resume();
                }
                e().b();
            } else if (this.a != null) {
                this.d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    public void h(n03 n03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, n03Var) == null) {
            d82.b("VrVideo", "update 接口");
            vw1 vw1Var = this.a;
            if (vw1Var != null) {
                vw1Var.d(n03Var, true);
            }
            this.c = n03Var;
        }
    }
}
