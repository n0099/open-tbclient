package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
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
public class my8 extends py8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my8(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 88200L;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00db A[Catch: all -> 0x01a7, Exception -> 0x01aa, TryCatch #8 {Exception -> 0x01aa, all -> 0x01a7, blocks: (B:13:0x002e, B:17:0x005b, B:19:0x0061, B:21:0x006d, B:24:0x0072, B:29:0x0082, B:33:0x00d5, B:35:0x00db, B:37:0x00e1, B:38:0x00ed, B:40:0x00f1, B:42:0x0123, B:43:0x0158, B:44:0x015d, B:49:0x0174, B:52:0x017c, B:30:0x00a0, B:54:0x019b), top: B:101:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dc A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #5 {Exception -> 0x01d8, blocks: (B:84:0x01d4, B:88:0x01dc), top: B:97:0x01d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.py8
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        Throwable th;
        FileOutputStream fileOutputStream;
        ByteBuffer[] byteBufferArr;
        long j;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            my8 my8Var = this;
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (my8Var.b == 0) {
                        my8Var.b = 48000;
                    }
                    if (my8Var.c == 0) {
                        my8Var.c = 1;
                    }
                    my8Var.d = (my8Var.b * 16) / 8;
                    FileInputStream fileInputStream2 = new FileInputStream(my8Var.a);
                    try {
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            MediaCodec f = f();
                            f.start();
                            ByteBuffer[] inputBuffers = f.getInputBuffers();
                            ByteBuffer[] outputBuffers = f.getOutputBuffers();
                            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                            byte[] bArr = new byte[4096];
                            ByteBuffer[] byteBufferArr2 = outputBuffers;
                            long j2 = 0;
                            long j3 = 0;
                            boolean z2 = false;
                            int i2 = 0;
                            boolean z3 = false;
                            boolean z4 = false;
                            int i3 = 0;
                            while (!z3) {
                                if (!z4 && (dequeueInputBuffer = f.dequeueInputBuffer(10000L)) >= 0) {
                                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                                    byteBuffer.clear();
                                    int remaining = byteBuffer.remaining();
                                    if (remaining != bArr.length) {
                                        bArr = new byte[remaining];
                                    }
                                    byte[] bArr2 = bArr;
                                    if (!z2 && (i2 = fileInputStream2.read(bArr2)) == -1) {
                                        i = i2;
                                        z = true;
                                    } else {
                                        z = z2;
                                        i = i2;
                                    }
                                    if (z) {
                                        f.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                        byteBufferArr = inputBuffers;
                                        i2 = i;
                                        bArr = bArr2;
                                        z2 = z;
                                        j = 10000;
                                        z4 = true;
                                        dequeueOutputBuffer = f.dequeueOutputBuffer(bufferInfo, j);
                                        if (dequeueOutputBuffer < 0) {
                                            if ((bufferInfo.flags & 2) != 0) {
                                                BdLog.i("audio encoder: codec config buffer");
                                                f.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            } else {
                                                if (bufferInfo.size != 0) {
                                                    ByteBuffer byteBuffer2 = byteBufferArr2[dequeueOutputBuffer];
                                                    byteBuffer2.position(bufferInfo.offset);
                                                    byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                                                    BdLog.i(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                                                    if (j2 < bufferInfo.presentationTimeUs) {
                                                        long j4 = bufferInfo.presentationTimeUs;
                                                        int i4 = bufferInfo.size;
                                                        int i5 = i4 + 7;
                                                        byteBuffer2.position(bufferInfo.offset);
                                                        byteBuffer2.limit(bufferInfo.offset + i4);
                                                        byte[] bArr3 = new byte[i5];
                                                        my8Var.e(bArr3, i5);
                                                        byteBuffer2.get(bArr3, 7, i4);
                                                        fileOutputStream.write(bArr3, 0, i5);
                                                        BdLog.i(i5 + " bytes written.");
                                                        j2 = j4;
                                                    } else {
                                                        BdLog.i("error sample! its presentationTimeUs should not lower than before.");
                                                    }
                                                }
                                                f.releaseOutputBuffer(dequeueOutputBuffer, false);
                                                if ((bufferInfo.flags & 4) != 0) {
                                                    my8Var = this;
                                                    inputBuffers = byteBufferArr;
                                                    z3 = true;
                                                }
                                            }
                                        } else if (dequeueOutputBuffer == -3) {
                                            byteBufferArr2 = f.getOutputBuffers();
                                        } else if (dequeueOutputBuffer == -2) {
                                            BdLog.i("format change : " + f.getOutputFormat());
                                        }
                                        my8Var = this;
                                        inputBuffers = byteBufferArr;
                                    } else {
                                        int i6 = i;
                                        byteBuffer.put(bArr2, 0, i6);
                                        int i7 = i3 + i6;
                                        byteBufferArr = inputBuffers;
                                        f.queueInputBuffer(dequeueInputBuffer, 0, i6, j3, 0);
                                        i3 = i7;
                                        i2 = i6;
                                        j3 = (long) (((i7 / 2.0d) * 1000000.0d) / my8Var.d);
                                        bArr = bArr2;
                                        z2 = z;
                                    }
                                } else {
                                    byteBufferArr = inputBuffers;
                                }
                                j = 10000;
                                dequeueOutputBuffer = f.dequeueOutputBuffer(bufferInfo, j);
                                if (dequeueOutputBuffer < 0) {
                                }
                                my8Var = this;
                                inputBuffers = byteBufferArr;
                            }
                            BdLog.i("acc encode done");
                            fileInputStream2.close();
                            fileOutputStream.close();
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
        }
    }

    public final void e(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i) == null) {
            int[] iArr = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
            int i2 = 0;
            while (true) {
                if (i2 < 13) {
                    if (iArr[i2] == this.b) {
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
    public final MediaCodec f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
            mediaFormat.setInteger("channel-count", this.c);
            mediaFormat.setInteger("sample-rate", this.b);
            mediaFormat.setInteger("aac-profile", 2);
            createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        return (MediaCodec) invokeV.objValue;
    }
}
