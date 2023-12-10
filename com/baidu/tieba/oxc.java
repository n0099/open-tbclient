package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedHeadImg;
/* loaded from: classes7.dex */
public class oxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadImg feedHeadImg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadImg)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, feedHeadImg.img_url);
            ltc.a(jSONObject, "shape_type", feedHeadImg.shape_type);
            ltc.a(jSONObject, "pendant_url", feedHeadImg.pendant_url);
            ltc.a(jSONObject, "corner_url", feedHeadImg.corner_url);
            ltc.a(jSONObject, "schema", feedHeadImg.schema);
            if (feedHeadImg.masks != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : feedHeadImg.masks) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "masks", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
