package com.baidu.ugc.editvideo.sticker;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.faceunity.gles.GeneratedTexture;
import com.repackage.le0;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public float C;
    public float D;
    public float E;
    public int[] a;
    public int[] b;
    public MultiMediaData c;
    public int d;
    public int e;
    public float[] f;
    public float g;
    public float h;
    public GLViewPortLocation i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public MultiMediaData s;
    public MultiMediaData t;
    public MultiMediaData u;
    public PointF v;
    public PointF w;
    public PointF x;
    public String y;
    public String z;

    public a(MultiMediaData multiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {multiMediaData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new float[16];
        this.y = "left_top";
        this.z = "right_bottom";
        this.A = "left_bottom";
        this.a = new int[1];
        this.b = new int[1];
        this.E = 1.0f;
        this.c = multiMediaData;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PointF a(String str, PointF... pointFArr) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, pointFArr)) == null) {
            switch (str.hashCode()) {
                case -1568783182:
                    if (str.equals("right_top")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1514196637:
                    if (str.equals("left_bottom")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1699249582:
                    if (str.equals("right_bottom")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1718760733:
                    if (str.equals("left_top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            return c != 0 ? c != 1 ? c != 2 ? pointFArr[0] : pointFArr[3] : pointFArr[2] : pointFArr[1];
        }
        return (PointF) invokeLL.objValue;
    }

    private float[] a(float f, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.translateM(fArr, 0, f2, f3, 1.0f);
            Matrix.rotateM(fArr, 0, f % 360.0f, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr, 0, f4, f5, 0.0f);
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            float f = this.m;
            float f2 = this.E;
            this.g = f * f2;
            this.h = this.n * f2;
            float sin = (float) Math.sin(Math.toRadians(this.j));
            float cos = (float) Math.cos(Math.toRadians(this.j));
            float f3 = this.k;
            float f4 = this.g;
            float f5 = f3 - f4;
            float f6 = this.l;
            float f7 = this.h;
            float f8 = f6 + f7;
            float f9 = f6 - f7;
            float f10 = f4 + f3;
            PointF pointF = new PointF((((f5 - f3) * cos) - ((f9 - f6) * sin)) + f3, ((f5 - f3) * sin) + ((f9 - f6) * cos) + f6);
            PointF pointF2 = new PointF((((f5 - f3) * cos) - ((f8 - f6) * sin)) + f3, ((f5 - f3) * sin) + ((f8 - f6) * cos) + f6);
            PointF pointF3 = new PointF((((f10 - f3) * cos) - ((f9 - f6) * sin)) + f3, ((f10 - f3) * sin) + ((f9 - f6) * cos) + f6);
            PointF pointF4 = new PointF((((f10 - f3) * cos) - ((f8 - f6) * sin)) + f3, ((f10 - f3) * sin) + ((f8 - f6) * cos) + f6);
            this.v = a(this.y, pointF, pointF2, pointF3, pointF4);
            this.w = a(this.z, pointF, pointF2, pointF3, pointF4);
            this.x = a(this.A, pointF, pointF2, pointF3, pointF4);
            MultiMediaData multiMediaData = this.s;
            if (multiMediaData != null) {
                this.C = ((multiMediaData.width / 6.0f) * 1.0f) / this.o;
                this.D = ((multiMediaData.height / 6.0f) * 1.0f) / this.p;
            }
        }
    }

    public void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.E = f;
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.o = f;
            this.p = f2;
            this.q = f3;
            this.r = f4;
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.d = i;
            this.e = i2;
        }
    }

    public void a(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, multiMediaData, str) == null) {
            this.s = multiMediaData;
            this.y = str;
        }
    }

    public void a(FullFrameRect fullFrameRect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fullFrameRect) == null) {
            float[] fArr = new float[16];
            float[] fArr2 = this.f;
            float f = this.j;
            PointF pointF = this.x;
            Matrix.multiplyMM(fArr, 0, fArr2, 0, a(f, pointF.x, pointF.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.u.textureId, le0.b);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect.setVertexPoint(fArr);
        }
    }

    public void a(FullFrameRect fullFrameRect, MultiMediaData multiMediaData) {
        GLViewPortLocation gLViewPortLocation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, fullFrameRect, multiMediaData) == null) || multiMediaData == null || multiMediaData.textureId == 0 || (gLViewPortLocation = this.i) == null) {
            return;
        }
        float[] fArr = new float[16];
        float[] fArr2 = this.f;
        int i = gLViewPortLocation.width;
        int i2 = gLViewPortLocation.height;
        Matrix.multiplyMM(fArr, 0, fArr2, 0, a(0.0f, i / 2.0f, i2 / 2.0f, Math.min(i, i2), 5.0f), 0);
        fullFrameRect.setVertexPoint(fArr);
        fullFrameRect.drawFrame(multiMediaData.textureId, le0.b);
        float[] fArr3 = this.f;
        GLViewPortLocation gLViewPortLocation2 = this.i;
        int i3 = gLViewPortLocation2.width;
        int i4 = gLViewPortLocation2.height;
        Matrix.multiplyMM(fArr, 0, fArr3, 0, a(90.0f, i3 / 2.0f, i4 / 2.0f, Math.min(i3, i4), 5.0f), 0);
        fullFrameRect.setVertexPoint(fArr);
        fullFrameRect.drawFrame(multiMediaData.textureId, le0.b);
        Matrix.setIdentityM(fArr, 0);
        fullFrameRect.setVertexPoint(fArr);
    }

    public void a(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, fullFrameRect, fullFrameRect2) == null) {
            SurfaceTexture surfaceTexture = this.c.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.c.mtx);
            }
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            MultiMediaData multiMediaData = this.c;
            this.j = multiMediaData.rotation + multiMediaData.angle;
            int i = this.d;
            float f = i != 0 ? (this.i.width * 1.0f) / i : 1.0f;
            int round = Math.round(this.c.width * f) / 2;
            int round2 = Math.round(this.c.height * f) / 2;
            MultiMediaData multiMediaData2 = this.c;
            float f2 = multiMediaData2.x;
            float f3 = multiMediaData2.y;
            int i2 = this.d;
            if (i2 != 0) {
                f2 = (f2 / i2) * this.i.width;
            }
            int i3 = this.e;
            if (i3 != 0) {
                f3 = (this.c.y / i3) * this.i.height;
            }
            MultiMediaData multiMediaData3 = this.c;
            this.k = ((multiMediaData3.width / 2.0f) * f) + f2;
            this.l = (this.i.height - ((multiMediaData3.height / 2.0f) * f)) - f3;
            if (multiMediaData3.type == 0) {
                if (multiMediaData3.rotation == 0.0f) {
                    this.j += 180.0f;
                }
                round = -round;
            } else {
                float f4 = this.j;
                float f5 = multiMediaData3.rotation;
                this.j = f4 - f5;
                if (f5 == 90.0f || f5 == 270.0f) {
                    round2 = round;
                    round = round2;
                }
            }
            MultiMediaData multiMediaData4 = this.c;
            this.m = round * multiMediaData4.scaleX;
            this.n = round2 * multiMediaData4.scaleY;
            Matrix.multiplyMM(fArr, 0, this.f, 0, a(this.j, this.k, this.l, this.m, this.n), 0);
            FullFrameRect fullFrameRect3 = this.c.type == 0 ? fullFrameRect : fullFrameRect2;
            fullFrameRect3.setVertexPoint(fArr);
            MultiMediaData multiMediaData5 = this.c;
            fullFrameRect3.drawFrame(multiMediaData5.textureId, multiMediaData5.mtx);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect3.setVertexPoint(fArr);
            if (this.g == 0.0f || this.h == 0.0f || this.v == null || this.w == null) {
                e();
            }
        }
    }

    public void a(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gLViewPortLocation) == null) {
            this.i = gLViewPortLocation;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.B = z;
        }
    }

    public void a(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fArr) == null) {
            this.f = fArr;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean a(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.i == null) {
                return false;
            }
            float f3 = this.k;
            float f4 = this.g;
            int i = this.i.height;
            float f5 = this.l;
            float f6 = this.h;
            RectF rectF = new RectF(f3 - f4, (i - f5) - f6, f3 + f4, (i - f5) + f6);
            new android.graphics.Matrix().mapRect(rectF);
            float f7 = this.j;
            if (f7 % 360.0f == 0.0f) {
                return rectF.contains(f, f2);
            }
            float sin = (float) Math.sin(Math.toRadians(f7));
            float cos = (float) Math.cos(Math.toRadians(this.j));
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float f8 = centerX - f;
            float f9 = centerY - f2;
            return rectF.contains(((f8 * cos) - (f9 * sin)) + centerX, (f8 * sin) + (f9 * cos) + centerY);
        }
        return invokeCommon.booleanValue;
    }

    public MultiMediaData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (MultiMediaData) invokeV.objValue;
    }

    public void b(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, multiMediaData, str) == null) {
            this.t = multiMediaData;
            this.z = str;
        }
    }

    public void b(FullFrameRect fullFrameRect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, fullFrameRect) == null) && this.a[0] == 0) {
            this.b[0] = fullFrameRect.createTexture2DObject();
            GLViewPortLocation gLViewPortLocation = this.i;
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, gLViewPortLocation.width, gLViewPortLocation.height, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glGenFramebuffers(1, this.a, 0);
            GLES20.glBindFramebuffer(36160, this.a[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.b[0], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public void b(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, fullFrameRect, fullFrameRect2) == null) {
            e();
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, 0, this.f, 0, a(this.j, this.k, this.l, this.g, this.h), 0);
            fullFrameRect2.setVertexPoint(fArr);
            fullFrameRect2.drawFrame(fArr);
            float[] fArr2 = this.f;
            float f = this.j;
            PointF pointF = this.v;
            Matrix.multiplyMM(fArr, 0, fArr2, 0, a(f, pointF.x, pointF.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.s.textureId, le0.b);
            float[] fArr3 = this.f;
            float f2 = this.j;
            PointF pointF2 = this.w;
            Matrix.multiplyMM(fArr, 0, fArr3, 0, a(f2, pointF2.x, pointF2.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.t.textureId, le0.b);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect.setVertexPoint(fArr);
        }
    }

    public boolean b(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.i == null || this.w == null || this.t == null) {
                return false;
            }
            PointF pointF = this.w;
            float f3 = pointF.x;
            float f4 = this.C;
            int i = this.i.height;
            float f5 = pointF.y;
            float f6 = this.D;
            RectF rectF = new RectF(f3 - (f4 * 1.5f), (i - f5) + (f6 * 1.5f), f3 + (f4 * 1.5f), (i - f5) - (f6 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public PointF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.i == null) {
                return null;
            }
            return new PointF(this.k, this.i.height - this.l);
        }
        return (PointF) invokeV.objValue;
    }

    public void c(MultiMediaData multiMediaData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, multiMediaData, str) == null) {
            this.u = multiMediaData;
            this.A = str;
        }
    }

    public boolean c(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.i == null || this.v == null || this.s == null) {
                return false;
            }
            PointF pointF = this.v;
            float f3 = pointF.x;
            float f4 = this.C;
            int i = this.i.height;
            float f5 = pointF.y;
            float f6 = this.D;
            RectF rectF = new RectF(f3 - (f4 * 1.5f), (i - f5) + (f6 * 1.5f), f3 + (f4 * 1.5f), (i - f5) - (f6 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int[] iArr = this.b;
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            int[] iArr2 = this.a;
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
        }
    }

    public boolean d(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.i == null || this.x == null || this.u == null) {
                return false;
            }
            PointF pointF = this.x;
            float f3 = pointF.x;
            float f4 = this.C;
            int i = this.i.height;
            float f5 = pointF.y;
            float f6 = this.D;
            RectF rectF = new RectF(f3 - (f4 * 1.5f), (i - f5) + (f6 * 1.5f), f3 + (f4 * 1.5f), (i - f5) - (f6 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f, f2);
        }
        return invokeCommon.booleanValue;
    }
}
