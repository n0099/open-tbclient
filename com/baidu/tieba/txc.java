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
public class txc extends poc {
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
                poc.a(jSONObject, CommonToolbarStatisticConstants.TOOLBAR_MENU_NEW_DETAIL_BROWSER, xxc.b(worldCupNews));
            }
            WorldCupPk worldCupPk = worldCup.pk;
            if (worldCupPk != null) {
                poc.a(jSONObject, PushConstants.URI_PACKAGE_NAME, yxc.b(worldCupPk));
            }
            WorldCupLottery worldCupLottery = worldCup.lottery;
            if (worldCupLottery != null) {
                poc.a(jSONObject, "lottery", wxc.b(worldCupLottery));
            }
            WorldCupGame worldCupGame = worldCup.game;
            if (worldCupGame != null) {
                poc.a(jSONObject, "game", uxc.b(worldCupGame));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
