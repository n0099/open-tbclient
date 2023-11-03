package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.CustomState;
import tbclient.FeedHeadFigure;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedHeadSymbol;
import tbclient.FeedKV;
/* loaded from: classes7.dex */
public class msc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadFigureComponent feedHeadFigureComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadFigureComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            FeedHeadFigure feedHeadFigure = feedHeadFigureComponent.image_data;
            if (feedHeadFigure != null) {
                poc.a(jSONObject, "image_data", nsc.b(feedHeadFigure));
            }
            if (feedHeadFigureComponent.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedHeadFigureComponent.main_data) {
                    jSONArray.put(qsc.b(feedHeadSymbol));
                }
                poc.a(jSONObject, "main_data", jSONArray);
            }
            if (feedHeadFigureComponent.extra_data != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol2 : feedHeadFigureComponent.extra_data) {
                    jSONArray2.put(qsc.b(feedHeadSymbol2));
                }
                poc.a(jSONObject, WriteVoteActivityConfig.EXTRA_DATA_KEY, jSONArray2);
            }
            poc.a(jSONObject, "schema", feedHeadFigureComponent.schema);
            CustomState customState = feedHeadFigureComponent.custom_state;
            if (customState != null) {
                poc.a(jSONObject, "custom_state", hrc.b(customState));
            }
            if (feedHeadFigureComponent.business_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (FeedKV feedKV : feedHeadFigureComponent.business_info) {
                    jSONArray3.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "business_info", jSONArray3);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
