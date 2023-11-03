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
public class svc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeaderCard headerCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headerCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "card_title", headerCard.card_title);
            if (headerCard.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : headerCard.thread_list) {
                    jSONArray.put(u4d.b(threadInfo));
                }
                poc.a(jSONObject, "thread_list", jSONArray);
            }
            ThemeColorInfo themeColorInfo = headerCard.card_background;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "card_background", p4d.b(themeColorInfo));
            }
            HeadCardCover headCardCover = headerCard.cover;
            if (headCardCover != null) {
                poc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, pvc.b(headCardCover));
            }
            QuizCard quizCard = headerCard.quiz_card;
            if (quizCard != null) {
                poc.a(jSONObject, "quiz_card", a2d.b(quizCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
