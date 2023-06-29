package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.tieba.r1b;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.nio.ByteBuffer;
@TargetApi(18)
/* loaded from: classes8.dex */
public class InnerAudioProcessor extends InnerMediaProcessor {
    public static final String TAG = "InnerAudioProcessor";
    public static final boolean VERBOSE = false;
    public Context mContext;
    public boolean mDoDecode;
    public long mLastPresentationTimeStamp;
    public String mSourcePath;

    public InnerAudioProcessor(Context context, String str, InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super("FilterAudioThread");
        this.mLastPresentationTimeStamp = -1L;
        this.mDoDecode = false;
        this.mContext = context;
        this.mSourcePath = str;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01df A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecodeEditEncodeMux(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MediaCodec mediaCodec2, MediaFormat mediaFormat) {
        boolean z;
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
        boolean z2;
        long j;
        MediaCodec mediaCodec5;
        MediaCodec mediaCodec6;
        int i7;
        MediaFormat mediaFormat2;
        boolean z3;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        boolean z4;
        boolean z5;
        MediaCodec mediaCodec7 = mediaCodec;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        long j2 = 1000;
        int i8 = 0;
        mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
        if (this.mClipPoint + this.mClipDuration != 0) {
            z = true;
        } else {
            z = false;
        }
        ByteBuffer[] byteBufferArr2 = outputBuffers;
        int i9 = -1;
        int i10 = -1;
        boolean z6 = false;
        boolean z7 = false;
        MediaFormat mediaFormat3 = null;
        ByteBuffer[] byteBufferArr3 = null;
        ByteBuffer[] byteBufferArr4 = null;
        MediaFormat mediaFormat4 = null;
        boolean z8 = false;
        while (!z6 && isUnInterrupted()) {
            int i11 = i10;
            if (!z7 && ((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec7.dequeueInputBuffer(10000L)) != -1)) {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i8);
                long sampleTime = mediaExtractor.getSampleTime();
                if (z && sampleTime <= ((this.mClipPoint + this.mClipDuration) * j2) + 100000) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (readSampleData >= 0 && (!z || z4)) {
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
                    if (mediaExtractor.advance() && (!z || z4)) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    }
                    z7 = z5;
                }
            } else {
                i = i9;
                i2 = i11;
                i3 = -1;
                i4 = 1;
            }
            if (!z8 && i == i3 && ((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueOutputBuffer = mediaCodec7.dequeueOutputBuffer(bufferInfo, 10000L)) != i3)) {
                if (dequeueOutputBuffer == -3) {
                    mediaCodec3 = mediaCodec2;
                    byteBufferArr2 = mediaCodec.getOutputBuffers();
                } else {
                    if (dequeueOutputBuffer == -2) {
                        MediaFormat outputFormat = mediaCodec.getOutputFormat();
                        r1b.n(outputFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                        r1b.n(outputFormat, mediaFormat, "channel-count", i4);
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
                            z2 = false;
                            j = 1000;
                        } else {
                            ByteBuffer byteBuffer2 = byteBufferArr3[dequeueInputBuffer2];
                            int i12 = bufferInfo.size;
                            long j3 = bufferInfo.presentationTimeUs;
                            if (i12 >= 0 && j3 >= this.mClipPoint * 1000) {
                                ByteBuffer duplicate = byteBufferArr2[i].duplicate();
                                duplicate.position(bufferInfo.offset);
                                duplicate.limit(bufferInfo.offset + i12);
                                byteBuffer2.position(i5);
                                byteBuffer2.put(duplicate);
                                j = 1000;
                                z2 = false;
                                mediaCodec5 = mediaCodec3;
                                i6 = -2;
                                mediaCodec2.queueInputBuffer(dequeueInputBuffer2, 0, i12, j3 - (this.mClipPoint * 1000), bufferInfo.flags);
                            } else {
                                mediaCodec5 = mediaCodec3;
                                i6 = -2;
                                z2 = false;
                                j = 1000;
                            }
                            mediaCodec4 = mediaCodec;
                            mediaCodec4.releaseOutputBuffer(i, z2);
                            if ((bufferInfo.flags & 4) != 0) {
                                i9 = -1;
                                z8 = true;
                            } else {
                                i9 = -1;
                            }
                            if (z6 && mediaFormat4 != null && ((mediaFormat3 == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
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
                                            mediaCodec5.releaseOutputBuffer(dequeueOutputBuffer2, z2);
                                            mediaCodec6 = mediaCodec5;
                                        } else {
                                            if (bufferInfo2.size != 0 && bufferInfo2.presentationTimeUs > this.mLastPresentationTimeStamp) {
                                                this.mMuxer.writeSampleData(i7, byteBuffer3, bufferInfo2);
                                                this.mLastPresentationTimeStamp = bufferInfo2.presentationTimeUs;
                                            }
                                            if ((bufferInfo2.flags & 4) != 0) {
                                                mediaCodec6 = mediaCodec2;
                                                z3 = false;
                                                z6 = true;
                                            } else {
                                                mediaCodec6 = mediaCodec2;
                                                z3 = false;
                                            }
                                            mediaCodec6.releaseOutputBuffer(dequeueOutputBuffer2, z3);
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
                        z2 = false;
                        j = 1000;
                        mediaCodec5 = mediaCodec3;
                    }
                    i9 = i;
                    if (z6) {
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
            } else {
                mediaCodec3 = mediaCodec2;
            }
            i5 = 0;
            obj = null;
            if (i == i3) {
            }
            mediaCodec4 = mediaCodec7;
            byteBufferArr = inputBuffers;
            i6 = -2;
            z2 = false;
            j = 1000;
            mediaCodec5 = mediaCodec3;
            i9 = i;
            if (z6) {
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
        if (!isUnInterrupted()) {
            onInterrupt();
        }
    }

    private void doExtractMux(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int addTrack = this.mMuxer.addTrack(mediaFormat);
        this.mAddTrack = true;
        int i2 = 0;
        checkMuxerStart(false);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        mediaExtractor.seekTo(this.mClipPoint * 1000, 0);
        if (this.mClipPoint + this.mClipDuration != 0) {
            z = true;
        } else {
            z = false;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        boolean z4 = false;
        while (!z4) {
            int readSampleData = mediaExtractor.readSampleData(allocateDirect, i2);
            long sampleTime = mediaExtractor.getSampleTime();
            if (z && sampleTime <= ((this.mClipPoint + this.mClipDuration) * 1000) + 100000) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && sampleTime >= this.mClipPoint * 1000) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (readSampleData >= 0 && (!z || z2)) {
                if (z && !z3) {
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
            } else {
                i2 = 0;
                if (mediaExtractor.advance() && (!z || z2)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractDecodeEditEncodeMux() throws Exception {
        Exception exc;
        MediaCodec mediaCodec;
        MediaExtractor mediaExtractor;
        MediaCodec mediaCodec2;
        MediaCodec mediaCodec3;
        int integer;
        MediaCodecInfo m = r1b.m("audio/mp4a-latm");
        if (m == null) {
            return;
        }
        MediaExtractor mediaExtractor2 = null;
        e = null;
        e = null;
        Exception e = null;
        try {
            mediaExtractor = r1b.b(this.mSourcePath);
        } catch (Exception e2) {
            mediaCodec = null;
            mediaExtractor = null;
            e = e2;
            mediaCodec2 = null;
        } catch (Throwable th) {
            th = th;
            exc = null;
            mediaCodec = null;
        }
        try {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(r1b.e(mediaExtractor));
            if (this.mDoDecode) {
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", "audio/mp4a-latm");
                mediaFormat.setInteger("aac-profile", 2);
                mediaFormat.setInteger("max-input-size", 8192);
                r1b.n(trackFormat, mediaFormat, "sample-rate", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE);
                r1b.n(trackFormat, mediaFormat, "channel-count", 1);
                r1b.n(trackFormat, mediaFormat, "bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
                mediaCodec2 = MediaCodec.createByCodecName(m.getName());
                try {
                    mediaCodec = r1b.a(trackFormat);
                    try {
                        try {
                            doExtractDecodeEditEncodeMux(mediaExtractor, mediaCodec, mediaCodec2, mediaFormat);
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (mediaExtractor != null) {
                                try {
                                    mediaExtractor.release();
                                } catch (Exception unused) {
                                }
                            }
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.stop();
                                    mediaCodec.release();
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
                            if (e != null) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        MediaExtractor mediaExtractor3 = mediaExtractor;
                        mediaCodec3 = mediaCodec2;
                        exc = e;
                        mediaExtractor2 = mediaExtractor3;
                        if (mediaExtractor2 != null) {
                            try {
                                mediaExtractor2.release();
                            } catch (Exception e4) {
                                if (exc == null) {
                                    exc = e4;
                                }
                            }
                        }
                        if (mediaCodec != null) {
                            try {
                                mediaCodec.stop();
                                mediaCodec.release();
                            } catch (Exception e5) {
                                if (exc == null) {
                                }
                            }
                        }
                        if (mediaCodec3 != null) {
                            try {
                                mediaCodec3.stop();
                                mediaCodec3.release();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    mediaCodec = null;
                } catch (Throwable th3) {
                    th = th3;
                    mediaCodec = null;
                    mediaExtractor2 = mediaExtractor;
                    mediaCodec3 = mediaCodec2;
                    exc = null;
                    if (mediaExtractor2 != null) {
                    }
                    if (mediaCodec != null) {
                    }
                    if (mediaCodec3 != null) {
                    }
                    throw th;
                }
            } else {
                int i = 512000;
                if (trackFormat.containsKey("max-input-size") && (integer = trackFormat.getInteger("max-input-size")) > 0) {
                    i = integer;
                }
                doExtractMux(mediaExtractor, trackFormat, i);
                mediaCodec2 = null;
                mediaCodec = null;
            }
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e7) {
                    e = e7;
                }
            }
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    mediaCodec.release();
                } catch (Exception e8) {
                    if (e == null) {
                        e = e8;
                    }
                }
            }
            if (mediaCodec2 != null) {
                try {
                    mediaCodec2.stop();
                    mediaCodec2.release();
                } catch (Exception e9) {
                    if (e == null) {
                        e = e9;
                    }
                }
            }
        } catch (Exception e10) {
            mediaCodec = null;
            e = e10;
            mediaCodec2 = null;
        } catch (Throwable th4) {
            th = th4;
            exc = null;
            mediaCodec = null;
            mediaExtractor2 = mediaExtractor;
            mediaCodec3 = mediaCodec;
            if (mediaExtractor2 != null) {
            }
            if (mediaCodec != null) {
            }
            if (mediaCodec3 != null) {
            }
            throw th;
        }
        if (e != null) {
            return;
        }
        throw e;
    }
}
