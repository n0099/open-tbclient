package com.baidu.tieba;

import android.opengl.GLES20;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class se0 extends re0 implements te0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String k = "se0";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public xe0 d;
    public we0 e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948148395, "Lcom/baidu/tieba/se0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948148395, "Lcom/baidu/tieba/se0;");
        }
    }

    public se0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        this.c = "#extension GL_OES_EGL_image_external : require\nprecision mediump float; // 指定默认精度\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
        new LinkedList();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GLES20.glUseProgram(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            GLES20.glDeleteProgram(this.a);
            this.a = -1;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            GLES20.glDisableVertexAttribArray(this.f);
            GLES20.glDisableVertexAttribArray(this.i);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GLES20.glUseProgram(this.a);
        }
    }

    @Override // com.baidu.tieba.te0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            i();
        }
    }

    @Override // com.baidu.tieba.te0
    public void a(ue0 ue0Var, ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ue0Var, ze0Var) == null) {
            xe0 xe0Var = this.d;
            if (xe0Var != null && xe0Var.e()) {
                l();
                d(this.d);
                c(ue0Var, ze0Var);
                g(ue0Var, ze0Var);
                j();
                k(this.d);
                f();
                return;
            }
            Log.e(k, "onDraw filter has not been setup!!!");
        }
    }

    public void g(ue0 ue0Var, ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, ue0Var, ze0Var) == null) {
            if (ze0Var.e()) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
            }
            if (ze0Var.d()) {
                GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
                GLES20.glBlendFunc(770, 771);
            }
            GLES20.glDrawArrays(5, 0, ue0Var.e());
            if (ze0Var.d()) {
                GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            }
        }
    }

    @Override // com.baidu.tieba.te0
    public void b(xe0 xe0Var, we0 we0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xe0Var, we0Var) == null) {
            this.d = xe0Var;
            this.e = we0Var;
            e(this.b, this.c);
            if (this.a != -1) {
                h();
                return;
            }
            throw new RuntimeException("Unable to create program");
        }
    }

    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            if (this.d.getType() != 36197) {
                str2 = str2.replaceFirst("#extension GL_OES_EGL_image_external : require", "").replace("samplerExternalOES", "sampler2D");
            }
            this.a = bf0.c(str, str2);
        }
    }

    public void c(ue0 ue0Var, ze0 ze0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ue0Var, ze0Var) == null) {
            GLES20.glUniformMatrix4fv(this.g, 1, false, ze0Var.b(), 0);
            GLES20.glUniformMatrix4fv(this.h, 1, false, ze0Var.c(), 0);
            GLES20.glEnableVertexAttribArray(this.f);
            GLES20.glVertexAttribPointer(this.f, ue0Var.a(), 5126, false, ue0Var.f(), (Buffer) ue0Var.d());
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glVertexAttribPointer(this.i, ue0Var.a(), 5126, false, ue0Var.c(), (Buffer) ue0Var.b());
        }
    }

    public void d(xe0 xe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xe0Var) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(xe0Var.getType(), xe0Var.c());
            GLES20.glUniform1i(this.j, 0);
        }
    }

    public void k(xe0 xe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xe0Var) == null) {
            GLES20.glBindTexture(xe0Var.getType(), 0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j = GLES20.glGetUniformLocation(this.a, "uTexture");
            this.f = GLES20.glGetAttribLocation(this.a, "aPosition");
            this.g = GLES20.glGetUniformLocation(this.a, "uMVPMatrix");
            this.h = GLES20.glGetUniformLocation(this.a, "uTexMatrix");
            this.i = GLES20.glGetAttribLocation(this.a, "aTextureCoord");
        }
    }
}
