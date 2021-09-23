package com.bytedance.sdk.openadsdk.component.reward;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes9.dex */
public class e implements TTAdNative.FullScreenVideoAdListener, TTAdNative.RewardVideoAdListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TTAdNative.RewardVideoAdListener f66165a;

    /* renamed from: b  reason: collision with root package name */
    public final TTAdNative.FullScreenVideoAdListener f66166b;

    public e(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rewardVideoAdListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66165a = rewardVideoAdListener;
        this.f66166b = null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.c.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            if (this.f66165a != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, str, i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f66167a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f66168b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f66169c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66169c = this;
                        this.f66167a = str;
                        this.f66168b = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66169c.f66165a == null) {
                            return;
                        }
                        String str2 = this.f66167a;
                        if (str2 == null) {
                            str2 = "";
                        }
                        this.f66169c.f66165a.onError(this.f66168b, str2);
                    }
                });
            }
            if (this.f66166b != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, i2, str) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f66170a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f66171b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f66172c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66172c = this;
                        this.f66170a = i2;
                        this.f66171b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66172c.f66166b) == null) {
                            return;
                        }
                        fullScreenVideoAdListener.onError(this.f66170a, this.f66171b);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFullScreenVideoAd) == null) || this.f66166b == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this, tTFullScreenVideoAd) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTFullScreenVideoAd f66173a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f66174b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, tTFullScreenVideoAd};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66174b = this;
                this.f66173a = tTFullScreenVideoAd;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66174b.f66166b) == null) {
                    return;
                }
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(this.f66173a);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f66166b == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66175a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66175a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66175a.f66166b) == null) {
                    return;
                }
                fullScreenVideoAdListener.onFullScreenVideoCached();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tTRewardVideoAd) == null) || this.f66165a == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this, tTRewardVideoAd) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTRewardVideoAd f66176a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f66177b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, tTRewardVideoAd};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66177b = this;
                this.f66176a = tTRewardVideoAd;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardVideoAdListener = this.f66177b.f66165a) == null) {
                    return;
                }
                rewardVideoAdListener.onRewardVideoAdLoad(this.f66176a);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f66165a == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66178a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66178a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardVideoAdListener = this.f66178a.f66165a) == null) {
                    return;
                }
                rewardVideoAdListener.onRewardVideoCached();
            }
        });
    }

    public e(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fullScreenVideoAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66165a = null;
        this.f66166b = fullScreenVideoAdListener;
    }
}
