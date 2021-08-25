package com.bytedance.sdk.openadsdk.core.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.r;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressView f66110a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f66111b;

    /* renamed from: c  reason: collision with root package name */
    public m f66112c;

    /* renamed from: d  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f66113d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.AdInteractionListener f66114e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f66115f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f66116g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66117h;

    /* renamed from: i  reason: collision with root package name */
    public Dialog f66118i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f66119j;
    public FrameLayout k;
    public a l;
    public long o;
    public String p;

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
        this.o = 0L;
        this.p = ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE;
        this.f66111b = context;
        this.f66112c = mVar;
        a(context, mVar, adSlot, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE);
        a(this.f66110a, this.f66112c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (nativeExpressView = this.f66110a) == null) {
            return;
        }
        nativeExpressView.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (this.f66116g == null) {
                a(activity, (TTAdDislike.DislikeInteractionCallback) null);
            }
            return this.f66116g;
        }
        return (TTAdDislike) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f66112c;
            if (mVar == null || mVar.aG() == null) {
                return null;
            }
            this.f66112c.aG().b(this.p);
            return new com.bytedance.sdk.openadsdk.dislike.c.a(this.f66112c.aG());
        }
        return (DislikeInfo) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66110a : (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m mVar = this.f66112c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m mVar = this.f66112c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m mVar = this.f66112c;
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f66110a.j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, activity, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null || activity == null) {
            return;
        }
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tTDislikeDialogAbstract) == null) {
            if (tTDislikeDialogAbstract == null) {
                k.c("dialog is null, please check");
                return;
            }
            tTDislikeDialogAbstract.setDislikeModel(this.f66112c.aG());
            NativeExpressView nativeExpressView = this.f66110a;
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tTAppDownloadListener) == null) {
            this.f66115f = tTAppDownloadListener;
            r.a aVar = this.n;
            if (aVar != null) {
                aVar.a(tTAppDownloadListener);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, expressAdInteractionListener) == null) {
            this.f66113d = expressAdInteractionListener;
            this.f66110a.setExpressInteractionListener(expressAdInteractionListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, activity) == null) || activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                k.c("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
            } else {
                a(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (dialog = this.f66118i) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void a(@NonNull Context context, m mVar, AdSlot adSlot, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, context, mVar, adSlot, str) == null) {
            this.f66110a = new NativeExpressView(context, mVar, adSlot, this.p);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.r, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adInteractionListener) == null) {
            this.f66114e = adInteractionListener;
            this.f66113d = adInteractionListener;
            this.f66110a.setExpressInteractionListener(adInteractionListener);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, activity, dislikeInteractionCallback) == null) {
            if (this.f66116g == null) {
                this.f66116g = new com.bytedance.sdk.openadsdk.dislike.ui.a(activity, this.f66112c.aG(), this.p, false);
            }
            this.f66116g.setDislikeInteractionCallback(dislikeInteractionCallback);
            NativeExpressView nativeExpressView = this.f66110a;
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f66116g);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66111b, mVar, this.p);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, nativeExpressView, mVar) == null) {
            this.f66112c = mVar;
            this.f66110a.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this) { // from class: com.bytedance.sdk.openadsdk.core.d.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66120a;

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
                    this.f66120a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView2, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView2, i2)) == null) {
                        try {
                            this.f66120a.f66110a.m();
                            this.f66120a.l = new a(nativeExpressView2.getContext());
                            this.f66120a.l.a(this.f66120a.f66112c, this.f66120a.f66110a, this.f66120a.f66117h);
                            return true;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    return invokeLI.booleanValue;
                }
            });
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(mVar);
            this.f66117h = a2;
            if (a2 != null) {
                a2.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.f66117h.a((Activity) nativeExpressView.getContext());
                }
            }
            d.a(mVar);
            EmptyView a3 = a(nativeExpressView);
            if (a3 == null) {
                a3 = new EmptyView(this.f66111b, nativeExpressView);
                nativeExpressView.addView(a3);
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66117h;
            if (aVar != null) {
                aVar.a(a3);
            }
            a3.setCallback(new EmptyView.a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.core.d.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ m f66121a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f66122b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66122b = this;
                    this.f66121a = mVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        k.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
                        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.f66122b.f66117h;
                        if (aVar2 != null) {
                            if (z) {
                                if (aVar2 != null) {
                                    aVar2.b();
                                }
                            } else if (aVar2 != null) {
                                aVar2.c();
                            }
                        }
                        b bVar = this.f66122b;
                        bVar.o = d.a(bVar.o, z, this.f66121a, this.f66122b.p);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.f66122b.f66117h;
                        if (aVar2 != null) {
                            aVar2.d();
                        }
                        b bVar = this.f66122b;
                        bVar.o = d.a(bVar.o, this.f66121a, this.f66122b.p);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar2 = this.f66122b.f66117h) == null) {
                        return;
                    }
                    aVar2.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        k.b("TTInteractionExpressAd", "ExpressView SHOW");
                        this.f66122b.o = System.currentTimeMillis();
                        HashMap hashMap = new HashMap();
                        hashMap.put("dynamic_show_type", Integer.valueOf(this.f66122b.f66110a.n() ? 1 : 0));
                        k.e("AdEvent", "pangolin ad show " + q.a(this.f66121a, view));
                        b bVar = this.f66122b;
                        d.a(bVar.f66111b, this.f66121a, bVar.p, hashMap);
                        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66122b.f66113d;
                        if (expressAdInteractionListener != null) {
                            expressAdInteractionListener.onAdShow(view, this.f66121a.X());
                        }
                        this.f66122b.m.getAndSet(true);
                        NativeExpressView nativeExpressView2 = this.f66122b.f66110a;
                        if (nativeExpressView2 != null) {
                            nativeExpressView2.k();
                            this.f66122b.f66110a.i();
                        }
                    }
                }
            });
            a(this.f66117h, this.f66110a);
            a3.setNeedCheckingShow(true);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, aVar, nativeExpressView) == null) || aVar == null || nativeExpressView == null) {
            return;
        }
        m mVar = this.f66112c;
        r.a aVar2 = new r.a(this.f66115f, mVar != null ? mVar.ak() : "");
        this.n = aVar2;
        aVar.a(aVar2);
    }

    private EmptyView a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, viewGroup)) == null) {
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

    private void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, activity) == null) {
            if (this.f66118i == null) {
                com.bytedance.sdk.openadsdk.core.m mVar = new com.bytedance.sdk.openadsdk.core.m(activity);
                this.f66118i = mVar;
                mVar.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.bytedance.sdk.openadsdk.core.d.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f66123a;

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
                        this.f66123a = this;
                    }

                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66123a.f66117h;
                            if (aVar != null) {
                                aVar.d();
                            }
                            TTNativeExpressAd.AdInteractionListener adInteractionListener = this.f66123a.f66114e;
                            if (adInteractionListener != null) {
                                adInteractionListener.onAdDismiss();
                            }
                        }
                    }
                });
                ((com.bytedance.sdk.openadsdk.core.m) this.f66118i).a(this.f66112c);
                ((com.bytedance.sdk.openadsdk.core.m) this.f66118i).a(true, new m.a(this) { // from class: com.bytedance.sdk.openadsdk.core.d.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f66124a;

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
                        this.f66124a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.m.a
                    public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, imageView2, frameLayout) == null) {
                            b bVar = this.f66124a;
                            bVar.f66119j = imageView2;
                            bVar.k = frameLayout;
                            frameLayout.addView(bVar.f66110a, new FrameLayout.LayoutParams(-1, -1));
                            this.f66124a.a();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.m.a
                    public void b(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                            b bVar = this.f66124a;
                            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = bVar.f66116g;
                            if (aVar != null) {
                                aVar.showDislikeDialog();
                            } else {
                                TTDelegateActivity.a(bVar.f66111b, bVar.f66112c);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.m.a
                    public void a(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f66124a.b();
                            b bVar = this.f66124a;
                            d.a(bVar.f66111b, bVar.f66112c, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE);
                            k.b("TTInteractionExpressAd", "dislike事件发出");
                        }
                    }
                });
            }
            a aVar = this.l;
            if (aVar != null) {
                aVar.a(this.f66118i);
            }
            if (this.f66118i.isShowing()) {
                return;
            }
            try {
                this.f66118i.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            e eVar = new e(this.f66111b, this.f66112c, this.p, 3);
            eVar.a(this.f66110a);
            eVar.b(this.f66119j);
            eVar.a(this.f66117h);
            eVar.a(this);
            this.f66110a.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f66111b, this.f66112c, this.p, 3);
            dVar.a(this.f66110a);
            dVar.b(this.f66119j);
            dVar.a(this);
            dVar.a(this.f66117h);
            dVar.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.core.d.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66125a;

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
                    this.f66125a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        if (i2 == 2 || i2 == 3 || i2 == 5) {
                            this.f66125a.b();
                        }
                    }
                }
            });
            this.f66110a.setClickCreativeListener(dVar);
        }
    }
}
