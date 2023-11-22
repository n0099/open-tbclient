package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NoticeInfo;
/* loaded from: classes7.dex */
public class l0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NoticeInfo noticeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, noticeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "notice", noticeInfo.notice);
            qoc.a(jSONObject, "pullCommentFrequence", noticeInfo.pullCommentFrequence);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
