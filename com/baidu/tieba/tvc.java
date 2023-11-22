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
public class tvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeaderCard headerCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headerCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "card_title", headerCard.card_title);
            if (headerCard.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : headerCard.thread_list) {
                    jSONArray.put(v4d.b(threadInfo));
                }
                qoc.a(jSONObject, "thread_list", jSONArray);
            }
            ThemeColorInfo themeColorInfo = headerCard.card_background;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "card_background", q4d.b(themeColorInfo));
            }
            HeadCardCover headCardCover = headerCard.cover;
            if (headCardCover != null) {
                qoc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, qvc.b(headCardCover));
            }
            QuizCard quizCard = headerCard.quiz_card;
            if (quizCard != null) {
                qoc.a(jSONObject, "quiz_card", b2d.b(quizCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
