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
public class mwc extends poc {
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
                poc.a(jSONObject, "private_forum_shareinfo", lwc.b(privateForumShareinfo));
            }
            PrivatePopInfo privatePopInfo = privateForumTotalInfo.private_forum_popinfo;
            if (privatePopInfo != null) {
                poc.a(jSONObject, "private_forum_popinfo", t1d.b(privatePopInfo));
            }
            PrivateForumInfo privateForumInfo = privateForumTotalInfo.private_forum_info;
            if (privateForumInfo != null) {
                poc.a(jSONObject, "private_forum_info", s1d.b(privateForumInfo));
            }
            poc.a(jSONObject, "private_forum_taskpercent", privateForumTotalInfo.private_forum_taskpercent);
            HeadImgs headImgs = privateForumTotalInfo.head_imgs;
            if (headImgs != null) {
                poc.a(jSONObject, "head_imgs", qvc.c(headImgs));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
