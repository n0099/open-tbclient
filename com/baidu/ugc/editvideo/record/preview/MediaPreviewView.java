package com.baidu.ugc.editvideo.record.preview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.b.a.e;
import c.a.x0.a;
import c.a.x0.t.h;
import c.a.x0.t.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class MediaPreviewView extends GLSurfaceView implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mBlue;
    public float mGreen;
    public List<IEffectProcessor> mIEffectProcessorList;
    public List<IMediaRenderer> mIMediaRendererList;
    public MediaGLRenderer.OnDrawFrameFrequencyListener mOnDrawFrameListener;
    public OnSurfaceTextureCreateListener mOnSurfaceTextureCreateListener;
    public float mRed;
    public MediaGLRenderer mRenderer;
    public float[] mSTMatrix;
    public float mScaleX;
    public float mScaleY;
    public SurfaceTexture mSurfaceTexture;
    public int mTextureIdEXT;
    public float mTx;
    public float mTy;

    /* loaded from: classes8.dex */
    public interface OnSurfaceTextureCreateListener {
        void onSurfaceTextureCreate(SurfaceTexture surfaceTexture, int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaPreviewView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSTMatrix = new float[16];
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTx = 0.0f;
        this.mTy = 0.0f;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
        this.mRenderer = new MediaGLRenderer();
        setEGLContextFactory(new MyEGLContextFactory(Build.VERSION.SDK_INT >= 23 ? 3 : 2));
        setEGLConfigChooser(new MSAAConfigChooser());
        setRenderer(this.mRenderer);
        setRenderMode(0);
        this.mRenderer.setOnDrawFrameFrequencyListener(this);
        this.mRenderer.setRendererListener(this);
        this.mRenderer.setOnMediaGLRendererStatusListener(new MediaGLRenderer.OnMediaGLRendererStatusListener(this) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaPreviewView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
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

            @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
            public void onError(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    a.a("v_log_preview_render_error", str, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnDestroy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            int b2 = h.b(this.mIEffectProcessorList);
            for (int i2 = 0; i2 < b2; i2++) {
                IEffectProcessor iEffectProcessor = (IEffectProcessor) h.c(this.mIEffectProcessorList, i2);
                if (z) {
                    iEffectProcessor.onDestroyInGlThread();
                } else {
                    iEffectProcessor.onDestroy();
                }
            }
            List<IMediaRenderer> list = this.mIMediaRendererList;
            if (list != null) {
                for (IMediaRenderer iMediaRenderer : list) {
                    if (z) {
                        iMediaRenderer.onDestroyInGlThread();
                    } else {
                        iMediaRenderer.onDestroy();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnPause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            int b2 = h.b(this.mIEffectProcessorList);
            for (int i2 = 0; i2 < b2; i2++) {
                IEffectProcessor iEffectProcessor = (IEffectProcessor) h.c(this.mIEffectProcessorList, i2);
                if (z) {
                    iEffectProcessor.onPauseInGlThread();
                } else {
                    iEffectProcessor.onPause();
                }
            }
            List<IMediaRenderer> list = this.mIMediaRendererList;
            if (list != null) {
                for (IMediaRenderer iMediaRenderer : list) {
                    if (z) {
                        iMediaRenderer.onPauseInGlThread();
                    } else {
                        iMediaRenderer.onPause();
                    }
                }
            }
        }
    }

    private void scissor(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, gLViewPortLocation) == null) {
            if (!(this.mScaleX == 1.0f && this.mScaleY == 1.0f) && gLViewPortLocation.width > v.c()) {
                GLES20.glEnable(3089);
                int i2 = gLViewPortLocation.width;
                int ceil = (int) Math.ceil((((1.0f - this.mScaleX) * i2) / 2.0f) - (((i2 - v.c()) * this.mScaleX) / 2.0f));
                int ceil2 = (int) Math.ceil((1.0f - this.mScaleY) * gLViewPortLocation.height);
                int ceil3 = (int) Math.ceil((gLViewPortLocation.width - v.c()) * this.mScaleX);
                int ceil4 = (int) Math.ceil(gLViewPortLocation.height * this.mScaleY);
                GLES20.glScissor(ceil, ceil2, ceil3, ceil4);
                GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                GLES20.glClear(16640);
                GLES20.glScissor((gLViewPortLocation.width - ceil) - ceil3, ceil2, ceil3, ceil4);
                GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
                GLES20.glClear(16640);
                GLES20.glDisable(3089);
            }
        }
    }

    public PointF getCenterPointOfViewport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f2 = this.mScaleX;
            float width = (((getWidth() * 1.0f) / 2.0f) * f2) + ((((1.0f - f2) * getWidth()) * 1.0f) / 2.0f) + (((getWidth() * this.mTx) * 1.0f) / 2.0f);
            float f3 = this.mScaleY;
            return new PointF(width, ((((getHeight() * 1.0f) / 2.0f) * f3) + ((((1.0f - f3) * getHeight()) * 1.0f) / 2.0f)) - (((getHeight() * this.mTy) * 1.0f) / 2.0f));
        }
        return (PointF) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            notifyOnDestroy(false);
            queueEvent(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaPreviewView this$0;

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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRenderer.onDestroy();
                        if (this.this$0.mSurfaceTexture != null) {
                            this.this$0.mSurfaceTexture.release();
                            this.this$0.mSurfaceTexture = null;
                        }
                        int i2 = this.this$0.mTextureIdEXT;
                        if (i2 != 0) {
                            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                            this.this$0.mTextureIdEXT = 0;
                        }
                        this.this$0.notifyOnDestroy(true);
                    }
                }
            });
        }
    }

    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl10) == null) {
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
            this.mRenderer.setUpdateTexture(this.mTextureIdEXT, this.mSTMatrix, 0);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnDrawFrameFrequencyListener
    public void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gLViewPortLocation) == null) {
            scissor(gLViewPortLocation);
            MediaGLRenderer.OnDrawFrameFrequencyListener onDrawFrameFrequencyListener = this.mOnDrawFrameListener;
            if (onDrawFrameFrequencyListener != null) {
                onDrawFrameFrequencyListener.onDrawFrameFrequency(gLViewPortLocation);
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceTexture) == null) {
            requestRender();
        }
    }

    @Override // android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            notifyOnPause(false);
            queueEvent(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaPreviewView this$0;

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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRenderer.onPause();
                        this.this$0.notifyOnPause(true);
                    }
                }
            });
            super.onPause();
        }
    }

    @Override // android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.mRenderer.onResume();
            int b2 = h.b(this.mIEffectProcessorList);
            for (int i2 = 0; i2 < b2; i2++) {
                ((IEffectProcessor) h.c(this.mIEffectProcessorList, i2)).onResume();
            }
            List<IMediaRenderer> list = this.mIMediaRendererList;
            if (list != null) {
                for (IMediaRenderer iMediaRenderer : list) {
                    iMediaRenderer.onResume();
                }
            }
            requestRender();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, gl10, i2, i3) == null) {
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gl10, eGLConfig) == null) || this.mRenderer.getFullScreenEXT() == null) {
            return;
        }
        this.mTextureIdEXT = this.mRenderer.getFullScreenEXT().createTextureObject();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureIdEXT);
        this.mSurfaceTexture = surfaceTexture;
        setSurfaceTexture(surfaceTexture, this.mTextureIdEXT);
    }

    public void setEffectProcessor(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.mIEffectProcessorList = list;
            this.mRenderer.setEffectProcessor(list);
        }
    }

    public void setGlClearColor(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            queueEvent(new Runnable(this, f2, f3, f4, f5) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaPreviewView this$0;
                public final /* synthetic */ float val$alpha;
                public final /* synthetic */ float val$blue;
                public final /* synthetic */ float val$green;
                public final /* synthetic */ float val$red;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
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
                    this.val$red = f2;
                    this.val$green = f3;
                    this.val$blue = f4;
                    this.val$alpha = f5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRed = this.val$red;
                        this.this$0.mGreen = this.val$green;
                        this.this$0.mBlue = this.val$blue;
                        this.this$0.mAlpha = this.val$alpha;
                        this.this$0.mRenderer.setGlClearColor(this.val$red, this.val$green, this.val$blue, this.val$alpha);
                        this.this$0.requestRender();
                    }
                }
            });
        }
    }

    public void setMediaRenderers(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.mIMediaRendererList = list;
            this.mRenderer.setMediaRenderer(list);
        }
    }

    public void setOnDrawFrameListener(MediaGLRenderer.OnDrawFrameFrequencyListener onDrawFrameFrequencyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onDrawFrameFrequencyListener) == null) {
            this.mOnDrawFrameListener = onDrawFrameFrequencyListener;
        }
    }

    public void setOnSurfaceTextureCreateListener(OnSurfaceTextureCreateListener onSurfaceTextureCreateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSurfaceTextureCreateListener) == null) {
            this.mOnSurfaceTextureCreateListener = onSurfaceTextureCreateListener;
        }
    }

    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            queueEvent(new Runnable(this, f2, f3, f4, f5) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaPreviewView this$0;
                public final /* synthetic */ float val$sh;
                public final /* synthetic */ float val$sw;
                public final /* synthetic */ float val$tx;
                public final /* synthetic */ float val$ty;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
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
                    this.val$sh = f2;
                    this.val$sw = f3;
                    this.val$tx = f4;
                    this.val$ty = f5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MediaPreviewView mediaPreviewView = this.this$0;
                        float f6 = this.val$sh;
                        mediaPreviewView.mScaleX = f6;
                        float f7 = this.val$sw;
                        mediaPreviewView.mScaleY = f7;
                        float f8 = this.val$tx;
                        mediaPreviewView.mTx = f8;
                        float f9 = this.val$ty;
                        mediaPreviewView.mTy = f9;
                        mediaPreviewView.mRenderer.setScaleAndTranslate(f6, f7, f8, f9);
                        this.this$0.requestRender();
                    }
                }
            });
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, surfaceTexture, i2) == null) || surfaceTexture == null) {
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        OnSurfaceTextureCreateListener onSurfaceTextureCreateListener = this.mOnSurfaceTextureCreateListener;
        if (onSurfaceTextureCreateListener != null) {
            onSurfaceTextureCreateListener.onSurfaceTextureCreate(surfaceTexture, i2);
        }
        requestRender();
    }

    public void setVlogCore(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.mRenderer.setCore(eVar);
        }
    }

    public void setWaitingDrawFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            queueEvent(new Runnable(this, z) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaPreviewView this$0;
                public final /* synthetic */ boolean val$waitingDrawFrame;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
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
                    this.val$waitingDrawFrame = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mRenderer.setWaitingDrawFrame(this.val$waitingDrawFrame);
                    }
                }
            });
        }
    }
}
