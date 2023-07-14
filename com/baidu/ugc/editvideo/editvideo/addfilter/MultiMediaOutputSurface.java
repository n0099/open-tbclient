package com.baidu.ugc.editvideo.editvideo.addfilter;

import android.opengl.GLES20;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.kab;
import com.baidu.tieba.rh0;
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
/* loaded from: classes9.dex */
public class MultiMediaOutputSurface extends BaseOutputSurface implements OnDrawUpdateTextureListener {
    public IMultiMediaDataSource mDataSource;
    public List<IEffectProcessor> mEffectProcessors;
    public FullFrameRect mFullScreen2D;
    public GLViewPortLocation mGLViewPortLocation;
    public MultiMediaPreGlRenderer mInnerRenderer;
    public List<IMediaRenderer> mMediaRenderers;
    public rh0 mVlogEdit;

    public MultiMediaOutputSurface(IMultiMediaDataSource iMultiMediaDataSource) {
        this.mDataSource = iMultiMediaDataSource;
        MultiMediaPreGlRenderer multiMediaPreGlRenderer = new MultiMediaPreGlRenderer();
        this.mInnerRenderer = multiMediaPreGlRenderer;
        multiMediaPreGlRenderer.setMultiMediaDataSource(iMultiMediaDataSource);
        this.mInnerRenderer.setOnDrawUpdateTextureListener(this);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void drawImage(int i) {
        onDrawFrame(this.mDataSource.getCurrentIndex(), this.mDataSource.getCurrentPlayTime());
        this.mInnerRenderer.onPreProcess();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        return this.mFullScreen2D;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        return this.mFullScreenEXT;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public rh0 getVlogCore() {
        return this.mVlogEdit;
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void init(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        setup();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i, long j) {
        rh0 rh0Var = this.mVlogEdit;
        if (rh0Var != null) {
            rh0Var.h(i, j);
            this.mVlogEdit.c(this.mVideoWidth, this.mVideoHeight);
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

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i, int i2) {
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void release() {
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

    public void setEffectProcessors(List<IEffectProcessor> list) {
        this.mEffectProcessors = list;
    }

    public void setMediaRenderers(List<IMediaRenderer> list) {
        this.mMediaRenderers = list;
    }

    public void setPreviewSize(int i, int i2) {
        this.mInnerRenderer.setPreviewSize(i, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setUpdateTexture(int i, float[] fArr, int i2) {
        IEffectProcessor next;
        int onProcessFrame;
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
        if (this.mVlogEdit == null || kab.e(this.mMediaRenderers)) {
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

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f) {
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVlogCore(rh0 rh0Var) {
        this.mVlogEdit = rh0Var;
        this.mInnerRenderer.setCompat(rh0Var != null);
    }

    @Override // com.baidu.ugc.editvideo.editvideo.addfilter.BaseOutputSurface
    public void setup() {
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
