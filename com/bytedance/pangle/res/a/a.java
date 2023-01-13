package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger f;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final h b;
    public final g c;
    public final e d;
    public C0524a e;

    /* renamed from: com.bytedance.pangle.res.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0524a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final short a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public C0524a(short s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Short.valueOf(s), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i3 + i2;
        }

        public static C0524a a(g gVar, e eVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, gVar, eVar)) == null) {
                try {
                    return new C0524a(gVar.readShort(), gVar.readShort(), gVar.readInt(), eVar.a());
                } catch (EOFException unused) {
                    return new C0524a((short) -1, 0, 0, eVar.a());
                }
            }
            return (C0524a) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-619096987, "Lcom/bytedance/pangle/res/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-619096987, "Lcom/bytedance/pangle/res/a/a;");
                return;
            }
        }
        f = Logger.getLogger(a.class.getName());
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            b(514);
            this.c.readUnsignedByte();
            this.c.skipBytes(3);
            this.c.skipBytes(this.c.readInt() * 4);
        }
    }

    private C0524a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            C0524a a = C0524a.a(this.c, this.d);
            this.e = a;
            return a;
        }
        return (C0524a) invokeV.objValue;
    }

    public a(byte[] bArr, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.d = eVar;
        this.c = new g(new i(eVar));
        this.a = bArr;
        this.b = hVar;
    }

    private String a(int i) {
        InterceptResult invokeI;
        int i2;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            StringBuilder sb = new StringBuilder(16);
            while (true) {
                i2 = i - 1;
                if (i == 0 || this.c.readByte() == 0) {
                    break;
                }
                sb.append((char) s);
                i = i2;
            }
            this.c.skipBytes(i2);
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    private void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) != null) || this.e.a == i) {
            return;
        }
        throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.e.a)));
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            b(515);
            int readInt = this.c.readInt();
            for (int i = 0; i < readInt; i++) {
                this.c.readInt();
                this.c.skipBytes(256);
            }
            while (j().a == 513) {
                c();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.c.readShort() >= 0) {
                short readShort = this.c.readShort();
                this.c.readInt();
                if ((readShort & 1) == 0) {
                    h();
                    return;
                } else {
                    g();
                    return;
                }
            }
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int a = k.a(this.c);
            k.a(this.a, this.c.readInt(), a, this.b);
            int readInt = this.c.readInt();
            for (int i = 0; i < readInt; i++) {
                int a2 = k.a(this.c);
                k.a(this.a, this.c.readInt(), a2, this.b);
                h();
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.c.a();
            this.c.b();
            byte readByte = this.c.readByte();
            int a = k.a(this.c);
            int readInt = this.c.readInt();
            if (readByte == 1) {
                k.a(this.a, readInt, a, this.b);
            }
            if (readByte == 2) {
                k.a(this.a, readInt, a, this.b);
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            d();
            short s = j().a;
            while (s == 514) {
                d();
                s = j().a;
            }
            while (s == 513) {
                e();
                if (this.d.a() < this.e.e) {
                    Logger logger = f;
                    logger.warning("Unknown data detected. Skipping: " + (this.e.e - this.d.a()) + " byte(s)");
                    e eVar = this.d;
                    eVar.skip((long) (this.e.e - eVar.a()));
                }
                s = j().a;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
            b(2);
            int readInt = this.c.readInt();
            l.a(this.c);
            j();
            for (int i = 0; i < readInt; i++) {
                b(512);
                this.c.readInt();
                this.c.skipBytes(256);
                this.c.skipBytes(4);
                this.c.skipBytes(4);
                this.c.skipBytes(4);
                this.c.skipBytes(4);
                if (this.e.b == 288 && this.c.readInt() > 0) {
                    throw new RuntimeException("don't support");
                }
                l.a(this.c);
                l.a(this.c);
                j();
                boolean z = true;
                while (z) {
                    short s = this.e.a;
                    if (s != 514) {
                        if (s != 515) {
                            z = false;
                        } else {
                            b();
                        }
                    } else {
                        c();
                    }
                }
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            b(513);
            this.c.readUnsignedByte();
            this.c.readByte();
            this.c.skipBytes(2);
            int readInt = this.c.readInt();
            int readInt2 = this.c.readInt();
            i();
            int i = (this.e.d + readInt2) - (readInt * 4);
            if (i != this.d.a()) {
                f.warning("Invalid data detected. Skipping: " + (i - this.d.a()) + " byte(s)");
                this.c.skipBytes(i - this.d.a());
            }
            int[] a = this.c.a(readInt);
            HashSet hashSet = new HashSet();
            for (int i2 : a) {
                if (i2 != -1 && !hashSet.contains(Integer.valueOf(i2))) {
                    f();
                    hashSet.add(Integer.valueOf(i2));
                }
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int readInt = this.c.readInt();
            int i = 28;
            if (readInt >= 28) {
                this.c.readShort();
                this.c.readShort();
                this.c.readByte();
                this.c.readByte();
                this.c.readByte();
                this.c.readByte();
                this.c.readByte();
                this.c.readByte();
                this.c.readUnsignedShort();
                this.c.readByte();
                this.c.readByte();
                this.c.readByte();
                this.c.skipBytes(1);
                this.c.readShort();
                this.c.readShort();
                this.c.readShort();
                this.c.skipBytes(2);
                if (readInt >= 32) {
                    this.c.readByte();
                    this.c.readByte();
                    this.c.readShort();
                    i = 32;
                }
                if (readInt >= 36) {
                    this.c.readShort();
                    this.c.readShort();
                    i = 36;
                }
                if (readInt >= 48) {
                    a(4).toCharArray();
                    a(8).toCharArray();
                    i = 48;
                }
                if (readInt >= 52) {
                    this.c.readByte();
                    this.c.readByte();
                    this.c.skipBytes(2);
                    i = 52;
                }
                if (readInt >= 56) {
                    this.c.skipBytes(4);
                    i = 56;
                }
                int i2 = readInt - 56;
                if (i2 > 0) {
                    byte[] bArr = new byte[i2];
                    i += i2;
                    this.c.readFully(bArr);
                    BigInteger bigInteger = new BigInteger(1, bArr);
                    if (bigInteger.equals(BigInteger.ZERO)) {
                        f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
                    } else {
                        f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
                    }
                }
                int i3 = readInt - i;
                if (i3 > 0) {
                    this.c.skipBytes(i3);
                    return;
                }
                return;
            }
            throw new RuntimeException("Config size < 28");
        }
    }
}
