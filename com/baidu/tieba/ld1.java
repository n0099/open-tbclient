package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ld1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static Bundle d;
    public static long e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends xa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa1 a;

        public a(xa1 xa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa1Var;
        }

        @Override // com.baidu.tieba.xa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code", 1);
                    String optString = jSONObject.optString("msg", "");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == 0 && optJSONObject != null) {
                        String unused = ld1.a = optJSONObject.optString("orderId");
                        String unused2 = ld1.b = optJSONObject.optString("smsId");
                        ld1.c = optJSONObject.optString("mobile");
                        this.a.c(optJSONObject);
                        return;
                    }
                    xa1 xa1Var = this.a;
                    xa1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused3) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends xa1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa1 a;

        public b(xa1 xa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa1Var;
        }

        @Override // com.baidu.tieba.xa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xa1
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code", 1);
                    String optString = jSONObject.optString("msg", "");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == 0 && optJSONObject != null) {
                        this.a.c(optJSONObject);
                        return;
                    }
                    xa1 xa1Var = this.a;
                    xa1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends xa1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa1 a;

        public c(xa1 xa1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xa1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.c(jSONObject);
            }
        }

        @Override // com.baidu.tieba.xa1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return i(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDeoE4C+X8ahP2/juzyb10hdQNIHR3a+m3+nV6sVaOiXpNw1sNnB/2ms9vV2yXCOTz2JFWMmgr8p5dA9yUfYzSVMWN8jyZdOzAwGzjh6oB32FsqlgFkXNTNJHkdIzJRq/H8Q9mlh67c2KrMN2QLU219M6EbLoTL0i+0oUbZ4W0IrwIDAQAB");
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str, xa1<JSONObject> xa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, xa1Var) == null) {
            String[] split = str.split("&");
            ya1 ya1Var = new ya1();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        ya1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        ya1Var.d(split2[0], split2[1]);
                    }
                }
            }
            fb1.j().g(hb1.e(), ya1Var, new c(xa1Var));
        }
    }

    public static void g(String str, za1 za1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, za1Var) == null) {
            String a2 = za1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                za1Var.d("Cookie", str2);
                return;
            }
            za1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, generatePublic);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void e(Bundle bundle, String str, String str2, long j, xa1<JSONObject> xa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bundle, str, str2, Long.valueOf(j), xa1Var}) == null) {
            d = bundle;
            e = j;
            f = str2;
            za1 za1Var = new za1();
            gb1.d(za1Var);
            f(bundle, za1Var);
            ya1 ya1Var = new ya1();
            ya1Var.d("token", d("orderId=" + str + "&payChannel=" + str2 + "&timestamp=" + j));
            new db1().a(hb1.n(), za1Var, ya1Var, new a(xa1Var));
        }
    }

    public static void f(Bundle bundle, za1 za1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bundle, za1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            g(string, za1Var);
        }
    }

    public static void h(String str, xa1<JSONObject> xa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, xa1Var) == null) {
            za1 za1Var = new za1();
            gb1.d(za1Var);
            f(d, za1Var);
            ya1 ya1Var = new ya1();
            ya1Var.d("token", d("orderId=" + a + "&payChannel=" + f + "&smsId=" + b + "&timestamp=" + e + "&verifyCode=" + str));
            new db1().a(hb1.g(), za1Var, ya1Var, new b(xa1Var));
        }
    }
}
