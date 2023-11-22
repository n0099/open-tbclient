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
/* loaded from: classes9.dex */
public class xh5 extends ii5<gi5, hi5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<zh5> l;
    public List<zh5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948300388, "Lcom/baidu/tieba/xh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948300388, "Lcom/baidu/tieba/xh5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh5(gi5 gi5Var, ai5 ai5Var) {
        super(gi5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gi5Var, ai5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((oi5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = ai5Var.j;
        this.j = ai5Var.i;
        int i3 = ai5Var.g * 1000;
        short s = ai5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = ai5Var.c;
        this.c = ai5Var.d;
        this.d = ai5Var.e;
        this.e = ai5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ii5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, hi5 hi5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, hi5Var})) == null) {
            try {
                int c = c(hi5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(hi5Var.f(), 0, c, options);
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

    public final int c(hi5 hi5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hi5Var)) == null) {
            int i2 = 33;
            for (zh5 zh5Var : this.m) {
                i2 += zh5Var.a + 12;
            }
            for (zh5 zh5Var2 : this.l) {
                if (zh5Var2 instanceof ci5) {
                    i = zh5Var2.a + 12;
                } else if (zh5Var2 instanceof bi5) {
                    i = zh5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            hi5Var.d(length);
            hi5Var.c(n);
            hi5Var.h(13);
            int a = hi5Var.a();
            hi5Var.g(ei5.f);
            hi5Var.h(this.b);
            hi5Var.h(this.c);
            hi5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(hi5Var.f(), a, 17);
            hi5Var.h((int) d.getValue());
            for (zh5 zh5Var3 : this.m) {
                if (!(zh5Var3 instanceof di5)) {
                    ((gi5) this.a).reset();
                    ((gi5) this.a).skip(zh5Var3.b);
                    ((gi5) this.a).read(hi5Var.f(), hi5Var.a(), zh5Var3.a + 12);
                    hi5Var.e(zh5Var3.a + 12);
                }
            }
            for (zh5 zh5Var4 : this.l) {
                if (zh5Var4 instanceof ci5) {
                    ((gi5) this.a).reset();
                    ((gi5) this.a).skip(zh5Var4.b);
                    ((gi5) this.a).read(hi5Var.f(), hi5Var.a(), zh5Var4.a + 12);
                    hi5Var.e(zh5Var4.a + 12);
                } else if (zh5Var4 instanceof bi5) {
                    hi5Var.h(zh5Var4.a - 4);
                    int a2 = hi5Var.a();
                    hi5Var.g(ci5.c);
                    ((gi5) this.a).reset();
                    ((gi5) this.a).skip(zh5Var4.b + 4 + 4 + 4);
                    ((gi5) this.a).read(hi5Var.f(), hi5Var.a(), zh5Var4.a - 4);
                    hi5Var.e(zh5Var4.a - 4);
                    d.reset();
                    d.update(hi5Var.f(), a2, zh5Var4.a);
                    hi5Var.h((int) d.getValue());
                }
            }
            hi5Var.c(o);
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
