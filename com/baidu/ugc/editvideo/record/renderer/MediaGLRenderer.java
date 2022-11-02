package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.eg0;
import com.baidu.tieba.ni9;
import com.baidu.tieba.ri9;
import com.baidu.tieba.wi9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
public class MediaGLRenderer implements GLSurfaceView.Renderer, IMediaLifeCycle, EffectChangeObserver, MediaTrackChangeObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mBlue;
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public GLViewPortLocation mGLViewPortLocation;
    public float mGreen;
    public boolean mHasSetPro;
    public List<IEffectProcessor> mIEffectProcessors;
    public List<IMediaRenderer> mIMediaRenderers;
    public OnDrawFrameFrequencyListener mOnDrawFrameFrequencyListener;
    public OnEditStickerListener mOnEditStickerListener;
    public OnMediaGLRendererStatusListener mOnMediaGLRendererStatusListener;
    public List<Long> mProcessorCostTimeList;
    public float mRed;
    public GLSurfaceView.Renderer mRendererListener;
    public float mScaleX;
    public float mScaleY;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public ni9 mTextureReader;
    public float mTx;
    public float mTy;
    public float[] mUpdateMatrix;
    public int mUpdateTextureId;
    public int mUpdateTextureMode;
    public float mVideoRatio;
    public eg0 mVlogEdit;
    public boolean mWaitingDrawFrame;

    /* loaded from: classes6.dex */
    public interface OnDrawFrameFrequencyListener {
        void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation);
    }

    /* loaded from: classes6.dex */
    public interface OnEditStickerListener {
        boolean canDoProcessor();
    }

    /* loaded from: classes6.dex */
    public interface OnMediaGLRendererStatusListener {
        void onError(int i, String str);
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public MediaGLRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUpdateTextureMode = 0;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTx = 0.0f;
        this.mTy = 0.0f;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
        this.mProcessorCostTimeList = new CopyOnWriteArrayList();
    }

    public double getProcessorCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (wi9.e(this.mProcessorCostTimeList)) {
                return 0.0d;
            }
            long j = 0;
            int size = this.mProcessorCostTimeList.size();
            for (Long l : this.mProcessorCostTimeList) {
                j += l.longValue();
            }
            this.mProcessorCostTimeList.clear();
            return j / size;
        }
        return invokeV.doubleValue;
    }

    private void debugProcessorCostTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j) == null) {
            this.mProcessorCostTimeList.add(Long.valueOf(j));
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, list) != null) || (eg0Var = this.mVlogEdit) == null) {
            return;
        }
        eg0Var.n(list);
    }

    public void setCore(eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eg0Var) == null) {
            this.mVlogEdit = eg0Var;
        }
    }

    public void setEffectProcessor(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.mIEffectProcessors = list;
        }
    }

    public void setMediaRenderer(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.mIMediaRenderers = list;
        }
    }

    public void setOnDrawFrameFrequencyListener(OnDrawFrameFrequencyListener onDrawFrameFrequencyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onDrawFrameFrequencyListener) == null) {
            this.mOnDrawFrameFrequencyListener = onDrawFrameFrequencyListener;
        }
    }

    public void setOnEditStickerListener(OnEditStickerListener onEditStickerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onEditStickerListener) == null) {
            this.mOnEditStickerListener = onEditStickerListener;
        }
    }

    public void setOnMediaGLRendererStatusListener(OnMediaGLRendererStatusListener onMediaGLRendererStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onMediaGLRendererStatusListener) == null) {
            this.mOnMediaGLRendererStatusListener = onMediaGLRendererStatusListener;
        }
    }

    public void setRendererListener(GLSurfaceView.Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, renderer) == null) {
            this.mRendererListener = renderer;
        }
    }

    public void setTextureReader(ni9 ni9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ni9Var) == null) {
            this.mTextureReader = ni9Var;
        }
    }

    public void setWaitingDrawFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mWaitingDrawFrame = z;
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ni9 ni9Var = this.mTextureReader;
            if (ni9Var != null) {
                ni9Var.release();
            }
            eg0 eg0Var = this.mVlogEdit;
            if (eg0Var != null) {
                eg0Var.release();
            }
            FullFrameRect fullFrameRect = this.mFullScreenEXT;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
                this.mFullScreenEXT = null;
            }
            FullFrameRect fullFrameRect2 = this.mFullScreen2D;
            if (fullFrameRect2 != null) {
                fullFrameRect2.release(false);
                this.mFullScreen2D = null;
            }
        }
    }

    public FullFrameRect getFullScreen2D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mFullScreen2D;
        }
        return (FullFrameRect) invokeV.objValue;
    }

    public FullFrameRect getFullScreenEXT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFullScreenEXT;
        }
        return (FullFrameRect) invokeV.objValue;
    }

    public GLViewPortLocation getGLViewPortLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mGLViewPortLocation;
        }
        return (GLViewPortLocation) invokeV.objValue;
    }

    public int getSurfaceViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSurfaceViewHeight;
        }
        return invokeV.intValue;
    }

    public int getSurfaceViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mSurfaceViewWidth;
        }
        return invokeV.intValue;
    }

    public eg0 getVlogEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mVlogEdit;
        }
        return (eg0) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map, list) != null) || (eg0Var = this.mVlogEdit) == null) {
            return;
        }
        eg0Var.e(list, map);
    }

    public void onDrawFrame(int i, long j) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) && (eg0Var = this.mVlogEdit) != null) {
            eg0Var.g(i, j);
            eg0 eg0Var2 = this.mVlogEdit;
            GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
            eg0Var2.b(gLViewPortLocation.width, gLViewPortLocation.height);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IEffectProcessor next;
        int onProcessFrame;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, gl10) != null) || this.mWaitingDrawFrame) {
            return;
        }
        try {
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            if (this.mGLViewPortLocation == null) {
                setVideoRatio(this.mVideoRatio);
            }
            GLES20.glViewport(0, 0, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
            if (this.mRendererListener != null) {
                this.mRendererListener.onDrawFrame(gl10);
            }
            if (this.mUpdateMatrix != null) {
                int i = this.mUpdateTextureId;
                int i2 = this.mUpdateTextureMode;
                float[] fArr = this.mUpdateMatrix;
                if (this.mOnEditStickerListener != null && !this.mOnEditStickerListener.canDoProcessor()) {
                    if (!wi9.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer : this.mIMediaRenderers) {
                            iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer.setTextureMode(this.mUpdateTextureMode);
                            iMediaRenderer.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer.onDrawFrame(this.mVlogEdit, this.mUpdateTextureId, this.mUpdateMatrix);
                            iMediaRenderer.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    }
                } else if (wi9.e(this.mIEffectProcessors) && wi9.e(this.mIMediaRenderers)) {
                    GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                    if (i2 == 0) {
                        this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreenEXT.drawFrame(i, fArr);
                    } else {
                        this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreen2D.drawFrame(i, fArr);
                    }
                } else {
                    if (this.mIEffectProcessors != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<IEffectProcessor> it = this.mIEffectProcessors.iterator();
                        int i3 = i2;
                        int i4 = i3;
                        loop1: while (true) {
                            int i5 = i;
                            while (it.hasNext()) {
                                next = it.next();
                                next.setInputTextureMode(i4);
                                next.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                                onProcessFrame = next.onProcessFrame(this.mVlogEdit, i5, fArr);
                                if (onProcessFrame <= 0 || onProcessFrame == i5) {
                                }
                            }
                            i3 = next.getOutputTextureMode();
                            i4 = i3;
                            i = onProcessFrame;
                        }
                        debugProcessorCostTime(System.currentTimeMillis() - currentTimeMillis);
                        i2 = i3;
                    }
                    this.mUpdateTextureId = i;
                    this.mUpdateTextureMode = i2;
                    if (!wi9.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer2 : this.mIMediaRenderers) {
                            iMediaRenderer2.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer2.setTextureMode(i2);
                            iMediaRenderer2.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer2.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer2.onDrawFrame(this.mVlogEdit, i, fArr);
                            iMediaRenderer2.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    } else {
                        GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                        GLES20.glBlendFunc(770, 771);
                        if (i2 == 0) {
                            this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreenEXT.drawFrame(i, fArr);
                            this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        } else {
                            this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreen2D.drawFrame(i, fArr);
                            this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                    }
                }
                if (this.mTextureReader != null) {
                    this.mTextureReader.b(i, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
                }
                if (this.mOnDrawFrameFrequencyListener != null) {
                    this.mOnDrawFrameFrequencyListener.onDrawFrameFrequency(this.mGLViewPortLocation);
                    return;
                }
                return;
            }
            throw new RuntimeException("update texture fail");
        } catch (Exception e) {
            ri9.g(e);
            OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
            if (onMediaGLRendererStatusListener != null) {
                onMediaGLRendererStatusListener.onError(1251, "onDrawFrame error:" + ri9.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                GlUtil.mGLErrorMsg = "";
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, gl10, i, i2) == null) {
            try {
                if (this.mSurfaceViewWidth != 0 && this.mSurfaceViewHeight != 0 && this.mSurfaceViewWidth == i && this.mSurfaceViewHeight == i2) {
                    return;
                }
                this.mSurfaceViewWidth = i;
                this.mSurfaceViewHeight = i2;
                setVideoRatio(this.mVideoRatio);
            } catch (Exception e) {
                OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
                if (onMediaGLRendererStatusListener != null) {
                    onMediaGLRendererStatusListener.onError(1251, "onSurfaceChanged error:" + ri9.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                    GlUtil.mGLErrorMsg = "";
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, gl10, eGLConfig) == null) {
            try {
                if (!this.mHasSetPro) {
                    Process.setThreadPriority(-8);
                    this.mHasSetPro = true;
                }
                this.mFullScreenEXT = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.mFullScreen2D = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                if (this.mIEffectProcessors != null) {
                    for (IEffectProcessor iEffectProcessor : this.mIEffectProcessors) {
                        iEffectProcessor.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                    }
                }
                if (this.mIMediaRenderers != null) {
                    for (IMediaRenderer iMediaRenderer : this.mIMediaRenderers) {
                        iMediaRenderer.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                    }
                }
                if (this.mRendererListener != null) {
                    this.mRendererListener.onSurfaceCreated(gl10, eGLConfig);
                }
                if (this.mTextureReader != null) {
                    this.mTextureReader.a(EGL14.eglGetCurrentContext());
                }
            } catch (Exception e) {
                OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
                if (onMediaGLRendererStatusListener != null) {
                    onMediaGLRendererStatusListener.onError(1251, "onSurfaceCreated error:" + ri9.a(e.getMessage()) + GlUtil.mGLErrorMsg);
                    GlUtil.mGLErrorMsg = "";
                }
            }
        }
    }

    public void setGlClearColor(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mRed = f;
            this.mGreen = f2;
            this.mBlue = f3;
            this.mAlpha = f4;
        }
    }

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mScaleX = f;
            this.mScaleY = f2;
            this.mTx = f3;
            this.mTy = f4;
        }
    }

    public void setUpdateTexture(int i, float[] fArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), fArr, Integer.valueOf(i2)}) == null) {
            this.mUpdateTextureId = i;
            this.mUpdateMatrix = fArr;
            this.mUpdateTextureMode = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setVideoRatio(float f) {
        int i;
        int i2;
        GLViewPortLocation gLViewPortLocation;
        List<IMediaRenderer> list;
        List<IEffectProcessor> list2;
        GLSurfaceView.Renderer renderer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f) == null) {
            this.mVideoRatio = f;
            int i3 = this.mSurfaceViewWidth;
            if (i3 != 0 && (i = this.mSurfaceViewHeight) != 0) {
                int i4 = 0;
                if (f != 0.0f) {
                    if ((i * 1.0f) / i3 > f) {
                        int i5 = (int) (i3 * f);
                        int i6 = (i - i5) / 2;
                        i = i5;
                        i2 = i6;
                        gLViewPortLocation = this.mGLViewPortLocation;
                        if (gLViewPortLocation != null) {
                            this.mGLViewPortLocation = new GLViewPortLocation(i4, i2, i3, i);
                        } else {
                            gLViewPortLocation.x = i4;
                            gLViewPortLocation.y = i2;
                            gLViewPortLocation.width = i3;
                            gLViewPortLocation.height = i;
                        }
                        list = this.mIMediaRenderers;
                        if (list != null) {
                            for (IMediaRenderer iMediaRenderer : list) {
                                iMediaRenderer.onSurfaceChanged(null, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
                                iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                            }
                        }
                        list2 = this.mIEffectProcessors;
                        if (list2 != null) {
                            for (IEffectProcessor iEffectProcessor : list2) {
                                iEffectProcessor.setPreviewSize(i3, i);
                            }
                        }
                        renderer = this.mRendererListener;
                        if (renderer == null) {
                            GLViewPortLocation gLViewPortLocation2 = this.mGLViewPortLocation;
                            renderer.onSurfaceChanged(null, gLViewPortLocation2.width, gLViewPortLocation2.height);
                            return;
                        }
                        return;
                    }
                    int i7 = (int) (i / f);
                    i4 = (i3 - i7) / 2;
                    i3 = i7;
                }
                i2 = 0;
                gLViewPortLocation = this.mGLViewPortLocation;
                if (gLViewPortLocation != null) {
                }
                list = this.mIMediaRenderers;
                if (list != null) {
                }
                list2 = this.mIEffectProcessors;
                if (list2 != null) {
                }
                renderer = this.mRendererListener;
                if (renderer == null) {
                }
            }
        }
    }
}
