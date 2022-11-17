package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mc9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile mc9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947968006, "Lcom/baidu/tieba/mc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947968006, "Lcom/baidu/tieba/mc9;");
                return;
            }
        }
        b = kc9.m();
    }

    public mc9() {
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
        this.a = of1.g();
    }

    public static mc9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (mc9.class) {
                    if (c == null) {
                        c = new mc9();
                    }
                }
            }
            return c;
        }
        return (mc9) invokeV.objValue;
    }

    public void b(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048576, this, str, i, str2) != null) || !this.a || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("dbOverNum", i);
            jSONObject.put("tableName", str2);
            c("logDiscard", "database", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void l(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) && this.a && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str2);
                jSONObject.put("size", str3);
                c("logSize", str, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void c(String str, String str2, JSONObject jSONObject) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, jSONObject) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (b) {
                if (jSONObject != null) {
                    str3 = jSONObject.toString();
                } else {
                    str3 = "";
                }
                Log.d("UBCQualityStatics", "Quality event: type=" + str + ", value=" + str2 + ",ext=" + str3);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("type", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put("value", str2);
                }
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                uBCManager.onEvent("1876", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void d(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) != null) || !this.a || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("fileNum", i);
            c("logDiscard", "fileNum", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void e(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048579, this, str, i, i2, i3) != null) || !this.a || TextUtils.isEmpty(str)) {
            return;
        }
        if (i == 0 && i2 == 0 && i3 == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            if (i != 0) {
                jSONObject.put("flowExpired", i);
            }
            if (i2 != 0) {
                jSONObject.put("eventExpired", i2);
            }
            if (i3 != 0) {
                jSONObject.put("flowInterrupt", i3);
            }
            c("logDiscard", "timeExpired", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || !this.a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            c("logDiscard", "realLog", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || !this.a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", str);
            c("sqlError", null, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || !this.a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", str);
            c("sendFail", "bodyError", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || !this.a) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errno", i);
            c("sendFail", "backend", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void g(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) && this.a && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                jSONObject.put("size", str2);
                jSONObject.put("logId", str3);
                c("logSize", "single", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, str2) != null) || !this.a) {
            return;
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("msg", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("exception", str2);
            }
            c("sendFail", "requestError", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void m(boolean z, long j) {
        int q;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                q = pb9.o().r();
            } else {
                q = pb9.o().q();
            }
            if (z) {
                str = "uploadReal";
            } else {
                str = "uploadNonReal";
            }
            if (j > q) {
                l(str, String.valueOf(q), String.valueOf(j));
            }
        }
    }
}
