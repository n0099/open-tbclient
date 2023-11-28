package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.VoteSchema;
/* loaded from: classes8.dex */
public class uz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public uz4() {
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

    public static uz4 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            uz4 uz4Var = new uz4();
            uz4Var.a = jSONObject.optString("text_before_vote");
            uz4Var.b = jSONObject.optString("text_after_vote");
            uz4Var.c = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
            return uz4Var;
        }
        return (uz4) invokeL.objValue;
    }

    public static uz4 b(VoteSchema voteSchema) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, voteSchema)) == null) {
            if (voteSchema == null) {
                return null;
            }
            uz4 uz4Var = new uz4();
            uz4Var.a = voteSchema.text_before_vote;
            uz4Var.b = voteSchema.text_after_vote;
            uz4Var.c = voteSchema.jump_url;
            return uz4Var;
        }
        return (uz4) invokeL.objValue;
    }
}
