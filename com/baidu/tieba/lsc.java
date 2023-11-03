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
public class lsc extends poc {
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
                poc.a(jSONObject, "image_data", psc.b(feedHeadImg));
            }
            if (feedHeadComponent.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedHeadComponent.main_data) {
                    jSONArray.put(qsc.b(feedHeadSymbol));
                }
                poc.a(jSONObject, "main_data", jSONArray);
            }
            if (feedHeadComponent.extra_data != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol2 : feedHeadComponent.extra_data) {
                    jSONArray2.put(qsc.b(feedHeadSymbol2));
                }
                poc.a(jSONObject, WriteVoteActivityConfig.EXTRA_DATA_KEY, jSONArray2);
            }
            poc.a(jSONObject, "schema", feedHeadComponent.schema);
            FeedHeadButton feedHeadButton = feedHeadComponent.button;
            if (feedHeadButton != null) {
                poc.a(jSONObject, NativeConstants.ID_BUTTON, ksc.b(feedHeadButton));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
