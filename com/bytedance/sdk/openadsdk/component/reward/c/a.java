package com.bytedance.sdk.openadsdk.component.reward.c;

import android.app.Activity;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f66151a;

    /* renamed from: b  reason: collision with root package name */
    public m f66152b;

    /* renamed from: c  reason: collision with root package name */
    public int f66153c;

    /* renamed from: d  reason: collision with root package name */
    public int f66154d;

    /* renamed from: e  reason: collision with root package name */
    public int f66155e;

    /* renamed from: f  reason: collision with root package name */
    public float f66156f;

    /* renamed from: g  reason: collision with root package name */
    public String f66157g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.b.e f66158h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.b.c f66159i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.b.d f66160j;
    public com.bytedance.sdk.openadsdk.component.reward.b.e k;

    /* renamed from: com.bytedance.sdk.openadsdk.component.reward.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1901a {
        void a(boolean z);
    }

    public a(Activity activity, m mVar, int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66151a = activity;
        this.f66152b = mVar;
        this.f66153c = i2;
        this.f66154d = i3;
        this.f66155e = i4;
        this.f66156f = f2;
    }

    public InterfaceC1901a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (InterfaceC1901a) invokeV.objValue;
    }

    public abstract void a(FrameLayout frameLayout);

    public void a(com.bytedance.sdk.openadsdk.component.reward.b.c cVar, com.bytedance.sdk.openadsdk.component.reward.b.d dVar, com.bytedance.sdk.openadsdk.component.reward.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, dVar, eVar) == null) {
            this.f66159i = cVar;
            this.f66160j = dVar;
            this.k = eVar;
        }
    }

    public abstract void a(com.bytedance.sdk.openadsdk.component.reward.view.c cVar);

    public abstract boolean b();

    public abstract boolean c();

    public abstract void d();

    public final void a(com.bytedance.sdk.openadsdk.core.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f66158h = eVar;
        }
    }
}
