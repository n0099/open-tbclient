package com.baidu.ugc.editvideo.faceunity.gles;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.tieba.lha;
import com.faceunity.gles.GeneratedTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes7.dex */
public class GlUtil {
    public static final float[] HORI_FLIP_MATRIX;
    public static final float[] IDENTITY_MATRIX;
    public static final int NO_TEXTURE = -1;
    public static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";
    public static final float[] VERT_FLIP_MATRIX;
    public static String mGLErrorMsg = "";

    public static void checkLocation(int i, String str) {
    }

    static {
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

    public static int createFrameBufferObject() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static void bindTextureToFBO(int i, int i2, int i3) {
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glBindTexture(i2, i);
        GLES20.glFramebufferTexture2D(36160, 36064, i2, i, 0);
    }

    public static int createTextureObject(int i, int i2, int i3) {
        int createTextureObject = createTextureObject(i);
        GLES20.glTexImage2D(i, 0, GeneratedTexture.FORMAT, i2, i3, 0, GeneratedTexture.FORMAT, 5121, null);
        checkGlError("createTextureObject");
        return createTextureObject;
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            lha.e("Grafika", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int createTextureObject(int i) {
        return createTextureObject(i, 0);
    }

    public static void destroyFramebufferObject(int i) {
        if (i == -1) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        checkGlError("glDeleteFramebuffers");
    }

    public static void destroyTextureObject(int i) {
        if (i == -1) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlError("glDeleteTextures");
    }

    public static int createFBOForTexture(int i, int i2) {
        int createFrameBufferObject = createFrameBufferObject();
        checkGlError("createFrameBufferObject");
        bindTextureToFBO(i, i2, createFrameBufferObject);
        return createFrameBufferObject;
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        checkGlError("loadImageTexture");
        return i4;
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError("glCreateProgram");
        if (glCreateProgram == 0) {
            lha.e("Grafika", "Could not create program");
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
            lha.e("Grafika", str3);
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            String str2 = "Could not compile shader, type:" + i + ":" + GLES20.glGetShaderInfoLog(glCreateShader);
            mGLErrorMsg = str2 + ",shader:" + str;
            lha.e("Grafika", str2);
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static int createTextureObject(int i, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = 9729;
        } else {
            i3 = 9728;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlError("glGenTextures");
        int i4 = iArr[0];
        GLES20.glBindTexture(i, i4);
        checkGlError("glBindTexture " + i4);
        float f = (float) i3;
        GLES20.glTexParameterf(i, 10241, f);
        GLES20.glTexParameterf(i, 10240, f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        checkGlError("glTexParameter");
        return i4;
    }

    public static int createTextureObject(int i, int i2, int i3, int i4) {
        int createTextureObject = createTextureObject(i, i2);
        GLES20.glTexImage2D(i, 0, GeneratedTexture.FORMAT, i3, i4, 0, GeneratedTexture.FORMAT, 5121, null);
        return createTextureObject;
    }

    public static void logVersionInfo() {
        lha.j("Grafika", "vendor  : " + GLES20.glGetString(7936));
        lha.j("Grafika", "renderer: " + GLES20.glGetString(7937));
        lha.j("Grafika", "version : " + GLES20.glGetString(7938));
    }
}
