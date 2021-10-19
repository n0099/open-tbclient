package com.bytedance.sdk.component.video.view;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.video.c.a;
import com.bytedance.sdk.component.video.d.c;
import com.bytedance.sdk.component.video.d.d;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class PlayerLayout extends FrameLayout implements a.InterfaceC1898a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static AudioManager.OnAudioFocusChangeListener f65657b;

    /* renamed from: d  reason: collision with root package name */
    public static int f65658d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65659a;

    /* renamed from: c  reason: collision with root package name */
    public int f65660c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.component.video.c.a f65661e;

    /* renamed from: f  reason: collision with root package name */
    public Class f65662f;

    /* renamed from: g  reason: collision with root package name */
    public TextureView f65663g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceView f65664h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65665i;

    /* renamed from: j  reason: collision with root package name */
    public Timer f65666j;
    public AudioManager k;
    public a l;
    public long m;
    public com.bytedance.sdk.component.video.b.a n;
    public boolean o;

    /* loaded from: classes9.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayerLayout f65669a;

        public a(PlayerLayout playerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65669a = playerLayout;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f65669a.f65660c;
                if (i2 == 5 || i2 == 6 || i2 == 3) {
                    this.f65669a.post(new Runnable(this) { // from class: com.bytedance.sdk.component.video.view.PlayerLayout.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a f65670a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f65670a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                long currentPositionWhenPlaying = this.f65670a.f65669a.getCurrentPositionWhenPlaying();
                                long duration = this.f65670a.f65669a.getDuration();
                                this.f65670a.f65669a.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1290997503, "Lcom/bytedance/sdk/component/video/view/PlayerLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1290997503, "Lcom/bytedance/sdk/component/video/view/PlayerLayout;");
                return;
            }
        }
        f65657b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.component.video.view.PlayerLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                }
            }
        };
        f65658d = -1;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                com.bytedance.sdk.component.video.c.a aVar = (com.bytedance.sdk.component.video.c.a) this.f65662f.getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f65661e = aVar;
                aVar.a(getContext());
                this.f65661e.b(this.f65665i);
                this.f65661e.a(this.o);
                this.f65661e.a(this);
                this.f65661e.a(this.n);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
            if (this.o) {
                j();
            } else {
                k();
            }
            AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.k = audioManager;
            audioManager.requestAudioFocus(f65657b, 3, 2);
            d.a(getContext()).getWindow().addFlags(128);
            c();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.b("PlayerLayout", "video_new onStateNormal ", Integer.valueOf(hashCode()));
            this.f65660c = 0;
            m();
            com.bytedance.sdk.component.video.c.a aVar = this.f65661e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.b("PlayerLayout", "video_new onStatePreparing ", Integer.valueOf(hashCode()));
            this.f65660c = 1;
            n();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.b("PlayerLayout", "video_new onStatePreparingPlaying ", Integer.valueOf(hashCode()));
            this.f65660c = 3;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.b("PlayerLayout", "video_new onStatePreparingChangeUrl ", Integer.valueOf(hashCode()));
            this.f65660c = 2;
            a();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.b("PlayerLayout", "video_new onStatePlaying seekToInAdvance=", Integer.valueOf(this.f65659a), Integer.valueOf(hashCode()));
            if (this.f65660c == 4) {
                int i2 = this.f65659a;
                if (i2 != 0) {
                    this.f65661e.a(i2);
                    c.a("PlayerLayout", "video_new onStatePlaying seekTo");
                    this.f65659a = 0;
                } else {
                    this.f65661e.a(0);
                }
            }
            this.f65660c = 5;
            l();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.b("PlayerLayout", "video_new onStatePause ", Integer.valueOf(hashCode()));
            this.f65660c = 6;
            m();
        }
    }

    public long getCurrentPositionWhenPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f65660c;
            if (i2 == 5 || i2 == 6 || i2 == 3) {
                try {
                    return this.f65661e.c();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return this.f65661e.d();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.b("PlayerLayout", "video_new onStateError ", Integer.valueOf(hashCode()));
            this.f65660c = 8;
            m();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.b("PlayerLayout", "video_new onStateAutoComplete ", Integer.valueOf(hashCode()));
            this.f65660c = 7;
            m();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a("PlayerLayout", "video_new addTextureView ", Integer.valueOf(hashCode()));
            removeAllViews();
            TextureView textureView = new TextureView(getContext().getApplicationContext());
            this.f65663g = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.bytedance.sdk.component.video.view.PlayerLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PlayerLayout f65667a;

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
                    this.f65667a = this;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                    com.bytedance.sdk.component.video.c.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i2, i3) == null) || (aVar = this.f65667a.f65661e) == null) {
                        return;
                    }
                    aVar.a(new Surface(surfaceTexture));
                    this.f65667a.f65661e.a();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                        c.a("PlayerLayout", "video_new  onSurfaceTextureDestroyed: ");
                        return false;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i2, i3) == null) {
                    }
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, surfaceTexture) == null) {
                    }
                }
            });
            addView(this.f65663g, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a("PlayerLayout", "video_new addSurfaceView ", Integer.valueOf(hashCode()));
            removeAllViews();
            SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
            this.f65664h = surfaceView;
            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(this) { // from class: com.bytedance.sdk.component.video.view.PlayerLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PlayerLayout f65668a;

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
                    this.f65668a = this;
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, surfaceHolder, i2, i3, i4) == null) {
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceHolder) == null) || this.f65668a.f65661e == null) {
                        return;
                    }
                    surfaceHolder.setType(3);
                    this.f65668a.f65661e.a(surfaceHolder);
                    this.f65668a.f65661e.a();
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder) == null) {
                        c.a("PlayerLayout", "video_new surfaceDestroyed ", Integer.valueOf(hashCode()));
                        PlayerLayout playerLayout = this.f65668a;
                        com.bytedance.sdk.component.video.c.a aVar = playerLayout.f65661e;
                        if (aVar != null) {
                            playerLayout.f65659a = aVar.c();
                            this.f65668a.f65661e.b();
                            c.a("PlayerLayout", "video_new  ", Integer.valueOf(this.f65668a.f65659a));
                        }
                    }
                }
            });
            this.f65664h.setZOrderOnTop(true);
            this.f65664h.setZOrderMediaOverlay(true);
            addView(this.f65664h, new FrameLayout.LayoutParams(-1, -1, 17));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.b("PlayerLayout", "startProgressTimer: ", Integer.valueOf(hashCode()));
            m();
            this.f65666j = new Timer();
            a aVar = new a(this);
            this.l = aVar;
            this.f65666j.schedule(aVar, 0L, 300L);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Timer timer = this.f65666j;
            if (timer != null) {
                timer.cancel();
            }
            a aVar = this.l;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m = 0L;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.b("PlayerLayout", "video_new reset ", Integer.valueOf(hashCode()));
            m();
            b();
            removeAllViews();
            ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(f65657b);
            d.a(getContext()).getWindow().clearFlags(128);
            com.bytedance.sdk.component.video.c.a aVar = this.f65661e;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void setMediaInterface(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cls) == null) {
            o();
            this.f65662f = cls;
        }
    }

    public void setState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            switch (i2) {
                case 0:
                    b();
                    return;
                case 1:
                    c();
                    return;
                case 2:
                    e();
                    return;
                case 3:
                    d();
                    return;
                case 4:
                default:
                    return;
                case 5:
                    f();
                    return;
                case 6:
                    g();
                    return;
                case 7:
                    i();
                    return;
                case 8:
                    h();
                    return;
            }
        }
    }

    public void a(int i2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.m = j2;
            c.b("PlayerLayout", "onProgress:  progress =", Integer.valueOf(i2), "  position = ", Long.valueOf(j2), "  duration=", Long.valueOf(j3));
        }
    }
}
