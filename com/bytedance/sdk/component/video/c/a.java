package com.bytedance.sdk.component.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1892a f65119a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f65120b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f65121c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65123e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.component.video.b.a f65124f;

    /* renamed from: g  reason: collision with root package name */
    public Context f65125g;

    /* renamed from: com.bytedance.sdk.component.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1892a {
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65122d = false;
        this.f65123e = false;
        this.f65124f = null;
        this.f65119a = null;
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.f65120b = surface;
        }
    }

    public abstract void b();

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f65123e = z;
        }
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            this.f65121c = surfaceHolder;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f65122d = z;
        }
    }

    public void a(com.bytedance.sdk.component.video.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f65124f = aVar;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f65125g = context;
        }
    }

    public void a(InterfaceC1892a interfaceC1892a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1892a) == null) {
            this.f65119a = interfaceC1892a;
        }
    }
}
