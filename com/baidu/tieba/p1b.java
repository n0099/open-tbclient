package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class p1b implements j2b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public w2b a;
    public String b;

    public abstract t2b j(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public abstract t2b k(String str, byte[] bArr, Map<String, String> map) throws IOException;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948010600, "Lcom/baidu/tieba/p1b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948010600, "Lcom/baidu/tieba/p1b;");
                return;
            }
        }
        c = q2b.m();
    }

    public p1b() {
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
        this.a = new w2b();
        this.b = "";
    }

    public final HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>(2);
            hashMap.put("Content-type", "application/x-www-form-urlencoded");
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j2b
    public boolean a(JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return i(this.b, jSONObject, z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.j2b
    public boolean b(File file, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{file, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return h(this.b, file, j, z, z2);
        }
        return invokeCommon.booleanValue;
    }

    public final String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = q2b.k(z);
            }
            return this.b;
        }
        return (String) invokeZ.objValue;
    }

    public final String e(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isUBCDebug = this.a.isUBCDebug();
            if (TextUtils.isEmpty(str)) {
                str = d(isUBCDebug);
            }
            if (z2) {
                c2 = q2b.h(str);
            } else {
                c2 = q2b.c(str);
            }
            if (isUBCDebug && !TextUtils.isEmpty(c2)) {
                c2 = w3b.a(c2, "debug", "1");
            }
            if (z) {
                c2 = w3b.a(c2, "reallog", "1");
            }
            if (v1b.o().E()) {
                return w3b.a(c2, "beta", "1");
            }
            return c2;
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean f(t2b t2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t2bVar)) == null) {
            if (t2bVar == null) {
                return false;
            }
            if (!t2bVar.e()) {
                if (c) {
                    Log.d("UploadManager", "postByteRequest, fail: " + t2bVar.d());
                } else {
                    s2b.a().i(t2bVar.d(), null);
                }
                if (v1b.o().M()) {
                    g(t2bVar.c());
                }
                t2bVar.a();
                return false;
            }
            try {
                int i = new JSONObject(t2bVar.b()).getInt("error");
                if (i != 0) {
                    if (c) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!c) {
                        s2b.a().k(i);
                    }
                }
            } catch (Exception e) {
                if (c) {
                    Log.d("UploadManager", "body tostring fail:" + e.getMessage());
                } else {
                    s2b.a().j(Log.getStackTraceString(e));
                }
            }
            t2bVar.a();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            if (i != 403 && i != 408 && i != 499) {
                if (i >= 500 && i < 600) {
                    j = 300000;
                } else {
                    z = false;
                    if (!z) {
                        v1b.o().Z(currentTimeMillis);
                        return;
                    }
                    return;
                }
            } else {
                j = 60000;
            }
            currentTimeMillis += j;
            if (!z) {
            }
        }
    }

    public final boolean h(String str, File file, long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, file, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (file == null || !file.exists()) {
                return false;
            }
            String e = e(str, z, z2);
            HashMap<String, String> c2 = c();
            if (x2b.m().p() && j > 0) {
                c2.put("Content-Length", String.valueOf(j));
            }
            InputStream inputStream2 = null;
            try {
                inputStream = new BufferedInputStream(new Base64InputStream(new FileInputStream(file), 2));
                try {
                    try {
                        boolean f = f(j(e, inputStream, c2));
                        r3b.b(inputStream);
                        return f;
                    } catch (Exception e2) {
                        e = e2;
                        if (c) {
                            Log.d("UploadManager", "postByteRequest, Exception: ", e);
                        } else {
                            s2b.a().i(null, Log.getStackTraceString(e));
                        }
                        r3b.b(inputStream);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    r3b.b(inputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }

    public boolean i(String str, JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (jSONObject != null && (a = t3b.a(jSONObject.toString().getBytes())) != null && a.length >= 2) {
                a[0] = 117;
                a[1] = 123;
                String e = e(str, z, z2);
                HashMap<String, String> c2 = c();
                if (x2b.m().p()) {
                    c2.put("Content-Length", String.valueOf(a.length));
                }
                try {
                    return f(k(e, a, c2));
                } catch (IOException e2) {
                    if (c) {
                        Log.d("UploadManager", "postByteRequest, Exception: ", e2);
                    } else {
                        s2b.a().i(null, Log.getStackTraceString(e2));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
