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
public class wh5 extends hi5<fi5, gi5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<yh5> l;
    public List<yh5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270597, "Lcom/baidu/tieba/wh5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270597, "Lcom/baidu/tieba/wh5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wh5(fi5 fi5Var, zh5 zh5Var) {
        super(fi5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi5Var, zh5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ni5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = zh5Var.j;
        this.j = zh5Var.i;
        int i3 = zh5Var.g * 1000;
        short s = zh5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = zh5Var.c;
        this.c = zh5Var.d;
        this.d = zh5Var.e;
        this.e = zh5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hi5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, gi5 gi5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, gi5Var})) == null) {
            try {
                int c = c(gi5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(gi5Var.f(), 0, c, options);
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

    public final int c(gi5 gi5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gi5Var)) == null) {
            int i2 = 33;
            for (yh5 yh5Var : this.m) {
                i2 += yh5Var.a + 12;
            }
            for (yh5 yh5Var2 : this.l) {
                if (yh5Var2 instanceof bi5) {
                    i = yh5Var2.a + 12;
                } else if (yh5Var2 instanceof ai5) {
                    i = yh5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            gi5Var.d(length);
            gi5Var.c(n);
            gi5Var.h(13);
            int a = gi5Var.a();
            gi5Var.g(di5.f);
            gi5Var.h(this.b);
            gi5Var.h(this.c);
            gi5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(gi5Var.f(), a, 17);
            gi5Var.h((int) d.getValue());
            for (yh5 yh5Var3 : this.m) {
                if (!(yh5Var3 instanceof ci5)) {
                    ((fi5) this.a).reset();
                    ((fi5) this.a).skip(yh5Var3.b);
                    ((fi5) this.a).read(gi5Var.f(), gi5Var.a(), yh5Var3.a + 12);
                    gi5Var.e(yh5Var3.a + 12);
                }
            }
            for (yh5 yh5Var4 : this.l) {
                if (yh5Var4 instanceof bi5) {
                    ((fi5) this.a).reset();
                    ((fi5) this.a).skip(yh5Var4.b);
                    ((fi5) this.a).read(gi5Var.f(), gi5Var.a(), yh5Var4.a + 12);
                    gi5Var.e(yh5Var4.a + 12);
                } else if (yh5Var4 instanceof ai5) {
                    gi5Var.h(yh5Var4.a - 4);
                    int a2 = gi5Var.a();
                    gi5Var.g(bi5.c);
                    ((fi5) this.a).reset();
                    ((fi5) this.a).skip(yh5Var4.b + 4 + 4 + 4);
                    ((fi5) this.a).read(gi5Var.f(), gi5Var.a(), yh5Var4.a - 4);
                    gi5Var.e(yh5Var4.a - 4);
                    d.reset();
                    d.update(gi5Var.f(), a2, yh5Var4.a);
                    gi5Var.h((int) d.getValue());
                }
            }
            gi5Var.c(o);
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
