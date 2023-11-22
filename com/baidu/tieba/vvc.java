package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.Info;
import tbclient.FrsPage.RecmForumInfo;
/* loaded from: classes8.dex */
public class vvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, info)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_USER_NUM, info.user_num);
            qoc.a(jSONObject, "post_num", info.post_num);
            if (info.recm_forum_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (RecmForumInfo recmForumInfo : info.recm_forum_list) {
                    jSONArray.put(rwc.b(recmForumInfo));
                }
                qoc.a(jSONObject, "recm_forum_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
