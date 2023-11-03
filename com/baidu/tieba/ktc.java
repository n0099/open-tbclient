package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ForumArIno;
/* loaded from: classes7.dex */
public class ktc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumArIno forumArIno) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumArIno)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "switch", forumArIno._switch);
            poc.a(jSONObject, ARConfigKey.AR_ID, forumArIno.ar_id);
            poc.a(jSONObject, "ar_type", forumArIno.ar_type);
            poc.a(jSONObject, "title", forumArIno.title);
            poc.a(jSONObject, "animation_url", forumArIno.animation_url);
            poc.a(jSONObject, "suspension_url", forumArIno.suspension_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
