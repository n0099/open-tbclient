package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThumbnailInfo;
import tbclient.VideoField;
/* loaded from: classes9.dex */
public class x5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoField videoField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoField)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", videoField.url);
            poc.a(jSONObject, "duration", videoField.duration);
            poc.a(jSONObject, "width", videoField.width);
            poc.a(jSONObject, "height", videoField.height);
            poc.a(jSONObject, "play_count", videoField.play_count);
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                poc.a(jSONObject, "thumbnail", y4d.b(thumbnailInfo));
            }
            poc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoField.is_vertical);
            poc.a(jSONObject, PackageTable.MD5, videoField.md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
