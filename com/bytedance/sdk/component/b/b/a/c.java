package com.bytedance.sdk.component.b.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.e;
import com.bytedance.sdk.component.b.a.f;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.b.aa;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.t;
import com.bytedance.sdk.component.b.b.v;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f28221a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f28222b;

    /* renamed from: c  reason: collision with root package name */
    public static final ac f28223c;

    /* renamed from: d  reason: collision with root package name */
    public static final aa f28224d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f28225e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f28226f;

    /* renamed from: g  reason: collision with root package name */
    public static final TimeZone f28227g;

    /* renamed from: h  reason: collision with root package name */
    public static final Comparator<String> f28228h;

    /* renamed from: i  reason: collision with root package name */
    public static final f f28229i;
    public static final f j;
    public static final f k;
    public static final f l;
    public static final f m;
    public static final Charset n;
    public static final Charset o;
    public static final Charset p;
    public static final Charset q;
    public static final Pattern r;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1529480891, "Lcom/bytedance/sdk/component/b/b/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1529480891, "Lcom/bytedance/sdk/component/b/b/a/c;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        f28221a = bArr;
        f28222b = new String[0];
        f28223c = ac.a(null, bArr);
        f28224d = aa.a((v) null, f28221a);
        f28229i = f.b("efbbbf");
        j = f.b("feff");
        k = f.b("fffe");
        l = f.b("0000ffff");
        m = f.b("ffff0000");
        f28225e = Charset.forName("UTF-8");
        f28226f = Charset.forName("ISO-8859-1");
        n = Charset.forName(CharEncoding.UTF_16BE);
        o = Charset.forName(CharEncoding.UTF_16LE);
        p = Charset.forName("UTF-32BE");
        q = Charset.forName("UTF-32LE");
        f28227g = TimeZone.getTimeZone("GMT");
        f28228h = new Comparator<String>() { // from class: com.bytedance.sdk.component.b.b.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
            }
        };
        r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static void a(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CMP_L]}, finally: {[CMP_L, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, IF] complete} */
    public static boolean b(s sVar, int i2, TimeUnit timeUnit) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65563, null, sVar, i2, timeUnit)) == null) {
            long nanoTime = System.nanoTime();
            long c_ = sVar.a().c() ? sVar.a().c_() - nanoTime : Long.MAX_VALUE;
            sVar.a().a(Math.min(c_, timeUnit.toNanos(i2)) + nanoTime);
            try {
                com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
                while (sVar.a(cVar, 8192L) != -1) {
                    cVar.r();
                }
                if (c_ == Long.MAX_VALUE) {
                    sVar.a().f();
                } else {
                    sVar.a().a(nanoTime + c_);
                }
                return true;
            } catch (InterruptedIOException unused) {
                if (c_ == Long.MAX_VALUE) {
                    sVar.a().f();
                } else {
                    sVar.a().a(nanoTime + c_);
                }
                return false;
            } catch (Throwable th) {
                if (c_ == Long.MAX_VALUE) {
                    sVar.a().f();
                } else {
                    sVar.a().a(nanoTime + c_);
                }
                throw th;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static String c(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65565, null, str, i2, i3)) == null) {
            int a2 = a(str, i2, i3);
            return str.substring(a2, b(str, a2, i3));
        }
        return (String) invokeLII.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? r.matcher(str).matches() : invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress d(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65567, null, str, i2, i3)) == null) {
            byte[] bArr = new byte[16];
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i2 < i3) {
                    if (i5 != 16) {
                        int i8 = i2 + 2;
                        if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                            if (i6 == -1) {
                                i5 += 2;
                                i6 = i5;
                                if (i8 != i3) {
                                    i7 = i8;
                                    i2 = i7;
                                    int i9 = 0;
                                    while (i2 < i3) {
                                    }
                                    i4 = i2 - i7;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            return null;
                        }
                        if (i5 != 0) {
                            if (str.regionMatches(i2, ":", 0, 1)) {
                                i2++;
                            } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i7, i3, bArr, i5 - 2)) {
                                return null;
                            } else {
                                i5 += 2;
                            }
                        }
                        i7 = i2;
                        i2 = i7;
                        int i92 = 0;
                        while (i2 < i3) {
                            int a2 = a(str.charAt(i2));
                            if (a2 == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + a2;
                            i2++;
                        }
                        i4 = i2 - i7;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i5 + 1;
                        bArr[i5] = (byte) ((i92 >>> 8) & 255);
                        i5 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i5 != 16) {
                if (i6 == -1) {
                    return null;
                }
                int i11 = i5 - i6;
                System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
                Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeLII.objValue;
    }

    public static void a(Socket socket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, socket) == null) || socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!a(e2)) {
                throw e2;
            }
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static boolean a(s sVar, int i2, TimeUnit timeUnit) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65555, null, sVar, i2, timeUnit)) == null) {
            try {
                return b(sVar, i2, timeUnit);
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    public static <T> List<T> a(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, list)) == null) ? Collections.unmodifiableList(new ArrayList(list)) : (List) invokeL.objValue;
    }

    public static <T> List<T> a(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tArr)) == null) ? Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone())) : (List) invokeL.objValue;
    }

    public static ThreadFactory a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, str, z)) == null) ? new ThreadFactory(str, z) { // from class: com.bytedance.sdk.component.b.b.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f28230a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f28231b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28230a = str;
                this.f28231b = z;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable, "tt_pangle_thread_" + this.f28230a);
                    thread.setDaemon(this.f28231b);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        } : (ThreadFactory) invokeLZ.objValue;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, comparator, strArr, strArr2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                int length = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (comparator.compare(str, strArr2[i2]) == 0) {
                        arrayList.add(str);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, comparator, strArr, strArr2)) == null) {
            if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String a(t tVar, boolean z) {
        InterceptResult invokeLZ;
        String g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, tVar, z)) == null) {
            if (tVar.g().contains(":")) {
                g2 = PreferencesUtil.LEFT_MOUNT + tVar.g() + PreferencesUtil.RIGHT_MOUNT;
            } else {
                g2 = tVar.g();
            }
            if (z || tVar.h() != t.a(tVar.c())) {
                return g2 + ":" + tVar.h();
            }
            return g2;
        }
        return (String) invokeLZ.objValue;
    }

    public static int b(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, null, str, i2, i3)) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean a(AssertionError assertionError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, assertionError)) == null) ? (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true : invokeL.booleanValue;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, comparator, strArr, str)) == null) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (comparator.compare(strArr[i2], str) == 0) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static String[] a(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, strArr, str)) == null) {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = str;
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }

    public static int a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int a(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            while (i2 < i3) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static int a(String str, int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            while (i2 < i3) {
                if (str.charAt(i2) == c2) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        InetAddress d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str.contains(":")) {
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    d2 = d(str, 1, str.length() - 1);
                } else {
                    d2 = d(str, 0, str.length());
                }
                if (d2 == null) {
                    return null;
                }
                byte[] address = d2.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (d(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, objArr)) == null) ? String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, eVar, charset)) == null) {
            if (eVar.a(0L, f28229i)) {
                eVar.h(f28229i.g());
                return f28225e;
            } else if (eVar.a(0L, j)) {
                eVar.h(j.g());
                return n;
            } else if (eVar.a(0L, k)) {
                eVar.h(k.g());
                return o;
            } else if (eVar.a(0L, l)) {
                eVar.h(l.g());
                return p;
            } else if (eVar.a(0L, m)) {
                eVar.h(m.g());
                return q;
            } else {
                return charset;
            }
        }
        return (Charset) invokeLL.objValue;
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Long.valueOf(j2), timeUnit})) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }
        return invokeCommon.intValue;
    }

    public static AssertionError a(String str, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, exc)) == null) ? (AssertionError) new AssertionError(str).initCause(exc) : (AssertionError) invokeLL.objValue;
    }

    public static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)})) == null) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            return i5 == i4 + 4;
        }
        return invokeCommon.booleanValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < bArr.length) {
                int i6 = i4;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i4;
                if (i7 > i5 && i7 >= 4) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
            while (i2 < bArr.length) {
                if (i2 == i3) {
                    cVar.i(58);
                    i2 += i5;
                    if (i2 == 16) {
                        cVar.i(58);
                    }
                } else {
                    if (i2 > 0) {
                        cVar.i(58);
                    }
                    cVar.k(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return cVar.o();
        }
        return (String) invokeL.objValue;
    }
}
