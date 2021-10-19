package com.bytedance.sdk.openadsdk.core.a;

import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.l;
/* loaded from: classes9.dex */
public class e implements TTAdNative.InteractionAdListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TTAdNative.InteractionAdListener f66517a;

    public e(TTAdNative.InteractionAdListener interactionAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interactionAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66517a = interactionAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener, com.bytedance.sdk.openadsdk.c.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || this.f66517a == null) {
            return;
        }
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f66517a.onError(i2, str);
        } else {
            l.d().post(new Runnable(this, i2, str) { // from class: com.bytedance.sdk.openadsdk.core.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f66518a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f66519b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f66520c;

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
                    this.f66520c = this;
                    this.f66518a = i2;
                    this.f66519b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66520c.f66517a.onError(this.f66518a, this.f66519b);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.InteractionAdListener
    public void onInteractionAdLoad(TTInteractionAd tTInteractionAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTInteractionAd) == null) || this.f66517a == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f66517a.onInteractionAdLoad(tTInteractionAd);
        } else {
            l.d().post(new Runnable(this, tTInteractionAd) { // from class: com.bytedance.sdk.openadsdk.core.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTInteractionAd f66521a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f66522b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tTInteractionAd};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66522b = this;
                    this.f66521a = tTInteractionAd;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66522b.f66517a.onInteractionAdLoad(this.f66521a);
                    }
                }
            });
        }
    }
}
