package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import com.repackage.g89;
import com.repackage.j89;
import com.repackage.t79;
import com.repackage.z79;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes4.dex */
public class InnerVideoProcessor extends InnerMediaProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InnerVideoProcessor";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mLastPresentationTimeStamp;
    public int mLastProgressPercent;
    public float mRotation;
    public String mSourcePath;
    public long mSourceVideoDuration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerVideoProcessor(Context context, String str, InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super("FilterVideoThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, innerMuxerWrapper, onGenFilterVideoListener};
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
        this.mLastPresentationTimeStamp = -1L;
        this.mLastProgressPercent = 0;
        this.mContext = context;
        this.mSourcePath = str;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0168 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecodeEditEncodeMux(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, InputSurface inputSurface, BaseOutputSurface baseOutputSurface) {
        long j;
        int i;
        MediaCodec mediaCodec3;
        long j2;
        int i2;
        MediaFormat mediaFormat;
        boolean z;
        int i3;
        int dequeueOutputBuffer;
        boolean z2;
        boolean z3;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, this, mediaExtractor, mediaCodec, mediaCodec2, inputSurface, baseOutputSurface) == null) {
            MediaCodec mediaCodec4 = mediaCodec;
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            ByteBuffer[] outputBuffers2 = mediaCodec2.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            long j3 = 1000;
            int i4 = 0;
            mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
            boolean z4 = this.mClipPoint + this.mClipDuration != 0;
            int i5 = -1;
            ByteBuffer[] byteBufferArr = outputBuffers;
            ByteBuffer[] byteBufferArr2 = outputBuffers2;
            MediaFormat mediaFormat2 = null;
            int i6 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            while (!z5 && isUnInterrupted()) {
                if (z6 || !((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec4.dequeueInputBuffer(10000L)) != i5)) {
                    j = 10000;
                    i = i6;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i4);
                    long sampleTime = mediaExtractor.getSampleTime();
                    boolean z8 = z4 && sampleTime <= ((this.mClipPoint + this.mClipDuration) * j3) + 100000;
                    if (readSampleData >= 0 && (!z4 || z8)) {
                        j = 10000;
                        i = i6;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                        mediaExtractor.advance();
                    } else {
                        i = i6;
                        j = 10000;
                        boolean z9 = !mediaExtractor.advance() || (z4 && !z8);
                        if (z9) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                        z6 = z9;
                    }
                }
                if (z7 || !((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
                    mediaCodec3 = mediaCodec;
                } else {
                    mediaCodec3 = mediaCodec;
                    int dequeueOutputBuffer2 = mediaCodec3.dequeueOutputBuffer(bufferInfo, j);
                    if (dequeueOutputBuffer2 != -1) {
                        if (dequeueOutputBuffer2 == -3) {
                            byteBufferArr = mediaCodec.getOutputBuffers();
                            j2 = 1000;
                            if (z5 && ((mediaFormat2 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueOutputBuffer = mediaCodec2.dequeueOutputBuffer(bufferInfo2, j)) != -1)) {
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
                                            long j4 = bufferInfo2.presentationTimeUs;
                                            if (j4 > this.mLastPresentationTimeStamp) {
                                                this.mLastPresentationTimeStamp = j4;
                                                i2 = i2;
                                                this.mMuxer.writeSampleData(i2, byteBuffer, bufferInfo2);
                                            } else {
                                                i2 = i2;
                                            }
                                        }
                                        int i7 = (int) (bufferInfo2.presentationTimeUs / ((z4 ? this.mClipDuration : this.mSourceVideoDuration) * 10));
                                        if (i7 > 0 && i7 <= 100 && this.mLastProgressPercent < i7) {
                                            onProgress(i7);
                                            this.mLastProgressPercent = i7;
                                        }
                                        if ((bufferInfo2.flags & 4) != 0) {
                                            onProgress(100);
                                            z2 = true;
                                        } else {
                                            z2 = z5;
                                        }
                                        i4 = 0;
                                        mediaCodec2.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        z5 = z2;
                                        mediaFormat = mediaFormat2;
                                        if (mediaFormat != null || this.mAddTrack) {
                                            z = true;
                                            i3 = i2;
                                        } else {
                                            log(TAG, "muxer: adding video track.");
                                            i3 = this.mMuxer.addTrack(mediaFormat);
                                            z = true;
                                            this.mAddTrack = true;
                                        }
                                        checkMuxerStart(z);
                                        mediaCodec4 = mediaCodec3;
                                        mediaFormat2 = mediaFormat;
                                        i6 = i3;
                                        j3 = j2;
                                        i5 = -1;
                                    }
                                }
                                i4 = 0;
                                if (mediaFormat != null) {
                                }
                                z = true;
                                i3 = i2;
                                checkMuxerStart(z);
                                mediaCodec4 = mediaCodec3;
                                mediaFormat2 = mediaFormat;
                                i6 = i3;
                                j3 = j2;
                                i5 = -1;
                            } else {
                                i2 = i;
                            }
                            i4 = 0;
                            mediaFormat = mediaFormat2;
                            if (mediaFormat != null) {
                            }
                            z = true;
                            i3 = i2;
                            checkMuxerStart(z);
                            mediaCodec4 = mediaCodec3;
                            mediaFormat2 = mediaFormat;
                            i6 = i3;
                            j3 = j2;
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
                                        z3 = true;
                                        mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, z3);
                                        if (!z3) {
                                            baseOutputSurface.awaitNewImage();
                                            baseOutputSurface.drawImage((int) (bufferInfo.presentationTimeUs / j2));
                                            inputSurface.setPresentationTime((bufferInfo.presentationTimeUs - (this.mClipPoint * j2)) * j2);
                                            inputSurface.swapBuffers();
                                        }
                                        if ((bufferInfo.flags & 4) != 0) {
                                            mediaCodec2.signalEndOfInputStream();
                                            z7 = true;
                                        }
                                        if (z5) {
                                        }
                                        i2 = i;
                                        i4 = 0;
                                        mediaFormat = mediaFormat2;
                                        if (mediaFormat != null) {
                                        }
                                        z = true;
                                        i3 = i2;
                                        checkMuxerStart(z);
                                        mediaCodec4 = mediaCodec3;
                                        mediaFormat2 = mediaFormat;
                                        i6 = i3;
                                        j3 = j2;
                                        i5 = -1;
                                    }
                                } else {
                                    j2 = 1000;
                                }
                                z3 = false;
                                mediaCodec3.releaseOutputBuffer(dequeueOutputBuffer2, z3);
                                if (!z3) {
                                }
                                if ((bufferInfo.flags & 4) != 0) {
                                }
                                if (z5) {
                                }
                                i2 = i;
                                i4 = 0;
                                mediaFormat = mediaFormat2;
                                if (mediaFormat != null) {
                                }
                                z = true;
                                i3 = i2;
                                checkMuxerStart(z);
                                mediaCodec4 = mediaCodec3;
                                mediaFormat2 = mediaFormat;
                                i6 = i3;
                                j3 = j2;
                                i5 = -1;
                            }
                        }
                    }
                }
                j2 = 1000;
                if (z5) {
                }
                i2 = i;
                i4 = 0;
                mediaFormat = mediaFormat2;
                if (mediaFormat != null) {
                }
                z = true;
                i3 = i2;
                checkMuxerStart(z);
                mediaCodec4 = mediaCodec3;
                mediaFormat2 = mediaFormat;
                i6 = i3;
                j3 = j2;
                i5 = -1;
            }
            if (isUnInterrupted()) {
                return;
            }
            onInterrupt();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x01a5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:167:0x019d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x000e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:180:0x0194 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0136 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x0139 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0151 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0198 A[Catch: Exception -> 0x019d, TRY_LEAVE, TryCatch #6 {Exception -> 0x019d, blocks: (B:120:0x0194, B:122:0x0198), top: B:180:0x0194 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.baidu.ugc.editvideo.editvideo.addfilter.InnerVideoProcessor, java.lang.Object, com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor] */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.baidu.ugc.editvideo.editvideo.addfilter.InputSurface] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
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
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String e2 = "video/avc";
            MediaCodecInfo m = z79.m("video/avc");
            if (m == null) {
                return;
            }
            Exception e3 = 0;
            e3 = null;
            e3 = null;
            MediaExtractor mediaExtractor = null;
            try {
                try {
                    e = z79.b(this.mSourcePath);
                    try {
                        try {
                            MediaFormat trackFormat = e.getTrackFormat(z79.f(e));
                            int integer = this.mOutWidth == 0 ? trackFormat.getInteger("width") : this.mOutWidth;
                            int integer2 = this.mOutHeight == 0 ? trackFormat.getInteger("height") : this.mOutHeight;
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(this.mSourcePath);
                            int b = ((int) (t79.b(mediaMetadataRetriever.extractMetadata(24), 0) + this.mRotation)) % 360;
                            if (g89.b) {
                                trackFormat.setInteger("rotation-degrees", b);
                            } else {
                                trackFormat.setInteger("rotation-degrees", b);
                            }
                            if ((this.mOutWidth == 0 || this.mOutHeight == 0) && (b == 90 || b == 270)) {
                                int i = integer2;
                                integer2 = integer;
                                integer = i;
                            }
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            if (!j89.a(extractMetadata)) {
                                this.mSourceVideoDuration = t79.c(extractMetadata, 0L);
                            }
                            this.mLastProgressPercent = 0;
                            String str = e2;
                            if (this.mEncodeHevcVideo) {
                                MediaCodecInfo m2 = z79.m(MimeTypes.VIDEO_H265);
                                str = e2;
                                if (m2 != null) {
                                    m = m2;
                                    str = MimeTypes.VIDEO_H265;
                                }
                            }
                            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, integer, integer2);
                            createVideoFormat.setInteger("color-format", 2130708361);
                            z79.n(trackFormat, createVideoFormat, "bitrate", this.mOutBitRate == 0 ? RecordConstants.DEFAULT_BIT_RATE_GTE_API18 : this.mOutBitRate);
                            z79.n(trackFormat, createVideoFormat, "frame-rate", this.mFrameRate == 0 ? 30 : this.mFrameRate);
                            z79.n(trackFormat, createVideoFormat, "i-frame-interval", 5);
                            AtomicReference atomicReference = new AtomicReference();
                            try {
                                e2 = z79.d(m, createVideoFormat, atomicReference);
                            } catch (Exception unused) {
                                if (integer % 16 != 0) {
                                    integer += 16 - (integer % 16);
                                }
                                if (integer2 % 16 != 0) {
                                    integer2 += 16 - (integer2 % 16);
                                }
                                createVideoFormat.setInteger("width", integer);
                                createVideoFormat.setInteger("height", integer2);
                                e2 = z79.d(m, createVideoFormat, atomicReference);
                            }
                            try {
                                m = new InputSurface((Surface) atomicReference.get());
                                try {
                                    m.makeCurrent();
                                    if (this.mOutputSurface != null) {
                                        this.mOutputSurface.init(integer, integer2);
                                        surface = this.mOutputSurface.getSurface();
                                    } else {
                                        surface = null;
                                    }
                                    mediaCodec2 = z79.c(trackFormat, surface);
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
                                        if (e3 != null) {
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
                            if (e3 != null) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        exc = null;
                        inputSurface = null;
                        mediaCodec2 = null;
                        mediaExtractor = e;
                        mediaCodec = null;
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
            if (e3 != null) {
                throw e3;
            }
        }
    }

    public void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.mRotation = f;
        }
    }
}
