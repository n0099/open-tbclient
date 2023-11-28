package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.BrandBook;
/* loaded from: classes7.dex */
public class kzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BrandBook brandBook) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, brandBook)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_book", brandBook.is_book);
            ltc.a(jSONObject, "book_num", brandBook.book_num);
            ltc.a(jSONObject, "end_time", brandBook.end_time);
            ltc.a(jSONObject, "ext", brandBook.ext);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
