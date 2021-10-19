package com.bytedance.sdk.openadsdk.core.video.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final MediaPlayer f67439a;

    /* renamed from: b  reason: collision with root package name */
    public final a f67440b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.video.a.a f67441c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f67442d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f67443e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67444f;

    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67448a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<b> f67449b;

        public a(b bVar, b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67448a = bVar;
            this.f67449b = new WeakReference<>(bVar2);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                try {
                    if (this.f67449b.get() != null) {
                        this.f67448a.a(i2);
                    }
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaPlayer) == null) {
                try {
                    if (this.f67449b.get() != null) {
                        this.f67448a.c();
                    }
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer, i2, i3)) == null) {
                try {
                    k.b("AndroidMediaPlayer", "onError: ", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.f67449b.get() != null) {
                        return this.f67448a.a(i2, i3);
                    }
                    return false;
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                    return false;
                }
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, mediaPlayer, i2, i3)) == null) {
                try {
                    k.c("AndroidMediaPlayer", "onInfo: ");
                    if (this.f67449b.get() != null) {
                        return this.f67448a.b(i2, i3);
                    }
                    return false;
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                    return false;
                }
            }
            return invokeLII.booleanValue;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, mediaPlayer) == null) {
                try {
                    if (this.f67449b.get() != null) {
                        this.f67448a.b();
                    }
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, mediaPlayer) == null) {
                try {
                    if (this.f67449b.get() != null) {
                        this.f67448a.d();
                    }
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
                }
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, mediaPlayer, i2, i3) == null) {
                try {
                    if (this.f67449b.get() != null) {
                        this.f67448a.a(i2, i3, 1, 1);
                    }
                } catch (Throwable th) {
                    k.c("AndroidMediaPlayer", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
                }
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
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
        Object obj = new Object();
        this.f67443e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f67439a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            this.f67439a.setAudioStreamType(3);
        } catch (Throwable th) {
            k.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.f67440b = new a(this, this);
        n();
    }

    private void m() {
        com.bytedance.sdk.component.video.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || Build.VERSION.SDK_INT < 23 || (aVar = this.f67441c) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable th) {
            k.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.f67441c = null;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f67439a.setOnPreparedListener(this.f67440b);
            this.f67439a.setOnBufferingUpdateListener(this.f67440b);
            this.f67439a.setOnCompletionListener(this.f67440b);
            this.f67439a.setOnSeekCompleteListener(this.f67440b);
            this.f67439a.setOnVideoSizeChangedListener(this.f67440b);
            this.f67439a.setOnErrorListener(this.f67440b);
            this.f67439a.setOnInfoListener(this.f67440b);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f67442d != null) {
                    this.f67442d.release();
                    this.f67442d = null;
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void b(boolean z) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f67439a.setLooping(z);
        }
    }

    public MediaPlayer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f67439a : (MediaPlayer) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void f() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f67439a.start();
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.finalize();
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void g() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f67439a.stop();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void h() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f67439a.pause();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return this.f67439a.getCurrentPosition();
            } catch (Throwable th) {
                k.c("AndroidMediaPlayer", "getCurrentPosition error: ", th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                return this.f67439a.getDuration();
            } catch (Throwable th) {
                k.c("AndroidMediaPlayer", "getDuration error: ", th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void k() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f67444f = true;
            this.f67439a.release();
            o();
            m();
            a();
            n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void l() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                this.f67439a.reset();
            } catch (Throwable th) {
                k.c("AndroidMediaPlayer", "reset error: ", th);
            }
            m();
            a();
            n();
        }
    }

    private void a(MediaPlayer mediaPlayer) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, mediaPlayer) == null) || (i2 = Build.VERSION.SDK_INT) < 19 || i2 >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object newInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(o.a(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, new Handler());
            declaredField.setAccessible(false);
            mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, newInstance, null);
        } catch (Throwable th) {
            k.c("AndroidMediaPlayer", "setSubtitleController error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            synchronized (this.f67443e) {
                if (!this.f67444f) {
                    this.f67439a.setDisplay(surfaceHolder);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    @TargetApi(14)
    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surface) == null) {
            o();
            this.f67442d = surface;
            this.f67439a.setSurface(surface);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(String str) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
                this.f67439a.setDataSource(parse.getPath());
            } else {
                this.f67439a.setDataSource(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fileDescriptor) == null) {
            this.f67439a.setDataSource(fileDescriptor);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    @RequiresApi(api = 23)
    public synchronized void a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(bVar.b())) {
                    bVar.b(com.bytedance.sdk.openadsdk.n.g.b.a(bVar.a()));
                }
                com.bytedance.sdk.component.video.b.a aVar = new com.bytedance.sdk.component.video.b.a();
                aVar.a(bVar.a());
                aVar.b(bVar.b());
                aVar.c(bVar.c());
                this.f67441c = com.bytedance.sdk.component.video.a.a.a(o.a(), aVar);
                com.bytedance.sdk.component.video.a.b.a.a(aVar);
                this.f67439a.setDataSource(this.f67441c);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(boolean z) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f67439a.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(long j2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f67439a.seekTo((int) j2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(float f2, float f3) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            l.c().post(new Runnable(this, f2, f3) { // from class: com.bytedance.sdk.openadsdk.core.video.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ float f67445a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ float f67446b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f67447c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2), Float.valueOf(f3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67447c = this;
                    this.f67445a = f2;
                    this.f67446b = f3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67447c.f67439a.setVolume(this.f67445a, this.f67446b);
                        k.c("AndroidMediaPlayer", "run: setVolume");
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(Context context, int i2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            this.f67439a.setWakeMode(context, i2);
        }
    }
}
