package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.nativeexpress.v;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes5.dex */
public class FullRewardExpressView extends NativeExpressView implements i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static float f29684c = 100.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f29685a;

    /* renamed from: b  reason: collision with root package name */
    public FullRewardExpressBackupView f29686b;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, pVar) == null) || pVar == null) {
            return;
        }
        double e2 = pVar.e();
        double f2 = pVar.f();
        double g2 = pVar.g();
        double h2 = pVar.h();
        int b2 = (int) s.b(this.f30510g, (float) e2);
        int b3 = (int) s.b(this.f30510g, (float) f2);
        int b4 = (int) s.b(this.f30510g, (float) g2);
        int b5 = (int) s.b(this.f30510g, (float) h2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(b4, b5);
        }
        layoutParams.width = b4;
        layoutParams.height = b5;
        layoutParams.topMargin = b3;
        layoutParams.leftMargin = b2;
        this.l.setLayoutParams(layoutParams);
        this.l.removeAllViews();
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FullRewardExpressView f29687a;

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
                    this.f29687a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView, i2)) == null) {
                        try {
                            nativeExpressView.m();
                            this.f29687a.f29686b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                            this.f29687a.f29686b.a(this.f29687a.j, nativeExpressView);
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

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            k.b("FullRewardExpressView", "onGetCurrentPlayTime");
            i iVar = this.f29685a;
            if (iVar != null) {
                return iVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            k.b("FullRewardExpressView", "onGetVideoState");
            i iVar = this.f29685a;
            if (iVar != null) {
                return iVar.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void e() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (iVar = this.f29685a) == null) {
            return;
        }
        iVar.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void f() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iVar = this.f29685a) == null) {
            return;
        }
        iVar.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.n = true;
            FrameLayout frameLayout = new FrameLayout(this.f30510g);
            this.l = frameLayout;
            addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            super.g();
            if (getWebView() != null) {
                getWebView().setBackgroundColor(Color.parseColor("#01000000"));
            }
            h();
        }
    }

    public FrameLayout getVideoFrameLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (n()) {
                return this.f29686b.getVideoContainer();
            }
            return this.l;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void setExpressVideoListenerProxy(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
            this.f29685a = iVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, pVar) == null) {
            if ((bVar instanceof v) && bVar != null) {
                v vVar = (v) bVar;
                if (vVar.h() != null) {
                    vVar.h().a((i) this);
                }
            }
            if (pVar != null && pVar.b()) {
                a(pVar);
            }
            super.a(bVar, pVar);
        }
    }

    private void a(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pVar) == null) || pVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(pVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, pVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f29688a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ FullRewardExpressView f29689b;

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
                    this.f29689b = this;
                    this.f29688a = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29689b.b(this.f29688a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            k.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
            i iVar = this.f29685a;
            if (iVar != null) {
                iVar.a(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k.b("FullRewardExpressView", "onSkipVideo");
            i iVar = this.f29685a;
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void b() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (iVar = this.f29685a) == null) {
            return;
        }
        iVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            k.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i2);
            i iVar = this.f29685a;
            if (iVar != null) {
                iVar.a(i2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.n
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, kVar) == null) {
            if (i2 != -1 && kVar != null && i2 == 3) {
                e();
            } else {
                super.a(i2, kVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.n
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) {
            if (i2 != -1 && kVar != null && i2 == 3) {
                e();
            }
            super.a(i2, kVar, z);
        }
    }
}
