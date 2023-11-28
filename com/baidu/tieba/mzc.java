package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.BusinessPromotCommentList;
/* loaded from: classes7.dex */
public class mzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static BusinessPromotCommentList b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            BusinessPromotCommentList.Builder builder = new BusinessPromotCommentList.Builder();
            if (jSONObject.has("title")) {
                builder.title = jSONObject.optString("title");
            }
            if (jSONObject.has("username")) {
                builder.username = jSONObject.optString("username");
            }
            if (jSONObject.has("uid")) {
                builder.uid = Long.valueOf(jSONObject.optLong("uid"));
            }
            if (jSONObject.has("is_lz")) {
                builder.is_lz = Integer.valueOf(jSONObject.optInt("is_lz"));
            }
            return builder.build(true);
        }
        return (BusinessPromotCommentList) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull BusinessPromotCommentList businessPromotCommentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, businessPromotCommentList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", businessPromotCommentList.title);
            ltc.a(jSONObject, "username", businessPromotCommentList.username);
            ltc.a(jSONObject, "uid", businessPromotCommentList.uid);
            ltc.a(jSONObject, "is_lz", businessPromotCommentList.is_lz);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
