package com.bytedance.sdk.component.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0326a f28952a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f28953b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f28954c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28955d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28956e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.component.video.b.a f28957f;

    /* renamed from: g  reason: collision with root package name */
    public Context f28958g;

    /* renamed from: com.bytedance.sdk.component.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0326a {
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
        this.f28955d = false;
        this.f28956e = false;
        this.f28957f = null;
        this.f28952a = null;
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            this.f28953b = surface;
        }
    }

    public abstract void b();

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f28956e = z;
        }
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            this.f28954c = surfaceHolder;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f28955d = z;
        }
    }

    public void a(com.bytedance.sdk.component.video.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f28957f = aVar;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f28958g = context;
        }
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0326a) == null) {
            this.f28952a = interfaceC0326a;
        }
    }
}
