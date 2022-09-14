package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.gg9;
import com.baidu.tieba.rf0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.glrender.MultiMediaPreGlRenderer;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class MultiMediaOutputSurface extends BaseOutputSurface implements OnDrawUpdateTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMultiMediaDataSource mDataSource;
    public List<IEffectProcessor> mEffectProcessors;
    public FullFrameRect mFullScreen2D;
    public GLViewPortLocation mGLViewPortLocation;
    public MultiMediaPreGlRenderer mInnerRenderer;
    public List<IMediaRenderer> mMediaRenderers;
    public rf0 mVlogEdit;

    public MultiMediaOutputSurface(IMultiMediaDataSource iMultiMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMultiMediaDataSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataSource = iMultiMediaDataSource;
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = new MultiMediaPreGlRenderer();
        this.mInnerRenderer = multiMediaPreGlRenderer;
        multiMediaPreGlRenderer.setMultiMediaDataSource(iMultiMediaDataSource);
        this.mInnerRenderer.setOnDrawUpdateTextureListener(this);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            onDrawFrame(this.mDataSource.getCurrentIndex(), this.mDataSource.getCurrentPlayTime());
            this.mInnerRenderer.onPreProcess();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFullScreen2D : (FullFrameRect) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFullScreenEXT : (FullFrameRect) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public rf0 getVlogCore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVlogEdit : (rf0) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void init(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.mVideoWidth = i;
            this.mVideoHeight = i2;
            setup();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, map, list) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            rf0 rf0Var = this.mVlogEdit;
            if (rf0Var != null) {
                rf0Var.g(i, j);
                this.mVlogEdit.b(this.mVideoWidth, this.mVideoHeight);
            }
            List<IEffectProcessor> list = this.mEffectProcessors;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    if (iEffectProcessor instanceof AEffectProcessor) {
                        ((AEffectProcessor) iEffectProcessor).startRecordAnim(i, j);
                        return;
                    }
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            List<IEffectProcessor> list = this.mEffectProcessors;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onDestroy();
                    iEffectProcessor.onDestroyInGlThread();
                }
            }
            List<IMediaRenderer> list2 = this.mMediaRenderers;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onDestroy();
                    iMediaRenderer.onDestroyInGlThread();
                }
            }
            this.mInnerRenderer.releaseProgram();
            FullFrameRect fullFrameRect = this.mFullScreen2D;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
                this.mFullScreen2D = null;
            }
        }
    }

    public void setEffectProcessors(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.mEffectProcessors = list;
        }
    }

    public void setMediaRenderers(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.mMediaRenderers = list;
        }
    }

    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.mInnerRenderer.setPreviewSize(i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setUpdateTexture(int i, float[] fArr, int i2) {
        IEffectProcessor next;
        int onProcessFrame;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), fArr, Integer.valueOf(i2)}) == null) {
            GLES20.glViewport(0, 0, this.mVideoWidth, this.mVideoHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            List<IEffectProcessor> list = this.mEffectProcessors;
            if (list != null) {
                Iterator<IEffectProcessor> it = list.iterator();
                int i3 = i2;
                int i4 = i3;
                loop0: while (true) {
                    int i5 = i;
                    while (it.hasNext()) {
                        next = it.next();
                        next.setInputTextureMode(i3);
                        onProcessFrame = next.onProcessFrame(this.mVlogEdit, i5, fArr);
                        if (onProcessFrame <= 0 || onProcessFrame == i5) {
                        }
                    }
                    i3 = next.getOutputTextureMode();
                    i4 = i3;
                    i = onProcessFrame;
                }
                i2 = i4;
            }
            if (this.mVlogEdit == null || gg9.e(this.mMediaRenderers)) {
                this.mFullScreen2D.drawFrame(i, fArr);
                return;
            }
            if (this.mGLViewPortLocation == null) {
                this.mGLViewPortLocation = new GLViewPortLocation(0, 0, this.mVideoWidth, this.mVideoHeight);
                for (IMediaRenderer iMediaRenderer : this.mMediaRenderers) {
                    iMediaRenderer.onGLLocation(this.mGLViewPortLocation);
                }
            }
            for (IMediaRenderer iMediaRenderer2 : this.mMediaRenderers) {
                iMediaRenderer2.setTextureMode(i2);
                iMediaRenderer2.onDrawFrame(this.mVlogEdit, i, fArr);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVlogCore(rf0 rf0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rf0Var) == null) {
            this.mVlogEdit = rf0Var;
            this.mInnerRenderer.setCompat(rf0Var != null);
        }
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void setup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mFullScreenEXT = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mFullScreen2D = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            List<IEffectProcessor> list = this.mEffectProcessors;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.setPreviewSize(this.mVideoWidth, this.mVideoHeight);
                    iEffectProcessor.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                }
            }
            List<IMediaRenderer> list2 = this.mMediaRenderers;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onSurfaceChanged(null, this.mVideoWidth, this.mVideoHeight);
                    iMediaRenderer.onSurfaceCreate(this.mFullScreenEXT, this.mFullScreen2D);
                }
            }
            this.mInnerRenderer.releaseProgram();
            this.mInnerRenderer.initProgram();
            this.mInnerRenderer.onSizeChange(this.mVideoWidth, this.mVideoHeight);
        }
    }
}
