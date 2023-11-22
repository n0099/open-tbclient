package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes7.dex */
public class kqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BirthdayInfo birthdayInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, birthdayInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "birthday_time", birthdayInfo.birthday_time);
            qoc.a(jSONObject, "birthday_show_status", birthdayInfo.birthday_show_status);
            qoc.a(jSONObject, "constellation", birthdayInfo.constellation);
            qoc.a(jSONObject, "age", birthdayInfo.age);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
