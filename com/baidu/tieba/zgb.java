package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes8.dex */
public class zgb {
    public static /* synthetic */ Interceptable $ic;
    public static HandlerThread a;
    public static Handler b;
    public static Thread c;
    public static LinkedList<pgb> d;
    public static String e;
    public static final char[] f;
    public static String g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pgb a;

        public a(pgb pgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download success");
                pgb pgbVar = this.a;
                if (pgbVar != null) {
                    pgbVar.onLibDownloadSuccess();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pgb a;

        public b(pgb pgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download in progress");
                pgb pgbVar = this.a;
                if (pgbVar != null) {
                    pgbVar.onLibDownloading();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pgb a;

        public c(pgb pgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Log.i("TransvodSoLoader", "on download success");
                pgb pgbVar = this.a;
                if (pgbVar != null) {
                    pgbVar.onLibDownloadSuccess();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final f b;
        public final /* synthetic */ File c;
        public final /* synthetic */ String d;
        public final /* synthetic */ pgb e;
        public final /* synthetic */ File f;

        public d(File file, String str, pgb pgbVar, File file2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str, pgbVar, file2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = file;
            this.d = str;
            this.e = pgbVar;
            this.f = file2;
            this.a = true;
            this.b = new f(null);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(String str) {
            URL url;
            HttpURLConnection httpURLConnection;
            int i;
            int contentLength;
            BufferedInputStream bufferedInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = true;
                HttpURLConnection httpURLConnection2 = null;
                try {
                    url = new URL(str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                int i2 = 0;
                if (url == null) {
                    Log.e("TransvodSoLoader", "url error " + str);
                    this.a = false;
                    return;
                }
                Log.i("TransvodSoLoader", "open connection to " + url);
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        if (Build.VERSION.SDK_INT < 21 && (httpURLConnection instanceof HttpsURLConnection)) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new uib());
                        }
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(6000);
                        httpURLConnection.connect();
                        i = httpURLConnection.getResponseCode();
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        th.printStackTrace();
                        Log.e("TransvodSoLoader", "open connection except!");
                        httpURLConnection = httpURLConnection2;
                        i = 0;
                        if (httpURLConnection != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (httpURLConnection != null) {
                    Log.e("TransvodSoLoader", "open connection failed!");
                    this.a = false;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                f fVar = this.b;
                sb.append(fVar.f);
                sb.append("-");
                sb.append(i);
                fVar.f = sb.toString();
                try {
                    contentLength = httpURLConnection.getContentLength();
                    Log.i("TransvodSoLoader", "total length " + contentLength);
                } finally {
                    try {
                    } finally {
                    }
                }
                if (contentLength < 0) {
                    this.a = false;
                    return;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.c, zgb.s(str, this.d)));
                byte[] bArr = new byte[1024];
                Log.i("TransvodSoLoader", "download " + zgb.s(str, this.d) + " start");
                long nanoTime = System.nanoTime();
                long j = nanoTime;
                int i3 = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, i2, read);
                    i3 += read;
                    long nanoTime2 = System.nanoTime();
                    if (nanoTime2 - j > 1000000000) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("download progress ");
                        sb2.append(i3);
                        sb2.append("/");
                        sb2.append(contentLength);
                        sb2.append(" speed ");
                        bufferedInputStream = bufferedInputStream2;
                        sb2.append((i3 * 1000000000) / (nanoTime2 - nanoTime));
                        sb2.append(" bytes/sec");
                        Log.i("TransvodSoLoader", sb2.toString());
                        j = nanoTime2;
                    } else {
                        bufferedInputStream = bufferedInputStream2;
                    }
                    bufferedInputStream2 = bufferedInputStream;
                    i2 = 0;
                }
                fileOutputStream.close();
                Log.i("TransvodSoLoader", "download " + zgb.s(str, this.d) + " end");
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            synchronized (zgb.d) {
                zgb.d.clear();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (int i = 0; !zgb.C(this.b) && i < 3; i++) {
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                zgb.c();
                synchronized (zgb.d) {
                    Iterator it = zgb.d.iterator();
                    while (it.hasNext()) {
                        pgb pgbVar = (pgb) it.next();
                        if (pgbVar != null) {
                            pgbVar.onLibDownloadSuccess();
                        }
                    }
                    zgb.d.clear();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Thread.currentThread().setName("yrtcSoDownload");
                this.b.a = this.d;
                long currentTimeMillis = System.currentTimeMillis();
                String[] z2 = zgb.z(this.d);
                pgb pgbVar = this.e;
                if (pgbVar != null) {
                    pgbVar.onLibDownloading();
                }
                int length = z2.length;
                boolean z3 = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = z2[i];
                    int i2 = 0;
                    while (true) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        a(str);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (str.endsWith(".zip") && this.a) {
                            this.b.d = currentTimeMillis3 - currentTimeMillis2;
                        }
                        if (this.a) {
                            break;
                        }
                        int i3 = i2 + 1;
                        if (i2 >= 5) {
                            i2 = i3;
                            break;
                        }
                        i2 = i3;
                    }
                    if (!this.a && str.endsWith(".zip")) {
                        this.b.g = -1;
                        break;
                    }
                    this.b.b += i2;
                    i++;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                this.b.c = currentTimeMillis4 - currentTimeMillis;
                boolean B = zgb.B(this.c, this.d);
                if (!this.a || !B) {
                    z = false;
                } else {
                    z = zgb.w(this.c, this.d);
                    if (z) {
                        zgb.G(this.c, this.f, this.d);
                        z3 = zgb.l(this.f);
                        this.b.e = System.currentTimeMillis() - currentTimeMillis4;
                        if (z3) {
                            c();
                        } else {
                            zgb.o(this.f);
                            b();
                        }
                        if (this.a) {
                            f fVar = this.b;
                            if (fVar.g != -1) {
                                fVar.g = -2;
                            }
                        } else if (!B) {
                            this.b.g = -2;
                        } else if (!z) {
                            this.b.g = -3;
                        } else if (!z3) {
                            this.b.g = -4;
                        }
                        d();
                        Thread unused = zgb.c = null;
                    }
                }
                if (this.e != null) {
                    b();
                }
                if (this.a) {
                }
                d();
                Thread unused2 = zgb.c = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.contains("transvod");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public long d;
        public long e;
        public String f;
        public int g;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = "";
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "&abi=" + this.a + "&retry=" + this.b + "&dotm=" + this.c + "&succm=" + this.d + "&unzip=" + this.e + "&err=" + this.f + "&res=" + this.g;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948360404, "Lcom/baidu/tieba/zgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948360404, "Lcom/baidu/tieba/zgb;");
                return;
            }
        }
        d = new LinkedList<>();
        e = null;
        f = "0123456789abcdef".toCharArray();
        g = null;
        h = null;
    }

    public static String q() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                str = Build.SUPPORTED_ABIS[0];
            } else {
                str = Build.CPU_ABI;
            }
            if (str.contains("arm")) {
                if (u()) {
                    return "arm64-v8a";
                }
                return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String A(String str) {
        MessageDigest messageDigest;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest == null) {
                return "";
            }
            messageDigest.update(str.getBytes());
            return k(messageDigest.digest());
        }
        return (String) invokeL.objValue;
    }

    public static String k(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bArr)) == null) {
            char[] cArr = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = f;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    public static boolean l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, file)) == null) {
            File file2 = new File(file, "transvod");
            if (!file2.exists()) {
                return false;
            }
            File file3 = new File(file2, "libtransvod.so");
            if (!file3.exists()) {
                return false;
            }
            return D(file3).equals(h);
        }
        return invokeL.booleanValue;
    }

    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists()) {
                return null;
            }
            q();
            File file2 = new File(file, "libtransvod.so");
            if (!file2.exists()) {
                return null;
            }
            return file2.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized boolean B(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, str)) == null) {
            synchronized (zgb.class) {
                File file2 = new File(file, s("*.sha1", str));
                boolean z = false;
                if (!file2.exists()) {
                    return false;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                    g = bufferedReader.readLine();
                    h = bufferedReader.readLine();
                    Log.i("TransvodSoLoader", "soload sha1 zip " + g);
                    Log.i("TransvodSoLoader", "soload sha1 so " + h);
                    bufferedReader.close();
                    z = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean E(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (str == null) {
                str = q();
            }
            File filesDir = context.getFilesDir();
            File file = new File(filesDir, "transvod");
            if (!file.exists()) {
                return false;
            }
            String[] strArr = {"libtransvod.so"};
            for (int i = 0; i < 1; i++) {
                if (!new File(file, strArr[i]).exists()) {
                    return false;
                }
            }
            if (!new File(file, s("*.sha1", str)).exists()) {
                return false;
            }
            if (!B(file, str)) {
                Log.i("TransvodSoLoader", "so sha1 read false " + filesDir.getAbsolutePath());
                return false;
            }
            boolean l = l(filesDir);
            Log.i("TransvodSoLoader", "so sha1 check ret " + l);
            return l;
        }
        return invokeLL.booleanValue;
    }

    public static boolean C(f fVar) {
        InterceptResult invokeL;
        URL url;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fVar)) == null) {
            boolean z = false;
            if (fVar == null) {
                return false;
            }
            String str = "http://mlog.bigda.com/c.gif?act=sodownload" + r() + fVar.toString() + "&mod=1";
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(str);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                url = null;
            }
            if (url == null) {
                Log.e("TransvodSoLoader", "report url failed!");
                return false;
            }
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(6000);
                    httpURLConnection2.connect();
                    int responseCode = httpURLConnection2.getResponseCode();
                    Log.i("TransvodSoLoader", "url : " + str);
                    Log.i("TransvodSoLoader", "code : " + responseCode);
                    if (responseCode == 200) {
                        z = true;
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    try {
                        th.printStackTrace();
                        Log.e("TransvodSoLoader", "open connection except!");
                        return z;
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static String D(File file) {
        MessageDigest messageDigest;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            try {
                messageDigest = MessageDigest.getInstance("SHA-1");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest == null) {
                return "";
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return k(messageDigest.digest());
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return "";
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static void o(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, file) == null) {
            File file2 = new File(file, "transvod");
            if (!file2.exists() || (listFiles = file2.listFiles(new e())) == null) {
                return;
            }
            for (File file3 : listFiles) {
                Log.i("TransvodSoLoader", "delete " + file3.getAbsolutePath() + " ret:" + file3.delete());
            }
        }
    }

    public static boolean v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists()) {
                return false;
            }
            String s = s("*.sha1", q());
            if (!new File(file, "libtransvod.so").exists() || !new File(file, s).exists()) {
                return false;
            }
            xeb.c(context);
            return xeb.a();
        }
        return invokeL.booleanValue;
    }

    public static String[] z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://thunder-sofiles.myzhiniu.com/a_transvod/transvod-12.1.0.24-");
            if (str == null) {
                str = q();
            }
            sb.append(str);
            String sb2 = sb.toString();
            return new String[]{sb2 + ".zip", sb2 + ".sha1"};
        }
        return (String[]) invokeL.objValue;
    }

    public static void F(String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            try {
                File file = new File(str2);
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../")) {
                            String str3 = str2 + File.separator + name;
                            if (nextEntry.isDirectory()) {
                                File file2 = new File(str3);
                                if (!file2.isDirectory()) {
                                    file2.mkdirs();
                                }
                            } else {
                                FileOutputStream fileOutputStream = new FileOutputStream(str3, false);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                zipInputStream.closeEntry();
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("TransvodSoLoader", "Unzip exception", e2);
            }
        }
    }

    public static boolean G(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, file, file2, str)) == null) {
            File file3 = new File(file, s("*.zip", str));
            if (!file3.exists()) {
                return false;
            }
            String s = s("*.sha1", str);
            File file4 = new File(file, s);
            if (!file4.exists()) {
                return false;
            }
            File file5 = new File(file2, "transvod");
            if (file5.exists()) {
                File[] listFiles = file5.listFiles();
                if (listFiles != null) {
                    for (File file6 : listFiles) {
                        if (!file6.delete()) {
                            Log.e("TransvodSoLoader", "delete file failed " + file6.getAbsolutePath());
                        }
                    }
                }
            } else if (!file5.mkdir()) {
                Log.e("TransvodSoLoader", "mkdir failed " + file5.getAbsolutePath());
            }
            try {
                if (!file5.exists()) {
                    Log.e("TransvodSoLoader", "mkdir so so files failed");
                    return false;
                }
                try {
                    F(file3.getAbsolutePath(), file5.getAbsolutePath());
                    n(file4, new File(file5, s));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                m(file);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static synchronized boolean p(Context context, String str, pgb pgbVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, context, str, pgbVar)) == null) {
            synchronized (zgb.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("yvodSoLoadState");
                    a = handlerThread;
                    handlerThread.start();
                    b = new Handler(a.getLooper());
                }
                if ("armeabi".equals(str)) {
                    str = PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
                }
                if (E(context, str)) {
                    y(context);
                    if (pgbVar != null) {
                        b.post(new a(pgbVar));
                    }
                    return true;
                }
                synchronized (d) {
                    d.add(pgbVar);
                }
                if (c != null) {
                    if (pgbVar != null) {
                        b.post(new b(pgbVar));
                    }
                    return false;
                } else if (E(context, str)) {
                    if (pgbVar != null) {
                        y(context);
                        b.post(new c(pgbVar));
                    }
                    return true;
                } else {
                    File cacheDir = context.getCacheDir();
                    File filesDir = context.getFilesDir();
                    e = filesDir.getAbsolutePath();
                    if (str == null) {
                        str = q();
                    }
                    Thread thread = new Thread(new d(cacheDir, str, pgbVar, filesDir));
                    c = thread;
                    thread.start();
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static /* synthetic */ boolean c() {
        return x();
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length <= 0) {
                return false;
            }
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return invokeV.booleanValue;
    }

    public static void m(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, file) == null) && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.getName().startsWith("transvod-") && (file2.getName().endsWith(".zip") || file2.getName().endsWith(".sha1"))) {
                    if (!file2.delete()) {
                        Log.e("TransvodSoLoader", "delete file failed " + file2.getAbsolutePath());
                    } else {
                        Log.i("TransvodSoLoader", "delete file ok " + file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            File file = new File(context.getFilesDir(), "transvod");
            if (!file.exists()) {
                return false;
            }
            String[] strArr = {"libtransvod.so"};
            boolean z = true;
            for (int i = 0; i < 1; i++) {
                File file2 = new File(file, strArr[i]);
                if (!file2.exists()) {
                    return false;
                }
                Log.i("TransvodSoLoader", "soload start " + file2.getAbsolutePath());
                try {
                    System.load(file2.getAbsolutePath());
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                Log.e("TransvodSoLoader", "soload finish " + file2.getAbsolutePath() + " res " + z);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void n(File file, File file2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, file, file2) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[512];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            String str = "" + (System.currentTimeMillis() / 1000);
            return (((((("&time=" + str) + "&key=" + A("sodownload" + str + "HiidoYYSystem")) + "&ts=" + str) + "&ph=" + URLEncoder.encode(Build.BRAND + "-" + Build.DEVICE + "-" + Build.PRODUCT)) + "&os=" + Build.VERSION.SDK_INT) + "&ver=12.1.0.24") + "&mod=1";
        }
        return (String) invokeV.objValue;
    }

    public static String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, str2)) == null) {
            if (str.endsWith(".zip")) {
                return "transvod-12.1.0.24-" + str2 + ".zip";
            } else if (str.endsWith(".sha1")) {
                return "transvod-12.1.0.24-" + str2 + ".sha1";
            } else {
                throw new RuntimeException("impossible code reached!");
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean w(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, file, str)) == null) {
            File file2 = new File(file, s("*.zip", str));
            if (!file2.exists()) {
                return false;
            }
            if (D(file2).equals(g)) {
                return true;
            }
            Log.i("TransvodSoLoader", "sha1 calc failed for " + file2.getAbsolutePath());
            return false;
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (TextUtils.isEmpty(e)) {
                return false;
            }
            File file = new File(new File(e), "transvod");
            if (!file.exists()) {
                return false;
            }
            String[] strArr = {"libtransvod.so"};
            boolean z = true;
            for (int i = 0; i < 1; i++) {
                File file2 = new File(file, strArr[i]);
                if (!file2.exists()) {
                    return false;
                }
                Log.i("TransvodSoLoader", "soload internal start " + file2.getAbsolutePath());
                try {
                    System.load(file2.getAbsolutePath());
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                Log.e("TransvodSoLoader", "soload internal finish " + file2.getAbsolutePath() + " res " + z);
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
