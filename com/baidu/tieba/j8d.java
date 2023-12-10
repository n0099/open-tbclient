package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Avatar;
import tbclient.Equipment;
import tbclient.SignatureInfo;
/* loaded from: classes6.dex */
public class j8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignatureInfo signatureInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signatureInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            Equipment equipment = signatureInfo.equipment;
            if (equipment != null) {
                ltc.a(jSONObject, "equipment", twc.b(equipment));
            }
            ltc.a(jSONObject, "game_id", signatureInfo.game_id);
            ltc.a(jSONObject, "game_name", signatureInfo.game_name);
            ltc.a(jSONObject, DI.LIVE_PLAYER, signatureInfo.player);
            Avatar avatar = signatureInfo.avatar;
            if (avatar != null) {
                ltc.a(jSONObject, "avatar", vuc.b(avatar));
            }
            ltc.a(jSONObject, "power", signatureInfo.power);
            ltc.a(jSONObject, CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_SERVER, signatureInfo.server);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
