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
/* loaded from: classes6.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static t f30424a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f30425b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30426c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f30427d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f30428e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f30429f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f30430g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30431h;

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
        this.f30426c = true;
        this.f30431h = false;
    }

    @MainThread
    public static t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f30424a == null) {
                f30424a = new t();
            }
            return f30424a;
        }
        return (t) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30426c : invokeV.booleanValue;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.e.m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30427d : (com.bytedance.sdk.openadsdk.core.e.m) invokeV.objValue;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30428e : (TTRewardVideoAd.RewardAdInteractionListener) invokeV.objValue;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30430g : (TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30429f : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f30425b = null;
            this.f30427d = null;
            this.f30428e = null;
            this.f30430g = null;
            this.f30429f = null;
            this.f30431h = false;
            this.f30426c = true;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f30431h = z;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f30426c = z;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            this.f30427d = mVar;
        }
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fullScreenVideoAdInteractionListener) == null) {
            this.f30430g = fullScreenVideoAdInteractionListener;
        }
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rewardAdInteractionListener) == null) {
            this.f30428e = rewardAdInteractionListener;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f30429f = aVar;
        }
    }
}
