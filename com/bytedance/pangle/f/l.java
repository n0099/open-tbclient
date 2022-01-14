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
/* loaded from: classes2.dex */
public final class l implements k {
    public static /* synthetic */ Interceptable $ic;
    public static final long a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final FileDescriptor f53067b;

    /* renamed from: c  reason: collision with root package name */
    public final long f53068c;

    /* renamed from: d  reason: collision with root package name */
    public final long f53069d;

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

    public l(FileDescriptor fileDescriptor, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53067b = fileDescriptor;
        this.f53068c = j2;
        this.f53069d = j3;
    }

    @Override // com.bytedance.pangle.f.k
    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53069d : invokeV.longValue;
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
    public final void a(j jVar, long j2, int i2) {
        int intValue;
        long mmap;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jVar, Long.valueOf(j2), Integer.valueOf(i2)}) != null) {
            return;
        }
        long j3 = this.f53068c + j2;
        long j4 = a;
        long j5 = (j3 / j4) * j4;
        int i3 = (int) (j3 - j5);
        long j6 = i2 + i3;
        try {
            try {
                try {
                    ByteBuffer byteBuffer2 = null;
                    try {
                        if (com.bytedance.pangle.util.g.c()) {
                            try {
                                intValue = ((Integer) FieldUtils.readField(com.bytedance.pangle.a.a.a.a(OsConstants.class, "MAP_POPULATE"), (Object) null)).intValue();
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            mmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.f53067b, j5);
                            if (!(Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT <= 28)) {
                                try {
                                    Constructor a2 = com.bytedance.pangle.a.a.a.a(Class.forName("java.nio.DirectByteBuffer"), Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE);
                                    if (a2 != null && a2.isAccessible()) {
                                        byteBuffer = (ByteBuffer) a2.newInstance(Integer.valueOf(i2), Long.valueOf(i3 + mmap), this.f53067b, null, Boolean.TRUE);
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
                                jVar.a(byteBuffer2);
                                if (mmap == 0) {
                                    try {
                                        Os.munmap(mmap, j6);
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
                                    byteBuffer = (ByteBuffer) a3.newInstance(Long.valueOf(i3 + mmap), Integer.valueOf(i2));
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
                    } catch (ErrnoException e14) {
                        e = e14;
                        throw new IOException("Failed to mmap " + j6 + " bytes", e);
                    }
                    intValue = 0;
                    mmap = Os.mmap(0L, j6, OsConstants.PROT_READ, OsConstants.MAP_SHARED | intValue, this.f53067b, j5);
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            Os.munmap(0L, j6);
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
        } catch (ErrnoException e15) {
            e = e15;
        }
    }
}
