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
/* loaded from: classes7.dex */
public class qk5 extends bl5<zk5, al5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<sk5> l;
    public List<sk5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948094734, "Lcom/baidu/tieba/qk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948094734, "Lcom/baidu/tieba/qk5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qk5(zk5 zk5Var, tk5 tk5Var) {
        super(zk5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zk5Var, tk5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hl5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = tk5Var.j;
        this.j = tk5Var.i;
        int i3 = tk5Var.g * 1000;
        short s = tk5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = tk5Var.c;
        this.c = tk5Var.d;
        this.d = tk5Var.e;
        this.e = tk5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, al5 al5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, al5Var})) == null) {
            try {
                int c = c(al5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(al5Var.f(), 0, c, options);
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

    public final int c(al5 al5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, al5Var)) == null) {
            int i2 = 33;
            for (sk5 sk5Var : this.m) {
                i2 += sk5Var.a + 12;
            }
            for (sk5 sk5Var2 : this.l) {
                if (sk5Var2 instanceof vk5) {
                    i = sk5Var2.a + 12;
                } else if (sk5Var2 instanceof uk5) {
                    i = sk5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            al5Var.d(length);
            al5Var.c(n);
            al5Var.h(13);
            int a = al5Var.a();
            al5Var.g(xk5.f);
            al5Var.h(this.b);
            al5Var.h(this.c);
            al5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(al5Var.f(), a, 17);
            al5Var.h((int) d.getValue());
            for (sk5 sk5Var3 : this.m) {
                if (!(sk5Var3 instanceof wk5)) {
                    ((zk5) this.a).reset();
                    ((zk5) this.a).skip(sk5Var3.b);
                    ((zk5) this.a).read(al5Var.f(), al5Var.a(), sk5Var3.a + 12);
                    al5Var.e(sk5Var3.a + 12);
                }
            }
            for (sk5 sk5Var4 : this.l) {
                if (sk5Var4 instanceof vk5) {
                    ((zk5) this.a).reset();
                    ((zk5) this.a).skip(sk5Var4.b);
                    ((zk5) this.a).read(al5Var.f(), al5Var.a(), sk5Var4.a + 12);
                    al5Var.e(sk5Var4.a + 12);
                } else if (sk5Var4 instanceof uk5) {
                    al5Var.h(sk5Var4.a - 4);
                    int a2 = al5Var.a();
                    al5Var.g(vk5.c);
                    ((zk5) this.a).reset();
                    ((zk5) this.a).skip(sk5Var4.b + 4 + 4 + 4);
                    ((zk5) this.a).read(al5Var.f(), al5Var.a(), sk5Var4.a - 4);
                    al5Var.e(sk5Var4.a - 4);
                    d.reset();
                    d.update(al5Var.f(), a2, sk5Var4.a);
                    al5Var.h((int) d.getValue());
                }
            }
            al5Var.c(o);
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
