package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public class uxa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uya a;
    public static final uxa b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948227755, "Lcom/baidu/tieba/uxa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948227755, "Lcom/baidu/tieba/uxa;");
                return;
            }
        }
        b = new uxa();
    }

    public uxa() {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && a == null) {
            a = new uya(context, "push");
        }
    }

    public synchronized void b(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            synchronized (this) {
                a(context);
                if (TextUtils.isEmpty(str)) {
                    a.a("key_push_token");
                } else {
                    String e = pxa.e(context, context.getPackageName());
                    byte[] h = pxa.h("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
                    byte[] h2 = pxa.h(e);
                    try {
                        bArr = new byte[32];
                        new SecureRandom().nextBytes(bArr);
                    } catch (Exception unused) {
                        bArr = new byte[0];
                    }
                    pxa.i(h, -4);
                    byte[] j = pxa.j(h, h2);
                    pxa.i(j, 6);
                    String encodeToString = Base64.encodeToString(pxa.j(j, bArr), 0);
                    boolean b2 = a.b("key_aes_gcm", encodeToString);
                    byte[] decode = Base64.decode(encodeToString, 0);
                    String str2 = "";
                    if (!TextUtils.isEmpty(str) && decode != null && decode.length >= 16) {
                        try {
                            try {
                                bArr2 = new byte[12];
                                new SecureRandom().nextBytes(bArr2);
                            } catch (GeneralSecurityException e2) {
                                String str3 = "GCM encrypt data error" + e2.getMessage();
                            }
                        } catch (Exception unused2) {
                            bArr2 = new byte[0];
                        }
                        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                        byte[] doFinal = cipher.doFinal(bytes);
                        if (doFinal != null && doFinal.length != 0) {
                            str2 = pxa.f(bArr2) + pxa.f(doFinal);
                        }
                    }
                    if (b2 && !TextUtils.isEmpty(str2)) {
                        a.b("key_push_token", str2);
                    }
                }
            }
        }
    }

    public synchronized String c(Context context) {
        InterceptResult invokeL;
        String str;
        boolean z;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            synchronized (this) {
                a(context);
                str = "";
                SharedPreferences sharedPreferences = a.a;
                boolean z2 = true;
                if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    SharedPreferences sharedPreferences2 = a.a;
                    if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                        z2 = false;
                    }
                    if (z2) {
                        SharedPreferences sharedPreferences3 = a.a;
                        if (sharedPreferences3 != null) {
                            str2 = sharedPreferences3.getString("key_push_token", "");
                        } else {
                            str2 = "";
                        }
                        SharedPreferences sharedPreferences4 = a.a;
                        if (sharedPreferences4 != null) {
                            str3 = sharedPreferences4.getString("key_aes_gcm", "");
                        } else {
                            str3 = "";
                        }
                        byte[] decode = Base64.decode(str3, 0);
                        String str4 = "";
                        if (!TextUtils.isEmpty(str2) && decode != null && decode.length >= 16) {
                            try {
                                SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                                String substring = str2.substring(0, 24);
                                String substring2 = str2.substring(24);
                                if (!TextUtils.isEmpty(substring) && !TextUtils.isEmpty(substring2)) {
                                    cipher.init(2, secretKeySpec, new GCMParameterSpec(128, pxa.h(substring)));
                                    str4 = new String(cipher.doFinal(pxa.h(substring2)), StandardCharsets.UTF_8);
                                }
                            } catch (Exception e) {
                                String str5 = "GCM decrypt data exception: " + e.getMessage();
                            }
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            str = str4;
                        } else {
                            a.a("key_aes_gcm");
                            a.a("key_push_token");
                        }
                    } else {
                        a.a("key_push_token");
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
