package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes7.dex */
public class mqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BookThread bookThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bookThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "book_id", bookThread.book_id);
            qoc.a(jSONObject, PaymentConfirmActivityConfig.BOOK_TYPE, bookThread.book_type);
            qoc.a(jSONObject, MangaBrowserActivityConfig.CHAPTER_ID, bookThread.chapter_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
