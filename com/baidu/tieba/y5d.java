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
public class y5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VideoField videoField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, videoField)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "url", videoField.url);
            qoc.a(jSONObject, "duration", videoField.duration);
            qoc.a(jSONObject, "width", videoField.width);
            qoc.a(jSONObject, "height", videoField.height);
            qoc.a(jSONObject, "play_count", videoField.play_count);
            ThumbnailInfo thumbnailInfo = videoField.thumbnail;
            if (thumbnailInfo != null) {
                qoc.a(jSONObject, "thumbnail", z4d.b(thumbnailInfo));
            }
            qoc.a(jSONObject, TiebaStatic.Params.IS_VERTICAL, videoField.is_vertical);
            qoc.a(jSONObject, PackageTable.MD5, videoField.md5);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
