package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.SimpleForum;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class j45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public n25 h;
    public p25 i;
    public int j;
    public int k;
    public String l;
    public String m;
    public List<String> n;

    public j45() {
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
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public p25 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (p25) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public List<String> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void k(JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = String.valueOf(jSONObject.optLong("id", 0L));
        this.b = jSONObject.optString("name");
        this.c = jSONObject.optString("avatar");
        boolean z2 = true;
        if (jSONObject.optInt("is_liked", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        if (jSONObject.optInt("is_liked", 0) == 2) {
            z2 = false;
        }
        this.e = z2;
        this.f = false;
        this.g = jSONObject.optInt("level_id");
        this.m = jSONObject.optString("recommend_tip");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            n25 n25Var = new n25();
            this.h = n25Var;
            n25Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.k = optInt;
        if (optInt == 0) {
            this.k = jSONObject.optInt("member_num", 0);
        }
        this.j = jSONObject.optInt("post_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("pendants");
        if (optJSONArray != null) {
            this.n = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.n.add(optJSONArray.optString(i));
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("show_info");
        if (optJSONObject2 != null) {
            p25 p25Var = new p25();
            this.i = p25Var;
            p25Var.e(optJSONObject2);
        }
    }

    public void l(SimpleForum simpleForum) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, simpleForum) != null) || simpleForum == null) {
            return;
        }
        this.a = String.valueOf(simpleForum.id);
        this.b = simpleForum.name;
        this.c = simpleForum.avatar;
        if (simpleForum.is_liked.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        if (simpleForum.is_liked.intValue() != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.e = z2;
        this.f = false;
        this.g = simpleForum.level_id.intValue();
        this.m = simpleForum.recommend_tip;
        if (simpleForum.multi_forum_perm != null) {
            n25 n25Var = new n25();
            this.h = n25Var;
            n25Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.k = simpleForum.member_num.intValue();
        this.j = simpleForum.post_num.intValue();
        this.l = simpleForum.first_class;
        ThemeColorInfo themeColorInfo = simpleForum.theme_color;
        this.n = simpleForum.pendants;
        if (simpleForum.show_info != null) {
            p25 p25Var = new p25();
            this.i = p25Var;
            p25Var.f(simpleForum.show_info);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.d = z;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f = z;
        }
    }
}
