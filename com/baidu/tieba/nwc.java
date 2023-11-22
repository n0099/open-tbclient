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
public class nwc extends qoc {
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
                qoc.a(jSONObject, "private_forum_shareinfo", mwc.b(privateForumShareinfo));
            }
            PrivatePopInfo privatePopInfo = privateForumTotalInfo.private_forum_popinfo;
            if (privatePopInfo != null) {
                qoc.a(jSONObject, "private_forum_popinfo", u1d.b(privatePopInfo));
            }
            PrivateForumInfo privateForumInfo = privateForumTotalInfo.private_forum_info;
            if (privateForumInfo != null) {
                qoc.a(jSONObject, "private_forum_info", t1d.b(privateForumInfo));
            }
            qoc.a(jSONObject, "private_forum_taskpercent", privateForumTotalInfo.private_forum_taskpercent);
            HeadImgs headImgs = privateForumTotalInfo.head_imgs;
            if (headImgs != null) {
                qoc.a(jSONObject, "head_imgs", rvc.c(headImgs));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
