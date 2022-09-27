package com.baidu.tieba;

import android.opengl.GLES20;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes5.dex */
public class od0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "od0";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948028270, "Lcom/baidu/tieba/od0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948028270, "Lcom/baidu/tieba/od0;");
        }
    }

    public static void a(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        Log.e(a, str + ": glError 0x" + Integer.toHexString(glGetError));
    }

    public static FloatBuffer b(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fArr)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        }
        return (FloatBuffer) invokeL.objValue;
    }

    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        int d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            int d2 = d(35633, str);
            if (d2 == 0 || (d = d(35632, str2)) == 0) {
                return -1;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            a("glCreateProgram");
            if (glCreateProgram == 0) {
                Log.e(a, "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, d2);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, d);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(a, "Could not link program: ");
                Log.e(a, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return -1;
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    public static int d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i);
            a("glCreateShader type=" + i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String str2 = a;
                Log.e(str2, "Could not compile shader " + i + ":");
                String str3 = a;
                Log.e(str3, " " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }
}
