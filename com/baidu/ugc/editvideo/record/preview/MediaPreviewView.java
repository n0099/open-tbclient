package com.baidu.ugc.editvideo.record.preview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bi9;
import com.baidu.tieba.fg0;
import com.baidu.tieba.kd9;
import com.baidu.tieba.nh9;
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
/* loaded from: classes6.dex */
public class MediaPreviewView extends GLSurfaceView implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mBlue;
    public float mGreen;
    public List mIEffectProcessorList;
    public List mIMediaRendererList;
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

    /* loaded from: classes6.dex */
    public interface OnSurfaceTextureCreateListener {
        void onSurfaceTextureCreate(SurfaceTexture surfaceTexture, int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
            public void onError(int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                    kd9.a("v_log_preview_render_error", str, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnDestroy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            int b = nh9.b(this.mIEffectProcessorList);
            for (int i = 0; i < b; i++) {
                IEffectProcessor iEffectProcessor = (IEffectProcessor) nh9.c(this.mIEffectProcessorList, i);
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
            int b = nh9.b(this.mIEffectProcessorList);
            for (int i = 0; i < b; i++) {
                IEffectProcessor iEffectProcessor = (IEffectProcessor) nh9.c(this.mIEffectProcessorList, i);
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
            if (!(this.mScaleX == 1.0f && this.mScaleY == 1.0f) && gLViewPortLocation.width > bi9.c()) {
                GLES20.glEnable(3089);
                int i = gLViewPortLocation.width;
                int ceil = (int) Math.ceil((((1.0f - this.mScaleX) * i) / 2.0f) - (((i - bi9.c()) * this.mScaleX) / 2.0f));
                int ceil2 = (int) Math.ceil((1.0f - this.mScaleY) * gLViewPortLocation.height);
                int ceil3 = (int) Math.ceil((gLViewPortLocation.width - bi9.c()) * this.mScaleX);
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
            float f = this.mScaleX;
            float width = (((getWidth() * 1.0f) / 2.0f) * f) + ((((1.0f - f) * getWidth()) * 1.0f) / 2.0f) + (((getWidth() * this.mTx) * 1.0f) / 2.0f);
            float f2 = this.mScaleY;
            return new PointF(width, ((((getHeight() * 1.0f) / 2.0f) * f2) + ((((1.0f - f2) * getHeight()) * 1.0f) / 2.0f)) - (((getHeight() * this.mTy) * 1.0f) / 2.0f));
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        int i = this.this$0.mTextureIdEXT;
                        if (i != 0) {
                            GLES20.glDeleteTextures(1, new int[]{i}, 0);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
            int b = nh9.b(this.mIEffectProcessorList);
            for (int i = 0; i < b; i++) {
                ((IEffectProcessor) nh9.c(this.mIEffectProcessorList, i)).onResume();
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

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, gl10, i, i2) == null) {
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

    public void setEffectProcessor(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.mIEffectProcessorList = list;
            this.mRenderer.setEffectProcessor(list);
        }
    }

    public void setGlClearColor(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            queueEvent(new Runnable(this, f, f2, f3, f4) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.4
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
                        Object[] objArr = {this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$red = f;
                    this.val$green = f2;
                    this.val$blue = f3;
                    this.val$alpha = f4;
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

    public void setMediaRenderers(List list) {
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

    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            queueEvent(new Runnable(this, f, f2, f3, f4) { // from class: com.baidu.ugc.editvideo.record.preview.MediaPreviewView.3
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
                        Object[] objArr = {this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sh = f;
                    this.val$sw = f2;
                    this.val$tx = f3;
                    this.val$ty = f4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MediaPreviewView mediaPreviewView = this.this$0;
                        float f5 = this.val$sh;
                        mediaPreviewView.mScaleX = f5;
                        float f6 = this.val$sw;
                        mediaPreviewView.mScaleY = f6;
                        float f7 = this.val$tx;
                        mediaPreviewView.mTx = f7;
                        float f8 = this.val$ty;
                        mediaPreviewView.mTy = f8;
                        mediaPreviewView.mRenderer.setScaleAndTranslate(f5, f6, f7, f8);
                        this.this$0.requestRender();
                    }
                }
            });
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, surfaceTexture, i) == null) || surfaceTexture == null) {
            return;
        }
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        OnSurfaceTextureCreateListener onSurfaceTextureCreateListener = this.mOnSurfaceTextureCreateListener;
        if (onSurfaceTextureCreateListener != null) {
            onSurfaceTextureCreateListener.onSurfaceTextureCreate(surfaceTexture, i);
        }
        requestRender();
    }

    public void setVlogCore(fg0 fg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fg0Var) == null) {
            this.mRenderer.setCore(fg0Var);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
