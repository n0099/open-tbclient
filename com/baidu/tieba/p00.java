package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;

    public p00() {
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
        this.c = 2;
        this.d = 0;
    }

    public static p00 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            p00 p00Var = new p00();
            p00Var.a = str;
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            p00Var.d = length;
            if (length < 14) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                p00Var.b = str2;
            }
            return p00Var;
        }
        return (p00) invokeLL.objValue;
    }

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i >= 14 : invokeI.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public static p00 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? g(j(str)) : (p00) invokeL.objValue;
    }

    public static p00 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                String str2 = "0";
                String str3 = "0";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!i("ZGV2aWNlaWQ=").equals(next) && !i("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, "0");
                    }
                }
                String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
                int i = jSONObject.getInt(i("dmVy"));
                int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
                if (!TextUtils.isEmpty(string)) {
                    p00 p00Var = new p00();
                    p00Var.a = string;
                    p00Var.c = i;
                    p00Var.d = length;
                    if (length < 14) {
                        if (!TextUtils.isEmpty(str3)) {
                            str2 = str3;
                        }
                        p00Var.b = str2;
                    }
                    p00Var.k();
                    return p00Var;
                }
            } catch (JSONException e) {
                o00.c(e);
            }
            return null;
        }
        return (p00) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? new String(h00.b(str.getBytes())) : (String) invokeL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = rz.a();
                return new String(nz.d(a, a, h00.b(str.getBytes())));
            } catch (Exception e) {
                o00.c(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] a = rz.a();
                return h00.a(nz.c(a, a, str.getBytes()), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException | Exception e) {
                o00.c(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d(this.b) : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c(this.d) : invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m(l()) : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f()) {
                str = "O";
            } else if (!b()) {
                return false;
            } else {
                str = "0";
            }
            this.b = str;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new JSONObject().put(i("ZGV2aWNlaWQ="), this.a).put(i("aW1laQ=="), this.b).put(i("dmVy"), this.c).toString();
            } catch (JSONException e) {
                o00.c(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
