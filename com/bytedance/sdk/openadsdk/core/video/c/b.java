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
    public final MediaPlayer f66913a;

    /* renamed from: b  reason: collision with root package name */
    public final a f66914b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.component.video.a.a f66915c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f66916d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f66917e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66918f;

    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66922a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<b> f66923b;

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
            this.f66922a = bVar;
            this.f66923b = new WeakReference<>(bVar2);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, mediaPlayer, i2) == null) {
                try {
                    if (this.f66923b.get() != null) {
                        this.f66922a.a(i2);
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
                    if (this.f66923b.get() != null) {
                        this.f66922a.c();
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
                    if (this.f66923b.get() != null) {
                        return this.f66922a.a(i2, i3);
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
                    if (this.f66923b.get() != null) {
                        return this.f66922a.b(i2, i3);
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
                    if (this.f66923b.get() != null) {
                        this.f66922a.b();
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
                    if (this.f66923b.get() != null) {
                        this.f66922a.d();
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
                    if (this.f66923b.get() != null) {
                        this.f66922a.a(i2, i3, 1, 1);
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
        this.f66917e = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f66913a = mediaPlayer;
        }
        a(mediaPlayer);
        try {
            this.f66913a.setAudioStreamType(3);
        } catch (Throwable th) {
            k.c("AndroidMediaPlayer", "setAudioStreamType error: ", th);
        }
        this.f66914b = new a(this, this);
        n();
    }

    private void m() {
        com.bytedance.sdk.component.video.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || Build.VERSION.SDK_INT < 23 || (aVar = this.f66915c) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable th) {
            k.c("AndroidMediaPlayer", "releaseMediaDataSource error: ", th);
        }
        this.f66915c = null;
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f66913a.setOnPreparedListener(this.f66914b);
            this.f66913a.setOnBufferingUpdateListener(this.f66914b);
            this.f66913a.setOnCompletionListener(this.f66914b);
            this.f66913a.setOnSeekCompleteListener(this.f66914b);
            this.f66913a.setOnVideoSizeChangedListener(this.f66914b);
            this.f66913a.setOnErrorListener(this.f66914b);
            this.f66913a.setOnInfoListener(this.f66914b);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            try {
                if (this.f66916d != null) {
                    this.f66916d.release();
                    this.f66916d = null;
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void b(boolean z) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f66913a.setLooping(z);
        }
    }

    public MediaPlayer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66913a : (MediaPlayer) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void f() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f66913a.start();
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
            this.f66913a.stop();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void h() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f66913a.pause();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                return this.f66913a.getCurrentPosition();
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
                return this.f66913a.getDuration();
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
            this.f66918f = true;
            this.f66913a.release();
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
                this.f66913a.reset();
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
            synchronized (this.f66917e) {
                if (!this.f66918f) {
                    this.f66913a.setDisplay(surfaceHolder);
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
            this.f66916d = surface;
            this.f66913a.setSurface(surface);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(String str) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
                this.f66913a.setDataSource(parse.getPath());
            } else {
                this.f66913a.setDataSource(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(FileDescriptor fileDescriptor) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fileDescriptor) == null) {
            this.f66913a.setDataSource(fileDescriptor);
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
                this.f66915c = com.bytedance.sdk.component.video.a.a.a(o.a(), aVar);
                com.bytedance.sdk.component.video.a.b.a.a(aVar);
                this.f66913a.setDataSource(this.f66915c);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(boolean z) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f66913a.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    public void a(long j2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f66913a.seekTo((int) j2);
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
                public final /* synthetic */ float f66919a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ float f66920b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f66921c;

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
                    this.f66921c = this;
                    this.f66919a = f2;
                    this.f66920b = f3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66921c.f66913a.setVolume(this.f66919a, this.f66920b);
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
            this.f66913a.setWakeMode(context, i2);
        }
    }
}
