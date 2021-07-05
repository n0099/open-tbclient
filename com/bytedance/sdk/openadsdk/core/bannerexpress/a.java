package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes6.dex */
public class a extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f29752a;

    /* renamed from: b  reason: collision with root package name */
    public NativeExpressView f29753b;

    /* renamed from: c  reason: collision with root package name */
    public NativeExpressView f29754c;

    /* renamed from: d  reason: collision with root package name */
    public m f29755d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f29756e;

    /* renamed from: f  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f29757f;

    /* renamed from: g  reason: collision with root package name */
    public TTNativeExpressAd.ExpressVideoAdListener f29758g;

    /* renamed from: h  reason: collision with root package name */
    public int f29759h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29760i;
    public String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, m mVar, AdSlot adSlot) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = "banner_ad";
        this.f29752a = context;
        this.f29755d = mVar;
        this.f29756e = adSlot;
        a();
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, nativeExpressView)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
            ofFloat.addListener(new Animator.AnimatorListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29763a;

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
                    this.f29763a = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        a aVar = this.f29763a;
                        aVar.f29760i = false;
                        aVar.g();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                    }
                }
            });
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            NativeExpressView nativeExpressView = this.f29753b;
            this.f29753b = this.f29754c;
            this.f29754c = nativeExpressView;
            if (nativeExpressView != null) {
                removeView(nativeExpressView);
                this.f29754c.n();
                this.f29754c = null;
            }
        }
    }

    public void c() {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (nativeExpressView = this.f29754c) == null) {
            return;
        }
        nativeExpressView.k();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NativeExpressView nativeExpressView = this.f29753b;
            if (nativeExpressView != null) {
                removeView(nativeExpressView);
                this.f29753b.n();
                this.f29753b = null;
            }
            NativeExpressView nativeExpressView2 = this.f29754c;
            if (nativeExpressView2 != null) {
                removeView(nativeExpressView2);
                this.f29754c.n();
                this.f29754c = null;
            }
        }
    }

    public void e() {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (nativeExpressView = this.f29753b) == null) {
            return;
        }
        nativeExpressView.k();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f29760i || this.f29754c == null || this.f29753b == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f29753b)).with(b(this.f29754c));
        animatorSet.setDuration(this.f29759h).start();
        q.a((View) this.f29754c, 0);
        this.f29760i = true;
    }

    public NativeExpressView getCurView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29753b : (NativeExpressView) invokeV.objValue;
    }

    public NativeExpressView getNextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f29754c : (NativeExpressView) invokeV.objValue;
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f29759h = i2;
        }
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, expressAdInteractionListener) == null) {
            this.f29757f = expressAdInteractionListener;
            NativeExpressView nativeExpressView = this.f29753b;
            if (nativeExpressView != null) {
                nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29762a;

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
                        this.f29762a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i2) {
                        a aVar;
                        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || (expressAdInteractionListener2 = (aVar = this.f29762a).f29757f) == null) {
                            return;
                        }
                        expressAdInteractionListener2.onAdClicked(aVar, i2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i2) {
                        a aVar;
                        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) || (expressAdInteractionListener2 = (aVar = this.f29762a).f29757f) == null) {
                            return;
                        }
                        expressAdInteractionListener2.onRenderFail(aVar, str, i2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).p()) {
                                this.f29762a.a(f2, f3);
                            }
                            a aVar = this.f29762a;
                            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f29757f;
                            if (expressAdInteractionListener2 != null) {
                                expressAdInteractionListener2.onRenderSuccess(aVar, f2, f3);
                            }
                        }
                    }
                });
            }
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, expressVideoAdListener) == null) {
            this.f29758g = expressVideoAdListener;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NativeExpressView nativeExpressView = new NativeExpressView(this.f29752a, this.f29755d, this.f29756e, this.j);
            this.f29753b = nativeExpressView;
            addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void a(m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mVar, adSlot) == null) {
            NativeExpressView nativeExpressView = new NativeExpressView(this.f29752a, mVar, adSlot, this.j);
            this.f29754c = nativeExpressView;
            nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f29761a;

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
                    this.f29761a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    a aVar;
                    TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || (expressAdInteractionListener = (aVar = this.f29761a).f29757f) == null) {
                        return;
                    }
                    expressAdInteractionListener.onAdClicked(aVar, i2);
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
                        this.f29761a.a(f2, f3);
                        this.f29761a.f();
                    }
                }
            });
            q.a((View) this.f29754c, 8);
            addView(this.f29754c, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29754c != null : invokeV.booleanValue;
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            int b2 = (int) q.b(this.f29752a, f2);
            int b3 = (int) q.b(this.f29752a, f3);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(b2, b3);
            }
            layoutParams.width = b2;
            layoutParams.height = b3;
            setLayoutParams(layoutParams);
        }
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, nativeExpressView)) == null) ? ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth()) : (ObjectAnimator) invokeL.objValue;
    }
}
