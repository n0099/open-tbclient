package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.q0.s.q.d2;
import c.a.r0.q2.r.f;
import c.a.r0.q2.y.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class VideoPbViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_DATA_TYPE_LOCAL_CACHE = 2;
    public static final int FIRST_DATA_TYPE_MEM_CACHE = 1;
    public static final int FIRST_DATA_TYPE_NETWORK = 3;
    public static final int FIRST_DATA_TYPE_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f47970b;

    /* renamed from: c  reason: collision with root package name */
    public int f47971c;

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
        this.a = new d();
        this.f47971c = 0;
    }

    public void bindPbModel(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) {
            this.f47970b = pbModel;
        }
    }

    public MutableLiveData<Integer> getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a() : (MutableLiveData) invokeV.objValue;
    }

    public f getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.b() : (f) invokeV.objValue;
    }

    public f getFirstLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.c() : (f) invokeV.objValue;
    }

    public MutableLiveData<Boolean> getIsDetailTabTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.d() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> getIsShowNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.e() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> getNextVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.f() : (MutableLiveData) invokeV.objValue;
    }

    public Rect getOriginArea() {
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

    public MutableLiveData<d2> getPreVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.h() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> getVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.i() : (MutableLiveData) invokeV.objValue;
    }

    public void init(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            this.a.w((Rect) intent.getParcelableExtra("video_origin_area"));
            boolean booleanExtra = intent.getBooleanExtra("key_jump_to_comment_area", false);
            String stringExtra = intent.getStringExtra("high_light_post_id");
            if (booleanExtra || !TextUtils.isEmpty(stringExtra)) {
                this.a.u(true);
            }
        }
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.k() : invokeV.booleanValue;
    }

    public boolean isJumpCommentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.l() : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a.m() : (MutableLiveData) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void loadNextVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.a.f().getValue() == null) {
            return;
        }
        f b0 = this.f47970b.b0(this.a.f().getValue());
        if (b0 != null) {
            this.a.j().addLast(this.a.b());
            this.a.o(b0);
            this.a.v(!ListUtils.isEmpty(b0.f()) ? b0.f().get(0) : null);
            this.a.x(this.a.j().getLast() != null ? this.a.j().getLast().O() : null);
            this.f47970b.p2(z ? 21 : 22);
            this.f47970b.G1(b0);
            this.a.s(true);
        }
    }

    public void loadPreVideo() {
        f pollLast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pollLast = this.a.j().pollLast()) == null) {
            return;
        }
        this.a.o(pollLast);
        this.a.v(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
        this.a.x(this.a.j().peekLast() != null ? this.a.j().peekLast().O() : null);
        this.f47970b.G1(pollLast);
        this.a.s(true);
    }

    public void loadTargetVideo(d2 d2Var) {
        f b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) || d2Var == null || (b0 = this.f47970b.b0(d2Var)) == null) {
            return;
        }
        this.a.j().addLast(this.a.b());
        this.a.o(b0);
        this.a.v(!ListUtils.isEmpty(b0.f()) ? b0.f().get(0) : null);
        this.a.x(this.a.j().getLast() != null ? this.a.j().getLast().O() : null);
        this.f47970b.p2(20);
        this.f47970b.G1(b0);
        this.a.s(true);
    }

    public void saveFirstLoadData(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, fVar, i2) == null) || i2 < this.f47971c) {
            return;
        }
        this.f47971c = i2;
        this.a.p(fVar);
        if (fVar != null) {
            d dVar = this.a;
            boolean z = true;
            if (fVar.s() != 1 && !fVar.g0()) {
                z = false;
            }
            dVar.q(z);
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.a.n(i2);
        }
    }

    public void setData(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048596, this, fVar, i2) == null) && i2 == 3) {
            this.a.o(fVar);
        }
    }

    public void setIsDetailTabTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.a.r(z);
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.a.s(z);
        }
    }

    public void setIsShowNavigationBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.a.t(z);
        }
    }

    public void setJumpCommentTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.a.u(z);
        }
    }
}
