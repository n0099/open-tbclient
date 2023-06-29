package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
/* loaded from: classes8.dex */
public class us4 implements qs4<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    @Override // com.baidu.tieba.qs4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs4
    /* renamed from: h */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    public us4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static byte[] g(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            int i = 0;
            for (byte[] bArr2 : bArr) {
                i += bArr2.length;
            }
            byte[] bArr3 = new byte[i];
            int i2 = 0;
            for (byte[] bArr4 : bArr) {
                System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 += bArr4.length;
            }
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        byte[] g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] bytes = d().getBytes(StandardCharsets.UTF_8);
            byte[] bytes2 = "com.baidu.swan".getBytes(StandardCharsets.UTF_8);
            if (Build.VERSION.SDK_INT < 23) {
                g = g(bytes2, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8), String.valueOf(System.nanoTime()).getBytes(StandardCharsets.UTF_8), bytes);
            } else {
                g = g(bytes2, bytes);
            }
            return xs4.b(g, true);
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public final String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                str = (String) Build.class.getField("SERIAL").get(null);
                try {
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                        Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod.setAccessible(true);
                        str = (String) declaredMethod.invoke(null, "ro.serialno");
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                        str = f("ro.serialno");
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = null;
            }
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs4
    /* renamed from: c */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b();
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String a = hx3.b.a(this.a);
            if (TextUtils.isEmpty(a)) {
                a = e();
            }
            if (TextUtils.isEmpty(a)) {
                a = UUID.randomUUID().toString();
            }
            if (a == null) {
                return "";
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 256);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                String readLine = bufferedReader.readLine();
                ws4.a(bufferedReader);
                if (readLine == null) {
                    return "";
                }
                return readLine;
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                ws4.a(bufferedReader2);
                ws4.a(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                ws4.a(bufferedReader2);
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }
}
