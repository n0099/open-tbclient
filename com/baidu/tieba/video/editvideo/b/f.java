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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.video.editvideo.b.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes22.dex */
class f extends Thread {
    private Context mContext;
    private String mFilterName;
    private String mSourcePath;
    private b.a noZ;
    private e npc;

    public f(Context context, String str, String str2, e eVar, b.a aVar) {
        super("FilterVideoThread");
        this.mContext = context;
        this.mSourcePath = str;
        this.mFilterName = str2;
        this.npc = eVar;
        this.noZ = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            dPc();
            if (dPe()) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.b.f.1
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:176:0x0292 */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0277: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:167:0x0276 */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0278: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:167:0x0276 */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0168 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dPc() throws Exception {
        MediaExtractor mediaExtractor;
        MediaExtractor mediaExtractor2;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        Throwable th;
        h hVar;
        g gVar;
        MediaCodec mediaCodec3;
        Exception exc;
        Exception exc2;
        MediaCodec mediaCodec4;
        MediaCodec mediaCodec5;
        MediaExtractor mediaExtractor3;
        Exception exc3;
        int i;
        MediaCodecInfo selectCodec = selectCodec(com.baidu.fsg.face.liveness.video.f.b);
        try {
            if (selectCodec != null) {
                try {
                    mediaExtractor3 = dPd();
                    try {
                        MediaFormat trackFormat = mediaExtractor3.getTrackFormat(getAndSelectVideoTrackIndex(mediaExtractor3));
                        int integer = trackFormat.getInteger("width");
                        int integer2 = trackFormat.getInteger("height");
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(this.mSourcePath);
                        if (TextUtils.equals(mediaMetadataRetriever.extractMetadata(24), "90")) {
                            i = integer2;
                            integer2 = integer;
                        } else {
                            i = integer;
                        }
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(com.baidu.fsg.face.liveness.video.f.b, i, integer2);
                        createVideoFormat.setInteger("color-format", 2130708361);
                        a(trackFormat, createVideoFormat, "bitrate", 2097152);
                        a(trackFormat, createVideoFormat, "frame-rate", 20);
                        a(trackFormat, createVideoFormat, "i-frame-interval", 1);
                        AtomicReference<Surface> atomicReference = new AtomicReference<>();
                        mediaCodec4 = createVideoEncoder(selectCodec, createVideoFormat, atomicReference);
                        try {
                            gVar = new g(atomicReference.get());
                            try {
                                gVar.makeCurrent();
                                hVar = new h(this.mContext, this.mFilterName, i, integer2);
                            } catch (Exception e) {
                                e = e;
                                mediaCodec5 = null;
                                hVar = null;
                            } catch (Throwable th2) {
                                th = th2;
                                hVar = null;
                                mediaExtractor2 = mediaExtractor3;
                                mediaCodec2 = null;
                                mediaCodec3 = mediaCodec4;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            gVar = null;
                            mediaCodec5 = null;
                            hVar = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gVar = null;
                            hVar = null;
                            mediaExtractor2 = mediaExtractor3;
                            mediaCodec2 = null;
                            mediaCodec3 = mediaCodec4;
                        }
                        try {
                            mediaCodec5 = createVideoDecoder(trackFormat, hVar.getSurface());
                            try {
                                a(mediaExtractor3, mediaCodec5, mediaCodec4, gVar, hVar);
                                if (mediaExtractor3 != null) {
                                    try {
                                        mediaExtractor3.release();
                                    } catch (Exception e3) {
                                        exc3 = 0 == 0 ? e3 : null;
                                        if (this.noZ != null) {
                                            this.noZ.bW(225, com.baidu.tieba.l.a.r(e3));
                                        }
                                    }
                                }
                                exc3 = null;
                                if (mediaCodec5 != null) {
                                    try {
                                        mediaCodec5.stop();
                                        mediaCodec5.release();
                                    } catch (Exception e4) {
                                        if (exc3 == null) {
                                            exc3 = e4;
                                        }
                                        if (this.noZ != null) {
                                            this.noZ.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.r(e4));
                                        }
                                    }
                                }
                                if (hVar != null) {
                                    try {
                                        hVar.release();
                                    } catch (Exception e5) {
                                        if (exc3 == null) {
                                            exc3 = e5;
                                        }
                                        if (this.noZ != null) {
                                            this.noZ.bW(227, com.baidu.tieba.l.a.r(e5));
                                        }
                                    }
                                }
                                if (mediaCodec4 != null) {
                                    try {
                                        mediaCodec4.stop();
                                        mediaCodec4.release();
                                    } catch (Exception e6) {
                                        if (exc3 == null) {
                                            exc3 = e6;
                                        }
                                        if (this.noZ != null) {
                                            this.noZ.bW(228, com.baidu.tieba.l.a.r(e6));
                                        }
                                    }
                                }
                                if (gVar != null) {
                                    try {
                                        gVar.release();
                                    } catch (Exception e7) {
                                        if (exc3 == null) {
                                            exc3 = e7;
                                        }
                                        if (this.noZ != null) {
                                            this.noZ.bW(229, com.baidu.tieba.l.a.r(e7));
                                        }
                                    }
                                }
                            } catch (Exception e8) {
                                e = e8;
                                e.printStackTrace();
                                if ((Build.VERSION.SDK_INT < 21 || !(e instanceof MediaCodec.CodecException) || au.isEmpty(e.getMessage()) || !e.getMessage().contains("0xfffffff3")) && this.noZ != null) {
                                    this.noZ.bW(224, com.baidu.tieba.l.a.r(e));
                                }
                                if (mediaExtractor3 != null) {
                                    try {
                                        mediaExtractor3.release();
                                    } catch (Exception e9) {
                                        exc = 0 == 0 ? e9 : null;
                                        if (this.noZ != null) {
                                            this.noZ.bW(225, com.baidu.tieba.l.a.r(e9));
                                        }
                                        exc3 = exc;
                                        if (mediaCodec5 != null) {
                                            try {
                                                mediaCodec5.stop();
                                                mediaCodec5.release();
                                            } catch (Exception e10) {
                                                if (exc3 == null) {
                                                    exc3 = e10;
                                                }
                                                if (this.noZ != null) {
                                                    this.noZ.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.r(e10));
                                                }
                                            }
                                        }
                                        if (hVar != null) {
                                            try {
                                                hVar.release();
                                            } catch (Exception e11) {
                                                if (exc3 == null) {
                                                    exc3 = e11;
                                                }
                                                if (this.noZ != null) {
                                                    this.noZ.bW(227, com.baidu.tieba.l.a.r(e11));
                                                }
                                            }
                                        }
                                        if (mediaCodec4 != null) {
                                            try {
                                                mediaCodec4.stop();
                                                mediaCodec4.release();
                                            } catch (Exception e12) {
                                                if (exc3 == null) {
                                                    exc3 = e12;
                                                }
                                                if (this.noZ != null) {
                                                    this.noZ.bW(228, com.baidu.tieba.l.a.r(e12));
                                                }
                                            }
                                        }
                                        if (gVar != null) {
                                            try {
                                                gVar.release();
                                            } catch (Exception e13) {
                                                if (exc3 == null) {
                                                    exc3 = e13;
                                                }
                                                if (this.noZ != null) {
                                                    this.noZ.bW(229, com.baidu.tieba.l.a.r(e13));
                                                }
                                            }
                                        }
                                        if (exc3 != null) {
                                        }
                                    }
                                }
                                exc3 = null;
                                if (mediaCodec5 != null) {
                                }
                                if (hVar != null) {
                                }
                                if (mediaCodec4 != null) {
                                }
                                if (gVar != null) {
                                }
                                if (exc3 != null) {
                                }
                            }
                        } catch (Exception e14) {
                            e = e14;
                            mediaCodec5 = null;
                        } catch (Throwable th4) {
                            th = th4;
                            mediaExtractor2 = mediaExtractor3;
                            mediaCodec2 = null;
                            mediaCodec3 = mediaCodec4;
                            if (mediaExtractor2 != null) {
                                try {
                                    mediaExtractor2.release();
                                } catch (Exception e15) {
                                    exc = 0 == 0 ? e15 : null;
                                    if (this.noZ != null) {
                                        this.noZ.bW(225, com.baidu.tieba.l.a.r(e15));
                                    }
                                    exc2 = exc;
                                    if (mediaCodec2 != null) {
                                        try {
                                            mediaCodec2.stop();
                                            mediaCodec2.release();
                                        } catch (Exception e16) {
                                            if (exc2 == null) {
                                                exc2 = e16;
                                            }
                                            if (this.noZ != null) {
                                                this.noZ.bW(Constants.METHOD_MEDIA_NOTIFY, com.baidu.tieba.l.a.r(e16));
                                            }
                                        }
                                    }
                                    if (hVar != null) {
                                        try {
                                            hVar.release();
                                        } catch (Exception e17) {
                                            if (exc2 == null) {
                                                exc2 = e17;
                                            }
                                            if (this.noZ != null) {
                                                this.noZ.bW(227, com.baidu.tieba.l.a.r(e17));
                                            }
                                        }
                                    }
                                    if (mediaCodec3 != null) {
                                        try {
                                            mediaCodec3.stop();
                                            mediaCodec3.release();
                                        } catch (Exception e18) {
                                            if (exc2 == null) {
                                                exc2 = e18;
                                            }
                                            if (this.noZ != null) {
                                                this.noZ.bW(228, com.baidu.tieba.l.a.r(e18));
                                            }
                                        }
                                    }
                                    if (gVar != null) {
                                        try {
                                            gVar.release();
                                        } catch (Exception e19) {
                                            if (exc2 == null) {
                                            }
                                            if (this.noZ != null) {
                                                this.noZ.bW(229, com.baidu.tieba.l.a.r(e19));
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
                            if (mediaCodec3 != null) {
                            }
                            if (gVar != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e20) {
                        e = e20;
                        gVar = null;
                        mediaCodec4 = null;
                        mediaCodec5 = null;
                        hVar = null;
                    } catch (Throwable th5) {
                        th = th5;
                        gVar = null;
                        mediaCodec3 = null;
                        hVar = null;
                        mediaExtractor2 = mediaExtractor3;
                        mediaCodec2 = null;
                    }
                } catch (Exception e21) {
                    e = e21;
                    gVar = null;
                    mediaCodec4 = null;
                    mediaCodec5 = null;
                    hVar = null;
                    mediaExtractor3 = null;
                } catch (Throwable th6) {
                    th = th6;
                    gVar = null;
                    mediaCodec3 = null;
                    mediaCodec2 = null;
                    hVar = null;
                    mediaExtractor2 = null;
                }
                if (exc3 != null) {
                    throw exc3;
                }
            }
        } catch (Throwable th7) {
            mediaExtractor2 = mediaExtractor;
            mediaCodec2 = mediaCodec;
            th = th7;
            mediaCodec3 = selectCodec;
        }
    }

    private MediaExtractor dPd() throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(this.mSourcePath);
        return mediaExtractor;
    }

    private MediaCodec createVideoDecoder(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        createDecoderByType.start();
        return createDecoderByType;
    }

    private MediaCodec createVideoEncoder(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) throws IOException {
        MediaCodec createByCodecName = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        createByCodecName.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        atomicReference.set(createByCodecName.createInputSurface());
        createByCodecName.start();
        return createByCodecName;
    }

    private int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            if (isVideoFormat(mediaExtractor.getTrackFormat(i))) {
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
        while (!z4 && dPe()) {
            if (z7 || !((mediaFormat2 == null || this.npc.isStarted()) && dPe())) {
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
            if (!z6 && ((mediaFormat2 == null || this.npc.isStarted()) && dPe())) {
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
                if (z4 && ((mediaFormat2 == null || this.npc.isStarted()) && dPe())) {
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
                                this.npc.c(i2, byteBuffer2, bufferInfo2);
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
                    i = this.npc.c(mediaFormat);
                    z3 = true;
                }
                if (!this.npc.isStarted() && z3) {
                    this.npc.dPf();
                    if (this.npc.start()) {
                        synchronized (this.npc) {
                            while (!this.npc.isStarted()) {
                                try {
                                    this.npc.wait(100L);
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
            if (!this.npc.isStarted()) {
                this.npc.dPf();
                if (this.npc.start()) {
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

    private boolean dPe() {
        return !Thread.currentThread().isInterrupted();
    }

    private static boolean isVideoFormat(MediaFormat mediaFormat) {
        return getMimeTypeFor(mediaFormat).startsWith("video/");
    }

    private static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
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
