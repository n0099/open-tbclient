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
public class xk5 extends il5<gl5, hl5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<zk5> l;
    public List<zk5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948303271, "Lcom/baidu/tieba/xk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948303271, "Lcom/baidu/tieba/xk5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk5(gl5 gl5Var, al5 al5Var) {
        super(gl5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gl5Var, al5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ol5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = al5Var.j;
        this.j = al5Var.i;
        int i3 = al5Var.g * 1000;
        short s = al5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = al5Var.c;
        this.c = al5Var.d;
        this.d = al5Var.e;
        this.e = al5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, hl5 hl5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, hl5Var})) == null) {
            try {
                int c = c(hl5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(hl5Var.f(), 0, c, options);
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

    public final int c(hl5 hl5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hl5Var)) == null) {
            int i2 = 33;
            for (zk5 zk5Var : this.m) {
                i2 += zk5Var.a + 12;
            }
            for (zk5 zk5Var2 : this.l) {
                if (zk5Var2 instanceof cl5) {
                    i = zk5Var2.a + 12;
                } else if (zk5Var2 instanceof bl5) {
                    i = zk5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            hl5Var.d(length);
            hl5Var.c(n);
            hl5Var.h(13);
            int a = hl5Var.a();
            hl5Var.g(el5.f);
            hl5Var.h(this.b);
            hl5Var.h(this.c);
            hl5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(hl5Var.f(), a, 17);
            hl5Var.h((int) d.getValue());
            for (zk5 zk5Var3 : this.m) {
                if (!(zk5Var3 instanceof dl5)) {
                    ((gl5) this.a).reset();
                    ((gl5) this.a).skip(zk5Var3.b);
                    ((gl5) this.a).read(hl5Var.f(), hl5Var.a(), zk5Var3.a + 12);
                    hl5Var.e(zk5Var3.a + 12);
                }
            }
            for (zk5 zk5Var4 : this.l) {
                if (zk5Var4 instanceof cl5) {
                    ((gl5) this.a).reset();
                    ((gl5) this.a).skip(zk5Var4.b);
                    ((gl5) this.a).read(hl5Var.f(), hl5Var.a(), zk5Var4.a + 12);
                    hl5Var.e(zk5Var4.a + 12);
                } else if (zk5Var4 instanceof bl5) {
                    hl5Var.h(zk5Var4.a - 4);
                    int a2 = hl5Var.a();
                    hl5Var.g(cl5.c);
                    ((gl5) this.a).reset();
                    ((gl5) this.a).skip(zk5Var4.b + 4 + 4 + 4);
                    ((gl5) this.a).read(hl5Var.f(), hl5Var.a(), zk5Var4.a - 4);
                    hl5Var.e(zk5Var4.a - 4);
                    d.reset();
                    d.update(hl5Var.f(), a2, zk5Var4.a);
                    hl5Var.h((int) d.getValue());
                }
            }
            hl5Var.c(o);
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
