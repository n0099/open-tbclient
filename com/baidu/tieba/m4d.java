package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Terminal;
/* loaded from: classes7.dex */
public class m4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Terminal terminal) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, terminal)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pc", terminal.pc);
            qoc.a(jSONObject, "wap", terminal.wap);
            qoc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, terminal.client);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
