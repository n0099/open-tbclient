package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PrivSets;
/* loaded from: classes8.dex */
public class r1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivSets privSets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privSets)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "location", privSets.location);
            poc.a(jSONObject, "like", privSets.like);
            poc.a(jSONObject, "group", privSets.group);
            poc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, privSets.post);
            poc.a(jSONObject, "friend", privSets.friend);
            poc.a(jSONObject, "live", privSets.live);
            poc.a(jSONObject, "reply", privSets.reply);
            poc.a(jSONObject, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, privSets.bazhu_show_inside);
            poc.a(jSONObject, "bazhu_show_outside", privSets.bazhu_show_outside);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
