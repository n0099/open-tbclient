package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BookThread;
/* loaded from: classes6.dex */
public class jvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BookThread bookThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bookThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "book_id", bookThread.book_id);
            ltc.a(jSONObject, PaymentConfirmActivityConfig.BOOK_TYPE, bookThread.book_type);
            ltc.a(jSONObject, MangaBrowserActivityConfig.CHAPTER_ID, bookThread.chapter_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
