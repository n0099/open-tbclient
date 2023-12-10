package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.center.clearcache.DiskUpdateListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActInfo;
import tbclient.SeniorLottery;
/* loaded from: classes8.dex */
public class rtc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActInfo actInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "activity_type", actInfo.activity_type);
            ltc.a(jSONObject, "status", actInfo.status);
            ltc.a(jSONObject, DiskUpdateListener.BEGIN_TIME, actInfo.begin_time);
            ltc.a(jSONObject, "end_time", actInfo.end_time);
            ltc.a(jSONObject, "url", actInfo.url);
            ltc.a(jSONObject, "total_num", actInfo.total_num);
            ltc.a(jSONObject, "activity_id", actInfo.activity_id);
            ltc.a(jSONObject, "award_act_id", actInfo.award_act_id);
            ltc.a(jSONObject, "component_id", actInfo.component_id);
            ltc.a(jSONObject, "is_senior", actInfo.is_senior);
            ltc.a(jSONObject, "banner_img", actInfo.banner_img);
            ltc.a(jSONObject, "banner_img_size", actInfo.banner_img_size);
            SeniorLottery seniorLottery = actInfo.lottery_senior;
            if (seniorLottery != null) {
                ltc.a(jSONObject, "lottery_senior", a8d.b(seniorLottery));
            }
            ltc.a(jSONObject, "show_total_num", actInfo.show_total_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
