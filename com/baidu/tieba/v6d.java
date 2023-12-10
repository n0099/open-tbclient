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
public class v6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivSets privSets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privSets)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "location", privSets.location);
            ltc.a(jSONObject, "like", privSets.like);
            ltc.a(jSONObject, "group", privSets.group);
            ltc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, privSets.post);
            ltc.a(jSONObject, "friend", privSets.friend);
            ltc.a(jSONObject, "live", privSets.live);
            ltc.a(jSONObject, "reply", privSets.reply);
            ltc.a(jSONObject, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, privSets.bazhu_show_inside);
            ltc.a(jSONObject, "bazhu_show_outside", privSets.bazhu_show_outside);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
