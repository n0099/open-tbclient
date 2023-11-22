package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThumbnailInfo;
/* loaded from: classes9.dex */
public class z4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThumbnailInfo thumbnailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, thumbnailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "url", thumbnailInfo.url);
            qoc.a(jSONObject, "width", thumbnailInfo.width);
            qoc.a(jSONObject, "height", thumbnailInfo.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
