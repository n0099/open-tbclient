package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes8.dex */
public class twc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendBook recommendBook) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendBook)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", recommendBook.type);
            poc.a(jSONObject, "book_id", recommendBook.book_id);
            poc.a(jSONObject, "title", recommendBook.title);
            poc.a(jSONObject, "image", recommendBook.image);
            if (recommendBook.desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : recommendBook.desc) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "desc", jSONArray);
            }
            poc.a(jSONObject, "link_url", recommendBook.link_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
