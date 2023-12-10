package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.HeadCardCover;
import tbclient.FrsPage.HeaderCard;
import tbclient.QuizCard;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class t0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeaderCard headerCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headerCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "card_title", headerCard.card_title);
            if (headerCard.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : headerCard.thread_list) {
                    jSONArray.put(y9d.b(threadInfo));
                }
                ltc.a(jSONObject, "thread_list", jSONArray);
            }
            ThemeColorInfo themeColorInfo = headerCard.card_background;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, "card_background", t9d.b(themeColorInfo));
            }
            HeadCardCover headCardCover = headerCard.cover;
            if (headCardCover != null) {
                ltc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, q0d.b(headCardCover));
            }
            QuizCard quizCard = headerCard.quiz_card;
            if (quizCard != null) {
                ltc.a(jSONObject, "quiz_card", e7d.b(quizCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
