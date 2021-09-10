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
    public static t f67011a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.c f67012b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67013c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f67014d;

    /* renamed from: e  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f67015e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f67016f;

    /* renamed from: g  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f67017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67018h;

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
        this.f67013c = true;
        this.f67018h = false;
    }

    @MainThread
    public static t a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67011a == null) {
                f67011a = new t();
            }
            return f67011a;
        }
        return (t) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67013c : invokeV.booleanValue;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.e.m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67014d : (com.bytedance.sdk.openadsdk.core.e.m) invokeV.objValue;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67015e : (TTRewardVideoAd.RewardAdInteractionListener) invokeV.objValue;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67017g : (TTFullScreenVideoAd.FullScreenVideoAdInteractionListener) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67016f : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f67012b = null;
            this.f67014d = null;
            this.f67015e = null;
            this.f67017g = null;
            this.f67016f = null;
            this.f67018h = false;
            this.f67013c = true;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f67018h = z;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f67013c = z;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) {
            this.f67014d = mVar;
        }
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fullScreenVideoAdInteractionListener) == null) {
            this.f67017g = fullScreenVideoAdInteractionListener;
        }
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rewardAdInteractionListener) == null) {
            this.f67015e = rewardAdInteractionListener;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f67016f = aVar;
        }
    }
}
