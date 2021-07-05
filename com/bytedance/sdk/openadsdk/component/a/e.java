package com.bytedance.sdk.openadsdk.component.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.component.a.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.Map;
/* loaded from: classes6.dex */
public class e implements u.a, TTBannerAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f29191a;

    /* renamed from: b  reason: collision with root package name */
    public final a f29192b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f29193c;

    /* renamed from: d  reason: collision with root package name */
    public u f29194d;

    /* renamed from: e  reason: collision with root package name */
    public int f29195e;

    /* renamed from: f  reason: collision with root package name */
    public m f29196f;

    /* renamed from: g  reason: collision with root package name */
    public TTBannerAd.AdInteractionListener f29197g;

    /* renamed from: h  reason: collision with root package name */
    public TTAppDownloadListener f29198h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f29199i;
    public final b j;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a k;
    public String l;
    public AdSlot m;

    public e(Context context, a aVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "banner_ad";
        this.f29193c = context;
        this.f29192b = aVar;
        this.m = adSlot;
        this.f29196f = aVar.b();
        this.f29191a = new d(context);
        this.j = b.a(this.f29193c);
        a(this.f29191a.b(), aVar);
        this.f29191a.a(this.f29196f.aH());
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29191a : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dislikeInteractionCallback)) == null) {
            if (dislikeInteractionCallback == null) {
                return null;
            }
            b(dislikeInteractionCallback);
            this.f29191a.a(this.f29199i);
            return this.f29199i;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f29196f;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m mVar = this.f29196f;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.f29197g = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tTAppDownloadListener) == null) {
            this.f29198h = tTAppDownloadListener;
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.k;
            if (aVar != null) {
                aVar.a(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null) {
            return;
        }
        a(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.l = "slide_banner_ad";
        a(this.f29191a.b(), this.f29192b);
        this.f29191a.a();
        this.f29191a.a(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f29195e = i2;
        this.f29194d = new u(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, dislikeInteractionCallback) == null) {
            if (this.f29199i == null) {
                this.f29199i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f29193c, this.f29196f.aG(), this.l, false);
            }
            this.f29199i.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (uVar = this.f29194d) == null) {
            return;
        }
        uVar.removeCallbacksAndMessages(null);
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, dislikeInteractionCallback) == null) {
            b(dislikeInteractionCallback);
            this.f29191a.a(this.f29199i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (uVar = this.f29194d) == null) {
            return;
        }
        uVar.removeCallbacksAndMessages(null);
        this.f29194d.sendEmptyMessageDelayed(1, this.f29195e);
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
            a();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.j.a(this.m, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f29200a;

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
                    this.f29200a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a(@NonNull a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        this.f29200a.a(aVar);
                        this.f29200a.f29191a.e();
                        this.f29200a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29200a.b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || this.f29191a.c() == null || this.f29191a.f()) {
            return;
        }
        a(this.f29191a.c(), aVar);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f29193c, mVar, this.l);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull c cVar, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, cVar, aVar) == null) {
            cVar.a(aVar.a());
            m b2 = aVar.b();
            this.f29196f = b2;
            this.f29199i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f29193c, b2.aG(), this.l, false);
            cVar.a(b2);
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(b2);
            this.k = a2;
            if (a2 != null) {
                a2.b();
                if (cVar.getContext() != null && (cVar.getContext() instanceof Activity)) {
                    this.k.a((Activity) cVar.getContext());
                }
            }
            com.bytedance.sdk.openadsdk.e.d.a(b2);
            EmptyView a3 = a(cVar);
            if (a3 == null) {
                a3 = new EmptyView(this.f29193c, cVar);
                cVar.addView(a3);
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.a(a3);
            }
            a3.setCallback(new EmptyView.a(this, b2) { // from class: com.bytedance.sdk.openadsdk.component.a.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f29201a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f29202b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, b2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29202b = this;
                    this.f29201a = b2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.f29202b.k != null) {
                            if (z) {
                                if (this.f29202b.k != null) {
                                    this.f29202b.k.b();
                                }
                            } else if (this.f29202b.k != null) {
                                this.f29202b.k.c();
                            }
                        }
                        if (z) {
                            this.f29202b.b();
                            j.b("TTBannerAd", "获得焦点，开始计时");
                            return;
                        }
                        j.b("TTBannerAd", "失去焦点，停止计时");
                        this.f29202b.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f29202b.c();
                        if (this.f29202b.k != null) {
                            this.f29202b.k.d();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f29202b.k == null) {
                        return;
                    }
                    this.f29202b.k.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f29202b.b();
                        j.b("TTBannerAd", "BANNER SHOW");
                        j.e("AdEvent", "pangolin ad show " + o.a(this.f29201a, view));
                        com.bytedance.sdk.openadsdk.e.d.a(this.f29202b.f29193c, this.f29201a, this.f29202b.l, (Map<String, Object>) null);
                        if (this.f29202b.f29197g != null) {
                            this.f29202b.f29197g.onAdShow(view, this.f29201a.X());
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.b.a aVar3 = new com.bytedance.sdk.openadsdk.core.b.a(this.f29193c, b2, this.l, 2);
            aVar3.a(cVar);
            aVar3.b(this.f29191a.d());
            aVar3.a(this.k);
            aVar3.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f29203a;

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
                    this.f29203a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f29203a.f29197g == null) {
                        return;
                    }
                    this.f29203a.f29197g.onAdClicked(view, i2);
                }
            });
            cVar.setOnClickListener(aVar3);
            cVar.setOnTouchListener(aVar3);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.k;
            if (aVar4 != null) {
                aVar4.a(this.f29198h);
            }
            a3.setNeedCheckingShow(true);
        }
    }

    private EmptyView a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, viewGroup)) == null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            }
            return null;
        }
        return (EmptyView) invokeL.objValue;
    }
}
