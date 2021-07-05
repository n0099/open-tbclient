package com.bytedance.sdk.openadsdk.core.a;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.core.l;
/* loaded from: classes6.dex */
public class a implements TTAdNative.BannerAdListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TTAdNative.BannerAdListener f29665a;

    public a(TTAdNative.BannerAdListener bannerAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bannerAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29665a = bannerAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener
    public void onBannerAdLoad(TTBannerAd tTBannerAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tTBannerAd) == null) || this.f29665a == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f29665a.onBannerAdLoad(tTBannerAd);
        } else {
            l.d().post(new Runnable(this, tTBannerAd) { // from class: com.bytedance.sdk.openadsdk.core.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBannerAd f29669a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f29670b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tTBannerAd};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29670b = this;
                    this.f29669a = tTBannerAd;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29670b.f29665a.onBannerAdLoad(this.f29669a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.BannerAdListener, com.bytedance.sdk.openadsdk.c.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f29665a == null) {
            return;
        }
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f29665a.onError(i2, str);
        } else {
            l.d().post(new Runnable(this, i2, str) { // from class: com.bytedance.sdk.openadsdk.core.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f29666a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f29667b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f29668c;

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
                    this.f29668c = this;
                    this.f29666a = i2;
                    this.f29667b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29668c.f29665a.onError(this.f29666a, this.f29667b);
                    }
                }
            });
        }
    }
}
