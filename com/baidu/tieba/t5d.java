package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.OriForumInfo;
/* loaded from: classes8.dex */
public class t5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull OriForumInfo oriForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, oriForumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "ori_fid", oriForumInfo.ori_fid);
            ktc.a(jSONObject, "ori_fname", oriForumInfo.ori_fname);
            ktc.a(jSONObject, "ori_avatar", oriForumInfo.ori_avatar);
            ktc.a(jSONObject, "ori_member_num", oriForumInfo.ori_member_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
