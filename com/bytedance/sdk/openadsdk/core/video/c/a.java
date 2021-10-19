package com.bytedance.sdk.openadsdk.core.video.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.video.c.c;
/* loaded from: classes9.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.e f67432a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f67433b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f67434c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f67435d;

    /* renamed from: e  reason: collision with root package name */
    public c.g f67436e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC1915c f67437f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f67438g;

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
            this.f67432a = eVar;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            try {
                if (this.f67432a != null) {
                    this.f67432a.b(this);
                }
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                if (this.f67433b != null) {
                    this.f67433b.a(this);
                }
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                if (this.f67435d != null) {
                    this.f67435d.c(this);
                }
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f67433b = bVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f67434c = aVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f67435d = fVar;
        }
    }

    public final boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            try {
                if (this.f67438g != null) {
                    return this.f67438g.b(this, i2, i3);
                }
                return false;
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.InterfaceC1915c interfaceC1915c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC1915c) == null) {
            this.f67437f = interfaceC1915c;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f67438g = dVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public final void a(c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f67436e = gVar;
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67432a = null;
            this.f67434c = null;
            this.f67433b = null;
            this.f67435d = null;
            this.f67436e = null;
            this.f67437f = null;
            this.f67438g = null;
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                if (this.f67434c != null) {
                    this.f67434c.a(this, i2);
                }
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
            }
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            try {
                if (this.f67436e != null) {
                    this.f67436e.a(this, i2, i3, i4, i5);
                }
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
            }
        }
    }

    public final boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            try {
                if (this.f67437f != null) {
                    return this.f67437f.a(this, i2, i3);
                }
                return false;
            } catch (Throwable th) {
                k.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
                return false;
            }
        }
        return invokeII.booleanValue;
    }
}
