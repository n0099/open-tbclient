package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k50 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public a b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863939, "Lcom/baidu/tieba/k50;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863939, "Lcom/baidu/tieba/k50;");
                return;
            }
        }
        c = i40.a & false;
    }

    public k50(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        c().mkdirs();
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            file.mkdirs();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0068 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    public static String e(File file, String str, String str2, boolean z) {
        ?? r1;
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r1 = 65539;
            InterceptResult invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, str, str2, Boolean.valueOf(z)});
            if (invokeCommon != null) {
                return (String) invokeCommon.objValue;
            }
        }
        a(file);
        File file2 = new File(file, str);
        try {
            try {
                str = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            fileInputStream = null;
            e = e2;
            str = 0;
        } catch (Throwable th3) {
            r1 = 0;
            th = th3;
            str = 0;
        }
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    str.write(bArr, 0, read);
                }
                byte[] byteArray = str.toByteArray();
                if (z) {
                    byteArray = new s40().a(byteArray);
                }
                String str3 = new String(byteArray, str2);
                f50.b(fileInputStream);
                f50.b(str);
                return str3;
            } catch (Exception e3) {
                e = e3;
                if (c) {
                    Log.e("Helios", "r err", e);
                }
                f50.b(fileInputStream);
                f50.b(str);
                return "";
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e = e4;
        } catch (Throwable th4) {
            r1 = 0;
            th = th4;
            f50.b(r1);
            f50.b(str);
            throw th;
        }
    }

    public static boolean f(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new s40().b(str2.getBytes(str3)));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                f50.b(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                f50.b(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                f50.b(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(this.a.getApplicationInfo().dataDir) : (File) invokeV.objValue;
    }

    public final File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new File(b(), ".helios") : (File) invokeV.objValue;
    }

    public synchronized a d() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = new a(this, ".helios", null);
                }
                aVar = this.b;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File a;
        public String b;
        public a c;
        public boolean d;
        public final /* synthetic */ k50 e;

        public a(k50 k50Var, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k50Var, str, aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = k50Var;
            this.d = false;
            this.b = str;
            this.c = aVar;
            this.d = false;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b().mkdirs();
            }
        }

        public File b() {
            InterceptResult invokeV;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                File file2 = this.a;
                if (file2 != null) {
                    return file2;
                }
                if (this.c == null) {
                    file = new File(this.e.b(), this.b);
                } else {
                    file = new File(this.c.b(), this.b);
                }
                this.a = file;
                return file;
            }
            return (File) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public File d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new File(this.a, str) : (File) invokeL.objValue;
        }

        public a e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (a) invokeV.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? new a(this.e, str, this) : (a) invokeL.objValue;
        }

        public String g(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? k50.e(b(), str, "UTF-8", z) : (String) invokeLZ.objValue;
        }

        public a h(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
                if (!this.d) {
                    ArrayList arrayList = new ArrayList();
                    a aVar = this;
                    do {
                        arrayList.add(aVar.c());
                        aVar = aVar.e();
                    } while (aVar != null);
                    int size = arrayList.size() - 1;
                    while (size >= 0) {
                        size--;
                        file = new File(file, (String) arrayList.get(size));
                    }
                    return new a(this.e, file);
                }
                throw new IllegalStateException("isolate session is not support");
            }
            return (a) invokeL.objValue;
        }

        public boolean i(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z)) == null) ? k50.f(b(), str, str2, "UTF-8", z) : invokeLLZ.booleanValue;
        }

        public a(k50 k50Var, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k50Var, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k50Var;
            this.d = false;
            this.d = true;
            this.a = file;
            this.b = file.getName();
        }
    }
}
