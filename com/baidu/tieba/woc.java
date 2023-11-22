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
public class woc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActInfo actInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "activity_type", actInfo.activity_type);
            qoc.a(jSONObject, "status", actInfo.status);
            qoc.a(jSONObject, DiskUpdateListener.BEGIN_TIME, actInfo.begin_time);
            qoc.a(jSONObject, "end_time", actInfo.end_time);
            qoc.a(jSONObject, "url", actInfo.url);
            qoc.a(jSONObject, "total_num", actInfo.total_num);
            qoc.a(jSONObject, "activity_id", actInfo.activity_id);
            qoc.a(jSONObject, "award_act_id", actInfo.award_act_id);
            qoc.a(jSONObject, "component_id", actInfo.component_id);
            qoc.a(jSONObject, "is_senior", actInfo.is_senior);
            qoc.a(jSONObject, "banner_img", actInfo.banner_img);
            qoc.a(jSONObject, "banner_img_size", actInfo.banner_img_size);
            SeniorLottery seniorLottery = actInfo.lottery_senior;
            if (seniorLottery != null) {
                qoc.a(jSONObject, "lottery_senior", x2d.b(seniorLottery));
            }
            qoc.a(jSONObject, "show_total_num", actInfo.show_total_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
