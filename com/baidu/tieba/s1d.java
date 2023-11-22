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
public class s1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivSets privSets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privSets)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "location", privSets.location);
            qoc.a(jSONObject, "like", privSets.like);
            qoc.a(jSONObject, "group", privSets.group);
            qoc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, privSets.post);
            qoc.a(jSONObject, "friend", privSets.friend);
            qoc.a(jSONObject, "live", privSets.live);
            qoc.a(jSONObject, "reply", privSets.reply);
            qoc.a(jSONObject, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, privSets.bazhu_show_inside);
            qoc.a(jSONObject, "bazhu_show_outside", privSets.bazhu_show_outside);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
