package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BirthdayInfo;
/* loaded from: classes6.dex */
public class jqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BirthdayInfo birthdayInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, birthdayInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "birthday_time", birthdayInfo.birthday_time);
            poc.a(jSONObject, "birthday_show_status", birthdayInfo.birthday_show_status);
            poc.a(jSONObject, "constellation", birthdayInfo.constellation);
            poc.a(jSONObject, "age", birthdayInfo.age);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
