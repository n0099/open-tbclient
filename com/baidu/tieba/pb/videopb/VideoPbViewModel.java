package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.p0.w2.i.f;
import c.a.p0.w2.q.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoPbViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f35183b;

    /* renamed from: c  reason: collision with root package name */
    public int f35184c;

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
        this.a = new e();
        this.f35184c = 0;
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) {
            this.f35183b = pbModel;
        }
    }

    public MutableLiveData<Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a() : (MutableLiveData) invokeV.objValue;
    }

    public f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.b() : (f) invokeV.objValue;
    }

    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.c() : (f) invokeV.objValue;
    }

    public MutableLiveData<Boolean> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.d() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.e() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.f() : (MutableLiveData) invokeV.objValue;
    }

    public Rect h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a.g() == null || this.a.g().isEmpty()) {
                return null;
            }
            return this.a.g();
        }
        return (Rect) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.h() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.i() : (MutableLiveData) invokeV.objValue;
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            this.a.v((Rect) intent.getParcelableExtra("video_origin_area"));
            boolean booleanExtra = intent.getBooleanExtra("key_jump_to_comment_area", false);
            String stringExtra = intent.getStringExtra("high_light_post_id");
            if (booleanExtra || !TextUtils.isEmpty(stringExtra)) {
                this.a.t(true);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.k() : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.l() : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.m() : (MutableLiveData) invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.a.f().getValue() == null) {
            return;
        }
        f d0 = this.f35183b.d0(this.a.f().getValue());
        if (d0 != null) {
            this.a.j().addLast(this.a.b());
            this.a.n(d0);
            this.a.u(!ListUtils.isEmpty(d0.f()) ? d0.f().get(0) : null);
            this.a.w(this.a.j().getLast() != null ? this.a.j().getLast().O() : null);
            this.f35183b.u2(z ? 21 : 22);
            this.f35183b.L1(d0);
            this.a.r(true);
        }
    }

    public void p() {
        f pollLast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pollLast = this.a.j().pollLast()) == null) {
            return;
        }
        this.a.n(pollLast);
        this.a.u(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
        this.a.w(this.a.j().peekLast() != null ? this.a.j().peekLast().O() : null);
        this.f35183b.L1(pollLast);
        this.a.r(true);
    }

    public void q(ThreadData threadData) {
        f d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) || threadData == null || (d0 = this.f35183b.d0(threadData)) == null) {
            return;
        }
        this.a.j().addLast(this.a.b());
        this.a.n(d0);
        this.a.u(!ListUtils.isEmpty(d0.f()) ? d0.f().get(0) : null);
        this.a.w(this.a.j().getLast() != null ? this.a.j().getLast().O() : null);
        this.f35183b.u2(20);
        this.f35183b.L1(d0);
        this.a.r(true);
    }

    public void r(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, fVar, i) == null) || i < this.f35184c) {
            return;
        }
        this.f35184c = i;
        this.a.o(fVar);
        if (fVar != null) {
            e eVar = this.a;
            boolean z = true;
            if (fVar.s() != 1 && !fVar.g0()) {
                z = false;
            }
            eVar.p(z);
        }
    }

    public void s(f fVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048594, this, fVar, i) == null) && i == 3) {
            this.a.n(fVar);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.a.q(z);
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
}
