package com.baidu.ugc.editvideo.record.source.multimedia;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTextureData;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tieba.eub;
import com.baidu.tieba.jc0;
import com.baidu.tieba.kxb;
import com.baidu.tieba.pc0;
import com.baidu.tieba.swb;
import com.baidu.tieba.twb;
import com.baidu.tieba.xwb;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.EglCore;
import com.baidu.ugc.editvideo.faceunity.gles.OffscreenSurface;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.VLogSimplePlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.ImportExportConfigUtil;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class MultiMediaDataSource implements Animator.AnimatorListener, Handler.Callback, IMultiMediaDataSource, IVLogCommunicateProtocol, IVlogEditManager, MultiMediaDataSourceRealTimer.AnimatorUpdateListener, MultiDataSourceUtil.OnInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener {
    public static final int Gl_THREAD_DELETE_ONE = 2;
    public static final int Gl_THREAD_INIT_ONE = 1;
    public static final int Gl_THREAD_MULTI_INIT_NEXT = 4;
    public static final int MSG_UPDATE_TIMELINE = 1;
    public volatile boolean isCancel;
    public volatile boolean isMute;
    public volatile boolean isPrepared;
    public volatile int[] mAudioChangeTypes;
    public Map<String, MediaTrack> mCommonTrackMap;
    public List<EffectChangeObserver> mEffectChangeObservers;
    public EGLContext mEglContext;
    public EglCore mEglCore;
    public List<MediaTrackChangeObserver> mMediaTrackChangeObservers;
    public MediaTrackConfig mMediaTrackConfig;
    public MultiMediaStateEventListener mMultiMediaStateEventListener;
    public MultiMediaTimelineUpdateListener mMultiMediaTimelineUpdateListener;
    public MultiMediaTimelineUpdateListener mMultiMediaTimelineUpdateListenerByMainThread;
    public volatile boolean mNeedInitMultiMediaData;
    public OffscreenSurface mOffscreenSurface;
    public IVLogPlayControlProtocol.OnPlayStateListener mOnPlayStateListener;
    public MediaTrack mOriginEffectTrack;
    public volatile long mPlayTime;
    public OnPreRunnableTask mPreRunnableTask;
    public IMultiMediaPreparedListener mPreparedListener;
    public NewSubTitleCreater mSubTitleCreater;
    public List<SubTitleUnit> mSubTitleUnitList;
    public volatile MultiMediaDataSourceRealTimer mTimer;
    public float mVideoRatio;
    public SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;
    public AtomicInteger mCurrentIndex = new AtomicInteger();
    public final Map<String, ShaderConfig> mShaderConfigMap = new HashMap();
    public List<MediaTrack> mUpdateMediaTracks = new ArrayList();
    public List<MultiMediaDataTrack> mUpdateMultiMediaDataTrack = new ArrayList();
    public volatile boolean isProgressSeeking = false;
    public volatile boolean isPaused = false;
    public volatile boolean isLooping = true;
    public volatile int mRepeatIndex = -1;
    public int mFrameRate = 30;
    public MultiMediaAdapter mMultiMediaAdapter = new MultiMediaAdapter() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.14
        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
        public void destroyPlayer(int i, MultiMediaData multiMediaData) {
            MultiMediaData multiMediaData2;
            MultiMediaDataTrack inputMultiMediaDataTrack = MultiMediaDataSource.this.getInputMultiMediaDataTrack();
            if (inputMultiMediaDataTrack == null || xwb.e(inputMultiMediaDataTrack.multiMediaDataList) || (multiMediaData2 = (MultiMediaData) xwb.c(inputMultiMediaDataTrack.multiMediaDataList, i)) == null) {
                return;
            }
            swb.b("destroyPlayer : " + i);
            if (!MultiMediaDataSource.this.isPaused) {
                MultiMediaDataSource.this.onReleaseMultiMedia(multiMediaData2);
                return;
            }
            multiMediaData2.releaseSurface();
            multiMediaData2.releasePlayer();
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
        public int getCount() {
            MultiMediaDataTrack inputMultiMediaDataTrack = MultiMediaDataSource.this.getInputMultiMediaDataTrack();
            if (inputMultiMediaDataTrack == null) {
                return 0;
            }
            return xwb.b(inputMultiMediaDataTrack.multiMediaDataList);
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
        public MultiMediaData instantiatePlayer(int i) {
            MultiMediaDataTrack inputMultiMediaDataTrack = MultiMediaDataSource.this.getInputMultiMediaDataTrack();
            if (inputMultiMediaDataTrack == null || xwb.e(inputMultiMediaDataTrack.multiMediaDataList)) {
                return null;
            }
            MultiMediaData multiMediaData = (MultiMediaData) xwb.c(inputMultiMediaDataTrack.multiMediaDataList, i);
            if (multiMediaData.player != null) {
                return null;
            }
            if (multiMediaData.type == 1) {
                MultiMediaDataSource.this.createPlayer(multiMediaData);
            }
            if (multiMediaData.textureId == 0) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = multiMediaData;
                MultiMediaDataSource.this.mReadPhotoHandler.sendMessage(obtain);
            } else {
                MultiMediaDataSource.this.bindPlayerSurfaceTexture(multiMediaData);
            }
            swb.b("instantiatePlayer : " + i);
            return multiMediaData;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
        public boolean isPlayerType(int i) {
            MultiMediaDataTrack inputMultiMediaDataTrack = MultiMediaDataSource.this.getInputMultiMediaDataTrack();
            return (inputMultiMediaDataTrack == null || xwb.e(inputMultiMediaDataTrack.multiMediaDataList) || ((MultiMediaData) xwb.c(inputMultiMediaDataTrack.multiMediaDataList, i)) == null) ? false : true;
        }
    };
    public Handler mMainHandler = new Handler(Looper.getMainLooper(), this);
    public Handler mReadPhotoHandler = new Handler(MultiMediaDataSourceTimerManager.getInstance().getReadPhotoLooper()) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.1
        public EGLContext mInnerEglContext;

        private void initGlResource(MultiMediaData multiMediaData) {
            if (multiMediaData == null) {
                return;
            }
            try {
                if (MultiMediaDataSource.this.mEglContext == null || MultiMediaDataSource.this.isPaused || MultiMediaDataSource.this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                    return;
                }
                MultiMediaDataSource.this.mOffscreenSurface.makeCurrent();
                MultiMediaDataSource.this.initMultiMedia(multiMediaData);
            } catch (RuntimeException e) {
                if (pc0.l()) {
                    Log.d(pc0.a, e.getLocalizedMessage());
                }
            }
        }

        private void initNextGlResource(MultiMediaData multiMediaData) {
            if (multiMediaData == null) {
                return;
            }
            try {
                if (MultiMediaDataSource.this.mEglContext == null || MultiMediaDataSource.this.isPaused || MultiMediaDataSource.this.mEglContext == EGL14.EGL_NO_CONTEXT) {
                    return;
                }
                MultiMediaDataSource.this.mOffscreenSurface.makeCurrent();
                int i = multiMediaData.frameIndex != multiMediaData.frameCount ? multiMediaData.frameIndex + 1 : 0;
                if (i == multiMediaData.frameCount) {
                    i = 0;
                }
                Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(multiMediaData.path + File.separator + i + "." + multiMediaData.frameSuffix);
                try {
                    int type = GLUtils.getType(decodeBitmap);
                    int internalFormat = GLUtils.getInternalFormat(decodeBitmap);
                    swb.b("type : " + type + " internalFormat : " + internalFormat);
                } catch (Exception unused) {
                    decodeBitmap = twb.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
                }
                if (multiMediaData.backupFrameTextureId != 0) {
                    GLES20.glBindTexture(3553, multiMediaData.backupFrameTextureId);
                } else {
                    multiMediaData.backupFrameTextureId = jc0.b();
                }
                GLUtils.texImage2D(3553, 0, decodeBitmap, 0);
                GLES20.glBindTexture(3553, 0);
                decodeBitmap.recycle();
            } catch (RuntimeException e) {
                if (pc0.l()) {
                    Log.d(pc0.a, e.getLocalizedMessage());
                }
            }
        }

        private void initSurface() {
            try {
                EGLContext eGLContext = MultiMediaDataSource.this.mEglContext;
                if (eGLContext == null) {
                    this.mInnerEglContext = null;
                    swb.b("no gl context");
                    return;
                }
                if (this.mInnerEglContext != null) {
                    if (eGLContext != null && eGLContext != this.mInnerEglContext && eGLContext != EGL14.EGL_NO_CONTEXT) {
                        MultiMediaDataSource.this.releaseEgl();
                    }
                    if (MultiMediaDataSource.this.mEglCore == null || this.mInnerEglContext == null || this.mInnerEglContext == EGL14.EGL_NO_CONTEXT) {
                        return;
                    }
                    MultiMediaDataSource.this.mEglCore = new EglCore(this.mInnerEglContext, 2);
                    MultiMediaDataSource.this.mOffscreenSurface = new OffscreenSurface(MultiMediaDataSource.this.mEglCore, 1, 1);
                    return;
                }
                this.mInnerEglContext = eGLContext;
                if (MultiMediaDataSource.this.mEglCore == null) {
                }
            } catch (Exception e) {
                if (pc0.l()) {
                    Log.d(pc0.a, e.getLocalizedMessage());
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            swb.b("initSurface what : " + message.what + " mInnerEglContext : " + this.mInnerEglContext + " MultiMediaDataSource.this.mEglContext : " + MultiMediaDataSource.this.mEglContext);
            initSurface();
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (obj instanceof MultiMediaData) {
                    initGlResource((MultiMediaData) obj);
                }
            } else if (i == 2) {
                MultiDataSourceUtil.glDeleteTextures(message.arg1);
            } else if (i != 4) {
            } else {
                Object obj2 = message.obj;
                if (obj2 instanceof MultiMediaData) {
                    initNextGlResource((MultiMediaData) obj2);
                }
            }
        }
    };

    private void applyTimeLineOnTemplateType() {
        MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
        if (mediaTrackConfig == null || !TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE) || xwb.e(this.mMediaTrackConfig.mediaTracks) || getInputTrack() == null) {
            return;
        }
        pc0.d(getInputTrack(), getInputSegmentFromConfig(), this.mMediaTrackConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindPlayerSurfaceTexture(final MultiMediaData multiMediaData) {
        VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
        if (vLogSimplePlayer == null) {
            return;
        }
        multiMediaData.playerReady = false;
        SurfaceTexture surfaceTexture = new SurfaceTexture(multiMediaData.textureId);
        multiMediaData.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.25
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                if (multiMediaData.playerReady || surfaceTexture2.getTimestamp() == 0) {
                    return;
                }
                multiMediaData.playerReady = true;
            }
        });
        Surface surface = new Surface(multiMediaData.surfaceTexture);
        multiMediaData.surface = surface;
        vLogSimplePlayer.setSurface(surface);
        float f = this.isMute ? 0.0f : 1.0f;
        vLogSimplePlayer.setVolume(f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MultiMediaData createMultiMediaData(MultiMediaData multiMediaData, long j, MediaSegment mediaSegment) {
        MultiMediaData multiMediaData2 = (MultiMediaData) multiMediaData.clone();
        multiMediaData2.textureId = 0;
        multiMediaData2.backupFrameTextureId = 0;
        multiMediaData2.mtx = new float[16];
        multiMediaData2.surfaceTexture = null;
        multiMediaData2.surface = null;
        multiMediaData2.player = null;
        multiMediaData2.uuid = null;
        multiMediaData2.subTitleText = null;
        multiMediaData2.start = j;
        multiMediaData2.end = multiMediaData.end;
        mediaSegment.end = (j - multiMediaData.start) + mediaSegment.start;
        multiMediaData.end = j;
        return multiMediaData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void createPlayer(final MultiMediaData multiMediaData) {
        if (multiMediaData.type != 0 && multiMediaData.player == null) {
            VLogSimplePlayer vLogSimplePlayer = new VLogSimplePlayer(multiMediaData.path);
            vLogSimplePlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.20
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    SurfaceTexture surfaceTexture;
                    MultiMediaData multiMediaData2 = multiMediaData;
                    if (!multiMediaData2.playerReady && (surfaceTexture = multiMediaData2.surfaceTexture) != null && surfaceTexture.getTimestamp() != 0) {
                        multiMediaData.playerReady = true;
                    }
                    MultiMediaDataSource.this.notifyFrameAvailable();
                }
            });
            vLogSimplePlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.21
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
                public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                    SurfaceTexture surfaceTexture;
                    if (i == 3) {
                        MultiMediaData multiMediaData2 = multiMediaData;
                        if (!multiMediaData2.playerReady && (surfaceTexture = multiMediaData2.surfaceTexture) != null && surfaceTexture.getTimestamp() != 0) {
                            multiMediaData.playerReady = true;
                        }
                    } else if (i != 702) {
                        return false;
                    }
                    MultiMediaDataSource.this.notifyFrameAvailable();
                    return false;
                }
            });
            vLogSimplePlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.22
                /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET, IPUT, IF] complete} */
                /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
                    r2.player = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
                    if (r2 == null) goto L12;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
                    if (r0.this$0.isPaused != false) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
                    r0.this$0.createPlayer(r2);
                    r0.this$0.bindPlayerSurfaceTexture(r2);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
                    return false;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
                    return false;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
                    if (r2 != null) goto L11;
                 */
                /* JADX WARN: Finally extract failed */
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                    MultiMediaData multiMediaData2;
                    try {
                        if (multiMediaData != null && multiMediaData.player != null) {
                            multiMediaData.player.release();
                        }
                        multiMediaData2 = multiMediaData;
                    } catch (Throwable th) {
                        try {
                            swb.g(th);
                            multiMediaData2 = multiMediaData;
                        } catch (Throwable th2) {
                            MultiMediaData multiMediaData3 = multiMediaData;
                            if (multiMediaData3 != null) {
                                multiMediaData3.player = null;
                            }
                            throw th2;
                        }
                    }
                }
            });
            vLogSimplePlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.23
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                    MultiMediaDataSource.this.notifyFrameAvailable(multiMediaData.surfaceTexture);
                }
            });
            vLogSimplePlayer.setOnSpeedChangeListener(new IMediaPlayer.OnSpeedChangeListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.24
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSpeedChangeListener
                public void onSpeedChange(float f) {
                    if (MultiMediaDataSource.this.mOnPlayStateListener != null) {
                        MultiMediaDataSource.this.mOnPlayStateListener.onSpeedChanged(f, multiMediaData);
                    }
                }
            });
            float f = this.isMute ? 0.0f : multiMediaData.volume;
            vLogSimplePlayer.setVolume(f, f);
            if (MediaSegment.SEG_TYPE_INPUT_SUPERPOSITION_FOOTER.equals(multiMediaData.inputType)) {
                vLogSimplePlayer.seekTo(0L);
            } else {
                vLogSimplePlayer.seekTo(multiMediaData.start);
            }
            vLogSimplePlayer.setAudioChangeType(this.mAudioChangeTypes);
            vLogSimplePlayer.setSpeed(multiMediaData.getCurrentSpeed());
            multiMediaData.player = vLogSimplePlayer;
        }
    }

    private MediaTrack getEffectTrack() {
        MediaTrack effectTrack = MultiDataSourceUtil.getEffectTrack(this.mUpdateMediaTracks);
        if (effectTrack == null) {
            effectTrack = new MediaTrack();
            effectTrack.trackType = "effect";
            MediaTrack inputTrack = getInputTrack();
            int i = 1;
            if (inputTrack != null && TextUtils.equals("input_blank", inputTrack.trackType)) {
                int i2 = 1;
                while (i < this.mUpdateMediaTracks.size()) {
                    MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i);
                    if (mediaTrack != null && TextUtils.equals("multi_input", mediaTrack.trackType)) {
                        i2++;
                    }
                    i++;
                }
                i = i2;
            }
            this.mUpdateMediaTracks.add(i, effectTrack);
            this.mUpdateMultiMediaDataTrack.add(i, new MultiMediaDataTrack());
        }
        if (xwb.e(effectTrack.mediaSegments)) {
            effectTrack.mediaSegments = new ArrayList();
        }
        return effectTrack;
    }

    private ArrayList<MultiMediaData> getInputMultiMediaDataList() {
        if (getInputMultiMediaDataTrack() == null) {
            return null;
        }
        return (ArrayList) getInputMultiMediaDataTrack().multiMediaDataList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MultiMediaDataTrack getInputMultiMediaDataTrack() {
        return (MultiMediaDataTrack) xwb.c(this.mUpdateMultiMediaDataTrack, 0);
    }

    private List<MediaSegment> getInputSegmentFromConfig() {
        ArrayList arrayList = new ArrayList();
        for (MediaTrack mediaTrack : this.mMediaTrackConfig.mediaTracks) {
            if (mediaTrack != null && !xwb.e(mediaTrack.mediaSegments)) {
                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                    if (mediaSegment != null && "input".equals(mediaSegment.type)) {
                        arrayList.add(mediaSegment);
                    }
                }
                if (!xwb.e(arrayList)) {
                    break;
                }
            }
        }
        return arrayList;
    }

    private MediaTrack getInputTrack() {
        return (MediaTrack) xwb.c(this.mUpdateMediaTracks, 0);
    }

    private long getMaxVideoDurationFromConfig() {
        MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
        if (mediaTrackConfig == null) {
            return 0L;
        }
        return mediaTrackConfig.maxVideoDuration;
    }

    private int getOriginalInputSize() {
        int size = getInputMultiMediaDataTrack().multiMediaDataList.size();
        if (getInputMultiMediaDataTrack().hasHeader()) {
            size--;
        }
        return getInputMultiMediaDataTrack().hasFooter() ? size - 1 : size;
    }

    private long getSegmentsDuration() {
        return MultiDataSourceUtil.getSegmentsDuration(getInputTrack());
    }

    private void initAllPlayers() {
        if (xwb.e(this.mUpdateMultiMediaDataTrack)) {
            return;
        }
        int b = xwb.b(this.mUpdateMultiMediaDataTrack);
        if (b > 0) {
            MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
            MultiMediaData multiMediaData = inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader;
            if (multiMediaData != null && multiMediaData.type == 1) {
                createPlayer(multiMediaData);
            }
            MultiMediaData multiMediaData2 = inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter;
            if (multiMediaData2 != null && multiMediaData2.type == 1) {
                createPlayer(multiMediaData2);
            }
        }
        for (int i = 1; i < b; i++) {
            if (!xwb.e(this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataList)) {
                List<MultiMediaData> list = this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataList;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MultiMediaData multiMediaData3 = list.get(i2);
                    if (multiMediaData3.type == 1) {
                        createPlayer(multiMediaData3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initMultiMedia(MultiMediaData multiMediaData) {
        initMultiMedia(multiMediaData, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initMultiMedia(MultiMediaData multiMediaData, long j) {
        if (multiMediaData != null) {
            if (!TextUtils.isEmpty(multiMediaData.path) && ((multiMediaData.textureId == 0 || multiMediaData.isFrameSequential()) && !this.isPaused)) {
                if (multiMediaData.type == 0) {
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
                        if (i2 == multiMediaData.frameIndex && multiMediaData.textureId != 0) {
                            return;
                        }
                        if (multiMediaData.backupFrameTextureId != 0) {
                            multiMediaData.frameIndex = i2;
                            multiMediaData.releasePlayer();
                            multiMediaData.releaseSurface();
                            int i3 = multiMediaData.textureId;
                            multiMediaData.textureId = multiMediaData.backupFrameTextureId;
                            multiMediaData.backupFrameTextureId = i3;
                        } else {
                            multiMediaData.frameIndex = i2;
                            multiMediaData.releasePlayer();
                            multiMediaData.releaseSurface();
                            MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                            Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(str + File.separator + "" + i2 + "." + multiMediaData.frameSuffix);
                            try {
                                swb.b("type : " + GLUtils.getType(decodeBitmap) + " internalFormat : " + GLUtils.getInternalFormat(decodeBitmap));
                            } catch (Exception unused) {
                                decodeBitmap = twb.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
                            }
                            multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap);
                        }
                        Message obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = multiMediaData;
                        this.mReadPhotoHandler.sendMessage(obtain);
                    } else {
                        Bitmap decodeBitmap2 = MultiDataSourceUtil.decodeBitmap(str);
                        try {
                            swb.b("type : " + GLUtils.getType(decodeBitmap2) + " internalFormat : " + GLUtils.getInternalFormat(decodeBitmap2));
                        } catch (Exception unused2) {
                            decodeBitmap2 = twb.c(decodeBitmap2, Bitmap.CompressFormat.PNG, 100);
                        }
                        multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap2);
                    }
                } else {
                    if (multiMediaData.width == 0 || multiMediaData.height == 0 || multiMediaData.originalDuration == 0) {
                        MultiDataSourceUtil.initVideoByPath(multiMediaData);
                    }
                    multiMediaData.textureId = jc0.d();
                    Matrix.setIdentityM(multiMediaData.mtx, 0);
                    bindPlayerSurfaceTexture(multiMediaData);
                }
            }
        }
    }

    public static boolean interceptUpdateByRepeat(MediaTrack mediaTrack, int i, long j) {
        int[] findIndexInSegments;
        int i2 = -1;
        for (int i3 : MultiDataSourceUtil.findIndexInSegments(mediaTrack.mediaSegments, j)) {
            if (i2 == -1 || i2 > i3) {
                i2 = i3;
            }
        }
        return (i == -1 || i == i2) ? false : true;
    }

    private void log() {
        if (pc0.l()) {
            Log.d(pc0.a, "---------------------MultiMediaData--start----------------------------");
            if (this.mUpdateMultiMediaDataTrack != null) {
                for (int i = 0; i < this.mUpdateMultiMediaDataTrack.size(); i++) {
                    MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(i);
                    if (multiMediaDataTrack.multiMediaDataList != null) {
                        for (int i2 = 0; i2 < multiMediaDataTrack.multiMediaDataList.size(); i2++) {
                            MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i2);
                            String str = pc0.a;
                            Log.d(str, "track : " + i + " --> multiMediaData : " + i2 + ": " + multiMediaData.start + "----" + multiMediaData.end + "---> tid : " + multiMediaData.textureId + " path : " + multiMediaData.path + " rotation : " + multiMediaData.rotation + " w : " + multiMediaData.width + " h : " + multiMediaData.height + " defaultEffect : " + multiMediaData.addDefaultEffect);
                        }
                    }
                    MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
                    if (multiMediaData2 != null) {
                        String str2 = pc0.a;
                        Log.d(str2, "SuperpositionHeader track : " + i + " --> multiMediaData  : " + multiMediaData2.start + "----" + multiMediaData2.end + "---> tid : " + multiMediaData2.textureId + " path : " + multiMediaData2.path + " rotation : " + multiMediaData2.rotation + " w : " + multiMediaData2.width + " h : " + multiMediaData2.height);
                    }
                    MultiMediaData multiMediaData3 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
                    if (multiMediaData3 != null) {
                        String str3 = pc0.a;
                        Log.d(str3, "SuperpositionFooter track : " + i + " --> multiMediaData  : " + multiMediaData3.start + "----" + multiMediaData3.end + "---> tid : " + multiMediaData3.textureId + " path : " + multiMediaData3.path + " rotation : " + multiMediaData3.rotation + " w : " + multiMediaData3.width + " h : " + multiMediaData3.height);
                    }
                }
            }
            Log.d(pc0.a, "-----------------MultiMediaData---end-----------------------------");
        }
    }

    private void notifyEffectChanged() {
        int b = xwb.b(this.mEffectChangeObservers);
        for (int i = 0; i < b; i++) {
            EffectChangeObserver effectChangeObserver = (EffectChangeObserver) xwb.c(this.mEffectChangeObservers, i);
            if (effectChangeObserver != null) {
                effectChangeObserver.onChanged(getShaderConfigMap(), getUpdateMediaTracks());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable() {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.onFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.onFrameAvailable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.onFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.onFrameAvailable(surfaceTexture);
        }
    }

    private void notifyIndexChanged(int i, int i2) {
        MultiMediaStateEventListener multiMediaStateEventListener;
        if (i == i2 || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onIndexChanged(i, i2);
    }

    private void notifyLoop() {
        MultiMediaStateEventListener multiMediaStateEventListener = this.mMultiMediaStateEventListener;
        if (multiMediaStateEventListener != null) {
            multiMediaStateEventListener.onLoop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMediaTracksChanged() {
        int b = xwb.b(this.mMediaTrackChangeObservers);
        for (int i = 0; i < b; i++) {
            MediaTrackChangeObserver mediaTrackChangeObserver = (MediaTrackChangeObserver) xwb.c(this.mMediaTrackChangeObservers, i);
            if (mediaTrackChangeObserver != null) {
                mediaTrackChangeObserver.onChanged(getUpdateMediaTracks());
            }
        }
    }

    private void notifyPlayEnd() {
        MultiMediaStateEventListener multiMediaStateEventListener = this.mMultiMediaStateEventListener;
        if (multiMediaStateEventListener != null) {
            multiMediaStateEventListener.onPlayEnd();
        }
    }

    private void notifyRepeatIndexEnd(int i) {
        MultiMediaStateEventListener multiMediaStateEventListener = this.mMultiMediaStateEventListener;
        if (multiMediaStateEventListener != null) {
            multiMediaStateEventListener.onRepeatIndexEnd(i);
        }
    }

    private void notifyRepeatIndexLoop(int i) {
        MultiMediaStateEventListener multiMediaStateEventListener = this.mMultiMediaStateEventListener;
        if (multiMediaStateEventListener != null) {
            multiMediaStateEventListener.onRepeatIndexLoop(i);
        }
    }

    private void notifyTimelineUpdate(long j) {
        if (this.mMultiMediaTimelineUpdateListener != null) {
            updateSubtitle(j);
            this.mMultiMediaTimelineUpdateListener.onTimelineUpdate(j, getSegmentsDuration());
        }
        if (this.mMultiMediaTimelineUpdateListenerByMainThread != null) {
            Handler handler = this.mMainHandler;
            handler.sendMessage(handler.obtainMessage(1, Long.valueOf(j)));
        }
        if (this.mMultiMediaTimelineUpdateListener == null && this.mMultiMediaTimelineUpdateListenerByMainThread == null) {
            updateSubtitle(j);
        }
    }

    private void pausePlayer(boolean z) {
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        VLogSimplePlayer vLogSimplePlayer3;
        List<MultiMediaDataTrack> list = this.mUpdateMultiMediaDataTrack;
        if (xwb.e(list)) {
            return;
        }
        int b = xwb.b(list);
        for (int i = 0; i < b; i++) {
            MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) xwb.c(list, i);
            if (multiMediaDataTrack != null) {
                MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
                if (multiMediaData != null && multiMediaData.type == 1 && (vLogSimplePlayer3 = multiMediaData.player) != null) {
                    if (vLogSimplePlayer3.isPlaying()) {
                        vLogSimplePlayer3.pause();
                    }
                    if (z) {
                        vLogSimplePlayer3.seekTo(multiMediaData.start);
                    }
                }
                MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
                if (multiMediaData2 != null && multiMediaData2.type == 1 && (vLogSimplePlayer2 = multiMediaData2.player) != null) {
                    if (vLogSimplePlayer2.isPlaying()) {
                        vLogSimplePlayer2.pause();
                    }
                    if (z) {
                        vLogSimplePlayer2.seekTo(0L);
                    }
                }
                List<MultiMediaData> list2 = multiMediaDataTrack.multiMediaDataList;
                if (!xwb.e(list2)) {
                    int b2 = xwb.b(list2);
                    for (int i2 = 0; i2 < b2; i2++) {
                        MultiMediaData multiMediaData3 = list2.get(i2);
                        if (multiMediaData3.type == 1 && (vLogSimplePlayer = multiMediaData3.player) != null) {
                            if (vLogSimplePlayer.isPlaying()) {
                                vLogSimplePlayer.pause();
                            }
                            if (z) {
                                vLogSimplePlayer.seekTo(multiMediaData3.start);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPrepared() {
        this.mNeedInitMultiMediaData = false;
        if (this.isPrepared) {
            return;
        }
        kxb.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.19
            @Override // java.lang.Runnable
            public void run() {
                if (MultiMediaDataSource.this.mPreparedListener != null) {
                    MultiMediaDataSource.this.mPreparedListener.onPrepared();
                }
            }
        });
        this.isPrepared = true;
    }

    private void refreshUpdateMultiMediaDataTrack(List<MultiMediaData> list) {
        String str;
        String str2;
        MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
        MultiMediaData multiMediaData = null;
        MultiMediaData multiMediaData2 = inputMultiMediaDataTrack.hasHeader() ? inputMultiMediaDataTrack.multiMediaDataList.get(0) : null;
        if (inputMultiMediaDataTrack.hasFooter()) {
            List<MultiMediaData> list2 = inputMultiMediaDataTrack.multiMediaDataList;
            multiMediaData = list2.get(list2.size() - 1);
        }
        ArrayList arrayList = new ArrayList();
        List<MultiMediaData> list3 = inputMultiMediaDataTrack.multiMediaDataList;
        if (list3 == null || list3.size() == 0 || list == null || list.size() == 0) {
            return;
        }
        for (MultiMediaData multiMediaData3 : list) {
            Iterator<MultiMediaData> it = inputMultiMediaDataTrack.multiMediaDataList.iterator();
            while (true) {
                if (it.hasNext()) {
                    MultiMediaData next = it.next();
                    if (multiMediaData3 != null && next != null && (str = multiMediaData3.path) != null && (str2 = next.path) != null && str.equals(str2) && multiMediaData3.start == next.start && multiMediaData3.end == next.end) {
                        arrayList.add(next);
                        break;
                    }
                }
            }
        }
        inputMultiMediaDataTrack.multiMediaDataList.clear();
        if (multiMediaData2 != null) {
            inputMultiMediaDataTrack.multiMediaDataList.add(multiMediaData2);
        }
        inputMultiMediaDataTrack.multiMediaDataList.addAll(arrayList);
        if (multiMediaData != null) {
            inputMultiMediaDataTrack.multiMediaDataList.add(multiMediaData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseEgl() {
        OffscreenSurface offscreenSurface = this.mOffscreenSurface;
        if (offscreenSurface != null) {
            offscreenSurface.release();
            this.mOffscreenSurface = null;
            swb.b("releaseEgl mOffscreenSurface");
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
            this.mEglCore = null;
            swb.b("releaseEgl mEglCore");
        }
        this.mEglContext = null;
    }

    private void releaseSubtitleCache() {
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater != null) {
            newSubTitleCreater.releaseBitmap();
        }
    }

    private void releaseSurface() {
        int b = xwb.b(this.mUpdateMultiMediaDataTrack);
        for (int i = 0; i < b; i++) {
            List<MultiMediaData> list = this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataList;
            if (list != null) {
                for (MultiMediaData multiMediaData : list) {
                    multiMediaData.releaseSurface();
                    multiMediaData.releasePlayer();
                }
            }
            if (this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionHeader != null) {
                this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionHeader.releaseSurface();
                this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionHeader.releasePlayer();
            }
            if (this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionFooter != null) {
                this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionFooter.releaseSurface();
                this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionFooter.releasePlayer();
            }
        }
    }

    private void resetTimer() {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
        if (multiMediaDataSourceRealTimer == null) {
            return;
        }
        multiMediaDataSourceRealTimer.reset();
        this.mTimer = null;
    }

    private void runOnDraw(Runnable runnable) {
        OnPreRunnableTask onPreRunnableTask = this.mPreRunnableTask;
        if (onPreRunnableTask == null || onPreRunnableTask.getRunOnDrawList() == null) {
            return;
        }
        this.mPreRunnableTask.getRunOnDrawList().add(runnable);
    }

    private int seekInternal(MediaTrack mediaTrack, List<MultiMediaData> list, long j, int i) {
        List<MultiMediaData> list2;
        int i2;
        int[] findIndexInSegments = MultiDataSourceUtil.findIndexInSegments(mediaTrack.mediaSegments, j);
        int i3 = -1;
        int i4 = 0;
        int i5 = -1;
        while (i4 < findIndexInSegments.length) {
            int i6 = findIndexInSegments[i4];
            if (i5 == i3 || i5 > i6) {
                list2 = list;
                i5 = i6;
            } else {
                list2 = list;
            }
            final MultiMediaData multiMediaData = (MultiMediaData) xwb.c(list2, i6);
            MediaSegment mediaSegment = (MediaSegment) xwb.c(mediaTrack.mediaSegments, i6);
            if (multiMediaData == null || mediaSegment == null) {
                i2 = i4;
            } else {
                int i7 = multiMediaData.type;
                if (i7 == 1) {
                    VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                    if (vLogSimplePlayer == null) {
                        return i5;
                    }
                    long j2 = this.mPlayTime;
                    i2 = i4;
                    long j3 = mediaSegment.start;
                    vLogSimplePlayer.seekTo(j2 > j3 ? Math.min((((float) (j - j3)) * multiMediaData.getCurrentSpeed()) + ((float) multiMediaData.start), (float) multiMediaData.end) : multiMediaData.start);
                    if (i == 2 || i == 3) {
                        vLogSimplePlayer.start();
                    }
                } else {
                    i2 = i4;
                    if (i7 == 0 && multiMediaData.isFrameSequential()) {
                        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.18
                            @Override // java.lang.Runnable
                            public void run() {
                                MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                            }
                        });
                    }
                }
            }
            i4 = i2 + 1;
            i3 = -1;
        }
        return i5;
    }

    private void seekSuperpositionHeaderAndFooter(int i, MediaTrack mediaTrack) {
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
        if (inputMultiMediaDataTrack == null) {
            return;
        }
        MultiMediaData multiMediaData = inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader;
        MultiMediaData multiMediaData2 = inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter;
        if (multiMediaData != null && multiMediaData.type == 1 && multiMediaData.player != null && this.mPlayTime >= 0 && this.mPlayTime < multiMediaData.end && (mediaSegment2 = mediaTrack.superpositionHeader) != null) {
            long j = this.mPlayTime;
            long j2 = mediaSegment2.start;
            long j3 = multiMediaData.end;
            long j4 = multiMediaData.start;
            long j5 = ((j - j2) * (j3 - j4)) / (mediaSegment2.end - j2);
            if (j5 >= 0 && j5 < j3) {
                multiMediaData.player.seekTo(j5 + j4);
                if (i == 2 || i == 3) {
                    multiMediaData.player.start();
                }
            }
        }
        if (multiMediaData2 == null || multiMediaData2.type != 1 || multiMediaData2.player == null || this.mPlayTime < multiMediaData2.start || this.mPlayTime > multiMediaData2.end || (mediaSegment = mediaTrack.superpositionFooter) == null) {
            return;
        }
        long j6 = this.mPlayTime;
        long j7 = mediaSegment.start;
        long j8 = multiMediaData2.end;
        long j9 = multiMediaData2.start;
        long j10 = ((j6 - j7) * (j8 - j9)) / (mediaSegment.end - j7);
        if (j10 < j9 || j10 >= j8) {
            return;
        }
        multiMediaData2.player.seekTo(j10 + j9);
        if (i == 2 || i == 3) {
            multiMediaData2.player.start();
        }
    }

    private void setCurrentSubtitle(final SubTitleUnit subTitleUnit) {
        Bitmap bitmap;
        MediaTrack buildSubtitleAndStickerTrack;
        int indexOf;
        if (subTitleUnit == null || (bitmap = subTitleUnit.textBitmap) == null || bitmap.isRecycled() || this.mSubTitleUnitList == null || this.mUpdateMediaTracks.size() != this.mUpdateMultiMediaDataTrack.size() || (indexOf = this.mUpdateMediaTracks.indexOf((buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack)))) < 0) {
            return;
        }
        MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf);
        List<MediaSegment> list = buildSubtitleAndStickerTrack.mediaSegments;
        if (list == null || multiMediaDataTrack.multiMediaDataList == null || list.size() != multiMediaDataTrack.multiMediaDataList.size()) {
            return;
        }
        for (int i = 0; i < buildSubtitleAndStickerTrack.mediaSegments.size(); i++) {
            MediaSegment mediaSegment = buildSubtitleAndStickerTrack.mediaSegments.get(i);
            final MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i);
            if (TextUtils.equals(mediaSegment.type, SubtitleLog.TAG)) {
                if (TextUtils.equals(multiMediaData.subTitleText, subTitleUnit.line) && multiMediaData.textureId != 0 && subTitleUnit.mIsNeedCache) {
                    return;
                }
                mediaSegment.effectStart = subTitleUnit.startTime;
                mediaSegment.effectEnd = subTitleUnit.endTime;
                mediaSegment.mediaAEffect = pc0.i(buildSubtitleAndStickerTrack, this.mMediaTrackConfig, mediaSegment.type, this.mSubTitleUnitList.indexOf(subTitleUnit), this.mSubTitleUnitList.size(), subTitleUnit.endTime - subTitleUnit.startTime);
                swb.c("zmy", "subTitleUnit.line : " + subTitleUnit.line + " multiMediaData.subTitleText : " + multiMediaData.subTitleText + " subTitleUnit.startTime : " + subTitleUnit.startTime + " end :" + subTitleUnit.startTime + " playTime : " + this.mPlayTime);
                multiMediaData.subTitleText = subTitleUnit.line;
                runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.7
                    @Override // java.lang.Runnable
                    public void run() {
                        MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                        if (TextUtils.isEmpty(multiMediaData.subTitleText)) {
                            return;
                        }
                        MultiMediaData multiMediaData2 = multiMediaData;
                        multiMediaData2.width = 0;
                        multiMediaData2.height = 0;
                        if (!subTitleUnit.textBitmap.isRecycled()) {
                            Bitmap copy = subTitleUnit.textBitmap.copy(Bitmap.Config.ARGB_8888, false);
                            MultiMediaData multiMediaData3 = multiMediaData;
                            multiMediaData3.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData3, copy);
                        }
                        MultiMediaData multiMediaData4 = multiMediaData;
                        multiMediaData4.scaleType = "adaptive";
                        SubTitleUnit subTitleUnit2 = subTitleUnit;
                        multiMediaData4.start = subTitleUnit2.startTime;
                        multiMediaData4.end = subTitleUnit2.endTime;
                        multiMediaData4.x = subTitleUnit2.x;
                        multiMediaData4.y = subTitleUnit2.y;
                    }
                });
            }
        }
    }

    private void startTimer(long j) {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
        if (multiMediaDataSourceRealTimer == null) {
            multiMediaDataSourceRealTimer = new MultiMediaDataSourceRealTimer();
            multiMediaDataSourceRealTimer.setDuration(getSegmentsDuration());
            multiMediaDataSourceRealTimer.setUpdateListener(this);
            multiMediaDataSourceRealTimer.setAnimatorListenerAdapter(this);
            multiMediaDataSourceRealTimer.setFrameRate(this.mFrameRate);
        }
        multiMediaDataSourceRealTimer.setCurrentPlayTime(j);
        multiMediaDataSourceRealTimer.start();
        this.mTimer = multiMediaDataSourceRealTimer;
    }

    private void stopTimer() {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
        if (multiMediaDataSourceRealTimer == null) {
            return;
        }
        multiMediaDataSourceRealTimer.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubtitle(long j) {
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater != null) {
            setCurrentSubtitle(newSubTitleCreater.getSubTitle(j, getDuration()));
        }
    }

    private void updateSuperpositionHeaderAndFooterTimeLine(long j, List<MultiMediaDataTrack> list) {
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        if (list == null) {
            return;
        }
        MultiMediaData multiMediaData = list.get(0).multiMediaDataSuperpositionHeader;
        MultiMediaData multiMediaData2 = list.get(0).multiMediaDataSuperpositionFooter;
        if (multiMediaData != null && multiMediaData.type == 1 && (vLogSimplePlayer2 = multiMediaData.player) != null) {
            if (j >= 0 && j < multiMediaData.end && !vLogSimplePlayer2.isPlaying()) {
                multiMediaData.player.start();
            } else if (j >= multiMediaData.end && multiMediaData.player.isPlaying()) {
                multiMediaData.player.pause();
                multiMediaData.player.seekTo(multiMediaData.start);
            }
        }
        if (multiMediaData2 == null || multiMediaData2.type != 1 || (vLogSimplePlayer = multiMediaData2.player) == null) {
            return;
        }
        if (j >= multiMediaData2.start && j < multiMediaData2.end && !vLogSimplePlayer.isPlaying()) {
            multiMediaData2.player.start();
        } else if (j >= multiMediaData2.start || !multiMediaData2.player.isPlaying()) {
        } else {
            multiMediaData2.player.pause();
            multiMediaData2.player.seekTo(0L);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addMultiMediaData(int i, List<MultiMediaData> list) {
        if (xwb.e(list)) {
            return;
        }
        int originalInputSize = getOriginalInputSize();
        MediaTrack inputTrack = getInputTrack();
        int hasGlobalFilter = MultiDataSourceUtil.hasGlobalFilter(inputTrack);
        String str = hasGlobalFilter >= 0 ? inputTrack.mediaSegments.get(hasGlobalFilter).lutConfigKey : null;
        int b = xwb.b(list) - 1;
        while (true) {
            if (b < 0) {
                MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
                if (mediaTrackConfig != null && !xwb.e(mediaTrackConfig.mediaTracks)) {
                    MediaSegment mediaSegment = this.mMediaTrackConfig.mediaTracks.get(0).superpositionHeader;
                    MediaSegment mediaSegment2 = this.mMediaTrackConfig.mediaTracks.get(0).superpositionFooter;
                    if (mediaSegment != null || mediaSegment2 != null) {
                        int max = Math.max(pc0.j, (mediaSegment == null ? 0 : 1) + (mediaSegment2 == null ? 0 : 1));
                        if (originalInputSize < max && originalInputSize + list.size() >= max) {
                            pc0.b(inputTrack, this.mShaderConfigMap, this.mMediaTrackConfig.mediaTracks.get(0));
                            pc0.c(inputTrack, this.mMediaTrackConfig);
                            MultiDataSourceUtil.applySuperpositionSegment(this.mUpdateMediaTracks, this.mShaderConfigMap, this.mUpdateMultiMediaDataTrack, this, this);
                        }
                    }
                }
                applyTimeLineOnTemplateType();
                pc0.a(inputTrack, getMaxVideoDurationFromConfig());
                stopTimer();
                resetTimer();
                notifyMediaTracksChanged();
                return;
            }
            MultiMediaData multiMediaData = (MultiMediaData) xwb.c(list, b);
            if (multiMediaData != null) {
                this.mMultiMediaAdapter.clearByIndex(i + b);
                int addMultiMediaData = MultiDataSourceUtil.addMultiMediaData(getInputMultiMediaDataTrack(), i, multiMediaData);
                if (addMultiMediaData == -1) {
                    return;
                }
                MediaSegment transData2Segment = MultiDataSourceUtil.transData2Segment(0L, multiMediaData);
                inputTrack.mediaSegments.add(addMultiMediaData, transData2Segment);
                if (hasGlobalFilter >= 0) {
                    transData2Segment.lutConfigKey = str;
                }
                List<MediaTransition> list2 = inputTrack.mediaTransitions;
                if (list2 != null) {
                    int i2 = addMultiMediaData - 1;
                    list2.add(i2 >= 0 ? i2 : 0, new MediaTransition());
                }
            }
            b--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.mCommonTrackMap.containsKey(r4.trackType) == false) goto L12;
     */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addOneTrack(MediaTrack mediaTrack) {
        if (mediaTrack == null) {
            return;
        }
        MediaTrack trackByType = MultiDataSourceUtil.getTrackByType(this.mUpdateMediaTracks, mediaTrack.trackType);
        if (this.mCommonTrackMap == null) {
            this.mCommonTrackMap = new HashMap();
        }
        if (trackByType == null) {
            MultiDataSourceUtil.addOneTrack(mediaTrack, this.mUpdateMediaTracks, this.mShaderConfigMap, this.mUpdateMultiMediaDataTrack, this);
        } else if (this.mCommonTrackMap.containsKey(mediaTrack.trackType)) {
            MultiDataSourceUtil.removeOneTrack(trackByType, this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack, this);
            MultiDataSourceUtil.addOneTrack(mediaTrack, this.mUpdateMediaTracks, this.mShaderConfigMap, this.mUpdateMultiMediaDataTrack, this);
            this.mCommonTrackMap.put(mediaTrack.trackType, mediaTrack);
        }
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addStickerData(final MultiMediaData multiMediaData, String str) {
        if (multiMediaData == null || TextUtils.isEmpty(str)) {
            return;
        }
        MediaTrack buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack);
        int indexOf = this.mUpdateMediaTracks.indexOf(buildSubtitleAndStickerTrack);
        if (indexOf >= 0) {
            MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf);
            MultiDataSourceUtil.addMultiMediaData(multiMediaDataTrack, multiMediaDataTrack.multiMediaDataList.size(), multiMediaData);
            long j = this.mPlayTime;
            if (getDuration() - j < multiMediaData.end - multiMediaData.start) {
                j = Math.max(getDuration() - (multiMediaData.end - multiMediaData.start), 0L);
            }
            MediaSegment transData2Segment = MultiDataSourceUtil.transData2Segment(j, multiMediaData);
            transData2Segment.type = str;
            buildSubtitleAndStickerTrack.mediaSegments.add(transData2Segment);
        }
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.15
            @Override // java.lang.Runnable
            public void run() {
                MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                MultiMediaDataSource.this.notifyFrameAvailable();
            }
        });
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void deleteMultiMediaData(int i) {
        int i2;
        int originalInputSize = getOriginalInputSize();
        int deleteMultiMediaData = MultiDataSourceUtil.deleteMultiMediaData(this.mUpdateMultiMediaDataTrack, i, this);
        if (deleteMultiMediaData == -1) {
            return;
        }
        MediaTrack inputTrack = getInputTrack();
        inputTrack.mediaSegments.remove(deleteMultiMediaData);
        if (!xwb.e(inputTrack.mediaTransitions)) {
            if (deleteMultiMediaData == inputTrack.mediaTransitions.size()) {
                deleteMultiMediaData--;
            }
            inputTrack.mediaTransitions.remove(deleteMultiMediaData);
        }
        MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
        MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
        if (mediaTrackConfig != null && inputMultiMediaDataTrack != null && !xwb.e(mediaTrackConfig.mediaTracks) && ((this.mMediaTrackConfig.mediaTracks.get(0).superpositionHeader != null || this.mMediaTrackConfig.mediaTracks.get(0).superpositionFooter != null) && originalInputSize >= (i2 = pc0.j) && originalInputSize - 1 < i2)) {
            onReleaseMultiMedia(inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader);
            inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader = null;
            onReleaseMultiMedia(inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter);
            inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter = null;
            inputTrack.superpositionHeader = null;
            inputTrack.superpositionFooter = null;
        }
        this.mMultiMediaAdapter.clear();
        applyTimeLineOnTemplateType();
        pc0.a(inputTrack, getMaxVideoDurationFromConfig());
        stopTimer();
        resetTimer();
        notifyMediaTracksChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public int editOneEffect(int i, MediaAEffectConfig mediaAEffectConfig, long j, long j2) {
        MediaTrack effectTrack = getEffectTrack();
        MediaSegment mediaSegment = (MediaSegment) xwb.c(effectTrack.mediaSegments, i);
        if (mediaSegment != null) {
            mediaSegment.start = j;
            mediaSegment.end = j2;
        } else {
            MediaSegment mediaSegment2 = new MediaSegment();
            mediaSegment2.start = j;
            mediaSegment2.end = j2;
            MediaAEffect mediaAEffect = mediaAEffectConfig.getMediaAEffect();
            mediaSegment2.mediaAEffect = mediaAEffect;
            mediaSegment2.type = "effect";
            mediaSegment2.effectConfigKey = mediaAEffect.name;
            effectTrack.mediaSegments.add(mediaSegment2);
            this.mShaderConfigMap.put(mediaSegment2.mediaAEffect.shaderConfigKey, mediaAEffectConfig.getShaderConfig());
            i = xwb.b(effectTrack.mediaSegments) - 1;
        }
        notifyEffectChanged();
        return i;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public String exportConfigJson(String str) {
        String a;
        synchronized (this.mShaderConfigMap) {
            MediaTrackConfig exportConfigJson = ImportExportConfigUtil.exportConfigJson(this.mShaderConfigMap, this.mUpdateMediaTracks, getInputMultiMediaDataTrack(), this.mMediaTrackConfig, str);
            exportConfigJson.videoRatio = this.mVideoRatio;
            a = new eub().a(exportConfigJson);
        }
        return a;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public int getCurrentIndex() {
        return this.mCurrentIndex.get();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        return this.mPlayTime;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public SubTitleUnit getCurrentSubtitle() {
        if (xwb.e(this.mSubTitleUnitList)) {
            return null;
        }
        long currentPlayTime = getCurrentPlayTime();
        for (SubTitleUnit subTitleUnit : this.mSubTitleUnitList) {
            if (currentPlayTime >= subTitleUnit.startTime && currentPlayTime <= subTitleUnit.endTime) {
                return subTitleUnit;
            }
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        return getSegmentsDuration();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public ArrayList<MultiMediaData> getInputMultiMediaData() {
        if (getInputMultiMediaDataTrack() == null) {
            return null;
        }
        ArrayList<MultiMediaData> arrayList = new ArrayList<>();
        if (getInputMultiMediaDataTrack().multiMediaDataList != null) {
            for (MultiMediaData multiMediaData : getInputMultiMediaDataTrack().multiMediaDataList) {
                if (!multiMediaData.isHeader() && !multiMediaData.isFooter()) {
                    arrayList.add(multiMediaData);
                }
            }
        }
        return arrayList;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        return this.mMediaTrackConfig;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MultiMediaData getMultiMediaData(int i) {
        MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
        if (inputMultiMediaDataTrack != null) {
            return (MultiMediaData) xwb.c(inputMultiMediaDataTrack.multiMediaDataList, i);
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        return this.mUpdateMultiMediaDataTrack;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MediaTrack getOriginEffectTrack() {
        return this.mOriginEffectTrack;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        return this.mShaderConfigMap;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MultiMediaData> getStickerMultiMediaDataList(boolean z) {
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks);
        if (subtitleAndStickerTrack == null || xwb.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || xwb.e(multiMediaDataTrack.multiMediaDataList)) {
            return null;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (MultiMediaData multiMediaData : multiMediaDataTrack.multiMediaDataList) {
                arrayList.add((MultiMediaData) multiMediaData.clone());
            }
            return arrayList;
        }
        return multiMediaDataTrack.multiMediaDataList;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsData(boolean z) {
        MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks);
        if (subtitleAndStickerTrack == null || xwb.e(subtitleAndStickerTrack.mediaSegments)) {
            return null;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (MediaSegment mediaSegment : subtitleAndStickerTrack.mediaSegments) {
                arrayList.add(mediaSegment.m50clone());
            }
            return arrayList;
        }
        return subtitleAndStickerTrack.mediaSegments;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsDataByType(String str) {
        MediaTrack subtitleAndStickerTrack;
        if (TextUtils.isEmpty(str) || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || xwb.e(subtitleAndStickerTrack.mediaSegments)) {
            return null;
        }
        return MultiDataSourceUtil.getStickerSegmentsDataByType(subtitleAndStickerTrack, str);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        return this.mUpdateMediaTracks;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public float getVideoRatio() {
        return this.mVideoRatio;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public float getVolume(int i) {
        if (xwb.e(this.mUpdateMultiMediaDataTrack) || xwb.e(getInputMultiMediaDataTrack().multiMediaDataList) || xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i) == null) {
            return 1.0f;
        }
        return ((MultiMediaData) xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i)).volume;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1 && this.mMultiMediaTimelineUpdateListenerByMainThread != null && (message.obj instanceof Long) && !this.isPaused) {
            updateSubtitle(((Long) message.obj).longValue());
            this.mMultiMediaTimelineUpdateListenerByMainThread.onTimelineUpdate(((Long) message.obj).longValue(), getSegmentsDuration());
            return false;
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isMute() {
        return this.isMute;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        return this.mTimer == null || !this.mTimer.isPlaying();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isPlaying() {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
        return multiMediaDataSourceRealTimer != null && multiMediaDataSourceRealTimer.isPlaying();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        List<MultiMediaDataTrack> list = this.mUpdateMultiMediaDataTrack;
        if (list == null) {
            return false;
        }
        boolean z = true;
        for (MultiMediaDataTrack multiMediaDataTrack : list) {
            List<MultiMediaData> list2 = multiMediaDataTrack.multiMediaDataList;
            if (list2 != null) {
                Iterator<MultiMediaData> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MultiMediaData next = it.next();
                    if (next.type == 1 && !next.playerReady) {
                        z = false;
                        break;
                    }
                }
            }
            if (!z) {
                break;
            }
            MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataSuperpositionHeader;
            if (multiMediaData != null && multiMediaData.type == 1 && !multiMediaData.playerReady) {
                return false;
            }
            MultiMediaData multiMediaData2 = multiMediaDataTrack.multiMediaDataSuperpositionFooter;
            if (multiMediaData2 != null && multiMediaData2.type == 1 && !multiMediaData2.playerReady) {
                return false;
            }
        }
        return z;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void modifyTimeByRange(long j, long j2) {
        MultiDataSourceUtil.modifyTimeByRange(this.mUpdateMediaTracks, this.mOriginEffectTrack, j, j2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void needDrawEffect(boolean z) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.isCancel = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener;
        if (this.isPaused || this.isProgressSeeking || this.isCancel) {
            this.isCancel = false;
        } else if (!this.isLooping) {
            if (getDuration() - this.mPlayTime < 30 && (multiMediaTimelineUpdateListener = this.mMultiMediaTimelineUpdateListener) != null) {
                multiMediaTimelineUpdateListener.onTimelineUpdate(getSegmentsDuration(), getSegmentsDuration());
            }
            if (getDuration() - this.mPlayTime < 30 && this.mMultiMediaTimelineUpdateListenerByMainThread != null) {
                Handler handler = this.mMainHandler;
                handler.sendMessage(handler.obtainMessage(1, Long.valueOf(getSegmentsDuration())));
            }
            pausePlayer(false);
            notifyPlayEnd();
        } else if (this.mRepeatIndex != -1 && this.mRepeatIndex == xwb.b(getInputMultiMediaDataList()) - 1 && xwb.b(getInputMultiMediaDataList()) > 1) {
            onAnimationUpdate(0L);
        } else {
            stopTimer();
            this.mCurrentIndex.set(0);
            this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
            this.mPlayTime = 0L;
            pausePlayer(true);
            notifyLoop();
            startTimer(this.mPlayTime);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.AnimatorUpdateListener
    public void onAnimationUpdate(long j) {
        int[] findIndexInSegments;
        if (this.isPaused) {
            return;
        }
        this.mPlayTime = j;
        this.mPlayTime = j >= 0 ? j > getSegmentsDuration() ? getSegmentsDuration() : j : 0L;
        MediaTrack inputTrack = getInputTrack();
        MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
        if (this.mRepeatIndex != -1 && interceptUpdateByRepeat(inputTrack, this.mRepeatIndex, this.mPlayTime)) {
            if (this.isLooping) {
                notifyRepeatIndexLoop(this.mRepeatIndex);
                repeatIndex(this.mRepeatIndex);
                return;
            }
            notifyRepeatIndexEnd(this.mRepeatIndex);
            pause();
        } else if (j <= getDuration()) {
            int i = -1;
            for (int i2 : MultiDataSourceUtil.findIndexInSegments(inputTrack.mediaSegments, j)) {
                if (i == -1 || i > i2) {
                    i = i2;
                }
            }
            if ((i == -1 ? 0 : i) != this.mCurrentIndex.get()) {
                this.mMultiMediaAdapter.positionChanged(i);
            }
            int updateTimeline = MultiDataSourceUtil.updateTimeline(inputTrack, inputMultiMediaDataTrack.multiMediaDataList, j);
            updateSuperpositionHeaderAndFooterTimeLine(j, this.mUpdateMultiMediaDataTrack);
            int i3 = this.mCurrentIndex.get();
            this.mCurrentIndex.set(updateTimeline != -1 ? updateTimeline : 0);
            notifyIndexChanged(i3, this.mCurrentIndex.get());
            int b = xwb.b(this.mUpdateMediaTracks);
            if (b > 1 && b == xwb.b(this.mUpdateMultiMediaDataTrack)) {
                for (int i4 = 1; i4 < b; i4++) {
                    MediaTrack mediaTrack = (MediaTrack) xwb.c(this.mUpdateMediaTracks, i4);
                    MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) xwb.c(this.mUpdateMultiMediaDataTrack, i4);
                    if (mediaTrack != null && multiMediaDataTrack != null) {
                        final List<MultiMediaData> list = multiMediaDataTrack.multiMediaDataList;
                        final List<MediaSegment> list2 = mediaTrack.mediaSegments;
                        MultiDataSourceUtil.updateTimeline(mediaTrack, list, j);
                        if (list2 != null && list != null) {
                            runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    for (int i5 = 0; i5 < list.size(); i5++) {
                                        MultiMediaData multiMediaData = (MultiMediaData) list.get(i5);
                                        MediaSegment mediaSegment = (MediaSegment) list2.get(i5);
                                        long j2 = mediaSegment != null ? mediaSegment.start : 0L;
                                        if (MultiMediaDataSource.this.mPlayTime >= j2) {
                                            MultiMediaDataSource.this.initMultiMedia(multiMediaData, j2);
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
            notifyTimelineUpdate(j);
            notifyFrameAvailable();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        resetTimer();
        release();
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater != null) {
            newSubTitleCreater.release();
        }
        this.onFrameAvailableListener = null;
        List<EffectChangeObserver> list = this.mEffectChangeObservers;
        if (list != null) {
            list.clear();
            this.mEffectChangeObservers = null;
        }
        List<MediaTrackChangeObserver> list2 = this.mMediaTrackChangeObservers;
        if (list2 != null) {
            list2.clear();
            this.mMediaTrackChangeObservers = null;
        }
        this.mReadPhotoHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
        List<MultiMediaData> list;
        if (Build.VERSION.SDK_INT >= 17) {
            this.mEglContext = EGL14.eglGetCurrentContext();
        }
        if (xwb.e(getInputMultiMediaDataList())) {
            return;
        }
        List<MultiMediaDataTrack> list2 = this.mUpdateMultiMediaDataTrack;
        for (int i = 0; i < xwb.b(list2); i++) {
            MultiMediaDataTrack multiMediaDataTrack = list2.get(i);
            if (multiMediaDataTrack != null && (list = multiMediaDataTrack.multiMediaDataList) != null) {
                if (i == 0) {
                    initMultiMedia((MultiMediaData) xwb.c(list, this.mCurrentIndex.get()));
                    initMultiMedia((MultiMediaData) xwb.c(multiMediaDataTrack.multiMediaDataList, this.mCurrentIndex.get() + 1));
                    initMultiMedia(multiMediaDataTrack.multiMediaDataSuperpositionHeader);
                    initMultiMedia(multiMediaDataTrack.multiMediaDataSuperpositionFooter);
                } else {
                    for (int i2 = 0; i2 < multiMediaDataTrack.multiMediaDataList.size(); i2++) {
                        initMultiMedia(multiMediaDataTrack.multiMediaDataList.get(i2));
                    }
                }
            }
        }
        if (this.mMediaTrackConfig == null || this.isPaused || this.mNeedInitMultiMediaData) {
            postPrepared();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil.OnInitMultiMediaListener
    public void onInitMultiMedia(final MultiMediaData multiMediaData) {
        this.mNeedInitMultiMediaData = true;
        createPlayer(multiMediaData);
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.13
            @Override // java.lang.Runnable
            public void run() {
                MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                if ((multiMediaData.isHeader() || multiMediaData.isSuperpositionHeader() || multiMediaData.isOtherTrack()) && MultiMediaDataSource.this.mCurrentIndex.get() == 0) {
                    MultiMediaDataSource.this.postPrepared();
                }
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        this.isPaused = true;
        this.isPrepared = false;
        this.mNeedInitMultiMediaData = true;
        pause();
        releaseSurface();
        this.mMultiMediaAdapter.clear();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil.OnReleaseMultiMediaListener
    public void onReleaseMultiMedia(MultiMediaData multiMediaData) {
        if (multiMediaData == null) {
            return;
        }
        multiMediaData.releaseSurface();
        multiMediaData.releasePlayer();
        if (multiMediaData.textureId != 0) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = multiMediaData.textureId;
            this.mReadPhotoHandler.sendMessage(obtain);
            multiMediaData.textureId = 0;
        }
        if (multiMediaData.backupFrameTextureId != 0) {
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            obtain2.arg1 = multiMediaData.backupFrameTextureId;
            this.mReadPhotoHandler.sendMessage(obtain2);
            multiMediaData.backupFrameTextureId = 0;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onResume() {
        this.isPaused = false;
        notifyEffectChanged();
        initAllPlayers();
        this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
        seek(this.mPlayTime);
        updateSubtitle(this.mPlayTime);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void pause() {
        stopTimer();
        resetTimer();
        pausePlayer(false);
        IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.onPause();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void prepareAsync() {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public boolean rangeSegmentScope(int i, long j, long j2) {
        MultiMediaDataTrack multiMediaDataTrack;
        MediaTrack inputTrack;
        if (j <= j2 && j >= 0 && (multiMediaDataTrack = (MultiMediaDataTrack) xwb.c(getMultiMediaDataTrack(), 0)) != null && !xwb.e(multiMediaDataTrack.multiMediaDataList) && xwb.c(multiMediaDataTrack.multiMediaDataList, i) != null) {
            MultiMediaData multiMediaData = (MultiMediaData) xwb.c(multiMediaDataTrack.multiMediaDataList, i);
            if ((multiMediaData.type != 1 || ((float) (j2 - j)) <= ((float) multiMediaData.originalDuration) / multiMediaData.getCurrentSpeed()) && (inputTrack = getInputTrack()) != null && !xwb.e(inputTrack.mediaSegments)) {
                long currentSpeed = (((float) (multiMediaData.end - multiMediaData.start)) / multiMediaData.getCurrentSpeed()) - ((float) (j2 - j));
                multiMediaData.start = ((float) j) * multiMediaData.getCurrentSpeed();
                multiMediaData.end = ((float) j2) * multiMediaData.getCurrentSpeed();
                int b = xwb.b(inputTrack.mediaSegments);
                ((MediaSegment) xwb.c(inputTrack.mediaSegments, i)).end -= currentSpeed;
                for (int i2 = i + 1; i2 < b; i2++) {
                    MediaSegment mediaSegment = (MediaSegment) xwb.c(inputTrack.mediaSegments, i2);
                    mediaSegment.start -= currentSpeed;
                    mediaSegment.end -= currentSpeed;
                }
                applyTimeLineOnTemplateType();
                pc0.a(getInputTrack(), getMaxVideoDurationFromConfig());
                stopTimer();
                resetTimer();
                notifyMediaTracksChanged();
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
        if (this.mEffectChangeObservers == null) {
            this.mEffectChangeObservers = new ArrayList();
        }
        if (this.mEffectChangeObservers.contains(effectChangeObserver)) {
            return;
        }
        this.mEffectChangeObservers.add(effectChangeObserver);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
        if (this.mMediaTrackChangeObservers == null) {
            this.mMediaTrackChangeObservers = new ArrayList();
        }
        if (this.mMediaTrackChangeObservers.contains(mediaTrackChangeObserver)) {
            return;
        }
        this.mMediaTrackChangeObservers.add(mediaTrackChangeObserver);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void release() {
        stopTimer();
        this.mCurrentIndex.set(0);
        this.mPlayTime = 0L;
        releaseSurface();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        List<MultiMediaData> list;
        int b;
        int b2 = xwb.b(this.mUpdateMultiMediaDataTrack);
        for (int i = 0; i < b2; i++) {
            MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) xwb.c(this.mUpdateMultiMediaDataTrack, i);
            if (multiMediaDataTrack != null && !xwb.e(multiMediaDataTrack.multiMediaDataList) && (b = xwb.b((list = multiMediaDataTrack.multiMediaDataList))) != 0) {
                for (int i2 = 0; i2 < b; i2++) {
                    MultiDataSourceUtil.glDeleteTextures((MultiMediaData) xwb.c(list, i2));
                }
                if (this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionHeader != null) {
                    MultiDataSourceUtil.glDeleteTextures(this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionHeader);
                }
                if (this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionFooter != null) {
                    MultiDataSourceUtil.glDeleteTextures(this.mUpdateMultiMediaDataTrack.get(i).multiMediaDataSuperpositionFooter);
                }
            }
        }
        releaseEgl();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeLastEffect() {
        MediaTrack effectTrack = getEffectTrack();
        List<MediaSegment> list = effectTrack.mediaSegments;
        if (list != null) {
            MediaSegment mediaSegment = (MediaSegment) xwb.c(list, list.size() - 1);
            if (mediaSegment != null) {
                effectTrack.mediaSegments.remove(mediaSegment);
            }
            if (xwb.e(effectTrack.mediaSegments)) {
                int indexOf = this.mUpdateMediaTracks.indexOf(effectTrack);
                this.mUpdateMediaTracks.remove(effectTrack);
                xwb.g(this.mUpdateMultiMediaDataTrack, indexOf);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeOneTrack(String str) {
        MediaTrack trackByType = MultiDataSourceUtil.getTrackByType(this.mUpdateMediaTracks, str);
        if (trackByType == null) {
            return;
        }
        MultiDataSourceUtil.removeOneTrack(trackByType, this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack, this);
        Map<String, MediaTrack> map = this.mCommonTrackMap;
        if (map != null) {
            map.remove(str);
        }
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void repeatIndex(int i) {
        MediaTrack inputTrack;
        MediaSegment mediaSegment;
        this.mRepeatIndex = i;
        if (this.mRepeatIndex == -1 || (inputTrack = getInputTrack()) == null || (mediaSegment = (MediaSegment) xwb.c(inputTrack.mediaSegments, this.mRepeatIndex)) == null) {
            return;
        }
        if (this.mPlayTime < mediaSegment.start || this.mPlayTime > mediaSegment.end) {
            this.mCurrentIndex.set(i);
            seek(mediaSegment.start + 1);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void replaceStickerData(int i, final MultiMediaData multiMediaData, String str) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaSegment mediaSegment;
        int indexOf2;
        final MultiMediaData multiMediaData2;
        if (multiMediaData == null || TextUtils.isEmpty(str) || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || xwb.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || xwb.e(multiMediaDataTrack.multiMediaDataList) || (mediaSegment = (MediaSegment) xwb.c(getStickerSegmentsDataByType(str), i)) == null || (indexOf2 = subtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0 || (multiMediaData2 = (MultiMediaData) xwb.c(multiMediaDataTrack.multiMediaDataList, indexOf2)) == null) {
            return;
        }
        multiMediaData.end = multiMediaData2.end;
        multiMediaData.x = multiMediaData2.x;
        multiMediaData.y = multiMediaData2.y;
        multiMediaData.angle = multiMediaData2.angle;
        multiMediaData.scaleX = multiMediaData2.scaleX;
        multiMediaData.scaleY = multiMediaData2.scaleY;
        xwb.g(multiMediaDataTrack.multiMediaDataList, indexOf2);
        multiMediaDataTrack.multiMediaDataList.add(indexOf2, multiMediaData);
        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.16
            @Override // java.lang.Runnable
            public void run() {
                MultiDataSourceUtil.glDeleteTextures(multiMediaData2);
                MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                MultiMediaDataSource.this.notifyFrameAvailable();
            }
        });
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void reset() {
        stopTimer();
        resetTimer();
        this.mCurrentIndex.set(0);
        this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
        this.mPlayTime = 0L;
        pausePlayer(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seek(long j) {
        long j2;
        final MultiMediaData multiMediaData;
        int b;
        int i;
        int i2;
        int i3;
        IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener;
        MultiMediaData multiMediaData2;
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        int i4;
        if (xwb.e(this.mUpdateMultiMediaDataTrack) || xwb.e(getInputMultiMediaDataTrack().multiMediaDataList)) {
            return;
        }
        boolean isPlaying = isPlaying();
        if (isPlaying) {
            pausePlayer(false);
            stopTimer();
        }
        long j3 = 0;
        if (j >= 0) {
            if (j <= getSegmentsDuration()) {
                j2 = j;
                this.mPlayTime = j2;
                MediaTrack inputTrack = getInputTrack();
                List<MultiMediaData> list = getInputMultiMediaDataTrack().multiMediaDataList;
                int seekInternal = seekInternal(inputTrack, list, this.mPlayTime, !isPlaying ? 3 : 4);
                int i5 = this.mCurrentIndex.get();
                this.mCurrentIndex.set(seekInternal != -1 ? 0 : seekInternal);
                this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
                multiMediaData = (MultiMediaData) xwb.c(list, this.mCurrentIndex.get());
                if (multiMediaData != null && multiMediaData.textureId == 0) {
                    runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.12
                        @Override // java.lang.Runnable
                        public void run() {
                            MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                            MultiMediaDataSource.this.notifyFrameAvailable();
                        }
                    });
                }
                notifyIndexChanged(i5, this.mCurrentIndex.get());
                b = xwb.b(this.mUpdateMediaTracks);
                if (b > 1 && b == xwb.b(this.mUpdateMultiMediaDataTrack)) {
                    i4 = 1;
                    while (i4 < b) {
                        seekInternal((MediaTrack) xwb.c(this.mUpdateMediaTracks, i4), this.mUpdateMultiMediaDataTrack.get(i4).multiMediaDataList, j2, isPlaying ? 3 : 4);
                        i4++;
                        b = b;
                        i5 = i5;
                        seekInternal = seekInternal;
                    }
                }
                i = i5;
                i2 = b;
                i3 = seekInternal;
                seekSuperpositionHeaderAndFooter(3, inputTrack);
                MultiMediaData multiMediaData3 = (MultiMediaData) xwb.c(list, this.mCurrentIndex.get());
                if (i2 <= 1 || (multiMediaData3 != null && (multiMediaData3.type != 1 || ((vLogSimplePlayer2 = multiMediaData3.player) != null && vLogSimplePlayer2.isInPlaybackState())))) {
                    notifyFrameAvailable();
                }
                seekSuperpositionHeaderAndFooter(3, inputTrack);
                notifyTimelineUpdate(j2);
                if (i != i3 && (multiMediaData2 = (MultiMediaData) xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i)) != null && (vLogSimplePlayer = multiMediaData2.player) != null && ((float) vLogSimplePlayer.getCurrentPosition()) != ((float) multiMediaData2.start) / multiMediaData2.getCurrentSpeed()) {
                    multiMediaData2.player.seekTo(multiMediaData2.start);
                }
                if (isPlaying) {
                    startTimer(j2);
                }
                onPlayStateListener = this.mOnPlayStateListener;
                if (onPlayStateListener == null) {
                    onPlayStateListener.onSeek(j);
                    return;
                }
                return;
            }
            j3 = getSegmentsDuration() - 16;
        }
        j2 = j3;
        this.mPlayTime = j2;
        MediaTrack inputTrack2 = getInputTrack();
        List<MultiMediaData> list2 = getInputMultiMediaDataTrack().multiMediaDataList;
        int seekInternal2 = seekInternal(inputTrack2, list2, this.mPlayTime, !isPlaying ? 3 : 4);
        int i52 = this.mCurrentIndex.get();
        this.mCurrentIndex.set(seekInternal2 != -1 ? 0 : seekInternal2);
        this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
        multiMediaData = (MultiMediaData) xwb.c(list2, this.mCurrentIndex.get());
        if (multiMediaData != null) {
            runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.12
                @Override // java.lang.Runnable
                public void run() {
                    MultiMediaDataSource.this.initMultiMedia(multiMediaData);
                    MultiMediaDataSource.this.notifyFrameAvailable();
                }
            });
        }
        notifyIndexChanged(i52, this.mCurrentIndex.get());
        b = xwb.b(this.mUpdateMediaTracks);
        if (b > 1) {
            i4 = 1;
            while (i4 < b) {
            }
        }
        i = i52;
        i2 = b;
        i3 = seekInternal2;
        seekSuperpositionHeaderAndFooter(3, inputTrack2);
        MultiMediaData multiMediaData32 = (MultiMediaData) xwb.c(list2, this.mCurrentIndex.get());
        if (i2 <= 1) {
        }
        notifyFrameAvailable();
        seekSuperpositionHeaderAndFooter(3, inputTrack2);
        notifyTimelineUpdate(j2);
        if (i != i3) {
            multiMediaData2.player.seekTo(multiMediaData2.start);
        }
        if (isPlaying) {
        }
        onPlayStateListener = this.mOnPlayStateListener;
        if (onPlayStateListener == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j, int i) {
        MultiMediaData multiMediaData;
        VLogSimplePlayer vLogSimplePlayer;
        if (xwb.e(this.mUpdateMultiMediaDataTrack) || xwb.e(getInputMultiMediaDataTrack().multiMediaDataList)) {
            return;
        }
        this.isProgressSeeking = i == 0 || i == 1;
        if (i == 0 || i == 3) {
            pausePlayer(false);
            stopTimer();
        }
        if (j < 0) {
            j = 0;
        } else if (j >= getSegmentsDuration()) {
            j = getSegmentsDuration() - 16;
        }
        this.mPlayTime = j;
        MediaTrack inputTrack = getInputTrack();
        int seekInternal = seekInternal(inputTrack, getInputMultiMediaDataTrack().multiMediaDataList, this.mPlayTime, i);
        this.mCurrentIndex.set(seekInternal == -1 ? 0 : seekInternal);
        int b = xwb.b(this.mUpdateMediaTracks);
        if (b > 1 && b == xwb.b(this.mUpdateMultiMediaDataTrack)) {
            for (int i2 = 1; i2 < b; i2++) {
                seekInternal((MediaTrack) xwb.c(this.mUpdateMediaTracks, i2), this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataList, this.mPlayTime, i);
            }
        }
        seekSuperpositionHeaderAndFooter(i, inputTrack);
        notifyFrameAvailable();
        notifyTimelineUpdate(this.mPlayTime);
        if (i == 2) {
            int b2 = xwb.b(getInputMultiMediaDataTrack().multiMediaDataList);
            for (int i3 = 0; i3 < b2; i3++) {
                if (seekInternal != i3 && (multiMediaData = (MultiMediaData) xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i3)) != null && (vLogSimplePlayer = multiMediaData.player) != null && ((float) vLogSimplePlayer.getCurrentPosition()) != ((float) multiMediaData.start) / multiMediaData.getCurrentSpeed()) {
                    vLogSimplePlayer.seekTo(multiMediaData.start);
                }
            }
        }
        if (i == 3 || i == 2) {
            startTimer(this.mPlayTime);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAngle(int i, float f) {
        MultiMediaData multiMediaData = getMultiMediaData(i);
        if (multiMediaData != null) {
            multiMediaData.angle = f;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    @Deprecated
    public void setAngle(int i, int i2) {
        setAngle(i, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int i) {
        setAudioChangeType(new int[]{i});
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr) {
        MultiMediaDataTrack inputMultiMediaDataTrack;
        this.mAudioChangeTypes = iArr;
        if (xwb.e(this.mUpdateMediaTracks) || (inputMultiMediaDataTrack = getInputMultiMediaDataTrack()) == null || xwb.e(inputMultiMediaDataTrack.multiMediaDataList)) {
            return;
        }
        for (MultiMediaData multiMediaData : inputMultiMediaDataTrack.multiMediaDataList) {
            VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
            if (vLogSimplePlayer != null) {
                vLogSimplePlayer.setAudioChangeType(iArr);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2) {
        MultiMediaDataTrack inputMultiMediaDataTrack;
        this.mAudioChangeTypes = iArr;
        if (xwb.e(this.mUpdateMediaTracks) || (inputMultiMediaDataTrack = getInputMultiMediaDataTrack()) == null || xwb.e(inputMultiMediaDataTrack.multiMediaDataList)) {
            return;
        }
        for (MultiMediaData multiMediaData : inputMultiMediaDataTrack.multiMediaDataList) {
            VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
            if (vLogSimplePlayer != null) {
                vLogSimplePlayer.setAudioChangeType(iArr, dArr, iArr2);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map) {
        MediaTrack effectTrack = getEffectTrack();
        if (xwb.e(list) && map.isEmpty()) {
            int indexOf = this.mUpdateMediaTracks.indexOf(effectTrack);
            this.mUpdateMediaTracks.remove(effectTrack);
            xwb.g(this.mUpdateMultiMediaDataTrack, indexOf);
            return;
        }
        effectTrack.mediaSegments.clear();
        effectTrack.mediaSegments.addAll(list);
        this.mShaderConfigMap.putAll(map);
        notifyEffectChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(float f, String str) {
        setFilter(-1, f, str);
        Iterator<Map.Entry<String, ShaderConfig>> it = this.mShaderConfigMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().contains(pc0.d)) {
                it.remove();
            }
        }
        notifyEffectChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(int i, float f, final String str) {
        final MediaTextureData mediaTextureData;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaTrack inputTrack = getInputTrack();
        String str2 = i >= 0 ? pc0.d + i : pc0.c;
        if (inputTrack != null) {
            String str3 = TextUtils.equals(str, IVlogEditManager.FILTER_ORIGINAL) ? "" : str2;
            if (pc0.m(inputTrack, "input_blank")) {
                int i2 = 1;
                int i3 = -1;
                while (true) {
                    if (i2 >= this.mUpdateMediaTracks.size()) {
                        break;
                    }
                    MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i2);
                    if (mediaTrack != null && pc0.m(mediaTrack, "multi_input")) {
                        if (i3 == -1) {
                            i3 = i2;
                        }
                        if (i >= 0) {
                            if (i2 - i3 == i) {
                                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                                    mediaSegment.lutConfigKey = str3;
                                }
                            }
                        } else if (i == -1) {
                            for (MediaSegment mediaSegment2 : mediaTrack.mediaSegments) {
                                mediaSegment2.lutConfigKey = str3;
                            }
                        }
                    }
                    i2++;
                }
            }
            MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
            List<MediaSegment> list = inputTrack.mediaSegments;
            if (list != null && inputMultiMediaDataTrack != null && inputMultiMediaDataTrack.multiMediaDataList != null) {
                if (i >= 0 && list.size() > i && inputMultiMediaDataTrack.multiMediaDataList.size() > i) {
                    inputTrack.mediaSegments.get(i).lutConfigKey = str3;
                } else if (i == -1) {
                    for (MediaSegment mediaSegment3 : inputTrack.mediaSegments) {
                        mediaSegment3.lutConfigKey = str3;
                    }
                }
            }
        }
        if (TextUtils.equals(str, IVlogEditManager.FILTER_ORIGINAL)) {
            ShaderConfig shaderConfig = this.mShaderConfigMap.get(str2);
            if (shaderConfig != null && !xwb.e(shaderConfig.textures)) {
                for (MediaTextureData mediaTextureData2 : shaderConfig.textures) {
                    final int i4 = mediaTextureData2.textureId;
                    if (i4 != 0) {
                        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.3
                            @Override // java.lang.Runnable
                            public void run() {
                                MultiDataSourceUtil.glDeleteTextures(i4);
                            }
                        });
                        mediaTextureData2.textureId = 0;
                    }
                    mediaTextureData2.path = "";
                }
            }
            this.mShaderConfigMap.remove(str2);
        } else {
            if (!this.mShaderConfigMap.containsKey(str2)) {
                this.mShaderConfigMap.put(str2, ShaderConfig.getLutShaderConfig());
            }
            ShaderConfig shaderConfig2 = this.mShaderConfigMap.get(str2);
            if (xwb.e(shaderConfig2.textures)) {
                mediaTextureData = new MediaTextureData();
                mediaTextureData.type = MediaTextureData.TEXTURE_LUT;
                mediaTextureData.path = str;
                ArrayList arrayList = new ArrayList();
                shaderConfig2.textures = arrayList;
                arrayList.add(mediaTextureData);
                z = true;
            } else {
                mediaTextureData = (MediaTextureData) xwb.c(shaderConfig2.textures, 0);
                z = !TextUtils.equals(mediaTextureData.path, str);
                shaderConfig2.textures.clear();
                shaderConfig2.textures.add(mediaTextureData);
                mediaTextureData.path = str;
            }
            shaderConfig2.fParams = new ArrayList();
            ShaderParams shaderParams = new ShaderParams();
            shaderParams.name = "non_level";
            shaderParams.type = ShaderParams.VALUE_TYPE_FLOAT;
            shaderParams.values = new float[]{1.0f - f};
            shaderConfig2.fParams.add(shaderParams);
            if (z) {
                runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(str);
                        if (decodeBitmap != null) {
                            MultiDataSourceUtil.glDeleteTextures(mediaTextureData.textureId);
                            int b = jc0.b();
                            GLUtils.texImage2D(3553, 0, decodeBitmap, 0);
                            mediaTextureData.textureId = b;
                        }
                    }
                });
            }
        }
        if (i >= 0) {
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setLooping(boolean z) {
        this.isLooping = z;
        IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.onSetIsLoop(z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        MediaTrack effectTrack;
        this.isPrepared = false;
        this.mMediaTrackConfig = mediaTrackConfig;
        List<MultiMediaData> stickerMultiMediaDataList = getStickerMultiMediaDataList(false);
        List<MediaSegment> stickerSegmentsData = getStickerSegmentsData(false);
        MediaTrackConfig mediaTrackConfig2 = this.mMediaTrackConfig;
        if (mediaTrackConfig2 != null && (effectTrack = MultiDataSourceUtil.getEffectTrack(mediaTrackConfig2.mediaTracks)) != null) {
            Object clone = effectTrack.clone();
            if (clone instanceof MediaTrack) {
                this.mOriginEffectTrack = (MediaTrack) clone;
            }
        }
        if (pc0.k(this.mUpdateMediaTracks, "user_background")) {
            if (this.mCommonTrackMap == null) {
                this.mCommonTrackMap = new HashMap();
            }
            MediaTrack trackByType = MultiDataSourceUtil.getTrackByType(this.mUpdateMediaTracks, "user_background");
            if (!this.mCommonTrackMap.containsKey("user_background")) {
                this.mCommonTrackMap.put("user_background", trackByType);
            }
        }
        MultiDataSourceUtil.releaseOtherTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack, this);
        stopTimer();
        resetTimer();
        pausePlayer(true);
        this.mMultiMediaAdapter.clear();
        releaseSubtitleCache();
        MultiDataSourceUtil.buildMultiMediaDataSource(getInputMultiMediaDataList(), mediaTrackConfig, this.mUpdateMultiMediaDataTrack, this.mUpdateMediaTracks, this.mShaderConfigMap, this, this);
        Map<String, MediaTrack> map = this.mCommonTrackMap;
        if (map != null) {
            for (Map.Entry<String, MediaTrack> entry : map.entrySet()) {
                addOneTrack(entry.getValue());
            }
        }
        MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack);
        setStickerDataList(stickerMultiMediaDataList, stickerSegmentsData);
        this.mCurrentIndex.set(0);
        this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
        this.mPlayTime = 0L;
        if (this.mNeedInitMultiMediaData) {
            notifyFrameAvailable();
        } else {
            MultiMediaData multiMediaData = (MultiMediaData) xwb.c(getInputMultiMediaData(), this.mCurrentIndex.get());
            if (multiMediaData == null || multiMediaData.textureId == 0) {
                this.mNeedInitMultiMediaData = true;
            } else {
                postPrepared();
            }
        }
        log();
        notifyEffectChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMultiMediaData(List<MultiMediaData> list) {
        if (xwb.e(list)) {
            reset();
            this.mUpdateMultiMediaDataTrack.clear();
            this.mUpdateMediaTracks.clear();
            this.mShaderConfigMap.clear();
            return;
        }
        this.mMultiMediaAdapter.seek0AndClearOther(list.get(0), 0);
        MultiDataSourceUtil.buildMultiMediaDataTrackList(list, this.mUpdateMultiMediaDataTrack);
        MultiDataSourceUtil.buildInputTrack(list, this.mUpdateMediaTracks);
        initAllPlayers();
        notifyEffectChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaStateEventListener(MultiMediaStateEventListener multiMediaStateEventListener) {
        this.mMultiMediaStateEventListener = multiMediaStateEventListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaTimelineUpdateListener(MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener, boolean z) {
        if (z) {
            this.mMultiMediaTimelineUpdateListenerByMainThread = multiMediaTimelineUpdateListener;
        } else {
            this.mMultiMediaTimelineUpdateListener = multiMediaTimelineUpdateListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setMute(boolean z) {
        this.isMute = z;
        int b = xwb.b(getInputMultiMediaDataList());
        for (int i = 0; i < b; i++) {
            MultiMediaData multiMediaData = (MultiMediaData) xwb.c(getInputMultiMediaDataList(), i);
            if (multiMediaData.type == 1 && multiMediaData.player != null) {
                float f = z ? 0.0f : multiMediaData.volume;
                multiMediaData.player.setVolume(f, f);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.onFrameAvailableListener = onFrameAvailableListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setOnPlayStateListener(IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener) {
        this.mOnPlayStateListener = onPlayStateListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setPreRunnableTask(OnPreRunnableTask onPreRunnableTask) {
        this.mPreRunnableTask = onPreRunnableTask;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setPreparedListener(IMultiMediaPreparedListener iMultiMediaPreparedListener) {
        this.mPreparedListener = iMultiMediaPreparedListener;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScale(float f, float f2) {
        MultiMediaData multiMediaData = getMultiMediaData(this.mCurrentIndex.get());
        if (multiMediaData != null) {
            multiMediaData.scaleX = f;
            multiMediaData.scaleY = f2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScaleType(String str) {
        if (getInputMultiMediaDataList() != null) {
            Iterator<MultiMediaData> it = getInputMultiMediaDataList().iterator();
            while (it.hasNext()) {
                it.next().scaleType = str;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setStickerDataList(final List<MultiMediaData> list, List<MediaSegment> list2) {
        MediaTrack buildSubtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        if (xwb.b(list) == xwb.b(list2) && (buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack)) != null && (indexOf = this.mUpdateMediaTracks.indexOf(buildSubtitleAndStickerTrack)) >= 0 && (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) != null) {
            List<MultiMediaData> list3 = multiMediaDataTrack.multiMediaDataList;
            List<MediaSegment> list4 = buildSubtitleAndStickerTrack.mediaSegments;
            if (list3 == null || list4 == null) {
                return;
            }
            final ArrayList arrayList = new ArrayList();
            for (MultiMediaData multiMediaData : list3) {
                boolean z = true;
                Iterator<MultiMediaData> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MultiMediaData next = it.next();
                    if (TextUtils.equals(multiMediaData.uuid, next.uuid) && TextUtils.equals(multiMediaData.path, next.path)) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(multiMediaData);
                }
            }
            list3.clear();
            list4.clear();
            list3.addAll(list);
            list4.addAll(list2);
            runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.17
                @Override // java.lang.Runnable
                public void run() {
                    for (MultiMediaData multiMediaData2 : arrayList) {
                        MultiDataSourceUtil.glDeleteTextures(multiMediaData2);
                        for (MultiMediaData multiMediaData3 : list) {
                            if (TextUtils.equals(multiMediaData2.uuid, multiMediaData3.uuid)) {
                                MultiDataSourceUtil.glDeleteTextures(multiMediaData3);
                            }
                        }
                    }
                    for (MultiMediaData multiMediaData4 : list) {
                        MultiMediaDataSource.this.initMultiMedia(multiMediaData4);
                    }
                }
            });
            notifyMediaTracksChanged();
            notifyFrameAvailable();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitle(List<SubTitleUnit> list) {
        this.mSubTitleUnitList = list;
        NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
        if (newSubTitleCreater == null) {
            NewSubTitleCreater newSubTitleCreater2 = new NewSubTitleCreater(list);
            this.mSubTitleCreater = newSubTitleCreater2;
            newSubTitleCreater2.setSubtitleCreaterCallBack(new NewSubTitleCreater.SubtitleCreaterCallBack() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.5
                @Override // com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.SubtitleCreaterCallBack
                public void onSubtitleBitmapCreated() {
                    if (MultiMediaDataSource.this.mTimer == null) {
                        MultiMediaDataSource multiMediaDataSource = MultiMediaDataSource.this;
                        multiMediaDataSource.updateSubtitle(multiMediaDataSource.mPlayTime);
                        MultiMediaDataSource.this.notifyFrameAvailable();
                    }
                }
            });
        } else {
            newSubTitleCreater.setSubTitleUnits(list);
        }
        int i = 0;
        if (list != null) {
            MediaTrack buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack);
            Iterator<MediaSegment> it = buildSubtitleAndStickerTrack.mediaSegments.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (TextUtils.equals(SubtitleLog.TAG, it.next().type)) {
                    i = 1;
                    break;
                }
            }
            if (i == 0) {
                MediaSegment mediaSegment = new MediaSegment();
                mediaSegment.type = SubtitleLog.TAG;
                buildSubtitleAndStickerTrack.mediaSegments.add(mediaSegment);
                int indexOf = this.mUpdateMediaTracks.indexOf(buildSubtitleAndStickerTrack);
                if (indexOf >= 0) {
                    this.mUpdateMultiMediaDataTrack.get(indexOf).multiMediaDataList.add(new MultiMediaData());
                }
            }
            updateSubtitle(this.mPlayTime);
            return;
        }
        MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks);
        if (subtitleAndStickerTrack == null) {
            return;
        }
        int indexOf2 = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack);
        if (indexOf2 >= 0) {
            MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf2);
            List<MediaSegment> list2 = subtitleAndStickerTrack.mediaSegments;
            if (list2 != null && multiMediaDataTrack.multiMediaDataList != null && list2.size() == multiMediaDataTrack.multiMediaDataList.size()) {
                while (i < subtitleAndStickerTrack.mediaSegments.size()) {
                    MediaSegment mediaSegment2 = subtitleAndStickerTrack.mediaSegments.get(i);
                    if (TextUtils.equals(mediaSegment2.type, SubtitleLog.TAG)) {
                        MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i);
                        final int i2 = multiMediaData.textureId;
                        final int i3 = mediaSegment2.textureId;
                        runOnDraw(new Runnable() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.6
                            @Override // java.lang.Runnable
                            public void run() {
                                MultiDataSourceUtil.glDeleteTextures(i2);
                                MultiDataSourceUtil.glDeleteTextures(i3);
                            }
                        });
                        subtitleAndStickerTrack.mediaSegments.remove(mediaSegment2);
                        multiMediaDataTrack.multiMediaDataList.remove(multiMediaData);
                    }
                    i++;
                }
            }
        }
        notifyMediaTracksChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleConfig(SubTitleConfig subTitleConfig) {
        if (this.mSubTitleCreater == null) {
            NewSubTitleCreater newSubTitleCreater = new NewSubTitleCreater(null);
            this.mSubTitleCreater = newSubTitleCreater;
            newSubTitleCreater.setSubtitleCreaterCallBack(new NewSubTitleCreater.SubtitleCreaterCallBack() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.8
                @Override // com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.SubtitleCreaterCallBack
                public void onSubtitleBitmapCreated() {
                    if (MultiMediaDataSource.this.mTimer == null) {
                        MultiMediaDataSource multiMediaDataSource = MultiMediaDataSource.this;
                        multiMediaDataSource.updateSubtitle(multiMediaDataSource.mPlayTime);
                        MultiMediaDataSource.this.notifyFrameAvailable();
                    }
                }
            });
        }
        this.mSubTitleCreater.setSubTitleConfig(subTitleConfig);
        updateSubtitle(this.mPlayTime);
        notifyEffectChanged();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleOnStickerLayerTop() {
        int i = 0;
        List<MediaSegment> stickerSegmentsData = getStickerSegmentsData(false);
        List<MultiMediaData> stickerMultiMediaDataList = getStickerMultiMediaDataList(false);
        if (xwb.e(stickerSegmentsData) || xwb.e(stickerMultiMediaDataList) || xwb.b(stickerSegmentsData) != xwb.b(stickerMultiMediaDataList)) {
            return;
        }
        while (true) {
            if (i >= stickerSegmentsData.size()) {
                i = -1;
                break;
            } else if (stickerSegmentsData.get(i) != null && TextUtils.equals(stickerSegmentsData.get(i).type, SubtitleLog.TAG)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            xwb.h(stickerSegmentsData, i, stickerSegmentsData.size() - 1);
            xwb.h(stickerMultiMediaDataList, i, stickerMultiMediaDataList.size() - 1);
        }
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setTransitionByIndex(int i, MediaTransitionConfig mediaTransitionConfig) {
        MediaTrack inputTrack = getInputTrack();
        if (mediaTransitionConfig == null || mediaTransitionConfig.mediaTransition == null) {
            if (!xwb.e(inputTrack.mediaTransitions)) {
                inputTrack.mediaTransitions.set(i, new MediaTransition());
                pc0.a(inputTrack, getMaxVideoDurationFromConfig());
            }
            notifyEffectChanged();
            return;
        }
        if (xwb.e(inputTrack.mediaTransitions)) {
            int b = xwb.b(inputTrack.mediaSegments) - 1;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < b; i2++) {
                if (i2 == i) {
                    MediaTransition mediaTransition = mediaTransitionConfig.mediaTransition;
                    long j = ((MediaSegment) xwb.c(inputTrack.mediaSegments, i2)).end;
                    long j2 = mediaTransition.duration;
                    mediaTransition.start = j - (j2 / 2);
                    mediaTransition.end = j + (j2 / 2);
                    arrayList.add(mediaTransition);
                } else {
                    arrayList.add(new MediaTransition());
                }
            }
            inputTrack.mediaTransitions = arrayList;
        } else {
            MediaTransition mediaTransition2 = (MediaTransition) xwb.c(inputTrack.mediaTransitions, i);
            MediaTransition mediaTransition3 = mediaTransitionConfig.mediaTransition;
            long j3 = (mediaTransition3.duration - mediaTransition2.duration) / 2;
            mediaTransition3.start = mediaTransition2.start + j3;
            mediaTransition3.end = mediaTransition2.end + j3;
            inputTrack.mediaTransitions.set(i, mediaTransition3);
        }
        pc0.a(inputTrack, getMaxVideoDurationFromConfig());
        for (Map.Entry<String, ShaderConfig> entry : mediaTransitionConfig.shaderConfigMap.entrySet()) {
            this.mShaderConfigMap.put(entry.getKey(), entry.getValue());
        }
        notifyEffectChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVideoRatio(float f) {
        float f2;
        MultiDataSourceUtil.sDefaultScaleType = "center_inside";
        float f3 = this.mVideoRatio;
        float f4 = 1.0f;
        if (f3 != 0.0f && f != 0.0f) {
            if (f3 < 1.0f || f < 1.0f) {
                float f5 = this.mVideoRatio;
                if (f5 > 1.0f || f > 1.0f) {
                    float f6 = this.mVideoRatio;
                    if (f6 <= f) {
                        f6 = 1.0f / f;
                    }
                    float f7 = this.mVideoRatio;
                    f4 = f6;
                    f2 = f7 > f ? f : 1.0f / f7;
                } else {
                    f2 = f / f5;
                }
                if (!xwb.e(getInputMultiMediaDataList())) {
                    Iterator<MultiMediaData> it = getInputMultiMediaDataList().iterator();
                    while (it.hasNext()) {
                        MultiMediaData next = it.next();
                        next.x *= f4;
                        next.y *= f2;
                    }
                }
                this.mVideoRatio = f;
            }
            f4 = f3 / f;
        }
        f2 = 1.0f;
        if (!xwb.e(getInputMultiMediaDataList())) {
        }
        this.mVideoRatio = f;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(float f) {
        if (xwb.b(this.mUpdateMultiMediaDataTrack) == 0) {
            return;
        }
        for (MultiMediaData multiMediaData : getInputMultiMediaDataTrack().multiMediaDataList) {
            if (multiMediaData != null && multiMediaData.type == 1) {
                multiMediaData.volume = f;
                VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                if (vLogSimplePlayer != null) {
                    vLogSimplePlayer.setVolume(f, f);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(int i, float f) {
        MultiMediaData multiMediaData;
        VLogSimplePlayer vLogSimplePlayer;
        if (xwb.b(this.mUpdateMultiMediaDataTrack) == 0 || (multiMediaData = (MultiMediaData) xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i)) == null || multiMediaData.type != 1 || (vLogSimplePlayer = multiMediaData.player) == null) {
            return;
        }
        multiMediaData.volume = f;
        vLogSimplePlayer.setVolume(f, f);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setX(float f) {
        MultiMediaData multiMediaData = getMultiMediaData(this.mCurrentIndex.get());
        if (multiMediaData != null) {
            multiMediaData.x = f;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setY(float f) {
        MultiMediaData multiMediaData = getMultiMediaData(this.mCurrentIndex.get());
        if (multiMediaData != null) {
            multiMediaData.y = f;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void split(final int i, final long j, final OnMultiMediaSplitListener onMultiMediaSplitListener) {
        if (xwb.e(getMultiMediaDataTrack()) || xwb.e(getInputMultiMediaDataTrack().multiMediaDataList) || xwb.e(getUpdateMediaTracks()) || xwb.e(getInputTrack().mediaSegments)) {
            return;
        }
        final MultiMediaData multiMediaData = (MultiMediaData) xwb.c(getInputMultiMediaDataTrack().multiMediaDataList, i);
        final MediaSegment mediaSegment = (MediaSegment) xwb.c(getInputTrack().mediaSegments, i);
        long j2 = mediaSegment.start;
        if (j2 > j || mediaSegment.end < j) {
            return;
        }
        final long currentSpeed = (((((float) (j - j2)) * (((float) (multiMediaData.end - multiMediaData.start)) / multiMediaData.getCurrentSpeed())) / ((float) (mediaSegment.end - mediaSegment.start))) * multiMediaData.getCurrentSpeed()) + ((float) multiMediaData.start);
        pausePlayer(false);
        VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
        if (multiMediaData.type != 1 || vLogSimplePlayer == null) {
            if (multiMediaData.type == 0) {
                addMultiMediaData(i + 1, new ArrayList<MultiMediaData>() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.11
                    {
                        add(MultiMediaDataSource.this.createMultiMediaData(multiMediaData, currentSpeed, mediaSegment));
                    }
                });
                if (onMultiMediaSplitListener != null) {
                    onMultiMediaSplitListener.onSplitPoint(((((((float) (currentSpeed - multiMediaData.start)) / multiMediaData.getCurrentSpeed()) * ((float) (mediaSegment.end - mediaSegment.start))) / ((float) (multiMediaData.end - multiMediaData.start))) / multiMediaData.getCurrentSpeed()) + ((float) mediaSegment.start));
                }
                notifyMediaTracksChanged();
            }
        } else if (onMultiMediaSplitListener == null) {
            addMultiMediaData(i + 1, new ArrayList<MultiMediaData>() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.9
                {
                    add(MultiMediaDataSource.this.createMultiMediaData(multiMediaData, currentSpeed, mediaSegment));
                }
            });
        } else {
            final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = vLogSimplePlayer.getOnSeekCompleteListener();
            vLogSimplePlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.10
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                    multiMediaData.player.setOnSeekCompleteListener(onSeekCompleteListener);
                    final long currentPosition = iMediaPlayer.getCurrentPosition();
                    MultiMediaDataSource.this.addMultiMediaData(i + 1, new ArrayList<MultiMediaData>() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.10.1
                        {
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            add(MultiMediaDataSource.this.createMultiMediaData(multiMediaData, currentPosition, mediaSegment));
                        }
                    });
                    long j3 = j;
                    MultiMediaData multiMediaData2 = multiMediaData;
                    long j4 = multiMediaData2.end;
                    long j5 = multiMediaData2.start;
                    if (j4 - j5 != 0) {
                        float currentSpeed2 = ((float) (currentPosition - j5)) / multiMediaData2.getCurrentSpeed();
                        MediaSegment mediaSegment2 = mediaSegment;
                        float f = currentSpeed2 * ((float) (mediaSegment2.end - mediaSegment2.start));
                        MultiMediaData multiMediaData3 = multiMediaData;
                        j3 = ((f / ((float) (multiMediaData3.end - multiMediaData3.start))) / multiMediaData3.getCurrentSpeed()) + ((float) mediaSegment.start);
                    }
                    onMultiMediaSplitListener.onSplitPoint(j3);
                    MultiMediaDataSource.this.notifyMediaTracksChanged();
                }
            });
            vLogSimplePlayer.seekTo(currentSpeed);
        }
        log();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void start() {
        startTimer(this.mPlayTime);
        IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
        if (onPlayStateListener != null) {
            onPlayStateListener.onStart();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateInputDataOrder(List<MultiMediaData> list) {
        MediaTrack inputTrack;
        ArrayList<MultiMediaData> inputMultiMediaDataList;
        int b;
        if (xwb.e(list) || (inputTrack = getInputTrack()) == null || (b = xwb.b((inputMultiMediaDataList = getInputMultiMediaDataList()))) != xwb.b(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int b2 = xwb.b(inputTrack.mediaSegments);
        for (int i = 0; i < b; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= b2) {
                    break;
                } else if (xwb.c(list, i) == xwb.c(inputMultiMediaDataList, i2)) {
                    arrayList.add(xwb.c(inputTrack.mediaSegments, i2));
                    break;
                } else {
                    i2++;
                }
            }
        }
        inputTrack.mediaSegments.clear();
        inputTrack.mediaSegments.addAll(arrayList);
        getInputMultiMediaDataTrack().multiMediaDataList.clear();
        getInputMultiMediaDataTrack().multiMediaDataList.addAll(list);
        applyTimeLineOnTemplateType();
        pc0.a(inputTrack, getMaxVideoDurationFromConfig());
        this.mMultiMediaAdapter.clear();
        reset();
        start();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateStickerDataRange(int i, String str, long j, long j2) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaSegment mediaSegment;
        int indexOf2;
        MultiMediaData multiMediaData;
        if (TextUtils.isEmpty(str) || j < 0 || j2 < 0 || j2 - j <= 0 || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || xwb.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || xwb.e(multiMediaDataTrack.multiMediaDataList) || (mediaSegment = (MediaSegment) xwb.c(getStickerSegmentsDataByType(str), i)) == null || (indexOf2 = subtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0 || (multiMediaData = (MultiMediaData) xwb.c(multiMediaDataTrack.multiMediaDataList, indexOf2)) == null) {
            return;
        }
        if (j2 > getDuration()) {
            j2 = getDuration();
            j = Math.max(getDuration() - (multiMediaData.end - multiMediaData.start), 0L);
        }
        if (TextUtils.equals(SubtitleLog.TAG, str)) {
            multiMediaData.start = j;
        } else {
            mediaSegment.start = j;
            mediaSegment.end = j2;
            multiMediaData.start = 0L;
            j2 -= j;
        }
        multiMediaData.end = j2;
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }
}
