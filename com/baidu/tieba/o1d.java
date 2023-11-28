package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.HeadImgs;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.PrivateForumInfo;
import tbclient.PrivatePopInfo;
/* loaded from: classes7.dex */
public class o1d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PrivateForumTotalInfo privateForumTotalInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, privateForumTotalInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            PrivateForumShareinfo privateForumShareinfo = privateForumTotalInfo.private_forum_shareinfo;
            if (privateForumShareinfo != null) {
                ltc.a(jSONObject, "private_forum_shareinfo", n1d.b(privateForumShareinfo));
            }
            PrivatePopInfo privatePopInfo = privateForumTotalInfo.private_forum_popinfo;
            if (privatePopInfo != null) {
                ltc.a(jSONObject, "private_forum_popinfo", x6d.b(privatePopInfo));
            }
            PrivateForumInfo privateForumInfo = privateForumTotalInfo.private_forum_info;
            if (privateForumInfo != null) {
                ltc.a(jSONObject, "private_forum_info", w6d.b(privateForumInfo));
            }
            ltc.a(jSONObject, "private_forum_taskpercent", privateForumTotalInfo.private_forum_taskpercent);
            HeadImgs headImgs = privateForumTotalInfo.head_imgs;
            if (headImgs != null) {
                ltc.a(jSONObject, "head_imgs", r0d.c(headImgs));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
