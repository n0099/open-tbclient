package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediafilter.MediaCodecFilter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes7.dex */
public final class n2c extends MediaCodecFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n2c(int i) {
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
        this.b = i;
    }

    @Override // com.yy.transvod.player.mediafilter.MediaCodecFilter
    public int N(long j) {
        InterceptResult invokeJ;
        MediaInfo mediaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            int dequeueOutputBuffer = this.B.dequeueOutputBuffer(this.C, j);
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = this.E[dequeueOutputBuffer];
                int remaining = byteBuffer.remaining();
                MediaCodec.BufferInfo bufferInfo = this.C;
                if (remaining != bufferInfo.size) {
                    Buffer position = byteBuffer.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.C;
                    position.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                MediaSample c = this.r.c();
                if (c != null && (mediaInfo = c.i) != null) {
                    mediaInfo.c(this.q);
                    c.i.k = byteBuffer;
                    this.u++;
                    d2c.c(c, 6);
                    synchronized (this.k) {
                        if (this.d != null) {
                            this.d.f(c);
                        }
                    }
                    this.B.releaseOutputBuffer(dequeueOutputBuffer, false);
                } else {
                    return -1;
                }
            } else if (dequeueOutputBuffer == -3) {
                this.E = this.B.getOutputBuffers();
                TLog.g(this, "output buffers have been changed.");
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.B.getOutputFormat();
                TLog.g(this, "output format has been changed from " + this.p + " to " + outputFormat);
                this.p = outputFormat;
                MediaInfo mediaInfo2 = this.q;
                mediaInfo2.a = 1;
                mediaInfo2.j = outputFormat.getInteger("sample-rate");
                this.q.h = this.p.getInteger("channel-count");
                MediaInfo mediaInfo3 = this.q;
                mediaInfo3.f = (mediaInfo3.h << 1) * 2048;
                synchronized (this.k) {
                    if (this.d != null) {
                        this.d.d("setFormat", outputFormat, this.a, false);
                    }
                }
            }
            if (dequeueOutputBuffer < 0) {
                return 0;
            }
            return 1;
        }
        return invokeJ.intValue;
    }

    @Override // com.baidu.tieba.q2c
    public void z(MediaFormat mediaFormat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaFormat, i) == null) {
            this.w = false;
            this.r.e(true);
            this.p = mediaFormat;
            if (mediaFormat != null) {
                MediaCodec mediaCodec = this.B;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.B.release();
                    this.B = null;
                }
                this.a = i;
                this.B = J(null, mediaFormat);
            }
        }
    }
}
