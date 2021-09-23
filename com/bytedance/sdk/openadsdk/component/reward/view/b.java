package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.g.a;
import com.dxmpay.wallet.download.PayDownloadModule;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66281a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f66282b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66283c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66284d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66285e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f66286f;

    /* renamed from: g  reason: collision with root package name */
    public m f66287g;

    /* renamed from: h  reason: collision with root package name */
    public String f66288h;

    /* renamed from: i  reason: collision with root package name */
    public FullRewardExpressView f66289i;

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66283c = false;
        this.f66284d = false;
        this.f66285e = false;
        this.f66286f = activity;
    }

    public FrameLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FullRewardExpressView fullRewardExpressView = this.f66289i;
            if (fullRewardExpressView != null) {
                return fullRewardExpressView.getVideoFrameLayout();
            }
            return null;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66283c : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66284d : invokeV.booleanValue;
    }

    public Handler e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f66282b == null) {
                this.f66282b = new Handler(Looper.getMainLooper());
            }
            return this.f66282b;
        }
        return (Handler) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FullRewardExpressView fullRewardExpressView = this.f66289i;
            if (fullRewardExpressView != null) {
                fullRewardExpressView.l();
            }
            Handler handler = this.f66282b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        }
    }

    public void g() {
        FullRewardExpressView fullRewardExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fullRewardExpressView = this.f66289i) == null) {
            return;
        }
        fullRewardExpressView.k();
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            FullRewardExpressView fullRewardExpressView = this.f66289i;
            if (fullRewardExpressView == null) {
                return false;
            }
            return fullRewardExpressView.n();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        FullRewardExpressView fullRewardExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (fullRewardExpressView = this.f66289i) == null) {
            return;
        }
        fullRewardExpressView.i();
    }

    public void j() {
        FullRewardExpressView fullRewardExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fullRewardExpressView = this.f66289i) == null) {
            return;
        }
        fullRewardExpressView.j();
        this.f66289i.k();
    }

    public void a(m mVar, AdSlot adSlot, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mVar, adSlot, str) == null) || this.f66285e) {
            return;
        }
        this.f66285e = true;
        this.f66287g = mVar;
        this.f66288h = str;
        this.f66289i = new FullRewardExpressView(this.f66286f, mVar, adSlot, str);
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f66284d = z;
        }
    }

    public FullRewardExpressView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66289i : (FullRewardExpressView) invokeV.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f66283c = z;
        }
    }

    public void a(e eVar, d dVar, a aVar) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, eVar, dVar, aVar) == null) || this.f66289i == null || (mVar = this.f66287g) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(mVar);
        this.f66281a = a2;
        if (a2 != null) {
            a2.b();
            if (this.f66289i.getContext() != null && (this.f66289i.getContext() instanceof Activity)) {
                this.f66281a.a((Activity) this.f66289i.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.f66287g);
        EmptyView a3 = a((ViewGroup) this.f66289i);
        if (a3 == null) {
            a3 = new EmptyView(this.f66286f, this.f66289i);
            this.f66289i.addView(a3);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.f66281a;
        if (aVar2 != null) {
            aVar2.a(a3);
        }
        a3.setCallback(new EmptyView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f66290a;

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
                this.f66290a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (aVar3 = this.f66290a.f66281a) == null) {
                    return;
                }
                if (z) {
                    if (aVar3 != null) {
                        aVar3.b();
                    }
                } else if (aVar3 != null) {
                    aVar3.c();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || (aVar3 = this.f66290a.f66281a) == null) {
                    return;
                }
                aVar3.d();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (aVar3 = this.f66290a.f66281a) == null) {
                    return;
                }
                aVar3.a();
            }
        });
        eVar.a(this.f66289i);
        eVar.a(this.f66281a);
        this.f66289i.setClickListener(eVar);
        dVar.a(this.f66289i);
        dVar.a(this.f66281a);
        this.f66289i.setClickCreativeListener(dVar);
        a3.setNeedCheckingShow(false);
        a(this.f66281a, this.f66289i, aVar);
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView, a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, nativeExpressView, aVar2) == null) || aVar == null || nativeExpressView == null) {
            return;
        }
        m mVar = this.f66287g;
        aVar.a(new TTAppDownloadListener(this, aVar2, mVar != null ? mVar.ak() : "") { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66291a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f66292b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f66293c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar2, r8};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66293c = this;
                this.f66291a = aVar2;
                this.f66292b = r8;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) || j2 <= 0) {
                    return;
                }
                int i2 = (int) ((j3 * 100) / j2);
                this.f66293c.f66286f.runOnUiThread(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f66295a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass2 f66296b;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2)};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66296b = this;
                        this.f66295a = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            a aVar3 = this.f66296b.f66291a;
                            aVar3.a("已下载" + this.f66295a + "%");
                        }
                    }
                });
                a.C1923a.a(this.f66292b, 3, i2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    this.f66293c.f66286f.runOnUiThread(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66298a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66298a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f66298a.f66291a.a(PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                            }
                        }
                    });
                    if (j2 > 0) {
                        a.C1923a.a(this.f66292b, 4, (int) ((j3 * 100) / j2));
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
                    this.f66293c.f66286f.runOnUiThread(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66299a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66299a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f66299a.f66291a.a("点击安装");
                            }
                        }
                    });
                    a.C1923a.a(this.f66292b, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    this.f66293c.f66286f.runOnUiThread(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66297a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66297a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f66297a.f66291a.a("下载暂停");
                            }
                        }
                    });
                    if (j2 > 0) {
                        a.C1923a.a(this.f66292b, 2, (int) ((j3 * 100) / j2));
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f66293c.f66286f.runOnUiThread(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66294a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66294a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f66294a.f66291a.a("点击开始下载");
                            }
                        }
                    });
                    a.C1923a.a(this.f66292b, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) {
                    this.f66293c.f66286f.runOnUiThread(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.b.2.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66300a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66300a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f66300a.f66291a.a("点击打开");
                            }
                        }
                    });
                    a.C1923a.a(this.f66292b, 6, 100);
                }
            }
        });
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66286f, mVar, this.f66288h);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
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

    public void a(i iVar) {
        FullRewardExpressView fullRewardExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) || (fullRewardExpressView = this.f66289i) == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(iVar);
    }

    public void a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        FullRewardExpressView fullRewardExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, expressAdInteractionListener) == null) || (fullRewardExpressView = this.f66289i) == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(expressAdInteractionListener);
    }
}
