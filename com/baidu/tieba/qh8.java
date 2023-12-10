package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class qh8 extends fw4 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final List<th8> b;
    public int c;
    public int d;
    public boolean e;
    @Nullable
    public ThemeColorInfo f;
    @Nullable
    public JSONObject g;

    @Override // com.baidu.tieba.fw4
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948091944, "Lcom/baidu/tieba/qh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948091944, "Lcom/baidu/tieba/qh8;");
                return;
            }
        }
        h = BdUniqueId.gen();
    }

    public qh8() {
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
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.b = new ArrayList();
    }

    @Nullable
    public ThemeColorInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @NonNull
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = this.g;
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.pi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return h;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public List<th8> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!ListUtils.isEmpty(this.b) && !rd.isEmpty(this.a)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g != null && !ListUtils.isEmpty(this.b)) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (th8 th8Var : this.b) {
                        if (th8Var != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("forum_name", th8Var.c());
                            jSONObject.put("forum_id", th8Var.b());
                            jSONObject.put("avatar", th8Var.a());
                            jSONObject.put("forum_scheme", th8Var.g());
                            jSONObject.put("label_img", th8Var.d());
                            int i2 = 1;
                            if (th8Var.j()) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            jSONObject.put("is_like", i);
                            if (!th8Var.k()) {
                                i2 = 0;
                            }
                            jSONObject.put("is_sign", i2);
                            jSONObject.put(TiebaStatic.Params.REC_TYPE, th8Var.e());
                            jSONObject.put("smart_color", th8Var.i());
                            jSONArray.put(jSONObject);
                        }
                    }
                    this.g.putOpt("forum_list", jSONArray);
                } catch (JSONException e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("RecentForumLog", "HomePageRecentForumData json解析异常 " + e.getMessage());
                    } else {
                        throw new IllegalArgumentException("HomePageRecentForumData json解析异常");
                    }
                }
                return this.g.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            n(new JSONObject(str));
        } catch (Exception e) {
            if (!TbadkApplication.getInst().isDebugMode()) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("RecentForumLog", "HomePageRecentForumData json解析异常 " + e.getMessage());
                return;
            }
            throw new IllegalArgumentException("HomePageRecentForumData json解析异常");
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.g = jSONObject;
        this.b.clear();
        this.a = jSONObject.optString("sign_scheme");
        jSONObject.optInt("sample_type");
        this.f = z5b.j(jSONObject.optJSONObject("background_info"));
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    th8 th8Var = new th8();
                    th8Var.n(optJSONObject);
                    if (th8Var.m()) {
                        this.b.add(th8Var);
                    }
                }
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.d = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.c = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.e = z;
        }
    }
}
