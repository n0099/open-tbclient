package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import c.a.v0.t.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class InnerAudioProcessor extends InnerMediaProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InnerAudioProcessor";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mDoDecode;
    public long mLastPresentationTimeStamp;
    public String mSourcePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerAudioProcessor(Context context, String str, InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super("FilterAudioThread");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, innerMuxerWrapper, onGenFilterVideoListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastPresentationTimeStamp = -1L;
        this.mDoDecode = false;
        this.mContext = context;
        this.mSourcePath = str;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e3 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecodeEditEncodeMux(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, MediaFormat mediaFormat) {
        int i2;
        int i3;
        int i4;
        int i5;
        MediaCodec mediaCodec3;
        Object obj;
        int i6;
        MediaCodec mediaCodec4;
        ByteBuffer[] byteBufferArr;
        int i7;
        boolean z;
        long j2;
        MediaCodec mediaCodec5;
        MediaCodec mediaCodec6;
        int i8;
        MediaFormat mediaFormat2;
        boolean z2;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, this, mediaExtractor, mediaCodec, mediaCodec2, mediaFormat) == null) {
            MediaCodec mediaCodec7 = mediaCodec;
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            long j3 = 1000;
            int i9 = 0;
            mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
            boolean z3 = this.mClipPoint + this.mClipDuration != 0;
            ByteBuffer[] byteBufferArr2 = outputBuffers;
            int i10 = -1;
            int i11 = -1;
            boolean z4 = false;
            boolean z5 = false;
            MediaFormat mediaFormat3 = null;
            ByteBuffer[] byteBufferArr3 = null;
            ByteBuffer[] byteBufferArr4 = null;
            MediaFormat mediaFormat4 = null;
            boolean z6 = false;
            while (!z4 && isUnInterrupted()) {
                int i12 = i11;
                if (z5 || !((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec7.dequeueInputBuffer(10000L)) != -1)) {
                    i2 = i10;
                    i3 = i12;
                    i4 = -1;
                    i5 = 1;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i9);
                    long sampleTime = mediaExtractor.getSampleTime();
                    boolean z7 = z3 && sampleTime <= ((this.mClipPoint + this.mClipDuration) * j3) + 100000;
                    if (readSampleData >= 0 && (!z3 || z7)) {
                        i2 = i10;
                        i3 = i12;
                        i4 = -1;
                        i5 = 1;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                        mediaExtractor.advance();
                    } else {
                        i2 = i10;
                        i3 = i12;
                        i4 = -1;
                        i5 = 1;
                        boolean z8 = !mediaExtractor.advance() || (z3 && !z7);
                        if (z8) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                        z5 = z8;
                    }
                }
                if (z6 || i2 != i4 || ((mediaFormat3 != null && !this.mMuxer.isStarted()) || !isUnInterrupted() || (dequeueOutputBuffer = mediaCodec7.dequeueOutputBuffer(bufferInfo, 10000L)) == i4)) {
                    mediaCodec3 = mediaCodec2;
                } else if (dequeueOutputBuffer == -3) {
                    mediaCodec3 = mediaCodec2;
                    byteBufferArr2 = mediaCodec.getOutputBuffers();
                } else {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = mediaCodec.getOutputFormat();
                        m.n(outputFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                        m.n(outputFormat, mediaFormat, "channel-count", i5);
                        mediaCodec3 = mediaCodec2;
                        obj = null;
                        mediaCodec3.configure(mediaFormat, (Surface) null, (MediaCrypto) null, i5);
                        mediaCodec2.start();
                        ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
                        byteBufferArr4 = mediaCodec2.getOutputBuffers();
                        byteBufferArr3 = inputBuffers2;
                        mediaFormat4 = outputFormat;
                        i6 = 0;
                    } else {
                        mediaCodec3 = mediaCodec2;
                        obj = null;
                        ByteBuffer byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                        if ((bufferInfo.flags & 2) != 0) {
                            i6 = 0;
                            mediaCodec7.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            i6 = 0;
                            i2 = dequeueOutputBuffer;
                        }
                    }
                    if (i2 == i4 && isUnInterrupted()) {
                        byteBufferArr = inputBuffers;
                        int dequeueInputBuffer2 = mediaCodec3.dequeueInputBuffer(10000L);
                        if (dequeueInputBuffer2 == i4 || byteBufferArr3 == null) {
                            mediaCodec5 = mediaCodec3;
                            mediaCodec4 = mediaCodec7;
                            i7 = -2;
                            z = false;
                            j2 = 1000;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferArr3[dequeueInputBuffer2];
                            int i13 = bufferInfo.size;
                            long j4 = bufferInfo.presentationTimeUs;
                            if (i13 < 0 || j4 < this.mClipPoint * 1000) {
                                mediaCodec5 = mediaCodec3;
                                i7 = -2;
                                z = false;
                                j2 = 1000;
                            } else {
                                ByteBuffer duplicate = byteBufferArr2[i2].duplicate();
                                duplicate.position(bufferInfo.offset);
                                duplicate.limit(bufferInfo.offset + i13);
                                byteBuffer2.position(i6);
                                byteBuffer2.put(duplicate);
                                j2 = 1000;
                                z = false;
                                mediaCodec5 = mediaCodec3;
                                i7 = -2;
                                mediaCodec2.queueInputBuffer(dequeueInputBuffer2, 0, i13, j4 - (this.mClipPoint * 1000), bufferInfo.flags);
                            }
                            mediaCodec4 = mediaCodec;
                            mediaCodec4.releaseOutputBuffer(i2, z);
                            if ((bufferInfo.flags & 4) != 0) {
                                i10 = -1;
                                z6 = true;
                            } else {
                                i10 = -1;
                            }
                            if (z4 && mediaFormat4 != null && ((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
                                int dequeueOutputBuffer2 = mediaCodec5.dequeueOutputBuffer(bufferInfo2, 10000L);
                                if (dequeueOutputBuffer2 == -1) {
                                    mediaCodec6 = mediaCodec5;
                                    i8 = i3;
                                } else {
                                    if (dequeueOutputBuffer2 == -3) {
                                        byteBufferArr4 = mediaCodec2.getOutputBuffers();
                                        mediaCodec6 = mediaCodec5;
                                        mediaFormat2 = mediaFormat3;
                                        i8 = i3;
                                    } else if (dequeueOutputBuffer2 == i7) {
                                        i8 = i3;
                                        if (i8 >= 0) {
                                            return;
                                        }
                                        mediaFormat2 = mediaCodec2.getOutputFormat();
                                        mediaCodec6 = mediaCodec5;
                                    } else {
                                        i8 = i3;
                                        ByteBuffer byteBuffer3 = byteBufferArr4[dequeueOutputBuffer2];
                                        if ((bufferInfo2.flags & 2) != 0) {
                                            mediaCodec5.releaseOutputBuffer(dequeueOutputBuffer2, z);
                                            mediaCodec6 = mediaCodec5;
                                        } else {
                                            if (bufferInfo2.size != 0 && bufferInfo2.presentationTimeUs > this.mLastPresentationTimeStamp) {
                                                this.mMuxer.writeSampleData(i8, byteBuffer3, bufferInfo2);
                                                this.mLastPresentationTimeStamp = bufferInfo2.presentationTimeUs;
                                            }
                                            if ((bufferInfo2.flags & 4) != 0) {
                                                mediaCodec6 = mediaCodec2;
                                                z2 = false;
                                                z4 = true;
                                            } else {
                                                mediaCodec6 = mediaCodec2;
                                                z2 = false;
                                            }
                                            mediaCodec6.releaseOutputBuffer(dequeueOutputBuffer2, z2);
                                        }
                                    }
                                    if (mediaFormat2 == null && !this.mAddTrack) {
                                        log(TAG, "muxer: adding audio track.");
                                        i8 = this.mMuxer.addTrack(mediaFormat2);
                                        this.mAddTrack = true;
                                    }
                                    checkMuxerStart(false);
                                    mediaCodec7 = mediaCodec4;
                                    mediaFormat3 = mediaFormat2;
                                    i11 = i8;
                                    inputBuffers = byteBufferArr;
                                    j3 = j2;
                                    i9 = 0;
                                }
                            } else {
                                mediaCodec6 = mediaCodec5;
                                i8 = i3;
                            }
                            mediaFormat2 = mediaFormat3;
                            if (mediaFormat2 == null) {
                            }
                            checkMuxerStart(false);
                            mediaCodec7 = mediaCodec4;
                            mediaFormat3 = mediaFormat2;
                            i11 = i8;
                            inputBuffers = byteBufferArr;
                            j3 = j2;
                            i9 = 0;
                        }
                    } else {
                        mediaCodec4 = mediaCodec7;
                        byteBufferArr = inputBuffers;
                        i7 = -2;
                        z = false;
                        j2 = 1000;
                        mediaCodec5 = mediaCodec3;
                    }
                    i10 = i2;
                    if (z4) {
                    }
                    mediaCodec6 = mediaCodec5;
                    i8 = i3;
                    mediaFormat2 = mediaFormat3;
                    if (mediaFormat2 == null) {
                    }
                    checkMuxerStart(false);
                    mediaCodec7 = mediaCodec4;
                    mediaFormat3 = mediaFormat2;
                    i11 = i8;
                    inputBuffers = byteBufferArr;
                    j3 = j2;
                    i9 = 0;
                }
                i6 = 0;
                obj = null;
                if (i2 == i4) {
                }
                mediaCodec4 = mediaCodec7;
                byteBufferArr = inputBuffers;
                i7 = -2;
                z = false;
                j2 = 1000;
                mediaCodec5 = mediaCodec3;
                i10 = i2;
                if (z4) {
                }
                mediaCodec6 = mediaCodec5;
                i8 = i3;
                mediaFormat2 = mediaFormat3;
                if (mediaFormat2 == null) {
                }
                checkMuxerStart(false);
                mediaCodec7 = mediaCodec4;
                mediaFormat3 = mediaFormat2;
                i11 = i8;
                inputBuffers = byteBufferArr;
                j3 = j2;
                i9 = 0;
            }
            if (isUnInterrupted()) {
                return;
            }
            onInterrupt();
        }
    }

    private void doExtractMux(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, mediaExtractor, mediaFormat, i2) == null) {
            int addTrack = this.mMuxer.addTrack(mediaFormat);
            this.mAddTrack = true;
            int i3 = 0;
            checkMuxerStart(false);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
            boolean z = this.mClipPoint + this.mClipDuration != 0;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
            boolean z2 = false;
            while (!z2) {
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, i3);
                long sampleTime = mediaExtractor.getSampleTime();
                boolean z3 = z && sampleTime <= ((this.mClipPoint + this.mClipDuration) * 1000) + 100000;
                boolean z4 = z && sampleTime >= this.mClipPoint * 1000;
                if (readSampleData < 0 || (z && !z3)) {
                    i3 = 0;
                    z2 = !mediaExtractor.advance() || (z && !z3);
                } else if (z && !z4) {
                    mediaExtractor.advance();
                    i3 = 0;
                } else {
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() - (this.mClipPoint * 1000);
                    bufferInfo.size = readSampleData;
                    i3 = 0;
                    bufferInfo.offset = 0;
                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                    mediaExtractor.advance();
                    this.mMuxer.writeSampleData(addTrack, allocateDirect, bufferInfo);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.media.MediaCodecInfo */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00d5: MOVE  (r8 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:68:0x00d5 */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractDecodeEditEncodeMux() throws Exception {
        MediaCodecInfo m;
        Exception exc;
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec3;
        MediaExtractor mediaExtractor2;
        MediaCodec mediaCodec4;
        MediaCodec mediaCodec5;
        int integer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (m = m.m("audio/mp4a-latm")) == 0) {
            return;
        }
        MediaExtractor mediaExtractor3 = null;
        e = null;
        Exception e2 = null;
        try {
            try {
                mediaExtractor = m.b(this.mSourcePath);
            } catch (Throwable th) {
                th = th;
                mediaCodec4 = "audio/mp4a-latm";
                exc = null;
                mediaExtractor3 = mediaExtractor2;
                mediaCodec5 = m;
            }
            try {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(m.e(mediaExtractor));
                if (this.mDoDecode) {
                    MediaFormat mediaFormat = new MediaFormat();
                    mediaFormat.setString("mime", "audio/mp4a-latm");
                    mediaFormat.setInteger("aac-profile", 2);
                    mediaFormat.setInteger("max-input-size", 8192);
                    m.n(trackFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                    m.n(trackFormat, mediaFormat, "channel-count", 1);
                    m.n(trackFormat, mediaFormat, "bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
                    mediaCodec3 = MediaCodec.createByCodecName(m.getName());
                    try {
                        mediaCodec2 = m.a(trackFormat);
                        try {
                            doExtractDecodeEditEncodeMux(mediaExtractor, mediaCodec2, mediaCodec3, mediaFormat);
                        } catch (Exception e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception unused) {
                                }
                            }
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.stop();
                                    mediaCodec2.release();
                                } catch (Exception unused2) {
                                }
                            }
                            if (mediaCodec3 != null) {
                                try {
                                    mediaCodec3.stop();
                                    mediaCodec3.release();
                                } catch (Exception unused3) {
                                }
                            }
                            if (e2 == null) {
                            }
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        mediaCodec2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaCodec5 = null;
                        mediaExtractor3 = mediaExtractor;
                        mediaCodec4 = mediaCodec3;
                        exc = null;
                        if (mediaExtractor3 != null) {
                        }
                        if (mediaCodec5 != null) {
                        }
                        if (mediaCodec4 != null) {
                        }
                        throw th;
                    }
                } else {
                    int i2 = 512000;
                    if (trackFormat.containsKey("max-input-size") && (integer = trackFormat.getInteger("max-input-size")) > 0) {
                        i2 = integer;
                    }
                    doExtractMux(mediaExtractor, trackFormat, i2);
                    mediaCodec3 = null;
                    mediaCodec2 = null;
                }
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e5) {
                        e2 = e5;
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e6) {
                        if (e2 == null) {
                            e2 = e6;
                        }
                    }
                }
                if (mediaCodec3 != null) {
                    try {
                        mediaCodec3.stop();
                        mediaCodec3.release();
                    } catch (Exception e7) {
                        if (e2 == null) {
                            e2 = e7;
                        }
                    }
                }
            } catch (Exception e8) {
                mediaCodec2 = null;
                e2 = e8;
                mediaCodec3 = null;
            } catch (Throwable th3) {
                th = th3;
                exc = null;
                mediaCodec = null;
                mediaExtractor3 = mediaExtractor;
                mediaCodec4 = mediaCodec;
                mediaCodec5 = mediaCodec;
                if (mediaExtractor3 != null) {
                    try {
                        mediaExtractor3.release();
                    } catch (Exception e9) {
                        if (exc == null) {
                            exc = e9;
                        }
                    }
                }
                if (mediaCodec5 != null) {
                    try {
                        mediaCodec5.stop();
                        mediaCodec5.release();
                    } catch (Exception e10) {
                        if (exc == null) {
                        }
                    }
                }
                if (mediaCodec4 != null) {
                    try {
                        mediaCodec4.stop();
                        mediaCodec4.release();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception e11) {
            mediaCodec2 = null;
            mediaExtractor = null;
            e2 = e11;
            mediaCodec3 = null;
        } catch (Throwable th4) {
            th = th4;
            exc = null;
            mediaCodec = null;
        }
        if (e2 == null) {
            throw e2;
        }
    }
}
