package com.baidu.ugc.editvideo.faceunity.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.t.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes10.dex */
public class GlUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float[] HORI_FLIP_MATRIX;
    public static final float[] IDENTITY_MATRIX;
    public static final int NO_TEXTURE = -1;
    public static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";
    public static final float[] VERT_FLIP_MATRIX;
    public static String mGLErrorMsg = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1488831385, "Lcom/baidu/ugc/editvideo/faceunity/gles/GlUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1488831385, "Lcom/baidu/ugc/editvideo/faceunity/gles/GlUtil;");
                return;
            }
        }
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
        float[] fArr2 = new float[16];
        VERT_FLIP_MATRIX = fArr2;
        Matrix.setIdentityM(fArr2, 0);
        Matrix.scaleM(VERT_FLIP_MATRIX, 0, 1.0f, -1.0f, 1.0f);
        float[] fArr3 = new float[16];
        HORI_FLIP_MATRIX = fArr3;
        Matrix.setIdentityM(fArr3, 0);
        Matrix.scaleM(HORI_FLIP_MATRIX, 0, -1.0f, 1.0f, 1.0f);
    }

    public GlUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void bindTextureToFBO(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65538, null, i2, i3, i4) == null) {
            GLES20.glBindFramebuffer(36160, i4);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glBindTexture(i3, i2);
            GLES20.glFramebufferTexture2D(36160, 36064, i3, i2, 0);
        }
    }

    public static void checkGlError(String str) {
        int glGetError;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || (glGetError = GLES20.glGetError()) == 0) {
            return;
        }
        c.e("Grafika", str + ": glError 0x" + Integer.toHexString(glGetError));
    }

    public static void checkLocation(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, str) == null) {
        }
    }

    public static int createFBOForTexture(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            int createFrameBufferObject = createFrameBufferObject();
            checkGlError("createFrameBufferObject");
            bindTextureToFBO(i2, i3, createFrameBufferObject);
            return createFrameBufferObject;
        }
        return invokeII.intValue;
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fArr)) == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        }
        return (FloatBuffer) invokeL.objValue;
    }

    public static int createFrameBufferObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            return iArr[0];
        }
        return invokeV.intValue;
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, byteBuffer, i2, i3, i4)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i5 = iArr[0];
            checkGlError("glGenTextures");
            GLES20.glBindTexture(3553, i5);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            checkGlError("loadImageTexture");
            GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i4, 5121, byteBuffer);
            checkGlError("loadImageTexture");
            return i5;
        }
        return invokeLIII.intValue;
    }

    public static int createProgram(String str, String str2) {
        InterceptResult invokeLL;
        int loadShader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            int loadShader2 = loadShader(35633, str);
            if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (glCreateProgram == 0) {
                c.e("Grafika", "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String str3 = "Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram);
                mGLErrorMsg = str3 + ",vertexShader:" + str + ",fragmentShader:" + str2;
                c.e("Grafika", str3);
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            return glCreateProgram;
        }
        return invokeLL.intValue;
    }

    public static int createTextureObject(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65549, null, i2, i3, i4, i5)) == null) {
            int createTextureObject = createTextureObject(i2, i3);
            GLES20.glTexImage2D(i2, 0, GeneratedTexture.FORMAT, i4, i5, 0, GeneratedTexture.FORMAT, 5121, null);
            return createTextureObject;
        }
        return invokeIIII.intValue;
    }

    public static void destroyFramebufferObject(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, null, i2) == null) || i2 == -1) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
        checkGlError("glDeleteFramebuffers");
    }

    public static void destroyTextureObject(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65551, null, i2) == null) || i2 == -1) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        checkGlError("glDeleteTextures");
    }

    public static int loadShader(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i2, str)) == null) {
            int glCreateShader = GLES20.glCreateShader(i2);
            checkGlError("glCreateShader type=" + i2);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String str2 = "Could not compile shader, type:" + i2 + ":" + GLES20.glGetShaderInfoLog(glCreateShader);
                mGLErrorMsg = str2 + ",shader:" + str;
                c.e("Grafika", str2);
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return invokeIL.intValue;
    }

    public static void logVersionInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            c.j("Grafika", "vendor  : " + GLES20.glGetString(7936));
            c.j("Grafika", "renderer: " + GLES20.glGetString(7937));
            c.j("Grafika", "version : " + GLES20.glGetString(7938));
        }
    }

    public static int createTextureObject(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, null, i2, i3)) == null) {
            int i4 = i3 == 0 ? 9729 : 9728;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            checkGlError("glGenTextures");
            int i5 = iArr[0];
            GLES20.glBindTexture(i2, i5);
            checkGlError("glBindTexture " + i5);
            float f2 = (float) i4;
            GLES20.glTexParameterf(i2, 10241, f2);
            GLES20.glTexParameterf(i2, 10240, f2);
            GLES20.glTexParameteri(i2, 10242, 33071);
            GLES20.glTexParameteri(i2, 10243, 33071);
            checkGlError("glTexParameter");
            return i5;
        }
        return invokeII.intValue;
    }

    public static int createTextureObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? createTextureObject(i2, 0) : invokeI.intValue;
    }

    public static int createTextureObject(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65548, null, i2, i3, i4)) == null) {
            int createTextureObject = createTextureObject(i2);
            GLES20.glTexImage2D(i2, 0, GeneratedTexture.FORMAT, i3, i4, 0, GeneratedTexture.FORMAT, 5121, null);
            checkGlError("createTextureObject");
            return createTextureObject;
        }
        return invokeIII.intValue;
    }
}
