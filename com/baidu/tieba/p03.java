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
/* loaded from: classes7.dex */
public class p03 implements fy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zw1 a;
    public String b;
    public r03 c;
    public boolean d;
    public Context e;

    @Override // com.baidu.tieba.fy2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public p03(Context context, @NonNull r03 r03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, r03Var};
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
        this.c = r03Var;
        this.b = r03Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.b)) {
            gy2.a(this);
        }
    }

    @Override // com.baidu.tieba.fy2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public r03 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (r03) invokeV.objValue;
    }

    public zw1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                h82.i("VrVideo", "create player");
                this.a = ou2.D0().create();
            }
            return this.a;
        }
        return (zw1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r03 r03Var = this.c;
            if (r03Var != null) {
                return r03Var.t;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fy2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            h82.i("VrVideo", "onBackPressed");
            zw1 zw1Var = this.a;
            if (zw1Var != null && zw1Var.onBackPressed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fy2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            h82.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            zw1 zw1Var = this.a;
            if (zw1Var != null) {
                zw1Var.stop();
                this.a = null;
            }
            gy2.k(this);
        }
    }

    public void g(r03 r03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, r03Var) == null) {
            h82.i("VrVideo", "Open Player " + r03Var.j);
            zw1 zw1Var = this.a;
            if (zw1Var != null) {
                zw1Var.e(r03Var, this.e);
            }
            this.c = r03Var;
        }
    }

    @Override // com.baidu.tieba.fy2
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

    public void h(r03 r03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, r03Var) == null) {
            h82.b("VrVideo", "update 接口");
            zw1 zw1Var = this.a;
            if (zw1Var != null) {
                zw1Var.d(r03Var, true);
            }
            this.c = r03Var;
        }
    }
}
