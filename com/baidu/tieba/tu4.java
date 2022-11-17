package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.SimpleForum;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class tu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int e;
    public ys4 f;
    public int g;
    public int h;
    public String i;
    public ThemeColorInfo j;

    public tu4() {
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
            return this.e;
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

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public ThemeColorInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public ArrayList<Integer> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ThemeColorInfo themeColorInfo = this.j;
            if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(ij7.b(this.j.day.light_color)));
                arrayList.add(Integer.valueOf(ij7.b(this.j.day.dark_color)));
                arrayList.add(Integer.valueOf(ij7.b(this.j.night.light_color)));
                arrayList.add(Integer.valueOf(ij7.b(this.j.night.dark_color)));
                arrayList.add(Integer.valueOf(ij7.b(this.j.dark.light_color)));
                arrayList.add(Integer.valueOf(ij7.b(this.j.dark.dark_color)));
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.a = String.valueOf(jSONObject.optLong("id", 0L));
        this.b = jSONObject.optString("name");
        this.c = jSONObject.optString("avatar");
        this.e = jSONObject.optInt("level_id");
        JSONObject optJSONObject = jSONObject.optJSONObject("multi_forum_perm");
        if (optJSONObject != null) {
            ys4 ys4Var = new ys4();
            this.f = ys4Var;
            ys4Var.a(optJSONObject);
        }
        int optInt = jSONObject.optInt("memberNum", 0);
        this.h = optInt;
        if (optInt == 0) {
            this.h = jSONObject.optInt("member_num", 0);
        }
        this.g = jSONObject.optInt("post_num", 0);
    }

    public void i(SimpleForum simpleForum) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, simpleForum) != null) || simpleForum == null) {
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
        this.e = simpleForum.level_id.intValue();
        if (simpleForum.multi_forum_perm != null) {
            ys4 ys4Var = new ys4();
            this.f = ys4Var;
            ys4Var.b(simpleForum.multi_forum_perm);
        }
        simpleForum.is_brand_forum.intValue();
        this.h = simpleForum.member_num.intValue();
        this.g = simpleForum.post_num.intValue();
        this.i = simpleForum.first_class;
        this.j = simpleForum.theme_color;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.b = str;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d = z;
        }
    }
}
