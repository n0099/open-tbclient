package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.tieba.t00;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class r10 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public t00.a c;
    public ZipFile d;
    public PackageManager e;

    /* loaded from: classes8.dex */
    public class a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(r10 r10Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r10Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(".cfgtmp") : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b a(r10 r10Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r10Var)) == null) {
                try {
                    String b = r10Var.b("info");
                    if (TextUtils.isEmpty(b)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(b);
                    b bVar = new b();
                    bVar.a = jSONObject.getLong("version");
                    return bVar;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068632, "Lcom/baidu/tieba/r10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068632, "Lcom/baidu/tieba/r10;");
                return;
            }
        }
        f = new String[]{"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    }

    public r10() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                Bundle bundle = this.e.getPackageInfo(this.a, 128).applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString("com.baidu.helios.tc.qver");
                    if (TextUtils.isEmpty(string) || !string.startsWith("v")) {
                        return -1L;
                    }
                    return Long.valueOf(string.substring(1)).longValue();
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = e(str);
                    return p00.b(inputStream, "UTF-8");
                } catch (IOException e) {
                    throw new TrustSubject.ConfigNotFoundException(e);
                }
            } finally {
                o00.b(inputStream);
            }
        }
        return (String) invokeL.objValue;
    }

    public void c(String str, Context context, t00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, context, aVar) == null) {
            this.a = str;
            this.b = context;
            this.c = aVar;
            this.e = context.getPackageManager();
        }
    }

    public int d() {
        File file;
        FileOutputStream fileOutputStream;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.intValue;
        }
        try {
            AssetManager assets = this.b.createPackageContext(this.a, 0).getAssets();
            this.c.a();
            File k = k();
            InputStream inputStream = null;
            try {
                k.delete();
                file = File.createTempFile("cfg", ".cfgtmp", k.getParentFile());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            inputStream = assets.open("com.baidu.helios/c.dat");
                            p00.a(inputStream, fileOutputStream, 16384);
                            try {
                                X509Certificate[][] s = com.baidu.helios.trusts.zone.verifier.b.s(file);
                                if (s.length == 0) {
                                    o00.b(inputStream);
                                    o00.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return 3;
                                }
                                HashSet hashSet = new HashSet();
                                for (X509Certificate[] x509CertificateArr : s) {
                                    if (x509CertificateArr != null) {
                                        for (X509Certificate x509Certificate : x509CertificateArr) {
                                            if (x509Certificate != null) {
                                                hashSet.add(r00.c(x509Certificate.getSignature()));
                                            }
                                        }
                                    }
                                }
                                HashSet hashSet2 = new HashSet();
                                Collections.addAll(hashSet2, f);
                                if (!hashSet2.equals(hashSet)) {
                                    o00.b(inputStream);
                                    o00.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    return 3;
                                }
                                file.renameTo(k);
                                o00.b(inputStream);
                                o00.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused3) {
                                    }
                                }
                                return 0;
                            } catch (Exception unused4) {
                                o00.b(inputStream);
                                o00.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused5) {
                                    }
                                }
                                return 3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            o00.b(inputStream);
                            o00.b(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused6) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused7) {
                        o00.b(inputStream);
                        o00.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused8) {
                            }
                        }
                        return 5;
                    } catch (IOException unused9) {
                        o00.b(inputStream);
                        o00.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused10) {
                            }
                        }
                        return 2;
                    } catch (Exception unused11) {
                        o00.b(inputStream);
                        o00.b(fileOutputStream);
                        if (file != null) {
                            try {
                                file.delete();
                            } catch (Exception unused12) {
                            }
                        }
                        return 4;
                    }
                } catch (FileNotFoundException unused13) {
                    fileOutputStream = null;
                } catch (IOException unused14) {
                    fileOutputStream = null;
                } catch (Exception unused15) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException unused16) {
                file = null;
                fileOutputStream = null;
            } catch (IOException unused17) {
                file = null;
                fileOutputStream = null;
            } catch (Exception unused18) {
                file = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                file = null;
                fileOutputStream = null;
            }
        } catch (Exception unused19) {
            return 1;
        }
    }

    public final InputStream e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.d.getInputStream(new ZipEntry(str));
            } catch (Exception e) {
                throw new TrustSubject.ConfigNotFoundException(e);
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k().delete() : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            File[] listFiles = this.c.b().listFiles(new a(this));
            int i = 0;
            if (listFiles != null) {
                int length = listFiles.length;
                boolean z = false;
                while (i < length) {
                    listFiles[i].delete();
                    i++;
                    z = true;
                }
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d != null) {
                return true;
            }
            File k = k();
            if (k.exists()) {
                try {
                    this.d = new ZipFile(k);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ZipFile zipFile = this.d;
            if (zipFile != null) {
                o00.d(zipFile);
                this.d = null;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b a2 = b.a(this);
            if (a2 != null) {
                return a2.a;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c.d("c.dat") : (File) invokeV.objValue;
    }
}
