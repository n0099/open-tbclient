package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
/* loaded from: classes8.dex */
public class vk5 extends gl5<el5, fl5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<xk5> l;
    public List<xk5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948243689, "Lcom/baidu/tieba/vk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948243689, "Lcom/baidu/tieba/vk5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vk5(el5 el5Var, yk5 yk5Var) {
        super(el5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {el5Var, yk5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ml5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = yk5Var.j;
        this.j = yk5Var.i;
        int i3 = yk5Var.g * 1000;
        short s = yk5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = yk5Var.c;
        this.c = yk5Var.d;
        this.d = yk5Var.e;
        this.e = yk5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gl5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, fl5 fl5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, fl5Var})) == null) {
            try {
                int c = c(fl5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(fl5Var.f(), 0, c, options);
                } catch (IllegalArgumentException unused) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = i;
                    options2.inMutable = true;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, c, options2);
                }
                this.g.left = 0;
                this.g.top = 0;
                this.g.right = decodeByteArray.getWidth();
                this.g.bottom = decodeByteArray.getHeight();
                float f = i;
                this.h.left = (int) (this.d / f);
                this.h.top = (int) (this.e / f);
                this.h.right = (int) ((this.d / f) + decodeByteArray.getWidth());
                this.h.bottom = (int) ((this.e / f) + decodeByteArray.getHeight());
                canvas.drawBitmap(decodeByteArray, this.g, this.h, paint);
                return decodeByteArray;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public final int c(fl5 fl5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fl5Var)) == null) {
            int i2 = 33;
            for (xk5 xk5Var : this.m) {
                i2 += xk5Var.a + 12;
            }
            for (xk5 xk5Var2 : this.l) {
                if (xk5Var2 instanceof al5) {
                    i = xk5Var2.a + 12;
                } else if (xk5Var2 instanceof zk5) {
                    i = xk5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            fl5Var.d(length);
            fl5Var.c(n);
            fl5Var.h(13);
            int a = fl5Var.a();
            fl5Var.g(cl5.f);
            fl5Var.h(this.b);
            fl5Var.h(this.c);
            fl5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(fl5Var.f(), a, 17);
            fl5Var.h((int) d.getValue());
            for (xk5 xk5Var3 : this.m) {
                if (!(xk5Var3 instanceof bl5)) {
                    ((el5) this.a).reset();
                    ((el5) this.a).skip(xk5Var3.b);
                    ((el5) this.a).read(fl5Var.f(), fl5Var.a(), xk5Var3.a + 12);
                    fl5Var.e(xk5Var3.a + 12);
                }
            }
            for (xk5 xk5Var4 : this.l) {
                if (xk5Var4 instanceof al5) {
                    ((el5) this.a).reset();
                    ((el5) this.a).skip(xk5Var4.b);
                    ((el5) this.a).read(fl5Var.f(), fl5Var.a(), xk5Var4.a + 12);
                    fl5Var.e(xk5Var4.a + 12);
                } else if (xk5Var4 instanceof zk5) {
                    fl5Var.h(xk5Var4.a - 4);
                    int a2 = fl5Var.a();
                    fl5Var.g(al5.c);
                    ((el5) this.a).reset();
                    ((el5) this.a).skip(xk5Var4.b + 4 + 4 + 4);
                    ((el5) this.a).read(fl5Var.f(), fl5Var.a(), xk5Var4.a - 4);
                    fl5Var.e(xk5Var4.a - 4);
                    d.reset();
                    d.update(fl5Var.f(), a2, xk5Var4.a);
                    fl5Var.h((int) d.getValue());
                }
            }
            fl5Var.c(o);
            return length;
        }
        return invokeL.intValue;
    }

    public final CRC32 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CRC32 crc32 = p.get();
            if (crc32 == null) {
                CRC32 crc322 = new CRC32();
                p.set(crc322);
                return crc322;
            }
            return crc32;
        }
        return (CRC32) invokeV.objValue;
    }
}
