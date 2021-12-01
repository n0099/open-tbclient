package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import c.a.a0.b.a.g;
import c.a.x0.t.c;
import c.a.x0.t.h;
import c.a.x0.t.m;
import c.a.x0.t.u;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes11.dex */
public class InnerMultiMediaProcessor extends InnerMediaProcessor implements IMultiMediaDataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InnerMultiMediaProcessor";
    public static final int TIMEOUT_USEC = 10000;
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentIndex;
    public MediaTrackConfig mEditTrackConfig;
    public boolean mFrameAvailable;
    public boolean mFrameSkip;
    public int mLogDecoderCount;
    public long mPlayTime;
    public NewSubTitleCreater mSubTitleCreater;
    public List<SubTitleUnit> mSubTitleUnits;
    public List<MultiMediaDataTrack> mediaDataTracks;
    public List<MediaTrack> mediaTracks;
    public Map<String, ShaderConfig> shaderConfigMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerMultiMediaProcessor(InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super(TAG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {innerMuxerWrapper, onGenFilterVideoListener};
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
        this.mFrameAvailable = false;
        this.mFrameSkip = false;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    private void collectMediaCodecInstances(StringBuilder sb) {
        MediaCodecInfo[] codecInfos;
        String[] supportedTypes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, sb) == null) || Build.VERSION.SDK_INT < 23 || (codecInfos = new MediaCodecList(0).getCodecInfos()) == null) {
            return;
        }
        for (int i2 = 0; i2 < codecInfos.length; i2++) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i2];
            if (mediaCodecInfo != null && (supportedTypes = mediaCodecInfo.getSupportedTypes()) != null) {
                for (int i3 = 0; i3 < supportedTypes.length; i3++) {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(supportedTypes[i3]);
                    if (capabilitiesForType != null && (supportedTypes[i3].equals("video/avc") || supportedTypes[i3].equals("video/hevc"))) {
                        sb.append(" -- maxInstances : " + capabilitiesForType.getMaxSupportedInstances() + " type : " + supportedTypes[i3] + " j : " + i3 + " i : " + i2 + " isEncoder : " + mediaCodecInfo.isEncoder() + " name : " + mediaCodecInfo.getName() + ",");
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0016 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x000f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.media.MediaFormat] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createDecoder(MultiMediaData multiMediaData, BaseOutputSurface baseOutputSurface) throws IOException {
        MediaExtractor mediaExtractor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, this, multiMediaData, baseOutputSurface) == null) && multiMediaData.type != 0 && multiMediaData.videoDecoder == null) {
            FileInputStream fileInputStream = 0;
            try {
                try {
                    mediaExtractor = m.b(multiMediaData.path);
                } catch (Exception unused) {
                    MediaExtractor mediaExtractor2 = new MediaExtractor();
                    FileInputStream fileInputStream2 = new FileInputStream(new File(multiMediaData.path));
                    try {
                        mediaExtractor2.setDataSource(fileInputStream2.getFD());
                        fileInputStream2.close();
                        mediaExtractor = mediaExtractor2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != 0) {
                        }
                        throw th;
                    }
                }
                multiMediaData.videoExtractor = mediaExtractor;
                fileInputStream = multiMediaData.videoExtractor.getTrackFormat(m.f(mediaExtractor));
                multiMediaData.videoExtractor.seekTo(multiMediaData.start * 1000, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(multiMediaData.textureId);
                multiMediaData.surfaceTexture = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(baseOutputSurface);
                Surface surface = new Surface(multiMediaData.surfaceTexture);
                multiMediaData.surface = surface;
                multiMediaData.videoDecoder = m.c(fileInputStream, surface);
                this.mLogDecoderCount++;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != 0) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
        if (r4 < (r27.start * 1000)) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecode(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MultiMediaData multiMediaData, MediaSegment mediaSegment, MediaFormat mediaFormat) {
        boolean z;
        int i2;
        long j2;
        long j3;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, mediaExtractor, mediaCodec, multiMediaData, mediaSegment, mediaFormat) == null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            long j4 = multiMediaData.offset * 1000;
            if (multiMediaData.videoExtractorDone || !((mediaFormat == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) != -1)) {
                z = true;
                i2 = -1;
            } else {
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                long sampleTime = mediaExtractor.getSampleTime();
                if (readSampleData >= 0) {
                    z = true;
                    i2 = -1;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                    mediaExtractor.advance();
                } else {
                    z = true;
                    i2 = -1;
                    boolean z2 = !mediaExtractor.advance();
                    multiMediaData.videoExtractorDone = z2;
                    if (z2) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    }
                }
            }
            if (!multiMediaData.videoDecoderDone && ((mediaFormat == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer != i2) {
                    if (dequeueOutputBuffer == -3) {
                        mediaCodec.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        mediaCodec.getOutputFormat();
                    } else {
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if ((bufferInfo.flags & 2) != 0) {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            boolean z3 = bufferInfo.size != 0;
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z3);
                            c.e(TAG, "videoDecoderRender:" + z3);
                            if (z3) {
                                long j5 = bufferInfo.presentationTimeUs;
                                long j6 = j5 > 0 ? 1000L : 1000L;
                                if (bufferInfo.presentationTimeUs > 0) {
                                    j4 += (((float) (j3 - (multiMediaData.start * j6))) * 1.0f) / multiMediaData.getCurrentSpeed();
                                }
                                this.mFrameSkip = false;
                                multiMediaData.currentPts = j4;
                                if (multiMediaData.loop) {
                                    j4 += multiMediaData.basePts;
                                }
                                log(TAG, "decode 2: -------------------refreshcurrentPts ----- " + j4 + " flags ：" + bufferInfo.flags + " mPlayTime : " + this.mPlayTime + " pts : " + bufferInfo.presentationTimeUs + " basePts : " + multiMediaData.basePts + "------------");
                                StringBuilder sb = new StringBuilder();
                                sb.append("refreshcurrentPts:");
                                sb.append(j4);
                                sb.append(" mPlayTime ：");
                                sb.append(this.mPlayTime);
                                c.e(TAG, sb.toString());
                                if (j4 >= this.mPlayTime * 1000) {
                                    notifyFrameAvailable();
                                    j2 = 1000;
                                } else if (mediaSegment.start * 1000 == j4 && bufferInfo.flags == z) {
                                    notifyFrameAvailable();
                                } else {
                                    notifyFrameSkip();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("当前帧率过高，正在丢帧，");
                                    sb2.append(j4);
                                    sb2.append(",");
                                    j2 = 1000;
                                    sb2.append(this.mPlayTime * 1000);
                                    c.e(TAG, sb2.toString());
                                }
                                if (bufferInfo.presentationTimeUs >= multiMediaData.end * j2) {
                                    notifyFrameAvailable();
                                    multiMediaData.videoDecoderDone = z;
                                }
                                if ((bufferInfo.flags & 4) != 0) {
                                    notifyFrameAvailable();
                                    multiMediaData.videoDecoderDone = z;
                                }
                            }
                            j2 = 1000;
                            if (bufferInfo.presentationTimeUs >= multiMediaData.end * j2) {
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                            }
                        }
                    }
                }
                notifyFrameSkip();
            }
            if (multiMediaData.videoDecoderDone) {
                notifyFrameAvailable();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0266, code lost:
        if (isUnInterrupted() != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0268, code lost:
        onInterrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractEncodeMux(MediaCodec mediaCodec, InputSurface inputSurface, BaseOutputSurface baseOutputSurface) throws Exception {
        boolean z;
        boolean z2;
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaCodec, inputSurface, baseOutputSurface) != null) {
            return;
        }
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long currentTimeMillis = System.currentTimeMillis();
        if (getMultiMediaDataTrack() != null && getUpdateMediaTracks() != null && getUpdateMediaTracks().size() == getMultiMediaDataTrack().size()) {
            int i3 = 0;
            while (i3 < getMultiMediaDataTrack().size()) {
                MultiMediaDataTrack multiMediaDataTrack = getMultiMediaDataTrack().get(i3);
                MediaTrack mediaTrack = getUpdateMediaTracks().get(i3);
                if (mediaTrack.mediaSegments != null) {
                    int i4 = 0;
                    while (i4 < mediaTrack.mediaSegments.size()) {
                        MultiMediaData multiMediaData = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, i4);
                        MediaSegment mediaSegment3 = (MediaSegment) h.c(mediaTrack.mediaSegments, i4);
                        if (mediaSegment3 == null || multiMediaData == null) {
                            i2 = i3;
                        } else {
                            i2 = i3;
                            long j2 = mediaSegment3.start;
                            multiMediaData.offset = j2;
                            multiMediaData.currentPts = j2 * 1000;
                        }
                        i4++;
                        i3 = i2;
                    }
                }
                int i5 = i3;
                MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
                if (multiMediaData2 != null && (mediaSegment2 = mediaTrack.superpositionHeader) != null) {
                    long j3 = mediaSegment2.start;
                    multiMediaData2.offset = j3;
                    multiMediaData2.currentPts = j3 * 1000;
                }
                MultiMediaData multiMediaData3 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
                if (multiMediaData3 != null && (mediaSegment = mediaTrack.superpositionFooter) != null) {
                    long j4 = mediaSegment.start;
                    multiMediaData3.offset = j4;
                    multiMediaData3.currentPts = j4 * 1000;
                }
                i3 = i5 + 1;
            }
            int i6 = -1;
            MediaFormat mediaFormat = null;
            boolean z3 = false;
            boolean z4 = false;
            int i7 = -1;
            long j5 = 0;
            while (true) {
                if (z4 || !isUnInterrupted()) {
                    break;
                } else if (System.currentTimeMillis() - currentTimeMillis > 10000) {
                    onPlayEnd();
                    throw new RuntimeException("doEncode timeout1 10000 ms");
                } else {
                    if (this.mPlayTime <= getDuration() && !z3) {
                        int updateTimeline = MultiDataSourceUtil.updateTimeline(getInputTrack(), getInputMultiMediaData(), this.mPlayTime);
                        if (updateTimeline == i6) {
                            updateTimeline = 0;
                        }
                        this.mCurrentIndex = updateTimeline;
                        int i8 = 0;
                        while (i8 < getMultiMediaDataTrack().size()) {
                            MultiMediaDataTrack multiMediaDataTrack2 = getMultiMediaDataTrack().get(i8);
                            MediaTrack mediaTrack2 = getUpdateMediaTracks().get(i8);
                            if (mediaTrack2.mediaSegments != null) {
                                int i9 = 0;
                                while (i9 < mediaTrack2.mediaSegments.size()) {
                                    MultiMediaData multiMediaData4 = (MultiMediaData) h.c(multiMediaDataTrack2.multiMediaDataList, i9);
                                    long j6 = currentTimeMillis;
                                    MediaSegment mediaSegment4 = (MediaSegment) h.c(mediaTrack2.mediaSegments, i9);
                                    if (multiMediaData4 != null && mediaSegment4 != null) {
                                        extractDecode(multiMediaData4, mediaSegment4, mediaFormat, baseOutputSurface);
                                    }
                                    i9++;
                                    currentTimeMillis = j6;
                                }
                            }
                            extractDecode(multiMediaDataTrack2.multiMediaDataSuperpositionHeader, mediaTrack2.superpositionHeader, mediaFormat, baseOutputSurface);
                            extractDecode(multiMediaDataTrack2.multiMediaDataSuperpositionFooter, mediaTrack2.superpositionFooter, mediaFormat, baseOutputSurface);
                            i8++;
                            currentTimeMillis = currentTimeMillis;
                        }
                    }
                    long j7 = currentTimeMillis;
                    if (this.mFrameAvailable) {
                        System.currentTimeMillis();
                        baseOutputSurface.awaitNewImage();
                        baseOutputSurface.drawImage((int) this.mPlayTime);
                        inputSurface.setPresentationTime(this.mPlayTime * 1000 * 1000);
                        inputSurface.swapBuffers();
                        if (this.mPlayTime >= getDuration() && !z3) {
                            mediaCodec.signalEndOfInputStream();
                            z3 = true;
                        }
                        boolean z5 = this.mPlayTime < getDuration();
                        long j8 = (long) (this.mPlayTime + ((1.0d / this.mFrameRate) * 1000.0d));
                        this.mPlayTime = j8;
                        if (j8 >= getDuration() && z5) {
                            this.mPlayTime = getDuration();
                        }
                    }
                    if ((mediaFormat == null || this.mMuxer.isStarted()) && isUnInterrupted()) {
                        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (dequeueOutputBuffer != -1) {
                            if (dequeueOutputBuffer == -3) {
                                outputBuffers = mediaCodec.getOutputBuffers();
                            } else if (dequeueOutputBuffer != -2) {
                                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                                if ((bufferInfo.flags & 2) != 0) {
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                } else {
                                    if (bufferInfo.size != 0) {
                                        if (j5 == 0) {
                                            j5 = bufferInfo.presentationTimeUs;
                                        }
                                        int duration = (int) ((bufferInfo.presentationTimeUs - j5) / (getDuration() * 10));
                                        if (duration > 0 && duration < 100) {
                                            onProgress(duration);
                                        }
                                        this.mMuxer.writeSampleData(i7, byteBuffer, bufferInfo);
                                    }
                                    if ((bufferInfo.flags & 4) != 0) {
                                        z = false;
                                        z4 = true;
                                    } else {
                                        z = false;
                                    }
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z);
                                }
                            } else if (i7 >= 0) {
                                return;
                            } else {
                                mediaFormat = mediaCodec.getOutputFormat();
                            }
                        }
                    }
                    if (isUnInterrupted()) {
                        if (mediaFormat == null || this.mAddTrack) {
                            z2 = true;
                        } else {
                            i7 = this.mMuxer.addTrack(mediaFormat);
                            z2 = true;
                            this.mAddTrack = true;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (z4) {
                            onPlayEnd();
                            onProgress(100);
                            break;
                        }
                        checkMuxerStart(z2);
                        currentTimeMillis = currentTimeMillis2;
                    } else {
                        currentTimeMillis = j7;
                    }
                    this.mFrameAvailable = false;
                    i6 = -1;
                }
            }
        } else if (this.mListener != null) {
            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMultiMediaProcessor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InnerMultiMediaProcessor this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i10 = newInitContext.flag;
                        if ((i10 & 1) != 0) {
                            int i11 = i10 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    OnGenFilterVideoListener onGenFilterVideoListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (onGenFilterVideoListener = this.this$0.mListener) == null) {
                        return;
                    }
                    onGenFilterVideoListener.onGenFilterVideoFail(-3, "data size error!!!");
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r13 >= r2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void extractDecode(MultiMediaData multiMediaData, MediaSegment mediaSegment, MediaFormat mediaFormat, BaseOutputSurface baseOutputSurface) throws Exception {
        SubTitleUnit subTitle;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, this, multiMediaData, mediaSegment, mediaFormat, baseOutputSurface) == null) || multiMediaData == null || mediaSegment == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mediaSegment.start != 0 || mediaSegment.end != 0 || this.mPlayTime > getDuration()) {
            long j2 = mediaSegment.start;
            long j3 = mediaSegment.end;
            if (j2 != j3) {
                long j4 = this.mPlayTime;
                if (j4 >= j2) {
                }
            }
            if (multiMediaData.type == 1) {
                releaseDecoder(multiMediaData);
            }
            multiMediaData.releaseSurface();
            multiMediaData.releasePlayer();
            MultiDataSourceUtil.glDeleteTextures(multiMediaData);
            return;
        }
        initMultiMedia(multiMediaData, mediaSegment.start);
        if (multiMediaData.type == 1) {
            if (FileUtils.isExists(multiMediaData.path)) {
                long j5 = this.mPlayTime;
                if (multiMediaData.currentPts / 1000 <= j5) {
                    c.e(TAG, multiMediaData.currentPts + "," + (this.mPlayTime * 1000) + "," + multiMediaData.path);
                    createDecoder(multiMediaData, baseOutputSurface);
                    if (multiMediaData.videoDecoderDone && multiMediaData.loop) {
                        multiMediaData.videoDecoderDone = false;
                        multiMediaData.videoExtractorDone = false;
                        multiMediaData.basePts += multiMediaData.currentPts;
                        long j6 = mediaSegment.start;
                        multiMediaData.offset = j6;
                        multiMediaData.currentPts = j6 * 1000;
                        multiMediaData.videoDecoder.flush();
                        multiMediaData.videoExtractor.seekTo(multiMediaData.start * 1000, 0);
                    }
                    boolean z = true;
                    while (z && isUnInterrupted() && System.currentTimeMillis() - currentTimeMillis <= 3000) {
                        doExtractDecode(multiMediaData.videoExtractor, multiMediaData.videoDecoder, multiMediaData, mediaSegment, mediaFormat);
                        z = this.mFrameSkip;
                    }
                    if (!multiMediaData.videoDecoderDone) {
                        return;
                    }
                } else if (j5 <= 0) {
                    return;
                } else {
                    c.e(TAG, "当前帧率不够，正在追帧");
                    if (this.mFrameSkip) {
                        createDecoder(multiMediaData, baseOutputSurface);
                        if (multiMediaData.videoDecoderDone && multiMediaData.loop) {
                            multiMediaData.videoDecoderDone = false;
                            multiMediaData.videoExtractorDone = false;
                            multiMediaData.basePts += multiMediaData.currentPts;
                            long j7 = mediaSegment.start;
                            multiMediaData.offset = j7;
                            multiMediaData.currentPts = j7 * 1000;
                            multiMediaData.videoDecoder.flush();
                            multiMediaData.videoExtractor.seekTo(multiMediaData.start * 1000, 0);
                        }
                        boolean z2 = true;
                        while (z2 && isUnInterrupted() && System.currentTimeMillis() - currentTimeMillis <= 3000) {
                            doExtractDecode(multiMediaData.videoExtractor, multiMediaData.videoDecoder, multiMediaData, mediaSegment, mediaFormat);
                            z2 = this.mFrameSkip;
                        }
                        if (!multiMediaData.videoDecoderDone) {
                            return;
                        }
                    }
                }
                baseOutputSurface.onFrameAvailable(multiMediaData.surfaceTexture);
                return;
            }
            return;
        }
        if (TextUtils.equals(mediaSegment.type, SubtitleLog.TAG)) {
            c.e("subcreater", "parsersubtitle," + this.mPlayTime);
            NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
            if (newSubTitleCreater != null && (subTitle = newSubTitleCreater.getSubTitle(this.mPlayTime, getDuration())) != null && (bitmap = subTitle.textBitmap) != null && !bitmap.isRecycled() && !TextUtils.equals(multiMediaData.subTitleText, subTitle.line)) {
                multiMediaData.subTitleText = subTitle.line;
                MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                if (TextUtils.isEmpty(multiMediaData.subTitleText)) {
                    return;
                }
                mediaSegment.effectStart = subTitle.startTime;
                mediaSegment.effectEnd = subTitle.endTime;
                mediaSegment.mediaAEffect = c.a.a0.b.a.k.c.i(MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mediaTracks), this.mEditTrackConfig, mediaSegment.type, this.mSubTitleUnits.indexOf(subTitle), this.mSubTitleUnits.size(), subTitle.endTime - subTitle.startTime);
                multiMediaData.width = 0;
                multiMediaData.height = 0;
                multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, subTitle.textBitmap.copy(Bitmap.Config.ARGB_8888, false));
                multiMediaData.scaleType = "adaptive";
                multiMediaData.start = subTitle.startTime;
                multiMediaData.end = subTitle.endTime;
                multiMediaData.x = subTitle.x;
                multiMediaData.y = subTitle.y;
            }
        }
        if (this.mFrameSkip) {
            return;
        }
        baseOutputSurface.onFrameAvailable(multiMediaData.surfaceTexture);
        notifyFrameAvailable();
    }

    private ArrayList<MultiMediaData> getInputMultiMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (getInputMultiMediaDataTrack() == null) {
                return null;
            }
            return (ArrayList) getInputMultiMediaDataTrack().multiMediaDataList;
        }
        return (ArrayList) invokeV.objValue;
    }

    private MultiMediaDataTrack getInputMultiMediaDataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (MultiMediaDataTrack) h.c(getMultiMediaDataTrack(), 0) : (MultiMediaDataTrack) invokeV.objValue;
    }

    private MediaTrack getInputTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? (MediaTrack) h.c(getUpdateMediaTracks(), 0) : (MediaTrack) invokeV.objValue;
    }

    private long getSegmentsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            List<MediaSegment> list = getInputTrack().mediaSegments;
            return list.get(list.size() - 1).end;
        }
        return invokeV.longValue;
    }

    private void initMultiMedia(MultiMediaData multiMediaData, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65546, this, multiMediaData, j2) == null) || multiMediaData == null || TextUtils.isEmpty(multiMediaData.path)) {
            return;
        }
        if (multiMediaData.textureId == 0 || multiMediaData.isFrameSequential()) {
            if (multiMediaData.type != 0) {
                if (multiMediaData.width == 0 || multiMediaData.height == 0 || multiMediaData.originalDuration == 0) {
                    MultiDataSourceUtil.initVideoByPath(multiMediaData);
                }
                multiMediaData.textureId = g.d();
                Matrix.setIdentityM(multiMediaData.mtx, 0);
                return;
            }
            String str = multiMediaData.path;
            if (multiMediaData.isFrameSequential()) {
                int i2 = (int) (((float) (this.mPlayTime - j2)) / (1000.0f / multiMediaData.frameFps));
                if (i2 < 0) {
                    return;
                }
                if (multiMediaData.frameStartIndex == 0) {
                    if (!new File(str + File.separator + "0." + multiMediaData.frameSuffix).exists()) {
                        multiMediaData.frameStartIndex = 1;
                    }
                }
                int i3 = (i2 % multiMediaData.frameCount) + multiMediaData.frameStartIndex;
                if (i3 == multiMediaData.frameIndex && this.mPlayTime != 0) {
                    return;
                }
                str = str + File.separator + "" + i3 + "." + multiMediaData.frameSuffix;
                multiMediaData.frameIndex = i3;
                multiMediaData.releaseSurface();
                multiMediaData.releasePlayer();
                MultiDataSourceUtil.glDeleteTextures(multiMediaData);
            }
            multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, MultiDataSourceUtil.decodeBitmap(str));
        }
    }

    private void log() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            c.a.a0.b.a.k.c.l();
        }
    }

    private void notifyFrameAvailable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mFrameAvailable = true;
            this.mFrameSkip = false;
        }
    }

    private void notifyFrameSkip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mFrameSkip = true;
        }
    }

    private void onPlayEnd() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (getMultiMediaDataTrack() != null) {
                for (int i2 = 0; i2 < getMultiMediaDataTrack().size(); i2++) {
                    MultiMediaDataTrack multiMediaDataTrack = getMultiMediaDataTrack().get(i2);
                    if (multiMediaDataTrack != null) {
                        if (multiMediaDataTrack.multiMediaDataList != null) {
                            for (int i3 = 0; i3 < multiMediaDataTrack.multiMediaDataList.size(); i3++) {
                                MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i3);
                                if (multiMediaData != null) {
                                    releaseDecoder(multiMediaData);
                                    multiMediaData.releaseSurface();
                                    multiMediaData.releasePlayer();
                                    MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                                }
                            }
                        }
                        MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
                        if (multiMediaData2 != null) {
                            releaseDecoder(multiMediaData2);
                            multiMediaDataTrack.multiMediaDataSuperpositionHeader.releaseSurface();
                            multiMediaDataTrack.multiMediaDataSuperpositionHeader.releasePlayer();
                            MultiDataSourceUtil.glDeleteTextures(multiMediaDataTrack.multiMediaDataSuperpositionHeader);
                        }
                        MultiMediaData multiMediaData3 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
                        if (multiMediaData3 != null) {
                            releaseDecoder(multiMediaData3);
                            multiMediaDataTrack.multiMediaDataSuperpositionFooter.releaseSurface();
                            multiMediaDataTrack.multiMediaDataSuperpositionFooter.releasePlayer();
                            MultiDataSourceUtil.glDeleteTextures(multiMediaDataTrack.multiMediaDataSuperpositionFooter);
                        }
                    }
                }
            }
            releaseSubCreater();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, ARITH, IPUT, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
        if (r5 <= 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006b, code lost:
        if (r5 <= 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006d, code lost:
        r4.mLogDecoderCount = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0071, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void releaseDecoder(MultiMediaData multiMediaData) throws Exception {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, multiMediaData) == null) || multiMediaData == null) {
            return;
        }
        try {
            if (multiMediaData.videoExtractor != null) {
                multiMediaData.videoExtractor.release();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            multiMediaData.videoExtractor = null;
            throw th;
        }
        multiMediaData.videoExtractor = null;
        try {
            try {
                if (multiMediaData.videoDecoder != null) {
                    multiMediaData.videoDecoder.stop();
                }
                try {
                    if (multiMediaData.videoDecoder != null) {
                        multiMediaData.videoDecoder.release();
                    }
                    multiMediaData.videoDecoder = null;
                    i2 = this.mLogDecoderCount;
                    if (i2 <= 0) {
                        return;
                    }
                } catch (Exception unused2) {
                    multiMediaData.videoDecoder = null;
                    i2 = this.mLogDecoderCount;
                    if (i2 <= 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    multiMediaData.videoDecoder = null;
                    int i4 = this.mLogDecoderCount;
                    if (i4 > 0) {
                        this.mLogDecoderCount = i4 - 1;
                    }
                    throw th2;
                }
            } catch (Exception unused3) {
                multiMediaData.videoDecoder = null;
                i2 = this.mLogDecoderCount;
                if (i2 <= 0) {
                    return;
                }
            } catch (Throwable th3) {
                multiMediaData.videoDecoder = null;
                int i5 = this.mLogDecoderCount;
                if (i5 > 0) {
                    this.mLogDecoderCount = i5 - 1;
                }
                throw th3;
            }
        } catch (Exception unused4) {
            if (multiMediaData.videoDecoder != null) {
                multiMediaData.videoDecoder.release();
            }
            multiMediaData.videoDecoder = null;
            i2 = this.mLogDecoderCount;
            if (i2 <= 0) {
                return;
            }
        } catch (Throwable th4) {
            try {
                if (multiMediaData.videoDecoder != null) {
                    multiMediaData.videoDecoder.release();
                }
                multiMediaData.videoDecoder = null;
                i3 = this.mLogDecoderCount;
            } catch (Exception unused5) {
                multiMediaData.videoDecoder = null;
                i3 = this.mLogDecoderCount;
            } catch (Throwable th5) {
                multiMediaData.videoDecoder = null;
                int i6 = this.mLogDecoderCount;
                if (i6 > 0) {
                    this.mLogDecoderCount = i6 - 1;
                }
                throw th5;
            }
        }
        this.mLogDecoderCount = i2 - 1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:177:0x01b7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x0011 */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01a7, code lost:
        if (r2 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a9, code lost:
        r2.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01af, code lost:
        if (r2 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01b9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ba, code lost:
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01d8, code lost:
        if (r4 != null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01da, code lost:
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01e0, code lost:
        if (r4 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c6, code lost:
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c8, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cc, code lost:
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cf, code lost:
        r2.release();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c4 A[Catch: Exception -> 0x01ca, TRY_LEAVE, TryCatch #19 {Exception -> 0x01ca, blocks: (B:117:0x01c0, B:119:0x01c4), top: B:173:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00d4 -> B:177:0x01b7). Please submit an issue!!! */
    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractDecodeEditEncodeMux() throws Exception {
        MediaCodec mediaCodec;
        MediaCodec mediaCodec2;
        InputSurface inputSurface;
        int i2;
        int i3;
        MediaCodec d2;
        InputSurface inputSurface2;
        MediaCodecInfo m;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        String str = "video/avc";
        MediaCodecInfo m2 = m.m("video/avc");
        if (m2 == null) {
            return;
        }
        mediaCodec = 0;
        try {
            try {
                try {
                    i2 = this.mOutWidth == 0 ? RecordConstants.VIDEO_CONSTANT_WIDTH : this.mOutWidth;
                    i3 = this.mOutHeight == 0 ? RecordConstants.VIDEO_CONSTANT_HEIGHT : this.mOutHeight;
                    if (this.mEncodeHevcVideo && (m = m.m("video/hevc")) != null) {
                        this.mCurrentEncodeHevcVideo = true;
                        m2 = m;
                        str = "video/hevc";
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
                    createVideoFormat.setInteger("color-format", 2130708361);
                    createVideoFormat.setInteger("bitrate", this.mOutBitRate > 0 ? this.mOutBitRate : RecordConstants.DEFAULT_BIT_RATE_GTE_API18);
                    if (this.mFrameRate == 0) {
                        this.mFrameRate = 30;
                    }
                    createVideoFormat.setInteger("frame-rate", this.mFrameRate);
                    createVideoFormat.setInteger("i-frame-interval", 5);
                    releaseTextures();
                    AtomicReference atomicReference = new AtomicReference();
                    try {
                        d2 = m.d(m2, createVideoFormat, atomicReference);
                    } catch (Exception unused) {
                        if (i2 % 16 != 0) {
                            i2 += 16 - (i2 % 16);
                        }
                        if (i3 % 16 != 0) {
                            i3 += 16 - (i3 % 16);
                        }
                        createVideoFormat.setInteger("width", i2);
                        createVideoFormat.setInteger("height", i3);
                        d2 = m.d(m2, createVideoFormat, atomicReference);
                    }
                    try {
                        inputSurface2 = new InputSurface((Surface) atomicReference.get());
                    } catch (Exception e2) {
                        inputSurface = null;
                        mediaCodec2 = d2;
                        e = e2;
                    } catch (Throwable th) {
                        th = th;
                        inputSurface = null;
                        mediaCodec = d2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputSurface = null;
                }
            } catch (Exception e3) {
                e = e3;
                mediaCodec2 = null;
                inputSurface = null;
            }
            try {
                inputSurface2.makeCurrent();
                if (this.mOutputSurface != null) {
                    this.mOutputSurface.init(i2, i3);
                }
                doExtractEncodeMux(d2, inputSurface2, this.mOutputSurface);
                try {
                    onPlayEnd();
                } catch (Exception unused2) {
                }
                try {
                    if (this.mOutputSurface != null) {
                        this.mOutputSurface.release();
                    }
                } catch (Exception unused3) {
                }
                if (d2 != null) {
                    try {
                        d2.stop();
                    } catch (Exception unused4) {
                    } catch (Throwable th3) {
                        if (d2 != null) {
                            try {
                                d2.release();
                            } catch (Exception unused5) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Exception e4) {
                mediaCodec2 = d2;
                e = e4;
                inputSurface = inputSurface2;
                try {
                    if (isUnInterrupted()) {
                        mediaCodec = e;
                    } else {
                        onInterrupt();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("InnerVideoProcessor extractDecodeEditEncodeMux video fail ");
                    sb.append("< <muxer log> ");
                    sb.append(getMuxerLog());
                    sb.append(">");
                    if (Build.VERSION.SDK_INT >= 21 && (e instanceof MediaCodec.CodecException)) {
                        boolean isRecoverable = ((MediaCodec.CodecException) e).isRecoverable();
                        boolean isTransient = ((MediaCodec.CodecException) e).isTransient();
                        sb.append("< <codec exception> isTransient :");
                        sb.append(isTransient);
                        sb.append(" isRecoverable : ");
                        sb.append(isRecoverable);
                        if (Build.VERSION.SDK_INT >= 23) {
                            sb.append(" errorCode : ");
                            sb.append(((MediaCodec.CodecException) e).getErrorCode());
                            sb.append(" diagnosticInfo : ");
                            sb.append(((MediaCodec.CodecException) e).getDiagnosticInfo());
                        }
                        sb.append("timestamp : ");
                        sb.append(System.currentTimeMillis());
                        sb.append(">");
                    }
                    sb.append("< <exception log> ");
                    sb.append(m.g(e));
                    sb.append(">");
                    setErrMsg(true, sb.toString());
                    e.printStackTrace();
                    try {
                        onPlayEnd();
                    } catch (Exception unused6) {
                    }
                    try {
                        if (this.mOutputSurface != null) {
                            this.mOutputSurface.release();
                        }
                    } catch (Exception unused7) {
                    }
                    if (mediaCodec2 != null) {
                        try {
                            mediaCodec2.stop();
                        } catch (Exception unused8) {
                        } catch (Throwable th4) {
                            if (mediaCodec2 != null) {
                                try {
                                    mediaCodec2.release();
                                } catch (Exception unused9) {
                                }
                            }
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    mediaCodec = mediaCodec2;
                    try {
                        onPlayEnd();
                    } catch (Exception unused10) {
                    }
                    try {
                        if (this.mOutputSurface != null) {
                            this.mOutputSurface.release();
                        }
                    } catch (Exception unused11) {
                    }
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                        } catch (Exception unused12) {
                        } catch (Throwable th6) {
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.release();
                                } catch (Exception unused13) {
                                }
                            }
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                mediaCodec = d2;
                inputSurface = inputSurface2;
                onPlayEnd();
                if (this.mOutputSurface != null) {
                }
                if (mediaCodec != null) {
                }
            }
        } catch (Exception unused14) {
            mediaCodec = mediaCodec;
        }
        if (inputSurface != null) {
            try {
                inputSurface.release();
            } catch (Exception unused15) {
            }
        }
        throw th;
        throw th;
        if (inputSurface != null) {
            inputSurface.release();
            mediaCodec = mediaCodec;
        }
        if (mediaCodec != 0) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentIndex : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPlayTime : invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getSegmentsDuration() : invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEditTrackConfig : (MediaTrackConfig) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mediaDataTracks : (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    public String getMuxerLog() {
        InterceptResult invokeV;
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                if (this.mediaDataTracks != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("---log start---");
                    int i2 = this.mOutWidth == 0 ? RecordConstants.VIDEO_CONSTANT_WIDTH : this.mOutWidth;
                    int i3 = this.mOutHeight == 0 ? RecordConstants.VIDEO_CONSTANT_HEIGHT : this.mOutHeight;
                    int i4 = this.mOutBitRate > 0 ? this.mOutBitRate : RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
                    int i5 = this.mFrameRate == 0 ? 30 : this.mFrameRate;
                    sb.append(" muxer w*h->");
                    sb.append(i2);
                    sb.append(ProxyConfig.MATCH_ALL_SCHEMES);
                    sb.append(i3);
                    sb.append(" bitrate->");
                    sb.append(i4);
                    sb.append(" frameRate->");
                    sb.append(i5);
                    sb.append(" currentDecoderCount->");
                    sb.append(this.mLogDecoderCount);
                    sb.append(" currentEncodeHevcVideo->");
                    sb.append(this.mCurrentEncodeHevcVideo);
                    sb.append(" index->");
                    sb.append(this.mCurrentIndex);
                    sb.append(" playTime->");
                    sb.append(this.mPlayTime);
                    sb.append(" duration->");
                    sb.append(getDuration());
                    sb.append(" multiMediaTrack size->");
                    sb.append(this.mediaDataTracks.size());
                    for (int i6 = 0; i6 < this.mediaDataTracks.size(); i6++) {
                        MultiMediaDataTrack multiMediaDataTrack = this.mediaDataTracks.get(i6);
                        if (multiMediaDataTrack.multiMediaDataList != null) {
                            sb.append(" track");
                            sb.append(i6);
                            sb.append(" size->");
                            sb.append(multiMediaDataTrack.multiMediaDataList.size());
                            if (i6 == 0) {
                                if (multiMediaDataTrack.multiMediaDataSuperpositionHeader != null) {
                                    sb.append(" header type->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionHeader.type);
                                    sb.append(" header start->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionHeader.start);
                                    sb.append(" header end->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionHeader.end);
                                }
                                if (multiMediaDataTrack.multiMediaDataSuperpositionFooter != null) {
                                    sb.append(" footer type->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionFooter.type);
                                    sb.append(" footer start->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionFooter.start);
                                    sb.append(" footer end->");
                                    sb.append(multiMediaDataTrack.multiMediaDataSuperpositionFooter.end);
                                }
                                if (multiMediaDataTrack.multiMediaDataList.size() > this.mCurrentIndex && (multiMediaData2 = multiMediaDataTrack.multiMediaDataList.get(this.mCurrentIndex)) != null) {
                                    sb.append(" current multiMediaData");
                                    sb.append(" w->");
                                    sb.append(multiMediaData2.width);
                                    sb.append(" h->");
                                    sb.append(multiMediaData2.height);
                                    sb.append(" type->");
                                    sb.append(multiMediaData2.type);
                                    sb.append(" start->");
                                    sb.append(multiMediaData2.start);
                                    sb.append(" end->");
                                    sb.append(multiMediaData2.end);
                                    sb.append(" duration->");
                                    sb.append(multiMediaData2.originalDuration);
                                    sb.append(" isExist ->");
                                    sb.append(new File(multiMediaData2.path).exists());
                                }
                            } else if (multiMediaDataTrack.multiMediaDataList.size() > 0 && (multiMediaData = multiMediaDataTrack.multiMediaDataList.get(0)) != null) {
                                sb.append(" tracks multiMediaData");
                                sb.append(" w->");
                                sb.append(multiMediaData.width);
                                sb.append(" h->");
                                sb.append(multiMediaData.height);
                                sb.append(" type->");
                                sb.append(multiMediaData.type);
                                sb.append(" start->");
                                sb.append(multiMediaData.start);
                                sb.append(" end->");
                                sb.append(multiMediaData.end);
                                sb.append(" duration->");
                                sb.append(multiMediaData.originalDuration);
                            }
                        }
                    }
                    collectMediaCodecInstances(sb);
                    sb.append("---log end---");
                    return sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return super.getMuxerLog();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.shaderConfigMap : (Map) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mediaTracks : (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, effectChangeObserver) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mediaTrackChangeObserver) == null) {
        }
    }

    public void releaseSubCreater() {
        NewSubTitleCreater newSubTitleCreater;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (newSubTitleCreater = this.mSubTitleCreater) == null) {
            return;
        }
        newSubTitleCreater.release();
        this.mSubTitleCreater = null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int b2 = h.b(getMultiMediaDataTrack());
            for (int i2 = 0; i2 < b2; i2++) {
                List<MultiMediaData> list = getMultiMediaDataTrack().get(i2).multiMediaDataList;
                int b3 = h.b(list);
                if (b3 != 0) {
                    for (int i3 = 0; i3 < b3; i3++) {
                        MultiMediaData multiMediaData = (MultiMediaData) h.c(list, i3);
                        if (multiMediaData != null) {
                            multiMediaData.releaseSurface();
                            multiMediaData.releasePlayer(true);
                        }
                        MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                    }
                    if (getMultiMediaDataTrack().get(i2).multiMediaDataSuperpositionHeader != null) {
                        MultiDataSourceUtil.glDeleteTextures(getMultiMediaDataTrack().get(i2).multiMediaDataSuperpositionHeader);
                    }
                    if (getMultiMediaDataTrack().get(i2).multiMediaDataSuperpositionFooter != null) {
                        MultiDataSourceUtil.glDeleteTextures(getMultiMediaDataTrack().get(i2).multiMediaDataSuperpositionFooter);
                    }
                }
            }
            if (getShaderConfigMap() != null) {
                for (Map.Entry<String, ShaderConfig> entry : getShaderConfigMap().entrySet()) {
                    entry.getValue().destroy();
                }
            }
        }
    }

    public void setData(List<MultiMediaDataTrack> list, MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, list, mediaTrackConfig) == null) {
            this.mediaDataTracks = list;
            this.mEditTrackConfig = mediaTrackConfig;
            this.mediaTracks = mediaTrackConfig.mediaTracks;
            this.shaderConfigMap = mediaTrackConfig.shaderConfigMapDebug;
        }
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, subTitleConfig) == null) {
            if (this.mSubTitleCreater == null) {
                this.mSubTitleCreater = new NewSubTitleCreater(this.mSubTitleUnits, true);
            }
            this.mSubTitleCreater.setSubTitleConfig(subTitleConfig);
        }
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.mSubTitleUnits = list;
            NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
            if (newSubTitleCreater == null) {
                this.mSubTitleCreater = new NewSubTitleCreater(list, true);
            } else {
                newSubTitleCreater.setSubTitleUnits(list);
            }
        }
    }
}
