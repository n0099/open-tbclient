package com.bytedance.sdk.openadsdk.core.bannerexpress;

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
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.r;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes9.dex */
public class b extends r implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f66247a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66248b;

    /* renamed from: c  reason: collision with root package name */
    public m f66249c;

    /* renamed from: d  reason: collision with root package name */
    public AdSlot f66250d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f66251e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f66252f;

    /* renamed from: g  reason: collision with root package name */
    public TTDislikeDialogAbstract f66253g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f66254h;

    /* renamed from: i  reason: collision with root package name */
    public w f66255i;

    /* renamed from: j  reason: collision with root package name */
    public int f66256j;
    public TTAdDislike.DislikeInteractionCallback k;
    public Context l;
    public String o;
    public final Queue<Long> p;

    public b(Context context, m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = "banner_ad";
        this.p = new LinkedList();
        this.f66248b = context;
        this.f66249c = mVar;
        this.f66250d = adSlot;
        a(context, mVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f66247a) == null) {
            return;
        }
        aVar.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (this.f66254h == null) {
                a(activity, (TTAdDislike.DislikeInteractionCallback) null);
            }
            return this.f66254h;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m mVar = this.f66249c;
            if (mVar == null || mVar.aG() == null) {
                return null;
            }
            this.f66249c.aG().b(this.o);
            return new com.bytedance.sdk.openadsdk.dislike.c.a(this.f66249c.aG());
        }
        return (DislikeInfo) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66247a : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m mVar = this.f66249c;
            if (mVar == null) {
                return -1;
            }
            return mVar.ap();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            m mVar = this.f66249c;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m mVar = this.f66249c;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f66254h;
            if (aVar != null) {
                aVar.a(this.f66247a);
            }
            this.f66247a.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, activity, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.k = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tTDislikeDialogAbstract) == null) {
            if (tTDislikeDialogAbstract == null) {
                k.c("dialog is null, please check");
                return;
            }
            this.f66253g = tTDislikeDialogAbstract;
            tTDislikeDialogAbstract.setDislikeModel(this.f66249c.aG());
            a aVar = this.f66247a;
            if (aVar == null || aVar.getCurView() == null) {
                return;
            }
            this.f66247a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tTAppDownloadListener) == null) {
            this.f66252f = tTAppDownloadListener;
            r.a aVar = this.n;
            if (aVar != null) {
                aVar.a(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, expressAdInteractionListener) == null) {
            this.f66251e = expressAdInteractionListener;
            this.f66247a.setExpressInteractionListener(expressAdInteractionListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.o = "slide_banner_ad";
        a(this.f66247a.getCurView(), this.f66249c);
        this.f66247a.setDuration(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.f66256j = i2;
        this.f66255i = new w(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        Queue<Long> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, mVar) == null) || (queue = this.p) == null || queue.size() <= 0 || mVar == null) {
            return;
        }
        try {
            long longValue = this.p.poll().longValue();
            if (longValue > 0) {
                d.a((System.currentTimeMillis() - longValue) + "", mVar, this.o);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (wVar = this.f66255i) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adInteractionListener) == null) {
            this.f66251e = adInteractionListener;
            this.f66247a.setExpressInteractionListener(adInteractionListener);
        }
    }

    public void a(Context context, m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, mVar, adSlot) == null) {
            a aVar = new a(context, mVar, adSlot);
            this.f66247a = aVar;
            a(aVar.getCurView(), this.f66249c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, this, mVar) == null) && this.f66247a.getNextView() != null && this.f66247a.b()) {
            a(this.f66247a.getNextView(), mVar.aG());
            a(this.f66247a.getNextView(), mVar);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, activity, dislikeInteractionCallback) == null) {
            if (this.f66254h == null) {
                this.f66254h = new com.bytedance.sdk.openadsdk.dislike.ui.a(activity, this.f66249c.aG(), this.o, false);
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f66254h;
            if (aVar != null) {
                aVar.a(this.f66247a);
            }
            this.l = activity;
            this.f66254h.setDislikeInteractionCallback(dislikeInteractionCallback);
            a aVar2 = this.f66247a;
            if (aVar2 == null || aVar2.getCurView() == null) {
                return;
            }
            this.f66247a.getCurView().setDislike(this.f66254h);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f66248b).a(this.f66250d, 1, null, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66263a;

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
                    this.f66263a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
                public void a(List<m> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (list == null || list.isEmpty()) {
                            this.f66263a.a();
                            return;
                        }
                        m mVar = list.get(0);
                        b bVar = this.f66263a;
                        bVar.f66247a.a(mVar, bVar.f66250d);
                        this.f66263a.b(mVar);
                        this.f66263a.f66247a.c();
                        this.f66263a.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66263a.a();
                    }
                }
            }, 5000);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66248b, mVar, this.o);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (wVar = this.f66255i) == null) {
            return;
        }
        wVar.removeCallbacksAndMessages(null);
        this.f66255i.sendEmptyMessageDelayed(112201, this.f66256j);
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, nativeExpressView, bVar) == null) || bVar == null) {
            return;
        }
        if (this.k != null) {
            this.f66254h.a(bVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f66254h);
            }
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f66253g;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setDislikeModel(bVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f66253g);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressView, mVar) == null) || nativeExpressView == null || mVar == null) {
            return;
        }
        this.f66249c = mVar;
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(mVar);
        nativeExpressView.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this, a2) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.a f66257a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f66258b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, a2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66258b = this;
                this.f66257a = a2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView2, i2)) == null) {
                    try {
                        nativeExpressView2.m();
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                        bannerExpressBackupView.a(this.f66258b.f66249c, nativeExpressView2, this.f66257a);
                        bannerExpressBackupView.setDislikeInner(this.f66258b.f66254h);
                        bannerExpressBackupView.setDislikeOuter(this.f66258b.f66253g);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return invokeLI.booleanValue;
            }
        });
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                a2.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(mVar);
        EmptyView a3 = a(nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.f66248b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        if (a2 != null) {
            a2.a(a3);
        }
        a3.setCallback(new EmptyView.a(this, a2, mVar, nativeExpressView) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.a f66259a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f66260b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f66261c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f66262d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, a2, mVar, nativeExpressView};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66262d = this;
                this.f66259a = a2;
                this.f66260b = mVar;
                this.f66261c = nativeExpressView;
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    k.b("checkWebViewIsTransparent", "TAG=" + this.f66262d.o + ",onWindowFocusChanged....hasWindowFocus=" + z);
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66259a;
                    if (aVar != null) {
                        if (z) {
                            if (aVar != null) {
                                aVar.b();
                            }
                        } else if (aVar != null) {
                            aVar.c();
                        }
                    }
                    if (z) {
                        this.f66262d.a();
                        k.b("TTBannerExpressAd", "获得焦点，开始计时");
                    } else {
                        k.b("TTBannerExpressAd", "失去焦点，停止计时");
                        this.f66262d.b();
                    }
                    this.f66262d.a(z, this.f66260b);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66259a;
                    if (aVar != null) {
                        aVar.d();
                    }
                    this.f66262d.c(this.f66260b);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar = this.f66259a) == null) {
                    return;
                }
                aVar.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    k.b("TTBannerExpressAd", "ExpressView SHOW");
                    if (this.f66262d.p != null) {
                        this.f66262d.p.offer(Long.valueOf(System.currentTimeMillis()));
                    }
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66259a;
                    if (aVar != null) {
                        aVar.a();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("dynamic_show_type", Integer.valueOf(this.f66261c.n() ? 1 : 0));
                    k.e("AdEvent", "pangolin ad show " + q.a(this.f66260b, this.f66261c));
                    b bVar = this.f66262d;
                    d.a(bVar.f66248b, this.f66260b, bVar.o, hashMap);
                    TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66262d.f66251e;
                    if (expressAdInteractionListener != null) {
                        expressAdInteractionListener.onAdShow(view, this.f66260b.X());
                    }
                    this.f66262d.a();
                    this.f66262d.m.getAndSet(true);
                    a aVar2 = this.f66262d.f66247a;
                    if (aVar2 == null || aVar2.getCurView() == null) {
                        return;
                    }
                    this.f66262d.f66247a.getCurView().k();
                    this.f66262d.f66247a.getCurView().i();
                }
            }
        });
        e eVar = new e(this.f66248b, mVar, this.o, 2);
        eVar.a(nativeExpressView);
        eVar.a(a2);
        eVar.a(this);
        nativeExpressView.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f66248b, mVar, this.o, 2);
        dVar.a(nativeExpressView);
        dVar.a(a2);
        dVar.a(this);
        nativeExpressView.setClickCreativeListener(dVar);
        a(a2, nativeExpressView);
        a3.setNeedCheckingShow(true);
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, aVar, nativeExpressView) == null) || aVar == null || nativeExpressView == null) {
            return;
        }
        m mVar = this.f66249c;
        r.a aVar2 = new r.a(this.f66252f, mVar != null ? mVar.ak() : "");
        this.n = aVar2;
        aVar.a(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, m mVar) {
        Queue<Long> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65546, this, z, mVar) == null) || (queue = this.p) == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                long longValue = this.p.poll().longValue();
                d.a((System.currentTimeMillis() - longValue) + "", mVar, this.o);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 112201) {
            c();
        }
    }
}
