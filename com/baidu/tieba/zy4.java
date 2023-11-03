package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RewardCard;
/* loaded from: classes9.dex */
public class zy4 {
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
    public List<az4> i;
    public String j;
    public List<String> k;
    public String l;
    public String m;

    public zy4() {
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
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public List<az4> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public static zy4 n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            zy4 zy4Var = new zy4();
            zy4Var.a = jSONObject.optString("icon");
            zy4Var.b = jSONObject.optString("title");
            zy4Var.c = jSONObject.optString("start_text");
            zy4Var.d = jSONObject.optString("end_text");
            zy4Var.e = jSONObject.optString("end_time");
            zy4Var.f = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            zy4Var.g = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            zy4Var.h = jSONObject.optString("join_num");
            zy4Var.i = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("reward_material");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    az4 e = az4.e(optJSONArray.optJSONObject(i));
                    if (e != null) {
                        zy4Var.i.add(e);
                    }
                }
            }
            zy4Var.j = jSONObject.optString("total_num");
            zy4Var.k = new ArrayList();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("head_imgs");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    zy4Var.k.add(optJSONArray2.optString(i2));
                }
            }
            zy4Var.l = jSONObject.optString("join_succ_text");
            zy4Var.m = jSONObject.optString("banner_jump_url");
            return zy4Var;
        }
        return (zy4) invokeL.objValue;
    }

    public static zy4 o(RewardCard rewardCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rewardCard)) == null) {
            if (rewardCard == null) {
                return null;
            }
            zy4 zy4Var = new zy4();
            zy4Var.a = rewardCard.icon;
            zy4Var.b = rewardCard.title;
            zy4Var.c = rewardCard.start_text;
            zy4Var.d = rewardCard.end_text;
            zy4Var.e = rewardCard.end_time;
            zy4Var.f = rewardCard.button_text;
            zy4Var.g = rewardCard.jump_url;
            zy4Var.h = rewardCard.join_num;
            zy4Var.i = new ArrayList();
            for (int i = 0; i < rewardCard.reward_material.size(); i++) {
                zy4Var.i.add(az4.f(rewardCard.reward_material.get(i)));
            }
            zy4Var.j = rewardCard.total_num;
            ArrayList arrayList = new ArrayList();
            zy4Var.k = arrayList;
            arrayList.addAll(rewardCard.head_imgs);
            zy4Var.l = rewardCard.join_succ_text;
            zy4Var.m = rewardCard.banner_jump_url;
            return zy4Var;
        }
        return (zy4) invokeL.objValue;
    }
}
