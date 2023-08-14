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
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.bab;
import com.baidu.tieba.j9b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.rg0;
import com.baidu.tieba.t9b;
import com.baidu.tieba.xg0;
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
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
@TargetApi(18)
/* loaded from: classes9.dex */
public class InnerMultiMediaProcessor extends InnerMediaProcessor implements IMultiMediaDataSource {
    public static final String TAG = "InnerMultiMediaProcessor";
    public static final int TIMEOUT_USEC = 10000;
    public static final boolean VERBOSE = false;
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

    public InnerMultiMediaProcessor(InnerMuxerWrapper innerMuxerWrapper, OnGenFilterVideoListener onGenFilterVideoListener) {
        super(TAG);
        this.mFrameAvailable = false;
        this.mFrameSkip = false;
        this.mMuxer = innerMuxerWrapper;
        this.mListener = onGenFilterVideoListener;
    }

    private void collectMediaCodecInstances(StringBuilder sb) {
        MediaCodecInfo[] codecInfos;
        String[] supportedTypes;
        if (Build.VERSION.SDK_INT < 23 || (codecInfos = new MediaCodecList(0).getCodecInfos()) == null) {
            return;
        }
        for (int i = 0; i < codecInfos.length; i++) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i];
            if (mediaCodecInfo != null && (supportedTypes = mediaCodecInfo.getSupportedTypes()) != null) {
                for (int i2 = 0; i2 < supportedTypes.length; i2++) {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(supportedTypes[i2]);
                    if (capabilitiesForType != null && (supportedTypes[i2].equals("video/avc") || supportedTypes[i2].equals(MimeTypes.VIDEO_H265))) {
                        sb.append(" -- maxInstances : " + capabilitiesForType.getMaxSupportedInstances() + " type : " + supportedTypes[i2] + " j : " + i2 + " i : " + i + " isEncoder : " + mediaCodecInfo.isEncoder() + " name : " + mediaCodecInfo.getName() + ",");
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0012 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x000b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.media.MediaFormat] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createDecoder(MultiMediaData multiMediaData, BaseOutputSurface baseOutputSurface) throws IOException {
        MediaExtractor mediaExtractor;
        if (multiMediaData.type != 0 && multiMediaData.videoDecoder == null) {
            FileInputStream fileInputStream = 0;
            try {
                try {
                    mediaExtractor = t9b.b(multiMediaData.path);
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != 0) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception unused) {
                MediaExtractor mediaExtractor2 = new MediaExtractor();
                FileInputStream fileInputStream2 = new FileInputStream(new File(multiMediaData.path));
                try {
                    mediaExtractor2.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                    mediaExtractor = mediaExtractor2;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != 0) {
                    }
                    throw th;
                }
            }
            multiMediaData.videoExtractor = mediaExtractor;
            fileInputStream = multiMediaData.videoExtractor.getTrackFormat(t9b.f(mediaExtractor));
            multiMediaData.videoExtractor.seekTo(multiMediaData.start * 1000, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(multiMediaData.textureId);
            multiMediaData.surfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(baseOutputSurface);
            Surface surface = new Surface(multiMediaData.surfaceTexture);
            multiMediaData.surface = surface;
            multiMediaData.videoDecoder = t9b.c(fileInputStream, surface);
            this.mLogDecoderCount++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
        if (r4 < (r27.start * 1000)) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtractDecode(MediaExtractor mediaExtractor, MediaCodec mediaCodec, MultiMediaData multiMediaData, MediaSegment mediaSegment, MediaFormat mediaFormat) {
        boolean z;
        int i;
        long j;
        long j2;
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j3 = multiMediaData.offset * 1000;
        if (multiMediaData.videoExtractorDone || !((mediaFormat == null || this.mMuxer.isStarted()) && isUnInterrupted() && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) != -1)) {
            z = true;
            i = -1;
        } else {
            int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], 0);
            long sampleTime = mediaExtractor.getSampleTime();
            if (readSampleData >= 0) {
                z = true;
                i = -1;
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime + 0, mediaExtractor.getSampleFlags());
                mediaExtractor.advance();
            } else {
                z = true;
                i = -1;
                boolean z2 = !mediaExtractor.advance();
                multiMediaData.videoExtractorDone = z2;
                if (z2) {
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                }
            }
        }
        if (!multiMediaData.videoDecoderDone && ((mediaFormat == null || this.mMuxer.isStarted()) && isUnInterrupted())) {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer != i) {
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
                        j9b.e(TAG, "videoDecoderRender:" + z3);
                        if (z3) {
                            long j4 = bufferInfo.presentationTimeUs;
                            long j5 = j4 > 0 ? 1000L : 1000L;
                            if (bufferInfo.presentationTimeUs > 0) {
                                j3 += (((float) (j2 - (multiMediaData.start * j5))) * 1.0f) / multiMediaData.getCurrentSpeed();
                            }
                            this.mFrameSkip = false;
                            multiMediaData.currentPts = j3;
                            if (multiMediaData.loop) {
                                j3 += multiMediaData.basePts;
                            }
                            log(TAG, "decode 2: -------------------refreshcurrentPts ----- " + j3 + " flags ：" + bufferInfo.flags + " mPlayTime : " + this.mPlayTime + " pts : " + bufferInfo.presentationTimeUs + " basePts : " + multiMediaData.basePts + "------------");
                            StringBuilder sb = new StringBuilder();
                            sb.append("refreshcurrentPts:");
                            sb.append(j3);
                            sb.append(" mPlayTime ：");
                            sb.append(this.mPlayTime);
                            j9b.e(TAG, sb.toString());
                            if (j3 >= this.mPlayTime * 1000) {
                                notifyFrameAvailable();
                                j = 1000;
                            } else if (mediaSegment.start * 1000 == j3 && bufferInfo.flags == z) {
                                notifyFrameAvailable();
                            } else {
                                notifyFrameSkip();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("当前帧率过高，正在丢帧，");
                                sb2.append(j3);
                                sb2.append(",");
                                j = 1000;
                                sb2.append(this.mPlayTime * 1000);
                                j9b.e(TAG, sb2.toString());
                            }
                            if (bufferInfo.presentationTimeUs >= multiMediaData.end * j) {
                                notifyFrameAvailable();
                                multiMediaData.videoDecoderDone = z;
                            }
                            if ((bufferInfo.flags & 4) != 0) {
                                notifyFrameAvailable();
                                multiMediaData.videoDecoderDone = z;
                            }
                        }
                        j = 1000;
                        if (bufferInfo.presentationTimeUs >= multiMediaData.end * j) {
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

    /* JADX WARN: Code restructure failed: missing block: B:126:0x0262, code lost:
        if (isUnInterrupted() != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0264, code lost:
        onInterrupt();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0267, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:?, code lost:
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
        int i;
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long currentTimeMillis = System.currentTimeMillis();
        if (getMultiMediaDataTrack() != null && getUpdateMediaTracks() != null && getUpdateMediaTracks().size() == getMultiMediaDataTrack().size()) {
            int i2 = 0;
            while (i2 < getMultiMediaDataTrack().size()) {
                MultiMediaDataTrack multiMediaDataTrack = getMultiMediaDataTrack().get(i2);
                MediaTrack mediaTrack = getUpdateMediaTracks().get(i2);
                if (mediaTrack.mediaSegments != null) {
                    int i3 = 0;
                    while (i3 < mediaTrack.mediaSegments.size()) {
                        MultiMediaData multiMediaData = (MultiMediaData) o9b.c(multiMediaDataTrack.multiMediaDataList, i3);
                        MediaSegment mediaSegment3 = (MediaSegment) o9b.c(mediaTrack.mediaSegments, i3);
                        if (mediaSegment3 == null || multiMediaData == null) {
                            i = i2;
                        } else {
                            i = i2;
                            long j = mediaSegment3.start;
                            multiMediaData.offset = j;
                            multiMediaData.currentPts = j * 1000;
                        }
                        i3++;
                        i2 = i;
                    }
                }
                int i4 = i2;
                MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
                if (multiMediaData2 != null && (mediaSegment2 = mediaTrack.superpositionHeader) != null) {
                    long j2 = mediaSegment2.start;
                    multiMediaData2.offset = j2;
                    multiMediaData2.currentPts = j2 * 1000;
                }
                MultiMediaData multiMediaData3 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
                if (multiMediaData3 != null && (mediaSegment = mediaTrack.superpositionFooter) != null) {
                    long j3 = mediaSegment.start;
                    multiMediaData3.offset = j3;
                    multiMediaData3.currentPts = j3 * 1000;
                }
                i2 = i4 + 1;
            }
            int i5 = -1;
            MediaFormat mediaFormat = null;
            boolean z3 = false;
            boolean z4 = false;
            int i6 = -1;
            long j4 = 0;
            while (true) {
                if (z4 || !isUnInterrupted()) {
                    break;
                } else if (System.currentTimeMillis() - currentTimeMillis > 10000) {
                    onPlayEnd();
                    throw new RuntimeException("doEncode timeout1 10000 ms");
                } else {
                    if (this.mPlayTime <= getDuration() && !z3) {
                        int updateTimeline = MultiDataSourceUtil.updateTimeline(getInputTrack(), getInputMultiMediaData(), this.mPlayTime);
                        if (updateTimeline == i5) {
                            updateTimeline = 0;
                        }
                        this.mCurrentIndex = updateTimeline;
                        int i7 = 0;
                        while (i7 < getMultiMediaDataTrack().size()) {
                            MultiMediaDataTrack multiMediaDataTrack2 = getMultiMediaDataTrack().get(i7);
                            MediaTrack mediaTrack2 = getUpdateMediaTracks().get(i7);
                            if (mediaTrack2.mediaSegments != null) {
                                int i8 = 0;
                                while (i8 < mediaTrack2.mediaSegments.size()) {
                                    MultiMediaData multiMediaData4 = (MultiMediaData) o9b.c(multiMediaDataTrack2.multiMediaDataList, i8);
                                    long j5 = currentTimeMillis;
                                    MediaSegment mediaSegment4 = (MediaSegment) o9b.c(mediaTrack2.mediaSegments, i8);
                                    if (multiMediaData4 != null && mediaSegment4 != null) {
                                        extractDecode(multiMediaData4, mediaSegment4, mediaFormat, baseOutputSurface);
                                    }
                                    i8++;
                                    currentTimeMillis = j5;
                                }
                            }
                            extractDecode(multiMediaDataTrack2.multiMediaDataSuperpositionHeader, mediaTrack2.superpositionHeader, mediaFormat, baseOutputSurface);
                            extractDecode(multiMediaDataTrack2.multiMediaDataSuperpositionFooter, mediaTrack2.superpositionFooter, mediaFormat, baseOutputSurface);
                            i7++;
                            currentTimeMillis = currentTimeMillis;
                        }
                    }
                    long j6 = currentTimeMillis;
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
                        long j7 = (long) (this.mPlayTime + ((1.0d / this.mFrameRate) * 1000.0d));
                        this.mPlayTime = j7;
                        if (j7 >= getDuration() && z5) {
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
                                        if (j4 == 0) {
                                            j4 = bufferInfo.presentationTimeUs;
                                        }
                                        int duration = (int) ((bufferInfo.presentationTimeUs - j4) / (getDuration() * 10));
                                        if (duration > 0 && duration < 100) {
                                            onProgress(duration);
                                        }
                                        this.mMuxer.writeSampleData(i6, byteBuffer, bufferInfo);
                                    }
                                    if ((bufferInfo.flags & 4) != 0) {
                                        z = false;
                                        z4 = true;
                                    } else {
                                        z = false;
                                    }
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z);
                                }
                            } else if (i6 >= 0) {
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
                            i6 = this.mMuxer.addTrack(mediaFormat);
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
                        currentTimeMillis = j6;
                    }
                    this.mFrameAvailable = false;
                    i5 = -1;
                }
            }
        } else if (this.mListener != null) {
            bab.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.InnerMultiMediaProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    OnGenFilterVideoListener onGenFilterVideoListener = InnerMultiMediaProcessor.this.mListener;
                    if (onGenFilterVideoListener != null) {
                        onGenFilterVideoListener.onGenFilterVideoFail(-3, "data size error!!!");
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r13 >= r2) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void extractDecode(MultiMediaData multiMediaData, MediaSegment mediaSegment, MediaFormat mediaFormat, BaseOutputSurface baseOutputSurface) throws Exception {
        SubTitleUnit subTitle;
        Bitmap bitmap;
        if (multiMediaData == null || mediaSegment == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mediaSegment.start != 0 || mediaSegment.end != 0 || this.mPlayTime > getDuration()) {
            long j = mediaSegment.start;
            long j2 = mediaSegment.end;
            if (j != j2) {
                long j3 = this.mPlayTime;
                if (j3 >= j) {
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
                long j4 = this.mPlayTime;
                if (multiMediaData.currentPts / 1000 <= j4) {
                    j9b.e(TAG, multiMediaData.currentPts + "," + (this.mPlayTime * 1000) + "," + multiMediaData.path);
                    createDecoder(multiMediaData, baseOutputSurface);
                    if (multiMediaData.videoDecoderDone && multiMediaData.loop) {
                        multiMediaData.videoDecoderDone = false;
                        multiMediaData.videoExtractorDone = false;
                        multiMediaData.basePts += multiMediaData.currentPts;
                        long j5 = mediaSegment.start;
                        multiMediaData.offset = j5;
                        multiMediaData.currentPts = j5 * 1000;
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
                } else if (j4 <= 0) {
                    return;
                } else {
                    j9b.e(TAG, "当前帧率不够，正在追帧");
                    if (this.mFrameSkip) {
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
            j9b.e("subcreater", "parsersubtitle," + this.mPlayTime);
            NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
            if (newSubTitleCreater != null && (subTitle = newSubTitleCreater.getSubTitle(this.mPlayTime, getDuration())) != null && (bitmap = subTitle.textBitmap) != null && !bitmap.isRecycled() && !TextUtils.equals(multiMediaData.subTitleText, subTitle.line)) {
                multiMediaData.subTitleText = subTitle.line;
                MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                if (TextUtils.isEmpty(multiMediaData.subTitleText)) {
                    return;
                }
                mediaSegment.effectStart = subTitle.startTime;
                mediaSegment.effectEnd = subTitle.endTime;
                mediaSegment.mediaAEffect = xg0.i(MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mediaTracks), this.mEditTrackConfig, mediaSegment.type, this.mSubTitleUnits.indexOf(subTitle), this.mSubTitleUnits.size(), subTitle.endTime - subTitle.startTime);
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
        if (getInputMultiMediaDataTrack() == null) {
            return null;
        }
        return (ArrayList) getInputMultiMediaDataTrack().multiMediaDataList;
    }

    private MultiMediaDataTrack getInputMultiMediaDataTrack() {
        return (MultiMediaDataTrack) o9b.c(getMultiMediaDataTrack(), 0);
    }

    private MediaTrack getInputTrack() {
        return (MediaTrack) o9b.c(getUpdateMediaTracks(), 0);
    }

    private long getSegmentsDuration() {
        List<MediaSegment> list = getInputTrack().mediaSegments;
        return list.get(list.size() - 1).end;
    }

    private void initMultiMedia(MultiMediaData multiMediaData, long j) {
        if (multiMediaData == null || TextUtils.isEmpty(multiMediaData.path)) {
            return;
        }
        if (multiMediaData.textureId == 0 || multiMediaData.isFrameSequential()) {
            if (multiMediaData.type != 0) {
                if (multiMediaData.width == 0 || multiMediaData.height == 0 || multiMediaData.originalDuration == 0) {
                    MultiDataSourceUtil.initVideoByPath(multiMediaData);
                }
                multiMediaData.textureId = rg0.d();
                Matrix.setIdentityM(multiMediaData.mtx, 0);
                return;
            }
            String str = multiMediaData.path;
            if (multiMediaData.isFrameSequential()) {
                int i = (int) (((float) (this.mPlayTime - j)) / (1000.0f / multiMediaData.frameFps));
                if (i < 0) {
                    return;
                }
                if (multiMediaData.frameStartIndex == 0) {
                    if (!new File(str + File.separator + "0." + multiMediaData.frameSuffix).exists()) {
                        multiMediaData.frameStartIndex = 1;
                    }
                }
                int i2 = (i % multiMediaData.frameCount) + multiMediaData.frameStartIndex;
                if (i2 == multiMediaData.frameIndex && this.mPlayTime != 0) {
                    return;
                }
                str = str + File.separator + "" + i2 + "." + multiMediaData.frameSuffix;
                multiMediaData.frameIndex = i2;
                multiMediaData.releaseSurface();
                multiMediaData.releasePlayer();
                MultiDataSourceUtil.glDeleteTextures(multiMediaData);
            }
            multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, MultiDataSourceUtil.decodeBitmap(str));
        }
    }

    private void log() {
        xg0.l();
    }

    private void notifyFrameAvailable() {
        this.mFrameAvailable = true;
        this.mFrameSkip = false;
    }

    private void notifyFrameSkip() {
        this.mFrameSkip = true;
    }

    private void onPlayEnd() throws Exception {
        if (getMultiMediaDataTrack() != null) {
            for (int i = 0; i < getMultiMediaDataTrack().size(); i++) {
                MultiMediaDataTrack multiMediaDataTrack = getMultiMediaDataTrack().get(i);
                if (multiMediaDataTrack != null) {
                    if (multiMediaDataTrack.multiMediaDataList != null) {
                        for (int i2 = 0; i2 < multiMediaDataTrack.multiMediaDataList.size(); i2++) {
                            MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i2);
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IPUT, IGET]}, finally: {[IPUT, IGET, ARITH, IPUT, IF] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
        if (r4 <= 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0067, code lost:
        if (r4 <= 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0069, code lost:
        r3.mLogDecoderCount = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006d, code lost:
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void releaseDecoder(MultiMediaData multiMediaData) throws Exception {
        int i;
        int i2;
        if (multiMediaData == null) {
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
                    i = this.mLogDecoderCount;
                    if (i <= 0) {
                        return;
                    }
                } catch (Exception unused2) {
                    multiMediaData.videoDecoder = null;
                    i = this.mLogDecoderCount;
                    if (i <= 0) {
                        return;
                    }
                } catch (Throwable th2) {
                    multiMediaData.videoDecoder = null;
                    int i3 = this.mLogDecoderCount;
                    if (i3 > 0) {
                        this.mLogDecoderCount = i3 - 1;
                    }
                    throw th2;
                }
            } catch (Exception unused3) {
                if (multiMediaData.videoDecoder != null) {
                    multiMediaData.videoDecoder.release();
                }
                multiMediaData.videoDecoder = null;
                i = this.mLogDecoderCount;
                if (i <= 0) {
                    return;
                }
            } catch (Throwable th3) {
                try {
                    if (multiMediaData.videoDecoder != null) {
                        multiMediaData.videoDecoder.release();
                    }
                    multiMediaData.videoDecoder = null;
                    i2 = this.mLogDecoderCount;
                } catch (Exception unused4) {
                    multiMediaData.videoDecoder = null;
                    i2 = this.mLogDecoderCount;
                } catch (Throwable th4) {
                    multiMediaData.videoDecoder = null;
                    int i4 = this.mLogDecoderCount;
                    if (i4 > 0) {
                        this.mLogDecoderCount = i4 - 1;
                    }
                    throw th4;
                }
            }
        } catch (Exception unused5) {
            multiMediaData.videoDecoder = null;
            i = this.mLogDecoderCount;
            if (i <= 0) {
                return;
            }
        } catch (Throwable th5) {
            multiMediaData.videoDecoder = null;
            int i5 = this.mLogDecoderCount;
            if (i5 > 0) {
                this.mLogDecoderCount = i5 - 1;
            }
            throw th5;
        }
        this.mLogDecoderCount = i - 1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:172:0x01b7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:173:0x000e */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01a7, code lost:
        if (r2 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a9, code lost:
        r2.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01af, code lost:
        if (r2 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01b9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ba, code lost:
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01d8, code lost:
        if (r4 != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01da, code lost:
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e0, code lost:
        if (r4 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c5, code lost:
        if (r1 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cb, code lost:
        if (r1 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ce, code lost:
        r2.release();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c4 A[Catch: Exception -> 0x01ca, TRY_LEAVE, TryCatch #19 {Exception -> 0x01ca, blocks: (B:115:0x01c0, B:117:0x01c4), top: B:168:0x01c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x00d3 -> B:172:0x01b7). Please submit an issue!!! */
    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void extractDecodeEditEncodeMux() throws Exception {
        MediaCodec mediaCodec;
        InputSurface inputSurface;
        MediaCodec mediaCodec2;
        int i;
        int i2;
        MediaCodec d;
        InputSurface inputSurface2;
        MediaCodecInfo m;
        String str = "video/avc";
        MediaCodecInfo m2 = t9b.m("video/avc");
        if (m2 == null) {
            return;
        }
        mediaCodec = 0;
        try {
            try {
                try {
                    i = this.mOutWidth == 0 ? RecordConstants.VIDEO_CONSTANT_WIDTH : this.mOutWidth;
                    i2 = this.mOutHeight == 0 ? RecordConstants.VIDEO_CONSTANT_HEIGHT : this.mOutHeight;
                    if (this.mEncodeHevcVideo && (m = t9b.m(MimeTypes.VIDEO_H265)) != null) {
                        this.mCurrentEncodeHevcVideo = true;
                        m2 = m;
                        str = MimeTypes.VIDEO_H265;
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
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
                        d = t9b.d(m2, createVideoFormat, atomicReference);
                    } catch (Exception unused) {
                        if (i % 16 != 0) {
                            i += 16 - (i % 16);
                        }
                        if (i2 % 16 != 0) {
                            i2 += 16 - (i2 % 16);
                        }
                        createVideoFormat.setInteger("width", i);
                        createVideoFormat.setInteger("height", i2);
                        d = t9b.d(m2, createVideoFormat, atomicReference);
                    }
                    try {
                        inputSurface2 = new InputSurface((Surface) atomicReference.get());
                    } catch (Exception e) {
                        inputSurface = null;
                        mediaCodec2 = d;
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        inputSurface = null;
                        mediaCodec = d;
                    }
                } catch (Exception e2) {
                    e = e2;
                    mediaCodec2 = null;
                    inputSurface = null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputSurface = null;
            }
            try {
                inputSurface2.makeCurrent();
                if (this.mOutputSurface != null) {
                    this.mOutputSurface.init(i, i2);
                }
                doExtractEncodeMux(d, inputSurface2, this.mOutputSurface);
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
                if (d != null) {
                    try {
                        d.stop();
                    } catch (Exception unused4) {
                    } catch (Throwable th3) {
                        if (d != null) {
                            try {
                                d.release();
                            } catch (Exception unused5) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Exception e3) {
                mediaCodec2 = d;
                e = e3;
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
                    sb.append(t9b.g(e));
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
                mediaCodec = d;
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
        return this.mCurrentIndex;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        return this.mPlayTime;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        return getSegmentsDuration();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        return this.mEditTrackConfig;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        return this.mediaDataTracks;
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
    public String getMuxerLog() {
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        try {
            if (this.mediaDataTracks != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("---log start---");
                int i = this.mOutWidth == 0 ? RecordConstants.VIDEO_CONSTANT_WIDTH : this.mOutWidth;
                int i2 = this.mOutHeight == 0 ? RecordConstants.VIDEO_CONSTANT_HEIGHT : this.mOutHeight;
                int i3 = this.mOutBitRate > 0 ? this.mOutBitRate : RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
                int i4 = this.mFrameRate == 0 ? 30 : this.mFrameRate;
                sb.append(" muxer w*h->");
                sb.append(i);
                sb.append("*");
                sb.append(i2);
                sb.append(" bitrate->");
                sb.append(i3);
                sb.append(" frameRate->");
                sb.append(i4);
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
                for (int i5 = 0; i5 < this.mediaDataTracks.size(); i5++) {
                    MultiMediaDataTrack multiMediaDataTrack = this.mediaDataTracks.get(i5);
                    if (multiMediaDataTrack.multiMediaDataList != null) {
                        sb.append(" track");
                        sb.append(i5);
                        sb.append(" size->");
                        sb.append(multiMediaDataTrack.multiMediaDataList.size());
                        if (i5 == 0) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.getMuxerLog();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        return this.shaderConfigMap;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        return this.mediaTracks;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
    }

    public void releaseSubCreater() {
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater != null) {
            newSubTitleCreater.release();
            this.mSubTitleCreater = null;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        int b = o9b.b(getMultiMediaDataTrack());
        for (int i = 0; i < b; i++) {
            List<MultiMediaData> list = getMultiMediaDataTrack().get(i).multiMediaDataList;
            int b2 = o9b.b(list);
            if (b2 != 0) {
                for (int i2 = 0; i2 < b2; i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) o9b.c(list, i2);
                    if (multiMediaData != null) {
                        multiMediaData.releaseSurface();
                        multiMediaData.releasePlayer(true);
                    }
                    MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                }
                if (getMultiMediaDataTrack().get(i).multiMediaDataSuperpositionHeader != null) {
                    MultiDataSourceUtil.glDeleteTextures(getMultiMediaDataTrack().get(i).multiMediaDataSuperpositionHeader);
                }
                if (getMultiMediaDataTrack().get(i).multiMediaDataSuperpositionFooter != null) {
                    MultiDataSourceUtil.glDeleteTextures(getMultiMediaDataTrack().get(i).multiMediaDataSuperpositionFooter);
                }
            }
        }
        if (getShaderConfigMap() != null) {
            for (Map.Entry<String, ShaderConfig> entry : getShaderConfigMap().entrySet()) {
                entry.getValue().destroy();
            }
        }
    }

    public void setData(List<MultiMediaDataTrack> list, MediaTrackConfig mediaTrackConfig) {
        this.mediaDataTracks = list;
        this.mEditTrackConfig = mediaTrackConfig;
        this.mediaTracks = mediaTrackConfig.mediaTracks;
        this.shaderConfigMap = mediaTrackConfig.shaderConfigMapDebug;
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        if (this.mSubTitleCreater == null) {
            this.mSubTitleCreater = new NewSubTitleCreater(this.mSubTitleUnits, true);
        }
        this.mSubTitleCreater.setSubTitleConfig(subTitleConfig);
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        this.mSubTitleUnits = list;
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater == null) {
            this.mSubTitleCreater = new NewSubTitleCreater(list, true);
        } else {
            newSubTitleCreater.setSubTitleUnits(list);
        }
    }
}
