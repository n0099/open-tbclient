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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.u;
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
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes6.dex */
public class b extends l implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f29764a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f29765b;

    /* renamed from: c  reason: collision with root package name */
    public m f29766c;

    /* renamed from: d  reason: collision with root package name */
    public AdSlot f29767d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f29768e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f29769f;

    /* renamed from: g  reason: collision with root package name */
    public TTDislikeDialogAbstract f29770g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f29771h;

    /* renamed from: i  reason: collision with root package name */
    public u f29772i;
    public int j;
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
        this.f29765b = context;
        this.f29766c = mVar;
        this.f29767d = adSlot;
        a(context, mVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f29764a) == null) {
            return;
        }
        aVar.d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (this.f29771h == null) {
                a(activity, (TTAdDislike.DislikeInteractionCallback) null);
            }
            return this.f29771h;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m mVar = this.f29766c;
            if (mVar == null || mVar.aG() == null) {
                return null;
            }
            this.f29766c.aG().b(this.o);
            return new com.bytedance.sdk.openadsdk.dislike.c.a(this.f29766c.aG());
        }
        return (DislikeInfo) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29764a : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m mVar = this.f29766c;
            if (mVar == null) {
                return -1;
            }
            return mVar.ap();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            m mVar = this.f29766c;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m mVar = this.f29766c;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f29771h;
            if (aVar != null) {
                aVar.a(this.f29764a);
            }
            this.f29764a.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, activity, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.k = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tTDislikeDialogAbstract) == null) {
            if (tTDislikeDialogAbstract == null) {
                j.b("dialog is null, please check");
                return;
            }
            this.f29770g = tTDislikeDialogAbstract;
            tTDislikeDialogAbstract.setDislikeModel(this.f29766c.aG());
            a aVar = this.f29764a;
            if (aVar == null || aVar.getCurView() == null) {
                return;
            }
            this.f29764a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tTAppDownloadListener) == null) {
            this.f29769f = tTAppDownloadListener;
            l.a aVar = this.n;
            if (aVar != null) {
                aVar.a(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, expressAdInteractionListener) == null) {
            this.f29768e = expressAdInteractionListener;
            this.f29764a.setExpressInteractionListener(expressAdInteractionListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.o = "slide_banner_ad";
        a(this.f29764a.getCurView(), this.f29766c);
        this.f29764a.setDuration(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.j = i2;
        this.f29772i = new u(Looper.getMainLooper(), this);
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
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (uVar = this.f29772i) == null) {
            return;
        }
        uVar.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adInteractionListener) == null) {
            this.f29768e = adInteractionListener;
            this.f29764a.setExpressInteractionListener(adInteractionListener);
        }
    }

    public void a(Context context, m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, mVar, adSlot) == null) {
            a aVar = new a(context, mVar, adSlot);
            this.f29764a = aVar;
            a(aVar.getCurView(), this.f29766c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, this, mVar) == null) && this.f29764a.getNextView() != null && this.f29764a.b()) {
            a(this.f29764a.getNextView(), mVar.aG());
            a(this.f29764a.getNextView(), mVar);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, activity, dislikeInteractionCallback) == null) {
            if (this.f29771h == null) {
                this.f29771h = new com.bytedance.sdk.openadsdk.dislike.ui.a(activity, this.f29766c.aG(), this.o, false);
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f29771h;
            if (aVar != null) {
                aVar.a(this.f29764a);
            }
            this.l = activity;
            this.f29771h.setDislikeInteractionCallback(dislikeInteractionCallback);
            a aVar2 = this.f29764a;
            if (aVar2 == null || aVar2.getCurView() == null) {
                return;
            }
            this.f29764a.getCurView().setDislike(this.f29771h);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f29765b).a(this.f29767d, 1, null, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29779a;

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
                    this.f29779a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
                public void a(List<m> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (list == null || list.isEmpty()) {
                            this.f29779a.a();
                            return;
                        }
                        m mVar = list.get(0);
                        b bVar = this.f29779a;
                        bVar.f29764a.a(mVar, bVar.f29767d);
                        this.f29779a.b(mVar);
                        this.f29779a.f29764a.c();
                        this.f29779a.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29779a.a();
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
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f29765b, mVar, this.o);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || (uVar = this.f29772i) == null) {
            return;
        }
        uVar.removeCallbacksAndMessages(null);
        this.f29772i.sendEmptyMessageDelayed(112201, this.j);
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, nativeExpressView, bVar) == null) || bVar == null) {
            return;
        }
        if (this.k != null) {
            this.f29771h.a(bVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f29771h);
            }
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f29770g;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setDislikeModel(bVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f29770g);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nativeExpressView, mVar) == null) || nativeExpressView == null || mVar == null) {
            return;
        }
        this.f29766c = mVar;
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(mVar);
        nativeExpressView.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this, a2) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.a f29773a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f29774b;

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
                this.f29774b = this;
                this.f29773a = a2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView2, i2)) == null) {
                    try {
                        nativeExpressView2.o();
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                        bannerExpressBackupView.a(this.f29774b.f29766c, nativeExpressView2, this.f29773a);
                        bannerExpressBackupView.setDislikeInner(this.f29774b.f29771h);
                        bannerExpressBackupView.setDislikeOuter(this.f29774b.f29770g);
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
            a3 = new EmptyView(this.f29765b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        if (a2 != null) {
            a2.a(a3);
        }
        a3.setCallback(new EmptyView.a(this, a2, mVar, nativeExpressView) { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.downloadnew.core.a f29775a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ m f29776b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f29777c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f29778d;

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
                this.f29778d = this;
                this.f29775a = a2;
                this.f29776b = mVar;
                this.f29777c = nativeExpressView;
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                    j.b("checkWebViewIsTransparent", "TAG=" + this.f29778d.o + ",onWindowFocusChanged....hasWindowFocus=" + z);
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f29775a;
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
                        this.f29778d.a();
                        j.b("TTBannerExpressAd", "获得焦点，开始计时");
                    } else {
                        j.b("TTBannerExpressAd", "失去焦点，停止计时");
                        this.f29778d.b();
                    }
                    this.f29778d.a(z, this.f29776b);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f29775a;
                    if (aVar != null) {
                        aVar.d();
                    }
                    this.f29778d.c(this.f29776b);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar = this.f29775a) == null) {
                    return;
                }
                aVar.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    j.b("TTBannerExpressAd", "ExpressView SHOW");
                    if (this.f29778d.p != null) {
                        this.f29778d.p.offer(Long.valueOf(System.currentTimeMillis()));
                    }
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f29775a;
                    if (aVar != null) {
                        aVar.a();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("dynamic_show_type", Integer.valueOf(this.f29777c.p() ? 1 : 0));
                    j.e("AdEvent", "pangolin ad show " + o.a(this.f29776b, this.f29777c));
                    b bVar = this.f29778d;
                    d.a(bVar.f29765b, this.f29776b, bVar.o, hashMap);
                    TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f29778d.f29768e;
                    if (expressAdInteractionListener != null) {
                        expressAdInteractionListener.onAdShow(view, this.f29776b.X());
                    }
                    this.f29778d.a();
                    this.f29778d.m.getAndSet(true);
                    a aVar2 = this.f29778d.f29764a;
                    if (aVar2 == null || aVar2.getCurView() == null) {
                        return;
                    }
                    this.f29778d.f29764a.getCurView().l();
                    this.f29778d.f29764a.getCurView().j();
                }
            }
        });
        e eVar = new e(this.f29765b, mVar, this.o, 2);
        eVar.a(nativeExpressView);
        eVar.a(a2);
        eVar.a(this);
        nativeExpressView.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f29765b, mVar, this.o, 2);
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
        m mVar = this.f29766c;
        l.a aVar2 = new l.a(this.f29769f, mVar != null ? mVar.ak() : "");
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

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 112201) {
            c();
        }
    }
}
