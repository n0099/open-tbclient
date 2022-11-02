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
/* loaded from: classes6.dex */
public class AspectGLSurfaceView extends GLSurfaceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;
    public int b;
    public GLSurfaceView.Renderer c;
    public GLSurfaceView.Renderer d;

    /* loaded from: classes6.dex */
    public class a implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AspectGLSurfaceView a;

        public a(AspectGLSurfaceView aspectGLSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aspectGLSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aspectGLSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                if (this.a.d == null) {
                    gl10.glClear(16640);
                } else {
                    this.a.d.onDrawFrame(gl10);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i, i2) == null) {
                if (this.a.d == null) {
                    gl10.glViewport(0, 0, i, i2);
                } else {
                    this.a.d.onSurfaceChanged(gl10, i, i2);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gl10, eGLConfig) == null) {
                if (this.a.d == null) {
                    gl10.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
                } else {
                    this.a.d.onSurfaceCreated(gl10, eGLConfig);
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
    public AspectGLSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = -1.0d;
        this.b = 1;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.a > 0.0d) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                int paddingLeft = getPaddingLeft() + getPaddingRight();
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int i3 = size - paddingLeft;
                int i4 = size2 - paddingTop;
                double d = i3;
                double d2 = i4;
                double d3 = this.a;
                if (d3 <= d / d2 ? this.b == 1 : this.b != 1) {
                    i4 = (int) (d / d3);
                } else {
                    i3 = (int) (d2 * d3);
                }
                i = View.MeasureSpec.makeMeasureSpec(i3 + paddingLeft, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(i4 + paddingTop, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, renderer) == null) {
            if (this.c == null) {
                super.setRenderer(renderer);
            } else {
                this.d = renderer;
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

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.c = new a(this);
            setEGLContextClientVersion(i);
            super.setRenderer(this.c);
            setRenderMode(i2);
        }
    }

    public void setAspectRatio(double d, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), Integer.valueOf(i)}) == null) {
            this.b = i;
            if (this.a != d) {
                this.a = d;
                requestLayout();
            }
        }
    }
}
