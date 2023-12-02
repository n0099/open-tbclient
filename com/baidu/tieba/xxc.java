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
public class xxc extends ktc {
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
                    jSONArray.put(i6d.b(picInfo));
                }
                ktc.a(jSONObject, SocialConstants.PARAM_IMAGE, jSONArray);
            }
            ktc.a(jSONObject, "schema", feedOriginPic.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
