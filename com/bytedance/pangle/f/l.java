package com.bytedance.pangle.f;

import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class l implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileDescriptor b;
    public final long c;
    public final long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-294140282, "Lcom/bytedance/pangle/f/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-294140282, "Lcom/bytedance/pangle/f/l;");
                return;
            }
        }
        a = Os.sysconf(OsConstants._SC_PAGESIZE);
    }

    public l(FileDescriptor fileDescriptor, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileDescriptor, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = fileDescriptor;
        this.c = j;
        this.d = j2;
    }

    @Override // com.bytedance.pangle.f.k
    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.f.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(j jVar, long j, int i) {
        int intValue;
        long mmap;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jVar, Long.valueOf(j), Integer.valueOf(i)}) != null) {
            return;
        }
        long j2 = this.c + j;
        long j3 = a;
        long j4 = (j2 / j3) * j3;
        int i2 = (int) (j2 - j4);
        long j5 = i + i2;
        try {
            try {
                try {
                    ByteBuffer byteBuffer2 = null;
                    try {
                        if (com.bytedance.pangle.util.h.c()) {
                            try {
                                intValue = ((Integer) FieldUtils.readField(com.bytedance.pangle.a.a.a.a(OsConstants.class, "MAP_POPULATE"), (Object) null)).intValue();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            mmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.b, j4);
                            if (!(Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT <= 28)) {
                                try {
                                    Constructor a2 = com.bytedance.pangle.a.a.a.a(Class.forName("java.nio.DirectByteBuffer"), Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE);
                                    if (a2 != null && a2.isAccessible()) {
                                        byteBuffer = (ByteBuffer) a2.newInstance(Integer.valueOf(i), Long.valueOf(i2 + mmap), this.b, null, Boolean.TRUE);
                                    }
                                } catch (ClassNotFoundException e3) {
                                    e3.printStackTrace();
                                } catch (IllegalAccessException e4) {
                                    e4.printStackTrace();
                                } catch (InstantiationException e5) {
                                    e5.printStackTrace();
                                } catch (InvocationTargetException e6) {
                                    e6.printStackTrace();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                }
                                jVar.a(byteBuffer2);
                                if (mmap == 0) {
                                    try {
                                        Os.munmap(mmap, j5);
                                        return;
                                    } catch (ErrnoException unused) {
                                        return;
                                    }
                                }
                                return;
                            }
                            try {
                                Constructor a3 = com.bytedance.pangle.a.a.a.a(Class.forName("java.nio.DirectByteBuffer"), Long.TYPE, Integer.TYPE);
                                if (a3 != null && a3.isAccessible()) {
                                    byteBuffer = (ByteBuffer) a3.newInstance(Long.valueOf(i2 + mmap), Integer.valueOf(i));
                                }
                            } catch (ClassNotFoundException e8) {
                                e8.printStackTrace();
                            } catch (IllegalAccessException e9) {
                                e9.printStackTrace();
                            } catch (InstantiationException e10) {
                                e10.printStackTrace();
                            } catch (InvocationTargetException e11) {
                                e11.printStackTrace();
                            } catch (Exception e12) {
                                e12.printStackTrace();
                            }
                            jVar.a(byteBuffer2);
                            if (mmap == 0) {
                            }
                            byteBuffer2 = byteBuffer;
                            jVar.a(byteBuffer2);
                            if (mmap == 0) {
                            }
                        }
                        if (!(Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT <= 28)) {
                        }
                        byteBuffer2 = byteBuffer;
                        jVar.a(byteBuffer2);
                        if (mmap == 0) {
                        }
                    } catch (ErrnoException e13) {
                        e = e13;
                        throw new IOException("Failed to mmap " + j5 + " bytes", e);
                    }
                    intValue = 0;
                    mmap = Os.mmap(0L, j5, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.b, j4);
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            Os.munmap(0L, j5);
                        } catch (ErrnoException unused2) {
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
        } catch (ErrnoException e14) {
            e = e14;
        }
    }
}
