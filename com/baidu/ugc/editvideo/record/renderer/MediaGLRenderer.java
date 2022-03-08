package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.b.a.e;
import c.a.y0.p.a;
import c.a.y0.r.c;
import c.a.y0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
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
    public a mTextureReader;
    public float mTx;
    public float mTy;
    public float[] mUpdateMatrix;
    public int mUpdateTextureId;
    public int mUpdateTextureMode;
    public float mVideoRatio;
    public e mVlogEdit;
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
        void onError(int i2, String str);
    }

    public MediaGLRenderer() {
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

    private void debugProcessorCostTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, this, j2) == null) {
            this.mProcessorCostTimeList.add(Long.valueOf(j2));
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            a aVar = this.mTextureReader;
            if (aVar != null) {
                aVar.release();
            }
            e eVar = this.mVlogEdit;
            if (eVar != null) {
                eVar.release();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFullScreen2D : (FullFrameRect) invokeV.objValue;
    }

    public FullFrameRect getFullScreenEXT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFullScreenEXT : (FullFrameRect) invokeV.objValue;
    }

    public GLViewPortLocation getGLViewPortLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mGLViewPortLocation : (GLViewPortLocation) invokeV.objValue;
    }

    public double getProcessorCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (h.e(this.mProcessorCostTimeList)) {
                return 0.0d;
            }
            long j2 = 0;
            int size = this.mProcessorCostTimeList.size();
            for (Long l : this.mProcessorCostTimeList) {
                j2 += l.longValue();
            }
            this.mProcessorCostTimeList.clear();
            return j2 / size;
        }
        return invokeV.doubleValue;
    }

    public int getSurfaceViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSurfaceViewHeight : invokeV.intValue;
    }

    public int getSurfaceViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSurfaceViewWidth : invokeV.intValue;
    }

    public e getVlogEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVlogEdit : (e) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map, list) == null) || (eVar = this.mVlogEdit) == null) {
            return;
        }
        eVar.e(list, map);
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            release();
        }
    }

    public void onDrawFrame(int i2, long j2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (eVar = this.mVlogEdit) == null) {
            return;
        }
        eVar.g(i2, j2);
        e eVar2 = this.mVlogEdit;
        GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
        eVar2.b(gLViewPortLocation.width, gLViewPortLocation.height);
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, gl10, i2, i3) == null) {
            try {
                if (this.mSurfaceViewWidth == 0 || this.mSurfaceViewHeight == 0 || this.mSurfaceViewWidth != i2 || this.mSurfaceViewHeight != i3) {
                    this.mSurfaceViewWidth = i2;
                    this.mSurfaceViewHeight = i3;
                    setVideoRatio(this.mVideoRatio);
                }
            } catch (Exception e2) {
                OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
                if (onMediaGLRendererStatusListener != null) {
                    onMediaGLRendererStatusListener.onError(1251, "onSurfaceChanged error:" + c.a(e2.getMessage()) + GlUtil.mGLErrorMsg);
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
            } catch (Exception e2) {
                OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
                if (onMediaGLRendererStatusListener != null) {
                    onMediaGLRendererStatusListener.onError(1251, "onSurfaceCreated error:" + c.a(e2.getMessage()) + GlUtil.mGLErrorMsg);
                    GlUtil.mGLErrorMsg = "";
                }
            }
        }
    }

    public void setCore(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.mVlogEdit = eVar;
        }
    }

    public void setEffectProcessor(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.mIEffectProcessors = list;
        }
    }

    public void setGlClearColor(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mRed = f2;
            this.mGreen = f3;
            this.mBlue = f4;
            this.mAlpha = f5;
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

    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mScaleX = f2;
            this.mScaleY = f3;
            this.mTx = f4;
            this.mTy = f5;
        }
    }

    public void setTextureReader(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aVar) == null) {
            this.mTextureReader = aVar;
        }
    }

    public void setUpdateTexture(int i2, float[] fArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), fArr, Integer.valueOf(i3)}) == null) {
            this.mUpdateTextureId = i2;
            this.mUpdateMatrix = fArr;
            this.mUpdateTextureMode = i3;
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
    public void setVideoRatio(float f2) {
        int i2;
        int i3;
        GLViewPortLocation gLViewPortLocation;
        List<IMediaRenderer> list;
        List<IEffectProcessor> list2;
        GLSurfaceView.Renderer renderer;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeF(1048603, this, f2) != null) {
            return;
        }
        this.mVideoRatio = f2;
        int i4 = this.mSurfaceViewWidth;
        if (i4 == 0 || (i2 = this.mSurfaceViewHeight) == 0) {
            return;
        }
        int i5 = 0;
        if (f2 != 0.0f) {
            if ((i2 * 1.0f) / i4 > f2) {
                int i6 = (int) (i4 * f2);
                int i7 = (i2 - i6) / 2;
                i2 = i6;
                i3 = i7;
                gLViewPortLocation = this.mGLViewPortLocation;
                if (gLViewPortLocation != null) {
                    this.mGLViewPortLocation = new GLViewPortLocation(i5, i3, i4, i2);
                } else {
                    gLViewPortLocation.x = i5;
                    gLViewPortLocation.y = i3;
                    gLViewPortLocation.width = i4;
                    gLViewPortLocation.height = i2;
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
                        iEffectProcessor.setPreviewSize(i4, i2);
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
            int i8 = (int) (i2 / f2);
            i5 = (i4 - i8) / 2;
            i4 = i8;
        }
        i3 = 0;
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

    public void setWaitingDrawFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mWaitingDrawFrame = z;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || (eVar = this.mVlogEdit) == null) {
            return;
        }
        eVar.n(list);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IEffectProcessor next;
        int onProcessFrame;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gl10) == null) || this.mWaitingDrawFrame) {
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
                int i2 = this.mUpdateTextureId;
                int i3 = this.mUpdateTextureMode;
                float[] fArr = this.mUpdateMatrix;
                if (this.mOnEditStickerListener != null && !this.mOnEditStickerListener.canDoProcessor()) {
                    if (!h.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer : this.mIMediaRenderers) {
                            iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer.setTextureMode(this.mUpdateTextureMode);
                            iMediaRenderer.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer.onDrawFrame(this.mVlogEdit, this.mUpdateTextureId, this.mUpdateMatrix);
                            iMediaRenderer.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    }
                } else if (h.e(this.mIEffectProcessors) && h.e(this.mIMediaRenderers)) {
                    GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                    if (i3 == 0) {
                        this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreenEXT.drawFrame(i2, fArr);
                    } else {
                        this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                        this.mFullScreen2D.drawFrame(i2, fArr);
                    }
                } else {
                    if (this.mIEffectProcessors != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<IEffectProcessor> it = this.mIEffectProcessors.iterator();
                        int i4 = i3;
                        int i5 = i4;
                        loop1: while (true) {
                            int i6 = i2;
                            while (it.hasNext()) {
                                next = it.next();
                                next.setInputTextureMode(i5);
                                next.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                                onProcessFrame = next.onProcessFrame(this.mVlogEdit, i6, fArr);
                                if (onProcessFrame <= 0 || onProcessFrame == i6) {
                                }
                            }
                            i4 = next.getOutputTextureMode();
                            i5 = i4;
                            i2 = onProcessFrame;
                        }
                        debugProcessorCostTime(System.currentTimeMillis() - currentTimeMillis);
                        i3 = i4;
                    }
                    this.mUpdateTextureId = i2;
                    this.mUpdateTextureMode = i3;
                    if (!h.e(this.mIMediaRenderers)) {
                        for (IMediaRenderer iMediaRenderer2 : this.mIMediaRenderers) {
                            iMediaRenderer2.onGLLocation(this.mGLViewPortLocation);
                            iMediaRenderer2.setTextureMode(i3);
                            iMediaRenderer2.setGlClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                            iMediaRenderer2.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            iMediaRenderer2.onDrawFrame(this.mVlogEdit, i2, fArr);
                            iMediaRenderer2.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                    } else {
                        GLES20.glViewport(this.mGLViewPortLocation.x, this.mGLViewPortLocation.y, this.mGLViewPortLocation.width, this.mGLViewPortLocation.height);
                        GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                        GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
                        if (i3 == 0) {
                            this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreenEXT.drawFrame(i2, fArr);
                            this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        } else {
                            this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                            this.mFullScreen2D.drawFrame(i2, fArr);
                            this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                        }
                        GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                    }
                }
                if (this.mTextureReader != null) {
                    this.mTextureReader.b(i2, this.mSurfaceViewWidth, this.mSurfaceViewHeight);
                }
                if (this.mOnDrawFrameFrequencyListener != null) {
                    this.mOnDrawFrameFrequencyListener.onDrawFrameFrequency(this.mGLViewPortLocation);
                    return;
                }
                return;
            }
            throw new RuntimeException("update texture fail");
        } catch (Exception e2) {
            c.g(e2);
            OnMediaGLRendererStatusListener onMediaGLRendererStatusListener = this.mOnMediaGLRendererStatusListener;
            if (onMediaGLRendererStatusListener != null) {
                onMediaGLRendererStatusListener.onError(1251, "onDrawFrame error:" + c.a(e2.getMessage()) + GlUtil.mGLErrorMsg);
                GlUtil.mGLErrorMsg = "";
            }
        }
    }
}
