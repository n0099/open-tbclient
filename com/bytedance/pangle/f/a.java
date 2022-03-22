package com.bytedance.pangle.f;

import android.content.pm.Signature;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<byte[]> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294140623, "Lcom/bytedance/pangle/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294140623, "Lcom/bytedance/pangle/f/a;");
                return;
            }
        }
        a = new AtomicReference<>();
    }

    public static o a(String str) {
        InterceptResult invokeL;
        JarFile jarFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JarFile jarFile2 = null;
            try {
                try {
                    jarFile = new JarFile(str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (RuntimeException e3) {
                e = e3;
            } catch (GeneralSecurityException e4) {
                e = e4;
            }
            try {
                ArrayList<JarEntry> arrayList = new ArrayList();
                JarEntry jarEntry = jarFile.getJarEntry(CommonMethods.ANDROID_MANIFEST_FILENAME);
                if (jarEntry != null) {
                    Certificate[][] a2 = a(jarFile, jarEntry);
                    if (!com.bytedance.pangle.util.b.a(a2)) {
                        Signature[] a3 = d.a(a2);
                        Enumeration<JarEntry> entries = jarFile.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                String name = nextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals(CommonMethods.ANDROID_MANIFEST_FILENAME)) {
                                    arrayList.add(nextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] a4 = a(jarFile, jarEntry2);
                            if (!com.bytedance.pangle.util.b.a(a4)) {
                                if (!o.a(a3, d.a(a4))) {
                                    throw new q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                                }
                            } else {
                                throw new q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                        }
                        o oVar = new o(a3, 1, null, null, null);
                        try {
                            jarFile.close();
                        } catch (Exception unused) {
                        }
                        return oVar;
                    }
                    throw new q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                }
                throw new q(1, "Package " + str + " has no manifest");
            } catch (IOException e5) {
                e = e5;
                throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
            } catch (RuntimeException e6) {
                e = e6;
                throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
            } catch (GeneralSecurityException e7) {
                e = e7;
                throw new q(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
            } catch (Throwable th2) {
                th = th2;
                jarFile2 = jarFile;
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        return (o) invokeL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0038: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:19:0x0038 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Certificate[][] a(JarFile jarFile, JarEntry jarEntry) {
        InterceptResult invokeLL;
        Throwable e2;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jarFile, jarEntry)) == null) {
            InputStream inputStream2 = null;
            try {
                try {
                    InputStream inputStream3 = jarFile.getInputStream(jarEntry);
                    try {
                        byte[] andSet = a.getAndSet(null);
                        if (andSet == null) {
                            andSet = new byte[4096];
                        }
                        do {
                        } while (inputStream3.read(andSet, 0, andSet.length) != -1);
                        a.set(andSet);
                        Certificate[][] certificateArr = {jarEntry.getCertificates()};
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            } catch (Exception unused) {
                            }
                        }
                        return certificateArr;
                    } catch (IOException e4) {
                        e2 = e4;
                        throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e2);
                    } catch (RuntimeException e5) {
                        e2 = e5;
                        throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (RuntimeException e6) {
                            throw e6;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                e2 = e;
                throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e2);
            } catch (RuntimeException e8) {
                e = e8;
                e2 = e;
                throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e2);
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }
        return (Certificate[][]) invokeLL.objValue;
    }
}
