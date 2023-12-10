package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes8.dex */
public class v1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendBook recommendBook) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendBook)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", recommendBook.type);
            ltc.a(jSONObject, "book_id", recommendBook.book_id);
            ltc.a(jSONObject, "title", recommendBook.title);
            ltc.a(jSONObject, "image", recommendBook.image);
            if (recommendBook.desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : recommendBook.desc) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "desc", jSONArray);
            }
            ltc.a(jSONObject, "link_url", recommendBook.link_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
