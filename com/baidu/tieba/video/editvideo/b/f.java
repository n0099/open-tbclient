package com.baidu.tieba.video.editvideo.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import tv.danmaku.ijk.media.player.IMediaFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
@TargetApi(18)
/* loaded from: classes5.dex */
class f extends Thread {
    private b.a hsQ;
    private String hsR;
    private e hsU;
    private Context mContext;
    private String mFilterName;

    public f(Context context, String str, String str2, e eVar, b.a aVar) {
        super("FilterVideoThread");
        this.mContext = context;
        this.hsR = str;
        this.mFilterName = str2;
        this.hsU = eVar;
        this.hsQ = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            bGZ();
            if (bHb()) {
                com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.b.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.onPostExecute();
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    public void onPostExecute() {
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x01c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bGZ() throws Exception {
        Throwable th;
        g gVar;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        h hVar;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec3;
        MediaExtractor mediaExtractor2;
        Exception exc;
        Exception exc2;
        Exception exc3;
        int i;
        MediaCodecInfo selectCodec = selectCodec("video/avc");
        if (selectCodec != null) {
            try {
                mediaExtractor2 = bHa();
                try {
                    MediaFormat trackFormat = mediaExtractor2.getTrackFormat(c(mediaExtractor2));
                    int integer = trackFormat.getInteger("width");
                    int integer2 = trackFormat.getInteger("height");
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.hsR);
                    if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                        i = integer2;
                        integer2 = integer;
                    } else {
                        i = integer;
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, integer2);
                    createVideoFormat.setInteger("color-format", 2130708361);
                    a(trackFormat, createVideoFormat, IjkMediaMeta.IJKM_KEY_BITRATE, 2097152);
                    a(trackFormat, createVideoFormat, "frame-rate", 20);
                    a(trackFormat, createVideoFormat, "i-frame-interval", 1);
                    AtomicReference<Surface> atomicReference = new AtomicReference<>();
                    mediaCodec = a(selectCodec, createVideoFormat, atomicReference);
                    try {
                        gVar = new g(atomicReference.get());
                        try {
                            gVar.makeCurrent();
                            hVar = new h(this.mContext, this.mFilterName, i, integer2);
                            try {
                                mediaCodec3 = a(trackFormat, hVar.getSurface());
                                try {
                                    try {
                                        a(mediaExtractor2, mediaCodec3, mediaCodec, gVar, hVar);
                                        if (mediaExtractor2 != null) {
                                            try {
                                                mediaExtractor2.release();
                                            } catch (Exception e) {
                                                exc3 = 0 == 0 ? e : null;
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(225, com.baidu.tieba.j.a.o(e));
                                                }
                                            }
                                        }
                                        exc3 = null;
                                        if (mediaCodec3 != null) {
                                            try {
                                                mediaCodec3.stop();
                                                mediaCodec3.release();
                                            } catch (Exception e2) {
                                                if (exc3 == null) {
                                                    exc3 = e2;
                                                }
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(226, com.baidu.tieba.j.a.o(e2));
                                                }
                                            }
                                        }
                                        if (hVar != null) {
                                            try {
                                                hVar.release();
                                            } catch (Exception e3) {
                                                if (exc3 == null) {
                                                    exc3 = e3;
                                                }
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(227, com.baidu.tieba.j.a.o(e3));
                                                }
                                            }
                                        }
                                        if (mediaCodec != null) {
                                            try {
                                                mediaCodec.stop();
                                                mediaCodec.release();
                                            } catch (Exception e4) {
                                                if (exc3 == null) {
                                                    exc3 = e4;
                                                }
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(228, com.baidu.tieba.j.a.o(e4));
                                                }
                                            }
                                        }
                                        if (gVar != null) {
                                            try {
                                                gVar.release();
                                            } catch (Exception e5) {
                                                if (exc3 == null) {
                                                    exc3 = e5;
                                                }
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(229, com.baidu.tieba.j.a.o(e5));
                                                }
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        e.printStackTrace();
                                        if (this.hsQ != null) {
                                            this.hsQ.ar(224, com.baidu.tieba.j.a.o(e));
                                        }
                                        if (mediaExtractor2 != null) {
                                            try {
                                                mediaExtractor2.release();
                                            } catch (Exception e7) {
                                                exc = 0 == 0 ? e7 : null;
                                                if (this.hsQ != null) {
                                                    this.hsQ.ar(225, com.baidu.tieba.j.a.o(e7));
                                                }
                                                exc3 = exc;
                                                if (mediaCodec3 != null) {
                                                    try {
                                                        mediaCodec3.stop();
                                                        mediaCodec3.release();
                                                    } catch (Exception e8) {
                                                        if (exc3 == null) {
                                                            exc3 = e8;
                                                        }
                                                        if (this.hsQ != null) {
                                                            this.hsQ.ar(226, com.baidu.tieba.j.a.o(e8));
                                                        }
                                                    }
                                                }
                                                if (hVar != null) {
                                                    try {
                                                        hVar.release();
                                                    } catch (Exception e9) {
                                                        if (exc3 == null) {
                                                            exc3 = e9;
                                                        }
                                                        if (this.hsQ != null) {
                                                            this.hsQ.ar(227, com.baidu.tieba.j.a.o(e9));
                                                        }
                                                    }
                                                }
                                                if (mediaCodec != null) {
                                                    try {
                                                        mediaCodec.stop();
                                                        mediaCodec.release();
                                                    } catch (Exception e10) {
                                                        if (exc3 == null) {
                                                            exc3 = e10;
                                                        }
                                                        if (this.hsQ != null) {
                                                            this.hsQ.ar(228, com.baidu.tieba.j.a.o(e10));
                                                        }
                                                    }
                                                }
                                                if (gVar != null) {
                                                    try {
                                                        gVar.release();
                                                    } catch (Exception e11) {
                                                        if (exc3 == null) {
                                                            exc3 = e11;
                                                        }
                                                        if (this.hsQ != null) {
                                                            this.hsQ.ar(229, com.baidu.tieba.j.a.o(e11));
                                                        }
                                                    }
                                                }
                                                if (exc3 != null) {
                                                }
                                            }
                                        }
                                        exc3 = null;
                                        if (mediaCodec3 != null) {
                                        }
                                        if (hVar != null) {
                                        }
                                        if (mediaCodec != null) {
                                        }
                                        if (gVar != null) {
                                        }
                                        if (exc3 != null) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    mediaExtractor = mediaExtractor2;
                                    mediaCodec2 = mediaCodec3;
                                    th = th2;
                                    if (mediaExtractor != null) {
                                        try {
                                            mediaExtractor.release();
                                        } catch (Exception e12) {
                                            exc = 0 == 0 ? e12 : null;
                                            if (this.hsQ != null) {
                                                this.hsQ.ar(225, com.baidu.tieba.j.a.o(e12));
                                            }
                                            exc2 = exc;
                                            if (mediaCodec2 != null) {
                                                try {
                                                    mediaCodec2.stop();
                                                    mediaCodec2.release();
                                                } catch (Exception e13) {
                                                    if (exc2 == null) {
                                                        exc2 = e13;
                                                    }
                                                    if (this.hsQ != null) {
                                                        this.hsQ.ar(226, com.baidu.tieba.j.a.o(e13));
                                                    }
                                                }
                                            }
                                            if (hVar != null) {
                                                try {
                                                    hVar.release();
                                                } catch (Exception e14) {
                                                    if (exc2 == null) {
                                                        exc2 = e14;
                                                    }
                                                    if (this.hsQ != null) {
                                                        this.hsQ.ar(227, com.baidu.tieba.j.a.o(e14));
                                                    }
                                                }
                                            }
                                            if (mediaCodec != null) {
                                                try {
                                                    mediaCodec.stop();
                                                    mediaCodec.release();
                                                } catch (Exception e15) {
                                                    if (exc2 == null) {
                                                        exc2 = e15;
                                                    }
                                                    if (this.hsQ != null) {
                                                        this.hsQ.ar(228, com.baidu.tieba.j.a.o(e15));
                                                    }
                                                }
                                            }
                                            if (gVar != null) {
                                                try {
                                                    gVar.release();
                                                } catch (Exception e16) {
                                                    if (exc2 == null) {
                                                    }
                                                    if (this.hsQ != null) {
                                                        this.hsQ.ar(229, com.baidu.tieba.j.a.o(e16));
                                                    }
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    exc2 = null;
                                    if (mediaCodec2 != null) {
                                    }
                                    if (hVar != null) {
                                    }
                                    if (mediaCodec != null) {
                                    }
                                    if (gVar != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                mediaCodec3 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                mediaExtractor = mediaExtractor2;
                                mediaCodec2 = null;
                                if (mediaExtractor != null) {
                                }
                                exc2 = null;
                                if (mediaCodec2 != null) {
                                }
                                if (hVar != null) {
                                }
                                if (mediaCodec != null) {
                                }
                                if (gVar != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            mediaCodec3 = null;
                            hVar = null;
                        } catch (Throwable th4) {
                            th = th4;
                            hVar = null;
                            mediaExtractor = mediaExtractor2;
                            mediaCodec2 = null;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        gVar = null;
                        mediaCodec3 = null;
                        hVar = null;
                    } catch (Throwable th5) {
                        th = th5;
                        gVar = null;
                        hVar = null;
                        mediaExtractor = mediaExtractor2;
                        mediaCodec2 = null;
                    }
                } catch (Exception e20) {
                    e = e20;
                    gVar = null;
                    mediaCodec = null;
                    mediaCodec3 = null;
                    hVar = null;
                } catch (Throwable th6) {
                    th = th6;
                    gVar = null;
                    mediaCodec = null;
                    hVar = null;
                    mediaExtractor = mediaExtractor2;
                    mediaCodec2 = null;
                }
            } catch (Exception e21) {
                e = e21;
                gVar = null;
                mediaCodec = null;
                mediaCodec3 = null;
                hVar = null;
                mediaExtractor2 = null;
            } catch (Throwable th7) {
                th = th7;
                gVar = null;
                mediaCodec = null;
                mediaCodec2 = null;
                hVar = null;
                mediaExtractor = null;
            }
            if (exc3 != null) {
                throw exc3;
            }
        }
    }

    private MediaExtractor bHa() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.hsR);
        return mediaExtractor;
    }

    private MediaCodec a(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(d(mediaFormat));
        createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        atomicReference.set(createByCodecName.createInputSurface());
        createByCodecName.start();
        return createByCodecName;
    }

    private int c(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (e(mediaExtractor.getTrackFormat(i))) {
                mediaExtractor.selectTrack(i);
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, g gVar, h hVar) {
        boolean z;
        boolean z2;
        ByteBuffer[] byteBufferArr;
        MediaFormat mediaFormat;
        ByteBuffer[] byteBufferArr2;
        boolean z3;
        int i;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i2 = -1;
        MediaFormat mediaFormat2 = null;
        ByteBuffer[] byteBufferArr3 = outputBuffers2;
        boolean z7 = false;
        while (!z4 && bHb()) {
            if (z7 || !((mediaFormat2 == null || this.hsU.isStarted()) && bHb())) {
                z = z7;
            } else {
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(ErrDef.Feature.WEIGHT);
                if (dequeueInputBuffer == -1) {
                    z = z7;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (readSampleData >= 0) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, mediaExtractor.getSampleFlags());
                    }
                    boolean z8 = !mediaExtractor.advance();
                    if (z8) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        z = z8;
                    } else {
                        z = z8;
                    }
                }
            }
            if (!z6 && ((mediaFormat2 == null || this.hsU.isStarted()) && bHb())) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, ErrDef.Feature.WEIGHT);
                if (dequeueOutputBuffer == -1) {
                    z2 = z6;
                    byteBufferArr = outputBuffers;
                } else if (dequeueOutputBuffer == -3) {
                    z2 = z6;
                    byteBufferArr = mediaCodec.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    mediaCodec.getOutputFormat();
                    z2 = z6;
                    byteBufferArr = outputBuffers;
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if ((bufferInfo.flags & 2) != 0) {
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        z2 = z6;
                        byteBufferArr = outputBuffers;
                    } else {
                        boolean z9 = bufferInfo.size != 0;
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z9);
                        if (z9) {
                            hVar.bHg();
                            hVar.bHf();
                            gVar.setPresentationTime(bufferInfo.presentationTimeUs * 1000);
                            gVar.swapBuffers();
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            mediaCodec2.signalEndOfInputStream();
                            z2 = true;
                            byteBufferArr = outputBuffers;
                        }
                    }
                }
                if (z4 && ((mediaFormat2 == null || this.hsU.isStarted()) && bHb())) {
                    int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, ErrDef.Feature.WEIGHT);
                    if (dequeueOutputBuffer2 == -1) {
                        mediaFormat = mediaFormat2;
                        byteBufferArr2 = byteBufferArr3;
                    } else if (dequeueOutputBuffer2 == -3) {
                        mediaFormat = mediaFormat2;
                        byteBufferArr2 = mediaCodec2.getOutputBuffers();
                    } else if (dequeueOutputBuffer2 == -2) {
                        if (i2 < 0) {
                            mediaFormat = mediaCodec2.getOutputFormat();
                            byteBufferArr2 = byteBufferArr3;
                        } else {
                            return;
                        }
                    } else {
                        ByteBuffer byteBuffer2 = byteBufferArr3[dequeueOutputBuffer2];
                        if ((bufferInfo2.flags & 2) != 0) {
                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                            mediaFormat = mediaFormat2;
                            byteBufferArr2 = byteBufferArr3;
                        } else {
                            if (bufferInfo2.size != 0) {
                                this.hsU.writeSampleData(i2, byteBuffer2, bufferInfo2);
                            }
                            boolean z10 = (bufferInfo2.flags & 4) != 0 ? true : z4;
                            mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer2, false);
                            z4 = z10;
                            mediaFormat = mediaFormat2;
                            byteBufferArr2 = byteBufferArr3;
                        }
                    }
                } else {
                    mediaFormat = mediaFormat2;
                    byteBufferArr2 = byteBufferArr3;
                }
                if (mediaFormat != null || z5) {
                    z3 = z5;
                    i = i2;
                } else {
                    log("InnerVideoProcessor", "muxer: adding video track.");
                    i = this.hsU.addTrack(mediaFormat);
                    z3 = true;
                }
                if (!this.hsU.isStarted() && z3) {
                    this.hsU.bHc();
                    if (this.hsU.start()) {
                        synchronized (this.hsU) {
                            while (!this.hsU.isStarted()) {
                                try {
                                    this.hsU.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        z5 = z3;
                        i2 = i;
                        mediaFormat2 = mediaFormat;
                        byteBufferArr3 = byteBufferArr2;
                        outputBuffers = byteBufferArr;
                        z6 = z2;
                        z7 = z;
                    }
                }
                z5 = z3;
                i2 = i;
                mediaFormat2 = mediaFormat;
                byteBufferArr3 = byteBufferArr2;
                outputBuffers = byteBufferArr;
                z6 = z2;
                z7 = z;
            }
            z2 = z6;
            byteBufferArr = outputBuffers;
            if (z4) {
            }
            mediaFormat = mediaFormat2;
            byteBufferArr2 = byteBufferArr3;
            if (mediaFormat != null) {
            }
            z3 = z5;
            i = i2;
            if (!this.hsU.isStarted()) {
                this.hsU.bHc();
                if (this.hsU.start()) {
                }
            }
            z5 = z3;
            i2 = i;
            mediaFormat2 = mediaFormat;
            byteBufferArr3 = byteBufferArr2;
            outputBuffers = byteBufferArr;
            z6 = z2;
            z7 = z;
        }
    }

    private boolean bHb() {
        return !Thread.currentThread().isInterrupted();
    }

    private static boolean e(MediaFormat mediaFormat) {
        return d(mediaFormat).startsWith("video/");
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

    private static void log(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BdLog.i(str2);
        }
    }
}
