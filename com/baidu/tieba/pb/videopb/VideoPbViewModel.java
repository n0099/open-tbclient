package com.baidu.tieba.pb.videopb;

import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.a.q0.s.q.d2;
import c.a.r0.k2.h.e;
import c.a.r0.k2.o.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoPbViewModel extends ViewModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_DATA_TYPE_LOCAL_CACHE = 2;
    public static final int FIRST_DATA_TYPE_MEM_CACHE = 1;
    public static final int FIRST_DATA_TYPE_NETWORK = 3;
    public static final int FIRST_DATA_TYPE_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f55622a;

    /* renamed from: b  reason: collision with root package name */
    public PbModel f55623b;

    /* renamed from: c  reason: collision with root package name */
    public int f55624c;

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
        this.f55622a = new d();
        this.f55624c = 0;
    }

    public void bindPbModel(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) {
            this.f55623b = pbModel;
        }
    }

    public MutableLiveData<Integer> getCurrentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55622a.a() : (MutableLiveData) invokeV.objValue;
    }

    public e getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55622a.b() : (e) invokeV.objValue;
    }

    public e getFirstLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55622a.c() : (e) invokeV.objValue;
    }

    public MutableLiveData<Boolean> getIsDetailTabTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55622a.d() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<Boolean> getIsShowNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55622a.e() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> getNextVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55622a.f() : (MutableLiveData) invokeV.objValue;
    }

    public Rect getOriginArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f55622a.g() == null || this.f55622a.g().isEmpty()) {
                return null;
            }
            return this.f55622a.g();
        }
        return (Rect) invokeV.objValue;
    }

    public MutableLiveData<d2> getPreVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55622a.h() : (MutableLiveData) invokeV.objValue;
    }

    public MutableLiveData<d2> getVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f55622a.i() : (MutableLiveData) invokeV.objValue;
    }

    public void init(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
            this.f55622a.w((Rect) intent.getParcelableExtra("video_origin_area"));
            boolean booleanExtra = intent.getBooleanExtra("key_jump_to_comment_area", false);
            String stringExtra = intent.getStringExtra("high_light_post_id");
            if (booleanExtra || !TextUtils.isEmpty(stringExtra)) {
                this.f55622a.u(true);
            }
        }
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f55622a.k() : invokeV.booleanValue;
    }

    public boolean isJumpCommentTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f55622a.l() : invokeV.booleanValue;
    }

    public MutableLiveData<Boolean> isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f55622a.m() : (MutableLiveData) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void loadNextVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.f55622a.f().getValue() == null) {
            return;
        }
        e a0 = this.f55623b.a0(this.f55622a.f().getValue());
        if (a0 != null) {
            this.f55622a.j().addLast(this.f55622a.b());
            this.f55622a.o(a0);
            this.f55622a.v(!ListUtils.isEmpty(a0.f()) ? a0.f().get(0) : null);
            this.f55622a.x(this.f55622a.j().getLast() != null ? this.f55622a.j().getLast().O() : null);
            this.f55623b.i2(z ? 21 : 22);
            this.f55623b.B1(a0);
            this.f55622a.s(true);
        }
    }

    public void loadPreVideo() {
        e pollLast;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pollLast = this.f55622a.j().pollLast()) == null) {
            return;
        }
        this.f55622a.o(pollLast);
        this.f55622a.v(!ListUtils.isEmpty(pollLast.f()) ? pollLast.f().get(0) : null);
        this.f55622a.x(this.f55622a.j().peekLast() != null ? this.f55622a.j().peekLast().O() : null);
        this.f55623b.B1(pollLast);
        this.f55622a.s(true);
    }

    public void loadTargetVideo(d2 d2Var) {
        e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) || d2Var == null || (a0 = this.f55623b.a0(d2Var)) == null) {
            return;
        }
        this.f55622a.j().addLast(this.f55622a.b());
        this.f55622a.o(a0);
        this.f55622a.v(!ListUtils.isEmpty(a0.f()) ? a0.f().get(0) : null);
        this.f55622a.x(this.f55622a.j().getLast() != null ? this.f55622a.j().getLast().O() : null);
        this.f55623b.i2(20);
        this.f55623b.B1(a0);
        this.f55622a.s(true);
    }

    public void saveFirstLoadData(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, eVar, i2) == null) || i2 < this.f55624c) {
            return;
        }
        this.f55624c = i2;
        this.f55622a.p(eVar);
        if (eVar != null) {
            d dVar = this.f55622a;
            boolean z = true;
            if (eVar.t() != 1 && !eVar.f0()) {
                z = false;
            }
            dVar.q(z);
        }
    }

    public void setCurrentTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f55622a.n(i2);
        }
    }

    public void setData(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048596, this, eVar, i2) == null) && i2 == 3) {
            this.f55622a.o(eVar);
        }
    }

    public void setIsDetailTabTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f55622a.r(z);
        }
    }

    public void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f55622a.s(z);
        }
    }

    public void setIsShowNavigationBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f55622a.t(z);
        }
    }

    public void setJumpCommentTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f55622a.u(z);
        }
    }
}
