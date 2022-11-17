package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.c58;
import com.baidu.tieba.ks4;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.px7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c58 a;
    public PbModel b;
    public int c;

    public VideoPbViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new c58();
        this.c = 0;
    }

    public MutableLiveData<Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.a();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public px7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.b();
        }
        return (px7) invokeV.objValue;
    }

    public px7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.c();
        }
        return (px7) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.d();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.e();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.f();
        }
        return (String) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.g();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public Rect i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a.h() != null && !this.a.h().isEmpty()) {
                return this.a.h();
            }
            return null;
        }
        return (Rect) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.i();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.j();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.l();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a.m();
        }
        return invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a.n();
        }
        return (MutableLiveData) invokeV.objValue;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) {
            this.b = pbModel;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.a.r(z);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.a.s(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.a.t(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.a.u(z);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.a.v(str);
        }
    }

    public void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            this.a.x((Rect) intent.getParcelableExtra("video_origin_area"));
            boolean booleanExtra = intent.getBooleanExtra("key_jump_to_comment_area", false);
            String stringExtra = intent.getStringExtra("high_light_post_id");
            if (booleanExtra || !TextUtils.isEmpty(stringExtra)) {
                this.a.u(true);
            }
        }
    }

    public void p(boolean z) {
        ks4 ks4Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && this.a.g().getValue() != null) {
            px7 c1 = this.b.c1(this.a.g().getValue());
            if (c1 != null) {
                this.a.k().addLast(this.a.b());
                this.a.o(c1);
                ThreadData threadData = null;
                if (!ListUtils.isEmpty(c1.f())) {
                    ks4Var = c1.f().get(0);
                } else {
                    ks4Var = null;
                }
                this.a.w(ks4Var);
                if (this.a.k().getLast() != null) {
                    threadData = this.a.k().getLast().Q();
                }
                this.a.y(threadData);
                PbModel pbModel = this.b;
                if (z) {
                    i = 21;
                } else {
                    i = 22;
                }
                pbModel.y3(i);
                this.b.O2(c1);
                this.a.s(true);
            }
        }
    }

    public void q() {
        px7 pollLast;
        ks4 ks4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (pollLast = this.a.k().pollLast()) != null) {
            this.a.o(pollLast);
            ThreadData threadData = null;
            if (!ListUtils.isEmpty(pollLast.f())) {
                ks4Var = pollLast.f().get(0);
            } else {
                ks4Var = null;
            }
            this.a.w(ks4Var);
            if (this.a.k().peekLast() != null) {
                threadData = this.a.k().peekLast().Q();
            }
            this.a.y(threadData);
            this.b.O2(pollLast);
            this.a.s(true);
        }
    }

    public void r(ThreadData threadData) {
        px7 c1;
        ks4 ks4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) && threadData != null && (c1 = this.b.c1(threadData)) != null) {
            this.a.k().addLast(this.a.b());
            this.a.o(c1);
            ThreadData threadData2 = null;
            if (!ListUtils.isEmpty(c1.f())) {
                ks4Var = c1.f().get(0);
            } else {
                ks4Var = null;
            }
            this.a.w(ks4Var);
            if (this.a.k().getLast() != null) {
                threadData2 = this.a.k().getLast().Q();
            }
            this.a.y(threadData2);
            this.b.y3(20);
            this.b.O2(c1);
            this.a.s(true);
        }
    }

    public void s(px7 px7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, px7Var, i) == null) && i >= this.c) {
            this.c = i;
            this.a.p(px7Var);
            if (px7Var != null) {
                c58 c58Var = this.a;
                boolean z = true;
                if (px7Var.s() != 1 && !px7Var.l0()) {
                    z = false;
                }
                c58Var.q(z);
            }
        }
    }

    public void t(px7 px7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048595, this, px7Var, i) == null) && i == 3) {
            this.a.o(px7Var);
        }
    }
}
