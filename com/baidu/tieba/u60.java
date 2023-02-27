package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier;
import com.baidu.tieba.w50;
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
/* loaded from: classes6.dex */
public class u60 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public w50.a c;
    public ZipFile d;
    public PackageManager e;

    /* loaded from: classes6.dex */
    public class a implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(u60 u60Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u60Var};
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.endsWith(".cfgtmp");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

        public static b a(u60 u60Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, u60Var)) == null) {
                try {
                    String f = u60Var.f("info");
                    if (!TextUtils.isEmpty(f)) {
                        JSONObject jSONObject = new JSONObject(f);
                        b bVar = new b();
                        bVar.a = jSONObject.getLong("version");
                        return bVar;
                    }
                    return null;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948162810, "Lcom/baidu/tieba/u60;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948162810, "Lcom/baidu/tieba/u60;");
                return;
            }
        }
        f = new String[]{"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    }

    public u60() {
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

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File[] listFiles = this.c.b().listFiles(new a(this));
            int i = 0;
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z = false;
            while (i < length) {
                listFiles[i].delete();
                i++;
                z = true;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ZipFile zipFile = this.d;
            if (zipFile != null) {
                r50.d(zipFile);
                this.d = null;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return g().delete();
        }
        return invokeV.booleanValue;
    }

    public final File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c.d("c.dat");
        }
        return (File) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b a2 = b.a(this);
            if (a2 != null) {
                return a2.a;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.d != null) {
                return true;
            }
            File g = g();
            if (g.exists()) {
                try {
                    this.d = new ZipFile(g);
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

    public int a() {
        File file;
        FileOutputStream fileOutputStream;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                AssetManager assets = this.b.createPackageContext(this.a, 0).getAssets();
                this.c.a();
                File g = g();
                InputStream inputStream = null;
                try {
                    g.delete();
                    file = File.createTempFile("cfg", ".cfgtmp", g.getParentFile());
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            try {
                                inputStream = assets.open("com.baidu.helios/c.dat");
                                s50.a(inputStream, fileOutputStream, 16384);
                                try {
                                    X509Certificate[][] v = ZipSignatureSchemeV2Verifier.v(file);
                                    if (v.length == 0) {
                                        r50.b(inputStream);
                                        r50.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        return 3;
                                    }
                                    HashSet hashSet = new HashSet();
                                    for (X509Certificate[] x509CertificateArr : v) {
                                        if (x509CertificateArr != null) {
                                            for (X509Certificate x509Certificate : x509CertificateArr) {
                                                if (x509Certificate != null) {
                                                    hashSet.add(u50.c(x509Certificate.getSignature()));
                                                }
                                            }
                                        }
                                    }
                                    HashSet hashSet2 = new HashSet();
                                    Collections.addAll(hashSet2, f);
                                    if (hashSet2.equals(hashSet)) {
                                        file.renameTo(g);
                                        r50.b(inputStream);
                                        r50.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception unused2) {
                                            }
                                        }
                                        return 0;
                                    }
                                    r50.b(inputStream);
                                    r50.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    return 3;
                                } catch (Exception unused4) {
                                    r50.b(inputStream);
                                    r50.b(fileOutputStream);
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
                                r50.b(inputStream);
                                r50.b(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused6) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException unused7) {
                            r50.b(inputStream);
                            r50.b(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused8) {
                                }
                            }
                            return 5;
                        } catch (IOException unused9) {
                            r50.b(inputStream);
                            r50.b(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Exception unused10) {
                                }
                            }
                            return 2;
                        } catch (Exception unused11) {
                            r50.b(inputStream);
                            r50.b(fileOutputStream);
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
        } else {
            return invokeV.intValue;
        }
    }

    public void b(String str, Context context, w50.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, context, aVar) == null) {
            this.a = str;
            this.b = context;
            this.c = aVar;
            this.e = context.getPackageManager();
        }
    }

    public String f(String str) throws TrustSubject.ConfigNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = h(str);
                    return s50.b(inputStream, "UTF-8");
                } catch (IOException e) {
                    throw new TrustSubject.ConfigNotFoundException(e);
                }
            } finally {
                r50.b(inputStream);
            }
        }
        return (String) invokeL.objValue;
    }

    public final InputStream h(String str) throws TrustSubject.ConfigNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                return this.d.getInputStream(new ZipEntry(str));
            } catch (Exception e) {
                throw new TrustSubject.ConfigNotFoundException(e);
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Bundle bundle = this.e.getPackageInfo(this.a, 128).applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString("com.baidu.helios.tc.qver");
                    if (!TextUtils.isEmpty(string) && string.startsWith("v")) {
                        return Long.valueOf(string.substring(1)).longValue();
                    }
                    return -1L;
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }
}
