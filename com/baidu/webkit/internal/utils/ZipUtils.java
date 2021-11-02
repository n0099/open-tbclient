package com.baidu.webkit.internal.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/* loaded from: classes11.dex */
public class ZipUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static ZipUtils singleton;
    public transient /* synthetic */ FieldHolder $fh;
    public ZipEntry nextEntry;

    /* loaded from: classes11.dex */
    public class a extends ZipInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ZipUtils f61020a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ZipUtils zipUtils, InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipUtils, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61020a = zipUtils;
        }

        @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                if (j >= 0) {
                    int min = (int) Math.min(j, 4096L);
                    byte[] bArr = new byte[min];
                    while (j2 != j) {
                        long j3 = j - j2;
                        long j4 = min;
                        if (j4 <= j3) {
                            j3 = j4;
                        }
                        int read = read(bArr, 0, (int) j3);
                        if (read <= 0) {
                            return j2;
                        }
                        j2 += read;
                    }
                    return j2;
                }
                throw new IllegalArgumentException();
            }
            return invokeJ.longValue;
        }
    }

    public ZipUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ZipUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (singleton == null) {
                singleton = new ZipUtils();
            }
            return singleton;
        }
        return (ZipUtils) invokeV.objValue;
    }

    private void getNextEntry(ZipInputStream zipInputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, zipInputStream) == null) {
            try {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    while (true) {
                        this.nextEntry = nextEntry;
                        if (this.nextEntry == null || !this.nextEntry.isDirectory()) {
                            break;
                        }
                        nextEntry = zipInputStream.getNextEntry();
                    }
                    if (this.nextEntry == null) {
                        safeClose(zipInputStream);
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("could not get next zip entry", e2);
                } catch (RuntimeException unused) {
                    if (this.nextEntry == null) {
                        safeClose(zipInputStream);
                    }
                }
            } catch (Throwable th) {
                if (this.nextEntry == null) {
                    safeClose(zipInputStream);
                }
                throw th;
            }
        }
    }

    private void pushEntry(Stack<String> stack, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, stack, str, strArr) == null) {
            if (str != null) {
                str = str + "/";
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                stack.push(str != null ? str + strArr[i2] : strArr[i2]);
            }
        }
    }

    private void safeClose(ZipInputStream zipInputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, zipInputStream) == null) || zipInputStream == null) {
            return;
        }
        try {
            zipInputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public boolean unZip(Context context, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            try {
                try {
                    aVar = new a(this, new BufferedInputStream(new FileInputStream(str)));
                    try {
                        getNextEntry(aVar);
                        bufferedOutputStream = null;
                        boolean z3 = this.nextEntry == null;
                        while (this.nextEntry != null) {
                            try {
                                byte[] bArr = new byte[4096];
                                String name = this.nextEntry.getName();
                                if (str3 != null) {
                                    if (name.startsWith(str3)) {
                                        name = name.substring(str3.length());
                                    } else {
                                        getNextEntry(aVar);
                                    }
                                }
                                File file = new File(str2 + name);
                                com.baidu.webkit.internal.utils.a.a(file.getAbsolutePath());
                                File file2 = new File(file.getParent());
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 4096);
                                while (true) {
                                    try {
                                        int read = aVar.read(bArr, 0, 4096);
                                        if (read <= 0) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        try {
                                            th.printStackTrace();
                                            if (aVar != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            if (bufferedOutputStream != null) {
                                                bufferedOutputStream.close();
                                            }
                                            return z2;
                                        } catch (Throwable th3) {
                                            if (aVar != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (Throwable th4) {
                                                    th4.printStackTrace();
                                                }
                                            }
                                            throw th3;
                                        }
                                    }
                                }
                                getNextEntry(aVar);
                                if (z) {
                                    com.baidu.webkit.internal.utils.a.a(file);
                                }
                                bufferedOutputStream2.close();
                                bufferedOutputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                        z2 = !z3;
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable th6) {
                        bufferedOutputStream = null;
                        th = th6;
                    }
                } catch (Throwable th7) {
                    bufferedOutputStream = null;
                    th = th7;
                    aVar = null;
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th8) {
                th8.printStackTrace();
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public boolean unZip(Context context, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) ? unZip(context, str, str2, null, z) : invokeCommon.booleanValue;
    }

    public boolean zip(String str, String str2, String str3, String[] strArr) {
        InterceptResult invokeLLLL;
        ZipOutputStream zipOutputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, strArr)) != null) {
            return invokeLLLL.booleanValue;
        }
        byte[] bArr = new byte[512];
        Stack<String> stack = new Stack<>();
        if (str == null || str2 == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            String str4 = str + "/";
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str3)));
            try {
                File file = new File(str4 + str2);
                if (file.isDirectory()) {
                    pushEntry(stack, null, file.list());
                } else {
                    stack.push(str2);
                }
                FileInputStream fileInputStream2 = null;
                while (stack.size() > 0) {
                    try {
                        String pop = stack.pop();
                        if (strArr != null) {
                            for (String str5 : strArr) {
                                if (str5.equals(pop)) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            String str6 = str4 + pop;
                            File file2 = new File(str6);
                            if (file2.isDirectory()) {
                                zipOutputStream.putNextEntry(new ZipEntry(pop + "/"));
                                pushEntry(stack, pop, file2.list());
                            } else {
                                zipOutputStream.putNextEntry(new ZipEntry(pop));
                                FileInputStream fileInputStream3 = new FileInputStream(str6);
                                while (true) {
                                    try {
                                        int read = fileInputStream3.read(bArr);
                                        if (read > 0) {
                                            zipOutputStream.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (Throwable unused) {
                                                fileInputStream2 = fileInputStream3;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream3;
                                        try {
                                            th.printStackTrace();
                                            if (zipOutputStream != null) {
                                                try {
                                                    zipOutputStream.close();
                                                    return false;
                                                } catch (Throwable unused2) {
                                                    return false;
                                                }
                                            }
                                            return false;
                                        } finally {
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            if (zipOutputStream != null) {
                                                try {
                                                    zipOutputStream.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                        }
                                    }
                                }
                                fileInputStream3.close();
                                fileInputStream2 = null;
                            }
                            zipOutputStream.closeEntry();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                    }
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable unused5) {
                    }
                }
                try {
                    zipOutputStream.close();
                } catch (Throwable unused6) {
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
        }
    }
}
