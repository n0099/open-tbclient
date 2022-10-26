package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ci9;
import com.baidu.tieba.mh9;
import com.baidu.tieba.sh9;
import com.baidu.tieba.zh9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, this, mediaExtractor, mediaCodec, mediaCodec2, inputSurface, baseOutputSurface) == null) {
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:125:0x01a8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:167:0x01a0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:180:0x0197 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:184:0x000f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0139 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x013c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0154 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019b A[Catch: Exception -> 0x01a0, TRY_LEAVE, TryCatch #7 {Exception -> 0x01a0, blocks: (B:120:0x0197, B:122:0x019b), top: B:180:0x0197 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface] */
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
        MediaFormat trackFormat;
        int i;
        int i2;
        int i3;
        int i4;
        Surface surface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String e2 = "video/avc";
            MediaCodecInfo m = sh9.m("video/avc");
            if (m == null) {
                return;
            }
            Exception e3 = 0;
            e3 = null;
            e3 = null;
            MediaExtractor mediaExtractor = null;
            try {
                try {
                    e = sh9.b(this.mSourcePath);
                    try {
                        try {
                            trackFormat = e.getTrackFormat(sh9.f(e));
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
                            int b = ((int) (mh9.b(mediaMetadataRetriever.extractMetadata(24), 0) + this.mRotation)) % 360;
                            if (zh9.b) {
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
                            if (!ci9.a(extractMetadata)) {
                                this.mSourceVideoDuration = mh9.c(extractMetadata, 0L);
                            }
                            this.mLastProgressPercent = 0;
                            String str = e2;
                            if (this.mEncodeHevcVideo) {
                                MediaCodecInfo m2 = sh9.m(MimeTypes.VIDEO_H265);
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
                            sh9.n(trackFormat, createVideoFormat, "bitrate", i3);
                            if (this.mFrameRate == 0) {
                                i4 = 30;
                            } else {
                                i4 = this.mFrameRate;
                            }
                            sh9.n(trackFormat, createVideoFormat, "frame-rate", i4);
                            sh9.n(trackFormat, createVideoFormat, "i-frame-interval", 5);
                            AtomicReference atomicReference = new AtomicReference();
                            try {
                                e2 = sh9.d(m, createVideoFormat, atomicReference);
                            } catch (Exception unused) {
                                if (i % 16 != 0) {
                                    i += 16 - (i % 16);
                                }
                                if (i2 % 16 != 0) {
                                    i2 += 16 - (i2 % 16);
                                }
                                createVideoFormat.setInteger("width", i);
                                createVideoFormat.setInteger("height", i2);
                                e2 = sh9.d(m, createVideoFormat, atomicReference);
                            }
                            try {
                                m = new InputSurface((Surface) atomicReference.get());
                            } catch (Exception e4) {
                                mediaCodec2 = null;
                                e3 = e4;
                                m = 0;
                            } catch (Throwable th) {
                                inputSurface = null;
                                mediaCodec2 = null;
                                mediaExtractor = e;
                                mediaCodec = e2;
                                th = th;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            m = 0;
                            mediaCodec2 = null;
                            e = e;
                            e3 = e;
                            e2 = mediaCodec2;
                            e3.printStackTrace();
                            if (e != 0) {
                                try {
                                    e.release();
                                } catch (Exception unused2) {
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception unused3) {
                                }
                            }
                            try {
                                e = this.mOutputSurface;
                                if (e != 0) {
                                    e = this.mOutputSurface;
                                    e.release();
                                }
                            } catch (Exception unused4) {
                            }
                            if (e2 != 0) {
                                try {
                                    e2.stop();
                                    e2.release();
                                } catch (Exception unused5) {
                                }
                            }
                            if (m != 0) {
                                try {
                                    m.release();
                                } catch (Exception unused6) {
                                }
                            }
                            if (e3 == null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        exc = null;
                        inputSurface = null;
                        mediaCodec2 = null;
                        mediaExtractor = e;
                        mediaCodec = null;
                    }
                } catch (Throwable th3) {
                    MediaExtractor mediaExtractor2 = e;
                    mediaCodec = e2;
                    th = th3;
                    inputSurface = m;
                    exc = e3;
                    mediaExtractor = mediaExtractor2;
                }
                try {
                    m.makeCurrent();
                    if (this.mOutputSurface != null) {
                        this.mOutputSurface.init(i, i2);
                        surface = this.mOutputSurface.getSurface();
                    } else {
                        surface = null;
                    }
                    mediaCodec2 = sh9.c(trackFormat, surface);
                    try {
                        doExtractDecodeEditEncodeMux(e, mediaCodec2, e2, m, this.mOutputSurface);
                        if (e != 0) {
                            try {
                                e.release();
                            } catch (Exception e6) {
                                e3 = e6;
                            }
                        }
                        if (mediaCodec2 != null) {
                            try {
                                mediaCodec2.stop();
                                mediaCodec2.release();
                            } catch (Exception e7) {
                                if (e3 == null) {
                                    e3 = e7;
                                }
                            }
                        }
                        try {
                            e = this.mOutputSurface;
                            if (e != 0) {
                                e = this.mOutputSurface;
                                e.release();
                            }
                        } catch (Exception e8) {
                            e = e8;
                            if (e3 == null) {
                                e3 = e;
                            }
                        }
                        if (e2 != 0) {
                            try {
                                e2.stop();
                                e2.release();
                            } catch (Exception e9) {
                                e2 = e9;
                                if (e3 == null) {
                                    e3 = e2;
                                }
                            }
                        }
                        try {
                            m.release();
                        } catch (Exception e10) {
                            e2 = e10;
                            if (e3 == null) {
                                e3 = e2;
                            }
                        }
                    } catch (Exception e11) {
                        e3 = e11;
                        e3.printStackTrace();
                        if (e != 0) {
                        }
                        if (mediaCodec2 != null) {
                        }
                        e = this.mOutputSurface;
                        if (e != 0) {
                        }
                        if (e2 != 0) {
                        }
                        if (m != 0) {
                        }
                        if (e3 == null) {
                        }
                    }
                } catch (Exception e12) {
                    mediaCodec2 = null;
                    e3 = e12;
                } catch (Throwable th4) {
                    mediaCodec2 = null;
                    mediaExtractor = e;
                    mediaCodec = e2;
                    th = th4;
                    inputSurface = m;
                    exc = mediaCodec2;
                    if (mediaExtractor != null) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e13) {
                            if (exc == null) {
                                exc = e13;
                            }
                        }
                    }
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                            mediaCodec2.release();
                        } catch (Exception e14) {
                            if (exc == null) {
                                exc = e14;
                            }
                        }
                    }
                    try {
                        if (this.mOutputSurface != null) {
                            this.mOutputSurface.release();
                        }
                    } catch (Exception e15) {
                        if (exc == null) {
                            exc = e15;
                        }
                    }
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                            mediaCodec.release();
                        } catch (Exception e16) {
                            if (exc == null) {
                            }
                        }
                    }
                    if (inputSurface != null) {
                        try {
                            inputSurface.release();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
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
    }

    public void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.mRotation = f;
        }
    }
}
