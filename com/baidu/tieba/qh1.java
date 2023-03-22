package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
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
/* loaded from: classes6.dex */
public class qh1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static Bundle d;
    public static long e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends cf1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf1 a;

        public a(cf1 cf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf1Var;
        }

        @Override // com.baidu.tieba.cf1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cf1
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
                        String unused = qh1.a = optJSONObject.optString("orderId");
                        String unused2 = qh1.b = optJSONObject.optString("smsId");
                        qh1.c = optJSONObject.optString("mobile");
                        this.a.c(optJSONObject);
                        return;
                    }
                    cf1 cf1Var = this.a;
                    cf1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused3) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends cf1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf1 a;

        public b(cf1 cf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf1Var;
        }

        @Override // com.baidu.tieba.cf1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cf1
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
                    cf1 cf1Var = this.a;
                    cf1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends cf1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf1 a;

        public c(cf1 cf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cf1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.c(jSONObject);
            }
        }

        @Override // com.baidu.tieba.cf1
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

    public static void c(String str, cf1<JSONObject> cf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, cf1Var) == null) {
            String[] split = str.split("&");
            df1 df1Var = new df1();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        df1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        df1Var.d(split2[0], split2[1]);
                    }
                }
            }
            kf1.j().g(mf1.e(), df1Var, new c(cf1Var));
        }
    }

    public static void g(String str, ef1 ef1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, ef1Var) == null) {
            String a2 = ef1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                ef1Var.d("Cookie", str2);
                return;
            }
            ef1Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
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

    public static void e(Bundle bundle, String str, String str2, long j, cf1<JSONObject> cf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bundle, str, str2, Long.valueOf(j), cf1Var}) == null) {
            d = bundle;
            e = j;
            f = str2;
            ef1 ef1Var = new ef1();
            lf1.d(ef1Var);
            f(bundle, ef1Var);
            df1 df1Var = new df1();
            df1Var.d("token", d("orderId=" + str + "&payChannel=" + str2 + "&timestamp=" + j));
            new if1().a(mf1.n(), ef1Var, df1Var, new a(cf1Var));
        }
    }

    public static void f(Bundle bundle, ef1 ef1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bundle, ef1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            g(string, ef1Var);
        }
    }

    public static void h(String str, cf1<JSONObject> cf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, cf1Var) == null) {
            ef1 ef1Var = new ef1();
            lf1.d(ef1Var);
            f(d, ef1Var);
            df1 df1Var = new df1();
            df1Var.d("token", d("orderId=" + a + "&payChannel=" + f + "&smsId=" + b + "&timestamp=" + e + "&verifyCode=" + str));
            new if1().a(mf1.g(), ef1Var, df1Var, new b(cf1Var));
        }
    }
}
