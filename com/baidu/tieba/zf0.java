package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class zf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<Runnable> a;
    public final String b;
    public final String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public final SparseArray<String> m;
    public final SparseArray<ShaderParams> n;
    public long o;
    public long p;
    public long q;
    public String r;
    public String s;
    public List<MediaOneAEffect> t;
    public long u;
    public long v;
    public List<ShaderParams> w;
    public long x;
    public float[] y;
    public float[] z;

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public a(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniformMatrix4fv(this.a, 1, false, this.b, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf0 a;

        public b(zf0 zf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
                GLES20.glUniform1f(this.a.h, 1.0f);
                this.a.w();
                this.a.z();
                this.a.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float b;
        public final /* synthetic */ zf0 c;

        public c(zf0 zf0Var, int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniform1f(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public d(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public e(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniform3fv(this.a, 1, FloatBuffer.wrap(this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public f(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniform4fv(this.a, 1, FloatBuffer.wrap(this.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public g(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                int i = this.a;
                float[] fArr = this.b;
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ float[] b;
        public final /* synthetic */ zf0 c;

        public h(zf0 zf0Var, int i, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf0Var, Integer.valueOf(i), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zf0Var;
            this.a = i;
            this.b = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g();
                GLES20.glUniformMatrix3fv(this.a, 1, false, this.b, 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zf0() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int e2 = fg0.e(this.b, this.c);
            this.d = e2;
            this.e = GLES20.glGetAttribLocation(e2, CriusAttrConstants.POSITION);
            this.f = GLES20.glGetUniformLocation(this.d, "inputImageTexture");
            this.g = GLES20.glGetAttribLocation(this.d, "inputTextureCoordinate");
            this.h = GLES20.glGetUniformLocation(this.d, Key.ALPHA);
            this.k = true;
        }
    }

    public final void y() {
        ShaderParams shaderParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.m.size() != 0) {
            for (int i = 0; i < this.m.size(); i++) {
                int keyAt = this.m.keyAt(i);
                if (this.n.size() > 0 && (shaderParams = this.n.get(keyAt)) != null) {
                    T(keyAt, shaderParams);
                }
            }
        }
    }

    public zf0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3553;
        this.a = new LinkedList<>();
        this.m = new SparseArray<>();
        this.n = new SparseArray<>();
        this.b = str;
        this.c = str2;
        if (!TextUtils.isEmpty(str2) && str2.contains("samplerExternalOES") && !str2.contains("sampler2D")) {
            this.l = 36197;
        }
    }

    public final void N(float[] fArr, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, fArr, f2) == null) {
            float[] fArr2 = new float[16];
            int i = this.i;
            int i2 = this.j;
            if (i > i2) {
                float f3 = i / i2;
                Matrix.orthoM(fArr2, 0, -f3, f3, -1.0f, 1.0f, -1.0f, 1.0f);
                Matrix.scaleM(fArr, 0, f3, 1.0f, 1.0f);
            } else {
                float f4 = i2 / i;
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -f4, f4, -1.0f, 1.0f);
                Matrix.scaleM(fArr, 0, 1.0f, f4, 1.0f);
            }
            float[] fArr3 = new float[16];
            Matrix.multiplyMM(fArr3, 0, fArr2, 0, fArr, 0);
            S(i(), fArr3, false);
            if (f2 != 1.0f) {
                GLES20.glUniform1f(this.h, f2);
            }
        }
    }

    public void B(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            synchronized (this.a) {
                this.a.addLast(runnable);
            }
        }
    }

    public void D(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            G(this.h, f2, true);
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.x = j;
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(str));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        bufferedReader.close();
                        fileInputStream.close();
                        return sb.toString();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String n(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public final boolean f(MediaOneAEffect mediaOneAEffect, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, mediaOneAEffect, j)) == null) {
            if (TextUtils.equals(this.r, "end")) {
                if (this.q - mediaOneAEffect.end <= j) {
                    return true;
                }
                return false;
            }
            long j2 = mediaOneAEffect.start;
            long j3 = this.p;
            if (j2 + j3 <= j && mediaOneAEffect.end + j3 >= j) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final float A(ShaderParams shaderParams, float f2) {
        InterceptResult invokeLF;
        double cos;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, shaderParams, f2)) == null) {
            if (shaderParams.interpolator == null) {
                shaderParams.interpolator = "";
            }
            String str = shaderParams.interpolator;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1383205240:
                    if (str.equals("bounce")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1354466595:
                    if (str.equals(Easing.ACCELERATE_NAME)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1263948740:
                    if (str.equals(Easing.DECELERATE_NAME)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -749065269:
                    if (str.equals("overshoot")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 95131878:
                    if (str.equals("cycle")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 475910905:
                    if (str.equals("accelerateDecelerate")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1088816001:
                    if (str.equals("anticipateOvershoot")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return Math.abs(f2 * f2);
                case 1:
                    float f5 = 1.0f - f2;
                    return 1.0f - (f5 * f5);
                case 2:
                    cos = (Math.cos((f2 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                    break;
                case 3:
                    float f6 = f2 - 1.0f;
                    return (f6 * f6 * ((f6 * 3.0f) + 2.0f)) + 1.0f;
                case 4:
                    cos = Math.sin(f2 * 6.283185307179586d);
                    break;
                case 5:
                    if (f2 < 0.5f) {
                        return (((f2 * 4.0f) * 2.0f) - 3.0f) * 0.5f * f2 * 2.0f * f2 * 2.0f;
                    }
                    float f7 = f2 * 2.0f;
                    return (((f7 - (f7 * 2.0f)) - (((((f2 * 4.0f) * 2.0f) - 2.0f) + 3.0f) * 2.0f)) + 2.0f) * 0.5f;
                case 6:
                    float f8 = f2 * 1.1226f;
                    if (f8 < 0.3535f) {
                        return f8 * f8 * 8.0f;
                    }
                    if (f8 < 0.7408f) {
                        float f9 = f8 - 0.54719f;
                        f3 = f9 * f9 * 8.0f;
                        f4 = 0.7f;
                    } else if (f8 < 0.9644f) {
                        float f10 = f8 - 0.8526f;
                        f3 = f10 * f10 * 8.0f;
                        f4 = 0.9f;
                    } else {
                        float f11 = f8 - 1.0435f;
                        f3 = f11 * f11 * 8.0f;
                        f4 = 0.95f;
                    }
                    return f3 + f4;
                default:
                    return f2;
            }
            return (float) cos;
        }
        return invokeLF.floatValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            while (!this.a.isEmpty()) {
                this.a.removeFirst().run();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.t = null;
            this.w = null;
            B(new b(this));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !this.k) {
            l();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.k = false;
            GLES20.glDeleteProgram(this.d);
            o();
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || this.k) {
            return;
        }
        t();
        u();
    }

    public void F(String str, long j, long j2, long j3, String str2, List<MediaOneAEffect> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, list}) == null) {
            this.r = str;
            this.p = j;
            this.q = j2;
            this.o = j3;
            this.s = str2;
            this.t = list;
        }
    }

    public void G(int i, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new c(this, i, f2));
            } else {
                GLES20.glUniform1f(i, f2);
            }
        }
    }

    public void H(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new g(this, i, fArr));
            } else {
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void K(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new d(this, i, fArr));
            } else {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void L(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new e(this, i, fArr));
            } else {
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void M(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new f(this, i, fArr));
            } else {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void R(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new h(this, i, fArr));
            } else {
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        }
    }

    public void S(int i, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new a(this, i, fArr));
            } else {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        }
    }

    public void I(int i, float[] fArr, boolean z) {
        int length;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), fArr, Boolean.valueOf(z)}) == null) && (length = fArr.length) != 0) {
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            if (length != 9) {
                                if (length != 16) {
                                    H(i, fArr, z);
                                    return;
                                } else {
                                    S(i, fArr, z);
                                    return;
                                }
                            }
                            R(i, fArr, z);
                            return;
                        }
                        M(i, fArr, z);
                        return;
                    }
                    L(i, fArr, z);
                    return;
                }
                K(i, fArr, z);
                return;
            }
            G(i, fArr[0], z);
        }
    }

    public final float O(float[] fArr, float f2, ShaderParams shaderParams) {
        InterceptResult invokeCommon;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{fArr, Float.valueOf(f2), shaderParams})) == null) {
            float A = A(shaderParams, f2);
            float[] fArr2 = shaderParams.values;
            float f4 = ((fArr2[1] - fArr2[0]) * A) + fArr2[0];
            if (AnimatedStateListDrawableCompat.ELEMENT_TRANSITION.equals(shaderParams.name)) {
                float[] fArr3 = shaderParams.values;
                f3 = ((fArr3[3] - fArr3[2]) * A) + fArr3[2];
            } else {
                f3 = 0.0f;
            }
            float f5 = 1.0f;
            if ("value".equals(shaderParams.type)) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j(), shaderParams.name), f4);
            } else {
                if (Key.ALPHA.equals(shaderParams.name)) {
                    f5 = f4;
                }
                x(shaderParams, fArr, f4, f3);
            }
            return f5;
        }
        return invokeCommon.floatValue;
    }

    public final float k(long j, long j2, MediaOneAEffect mediaOneAEffect) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), mediaOneAEffect})) == null) {
            long j3 = mediaOneAEffect.end - mediaOneAEffect.start;
            float f2 = 1.0f;
            if (TextUtils.equals(this.r, "end")) {
                long j4 = this.q;
                if (j4 - mediaOneAEffect.end > 0) {
                    long j5 = j4 - j;
                    if (j5 >= j3 && j5 % j3 == 0) {
                        f2 = 0.0f;
                    } else {
                        f2 = 1.0f - (((float) (j5 % j3)) / (((float) j3) * 1.0f));
                    }
                    return Math.abs(((float) j2) - f2);
                }
            }
            long j6 = j - (mediaOneAEffect.start + this.p);
            if (j6 < j3 || j6 % j3 != 0) {
                f2 = ((float) (j6 % j3)) / (((float) j3) * 1.0f);
            }
            return Math.abs(((float) j2) - f2);
        }
        return invokeCommon.floatValue;
    }

    public void p(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048605, this, i, floatBuffer, floatBuffer2) == null) {
            fg0.a("draw start");
            GLES20.glUseProgram(this.d);
            fg0.a("glUseProgram");
            C();
            if (!this.k) {
                return;
            }
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.l, i);
                GLES20.glUniform1i(this.f, 0);
            }
            floatBuffer.position(0);
            GLES20.glEnableVertexAttribArray(this.e);
            fg0.a("glEnableVertexAttribPositionArray");
            GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, (Buffer) floatBuffer);
            fg0.a("glVertexAttribPositionPointer");
            floatBuffer2.position(0);
            GLES20.glEnableVertexAttribArray(this.g);
            fg0.a("glEnableVertexAttribTextureArray");
            GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 0, (Buffer) floatBuffer2);
            fg0.a("glVertexAttribTexturePointer");
            r();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.e);
            GLES20.glDisableVertexAttribArray(this.g);
            q();
            GLES20.glBindTexture(this.l, 0);
            GLES20.glUseProgram(0);
        }
    }

    public final float P(float f2, float[] fArr, float f3, List<ShaderParams> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), fArr, Float.valueOf(f3), list})) == null) {
            for (int i = 0; i < list.size(); i++) {
                ShaderParams shaderParams = list.get(i);
                if (!"value".equals(shaderParams.type) && !ShaderParams.VALUE_TYPE_ANIMATOR.equals(shaderParams.type)) {
                    T(GLES20.glGetUniformLocation(j(), shaderParams.name), shaderParams);
                } else {
                    f2 = O(fArr, f3, shaderParams);
                }
            }
            return f2;
        }
        return invokeCommon.floatValue;
    }

    public void Q(long j, long j2, List<ShaderParams> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list}) == null) {
            this.u = j;
            this.v = j2;
            this.w = list;
        }
    }

    public void e(int i, String str, ShaderParams shaderParams) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(1048596, this, i, str, shaderParams) != null) || shaderParams == null) {
            return;
        }
        this.m.put(i, str);
        this.n.put(i, shaderParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r3 >= r7) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(int i, ShaderParams shaderParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, shaderParams) == null) {
            if (ShaderParams.VALUE_TYPE_FLOAT.equals(shaderParams.type)) {
                float[] fArr = shaderParams.values;
                if (fArr != null && fArr.length > 0) {
                    if (fArr.length > 1) {
                        long j = this.x;
                        long j2 = shaderParams.timeInterval;
                        if (j2 != 0) {
                            long j3 = shaderParams.lastTimeInterval;
                            if (j - j3 <= j2) {
                            }
                        }
                        int i2 = shaderParams.valuesPointer + 1;
                        shaderParams.valuesPointer = i2;
                        if (i2 >= shaderParams.values.length) {
                            shaderParams.valuesPointer = 0;
                        }
                        shaderParams.lastTimeInterval = j;
                    } else {
                        shaderParams.valuesPointer = 0;
                    }
                }
                float[] fArr2 = shaderParams.values;
                if (fArr2 != null) {
                    int length = fArr2.length;
                    int i3 = shaderParams.valuesPointer;
                    if (length > i3) {
                        GLES20.glUniform1f(i, fArr2[i3]);
                    }
                }
            } else if ("array".equals(shaderParams.type)) {
                float[] fArr3 = shaderParams.values;
                if (fArr3 != null && fArr3.length > 0) {
                    I(i, fArr3, false);
                }
            } else if ("step".equals(shaderParams.type)) {
                float[] fArr4 = shaderParams.values;
                if (fArr4 != null && fArr4.length >= 3) {
                    float f2 = fArr4[0];
                    int i4 = shaderParams.valuesPointer;
                    float f3 = f2 + (i4 * fArr4[2]);
                    shaderParams.valuesPointer = i4 + 1;
                    if (f3 > fArr4[1]) {
                        f3 = fArr4[1];
                    }
                    GLES20.glUniform1f(i, f3);
                }
            } else if (ShaderParams.IMAGE_WIDTH.equals(shaderParams.name)) {
                GLES20.glUniform1f(i, this.i);
            } else if (ShaderParams.IMAGE_HEIGHT.equals(shaderParams.name)) {
                GLES20.glUniform1f(i, this.j);
            }
        }
    }

    public void v(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || this.t == null) {
            return;
        }
        long j = this.x;
        long j2 = 0;
        if ("repeat".equals(this.s)) {
            long j3 = this.p;
            j = ((j - j3) % this.o) + j3;
        } else if (MediaAEffect.AE_ANIM_REVERSE.equals(this.s)) {
            long j4 = this.p;
            long j5 = this.o;
            j = ((j - j4) % j5) + j4;
            j2 = ((j - j4) / j5) % 2;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float f2 = 1.0f;
        for (MediaOneAEffect mediaOneAEffect : this.t) {
            if (f(mediaOneAEffect, j) && mediaOneAEffect.aParams != null) {
                float k = k(j, j2, mediaOneAEffect);
                if (k >= 0.0f && k <= 1.0f) {
                    f2 = P(f2, fArr, k, mediaOneAEffect.aParams);
                }
            }
        }
        N(fArr, f2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void x(ShaderParams shaderParams, float[] fArr, float... fArr2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, shaderParams, fArr, fArr2) == null) {
            float f2 = fArr2[0];
            String str = shaderParams.name;
            switch (str.hashCode()) {
                case -1909310045:
                    if (str.equals("transitionX")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1909310044:
                    if (str.equals("transitionY")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1724158635:
                    if (str.equals(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    Matrix.scaleM(fArr, 0, f2, f2, 1.0f);
                    return;
                case 1:
                    Matrix.scaleM(fArr, 0, f2, 1.0f, 1.0f);
                    return;
                case 2:
                    Matrix.scaleM(fArr, 0, 1.0f, f2, 1.0f);
                    return;
                case 3:
                    Matrix.translateM(fArr, 0, f2 * 2.0f, 0.0f, 0.0f);
                    return;
                case 4:
                    Matrix.translateM(fArr, 0, 0.0f, f2 * 2.0f, 0.0f);
                    return;
                case 5:
                    Matrix.translateM(fArr, 0, f2 * 2.0f, fArr2[1] * 2.0f, 1.0f);
                    return;
                case 6:
                    float[] fArr3 = shaderParams.values;
                    if (fArr3.length != 2) {
                        f2 *= fArr3[2];
                    }
                    Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
                    return;
                default:
                    return;
            }
        }
    }

    public final void z() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || this.w == null) {
            return;
        }
        long j = this.x;
        long j2 = this.v;
        if (j == j2) {
            return;
        }
        long j3 = this.u;
        long j4 = j2 - j3;
        long j5 = j - j3;
        if (j5 >= j4 && j5 % j4 == 0) {
            f2 = 1.0f;
        } else {
            f2 = ((float) (j5 % j4)) / (((float) j4) * 1.0f);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            N(fArr, P(1.0f, fArr, f2, this.w));
        }
    }
}
