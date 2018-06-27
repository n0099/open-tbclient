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
import com.baidu.tieba.video.editvideo.b.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(18)
/* loaded from: classes2.dex */
class d extends Thread {
    private e hcA;
    private long hcF;
    private b.a hcw;
    private String hcx;
    private Context mContext;

    public d(Context context, String str, e eVar, b.a aVar) {
        super("FilterAudioThread");
        this.hcF = -1L;
        this.mContext = context;
        this.hcx = str;
        this.hcA = eVar;
        this.hcw = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            bCj();
            if (bCl()) {
                com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.b.d.1
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

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0170: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:98:0x016d */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x016f: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:98:0x016d */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x016e: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:98:0x016d */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bCj() throws Exception {
        MediaExtractor mediaExtractor;
        MediaExtractor mediaExtractor2;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaCodec mediaCodec3;
        MediaCodec mediaCodec4;
        Throwable th;
        Exception exc;
        MediaCodec mediaCodec5;
        MediaCodec mediaCodec6;
        MediaExtractor mediaExtractor3;
        MediaFormat trackFormat;
        MediaCodecInfo uM = uM("audio/mp4a-latm");
        try {
            if (uM != null) {
                try {
                    mediaExtractor3 = bCk();
                    try {
                        trackFormat = mediaExtractor3.getTrackFormat(b(mediaExtractor3));
                        MediaFormat mediaFormat = new MediaFormat();
                        mediaFormat.setString(IMediaFormat.KEY_MIME, "audio/mp4a-latm");
                        mediaFormat.setInteger("aac-profile", 5);
                        mediaFormat.setInteger("max-input-size", 8192);
                        a(trackFormat, mediaFormat, "sample-rate", 48000);
                        a(trackFormat, mediaFormat, "channel-count", 1);
                        a(trackFormat, mediaFormat, IjkMediaMeta.IJKM_KEY_BITRATE, 128000);
                        mediaCodec5 = a(uM, mediaFormat);
                    } catch (Exception e) {
                        e = e;
                        mediaCodec5 = null;
                        mediaCodec6 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec4 = null;
                        mediaExtractor2 = mediaExtractor3;
                        mediaCodec2 = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    mediaCodec5 = null;
                    mediaCodec6 = null;
                    mediaExtractor3 = null;
                } catch (Throwable th3) {
                    th = th3;
                    mediaCodec4 = null;
                    mediaCodec2 = null;
                    mediaExtractor2 = null;
                }
                try {
                    mediaCodec6 = b(trackFormat);
                    try {
                        a(mediaExtractor3, mediaCodec6, mediaCodec5);
                        if (mediaExtractor3 != null) {
                            try {
                                mediaExtractor3.release();
                            } catch (Exception e3) {
                                r0 = 0 == 0 ? e3 : null;
                                if (this.hcw != null) {
                                    this.hcw.an(231, com.baidu.tieba.j.a.m(e3));
                                }
                            }
                        }
                        if (mediaCodec6 != null) {
                            try {
                                mediaCodec6.stop();
                                mediaCodec6.release();
                            } catch (Exception e4) {
                                if (r0 == null) {
                                    r0 = e4;
                                }
                                if (this.hcw != null) {
                                    this.hcw.an(232, com.baidu.tieba.j.a.m(e4));
                                }
                            }
                        }
                        if (mediaCodec5 != null) {
                            try {
                                mediaCodec5.stop();
                                mediaCodec5.release();
                            } catch (Exception e5) {
                                if (r0 == null) {
                                    r0 = e5;
                                }
                                if (this.hcw != null) {
                                    this.hcw.an(233, com.baidu.tieba.j.a.m(e5));
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                        if (this.hcw != null) {
                            this.hcw.an(230, com.baidu.tieba.j.a.m(e));
                        }
                        if (mediaExtractor3 != null) {
                            try {
                                mediaExtractor3.release();
                            } catch (Exception e7) {
                                r0 = 0 == 0 ? e7 : null;
                                if (this.hcw != null) {
                                    this.hcw.an(231, com.baidu.tieba.j.a.m(e7));
                                }
                            }
                        }
                        if (mediaCodec6 != null) {
                            try {
                                mediaCodec6.stop();
                                mediaCodec6.release();
                            } catch (Exception e8) {
                                if (r0 == null) {
                                    r0 = e8;
                                }
                                if (this.hcw != null) {
                                    this.hcw.an(232, com.baidu.tieba.j.a.m(e8));
                                }
                            }
                        }
                        if (mediaCodec5 != null) {
                            try {
                                mediaCodec5.stop();
                                mediaCodec5.release();
                            } catch (Exception e9) {
                                if (r0 == null) {
                                    r0 = e9;
                                }
                                if (this.hcw != null) {
                                    this.hcw.an(233, com.baidu.tieba.j.a.m(e9));
                                }
                            }
                        }
                        if (r0 == null) {
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    mediaCodec6 = null;
                } catch (Throwable th4) {
                    mediaCodec4 = mediaCodec5;
                    th = th4;
                    mediaExtractor2 = mediaExtractor3;
                    mediaCodec2 = null;
                    if (mediaExtractor2 != null) {
                        try {
                            mediaExtractor2.release();
                        } catch (Exception e11) {
                            r0 = 0 == 0 ? e11 : null;
                            if (this.hcw != null) {
                                this.hcw.an(231, com.baidu.tieba.j.a.m(e11));
                            }
                        }
                    }
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                            mediaCodec2.release();
                        } catch (Exception e12) {
                            if (r0 == null) {
                                r0 = e12;
                            }
                            if (this.hcw != null) {
                                this.hcw.an(232, com.baidu.tieba.j.a.m(e12));
                            }
                            exc = r0;
                            if (mediaCodec4 != null) {
                                try {
                                    mediaCodec4.stop();
                                    mediaCodec4.release();
                                } catch (Exception e13) {
                                    if (exc == null) {
                                    }
                                    if (this.hcw != null) {
                                        this.hcw.an(233, com.baidu.tieba.j.a.m(e13));
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    exc = r0;
                    if (mediaCodec4 != null) {
                    }
                    throw th;
                }
                if (r0 == null) {
                    throw r0;
                }
            }
        } catch (Throwable th5) {
            mediaExtractor2 = mediaExtractor;
            mediaCodec2 = mediaCodec;
            mediaCodec4 = mediaCodec3;
            th = th5;
        }
    }

    private MediaExtractor bCk() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.hcx);
        return mediaExtractor;
    }

    private MediaCodec b(MediaFormat mediaFormat) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(d(mediaFormat));
        createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        createByCodecName.start();
        return createByCodecName;
    }

    private int b(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (c(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    private void a(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2) {
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
        while (!z4 && bCl()) {
            if (z7 || !((mediaFormat2 == null || this.hcA.isStarted()) && bCl())) {
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
            if (!z6 && i3 == -1 && ((mediaFormat2 == null || this.hcA.isStarted()) && bCl() && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L)) != -1)) {
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
            if (i3 == -1 || !bCl()) {
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
            if (z4 || !((mediaFormat2 == null || this.hcA.isStarted()) && bCl())) {
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
                        if (bufferInfo2.size != 0 && bufferInfo2.presentationTimeUs > this.hcF) {
                            this.hcA.writeSampleData(i4, byteBuffer3, bufferInfo2);
                            this.hcF = bufferInfo2.presentationTimeUs;
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
                aB("InnerAudioProcessor", "muxer: adding audio track.");
                i2 = this.hcA.addTrack(mediaFormat);
                z3 = true;
            }
            if (!this.hcA.isStarted() && z3) {
                this.hcA.bCn();
                if (!this.hcA.start()) {
                    synchronized (this.hcA) {
                        while (!this.hcA.isStarted()) {
                            try {
                                this.hcA.wait(100L);
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

    private boolean bCl() {
        return !Thread.currentThread().isInterrupted();
    }

    private static boolean c(MediaFormat mediaFormat) {
        return d(mediaFormat).startsWith("audio/");
    }

    private static String d(MediaFormat mediaFormat) {
        return mediaFormat.getString(IMediaFormat.KEY_MIME);
    }

    private static void a(MediaFormat mediaFormat, MediaFormat mediaFormat2, String str, int i) {
        if (mediaFormat != null && mediaFormat.containsKey(str) && mediaFormat.getInteger(str) > 0) {
            i = mediaFormat.getInteger(str);
        }
        if (mediaFormat2 != null) {
            mediaFormat2.setInteger(str, i);
        }
    }

    private static MediaCodecInfo uM(String str) {
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

    private static void aB(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BdLog.i(str2);
        }
    }
}
