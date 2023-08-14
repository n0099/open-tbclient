package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.baidu.tieba.aab;
import com.baidu.tieba.dab;
import com.baidu.tieba.n9b;
import com.baidu.tieba.t9b;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes9.dex */
public class InnerVideoProcessor extends InnerMediaProcessor {
    public static final String TAG = "InnerVideoProcessor";
    public static final boolean VERBOSE = false;
    public Context mContext;
    public long mLastPresentationTimeStamp;
    public int mLastProgressPercent;
    public float mRotation;
    public String mSourcePath;
    public long mSourceVideoDuration;

    public InnerVideoProcessor(Context context, String str, InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super("FilterVideoThread");
        this.mLastPresentationTimeStamp = -1L;
        this.mLastProgressPercent = 0;
        this.mContext = context;
        this.mSourcePath = str;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0164 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecodeEditEncodeMux(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, InputSurface inputSurface, BaseOutputSurface baseOutputSurface) {
        boolean z;
        long j;
        int i;
        MediaCodec mediaCodec3;
        long j2;
        int i2;
        MediaFormat mediaFormat;
        boolean z2;
        int i3;
        int dequeueOutputBuffer;
        long j3;
        boolean z3;
        boolean z4;
        int dequeueInputBuffer;
        boolean z5;
        boolean z6;
        MediaCodec mediaCodec4 = mediaCodec;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        long j4 = 1000;
        int i4 = 0;
        mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
        if (this.mClipPoint + this.mClipDuration != 0) {
            z = true;
        } else {
            z = false;
        }
        int i5 = -1;
        ByteBuffer[] byteBufferArr = outputBuffers;
        ByteBuffer[] byteBufferArr2 = outputBuffers2;
        MediaFormat mediaFormat2 = null;
        int i6 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (!z7 && isUnInterrupted()) {
            if (!z8 && ((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec4.dequeueInputBuffer(10000L)) != i5)) {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                long sampleTime = mediaExtractor.getSampleTime();
                if (z && sampleTime <= ((this.mClipPoint + this.mClipDuration) * j4) + 100000) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (readSampleData >= 0 && (!z || z5)) {
                    j = 10000;
                    i = i6;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                    mediaExtractor.advance();
                } else {
                    i = i6;
                    j = 10000;
                    if (mediaExtractor.advance() && (!z || z5)) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (z6) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    }
                    z8 = z6;
                }
            } else {
                j = 10000;
                i = i6;
            }
            if (!z9 && ((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
                mediaCodec3 = mediaCodec;
                int dequeueOutputBuffer2 = mediaCodec3.dequeueOutputBuffer(bufferInfo, j);
                if (dequeueOutputBuffer2 != -1) {
                    if (dequeueOutputBuffer2 == -3) {
                        byteBufferArr = mediaCodec.getOutputBuffers();
                        j2 = 1000;
                        if (z7 && ((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueOutputBuffer = mediaCodec2.dequeueOutputBuffer(bufferInfo2, j)) != -1)) {
                            if (dequeueOutputBuffer == -3) {
                                byteBufferArr2 = mediaCodec2.getOutputBuffers();
                                mediaFormat = mediaFormat2;
                                i2 = i;
                            } else if (dequeueOutputBuffer == -2) {
                                i2 = i;
                                if (i2 >= 0) {
                                    return;
                                }
                                mediaFormat = mediaCodec2.getOutputFormat();
                            } else {
                                i2 = i;
                                ByteBuffer byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                                if ((bufferInfo2.flags & 2) != 0) {
                                    mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                } else {
                                    if (bufferInfo2.size != 0) {
                                        long j5 = bufferInfo2.presentationTimeUs;
                                        if (j5 > this.mLastPresentationTimeStamp) {
                                            this.mLastPresentationTimeStamp = j5;
                                            i2 = i2;
                                            this.mMuxer.writeSampleData(i2, byteBuffer, bufferInfo2);
                                        } else {
                                            i2 = i2;
                                        }
                                    }
                                    long j6 = bufferInfo2.presentationTimeUs;
                                    if (z) {
                                        j3 = this.mClipDuration;
                                    } else {
                                        j3 = this.mSourceVideoDuration;
                                    }
                                    int i7 = (int) (j6 / (j3 * 10));
                                    if (i7 > 0 && i7 <= 100 && this.mLastProgressPercent < i7) {
                                        onProgress(i7);
                                        this.mLastProgressPercent = i7;
                                    }
                                    if ((bufferInfo2.flags & 4) != 0) {
                                        onProgress(100);
                                        z3 = true;
                                    } else {
                                        z3 = z7;
                                    }
                                    i4 = 0;
                                    mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                    z7 = z3;
                                    mediaFormat = mediaFormat2;
                                    if (mediaFormat == null && !this.mAddTrack) {
                                        log(TAG, "muxer: adding video track.");
                                        i3 = this.mMuxer.addTrack(mediaFormat);
                                        z2 = true;
                                        this.mAddTrack = true;
                                    } else {
                                        z2 = true;
                                        i3 = i2;
                                    }
                                    checkMuxerStart(z2);
                                    mediaCodec4 = mediaCodec3;
                                    mediaFormat2 = mediaFormat;
                                    i6 = i3;
                                    j4 = j2;
                                    i5 = -1;
                                }
                            }
                            i4 = 0;
                            if (mediaFormat == null) {
                            }
                            z2 = true;
                            i3 = i2;
                            checkMuxerStart(z2);
                            mediaCodec4 = mediaCodec3;
                            mediaFormat2 = mediaFormat;
                            i6 = i3;
                            j4 = j2;
                            i5 = -1;
                        } else {
                            i2 = i;
                        }
                        i4 = 0;
                        mediaFormat = mediaFormat2;
                        if (mediaFormat == null) {
                        }
                        z2 = true;
                        i3 = i2;
                        checkMuxerStart(z2);
                        mediaCodec4 = mediaCodec3;
                        mediaFormat2 = mediaFormat;
                        i6 = i3;
                        j4 = j2;
                        i5 = -1;
                    } else if (dequeueOutputBuffer2 == -2) {
                        mediaCodec.getOutputFormat();
                    } else {
                        ByteBuffer byteBuffer2 = byteBufferArr[dequeueOutputBuffer2];
                        if ((bufferInfo.flags & 2) != 0) {
                            mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, false);
                        } else {
                            if (bufferInfo.size != 0) {
                                j2 = 1000;
                                if (bufferInfo.presentationTimeUs >= this.mClipPoint * 1000) {
                                    z4 = true;
                                    mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, z4);
                                    if (!z4) {
                                        baseOutputSurface.awaitNewImage();
                                        baseOutputSurface.drawImage((int) (bufferInfo.presentationTimeUs / j2));
                                        inputSurface.setPresentationTime((bufferInfo.presentationTimeUs - (this.mClipPoint * j2)) * j2);
                                        inputSurface.swapBuffers();
                                    }
                                    if ((bufferInfo.flags & 4) != 0) {
                                        mediaCodec2.signalEndOfInputStream();
                                        z9 = true;
                                    }
                                    if (z7) {
                                    }
                                    i2 = i;
                                    i4 = 0;
                                    mediaFormat = mediaFormat2;
                                    if (mediaFormat == null) {
                                    }
                                    z2 = true;
                                    i3 = i2;
                                    checkMuxerStart(z2);
                                    mediaCodec4 = mediaCodec3;
                                    mediaFormat2 = mediaFormat;
                                    i6 = i3;
                                    j4 = j2;
                                    i5 = -1;
                                }
                            } else {
                                j2 = 1000;
                            }
                            z4 = false;
                            mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, z4);
                            if (!z4) {
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                            }
                            if (z7) {
                            }
                            i2 = i;
                            i4 = 0;
                            mediaFormat = mediaFormat2;
                            if (mediaFormat == null) {
                            }
                            z2 = true;
                            i3 = i2;
                            checkMuxerStart(z2);
                            mediaCodec4 = mediaCodec3;
                            mediaFormat2 = mediaFormat;
                            i6 = i3;
                            j4 = j2;
                            i5 = -1;
                        }
                    }
                }
            } else {
                mediaCodec3 = mediaCodec;
            }
            j2 = 1000;
            if (z7) {
            }
            i2 = i;
            i4 = 0;
            mediaFormat = mediaFormat2;
            if (mediaFormat == null) {
            }
            z2 = true;
            i3 = i2;
            checkMuxerStart(z2);
            mediaCodec4 = mediaCodec3;
            mediaFormat2 = mediaFormat;
            i6 = i3;
            j4 = j2;
            i5 = -1;
        }
        if (!isUnInterrupted()) {
            onInterrupt();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:123:0x01a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:162:0x019c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:173:0x000b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:175:0x0193 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0135 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0138 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x0150 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0197 A[Catch: Exception -> 0x019c, TRY_LEAVE, TryCatch #6 {Exception -> 0x019c, blocks: (B:118:0x0193, B:120:0x0197), top: B:175:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.baidu.ugc.editvideo.editvideo.addfilter.InnerVideoProcessor, com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.baidu.ugc.editvideo.editvideo.addfilter.InputSurface] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.baidu.ugc.editvideo.editvideo.addfilter.InputSurface] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractDecodeEditEncodeMux() throws Exception {
        Exception exc;
        MediaCodec mediaCodec;
        InputSurface inputSurface;
        MediaCodec mediaCodec2;
        ?? e;
        int i;
        int i2;
        int i3;
        int i4;
        Surface surface;
        String e2 = "video/avc";
        MediaCodecInfo m = t9b.m("video/avc");
        if (m == null) {
            return;
        }
        Exception e3 = 0;
        e3 = null;
        e3 = null;
        MediaExtractor mediaExtractor = null;
        try {
            try {
                e = t9b.b(this.mSourcePath);
                try {
                    try {
                        MediaFormat trackFormat = e.getTrackFormat(t9b.f(e));
                        if (this.mOutWidth == 0) {
                            i = trackFormat.getInteger("width");
                        } else {
                            i = this.mOutWidth;
                        }
                        if (this.mOutHeight == 0) {
                            i2 = trackFormat.getInteger("height");
                        } else {
                            i2 = this.mOutHeight;
                        }
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(this.mSourcePath);
                        int b = ((int) (n9b.b(mediaMetadataRetriever.extractMetadata(24), 0) + this.mRotation)) % 360;
                        if (aab.b) {
                            trackFormat.setInteger("rotation-degrees", b);
                        } else {
                            trackFormat.setInteger("rotation-degrees", b);
                        }
                        if ((this.mOutWidth == 0 || this.mOutHeight == 0) && (b == 90 || b == 270)) {
                            int i5 = i2;
                            i2 = i;
                            i = i5;
                        }
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (!dab.a(extractMetadata)) {
                            this.mSourceVideoDuration = n9b.c(extractMetadata, 0L);
                        }
                        this.mLastProgressPercent = 0;
                        String str = e2;
                        if (this.mEncodeHevcVideo) {
                            MediaCodecInfo m2 = t9b.m(MimeTypes.VIDEO_H265);
                            str = e2;
                            if (m2 != null) {
                                m = m2;
                                str = MimeTypes.VIDEO_H265;
                            }
                        }
                        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
                        createVideoFormat.setInteger("color-format", 2130708361);
                        if (this.mOutBitRate == 0) {
                            i3 = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
                        } else {
                            i3 = this.mOutBitRate;
                        }
                        t9b.n(trackFormat, createVideoFormat, "bitrate", i3);
                        if (this.mFrameRate == 0) {
                            i4 = 30;
                        } else {
                            i4 = this.mFrameRate;
                        }
                        t9b.n(trackFormat, createVideoFormat, "frame-rate", i4);
                        t9b.n(trackFormat, createVideoFormat, "i-frame-interval", 5);
                        AtomicReference atomicReference = new AtomicReference();
                        try {
                            e2 = t9b.d(m, createVideoFormat, atomicReference);
                        } catch (Exception unused) {
                            if (i % 16 != 0) {
                                i += 16 - (i % 16);
                            }
                            if (i2 % 16 != 0) {
                                i2 += 16 - (i2 % 16);
                            }
                            createVideoFormat.setInteger("width", i);
                            createVideoFormat.setInteger("height", i2);
                            e2 = t9b.d(m, createVideoFormat, atomicReference);
                        }
                        try {
                            m = new InputSurface((Surface) atomicReference.get());
                            try {
                                m.makeCurrent();
                                if (this.mOutputSurface != null) {
                                    this.mOutputSurface.init(i, i2);
                                    surface = this.mOutputSurface.getSurface();
                                } else {
                                    surface = null;
                                }
                                mediaCodec2 = t9b.c(trackFormat, surface);
                                try {
                                    doExtractDecodeEditEncodeMux(e, mediaCodec2, e2, m, this.mOutputSurface);
                                    if (e != 0) {
                                        try {
                                            e.release();
                                        } catch (Exception e4) {
                                            e3 = e4;
                                        }
                                    }
                                    if (mediaCodec2 != null) {
                                        try {
                                            mediaCodec2.stop();
                                            mediaCodec2.release();
                                        } catch (Exception e5) {
                                            if (e3 == null) {
                                                e3 = e5;
                                            }
                                        }
                                    }
                                    try {
                                        e = this.mOutputSurface;
                                        if (e != 0) {
                                            e = this.mOutputSurface;
                                            e.release();
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        if (e3 == null) {
                                            e3 = e;
                                        }
                                    }
                                    if (e2 != 0) {
                                        try {
                                            e2.stop();
                                            e2.release();
                                        } catch (Exception e7) {
                                            e2 = e7;
                                            if (e3 == null) {
                                                e3 = e2;
                                            }
                                        }
                                    }
                                    try {
                                        m.release();
                                    } catch (Exception e8) {
                                        e2 = e8;
                                        if (e3 == null) {
                                            e3 = e2;
                                        }
                                    }
                                } catch (Exception e9) {
                                    e3 = e9;
                                    e3.printStackTrace();
                                    if (e != 0) {
                                    }
                                    if (mediaCodec2 != null) {
                                    }
                                    try {
                                        e = this.mOutputSurface;
                                        if (e != 0) {
                                        }
                                    } catch (Exception unused2) {
                                    }
                                    if (e2 != 0) {
                                    }
                                    if (m != 0) {
                                    }
                                    if (e3 == null) {
                                    }
                                }
                            } catch (Exception e10) {
                                mediaCodec2 = null;
                                e3 = e10;
                            } catch (Throwable th) {
                                mediaCodec2 = null;
                                mediaExtractor = e;
                                mediaCodec = e2;
                                th = th;
                                inputSurface = m;
                                exc = mediaCodec2;
                                if (mediaExtractor != null) {
                                    try {
                                        mediaExtractor.release();
                                    } catch (Exception e11) {
                                        if (exc == null) {
                                            exc = e11;
                                        }
                                    }
                                }
                                if (mediaCodec2 != null) {
                                    try {
                                        mediaCodec2.stop();
                                        mediaCodec2.release();
                                    } catch (Exception e12) {
                                        if (exc == null) {
                                            exc = e12;
                                        }
                                    }
                                }
                                try {
                                    if (this.mOutputSurface != null) {
                                        this.mOutputSurface.release();
                                    }
                                } catch (Exception e13) {
                                    if (exc == null) {
                                        exc = e13;
                                    }
                                }
                                if (mediaCodec != null) {
                                    try {
                                        mediaCodec.stop();
                                        mediaCodec.release();
                                    } catch (Exception e14) {
                                        if (exc == null) {
                                        }
                                    }
                                }
                                if (inputSurface != null) {
                                    try {
                                        inputSurface.release();
                                    } catch (Exception unused3) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e15) {
                            mediaCodec2 = null;
                            e3 = e15;
                            m = 0;
                        } catch (Throwable th2) {
                            inputSurface = null;
                            mediaCodec2 = null;
                            mediaExtractor = e;
                            mediaCodec = e2;
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        exc = null;
                        inputSurface = null;
                        mediaCodec2 = null;
                        mediaExtractor = e;
                        mediaCodec = null;
                    }
                } catch (Exception e16) {
                    e = e16;
                    m = 0;
                    mediaCodec2 = null;
                    e = e;
                    e3 = e;
                    e2 = mediaCodec2;
                    e3.printStackTrace();
                    if (e != 0) {
                        try {
                            e.release();
                        } catch (Exception unused4) {
                        }
                    }
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                            mediaCodec2.release();
                        } catch (Exception unused5) {
                        }
                    }
                    e = this.mOutputSurface;
                    if (e != 0) {
                        e = this.mOutputSurface;
                        e.release();
                    }
                    if (e2 != 0) {
                        try {
                            e2.stop();
                            e2.release();
                        } catch (Exception unused6) {
                        }
                    }
                    if (m != 0) {
                        try {
                            m.release();
                        } catch (Exception unused7) {
                        }
                    }
                    if (e3 == null) {
                    }
                }
            } catch (Throwable th4) {
                MediaExtractor mediaExtractor2 = e;
                mediaCodec = e2;
                th = th4;
                inputSurface = m;
                exc = e3;
                mediaExtractor = mediaExtractor2;
            }
        } catch (Exception e17) {
            e = e17;
            m = 0;
            e = 0;
            mediaCodec2 = null;
        } catch (Throwable th5) {
            th = th5;
            exc = null;
            mediaCodec = null;
            inputSurface = null;
            mediaCodec2 = null;
        }
        if (e3 == null) {
            return;
        }
        throw e3;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }
}
