package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes8.dex */
public class uwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendBook recommendBook) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendBook)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", recommendBook.type);
            qoc.a(jSONObject, "book_id", recommendBook.book_id);
            qoc.a(jSONObject, "title", recommendBook.title);
            qoc.a(jSONObject, "image", recommendBook.image);
            if (recommendBook.desc != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : recommendBook.desc) {
                    jSONArray.put(str);
                }
                qoc.a(jSONObject, "desc", jSONArray);
            }
            qoc.a(jSONObject, "link_url", recommendBook.link_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
