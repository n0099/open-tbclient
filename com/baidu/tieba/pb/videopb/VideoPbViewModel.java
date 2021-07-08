package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.h2.h.e;
import d.a.p0.h2.o.d;
/* loaded from: classes4.dex */
public class VideoPbViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f19804a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f19805b;

    /* renamed from: c  reason: collision with root package name */
    public int f19806c;

    public VideoPbViewModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19804a = new d();
        this.f19806c = 0;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) {
            this.f19805b = pbModel;
        }
    }

    public MutableLiveData<Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19804a.a() : (MutableLiveData) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19804a.b() : (e) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19804a.c() : (e) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19804a.d() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19804a.e() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<b2> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19804a.f() : (MutableLiveData) invokeV.objValue;
    }

    public Rect h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f19804a.g() == null || this.f19804a.g().isEmpty()) {
                return null;
            }
            return this.f19804a.g();
        }
        return (Rect) invokeV.objValue;
    }

    public MutableLiveData<b2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19804a.h() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<b2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19804a.i() : (MutableLiveData) invokeV.objValue;
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            this.f19804a.v((Rect) intent.getParcelableExtra(PbActivityConfig.VIDEO_ORIGIN_AREA));
            this.f19804a.t(intent.getBooleanExtra("key_jump_to_comment_area", false));
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f19804a.k() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19804a.l() : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f19804a.m() : (MutableLiveData) invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.f19804a.f().getValue() == null) {
            return;
        }
        e Q = this.f19805b.Q(this.f19804a.f().getValue());
        if (Q != null) {
            this.f19804a.j().addLast(this.f19804a.b());
            this.f19804a.n(Q);
            this.f19804a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
            this.f19804a.w(this.f19804a.j().getLast() != null ? this.f19804a.j().getLast().N() : null);
            this.f19805b.R1(z ? 21 : 22);
            this.f19805b.m1(Q);
            this.f19804a.r(true);
        }
    }

    public void p() {
        e pollLast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pollLast = this.f19804a.j().pollLast()) == null) {
            return;
        }
        this.f19804a.n(pollLast);
        this.f19804a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
        this.f19804a.w(this.f19804a.j().peekLast() != null ? this.f19804a.j().peekLast().N() : null);
        this.f19805b.m1(pollLast);
        this.f19804a.r(true);
    }

    public void q(b2 b2Var) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, b2Var) == null) || b2Var == null || (Q = this.f19805b.Q(b2Var)) == null) {
            return;
        }
        this.f19804a.j().addLast(this.f19804a.b());
        this.f19804a.n(Q);
        this.f19804a.u(!ListUtils.isEmpty(Q.f()) ? Q.f().get(0) : null);
        this.f19804a.w(this.f19804a.j().getLast() != null ? this.f19804a.j().getLast().N() : null);
        this.f19805b.R1(20);
        this.f19805b.m1(Q);
        this.f19804a.r(true);
    }

    public void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, eVar, i2) == null) || i2 < this.f19806c) {
            return;
        }
        this.f19806c = i2;
        this.f19804a.o(eVar);
        if (eVar != null) {
            d dVar = this.f19804a;
            boolean z = true;
            if (eVar.t() != 1 && !eVar.e0()) {
                z = false;
            }
            dVar.p(z);
        }
    }

    public void s(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, eVar, i2) == null) && i2 == 3) {
            this.f19804a.n(eVar);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f19804a.q(z);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f19804a.r(z);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f19804a.s(z);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f19804a.t(z);
        }
    }
}
