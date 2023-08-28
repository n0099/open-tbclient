package com.baidu.tieba;

import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.FrameInfo;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediacodec.NativeIttiam;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public abstract class y2c extends s2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NativeIttiam A;
    public ByteBuffer B;
    public ByteBuffer C;
    public int D;
    public boolean E;
    public FrameInfo F;
    public WeakReference<b2c> G;

    public y2c() {
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
        this.A = new NativeIttiam();
        this.B = null;
        this.C = null;
        this.D = 0;
        this.E = false;
        this.F = new FrameInfo();
        this.G = new WeakReference<>(null);
    }

    @Override // com.baidu.tieba.s2c
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
            TLog.g(this, "NativeIttiamFilter.stopCodec enter.");
            this.A.l();
            this.B = null;
            this.C = null;
            this.F.a = 0L;
            this.D = 0;
            this.v = 0L;
            G();
            TLog.g(this, "NativeIttiamFilter.stopCodec leave.");
        }
    }

    @Override // com.baidu.tieba.s2c
    public int D(MediaSample mediaSample) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSample)) == null) {
            this.E = false;
            int J = J(mediaSample);
            if (J == 1 && this.E) {
                this.E = false;
                K();
            }
            return J;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.s2c, com.baidu.tieba.b3c, com.baidu.tieba.j1c.a
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
        boolean z;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaSample)) == null) {
            if (mediaSample == null || (aVframe = mediaSample.g) == null || (mediaInfo = mediaSample.i) == null || (byteBuffer = this.B) == null || this.C == null || mediaInfo.k == null) {
                return -1;
            }
            int i = aVframe.e;
            int i2 = this.a;
            if (i > i2) {
                long j = this.v + 1;
                this.v = j;
                if (j >= 10 && j % 1000 != 0) {
                    return 0;
                }
                TLog.c(this, String.format("Ittiam::sample.avFrame.playTaskID: %d > mPlayTaskID %d", Integer.valueOf(mediaSample.g.e), Integer.valueOf(this.a)));
                return 0;
            } else if (i < i2) {
                long j2 = this.v + 1;
                this.v = j2;
                if (j2 < 10 || j2 % 1000 == 0) {
                    TLog.c(this, String.format("Ittiam::sample.avFrame.playTaskID: %d < mPlayTaskID %d", Integer.valueOf(mediaSample.g.e), Integer.valueOf(this.a)));
                }
                return -1;
            } else {
                byteBuffer.clear();
                this.C.clear();
                FrameInfo frameInfo = this.F;
                frameInfo.a = 0L;
                frameInfo.b = 0L;
                boolean z2 = mediaSample.g.c;
                int capacity = mediaSample.i.k.capacity();
                if (mediaSample.d && (bArr2 = mediaSample.g.q) != null) {
                    capacity += bArr2.length + 4;
                }
                ByteBuffer byteBuffer2 = this.B;
                if (byteBuffer2 == null || byteBuffer2.capacity() < capacity) {
                    int i3 = (int) (capacity * 1.5d);
                    if (i3 > 2000000 || i3 < capacity) {
                        i3 = capacity;
                    }
                    this.B = ByteBuffer.allocateDirect(i3);
                }
                if (this.B.capacity() < capacity) {
                    return -1;
                }
                if (mediaSample.d && (bArr = mediaSample.g.q) != null) {
                    this.B.putInt(bArr.length);
                    this.B.put(mediaSample.g.q);
                }
                this.B.put(mediaSample.i.k).flip();
                int k = this.A.k(this.B, this.C, mediaSample.d, mediaSample.l, this.F);
                if (k != 0 && k != -2) {
                    TLog.c(this, "ittiam decode error.maybe");
                    return -1;
                }
                this.r.a(mediaSample);
                if (k == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.E = z;
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public final int K() {
        InterceptResult invokeV;
        MediaInfo mediaInfo;
        AVframe aVframe;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MediaSample c = this.r.c();
            if (c != null && c.g != null && (mediaInfo = c.i) != null) {
                mediaInfo.c(this.q);
                c.i.k = this.C;
                FrameInfo frameInfo = this.F;
                c.l = frameInfo.a;
                E(c, frameInfo.b);
                this.u++;
                f2c.c(c, 6);
                n(c);
                b2c b2cVar = this.G.get();
                if (b2cVar != null && (aVframe = c.g) != null) {
                    b2cVar.t((int) aVframe.l);
                }
                synchronized (this.k) {
                    if (this.d != null) {
                        this.d.f(c);
                    }
                }
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
