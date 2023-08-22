package com.baidu.tieba;

import android.content.pm.Signature;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes7.dex */
public class of1 {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public static WeakReference<byte[]> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948030223, "Lcom/baidu/tieba/of1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948030223, "Lcom/baidu/tieba/of1;");
                return;
            }
        }
        a = new Object();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0085, code lost:
        r11 = com.baidu.tieba.of1.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0087, code lost:
        monitor-enter(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0088, code lost:
        com.baidu.tieba.of1.b = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008a, code lost:
        monitor-exit(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008b, code lost:
        if (r4 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008e, code lost:
        if (r4.length <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0090, code lost:
        r11 = r4.length;
        r1 = new android.content.pm.Signature[r4.length];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:
        if (r6 >= r11) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0096, code lost:
        r1[r6] = new android.content.pm.Signature(r4[r6].getEncoded());
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Signature[] a(String str) {
        InterceptResult invokeL;
        JarFile jarFile;
        byte[] bArr;
        JarFile jarFile2;
        Signature[] signatureArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (a) {
                WeakReference<byte[]> weakReference = b;
                jarFile = null;
                if (weakReference != null) {
                    b = null;
                    bArr = weakReference.get();
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[8192];
                    weakReference = new WeakReference<>(bArr);
                }
            }
            try {
                jarFile2 = new JarFile(str);
                try {
                    Enumeration<JarEntry> entries = jarFile2.entries();
                    Certificate[] certificateArr = null;
                    while (true) {
                        int i = 0;
                        if (!entries.hasMoreElements()) {
                            break;
                        }
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                            Certificate[] b2 = b(jarFile2, nextElement, bArr);
                            if (b2 == null) {
                                try {
                                    jarFile2.close();
                                } catch (IOException unused) {
                                }
                                return null;
                            } else if (certificateArr == null) {
                                certificateArr = b2;
                            } else {
                                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < b2.length) {
                                            if (certificateArr[i2] != null && certificateArr[i2].equals(b2[i3])) {
                                                z = true;
                                                break;
                                            }
                                            i3++;
                                        } else {
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (!z || certificateArr.length != b2.length) {
                                        try {
                                            jarFile2.close();
                                        } catch (IOException unused2) {
                                        }
                                        return null;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                } catch (Exception unused3) {
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                jarFile2 = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (Signature[]) invokeL.objValue;
        }
        return signatureArr;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Certificate[] b(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jarFile, jarEntry, bArr)) == null) {
            BufferedInputStream bufferedInputStream2 = null;
            Certificate[] certificateArr = null;
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                    try {
                    } catch (IOException unused) {
                    } catch (RuntimeException unused2) {
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                if (jarEntry != null) {
                    certificateArr = jarEntry.getCertificates();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused4) {
                }
                return certificateArr;
            } catch (IOException unused5) {
                bufferedInputStream = null;
            } catch (RuntimeException unused6) {
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (Certificate[]) invokeLLL.objValue;
        }
    }
}
