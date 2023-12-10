package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FeedHeadFigure;
/* loaded from: classes7.dex */
public class mxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadFigure feedHeadFigure) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadFigure)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, feedHeadFigure.img_url);
            ltc.a(jSONObject, "bg_type", feedHeadFigure.bg_type);
            ltc.a(jSONObject, "bg_value", feedHeadFigure.bg_value);
            ltc.a(jSONObject, "corner_url", feedHeadFigure.corner_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
