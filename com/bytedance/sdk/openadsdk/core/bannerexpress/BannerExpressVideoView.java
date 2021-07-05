package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes6.dex */
public class BannerExpressVideoView extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerExpressVideoView(@NonNull Context context, m mVar, AdSlot adSlot) {
        super(context, mVar, adSlot);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], (AdSlot) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f29752a, this.f29755d, this.f29756e, this.j);
            this.f29753b = nativeExpressVideoView;
            addView(nativeExpressVideoView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            NativeExpressView nativeExpressView = this.f29753b;
            if (nativeExpressView != null) {
                return ((NativeExpressVideoView) nativeExpressView).getVideoModel();
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.multipro.b.a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setDuration(int i2) {
        super.setDuration(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        super.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        super.setVideoAdListener(expressVideoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.a
    public void a(m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar, adSlot) == null) {
            NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(this.f29752a, mVar, adSlot, this.j);
            this.f29754c = nativeExpressVideoView;
            nativeExpressVideoView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BannerExpressVideoView f29751a;

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
                    this.f29751a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    BannerExpressVideoView bannerExpressVideoView;
                    TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || (expressAdInteractionListener = (bannerExpressVideoView = this.f29751a).f29757f) == null) {
                        return;
                    }
                    expressAdInteractionListener.onAdClicked(bannerExpressVideoView, i2);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f2, float f3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                        this.f29751a.a(f2, f3);
                        this.f29751a.f();
                    }
                }
            });
            q.a((View) this.f29754c, 8);
            addView(this.f29754c, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
