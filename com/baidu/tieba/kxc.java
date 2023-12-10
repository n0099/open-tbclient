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
public class kxc extends ltc {
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
                ltc.a(jSONObject, "image_data", oxc.b(feedHeadImg));
            }
            if (feedHeadComponent.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedHeadComponent.main_data) {
                    jSONArray.put(pxc.b(feedHeadSymbol));
                }
                ltc.a(jSONObject, "main_data", jSONArray);
            }
            if (feedHeadComponent.extra_data != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol2 : feedHeadComponent.extra_data) {
                    jSONArray2.put(pxc.b(feedHeadSymbol2));
                }
                ltc.a(jSONObject, WriteVoteActivityConfig.EXTRA_DATA_KEY, jSONArray2);
            }
            ltc.a(jSONObject, "schema", feedHeadComponent.schema);
            FeedHeadButton feedHeadButton = feedHeadComponent.button;
            if (feedHeadButton != null) {
                ltc.a(jSONObject, NativeConstants.ID_BUTTON, jxc.b(feedHeadButton));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
