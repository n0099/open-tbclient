package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.tieba.ah9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes6.dex */
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
        int i;
        int i2;
        int i3;
        int i4;
        MediaCodec mediaCodec3;
        Object obj;
        int i5;
        MediaCodec mediaCodec4;
        ByteBuffer[] byteBufferArr;
        int i6;
        boolean z;
        long j;
        MediaCodec mediaCodec5;
        MediaCodec mediaCodec6;
        int i7;
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
            long j2 = 1000;
            int i8 = 0;
            mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
            boolean z3 = this.mClipPoint + this.mClipDuration != 0;
            ByteBuffer[] byteBufferArr2 = outputBuffers;
            int i9 = -1;
            int i10 = -1;
            boolean z4 = false;
            boolean z5 = false;
            MediaFormat mediaFormat3 = null;
            ByteBuffer[] byteBufferArr3 = null;
            ByteBuffer[] byteBufferArr4 = null;
            MediaFormat mediaFormat4 = null;
            boolean z6 = false;
            while (!z4 && isUnInterrupted()) {
                int i11 = i10;
                if (z5 || !((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec7.dequeueInputBuffer(10000L)) != -1)) {
                    i = i9;
                    i2 = i11;
                    i3 = -1;
                    i4 = 1;
                } else {
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i8);
                    long sampleTime = mediaExtractor.getSampleTime();
                    boolean z7 = z3 && sampleTime <= ((this.mClipPoint + this.mClipDuration) * j2) + 100000;
                    if (readSampleData >= 0 && (!z3 || z7)) {
                        i = i9;
                        i2 = i11;
                        i3 = -1;
                        i4 = 1;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                        mediaExtractor.advance();
                    } else {
                        i = i9;
                        i2 = i11;
                        i3 = -1;
                        i4 = 1;
                        boolean z8 = !mediaExtractor.advance() || (z3 && !z7);
                        if (z8) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                        z5 = z8;
                    }
                }
                if (z6 || i != i3 || ((mediaFormat3 != null && !this.mMuxer.isStarted()) || !isUnInterrupted() || (dequeueOutputBuffer = mediaCodec7.dequeueOutputBuffer(bufferInfo, 10000L)) == i3)) {
                    mediaCodec3 = mediaCodec2;
                } else if (dequeueOutputBuffer == -3) {
                    mediaCodec3 = mediaCodec2;
                    byteBufferArr2 = mediaCodec.getOutputBuffers();
                } else {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = mediaCodec.getOutputFormat();
                        ah9.n(outputFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                        ah9.n(outputFormat, mediaFormat, "channel-count", i4);
                        mediaCodec3 = mediaCodec2;
                        obj = null;
                        mediaCodec3.configure(mediaFormat, (Surface) null, (MediaCrypto) null, i4);
                        mediaCodec2.start();
                        ByteBuffer[] inputBuffers2 = mediaCodec2.getInputBuffers();
                        byteBufferArr4 = mediaCodec2.getOutputBuffers();
                        byteBufferArr3 = inputBuffers2;
                        mediaFormat4 = outputFormat;
                        i5 = 0;
                    } else {
                        mediaCodec3 = mediaCodec2;
                        obj = null;
                        ByteBuffer byteBuffer = byteBufferArr2[dequeueOutputBuffer];
                        if ((bufferInfo.flags & 2) != 0) {
                            i5 = 0;
                            mediaCodec7.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            i5 = 0;
                            i = dequeueOutputBuffer;
                        }
                    }
                    if (i == i3 && isUnInterrupted()) {
                        byteBufferArr = inputBuffers;
                        int dequeueInputBuffer2 = mediaCodec3.dequeueInputBuffer(10000L);
                        if (dequeueInputBuffer2 == i3 || byteBufferArr3 == null) {
                            mediaCodec5 = mediaCodec3;
                            mediaCodec4 = mediaCodec7;
                            i6 = -2;
                            z = false;
                            j = 1000;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferArr3[dequeueInputBuffer2];
                            int i12 = bufferInfo.size;
                            long j3 = bufferInfo.presentationTimeUs;
                            if (i12 < 0 || j3 < this.mClipPoint * 1000) {
                                mediaCodec5 = mediaCodec3;
                                i6 = -2;
                                z = false;
                                j = 1000;
                            } else {
                                ByteBuffer duplicate = byteBufferArr2[i].duplicate();
                                duplicate.position(bufferInfo.offset);
                                duplicate.limit(bufferInfo.offset + i12);
                                byteBuffer2.position(i5);
                                byteBuffer2.put(duplicate);
                                j = 1000;
                                z = false;
                                mediaCodec5 = mediaCodec3;
                                i6 = -2;
                                mediaCodec2.queueInputBuffer(dequeueInputBuffer2, 0, i12, j3 - (this.mClipPoint * 1000), bufferInfo.flags);
                            }
                            mediaCodec4 = mediaCodec;
                            mediaCodec4.releaseOutputBuffer(i, z);
                            if ((bufferInfo.flags & 4) != 0) {
                                i9 = -1;
                                z6 = true;
                            } else {
                                i9 = -1;
                            }
                            if (z4 && mediaFormat4 != null && ((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
                                int dequeueOutputBuffer2 = mediaCodec5.dequeueOutputBuffer(bufferInfo2, 10000L);
                                if (dequeueOutputBuffer2 == -1) {
                                    mediaCodec6 = mediaCodec5;
                                    i7 = i2;
                                } else {
                                    if (dequeueOutputBuffer2 == -3) {
                                        byteBufferArr4 = mediaCodec2.getOutputBuffers();
                                        mediaCodec6 = mediaCodec5;
                                        mediaFormat2 = mediaFormat3;
                                        i7 = i2;
                                    } else if (dequeueOutputBuffer2 == i6) {
                                        i7 = i2;
                                        if (i7 >= 0) {
                                            return;
                                        }
                                        mediaFormat2 = mediaCodec2.getOutputFormat();
                                        mediaCodec6 = mediaCodec5;
                                    } else {
                                        i7 = i2;
                                        ByteBuffer byteBuffer3 = byteBufferArr4[dequeueOutputBuffer2];
                                        if ((bufferInfo2.flags & 2) != 0) {
                                            mediaCodec5.releaseOutputBuffer(dequeueOutputBuffer2, z);
                                            mediaCodec6 = mediaCodec5;
                                        } else {
                                            if (bufferInfo2.size != 0 && bufferInfo2.presentationTimeUs > this.mLastPresentationTimeStamp) {
                                                this.mMuxer.writeSampleData(i7, byteBuffer3, bufferInfo2);
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
                                        i7 = this.mMuxer.addTrack(mediaFormat2);
                                        this.mAddTrack = true;
                                    }
                                    checkMuxerStart(false);
                                    mediaCodec7 = mediaCodec4;
                                    mediaFormat3 = mediaFormat2;
                                    i10 = i7;
                                    inputBuffers = byteBufferArr;
                                    j2 = j;
                                    i8 = 0;
                                }
                            } else {
                                mediaCodec6 = mediaCodec5;
                                i7 = i2;
                            }
                            mediaFormat2 = mediaFormat3;
                            if (mediaFormat2 == null) {
                            }
                            checkMuxerStart(false);
                            mediaCodec7 = mediaCodec4;
                            mediaFormat3 = mediaFormat2;
                            i10 = i7;
                            inputBuffers = byteBufferArr;
                            j2 = j;
                            i8 = 0;
                        }
                    } else {
                        mediaCodec4 = mediaCodec7;
                        byteBufferArr = inputBuffers;
                        i6 = -2;
                        z = false;
                        j = 1000;
                        mediaCodec5 = mediaCodec3;
                    }
                    i9 = i;
                    if (z4) {
                    }
                    mediaCodec6 = mediaCodec5;
                    i7 = i2;
                    mediaFormat2 = mediaFormat3;
                    if (mediaFormat2 == null) {
                    }
                    checkMuxerStart(false);
                    mediaCodec7 = mediaCodec4;
                    mediaFormat3 = mediaFormat2;
                    i10 = i7;
                    inputBuffers = byteBufferArr;
                    j2 = j;
                    i8 = 0;
                }
                i5 = 0;
                obj = null;
                if (i == i3) {
                }
                mediaCodec4 = mediaCodec7;
                byteBufferArr = inputBuffers;
                i6 = -2;
                z = false;
                j = 1000;
                mediaCodec5 = mediaCodec3;
                i9 = i;
                if (z4) {
                }
                mediaCodec6 = mediaCodec5;
                i7 = i2;
                mediaFormat2 = mediaFormat3;
                if (mediaFormat2 == null) {
                }
                checkMuxerStart(false);
                mediaCodec7 = mediaCodec4;
                mediaFormat3 = mediaFormat2;
                i10 = i7;
                inputBuffers = byteBufferArr;
                j2 = j;
                i8 = 0;
            }
            if (isUnInterrupted()) {
                return;
            }
            onInterrupt();
        }
    }

    private void doExtractMux(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, mediaExtractor, mediaFormat, i) == null) {
            int addTrack = this.mMuxer.addTrack(mediaFormat);
            this.mAddTrack = true;
            int i2 = 0;
            checkMuxerStart(false);
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
            boolean z = this.mClipPoint + this.mClipDuration != 0;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
            boolean z2 = false;
            while (!z2) {
                int readSampleData = mediaExtractor.readSampleData(allocateDirect, i2);
                long sampleTime = mediaExtractor.getSampleTime();
                boolean z3 = z && sampleTime <= ((this.mClipPoint + this.mClipDuration) * 1000) + 100000;
                boolean z4 = z && sampleTime >= this.mClipPoint * 1000;
                if (readSampleData < 0 || (z && !z3)) {
                    i2 = 0;
                    z2 = !mediaExtractor.advance() || (z && !z3);
                } else if (z && !z4) {
                    mediaExtractor.advance();
                    i2 = 0;
                } else {
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() - (this.mClipPoint * 1000);
                    bufferInfo.size = readSampleData;
                    i2 = 0;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (m = ah9.m("audio/mp4a-latm")) == 0) {
            return;
        }
        MediaExtractor mediaExtractor3 = null;
        e = null;
        Exception e = null;
        try {
            try {
                mediaExtractor = ah9.b(this.mSourcePath);
            } catch (Throwable th) {
                th = th;
                mediaCodec4 = "audio/mp4a-latm";
                exc = null;
                mediaExtractor3 = mediaExtractor2;
                mediaCodec5 = m;
            }
            try {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(ah9.e(mediaExtractor));
                if (this.mDoDecode) {
                    MediaFormat mediaFormat = new MediaFormat();
                    mediaFormat.setString("mime", "audio/mp4a-latm");
                    mediaFormat.setInteger("aac-profile", 2);
                    mediaFormat.setInteger("max-input-size", 8192);
                    ah9.n(trackFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                    ah9.n(trackFormat, mediaFormat, "channel-count", 1);
                    ah9.n(trackFormat, mediaFormat, "bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
                    mediaCodec3 = MediaCodec.createByCodecName(m.getName());
                    try {
                        mediaCodec2 = ah9.a(trackFormat);
                        try {
                            doExtractDecodeEditEncodeMux(mediaExtractor, mediaCodec2, mediaCodec3, mediaFormat);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
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
                            if (e == null) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
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
                    int i = 512000;
                    if (trackFormat.containsKey("max-input-size") && (integer = trackFormat.getInteger("max-input-size")) > 0) {
                        i = integer;
                    }
                    doExtractMux(mediaExtractor, trackFormat, i);
                    mediaCodec3 = null;
                    mediaCodec2 = null;
                }
                if (mediaExtractor != null) {
                    try {
                        mediaExtractor.release();
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.stop();
                        mediaCodec2.release();
                    } catch (Exception e5) {
                        if (e == null) {
                            e = e5;
                        }
                    }
                }
                if (mediaCodec3 != null) {
                    try {
                        mediaCodec3.stop();
                        mediaCodec3.release();
                    } catch (Exception e6) {
                        if (e == null) {
                            e = e6;
                        }
                    }
                }
            } catch (Exception e7) {
                mediaCodec2 = null;
                e = e7;
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
                    } catch (Exception e8) {
                        if (exc == null) {
                            exc = e8;
                        }
                    }
                }
                if (mediaCodec5 != null) {
                    try {
                        mediaCodec5.stop();
                        mediaCodec5.release();
                    } catch (Exception e9) {
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
        } catch (Exception e10) {
            mediaCodec2 = null;
            mediaExtractor = null;
            e = e10;
            mediaCodec3 = null;
        } catch (Throwable th4) {
            th = th4;
            exc = null;
            mediaCodec = null;
        }
        if (e == null) {
            throw e;
        }
    }
}
