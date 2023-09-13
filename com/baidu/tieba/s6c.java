package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.text.TextPaint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberRender;
import com.baidu.tieba.j4c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import com.yy.transvod.player.common.effectmp4.EffectFrame;
import com.yy.transvod.player.common.effectmp4.EffectInfo;
import com.yy.transvod.player.common.effectmp4.EffectObject;
import com.yy.transvod.player.common.effectmp4.EffectSource;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
@TargetApi(16)
/* loaded from: classes7.dex */
public final class s6c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String N = "s6c";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public long C;
    public w4c D;
    public Bitmap E;
    public Bitmap F;
    public TreeMap<Integer, float[]> G;
    public TreeMap<Integer, Rect> H;
    public TreeMap<Integer, String> I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public v6c a;
    public int b;
    public p6c[] c;
    public p6c[] d;
    public o6c[] e;
    public n6c[] f;
    public n4c g;
    public n4c h;
    public int i;
    public int[] j;
    public int[] k;
    public FloatBuffer[] l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public MediaInfo s;
    public float[] t;
    public final AtomicBoolean u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public float[] z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948104809, "Lcom/baidu/tieba/s6c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948104809, "Lcom/baidu/tieba/s6c;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ByteBuffer c;
        public final /* synthetic */ Object d;

        public a(s6c s6cVar, int i, int i2, ByteBuffer byteBuffer, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6cVar, Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = byteBuffer;
            this.d = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    TLog.g(this, "readPixels,start");
                    Matrix matrix = new Matrix();
                    matrix.postScale(1.0f, -1.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(this.c);
                    Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, this.a, this.b, matrix, false);
                    createBitmap.recycle();
                    ((j4c.d) this.d).a(createBitmap2);
                    TLog.g(this, "readPixels,end");
                } catch (Exception unused) {
                    TLog.g(this, "readPixels error");
                }
            }
        }
    }

    public s6c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new v6c();
        this.b = 0;
        this.c = new p6c[4];
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.j = new int[3];
        this.k = new int[1];
        this.l = new FloatBuffer[1];
        this.m = 0;
        this.n = 0;
        this.o = 1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = MediaInfo.a();
        this.t = new float[t6c.a.length];
        this.u = new AtomicBoolean(false);
        this.v = 0;
        this.w = 1;
        this.x = true;
        this.y = true;
        this.z = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.A = false;
        this.B = false;
        this.C = 0L;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = new TreeMap<>();
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.w = i;
        this.l[0] = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l[0].put(t6c.a).rewind();
        int i4 = 0;
        while (true) {
            p6c[] p6cVarArr = this.c;
            if (i4 >= p6cVarArr.length) {
                break;
            }
            p6cVarArr[i4] = new p6c(this.a);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr = this.j;
            if (i5 >= iArr.length) {
                break;
            }
            iArr[i5] = -1;
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr2 = this.k;
            if (i6 < iArr2.length) {
                iArr2[i6] = -1;
                i6++;
            } else {
                TLog.g(this, String.format("OpenGL samplerFilter = %d", Integer.valueOf(i)));
                return;
            }
        }
    }

    public final void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!e()) {
                TLog.g(this, "updateVertexBuffer return  " + str);
                return;
            }
            TLog.g(this, "updateVertexBuffer  in " + str);
            W();
            float[] fArr = new float[t6c.a.length];
            this.l[0].get(fArr).rewind();
            MediaInfo mediaInfo = this.s;
            int i = mediaInfo.b;
            int i2 = mediaInfo.d;
            int i3 = mediaInfo.c;
            int i4 = mediaInfo.e;
            this.x = true;
            this.y = true;
            int i5 = this.b;
            if (i5 != 1 && i5 != 2) {
                if (i5 == 3) {
                    if (i > 0) {
                        float f = this.D.a.c;
                        mediaInfo.b = (int) f;
                        mediaInfo.d = (int) (i2 * (f / i));
                    }
                    MediaInfo mediaInfo2 = this.s;
                    int i6 = mediaInfo2.c;
                    if (i6 > 0) {
                        float f2 = this.D.a.d;
                        mediaInfo2.c = (int) f2;
                        mediaInfo2.e = (int) (mediaInfo2.e * (f2 / i6));
                    }
                }
            } else {
                MediaInfo mediaInfo3 = this.s;
                mediaInfo3.b /= 2;
                mediaInfo3.d /= 2;
            }
            if (this.r == 1) {
                w6c.a(fArr, this.o, this.q, this.s, this.n, this.m);
                w6c.b(fArr, this.o, this.q, this.s, this.n, this.m);
            } else {
                w6c.a(fArr, this.o, this.q, this.s, this.m, this.n);
                w6c.b(fArr, this.o, this.q, this.s, this.m, this.n);
            }
            MediaInfo mediaInfo4 = this.s;
            mediaInfo4.b = i;
            mediaInfo4.d = i2;
            mediaInfo4.c = i3;
            mediaInfo4.e = i4;
            this.l[0].put(fArr).rewind();
            GLES20.glBindBuffer(34962, this.k[0]);
            GLES20.glBufferData(34962, 64, this.l[0], 35044);
            w6c.c("glBufferData()", this.a);
            GLES20.glBindBuffer(34962, 0);
            B("updateVertexBuffer", fArr);
        }
    }

    public static void S(MediaSample mediaSample, int[] iArr, ByteBuffer[] byteBufferArr, v6c v6cVar) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, mediaSample, iArr, byteBufferArr, v6cVar) == null) {
            MediaInfo mediaInfo = mediaSample.i;
            int i = mediaInfo.d;
            int i2 = mediaInfo.e;
            for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
                if (byteBufferArr[i3] != null && byteBufferArr[i3].position() > 0) {
                    TLog.d(N, "ByteBuffer.position MUST not be more than 0, otherwise it will crash. Maybe it is a bug.");
                    throw new RuntimeException("unexpected ByteBuffer.");
                }
            }
            int i4 = mediaSample.i.a;
            if (i4 == 4) {
                GLES20.glPixelStorei(3317, 1);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, iArr[0]);
                if (byteBufferArr[0] != null) {
                    GLES20.glTexImage2D(3553, 0, 6407, i, i2, 0, 6407, 5121, byteBufferArr[0]);
                }
            } else if (i4 == 2) {
                GLES20.glPixelStorei(3317, 1);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, iArr[0]);
                if (byteBufferArr[0] != null) {
                    c = 2;
                    GLES20.glTexImage2D(3553, 0, 6409, i, i2, 0, 6409, 5121, byteBufferArr[0]);
                } else {
                    c = 2;
                }
                int i5 = i >> 1;
                int i6 = i2 >> 1;
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, iArr[1]);
                if (byteBufferArr[1] != null) {
                    GLES20.glTexImage2D(3553, 0, 6409, i5, i6, 0, 6409, 5121, byteBufferArr[1]);
                }
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, iArr[c]);
                if (byteBufferArr[c] != null) {
                    GLES20.glTexImage2D(3553, 0, 6409, i5, i6, 0, 6409, 5121, byteBufferArr[c]);
                }
            } else if (i4 == 3) {
                GLES20.glPixelStorei(3317, 1);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glTexImage2D(3553, 0, 6409, i, i2, 0, 6409, 5121, byteBufferArr[0]);
                w6c.c("glTexImage2D()", v6cVar);
                int i7 = i >> 1;
                int i8 = i2 >> 1;
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, iArr[1]);
                if (byteBufferArr[1] != null) {
                    GLES20.glTexImage2D(3553, 0, 6410, i7, i8, 0, 6410, 5121, byteBufferArr[1]);
                }
                w6c.c("glTexImage2D()", v6cVar);
            }
        }
    }

    public static void T(int i, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, iArr) == null) {
            int[] iArr2 = {33984, 33985, 33986};
            int i2 = 0;
            if (i == 4) {
                GLES20.glActiveTexture(iArr2[0]);
                GLES20.glBindTexture(3553, iArr[0]);
            } else if (i == 2) {
                while (i2 < 3) {
                    GLES20.glActiveTexture(iArr2[i2]);
                    GLES20.glBindTexture(3553, iArr[i2]);
                    i2++;
                }
            } else if (i == 3) {
                while (i2 < 2) {
                    GLES20.glActiveTexture(iArr2[i2]);
                    GLES20.glBindTexture(3553, iArr[i2]);
                    i2++;
                }
            }
        }
    }

    public static boolean d(MediaSample mediaSample) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaSample)) == null) {
            int i = mediaSample.i.a;
            if (i != 2 && i != 3 && i != 4 && i != 8) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.o != i) {
            this.o = i;
            Z("setDisplayMode()");
            TLog.g(this, "setDisplayMode " + this.o);
        }
    }

    public void I(x4c x4cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x4cVar) == null) && this.D != null) {
            U(x4cVar);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (b() && z) {
                k();
            }
            this.M = z;
            X("setIsSpecialMp4WithAlpha", false);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.B = z;
            if (z) {
                j();
            }
        }
    }

    public void L(n4c n4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, n4cVar) == null) {
            this.h = n4cVar;
            W();
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && this.r != i) {
            this.r = i;
            Z("setOrientateMode()");
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && this.p != i) {
            this.p = i;
            m();
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && this.q != i) {
            this.q = i;
            m();
        }
    }

    public void V(MediaInfo mediaInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mediaInfo) == null) {
            if (!this.s.e(mediaInfo)) {
                TLog.g(this, "updateFrameSize, is same, return");
                return;
            }
            this.s.c(mediaInfo);
            Z("updateFrameSize()");
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        i();
                        return;
                    }
                    return;
                }
                j();
                return;
            }
            k();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap A(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Bitmap bitmap = null;
            bitmap = null;
            bitmap = null;
            FileInputStream fileInputStream2 = null;
            if (str != null) {
                try {
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!str.isEmpty()) {
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            try {
                                bitmap = BitmapFactory.decodeStream(fileInputStream);
                                fileInputStream.close();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return bitmap;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream2 != null) {
                        }
                        throw th;
                    }
                    return bitmap;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void B(String str, float[] fArr) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fArr) == null) {
            if (fArr != null && fArr.length >= 16) {
                String[] strArr = {"Extend", "Scale", "Crop"};
                String[] strArr2 = {"None", "Rotate90", "Rotate180", "Rotate270"};
                String[] strArr3 = {"Vertical", "Horizontal"};
                Object[] objArr = new Object[25];
                objArr[0] = Integer.valueOf(this.s.b);
                objArr[1] = Integer.valueOf(this.s.c);
                objArr[2] = Integer.valueOf(this.s.d);
                objArr[3] = Integer.valueOf(this.s.e);
                objArr[4] = Integer.valueOf(this.m);
                objArr[5] = Integer.valueOf(this.n);
                int i = this.o;
                String str4 = "Unknown";
                if (i < 0 || i >= 3) {
                    str2 = "Unknown";
                } else {
                    str2 = strArr[i];
                }
                objArr[6] = str2;
                int i2 = this.p;
                if (i2 < 0 || i2 >= 4) {
                    str3 = "Unknown";
                } else {
                    str3 = strArr2[i2];
                }
                objArr[7] = str3;
                int i3 = this.r;
                if (i3 >= 0 && i3 < 2) {
                    str4 = strArr3[i3];
                }
                objArr[8] = str4;
                objArr[9] = Float.valueOf(fArr[0]);
                objArr[10] = Float.valueOf(fArr[1]);
                objArr[11] = Float.valueOf(fArr[2]);
                objArr[12] = Float.valueOf(fArr[3]);
                objArr[13] = Float.valueOf(fArr[4]);
                objArr[14] = Float.valueOf(fArr[5]);
                objArr[15] = Float.valueOf(fArr[6]);
                objArr[16] = Float.valueOf(fArr[7]);
                objArr[17] = Float.valueOf(fArr[8]);
                objArr[18] = Float.valueOf(fArr[9]);
                objArr[19] = Float.valueOf(fArr[10]);
                objArr[20] = Float.valueOf(fArr[11]);
                objArr[21] = Float.valueOf(fArr[12]);
                objArr[22] = Float.valueOf(fArr[13]);
                objArr[23] = Float.valueOf(fArr[14]);
                objArr[24] = Float.valueOf(fArr[15]);
                String format = String.format(" frameSize:%dx%d, planeSize:%dx%d, surfaceSize:%dx%d\ndisplayMode:%s, Rotation:%s, Orientation:%s,\nVertex =\n%.6f, %.6f, %.6f, %.6f\n%.6f, %.6f, %.6f, %.6f\n%.6f, %.6f, %.6f, %.6f\n%.6f, %.6f, %.6f, %.6f\n", objArr);
                TLog.g(this, str + format);
                return;
            }
            TLog.c(this, str + " vertexArray invalid!!");
        }
    }

    public void C() {
        boolean z;
        n4c n4cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.v == 0) {
            return;
        }
        int i = this.b;
        if (i == 0 || i == 2) {
            if (this.B && (((n4cVar = this.g) != null && n4cVar.a) || this.A)) {
                z = true;
            } else {
                z = false;
            }
            X("reDraw", z);
        }
        GLES20.glViewport(0, 0, this.m, this.n);
        int i2 = this.v;
        if (i2 == 8) {
            p6c p6cVar = v()[3];
            if (this.b == 3 && (p6cVar instanceof n6c)) {
                r(p6cVar, this.C, this.i);
                return;
            } else {
                u(p6cVar, this.i);
                return;
            }
        }
        p6c y = y(i2);
        z();
        GLES20.glClear(16384);
        y.g(this.k[0]);
        T(this.v, this.j);
        y.h(this.t);
        if (this.b == 3 && (y instanceof n6c)) {
            p((n6c) y, this.C, true);
        } else {
            y.i(this.g);
        }
        y.c();
        GLES20.glBindTexture(3553, 0);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!b()) {
                TLog.g(this, "opengl no need to release.");
                return;
            }
            TLog.g(this, "OpenGL.release enter.");
            int i = 0;
            while (true) {
                int[] iArr = this.k;
                if (i >= iArr.length) {
                    break;
                }
                iArr[i] = w6c.i(iArr[i], this.a);
                i++;
            }
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.j;
                if (i2 >= iArr2.length) {
                    break;
                }
                iArr2[i2] = w6c.l(iArr2[i2], this.a);
                i2++;
            }
            this.i = w6c.l(this.i, this.a);
            int i3 = 0;
            while (true) {
                p6c[] p6cVarArr = this.c;
                if (i3 >= p6cVarArr.length) {
                    break;
                }
                p6cVarArr[i3].b();
                i3++;
            }
            this.J = w6c.l(this.J, this.a);
            if (this.d != null) {
                int i4 = 0;
                while (true) {
                    p6c[] p6cVarArr2 = this.d;
                    if (i4 >= p6cVarArr2.length) {
                        break;
                    }
                    p6cVarArr2[i4].b();
                    i4++;
                }
            }
            if (this.e != null) {
                int i5 = 0;
                while (true) {
                    o6c[] o6cVarArr = this.e;
                    if (i5 >= o6cVarArr.length) {
                        break;
                    }
                    o6cVarArr[i5].b();
                    i5++;
                }
            }
            if (this.f != null) {
                int i6 = 0;
                while (true) {
                    n6c[] n6cVarArr = this.f;
                    if (i6 >= n6cVarArr.length) {
                        break;
                    }
                    n6cVarArr[i6].b();
                    i6++;
                }
            }
            Bitmap bitmap = this.E;
            if (bitmap != null) {
                bitmap.recycle();
                this.E = null;
            }
            Bitmap bitmap2 = this.F;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.F = null;
            }
            this.u.set(false);
            this.v = 0;
            this.A = false;
            this.C = 0L;
            TLog.g(this, "OpenGL.release leave.");
        }
    }

    public void D(Executor executor, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, executor, obj) == null) {
            int i = this.m;
            int i2 = this.n;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.position(0);
            GLES20.glReadPixels(0, 0, i, i2, GeneratedTexture.FORMAT, 5121, allocateDirect);
            executor.execute(new a(this, i, i2, allocateDirect, obj));
        }
    }

    public void Y(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            if (i != this.m || i2 != this.n) {
                TLog.g(this, "updateSurfaceSize width:" + i + ", height:" + i2);
                this.m = i;
                this.n = i2;
                Z("updateSurfaceSize()");
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.v = 0;
            this.A = false;
            this.C = 0L;
            this.s.i();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.i == -1) {
            int e = w6c.e(this.a);
            this.i = e;
            R(e);
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, 0);
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.u.get();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            MediaInfo mediaInfo = this.s;
            int i2 = mediaInfo.b;
            if (i2 > 0 && (i = mediaInfo.c) > 0 && mediaInfo.d >= i2 && mediaInfo.e >= i && this.m > 0 && this.n > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            GLES20.glViewport(0, 0, this.m, this.n);
            z();
            GLES20.glClear(16384);
        }
    }

    public final p6c[] v() {
        InterceptResult invokeV;
        p6c[] p6cVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            int i = this.b;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        p6cVarArr = null;
                    } else {
                        p6cVarArr = this.f;
                    }
                } else {
                    p6cVarArr = this.e;
                }
            } else {
                p6cVarArr = this.d;
            }
            if (p6cVarArr == null) {
                return this.c;
            }
            return p6cVarArr;
        }
        return (p6c[]) invokeV.objValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int i = this.w;
            if (i != 0 && i != 1) {
                return 9728;
            }
            return 9729;
        }
        return invokeV.intValue;
    }

    public v6c x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.a;
        }
        return (v6c) invokeV.objValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            float f = this.z[3];
            int i = this.b;
            f = (i == 1 || i == 3) ? 0.0f : 0.0f;
            float[] fArr = this.z;
            GLES20.glClearColor(fArr[0], fArr[1], fArr[2], f);
        }
    }

    public void G(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float[] fArr = this.z;
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
        }
    }

    public void P(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            if (this.u.getAndSet(true)) {
                TLog.g(this, "already created.");
                return;
            }
            TLog.g(this, "OpenGL.setup enter displayWidth = " + i + ", displayHeight = " + i2);
            this.s.i();
            try {
                this.c[0].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;     \nprecision mediump int;       \nvarying vec2 v_texCoord;     \nuniform sampler2D u_texRGB;  \nvoid main(void)              \n{                            \n   vec4 color = texture2D(u_texRGB, v_texCoord); \n   gl_FragColor = color;     \n}                            \n", 4, this.w);
                this.c[1].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;  \nprecision mediump int;    \nvarying vec2 v_texCoord;  \nuniform sampler2D u_texY; \nuniform sampler2D u_texU; \nuniform sampler2D u_texV; \nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvoid main(void)   \n{                 \n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, v_texCoord).r - 0.0625; \n   yuv.y = texture2D(u_texU, v_texCoord).r - 0.5;    \n   yuv.z = texture2D(u_texV, v_texCoord).r - 0.5;    \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   gl_FragColor = vec4(rgb, 1.0);  \n}                                  \n", 2, this.w);
                this.c[2].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;   \nprecision mediump int;     \nvarying vec2 v_texCoord;   \nuniform sampler2D u_texY;  \nuniform sampler2D u_texUV; \nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvoid main(void)   \n{                 \n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, v_texCoord).r - 0.0625;            \n   yuv.yz = texture2D(u_texUV, v_texCoord).ra - vec2(0.5, 0.5); \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   gl_FragColor = vec4(rgb, 1.0);  \n}                                  \n", 3, this.w);
                if (this.w == 0) {
                    this.c[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nprecision mediump int;\nvarying vec2 v_texCoord;\nuniform samplerExternalOES u_texRGB;\nvoid main(void) {\n    vec3 color = texture2D(u_texRGB, v_texCoord).rgb;\n    gl_FragColor = vec4(color, 1.0);\n}\n", 8, this.w);
                } else {
                    this.c[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nvarying vec2 v_texCoord;\nuniform samplerExternalOES u_texRGB;\nuniform vec2 u_textureSize;\nuniform int u_samplerFilter;\nvec3 cubicHermite(vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n    float t2 = t * t;\n    float t3 = t * t * t;\n    vec3 a = -A / 2.0 + (3.0 * B) / 2.0 - (3.0 * C) / 2.0 + D / 2.0;\n    vec3 b = A - (5.0 * B) / 2.0 + 2.0 * C - D / 2.0;\n    vec3 c = -A / 2.0 + C / 2.0;\n    vec3 d = B;\n    vec3 rgb = a * t3 + b * t2 + c * t + d;\n    return rgb;\n}\nvec3 bicubic(vec2 P) {\n    vec2 c_onePixel = (1.0 / u_textureSize);\n    vec2 c_twoPixels = (2.0 / u_textureSize);\n    vec2 pixel = P * u_textureSize + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel) / u_textureSize - vec2(c_onePixel / 2.0);\n    vec3 C01 = texture2D(u_texRGB, pixel + vec2(-c_onePixel.x, 0.0)).rgb;\n    vec3 C11 = texture2D(u_texRGB, pixel + vec2(0.0, 0.0)).rgb;\n    vec3 C21 = texture2D(u_texRGB, pixel + vec2(c_onePixel.x, 0.0)).rgb;\n    vec3 C31 = texture2D(u_texRGB, pixel + vec2(c_twoPixels.x, 0.0)).rgb;\n    vec3 C02 = texture2D(u_texRGB, pixel + vec2(-c_onePixel.x, c_onePixel.y)).rgb;\n    vec3 C12 = texture2D(u_texRGB, pixel + vec2(0.0, c_onePixel.y)).rgb;\n    vec3 C22 = texture2D(u_texRGB, pixel + vec2(c_onePixel.x, c_onePixel.y)).rgb;\n    vec3 C32 = texture2D(u_texRGB, pixel + vec2(c_twoPixels.x, c_onePixel.y)).rgb;\n    vec3 CP1X = cubicHermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubicHermite(C02, C12, C22, C32, frac.x);\n    return mix(CP1X, CP2X, frac.y);\n}\nvoid main(void) {\n    vec3 color;\n    if (u_samplerFilter == 0) {\n        color = texture2D(u_texRGB, v_texCoord).rgb;\n    } else {\n        color = bicubic(v_texCoord).rgb;\n    }\n    gl_FragColor = vec4(color, 1.0);\n}\n", 8, this.w);
                }
                h(this.b);
                g();
                l();
                this.m = i;
                this.n = i2;
                TLog.g(this, "OpenGL.setup leave.");
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public final void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, i);
            float w = w();
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10240, w);
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10241, w);
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10242, 33071.0f);
            GLES20.glTexParameterf(CyberRender.GL_TEXTURE_EXTERNAL_OES, 10243, 33071.0f);
        }
    }

    public final p6c y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            p6c[] v = v();
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 8) {
                            return null;
                        }
                        return v[3];
                    }
                    return v[0];
                }
                return v[2];
            }
            return v[1];
        }
        return (p6c) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.util.TreeMap<java.lang.Integer, float[]> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.util.TreeMap<java.lang.Integer, android.graphics.Rect> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void U(x4c x4cVar) {
        boolean z;
        int i;
        char c;
        TreeMap treeMap;
        Iterator<Map.Entry<Integer, EffectSource>> it;
        int i2;
        EffectSource effectSource;
        Bitmap bitmap;
        TreeMap<String, String> treeMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, x4cVar) == null) {
            TreeMap treeMap3 = new TreeMap();
            ArrayList arrayList = new ArrayList();
            this.I.clear();
            Iterator<Map.Entry<Integer, EffectSource>> it2 = this.D.b.entrySet().iterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                Bitmap bitmap2 = null;
                if (!it2.hasNext()) {
                    break;
                }
                EffectSource value = it2.next().getValue();
                if (value.e.equals("txt") && (treeMap2 = x4cVar.a) != null) {
                    String str = treeMap2.get(value.d);
                    it = it2;
                    treeMap = treeMap3;
                    i2 = i4;
                    effectSource = value;
                    bitmap = t((int) value.a, (int) value.b, value.g, value.f, str);
                    TLog.h("updateEffectResourceImage", "tag: " + effectSource.d + ", txt: " + str + " scaleMode:" + effectSource.h);
                } else {
                    treeMap = treeMap3;
                    it = it2;
                    i2 = i4;
                    effectSource = value;
                    TreeMap<String, String> treeMap4 = x4cVar.b;
                    if (treeMap4 != null) {
                        bitmap2 = A(treeMap4.get(effectSource.d));
                    }
                    TLog.h("updateEffectResourceImage", "tag: " + effectSource.d + " scaleMode:" + effectSource.h);
                    bitmap = bitmap2;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    arrayList.add(bitmap);
                    i3 = Math.max(i3, bitmap.getWidth());
                    i5 = Math.max(i5, bitmap.getHeight());
                    i6 += bitmap.getWidth();
                    this.I.put(Integer.valueOf(effectSource.c), effectSource.h);
                    TreeMap treeMap5 = treeMap;
                    treeMap5.put(Integer.valueOf(effectSource.c), bitmap);
                    i4 = i2 + bitmap.getHeight();
                    treeMap3 = treeMap5;
                } else {
                    treeMap3 = treeMap;
                    i4 = i2;
                }
                it2 = it;
            }
            TreeMap treeMap6 = treeMap3;
            int i7 = i4;
            if (treeMap6.isEmpty()) {
                return;
            }
            if (i3 * i7 < i5 * i6) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i3 = i6;
            }
            if (z) {
                i = i7;
            } else {
                i = i5;
            }
            Bitmap bitmap3 = this.E;
            if (bitmap3 != null) {
                bitmap3.recycle();
                this.E = null;
            }
            this.E = Bitmap.createBitmap(i3, i, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.E);
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            TreeMap<Integer, float[]> treeMap7 = this.G;
            if (treeMap7 == null) {
                this.G = new TreeMap<>();
            } else {
                treeMap7.clear();
            }
            TreeMap<Integer, Rect> treeMap8 = this.H;
            if (treeMap8 == null) {
                this.H = new TreeMap<>();
            } else {
                treeMap8.clear();
            }
            int i8 = 0;
            for (Map.Entry entry : treeMap6.entrySet()) {
                Bitmap bitmap4 = (Bitmap) entry.getValue();
                if (z) {
                    int height = bitmap4.getHeight() + i8;
                    c = 0;
                    rect.set(0, 0, bitmap4.getWidth(), bitmap4.getHeight());
                    rect2.set(0, i8, bitmap4.getWidth(), height);
                    i8 = height;
                } else {
                    c = 0;
                    rect.set(0, 0, bitmap4.getWidth(), bitmap4.getHeight());
                    rect2.set(i8, 0, bitmap4.getWidth() + i8, bitmap4.getHeight());
                    i8 = bitmap4.getWidth() + i8;
                }
                canvas.drawBitmap(bitmap4, rect, rect2, (Paint) null);
                float[] fArr = new float[4];
                float f = i3;
                fArr[c] = rect2.left / f;
                float f2 = i;
                fArr[1] = rect2.top / f2;
                fArr[2] = rect2.width() / f;
                fArr[3] = rect2.height() / f2;
                this.G.put(entry.getKey(), fArr);
                this.H.put(entry.getKey(), new Rect(rect2));
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                ((Bitmap) it3.next()).recycle();
            }
            arrayList.clear();
        }
    }

    public final void W() {
        MediaInfo mediaInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            n4c n4cVar = this.h;
            if (n4cVar != null) {
                this.g = new n4c(n4cVar.b, n4cVar.c, n4cVar.d, n4cVar.e, n4cVar.a);
            } else {
                this.g = null;
            }
            if (this.h == null) {
                return;
            }
            int i = this.o;
            if (i != 0) {
                int i2 = this.s.c;
                int i3 = this.m;
                int i4 = this.n;
                n4c n4cVar2 = this.g;
                float f = n4cVar2.d - n4cVar2.b;
                float f2 = n4cVar2.c - n4cVar2.e;
                float f3 = i2 / (mediaInfo.b / 2);
                float f4 = i4;
                float f5 = i3;
                float f6 = f4 / f5;
                if (i == 1) {
                    i4 = w6c.f(f3 * f5);
                } else if (f3 > f6) {
                    i4 = w6c.f(f3 * f5);
                } else {
                    i3 = w6c.f(f4 / f3);
                }
                float f7 = i3 / f5;
                float f8 = i4 / f4;
                n4c n4cVar3 = this.g;
                n4c n4cVar4 = this.h;
                float f9 = ((float) ((f7 - 1.0d) + (n4cVar4.b * 2.0f))) / (f7 * 2.0f);
                n4cVar3.b = f9;
                n4cVar3.d = f9 + (f / f7);
                float f10 = ((float) ((f8 - 1.0d) + (n4cVar4.e * 2.0f))) / (2.0f * f8);
                n4cVar3.e = f10;
                n4cVar3.c = f10 + (f2 / f8);
            }
            MediaInfo mediaInfo2 = this.s;
            int i5 = mediaInfo2.e;
            int i6 = mediaInfo2.c;
            if (i5 != i6) {
                float g = w6c.g(i6 / i5);
                n4c n4cVar5 = this.g;
                n4cVar5.c *= g;
                n4cVar5.e *= g;
            }
            MediaInfo mediaInfo3 = this.s;
            int i7 = mediaInfo3.d;
            int i8 = mediaInfo3.b;
            if (i7 != i8) {
                float g2 = w6c.g(i8 / i7);
                n4c n4cVar6 = this.g;
                n4cVar6.b *= g2;
                n4cVar6.d *= g2;
            }
        }
    }

    public final void X(String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
            if (this.D != null) {
                i = 3;
            } else if (this.M) {
                i = 1;
            } else if (z) {
                i = 2;
            } else {
                i = 0;
            }
            if (i != this.b) {
                this.b = i;
                Z(str);
            }
        }
    }

    public final void c(n6c n6cVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, n6cVar, bitmap) == null) {
            if (this.J != -1) {
                GLES20.glActiveTexture(this.j.length + 33984);
                GLES20.glBindTexture(3553, this.J);
                if (this.K != bitmap.hashCode()) {
                    this.K = bitmap.hashCode();
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    return;
                }
                return;
            }
            this.J = w6c.e(this.a);
            GLES20.glActiveTexture(this.j.length + 33984);
            GLES20.glBindTexture(3553, this.J);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            n6cVar.n(this.j.length);
        }
    }

    public void n(MediaSample mediaSample, ByteBuffer[] byteBufferArr) {
        boolean z;
        n4c n4cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048612, this, mediaSample, byteBufferArr) != null) || !d(mediaSample)) {
            return;
        }
        int i = this.b;
        if (i == 0 || i == 2) {
            if (this.B && (((n4cVar = this.g) != null && n4cVar.a) || mediaSample.H)) {
                z = true;
            } else {
                z = false;
            }
            X("draw", z);
        }
        GLES20.glViewport(0, 0, this.m, this.n);
        int i2 = mediaSample.i.a;
        if (i2 == 8) {
            p6c p6cVar = v()[3];
            if (this.b == 3 && (p6cVar instanceof n6c)) {
                r(p6cVar, mediaSample.l, this.i);
            } else {
                u(p6cVar, this.i);
            }
        } else {
            s(y(i2), mediaSample, byteBufferArr);
        }
        this.v = mediaSample.i.a;
        this.A = mediaSample.H;
        this.C = mediaSample.l;
    }

    public final void u(p6c p6cVar, int i) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048619, this, p6cVar, i) == null) {
            if (this.x) {
                MediaInfo mediaInfo = this.s;
                p6cVar.f(mediaInfo.d, mediaInfo.e);
                this.x = false;
            }
            MediaInfo mediaInfo2 = this.s;
            int i2 = mediaInfo2.b;
            float f2 = 1.0f;
            if (i2 % 16 == 0) {
                f = 1.0f;
            } else {
                f = i2 / mediaInfo2.d;
            }
            MediaInfo mediaInfo3 = this.s;
            int i3 = mediaInfo3.c;
            if (i3 % 16 != 0) {
                f2 = i3 / mediaInfo3.e;
            }
            p6cVar.e(f, f2);
            z();
            GLES20.glClear(16384);
            p6cVar.g(this.k[0]);
            p6cVar.h(this.t);
            p6cVar.i(this.g);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, i);
            w6c.c("glBindTexture()", this.a);
            p6cVar.c();
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, 0);
            w6c.c("glBindTexture()", this.a);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.K = 0;
            Bitmap bitmap = this.E;
            if (bitmap != null) {
                bitmap.recycle();
                this.E = null;
            }
            Bitmap bitmap2 = this.F;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.F = null;
            }
            this.G = null;
            this.H = null;
            if (this.D == null) {
                return;
            }
            this.D = null;
            X("clearEffectParam", false);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int[] iArr = this.k;
            GLES20.glGenBuffers(iArr.length, iArr, 0);
            int i = 0;
            while (true) {
                int[] iArr2 = this.k;
                if (i < iArr2.length) {
                    GLES20.glBindBuffer(34962, iArr2[i]);
                    GLES20.glBufferData(34962, 64, this.l[i], 35044);
                    w6c.c("glBufferData()", this.a);
                    i++;
                } else {
                    GLES20.glBindBuffer(34962, 0);
                    return;
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || this.f != null) {
            return;
        }
        this.f = new n6c[4];
        int i = 0;
        while (true) {
            n6c[] n6cVarArr = this.f;
            if (i < n6cVarArr.length) {
                n6cVarArr[i] = new n6c(this.a);
                i++;
            } else {
                try {
                    n6cVarArr[0].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;\nprecision mediump int;\n\nvarying vec2 v_texCoord;\nuniform sampler2D u_texRGB;\n\nuniform vec4 bgRectRGB;\nuniform vec4 bgRectA;\n\n#define MAX_TEXT_MARSKS_COUNT 20\n\nuniform sampler2D srcImage;\nuniform int maskCount;\nuniform vec4 srcRgbRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskFrameRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskAlphaRects[MAX_TEXT_MARSKS_COUNT];\n\nuniform vec2 rectOffset;\nuniform int isFontFill;\nuniform vec4 fontColor;\nuniform int maskTypes[MAX_TEXT_MARSKS_COUNT];\n\nvec4 mainImage(vec2 uv) {\n    vec2 bgCoordRGB = bgRectRGB.xy * rectOffset.xy + uv * bgRectRGB.zw;\n    vec4 bgRGB = texture2D(u_texRGB, bgCoordRGB);\n    vec2 bgCoordA = bgRectA.xy * rectOffset.xy + uv * bgRectA.zw;\n    vec4 bgA = texture2D(u_texRGB, bgCoordA);\n    vec4 bgColor = vec4(bgRGB.rgb, bgA.r);\n\n    vec4 color = bgColor;\n    for (int i = 0; i < maskCount; ++i) {\n        vec4 maskFrameRect = vec4(maskFrameRects[i].xy*rectOffset.xy, maskFrameRects[i].zw);\n\n        if (uv.x >= maskFrameRect.x \n            && uv.x < maskFrameRect.x + maskFrameRect.z \n            && uv.y >= maskFrameRect.y \n            && uv.y < maskFrameRect.y + maskFrameRect.w) {\n            vec4 maskAlphaRect = maskAlphaRects[i];\n            vec4 srcRgbRect = srcRgbRects[i];\n\n            vec2 maskPos = (uv - maskFrameRect.xy) / maskFrameRect.zw;\n\n            vec2 srcCoordRGB = srcRgbRect.xy + maskPos * srcRgbRect.zw;\n            vec4 srcRGBA = texture2D(srcImage, srcCoordRGB);\n\n            float type = float(maskTypes[i]) + 0.5;\n            float isFill = step(type, float(isFontFill));\n            srcRGBA = isFill * vec4(fontColor.r, fontColor.g, fontColor.b, srcRGBA.a) \n                        + (1.0 - isFill) * srcRGBA;\n\n            vec2 srcCoordA = maskAlphaRect.xy * rectOffset.xy + maskPos * maskAlphaRect.zw;\n            float alpha = texture2D(u_texRGB, srcCoordA).r;\n            alpha = alpha * srcRGBA.a;\n\n            color = vec4(mix(color.r, srcRGBA.r, alpha), \n                         mix(color.g, srcRGBA.g, alpha), \n                         mix(color.b, srcRGBA.b, alpha), \n                         mix(color.a, srcRGBA.a, alpha));\n        }\n    }\n    return color;\n}\n\nvoid main() {\n    vec4 color = mainImage(v_texCoord);\n    gl_FragColor = color;\n}", 4, this.w);
                    this.f[1].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;\nprecision mediump int;\n\nvarying vec2 v_texCoord;\nuniform sampler2D u_texY;\nuniform sampler2D u_texU;\nuniform sampler2D u_texV;\nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0);\n\nuniform vec4 bgRectRGB;\nuniform vec4 bgRectA;\n\n#define MAX_TEXT_MARSKS_COUNT 20\n\nuniform sampler2D srcImage;\nuniform int maskCount;\nuniform vec4 srcRgbRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskFrameRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskAlphaRects[MAX_TEXT_MARSKS_COUNT];\n\nuniform vec2 rectOffset;\nuniform int isFontFill;\nuniform vec4 fontColor;\nuniform int maskTypes[MAX_TEXT_MARSKS_COUNT];\n\nvec3 yuv2Rgb(vec2 coord) { \n    vec3 rgb, yuv;\n    yuv.x = texture2D(u_texY, coord).r - 0.0625;\n    yuv.y = texture2D(u_texU, coord).r - 0.5;\n    yuv.z = texture2D(u_texV, coord).r - 0.5;\n    rgb = op * yuv;\n    rgb.r = clamp(rgb.r, 0.0, 1.0);\n    rgb.g = clamp(rgb.g, 0.0, 1.0);\n    rgb.b = clamp(rgb.b, 0.0, 1.0);\n    return rgb;\n}\n\nvec4 mainImage(vec2 uv) {\n    vec2 bgCoordRGB = bgRectRGB.xy * rectOffset.xy + uv * bgRectRGB.zw;\n    vec3 bgRGB = yuv2Rgb(bgCoordRGB);\n    vec2 bgCoordA = bgRectA.xy * rectOffset.xy + uv * bgRectA.zw;\n    vec3 bgA = yuv2Rgb(bgCoordA);\n    vec4 bgColor = vec4(bgRGB, bgA.r);\n\n    vec4 color = bgColor;\n    for (int i = 0; i < maskCount; ++i) {\n        vec4 maskFrameRect = vec4(maskFrameRects[i].xy*rectOffset.xy, maskFrameRects[i].zw);\n\n        if (uv.x >= maskFrameRect.x \n            && uv.x < maskFrameRect.x + maskFrameRect.z \n            && uv.y >= maskFrameRect.y \n            && uv.y < maskFrameRect.y + maskFrameRect.w) {\n            vec4 maskAlphaRect = maskAlphaRects[i];\n            vec4 srcRgbRect = srcRgbRects[i];\n\n            vec2 maskPos = (uv - maskFrameRect.xy) / maskFrameRect.zw;\n\n            vec2 srcCoordRGB = srcRgbRect.xy + maskPos * srcRgbRect.zw;\n            vec4 srcRGBA = texture2D(srcImage, srcCoordRGB);\n\n            float type = float(maskTypes[i]) + 0.5;\n            float isFill = step(type, float(isFontFill));\n            srcRGBA = isFill * vec4(fontColor.r, fontColor.g, fontColor.b, srcRGBA.a) \n                        + (1.0 - isFill) * srcRGBA;\n\n            vec2 srcCoordA = maskAlphaRect.xy * rectOffset.xy + maskPos * maskAlphaRect.zw;\n            float alpha = yuv2Rgb(srcCoordA).r;\n            alpha = alpha * srcRGBA.a;\n\n            color = vec4(mix(color.r, srcRGBA.r, alpha), \n                         mix(color.g, srcRGBA.g, alpha), \n                         mix(color.b, srcRGBA.b, alpha), \n                         mix(color.a, srcRGBA.a, alpha));\n        }\n    }\n    return color;\n}\n\nvoid main() {\n    vec4 color = mainImage(v_texCoord);\n    gl_FragColor = color;\n}", 2, this.w);
                    this.f[2].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;\nprecision mediump int;\n\nvarying vec2 v_texCoord;\nuniform sampler2D u_texY;\nuniform sampler2D u_texUV;\nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0);\n\nuniform vec4 bgRectRGB;\nuniform vec4 bgRectA;\n\n#define MAX_TEXT_MARSKS_COUNT 20\n\nuniform sampler2D srcImage;\nuniform int maskCount;\nuniform vec4 srcRgbRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskFrameRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskAlphaRects[MAX_TEXT_MARSKS_COUNT];\n\nuniform vec2 rectOffset;\nuniform int isFontFill;\nuniform vec4 fontColor;\nuniform int maskTypes[MAX_TEXT_MARSKS_COUNT];\n\nvec3 NV12Rgb(vec2 coord) {\n    vec3 rgb, yuv;\n    yuv.x = texture2D(u_texY, coord).r - 0.0625;\n    yuv.yz = texture2D(u_texUV, coord).ra - vec2(0.5, 0.5);\n    rgb = op * yuv;\n    rgb.r = clamp(rgb.r, 0.0, 1.0);\n    rgb.g = clamp(rgb.g, 0.0, 1.0);\n    rgb.b = clamp(rgb.b, 0.0, 1.0);\n    return rgb;\n}\n\nvec4 mainImage(vec2 uv) {\n    vec2 bgCoordRGB = bgRectRGB.xy * rectOffset.xy + uv * bgRectRGB.zw;\n    vec3 bgRGB = NV12Rgb(bgCoordRGB);\n    vec2 bgCoordA = bgRectA.xy * rectOffset.xy + uv * bgRectA.zw;\n    vec3 bgA = NV12Rgb(bgCoordA);\n    vec4 bgColor = vec4(bgRGB, bgA.r);\n\n    vec4 color = bgColor;\n    for (int i = 0; i < maskCount; ++i) {\n        vec4 maskFrameRect = vec4(maskFrameRects[i].xy*rectOffset.xy, maskFrameRects[i].zw);\n\n        if (uv.x >= maskFrameRect.x \n            && uv.x < maskFrameRect.x + maskFrameRect.z \n            && uv.y >= maskFrameRect.y \n            && uv.y < maskFrameRect.y + maskFrameRect.w) {\n            vec4 maskAlphaRect = maskAlphaRects[i];\n            vec4 srcRgbRect = srcRgbRects[i];\n\n            vec2 maskPos = (uv - maskFrameRect.xy) / maskFrameRect.zw;\n\n            vec2 srcCoordRGB = srcRgbRect.xy + maskPos * srcRgbRect.zw;\n            vec4 srcRGBA = texture2D(srcImage, srcCoordRGB);\n\n            float type = float(maskTypes[i]) + 0.5;\n            float isFill = step(type, float(isFontFill));\n            srcRGBA = isFill * vec4(fontColor.r, fontColor.g, fontColor.b, srcRGBA.a) \n                        + (1.0 - isFill) * srcRGBA;\n\n            vec2 srcCoordA = maskAlphaRect.xy * rectOffset.xy + maskPos * maskAlphaRect.zw;\n            float alpha = NV12Rgb(srcCoordA).r;\n            alpha = alpha * srcRGBA.a;\n\n            color = vec4(mix(color.r, srcRGBA.r, alpha), \n                         mix(color.g, srcRGBA.g, alpha), \n                         mix(color.b, srcRGBA.b, alpha), \n                         mix(color.a, srcRGBA.a, alpha));\n        }\n    }\n    return color;\n}\n\nvoid main() {\n    vec4 color = mainImage(v_texCoord);\n    gl_FragColor = color;\n}", 3, this.w);
                    this.f[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nprecision mediump int;\n\nvarying vec2 v_texCoord;\nuniform samplerExternalOES u_texRGB;\n\nuniform vec4 bgRectRGB;\nuniform vec4 bgRectA;\n\n#define MAX_TEXT_MARSKS_COUNT 20\n\nuniform sampler2D srcImage;\nuniform int maskCount;\nuniform vec4 srcRgbRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskFrameRects[MAX_TEXT_MARSKS_COUNT];\nuniform vec4 maskAlphaRects[MAX_TEXT_MARSKS_COUNT];\n\nuniform vec2 rectOffset;\nuniform int isFontFill;\nuniform vec4 fontColor;\nuniform int maskTypes[MAX_TEXT_MARSKS_COUNT];\n\nvec4 mainImage(vec2 uv) {\n    vec2 bgCoordRGB = bgRectRGB.xy * rectOffset.xy + uv * bgRectRGB.zw;\n    vec4 bgRGB = texture2D(u_texRGB, bgCoordRGB);\n    vec2 bgCoordA = bgRectA.xy * rectOffset.xy + uv * bgRectA.zw;\n    vec4 bgA = texture2D(u_texRGB, bgCoordA);\n    vec4 bgColor = vec4(bgRGB.rgb, bgA.r);\n\n    vec4 color = bgColor;\n    for (int i = 0; i < maskCount; ++i) {\n        vec4 maskFrameRect = vec4(maskFrameRects[i].xy*rectOffset.xy, maskFrameRects[i].zw);\n\n        if (uv.x >= maskFrameRect.x \n            && uv.x < maskFrameRect.x + maskFrameRect.z \n            && uv.y >= maskFrameRect.y \n            && uv.y < maskFrameRect.y + maskFrameRect.w) {\n            vec4 maskAlphaRect = maskAlphaRects[i];\n            vec4 srcRgbRect = srcRgbRects[i];\n\n            vec2 maskPos = (uv - maskFrameRect.xy) / maskFrameRect.zw;\n\n            vec2 srcCoordRGB = srcRgbRect.xy + maskPos * srcRgbRect.zw;\n            vec4 srcRGBA = texture2D(srcImage, srcCoordRGB);\n\n            float type = float(maskTypes[i]) + 0.5;\n            float isFill = step(type, float(isFontFill));\n            srcRGBA = isFill * vec4(fontColor.r, fontColor.g, fontColor.b, srcRGBA.a) \n                        + (1.0 - isFill) * srcRGBA;\n\n            vec2 srcCoordA = maskAlphaRect.xy * rectOffset.xy + maskPos * maskAlphaRect.zw;\n            float alpha = texture2D(u_texRGB, srcCoordA).r;\n            alpha = alpha * srcRGBA.a;\n\n            color = vec4(mix(color.r, srcRGBA.r, alpha), \n                         mix(color.g, srcRGBA.g, alpha), \n                         mix(color.b, srcRGBA.b, alpha), \n                         mix(color.a, srcRGBA.a, alpha));\n        }\n    }\n    return color;\n}\n\nvoid main() {\n    vec4 color = mainImage(v_texCoord);\n    gl_FragColor = color;\n}", 8, this.w);
                    return;
                } catch (Exception unused) {
                    this.f = null;
                    return;
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || this.e != null) {
            return;
        }
        this.e = new o6c[4];
        int i = 0;
        while (true) {
            o6c[] o6cVarArr = this.e;
            if (i < o6cVarArr.length) {
                o6cVarArr[i] = new o6c(this.a);
                i++;
            } else {
                try {
                    o6cVarArr[0].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;\nprecision mediump int;\nvarying vec2 v_texCoord;\nuniform sampler2D u_texRGB;  \nuniform vec4 u_frontArea;\nvec4 pipEffect(vec2 coord) { \n    vec4 fragColor; \n    vec2 uvBack = vec2(coord.x *0.5,coord.y); \n    vec2 uvFront = coord ; \n    uvFront.x = uvFront.x - u_frontArea.x; \n    uvFront.x = uvFront.x / (u_frontArea.y - u_frontArea.x);\n    uvFront.x = 0.5 * uvFront.x + 0.5; \n    uvFront.y = u_frontArea.z - u_frontArea.w - (u_frontArea.z -uvFront.y); \n    uvFront.y = uvFront.y / (u_frontArea.z - u_frontArea.w); \n    vec4 bgTexColor = texture2D(u_texRGB,uvBack); \n    vec4 frontTexColor = texture2D(u_texRGB,uvFront); \n    if (coord.x < u_frontArea.x || coord.x > u_frontArea.y || coord.y > u_frontArea.z        || coord.y < u_frontArea.w) { \n       fragColor = bgTexColor; \n    } else { \n       fragColor = frontTexColor; \n    } \n    return fragColor; \n} \nvoid main(void) {\n    vec4 color  =  pipEffect(v_texCoord); \n    gl_FragColor = color; \n}\n", 4, this.w);
                    this.e[1].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;  \nprecision mediump int;    \nvarying vec2 v_texCoord;  \nuniform sampler2D u_texY; \nuniform sampler2D u_texU; \nuniform sampler2D u_texV; \nuniform vec4 u_frontArea;\nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvec3 yuv2Rgb(vec2 coord) { \n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, coord).r - 0.0625; \n   yuv.y = texture2D(u_texU, coord).r - 0.5;    \n   yuv.z = texture2D(u_texV, coord).r - 0.5;    \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   return rgb; \n   } \nvec3 pipEffect(vec2 coord) { \n    vec3 fragColor; \n    vec2 uvBack = vec2(coord.x *0.5,coord.y); \n    vec2 uvFront = coord ; \n    uvFront.x = uvFront.x - u_frontArea.x; \n    uvFront.x = uvFront.x / (u_frontArea.y - u_frontArea.x);\n    uvFront.x = 0.5 * uvFront.x + 0.5; \n    uvFront.y = u_frontArea.z - u_frontArea.w - (u_frontArea.z -uvFront.y); \n    uvFront.y = uvFront.y / (u_frontArea.z - u_frontArea.w); \n    vec3 bgTexColor = yuv2Rgb(uvBack); \n    vec3 frontTexColor = yuv2Rgb(uvFront); \n    if (coord.x < u_frontArea.x || coord.x > u_frontArea.y || coord.y > u_frontArea.z        || coord.y < u_frontArea.w) { \n       fragColor = bgTexColor; \n    } else { \n       fragColor = frontTexColor; \n    } \n    return fragColor; \n} \nvoid main(void)   \n{                 \n   vec3 color = pipEffect(v_texCoord); \n   gl_FragColor = vec4(color, 1.0);  \n}                                  \n", 2, this.w);
                    this.e[2].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;   \nprecision mediump int;     \nvarying vec2 v_texCoord;   \nuniform sampler2D u_texY;  \nuniform sampler2D u_texUV; \nuniform vec4 u_frontArea;\nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvec3 NV12Rgb(vec2 coord) { \n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, coord).r - 0.0625;            \n   yuv.yz = texture2D(u_texUV, coord).ra - vec2(0.5, 0.5); \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   return rgb; \n} \nvec3 pipEffect(vec2 coord) { \n    vec3 fragColor; \n    vec2 uvBack = vec2(coord.x *0.5,coord.y); \n    vec2 uvFront = coord ; \n    uvFront.x = uvFront.x - u_frontArea.x; \n    uvFront.x = uvFront.x / (u_frontArea.y - u_frontArea.x);\n    uvFront.x = 0.5 * uvFront.x + 0.5; \n    uvFront.y = u_frontArea.z - u_frontArea.w - (u_frontArea.z -uvFront.y); \n    uvFront.y = uvFront.y / (u_frontArea.z - u_frontArea.w); \n    vec3 bgTexColor = NV12Rgb(uvBack); \n    vec3 frontTexColor = NV12Rgb(uvFront); \n    if (coord.x < u_frontArea.x || coord.x > u_frontArea.y || coord.y > u_frontArea.z        || coord.y < u_frontArea.w) { \n       fragColor = bgTexColor; \n    } else { \n       fragColor = frontTexColor; \n    } \n    return fragColor; \n} \nvoid main(void)   \n{                 \n   vec3 color = pipEffect(v_texCoord); \n   gl_FragColor = vec4(color, 1.0);  \n}                                  \n", 3, this.w);
                    this.e[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nprecision mediump int;\nvarying vec2 v_texCoord;\nuniform samplerExternalOES u_texRGB;\nuniform vec4 u_frontArea;\nvec4 pipEffect(vec2 coord) { \n    vec4 fragColor; \n    vec2 uvBack = vec2(coord.x *0.5,coord.y); \n    vec2 uvFront = coord ; \n    uvFront.x = uvFront.x - u_frontArea.x; \n    uvFront.x = uvFront.x / (u_frontArea.y - u_frontArea.x);\n    uvFront.x = 0.5 * uvFront.x + 0.5; \n    uvFront.y = u_frontArea.z - u_frontArea.w - (u_frontArea.z -uvFront.y); \n    uvFront.y = uvFront.y / (u_frontArea.z - u_frontArea.w); \n    vec4 bgTexColor = texture2D(u_texRGB,uvBack); \n    vec4 frontTexColor = texture2D(u_texRGB,uvFront); \n    if (coord.x < u_frontArea.x || coord.x > u_frontArea.y || coord.y > u_frontArea.z        || coord.y < u_frontArea.w) { \n       fragColor = bgTexColor; \n    } else { \n       fragColor = frontTexColor; \n    } \n    return fragColor; \n} \nvoid main(void) {\n    vec4 color  =  pipEffect(v_texCoord); \n    gl_FragColor = color; \n}\n", 8, this.w);
                    return;
                } catch (Exception unused) {
                    this.e = null;
                    return;
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            int[] iArr = this.j;
            GLES20.glGenTextures(iArr.length, iArr, 0);
            for (int i = 0; i < this.j.length; i++) {
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, this.j[i]);
                float w = w();
                GLES20.glTexParameterf(3553, 10240, w);
                GLES20.glTexParameterf(3553, 10241, w);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            GLES20.glBindTexture(3553, 0);
            Q();
        }
    }

    public final void k() {
        p6c[] p6cVarArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.d != null) {
            return;
        }
        this.d = new p6c[4];
        int i = 0;
        while (true) {
            p6cVarArr = this.d;
            if (i < p6cVarArr.length) {
                p6cVarArr[i] = new p6c(this.a);
                i++;
            } else {
                try {
                    break;
                } catch (Exception unused) {
                    this.d = null;
                    return;
                }
            }
        }
        p6cVarArr[0].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;     \nprecision mediump int;       \nvarying vec2 v_texCoord;     \nuniform sampler2D u_texRGB;  \nvoid main(void)              \n{\n   vec2 rgbCoord = vec2(v_texCoord.x * 0.5, v_texCoord.y);\n   vec2 alphaCoord = vec2(rgbCoord.x, rgbCoord.y);\n   vec3 rgb = texture2D(u_texRGB, rgbCoord).rgb;\n   vec3 alpha = texture2D(u_texRGB, alphaCoord).rgb; \n   gl_FragColor = vec4(rgb, alpha.r);     \n}\n", 4, this.w);
        this.d[1].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;  \nprecision mediump int;    \nvarying vec2 v_texCoord;  \nuniform sampler2D u_texY; \nuniform sampler2D u_texU; \nuniform sampler2D u_texV; \nuniform float u_widthDelta; \nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvec3 getSampleColor(vec2 coord) {\n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, coord).r - 0.0625; \n   yuv.y = texture2D(u_texU, coord).r - 0.5;    \n   yuv.z = texture2D(u_texV, coord).r - 0.5;    \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0);\n   return rgb;\n}\nvoid main(void)   \n{ \n   vec2 rgbCoord = vec2(v_texCoord.x * 0.5, v_texCoord.y);\n   vec2 alphaCoord = vec2(rgbCoord.x + u_widthDelta, rgbCoord.y);\n   vec3 rgb = getSampleColor(rgbCoord);\n   vec3 alpha = getSampleColor(alphaCoord);\n   gl_FragColor = vec4(rgb, alpha.r);  \n}\n", 2, this.w);
        this.d[2].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "precision mediump float;   \nprecision mediump int;     \nvarying vec2 v_texCoord;   \nuniform sampler2D u_texY;  \nuniform sampler2D u_texUV; \nuniform float u_widthDelta; \nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0);\nvec3 getSampleColor(vec2 coord) {\n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, coord).r - 0.0625;            \n   yuv.yz = texture2D(u_texUV, coord).ra - vec2(0.5, 0.5); \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   return rgb;\n}\nvoid main(void)   \n{                 \n   vec2 rgbCoord = vec2(v_texCoord.x * 0.5, v_texCoord.y);       \n   vec2 alphaCoord = vec2(rgbCoord.x + u_widthDelta, rgbCoord.y);\n   vec3 rgb = getSampleColor(rgbCoord);\n   vec3 alpha = getSampleColor(alphaCoord);\n   gl_FragColor = vec4(rgb, alpha.r); \n} \n", 3, this.w);
        if (this.w == 0) {
            this.d[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nprecision mediump int;\nvarying vec2 v_texCoord;\nuniform vec2 rectOffset;\nuniform samplerExternalOES u_texRGB;\nvoid main(void) {\n    vec2 rgbCoord = vec2(v_texCoord.x * rectOffset.x * 0.5, v_texCoord.y * rectOffset.y);\n    vec2 alphaCoord = vec2(rgbCoord.x + rectOffset.x * 0.5, rgbCoord.y);\n    vec3 rgb = texture2D(u_texRGB, rgbCoord).rgb;\n    vec3 alpha = texture2D(u_texRGB, alphaCoord).rgb;\n    gl_FragColor = vec4(rgb, alpha.r);\n}\n", 8, this.w);
        } else {
            this.d[3].a("precision mediump float;    \nprecision mediump int;      \nattribute vec2 a_position;  \nattribute vec2 a_texCoord;  \nvarying vec2 v_texCoord;    \nuniform mat4 u_modelView;   \nuniform mat4 u_projection;  \nvoid main()                 \n{                           \n   vec4 value = vec4(a_position, 0.0, 1.0); \n   gl_Position = u_modelView * value;       \n   v_texCoord = a_texCoord; \n}                           \n", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nprecision highp int;\nvarying vec2 v_texCoord;\nuniform vec2 rectOffset;\nuniform samplerExternalOES u_texRGB;\nuniform vec2 u_textureSize;\nuniform int u_samplerFilter;\nvec3 cubicHermite(vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n    float t2 = t * t;\n    float t3 = t * t * t;\n    vec3 a = -A / 2.0 + (3.0 * B) / 2.0 - (3.0 * C) / 2.0 + D / 2.0;\n    vec3 b = A - (5.0 * B) / 2.0 + 2.0 * C - D / 2.0;\n    vec3 c = -A / 2.0 + C / 2.0;\n    vec3 d = B;\n    vec3 rgb = a * t3 + b * t2 + c * t + d;\n    return rgb;\n}\nvec3 bicubic(vec2 P) {\n    vec2 c_onePixel = (1.0 / u_textureSize);\n    vec2 c_twoPixels = (2.0 / u_textureSize);\n    vec2 pixel = P * u_textureSize + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel) / u_textureSize - vec2(c_onePixel / 2.0);\n    vec3 C01 = texture2D(u_texRGB, pixel + vec2(-c_onePixel.x, 0.0)).rgb;\n    vec3 C11 = texture2D(u_texRGB, pixel + vec2(0.0, 0.0)).rgb;\n    vec3 C21 = texture2D(u_texRGB, pixel + vec2(c_onePixel.x, 0.0)).rgb;\n    vec3 C31 = texture2D(u_texRGB, pixel + vec2(c_twoPixels.x, 0.0)).rgb;\n    vec3 C02 = texture2D(u_texRGB, pixel + vec2(-c_onePixel.x, c_onePixel.y)).rgb;\n    vec3 C12 = texture2D(u_texRGB, pixel + vec2(0.0, c_onePixel.y)).rgb;\n    vec3 C22 = texture2D(u_texRGB, pixel + vec2(c_onePixel.x, c_onePixel.y)).rgb;\n    vec3 C32 = texture2D(u_texRGB, pixel + vec2(c_twoPixels.x, c_onePixel.y)).rgb;\n    vec3 CP1X = cubicHermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubicHermite(C02, C12, C22, C32, frac.x);\n    return mix(CP1X, CP2X, frac.y);\n}\nvoid main(void) {\n    vec2 rgbCoord = vec2(v_texCoord.x * rectOffset.x * 0.5, v_texCoord.y * rectOffset.y);\n    vec2 alphaCoord = vec2(rgbCoord.x + rectOffset.x * 0.5, rgbCoord.y);\n    if (u_samplerFilter == 0) {\n        vec3 rgb = texture2D(u_texRGB, rgbCoord).rgb;\n        vec3 alpha = texture2D(u_texRGB, alphaCoord).rgb;\n        gl_FragColor = vec4(rgb, alpha.r);\n    } else if (u_samplerFilter == 1) {\n        vec3 rgb = bicubic(rgbCoord).rgb;\n        vec3 alpha = texture2D(u_texRGB, alphaCoord).rgb;\n        gl_FragColor = vec4(rgb, alpha.r);\n    } else {\n        vec3 rgb = bicubic(rgbCoord).rgb;\n        vec3 alpha = bicubic(alphaCoord).rgb;\n        gl_FragColor = vec4(rgb, alpha.r);\n    }\n}\n", 8, this.w);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            float[] fArr = t6c.b;
            float[] fArr2 = this.t;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            int i = this.q;
            if (i == 1) {
                android.opengl.Matrix.rotateM(this.t, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            } else if (i == 2) {
                android.opengl.Matrix.rotateM(this.t, 0, 180.0f, 0.0f, 0.0f, 1.0f);
            } else if (i == 3) {
                android.opengl.Matrix.rotateM(this.t, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            }
            int i2 = this.p;
            if (i2 == 1) {
                android.opengl.Matrix.rotateM(this.t, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            } else if (i2 == 2) {
                android.opengl.Matrix.rotateM(this.t, 0, 180.0f, 0.0f, 0.0f, 1.0f);
            } else if (i2 == 3) {
                android.opengl.Matrix.rotateM(this.t, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            }
            Z("setRotateMode()");
        }
    }

    public final void p(n6c n6cVar, long j, boolean z) {
        float f;
        Iterator<EffectObject> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{n6cVar, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            n6cVar.p(this.D.a);
            float f2 = 1.0f;
            if (z && this.s.b % 16 == 0) {
                f = 1.0f;
            } else {
                f = this.D.a.a / this.s.d;
            }
            if (!z || this.s.c % 16 != 0) {
                f2 = this.D.a.b / this.s.e;
            }
            n6cVar.e(f, f2);
            int ceil = (int) Math.ceil(((float) (this.D.a.e * j)) / 1000.0f);
            int i = this.L;
            char c = 1;
            char c2 = 0;
            char c3 = 2;
            char c4 = 3;
            if (i < 50) {
                TLog.h("[renderFramePts]", String.format("cur play Frame count: %d, index: %d, pts: %d", Integer.valueOf(i), Integer.valueOf(ceil), Long.valueOf(j)));
            }
            int i2 = this.L;
            if (ceil != i2) {
                TLog.h("[diffIndexLog]", String.format("diff frame, frame count: %d, index: %d, pts: %d", Integer.valueOf(i2), Integer.valueOf(ceil), Long.valueOf(j)));
            }
            Bitmap bitmap = this.E;
            if (bitmap != null && !bitmap.isRecycled()) {
                c(n6cVar, this.E);
                EffectFrame a2 = this.D.a(j);
                if (a2 != null) {
                    int i3 = 4;
                    int size = a2.a.size() * 4;
                    float[] fArr = new float[size];
                    float[] fArr2 = new float[size];
                    float[] fArr3 = new float[size];
                    Iterator<EffectObject> it2 = a2.a.iterator();
                    int i4 = 0;
                    while (it2.hasNext()) {
                        EffectObject next = it2.next();
                        float[] fArr4 = this.G.get(Integer.valueOf(next.a));
                        if (fArr4 != null) {
                            float[] fArr5 = new float[i3];
                            fArr5[c2] = fArr4[c2];
                            fArr5[c] = fArr4[c];
                            fArr5[c3] = fArr4[c3];
                            fArr5[c4] = fArr4[c4];
                            float[] fArr6 = new float[i3];
                            float[] fArr7 = next.b;
                            fArr6[c2] = fArr7[c2];
                            fArr6[c] = fArr7[c];
                            fArr6[c3] = fArr7[c3];
                            fArr6[c4] = fArr7[c4];
                            if (this.I.containsKey(Integer.valueOf(next.a)) && !this.I.get(Integer.valueOf(next.a)).equals("scaleFill")) {
                                float[] fArr8 = next.b;
                                if (fArr8[c3] != 0.0f && fArr8[c4] != 0.0f) {
                                    Rect rect = this.H.get(Integer.valueOf(next.a));
                                    float f3 = rect.right - rect.left;
                                    float f4 = rect.bottom - rect.top;
                                    EffectInfo effectInfo = this.D.a;
                                    float f5 = effectInfo.c;
                                    it = it2;
                                    float[] fArr9 = next.b;
                                    float f6 = f5 * fArr9[c3];
                                    float f7 = effectInfo.d * fArr9[3];
                                    float f8 = f3 / f4;
                                    float f9 = f6 / f7;
                                    if (this.I.get(Integer.valueOf(next.a)).equals("aspectFit")) {
                                        if (f8 - f9 > 1.0E-6d) {
                                            float[] fArr10 = next.b;
                                            fArr6[3] = (fArr10[3] * ((f6 * f4) / f3)) / f7;
                                            fArr6[1] = fArr10[1] + ((fArr10[3] - fArr6[3]) / 2.0f);
                                        } else if (f9 - f8 > 1.0E-6d) {
                                            float[] fArr11 = next.b;
                                            fArr6[2] = (fArr11[2] * ((f7 * f3) / f4)) / f6;
                                            fArr6[0] = fArr11[0] + ((fArr11[2] - fArr6[2]) / 2.0f);
                                        }
                                    } else if (this.I.get(Integer.valueOf(next.a)).equals("aspectFill")) {
                                        if (f8 - f9 > 1.0E-6d) {
                                            fArr5[2] = (fArr4[2] * ((f4 * f6) / f7)) / f3;
                                            fArr5[0] = fArr4[0] + ((fArr4[2] - fArr5[2]) / 2.0f);
                                        } else if (f9 - f8 > 1.0E-6d) {
                                            fArr5[3] = (fArr4[3] * ((f3 * f7) / f6)) / f4;
                                            fArr5[1] = fArr4[1] + ((fArr4[3] - fArr5[3]) / 2.0f);
                                        }
                                    }
                                    int i5 = i4 * 4;
                                    System.arraycopy(fArr5, 0, fArr, i5, 4);
                                    System.arraycopy(fArr6, 0, fArr2, i5, 4);
                                    System.arraycopy(next.c, 0, fArr3, i5, 4);
                                    i4++;
                                    it2 = it;
                                    i3 = 4;
                                    c = 1;
                                    c2 = 0;
                                    c3 = 2;
                                    c4 = 3;
                                }
                            }
                            it = it2;
                            int i52 = i4 * 4;
                            System.arraycopy(fArr5, 0, fArr, i52, 4);
                            System.arraycopy(fArr6, 0, fArr2, i52, 4);
                            System.arraycopy(next.c, 0, fArr3, i52, 4);
                            i4++;
                            it2 = it;
                            i3 = 4;
                            c = 1;
                            c2 = 0;
                            c3 = 2;
                            c4 = 3;
                        }
                    }
                    if (i4 > 0) {
                        n6cVar.l(i4);
                        n6cVar.o(fArr, i4);
                        n6cVar.m(fArr2, i4);
                        n6cVar.k(fArr3, i4);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.F == null) {
                this.F = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            }
            c(n6cVar, this.F);
        }
    }

    public final void q(p6c p6cVar, MediaSample mediaSample, ByteBuffer[] byteBufferArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048615, this, p6cVar, mediaSample, byteBufferArr) == null) {
            n6c n6cVar = (n6c) p6cVar;
            z();
            GLES20.glClear(16384);
            n6cVar.g(this.k[0]);
            S(mediaSample, this.j, byteBufferArr, this.a);
            n6cVar.h(this.t);
            p(n6cVar, mediaSample.l, false);
            n6cVar.c();
            GLES20.glBindTexture(3553, 0);
        }
    }

    public final void r(p6c p6cVar, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{p6cVar, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            n6c n6cVar = (n6c) p6cVar;
            if (this.x) {
                MediaInfo mediaInfo = this.s;
                n6cVar.f(mediaInfo.d, mediaInfo.e);
                this.x = false;
            }
            z();
            GLES20.glClear(16384);
            p6cVar.g(this.k[0]);
            p6cVar.h(this.t);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, i);
            w6c.c("glBindTexture()", this.a);
            p(n6cVar, j, true);
            p6cVar.c();
            GLES20.glBindTexture(CyberRender.GL_TEXTURE_EXTERNAL_OES, 0);
            w6c.c("glBindTexture()", this.a);
        }
    }

    public final void s(p6c p6cVar, MediaSample mediaSample, ByteBuffer[] byteBufferArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, p6cVar, mediaSample, byteBufferArr) == null) {
            if (this.b == 3 && (p6cVar instanceof n6c)) {
                q(p6cVar, mediaSample, byteBufferArr);
                return;
            }
            if (this.y && this.b == 1) {
                MediaInfo mediaInfo = this.s;
                p6cVar.d((mediaInfo.b / mediaInfo.d) / 2.0f);
                this.y = false;
            }
            z();
            GLES20.glClear(16384);
            p6cVar.g(this.k[0]);
            S(mediaSample, this.j, byteBufferArr, this.a);
            p6cVar.h(this.t);
            p6cVar.i(this.g);
            p6cVar.c();
            GLES20.glBindTexture(3553, 0);
        }
    }

    public final Bitmap t(int i, int i2, float f, String str, String str2) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), str, str2})) == null) {
            if (str2 == null || str2.isEmpty()) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Rect rect = new Rect();
            Rect rect2 = new Rect(0, 0, i, i2);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAntiAlias(true);
            if (str.isEmpty()) {
                textPaint.setColor(-1);
            } else {
                textPaint.setColor(Color.parseColor(str));
            }
            if (Math.abs(f) < 0.01d) {
                float f2 = 0.8f;
                float f3 = i2;
                textPaint.setTextSize(f3 * 0.8f);
                while (f2 > 0.1f) {
                    textPaint.getTextBounds(str2, 0, str2.length(), rect);
                    if (rect.width() <= rect2.width()) {
                        break;
                    }
                    f2 -= 0.1f;
                    textPaint.setTextSize(f3 * f2);
                }
            } else {
                textPaint.setTextSize(f);
            }
            Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
            int centerY = (rect2.centerY() - (fontMetricsInt.top / 2)) - (fontMetricsInt.bottom / 2);
            if (((int) Math.ceil(textPaint.measureText(str2))) > rect2.width()) {
                int breakText = textPaint.breakText(str2, true, rect2.width() - textPaint.measureText("..."), null);
                str3 = str2.substring(0, breakText) + "...";
            } else {
                str3 = str2;
            }
            canvas.drawText(str3, rect2.centerX(), centerY, textPaint);
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
