package com.bytedance.pangle.f;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes8.dex */
public final class a {
    public static final AtomicReference<byte[]> a = new AtomicReference<>();

    public static o a(String str) {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (GeneralSecurityException e3) {
            e = e3;
        }
        try {
            ArrayList<JarEntry> arrayList = new ArrayList();
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry != null) {
                Certificate[][] a2 = a(jarFile, jarEntry);
                if (!com.bytedance.pangle.util.c.a(a2)) {
                    Signature[] a3 = d.a(a2);
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory()) {
                            String name = nextElement.getName();
                            if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                arrayList.add(nextElement);
                            }
                        }
                    }
                    for (JarEntry jarEntry2 : arrayList) {
                        Certificate[][] a4 = a(jarFile, jarEntry2);
                        if (!com.bytedance.pangle.util.c.a(a4)) {
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
        } catch (IOException e4) {
            e = e4;
            throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (GeneralSecurityException e6) {
            e = e6;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0034: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:17:0x0034 */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Certificate[][] a(JarFile jarFile, JarEntry jarEntry) {
        Throwable e;
        InputStream inputStream;
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
                        } catch (RuntimeException e2) {
                            throw e2;
                        } catch (Exception unused) {
                        }
                    }
                    return certificateArr;
                } catch (IOException e3) {
                    e = e3;
                    throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                } catch (RuntimeException e4) {
                    e = e4;
                    throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            e = e;
            throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (RuntimeException e7) {
            e = e7;
            e = e;
            throw new q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }
}
