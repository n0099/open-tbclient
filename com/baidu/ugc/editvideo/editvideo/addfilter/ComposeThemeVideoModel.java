package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tieba.h1b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.kg0;
import com.baidu.tieba.kxa;
import com.baidu.tieba.m1b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.vh0;
import com.baidu.tieba.z1b;
import com.baidu.ugc.editvideo.data.AREditSticker;
import com.baidu.ugc.editvideo.data.ImageQualityData;
import com.baidu.ugc.editvideo.data.MediaInfo;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.AREditProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MultiMediaStickerRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@TargetApi(18)
/* loaded from: classes8.dex */
public class ComposeThemeVideoModel {
    public MediaTrackConfig editTrackConfig;
    public Map<BeautyType, Object> mAREditBeautyMap;
    public Map<BeautyType, Object> mAREditBeautyMapForMale;
    public AREditSticker mAREditSticker;
    public String mAudioPath;
    public InnerAudioProcessor mAudioProcessor;
    public long mClipDuration;
    public long mClipPoint;
    public Context mContext;
    public boolean mEncodeHevcVideo;
    public FilterValue mFilterValue;
    public int mFrameRate;
    public ImageQualityData mImageQualityData;
    public volatile boolean mIsAudioReady;
    public volatile boolean mIsMuxerStop;
    public volatile boolean mIsVideoReady;
    public OnGenFilterVideoListener mListener;
    public InnerMuxerWrapper mMuxer;
    public volatile boolean mOnInterrupt;
    public int mOutBitRate;
    public int mOutHeight;
    public int mOutWidth;
    public String mOutputPath;
    public BaseOutputSurface mOutputSurface;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mRotation;
    public String mSourcePath;
    public List<MultiMediaData> mStickerList;
    public SubTitleConfig mSubTitleConfig;
    public List<SubTitleUnit> mSubTitleUnits;
    public VideoEffectData mVideoEffectData;
    public InnerMediaProcessor mVideoProcessor;
    public String mWaterMarkBase64;
    public List<MultiMediaDataTrack> mediaDataTracks;
    public boolean mIsAddWaterMark = false;
    public boolean mIsRunning = false;
    public boolean mCompat = false;
    public boolean mIsDefaultMale = false;

    public ComposeThemeVideoModel(Context context, String str, String str2) {
        this.mContext = context;
        this.mSourcePath = str;
        this.mOutputPath = str2;
    }

    public ComposeThemeVideoModel(Context context, List<MultiMediaDataTrack> list, String str, String str2) {
        this.mContext = context;
        this.mediaDataTracks = list;
        this.mAudioPath = str;
        this.mOutputPath = str2;
    }

