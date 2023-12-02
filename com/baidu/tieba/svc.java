package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CategoryInfo;
/* loaded from: classes8.dex */
public class svc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CategoryInfo categoryInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, categoryInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_ID, categoryInfo.category_id);
            ktc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, categoryInfo.category_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
