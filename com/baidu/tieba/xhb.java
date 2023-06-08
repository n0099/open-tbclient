package com.baidu.tieba;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.tieba.pib;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class xhb extends zhb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger A;
    public AtomicBoolean B;
    public pib.k C;
    public SurfaceTexture.OnFrameAvailableListener D;
    public MediaInfo o;
    public long p;
    public pib q;
    public AtomicInteger r;
    public boolean s;
    public AtomicBoolean t;
    public AtomicBoolean u;
    public int v;
    public boolean w;
    public WeakReference<zgb> x;
    public boolean y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements pib.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xhb a;

        public a(xhb xhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xhbVar;
        }

        @Override // com.baidu.tieba.pib.k
        public void a(MediaSample mediaSample, int i, int i2, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mediaSample, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
                long e = j - this.a.e.e();
                vgb vgbVar = this.a.g.get();
                if (vgbVar != null) {
                    vgbVar.a(Message.obtain(null, SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_DATABACK_STAMP_KEY, i, i2, Long.valueOf(e)), i3);
                }
                TLog.h("transvod", " onFirstFrameAgainPresented, width=" + i + " height=" + i2 + " costMs=" + e);
            }
        }

        @Override // com.baidu.tieba.pib.k
        public void c(MediaSample mediaSample, int i, int i2, long j, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{mediaSample, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
                long e = j - this.a.e.e();
                vgb vgbVar = this.a.g.get();
                if (vgbVar != null) {
                    vgbVar.a(Message.obtain(null, 5102, i, i2, Long.valueOf(e)), i3);
                }
                TLog.m("transvod", " onFirstFramePresented, width=" + i + " height=" + i2 + " costMs=" + e);
            }
        }

        @Override // com.baidu.tieba.pib.k
        public void b() {
            vgb vgbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (vgbVar = this.a.g.get()) != null) {
                vgbVar.a(Message.obtain((Handler) null, (int) SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_START_STAMP_KEY), -1);
            }
        }

        @Override // com.baidu.tieba.pib.k
        public void d() {
            vgb vgbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (vgbVar = this.a.g.get()) != null) {
                vgbVar.a(Message.obtain((Handler) null, (int) SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_END_STAMP_KEY), -1);
                TLog.g(this, "onSurfaceCreated");
            }
        }

        @Override // com.baidu.tieba.pib.k
        public void onSurfaceChanged(int i, int i2) {
            vgb vgbVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && (vgbVar = this.a.g.get()) != null) {
                vgbVar.a(Message.obtain(null, SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONRESUME_STAMP_KEY, i, i2), -1);
                TLog.g(this, "onSurfaceChanged");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xhb a;

        public b(xhb xhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xhbVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                try {
                    this.a.q.E(false);
                    surfaceTexture.updateTexImage();
                    long timestamp = surfaceTexture.getTimestamp() / 1000000;
                    MediaSample poll = this.a.f.poll();
                    if (poll != null) {
                        if (poll.i.a == 8) {
                            if (this.a.o.e(poll.i)) {
                                this.a.o.c(poll.i);
                                this.a.Y(poll.i);
                                poll.b = true;
                                TLog.g(this, "OpenGLFilter updateConfig :: OnFrameAvailableListener");
                            }
                            poll.h = surfaceTexture;
                            this.a.O(poll);
                            this.a.q.t(poll);
                            this.a.N(poll);
                            if (timestamp != 0 && (Math.abs(timestamp - poll.l) < 10000 || Math.abs(this.a.p - timestamp) < 10000)) {
                                poll.l = timestamp;
                                if (this.a.y) {
                                    TLog.g(this, "[decoder] use the surfaceStamp!!!, sample.Pts =" + poll.l);
                                    this.a.y = false;
                                }
                            }
                        }
                        kgb.f().e(poll);
                    }
                } catch (Exception e) {
                    TLog.c(this, "updateTexImage exception:" + e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xhb(Context context, Object obj, int i, boolean z, int i2, zgb zgbVar) {
        super(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, obj, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), zgbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = MediaInfo.a();
        this.p = 0L;
        this.q = null;
        this.r = new AtomicInteger(0);
        this.s = false;
        this.t = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.v = -1;
        this.x = new WeakReference<>(null);
        this.y = true;
        this.z = 0;
        this.A = new AtomicInteger(0);
        this.B = new AtomicBoolean(false);
        this.C = new a(this);
        this.D = new b(this);
        if (obj instanceof SurfaceView) {
            this.q = new uib(context, (SurfaceView) obj, i, i2, zgbVar);
            TLog.g(this, "OpenGLFilter:: renderType: OutputSurfaceView");
        } else if (obj instanceof TextureView) {
            this.q = new vib(context, (TextureView) obj, i, i2, zgbVar);
            TLog.g(this, "OpenGLFilter:: renderType: OutputTextureView");
        } else if (obj instanceof hib) {
            this.q = new tib(context, (hib) obj, i, i2, zgbVar);
            TLog.g(this, "OpenGLFilter:: renderType: ExternalSurfaceView");
        } else if (obj instanceof gib) {
            this.q = new sib(context, (gib) obj, i, i2, zgbVar);
            TLog.g(this, "OpenGLFilter:: renderType: ExternalSurface");
        }
        this.b = i;
        this.s = z;
        this.l.setName("VOD video render");
        this.l.d(-8);
        this.q.Q(this.l);
        this.q.L(this.D);
        this.q.P(0);
        this.q.M(this.C);
        this.x = new WeakReference<>(zgbVar);
        super.a();
    }

    public void I(igb igbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, igbVar) == null) {
            this.q.v(igbVar);
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.q.H(i);
        }
    }

    public void S(sgb sgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sgbVar) == null) {
            this.q.I(sgbVar);
        }
    }

    public void T(boolean z) {
        pib pibVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (pibVar = this.q) != null) {
            pibVar.J(z);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.w = z;
            TLog.g(this, String.format(Locale.getDefault(), "zwsetEnableRevDecodeOutputSize: %d ", Integer.valueOf(this.w ? 1 : 0)));
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.q.K(z);
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.q.N(i);
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.q.O(i);
        }
    }

    public void P(Executor executor, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, executor, obj) == null) {
            this.q.F(executor, obj);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q.p();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.s();
        }
    }

    public pib J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.q;
        }
        return (pib) invokeV.objValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.A.incrementAndGet();
        }
    }

    @Override // com.baidu.tieba.zhb, com.baidu.tieba.rhb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TLog.g(this, "OpenGLFilter.setup enter.");
            this.t.set(true);
            this.p = 0L;
            this.y = true;
            TLog.g(this, "OpenGLFilter.setup leave.");
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.finalize();
        }
    }

    @Override // com.baidu.tieba.thb
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            TLog.g(this, "sendEmptyMessage(PLAYBACK_RENDER_PENDING_CLEAR)");
            this.l.g(2202);
            this.l.f(2202);
        }
    }

    @Override // com.baidu.tieba.zhb, com.baidu.tieba.hgb.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            TLog.g(this, "OpenGLFilter.onStart.");
            handleMessage(Message.obtain((Handler) null, 2408));
        }
    }

    @Override // com.baidu.tieba.zhb, com.baidu.tieba.hgb.a
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            TLog.g(this, "OpenGLFilter.onStop.");
        }
    }

    @Override // com.baidu.tieba.zhb, com.baidu.tieba.thb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.l.g(ErrorConstant.Code.DATA_WRITE_DB);
            this.l.f(ErrorConstant.Code.DATA_WRITE_DB);
            this.l.c();
        }
    }

    public final void K() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f.isEmpty()) {
                i = 0;
                while (true) {
                    MediaSample poll = this.f.poll();
                    if (poll == null) {
                        break;
                    }
                    i++;
                    v(poll, 9, "player is stopped");
                    if (poll.i.k != null) {
                        if (this.m.getElementCount() < 5) {
                            this.m.add(poll.i.k);
                        }
                        poll.i.k = null;
                    }
                    kgb.f().e(poll);
                }
            } else {
                i = 0;
            }
            if (this.m.getElementCount() > 5) {
                TLog.g(this, "shrink free queue begin: ");
                int i2 = 0;
                while (true) {
                    if (this.m.poll() == null) {
                        break;
                    }
                    i2++;
                    if (this.m.getElementCount() <= 5) {
                        TLog.g(this, "drop free queue elements: " + i2);
                        break;
                    }
                }
            }
            TLog.g(this, String.format("there are still %d entries in queue that not presented, freeQueue %d entries.", Integer.valueOf(i), Integer.valueOf(this.m.getElementCount())));
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.u.set(true);
            this.a = i;
            vgb vgbVar = this.g.get();
            if (vgbVar != null) {
                vgbVar.a(Message.obtain((Handler) null, (int) SpeedStatsStampTable.PUSH_SCHEME_MID_ACTIVITY_ONCREATE_END_STAMP_KEY), this.a);
            }
            TLog.g(this, "OpenGLFilter pause");
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.u.set(false);
            this.a = i;
            this.A.incrementAndGet();
            vgb vgbVar = this.g.get();
            if (vgbVar != null) {
                vgbVar.a(Message.obtain((Handler) null, (int) SpeedStatsStampTable.PUSH_SCHEME_LANDING_ACTIVITY_ONCREATE_START_STAMP_KEY), this.a);
            }
            TLog.g(this, "OpenGLFilter resume");
        }
    }

    public void Y(MediaInfo mediaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaInfo) == null) {
            if (!this.t.get()) {
                TLog.c(this, "render config error" + this.t.get());
                return;
            }
            this.q.V(mediaInfo);
        }
    }

    public final void N(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mediaSample) == null) {
            dhb.c(mediaSample, 10);
            long j = mediaSample.z - mediaSample.u;
            zgb zgbVar = this.x.get();
            if (zgbVar != null) {
                zgbVar.u();
                zgbVar.C((int) j);
                zgbVar.A(System.currentTimeMillis());
            }
            mediaSample.L = this.A.get();
            if (this.q.w() > 0 && this.z < 3) {
                mediaSample.N = this.q.w();
                this.z++;
            }
            this.q.x(mediaSample);
            w(mediaSample);
        }
    }

    @Override // com.baidu.tieba.zhb, com.baidu.tieba.hgb.a
    public final void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, message) == null) {
            switch (message.what) {
                case 2201:
                    this.D.onFrameAvailable(this.q.y());
                    break;
                case 2202:
                    TLog.g(this, "handle message: PLAYBACK_RENDER_PENDING_CLEAR");
                    this.q.u();
                    break;
                case 2203:
                    TLog.g(this, "handle message: PLAYBACK_RENDER_SAMPLES_CLEAR");
                    this.q.T();
                    K();
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
            this.q.z(message);
        }
    }

    public final void O(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSample) == null) {
            dhb.c(mediaSample, 9);
            zgb zgbVar = this.x.get();
            if (zgbVar != null) {
                zgbVar.B(System.currentTimeMillis());
            }
            int i = mediaSample.g.d;
            if (i != this.v) {
                this.z = 0;
            }
            if (mediaSample.b || i != this.v || this.w) {
                TLog.g(this, String.format(Locale.getDefault(), "openglFilter output size %d * %d  changedTag %d", Integer.valueOf(mediaSample.i.b), Integer.valueOf(mediaSample.i.c), Integer.valueOf(mediaSample.b ? 1 : 0)));
                this.v = i;
                this.w = false;
                if (zgbVar != null) {
                    MediaInfo mediaInfo = mediaSample.i;
                    zgbVar.y(mediaInfo.b, mediaInfo.c);
                }
            }
        }
    }

    @Override // com.baidu.tieba.thb, com.baidu.tieba.rhb
    public void d(String str, Object obj, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.a = i;
            this.y = true;
        }
    }

    @Override // com.baidu.tieba.thb, com.baidu.tieba.rhb
    public final void f(MediaSample mediaSample) {
        MediaSample poll;
        MediaSample poll2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, mediaSample) != null) || mediaSample == null) {
            return;
        }
        if (!this.u.get() && this.t.get()) {
            if (mediaSample.D && !this.i) {
                return;
            }
            this.p = mediaSample.l;
            int elementCount = this.f.getElementCount();
            if (mediaSample.i.a != 8) {
                if (elementCount >= 15 && (poll2 = this.f.poll()) != null) {
                    ByteBuffer byteBuffer = poll2.i.k;
                    if (byteBuffer != null) {
                        this.m.add(byteBuffer);
                        poll2.i.k = null;
                    }
                    kgb.f().e(poll2);
                    this.r.incrementAndGet();
                }
                ByteBuffer poll3 = this.m.poll();
                int remaining = mediaSample.i.k.remaining();
                if (poll3 == null || poll3.capacity() < remaining) {
                    poll3 = ByteBuffer.allocateDirect(remaining);
                    TLog.g(this, "allocate a new one. capacity:" + remaining);
                }
                poll3.clear();
                mediaSample.i.k.mark();
                poll3.put(mediaSample.i.k).flip();
                mediaSample.i.k.reset();
                mediaSample.i.k = poll3;
            } else if (this.B.get() && elementCount > 0) {
                while (true) {
                    MediaSample poll4 = this.f.poll();
                    if (poll4 == null) {
                        break;
                    }
                    MediaInfo mediaInfo = poll4.i;
                    if (mediaInfo.k != null) {
                        mediaInfo.k = null;
                    }
                    kgb.f().e(poll4);
                    this.r.incrementAndGet();
                }
            } else if (elementCount >= 5 && (poll = this.f.poll()) != null) {
                MediaInfo mediaInfo2 = poll.i;
                if (mediaInfo2.k != null) {
                    mediaInfo2.k = null;
                }
                kgb.f().e(poll);
                this.r.incrementAndGet();
            }
            dhb.c(mediaSample, 8);
            this.f.add(mediaSample);
            if ((this.e.g() == 6 || this.e.g() == 7) && mediaSample.i.a != 8) {
                this.l.f(2102);
                return;
            }
            return;
        }
        kgb.f().e(mediaSample);
    }

    @Override // com.baidu.tieba.thb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            TLog.g(this, "OpenGLFilter.stop enter, dropCount=" + this.r.get());
            this.r.set(0);
            if (!this.t.get()) {
                TLog.g(this, "OpenGLFilter.stop return.");
                return;
            }
            this.t.set(false);
            this.u.set(false);
            if (this.s) {
                this.l.g(2202);
                this.l.f(2202);
            }
            this.l.g(2203);
            this.l.f(2203);
            TLog.g(this, "OpenGLFilter.stop leave.");
        }
    }

    @Override // com.baidu.tieba.zhb
    public void y() {
        MediaInfo mediaInfo;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MediaSample poll = this.f.poll();
            if (poll != null && poll.g != null) {
                MediaInfo mediaInfo2 = poll.i;
                if (mediaInfo2.k != null) {
                    if (this.o.e(mediaInfo2)) {
                        this.o.c(poll.i);
                        Y(poll.i);
                        poll.b = true;
                        TLog.g(this, "OpenGLFilter updateConfig :: onInputAvailable");
                    }
                    O(poll);
                    this.q.t(poll);
                    N(poll);
                    if (poll != null && (mediaInfo = poll.i) != null && (byteBuffer = mediaInfo.k) != null) {
                        this.m.add(byteBuffer);
                        poll.i.k = null;
                    }
                    kgb.f().e(poll);
                    if (!this.f.isEmpty()) {
                        this.l.f(2102);
                        return;
                    }
                    return;
                }
            }
            this.l.g(2102);
        }
    }
}
