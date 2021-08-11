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
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.component.a.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.Map;
/* loaded from: classes9.dex */
public class e implements w.a, TTBannerAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d f65279a;

    /* renamed from: b  reason: collision with root package name */
    public final a f65280b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f65281c;

    /* renamed from: d  reason: collision with root package name */
    public w f65282d;

    /* renamed from: e  reason: collision with root package name */
    public int f65283e;

    /* renamed from: f  reason: collision with root package name */
    public m f65284f;

    /* renamed from: g  reason: collision with root package name */
    public TTBannerAd.AdInteractionListener f65285g;

    /* renamed from: h  reason: collision with root package name */
    public TTAppDownloadListener f65286h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f65287i;

    /* renamed from: j  reason: collision with root package name */
    public final b f65288j;
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
        this.f65281c = context;
        this.f65280b = aVar;
        this.m = adSlot;
        this.f65284f = aVar.b();
        this.f65279a = new d(context);
        this.f65288j = b.a(this.f65281c);
        a(this.f65279a.b(), aVar);
        this.f65279a.a(this.f65284f.aH());
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65279a : (View) invokeV.objValue;
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
            this.f65279a.a(this.f65287i);
            return this.f65287i;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f65284f;
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
            m mVar = this.f65284f;
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
            this.f65285g = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tTAppDownloadListener) == null) {
            this.f65286h = tTAppDownloadListener;
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
        a(this.f65279a.b(), this.f65280b);
        this.f65279a.a();
        this.f65279a.a(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f65283e = i2;
        this.f65282d = new w(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, dislikeInteractionCallback) == null) {
            if (this.f65287i == null) {
                this.f65287i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f65281c, this.f65284f.aG(), this.l, false);
            }
            this.f65287i.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (wVar = this.f65282d) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dislikeInteractionCallback) == null) {
            b(dislikeInteractionCallback);
            this.f65279a.a(this.f65287i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (wVar = this.f65282d) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
        this.f65282d.sendEmptyMessageDelayed(1, this.f65283e);
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
            a();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f65288j.a(this.m, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f65289a;

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
                    this.f65289a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a(@NonNull a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        this.f65289a.a(aVar);
                        this.f65289a.f65279a.e();
                        this.f65289a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65289a.b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || this.f65279a.c() == null || this.f65279a.f()) {
            return;
        }
        a(this.f65279a.c(), aVar);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65281c, mVar, this.l);
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
            this.f65284f = b2;
            this.f65287i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f65281c, b2.aG(), this.l, false);
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
                a3 = new EmptyView(this.f65281c, cVar);
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
                public final /* synthetic */ m f65290a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f65291b;

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
                    this.f65291b = this;
                    this.f65290a = b2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.f65291b.k != null) {
                            if (z) {
                                if (this.f65291b.k != null) {
                                    this.f65291b.k.b();
                                }
                            } else if (this.f65291b.k != null) {
                                this.f65291b.k.c();
                            }
                        }
                        if (z) {
                            this.f65291b.b();
                            k.b("TTBannerAd", "获得焦点，开始计时");
                            return;
                        }
                        k.b("TTBannerAd", "失去焦点，停止计时");
                        this.f65291b.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f65291b.c();
                        if (this.f65291b.k != null) {
                            this.f65291b.k.d();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65291b.k == null) {
                        return;
                    }
                    this.f65291b.k.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f65291b.b();
                        k.b("TTBannerAd", "BANNER SHOW");
                        k.e("AdEvent", "pangolin ad show " + q.a(this.f65290a, view));
                        com.bytedance.sdk.openadsdk.e.d.a(this.f65291b.f65281c, this.f65290a, this.f65291b.l, (Map<String, Object>) null);
                        if (this.f65291b.f65285g != null) {
                            this.f65291b.f65285g.onAdShow(view, this.f65290a.X());
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.b.a aVar3 = new com.bytedance.sdk.openadsdk.core.b.a(this.f65281c, b2, this.l, 2);
            aVar3.a(cVar);
            aVar3.b(this.f65279a.d());
            aVar3.a(this.k);
            aVar3.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f65292a;

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
                    this.f65292a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f65292a.f65285g == null) {
                        return;
                    }
                    this.f65292a.f65285g.onAdClicked(view, i2);
                }
            });
            cVar.setOnClickListener(aVar3);
            cVar.setOnTouchListener(aVar3);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.k;
            if (aVar4 != null) {
                aVar4.a(this.f65286h);
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
