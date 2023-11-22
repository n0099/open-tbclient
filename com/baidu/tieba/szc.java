package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
import tbclient.LinkThreadInfo;
/* loaded from: classes8.dex */
public class szc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkThreadInfo linkThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "link_url", linkThreadInfo.link_url);
            qoc.a(jSONObject, "link_url_code", linkThreadInfo.link_url_code);
            if (linkThreadInfo.link_content != null) {
                JSONArray jSONArray = new JSONArray();
                for (LinkThreadContent linkThreadContent : linkThreadInfo.link_content) {
                    jSONArray.put(rzc.b(linkThreadContent));
                }
                qoc.a(jSONObject, "link_content", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
