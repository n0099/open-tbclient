package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DeletedReasonInfo;
import tbclient.ForumShowInfo;
import tbclient.FrsTabInfo;
import tbclient.MultiForumPerm;
import tbclient.SimpleForum;
import tbclient.SpritePBGuide;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class k8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleForum simpleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", simpleForum.id);
            ltc.a(jSONObject, "name", simpleForum.name);
            ltc.a(jSONObject, "is_exists", simpleForum.is_exists);
            ltc.a(jSONObject, "avatar", simpleForum.avatar);
            ltc.a(jSONObject, "is_liked", simpleForum.is_liked);
            ltc.a(jSONObject, "is_signed", simpleForum.is_signed);
            ltc.a(jSONObject, "first_class", simpleForum.first_class);
            ltc.a(jSONObject, "second_class", simpleForum.second_class);
            ltc.a(jSONObject, "ext", simpleForum.ext);
            ltc.a(jSONObject, "level_id", simpleForum.level_id);
            MultiForumPerm multiForumPerm = simpleForum.multi_forum_perm;
            if (multiForumPerm != null) {
                ltc.a(jSONObject, "multi_forum_perm", g5d.b(multiForumPerm));
            }
            ltc.a(jSONObject, "member_num", simpleForum.member_num);
            ltc.a(jSONObject, "post_num", simpleForum.post_num);
            ltc.a(jSONObject, "is_brand_forum", simpleForum.is_brand_forum);
            if (simpleForum.tab_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                    jSONArray.put(i3d.b(frsTabInfo));
                }
                ltc.a(jSONObject, "tab_info", jSONArray);
            }
            ltc.a(jSONObject, "forum_toutu", simpleForum.forum_toutu);
            DeletedReasonInfo deletedReasonInfo = simpleForum.deleted_reason_info;
            if (deletedReasonInfo != null) {
                ltc.a(jSONObject, "deleted_reason_info", mwc.b(deletedReasonInfo));
            }
            ltc.a(jSONObject, "is_frs_mask", simpleForum.is_frs_mask);
            ThemeColorInfo themeColorInfo = simpleForum.theme_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, "theme_color", t9d.b(themeColorInfo));
            }
            ltc.a(jSONObject, "recommend_tip", simpleForum.recommend_tip);
            if (simpleForum.pendants != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : simpleForum.pendants) {
                    jSONArray2.put(str);
                }
                ltc.a(jSONObject, "pendants", jSONArray2);
            }
            ForumShowInfo forumShowInfo = simpleForum.show_info;
            if (forumShowInfo != null) {
                ltc.a(jSONObject, "show_info", nyc.b(forumShowInfo));
            }
            SpritePBGuide spritePBGuide = simpleForum.sprite_pb_guide;
            if (spritePBGuide != null) {
                ltc.a(jSONObject, "sprite_pb_guide", t8d.b(spritePBGuide));
            }
            ltc.a(jSONObject, "scheme", simpleForum.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
