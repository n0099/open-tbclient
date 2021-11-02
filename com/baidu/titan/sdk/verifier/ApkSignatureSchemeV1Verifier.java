package com.baidu.titan.sdk.verifier;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes10.dex */
public class ApkSignatureSchemeV1Verifier {
    public static final String TAG = "SignatureVerifierV1";
    public static Object mSync = new Object();
    public static WeakReference<byte[]> sReadBuffer;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
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
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                bufferedInputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            bufferedInputStream = null;
        } catch (RuntimeException unused6) {
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Certificate[] verify(File file) {
        WeakReference<byte[]> weakReference;
        JarFile jarFile;
        byte[] bArr;
        JarFile jarFile2;
        boolean z;
        synchronized (mSync) {
            weakReference = sReadBuffer;
            jarFile = null;
            if (weakReference != null) {
                sReadBuffer = null;
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
            jarFile2 = new JarFile(file);
            try {
                Enumeration<JarEntry> entries = jarFile2.entries();
                Certificate[] certificateArr = null;
                while (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                        Certificate[] loadCertificates = loadCertificates(jarFile2, nextElement, bArr);
                        if (loadCertificates == null) {
                            try {
                                jarFile2.close();
                            } catch (IOException unused) {
                            }
                            return null;
                        } else if (certificateArr == null) {
                            certificateArr = loadCertificates;
                        } else {
                            for (int i2 = 0; i2 < certificateArr.length; i2++) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= loadCertificates.length) {
                                        z = false;
                                        break;
                                    } else if (certificateArr[i2] != null && certificateArr[i2].equals(loadCertificates[i3])) {
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z || certificateArr.length != loadCertificates.length) {
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
                synchronized (mSync) {
                    sReadBuffer = weakReference;
                }
                if (certificateArr == null || certificateArr.length <= 0) {
                    try {
                        jarFile2.close();
                    } catch (IOException unused3) {
                    }
                    return null;
                }
                try {
                    jarFile2.close();
                } catch (IOException unused4) {
                }
                return certificateArr;
            } catch (Exception unused5) {
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                jarFile = jarFile2;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (Exception unused8) {
            jarFile2 = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
