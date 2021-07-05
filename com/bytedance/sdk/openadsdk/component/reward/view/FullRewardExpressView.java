package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes6.dex */
public class FullRewardExpressView extends NativeExpressView implements g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static float f29476c = 100.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f29477a;

    /* renamed from: b  reason: collision with root package name */
    public FullRewardExpressBackupView f29478b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-29599563, "Lcom/bytedance/sdk/openadsdk/component/reward/view/FullRewardExpressView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-29599563, "Lcom/bytedance/sdk/openadsdk/component/reward/view/FullRewardExpressView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullRewardExpressView(@NonNull Context context, m mVar, AdSlot adSlot, String str) {
        super(context, mVar, adSlot, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (m) objArr2[1], (AdSlot) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void b(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, this, pVar) == null) || pVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(pVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, pVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f29480a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FullRewardExpressView f29481b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29481b = this;
                    this.f29480a = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29481b.c(this.f29480a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, pVar) == null) || pVar == null) {
            return;
        }
        double e2 = pVar.e();
        double f2 = pVar.f();
        double g2 = pVar.g();
        double h2 = pVar.h();
        int b2 = (int) q.b(this.f30298h, (float) e2);
        int b3 = (int) q.b(this.f30298h, (float) f2);
        int b4 = (int) q.b(this.f30298h, (float) g2);
        int b5 = (int) q.b(this.f30298h, (float) h2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(b4, b5);
        }
        layoutParams.width = b4;
        layoutParams.height = b5;
        layoutParams.topMargin = b3;
        layoutParams.leftMargin = b2;
        this.o.setLayoutParams(layoutParams);
        this.o.removeAllViews();
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FullRewardExpressView f29479a;

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
                    this.f29479a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView, i2)) == null) {
                        try {
                            nativeExpressView.o();
                            this.f29479a.f29478b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                            this.f29479a.f29478b.a(this.f29479a.m, nativeExpressView);
                            return true;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    return invokeLI.booleanValue;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            j.b("FullRewardExpressView", "onGetVideoState");
            g gVar = this.f29477a;
            if (gVar != null) {
                return gVar.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (gVar = this.f29477a) == null) {
            return;
        }
        gVar.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (gVar = this.f29477a) == null) {
            return;
        }
        gVar.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.q = true;
            FrameLayout frameLayout = new FrameLayout(this.f30298h);
            this.o = frameLayout;
            addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            super.g();
            getWebView().setBackgroundColor(0);
            i();
        }
    }

    public FrameLayout getVideoFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (p()) {
                return this.f29478b.getVideoContainer();
            }
            return this.o;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.h();
            this.j.a((g) this);
        }
    }

    public void setExpressVideoListenerProxy(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f29477a = gVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            if (pVar != null && pVar.b()) {
                b(pVar);
            }
            super.a(pVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void b() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gVar = this.f29477a) == null) {
            return;
        }
        gVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            j.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
            g gVar = this.f29477a;
            if (gVar != null) {
                gVar.a(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j.b("FullRewardExpressView", "onSkipVideo");
            g gVar = this.f29477a;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            j.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i2);
            g gVar = this.f29477a;
            if (gVar != null) {
                gVar.a(i2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, kVar) == null) {
            if (i2 != -1 && kVar != null && i2 == 3) {
                e();
            } else {
                super.a(i2, kVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) {
            if (i2 != -1 && kVar != null && i2 == 3) {
                e();
            }
            super.a(i2, kVar, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            j.b("FullRewardExpressView", "onGetCurrentPlayTime");
            g gVar = this.f29477a;
            if (gVar != null) {
                return gVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}
