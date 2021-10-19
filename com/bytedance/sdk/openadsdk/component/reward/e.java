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
    public final TTAdNative.RewardVideoAdListener f66200a;

    /* renamed from: b  reason: collision with root package name */
    public final TTAdNative.FullScreenVideoAdListener f66201b;

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
        this.f66200a = rewardVideoAdListener;
        this.f66201b = null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.c.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            if (this.f66200a != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, str, i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f66202a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f66203b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f66204c;

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
                        this.f66204c = this;
                        this.f66202a = str;
                        this.f66203b = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66204c.f66200a == null) {
                            return;
                        }
                        String str2 = this.f66202a;
                        if (str2 == null) {
                            str2 = "";
                        }
                        this.f66204c.f66200a.onError(this.f66203b, str2);
                    }
                });
            }
            if (this.f66201b != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, i2, str) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f66205a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f66206b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ e f66207c;

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
                        this.f66207c = this;
                        this.f66205a = i2;
                        this.f66206b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66207c.f66201b) == null) {
                            return;
                        }
                        fullScreenVideoAdListener.onError(this.f66205a, this.f66206b);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFullScreenVideoAd) == null) || this.f66201b == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this, tTFullScreenVideoAd) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTFullScreenVideoAd f66208a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f66209b;

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
                this.f66209b = this;
                this.f66208a = tTFullScreenVideoAd;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66209b.f66201b) == null) {
                    return;
                }
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(this.f66208a);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f66201b == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66210a;

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
                this.f66210a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (fullScreenVideoAdListener = this.f66210a.f66201b) == null) {
                    return;
                }
                fullScreenVideoAdListener.onFullScreenVideoCached();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tTRewardVideoAd) == null) || this.f66200a == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this, tTRewardVideoAd) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTRewardVideoAd f66211a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f66212b;

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
                this.f66212b = this;
                this.f66211a = tTRewardVideoAd;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardVideoAdListener = this.f66212b.f66200a) == null) {
                    return;
                }
                rewardVideoAdListener.onRewardVideoAdLoad(this.f66211a);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f66200a == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66213a;

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
                this.f66213a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (rewardVideoAdListener = this.f66213a.f66200a) == null) {
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
        this.f66200a = null;
        this.f66201b = fullScreenVideoAdListener;
    }
}
