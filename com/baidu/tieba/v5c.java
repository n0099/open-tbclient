package com.baidu.tieba;

import android.media.MediaFormat;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.m4c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class v5c extends e6c implements m4c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int o;
    public MediaFormat p;
    public MediaInfo q;
    public p5c r;
    public WeakReference<e5c> s;
    public long t;
    public long u;
    public long v;
    public boolean w;
    public long x;
    public long y;
    public AtomicBoolean z;

    public abstract void B();

    public abstract void C();

    public abstract int D(MediaSample mediaSample);

    public abstract void z(MediaFormat mediaFormat, int i);

    public v5c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = null;
        this.q = MediaInfo.a();
        this.r = new p5c();
        this.s = new WeakReference<>(null);
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.w = true;
        this.x = 0L;
        this.y = 0L;
        this.z = new AtomicBoolean(false);
    }

    public void A() {
        a5c a5cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x();
            TLog.g(this, "MediaCodec decoderError");
            WeakReference<a5c> weakReference = this.g;
            if (weakReference != null && (a5cVar = weakReference.get()) != null) {
                Message obtain = Message.obtain();
                obtain.what = 53;
                a5cVar.a(obtain, this.a);
            }
        }
    }

    @Override // com.baidu.tieba.y5c
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TLog.g(this, "CodecFilter.setop enter.");
            this.z.set(true);
            this.l.g(1002);
            this.l.f(1002);
        }
    }

    public void E(MediaSample mediaSample, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, mediaSample, j) == null) {
            long j2 = this.y;
            if (j2 > 0) {
                long j3 = mediaSample.v;
                if (j3 < j2) {
                    j += j2 - Math.max(j3, this.x);
                }
                this.x = 0L;
                this.y = 0L;
                if (j > 0) {
                    i5c.d(mediaSample, 11, j);
                }
            } else if (j > 0) {
                i5c.d(mediaSample, 11, j);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.f.isEmpty()) {
                int i = 0;
                while (true) {
                    MediaSample poll = this.f.poll();
                    if (poll == null) {
                        break;
                    }
                    i++;
                    v(poll, 5, "player is stopped");
                    p4c.f().e(poll);
                }
                TLog.g(this, String.format("CodecFilter there are still %d entries in queue that not decoded.", Integer.valueOf(i)));
            }
            if (!this.r.b()) {
                int i2 = 0;
                while (true) {
                    MediaSample c = this.r.c();
                    if (c != null) {
                        i2++;
                        v(c, 6, "player is stopped");
                        p4c.f().e(c);
                    } else {
                        TLog.g(this, String.format("CodecFilter there are still %d entries in queue that not presented.", Integer.valueOf(i2)));
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.e6c, com.baidu.tieba.w5c
    public void a() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TLog.g(this, "CodecFilter.setup enter. type:" + q5c.a[this.q.a]);
            m4c m4cVar = this.l;
            Object[] objArr = new Object[1];
            if (this.c == 0) {
                str = "video";
            } else {
                str = "audio";
            }
            objArr[0] = str;
            m4cVar.setName(String.format("VOD %s decode", objArr));
            this.t = 0L;
            this.u = 0L;
            this.z.set(false);
            super.a();
            TLog.g(this, "CodecFilter.setup leave. type:" + q5c.a[this.q.a]);
        }
    }

    @Override // com.baidu.tieba.e6c, com.baidu.tieba.y5c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TLog.g(this, "CodecFilter.release enter. type:" + q5c.a[this.q.a]);
            super.p();
            this.p = null;
            F();
            TLog.g(this, String.format("inputCount:%d, outputCount:%d", Long.valueOf(this.t), Long.valueOf(this.u)));
            TLog.g(this, "CodecFilter.release leave. type:" + q5c.a[this.q.a]);
        }
    }

    @Override // com.baidu.tieba.e6c
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.w) {
                I();
            } else {
                H();
            }
            MediaSample peek = this.f.peek();
            if (peek == null) {
                this.l.g(2102);
                return;
            }
            synchronized (this.k) {
                if (this.d != null) {
                    this.d.e(peek.E);
                }
            }
            i5c.c(peek, 5);
            int D = D(peek);
            if (D != -2) {
                if (D != -1) {
                    if (D == 1) {
                        this.f.poll();
                    }
                } else {
                    this.f.poll();
                    v(peek, 6, "exception occurs");
                    p4c.f().e(peek);
                }
                if (!this.f.isEmpty() && !this.z.get()) {
                    this.l.f(2102);
                    return;
                }
                return;
            }
            x5c x5cVar = this.e;
            if (x5cVar != null) {
                x5cVar.j(D);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.r.b()) {
            int i = 0;
            while (true) {
                MediaSample c = this.r.c();
                if (c != null) {
                    i++;
                    p4c.f().e(c);
                } else {
                    TLog.g(this, String.format("there are still %d entries in queue that not presented.", Integer.valueOf(i)));
                    return;
                }
            }
        }
    }

    public final void H() {
        MediaSample poll;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f.size() >= 15 && (poll = this.f.poll()) != null) {
            MediaInfo mediaInfo = poll.i;
            if (mediaInfo.k != null) {
                mediaInfo.k = null;
            }
            p4c.f().e(poll);
        }
    }

    public final void I() {
        int size;
        MediaSample peek;
        MediaSample poll;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (size = this.f.size()) >= 15 && (peek = this.f.peek()) != null && peek.d) {
            Iterator<MediaSample> it = this.f.iterator();
            int i = -1;
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            while (it.hasNext()) {
                MediaSample next = it.next();
                i2++;
                if (i2 != 0 && next.d && i3 == -1) {
                    i3 = i2;
                    z = true;
                }
            }
            if (z) {
                TLog.g(this, "first frame index 0second frame index " + i3 + "inputSize " + size);
                Iterator<MediaSample> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    i++;
                    if (i >= 0 && i < i3 && (poll = this.f.poll()) != null) {
                        MediaInfo mediaInfo = poll.i;
                        if (mediaInfo.k != null) {
                            mediaInfo.k = null;
                        }
                        p4c.f().e(poll);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.y5c, com.baidu.tieba.w5c
    public void d(String str, Object obj, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.t = 0L;
            this.u = 0L;
            if (str.compareTo("setFormat") == 0 && (obj instanceof MediaFormat)) {
                Message obtain = Message.obtain();
                obtain.what = 2001;
                obtain.obj = obj;
                obtain.arg1 = i;
                this.l.g(2001);
                this.l.sendMessage(obtain);
                TLog.g(this, "CodecFilter sendEmptyMessage(CODEC_FILTER_CREATE_DECODER)");
            }
            super.d(str, obj, i, z);
        }
    }

    @Override // com.baidu.tieba.y5c, com.baidu.tieba.w5c
    public final void f(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mediaSample) == null) {
            if (this.z.get()) {
                TLog.c(this, "CodecFilter codec is stop");
                p4c.f().e(mediaSample);
            } else if (mediaSample.f) {
                p4c.f().e(mediaSample);
                TLog.c(this, "CodecFilter.processMediaSample bForVideoCodecConfigfOnly is true!!");
            } else {
                this.t++;
                mediaSample.s = this.o;
                i5c.c(mediaSample, 4);
                this.f.add(mediaSample);
                x5c x5cVar = this.e;
                if (x5cVar != null && this.i && x5cVar.g() == 6) {
                    this.l.f(2102);
                }
            }
        }
    }

    @Override // com.baidu.tieba.e6c, com.baidu.tieba.m4c.a
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, message) == null) {
            switch (message.what) {
                case 2001:
                    z((MediaFormat) message.obj, message.arg1);
                    return;
                case 2002:
                    B();
                    return;
                case 2003:
                    C();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }
}
