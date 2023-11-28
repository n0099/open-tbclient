package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedOriginPic;
import tbclient.PicInfo;
/* loaded from: classes9.dex */
public class yxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedOriginPic feedOriginPic) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedOriginPic)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedOriginPic.pics != null) {
                JSONArray jSONArray = new JSONArray();
                for (PicInfo picInfo : feedOriginPic.pics) {
                    jSONArray.put(j6d.b(picInfo));
                }
                ltc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            ltc.a(jSONObject, "schema", feedOriginPic.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
