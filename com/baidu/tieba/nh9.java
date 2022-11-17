package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class nh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public String b;
    public int c;
    public int d;

    public nh9(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 88200L;
        this.b = str;
    }

    public final void a(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bArr, i) == null) {
            int[] iArr = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            int i2 = 0;
            while (true) {
                if (i2 < 13) {
                    if (iArr[i2] == this.c) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = 4;
                    break;
                }
            }
            bArr[0] = -1;
            bArr[1] = -7;
            bArr[2] = (byte) (64 + (i2 << 2) + 0);
            bArr[3] = (byte) (128 + (i >> 11));
            bArr[4] = (byte) ((i & 2047) >> 3);
            bArr[5] = (byte) (((i & 7) << 5) + 31);
            bArr[6] = -4;
        }
    }

    @TargetApi(16)
    public final MediaCodec b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
            mediaFormat.setInteger("channel-count", this.d);
            mediaFormat.setInteger("sample-rate", this.c);
            mediaFormat.setInteger("aac-profile", 2);
            createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        return (MediaCodec) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0223 A[Catch: Exception -> 0x021f, TRY_LEAVE, TryCatch #1 {Exception -> 0x021f, blocks: (B:97:0x021b, B:101:0x0223), top: B:109:0x021b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bf A[SYNTHETIC] */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ByteBuffer[] byteBufferArr;
        long j;
        long j2;
        long j3;
        long j4;
        int dequeueInputBuffer;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            MediaCodec mediaCodec = null;
            try {
                try {
                    if (this.c == 0) {
                        this.c = 48000;
                    }
                    if (this.d == 0) {
                        this.d = 1;
                    }
                    this.a = (this.c * 16) / 8;
                    fileInputStream = new FileInputStream(this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                fileOutputStream = null;
            }
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    try {
                        mediaCodec = b();
                        mediaCodec.start();
                        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
                        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
                        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                        byte[] bArr = new byte[4096];
                        ByteBuffer[] byteBufferArr2 = outputBuffers;
                        long j5 = 0;
                        long j6 = 0;
                        boolean z2 = false;
                        int i2 = 0;
                        boolean z3 = false;
                        boolean z4 = false;
                        int i3 = 0;
                        while (!z3) {
                            ByteBuffer[] byteBufferArr3 = byteBufferArr2;
                            if (!z4 && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) >= 0) {
                                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                byteBuffer.clear();
                                int remaining = byteBuffer.remaining();
                                if (remaining != bArr.length) {
                                    bArr = new byte[remaining];
                                }
                                byte[] bArr2 = bArr;
                                if (!z2 && (i2 = fileInputStream.read(bArr2)) == -1) {
                                    i = i2;
                                    z = true;
                                } else {
                                    z = z2;
                                    i = i2;
                                }
                                if (z) {
                                    j = j5;
                                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    byteBufferArr = inputBuffers;
                                    bArr = bArr2;
                                    z2 = z;
                                    i2 = i;
                                    j2 = 10000;
                                    z4 = true;
                                } else {
                                    j = j5;
                                    byteBuffer.put(bArr2, 0, i);
                                    int i4 = i3 + i;
                                    byteBufferArr = inputBuffers;
                                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, j6, 0);
                                    i3 = i4;
                                    j6 = (long) (((i4 / 2.0d) * 1000000.0d) / this.a);
                                    z2 = z;
                                    i2 = i;
                                    j2 = 10000;
                                    bArr = bArr2;
                                }
                            } else {
                                byteBufferArr = inputBuffers;
                                j = j5;
                                j2 = 10000;
                            }
                            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, j2);
                            if (dequeueOutputBuffer >= 0) {
                                if ((bufferInfo.flags & 2) != 0) {
                                    dj9.b("audio encoder: codec config buffer");
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    j3 = j;
                                    j5 = j3;
                                    byteBufferArr2 = byteBufferArr3;
                                } else {
                                    if (bufferInfo.size != 0) {
                                        ByteBuffer byteBuffer2 = byteBufferArr3[dequeueOutputBuffer];
                                        byteBuffer2.position(bufferInfo.offset);
                                        byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                                        dj9.b(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                                        j4 = j;
                                        if (j4 < bufferInfo.presentationTimeUs) {
                                            long j7 = bufferInfo.presentationTimeUs;
                                            int i5 = bufferInfo.size;
                                            int i6 = i5 + 7;
                                            byteBuffer2.position(bufferInfo.offset);
                                            byteBuffer2.limit(bufferInfo.offset + i5);
                                            byte[] bArr3 = new byte[i6];
                                            a(bArr3, i6);
                                            byteBuffer2.get(bArr3, 7, i5);
                                            fileOutputStream.write(bArr3, 0, i6);
                                            dj9.b(i6 + " bytes written.");
                                            j5 = j7;
                                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            byteBufferArr2 = byteBufferArr3;
                                            if ((bufferInfo.flags & 4) == 0) {
                                                inputBuffers = byteBufferArr;
                                                z3 = true;
                                            }
                                        } else {
                                            dj9.b("error sample! its presentationTimeUs should not lower than before. lastPTS = " + j4 + ", bufferPTS = " + bufferInfo.presentationTimeUs);
                                        }
                                    } else {
                                        j4 = j;
                                    }
                                    j5 = j4;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    byteBufferArr2 = byteBufferArr3;
                                    if ((bufferInfo.flags & 4) == 0) {
                                    }
                                }
                            } else {
                                j3 = j;
                                if (dequeueOutputBuffer == -3) {
                                    j5 = j3;
                                    byteBufferArr2 = mediaCodec.getOutputBuffers();
                                    inputBuffers = byteBufferArr;
                                } else {
                                    if (dequeueOutputBuffer == -2) {
                                        dj9.b("format change : " + mediaCodec.getOutputFormat());
                                    }
                                    j5 = j3;
                                    byteBufferArr2 = byteBufferArr3;
                                }
                            }
                            inputBuffers = byteBufferArr;
                        }
                        dj9.b("acc encode done");
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.release();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        fileInputStream.close();
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.release();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.release();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                if (mediaCodec != null) {
                }
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.c = i;
        }
    }
}
