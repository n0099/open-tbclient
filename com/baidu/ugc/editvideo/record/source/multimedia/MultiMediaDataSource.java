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
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.b.a.g;
import c.a.y0.j.b;
import c.a.y0.t.c;
import c.a.y0.t.d;
import c.a.y0.t.h;
import c.a.y0.t.u;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes13.dex */
public class MultiMediaDataSource implements Animator.AnimatorListener, Handler.Callback, IMultiMediaDataSource, IVLogCommunicateProtocol, IVlogEditManager, MultiMediaDataSourceRealTimer.AnimatorUpdateListener, MultiDataSourceUtil.OnInitMultiMediaListener, MultiDataSourceUtil.OnReleaseMultiMediaListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int Gl_THREAD_DELETE_ONE = 2;
    public static final int Gl_THREAD_INIT_ONE = 1;
    public static final int Gl_THREAD_MULTI_INIT_NEXT = 4;
    public static final int MSG_UPDATE_TIMELINE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean isCancel;
    public volatile boolean isLooping;
    public volatile boolean isMute;
    public volatile boolean isPaused;
    public volatile boolean isPrepared;
    public volatile boolean isProgressSeeking;
    public volatile int[] mAudioChangeTypes;
    public Map<String, MediaTrack> mCommonTrackMap;
    public AtomicInteger mCurrentIndex;
    public List<EffectChangeObserver> mEffectChangeObservers;
    public EGLContext mEglContext;
    public EglCore mEglCore;
    public int mFrameRate;
    public Handler mMainHandler;
    public List<MediaTrackChangeObserver> mMediaTrackChangeObservers;
    public MediaTrackConfig mMediaTrackConfig;
    public MultiMediaAdapter mMultiMediaAdapter;
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
    public Handler mReadPhotoHandler;
    public volatile int mRepeatIndex;
    public final Map<String, ShaderConfig> mShaderConfigMap;
    public NewSubTitleCreater mSubTitleCreater;
    public List<SubTitleUnit> mSubTitleUnitList;
    public volatile MultiMediaDataSourceRealTimer mTimer;
    public List<MediaTrack> mUpdateMediaTracks;
    public List<MultiMediaDataTrack> mUpdateMultiMediaDataTrack;
    public float mVideoRatio;
    public SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;

    public MultiMediaDataSource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentIndex = new AtomicInteger();
        this.mShaderConfigMap = new HashMap();
        this.mUpdateMediaTracks = new ArrayList();
        this.mUpdateMultiMediaDataTrack = new ArrayList();
        this.isProgressSeeking = false;
        this.isPaused = false;
        this.isLooping = true;
        this.mRepeatIndex = -1;
        this.mFrameRate = 30;
        this.mMultiMediaAdapter = new MultiMediaAdapter(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSource this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
            public void destroyPlayer(int i4, MultiMediaData multiMediaData) {
                MultiMediaDataTrack inputMultiMediaDataTrack;
                MultiMediaData multiMediaData2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, multiMediaData) == null) || (inputMultiMediaDataTrack = this.this$0.getInputMultiMediaDataTrack()) == null || h.e(inputMultiMediaDataTrack.multiMediaDataList) || (multiMediaData2 = (MultiMediaData) h.c(inputMultiMediaDataTrack.multiMediaDataList, i4)) == null) {
                    return;
                }
                c.b("destroyPlayer : " + i4);
                if (!this.this$0.isPaused) {
                    this.this$0.onReleaseMultiMedia(multiMediaData2);
                    return;
                }
                multiMediaData2.releaseSurface();
                multiMediaData2.releasePlayer();
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
            public int getCount() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    MultiMediaDataTrack inputMultiMediaDataTrack = this.this$0.getInputMultiMediaDataTrack();
                    if (inputMultiMediaDataTrack == null) {
                        return 0;
                    }
                    return h.b(inputMultiMediaDataTrack.multiMediaDataList);
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
            public MultiMediaData instantiatePlayer(int i4) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4)) == null) {
                    MultiMediaDataTrack inputMultiMediaDataTrack = this.this$0.getInputMultiMediaDataTrack();
                    if (inputMultiMediaDataTrack == null || h.e(inputMultiMediaDataTrack.multiMediaDataList)) {
                        return null;
                    }
                    MultiMediaData multiMediaData = (MultiMediaData) h.c(inputMultiMediaDataTrack.multiMediaDataList, i4);
                    if (multiMediaData.player != null) {
                        return null;
                    }
                    if (multiMediaData.type == 1) {
                        this.this$0.createPlayer(multiMediaData);
                    }
                    if (multiMediaData.textureId == 0) {
                        Message obtain = Message.obtain();
                        obtain.what = 1;
                        obtain.obj = multiMediaData;
                        this.this$0.mReadPhotoHandler.sendMessage(obtain);
                    } else {
                        this.this$0.bindPlayerSurfaceTexture(multiMediaData);
                    }
                    c.b("instantiatePlayer : " + i4);
                    return multiMediaData;
                }
                return (MultiMediaData) invokeI.objValue;
            }

            @Override // com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter
            public boolean isPlayerType(int i4) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i4)) == null) {
                    MultiMediaDataTrack inputMultiMediaDataTrack = this.this$0.getInputMultiMediaDataTrack();
                    return (inputMultiMediaDataTrack == null || h.e(inputMultiMediaDataTrack.multiMediaDataList) || ((MultiMediaData) h.c(inputMultiMediaDataTrack.multiMediaDataList, i4)) == null) ? false : true;
                }
                return invokeI.booleanValue;
            }
        };
        this.mMainHandler = new Handler(Looper.getMainLooper(), this);
        this.mReadPhotoHandler = new Handler(this, MultiMediaDataSourceTimerManager.getInstance().getReadPhotoLooper()) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public EGLContext mInnerEglContext;
            public final /* synthetic */ MultiMediaDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void initGlResource(MultiMediaData multiMediaData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(65537, this, multiMediaData) == null) || multiMediaData == null) {
                    return;
                }
                try {
                    if (this.this$0.mEglContext == null || this.this$0.isPaused || this.this$0.mEglContext == EGL14.EGL_NO_CONTEXT) {
                        return;
                    }
                    this.this$0.mOffscreenSurface.makeCurrent();
                    this.this$0.initMultiMedia(multiMediaData);
                } catch (RuntimeException e2) {
                    if (c.a.b0.b.a.k.c.l()) {
                        String str = c.a.b0.b.a.k.c.a;
                        e2.getLocalizedMessage();
                    }
                }
            }

            private void initNextGlResource(MultiMediaData multiMediaData) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(65538, this, multiMediaData) == null) || multiMediaData == null) {
                    return;
                }
                try {
                    if (this.this$0.mEglContext == null || this.this$0.isPaused || this.this$0.mEglContext == EGL14.EGL_NO_CONTEXT) {
                        return;
                    }
                    this.this$0.mOffscreenSurface.makeCurrent();
                    int i4 = multiMediaData.frameIndex != multiMediaData.frameCount ? multiMediaData.frameIndex + 1 : 0;
                    if (i4 == multiMediaData.frameCount) {
                        i4 = 0;
                    }
                    Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(multiMediaData.path + File.separator + i4 + "." + multiMediaData.frameSuffix);
                    try {
                        int type = GLUtils.getType(decodeBitmap);
                        int internalFormat = GLUtils.getInternalFormat(decodeBitmap);
                        c.b("type : " + type + " internalFormat : " + internalFormat);
                    } catch (Exception unused) {
                        decodeBitmap = d.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
                    }
                    if (multiMediaData.backupFrameTextureId != 0) {
                        GLES20.glBindTexture(3553, multiMediaData.backupFrameTextureId);
                    } else {
                        multiMediaData.backupFrameTextureId = g.b();
                    }
                    GLUtils.texImage2D(3553, 0, decodeBitmap, 0);
                    GLES20.glBindTexture(3553, 0);
                    decodeBitmap.recycle();
                } catch (RuntimeException e2) {
                    if (c.a.b0.b.a.k.c.l()) {
                        String str = c.a.b0.b.a.k.c.a;
                        e2.getLocalizedMessage();
                    }
                }
            }

            private void initSurface() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(65539, this) == null) {
                    try {
                        EGLContext eGLContext = this.this$0.mEglContext;
                        if (eGLContext == null) {
                            this.mInnerEglContext = null;
                            c.b("no gl context");
                            return;
                        }
                        if (this.mInnerEglContext != null) {
                            if (eGLContext != null && eGLContext != this.mInnerEglContext && eGLContext != EGL14.EGL_NO_CONTEXT) {
                                this.this$0.releaseEgl();
                            }
                            if (this.this$0.mEglCore == null || this.mInnerEglContext == null || this.mInnerEglContext == EGL14.EGL_NO_CONTEXT) {
                                return;
                            }
                            this.this$0.mEglCore = new EglCore(this.mInnerEglContext, 2);
                            this.this$0.mOffscreenSurface = new OffscreenSurface(this.this$0.mEglCore, 1, 1);
                            return;
                        }
                        this.mInnerEglContext = eGLContext;
                        if (this.this$0.mEglCore == null) {
                        }
                    } catch (Exception e2) {
                        if (c.a.b0.b.a.k.c.l()) {
                            String str = c.a.b0.b.a.k.c.a;
                            e2.getLocalizedMessage();
                        }
                    }
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    c.b("initSurface what : " + message.what + " mInnerEglContext : " + this.mInnerEglContext + " MultiMediaDataSource.this.mEglContext : " + this.this$0.mEglContext);
                    initSurface();
                    int i4 = message.what;
                    if (i4 == 1) {
                        Object obj = message.obj;
                        if (obj instanceof MultiMediaData) {
                            initGlResource((MultiMediaData) obj);
                        }
                    } else if (i4 == 2) {
                        MultiDataSourceUtil.glDeleteTextures(message.arg1);
                    } else if (i4 != 4) {
                    } else {
                        Object obj2 = message.obj;
                        if (obj2 instanceof MultiMediaData) {
                            initNextGlResource((MultiMediaData) obj2);
                        }
                    }
                }
            }
        };
    }

    private void applyTimeLineOnTemplateType() {
        MediaTrackConfig mediaTrackConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (mediaTrackConfig = this.mMediaTrackConfig) == null || !TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE) || h.e(this.mMediaTrackConfig.mediaTracks) || getInputTrack() == null) {
            return;
        }
        c.a.b0.b.a.k.c.d(getInputTrack(), getInputSegmentFromConfig(), this.mMediaTrackConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindPlayerSurfaceTexture(MultiMediaData multiMediaData) {
        VLogSimplePlayer vLogSimplePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65562, this, multiMediaData) == null) || (vLogSimplePlayer = multiMediaData.player) == null) {
            return;
        }
        multiMediaData.playerReady = false;
        SurfaceTexture surfaceTexture = new SurfaceTexture(multiMediaData.textureId);
        multiMediaData.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSource this$0;
            public final /* synthetic */ MultiMediaData val$multiMediaData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$multiMediaData = multiMediaData;
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceTexture2) == null) || this.val$multiMediaData.playerReady || surfaceTexture2.getTimestamp() == 0) {
                    return;
                }
                this.val$multiMediaData.playerReady = true;
            }
        });
        Surface surface = new Surface(multiMediaData.surfaceTexture);
        multiMediaData.surface = surface;
        vLogSimplePlayer.setSurface(surface);
        float f2 = this.isMute ? 0.0f : 1.0f;
        vLogSimplePlayer.setVolume(f2, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MultiMediaData createMultiMediaData(MultiMediaData multiMediaData, long j2, MediaSegment mediaSegment) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{multiMediaData, Long.valueOf(j2), mediaSegment})) == null) {
            MultiMediaData multiMediaData2 = (MultiMediaData) multiMediaData.clone();
            multiMediaData2.textureId = 0;
            multiMediaData2.backupFrameTextureId = 0;
            multiMediaData2.mtx = new float[16];
            multiMediaData2.surfaceTexture = null;
            multiMediaData2.surface = null;
            multiMediaData2.player = null;
            multiMediaData2.uuid = null;
            multiMediaData2.subTitleText = null;
            multiMediaData2.start = j2;
            multiMediaData2.end = multiMediaData.end;
            mediaSegment.end = (j2 - multiMediaData.start) + mediaSegment.start;
            multiMediaData.end = j2;
            return multiMediaData2;
        }
        return (MultiMediaData) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void createPlayer(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, multiMediaData) == null) {
            synchronized (this) {
                if (multiMediaData.type != 0 && multiMediaData.player == null) {
                    VLogSimplePlayer vLogSimplePlayer = new VLogSimplePlayer(multiMediaData.path);
                    vLogSimplePlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.20
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnPreparedListener
                        public void onPrepared(IMediaPlayer iMediaPlayer) {
                            SurfaceTexture surfaceTexture;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                                MultiMediaData multiMediaData2 = this.val$multiMediaData;
                                if (!multiMediaData2.playerReady && (surfaceTexture = multiMediaData2.surfaceTexture) != null && surfaceTexture.getTimestamp() != 0) {
                                    this.val$multiMediaData.playerReady = true;
                                }
                                this.this$0.notifyFrameAvailable();
                            }
                        }
                    });
                    vLogSimplePlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.21
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnInfoListener
                        public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
                            InterceptResult invokeLII;
                            SurfaceTexture surfaceTexture;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) == null) {
                                if (i2 == 3) {
                                    MultiMediaData multiMediaData2 = this.val$multiMediaData;
                                    if (!multiMediaData2.playerReady && (surfaceTexture = multiMediaData2.surfaceTexture) != null && surfaceTexture.getTimestamp() != 0) {
                                        this.val$multiMediaData.playerReady = true;
                                    }
                                } else if (i2 != 702) {
                                    return false;
                                }
                                this.this$0.notifyFrameAvailable();
                                return false;
                            }
                            return invokeLII.booleanValue;
                        }
                    });
                    vLogSimplePlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.22
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET, IPUT, IF] complete} */
                        /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
                            if (r6 != null) goto L13;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
                            r6.player = null;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
                            if (r6 == null) goto L14;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
                            if (r4.this$0.isPaused != false) goto L19;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
                            r4.this$0.createPlayer(r4.val$multiMediaData);
                            r4.this$0.bindPlayerSurfaceTexture(r4.val$multiMediaData);
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
                            return false;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
                            return false;
                         */
                        /* JADX WARN: Finally extract failed */
                        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnErrorListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
                            InterceptResult invokeLII;
                            MultiMediaData multiMediaData2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && (invokeLII = interceptable2.invokeLII(1048576, this, iMediaPlayer, i2, i3)) != null) {
                                return invokeLII.booleanValue;
                            }
                            try {
                                if (this.val$multiMediaData != null && this.val$multiMediaData.player != null) {
                                    this.val$multiMediaData.player.release();
                                }
                                multiMediaData2 = this.val$multiMediaData;
                            } catch (Throwable th) {
                                try {
                                    c.g(th);
                                    multiMediaData2 = this.val$multiMediaData;
                                } catch (Throwable th2) {
                                    MultiMediaData multiMediaData3 = this.val$multiMediaData;
                                    if (multiMediaData3 != null) {
                                        multiMediaData3.player = null;
                                    }
                                    throw th2;
                                }
                            }
                        }
                    });
                    vLogSimplePlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.23
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                                this.this$0.notifyFrameAvailable(this.val$multiMediaData.surfaceTexture);
                            }
                        }
                    });
                    vLogSimplePlayer.setOnSpeedChangeListener(new IMediaPlayer.OnSpeedChangeListener(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.24
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSpeedChangeListener
                        public void onSpeedChange(float f2) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeF(1048576, this, f2) == null) || this.this$0.mOnPlayStateListener == null) {
                                return;
                            }
                            this.this$0.mOnPlayStateListener.onSpeedChanged(f2, this.val$multiMediaData);
                        }
                    });
                    float f2 = this.isMute ? 0.0f : multiMediaData.volume;
                    vLogSimplePlayer.setVolume(f2, f2);
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
        }
    }

    private MediaTrack getEffectTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            MediaTrack effectTrack = MultiDataSourceUtil.getEffectTrack(this.mUpdateMediaTracks);
            if (effectTrack == null) {
                effectTrack = new MediaTrack();
                effectTrack.trackType = "effect";
                MediaTrack inputTrack = getInputTrack();
                int i2 = 1;
                if (inputTrack != null && TextUtils.equals("input_blank", inputTrack.trackType)) {
                    int i3 = 1;
                    while (i2 < this.mUpdateMediaTracks.size()) {
                        MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i2);
                        if (mediaTrack != null && TextUtils.equals("multi_input", mediaTrack.trackType)) {
                            i3++;
                        }
                        i2++;
                    }
                    i2 = i3;
                }
                this.mUpdateMediaTracks.add(i2, effectTrack);
                this.mUpdateMultiMediaDataTrack.add(i2, new MultiMediaDataTrack());
            }
            if (h.e(effectTrack.mediaSegments)) {
                effectTrack.mediaSegments = new ArrayList();
            }
            return effectTrack;
        }
        return (MediaTrack) invokeV.objValue;
    }

    private ArrayList<MultiMediaData> getInputMultiMediaDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (getInputMultiMediaDataTrack() == null) {
                return null;
            }
            return (ArrayList) getInputMultiMediaDataTrack().multiMediaDataList;
        }
        return (ArrayList) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MultiMediaDataTrack getInputMultiMediaDataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) ? (MultiMediaDataTrack) h.c(this.mUpdateMultiMediaDataTrack, 0) : (MultiMediaDataTrack) invokeV.objValue;
    }

    private List<MediaSegment> getInputSegmentFromConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (MediaTrack mediaTrack : this.mMediaTrackConfig.mediaTracks) {
                if (mediaTrack != null && !h.e(mediaTrack.mediaSegments)) {
                    for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                        if (mediaSegment != null && "input".equals(mediaSegment.type)) {
                            arrayList.add(mediaSegment);
                        }
                    }
                    if (!h.e(arrayList)) {
                        break;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private MediaTrack getInputTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) ? (MediaTrack) h.c(this.mUpdateMediaTracks, 0) : (MediaTrack) invokeV.objValue;
    }

    private long getMaxVideoDurationFromConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
            if (mediaTrackConfig == null) {
                return 0L;
            }
            return mediaTrackConfig.maxVideoDuration;
        }
        return invokeV.longValue;
    }

    private int getOriginalInputSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            int size = getInputMultiMediaDataTrack().multiMediaDataList.size();
            if (getInputMultiMediaDataTrack().hasHeader()) {
                size--;
            }
            return getInputMultiMediaDataTrack().hasFooter() ? size - 1 : size;
        }
        return invokeV.intValue;
    }

    private long getSegmentsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? MultiDataSourceUtil.getSegmentsDuration(getInputTrack()) : invokeV.longValue;
    }

    private void initAllPlayers() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || h.e(this.mUpdateMultiMediaDataTrack)) {
            return;
        }
        int b2 = h.b(this.mUpdateMultiMediaDataTrack);
        if (b2 > 0) {
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
        for (int i2 = 1; i2 < b2; i2++) {
            if (!h.e(this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataList)) {
                List<MultiMediaData> list = this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataList;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    MultiMediaData multiMediaData3 = list.get(i3);
                    if (multiMediaData3.type == 1) {
                        createPlayer(multiMediaData3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initMultiMedia(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, multiMediaData) == null) {
            synchronized (this) {
                initMultiMedia(multiMediaData, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initMultiMedia(MultiMediaData multiMediaData, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65575, this, multiMediaData, j2) == null) {
            synchronized (this) {
                if (multiMediaData != null) {
                    if (!TextUtils.isEmpty(multiMediaData.path) && ((multiMediaData.textureId == 0 || multiMediaData.isFrameSequential()) && !this.isPaused)) {
                        if (multiMediaData.type == 0) {
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
                                if (i3 == multiMediaData.frameIndex && multiMediaData.textureId != 0) {
                                    return;
                                }
                                if (multiMediaData.backupFrameTextureId != 0) {
                                    multiMediaData.frameIndex = i3;
                                    multiMediaData.releasePlayer();
                                    multiMediaData.releaseSurface();
                                    int i4 = multiMediaData.textureId;
                                    multiMediaData.textureId = multiMediaData.backupFrameTextureId;
                                    multiMediaData.backupFrameTextureId = i4;
                                } else {
                                    multiMediaData.frameIndex = i3;
                                    multiMediaData.releasePlayer();
                                    multiMediaData.releaseSurface();
                                    MultiDataSourceUtil.glDeleteTextures(multiMediaData);
                                    Bitmap decodeBitmap = MultiDataSourceUtil.decodeBitmap(str + File.separator + "" + i3 + "." + multiMediaData.frameSuffix);
                                    try {
                                        c.b("type : " + GLUtils.getType(decodeBitmap) + " internalFormat : " + GLUtils.getInternalFormat(decodeBitmap));
                                    } catch (Exception unused) {
                                        decodeBitmap = d.c(decodeBitmap, Bitmap.CompressFormat.PNG, 100);
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
                                    c.b("type : " + GLUtils.getType(decodeBitmap2) + " internalFormat : " + GLUtils.getInternalFormat(decodeBitmap2));
                                } catch (Exception unused2) {
                                    decodeBitmap2 = d.c(decodeBitmap2, Bitmap.CompressFormat.PNG, 100);
                                }
                                multiMediaData.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData, decodeBitmap2);
                            }
                        } else {
                            if (multiMediaData.width == 0 || multiMediaData.height == 0 || multiMediaData.originalDuration == 0) {
                                MultiDataSourceUtil.initVideoByPath(multiMediaData);
                            }
                            multiMediaData.textureId = g.d();
                            Matrix.setIdentityM(multiMediaData.mtx, 0);
                            bindPlayerSurfaceTexture(multiMediaData);
                        }
                    }
                }
            }
        }
    }

    public static boolean interceptUpdateByRepeat(MediaTrack mediaTrack, int i2, long j2) {
        InterceptResult invokeCommon;
        int[] findIndexInSegments;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{mediaTrack, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = -1;
            for (int i4 : MultiDataSourceUtil.findIndexInSegments(mediaTrack.mediaSegments, j2)) {
                if (i3 == -1 || i3 > i4) {
                    i3 = i4;
                }
            }
            return (i2 == -1 || i2 == i3) ? false : true;
        }
        return invokeCommon.booleanValue;
    }

    private void log() {
        MultiMediaData multiMediaData;
        MultiMediaData multiMediaData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65577, this) == null) && c.a.b0.b.a.k.c.l()) {
            String str = c.a.b0.b.a.k.c.a;
            if (this.mUpdateMultiMediaDataTrack != null) {
                for (int i2 = 0; i2 < this.mUpdateMultiMediaDataTrack.size(); i2++) {
                    MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(i2);
                    if (multiMediaDataTrack.multiMediaDataList != null) {
                        for (int i3 = 0; i3 < multiMediaDataTrack.multiMediaDataList.size(); i3++) {
                            MultiMediaData multiMediaData3 = multiMediaDataTrack.multiMediaDataList.get(i3);
                            String str2 = c.a.b0.b.a.k.c.a;
                            String str3 = "track : " + i2 + " --> multiMediaData : " + i3 + ": " + multiMediaData3.start + "----" + multiMediaData3.end + "---> tid : " + multiMediaData3.textureId + " path : " + multiMediaData3.path + " rotation : " + multiMediaData3.rotation + " w : " + multiMediaData3.width + " h : " + multiMediaData3.height + " defaultEffect : " + multiMediaData3.addDefaultEffect;
                        }
                    }
                    if (multiMediaDataTrack.multiMediaDataSuperpositionHeader != null) {
                        String str4 = c.a.b0.b.a.k.c.a;
                        String str5 = "SuperpositionHeader track : " + i2 + " --> multiMediaData  : " + multiMediaData.start + "----" + multiMediaData.end + "---> tid : " + multiMediaData.textureId + " path : " + multiMediaData.path + " rotation : " + multiMediaData.rotation + " w : " + multiMediaData.width + " h : " + multiMediaData.height;
                    }
                    if (multiMediaDataTrack.multiMediaDataSuperpositionFooter != null) {
                        String str6 = c.a.b0.b.a.k.c.a;
                        String str7 = "SuperpositionFooter track : " + i2 + " --> multiMediaData  : " + multiMediaData2.start + "----" + multiMediaData2.end + "---> tid : " + multiMediaData2.textureId + " path : " + multiMediaData2.path + " rotation : " + multiMediaData2.rotation + " w : " + multiMediaData2.width + " h : " + multiMediaData2.height;
                    }
                }
            }
            String str8 = c.a.b0.b.a.k.c.a;
        }
    }

    private void notifyEffectChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            int b2 = h.b(this.mEffectChangeObservers);
            for (int i2 = 0; i2 < b2; i2++) {
                EffectChangeObserver effectChangeObserver = (EffectChangeObserver) h.c(this.mEffectChangeObservers, i2);
                if (effectChangeObserver != null) {
                    effectChangeObserver.onChanged(getShaderConfigMap(), getUpdateMediaTracks());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable() {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65579, this) == null) || (onFrameAvailableListener = this.onFrameAvailableListener) == null) {
            return;
        }
        onFrameAvailableListener.onFrameAvailable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65580, this, surfaceTexture) == null) || (onFrameAvailableListener = this.onFrameAvailableListener) == null) {
            return;
        }
        onFrameAvailableListener.onFrameAvailable(surfaceTexture);
    }

    private void notifyIndexChanged(int i2, int i3) {
        MultiMediaStateEventListener multiMediaStateEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65581, this, i2, i3) == null) || i2 == i3 || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onIndexChanged(i2, i3);
    }

    private void notifyLoop() {
        MultiMediaStateEventListener multiMediaStateEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65582, this) == null) || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onLoop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMediaTracksChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            int b2 = h.b(this.mMediaTrackChangeObservers);
            for (int i2 = 0; i2 < b2; i2++) {
                MediaTrackChangeObserver mediaTrackChangeObserver = (MediaTrackChangeObserver) h.c(this.mMediaTrackChangeObservers, i2);
                if (mediaTrackChangeObserver != null) {
                    mediaTrackChangeObserver.onChanged(getUpdateMediaTracks());
                }
            }
        }
    }

    private void notifyPlayEnd() {
        MultiMediaStateEventListener multiMediaStateEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onPlayEnd();
    }

    private void notifyRepeatIndexEnd(int i2) {
        MultiMediaStateEventListener multiMediaStateEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65585, this, i2) == null) || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onRepeatIndexEnd(i2);
    }

    private void notifyRepeatIndexLoop(int i2) {
        MultiMediaStateEventListener multiMediaStateEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65586, this, i2) == null) || (multiMediaStateEventListener = this.mMultiMediaStateEventListener) == null) {
            return;
        }
        multiMediaStateEventListener.onRepeatIndexLoop(i2);
    }

    private void notifyTimelineUpdate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65587, this, j2) == null) {
            if (this.mMultiMediaTimelineUpdateListener != null) {
                updateSubtitle(j2);
                this.mMultiMediaTimelineUpdateListener.onTimelineUpdate(j2, getSegmentsDuration());
            }
            if (this.mMultiMediaTimelineUpdateListenerByMainThread != null) {
                Handler handler = this.mMainHandler;
                handler.sendMessage(handler.obtainMessage(1, Long.valueOf(j2)));
            }
            if (this.mMultiMediaTimelineUpdateListener == null && this.mMultiMediaTimelineUpdateListenerByMainThread == null) {
                updateSubtitle(j2);
            }
        }
    }

    private void pausePlayer(boolean z) {
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        VLogSimplePlayer vLogSimplePlayer3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65588, this, z) == null) {
            List<MultiMediaDataTrack> list = this.mUpdateMultiMediaDataTrack;
            if (h.e(list)) {
                return;
            }
            int b2 = h.b(list);
            for (int i2 = 0; i2 < b2; i2++) {
                MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(list, i2);
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
                    if (!h.e(list2)) {
                        int b3 = h.b(list2);
                        for (int i3 = 0; i3 < b3; i3++) {
                            MultiMediaData multiMediaData3 = list2.get(i3);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            this.mNeedInitMultiMediaData = false;
            if (this.isPrepared) {
                return;
            }
            u.a().post(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaDataSource this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mPreparedListener == null) {
                        return;
                    }
                    this.this$0.mPreparedListener.onPrepared();
                }
            });
            this.isPrepared = true;
        }
    }

    private void refreshUpdateMultiMediaDataTrack(List<MultiMediaData> list) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, this, list) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseEgl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            OffscreenSurface offscreenSurface = this.mOffscreenSurface;
            if (offscreenSurface != null) {
                offscreenSurface.release();
                this.mOffscreenSurface = null;
                c.b("releaseEgl mOffscreenSurface");
            }
            EglCore eglCore = this.mEglCore;
            if (eglCore != null) {
                eglCore.release();
                this.mEglCore = null;
                c.b("releaseEgl mEglCore");
            }
            this.mEglContext = null;
        }
    }

    private void releaseSubtitleCache() {
        NewSubTitleCreater newSubTitleCreater;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65592, this) == null) || (newSubTitleCreater = this.mSubTitleCreater) == null) {
            return;
        }
        newSubTitleCreater.releaseBitmap();
    }

    private void releaseSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, this) == null) {
            int b2 = h.b(this.mUpdateMultiMediaDataTrack);
            for (int i2 = 0; i2 < b2; i2++) {
                List<MultiMediaData> list = this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataList;
                if (list != null) {
                    for (MultiMediaData multiMediaData : list) {
                        multiMediaData.releaseSurface();
                        multiMediaData.releasePlayer();
                    }
                }
                if (this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionHeader != null) {
                    this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionHeader.releaseSurface();
                    this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionHeader.releasePlayer();
                }
                if (this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionFooter != null) {
                    this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionFooter.releaseSurface();
                    this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionFooter.releasePlayer();
                }
            }
        }
    }

    private void resetTimer() {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65594, this) == null) || (multiMediaDataSourceRealTimer = this.mTimer) == null) {
            return;
        }
        multiMediaDataSourceRealTimer.reset();
        this.mTimer = null;
    }

    private void runOnDraw(Runnable runnable) {
        OnPreRunnableTask onPreRunnableTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65595, this, runnable) == null) || (onPreRunnableTask = this.mPreRunnableTask) == null || onPreRunnableTask.getRunOnDrawList() == null) {
            return;
        }
        this.mPreRunnableTask.getRunOnDrawList().add(runnable);
    }

    private int seekInternal(MediaTrack mediaTrack, List<MultiMediaData> list, long j2, int i2) {
        InterceptResult invokeCommon;
        List<MultiMediaData> list2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65596, this, new Object[]{mediaTrack, list, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            int[] findIndexInSegments = MultiDataSourceUtil.findIndexInSegments(mediaTrack.mediaSegments, j2);
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            while (i5 < findIndexInSegments.length) {
                int i7 = findIndexInSegments[i5];
                if (i6 == i4 || i6 > i7) {
                    list2 = list;
                    i6 = i7;
                } else {
                    list2 = list;
                }
                MultiMediaData multiMediaData = (MultiMediaData) h.c(list2, i7);
                MediaSegment mediaSegment = (MediaSegment) h.c(mediaTrack.mediaSegments, i7);
                if (multiMediaData == null || mediaSegment == null) {
                    i3 = i5;
                } else {
                    int i8 = multiMediaData.type;
                    if (i8 == 1) {
                        VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                        if (vLogSimplePlayer == null) {
                            return i6;
                        }
                        long j3 = this.mPlayTime;
                        i3 = i5;
                        long j4 = mediaSegment.start;
                        vLogSimplePlayer.seekTo(j3 > j4 ? Math.min((((float) (j2 - j4)) * multiMediaData.getCurrentSpeed()) + ((float) multiMediaData.start), (float) multiMediaData.end) : multiMediaData.start);
                        if (i2 == 2 || i2 == 3) {
                            vLogSimplePlayer.start();
                        }
                    } else {
                        i3 = i5;
                        if (i8 == 0 && multiMediaData.isFrameSequential()) {
                            runOnDraw(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.18
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MultiMediaDataSource this$0;
                                public final /* synthetic */ MultiMediaData val$data;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, multiMediaData};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i9 = newInitContext.flag;
                                        if ((i9 & 1) != 0) {
                                            int i10 = i9 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$data = multiMediaData;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.this$0.initMultiMedia(this.val$data);
                                    }
                                }
                            });
                        }
                    }
                }
                i5 = i3 + 1;
                i4 = -1;
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    private void seekSuperpositionHeaderAndFooter(int i2, MediaTrack mediaTrack) {
        MultiMediaDataTrack inputMultiMediaDataTrack;
        MediaSegment mediaSegment;
        MediaSegment mediaSegment2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65597, this, i2, mediaTrack) == null) || (inputMultiMediaDataTrack = getInputMultiMediaDataTrack()) == null) {
            return;
        }
        MultiMediaData multiMediaData = inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader;
        MultiMediaData multiMediaData2 = inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter;
        if (multiMediaData != null && multiMediaData.type == 1 && multiMediaData.player != null && this.mPlayTime >= 0 && this.mPlayTime < multiMediaData.end && (mediaSegment2 = mediaTrack.superpositionHeader) != null) {
            long j2 = this.mPlayTime;
            long j3 = mediaSegment2.start;
            long j4 = multiMediaData.end;
            long j5 = multiMediaData.start;
            long j6 = ((j2 - j3) * (j4 - j5)) / (mediaSegment2.end - j3);
            if (j6 >= 0 && j6 < j4) {
                multiMediaData.player.seekTo(j6 + j5);
                if (i2 == 2 || i2 == 3) {
                    multiMediaData.player.start();
                }
            }
        }
        if (multiMediaData2 == null || multiMediaData2.type != 1 || multiMediaData2.player == null || this.mPlayTime < multiMediaData2.start || this.mPlayTime > multiMediaData2.end || (mediaSegment = mediaTrack.superpositionFooter) == null) {
            return;
        }
        long j7 = this.mPlayTime;
        long j8 = mediaSegment.start;
        long j9 = multiMediaData2.end;
        long j10 = multiMediaData2.start;
        long j11 = ((j7 - j8) * (j9 - j10)) / (mediaSegment.end - j8);
        if (j11 < j10 || j11 >= j9) {
            return;
        }
        multiMediaData2.player.seekTo(j11 + j10);
        if (i2 == 2 || i2 == 3) {
            multiMediaData2.player.start();
        }
    }

    private void setCurrentSubtitle(SubTitleUnit subTitleUnit) {
        Bitmap bitmap;
        MediaTrack buildSubtitleAndStickerTrack;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65598, this, subTitleUnit) == null) || subTitleUnit == null || (bitmap = subTitleUnit.textBitmap) == null || bitmap.isRecycled() || this.mSubTitleUnitList == null || this.mUpdateMediaTracks.size() != this.mUpdateMultiMediaDataTrack.size() || (indexOf = this.mUpdateMediaTracks.indexOf((buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack)))) < 0) {
            return;
        }
        MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf);
        List<MediaSegment> list = buildSubtitleAndStickerTrack.mediaSegments;
        if (list == null || multiMediaDataTrack.multiMediaDataList == null || list.size() != multiMediaDataTrack.multiMediaDataList.size()) {
            return;
        }
        for (int i2 = 0; i2 < buildSubtitleAndStickerTrack.mediaSegments.size(); i2++) {
            MediaSegment mediaSegment = buildSubtitleAndStickerTrack.mediaSegments.get(i2);
            MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i2);
            if (TextUtils.equals(mediaSegment.type, SubtitleLog.TAG)) {
                if (TextUtils.equals(multiMediaData.subTitleText, subTitleUnit.line) && multiMediaData.textureId != 0 && subTitleUnit.mIsNeedCache) {
                    return;
                }
                mediaSegment.effectStart = subTitleUnit.startTime;
                mediaSegment.effectEnd = subTitleUnit.endTime;
                mediaSegment.mediaAEffect = c.a.b0.b.a.k.c.i(buildSubtitleAndStickerTrack, this.mMediaTrackConfig, mediaSegment.type, this.mSubTitleUnitList.indexOf(subTitleUnit), this.mSubTitleUnitList.size(), subTitleUnit.endTime - subTitleUnit.startTime);
                c.c("zmy", "subTitleUnit.line : " + subTitleUnit.line + " multiMediaData.subTitleText : " + multiMediaData.subTitleText + " subTitleUnit.startTime : " + subTitleUnit.startTime + " end :" + subTitleUnit.startTime + " playTime : " + this.mPlayTime);
                multiMediaData.subTitleText = subTitleUnit.line;
                runOnDraw(new Runnable(this, multiMediaData, subTitleUnit) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;
                    public final /* synthetic */ MultiMediaData val$multiMediaData;
                    public final /* synthetic */ SubTitleUnit val$subTitleUnit;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, multiMediaData, subTitleUnit};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$multiMediaData = multiMediaData;
                        this.val$subTitleUnit = subTitleUnit;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MultiDataSourceUtil.glDeleteTextures(this.val$multiMediaData);
                            if (TextUtils.isEmpty(this.val$multiMediaData.subTitleText)) {
                                return;
                            }
                            MultiMediaData multiMediaData2 = this.val$multiMediaData;
                            multiMediaData2.width = 0;
                            multiMediaData2.height = 0;
                            if (!this.val$subTitleUnit.textBitmap.isRecycled()) {
                                Bitmap copy = this.val$subTitleUnit.textBitmap.copy(Bitmap.Config.ARGB_8888, false);
                                MultiMediaData multiMediaData3 = this.val$multiMediaData;
                                multiMediaData3.textureId = MultiDataSourceUtil.initImageByBitmap(multiMediaData3, copy);
                            }
                            MultiMediaData multiMediaData4 = this.val$multiMediaData;
                            multiMediaData4.scaleType = "adaptive";
                            SubTitleUnit subTitleUnit2 = this.val$subTitleUnit;
                            multiMediaData4.start = subTitleUnit2.startTime;
                            multiMediaData4.end = subTitleUnit2.endTime;
                            multiMediaData4.x = subTitleUnit2.x;
                            multiMediaData4.y = subTitleUnit2.y;
                        }
                    }
                });
            }
        }
    }

    private void startTimer(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65599, this, j2) == null) {
            MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
            if (multiMediaDataSourceRealTimer == null) {
                multiMediaDataSourceRealTimer = new MultiMediaDataSourceRealTimer();
                multiMediaDataSourceRealTimer.setDuration(getSegmentsDuration());
                multiMediaDataSourceRealTimer.setUpdateListener(this);
                multiMediaDataSourceRealTimer.setAnimatorListenerAdapter(this);
                multiMediaDataSourceRealTimer.setFrameRate(this.mFrameRate);
            }
            multiMediaDataSourceRealTimer.setCurrentPlayTime(j2);
            multiMediaDataSourceRealTimer.start();
            this.mTimer = multiMediaDataSourceRealTimer;
        }
    }

    private void stopTimer() {
        MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65600, this) == null) || (multiMediaDataSourceRealTimer = this.mTimer) == null) {
            return;
        }
        multiMediaDataSourceRealTimer.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubtitle(long j2) {
        NewSubTitleCreater newSubTitleCreater;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65601, this, j2) == null) || (newSubTitleCreater = this.mSubTitleCreater) == null) {
            return;
        }
        setCurrentSubtitle(newSubTitleCreater.getSubTitle(j2, getDuration()));
    }

    private void updateSuperpositionHeaderAndFooterTimeLine(long j2, List<MultiMediaDataTrack> list) {
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65602, this, j2, list) == null) || list == null) {
            return;
        }
        MultiMediaData multiMediaData = list.get(0).multiMediaDataSuperpositionHeader;
        MultiMediaData multiMediaData2 = list.get(0).multiMediaDataSuperpositionFooter;
        if (multiMediaData != null && multiMediaData.type == 1 && (vLogSimplePlayer2 = multiMediaData.player) != null) {
            if (j2 >= 0 && j2 < multiMediaData.end && !vLogSimplePlayer2.isPlaying()) {
                multiMediaData.player.start();
            } else if (j2 >= multiMediaData.end && multiMediaData.player.isPlaying()) {
                multiMediaData.player.pause();
                multiMediaData.player.seekTo(multiMediaData.start);
            }
        }
        if (multiMediaData2 == null || multiMediaData2.type != 1 || (vLogSimplePlayer = multiMediaData2.player) == null) {
            return;
        }
        if (j2 >= multiMediaData2.start && j2 < multiMediaData2.end && !vLogSimplePlayer.isPlaying()) {
            multiMediaData2.player.start();
        } else if (j2 >= multiMediaData2.start || !multiMediaData2.player.isPlaying()) {
        } else {
            multiMediaData2.player.pause();
            multiMediaData2.player.seekTo(0L);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addMultiMediaData(int i2, List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) || h.e(list)) {
            return;
        }
        int originalInputSize = getOriginalInputSize();
        MediaTrack inputTrack = getInputTrack();
        int hasGlobalFilter = MultiDataSourceUtil.hasGlobalFilter(inputTrack);
        String str = hasGlobalFilter >= 0 ? inputTrack.mediaSegments.get(hasGlobalFilter).lutConfigKey : null;
        int b2 = h.b(list) - 1;
        while (true) {
            if (b2 < 0) {
                MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
                if (mediaTrackConfig != null && !h.e(mediaTrackConfig.mediaTracks)) {
                    MediaSegment mediaSegment = this.mMediaTrackConfig.mediaTracks.get(0).superpositionHeader;
                    MediaSegment mediaSegment2 = this.mMediaTrackConfig.mediaTracks.get(0).superpositionFooter;
                    if (mediaSegment != null || mediaSegment2 != null) {
                        int max = Math.max(c.a.b0.b.a.k.c.f1314j, (mediaSegment == null ? 0 : 1) + (mediaSegment2 == null ? 0 : 1));
                        if (originalInputSize < max && originalInputSize + list.size() >= max) {
                            c.a.b0.b.a.k.c.b(inputTrack, this.mShaderConfigMap, this.mMediaTrackConfig.mediaTracks.get(0));
                            c.a.b0.b.a.k.c.c(inputTrack, this.mMediaTrackConfig);
                            MultiDataSourceUtil.applySuperpositionSegment(this.mUpdateMediaTracks, this.mShaderConfigMap, this.mUpdateMultiMediaDataTrack, this, this);
                        }
                    }
                }
                applyTimeLineOnTemplateType();
                c.a.b0.b.a.k.c.a(inputTrack, getMaxVideoDurationFromConfig());
                stopTimer();
                resetTimer();
                notifyMediaTracksChanged();
                return;
            }
            MultiMediaData multiMediaData = (MultiMediaData) h.c(list, b2);
            if (multiMediaData != null) {
                this.mMultiMediaAdapter.clearByIndex(i2 + b2);
                int addMultiMediaData = MultiDataSourceUtil.addMultiMediaData(getInputMultiMediaDataTrack(), i2, multiMediaData);
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
                    int i3 = addMultiMediaData - 1;
                    list2.add(i3 >= 0 ? i3 : 0, new MediaTransition());
                }
            }
            b2--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r4.mCommonTrackMap.containsKey(r5.trackType) == false) goto L14;
     */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addOneTrack(MediaTrack mediaTrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaTrack) == null) || mediaTrack == null) {
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
    public void addStickerData(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, multiMediaData, str) == null) || multiMediaData == null || TextUtils.isEmpty(str)) {
            return;
        }
        MediaTrack buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack);
        int indexOf = this.mUpdateMediaTracks.indexOf(buildSubtitleAndStickerTrack);
        if (indexOf >= 0) {
            MultiMediaDataTrack multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf);
            MultiDataSourceUtil.addMultiMediaData(multiMediaDataTrack, multiMediaDataTrack.multiMediaDataList.size(), multiMediaData);
            long j2 = this.mPlayTime;
            if (getDuration() - j2 < multiMediaData.end - multiMediaData.start) {
                j2 = Math.max(getDuration() - (multiMediaData.end - multiMediaData.start), 0L);
            }
            MediaSegment transData2Segment = MultiDataSourceUtil.transData2Segment(j2, multiMediaData);
            transData2Segment.type = str;
            buildSubtitleAndStickerTrack.mediaSegments.add(transData2Segment);
        }
        runOnDraw(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSource this$0;
            public final /* synthetic */ MultiMediaData val$stickerData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$stickerData = multiMediaData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.initMultiMedia(this.val$stickerData);
                    this.this$0.notifyFrameAvailable();
                }
            }
        });
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void deleteMultiMediaData(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int originalInputSize = getOriginalInputSize();
            int deleteMultiMediaData = MultiDataSourceUtil.deleteMultiMediaData(this.mUpdateMultiMediaDataTrack, i2, this);
            if (deleteMultiMediaData == -1) {
                return;
            }
            MediaTrack inputTrack = getInputTrack();
            inputTrack.mediaSegments.remove(deleteMultiMediaData);
            if (!h.e(inputTrack.mediaTransitions)) {
                if (deleteMultiMediaData == inputTrack.mediaTransitions.size()) {
                    deleteMultiMediaData--;
                }
                inputTrack.mediaTransitions.remove(deleteMultiMediaData);
            }
            MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
            MediaTrackConfig mediaTrackConfig = this.mMediaTrackConfig;
            if (mediaTrackConfig != null && inputMultiMediaDataTrack != null && !h.e(mediaTrackConfig.mediaTracks) && ((this.mMediaTrackConfig.mediaTracks.get(0).superpositionHeader != null || this.mMediaTrackConfig.mediaTracks.get(0).superpositionFooter != null) && originalInputSize >= (i3 = c.a.b0.b.a.k.c.f1314j) && originalInputSize - 1 < i3)) {
                onReleaseMultiMedia(inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader);
                inputMultiMediaDataTrack.multiMediaDataSuperpositionHeader = null;
                onReleaseMultiMedia(inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter);
                inputMultiMediaDataTrack.multiMediaDataSuperpositionFooter = null;
                inputTrack.superpositionHeader = null;
                inputTrack.superpositionFooter = null;
            }
            this.mMultiMediaAdapter.clear();
            applyTimeLineOnTemplateType();
            c.a.b0.b.a.k.c.a(inputTrack, getMaxVideoDurationFromConfig());
            stopTimer();
            resetTimer();
            notifyMediaTracksChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public int editOneEffect(int i2, MediaAEffectConfig mediaAEffectConfig, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), mediaAEffectConfig, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            MediaTrack effectTrack = getEffectTrack();
            MediaSegment mediaSegment = (MediaSegment) h.c(effectTrack.mediaSegments, i2);
            if (mediaSegment != null) {
                mediaSegment.start = j2;
                mediaSegment.end = j3;
            } else {
                MediaSegment mediaSegment2 = new MediaSegment();
                mediaSegment2.start = j2;
                mediaSegment2.end = j3;
                MediaAEffect mediaAEffect = mediaAEffectConfig.getMediaAEffect();
                mediaSegment2.mediaAEffect = mediaAEffect;
                mediaSegment2.type = "effect";
                mediaSegment2.effectConfigKey = mediaAEffect.name;
                effectTrack.mediaSegments.add(mediaSegment2);
                this.mShaderConfigMap.put(mediaSegment2.mediaAEffect.shaderConfigKey, mediaAEffectConfig.getShaderConfig());
                i2 = h.b(effectTrack.mediaSegments) - 1;
            }
            notifyEffectChanged();
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public String exportConfigJson(String str) {
        InterceptResult invokeL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this.mShaderConfigMap) {
                MediaTrackConfig exportConfigJson = ImportExportConfigUtil.exportConfigJson(this.mShaderConfigMap, this.mUpdateMediaTracks, getInputMultiMediaDataTrack(), this.mMediaTrackConfig, str);
                exportConfigJson.videoRatio = this.mVideoRatio;
                a = new b().a(exportConfigJson);
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCurrentIndex.get() : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPlayTime : invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public SubTitleUnit getCurrentSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (h.e(this.mSubTitleUnitList)) {
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
        return (SubTitleUnit) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getSegmentsDuration() : invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public ArrayList<MultiMediaData> getInputMultiMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mMediaTrackConfig : (MediaTrackConfig) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MultiMediaData getMultiMediaData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
            if (inputMultiMediaDataTrack != null) {
                return (MultiMediaData) h.c(inputMultiMediaDataTrack.multiMediaDataList, i2);
            }
            return null;
        }
        return (MultiMediaData) invokeI.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mUpdateMultiMediaDataTrack : (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MediaTrack getOriginEffectTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mOriginEffectTrack : (MediaTrack) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mShaderConfigMap : (Map) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MultiMediaData> getStickerMultiMediaDataList(boolean z) {
        InterceptResult invokeZ;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks);
            if (subtitleAndStickerTrack == null || h.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || h.e(multiMediaDataTrack.multiMediaDataList)) {
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
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            MediaTrack subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks);
            if (subtitleAndStickerTrack == null || h.e(subtitleAndStickerTrack.mediaSegments)) {
                return null;
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (MediaSegment mediaSegment : subtitleAndStickerTrack.mediaSegments) {
                    arrayList.add(mediaSegment.m37clone());
                }
                return arrayList;
            }
            return subtitleAndStickerTrack.mediaSegments;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsDataByType(String str) {
        InterceptResult invokeL;
        MediaTrack subtitleAndStickerTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || h.e(subtitleAndStickerTrack.mediaSegments)) {
                return null;
            }
            return MultiDataSourceUtil.getStickerSegmentsDataByType(subtitleAndStickerTrack, str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mUpdateMediaTracks : (List) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public float getVideoRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mVideoRatio : invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public float getVolume(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (h.e(this.mUpdateMultiMediaDataTrack) || h.e(getInputMultiMediaDataTrack().multiMediaDataList) || h.c(getInputMultiMediaDataTrack().multiMediaDataList, i2) == null) {
                return 1.0f;
            }
            return ((MultiMediaData) h.c(getInputMultiMediaDataTrack().multiMediaDataList, i2)).volume;
        }
        return invokeI.floatValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, message)) == null) {
            if (message.what == 1 && this.mMultiMediaTimelineUpdateListenerByMainThread != null && (message.obj instanceof Long) && !this.isPaused) {
                updateSubtitle(((Long) message.obj).longValue());
                this.mMultiMediaTimelineUpdateListenerByMainThread.onTimelineUpdate(((Long) message.obj).longValue(), getSegmentsDuration());
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.isMute : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mTimer == null || !this.mTimer.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            MultiMediaDataSourceRealTimer multiMediaDataSourceRealTimer = this.mTimer;
            return multiMediaDataSourceRealTimer != null && multiMediaDataSourceRealTimer.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void modifyTimeByRange(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            MultiDataSourceUtil.modifyTimeByRange(this.mUpdateMediaTracks, this.mOriginEffectTrack, j2, j3);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void needDrawEffect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, animator) == null) {
            this.isCancel = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, animator) == null) {
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
            } else if (this.mRepeatIndex != -1 && this.mRepeatIndex == h.b(getInputMultiMediaDataList()) - 1 && h.b(getInputMultiMediaDataList()) > 1) {
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
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, animator) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSourceRealTimer.AnimatorUpdateListener
    public void onAnimationUpdate(long j2) {
        int[] findIndexInSegments;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048609, this, j2) == null) || this.isPaused) {
            return;
        }
        this.mPlayTime = j2;
        this.mPlayTime = j2 >= 0 ? j2 > getSegmentsDuration() ? getSegmentsDuration() : j2 : 0L;
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
        } else if (j2 <= getDuration()) {
            int i2 = -1;
            for (int i3 : MultiDataSourceUtil.findIndexInSegments(inputTrack.mediaSegments, j2)) {
                if (i2 == -1 || i2 > i3) {
                    i2 = i3;
                }
            }
            if ((i2 == -1 ? 0 : i2) != this.mCurrentIndex.get()) {
                this.mMultiMediaAdapter.positionChanged(i2);
            }
            int updateTimeline = MultiDataSourceUtil.updateTimeline(inputTrack, inputMultiMediaDataTrack.multiMediaDataList, j2);
            updateSuperpositionHeaderAndFooterTimeLine(j2, this.mUpdateMultiMediaDataTrack);
            int i4 = this.mCurrentIndex.get();
            this.mCurrentIndex.set(updateTimeline != -1 ? updateTimeline : 0);
            notifyIndexChanged(i4, this.mCurrentIndex.get());
            int b2 = h.b(this.mUpdateMediaTracks);
            if (b2 > 1 && b2 == h.b(this.mUpdateMultiMediaDataTrack)) {
                for (int i5 = 1; i5 < b2; i5++) {
                    MediaTrack mediaTrack = (MediaTrack) h.c(this.mUpdateMediaTracks, i5);
                    MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(this.mUpdateMultiMediaDataTrack, i5);
                    if (mediaTrack != null && multiMediaDataTrack != null) {
                        List<MultiMediaData> list = multiMediaDataTrack.multiMediaDataList;
                        List<MediaSegment> list2 = mediaTrack.mediaSegments;
                        MultiDataSourceUtil.updateTimeline(mediaTrack, list, j2);
                        if (list2 != null && list != null) {
                            runOnDraw(new Runnable(this, list, list2) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MultiMediaDataSource this$0;
                                public final /* synthetic */ List val$mediaSegments;
                                public final /* synthetic */ List val$multiMediaDataList;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, list, list2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$multiMediaDataList = list;
                                    this.val$mediaSegments = list2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        for (int i6 = 0; i6 < this.val$multiMediaDataList.size(); i6++) {
                                            MultiMediaData multiMediaData = (MultiMediaData) this.val$multiMediaDataList.get(i6);
                                            MediaSegment mediaSegment = (MediaSegment) this.val$mediaSegments.get(i6);
                                            long j3 = mediaSegment != null ? mediaSegment.start : 0L;
                                            if (this.this$0.mPlayTime >= j3) {
                                                this.this$0.initMultiMedia(multiMediaData, j3);
                                            }
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
            notifyTimelineUpdate(j2);
            notifyFrameAvailable();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
        List<MultiMediaData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.mEglContext = EGL14.eglGetCurrentContext();
            }
            if (h.e(getInputMultiMediaDataList())) {
                return;
            }
            List<MultiMediaDataTrack> list2 = this.mUpdateMultiMediaDataTrack;
            for (int i2 = 0; i2 < h.b(list2); i2++) {
                MultiMediaDataTrack multiMediaDataTrack = list2.get(i2);
                if (multiMediaDataTrack != null && (list = multiMediaDataTrack.multiMediaDataList) != null) {
                    if (i2 == 0) {
                        initMultiMedia((MultiMediaData) h.c(list, this.mCurrentIndex.get()));
                        initMultiMedia((MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, this.mCurrentIndex.get() + 1));
                        initMultiMedia(multiMediaDataTrack.multiMediaDataSuperpositionHeader);
                        initMultiMedia(multiMediaDataTrack.multiMediaDataSuperpositionFooter);
                    } else {
                        for (int i3 = 0; i3 < multiMediaDataTrack.multiMediaDataList.size(); i3++) {
                            initMultiMedia(multiMediaDataTrack.multiMediaDataList.get(i3));
                        }
                    }
                }
            }
            if (this.mMediaTrackConfig == null || this.isPaused || this.mNeedInitMultiMediaData) {
                postPrepared();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil.OnInitMultiMediaListener
    public void onInitMultiMedia(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, multiMediaData) == null) {
            this.mNeedInitMultiMediaData = true;
            createPlayer(multiMediaData);
            runOnDraw(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaDataSource this$0;
                public final /* synthetic */ MultiMediaData val$multiMediaData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, multiMediaData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$multiMediaData = multiMediaData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.initMultiMedia(this.val$multiMediaData);
                        if ((this.val$multiMediaData.isHeader() || this.val$multiMediaData.isSuperpositionHeader() || this.val$multiMediaData.isOtherTrack()) && this.this$0.mCurrentIndex.get() == 0) {
                            this.this$0.postPrepared();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.isPaused = true;
            this.isPrepared = false;
            this.mNeedInitMultiMediaData = true;
            pause();
            releaseSurface();
            this.mMultiMediaAdapter.clear();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil.OnReleaseMultiMediaListener
    public void onReleaseMultiMedia(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, multiMediaData) == null) || multiMediaData == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.isPaused = false;
            notifyEffectChanged();
            initAllPlayers();
            this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
            seek(this.mPlayTime);
            updateSubtitle(this.mPlayTime);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            stopTimer();
            resetTimer();
            pausePlayer(false);
            IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
            if (onPlayStateListener != null) {
                onPlayStateListener.onPause();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public boolean rangeSegmentScope(int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaTrack inputTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j2 <= j3 && j2 >= 0 && (multiMediaDataTrack = (MultiMediaDataTrack) h.c(getMultiMediaDataTrack(), 0)) != null && !h.e(multiMediaDataTrack.multiMediaDataList) && h.c(multiMediaDataTrack.multiMediaDataList, i2) != null) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, i2);
                if ((multiMediaData.type != 1 || ((float) (j3 - j2)) <= ((float) multiMediaData.originalDuration) / multiMediaData.getCurrentSpeed()) && (inputTrack = getInputTrack()) != null && !h.e(inputTrack.mediaSegments)) {
                    long currentSpeed = (((float) (multiMediaData.end - multiMediaData.start)) / multiMediaData.getCurrentSpeed()) - ((float) (j3 - j2));
                    multiMediaData.start = ((float) j2) * multiMediaData.getCurrentSpeed();
                    multiMediaData.end = ((float) j3) * multiMediaData.getCurrentSpeed();
                    int b2 = h.b(inputTrack.mediaSegments);
                    ((MediaSegment) h.c(inputTrack.mediaSegments, i2)).end -= currentSpeed;
                    for (int i3 = i2 + 1; i3 < b2; i3++) {
                        MediaSegment mediaSegment = (MediaSegment) h.c(inputTrack.mediaSegments, i3);
                        mediaSegment.start -= currentSpeed;
                        mediaSegment.end -= currentSpeed;
                    }
                    applyTimeLineOnTemplateType();
                    c.a.b0.b.a.k.c.a(getInputTrack(), getMaxVideoDurationFromConfig());
                    stopTimer();
                    resetTimer();
                    notifyMediaTracksChanged();
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, effectChangeObserver) == null) {
            if (this.mEffectChangeObservers == null) {
                this.mEffectChangeObservers = new ArrayList();
            }
            if (this.mEffectChangeObservers.contains(effectChangeObserver)) {
                return;
            }
            this.mEffectChangeObservers.add(effectChangeObserver);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, mediaTrackChangeObserver) == null) {
            if (this.mMediaTrackChangeObservers == null) {
                this.mMediaTrackChangeObservers = new ArrayList();
            }
            if (this.mMediaTrackChangeObservers.contains(mediaTrackChangeObserver)) {
                return;
            }
            this.mMediaTrackChangeObservers.add(mediaTrackChangeObserver);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            stopTimer();
            this.mCurrentIndex.set(0);
            this.mPlayTime = 0L;
            releaseSurface();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        List<MultiMediaData> list;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            int b3 = h.b(this.mUpdateMultiMediaDataTrack);
            for (int i2 = 0; i2 < b3; i2++) {
                MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) h.c(this.mUpdateMultiMediaDataTrack, i2);
                if (multiMediaDataTrack != null && !h.e(multiMediaDataTrack.multiMediaDataList) && (b2 = h.b((list = multiMediaDataTrack.multiMediaDataList))) != 0) {
                    for (int i3 = 0; i3 < b2; i3++) {
                        MultiDataSourceUtil.glDeleteTextures((MultiMediaData) h.c(list, i3));
                    }
                    if (this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionHeader != null) {
                        MultiDataSourceUtil.glDeleteTextures(this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionHeader);
                    }
                    if (this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionFooter != null) {
                        MultiDataSourceUtil.glDeleteTextures(this.mUpdateMultiMediaDataTrack.get(i2).multiMediaDataSuperpositionFooter);
                    }
                }
            }
            releaseEgl();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeLastEffect() {
        MediaTrack effectTrack;
        List<MediaSegment> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (list = (effectTrack = getEffectTrack()).mediaSegments) == null) {
            return;
        }
        MediaSegment mediaSegment = (MediaSegment) h.c(list, list.size() - 1);
        if (mediaSegment != null) {
            effectTrack.mediaSegments.remove(mediaSegment);
        }
        if (h.e(effectTrack.mediaSegments)) {
            int indexOf = this.mUpdateMediaTracks.indexOf(effectTrack);
            this.mUpdateMediaTracks.remove(effectTrack);
            h.g(this.mUpdateMultiMediaDataTrack, indexOf);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeOneTrack(String str) {
        MediaTrack trackByType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || (trackByType = MultiDataSourceUtil.getTrackByType(this.mUpdateMediaTracks, str)) == null) {
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
    public void repeatIndex(int i2) {
        MediaTrack inputTrack;
        MediaSegment mediaSegment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.mRepeatIndex = i2;
            if (this.mRepeatIndex == -1 || (inputTrack = getInputTrack()) == null || (mediaSegment = (MediaSegment) h.c(inputTrack.mediaSegments, this.mRepeatIndex)) == null) {
                return;
            }
            if (this.mPlayTime < mediaSegment.start || this.mPlayTime > mediaSegment.end) {
                this.mCurrentIndex.set(i2);
                seek(mediaSegment.start + 1);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void replaceStickerData(int i2, MultiMediaData multiMediaData, String str) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaSegment mediaSegment;
        int indexOf2;
        MultiMediaData multiMediaData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048626, this, i2, multiMediaData, str) == null) || multiMediaData == null || TextUtils.isEmpty(str) || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || h.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || h.e(multiMediaDataTrack.multiMediaDataList) || (mediaSegment = (MediaSegment) h.c(getStickerSegmentsDataByType(str), i2)) == null || (indexOf2 = subtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0 || (multiMediaData2 = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, indexOf2)) == null) {
            return;
        }
        multiMediaData.end = multiMediaData2.end;
        multiMediaData.x = multiMediaData2.x;
        multiMediaData.y = multiMediaData2.y;
        multiMediaData.angle = multiMediaData2.angle;
        multiMediaData.scaleX = multiMediaData2.scaleX;
        multiMediaData.scaleY = multiMediaData2.scaleY;
        h.g(multiMediaDataTrack.multiMediaDataList, indexOf2);
        multiMediaDataTrack.multiMediaDataList.add(indexOf2, multiMediaData);
        runOnDraw(new Runnable(this, multiMediaData2, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MultiMediaDataSource this$0;
            public final /* synthetic */ MultiMediaData val$multiMediaData;
            public final /* synthetic */ MultiMediaData val$stickerData;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, multiMediaData2, multiMediaData};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$multiMediaData = multiMediaData2;
                this.val$stickerData = multiMediaData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    MultiDataSourceUtil.glDeleteTextures(this.val$multiMediaData);
                    this.this$0.initMultiMedia(this.val$stickerData);
                    this.this$0.notifyFrameAvailable();
                }
            }
        });
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            stopTimer();
            resetTimer();
            this.mCurrentIndex.set(0);
            this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
            this.mPlayTime = 0L;
            pausePlayer(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void seek(long j2) {
        long j3;
        MultiMediaData multiMediaData;
        int b2;
        int i2;
        int i3;
        int i4;
        IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener;
        MultiMediaData multiMediaData2;
        VLogSimplePlayer vLogSimplePlayer;
        VLogSimplePlayer vLogSimplePlayer2;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048628, this, j2) == null) || h.e(this.mUpdateMultiMediaDataTrack) || h.e(getInputMultiMediaDataTrack().multiMediaDataList)) {
            return;
        }
        boolean isPlaying = isPlaying();
        if (isPlaying) {
            pausePlayer(false);
            stopTimer();
        }
        long j4 = 0;
        if (j2 >= 0) {
            if (j2 <= getSegmentsDuration()) {
                j3 = j2;
                this.mPlayTime = j3;
                MediaTrack inputTrack = getInputTrack();
                List<MultiMediaData> list = getInputMultiMediaDataTrack().multiMediaDataList;
                int seekInternal = seekInternal(inputTrack, list, this.mPlayTime, !isPlaying ? 3 : 4);
                int i6 = this.mCurrentIndex.get();
                this.mCurrentIndex.set(seekInternal != -1 ? 0 : seekInternal);
                this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
                multiMediaData = (MultiMediaData) h.c(list, this.mCurrentIndex.get());
                if (multiMediaData != null && multiMediaData.textureId == 0) {
                    runOnDraw(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiMediaDataSource this$0;
                        public final /* synthetic */ MultiMediaData val$multiMediaData;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, multiMediaData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$multiMediaData = multiMediaData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.initMultiMedia(this.val$multiMediaData);
                                this.this$0.notifyFrameAvailable();
                            }
                        }
                    });
                }
                notifyIndexChanged(i6, this.mCurrentIndex.get());
                b2 = h.b(this.mUpdateMediaTracks);
                if (b2 > 1 && b2 == h.b(this.mUpdateMultiMediaDataTrack)) {
                    i5 = 1;
                    while (i5 < b2) {
                        seekInternal((MediaTrack) h.c(this.mUpdateMediaTracks, i5), this.mUpdateMultiMediaDataTrack.get(i5).multiMediaDataList, j3, isPlaying ? 3 : 4);
                        i5++;
                        b2 = b2;
                        i6 = i6;
                        seekInternal = seekInternal;
                    }
                }
                i2 = i6;
                i3 = b2;
                i4 = seekInternal;
                seekSuperpositionHeaderAndFooter(3, inputTrack);
                MultiMediaData multiMediaData3 = (MultiMediaData) h.c(list, this.mCurrentIndex.get());
                if (i3 <= 1 || (multiMediaData3 != null && (multiMediaData3.type != 1 || ((vLogSimplePlayer2 = multiMediaData3.player) != null && vLogSimplePlayer2.isInPlaybackState())))) {
                    notifyFrameAvailable();
                }
                seekSuperpositionHeaderAndFooter(3, inputTrack);
                notifyTimelineUpdate(j3);
                if (i2 != i4 && (multiMediaData2 = (MultiMediaData) h.c(getInputMultiMediaDataTrack().multiMediaDataList, i2)) != null && (vLogSimplePlayer = multiMediaData2.player) != null && ((float) vLogSimplePlayer.getCurrentPosition()) != ((float) multiMediaData2.start) / multiMediaData2.getCurrentSpeed()) {
                    multiMediaData2.player.seekTo(multiMediaData2.start);
                }
                if (isPlaying) {
                    startTimer(j3);
                }
                onPlayStateListener = this.mOnPlayStateListener;
                if (onPlayStateListener == null) {
                    onPlayStateListener.onSeek(j2);
                    return;
                }
                return;
            }
            j4 = getSegmentsDuration() - 16;
        }
        j3 = j4;
        this.mPlayTime = j3;
        MediaTrack inputTrack2 = getInputTrack();
        List<MultiMediaData> list2 = getInputMultiMediaDataTrack().multiMediaDataList;
        int seekInternal2 = seekInternal(inputTrack2, list2, this.mPlayTime, !isPlaying ? 3 : 4);
        int i62 = this.mCurrentIndex.get();
        this.mCurrentIndex.set(seekInternal2 != -1 ? 0 : seekInternal2);
        this.mMultiMediaAdapter.positionChanged(this.mCurrentIndex.get());
        multiMediaData = (MultiMediaData) h.c(list2, this.mCurrentIndex.get());
        if (multiMediaData != null) {
            runOnDraw(new Runnable(this, multiMediaData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaDataSource this$0;
                public final /* synthetic */ MultiMediaData val$multiMediaData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, multiMediaData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i7 = newInitContext.flag;
                        if ((i7 & 1) != 0) {
                            int i8 = i7 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$multiMediaData = multiMediaData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.initMultiMedia(this.val$multiMediaData);
                        this.this$0.notifyFrameAvailable();
                    }
                }
            });
        }
        notifyIndexChanged(i62, this.mCurrentIndex.get());
        b2 = h.b(this.mUpdateMediaTracks);
        if (b2 > 1) {
            i5 = 1;
            while (i5 < b2) {
            }
        }
        i2 = i62;
        i3 = b2;
        i4 = seekInternal2;
        seekSuperpositionHeaderAndFooter(3, inputTrack2);
        MultiMediaData multiMediaData32 = (MultiMediaData) h.c(list2, this.mCurrentIndex.get());
        if (i3 <= 1) {
        }
        notifyFrameAvailable();
        seekSuperpositionHeaderAndFooter(3, inputTrack2);
        notifyTimelineUpdate(j3);
        if (i2 != i4) {
            multiMediaData2.player.seekTo(multiMediaData2.start);
        }
        if (isPlaying) {
        }
        onPlayStateListener = this.mOnPlayStateListener;
        if (onPlayStateListener == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j2, int i2) {
        MultiMediaData multiMediaData;
        VLogSimplePlayer vLogSimplePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || h.e(this.mUpdateMultiMediaDataTrack) || h.e(getInputMultiMediaDataTrack().multiMediaDataList)) {
            return;
        }
        this.isProgressSeeking = i2 == 0 || i2 == 1;
        if (i2 == 0 || i2 == 3) {
            pausePlayer(false);
            stopTimer();
        }
        if (j2 < 0) {
            j2 = 0;
        } else if (j2 >= getSegmentsDuration()) {
            j2 = getSegmentsDuration() - 16;
        }
        this.mPlayTime = j2;
        MediaTrack inputTrack = getInputTrack();
        int seekInternal = seekInternal(inputTrack, getInputMultiMediaDataTrack().multiMediaDataList, this.mPlayTime, i2);
        this.mCurrentIndex.set(seekInternal == -1 ? 0 : seekInternal);
        int b2 = h.b(this.mUpdateMediaTracks);
        if (b2 > 1 && b2 == h.b(this.mUpdateMultiMediaDataTrack)) {
            for (int i3 = 1; i3 < b2; i3++) {
                seekInternal((MediaTrack) h.c(this.mUpdateMediaTracks, i3), this.mUpdateMultiMediaDataTrack.get(i3).multiMediaDataList, this.mPlayTime, i2);
            }
        }
        seekSuperpositionHeaderAndFooter(i2, inputTrack);
        notifyFrameAvailable();
        notifyTimelineUpdate(this.mPlayTime);
        if (i2 == 2) {
            int b3 = h.b(getInputMultiMediaDataTrack().multiMediaDataList);
            for (int i4 = 0; i4 < b3; i4++) {
                if (seekInternal != i4 && (multiMediaData = (MultiMediaData) h.c(getInputMultiMediaDataTrack().multiMediaDataList, i4)) != null && (vLogSimplePlayer = multiMediaData.player) != null && ((float) vLogSimplePlayer.getCurrentPosition()) != ((float) multiMediaData.start) / multiMediaData.getCurrentSpeed()) {
                    vLogSimplePlayer.seekTo(multiMediaData.start);
                }
            }
        }
        if (i2 == 3 || i2 == 2) {
            startTimer(this.mPlayTime);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAngle(int i2, float f2) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (multiMediaData = getMultiMediaData(i2)) == null) {
            return;
        }
        multiMediaData.angle = f2;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    @Deprecated
    public void setAngle(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) {
            setAngle(i2, i3);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            setAudioChangeType(new int[]{i2});
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr) {
        MultiMediaDataTrack inputMultiMediaDataTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, iArr) == null) {
            this.mAudioChangeTypes = iArr;
            if (h.e(this.mUpdateMediaTracks) || (inputMultiMediaDataTrack = getInputMultiMediaDataTrack()) == null || h.e(inputMultiMediaDataTrack.multiMediaDataList)) {
                return;
            }
            for (MultiMediaData multiMediaData : inputMultiMediaDataTrack.multiMediaDataList) {
                VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                if (vLogSimplePlayer != null) {
                    vLogSimplePlayer.setAudioChangeType(iArr);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2) {
        MultiMediaDataTrack inputMultiMediaDataTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048634, this, iArr, dArr, iArr2) == null) {
            this.mAudioChangeTypes = iArr;
            if (h.e(this.mUpdateMediaTracks) || (inputMultiMediaDataTrack = getInputMultiMediaDataTrack()) == null || h.e(inputMultiMediaDataTrack.multiMediaDataList)) {
                return;
            }
            for (MultiMediaData multiMediaData : inputMultiMediaDataTrack.multiMediaDataList) {
                VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                if (vLogSimplePlayer != null) {
                    vLogSimplePlayer.setAudioChangeType(iArr, dArr, iArr2);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, list, map) == null) {
            MediaTrack effectTrack = getEffectTrack();
            if (h.e(list) && map.isEmpty()) {
                int indexOf = this.mUpdateMediaTracks.indexOf(effectTrack);
                this.mUpdateMediaTracks.remove(effectTrack);
                h.g(this.mUpdateMultiMediaDataTrack, indexOf);
                return;
            }
            effectTrack.mediaSegments.clear();
            effectTrack.mediaSegments.addAll(list);
            this.mShaderConfigMap.putAll(map);
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Float.valueOf(f2), str}) == null) {
            setFilter(-1, f2, str);
            Iterator<Map.Entry<String, ShaderConfig>> it = this.mShaderConfigMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().contains(c.a.b0.b.a.k.c.f1308d)) {
                    it.remove();
                }
            }
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(int i2, float f2, String str) {
        MediaTextureData mediaTextureData;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), str}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        MediaTrack inputTrack = getInputTrack();
        String str2 = i2 >= 0 ? c.a.b0.b.a.k.c.f1308d + i2 : c.a.b0.b.a.k.c.f1307c;
        if (inputTrack != null) {
            String str3 = TextUtils.equals(str, IVlogEditManager.FILTER_ORIGINAL) ? "" : str2;
            if (c.a.b0.b.a.k.c.m(inputTrack, "input_blank")) {
                int i3 = 1;
                int i4 = -1;
                while (true) {
                    if (i3 >= this.mUpdateMediaTracks.size()) {
                        break;
                    }
                    MediaTrack mediaTrack = this.mUpdateMediaTracks.get(i3);
                    if (mediaTrack != null && c.a.b0.b.a.k.c.m(mediaTrack, "multi_input")) {
                        if (i4 == -1) {
                            i4 = i3;
                        }
                        if (i2 >= 0) {
                            if (i3 - i4 == i2) {
                                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                                    mediaSegment.lutConfigKey = str3;
                                }
                            }
                        } else if (i2 == -1) {
                            for (MediaSegment mediaSegment2 : mediaTrack.mediaSegments) {
                                mediaSegment2.lutConfigKey = str3;
                            }
                        }
                    }
                    i3++;
                }
            }
            MultiMediaDataTrack inputMultiMediaDataTrack = getInputMultiMediaDataTrack();
            List<MediaSegment> list = inputTrack.mediaSegments;
            if (list != null && inputMultiMediaDataTrack != null && inputMultiMediaDataTrack.multiMediaDataList != null) {
                if (i2 >= 0 && list.size() > i2 && inputMultiMediaDataTrack.multiMediaDataList.size() > i2) {
                    inputTrack.mediaSegments.get(i2).lutConfigKey = str3;
                } else if (i2 == -1) {
                    for (MediaSegment mediaSegment3 : inputTrack.mediaSegments) {
                        mediaSegment3.lutConfigKey = str3;
                    }
                }
            }
        }
        if (TextUtils.equals(str, IVlogEditManager.FILTER_ORIGINAL)) {
            ShaderConfig shaderConfig = this.mShaderConfigMap.get(str2);
            if (shaderConfig != null && !h.e(shaderConfig.textures)) {
                for (MediaTextureData mediaTextureData2 : shaderConfig.textures) {
                    int i5 = mediaTextureData2.textureId;
                    if (i5 != 0) {
                        runOnDraw(new Runnable(this, i5) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MultiMediaDataSource this$0;
                            public final /* synthetic */ int val$textureId;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i5)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i6 = newInitContext.flag;
                                    if ((i6 & 1) != 0) {
                                        int i7 = i6 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$textureId = i5;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    MultiDataSourceUtil.glDeleteTextures(this.val$textureId);
                                }
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
            if (h.e(shaderConfig2.textures)) {
                mediaTextureData = new MediaTextureData();
                mediaTextureData.type = MediaTextureData.TEXTURE_LUT;
                mediaTextureData.path = str;
                ArrayList arrayList = new ArrayList();
                shaderConfig2.textures = arrayList;
                arrayList.add(mediaTextureData);
                z = true;
            } else {
                mediaTextureData = (MediaTextureData) h.c(shaderConfig2.textures, 0);
                z = !TextUtils.equals(mediaTextureData.path, str);
                shaderConfig2.textures.clear();
                shaderConfig2.textures.add(mediaTextureData);
                mediaTextureData.path = str;
            }
            shaderConfig2.fParams = new ArrayList();
            ShaderParams shaderParams = new ShaderParams();
            shaderParams.name = "non_level";
            shaderParams.type = ShaderParams.VALUE_TYPE_FLOAT;
            shaderParams.values = new float[]{1.0f - f2};
            shaderConfig2.fParams.add(shaderParams);
            if (z) {
                runOnDraw(new Runnable(this, str, mediaTextureData) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;
                    public final /* synthetic */ String val$path;
                    public final /* synthetic */ MediaTextureData val$textureData;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, mediaTextureData};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i6 = newInitContext.flag;
                            if ((i6 & 1) != 0) {
                                int i7 = i6 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$path = str;
                        this.val$textureData = mediaTextureData;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap decodeBitmap;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (decodeBitmap = MultiDataSourceUtil.decodeBitmap(this.val$path)) == null) {
                            return;
                        }
                        MultiDataSourceUtil.glDeleteTextures(this.val$textureData.textureId);
                        int b2 = g.b();
                        GLUtils.texImage2D(3553, 0, decodeBitmap, 0);
                        this.val$textureData.textureId = b2;
                    }
                });
            }
        }
        if (i2 >= 0) {
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFrameRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mFrameRate = i2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.isLooping = z;
            IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
            if (onPlayStateListener != null) {
                onPlayStateListener.onSetIsLoop(z);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        MediaTrack effectTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, mediaTrackConfig) == null) {
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
            if (c.a.b0.b.a.k.c.k(this.mUpdateMediaTracks, "user_background")) {
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
                MultiMediaData multiMediaData = (MultiMediaData) h.c(getInputMultiMediaData(), this.mCurrentIndex.get());
                if (multiMediaData == null || multiMediaData.textureId == 0) {
                    this.mNeedInitMultiMediaData = true;
                } else {
                    postPrepared();
                }
            }
            log();
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMultiMediaData(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, list) == null) {
            if (h.e(list)) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaStateEventListener(MultiMediaStateEventListener multiMediaStateEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, multiMediaStateEventListener) == null) {
            this.mMultiMediaStateEventListener = multiMediaStateEventListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaTimelineUpdateListener(MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, multiMediaTimelineUpdateListener, z) == null) {
            if (z) {
                this.mMultiMediaTimelineUpdateListenerByMainThread = multiMediaTimelineUpdateListener;
            } else {
                this.mMultiMediaTimelineUpdateListener = multiMediaTimelineUpdateListener;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.isMute = z;
            int b2 = h.b(getInputMultiMediaDataList());
            for (int i2 = 0; i2 < b2; i2++) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(getInputMultiMediaDataList(), i2);
                if (multiMediaData.type == 1 && multiMediaData.player != null) {
                    float f2 = z ? 0.0f : multiMediaData.volume;
                    multiMediaData.player.setVolume(f2, f2);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onFrameAvailableListener) == null) {
            this.onFrameAvailableListener = onFrameAvailableListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setOnPlayStateListener(IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, onPlayStateListener) == null) {
            this.mOnPlayStateListener = onPlayStateListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setPreRunnableTask(OnPreRunnableTask onPreRunnableTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onPreRunnableTask) == null) {
            this.mPreRunnableTask = onPreRunnableTask;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setPreparedListener(IMultiMediaPreparedListener iMultiMediaPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, iMultiMediaPreparedListener) == null) {
            this.mPreparedListener = iMultiMediaPreparedListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScale(float f2, float f3) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (multiMediaData = getMultiMediaData(this.mCurrentIndex.get())) == null) {
            return;
        }
        multiMediaData.scaleX = f2;
        multiMediaData.scaleY = f3;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScaleType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048650, this, str) == null) || getInputMultiMediaDataList() == null) {
            return;
        }
        Iterator<MultiMediaData> it = getInputMultiMediaDataList().iterator();
        while (it.hasNext()) {
            it.next().scaleType = str;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setStickerDataList(List<MultiMediaData> list, List<MediaSegment> list2) {
        MediaTrack buildSubtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, list, list2) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            if (h.b(list) == h.b(list2) && (buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack)) != null && (indexOf = this.mUpdateMediaTracks.indexOf(buildSubtitleAndStickerTrack)) >= 0 && (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) != null) {
                List<MultiMediaData> list3 = multiMediaDataTrack.multiMediaDataList;
                List<MediaSegment> list4 = buildSubtitleAndStickerTrack.mediaSegments;
                if (list3 == null || list4 == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
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
                runOnDraw(new Runnable(this, arrayList, list) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;
                    public final /* synthetic */ List val$deleteMultiMediaDataList;
                    public final /* synthetic */ List val$tempFinalList;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, arrayList, list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$deleteMultiMediaDataList = arrayList;
                        this.val$tempFinalList = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (MultiMediaData multiMediaData2 : this.val$deleteMultiMediaDataList) {
                                MultiDataSourceUtil.glDeleteTextures(multiMediaData2);
                                for (MultiMediaData multiMediaData3 : this.val$tempFinalList) {
                                    if (TextUtils.equals(multiMediaData2.uuid, multiMediaData3.uuid)) {
                                        MultiDataSourceUtil.glDeleteTextures(multiMediaData3);
                                    }
                                }
                            }
                            for (MultiMediaData multiMediaData4 : this.val$tempFinalList) {
                                this.this$0.initMultiMedia(multiMediaData4);
                            }
                        }
                    }
                });
                notifyMediaTracksChanged();
                notifyFrameAvailable();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitle(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, list) == null) {
            this.mSubTitleUnitList = list;
            NewSubTitleCreater newSubTitleCreater = this.mSubTitleCreater;
            if (newSubTitleCreater == null) {
                NewSubTitleCreater newSubTitleCreater2 = new NewSubTitleCreater(list);
                this.mSubTitleCreater = newSubTitleCreater2;
                newSubTitleCreater2.setSubtitleCreaterCallBack(new NewSubTitleCreater.SubtitleCreaterCallBack(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.SubtitleCreaterCallBack
                    public void onSubtitleBitmapCreated() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mTimer == null) {
                            MultiMediaDataSource multiMediaDataSource = this.this$0;
                            multiMediaDataSource.updateSubtitle(multiMediaDataSource.mPlayTime);
                            this.this$0.notifyFrameAvailable();
                        }
                    }
                });
            } else {
                newSubTitleCreater.setSubTitleUnits(list);
            }
            int i2 = 0;
            if (list != null) {
                MediaTrack buildSubtitleAndStickerTrack = MultiDataSourceUtil.buildSubtitleAndStickerTrack(this.mUpdateMediaTracks, this.mUpdateMultiMediaDataTrack);
                Iterator<MediaSegment> it = buildSubtitleAndStickerTrack.mediaSegments.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (TextUtils.equals(SubtitleLog.TAG, it.next().type)) {
                        i2 = 1;
                        break;
                    }
                }
                if (i2 == 0) {
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
                    while (i2 < subtitleAndStickerTrack.mediaSegments.size()) {
                        MediaSegment mediaSegment2 = subtitleAndStickerTrack.mediaSegments.get(i2);
                        if (TextUtils.equals(mediaSegment2.type, SubtitleLog.TAG)) {
                            MultiMediaData multiMediaData = multiMediaDataTrack.multiMediaDataList.get(i2);
                            runOnDraw(new Runnable(this, multiMediaData.textureId, mediaSegment2.textureId) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MultiMediaDataSource this$0;
                                public final /* synthetic */ int val$mediaSegmentTextureId;
                                public final /* synthetic */ int val$multiMediaDataTextureId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(r7), Integer.valueOf(r8)};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                    this.val$multiMediaDataTextureId = r7;
                                    this.val$mediaSegmentTextureId = r8;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        MultiDataSourceUtil.glDeleteTextures(this.val$multiMediaDataTextureId);
                                        MultiDataSourceUtil.glDeleteTextures(this.val$mediaSegmentTextureId);
                                    }
                                }
                            });
                            subtitleAndStickerTrack.mediaSegments.remove(mediaSegment2);
                            multiMediaDataTrack.multiMediaDataList.remove(multiMediaData);
                        }
                        i2++;
                    }
                }
            }
            notifyMediaTracksChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, subTitleConfig) == null) {
            if (this.mSubTitleCreater == null) {
                NewSubTitleCreater newSubTitleCreater = new NewSubTitleCreater(null);
                this.mSubTitleCreater = newSubTitleCreater;
                newSubTitleCreater.setSubtitleCreaterCallBack(new NewSubTitleCreater.SubtitleCreaterCallBack(this) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.SubtitleCreaterCallBack
                    public void onSubtitleBitmapCreated() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mTimer == null) {
                            MultiMediaDataSource multiMediaDataSource = this.this$0;
                            multiMediaDataSource.updateSubtitle(multiMediaDataSource.mPlayTime);
                            this.this$0.notifyFrameAvailable();
                        }
                    }
                });
            }
            this.mSubTitleCreater.setSubTitleConfig(subTitleConfig);
            updateSubtitle(this.mPlayTime);
            notifyEffectChanged();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleOnStickerLayerTop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            int i2 = 0;
            List<MediaSegment> stickerSegmentsData = getStickerSegmentsData(false);
            List<MultiMediaData> stickerMultiMediaDataList = getStickerMultiMediaDataList(false);
            if (h.e(stickerSegmentsData) || h.e(stickerMultiMediaDataList) || h.b(stickerSegmentsData) != h.b(stickerMultiMediaDataList)) {
                return;
            }
            while (true) {
                if (i2 >= stickerSegmentsData.size()) {
                    i2 = -1;
                    break;
                } else if (stickerSegmentsData.get(i2) != null && TextUtils.equals(stickerSegmentsData.get(i2).type, SubtitleLog.TAG)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                h.h(stickerSegmentsData, i2, stickerSegmentsData.size() - 1);
                h.h(stickerMultiMediaDataList, i2, stickerMultiMediaDataList.size() - 1);
            }
            notifyMediaTracksChanged();
            notifyFrameAvailable();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setTransitionByIndex(int i2, MediaTransitionConfig mediaTransitionConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048655, this, i2, mediaTransitionConfig) == null) {
            MediaTrack inputTrack = getInputTrack();
            if (mediaTransitionConfig == null || mediaTransitionConfig.mediaTransition == null) {
                if (!h.e(inputTrack.mediaTransitions)) {
                    inputTrack.mediaTransitions.set(i2, new MediaTransition());
                    c.a.b0.b.a.k.c.a(inputTrack, getMaxVideoDurationFromConfig());
                }
                notifyEffectChanged();
                return;
            }
            if (h.e(inputTrack.mediaTransitions)) {
                int b2 = h.b(inputTrack.mediaSegments) - 1;
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < b2; i3++) {
                    if (i3 == i2) {
                        MediaTransition mediaTransition = mediaTransitionConfig.mediaTransition;
                        long j2 = ((MediaSegment) h.c(inputTrack.mediaSegments, i3)).end;
                        long j3 = mediaTransition.duration;
                        mediaTransition.start = j2 - (j3 / 2);
                        mediaTransition.end = j2 + (j3 / 2);
                        arrayList.add(mediaTransition);
                    } else {
                        arrayList.add(new MediaTransition());
                    }
                }
                inputTrack.mediaTransitions = arrayList;
            } else {
                MediaTransition mediaTransition2 = (MediaTransition) h.c(inputTrack.mediaTransitions, i2);
                MediaTransition mediaTransition3 = mediaTransitionConfig.mediaTransition;
                long j4 = (mediaTransition3.duration - mediaTransition2.duration) / 2;
                mediaTransition3.start = mediaTransition2.start + j4;
                mediaTransition3.end = mediaTransition2.end + j4;
                inputTrack.mediaTransitions.set(i2, mediaTransition3);
            }
            c.a.b0.b.a.k.c.a(inputTrack, getMaxVideoDurationFromConfig());
            for (Map.Entry<String, ShaderConfig> entry : mediaTransitionConfig.shaderConfigMap.entrySet()) {
                this.mShaderConfigMap.put(entry.getKey(), entry.getValue());
            }
            notifyEffectChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVideoRatio(float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048656, this, f2) == null) {
            MultiDataSourceUtil.sDefaultScaleType = "center_inside";
            float f4 = this.mVideoRatio;
            float f5 = 1.0f;
            if (f4 != 0.0f && f2 != 0.0f) {
                if (f4 < 1.0f || f2 < 1.0f) {
                    float f6 = this.mVideoRatio;
                    if (f6 > 1.0f || f2 > 1.0f) {
                        float f7 = this.mVideoRatio;
                        if (f7 <= f2) {
                            f7 = 1.0f / f2;
                        }
                        float f8 = this.mVideoRatio;
                        f5 = f7;
                        f3 = f8 > f2 ? f2 : 1.0f / f8;
                    } else {
                        f3 = f2 / f6;
                    }
                    if (!h.e(getInputMultiMediaDataList())) {
                        Iterator<MultiMediaData> it = getInputMultiMediaDataList().iterator();
                        while (it.hasNext()) {
                            MultiMediaData next = it.next();
                            next.x *= f5;
                            next.y *= f3;
                        }
                    }
                    this.mVideoRatio = f2;
                }
                f5 = f4 / f2;
            }
            f3 = 1.0f;
            if (!h.e(getInputMultiMediaDataList())) {
            }
            this.mVideoRatio = f2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048657, this, f2) == null) || h.b(this.mUpdateMultiMediaDataTrack) == 0) {
            return;
        }
        for (MultiMediaData multiMediaData : getInputMultiMediaDataTrack().multiMediaDataList) {
            if (multiMediaData != null && multiMediaData.type == 1) {
                multiMediaData.volume = f2;
                VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
                if (vLogSimplePlayer != null) {
                    vLogSimplePlayer.setVolume(f2, f2);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(int i2, float f2) {
        MultiMediaData multiMediaData;
        VLogSimplePlayer vLogSimplePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || h.b(this.mUpdateMultiMediaDataTrack) == 0 || (multiMediaData = (MultiMediaData) h.c(getInputMultiMediaDataTrack().multiMediaDataList, i2)) == null || multiMediaData.type != 1 || (vLogSimplePlayer = multiMediaData.player) == null) {
            return;
        }
        multiMediaData.volume = f2;
        vLogSimplePlayer.setVolume(f2, f2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setX(float f2) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048659, this, f2) == null) || (multiMediaData = getMultiMediaData(this.mCurrentIndex.get())) == null) {
            return;
        }
        multiMediaData.x = f2;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setY(float f2) {
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048660, this, f2) == null) || (multiMediaData = getMultiMediaData(this.mCurrentIndex.get())) == null) {
            return;
        }
        multiMediaData.y = f2;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void split(int i2, long j2, OnMultiMediaSplitListener onMultiMediaSplitListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), onMultiMediaSplitListener}) == null) || h.e(getMultiMediaDataTrack()) || h.e(getInputMultiMediaDataTrack().multiMediaDataList) || h.e(getUpdateMediaTracks()) || h.e(getInputTrack().mediaSegments)) {
            return;
        }
        MultiMediaData multiMediaData = (MultiMediaData) h.c(getInputMultiMediaDataTrack().multiMediaDataList, i2);
        MediaSegment mediaSegment = (MediaSegment) h.c(getInputTrack().mediaSegments, i2);
        long j3 = mediaSegment.start;
        if (j3 > j2 || mediaSegment.end < j2) {
            return;
        }
        long currentSpeed = (((((float) (j2 - j3)) * (((float) (multiMediaData.end - multiMediaData.start)) / multiMediaData.getCurrentSpeed())) / ((float) (mediaSegment.end - mediaSegment.start))) * multiMediaData.getCurrentSpeed()) + ((float) multiMediaData.start);
        pausePlayer(false);
        VLogSimplePlayer vLogSimplePlayer = multiMediaData.player;
        if (multiMediaData.type != 1 || vLogSimplePlayer == null) {
            if (multiMediaData.type == 0) {
                addMultiMediaData(i2 + 1, new ArrayList<MultiMediaData>(this, multiMediaData, currentSpeed, mediaSegment) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MultiMediaDataSource this$0;
                    public final /* synthetic */ long val$currentDataPlayPosition;
                    public final /* synthetic */ MultiMediaData val$data;
                    public final /* synthetic */ MediaSegment val$segment;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, multiMediaData, Long.valueOf(currentSpeed), mediaSegment};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$data = multiMediaData;
                        this.val$currentDataPlayPosition = currentSpeed;
                        this.val$segment = mediaSegment;
                        add(this.this$0.createMultiMediaData(this.val$data, this.val$currentDataPlayPosition, this.val$segment));
                    }
                });
                if (onMultiMediaSplitListener != null) {
                    onMultiMediaSplitListener.onSplitPoint(((((((float) (currentSpeed - multiMediaData.start)) / multiMediaData.getCurrentSpeed()) * ((float) (mediaSegment.end - mediaSegment.start))) / ((float) (multiMediaData.end - multiMediaData.start))) / multiMediaData.getCurrentSpeed()) + ((float) mediaSegment.start));
                }
                notifyMediaTracksChanged();
            }
        } else if (onMultiMediaSplitListener == null) {
            addMultiMediaData(i2 + 1, new ArrayList<MultiMediaData>(this, multiMediaData, currentSpeed, mediaSegment) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaDataSource this$0;
                public final /* synthetic */ long val$currentDataPlayPosition;
                public final /* synthetic */ MultiMediaData val$data;
                public final /* synthetic */ MediaSegment val$segment;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, multiMediaData, Long.valueOf(currentSpeed), mediaSegment};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$data = multiMediaData;
                    this.val$currentDataPlayPosition = currentSpeed;
                    this.val$segment = mediaSegment;
                    add(this.this$0.createMultiMediaData(this.val$data, this.val$currentDataPlayPosition, this.val$segment));
                }
            });
        } else {
            vLogSimplePlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener(this, multiMediaData, vLogSimplePlayer.getOnSeekCompleteListener(), i2, mediaSegment, j2, onMultiMediaSplitListener) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiMediaDataSource this$0;
                public final /* synthetic */ MultiMediaData val$data;
                public final /* synthetic */ long val$fuzzyPlayPosition;
                public final /* synthetic */ int val$index;
                public final /* synthetic */ OnMultiMediaSplitListener val$l;
                public final /* synthetic */ IMediaPlayer.OnSeekCompleteListener val$onSeekCompleteListener;
                public final /* synthetic */ MediaSegment val$segment;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, multiMediaData, r8, Integer.valueOf(i2), mediaSegment, Long.valueOf(j2), onMultiMediaSplitListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$data = multiMediaData;
                    this.val$onSeekCompleteListener = r8;
                    this.val$index = i2;
                    this.val$segment = mediaSegment;
                    this.val$fuzzyPlayPosition = j2;
                    this.val$l = onMultiMediaSplitListener;
                }

                @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iMediaPlayer) == null) {
                        this.val$data.player.setOnSeekCompleteListener(this.val$onSeekCompleteListener);
                        long currentPosition = iMediaPlayer.getCurrentPosition();
                        this.this$0.addMultiMediaData(this.val$index + 1, new ArrayList<MultiMediaData>(this, currentPosition) { // from class: com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaDataSource.10.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass10 this$1;
                            public final /* synthetic */ long val$position;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Long.valueOf(currentPosition)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$position = currentPosition;
                                AnonymousClass10 anonymousClass10 = this.this$1;
                                add(anonymousClass10.this$0.createMultiMediaData(anonymousClass10.val$data, this.val$position, anonymousClass10.val$segment));
                            }
                        });
                        long j4 = this.val$fuzzyPlayPosition;
                        MultiMediaData multiMediaData2 = this.val$data;
                        long j5 = multiMediaData2.end;
                        long j6 = multiMediaData2.start;
                        if (j5 - j6 != 0) {
                            float currentSpeed2 = ((float) (currentPosition - j6)) / multiMediaData2.getCurrentSpeed();
                            MediaSegment mediaSegment2 = this.val$segment;
                            float f2 = currentSpeed2 * ((float) (mediaSegment2.end - mediaSegment2.start));
                            MultiMediaData multiMediaData3 = this.val$data;
                            j4 = ((f2 / ((float) (multiMediaData3.end - multiMediaData3.start))) / multiMediaData3.getCurrentSpeed()) + ((float) this.val$segment.start);
                        }
                        this.val$l.onSplitPoint(j4);
                        this.this$0.notifyMediaTracksChanged();
                    }
                }
            });
            vLogSimplePlayer.seekTo(currentSpeed);
        }
        log();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            startTimer(this.mPlayTime);
            IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener = this.mOnPlayStateListener;
            if (onPlayStateListener != null) {
                onPlayStateListener.onStart();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateInputDataOrder(List<MultiMediaData> list) {
        MediaTrack inputTrack;
        ArrayList<MultiMediaData> inputMultiMediaDataList;
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048663, this, list) == null) || h.e(list) || (inputTrack = getInputTrack()) == null || (b2 = h.b((inputMultiMediaDataList = getInputMultiMediaDataList()))) != h.b(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int b3 = h.b(inputTrack.mediaSegments);
        for (int i2 = 0; i2 < b2; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= b3) {
                    break;
                } else if (h.c(list, i2) == h.c(inputMultiMediaDataList, i3)) {
                    arrayList.add(h.c(inputTrack.mediaSegments, i3));
                    break;
                } else {
                    i3++;
                }
            }
        }
        inputTrack.mediaSegments.clear();
        inputTrack.mediaSegments.addAll(arrayList);
        getInputMultiMediaDataTrack().multiMediaDataList.clear();
        getInputMultiMediaDataTrack().multiMediaDataList.addAll(list);
        applyTimeLineOnTemplateType();
        c.a.b0.b.a.k.c.a(inputTrack, getMaxVideoDurationFromConfig());
        this.mMultiMediaAdapter.clear();
        reset();
        start();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateStickerDataRange(int i2, String str, long j2, long j3) {
        MediaTrack subtitleAndStickerTrack;
        int indexOf;
        MultiMediaDataTrack multiMediaDataTrack;
        MediaSegment mediaSegment;
        int indexOf2;
        MultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Long.valueOf(j3)}) == null) || TextUtils.isEmpty(str) || j2 < 0 || j3 < 0 || j3 - j2 <= 0 || (subtitleAndStickerTrack = MultiDataSourceUtil.getSubtitleAndStickerTrack(this.mUpdateMediaTracks)) == null || h.e(subtitleAndStickerTrack.mediaSegments) || (indexOf = this.mUpdateMediaTracks.indexOf(subtitleAndStickerTrack)) < 0 || (multiMediaDataTrack = this.mUpdateMultiMediaDataTrack.get(indexOf)) == null || h.e(multiMediaDataTrack.multiMediaDataList) || (mediaSegment = (MediaSegment) h.c(getStickerSegmentsDataByType(str), i2)) == null || (indexOf2 = subtitleAndStickerTrack.mediaSegments.indexOf(mediaSegment)) < 0 || (multiMediaData = (MultiMediaData) h.c(multiMediaDataTrack.multiMediaDataList, indexOf2)) == null) {
            return;
        }
        if (j3 > getDuration()) {
            j3 = getDuration();
            j2 = Math.max(getDuration() - (multiMediaData.end - multiMediaData.start), 0L);
        }
        if (TextUtils.equals(SubtitleLog.TAG, str)) {
            multiMediaData.start = j2;
        } else {
            mediaSegment.start = j2;
            mediaSegment.end = j3;
            multiMediaData.start = 0L;
            j3 -= j2;
        }
        multiMediaData.end = j3;
        notifyMediaTracksChanged();
        notifyFrameAvailable();
    }
}
