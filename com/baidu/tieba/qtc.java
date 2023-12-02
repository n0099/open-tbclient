package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.center.clearcache.DiskUpdateListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActInfo;
import tbclient.SeniorLottery;
/* loaded from: classes7.dex */
public class qtc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActInfo actInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "activity_type", actInfo.activity_type);
            ktc.a(jSONObject, "status", actInfo.status);
            ktc.a(jSONObject, DiskUpdateListener.BEGIN_TIME, actInfo.begin_time);
            ktc.a(jSONObject, "end_time", actInfo.end_time);
            ktc.a(jSONObject, "url", actInfo.url);
            ktc.a(jSONObject, "total_num", actInfo.total_num);
            ktc.a(jSONObject, "activity_id", actInfo.activity_id);
            ktc.a(jSONObject, "award_act_id", actInfo.award_act_id);
            ktc.a(jSONObject, "component_id", actInfo.component_id);
            ktc.a(jSONObject, "is_senior", actInfo.is_senior);
            ktc.a(jSONObject, "banner_img", actInfo.banner_img);
            ktc.a(jSONObject, "banner_img_size", actInfo.banner_img_size);
            SeniorLottery seniorLottery = actInfo.lottery_senior;
            if (seniorLottery != null) {
                ktc.a(jSONObject, "lottery_senior", z7d.b(seniorLottery));
            }
            ktc.a(jSONObject, "show_total_num", actInfo.show_total_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
