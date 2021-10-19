package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.r;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class q extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressView f67251a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f67252b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f67253c;

    /* renamed from: d  reason: collision with root package name */
    public String f67254d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f67255e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f67256f;

    /* renamed from: g  reason: collision with root package name */
    public TTAdDislike.DislikeInteractionCallback f67257g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f67258h;

    /* renamed from: i  reason: collision with root package name */
    public TTDislikeDialogAbstract f67259i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f67260j;
    public long k;

    public q(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot) {
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
        this.f67254d = "embeded_ad";
        this.k = 0L;
        this.f67252b = context;
        this.f67253c = mVar;
        a(context, mVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nativeExpressView = this.f67251a) == null) {
            return;
        }
        nativeExpressView.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (this.f67258h == null) {
                a(activity, (TTAdDislike.DislikeInteractionCallback) null);
            }
            return this.f67258h;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67253c;
            if (mVar == null || mVar.aG() == null) {
                return null;
            }
            this.f67253c.aG().b(this.f67254d);
            return new com.bytedance.sdk.openadsdk.dislike.c.a(this.f67253c.aG());
        }
        return (DislikeInfo) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67251a : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67253c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67253c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67253c;
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
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f67258h;
            if (aVar != null) {
                aVar.a(this.f67251a);
            }
            this.f67251a.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, activity, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.f67257g = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tTDislikeDialogAbstract) == null) {
            if (tTDislikeDialogAbstract == null) {
                com.bytedance.sdk.component.utils.k.c("dialog is null, please check");
                return;
            }
            this.f67259i = tTDislikeDialogAbstract;
            tTDislikeDialogAbstract.setDislikeModel(this.f67253c.aG());
            NativeExpressView nativeExpressView = this.f67251a;
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tTAppDownloadListener) == null) {
            this.f67256f = tTAppDownloadListener;
            r.a aVar = this.n;
            if (aVar != null) {
                aVar.a(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, expressAdInteractionListener) == null) {
            this.f67255e = expressAdInteractionListener;
            this.f67251a.setExpressInteractionListener(expressAdInteractionListener);
        }
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, mVar, adSlot) == null) {
            NativeExpressView nativeExpressView = new NativeExpressView(context, mVar, adSlot, this.f67254d);
            this.f67251a = nativeExpressView;
            a(nativeExpressView, this.f67253c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adInteractionListener) == null) {
            this.f67255e = adInteractionListener;
            this.f67251a.setExpressInteractionListener(adInteractionListener);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, activity, dislikeInteractionCallback) == null) {
            if (this.f67258h == null) {
                this.f67258h = new com.bytedance.sdk.openadsdk.dislike.ui.a(activity, this.f67253c.aG(), this.f67254d, false);
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f67258h;
            if (aVar != null) {
                aVar.a(this.f67251a);
            }
            this.f67258h.setDislikeInteractionCallback(dislikeInteractionCallback);
            NativeExpressView nativeExpressView = this.f67251a;
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f67258h);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f67252b, mVar, this.f67254d);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeExpressView, mVar) == null) {
            this.f67253c = mVar;
            nativeExpressView.setBackupListener(new c(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f67261a;

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
                    this.f67261a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView2, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView2, i2)) == null) {
                        try {
                            nativeExpressView2.m();
                            j jVar = new j(nativeExpressView2.getContext());
                            jVar.a(this.f67261a.f67253c, nativeExpressView2, this.f67261a.f67260j);
                            jVar.setDislikeInner(this.f67261a.f67258h);
                            jVar.setDislikeOuter(this.f67261a.f67259i);
                            return true;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    return invokeLI.booleanValue;
                }
            });
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(mVar);
            this.f67260j = a2;
            if (a2 != null) {
                a2.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.f67260j.a((Activity) nativeExpressView.getContext());
                }
            }
            com.bytedance.sdk.openadsdk.e.d.a(mVar);
            EmptyView a3 = a(nativeExpressView);
            if (a3 == null) {
                a3 = new EmptyView(this.f67252b, nativeExpressView);
                nativeExpressView.addView(a3);
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f67260j;
            if (aVar != null) {
                aVar.a(a3);
            }
            a3.setCallback(new EmptyView.a(this, mVar, mVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f67262a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f67263b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ q f67264c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mVar, mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67264c = this;
                    this.f67262a = mVar;
                    this.f67263b = mVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.f67264c.f67260j != null) {
                            if (z) {
                                if (this.f67264c.f67260j != null) {
                                    this.f67264c.f67260j.b();
                                }
                            } else if (this.f67264c.f67260j != null) {
                                this.f67264c.f67260j.c();
                            }
                        }
                        q qVar = this.f67264c;
                        qVar.k = com.bytedance.sdk.openadsdk.e.d.a(qVar.k, z, this.f67262a, this.f67264c.f67254d);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        if (this.f67264c.f67260j != null) {
                            this.f67264c.f67260j.d();
                        }
                        q qVar = this.f67264c;
                        qVar.k = com.bytedance.sdk.openadsdk.e.d.a(qVar.k, this.f67262a, this.f67264c.f67254d);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f67264c.f67260j == null) {
                        return;
                    }
                    this.f67264c.f67260j.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f67264c.k = System.currentTimeMillis();
                        com.bytedance.sdk.component.utils.k.b("TTNativeExpressAd", "ExpressView SHOW");
                        HashMap hashMap = new HashMap();
                        hashMap.put("dynamic_show_type", Integer.valueOf(this.f67264c.f67251a.getDynamicShowType()));
                        com.bytedance.sdk.component.utils.k.e("AdEvent", "pangolin ad show " + com.bytedance.sdk.openadsdk.q.q.a(this.f67263b, view));
                        q qVar = this.f67264c;
                        com.bytedance.sdk.openadsdk.e.d.a(qVar.f67252b, this.f67263b, qVar.f67254d, hashMap);
                        if (this.f67264c.f67255e != null) {
                            this.f67264c.f67255e.onAdShow(view, this.f67263b.X());
                        }
                        this.f67264c.m.getAndSet(true);
                        NativeExpressView nativeExpressView2 = this.f67264c.f67251a;
                        if (nativeExpressView2 != null) {
                            nativeExpressView2.k();
                            this.f67264c.f67251a.i();
                        }
                    }
                }
            });
            Context context = this.f67252b;
            String str = this.f67254d;
            e eVar = new e(context, mVar, str, com.bytedance.sdk.openadsdk.q.q.a(str));
            eVar.a(nativeExpressView);
            eVar.a(this.f67260j);
            eVar.a(this);
            this.f67251a.setClickListener(eVar);
            Context context2 = this.f67252b;
            String str2 = this.f67254d;
            d dVar = new d(context2, mVar, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
            dVar.a(nativeExpressView);
            dVar.a(this.f67260j);
            dVar.a(this);
            this.f67251a.setClickCreativeListener(dVar);
            a(this.f67260j, this.f67251a);
            a3.setNeedCheckingShow(true);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, aVar, nativeExpressView) == null) || aVar == null || nativeExpressView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67253c;
        r.a aVar2 = new r.a(this.f67256f, mVar != null ? mVar.ak() : "");
        this.n = aVar2;
        aVar.a(aVar2);
    }

    private EmptyView a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, viewGroup)) == null) {
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
