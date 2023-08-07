package com.baidu.tieba;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class zvb extends jwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public int B;
    public long C;
    public int D;
    public int E;
    public long F;
    public AtomicLong G;
    public final String o;
    public byte[] p;
    public int q;
    public MediaFormat r;
    public MediaFormat s;
    public AudioTrack t;
    public AtomicBoolean u;
    public AtomicBoolean v;
    public AtomicInteger w;
    public long x;
    public long y;
    public long z;

    public zvb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = zvb.class.getSimpleName();
        this.p = null;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.w = new AtomicInteger(-1);
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.B = 0;
        this.C = 0L;
        this.F = 0L;
        this.G = new AtomicLong(0L);
        this.l.setName("VOD Audio playback");
        this.b = i;
    }

    public final void A(boolean z) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.x == 0) {
                this.x = currentTimeMillis;
            }
            int i2 = (int) (currentTimeMillis - this.x);
            if ((!z && i2 < 5000) || (i = this.B) == 0) {
                return;
            }
            int i3 = i2 / 1000;
            if (i3 == 0) {
                j = (this.A * 8) / 1024;
            } else {
                i /= i3;
                j = ((this.A * 8) / i3) / 1024;
            }
            TLog.h("[AudioMonitor]", String.format("playuid %d, %d ms, fps %d, %d kbps, frames %d, channel %d, sampleRate %d, pts [%d, %d]", Integer.valueOf(this.b), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf((int) j), Integer.valueOf(this.B), Integer.valueOf(this.D), Integer.valueOf(this.E), Long.valueOf(this.y), Long.valueOf(this.z)));
            G();
            this.x = currentTimeMillis;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0082 -> B:31:0x0087). Please submit an issue!!! */
    @Override // com.baidu.tieba.dwb
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            synchronized (this) {
                TLog.g(this, "set volume old: " + this.w.get() + " new: " + i);
                this.w.set(i);
                if (this.t != null) {
                    float minVolume = AudioTrack.getMinVolume();
                    float maxVolume = AudioTrack.getMaxVolume();
                    float f = i / 1000.0f;
                    if (f >= minVolume) {
                        if (f > maxVolume) {
                            minVolume = maxVolume;
                        } else {
                            minVolume = f;
                        }
                    }
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            TLog.g(this, "set volume " + minVolume);
                            this.t.setVolume(minVolume);
                        } else {
                            TLog.g(this, "set volume++ " + minVolume);
                            this.t.setStereoVolume(minVolume, minVolume);
                        }
                    } catch (Exception unused) {
                        TLog.g(this, "set volume error");
                    }
                }
            }
        }
    }

    public final AudioTrack B(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            this.E = i;
            this.D = i2;
            int i4 = (i2 << 1) * 2048;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 6) {
                            if (i2 != 8) {
                                i3 = 1;
                            } else {
                                i3 = 1020;
                            }
                        } else {
                            i3 = GDiffPatcher.COPY_INT_UBYTE;
                        }
                    } else {
                        i3 = 204;
                    }
                } else {
                    i3 = 12;
                }
            } else {
                i3 = 4;
            }
            this.p = new byte[i4];
            try {
                return new AudioTrack(3, i, i3, 2, i4, 1);
            } catch (IllegalArgumentException e) {
                TLog.g(this, "createAudioTrack error = " + e.getMessage());
                return null;
            } catch (Throwable th) {
                TLog.g(this, "createAudioTrack exception = " + th.toString());
                return null;
            }
        }
        return (AudioTrack) invokeII.objValue;
    }

    public final void C(MediaFormat mediaFormat) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaFormat) == null) {
            TLog.g(this, "AudioTrackFilter.internalCreatePlayback enter.");
            if (mediaFormat == null) {
                TLog.c(this, "MediaFormat is null");
                return;
            }
            G();
            int integer = mediaFormat.getInteger("sample-rate");
            int integer2 = mediaFormat.getInteger("channel-count");
            AudioTrack audioTrack = this.t;
            if (audioTrack != null) {
                i = audioTrack.getSampleRate();
            } else {
                i = 0;
            }
            AudioTrack audioTrack2 = this.t;
            if (audioTrack2 != null) {
                i2 = audioTrack2.getChannelCount();
            } else {
                i2 = 0;
            }
            if (this.t != null && integer == i && integer2 == i2) {
                TLog.g(this, "error: no need to create");
            } else {
                AudioTrack audioTrack3 = this.t;
                if (audioTrack3 != null && audioTrack3.getState() != 0) {
                    this.t.flush();
                    this.t.stop();
                    this.t.release();
                    TLog.g(this, "remove AudioTrack.");
                }
                TLog.g(this, String.format("create AudioTrack. sampleRate:%d, channels:%d", Integer.valueOf(integer), Integer.valueOf(integer2)));
                AudioTrack B = B(integer, integer2);
                this.t = B;
                if (B != null) {
                    if (B.getState() == 0) {
                        TLog.c(this, "create audio track failed, state is uninitialized!");
                        return;
                    }
                    if (this.w.get() != -1) {
                        String str = this.o;
                        TLog.h(str, "delay set volume:" + this.w.get());
                        u(this.w.get());
                    }
                    this.t.play();
                    this.u.set(false);
                } else {
                    TLog.g(this, "error: audioTrack create error");
                }
            }
            TLog.g(this, "AudioTrackFilter.internalCreatePlayback  leave.");
        }
    }

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.bwb
    public void f(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mediaSample) == null) {
            if (!this.u.get() && !this.v.get()) {
                if (this.f.getElementCount() >= 8) {
                    MediaSample poll = this.f.poll();
                    if (poll != null) {
                        ByteBuffer byteBuffer = poll.i.k;
                        if (byteBuffer != null) {
                            this.m.add(byteBuffer);
                            poll.i.k = null;
                        }
                        uub.f().e(poll);
                    }
                    long j = this.F + 1;
                    this.F = j;
                    if (j % 45 == 0) {
                        TLog.l(this, " inputCount >= MAX_MEDIA_SAMPLE_COUNT  playTag = " + this.G);
                    }
                }
                ByteBuffer poll2 = this.m.poll();
                int remaining = mediaSample.i.k.remaining();
                if (poll2 == null || poll2.capacity() < remaining) {
                    poll2 = ByteBuffer.allocateDirect(remaining);
                    TLog.g(this, "allocate a new one. capacity:" + remaining);
                }
                poll2.clear();
                mediaSample.i.k.mark();
                poll2.put(mediaSample.i.k).flip();
                mediaSample.i.k.reset();
                mediaSample.i.k = poll2;
                this.f.add(mediaSample);
                if (this.e.g() == 6) {
                    this.l.f(2102);
                    return;
                }
                return;
            }
            uub.f().e(mediaSample);
        }
    }

    public final void D() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
                        if (this.m.getElementCount() < 15) {
                            this.m.add(poll.i.k);
                        }
                        poll.i.k = null;
                    }
                    uub.f().e(poll);
                }
            } else {
                i = 0;
            }
            TLog.g(this, String.format("there are still %d entries in queue that not presented, freeQueue %d entries.", Integer.valueOf(i), Integer.valueOf(this.m.getElementCount())));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (this.s == null) {
                    C(this.r);
                    this.s = this.r;
                    TLog.g(this, " create AudioTrack  current channel count  " + this.s.getInteger("channel-count"));
                    D();
                } else if (!this.s.equals(this.r)) {
                    C(this.r);
                    this.s = this.r;
                    TLog.g(this, " create AudioTrack  current channel count  " + this.s.getInteger("channel-count"));
                    D();
                }
            }
        }
    }

    public final void E(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mediaSample) == null) {
            this.A += mediaSample.g.l;
            this.B++;
            if (this.y == 0) {
                this.y = mediaSample.l;
            }
            this.z = mediaSample.l;
            A(false);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.v.set(true);
            this.a = i;
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.v.set(false);
            this.a = i;
        }
    }

    @Override // com.baidu.tieba.jwb, com.baidu.tieba.rub.a
    public final void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, message) == null) {
            if (message.what != 1002) {
                super.handleMessage(message);
            } else {
                I();
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.x = 0L;
            this.B = 0;
            this.A = 0L;
            this.y = 0L;
            this.z = 0L;
        }
    }

    @Override // com.baidu.tieba.jwb, com.baidu.tieba.dwb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TLog.g(this, "AudioTrackFilter.release enter");
            this.l.g(1002);
            this.l.f(1002);
            super.p();
            TLog.g(this, "AudioTrackFilter.release leave");
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TLog.g(this, "AudioTrackFilter.stopAudioTrack enter.");
            synchronized (this) {
                if (this.t != null && this.t.getState() != 0) {
                    this.t.flush();
                    this.t.stop();
                    this.t.release();
                    this.t = null;
                }
            }
            D();
            this.p = null;
            TLog.g(this, "AudioTrackFilter.stopAudioTrack leave.");
        }
    }

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.bwb
    public void d(String str, Object obj, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TLog.g(this, "AudioTrackFilter.config  enter");
            this.u.set(false);
            MediaFormat mediaFormat = (MediaFormat) obj;
            int integer = mediaFormat.getInteger("sample-rate");
            int integer2 = mediaFormat.getInteger("channel-count");
            synchronized (this) {
                this.r = MediaFormat.createAudioFormat("audio/mp4a-latm", integer, integer2);
                TLog.g(this, " create AudioTrack  new channel count  " + this.r.getInteger("channel-count"));
            }
            TLog.g(this, "AudioTrackFilter.config leave");
        }
    }

    @Override // com.baidu.tieba.dwb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TLog.g(this, "AudioTrackFilter.stop enter");
            this.u.set(true);
            this.v.set(false);
            TLog.g(this, "AudioTrackFilter.stop leave");
            TLog.g(this, "AudioTrackFilter.stop logNum " + this.F + " playTag " + this.G);
            this.F = 0L;
        }
    }

    @Override // com.baidu.tieba.jwb
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.u.get()) {
                TLog.g(this, "ws AudioTrack is stoped");
                return;
            }
            while (this.f.getElementCount() > 0) {
                try {
                    this.G.getAndIncrement();
                    z();
                    this.G.getAndIncrement();
                    MediaSample poll = this.f.poll();
                    if (poll != null) {
                        MediaInfo mediaInfo = poll.i;
                        int remaining = mediaInfo.k.remaining();
                        this.C += (remaining / 2) * this.D;
                        this.G.getAndIncrement();
                        mediaInfo.k.mark();
                        nvb.c(poll, 9);
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.t.write(mediaInfo.k, remaining, 0);
                        } else {
                            if (remaining > this.p.length) {
                                remaining = this.p.length;
                            }
                            mediaInfo.k.get(this.p, 0, remaining);
                            this.t.write(this.p, 0, remaining);
                        }
                        nvb.c(poll, 10);
                        this.G.getAndIncrement();
                        long j = this.C % 10240;
                        E(poll);
                        int i = poll.g.d;
                        if (i != this.q) {
                            this.q = i;
                            poll.e = true;
                            TLog.g(this, "first frame show --- audio");
                        }
                        w(poll);
                        this.G.getAndIncrement();
                        mediaInfo.k.reset();
                        this.m.add(mediaInfo.k);
                        mediaInfo.k = null;
                        uub.f().e(poll);
                    } else {
                        this.G.set(111L);
                        this.l.g(2102);
                        this.G.set(222L);
                    }
                    this.G.set(0L);
                } catch (Exception e) {
                    e.printStackTrace();
                    TLog.g(this, "onInputAvailable error = " + e.getMessage());
                    return;
                }
            }
        }
    }
}
