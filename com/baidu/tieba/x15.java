package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import tbclient.UserGrowth;
import tbclient.UserTaskInfo;
/* loaded from: classes6.dex */
public class x15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public double d;
    public List<z15> e;

    public x15() {
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
        this.e = new ArrayList();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.longValue;
    }

    public List<z15> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public double e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.doubleValue;
    }

    public void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("level_id");
        this.b = jSONObject.optLong("score");
        this.c = jSONObject.optLong("target_score");
        this.d = jSONObject.optDouble("tmoney");
        this.e.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("task_info");
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = optJSONArray.getJSONObject(i);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            z15 z15Var = new z15();
            z15Var.g(jSONObject2);
            this.e.add(z15Var);
        }
    }

    public void g(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, userGrowth) == null) || userGrowth == null) {
            return;
        }
        this.a = userGrowth.level_id.intValue();
        this.b = userGrowth.score.longValue();
        this.c = userGrowth.target_score.longValue();
        this.d = userGrowth.tmoney.doubleValue();
        this.e.clear();
        for (UserTaskInfo userTaskInfo : userGrowth.task_info) {
            z15 z15Var = new z15();
            z15Var.h(userTaskInfo);
            this.e.add(z15Var);
        }
    }
}
