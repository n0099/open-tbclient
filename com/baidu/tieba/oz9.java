package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.tieba.pz9;
import com.baidu.tieba.sz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class oz9 extends pz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz9(String str) {
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
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x015c A[Catch: all -> 0x0282, TryCatch #0 {all -> 0x0282, blocks: (B:27:0x00e3, B:29:0x00e9, B:31:0x00f2, B:47:0x0156, B:49:0x015c, B:51:0x0162, B:52:0x016f, B:55:0x0175, B:57:0x0178, B:59:0x0192, B:61:0x0198, B:63:0x01a6, B:65:0x01ac, B:69:0x01b9, B:76:0x01c9, B:78:0x01d0, B:79:0x01d9, B:81:0x01f7, B:83:0x0201, B:86:0x020f, B:89:0x021c, B:33:0x010d, B:35:0x0115, B:39:0x0126, B:44:0x0143, B:42:0x0131, B:93:0x0240, B:95:0x0246, B:96:0x024e), top: B:108:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0209  */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pz9.b a(String str, boolean z, sz9.f fVar, sz9.f fVar2, long j, long j2, long j3) throws Exception {
        InterceptResult invokeCommon;
        MediaFormat mediaFormat;
        ByteBuffer[] byteBufferArr;
        long j4;
        int dequeueOutputBuffer;
        ByteBuffer[] byteBufferArr2;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Boolean.valueOf(z), fVar, fVar2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            sz9.f fVar3 = fVar2;
            long j5 = j2;
            if (!TextUtils.isEmpty(str) && fVar != null && fVar3 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = this.a;
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(str2);
                int i = 0;
                while (true) {
                    if (i < mediaExtractor.getTrackCount()) {
                        mediaFormat = mediaExtractor.getTrackFormat(i);
                        if (mediaFormat.getString("mime").startsWith("audio/")) {
                            mediaExtractor.selectTrack(i);
                            break;
                        }
                        i++;
                    } else {
                        mediaFormat = null;
                        break;
                    }
                }
                d1a.c("AndroidAudioDecoder", "startTime:" + j + ",endTime:" + j5);
                if (j > 0) {
                    mediaExtractor.seekTo(j * 1000, 0);
                }
                if (mediaFormat == null) {
                    d1a.b("not a valid file with audio track..");
                    mediaExtractor.release();
                    return null;
                }
                d1a.b("mediaFormat " + mediaFormat);
                pz9.b bVar = new pz9.b();
                int i2 = fVar3.b;
                int i3 = fVar3.a;
                int i4 = fVar3.c;
                bVar.a = str;
                FileOutputStream fileOutputStream = new FileOutputStream(bVar.a);
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
                createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
                createDecoderByType.start();
                ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
                ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
                double d = mediaFormat.getLong("durationUs");
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                boolean z2 = false;
                boolean z3 = false;
                ByteBuffer[] byteBufferArr3 = outputBuffers;
                while (!z2) {
                    long j6 = currentTimeMillis;
                    if (!z3) {
                        try {
                            int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(5000L);
                            if (dequeueInputBuffer >= 0) {
                                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                if (readSampleData < 0) {
                                    d1a.b("saw input EOS.");
                                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    byteBufferArr = inputBuffers;
                                    j4 = 5000;
                                } else {
                                    long sampleTime = mediaExtractor.getSampleTime();
                                    if (j3 != 0) {
                                        byteBufferArr = inputBuffers;
                                        mediaExtractor.seekTo(sampleTime + j3, 0);
                                    } else {
                                        byteBufferArr = inputBuffers;
                                    }
                                    if (j5 != -1 && sampleTime + j3 >= j5 * 1000) {
                                        createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                        j4 = 5000;
                                    }
                                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                                    mediaExtractor.advance();
                                    j4 = 5000;
                                    dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j4);
                                    if (dequeueOutputBuffer >= 0) {
                                        if ((bufferInfo.flags & 2) != 0) {
                                            d1a.b("audio encoder: codec config buffer");
                                            createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            inputBuffers = byteBufferArr;
                                            currentTimeMillis = j6;
                                        } else {
                                            if (bufferInfo.size != 0 && dequeueOutputBuffer >= 0 && byteBufferArr3.length > dequeueOutputBuffer) {
                                                ByteBuffer byteBuffer = byteBufferArr3[dequeueOutputBuffer];
                                                byteBuffer.position(bufferInfo.offset);
                                                byteBufferArr2 = byteBufferArr3;
                                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                                byte[] bArr4 = new byte[bufferInfo.size];
                                                byteBuffer.get(bArr4);
                                                if (!z) {
                                                    if (fVar2.a()) {
                                                        bArr2 = sz9.c(fVar3.c / 8, fVar.c / 8, bArr4);
                                                    } else {
                                                        bArr2 = null;
                                                    }
                                                    if (fVar2.b()) {
                                                        int i5 = fVar3.b;
                                                        int i6 = fVar.b;
                                                        int i7 = fVar.c / 8;
                                                        if (bArr2 == null) {
                                                            bArr3 = bArr4;
                                                        } else {
                                                            bArr3 = bArr2;
                                                        }
                                                        bArr = sz9.d(i5, i6, i7, bArr3);
                                                    } else {
                                                        bArr = null;
                                                    }
                                                } else {
                                                    bArr = null;
                                                    bArr2 = null;
                                                }
                                                if (bArr == null) {
                                                    if (bArr2 == null) {
                                                        bArr = bArr4;
                                                    } else {
                                                        bArr = bArr2;
                                                    }
                                                }
                                                fileOutputStream.write(bArr);
                                                if (this.b != null) {
                                                    this.b.a(bArr4, bufferInfo.presentationTimeUs / d);
                                                }
                                                d1a.b(this.a + " presentationTimeUs : " + bufferInfo.presentationTimeUs);
                                            } else {
                                                byteBufferArr2 = byteBufferArr3;
                                            }
                                            createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            if ((bufferInfo.flags & 4) != 0) {
                                                d1a.b("saw output EOS.");
                                                z2 = true;
                                            }
                                        }
                                    } else {
                                        byteBufferArr2 = byteBufferArr3;
                                        if (dequeueOutputBuffer == -3) {
                                            byteBufferArr3 = createDecoderByType.getOutputBuffers();
                                            d1a.b("output buffers have changed.");
                                            fVar3 = fVar2;
                                            inputBuffers = byteBufferArr;
                                            j5 = j2;
                                            currentTimeMillis = j6;
                                        } else if (dequeueOutputBuffer == -2) {
                                            d1a.b("output format has changed to " + createDecoderByType.getOutputFormat());
                                        }
                                    }
                                    byteBufferArr3 = byteBufferArr2;
                                    fVar3 = fVar2;
                                    inputBuffers = byteBufferArr;
                                    j5 = j2;
                                    currentTimeMillis = j6;
                                }
                                z3 = true;
                                dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j4);
                                if (dequeueOutputBuffer >= 0) {
                                }
                                byteBufferArr3 = byteBufferArr2;
                                fVar3 = fVar2;
                                inputBuffers = byteBufferArr;
                                j5 = j2;
                                currentTimeMillis = j6;
                            }
                        } finally {
                            fileOutputStream.close();
                            createDecoderByType.stop();
                            createDecoderByType.release();
                            mediaExtractor.release();
                        }
                    }
                    byteBufferArr = inputBuffers;
                    j4 = 5000;
                    dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, j4);
                    if (dequeueOutputBuffer >= 0) {
                    }
                    byteBufferArr3 = byteBufferArr2;
                    fVar3 = fVar2;
                    inputBuffers = byteBufferArr;
                    j5 = j2;
                    currentTimeMillis = j6;
                }
                long j7 = currentTimeMillis;
                if (this.b != null) {
                    this.b.a(null, 1.0d);
                }
                d1a.b("decode " + str + " cost " + (System.currentTimeMillis() - j7) + " milliseconds !");
                return bVar;
            }
            return null;
        }
        return (pz9.b) invokeCommon.objValue;
    }
}
