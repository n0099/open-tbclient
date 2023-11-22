package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedHeadButton;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
/* loaded from: classes7.dex */
public class msc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadComponent feedHeadComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            FeedHeadImg feedHeadImg = feedHeadComponent.image_data;
            if (feedHeadImg != null) {
                qoc.a(jSONObject, "image_data", qsc.b(feedHeadImg));
            }
            if (feedHeadComponent.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedHeadComponent.main_data) {
                    jSONArray.put(rsc.b(feedHeadSymbol));
                }
                qoc.a(jSONObject, "main_data", jSONArray);
            }
            if (feedHeadComponent.extra_data != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol2 : feedHeadComponent.extra_data) {
                    jSONArray2.put(rsc.b(feedHeadSymbol2));
                }
                qoc.a(jSONObject, WriteVoteActivityConfig.EXTRA_DATA_KEY, jSONArray2);
            }
            qoc.a(jSONObject, "schema", feedHeadComponent.schema);
            FeedHeadButton feedHeadButton = feedHeadComponent.button;
            if (feedHeadButton != null) {
                qoc.a(jSONObject, NativeConstants.ID_BUTTON, lsc.b(feedHeadButton));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
