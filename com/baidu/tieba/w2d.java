package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AwardInfo;
import tbclient.AwardUser;
import tbclient.LotteryRegular;
import tbclient.LotteryTheme;
import tbclient.SeniorLottery;
/* loaded from: classes8.dex */
public class w2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SeniorLottery seniorLottery) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, seniorLottery)) == null) {
            JSONObject jSONObject = new JSONObject();
            LotteryTheme lotteryTheme = seniorLottery.theme;
            if (lotteryTheme != null) {
                poc.a(jSONObject, "theme", vzc.b(lotteryTheme));
            }
            if (seniorLottery.award_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (AwardInfo awardInfo : seniorLottery.award_info) {
                    jSONArray.put(zpc.b(awardInfo));
                }
                poc.a(jSONObject, "award_info", jSONArray);
            }
            poc.a(jSONObject, "myaward", seniorLottery.myaward);
            if (seniorLottery.luck_users != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AwardUser awardUser : seniorLottery.luck_users) {
                    jSONArray2.put(aqc.b(awardUser));
                }
                poc.a(jSONObject, "luck_users", jSONArray2);
            }
            poc.a(jSONObject, "act_desc", seniorLottery.act_desc);
            if (seniorLottery.act_regular != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (LotteryRegular lotteryRegular : seniorLottery.act_regular) {
                    jSONArray3.put(uzc.b(lotteryRegular));
                }
                poc.a(jSONObject, "act_regular", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
