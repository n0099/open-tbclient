package com.bytedance.sdk.openadsdk.component.reward.c;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.component.reward.c.a;
import com.bytedance.sdk.openadsdk.component.reward.view.FullInteractionStyleView;
import com.bytedance.sdk.openadsdk.core.e.m;
/* loaded from: classes5.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullInteractionStyleView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, m mVar, int i2, int i3, int i4, float f2) {
        super(activity, mVar, i2, i3, i4, f2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (m) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            m mVar = this.f29576b;
            if (mVar == null) {
                return false;
            }
            int ap = mVar.ap();
            return ap == 15 || ap == 5;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f() : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f() : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29581g = this.j.y();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FullInteractionStyleView fullInteractionStyleView = this.l;
            if (fullInteractionStyleView != null) {
                return fullInteractionStyleView.getVideoContainer();
            }
            return null;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void a(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            FullInteractionStyleView fullInteractionStyleView = new FullInteractionStyleView(this.f29575a, this.f29581g);
            this.l = fullInteractionStyleView;
            fullInteractionStyleView.setDownloadListener(this.f29582h);
            this.l.a(this.f29576b, null, this.f29580f, this.f29579e, this.f29577c, this.f29578d);
            frameLayout.addView(this.l.getInteractionStyleRootView());
        }
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mVar)) == null) ? (mVar == null || mVar.aJ() == 100.0f) ? false : true : invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public a.InterfaceC0333a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a.InterfaceC0333a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f29586a;

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
                this.f29586a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.c.a.InterfaceC0333a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) || this.f29586a.l == null) {
                    return;
                }
                this.f29586a.l.setIsMute(z);
            }
        } : (a.InterfaceC0333a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.c.a
    public void a(com.bytedance.sdk.openadsdk.component.reward.view.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            cVar.a(8);
            cVar.b(8);
            if (this.f29576b.d() == 2) {
                this.f29583i.a(false);
                this.f29583i.c(false);
                this.f29583i.d(false);
                this.f29583i.e(false);
                return;
            }
            this.f29583i.a(this.f29576b.aM());
            this.f29583i.c(f());
            this.f29583i.d(f());
            this.f29583i.e(true ^ f());
        }
    }
}
