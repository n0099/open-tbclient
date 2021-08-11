package com.baidu.ugc.editvideo.sticker;

import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import c.a.z.b.a.g;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public float C;
    public float D;
    public float E;

    /* renamed from: a  reason: collision with root package name */
    public int[] f59614a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f59615b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaData f59616c;

    /* renamed from: d  reason: collision with root package name */
    public int f59617d;

    /* renamed from: e  reason: collision with root package name */
    public int f59618e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f59619f;

    /* renamed from: g  reason: collision with root package name */
    public float f59620g;

    /* renamed from: h  reason: collision with root package name */
    public float f59621h;

    /* renamed from: i  reason: collision with root package name */
    public GLViewPortLocation f59622i;

    /* renamed from: j  reason: collision with root package name */
    public float f59623j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59619f = new float[16];
        this.y = "left_top";
        this.z = "right_bottom";
        this.A = "left_bottom";
        this.f59614a = new int[1];
        this.f59615b = new int[1];
        this.E = 1.0f;
        this.f59616c = multiMediaData;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PointF a(String str, PointF... pointFArr) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, pointFArr)) == null) {
            switch (str.hashCode()) {
                case -1568783182:
                    if (str.equals("right_top")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1514196637:
                    if (str.equals("left_bottom")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1699249582:
                    if (str.equals("right_bottom")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1718760733:
                    if (str.equals("left_top")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            return c2 != 0 ? c2 != 1 ? c2 != 2 ? pointFArr[0] : pointFArr[3] : pointFArr[2] : pointFArr[1];
        }
        return (PointF) invokeLL.objValue;
    }

    private float[] a(float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            Matrix.translateM(fArr, 0, f3, f4, 1.0f);
            Matrix.rotateM(fArr, 0, f2 % 360.0f, 0.0f, 0.0f, 1.0f);
            Matrix.scaleM(fArr, 0, f5, f6, 0.0f);
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            float f2 = this.m;
            float f3 = this.E;
            this.f59620g = f2 * f3;
            this.f59621h = this.n * f3;
            float sin = (float) Math.sin(Math.toRadians(this.f59623j));
            float cos = (float) Math.cos(Math.toRadians(this.f59623j));
            float f4 = this.k;
            float f5 = this.f59620g;
            float f6 = f4 - f5;
            float f7 = this.l;
            float f8 = this.f59621h;
            float f9 = f7 + f8;
            float f10 = f7 - f8;
            float f11 = f5 + f4;
            PointF pointF = new PointF((((f6 - f4) * cos) - ((f10 - f7) * sin)) + f4, ((f6 - f4) * sin) + ((f10 - f7) * cos) + f7);
            PointF pointF2 = new PointF((((f6 - f4) * cos) - ((f9 - f7) * sin)) + f4, ((f6 - f4) * sin) + ((f9 - f7) * cos) + f7);
            PointF pointF3 = new PointF((((f11 - f4) * cos) - ((f10 - f7) * sin)) + f4, ((f11 - f4) * sin) + ((f10 - f7) * cos) + f7);
            PointF pointF4 = new PointF((((f11 - f4) * cos) - ((f9 - f7) * sin)) + f4, ((f11 - f4) * sin) + ((f9 - f7) * cos) + f7);
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

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.E = f2;
        }
    }

    public void a(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.o = f2;
            this.p = f3;
            this.q = f4;
            this.r = f5;
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f59617d = i2;
            this.f59618e = i3;
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
            float[] fArr2 = this.f59619f;
            float f2 = this.f59623j;
            PointF pointF = this.x;
            Matrix.multiplyMM(fArr, 0, fArr2, 0, a(f2, pointF.x, pointF.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.u.textureId, g.f31079b);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect.setVertexPoint(fArr);
        }
    }

    public void a(FullFrameRect fullFrameRect, MultiMediaData multiMediaData) {
        GLViewPortLocation gLViewPortLocation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, fullFrameRect, multiMediaData) == null) || multiMediaData == null || multiMediaData.textureId == 0 || (gLViewPortLocation = this.f59622i) == null) {
            return;
        }
        float[] fArr = new float[16];
        float[] fArr2 = this.f59619f;
        int i2 = gLViewPortLocation.width;
        int i3 = gLViewPortLocation.height;
        Matrix.multiplyMM(fArr, 0, fArr2, 0, a(0.0f, i2 / 2.0f, i3 / 2.0f, Math.min(i2, i3), 5.0f), 0);
        fullFrameRect.setVertexPoint(fArr);
        fullFrameRect.drawFrame(multiMediaData.textureId, g.f31079b);
        float[] fArr3 = this.f59619f;
        GLViewPortLocation gLViewPortLocation2 = this.f59622i;
        int i4 = gLViewPortLocation2.width;
        int i5 = gLViewPortLocation2.height;
        Matrix.multiplyMM(fArr, 0, fArr3, 0, a(90.0f, i4 / 2.0f, i5 / 2.0f, Math.min(i4, i5), 5.0f), 0);
        fullFrameRect.setVertexPoint(fArr);
        fullFrameRect.drawFrame(multiMediaData.textureId, g.f31079b);
        Matrix.setIdentityM(fArr, 0);
        fullFrameRect.setVertexPoint(fArr);
    }

    public void a(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, fullFrameRect, fullFrameRect2) == null) {
            SurfaceTexture surfaceTexture = this.f59616c.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.f59616c.mtx);
            }
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            MultiMediaData multiMediaData = this.f59616c;
            this.f59623j = multiMediaData.rotation + multiMediaData.angle;
            int i2 = this.f59617d;
            float f2 = i2 != 0 ? (this.f59622i.width * 1.0f) / i2 : 1.0f;
            int round = Math.round(this.f59616c.width * f2) / 2;
            int round2 = Math.round(this.f59616c.height * f2) / 2;
            MultiMediaData multiMediaData2 = this.f59616c;
            float f3 = multiMediaData2.x;
            float f4 = multiMediaData2.y;
            int i3 = this.f59617d;
            if (i3 != 0) {
                f3 = (f3 / i3) * this.f59622i.width;
            }
            int i4 = this.f59618e;
            if (i4 != 0) {
                f4 = (this.f59616c.y / i4) * this.f59622i.height;
            }
            MultiMediaData multiMediaData3 = this.f59616c;
            this.k = ((multiMediaData3.width / 2.0f) * f2) + f3;
            this.l = (this.f59622i.height - ((multiMediaData3.height / 2.0f) * f2)) - f4;
            if (multiMediaData3.type == 0) {
                if (multiMediaData3.rotation == 0.0f) {
                    this.f59623j += 180.0f;
                }
                round = -round;
            } else {
                float f5 = this.f59623j;
                float f6 = multiMediaData3.rotation;
                this.f59623j = f5 - f6;
                if (f6 == 90.0f || f6 == 270.0f) {
                    round2 = round;
                    round = round2;
                }
            }
            MultiMediaData multiMediaData4 = this.f59616c;
            this.m = round * multiMediaData4.scaleX;
            this.n = round2 * multiMediaData4.scaleY;
            Matrix.multiplyMM(fArr, 0, this.f59619f, 0, a(this.f59623j, this.k, this.l, this.m, this.n), 0);
            FullFrameRect fullFrameRect3 = this.f59616c.type == 0 ? fullFrameRect : fullFrameRect2;
            fullFrameRect3.setVertexPoint(fArr);
            MultiMediaData multiMediaData5 = this.f59616c;
            fullFrameRect3.drawFrame(multiMediaData5.textureId, multiMediaData5.mtx);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect3.setVertexPoint(fArr);
            if (this.f59620g == 0.0f || this.f59621h == 0.0f || this.v == null || this.w == null) {
                e();
            }
        }
    }

    public void a(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gLViewPortLocation) == null) {
            this.f59622i = gLViewPortLocation;
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
            this.f59619f = fArr;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean a(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f59622i == null) {
                return false;
            }
            float f4 = this.k;
            float f5 = this.f59620g;
            int i2 = this.f59622i.height;
            float f6 = this.l;
            float f7 = this.f59621h;
            RectF rectF = new RectF(f4 - f5, (i2 - f6) - f7, f4 + f5, (i2 - f6) + f7);
            new android.graphics.Matrix().mapRect(rectF);
            float f8 = this.f59623j;
            if (f8 % 360.0f == 0.0f) {
                return rectF.contains(f2, f3);
            }
            float sin = (float) Math.sin(Math.toRadians(f8));
            float cos = (float) Math.cos(Math.toRadians(this.f59623j));
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            float f9 = centerX - f2;
            float f10 = centerY - f3;
            return rectF.contains(((f9 * cos) - (f10 * sin)) + centerX, (f9 * sin) + (f10 * cos) + centerY);
        }
        return invokeCommon.booleanValue;
    }

    public MultiMediaData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f59616c : (MultiMediaData) invokeV.objValue;
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
        if ((interceptable == null || interceptable.invokeL(1048590, this, fullFrameRect) == null) && this.f59614a[0] == 0) {
            this.f59615b[0] = fullFrameRect.createTexture2DObject();
            GLViewPortLocation gLViewPortLocation = this.f59622i;
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, gLViewPortLocation.width, gLViewPortLocation.height, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glGenFramebuffers(1, this.f59614a, 0);
            GLES20.glBindFramebuffer(36160, this.f59614a[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f59615b[0], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public void b(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, fullFrameRect, fullFrameRect2) == null) {
            e();
            float[] fArr = new float[16];
            Matrix.multiplyMM(fArr, 0, this.f59619f, 0, a(this.f59623j, this.k, this.l, this.f59620g, this.f59621h), 0);
            fullFrameRect2.setVertexPoint(fArr);
            fullFrameRect2.drawFrame(fArr);
            float[] fArr2 = this.f59619f;
            float f2 = this.f59623j;
            PointF pointF = this.v;
            Matrix.multiplyMM(fArr, 0, fArr2, 0, a(f2, pointF.x, pointF.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.s.textureId, g.f31079b);
            float[] fArr3 = this.f59619f;
            float f3 = this.f59623j;
            PointF pointF2 = this.w;
            Matrix.multiplyMM(fArr, 0, fArr3, 0, a(f3, pointF2.x, pointF2.y, -this.C, this.D), 0);
            fullFrameRect.setVertexPoint(fArr);
            fullFrameRect.drawFrame(this.t.textureId, g.f31079b);
            Matrix.setIdentityM(fArr, 0);
            fullFrameRect.setVertexPoint(fArr);
        }
    }

    public boolean b(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f59622i == null || this.w == null || this.t == null) {
                return false;
            }
            PointF pointF = this.w;
            float f4 = pointF.x;
            float f5 = this.C;
            int i2 = this.f59622i.height;
            float f6 = pointF.y;
            float f7 = this.D;
            RectF rectF = new RectF(f4 - (f5 * 1.5f), (i2 - f6) + (f7 * 1.5f), f4 + (f5 * 1.5f), (i2 - f6) - (f7 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public PointF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f59622i == null) {
                return null;
            }
            return new PointF(this.k, this.f59622i.height - this.l);
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

    public boolean c(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f59622i == null || this.v == null || this.s == null) {
                return false;
            }
            PointF pointF = this.v;
            float f4 = pointF.x;
            float f5 = this.C;
            int i2 = this.f59622i.height;
            float f6 = pointF.y;
            float f7 = this.D;
            RectF rectF = new RectF(f4 - (f5 * 1.5f), (i2 - f6) + (f7 * 1.5f), f4 + (f5 * 1.5f), (i2 - f6) - (f7 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int[] iArr = this.f59615b;
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            int[] iArr2 = this.f59614a;
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
        }
    }

    public boolean d(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f59622i == null || this.x == null || this.u == null) {
                return false;
            }
            PointF pointF = this.x;
            float f4 = pointF.x;
            float f5 = this.C;
            int i2 = this.f59622i.height;
            float f6 = pointF.y;
            float f7 = this.D;
            RectF rectF = new RectF(f4 - (f5 * 1.5f), (i2 - f6) + (f7 * 1.5f), f4 + (f5 * 1.5f), (i2 - f6) - (f7 * 1.5f));
            new android.graphics.Matrix().mapRect(rectF);
            return rectF.contains(f2, f3);
        }
        return invokeCommon.booleanValue;
    }
}
