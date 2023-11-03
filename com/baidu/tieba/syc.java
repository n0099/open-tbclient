package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.HeadcardLayout;
import tbclient.PubHeadCardCover;
import tbclient.QuizCard;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class syc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeadcardLayout headcardLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headcardLayout)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "card_title", headcardLayout.card_title);
            if (headcardLayout.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : headcardLayout.thread_list) {
                    jSONArray.put(u4d.b(threadInfo));
                }
                poc.a(jSONObject, "thread_list", jSONArray);
            }
            ThemeColorInfo themeColorInfo = headcardLayout.card_background;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "card_background", p4d.b(themeColorInfo));
            }
            PubHeadCardCover pubHeadCardCover = headcardLayout.cover;
            if (pubHeadCardCover != null) {
                poc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, x1d.b(pubHeadCardCover));
            }
            QuizCard quizCard = headcardLayout.quiz_card;
            if (quizCard != null) {
                poc.a(jSONObject, "quiz_card", a2d.b(quizCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
