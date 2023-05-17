package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ld5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public boolean p;
    public String q;

    public ld5() {
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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public static HashMap<String, ld5> p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("top_level_navi");
                Iterator<String> keys = jSONObject2.keys();
                HashMap<String, ld5> hashMap = new HashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                    ld5 ld5Var = new ld5();
                    ld5Var.o(jSONObject3);
                    hashMap.put(next, ld5Var);
                }
                return hashMap;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (HashMap) invokeL.objValue;
    }

    public boolean n(ld5 ld5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, ld5Var)) == null) {
            if (ld5Var == null) {
                return false;
            }
            if (this == ld5Var) {
                return true;
            }
            if (!this.a.equals(ld5Var.a) || !this.b.equals(ld5Var.b) || !this.c.equals(ld5Var.c) || !this.d.equals(ld5Var.d) || !this.e.equals(ld5Var.e) || !this.f.equals(ld5Var.f) || !this.g.equals(ld5Var.g) || !this.h.equals(ld5Var.h) || !this.i.equals(ld5Var.i) || !this.j.equals(ld5Var.j) || !this.k.equals(ld5Var.k) || !this.l.equals(ld5Var.l) || !this.m.equals(ld5Var.m) || this.n != ld5Var.n || this.o != ld5Var.o || this.p != ld5Var.p || !this.q.equals(ld5Var.q)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("color");
        this.b = jSONObject.optString("color_night");
        this.c = jSONObject.optString("color_dark");
        this.d = jSONObject.optString(BigdayActivityConfig.IMG_URL);
        this.e = jSONObject.optString("img_url_night");
        this.f = jSONObject.optString("img_url_dark");
        this.g = jSONObject.optString("card_color");
        this.h = jSONObject.optString("card_color_night");
        this.i = jSONObject.optString("card_color_dark");
        this.j = jSONObject.optString("card_img_url");
        this.k = jSONObject.optString("card_img_url_night");
        this.l = jSONObject.optString("card_img_url_dark");
        this.m = jSONObject.optString("card_jump_url");
        this.n = jSONObject.optInt("card_show_height");
        this.o = jSONObject.optInt("card_img_width");
        if (jSONObject.optInt("is_black_title") != 2) {
            z = true;
        } else {
            z = false;
        }
        this.p = z;
        this.q = jSONObject.optString("h5_img_url");
    }
}
