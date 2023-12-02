package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.BrandBook;
/* loaded from: classes6.dex */
public class jzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BrandBook brandBook) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, brandBook)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "is_book", brandBook.is_book);
            ktc.a(jSONObject, "book_num", brandBook.book_num);
            ktc.a(jSONObject, "end_time", brandBook.end_time);
            ktc.a(jSONObject, "ext", brandBook.ext);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
