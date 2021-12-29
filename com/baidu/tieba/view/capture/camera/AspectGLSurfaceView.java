package com.baidu.tieba.view.capture.camera;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes12.dex */
public class AspectGLSurfaceView extends GLSurfaceView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_CORP_CENTER = 1;
    public static final int TYPE_INSIDE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public double f51236e;

    /* renamed from: f  reason: collision with root package name */
    public int f51237f;

    /* renamed from: g  reason: collision with root package name */
    public GLSurfaceView.Renderer f51238g;

    /* renamed from: h  reason: collision with root package name */
    public GLSurfaceView.Renderer f51239h;

    /* loaded from: classes12.dex */
    public class a implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AspectGLSurfaceView f51240e;

        public a(AspectGLSurfaceView aspectGLSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aspectGLSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51240e = aspectGLSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                if (this.f51240e.f51239h != null) {
                    this.f51240e.f51239h.onDrawFrame(gl10);
                } else {
                    gl10.glClear(16640);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i2, i3) == null) {
                if (this.f51240e.f51239h != null) {
                    this.f51240e.f51239h.onSurfaceChanged(gl10, i2, i3);
                } else {
                    gl10.glViewport(0, 0, i2, i3);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gl10, eGLConfig) == null) {
                if (this.f51240e.f51239h != null) {
                    this.f51240e.f51239h.onSurfaceCreated(gl10, eGLConfig);
                } else {
                    gl10.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AspectGLSurfaceView(@NonNull Context context) {
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

    public void initDefault(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.f51238g = new a(this);
            setEGLContextClientVersion(i2);
            super.setRenderer(this.f51238g);
            setRenderMode(i3);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f51236e > 0.0d) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i4 = size - paddingLeft;
                int i5 = size2 - paddingTop;
                double d2 = i4;
                double d3 = i5;
                double d4 = this.f51236e;
                if (d4 <= d2 / d3 ? this.f51237f != 1 : this.f51237f == 1) {
                    i4 = (int) (d3 * d4);
                } else {
                    i5 = (int) (d2 / d4);
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i4 + paddingLeft, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(i5 + paddingTop, 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setAspectRatio(double d2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2), Integer.valueOf(i2)}) == null) {
            this.f51237f = i2;
            if (this.f51236e != d2) {
                this.f51236e = d2;
                requestLayout();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, renderer) == null) {
            if (this.f51238g == null) {
                super.setRenderer(renderer);
            } else {
                this.f51239h = renderer;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            try {
                super.surfaceDestroyed(surfaceHolder);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectGLSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f51236e = -1.0d;
        this.f51237f = 1;
    }
}
