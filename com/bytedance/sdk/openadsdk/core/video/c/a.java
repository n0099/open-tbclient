package com.bytedance.sdk.openadsdk.core.video.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.video.c.c;
/* loaded from: classes6.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.e f30498a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f30499b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f30500c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f30501d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f30502e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0343c f30503f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f30504g;

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
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.f30498a = eVar;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                if (this.f30498a != null) {
                    this.f30498a.b(this);
                }
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                if (this.f30499b != null) {
                    this.f30499b.a(this);
                }
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                if (this.f30501d != null) {
                    this.f30501d.c(this);
                }
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f30499b = bVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f30500c = aVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f30501d = fVar;
        }
    }

    public final boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            try {
                if (this.f30504g != null) {
                    return this.f30504g.b(this, i2, i3);
                }
                return false;
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.InterfaceC0343c interfaceC0343c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0343c) == null) {
            this.f30503f = interfaceC0343c;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f30504g = dVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f30502e = gVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30498a = null;
            this.f30500c = null;
            this.f30499b = null;
            this.f30501d = null;
            this.f30502e = null;
            this.f30503f = null;
            this.f30504g = null;
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                if (this.f30500c != null) {
                    this.f30500c.a(this, i2);
                }
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            try {
                if (this.f30502e != null) {
                    this.f30502e.a(this, i2, i3, i4, i5);
                }
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
            }
        }
    }

    public final boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            try {
                if (this.f30503f != null) {
                    return this.f30503f.a(this, i2, i3);
                }
                return false;
            } catch (Throwable th) {
                j.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
                return false;
            }
        }
        return invokeII.booleanValue;
    }
}
