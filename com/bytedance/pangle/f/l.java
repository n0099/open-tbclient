package com.bytedance.pangle.f;

import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class l implements k {
    public static final long a = Os.sysconf(OsConstants._SC_PAGESIZE);
    public final FileDescriptor b;
    public final long c;
    public final long d;

    @Override // com.bytedance.pangle.f.k
    public final long a() {
        return this.d;
    }

    public l(FileDescriptor fileDescriptor, long j, long j2) {
        this.b = fileDescriptor;
        this.c = j;
        this.d = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.f.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(j jVar, long j, int i) {
        ByteBuffer byteBuffer;
        int intValue;
        long mmap;
        boolean z;
        ByteBuffer byteBuffer2;
        long j2 = this.c + j;
        long j3 = a;
        long j4 = (j2 / j3) * j3;
        int i2 = (int) (j2 - j4);
        long j5 = i + i2;
        try {
            try {
                try {
                    byteBuffer = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            Os.munmap(0L, j5);
                        } catch (ErrnoException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (ErrnoException e) {
            e = e;
        }
        try {
            if (com.bytedance.pangle.util.h.c()) {
                try {
                    intValue = ((Integer) FieldUtils.readField(com.bytedance.pangle.a.a.a.a(OsConstants.class, "MAP_POPULATE"), (Object) null)).intValue();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                mmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.b, j4);
                if (Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT <= 28) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    try {
                        Constructor a2 = com.bytedance.pangle.a.a.a.a(Class.forName("java.nio.DirectByteBuffer"), Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE);
                        if (a2 != null && a2.isAccessible()) {
                            byteBuffer2 = (ByteBuffer) a2.newInstance(Integer.valueOf(i), Long.valueOf(i2 + mmap), this.b, null, Boolean.TRUE);
                        }
                    } catch (ClassNotFoundException e4) {
                        e4.printStackTrace();
                    } catch (IllegalAccessException e5) {
                        e5.printStackTrace();
                    } catch (InstantiationException e6) {
                        e6.printStackTrace();
                    } catch (InvocationTargetException e7) {
                        e7.printStackTrace();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                    jVar.a(byteBuffer);
                    if (mmap == 0) {
                        try {
                            Os.munmap(mmap, j5);
                            return;
                        } catch (ErrnoException unused2) {
                            return;
                        }
                    }
                    return;
                }
                try {
                    Constructor a3 = com.bytedance.pangle.a.a.a.a(Class.forName("java.nio.DirectByteBuffer"), Long.TYPE, Integer.TYPE);
                    if (a3 != null && a3.isAccessible()) {
                        byteBuffer2 = (ByteBuffer) a3.newInstance(Long.valueOf(i2 + mmap), Integer.valueOf(i));
                    }
                } catch (ClassNotFoundException e9) {
                    e9.printStackTrace();
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (InstantiationException e11) {
                    e11.printStackTrace();
                } catch (InvocationTargetException e12) {
                    e12.printStackTrace();
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                jVar.a(byteBuffer);
                if (mmap == 0) {
                }
                byteBuffer = byteBuffer2;
                jVar.a(byteBuffer);
                if (mmap == 0) {
                }
            }
            if (Build.VERSION.SDK_INT < 24) {
            }
            z = false;
            if (!z) {
            }
            byteBuffer = byteBuffer2;
            jVar.a(byteBuffer);
            if (mmap == 0) {
            }
        } catch (ErrnoException e14) {
            e = e14;
            throw new IOException("Failed to mmap " + j5 + " bytes", e);
        }
        intValue = 0;
        mmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.b, j4);
    }
}
