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
public class ts2 implements jq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dp1 a;
    public String b;
    public vs2 c;
    public boolean d;
    public Context e;

    public ts2(Context context, @NonNull vs2 vs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vs2Var};
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
        this.c = vs2Var;
        this.b = vs2Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        kq2.a(this);
    }

    @Override // com.baidu.tieba.jq2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jq2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public vs2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (vs2) invokeV.objValue;
    }

    public dp1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                l02.i("VrVideo", "create player");
                this.a = sm2.D0().create();
            }
            return this.a;
        }
        return (dp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jq2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vs2 vs2Var = this.c;
            return vs2Var != null ? vs2Var.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(vs2 vs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vs2Var) == null) {
            l02.i("VrVideo", "Open Player " + vs2Var.j);
            dp1 dp1Var = this.a;
            if (dp1Var != null) {
                dp1Var.e(vs2Var, this.e);
            }
            this.c = vs2Var;
        }
    }

    public void h(vs2 vs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vs2Var) == null) {
            l02.b("VrVideo", "update 接口");
            dp1 dp1Var = this.a;
            if (dp1Var != null) {
                dp1Var.d(vs2Var, true);
            }
            this.c = vs2Var;
        }
    }

    @Override // com.baidu.tieba.jq2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.jq2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.jq2
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

    @Override // com.baidu.tieba.jq2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            l02.i("VrVideo", "onBackPressed");
            dp1 dp1Var = this.a;
            return dp1Var != null && dp1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jq2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l02.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            dp1 dp1Var = this.a;
            if (dp1Var != null) {
                dp1Var.stop();
                this.a = null;
            }
            kq2.k(this);
        }
    }
}
