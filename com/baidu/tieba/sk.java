package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public class sk extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public static long p;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final sj.a b;
    public final rk c;
    public final ByteBuffer d;
    public final rj e;
    public boolean f;
    public int g;
    public boolean h;
    public int i;
    public b j;
    public int k;
    public final tj l;
    public int m;
    public long n;
    public long o;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448317013, "Lcom/baidu/tieba/sk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448317013, "Lcom/baidu/tieba/sk;");
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public int c;
        public int d;
        public byte[] e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sk(Handler handler, sj.a aVar, rk rkVar, String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, aVar, rkVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.h = false;
        this.l = new tj();
        this.m = 0;
        this.n = 0L;
        this.o = 0L;
        this.a = handler;
        this.b = aVar;
        this.c = rkVar;
        this.d = ByteBuffer.allocateDirect(rkVar.b() + 14);
        this.e = new rj(rkVar.c());
        this.j = null;
        this.g = 1;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (sk.class) {
                p = 0L;
            }
        }
    }

    public final boolean b() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.g;
            if (i != 3 && i != 2) {
                if (i == 1) {
                    return o();
                }
                if (i == 0) {
                }
                return false;
            }
            return n();
        }
        return invokeV.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (sk.class) {
                j = p;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f = true;
            try {
                this.b.close();
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public void d(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.n = 0L;
            this.o = 0L;
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.obj = obj;
            this.a.sendMessage(obtainMessage);
        }
    }

    public void e(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.o = currentTimeMillis;
            d(new yj(bArr, this.n, currentTimeMillis));
        }
    }

    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            d(new hk(bArr));
        }
    }

    public void i(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            d(new ik(bArr));
        }
    }

    public void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            d(new kk(bArr));
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            d(new qk(str));
        }
    }

    public void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            d(new ak(i, str));
        }
    }

    public void g(boolean z, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, map) == null) {
            d(new ok(z, map));
        }
    }

    public final Map<String, String> l(byte[] bArr) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bArr)) == null) {
            String str = new String(bArr, "UTF-8");
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("\r\n")) {
                if (str2.length() > 0) {
                    String[] split2 = str2.split(": ");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final Pair<Integer, String> m() throws UnsupportedEncodingException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = 4;
            while (i < this.d.position() && this.d.get(i) != 32) {
                i++;
            }
            int i2 = i + 1;
            int i3 = i2;
            while (i3 < this.d.position() && this.d.get(i3) != 32) {
                i3++;
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i2 + i4;
                if (i6 >= i3) {
                    break;
                }
                i5 = (i5 * 10) + (this.d.get(i6) - 48);
                i4++;
            }
            int i7 = i3 + 1;
            int i8 = i7;
            while (i8 < this.d.position() && this.d.get(i8) != 13) {
                i8++;
            }
            int i9 = i8 - i7;
            byte[] bArr = new byte[i9];
            this.d.position(i7);
            this.d.get(bArr, 0, i9);
            return new Pair<>(Integer.valueOf(i5), new String(bArr, "UTF-8"));
        }
        return (Pair) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0360 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0362 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() throws Exception {
        InterceptResult invokeV;
        int i;
        int i2;
        String str;
        boolean z;
        boolean z2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b bVar = this.j;
            int i3 = 10;
            byte[] bArr = null;
            if (bVar == null) {
                if (this.d.position() >= 2) {
                    byte b2 = this.d.get(0);
                    if ((b2 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i4 = (b2 & 112) >> 4;
                    int i5 = b2 & 15;
                    byte b3 = this.d.get(1);
                    if ((b3 & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i6 = b3 & ByteCompanionObject.MAX_VALUE;
                    if (i4 == 0) {
                        if (!z2) {
                            if (i5 > 7) {
                                if (z) {
                                    if (i6 <= 125) {
                                        if (i5 != 8 && i5 != 9 && i5 != 10) {
                                            throw new WebSocketException("control frame using reserved opcode " + i5);
                                        } else if (i5 == 8 && i6 == 1) {
                                            throw new WebSocketException("received close control frame with payload len 1");
                                        }
                                    } else {
                                        throw new WebSocketException("control frame with payload length > 125 octets");
                                    }
                                } else {
                                    throw new WebSocketException("fragmented control frame");
                                }
                            } else if (i5 != 0 && i5 != 1 && i5 != 2) {
                                throw new WebSocketException("data frame using reserved opcode " + i5);
                            } else if (!this.h && i5 == 0) {
                                throw new WebSocketException("received continuation data frame outside fragmented message");
                            } else {
                                if (this.h && i5 != 0) {
                                    throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                                }
                            }
                            if (i6 < 126) {
                                i3 = 2;
                            } else if (i6 == 126) {
                                i3 = 4;
                            } else if (i6 != 127) {
                                throw new Exception("BdLogic error");
                            }
                            if (this.d.position() >= i3) {
                                if (i6 == 126) {
                                    j = ((this.d.get(2) & 255) << 8) | (this.d.get(3) & 255);
                                    if (j < 126) {
                                        throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                    }
                                } else if (i6 == 127) {
                                    if ((this.d.get(2) & 128) == 0) {
                                        j = (this.d.get(9) & 255) | ((this.d.get(2) & 255) << 56) | ((this.d.get(3) & 255) << 48) | ((this.d.get(4) & 255) << 40) | ((this.d.get(5) & 255) << 32) | ((this.d.get(6) & 255) << 24) | ((this.d.get(7) & 255) << 16) | ((this.d.get(8) & 255) << 8);
                                        if (j < 65536) {
                                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                        }
                                    } else {
                                        throw new WebSocketException("invalid data frame length (> 2^63)");
                                    }
                                } else {
                                    j = i6;
                                }
                                b bVar2 = new b(null);
                                this.j = bVar2;
                                bVar2.a = i5;
                                bVar2.b = z;
                                bVar2.d = (int) j;
                                bVar2.c = i3;
                                int position = this.d.position();
                                b bVar3 = this.j;
                                bVar3.e = new byte[bVar3.c];
                                this.d.position(0);
                                ByteBuffer byteBuffer = this.d;
                                b bVar4 = this.j;
                                byteBuffer.get(bVar4.e, 0, bVar4.c);
                                this.d.position(this.j.c);
                                this.d.limit(position);
                                this.d.compact();
                                if (this.j.d != 0 && this.d.position() < this.j.d) {
                                    return false;
                                }
                                return true;
                            }
                            return false;
                        }
                        throw new WebSocketException("masked server frame");
                    }
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                return false;
            }
            int i7 = this.k;
            int i8 = bVar.d;
            if (i7 >= i8) {
                int i9 = bVar.a;
                if (i9 > 7) {
                    if (i9 == 8) {
                        int i10 = 1005;
                        if (i8 >= 2) {
                            byte[] bArr2 = bVar.e;
                            i10 = ((bArr2[0] & 255) * 256) + (bArr2[1] & 255);
                            if (i10 >= 1000 && ((i10 < 1000 || i10 > 2999 || i10 == 1000 || i10 == 1001 || i10 == 1002 || i10 == 1003 || i10 == 1007 || i10 == 1008 || i10 == 1009 || i10 == 1010 || i10 == 1011) && i10 < 5000)) {
                                b bVar5 = this.j;
                                int i11 = bVar5.d;
                                if (i11 > 2) {
                                    byte[] bArr3 = new byte[i11 - 2];
                                    System.arraycopy(bVar5.e, 2, bArr3, 0, i11 - 2);
                                    tj tjVar = new tj();
                                    tjVar.c(bArr3);
                                    if (tjVar.a()) {
                                        str = new String(bArr3, "UTF-8");
                                        f(i10, str);
                                    } else {
                                        throw new WebSocketException("invalid close reasons (not UTF-8)");
                                    }
                                }
                            } else {
                                throw new WebSocketException("invalid close code " + i10);
                            }
                        }
                        str = null;
                        f(i10, str);
                    } else if (i9 == 9) {
                        h(this.e.toByteArray());
                    } else if (i9 == 10) {
                        i(this.e.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                } else {
                    if (!this.h) {
                        i = 1;
                        this.h = true;
                        this.i = i9;
                        if (i9 == 1 && this.c.h()) {
                            this.l.b();
                        }
                    } else {
                        i = 1;
                    }
                    if (this.i == i && this.c.h() && !this.l.c(this.e.toByteArray())) {
                        throw new WebSocketException("invalid UTF-8 in text message payload");
                    }
                    if (this.j.b) {
                        int i12 = this.i;
                        if (i12 == 1) {
                            if (this.c.h() && !this.l.a()) {
                                throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                            }
                            if (this.c.d()) {
                                j(this.e.toByteArray());
                            } else {
                                k(new String(this.e.toByteArray(), "UTF-8"));
                            }
                        } else if (i12 == 2) {
                            e(this.e.toByteArray());
                        } else {
                            throw new Exception("BdLogic error");
                        }
                        i2 = 0;
                        this.h = false;
                        this.e.reset();
                        this.j = null;
                        this.k = i2;
                        if (this.d.position() <= 0) {
                            return true;
                        }
                        return false;
                    }
                }
                i2 = 0;
                this.j = null;
                this.k = i2;
                if (this.d.position() <= 0) {
                }
            } else {
                int position2 = this.d.position();
                int i13 = this.j.d;
                int i14 = this.k;
                if (i13 - i14 < position2) {
                    position2 = i13 - i14;
                }
                int position3 = this.d.position();
                if (this.j.d > 0) {
                    bArr = new byte[position2];
                    this.d.position(0);
                    this.d.get(bArr, 0, position2);
                }
                this.d.position(position2);
                this.d.limit(position3);
                this.d.compact();
                if (bArr != null) {
                    this.e.write(bArr);
                }
                int i15 = this.k + position2;
                this.k = i15;
                if (i15 >= this.j.d) {
                    return true;
                }
                return false;
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    public final boolean o() throws UnsupportedEncodingException {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int position = this.d.position() - 4;
            while (true) {
                z = false;
                if (position < 0) {
                    break;
                } else if (this.d.get(position + 0) == 13 && this.d.get(position + 1) == 10 && this.d.get(position + 2) == 13 && this.d.get(position + 3) == 10) {
                    int position2 = this.d.position();
                    Map<String, String> map = null;
                    if (this.d.get(0) == 72 && this.d.get(1) == 84 && this.d.get(2) == 84 && this.d.get(3) == 80) {
                        Pair<Integer, String> m = m();
                        if (((Integer) m.first).intValue() >= 300) {
                            d(new nk(((Integer) m.first).intValue(), (String) m.second));
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (position > 0) {
                            this.d.position(0);
                            byte[] bArr = new byte[position];
                            this.d.get(bArr);
                            map = l(bArr);
                        }
                    } else {
                        z2 = false;
                    }
                    this.d.position(position + 4);
                    this.d.limit(position2);
                    this.d.compact();
                    if (this.m < this.b.a() && map.size() == 0) {
                        this.m++;
                        return true;
                    }
                    this.m = 0;
                    if (!z2) {
                        if (this.d.position() > 0) {
                            z = true;
                        }
                        this.g = 3;
                    } else {
                        this.g = 0;
                        this.f = true;
                        z = true;
                    }
                    g(!z2, map);
                } else {
                    position--;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            try {
                try {
                    this.d.clear();
                    do {
                        try {
                            int read = this.b.read(this.d);
                            if (read > 0) {
                                if (this.n <= 0) {
                                    this.n = System.currentTimeMillis();
                                }
                                synchronized (sk.class) {
                                    p += read;
                                }
                            }
                            if (read > 0) {
                                while (b()) {
                                }
                            } else if (read < 0) {
                                d(new bk(new SocketException("len < 0")));
                                this.f = true;
                            }
                        } catch (SocketTimeoutException unused) {
                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                this.f = true;
                                d(new bk(new SocketException("not net")));
                                return;
                            }
                        }
                    } while (!this.f);
                } catch (WebSocketException e) {
                    d(new jk(e));
                } catch (SocketException e2) {
                    d(new bk(e2));
                } catch (Exception e3) {
                    d(new dk(e3));
                }
            } finally {
                this.f = true;
            }
        }
    }
}
