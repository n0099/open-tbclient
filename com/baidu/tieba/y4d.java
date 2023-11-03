package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThumbnailInfo;
/* loaded from: classes9.dex */
public class y4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThumbnailInfo thumbnailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, thumbnailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", thumbnailInfo.url);
            poc.a(jSONObject, "width", thumbnailInfo.width);
            poc.a(jSONObject, "height", thumbnailInfo.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
