package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.player.StreamConfig;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(18)
/* loaded from: classes10.dex */
class d extends Thread {
    private b.a kwK;
    private String kwL;
    private e kwO;
    private long kwT;
    private Context mContext;

    public d(Context context, String str, e eVar, b.a aVar) {
        super("FilterAudioThread");
        this.kwT = -1L;
        this.mContext = context;
        this.kwL = str;
        this.kwO = eVar;
        this.kwK = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            cPS();
            if (cPU()) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.b.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.onPostExecute();
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    public void onPostExecute() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=4, 132=4, 133=4, 134=4, 136=4, 137=4, 140=4, 141=4, 107=4, 108=4, 110=4, 111=4, 114=4, 115=4, 119=4, 120=4, 121=4, 123=4, 124=4, 127=4] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x01d0: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:137:0x01cf */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cPS() throws Exception {
        Throwable th;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec3;
        MediaCodec mediaCodec4;
        MediaExtractor mediaExtractor2;
        MediaExtractor mediaExtractor3;
        Exception exc;
        Exception exc2;
        Exception exc3;
        Exception exc4;
        int b;
        Exception exc5;
        Exception exc6;
        MediaCodecInfo selectCodec = selectCodec("audio/mp4a-latm");
        if (selectCodec == null) {
            return;
        }
        MediaCodec mediaCodec5 = null;
        MediaCodec mediaCodec6 = null;
        try {
            try {
                mediaExtractor2 = cPT();
                try {
                    b = b(mediaExtractor2);
                } catch (Exception e) {
                    e = e;
                    mediaCodec3 = null;
                    mediaCodec4 = null;
                } catch (Throwable th2) {
                    th = th2;
                    mediaCodec2 = null;
                    mediaExtractor = mediaExtractor2;
                    mediaCodec = null;
                }
            } catch (Throwable th3) {
                mediaExtractor = mediaExtractor3;
                mediaCodec = null;
                th = th3;
            }
        } catch (Exception e2) {
            e = e2;
            mediaCodec3 = null;
            mediaCodec4 = null;
            mediaExtractor2 = null;
        } catch (Throwable th4) {
            th = th4;
            mediaCodec = null;
            mediaCodec2 = null;
            mediaExtractor = null;
        }
        if (b < 0 && this.kwK != null) {
            this.kwK.cPJ();
            if (mediaExtractor2 != null) {
                try {
                    mediaExtractor2.release();
                } catch (Exception e3) {
                    exc5 = 0 == 0 ? e3 : null;
                    if (this.kwK != null) {
                        this.kwK.onGenFilterVideoRecordError(231, com.baidu.tieba.k.a.q(e3));
                    }
                }
            }
            exc5 = null;
            if (0 != 0) {
                try {
                    mediaCodec5.stop();
                    mediaCodec5.release();
                } catch (Exception e4) {
                    if (exc5 == null) {
                        exc5 = e4;
                    }
                    if (this.kwK != null) {
                        this.kwK.onGenFilterVideoRecordError(232, com.baidu.tieba.k.a.q(e4));
                    }
                    exc6 = exc5;
                }
            }
            exc6 = exc5;
            if (0 != 0) {
                try {
                    mediaCodec6.stop();
                    mediaCodec6.release();
                    return;
                } catch (Exception e5) {
                    if (exc6 == null) {
                    }
                    if (this.kwK != null) {
                        this.kwK.onGenFilterVideoRecordError(233, com.baidu.tieba.k.a.q(e5));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        MediaFormat trackFormat = mediaExtractor2.getTrackFormat(b);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, "audio/mp4a-latm");
        mediaFormat.setInteger("aac-profile", 5);
        mediaFormat.setInteger("max-input-size", 8192);
        setMediaFormatProperty(trackFormat, mediaFormat, "sample-rate", StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
        setMediaFormatProperty(trackFormat, mediaFormat, "channel-count", 1);
        setMediaFormatProperty(trackFormat, mediaFormat, IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
        mediaCodec3 = c(selectCodec, mediaFormat);
        try {
            mediaCodec4 = g(trackFormat);
            try {
                b(mediaExtractor2, mediaCodec4, mediaCodec3);
                if (mediaExtractor2 != null) {
                    try {
                        mediaExtractor2.release();
                    } catch (Exception e6) {
                        exc = 0 == 0 ? e6 : null;
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(231, com.baidu.tieba.k.a.q(e6));
                        }
                        exc4 = exc;
                    }
                }
                exc4 = null;
                if (mediaCodec4 != null) {
                    try {
                        mediaCodec4.stop();
                        mediaCodec4.release();
                    } catch (Exception e7) {
                        if (exc4 == null) {
                            exc4 = e7;
                        }
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(232, com.baidu.tieba.k.a.q(e7));
                        }
                    }
                }
                if (mediaCodec3 != null) {
                    try {
                        mediaCodec3.stop();
                        mediaCodec3.release();
                    } catch (Exception e8) {
                        if (exc4 == null) {
                            exc4 = e8;
                        }
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(233, com.baidu.tieba.k.a.q(e8));
                        }
                    }
                }
            } catch (Exception e9) {
                e = e9;
                e.printStackTrace();
                if (this.kwK != null) {
                    this.kwK.onGenFilterVideoRecordError(230, com.baidu.tieba.k.a.q(e));
                }
                if (mediaExtractor2 != null) {
                    try {
                        mediaExtractor2.release();
                    } catch (Exception e10) {
                        exc = 0 == 0 ? e10 : null;
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(231, com.baidu.tieba.k.a.q(e10));
                        }
                        exc4 = exc;
                        if (mediaCodec4 != null) {
                        }
                        if (mediaCodec3 != null) {
                        }
                        if (exc4 != null) {
                        }
                    }
                }
                exc4 = null;
                if (mediaCodec4 != null) {
                    try {
                        mediaCodec4.stop();
                        mediaCodec4.release();
                    } catch (Exception e11) {
                        if (exc4 == null) {
                            exc4 = e11;
                        }
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(232, com.baidu.tieba.k.a.q(e11));
                        }
                    }
                }
                if (mediaCodec3 != null) {
                    try {
                        mediaCodec3.stop();
                        mediaCodec3.release();
                    } catch (Exception e12) {
                        if (exc4 == null) {
                            exc4 = e12;
                        }
                        if (this.kwK != null) {
                            this.kwK.onGenFilterVideoRecordError(233, com.baidu.tieba.k.a.q(e12));
                        }
                    }
                }
                if (exc4 != null) {
                }
            }
        } catch (Exception e13) {
            e = e13;
            mediaCodec4 = null;
        } catch (Throwable th5) {
            mediaCodec2 = null;
            th = th5;
            mediaExtractor = mediaExtractor2;
            mediaCodec = mediaCodec3;
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e14) {
                    exc = 0 == 0 ? e14 : null;
                    if (this.kwK != null) {
                        this.kwK.onGenFilterVideoRecordError(231, com.baidu.tieba.k.a.q(e14));
                    }
                    exc2 = exc;
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                            mediaCodec2.release();
                        } catch (Exception e15) {
                            if (exc2 == null) {
                                exc2 = e15;
                            }
                            if (this.kwK != null) {
                                this.kwK.onGenFilterVideoRecordError(232, com.baidu.tieba.k.a.q(e15));
                            }
                            exc3 = exc2;
                            if (mediaCodec != null) {
                            }
                            throw th;
                        }
                    }
                    exc3 = exc2;
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                            mediaCodec.release();
                        } catch (Exception e16) {
                            if (exc3 == null) {
                            }
                            if (this.kwK != null) {
                                this.kwK.onGenFilterVideoRecordError(233, com.baidu.tieba.k.a.q(e16));
                            }
                        }
                    }
                    throw th;
                }
            }
            exc2 = null;
            if (mediaCodec2 != null) {
            }
            exc3 = exc2;
            if (mediaCodec != null) {
            }
            throw th;
        }
        if (exc4 != null) {
            throw exc4;
        }
    }

    private MediaExtractor cPT() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.kwL);
        return mediaExtractor;
    }

    private MediaCodec g(MediaFormat mediaFormat) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec c(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        createByCodecName.start();
        return createByCodecName;
    }

    private int b(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (h(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    private void b(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2) {
        boolean z;
        int i;
        boolean z2;
        MediaFormat mediaFormat;
        ByteBuffer[] byteBufferArr;
        boolean z3;
        int i2;
        int dequeueOutputBuffer;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        boolean z4 = false;
        boolean z5 = false;
        int i3 = -1;
        boolean z6 = false;
        int i4 = -1;
        MediaFormat mediaFormat2 = null;
        ByteBuffer[] byteBufferArr2 = outputBuffers2;
        boolean z7 = false;
        while (!z4 && cPU()) {
            if (z7 || !((mediaFormat2 == null || this.kwO.isStarted()) && cPU())) {
                z = z7;
            } else {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer == -1) {
                    z = z7;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (readSampleData >= 0) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                    }
                    z = !mediaExtractor.advance();
                    if (z) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    }
                }
            }
            if (!z6 && i3 == -1 && ((mediaFormat2 == null || this.kwO.isStarted()) && cPU() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L)) != -1)) {
                if (dequeueOutputBuffer == -3) {
                    outputBuffers = mediaCodec.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    mediaCodec.getOutputFormat();
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if ((bufferInfo.flags & 2) != 0) {
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        i3 = dequeueOutputBuffer;
                    }
                }
            }
            if (i3 == -1 || !cPU()) {
                i = i3;
                z2 = z6;
            } else {
                int dequeueInputBuffer2 = mediaCodec2.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer2 == -1) {
                    i = i3;
                    z2 = z6;
                } else {
                    ByteBuffer byteBuffer2 = inputBuffers2[dequeueInputBuffer2];
                    int i5 = bufferInfo.size;
                    long j = bufferInfo.presentationTimeUs;
                    if (i5 >= 0) {
                        ByteBuffer duplicate = outputBuffers[i3].duplicate();
                        duplicate.position(bufferInfo.offset);
                        duplicate.limit(bufferInfo.offset + i5);
                        byteBuffer2.position(0);
                        byteBuffer2.put(duplicate);
                        mediaCodec2.queueInputBuffer(dequeueInputBuffer2, 0, i5, j, bufferInfo.flags);
                    }
                    mediaCodec.releaseOutputBuffer(i3, false);
                    if ((bufferInfo.flags & 4) != 0) {
                        i = -1;
                        z2 = true;
                    } else {
                        i = -1;
                        z2 = z6;
                    }
                }
            }
            if (z4 || !((mediaFormat2 == null || this.kwO.isStarted()) && cPU())) {
                mediaFormat = mediaFormat2;
                byteBufferArr = byteBufferArr2;
            } else {
                int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
                if (dequeueOutputBuffer2 == -1) {
                    mediaFormat = mediaFormat2;
                    byteBufferArr = byteBufferArr2;
                } else if (dequeueOutputBuffer2 == -3) {
                    mediaFormat = mediaFormat2;
                    byteBufferArr = mediaCodec2.getOutputBuffers();
                } else if (dequeueOutputBuffer2 == -2) {
                    if (i4 < 0) {
                        mediaFormat = mediaCodec2.getOutputFormat();
                        byteBufferArr = byteBufferArr2;
                    } else {
                        return;
                    }
                } else {
                    ByteBuffer byteBuffer3 = byteBufferArr2[dequeueOutputBuffer2];
                    if ((bufferInfo2.flags & 2) != 0) {
                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                        mediaFormat = mediaFormat2;
                        byteBufferArr = byteBufferArr2;
                    } else {
                        if (bufferInfo2.size != 0 && bufferInfo2.presentationTimeUs > this.kwT) {
                            this.kwO.d(i4, byteBuffer3, bufferInfo2);
                            this.kwT = bufferInfo2.presentationTimeUs;
                        }
                        boolean z8 = (bufferInfo2.flags & 4) != 0 ? true : z4;
                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                        z4 = z8;
                        mediaFormat = mediaFormat2;
                        byteBufferArr = byteBufferArr2;
                    }
                }
            }
            if (mediaFormat == null || z5) {
                z3 = z5;
                i2 = i4;
            } else {
                z("InnerAudioProcessor", "muxer: adding audio track.");
                i2 = this.kwO.i(mediaFormat);
                z3 = true;
            }
            if (!this.kwO.isStarted() && z3) {
                this.kwO.cPW();
                if (!this.kwO.start()) {
                    synchronized (this.kwO) {
                        while (!this.kwO.isStarted()) {
                            try {
                                this.kwO.wait(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    z5 = z3;
                    i3 = i;
                    z6 = z2;
                    i4 = i2;
                    mediaFormat2 = mediaFormat;
                    byteBufferArr2 = byteBufferArr;
                    z7 = z;
                }
            }
            z5 = z3;
            i3 = i;
            z6 = z2;
            i4 = i2;
            mediaFormat2 = mediaFormat;
            byteBufferArr2 = byteBufferArr;
            z7 = z;
        }
    }

    private boolean cPU() {
        return !Thread.currentThread().isInterrupted();
    }

    private static boolean h(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("audio/");
    }

    private static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString(IMediaFormat.KEY_MIME);
    }

    private static void setMediaFormatProperty(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i) {
        if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
            i = mediaFormat.getInteger(str);
        }
        if (mediaFormat2 != null) {
            mediaFormat2.setInteger(str, i);
        }
    }

    private static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static void z(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BdLog.i(str2);
        }
    }
}
