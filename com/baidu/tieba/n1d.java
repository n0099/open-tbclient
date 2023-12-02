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
public class n1d extends ktc {
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
                ktc.a(jSONObject, "private_forum_shareinfo", m1d.b(privateForumShareinfo));
            }
            PrivatePopInfo privatePopInfo = privateForumTotalInfo.private_forum_popinfo;
            if (privatePopInfo != null) {
                ktc.a(jSONObject, "private_forum_popinfo", w6d.b(privatePopInfo));
            }
            PrivateForumInfo privateForumInfo = privateForumTotalInfo.private_forum_info;
            if (privateForumInfo != null) {
                ktc.a(jSONObject, "private_forum_info", v6d.b(privateForumInfo));
            }
            ktc.a(jSONObject, "private_forum_taskpercent", privateForumTotalInfo.private_forum_taskpercent);
            HeadImgs headImgs = privateForumTotalInfo.head_imgs;
            if (headImgs != null) {
                ktc.a(jSONObject, "head_imgs", q0d.c(headImgs));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
