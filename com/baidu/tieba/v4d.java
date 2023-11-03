package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThreadPicList;
/* loaded from: classes8.dex */
public class v4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadPicList threadPicList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadPicList)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "pic", threadPicList.pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
