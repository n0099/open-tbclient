package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class s6b implements g6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public volatile long b;
    public MediaCodec.BufferInfo c;
    public MediaCodec d;
    public MediaExtractor e;
    public MediaFormat f;
    public ByteBuffer[] g;
    public ByteBuffer[] h;
    public byte[] i;
    public volatile boolean j;
    public long k;
    public volatile boolean l;
    public t6b m;

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0073 A[EDGE_INSN: B:46:0x0073->B:28:0x0073 ?: BREAK  , SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public s6b(String str) throws Exception {
        int i;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = -1L;
        this.e = new MediaExtractor();
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.e = mediaExtractor;
            mediaExtractor.setDataSource(str);
        } catch (IOException unused) {
            try {
                Thread.sleep(25L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                try {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    this.e = mediaExtractor2;
                    mediaExtractor2.setDataSource(str);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                    MediaExtractor mediaExtractor3 = new MediaExtractor();
                    this.e = mediaExtractor3;
                    mediaExtractor3.setDataSource(str);
                    i = 0;
                    while (true) {
                        if (i >= this.e.getTrackCount()) {
                        }
                        i++;
                    }
                    mediaFormat = this.f;
                    if (mediaFormat == null) {
                    }
                }
            } catch (IOException unused2) {
                Thread.sleep(25L);
                MediaExtractor mediaExtractor32 = new MediaExtractor();
                this.e = mediaExtractor32;
                mediaExtractor32.setDataSource(str);
                i = 0;
                while (true) {
                    if (i >= this.e.getTrackCount()) {
                    }
                    i++;
                }
                mediaFormat = this.f;
                if (mediaFormat == null) {
                }
            }
        }
        i = 0;
        while (true) {
            if (i >= this.e.getTrackCount()) {
                break;
            }
            MediaFormat trackFormat = this.e.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                this.e.selectTrack(i);
                this.f = trackFormat;
                break;
            }
            i++;
        }
        mediaFormat = this.f;
        if (mediaFormat == null) {
            throw new NullPointerException("format is null");
        }
        String string2 = mediaFormat.getString("mime");
        this.a = this.f.getLong("durationUs");
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string2);
        this.d = createDecoderByType;
        createDecoderByType.configure(this.f, (Surface) null, (MediaCrypto) null, 0);
        this.d.start();
        this.g = this.d.getInputBuffers();
        this.h = this.d.getOutputBuffers();
        this.c = new MediaCodec.BufferInfo();
    }

    @Override // com.baidu.tieba.g6b
    public int a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (this.f.containsKey("bit-width") ? this.f.getInteger("bit-width") : 16) / 8;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g6b
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f.containsKey("sample-rate")) {
                return this.f.getInteger("sample-rate");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g6b
    public boolean c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i();
            int dequeueOutputBuffer = this.d.dequeueOutputBuffer(this.c, 10000L);
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = this.d.getOutputFormat();
                        this.f = outputFormat;
                        t6b t6bVar = this.m;
                        if (t6bVar != null) {
                            t6bVar.a(outputFormat);
                        }
                    } else if (dequeueOutputBuffer == -3) {
                        this.h = this.d.getOutputBuffers();
                    } else {
                        str = "decodeChunk,res=" + dequeueOutputBuffer;
                    }
                    return false;
                }
                str = "decodeChunk:INFO_TRY_AGAIN_LATER";
                j9b.j("VideoMuxer", str);
                return false;
            }
            MediaCodec.BufferInfo bufferInfo = this.c;
            if ((bufferInfo.flags & 2) != 0) {
                this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
                return false;
            }
            int i = bufferInfo.size;
            if (i - bufferInfo.offset < 0) {
                ByteBuffer byteBuffer = this.h[dequeueOutputBuffer];
                byte[] bArr = this.i;
                if (bArr == null || bArr.length != i) {
                    this.i = new byte[this.c.size];
                }
                byteBuffer.get(this.i);
                byteBuffer.clear();
                this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
            } else {
                j(dequeueOutputBuffer);
            }
            if ((this.c.flags & 4) != 0) {
                long j = this.k;
                if (j <= 0) {
                    j = this.a;
                }
                this.b = j;
                this.j = true;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.g6b
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.d.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.d.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.d = null;
            try {
                this.e.release();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.e = null;
        }
    }

    @Override // com.baidu.tieba.g6b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = false;
            this.j = false;
            this.c.flags = 0;
        }
    }

    @Override // com.baidu.tieba.g6b
    public int e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f.containsKey("channel-count")) {
                return this.f.getInteger("channel-count");
            }
            throw new IOException("Not a valid audio file");
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.g6b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.g6b
    public byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g6b
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : invokeV.longValue;
    }

    @Override // com.baidu.tieba.g6b
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : invokeV.longValue;
    }

    @Override // com.baidu.tieba.g6b
    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.k = j;
        }
    }

    public final void i() {
        int dequeueInputBuffer;
        long sampleTime;
        int sampleFlags;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.l || (dequeueInputBuffer = this.d.dequeueInputBuffer(10000L)) < 0) {
            return;
        }
        int readSampleData = this.e.readSampleData(this.g[dequeueInputBuffer], 0);
        if (readSampleData < 0) {
            this.l = true;
            j9b.j("VideoMuxer", "extractor to end, audioEndTimeUs" + this.k);
            sampleTime = 0L;
            readSampleData = 0;
        } else {
            sampleTime = this.e.getSampleTime();
        }
        long j = this.k;
        if (j > 0 && sampleTime > j) {
            j9b.j("VideoMuxer", "extractor audioEndTimeUs:" + this.k + ",presentationTimeUs:" + sampleTime);
            this.l = true;
        }
        boolean z = this.l;
        MediaCodec mediaCodec = this.d;
        if (z) {
            i = 0;
            sampleTime = 0;
            sampleFlags = 4;
        } else {
            sampleFlags = this.e.getSampleFlags();
            i = readSampleData;
        }
        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, sampleTime, sampleFlags);
        if (this.l) {
            return;
        }
        this.e.advance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r1 != (r2.size - r2.offset)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            ByteBuffer byteBuffer = this.h[i];
            byte[] bArr = this.i;
            if (bArr != null) {
                int length = bArr.length;
                MediaCodec.BufferInfo bufferInfo = this.c;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.c;
            this.i = new byte[bufferInfo2.size - bufferInfo2.offset];
            MediaCodec.BufferInfo bufferInfo3 = this.c;
            if (bufferInfo3.size > 0) {
                this.b = bufferInfo3.presentationTimeUs;
            }
            byteBuffer.position(this.c.offset);
            byteBuffer.get(this.i);
            byteBuffer.clear();
            this.d.releaseOutputBuffer(i, false);
        }
    }

    public void k(t6b t6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t6bVar) == null) {
            this.m = t6bVar;
        }
    }

    @Override // com.baidu.tieba.g6b
    public void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            d();
            this.e.seekTo(j, 2);
            this.b = j;
            this.c = new MediaCodec.BufferInfo();
            this.d.flush();
        }
    }
}
