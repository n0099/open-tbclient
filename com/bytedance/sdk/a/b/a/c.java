package com.bytedance.sdk.a.b.a;

import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.ac;
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
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f5872a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f5873b = new String[0];
    public static final com.bytedance.sdk.a.b.c ppt = com.bytedance.sdk.a.b.c.a(null, f5872a);
    public static final ac ppu = ac.b(null, f5872a);
    private static final f ppv = f.b("efbbbf");
    private static final f ppw = f.b("feff");
    private static final f ppx = f.b("fffe");
    private static final f ppy = f.b("0000ffff");
    private static final f ppz = f.b("ffff0000");
    public static final Charset ppA = Charset.forName("UTF-8");
    public static final Charset ppB = Charset.forName("ISO-8859-1");
    private static final Charset n = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset ppC = Charset.forName(CharEncoding.UTF_16LE);
    private static final Charset ppD = Charset.forName("UTF-32BE");
    private static final Charset ppE = Charset.forName("UTF-32LE");
    public static final TimeZone ppF = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> ppG = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.a.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern ppH = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!a(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public static boolean a(s sVar, int i, TimeUnit timeUnit) {
        try {
            return b(sVar, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[CMP_L]}, finally: {[CMP_L, INVOKE, INVOKE, INVOKE, ARITH, INVOKE, IF] complete} */
    public static boolean b(s sVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long eoL = sVar.eoy().c() ? sVar.eoy().eoL() - nanoTime : Long.MAX_VALUE;
        sVar.eoy().ip(Math.min(eoL, timeUnit.toNanos(i)) + nanoTime);
        try {
            com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
            while (sVar.b(cVar, 8192L) != -1) {
                cVar.r();
            }
            if (eoL == Long.MAX_VALUE) {
                sVar.eoy().eoN();
            } else {
                sVar.eoy().ip(eoL + nanoTime);
            }
            return true;
        } catch (InterruptedIOException e) {
            if (eoL == Long.MAX_VALUE) {
                sVar.eoy().eoN();
            } else {
                sVar.eoy().ip(eoL + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (eoL == Long.MAX_VALUE) {
                sVar.eoy().eoN();
            } else {
                sVar.eoy().ip(eoL + nanoTime);
            }
            throw th;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> P(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory bm(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.a.b.a.c.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (comparator.compare(str, strArr2[i]) != 0) {
                        i++;
                    } else {
                        arrayList.add(str);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String a(com.bytedance.sdk.a.b.s sVar, boolean z) {
        String f;
        if (sVar.f().contains(":")) {
            f = "[" + sVar.f() + "]";
        } else {
            f = sVar.f();
        }
        if (!z && sVar.g() == com.bytedance.sdk.a.b.s.a(sVar.b())) {
            return f;
        }
        return f + ":" + sVar.g();
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] b(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i3;
            }
        }
        return i2;
    }

    public static int b(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            switch (str.charAt(i3)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                default:
                    return i3 + 1;
            }
        }
        return i;
    }

    public static String C(String str, int i, int i2) {
        int a2 = a(str, i, i2);
        return str.substring(a2, b(str, a2, i2));
    }

    public static int a(String str, int i, int i2, String str2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str2.indexOf(str.charAt(i3)) != -1) {
                return i3;
            }
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) == c) {
                return i3;
            }
        }
        return i2;
    }

    public static String a(String str) {
        if (str.contains(":")) {
            InetAddress D = (str.startsWith("[") && str.endsWith("]")) ? D(str, 1, str.length() - 1) : D(str, 0, str.length());
            if (D == null) {
                return null;
            }
            byte[] address = D.getAddress();
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
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return true;
            }
            if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str) {
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > 31 && charAt < 127) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    public static boolean c(String str) {
        return ppH.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        if (eVar.a(0L, ppv)) {
            eVar.h(ppv.g());
            return ppA;
        } else if (eVar.a(0L, ppw)) {
            eVar.h(ppw.g());
            return n;
        } else if (eVar.a(0L, ppx)) {
            eVar.h(ppx.g());
            return ppC;
        } else if (eVar.a(0L, ppy)) {
            eVar.h(ppy.g());
            return ppD;
        } else if (eVar.a(0L, ppz)) {
            eVar.h(ppz.g());
            return ppE;
        } else {
            return charset;
        }
    }

    public static int a(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static AssertionError f(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static int a(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static InetAddress D(String str, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = -1;
        int i7 = -1;
        int i8 = 0;
        while (true) {
            if (i5 < i2) {
                if (i8 != bArr.length) {
                    if (i5 + 2 <= i2 && str.regionMatches(i5, "::", 0, 2)) {
                        if (i7 == -1) {
                            i6 = i5 + 2;
                            int i9 = i8 + 2;
                            if (i6 != i2) {
                                i7 = i9;
                                i8 = i9;
                                int i10 = 0;
                                i3 = i6;
                                while (i3 < i2) {
                                }
                                i4 = i3 - i6;
                                if (i4 == 0) {
                                    break;
                                }
                                break;
                            }
                            i7 = i9;
                            i8 = i9;
                            break;
                        }
                        return null;
                    }
                    if (i8 == 0) {
                        i6 = i5;
                    } else if (str.regionMatches(i5, ":", 0, 1)) {
                        i6 = i5 + 1;
                    } else {
                        if (str.regionMatches(i5, ".", 0, 1) && a(str, i6, i2, bArr, i8 - 2)) {
                            i8 += 2;
                        }
                        return null;
                    }
                    int i102 = 0;
                    i3 = i6;
                    while (i3 < i2) {
                        int a2 = a(str.charAt(i3));
                        if (a2 == -1) {
                            break;
                        }
                        i102 = (i102 << 4) + a2;
                        i3++;
                    }
                    i4 = i3 - i6;
                    if (i4 == 0 || i4 > 4) {
                        break;
                    }
                    int i11 = i8 + 1;
                    bArr[i8] = (byte) ((i102 >>> 8) & 255);
                    i8 = i11 + 1;
                    bArr[i11] = (byte) (i102 & 255);
                    i5 = i3;
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i8 != bArr.length) {
            if (i7 == -1) {
                return null;
            }
            System.arraycopy(bArr, i7, bArr, bArr.length - (i8 - i7), i8 - i7);
            Arrays.fill(bArr, i7, (bArr.length - i8) + i7, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i;
        int i5 = i3;
        while (i4 < i2) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i3) {
                if (str.charAt(i4) != '.') {
                    return false;
                }
                i4++;
            }
            int i6 = 0;
            int i7 = i4;
            while (i7 < i2) {
                char charAt = str.charAt(i7);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i6 != 0 || i4 == i7) && ((i6 * 10) + charAt) - 48 <= 255) {
                    i7++;
                }
                return false;
            }
            if (i7 - i4 == 0) {
                return false;
            }
            bArr[i5] = (byte) i6;
            i4 = i7;
            i5++;
        }
        return i5 == i3 + 4;
    }

    private static String a(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i4 = i6;
                i2 = i3;
            }
            i3 = i5 + 2;
        }
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        while (i < bArr.length) {
            if (i == i2) {
                cVar.OB(58);
                i += i4;
                if (i == 16) {
                    cVar.OB(58);
                }
            } else {
                if (i > 0) {
                    cVar.OB(58);
                }
                cVar.in(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return cVar.o();
    }
}
