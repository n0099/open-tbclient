package com.baidu.tieba.video.meida;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.video.meida.c;
import com.baidu.tieba.video.meida.g;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class b extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed A[Catch: all -> 0x025a, TryCatch #0 {all -> 0x025a, blocks: (B:21:0x00c2, B:23:0x00c8, B:25:0x00d3, B:26:0x00e3, B:28:0x00ed, B:30:0x00f5, B:33:0x010f, B:35:0x0115, B:37:0x013a, B:39:0x0140, B:40:0x0150, B:42:0x0156, B:45:0x0167, B:49:0x0172, B:51:0x017d, B:52:0x0193, B:53:0x01ba, B:55:0x01c6, B:62:0x01db, B:65:0x01eb, B:31:0x0101, B:67:0x0209, B:69:0x0211, B:70:0x021b), top: B:78:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d8 A[SYNTHETIC] */
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.b a(String str, boolean z, g.a aVar, g.a aVar2) throws Exception {
        MediaFormat mediaFormat;
        boolean z2;
        int dequeueOutputBuffer;
        int i;
        ByteBuffer[] byteBufferArr;
        boolean z3;
        if (TextUtils.isEmpty(str) || aVar == null || aVar2 == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = this.nRF;
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str2);
        int i2 = 0;
        while (true) {
            if (i2 >= mediaExtractor.getTrackCount()) {
                mediaFormat = null;
                break;
            }
            mediaFormat = mediaExtractor.getTrackFormat(i2);
            if (!mediaFormat.getString(IMediaFormat.KEY_MIME).startsWith("audio/")) {
                i2++;
            } else {
                mediaExtractor.selectTrack(i2);
                break;
            }
        }
        if (mediaFormat == null) {
            BdLog.e("not a valid file with audio track..");
            mediaExtractor.release();
            return null;
        }
        BdLog.e("mediaFormat " + mediaFormat);
        c.b bVar = new c.b();
        bVar.channel = aVar2.channelCount;
        bVar.sampleRate = aVar2.sampleRate;
        bVar.nRI = aVar2.nRI;
        bVar.nRH = str;
        FileOutputStream fileOutputStream = new FileOutputStream(bVar.nRH);
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString(IMediaFormat.KEY_MIME));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
        ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
        double d = mediaFormat.getLong("durationUs");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (!z4) {
            if (!z5) {
                try {
                    int dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(5000L);
                    if (dequeueInputBuffer >= 0) {
                        int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                        if (readSampleData < 0) {
                            BdLog.i("saw input EOS.");
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            z2 = true;
                            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 5000L);
                            if (dequeueOutputBuffer < 0) {
                                if ((bufferInfo.flags & 2) != 0) {
                                    BdLog.i("audio encoder: codec config buffer");
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    z5 = z2;
                                } else {
                                    if (bufferInfo.size != 0) {
                                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                        byteBuffer.position(bufferInfo.offset);
                                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                        byte[] bArr = new byte[bufferInfo.size];
                                        byteBuffer.get(bArr);
                                        i = i3 + bArr.length;
                                        byte[] bArr2 = null;
                                        byte[] bArr3 = null;
                                        if (!z) {
                                            if (aVar2.dTL()) {
                                                bArr2 = g.b(aVar2.nRI / 8, aVar.nRI / 8, bArr);
                                            }
                                            if (aVar2.dTK()) {
                                                bArr3 = g.b(aVar2.channelCount, aVar.channelCount, aVar.nRI / 8, bArr2 == null ? bArr : bArr2);
                                            }
                                        }
                                        if (bArr3 != null) {
                                            bArr2 = bArr3;
                                        } else if (bArr2 == null) {
                                            bArr2 = bArr;
                                        }
                                        fileOutputStream.write(bArr2);
                                        if (this.nRG != null) {
                                            this.nRG.b(bArr, bufferInfo.presentationTimeUs / d);
                                        }
                                        BdLog.i(this.nRF + " presentationTimeUs : " + bufferInfo.presentationTimeUs);
                                    } else {
                                        i = i3;
                                    }
                                    createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    if ((bufferInfo.flags & 4) != 0) {
                                        BdLog.i("saw output EOS.");
                                        z3 = true;
                                    } else {
                                        z3 = z4;
                                    }
                                    z4 = z3;
                                    byteBufferArr = outputBuffers;
                                }
                            } else if (dequeueOutputBuffer == -3) {
                                ByteBuffer[] outputBuffers2 = createDecoderByType.getOutputBuffers();
                                BdLog.i("output buffers have changed.");
                                i = i3;
                                byteBufferArr = outputBuffers2;
                            } else {
                                if (dequeueOutputBuffer == -2) {
                                    BdLog.e("output format has changed to " + createDecoderByType.getOutputFormat());
                                }
                                i = i3;
                                byteBufferArr = outputBuffers;
                            }
                            i3 = i;
                            z5 = z2;
                            outputBuffers = byteBufferArr;
                        } else {
                            createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            mediaExtractor.advance();
                        }
                    }
                } finally {
                    fileOutputStream.close();
                    createDecoderByType.stop();
                    createDecoderByType.release();
                    mediaExtractor.release();
                }
            }
            z2 = z5;
            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 5000L);
            if (dequeueOutputBuffer < 0) {
            }
            i3 = i;
            z5 = z2;
            outputBuffers = byteBufferArr;
        }
        bVar.size = i3;
        if (this.nRG != null) {
            this.nRG.b(null, 1.0d);
        }
        BdLog.i("decode " + str + " cost " + (System.currentTimeMillis() - currentTimeMillis) + " milliseconds !");
        return bVar;
    }
}
