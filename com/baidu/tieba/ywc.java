package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.FeedAuthorSocial;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
import tbclient.LayoutManageInfo;
/* loaded from: classes9.dex */
public class ywc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedAuthorSocial feedAuthorSocial) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedAuthorSocial)) == null) {
            JSONObject jSONObject = new JSONObject();
            FeedHeadImg feedHeadImg = feedAuthorSocial.image_data;
            if (feedHeadImg != null) {
                ktc.a(jSONObject, "image_data", nxc.b(feedHeadImg));
            }
            if (feedAuthorSocial.main_data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedHeadSymbol feedHeadSymbol : feedAuthorSocial.main_data) {
                    jSONArray.put(oxc.b(feedHeadSymbol));
                }
                ktc.a(jSONObject, "main_data", jSONArray);
            }
            Agree agree = feedAuthorSocial.agree;
            if (agree != null) {
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            ktc.a(jSONObject, "comment_num", feedAuthorSocial.comment_num);
            ktc.a(jSONObject, "share_num", feedAuthorSocial.share_num);
            ktc.a(jSONObject, "tid", feedAuthorSocial.tid);
            ktc.a(jSONObject, "fid", feedAuthorSocial.fid);
            if (feedAuthorSocial.manage_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (LayoutManageInfo layoutManageInfo : feedAuthorSocial.manage_list) {
                    jSONArray2.put(n4d.b(layoutManageInfo));
                }
                ktc.a(jSONObject, "manage_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
