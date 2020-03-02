package com.baidu.tieba.video.meida;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.player.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a extends d {
    private long kAd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        super(str);
        this.kAd = 88200L;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0230 A[Catch: Exception -> 0x0234, TRY_LEAVE, TryCatch #4 {Exception -> 0x0234, blocks: (B:67:0x022b, B:69:0x0230), top: B:91:0x022b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.video.meida.d
    @TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Kl(String str) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        int i;
        byte[] bArr;
        boolean z;
        long j;
        int i2;
        boolean z2;
        long j2;
        int dequeueInputBuffer;
        int i3;
        boolean z3;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (this.sampleRate == 0) {
                this.sampleRate = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
            }
            if (this.channelCount == 0) {
                this.channelCount = 1;
            }
            this.kAd = (this.sampleRate * 16) / 8;
            fileInputStream = new FileInputStream(this.kAi);
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                e = e;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileInputStream = null;
        }
        try {
            MediaCodec cQN = cQN();
            cQN.start();
            ByteBuffer[] inputBuffers = cQN.getInputBuffers();
            ByteBuffer[] outputBuffers = cQN.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            long j3 = 0;
            long j4 = 0;
            boolean z4 = false;
            boolean z5 = false;
            ByteBuffer[] byteBufferArr = outputBuffers;
            int i4 = 0;
            int i5 = 0;
            byte[] bArr2 = new byte[4096];
            boolean z6 = false;
            while (!z4) {
                if (z5 || (dequeueInputBuffer = cQN.dequeueInputBuffer(10000L)) < 0) {
                    i = i4;
                    bArr = bArr2;
                    z = z6;
                    j = j4;
                    i2 = i5;
                    z2 = z5;
                } else {
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    int remaining = byteBuffer.remaining();
                    byte[] bArr3 = remaining != bArr2.length ? new byte[remaining] : bArr2;
                    if (z6) {
                        i3 = i5;
                        z3 = z6;
                    } else {
                        i3 = fileInputStream.read(bArr3);
                        z3 = i3 == -1 ? true : z6;
                    }
                    if (z3) {
                        cQN.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        i2 = i3;
                        bArr = bArr3;
                        z = z3;
                        j = j4;
                        int i6 = i4;
                        z2 = true;
                        i = i6;
                    } else {
                        byteBuffer.put(bArr3, 0, i3);
                        int i7 = i4 + i3;
                        cQN.queueInputBuffer(dequeueInputBuffer, 0, i3, j4, 0);
                        i = i7;
                        i2 = i3;
                        bArr = bArr3;
                        z = z3;
                        j = (long) ((1000000.0d * (i7 / 2.0d)) / this.kAd);
                        z2 = z5;
                    }
                }
                int dequeueOutputBuffer = cQN.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer >= 0) {
                    if ((bufferInfo.flags & 2) != 0) {
                        BdLog.i("audio encoder: codec config buffer");
                        cQN.releaseOutputBuffer(dequeueOutputBuffer, false);
                        i5 = i2;
                        bArr2 = bArr;
                        j4 = j;
                        z5 = z2;
                        i4 = i;
                        z6 = z;
                    } else {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer2 = byteBufferArr[dequeueOutputBuffer];
                            byteBuffer2.position(bufferInfo.offset);
                            byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                            BdLog.i(String.format(" writing audio sample : size=%s , presentationTimeUs=%s", Integer.valueOf(bufferInfo.size), Long.valueOf(bufferInfo.presentationTimeUs)));
                            if (j3 < bufferInfo.presentationTimeUs) {
                                j2 = bufferInfo.presentationTimeUs;
                                int i8 = bufferInfo.size;
                                byteBuffer2.position(bufferInfo.offset);
                                byteBuffer2.limit(bufferInfo.offset + i8);
                                byte[] bArr4 = new byte[i8 + 7];
                                i(bArr4, i8 + 7);
                                byteBuffer2.get(bArr4, 7, i8);
                                fileOutputStream.write(bArr4, 0, bArr4.length);
                                BdLog.i(bArr4.length + " bytes written.");
                                cQN.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if ((bufferInfo.flags & 4) == 0) {
                                    j4 = j;
                                    z4 = true;
                                    z5 = z2;
                                    j3 = j2;
                                    i4 = i;
                                    bArr2 = bArr;
                                    i5 = i2;
                                    z6 = z;
                                } else {
                                    j3 = j2;
                                    j4 = j;
                                    z5 = z2;
                                    bArr2 = bArr;
                                    i4 = i;
                                    i5 = i2;
                                    z6 = z;
                                }
                            } else {
                                BdLog.i("error sample! its presentationTimeUs should not lower than before.");
                            }
                        }
                        j2 = j3;
                        cQN.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) == 0) {
                        }
                    }
                } else if (dequeueOutputBuffer == -3) {
                    bArr2 = bArr;
                    j4 = j;
                    z5 = z2;
                    byteBufferArr = cQN.getOutputBuffers();
                    i5 = i2;
                    i4 = i;
                    z6 = z;
                } else if (dequeueOutputBuffer == -2) {
                    BdLog.i("format change : " + cQN.getOutputFormat());
                    i5 = i2;
                    bArr2 = bArr;
                    j4 = j;
                    z5 = z2;
                    i4 = i;
                    z6 = z;
                } else {
                    i5 = i2;
                    bArr2 = bArr;
                    j4 = j;
                    z5 = z2;
                    i4 = i;
                    z6 = z;
                }
            }
            BdLog.i("acc encode done");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            fileInputStream2 = fileInputStream;
            try {
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    @TargetApi(16)
    private MediaCodec cQN() throws IOException {
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, "audio/mp4a-latm");
        mediaFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        mediaFormat.setInteger("channel-count", this.channelCount);
        mediaFormat.setInteger("sample-rate", this.sampleRate);
        mediaFormat.setInteger("aac-profile", 2);
        createEncoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        return createEncoderByType;
    }

    private void i(byte[] bArr, int i) {
        int[] iArr = {96000, 88200, 64000, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K, StreamConfig.Audio.AUDIO_FREQUENCY, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K, 24000, 22050, 16000, 12000, RequestResponseCode.REQUEST_LOGIN_PB_AT, 8000, 7350};
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                i2 = 4;
                break;
            } else if (iArr[i2] == this.sampleRate) {
                break;
            } else {
                i2++;
            }
        }
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) ((i2 << 2) + 64 + 0);
        bArr[3] = (byte) ((i >> 11) + 128);
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }
}
