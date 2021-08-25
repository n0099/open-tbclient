package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes9.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static t f66831a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f66832b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66833c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66834d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f66835e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66836f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f66837g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66838h;

    public t() {
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
        this.f66833c = true;
        this.f66838h = false;
    }

    @MainThread
    public static t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f66831a == null) {
                f66831a = new t();
            }
            return f66831a;
        }
        return (t) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66833c : invokeV.booleanValue;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.e.m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66834d : (com.bytedance.sdk.openadsdk.core.e.m) invokeV.objValue;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66835e : (TTRewardVideoAd.RewardAdInteractionListener) invokeV.objValue;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66837g : (TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66836f : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f66832b = null;
            this.f66834d = null;
            this.f66835e = null;
            this.f66837g = null;
            this.f66836f = null;
            this.f66838h = false;
            this.f66833c = true;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f66838h = z;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f66833c = z;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            this.f66834d = mVar;
        }
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fullScreenVideoAdInteractionListener) == null) {
            this.f66837g = fullScreenVideoAdInteractionListener;
        }
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rewardAdInteractionListener) == null) {
            this.f66835e = rewardAdInteractionListener;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f66836f = aVar;
        }
    }
}
