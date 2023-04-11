package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.dz;
import com.baidu.tieba.h00;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p00 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public h00.a b;
    public volatile FileLock c;
    public volatile RandomAccessFile d;
    public ez e;
    public d00 f;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] l;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public long d;
        public String e;
        public boolean f;
        public String g;
        public boolean h;
        public String i;
        public int j;
        public boolean k;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-569986564, "Lcom/baidu/tieba/p00$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-569986564, "Lcom/baidu/tieba/p00$a;");
                    return;
                }
            }
            l = new String[]{ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.h = true;
            this.j = 1;
            this.k = false;
        }

        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append("|");
                sb.append(str);
                if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                    sb.append(this.c);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    sb.append(this.e);
                }
                return sb.toString().trim();
            }
            return (String) invokeV.objValue;
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.i = str;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.j == aVar.j && this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c) && this.f == aVar.f && this.g.equals(aVar.g)) {
                    String str = this.e;
                    String str2 = aVar.e;
                    if (str == str2) {
                        return true;
                    }
                    if (str != null && str.equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public synchronized void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                synchronized (this) {
                    this.h = z;
                }
            }
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Arrays.hashCode(new Object[]{this.a, this.b, this.c, Boolean.valueOf(this.f), this.g, this.e, Integer.valueOf(this.j)}) : invokeV.intValue;
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public String o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public boolean r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : invokeV.booleanValue;
        }

        public String s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : (String) invokeV.objValue;
        }

        public synchronized boolean u() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                synchronized (this) {
                    z = this.h;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public void w() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                String l2 = p00.l();
                if (TextUtils.isEmpty(l2)) {
                    return;
                }
                this.f = true;
                this.g = l2;
            }
        }

        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : invokeV.booleanValue;
        }

        public m00 y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                m00 m00Var = new m00();
                m00Var.a = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.b);
                if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.b)) {
                    sb.append(this.c);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    sb.append(this.e);
                }
                m00Var.b = sb.toString().trim();
                return m00Var;
            }
            return (m00) invokeV.objValue;
        }

        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dik", this.a);
                    jSONObject.put("v270fk", this.b);
                    jSONObject.put("cck", this.c);
                    jSONObject.put("vsk", this.j);
                    jSONObject.put("ctk", this.d);
                    jSONObject.put("csk", this.f);
                    if (!TextUtils.isEmpty(this.g)) {
                        jSONObject.put("pmk", this.g);
                    }
                    if (!TextUtils.isEmpty(this.i)) {
                        jSONObject.put("ock", this.i);
                    }
                    jSONObject.put("hrk", this.h);
                    jSONObject.put("ek", this.e);
                    jSONObject.put("ifu", this.k);
                    return jSONObject.toString();
                } catch (JSONException e) {
                    l00.c(e);
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948008089, "Lcom/baidu/tieba/p00;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948008089, "Lcom/baidu/tieba/p00;");
        }
    }

    public p00(Context context, h00 h00Var, d00 d00Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, h00Var, d00Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.a = context;
        h00.a b = h00Var.e().b("bohrium");
        this.b = b;
        b.d();
        this.f = d00Var;
        h(h00Var);
    }

    public static a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("dik", "");
                String optString2 = jSONObject.optString("cck", "");
                long optLong = jSONObject.optLong("ctk", 0L);
                int optInt = jSONObject.optInt("vsk", 1);
                boolean optBoolean = jSONObject.optBoolean("csk", false);
                String optString3 = jSONObject.optString("pmk", "");
                boolean optBoolean2 = jSONObject.optBoolean("hrk", true);
                String optString4 = jSONObject.optString("ock", null);
                String optString5 = jSONObject.optString("ek", "");
                String optString6 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                jSONObject.optBoolean("ifu", false);
                if (!TextUtils.isEmpty(optString)) {
                    a aVar = new a();
                    aVar.a = optString;
                    aVar.c = optString2;
                    aVar.d = optLong;
                    aVar.j = optInt;
                    aVar.e = optString5;
                    aVar.b = optString6;
                    aVar.f = optBoolean;
                    aVar.g = optString3;
                    aVar.h = optBoolean2;
                    aVar.i = optString4;
                    aVar.k = false;
                    return aVar;
                }
            } catch (Exception e) {
                l00.c(e);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a e(String str, String str2, String str3, boolean z, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Boolean.valueOf(z), str4})) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    String o = o(str);
                    long currentTimeMillis = System.currentTimeMillis();
                    a aVar = new a();
                    aVar.a = str;
                    aVar.c = o;
                    aVar.d = currentTimeMillis;
                    aVar.j = 1;
                    aVar.e = str3;
                    aVar.b = str2;
                    aVar.f = z;
                    aVar.g = str4;
                    return aVar;
                } catch (Exception e) {
                    l00.c(e);
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = h;
            if (str != null) {
                return str;
            }
            if (TextUtils.isEmpty(Build.MODEL)) {
                return "";
            }
            String substring = f00.b(Build.MODEL.getBytes(), false).substring(3, 15);
            h = substring;
            return substring;
        }
        return (String) invokeV.objValue;
    }

    public static String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                return new j00("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(new vy().a(str.getBytes("UTF-8")));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (new File(this.b.f(), "libbh.so").exists()) {
                return c(g(true));
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public a b(m00 m00Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m00Var)) == null) {
            if (m00Var != null) {
                a aVar = new a();
                aVar.d = System.currentTimeMillis();
                aVar.j = 1;
                try {
                    boolean z = false;
                    aVar.b = m00Var.b.substring(0, 1);
                    aVar.a = m00Var.a;
                    aVar.c = o(m00Var.a);
                    String[] strArr = a.l;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            break;
                        } else if (strArr[i].equals(aVar.b)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z && (str = m00Var.b) != null && str.length() >= 2) {
                        aVar.e = m00Var.b.substring(1);
                    }
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        return (a) invokeL.objValue;
    }

    public a d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            dz a2 = this.e.a(str2);
            dz.g gVar = new dz.g();
            gVar.a = true;
            dz.h b = a2.b(str, gVar);
            if (b == null || !b.c()) {
                return null;
            }
            return b.a;
        }
        return (a) invokeLL.objValue;
    }

    public final String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            return TextUtils.isEmpty(string) ? "" : string;
        }
        return (String) invokeL.objValue;
    }

    public final String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? this.b.c("libbh.so", z) : (String) invokeZ.objValue;
    }

    public final void h(h00 h00Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h00Var) == null) {
            ez ezVar = new ez(new hz());
            dz.b bVar = new dz.b();
            bVar.a = this.a;
            bVar.b = h00Var;
            dz.d dVar = new dz.d();
            for (dz dzVar : ezVar.b()) {
                dzVar.d(bVar);
                dzVar.e(dVar);
            }
            this.e = ezVar;
        }
    }

    public void i(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            dz.e eVar = new dz.e();
            for (dz dzVar : this.e.b()) {
                dzVar.a(eVar, aVar);
            }
        }
    }

    public boolean j(a aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a)) {
                throw new NullPointerException("content should not be null");
            }
            if (!z2) {
                try {
                    if (new File(this.b.f(), "libbh.so").exists() && (c = c(g(true))) != null) {
                        String A = c.A();
                        boolean z3 = !TextUtils.isEmpty(A) && A.equals(aVar.A());
                        boolean z4 = c.r() && !TextUtils.isEmpty(c.s()) && TextUtils.equals(c.s(), l());
                        if (z3 && z4) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return this.b.e("libbh.so", aVar.z(), z);
        }
        return invokeCommon.booleanValue;
    }

    public a k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String f = f(this.a);
            boolean z = false;
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                if (g) {
                    Log.d("CuidV270Manager", "uuid: " + uuid);
                }
                str2 = str + f + uuid;
            } else {
                if (!o00.b(f)) {
                    f = UUID.randomUUID().toString();
                    z = true;
                }
                str2 = "com.baidu" + f;
            }
            String b = f00.b(str2.getBytes(), true);
            if (z) {
                b = "FUUID" + b.substring(5);
            }
            String l = l();
            a aVar = new a();
            aVar.d = System.currentTimeMillis();
            aVar.j = 1;
            aVar.a = b;
            aVar.b = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            aVar.c = o(b);
            aVar.f = true;
            aVar.g = l;
            aVar.e = null;
            aVar.k = z;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public a m(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            dz.g gVar = new dz.g();
            gVar.a = true;
            List<dz> b = this.e.b();
            Collections.sort(b, dz.e);
            List<c00> h2 = this.f.h(this.a);
            if (h2 != null) {
                for (c00 c00Var : h2) {
                    if (!c00Var.d && c00Var.c) {
                        for (dz dzVar : b) {
                            dz.h b2 = dzVar.b(c00Var.a.packageName, gVar);
                            if (b2 != null && b2.c() && (aVar = b2.a) != null && o00.a(aVar.h()) && !TextUtils.equals(aVar.h(), str)) {
                                if (!(aVar.r() && !TextUtils.equals(l(), aVar.s()))) {
                                    return b2.a;
                                }
                            }
                        }
                        continue;
                    }
                }
                return null;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public synchronized boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                File g2 = this.b.g(".lock");
                if (!g2.exists()) {
                    try {
                        g2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(g2, "rw");
                    for (int i = 0; i < 100; i++) {
                        try {
                            try {
                                this.c = randomAccessFile2.getChannel().lock();
                                this.d = randomAccessFile2;
                                return true;
                            } catch (OverlappingFileLockException unused) {
                                Thread.sleep(100L);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            randomAccessFile = randomAccessFile2;
                            l00.c(e);
                            if (this.c == null) {
                                l00.b(randomAccessFile);
                            }
                            return false;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.c != null) {
                    try {
                        this.c.release();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.c = null;
                }
                l00.b(this.d);
                this.d = null;
            }
        }
    }
}
