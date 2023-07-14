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
public class qj1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static Bundle d;
    public static long e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ch1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch1 a;

        public a(ch1 ch1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch1Var;
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
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
                        String unused = qj1.a = optJSONObject.optString("orderId");
                        String unused2 = qj1.b = optJSONObject.optString("smsId");
                        qj1.c = optJSONObject.optString("mobile");
                        this.a.c(optJSONObject);
                        return;
                    }
                    ch1 ch1Var = this.a;
                    ch1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused3) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ch1<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch1 a;

        public b(ch1 ch1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch1Var;
        }

        @Override // com.baidu.tieba.ch1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
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
                    ch1 ch1Var = this.a;
                    ch1Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused) {
                    this.a.b(new ServerDataException(UIMsg.UI_TIP_SERVER_ERROR), UIMsg.UI_TIP_SERVER_ERROR);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ch1<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch1 a;

        public c(ch1 ch1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ch1
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.c(jSONObject);
            }
        }

        @Override // com.baidu.tieba.ch1
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

    public static void c(String str, ch1<JSONObject> ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, ch1Var) == null) {
            String[] split = str.split("&");
            dh1 dh1Var = new dh1();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        dh1Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        dh1Var.d(split2[0], split2[1]);
                    }
                }
            }
            kh1.j().g(mh1.e(), dh1Var, new c(ch1Var));
        }
    }

    public static void g(String str, eh1 eh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, eh1Var) == null) {
            String a2 = eh1Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                eh1Var.d("Cookie", str2);
                return;
            }
            eh1Var.d("Cookie", a2 + "; " + str2);
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

    public static void e(Bundle bundle, String str, String str2, long j, ch1<JSONObject> ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bundle, str, str2, Long.valueOf(j), ch1Var}) == null) {
            d = bundle;
            e = j;
            f = str2;
            eh1 eh1Var = new eh1();
            lh1.d(eh1Var);
            f(bundle, eh1Var);
            dh1 dh1Var = new dh1();
            dh1Var.d("token", d("orderId=" + str + "&payChannel=" + str2 + "&timestamp=" + j));
            new ih1().a(mh1.n(), eh1Var, dh1Var, new a(ch1Var));
        }
    }

    public static void f(Bundle bundle, eh1 eh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bundle, eh1Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            g(string, eh1Var);
        }
    }

    public static void h(String str, ch1<JSONObject> ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, ch1Var) == null) {
            eh1 eh1Var = new eh1();
            lh1.d(eh1Var);
            f(d, eh1Var);
            dh1 dh1Var = new dh1();
            dh1Var.d("token", d("orderId=" + a + "&payChannel=" + f + "&smsId=" + b + "&timestamp=" + e + "&verifyCode=" + str));
            new ih1().a(mh1.g(), eh1Var, dh1Var, new b(ch1Var));
        }
    }
}
