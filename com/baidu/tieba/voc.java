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
public class voc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActInfo actInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "activity_type", actInfo.activity_type);
            poc.a(jSONObject, "status", actInfo.status);
            poc.a(jSONObject, DiskUpdateListener.BEGIN_TIME, actInfo.begin_time);
            poc.a(jSONObject, "end_time", actInfo.end_time);
            poc.a(jSONObject, "url", actInfo.url);
            poc.a(jSONObject, "total_num", actInfo.total_num);
            poc.a(jSONObject, "activity_id", actInfo.activity_id);
            poc.a(jSONObject, "award_act_id", actInfo.award_act_id);
            poc.a(jSONObject, "component_id", actInfo.component_id);
            poc.a(jSONObject, "is_senior", actInfo.is_senior);
            poc.a(jSONObject, "banner_img", actInfo.banner_img);
            poc.a(jSONObject, "banner_img_size", actInfo.banner_img_size);
            SeniorLottery seniorLottery = actInfo.lottery_senior;
            if (seniorLottery != null) {
                poc.a(jSONObject, "lottery_senior", w2d.b(seniorLottery));
            }
            poc.a(jSONObject, "show_total_num", actInfo.show_total_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
