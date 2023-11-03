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
/* loaded from: classes7.dex */
public class pvc extends poc {
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
                poc.a(jSONObject, "freq", ouc.b(cardFreq));
            }
            ThemeColorInfo themeColorInfo = headCardCover.card_background;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "card_background", p4d.b(themeColorInfo));
            }
            MatchCardInfo matchCardInfo = headCardCover.match_info;
            if (matchCardInfo != null) {
                poc.a(jSONObject, "match_info", xvc.b(matchCardInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
