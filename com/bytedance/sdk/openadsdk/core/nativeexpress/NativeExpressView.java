package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a.g;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class NativeExpressView extends FrameLayout implements n, p {
    public static /* synthetic */ Interceptable $ic = null;
    public static int q = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable A;
    public ThemeStatusBroadcastReceiver B;
    public v C;
    public e.a D;
    public List<com.bytedance.sdk.openadsdk.core.nativeexpress.a.e> E;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.h F;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.c G;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.d H;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> I;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.g J;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66424a;

    /* renamed from: b  reason: collision with root package name */
    public int f66425b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f66426c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeDialogAbstract f66427d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f66428e;

    /* renamed from: f  reason: collision with root package name */
    public d f66429f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f66430g;

    /* renamed from: h  reason: collision with root package name */
    public String f66431h;

    /* renamed from: i  reason: collision with root package name */
    public AdSlot f66432i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f66433j;
    public TTNativeExpressAd.ExpressVideoAdListener k;
    public FrameLayout l;
    public boolean m;
    public boolean n;
    public c o;
    public boolean p;
    public e r;
    public final AtomicBoolean s;
    public String t;
    public float u;
    public float v;
    public com.bytedance.sdk.openadsdk.e.q w;
    public final ViewTreeObserver.OnScrollChangedListener x;
    public final Runnable y;
    public final Runnable z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1881890098, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/NativeExpressView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1881890098, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/NativeExpressView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66424a = true;
        this.f66425b = 0;
        this.f66431h = "embeded_ad";
        this.s = new AtomicBoolean(false);
        this.t = null;
        this.n = false;
        this.p = false;
        this.x = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f66434a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66434a = this;
            }

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    NativeExpressView nativeExpressView = this.f66434a;
                    nativeExpressView.removeCallbacks(nativeExpressView.y);
                    NativeExpressView nativeExpressView2 = this.f66434a;
                    nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
                }
            }
        };
        this.y = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f66435a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66435a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (y.a(this.f66435a, 0, 5)) {
                        NativeExpressView nativeExpressView = this.f66435a;
                        nativeExpressView.c(nativeExpressView.getVisibility());
                        return;
                    }
                    this.f66435a.c(8);
                }
            }
        };
        this.z = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f66436a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66436a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66436a.c(0);
                }
            }
        };
        this.A = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f66437a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f66437a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66437a.c(8);
                }
            }
        };
        this.f66431h = str;
        this.f66430g = context;
        this.f66433j = mVar;
        this.f66432i = adSlot;
        g();
    }

    private void b() {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if ("feed_video_middle_page".equals(this.f66431h)) {
                a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.b.a.b(this.u, this.v, this.n, this.f66433j);
            } else {
                a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.b.a.a(this.u, this.v, this.n, this.f66433j);
            }
            com.bytedance.sdk.openadsdk.e.q qVar = new com.bytedance.sdk.openadsdk.e.q(1, this.f66431h, this.f66433j);
            this.w = qVar;
            this.H = new h(qVar, this.f66431h, this.f66433j, this.t);
            this.J = new g.a().a(this.f66432i).a(this.f66431h).a(this.f66433j).a(a2).a(this.H).a(com.bytedance.sdk.openadsdk.core.o.h().G()).a();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (h()) {
                d();
                return;
            }
            this.F = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f66430g, this.J, this.B, this.w, this);
            this.G = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.c(this.f66430g, this, this.J, this.B);
            this.E.add(this.F);
            this.E.add(this.G);
            this.D = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.f(this.E, this.H);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int aE = this.f66433j.aE();
            this.f66425b = aE;
            if (aE == 1) {
                this.E.add(new com.bytedance.sdk.openadsdk.core.nativeexpress.a.a(this.f66430g, this.J, this.B, this));
            } else if (aE != 2) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.h hVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f66430g, this.J, this.B, this.w, this);
                this.F = hVar;
                this.E.add(hVar);
            } else {
                this.F = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f66430g, this.J, this.B, this.w, this);
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.a aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.a(this.f66430g, this.J, this.B, this);
                this.E.add(this.F);
                this.E.add(aVar);
            }
            boolean z = this.f66433j.aF() == 1;
            this.f66424a = z;
            if (z) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.c cVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.c(this.f66430g, this, this.J, this.B);
                this.G = cVar;
                this.E.add(cVar);
            }
            this.D = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.f(this.E, this.H);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f66427d;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f66426c;
            if (aVar != null) {
                aVar.showDislikeDialog();
            } else {
                TTDelegateActivity.a(getContext(), this.f66433j);
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f66433j;
            return mVar != null && mVar.h() == 1 && com.bytedance.sdk.openadsdk.core.e.m.b(this.f66433j);
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? TextUtils.equals(this.f66431h, "embeded_ad") || TextUtils.equals(this.f66431h, "splash_ad") : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdSlot adSlot = this.f66432i;
            if (adSlot != null) {
                this.u = adSlot.getExpressViewAcceptedWidth();
                this.v = this.f66432i.getExpressViewAcceptedHeight();
                this.t = this.f66432i.getCodeId();
            }
            setBackgroundColor(0);
            setBackgroundResource(17170445);
            a();
            b();
            this.E = new ArrayList();
            c();
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.h hVar = this.F;
            if (hVar != null) {
                this.C = hVar.b();
            }
        }
    }

    public d getClickCreativeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66429f : (d) invokeV.objValue;
    }

    public e getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : (e) invokeV.objValue;
    }

    public int getDynamicShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar = this.I;
            if (bVar != null) {
                return bVar.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getExpectExpressHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Float.valueOf(this.v).intValue() : invokeV.intValue;
    }

    public int getExpectExpressWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Float.valueOf(this.u).intValue() : invokeV.intValue;
    }

    public w getJsObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            v vVar = this.C;
            if (vVar != null) {
                return vVar.h();
            }
            return null;
        }
        return (w) invokeV.objValue;
    }

    public SSWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            v vVar = this.C;
            if (vVar == null) {
                return null;
            }
            return vVar.a();
        }
        return (SSWebView) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar = this.I;
            if (!(bVar instanceof v) || bVar == null) {
                return;
            }
            ((v) bVar).g();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.w.a();
            this.D.a(this);
            this.D.a();
        }
    }

    public void k() {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (vVar = this.C) == null) {
            return;
        }
        vVar.f();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            try {
                removeAllViews();
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.a.e eVar : this.E) {
                    eVar.a();
                }
                this.f66426c = null;
                this.f66427d = null;
                this.f66432i = null;
                this.f66433j = null;
                this.f66428e = null;
                this.f66429f = null;
                this.o = null;
                this.r = null;
                this.k = null;
                if (this.f66430g != null) {
                    this.f66430g.unregisterReceiver(this.B);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("NativeExpressView", "detach error", th);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                if (this.l == null || this.l.getParent() == null) {
                    return;
                }
                removeView(this.l);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.a("NativeExpressView", "backupDestroy remove video container error", th);
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar = this.I;
            return bVar != null && bVar.b() == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            com.bytedance.sdk.component.utils.k.f("webviewpool", "onAttachedToWindow+++");
            getViewTreeObserver().addOnScrollChangedListener(this.x);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDetachedFromWindow();
            try {
                getViewTreeObserver().removeOnScrollChangedListener(this.x);
            } catch (Exception unused) {
            }
            com.bytedance.sdk.component.utils.k.f("webviewpool", "onDetachedFromWindow===");
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onFinishTemporaryDetach();
            com.bytedance.sdk.component.utils.k.f("webviewpool", "onFinishTemporaryDetach+++");
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStartTemporaryDetach();
            com.bytedance.sdk.component.utils.k.f("webviewpool", "onStartTemporaryDetach===");
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (Build.VERSION.SDK_INT < 28) {
                onWindowVisibilityChanged(z ? getVisibility() : 8);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            removeCallbacks(this.A);
            removeCallbacks(this.z);
            if (i2 == 0) {
                postDelayed(this.z, 50L);
            } else {
                postDelayed(this.A, 50L);
            }
        }
    }

    public void setBackupListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.o = cVar;
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.c cVar2 = this.G;
            if (cVar2 != null) {
                cVar2.a(cVar);
            }
        }
    }

    public void setClickCreativeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dVar) == null) {
            this.f66429f = dVar;
        }
    }

    public void setClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.ui.a aVar) {
        BackupView backupView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar = this.I;
            if (bVar != null && (bVar instanceof l) && (backupView = (BackupView) bVar.d()) != null) {
                backupView.setDislikeInner(aVar);
            }
            this.f66426c = aVar;
        }
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expressAdInteractionListener) == null) {
            this.f66428e = expressAdInteractionListener;
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tTDislikeDialogAbstract) == null) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar = this.I;
            if (bVar != null && (bVar instanceof l) && (backupView = (BackupView) bVar.d()) != null) {
                backupView.setDislikeOuter(tTDislikeDialogAbstract);
            }
            this.f66427d = tTDislikeDialogAbstract;
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, expressVideoAdListener) == null) {
            this.k = expressVideoAdListener;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
                ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
                this.B = themeStatusBroadcastReceiver;
                this.f66430g.registerReceiver(themeStatusBroadcastReceiver, intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f66066a;
        int i4 = kVar.f66067b;
        int i5 = kVar.f66068c;
        int i6 = kVar.f66069d;
        String str = kVar.k;
        a(this.f66431h);
        if (i2 == 1) {
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.r;
            if (eVar != null) {
                eVar.a(kVar);
                this.r.a(str);
                this.r.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66428e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.f66433j.X());
            }
        } else if (i2 == 2) {
            d dVar = this.f66429f;
            if (dVar != null) {
                dVar.a(kVar);
                this.f66429f.a(str);
                this.f66429f.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.f66428e;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.f66433j.X());
            }
        } else if (i2 == 3) {
            e();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....mAdType=" + this.f66431h + ",!mVideoPause=" + (true ^ this.m) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.q.q.j(this.f66433j));
            if ("embeded_ad".equals(this.f66431h) && f() && !this.m && com.bytedance.sdk.openadsdk.q.q.j(this.f66433j)) {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....");
                d dVar2 = this.f66429f;
                if (dVar2 != null) {
                    dVar2.a(kVar);
                    this.f66429f.a(str);
                    this.f66429f.a(this, i3, i4, i5, i6);
                }
            } else {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "普通....");
                e eVar2 = this.r;
                if (eVar2 != null) {
                    eVar2.a(kVar);
                    this.r.a(kVar.k);
                    this.r.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.f66428e;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.f66433j.X());
            }
        }
    }

    public void c(int i2) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (bVar = this.I) != null && (bVar instanceof v)) {
            ((v) bVar).b(i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (!this.f66424a) {
                this.H.i();
            }
            this.H.j();
            ((h) this.H).l();
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66428e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i2), i2);
            }
        }
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f66066a;
        int i4 = kVar.f66067b;
        int i5 = kVar.f66068c;
        int i6 = kVar.f66069d;
        if (i2 == 1) {
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.r;
            if (eVar != null) {
                a(eVar.d(), z);
                this.r.a(kVar);
                this.r.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66428e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.f66433j.X());
            }
        } else if (i2 == 2) {
            d dVar = this.f66429f;
            if (dVar != null) {
                a(dVar.d(), z);
                this.f66429f.a(kVar);
                this.f66429f.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.f66428e;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.f66433j.X());
            }
        } else if (i2 == 3) {
            e();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....mAdType=" + this.f66431h + ",!mVideoPause=" + (true ^ this.m) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.q.q.j(this.f66433j));
            if ("embeded_ad".equals(this.f66431h) && f() && !this.m && com.bytedance.sdk.openadsdk.q.q.j(this.f66433j)) {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....");
                d dVar2 = this.f66429f;
                if (dVar2 != null) {
                    a(dVar2.d(), z);
                    this.f66429f.a(kVar);
                    this.f66429f.a(this, i3, i4, i5, i6);
                }
            } else {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "普通....");
                if (this.r != null) {
                    a(this.f66429f.d(), z);
                    this.r.a(kVar);
                    this.r.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.f66428e;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.f66433j.X());
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, z) == null) && aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            com.bytedance.sdk.openadsdk.downloadnew.a.d dVar = (com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar;
            dVar.d(true);
            dVar.e(z);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || this.f66433j == null || TextUtils.isEmpty(str) || !str.equals("feed_video_middle_page")) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f66433j, "feed_video_middle_page", "middle_page_click");
    }

    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar, com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, pVar) == null) {
            this.I = bVar;
            if (bVar.b() == 2 || bVar.b() == 0) {
                View d2 = bVar.d();
                if (d2.getParent() != null) {
                    ((ViewGroup) d2.getParent()).removeView(d2);
                }
                addView(bVar.d());
            }
            ((h) this.H).l();
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f66428e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onRenderSuccess(this, (float) pVar.c(), (float) pVar.d());
            }
        }
    }
}
