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
public class u6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivSets privSets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privSets)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "location", privSets.location);
            ktc.a(jSONObject, "like", privSets.like);
            ktc.a(jSONObject, "group", privSets.group);
            ktc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, privSets.post);
            ktc.a(jSONObject, "friend", privSets.friend);
            ktc.a(jSONObject, "live", privSets.live);
            ktc.a(jSONObject, "reply", privSets.reply);
            ktc.a(jSONObject, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, privSets.bazhu_show_inside);
            ktc.a(jSONObject, "bazhu_show_outside", privSets.bazhu_show_outside);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