    private void buildProcessorAndRenderer(List<IEffectProcessor> list, List<IMediaRenderer> list2, MultiMediaOutputSurface multiMediaOutputSurface) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        if (!this.mCompat) {
            AEffectProcessor aEffectProcessor = new AEffectProcessor();
            MediaTrackConfig mediaTrackConfig = this.editTrackConfig;
            aEffectProcessor.changeEffect(mediaTrackConfig.shaderConfigMapDebug, mediaTrackConfig.mediaTracks);
            list.add(aEffectProcessor);
            return;
        }
        vh0 vh0Var = new vh0();
        vh0Var.a(kxa.c().getContext());
        multiMediaOutputSurface.setVlogCore(vh0Var);
        MediaTrackConfig mediaTrackConfig2 = this.editTrackConfig;
        vh0Var.f(mediaTrackConfig2.mediaTracks, mediaTrackConfig2.shaderConfigMapDebug);
        MultiMediaDataSourceViewAdapter.buildDefault(list, list2);
        for (IEffectProcessor iEffectProcessor : list) {
            if (iEffectProcessor instanceof AREditProcessor) {
                final AREditProcessor aREditProcessor = (AREditProcessor) iEffectProcessor;
                AREditSticker aREditSticker = this.mAREditSticker;
                if (aREditSticker != null) {
                    aREditProcessor.setSticker(aREditSticker.sticker, aREditSticker.startTime, aREditSticker.endTime);
                }
                aREditProcessor.setBeautyValues((!this.mIsDefaultMale ? m1b.f(this.mAREditBeautyMap) : !m1b.f(this.mAREditBeautyMapForMale)) ? this.mAREditBeautyMapForMale : this.mAREditBeautyMap);
                if (isOpenImageQuality()) {
                    ImageQualityData imageQualityData = this.mImageQualityData;
                    aREditProcessor.setImageQualityStatus(imageQualityData.isOpen, imageQualityData.needDefog, imageQualityData.needDenoise);
                }
                aREditProcessor.setSyncInputContent(true);
                if (!m1b.f(this.mAREditBeautyMap) && !m1b.f(this.mAREditBeautyMapForMale)) {
                    aREditProcessor.setEditProcessCallback(new AREditProcessor.DuArEditProcessorCallback() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.3
                        public boolean isMale;

                        {
                            this.isMale = ComposeThemeVideoModel.this.mIsDefaultMale;
                        }

                        @Override // com.baidu.ugc.editvideo.record.processor.AREditProcessor.DuArEditProcessorCallback
                        public void onBeautyEnableChanged(kg0 kg0Var) {
                        }

                        @Override // com.baidu.ugc.editvideo.record.processor.AREditProcessor.DuArEditProcessorCallback
                        public void onChangeGender(boolean z) {
                            AREditProcessor aREditProcessor2;
                            Map<BeautyType, Object> map;
                            if (this.isMale == z) {
                                return;
                            }
                            this.isMale = z;
                            if (z) {
                                aREditProcessor2 = aREditProcessor;
                                map = ComposeThemeVideoModel.this.mAREditBeautyMapForMale;
                            } else {
                                aREditProcessor2 = aREditProcessor;
                                map = ComposeThemeVideoModel.this.mAREditBeautyMap;
                            }
                            aREditProcessor2.setBeautyValues(map);
                        }
                    });
                }
            }
        }
        if (m1b.e(this.mStickerList)) {
            return;
        }
        for (IMediaRenderer iMediaRenderer : list2) {
            if ((iMediaRenderer instanceof MultiMediaStickerRenderer) && (indexOf = this.editTrackConfig.mediaTracks.indexOf((subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.editTrackConfig.mediaTracks)))) >= 0) {
                this.mediaDataTracks.get(indexOf).multiMediaDataList = this.mStickerList;
                ((MultiMediaStickerRenderer) iMediaRenderer).setData(subtitleAndStickerTrack, this.mediaDataTracks.get(indexOf));
                iMediaRenderer.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkOrReportReady() {
        if (this.mIsAudioReady && this.mIsVideoReady && !this.mIsMuxerStop) {
            this.mMuxer.stop();
            this.mIsMuxerStop = true;
            z1b.a().postDelayed(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ComposeThemeVideoModel.this.mOnInterrupt) {
                        return;
                    }
                    ComposeThemeVideoModel.this.onMediaComplete();
                }
            }, 200L);
        }
    }

    private boolean hasAudioTrack(String str) {
        try {
            return s1b.g(str);
        } catch (Exception e) {
            e.printStackTrace();
            OnGenFilterVideoListener onGenFilterVideoListener = this.mListener;
            if (onGenFilterVideoListener != null) {
                onGenFilterVideoListener.onGenFilterVideoFail(-1, "check audio track error!" + r1b.g(e));
                return false;
            }
            return false;
        }
    }

    private boolean isOpenImageQuality() {
        return ImageQualityData.isValidStatus(this.mImageQualityData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMediaComplete() {
        int i;
        MediaMetadataRetriever mediaMetadataRetriever;
        if (this.mListener != null) {
            File file = new File(this.mOutputPath);
            boolean exists = file.exists();
            String str = "no exception";
            if (exists) {
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                    } catch (Exception e) {
                        e = e;
                        mediaMetadataRetriever = null;
                    } catch (Throwable th) {
                        th = th;
                        mediaMetadataRetriever = null;
                    }
                    try {
                        mediaMetadataRetriever.setDataSource(fileInputStream2.getFD());
                        i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        try {
                            str = e.toString();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            i = -1;
                            if (exists) {
                            }
                            StringBuilder sb = new StringBuilder("output file failed exist = " + exists);
                            sb.append(" length : ");
                            sb.append(file.length());
                            sb.append(" duration : ");
                            sb.append(i);
                            sb.append(" isOnInterrupt : ");
                            sb.append(this.mOnInterrupt);
                            sb.append(" eMsg : ");
                            sb.append(str);
                            if (file.getParentFile() != null) {
                            }
                            if (this.mVideoProcessor != null) {
                            }
                            sb.append(", mOutputPath = ");
                            sb.append(this.mOutputPath);
                            this.mListener.onGenFilterVideoFail(-1, sb.toString());
                            this.mIsRunning = false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (mediaMetadataRetriever != null) {
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    mediaMetadataRetriever = null;
                } catch (Throwable th4) {
                    th = th4;
                    mediaMetadataRetriever = null;
                }
                if (exists || file.length() <= 0 || i <= 0) {
                    StringBuilder sb2 = new StringBuilder("output file failed exist = " + exists);
                    sb2.append(" length : ");
                    sb2.append(file.length());
                    sb2.append(" duration : ");
                    sb2.append(i);
                    sb2.append(" isOnInterrupt : ");
                    sb2.append(this.mOnInterrupt);
                    sb2.append(" eMsg : ");
                    sb2.append(str);
                    if (file.getParentFile() != null) {
                        sb2.append(" draftDir exist :");
                        sb2.append(FileUtils.checkFile(file.getParentFile().getParent()));
                    }
                    if (this.mVideoProcessor != null) {
                        sb2.append(", detailMsg = ");
                        sb2.append(this.mVideoProcessor.getMuxerLog());
                    }
                    sb2.append(", mOutputPath = ");
                    sb2.append(this.mOutputPath);
                    this.mListener.onGenFilterVideoFail(-1, sb2.toString());
                } else {
                    this.mListener.onGenFilterVideoSuccess(this.mOutputPath);
                }
            }
            i = -1;
            if (exists) {
            }
            StringBuilder sb22 = new StringBuilder("output file failed exist = " + exists);
            sb22.append(" length : ");
            sb22.append(file.length());
            sb22.append(" duration : ");
            sb22.append(i);
            sb22.append(" isOnInterrupt : ");
            sb22.append(this.mOnInterrupt);
            sb22.append(" eMsg : ");
            sb22.append(str);
            if (file.getParentFile() != null) {
            }
            if (this.mVideoProcessor != null) {
            }
            sb22.append(", mOutputPath = ");
            sb22.append(this.mOutputPath);
            this.mListener.onGenFilterVideoFail(-1, sb22.toString());
        }
        this.mIsRunning = false;
    }

    public void initMultiVideoProcessor() {
        InnerMultiMediaProcessor innerMultiMediaProcessor = new InnerMultiMediaProcessor(this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2
            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onInterrupt() {
                ComposeThemeVideoModel.this.mOnInterrupt = true;
                if (this.mListener != null) {
                    z1b.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener = AnonymousClass2.this.mListener;
                            if (onGenFilterVideoListener != null) {
                                onGenFilterVideoListener.onGenFilterVideoAbort();
                            }
                        }
                    });
                }
                try {
                    File file = new File(ComposeThemeVideoModel.this.mOutputPath);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (this.mMuxer.isStarted()) {
                        this.mMuxer.stop();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    ComposeThemeVideoModel.this.mIsMuxerStop = true;
                    ComposeThemeVideoModel.this.mIsRunning = false;
                    throw th;
                }
                ComposeThemeVideoModel.this.mIsMuxerStop = true;
                ComposeThemeVideoModel.this.mIsRunning = false;
            }

            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onPostExecute() {
                ComposeThemeVideoModel.this.mIsVideoReady = true;
                ComposeThemeVideoModel.this.checkOrReportReady();
            }

            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onPreExecute() {
            }

            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onProgress(final int i) {
                if (this.mListener != null) {
                    z1b.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener = AnonymousClass2.this.mListener;
                            if (onGenFilterVideoListener != null) {
                                onGenFilterVideoListener.onGenFilterVideoProgress(i);
                            }
                        }
                    });
                }
            }
        };
        this.mVideoProcessor = innerMultiMediaProcessor;
        innerMultiMediaProcessor.setSubTitleUnits(this.mSubTitleUnits);
        ((InnerMultiMediaProcessor) this.mVideoProcessor).setSubTitleConfig(this.mSubTitleConfig);
        ((InnerMultiMediaProcessor) this.mVideoProcessor).setData(this.mediaDataTracks, this.editTrackConfig);
        this.mVideoProcessor.setRecordConfigEncodeHevcVideo(this.mEncodeHevcVideo);
        this.mVideoProcessor.setOutputVideoSize(this.mOutWidth, this.mOutHeight);
        this.mVideoProcessor.setOutputVideoBitRate(this.mOutBitRate);
        this.mVideoProcessor.setFrameRate(this.mFrameRate);
        MultiMediaOutputSurface multiMediaOutputSurface = new MultiMediaOutputSurface((IMultiMediaDataSource) this.mVideoProcessor);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        buildProcessorAndRenderer(arrayList, arrayList2, multiMediaOutputSurface);
        if (!m1b.e(arrayList)) {
            multiMediaOutputSurface.setEffectProcessors(arrayList);
        }
        if (!m1b.e(arrayList2)) {
            multiMediaOutputSurface.setMediaRenderers(arrayList2);
        }
        multiMediaOutputSurface.setPreviewSize(this.mPreviewWidth, this.mPreviewHeight);
        this.mVideoProcessor.setOutputSurface(multiMediaOutputSurface);
        this.mVideoProcessor.start();
    }

    public void initOneVideoProcessor() {
        InnerVideoProcessor innerVideoProcessor = new InnerVideoProcessor(this.mContext, this.mSourcePath, this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4
            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onInterrupt() {
                if (this.mListener != null) {
                    z1b.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener = AnonymousClass4.this.mListener;
                            if (onGenFilterVideoListener != null) {
                                onGenFilterVideoListener.onGenFilterVideoAbort();
                            }
                        }
                    });
                }
                try {
                    File file = new File(ComposeThemeVideoModel.this.mOutputPath);
                    if (file.exists()) {
                        file.delete();
                    }
                    this.mMuxer.stop();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    ComposeThemeVideoModel.this.mIsMuxerStop = true;
                    ComposeThemeVideoModel.this.mIsRunning = false;
                    throw th;
                }
                ComposeThemeVideoModel.this.mIsMuxerStop = true;
                ComposeThemeVideoModel.this.mIsRunning = false;
            }

            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onPostExecute() {
                ComposeThemeVideoModel.this.mIsVideoReady = true;
                ComposeThemeVideoModel.this.checkOrReportReady();
            }

            @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
            public void onProgress(final int i) {
                if (this.mListener != null) {
                    z1b.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            OnGenFilterVideoListener onGenFilterVideoListener = AnonymousClass4.this.mListener;
                            if (onGenFilterVideoListener != null) {
                                onGenFilterVideoListener.onGenFilterVideoProgress(i);
                            }
                        }
                    });
                }
            }
        };
        this.mVideoProcessor = innerVideoProcessor;
        innerVideoProcessor.setRecordConfigEncodeHevcVideo(this.mEncodeHevcVideo);
        this.mVideoProcessor.setOutputVideoSize(this.mOutWidth, this.mOutHeight);
        this.mVideoProcessor.setOutputVideoBitRate(this.mOutBitRate);
        this.mVideoProcessor.setPreviewVideoSize(this.mPreviewWidth, this.mPreviewHeight);
        this.mVideoProcessor.setFrameRate(this.mFrameRate);
        this.mVideoProcessor.setClipRange(this.mClipPoint, this.mClipDuration);
        ((InnerVideoProcessor) this.mVideoProcessor).setRotation(this.mRotation);
        if (this.mOutputSurface == null) {
            OutputSurfaceWithFilter outputSurfaceWithFilter = new OutputSurfaceWithFilter(this.mContext);
            outputSurfaceWithFilter.setFilterValue(this.mFilterValue);
            VideoEffectData videoEffectData = this.mVideoEffectData;
            if (videoEffectData != null) {
                outputSurfaceWithFilter.setMagicEffectList(videoEffectData.getMagicEffectList());
            }
            if (!TextUtils.isEmpty(this.mWaterMarkBase64)) {
                outputSurfaceWithFilter.setWaterMarkBitmap(i1b.a(this.mWaterMarkBase64));
            }
            outputSurfaceWithFilter.setAddWaterMark(this.mIsAddWaterMark);
            this.mOutputSurface = outputSurfaceWithFilter;
        }
        this.mVideoProcessor.setOutputSurface(this.mOutputSurface);
        this.mVideoProcessor.start();
    }

    public void interruptGenVideo() {
        InnerMediaProcessor innerMediaProcessor = this.mVideoProcessor;
        if (innerMediaProcessor != null) {
            innerMediaProcessor.interrupt();
            this.mVideoProcessor = null;
        }
        InnerAudioProcessor innerAudioProcessor = this.mAudioProcessor;
        if (innerAudioProcessor != null) {
            innerAudioProcessor.interrupt();
            this.mAudioProcessor = null;
        }
    }

    public boolean isAddWaterMark() {
        return this.mIsAddWaterMark;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void setAREditBeautyMap(Map<BeautyType, Object> map) {
        this.mAREditBeautyMap = map;
    }

    public void setAREditBeautyMapForMale(Map<BeautyType, Object> map) {
        this.mAREditBeautyMapForMale = map;
    }

    public void setAREditSticker(AREditSticker aREditSticker) {
        this.mAREditSticker = aREditSticker;
    }

    public void setAddWaterMark(boolean z) {
        this.mIsAddWaterMark = z;
    }

    public void setClipRange(long j, long j2) {
        this.mClipPoint = j;
        this.mClipDuration = j2;
    }

    public void setCompat(boolean z) {
        this.mCompat = z;
    }

    public void setDefaultMale(boolean z) {
        this.mIsDefaultMale = z;
    }

    public void setFilterValue(FilterValue filterValue) {
        this.mFilterValue = filterValue;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setImageQualityData(ImageQualityData imageQualityData) {
        this.mImageQualityData = imageQualityData;
    }

    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        this.editTrackConfig = mediaTrackConfig;
    }

    public void setOnGenerateListener(OnGenFilterVideoListener onGenFilterVideoListener) {
        this.mListener = onGenFilterVideoListener;
    }

    public void setOutputSurface(BaseOutputSurface baseOutputSurface) {
        this.mOutputSurface = baseOutputSurface;
    }

    public void setOutputVideoBitRate(int i) {
        this.mOutBitRate = i;
    }

    public void setOutputVideoSize(int i, int i2) {
        this.mOutWidth = i;
        this.mOutHeight = i2;
    }

    public void setPreviewVideoSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        this.mEncodeHevcVideo = z;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public void setStickerList(List<MultiMediaData> list) {
        this.mStickerList = list;
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        this.mSubTitleConfig = subTitleConfig;
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        this.mSubTitleUnits = list;
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        int duration;
        this.mVideoEffectData = videoEffectData;
        if (VideoEffectData.hasRepeatTimeEffect(videoEffectData)) {
            BaseEffect timeEffect = this.mVideoEffectData.getTimeEffect();
            MediaInfo d = s1b.d(this.mSourcePath);
            if (d != null && (duration = (int) d.getDuration()) > 100) {
                if (timeEffect.startTime < 0) {
                    timeEffect.startTime = 0;
                }
                int i = duration - 100;
                if (timeEffect.endTime > i) {
                    timeEffect.endTime = i;
                }
            }
            if (timeEffect.startTime >= timeEffect.endTime) {
                this.mVideoEffectData.setTimeEffect(null);
            }
        }
    }

    public void setWaterMarkBase64(String str) {
        this.mWaterMarkBase64 = str;
    }

    public void startMuxVideoAsync() {
        boolean hasAudioTrack;
        if (TextUtils.isEmpty(this.mSourcePath) && m1b.e(this.mediaDataTracks)) {
            OnGenFilterVideoListener onGenFilterVideoListener = this.mListener;
            if (onGenFilterVideoListener != null) {
                onGenFilterVideoListener.onGenFilterVideoFail(-1, "filter job cannot start by no input!");
            }
        } else if (this.mIsRunning) {
            OnGenFilterVideoListener onGenFilterVideoListener2 = this.mListener;
            if (onGenFilterVideoListener2 != null) {
                onGenFilterVideoListener2.onGenFilterVideoFail(-1, "filter job is running!");
            }
        } else {
            this.mIsRunning = true;
            this.mIsAudioReady = false;
            this.mIsVideoReady = false;
            this.mIsMuxerStop = false;
            this.mOnInterrupt = false;
            try {
                File file = new File(new File(this.mOutputPath).getParent());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                OnGenFilterVideoListener onGenFilterVideoListener3 = this.mListener;
                if (onGenFilterVideoListener3 != null) {
                    onGenFilterVideoListener3.onGenFilterVideoFail(-1, "filter job start mux error!" + r1b.g(e));
                }
                h1b.g(e);
            }
            try {
                this.mMuxer = new InnerMuxerWrapper(this.mOutputPath);
                if (TextUtils.isEmpty(this.mSourcePath)) {
                    hasAudioTrack = hasAudioTrack(this.mAudioPath);
                    if (!hasAudioTrack) {
                        this.mMuxer.setMuxAudio(false);
                        this.mIsAudioReady = true;
                    }
                    initMultiVideoProcessor();
                } else {
                    hasAudioTrack = hasAudioTrack(this.mSourcePath);
                    if (!hasAudioTrack) {
                        this.mMuxer.setMuxAudio(false);
                        this.mIsAudioReady = true;
                    }
                    initOneVideoProcessor();
                }
                if (hasAudioTrack) {
                    String str = TextUtils.isEmpty(this.mSourcePath) ? this.mAudioPath : this.mSourcePath;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    InnerAudioProcessor innerAudioProcessor = new InnerAudioProcessor(this.mContext, str, this.mMuxer, this.mListener) { // from class: com.baidu.ugc.editvideo.editvideo.addfilter.ComposeThemeVideoModel.1
                        @Override // com.baidu.ugc.editvideo.editvideo.addfilter.InnerMediaProcessor
                        public void onPostExecute() {
                            ComposeThemeVideoModel.this.mIsAudioReady = true;
                            ComposeThemeVideoModel.this.checkOrReportReady();
                        }
                    };
                    this.mAudioProcessor = innerAudioProcessor;
                    innerAudioProcessor.setClipRange(this.mClipPoint, this.mClipDuration);
                    this.mAudioProcessor.start();
                }
            } catch (Exception e2) {
                OnGenFilterVideoListener onGenFilterVideoListener4 = this.mListener;
                if (onGenFilterVideoListener4 != null) {
                    onGenFilterVideoListener4.onGenFilterVideoFail(-2, "FilterVideoGenerator muxer video async fail " + r1b.g(e2));
                }
            }
        }
    }
}
