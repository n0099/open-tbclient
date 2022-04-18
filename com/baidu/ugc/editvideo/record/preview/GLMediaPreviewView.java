package com.baidu.ugc.editvideo.record.preview;

import android.content.Context;
import android.graphics.PointF;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import com.repackage.pc9;
import com.repackage.pf0;
import com.repackage.sc9;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes4.dex */
public class GLMediaPreviewView extends MediaPreviewView implements EffectChangeObserver, MediaTrackChangeObserver, OnDrawUpdateTextureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    /* loaded from: classes4.dex */
    public @interface ScaleType {
        public static final int FILL_PARENT = 0;
        public static final int FIT_PARENT = 1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GLMediaPreviewView(Context context) {
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
    public GLMediaPreviewView(Context context, AttributeSet attributeSet) {
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
        this.mAdjustToFill = true;
        this.mCanMeasure = true;
        this.mRenderer.setOnEditStickerListener(new MediaGLRenderer.OnEditStickerListener(this) { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GLMediaPreviewView this$0;

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

            @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnEditStickerListener
            public boolean canDoProcessor() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (this.this$0.multiMediaDataSourceViewAdapter != null) {
                        return this.this$0.multiMediaDataSourceViewAdapter.canDoProcessor();
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustSize(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, this, z) == null) || this.mVideoWidth <= 0 || this.mVideoHeight <= 0) {
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
        addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GLMediaPreviewView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i8 = newInitContext.flag;
                    if ((i8 & 1) != 0) {
                        int i9 = i8 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)}) == null) {
                    this.this$0.removeOnLayoutChangeListener(this);
                }
            }
        });
    }

    private float getRealX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, this, f)) == null) {
            float f2 = this.mScaleX;
            return f2 != 0.0f ? ((f - ((((1.0f - f2) * getWidth()) * 1.0f) / 2.0f)) - (((getWidth() * this.mTx) * 1.0f) / 2.0f)) / this.mScaleX : f;
        }
        return invokeF.floatValue;
    }

    private float getRealY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65546, this, f)) == null) {
            float f2 = this.mScaleY;
            return f2 != 0.0f ? ((f - ((((1.0f - f2) * getHeight()) * 1.0f) / 2.0f)) + (((getHeight() * this.mTy) * 1.0f) / 2.0f)) / this.mScaleY : f;
        }
        return invokeF.floatValue;
    }

    public static int getVideoScaleType(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i, i2)) == null) {
            double d = (i2 * 1.0f) / i;
            return (d < 1.7647058823529411d || d > 2.162962962962963d) ? 1 : 0;
        }
        return invokeII.intValue;
    }

    private boolean handleTouchEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter == null) {
                return false;
            }
            return multiMediaDataSourceViewAdapter.handleTouchEvent();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRect2D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRenderer.getFullScreen2D() : (FullFrameRect) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public FullFrameRect getFullFrameRectEXT() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRenderer.getFullScreenEXT() : (FullFrameRect) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public pf0 getVlogCore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRenderer.getVlogEdit() : (pf0) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver
    public void onChanged(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mRenderer.onChanged(list);
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onChangeProcessorsAndRenderers(this.mIEffectProcessorList, this.mIMediaRendererList);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver
    public void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, map, list) == null) {
            this.mRenderer.onChanged(map, list);
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onChangeProcessorsAndRenderers(this.mIEffectProcessorList, this.mIMediaRendererList);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
            queueEvent(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GLMediaPreviewView this$0;

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
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.multiMediaDataSourceViewAdapter == null) {
                        return;
                    }
                    this.this$0.multiMediaDataSourceViewAdapter.onDestroy();
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onDrawFrame(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gl10) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onDrawFrame(gl10);
            } else {
                super.onDrawFrame(gl10);
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
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
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            queueEvent(new Runnable(this) { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GLMediaPreviewView this$0;

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
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.multiMediaDataSourceViewAdapter == null) {
                        return;
                    }
                    this.this$0.multiMediaDataSourceViewAdapter.onPause();
                }
            });
            super.onPause();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void onSizeChange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, gl10, i, i2) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onSurfaceChanged(gl10, i, i2);
            } else {
                super.onSurfaceChanged(gl10, i, i2);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.preview.MediaPreviewView, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, gl10, eGLConfig) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.multiMediaDataSourceViewAdapter;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onSurfaceCreated(gl10, eGLConfig);
            } else {
                super.onSurfaceCreated(gl10, eGLConfig);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0183  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048592, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
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
                        if (pc9.c(pointF, pointF3) + pc9.c(pointF2, pointF4) >= 5.0f) {
                            PointF d = pc9.d(pointF2, pointF);
                            PointF d2 = pc9.d(pointF4, pointF3);
                            float a = pc9.a(d, d2);
                            float e = pc9.e(d, d2);
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
                            PointF d3 = pc9.d(stickerCenterPoint, pointF5);
                            PointF d4 = pc9.d(stickerCenterPoint, pointF6);
                            float a2 = pc9.a(d3, d4);
                            float e2 = pc9.e(d3, d4);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            onVideoSizeChanged(i, i2, false);
        }
    }

    public void onVideoSizeChanged(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            List<IEffectProcessor> list = this.mIEffectProcessorList;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.setPreviewSize(i, i2);
                }
            }
            sc9.a().post(new Runnable(this, i, i2, z) { // from class: com.baidu.ugc.editvideo.record.preview.GLMediaPreviewView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GLMediaPreviewView this$0;
                public final /* synthetic */ int val$height;
                public final /* synthetic */ boolean val$isClipByPreDraw;
                public final /* synthetic */ int val$width;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
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
                    this.val$width = i;
                    this.val$height = i2;
                    this.val$isClipByPreDraw = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mVideoWidth = this.val$width;
                        this.this$0.mVideoHeight = this.val$height;
                        if (this.this$0.mVideoWidth == 0 || this.this$0.mVideoHeight == 0) {
                            return;
                        }
                        this.this$0.adjustSize(this.val$isClipByPreDraw);
                        this.this$0.requestLayout();
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.performClick() : invokeV.booleanValue;
    }

    public void setAdjustToFill(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mAdjustToFill = z;
        }
    }

    public void setCanMeasure(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mCanMeasure = z;
        }
    }

    public void setMultiMediaDataSourceViewAdapter(MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, multiMediaDataSourceViewAdapter) == null) {
            setMultiMediaDataSourceViewAdapter(multiMediaDataSourceViewAdapter, false);
        }
    }

    public void setMultiMediaDataSourceViewAdapter(MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, multiMediaDataSourceViewAdapter, z) == null) || multiMediaDataSourceViewAdapter == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), fArr, Integer.valueOf(i2)}) == null) {
            this.mRenderer.setUpdateTexture(i, fArr, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener
    public void setVideoRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.mRenderer.setVideoRatio(f);
        }
    }
}
