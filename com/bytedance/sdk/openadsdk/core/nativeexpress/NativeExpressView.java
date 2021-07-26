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
/* loaded from: classes5.dex */
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
    public boolean f30504a;

    /* renamed from: b  reason: collision with root package name */
    public int f30505b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f30506c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeDialogAbstract f30507d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f30508e;

    /* renamed from: f  reason: collision with root package name */
    public d f30509f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f30510g;

    /* renamed from: h  reason: collision with root package name */
    public String f30511h;

    /* renamed from: i  reason: collision with root package name */
    public AdSlot f30512i;
    public com.bytedance.sdk.openadsdk.core.e.m j;
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
        this.f30504a = true;
        this.f30505b = 0;
        this.f30511h = "embeded_ad";
        this.s = new AtomicBoolean(false);
        this.t = null;
        this.n = false;
        this.p = false;
        this.x = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f30513a;

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
                this.f30513a = this;
            }

            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    NativeExpressView nativeExpressView = this.f30513a;
                    nativeExpressView.removeCallbacks(nativeExpressView.y);
                    NativeExpressView nativeExpressView2 = this.f30513a;
                    nativeExpressView2.postDelayed(nativeExpressView2.y, 500L);
                }
            }
        };
        this.y = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f30514a;

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
                this.f30514a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (y.a(this.f30514a, 0, 5)) {
                        NativeExpressView nativeExpressView = this.f30514a;
                        nativeExpressView.c(nativeExpressView.getVisibility());
                        return;
                    }
                    this.f30514a.c(8);
                }
            }
        };
        this.z = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f30515a;

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
                this.f30515a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f30515a.c(0);
                }
            }
        };
        this.A = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NativeExpressView f30516a;

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
                this.f30516a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f30516a.c(8);
                }
            }
        };
        this.f30511h = str;
        this.f30510g = context;
        this.j = mVar;
        this.f30512i = adSlot;
        g();
    }

    private void b() {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if ("feed_video_middle_page".equals(this.f30511h)) {
                a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.b.a.b(this.u, this.v, this.n, this.j);
            } else {
                a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.b.a.a(this.u, this.v, this.n, this.j);
            }
            com.bytedance.sdk.openadsdk.e.q qVar = new com.bytedance.sdk.openadsdk.e.q(1, this.f30511h, this.j);
            this.w = qVar;
            this.H = new h(qVar, this.f30511h, this.j, this.t);
            this.J = new g.a().a(this.f30512i).a(this.f30511h).a(this.j).a(a2).a(this.H).a(com.bytedance.sdk.openadsdk.core.o.h().G()).a();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (h()) {
                d();
                return;
            }
            this.F = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f30510g, this.J, this.B, this.w, this);
            this.G = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.c(this.f30510g, this, this.J, this.B);
            this.E.add(this.F);
            this.E.add(this.G);
            this.D = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.f(this.E, this.H);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            int aE = this.j.aE();
            this.f30505b = aE;
            if (aE == 1) {
                this.E.add(new com.bytedance.sdk.openadsdk.core.nativeexpress.a.a(this.f30510g, this.J, this.B, this));
            } else if (aE != 2) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.h hVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f30510g, this.J, this.B, this.w, this);
                this.F = hVar;
                this.E.add(hVar);
            } else {
                this.F = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.h(this.f30510g, this.J, this.B, this.w, this);
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.a aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.a(this.f30510g, this.J, this.B, this);
                this.E.add(this.F);
                this.E.add(aVar);
            }
            boolean z = this.j.aF() == 1;
            this.f30504a = z;
            if (z) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.a.c cVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.c(this.f30510g, this, this.J, this.B);
                this.G = cVar;
                this.E.add(cVar);
            }
            this.D = new com.bytedance.sdk.openadsdk.core.nativeexpress.a.f(this.E, this.H);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f30507d;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f30506c;
            if (aVar != null) {
                aVar.showDislikeDialog();
            } else {
                TTDelegateActivity.a(getContext(), this.j);
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.j;
            return mVar != null && mVar.h() == 1 && com.bytedance.sdk.openadsdk.core.e.m.b(this.j);
        }
        return invokeV.booleanValue;
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? TextUtils.equals(this.f30511h, "embeded_ad") || TextUtils.equals(this.f30511h, "splash_ad") : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdSlot adSlot = this.f30512i;
            if (adSlot != null) {
                this.u = adSlot.getExpressViewAcceptedWidth();
                this.v = this.f30512i.getExpressViewAcceptedHeight();
                this.t = this.f30512i.getCodeId();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30509f : (d) invokeV.objValue;
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
                this.f30506c = null;
                this.f30507d = null;
                this.f30512i = null;
                this.j = null;
                this.f30508e = null;
                this.f30509f = null;
                this.o = null;
                this.r = null;
                this.k = null;
                if (this.f30510g != null) {
                    this.f30510g.unregisterReceiver(this.B);
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
            this.f30509f = dVar;
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
            this.f30506c = aVar;
        }
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expressAdInteractionListener) == null) {
            this.f30508e = expressAdInteractionListener;
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
            this.f30507d = tTDislikeDialogAbstract;
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
                this.f30510g.registerReceiver(themeStatusBroadcastReceiver, intentFilter);
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
        int i3 = kVar.f30160a;
        int i4 = kVar.f30161b;
        int i5 = kVar.f30162c;
        int i6 = kVar.f30163d;
        String str = kVar.k;
        a(this.f30511h);
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
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f30508e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.j.X());
            }
        } else if (i2 == 2) {
            d dVar = this.f30509f;
            if (dVar != null) {
                dVar.a(kVar);
                this.f30509f.a(str);
                this.f30509f.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.f30508e;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.j.X());
            }
        } else if (i2 == 3) {
            e();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....mAdType=" + this.f30511h + ",!mVideoPause=" + (true ^ this.m) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.q.q.j(this.j));
            if ("embeded_ad".equals(this.f30511h) && f() && !this.m && com.bytedance.sdk.openadsdk.q.q.j(this.j)) {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....");
                d dVar2 = this.f30509f;
                if (dVar2 != null) {
                    dVar2.a(kVar);
                    this.f30509f.a(str);
                    this.f30509f.a(this, i3, i4, i5, i6);
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
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.f30508e;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.j.X());
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
            if (!this.f30504a) {
                this.H.i();
            }
            this.H.j();
            ((h) this.H).l();
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f30508e;
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
        int i3 = kVar.f30160a;
        int i4 = kVar.f30161b;
        int i5 = kVar.f30162c;
        int i6 = kVar.f30163d;
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
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f30508e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.j.X());
            }
        } else if (i2 == 2) {
            d dVar = this.f30509f;
            if (dVar != null) {
                a(dVar.d(), z);
                this.f30509f.a(kVar);
                this.f30509f.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.f30508e;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.j.X());
            }
        } else if (i2 == 3) {
            e();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.l;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....mAdType=" + this.f30511h + ",!mVideoPause=" + (true ^ this.m) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.q.q.j(this.j));
            if ("embeded_ad".equals(this.f30511h) && f() && !this.m && com.bytedance.sdk.openadsdk.q.q.j(this.j)) {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "创意....");
                d dVar2 = this.f30509f;
                if (dVar2 != null) {
                    a(dVar2.d(), z);
                    this.f30509f.a(kVar);
                    this.f30509f.a(this, i3, i4, i5, i6);
                }
            } else {
                com.bytedance.sdk.component.utils.k.b("ClickCreativeListener", "普通....");
                if (this.r != null) {
                    a(this.f30509f.d(), z);
                    this.r.a(kVar);
                    this.r.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.f30508e;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.j.X());
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
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || this.j == null || TextUtils.isEmpty(str) || !str.equals("feed_video_middle_page")) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.j, "feed_video_middle_page", "middle_page_click");
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
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.f30508e;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onRenderSuccess(this, (float) pVar.c(), (float) pVar.d());
            }
        }
    }
}
