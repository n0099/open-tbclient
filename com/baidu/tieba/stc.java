package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsBottomActivity;
import tbclient.FrsBottomActivityBase;
/* loaded from: classes8.dex */
public class stc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomActivityBase frsBottomActivityBase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomActivityBase)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (frsBottomActivityBase.activity_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsBottomActivity frsBottomActivity : frsBottomActivityBase.activity_list) {
                    jSONArray.put(ttc.b(frsBottomActivity));
                }
                poc.a(jSONObject, "activity_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
