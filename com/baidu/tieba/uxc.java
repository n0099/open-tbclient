package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCup;
import tbclient.FrsPage.WorldCupGame;
import tbclient.FrsPage.WorldCupLottery;
import tbclient.FrsPage.WorldCupNews;
import tbclient.FrsPage.WorldCupPk;
/* loaded from: classes8.dex */
public class uxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCup worldCup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCup)) == null) {
            JSONObject jSONObject = new JSONObject();
            WorldCupNews worldCupNews = worldCup.news;
            if (worldCupNews != null) {
                qoc.a(jSONObject, CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER, yxc.b(worldCupNews));
            }
            WorldCupPk worldCupPk = worldCup.pk;
            if (worldCupPk != null) {
                qoc.a(jSONObject, PushConstants.URI_PACKAGE_NAME, zxc.b(worldCupPk));
            }
            WorldCupLottery worldCupLottery = worldCup.lottery;
            if (worldCupLottery != null) {
                qoc.a(jSONObject, "lottery", xxc.b(worldCupLottery));
            }
            WorldCupGame worldCupGame = worldCup.game;
            if (worldCupGame != null) {
                qoc.a(jSONObject, "game", vxc.b(worldCupGame));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
