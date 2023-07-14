package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes6.dex */
public class ln9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public b i;
    public int j;
    public int k;
    public float l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public Random t;
    public Bitmap u;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface c {
        float a();
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Bitmap b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public c j;

        public b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 10;
            this.b = bitmap;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
        }

        public b m(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                this.j = cVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public ln9 k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ln9(this, null);
            }
            return (ln9) invokeV.objValue;
        }

        public b l(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                this.h = i;
                this.i = i2;
                return this;
            }
            return (b) invokeII.objValue;
        }

        public b o(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                this.a = i;
                this.c = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b p(boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                this.e = z;
                this.f = z2;
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b n(int i, int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                this.g = i;
                this.b = ln9.a(this.b, i, i2);
                this.d = z;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    public ln9(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.i = bVar;
        this.u = bVar.b;
        this.o = bVar.g;
        this.p = bVar.h;
        this.a = bVar.j;
        this.q = bVar.i;
        this.b = bVar.a;
        this.n = bVar.d;
        this.r = bVar.e;
        this.s = bVar.f;
        this.m = bVar.c;
    }

    public ln9(b bVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.i = bVar;
        this.j = i;
        this.k = i2;
        Random random = new Random();
        this.t = random;
        this.g = random.nextInt((i * 8) / 9);
        int nextInt = this.t.nextInt(i2) - i2;
        this.h = nextInt;
        this.d = this.g;
        this.e = nextInt;
        this.m = bVar.c;
        this.n = bVar.d;
        this.a = bVar.j;
        this.p = bVar.h;
        this.q = bVar.i;
        this.o = bVar.g;
        this.r = bVar.e;
        this.s = bVar.f;
        this.b = bVar.a;
        g();
        f();
        h();
    }

    public /* synthetic */ ln9(b bVar, a aVar) {
        this(bVar);
    }

    public boolean b(Canvas canvas, Paint paint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, paint)) == null) {
            c();
            float f = this.e;
            if (f <= this.k && f >= 0.0f) {
                canvas.drawBitmap(this.u, this.d, f, paint);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bitmap, i, i2)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e += this.f;
        }
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d = (float) (this.d + (Math.sin(this.l) * 10.0d));
            if (this.s) {
                double d = this.l;
                if (this.t.nextBoolean()) {
                    i = -1;
                } else {
                    i = 1;
                }
                this.l = (float) (d + (i * Math.random() * 0.0025d));
            }
            float f = this.d;
            int i2 = this.j;
            int i3 = this.o;
            if (f > i2 - i3) {
                this.d = i2 - i3;
            }
        }
    }

    public final void h() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.r) {
                if (this.t.nextBoolean()) {
                    i = -1;
                } else {
                    i = 1;
                }
                this.l = (float) (((i * Math.random()) * this.c) / 50.0d);
            } else {
                this.l = this.c / 50.0f;
            }
            float f = this.l;
            if (f > 1.5707964f) {
                this.l = 1.5707964f;
            } else if (f < -1.5707964f) {
                this.l = -1.5707964f;
            }
        }
    }

    public final void f() {
        float nextInt;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.n) {
                c cVar = this.a;
                if (cVar != null) {
                    nextInt = cVar.a();
                } else {
                    nextInt = (this.t.nextInt(10) + 1) * 0.1f;
                }
                int i = this.p;
                float f2 = 0.0f;
                if (i > 0) {
                    f = Math.max(i, this.i.b.getWidth() * nextInt);
                } else {
                    f = 0.0f;
                }
                if (this.q > 0) {
                    f2 = Math.max(nextInt * this.i.b.getHeight(), this.q);
                }
                this.u = a(this.i.b, (int) f, (int) f2);
                return;
            }
            this.u = this.i.b;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.m) {
                this.f = ((float) (((this.t.nextInt(3) + 1) * 0.1d) + 1.0d)) * this.b;
            } else {
                this.f = this.b;
            }
        }
    }
}
