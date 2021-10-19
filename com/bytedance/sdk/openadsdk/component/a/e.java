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
    public final d f66005a;

    /* renamed from: b  reason: collision with root package name */
    public final a f66006b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f66007c;

    /* renamed from: d  reason: collision with root package name */
    public w f66008d;

    /* renamed from: e  reason: collision with root package name */
    public int f66009e;

    /* renamed from: f  reason: collision with root package name */
    public m f66010f;

    /* renamed from: g  reason: collision with root package name */
    public TTBannerAd.AdInteractionListener f66011g;

    /* renamed from: h  reason: collision with root package name */
    public TTAppDownloadListener f66012h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f66013i;

    /* renamed from: j  reason: collision with root package name */
    public final b f66014j;
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
        this.f66007c = context;
        this.f66006b = aVar;
        this.m = adSlot;
        this.f66010f = aVar.b();
        this.f66005a = new d(context);
        this.f66014j = b.a(this.f66007c);
        a(this.f66005a.b(), aVar);
        this.f66005a.a(this.f66010f.aH());
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66005a : (View) invokeV.objValue;
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
            this.f66005a.a(this.f66013i);
            return this.f66013i;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f66010f;
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
            m mVar = this.f66010f;
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
            this.f66011g = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tTAppDownloadListener) == null) {
            this.f66012h = tTAppDownloadListener;
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
        a(this.f66005a.b(), this.f66006b);
        this.f66005a.a();
        this.f66005a.a(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f66009e = i2;
        this.f66008d = new w(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, dislikeInteractionCallback) == null) {
            if (this.f66013i == null) {
                this.f66013i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f66007c, this.f66010f.aG(), this.l, false);
            }
            this.f66013i.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (wVar = this.f66008d) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dislikeInteractionCallback) == null) {
            b(dislikeInteractionCallback);
            this.f66005a.a(this.f66013i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (wVar = this.f66008d) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
        this.f66008d.sendEmptyMessageDelayed(1, this.f66009e);
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
            this.f66014j.a(this.m, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66015a;

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
                    this.f66015a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a(@NonNull a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        this.f66015a.a(aVar);
                        this.f66015a.f66005a.e();
                        this.f66015a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.a.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66015a.b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || this.f66005a.c() == null || this.f66005a.f()) {
            return;
        }
        a(this.f66005a.c(), aVar);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66007c, mVar, this.l);
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
            this.f66010f = b2;
            this.f66013i = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f66007c, b2.aG(), this.l, false);
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
                a3 = new EmptyView(this.f66007c, cVar);
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
                public final /* synthetic */ m f66016a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f66017b;

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
                    this.f66017b = this;
                    this.f66016a = b2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.f66017b.k != null) {
                            if (z) {
                                if (this.f66017b.k != null) {
                                    this.f66017b.k.b();
                                }
                            } else if (this.f66017b.k != null) {
                                this.f66017b.k.c();
                            }
                        }
                        if (z) {
                            this.f66017b.b();
                            k.b("TTBannerAd", "获得焦点，开始计时");
                            return;
                        }
                        k.b("TTBannerAd", "失去焦点，停止计时");
                        this.f66017b.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f66017b.c();
                        if (this.f66017b.k != null) {
                            this.f66017b.k.d();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66017b.k == null) {
                        return;
                    }
                    this.f66017b.k.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f66017b.b();
                        k.b("TTBannerAd", "BANNER SHOW");
                        k.e("AdEvent", "pangolin ad show " + q.a(this.f66016a, view));
                        com.bytedance.sdk.openadsdk.e.d.a(this.f66017b.f66007c, this.f66016a, this.f66017b.l, (Map<String, Object>) null);
                        if (this.f66017b.f66011g != null) {
                            this.f66017b.f66011g.onAdShow(view, this.f66016a.X());
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.b.a aVar3 = new com.bytedance.sdk.openadsdk.core.b.a(this.f66007c, b2, this.l, 2);
            aVar3.a(cVar);
            aVar3.b(this.f66005a.d());
            aVar3.a(this.k);
            aVar3.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66018a;

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
                    this.f66018a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || this.f66018a.f66011g == null) {
                        return;
                    }
                    this.f66018a.f66011g.onAdClicked(view, i2);
                }
            });
            cVar.setOnClickListener(aVar3);
            cVar.setOnTouchListener(aVar3);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.k;
            if (aVar4 != null) {
                aVar4.a(this.f66012h);
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
