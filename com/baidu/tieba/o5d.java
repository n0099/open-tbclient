package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NoticeInfo;
/* loaded from: classes7.dex */
public class o5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NoticeInfo noticeInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, noticeInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "notice", noticeInfo.notice);
            ltc.a(jSONObject, "pullCommentFrequence", noticeInfo.pullCommentFrequence);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
