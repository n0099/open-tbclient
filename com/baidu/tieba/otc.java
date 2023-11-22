package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumRuleStatus;
/* loaded from: classes7.dex */
public class otc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumRuleStatus forumRuleStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumRuleStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", forumRuleStatus.title);
            qoc.a(jSONObject, "audit_status", forumRuleStatus.audit_status);
            qoc.a(jSONObject, "has_forum_rule", forumRuleStatus.has_forum_rule);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
