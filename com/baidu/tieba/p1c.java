package com.baidu.tieba;

import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.common.AudioSendStamp;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.FrameInfo;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediacodec.NativeFfmpeg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public abstract class p1c extends k1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeFfmpeg A;
    public ByteBuffer B;
    public ByteBuffer C;
    public TreeMap<Integer, Object> D;
    public int E;
    public FrameInfo F;
    public r0c G;

    public p1c() {
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
        this.A = new NativeFfmpeg();
        this.B = null;
        this.C = null;
        this.D = new TreeMap<>();
        this.E = 0;
        this.F = new FrameInfo();
        this.G = new r0c(200);
    }

    @Override // com.baidu.tieba.k1c
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (!this.r.b() && K() == 1) {
                TLog.g(this, "handleEndOfStream");
                try {
                    Thread.sleep(20L);
                } catch (Exception unused) {
                    TLog.g(this, "handleEndOfStream error");
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TLog.g(this, "NativeFfmpegFilter.stopCodec enter.");
            this.A.k();
            this.B = null;
            this.C = null;
            this.E = 0;
            this.F.a = 0L;
            this.v = 0L;
            G();
            TLog.g(this, "NativeFfmpegFilter.stopCodec leave.");
        }
    }

    @Override // com.baidu.tieba.k1c
    public int D(MediaSample mediaSample) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSample)) == null) {
            K();
            int J = J(mediaSample);
            K();
            return J;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.k1c, com.baidu.tieba.t1c, com.baidu.tieba.b0c.a
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
            if (message.what != 1002) {
                super.handleMessage(message);
            } else {
                L();
            }
        }
    }

    public final int J(MediaSample mediaSample) {
        InterceptResult invokeL;
        AVframe aVframe;
        MediaInfo mediaInfo;
        ByteBuffer byteBuffer;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaSample)) == null) {
            if (mediaSample == null || (aVframe = mediaSample.g) == null || (mediaInfo = mediaSample.i) == null || (byteBuffer = this.B) == null || mediaInfo.k == null || mediaInfo.a == 0) {
                return -1;
            }
            int i = aVframe.e;
            int i2 = this.a;
            if (i > i2) {
                long j = this.v + 1;
                this.v = j;
                if (j < 10 || j % 1000 == 0) {
                    TLog.c(this, String.format("ffmepg::sample.avFrame.playTaskID: %d > mPlayTaskID %d", Integer.valueOf(mediaSample.g.e), Integer.valueOf(this.a)));
                }
                return 0;
            } else if (i < i2) {
                long j2 = this.v + 1;
                this.v = j2;
                if (j2 < 10 || j2 % 1000 == 0) {
                    TLog.c(this, String.format("ffmpeg::sample.avFrame.playTaskID: %d < mPlayTaskID %d", Integer.valueOf(mediaSample.g.e), Integer.valueOf(this.a)));
                }
                return -1;
            } else {
                byteBuffer.clear();
                boolean z = mediaSample.g.c;
                int capacity = mediaSample.i.k.capacity();
                if (mediaSample.d && (bArr2 = mediaSample.g.q) != null) {
                    capacity += bArr2.length + 7;
                }
                ByteBuffer byteBuffer2 = this.B;
                if (byteBuffer2 == null || byteBuffer2.capacity() < capacity) {
                    int i3 = (int) (capacity * 1.5d);
                    if (i3 > 2000000 || i3 < capacity) {
                        i3 = capacity;
                    }
                    this.B = ByteBuffer.allocateDirect(i3);
                }
                if (this.B.capacity() >= capacity) {
                    if (mediaSample.d && (bArr = mediaSample.g.q) != null) {
                        g1c.d(bArr, this.B);
                    }
                    this.B.put(mediaSample.i.k).flip();
                    if (this.A.o(this.B, mediaSample.d, mediaSample.l, mediaSample.k) < 0) {
                        TLog.c(this, "mCodec.send_packet() failed.");
                        m(51);
                        return -1;
                    }
                }
                this.G.b(mediaSample.t);
                this.r.a(mediaSample);
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public final int K() {
        InterceptResult invokeV;
        MediaInfo mediaInfo;
        AVframe aVframe;
        AVframe aVframe2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ByteBuffer byteBuffer = this.C;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.D.clear();
                FrameInfo frameInfo = this.F;
                frameInfo.a = 0L;
                frameInfo.b = 0L;
                if (this.A.n(this.C, this.D, frameInfo) > 0) {
                    MediaSample c = this.r.c();
                    if (c != null && c.g != null && (mediaInfo = c.i) != null) {
                        mediaInfo.c(this.q);
                        c.i.k = this.C;
                        FrameInfo frameInfo2 = this.F;
                        c.l = frameInfo2.a;
                        E(c, frameInfo2.b);
                        this.u++;
                        c.I = NativeFfmpeg.l(this.D);
                        ArrayList<Long> m = NativeFfmpeg.m(this.D);
                        if (m != null && !m.isEmpty()) {
                            c.J = new ArrayList<>();
                            Iterator<Long> it = m.iterator();
                            while (it.hasNext()) {
                                c.J.add(new AudioSendStamp(this.G.a(), it.next().longValue()));
                            }
                        }
                        n(c);
                        if (!c.c) {
                            t0c t0cVar = this.s.get();
                            if (t0cVar != null && (aVframe2 = c.g) != null) {
                                t0cVar.t((int) aVframe2.l);
                            }
                        } else {
                            t0c t0cVar2 = this.s.get();
                            if (t0cVar2 != null && (aVframe = c.g) != null) {
                                t0cVar2.s((int) aVframe.l);
                            }
                        }
                        this.D.clear();
                        x0c.c(c, 6);
                        synchronized (this.k) {
                            if (this.d != null) {
                                this.d.f(c);
                            }
                        }
                        return 1;
                    }
                    return -1;
                }
                return 0;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
