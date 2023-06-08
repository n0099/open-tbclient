package com.baidu.ugc.editvideo.record.preview;

import android.content.Context;
import android.graphics.PointF;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.mh0;
import com.baidu.tieba.nva;
import com.baidu.tieba.qva;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class GLMediaPreviewView extends MediaPreviewView implements EffectChangeObserver, MediaTrackChangeObserver, OnDrawUpdateTextureListener {
    public boolean mAdjustToFill;
    public boolean mCanMeasure;
    public float mDownX;
    public float mDownX1;
    public float mDownY;
    public float mDownY1;
    public float mLastDownX;
    public float mLastDownX1;
    public float mLastDownY;
    public float mLastDownY1;
    public int mSurfaceHeight;
    public int mSurfaceWidth;
    public int mVideoHeight;
    public int mVideoWidth;
    public MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface ScaleType {
        public static final int FILL_PARENT = 0;
        public static final int FIT_PARENT = 1;
    }

    public GLMediaPreviewView(Context context) {
        this(context, null);
    }

    public GLMediaPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdjustToFill = true;
        this.mCanMeasure = true;
        this.mRenderer.setOnEditStickerListener(new MediaGLRenderer.OnEditStickerListener() { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.1
            @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnEditStickerListener
            public boolean canDoProcessor() {
                if (GLMediaPreviewView.this.multiMediaDataSourceViewAdapter != null) {
                    return GLMediaPreviewView.this.multiMediaDataSourceViewAdapter.canDoProcessor();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustSize(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (this.mVideoWidth <= 0 || this.mVideoHeight <= 0) {
            return;
        }
        if (this.mSurfaceWidth <= 0 || this.mSurfaceHeight <= 0) {
            this.mSurfaceWidth = getMeasuredWidth();
            this.mSurfaceHeight = getMeasuredHeight();
        }
        if (this.mSurfaceWidth <= 0 || this.mSurfaceHeight <= 0 || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        if (this.mAdjustToFill) {
            this.mAdjustToFill = getVideoScaleType(this.mVideoWidth, this.mVideoHeight) == 0;
        }
        double d = (this.mVideoHeight * 1.0f) / this.mVideoWidth;
        int i = this.mSurfaceHeight;
        int i2 = this.mSurfaceWidth;
        int i3 = (d > ((i * 1.0f) / i2) ? 1 : (d == ((i * 1.0f) / i2) ? 0 : -1));
        boolean z2 = this.mAdjustToFill;
        if (i3 <= 0 ? !z2 : z2) {
            layoutParams.width = i2;
            layoutParams.height = (int) (i2 * d);
        } else {
            layoutParams.height = i;
            layoutParams.width = (int) (i / d);
        }
        if (z) {
            int i4 = layoutParams.width;
            int i5 = this.mSurfaceWidth;
            if (i4 > i5) {
                layoutParams.width = i5;
            }
            int i6 = layoutParams.height;
            int i7 = this.mSurfaceHeight;
            if (i6 > i7) {
                layoutParams.height = i7;
            }
        }
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                GLMediaPreviewView.this.removeOnLayoutChangeListener(this);
            }
        });
    }

    private float getRealX(float f) {
        float f2 = this.mScaleX;
        return f2 != 0.0f ? ((f - ((((1.0f - f2) * getWidth()) * 1.0f) / 2.0f)) - (((getWidth() * this.mTx) * 1.0f) / 2.0f)) / this.mScaleX : f;
    }

    private float getRealY(float f) {
        float f2 = this.mScaleY;
        return f2 != 0.0f ? ((f - ((((1.0f - f2) * getHeight()) * 1.0f) / 2.0f)) + (((getHeight() * this.mTy) * 1.0f) / 2.0f)) / this.mScaleY : f;
    }

    public static int getVideoScaleType(int i, int i2) {
        double d = (i2 * 1.0f) / i;
        return (d < 1.7647058823529411d || d > 2.162962962962963d) ? 1 : 0;
    }

    private boolean handleTouchEvent() {
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter == null) {
            return false;
        }
        return multiMediaDataSourceViewAdapter.handleTouchEvent();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        return this.mRenderer.getFullScreen2D();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        return this.mRenderer.getFullScreenEXT();
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public mh0 getVlogCore() {
        return this.mRenderer.getVlogEdit();
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        this.mRenderer.onChanged(list);
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter != null) {
            multiMediaDataSourceViewAdapter.onChangeProcessorsAndRenderers(this.mIEffectProcessorList, this.mIMediaRendererList);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        this.mRenderer.onChanged(map, list);
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter != null) {
            multiMediaDataSourceViewAdapter.onChangeProcessorsAndRenderers(this.mIEffectProcessorList, this.mIMediaRendererList);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        super.onDestroy();
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.3
            @Override // java.lang.Runnable
            public void run() {
                if (GLMediaPreviewView.this.multiMediaDataSourceViewAdapter != null) {
                    GLMediaPreviewView.this.multiMediaDataSourceViewAdapter.onDestroy();
                }
            }
        });
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i, long j) {
        this.mRenderer.onDrawFrame(i, j);
        List<IEffectProcessor> list = this.mIEffectProcessorList;
        if (list != null) {
            for (IEffectProcessor iEffectProcessor : list) {
                if (iEffectProcessor instanceof AEffectProcessor) {
                    ((AEffectProcessor) iEffectProcessor).startRecordAnim(i, j);
                }
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter != null) {
            multiMediaDataSourceViewAdapter.onDrawFrame(gl10);
        } else {
            super.onDrawFrame(gl10);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0 && this.mCanMeasure) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (this.mAdjustToFill) {
                this.mAdjustToFill = getVideoScaleType(this.mVideoWidth, this.mVideoHeight) == 0;
            }
            double d = (this.mVideoHeight * 1.0f) / this.mVideoWidth;
            int i3 = (d > ((size2 * 1.0f) / size) ? 1 : (d == ((size2 * 1.0f) / size) ? 0 : -1));
            boolean z = this.mAdjustToFill;
            if (i3 <= 0 ? !z : z) {
                size2 = (int) (this.mSurfaceWidth * d);
            } else {
                size = (int) (this.mSurfaceHeight / d);
            }
            i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        queueEvent(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.2
            @Override // java.lang.Runnable
            public void run() {
                if (GLMediaPreviewView.this.multiMediaDataSourceViewAdapter != null) {
                    GLMediaPreviewView.this.multiMediaDataSourceViewAdapter.onPause();
                }
            }
        });
        super.onPause();
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i, int i2) {
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter != null) {
            multiMediaDataSourceViewAdapter.onSurfaceChanged(gl10, i, i2);
        } else {
            super.onSurfaceChanged(gl10, i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter != null) {
            multiMediaDataSourceViewAdapter.onSurfaceCreated(gl10, eGLConfig);
        } else {
            super.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x017e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float realX = getRealX(motionEvent.getX());
                    float realY = getRealY(motionEvent.getY());
                    if (motionEvent.getPointerCount() == 2) {
                        float realX2 = getRealX(motionEvent.getX(1));
                        float realY2 = getRealY(motionEvent.getY(1));
                        PointF pointF = new PointF(this.mLastDownX, this.mLastDownY);
                        PointF pointF2 = new PointF(this.mLastDownX1, this.mLastDownY1);
                        PointF pointF3 = new PointF(realX, realY);
                        PointF pointF4 = new PointF(realX2, realY2);
                        if (nva.c(pointF, pointF3) + nva.c(pointF2, pointF4) >= 5.0f) {
                            PointF d = nva.d(pointF2, pointF);
                            PointF d2 = nva.d(pointF4, pointF3);
                            float a = nva.a(d, d2);
                            float e = nva.e(d, d2);
                            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
                            if (multiMediaDataSourceViewAdapter != null) {
                                multiMediaDataSourceViewAdapter.onTouchMove(0.0f, 0.0f, e, a);
                            }
                        }
                        this.mLastDownX1 = realX2;
                        this.mLastDownY1 = realY2;
                    } else {
                        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter2 = this.multiMediaDataSourceViewAdapter;
                        PointF stickerCenterPoint = multiMediaDataSourceViewAdapter2 != null ? multiMediaDataSourceViewAdapter2.getStickerCenterPoint() : null;
                        if (stickerCenterPoint != null) {
                            PointF pointF5 = new PointF(this.mLastDownX, this.mLastDownY);
                            PointF pointF6 = new PointF(realX, realY);
                            PointF d3 = nva.d(stickerCenterPoint, pointF5);
                            PointF d4 = nva.d(stickerCenterPoint, pointF6);
                            float a2 = nva.a(d3, d4);
                            float e2 = nva.e(d3, d4);
                            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter3 = this.multiMediaDataSourceViewAdapter;
                            if (multiMediaDataSourceViewAdapter3 != null) {
                                multiMediaDataSourceViewAdapter3.onTouchMove(realX - this.mLastDownX, realY - this.mLastDownY, e2, a2);
                            }
                        } else {
                            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter4 = this.multiMediaDataSourceViewAdapter;
                            if (multiMediaDataSourceViewAdapter4 != null) {
                                multiMediaDataSourceViewAdapter4.onTouchMove(realX - this.mLastDownX, realY - this.mLastDownY, 1.0f, 0.0f);
                            }
                        }
                    }
                    this.mLastDownX = realX;
                    this.mLastDownY = realY;
                    requestRender();
                    if (handleTouchEvent()) {
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6 && motionEvent.getPointerCount() == 2) {
                            int findPointerIndex = 1 - motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                            float realX3 = getRealX(motionEvent.getX(findPointerIndex));
                            float realY3 = getRealY(motionEvent.getY(findPointerIndex));
                            this.mLastDownX = realX3;
                            this.mLastDownY = realY3;
                        }
                        if (handleTouchEvent()) {
                            return super.onTouchEvent(motionEvent);
                        }
                        return true;
                    }
                }
            }
            float realX4 = getRealX(motionEvent.getX());
            float realY4 = getRealY(motionEvent.getY());
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter5 = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter5 != null) {
                multiMediaDataSourceViewAdapter5.onTouchUp(realX4, realY4);
            }
            this.mDownX = 0.0f;
            this.mDownY = 0.0f;
            this.mLastDownX = 0.0f;
            this.mLastDownY = 0.0f;
            this.mDownX1 = 0.0f;
            this.mDownY1 = 0.0f;
            this.mLastDownX1 = 0.0f;
            this.mLastDownY1 = 0.0f;
            requestRender();
            if (handleTouchEvent()) {
            }
        }
        this.mDownX = getRealX(motionEvent.getX());
        float realY5 = getRealY(motionEvent.getY());
        this.mDownY = realY5;
        this.mLastDownX = this.mDownX;
        this.mLastDownY = realY5;
        this.mDownX1 = -2.1474836E9f;
        this.mDownY1 = -2.1474836E9f;
        if (motionEvent.getPointerCount() == 2) {
            this.mDownX1 = getRealX(motionEvent.getX(1));
            float realY6 = getRealY(motionEvent.getY(1));
            this.mDownY1 = realY6;
            this.mLastDownX1 = this.mDownX1;
            this.mLastDownY1 = realY6;
        }
        MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter6 = this.multiMediaDataSourceViewAdapter;
        if (multiMediaDataSourceViewAdapter6 != null) {
            multiMediaDataSourceViewAdapter6.onTouchDown(this.mDownX, this.mDownY, this.mDownX1, this.mDownY1);
        }
        if (handleTouchEvent()) {
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        onVideoSizeChanged(i, i2, false);
    }

    public void onVideoSizeChanged(final int i, final int i2, final boolean z) {
        List<IEffectProcessor> list = this.mIEffectProcessorList;
        if (list != null) {
            for (IEffectProcessor iEffectProcessor : list) {
                iEffectProcessor.setPreviewSize(i, i2);
            }
        }
        qva.a().post(new Runnable() { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.4
            @Override // java.lang.Runnable
            public void run() {
                GLMediaPreviewView.this.mVideoWidth = i;
                GLMediaPreviewView.this.mVideoHeight = i2;
                if (GLMediaPreviewView.this.mVideoWidth == 0 || GLMediaPreviewView.this.mVideoHeight == 0) {
                    return;
                }
                GLMediaPreviewView.this.adjustSize(z);
                GLMediaPreviewView.this.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAdjustToFill(boolean z) {
        this.mAdjustToFill = z;
    }

    public void setCanMeasure(boolean z) {
        this.mCanMeasure = z;
    }

    public void setMultiMediaDataSourceViewAdapter(MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter) {
        setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
    }

    public void setMultiMediaDataSourceViewAdapter(MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter, boolean z) {
        if (multiMediaDataSourceViewAdapter == null) {
            return;
        }
        this.multiMediaDataSourceViewAdapter = multiMediaDataSourceViewAdapter;
        multiMediaDataSourceViewAdapter.setOnDrawUpdateTextureListener(this);
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            multiMediaDataSourceViewAdapter.buildProcessorsAndRenderers(arrayList, arrayList2, true);
            setEffectProcessor(arrayList);
            setMediaRenderers(arrayList2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setUpdateTexture(int i, float[] fArr, int i2) {
        this.mRenderer.setUpdateTexture(i, fArr, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f) {
        this.mRenderer.setVideoRatio(f);
    }
}
