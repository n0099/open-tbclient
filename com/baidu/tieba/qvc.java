package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CardFreq;
import tbclient.FrsPage.HeadCardCover;
import tbclient.FrsPage.MatchCardInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public class qvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeadCardCover headCardCover) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headCardCover)) == null) {
            JSONObject jSONObject = new JSONObject();
            CardFreq cardFreq = headCardCover.freq;
            if (cardFreq != null) {
                qoc.a(jSONObject, "freq", puc.b(cardFreq));
            }
            ThemeColorInfo themeColorInfo = headCardCover.card_background;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "card_background", q4d.b(themeColorInfo));
            }
            MatchCardInfo matchCardInfo = headCardCover.match_info;
            if (matchCardInfo != null) {
                qoc.a(jSONObject, "match_info", yvc.b(matchCardInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
