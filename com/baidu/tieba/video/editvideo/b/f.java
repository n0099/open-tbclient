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
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.video.editvideo.b.b;
import com.kwai.video.player.KsMediaMeta;
import com.kwai.video.player.misc.IMediaFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes8.dex */
class f extends Thread {
    private Context mContext;
    private String mFilterName;
    private String mSourcePath;
    private b.a nHh;
    private e nHk;

    public f(Context context, String str, String str2, e eVar, b.a aVar) {
        super("FilterVideoThread");
        this.mContext = context;
        this.mSourcePath = str;
        this.mFilterName = str2;
        this.nHk = eVar;
        this.nHh = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            dUm();
            if (dUo()) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.b.f.1
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:176:0x028b */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dUm() throws Exception {
        Throwable th;
        h hVar;
        g gVar;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        Exception exc;
        Exception exc2;
        g gVar2;
        MediaCodec mediaCodec3;
        Exception exc3;
        int i;
        int i2;
        MediaCodecInfo selectCodec = selectCodec(com.baidu.fsg.face.liveness.video.f.f2362b);
        try {
            if (selectCodec != null) {
                try {
                    mediaExtractor = dUn();
                    try {
                        MediaFormat trackFormat = mediaExtractor.getTrackFormat(b(mediaExtractor));
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(this.mSourcePath);
                        if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                            i = integer;
                            i2 = integer2;
                        } else {
                            i = integer2;
                            i2 = integer;
                        }
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(com.baidu.fsg.face.liveness.video.f.f2362b, i2, i);
                        createVideoFormat.setInteger("color-format", 2130708361);
                        a(trackFormat, createVideoFormat, KsMediaMeta.KSM_KEY_BITRATE, 2097152);
                        a(trackFormat, createVideoFormat, "frame-rate", 20);
                        a(trackFormat, createVideoFormat, "i-frame-interval", 1);
                        AtomicReference<Surface> atomicReference = new AtomicReference<>();
                        mediaCodec = a(selectCodec, createVideoFormat, atomicReference);
                        try {
                            gVar2 = new g(atomicReference.get());
                            try {
                                gVar2.makeCurrent();
                                hVar = new h(this.mContext, this.mFilterName, i2, i);
                            } catch (Exception e) {
                                e = e;
                                mediaCodec3 = null;
                                hVar = null;
                            } catch (Throwable th2) {
                                th = th2;
                                mediaCodec2 = null;
                                hVar = null;
                                gVar = gVar2;
                            }
                            try {
                                mediaCodec3 = a(trackFormat, hVar.getSurface());
                                try {
                                    a(mediaExtractor, mediaCodec3, mediaCodec, gVar2, hVar);
                                    if (mediaExtractor != null) {
                                        try {
                                            mediaExtractor.release();
                                        } catch (Exception e2) {
                                            exc3 = 0 == 0 ? e2 : null;
                                            if (this.nHh != null) {
                                                this.nHh.bW(225, com.baidu.tieba.l.a.p(e2));
                                            }
                                        }
                                    }
                                    exc3 = null;
                                    if (mediaCodec3 != null) {
                                        try {
                                            mediaCodec3.stop();
                                            mediaCodec3.release();
                                        } catch (Exception e3) {
                                            if (exc3 == null) {
                                                exc3 = e3;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.p(e3));
                                            }
                                        }
                                    }
                                    if (hVar != null) {
                                        try {
                                            hVar.release();
                                        } catch (Exception e4) {
                                            if (exc3 == null) {
                                                exc3 = e4;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(227, com.baidu.tieba.l.a.p(e4));
                                            }
                                        }
                                    }
                                    if (mediaCodec != null) {
                                        try {
                                            mediaCodec.stop();
                                            mediaCodec.release();
                                        } catch (Exception e5) {
                                            if (exc3 == null) {
                                                exc3 = e5;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(228, com.baidu.tieba.l.a.p(e5));
                                            }
                                        }
                                    }
                                    if (gVar2 != null) {
                                        try {
                                            gVar2.release();
                                        } catch (Exception e6) {
                                            if (exc3 == null) {
                                                exc3 = e6;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(229, com.baidu.tieba.l.a.p(e6));
                                            }
                                        }
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    e.printStackTrace();
                                    if ((Build.VERSION.SDK_INT < 21 || !(e instanceof MediaCodec.CodecException) || at.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.nHh != null) {
                                        this.nHh.bW(224, com.baidu.tieba.l.a.p(e));
                                    }
                                    if (mediaExtractor != null) {
                                        try {
                                            mediaExtractor.release();
                                        } catch (Exception e8) {
                                            exc = 0 == 0 ? e8 : null;
                                            if (this.nHh != null) {
                                                this.nHh.bW(225, com.baidu.tieba.l.a.p(e8));
                                            }
                                            exc3 = exc;
                                            if (mediaCodec3 != null) {
                                            }
                                            if (hVar != null) {
                                            }
                                            if (mediaCodec != null) {
                                            }
                                            if (gVar2 != null) {
                                            }
                                            if (exc3 != null) {
                                            }
                                        }
                                    }
                                    exc3 = null;
                                    if (mediaCodec3 != null) {
                                        try {
                                            mediaCodec3.stop();
                                            mediaCodec3.release();
                                        } catch (Exception e9) {
                                            if (exc3 == null) {
                                                exc3 = e9;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.p(e9));
                                            }
                                        }
                                    }
                                    if (hVar != null) {
                                        try {
                                            hVar.release();
                                        } catch (Exception e10) {
                                            if (exc3 == null) {
                                                exc3 = e10;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(227, com.baidu.tieba.l.a.p(e10));
                                            }
                                        }
                                    }
                                    if (mediaCodec != null) {
                                        try {
                                            mediaCodec.stop();
                                            mediaCodec.release();
                                        } catch (Exception e11) {
                                            if (exc3 == null) {
                                                exc3 = e11;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(228, com.baidu.tieba.l.a.p(e11));
                                            }
                                        }
                                    }
                                    if (gVar2 != null) {
                                        try {
                                            gVar2.release();
                                        } catch (Exception e12) {
                                            if (exc3 == null) {
                                                exc3 = e12;
                                            }
                                            if (this.nHh != null) {
                                                this.nHh.bW(229, com.baidu.tieba.l.a.p(e12));
                                            }
                                        }
                                    }
                                    if (exc3 != null) {
                                    }
                                }
                            } catch (Exception e13) {
                                e = e13;
                                mediaCodec3 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                mediaCodec2 = null;
                                gVar = gVar2;
                                if (mediaExtractor != null) {
                                    try {
                                        mediaExtractor.release();
                                    } catch (Exception e14) {
                                        exc = 0 == 0 ? e14 : null;
                                        if (this.nHh != null) {
                                            this.nHh.bW(225, com.baidu.tieba.l.a.p(e14));
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
                                                if (this.nHh != null) {
                                                    this.nHh.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.p(e15));
                                                }
                                            }
                                        }
                                        if (hVar != null) {
                                            try {
                                                hVar.release();
                                            } catch (Exception e16) {
                                                if (exc2 == null) {
                                                    exc2 = e16;
                                                }
                                                if (this.nHh != null) {
                                                    this.nHh.bW(227, com.baidu.tieba.l.a.p(e16));
                                                }
                                            }
                                        }
                                        if (mediaCodec != null) {
                                            try {
                                                mediaCodec.stop();
                                                mediaCodec.release();
                                            } catch (Exception e17) {
                                                if (exc2 == null) {
                                                    exc2 = e17;
                                                }
                                                if (this.nHh != null) {
                                                    this.nHh.bW(228, com.baidu.tieba.l.a.p(e17));
                                                }
                                            }
                                        }
                                        if (gVar != null) {
                                            try {
                                                gVar.release();
                                            } catch (Exception e18) {
                                                if (exc2 == null) {
                                                }
                                                if (this.nHh != null) {
                                                    this.nHh.bW(229, com.baidu.tieba.l.a.p(e18));
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
                        } catch (Exception e19) {
                            e = e19;
                            gVar2 = null;
                            mediaCodec3 = null;
                            hVar = null;
                        } catch (Throwable th4) {
                            th = th4;
                            gVar = null;
                            mediaCodec2 = null;
                            hVar = null;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        gVar2 = null;
                        mediaCodec = null;
                        mediaCodec3 = null;
                        hVar = null;
                    } catch (Throwable th5) {
                        th = th5;
                        gVar = null;
                        mediaCodec = null;
                        mediaCodec2 = null;
                        hVar = null;
                    }
                } catch (Exception e21) {
                    e = e21;
                    gVar2 = null;
                    mediaCodec = null;
                    mediaCodec3 = null;
                    hVar = null;
                    mediaExtractor = null;
                } catch (Throwable th6) {
                    th = th6;
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
        } catch (Throwable th7) {
            th = th7;
            gVar = selectCodec;
        }
    }

    private MediaExtractor dUn() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.mSourcePath);
        return mediaExtractor;
    }

    private MediaCodec a(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(e(mediaFormat));
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

    private int b(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (g(mediaExtractor.getTrackFormat(i))) {
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
        boolean z7 = false;
        int i2 = -1;
        MediaFormat mediaFormat2 = null;
        ByteBuffer[] byteBufferArr3 = outputBuffers2;
        while (!z4 && dUo()) {
            if (z7 || !((mediaFormat2 == null || this.nHk.isStarted()) && dUo())) {
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
                    boolean z8 = !mediaExtractor.advance();
                    if (z8) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        z = z8;
                    } else {
                        z = z8;
                    }
                }
            }
            if (!z6 && ((mediaFormat2 == null || this.nHk.isStarted()) && dUo())) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
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
                            hVar.awaitNewImage();
                            hVar.drawImage();
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
                if (z4 && ((mediaFormat2 == null || this.nHk.isStarted()) && dUo())) {
                    int dequeueOutputBuffer2 = mediaCodec2.dequeueOutputBuffer(bufferInfo2, 10000L);
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
                                this.nHk.c(i2, byteBuffer2, bufferInfo2);
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
                    D("InnerVideoProcessor", "muxer: adding video track.");
                    i = this.nHk.f(mediaFormat);
                    z3 = true;
                }
                if (!this.nHk.isStarted() && z3) {
                    this.nHk.dUp();
                    if (this.nHk.start()) {
                        synchronized (this.nHk) {
                            while (!this.nHk.isStarted()) {
                                try {
                                    this.nHk.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        z5 = z3;
                        z6 = z2;
                        z7 = z;
                        i2 = i;
                        mediaFormat2 = mediaFormat;
                        byteBufferArr3 = byteBufferArr2;
                        outputBuffers = byteBufferArr;
                    }
                }
                z5 = z3;
                z6 = z2;
                z7 = z;
                i2 = i;
                mediaFormat2 = mediaFormat;
                byteBufferArr3 = byteBufferArr2;
                outputBuffers = byteBufferArr;
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
            if (!this.nHk.isStarted()) {
                this.nHk.dUp();
                if (this.nHk.start()) {
                }
            }
            z5 = z3;
            z6 = z2;
            z7 = z;
            i2 = i;
            mediaFormat2 = mediaFormat;
            byteBufferArr3 = byteBufferArr2;
            outputBuffers = byteBufferArr;
        }
    }

    private boolean dUo() {
        return !Thread.currentThread().isInterrupted();
    }

    private static boolean g(MediaFormat mediaFormat) {
        return e(mediaFormat).startsWith("video/");
    }

    private static String e(MediaFormat mediaFormat) {
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

    private static void D(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            BdLog.i(str2);
        }
    }
}
