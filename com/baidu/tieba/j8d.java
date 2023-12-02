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
/* loaded from: classes6.dex */
public class j8d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleForum simpleForum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleForum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", simpleForum.id);
            ktc.a(jSONObject, "name", simpleForum.name);
            ktc.a(jSONObject, "is_exists", simpleForum.is_exists);
            ktc.a(jSONObject, "avatar", simpleForum.avatar);
            ktc.a(jSONObject, "is_liked", simpleForum.is_liked);
            ktc.a(jSONObject, "is_signed", simpleForum.is_signed);
            ktc.a(jSONObject, "first_class", simpleForum.first_class);
            ktc.a(jSONObject, "second_class", simpleForum.second_class);
            ktc.a(jSONObject, "ext", simpleForum.ext);
            ktc.a(jSONObject, "level_id", simpleForum.level_id);
            MultiForumPerm multiForumPerm = simpleForum.multi_forum_perm;
            if (multiForumPerm != null) {
                ktc.a(jSONObject, "multi_forum_perm", f5d.b(multiForumPerm));
            }
            ktc.a(jSONObject, "member_num", simpleForum.member_num);
            ktc.a(jSONObject, "post_num", simpleForum.post_num);
            ktc.a(jSONObject, "is_brand_forum", simpleForum.is_brand_forum);
            if (simpleForum.tab_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                    jSONArray.put(h3d.b(frsTabInfo));
                }
                ktc.a(jSONObject, "tab_info", jSONArray);
            }
            ktc.a(jSONObject, "forum_toutu", simpleForum.forum_toutu);
            DeletedReasonInfo deletedReasonInfo = simpleForum.deleted_reason_info;
            if (deletedReasonInfo != null) {
                ktc.a(jSONObject, "deleted_reason_info", lwc.b(deletedReasonInfo));
            }
            ktc.a(jSONObject, "is_frs_mask", simpleForum.is_frs_mask);
            ThemeColorInfo themeColorInfo = simpleForum.theme_color;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "theme_color", s9d.b(themeColorInfo));
            }
            ktc.a(jSONObject, "recommend_tip", simpleForum.recommend_tip);
            if (simpleForum.pendants != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : simpleForum.pendants) {
                    jSONArray2.put(str);
                }
                ktc.a(jSONObject, "pendants", jSONArray2);
            }
            ForumShowInfo forumShowInfo = simpleForum.show_info;
            if (forumShowInfo != null) {
                ktc.a(jSONObject, "show_info", myc.b(forumShowInfo));
            }
            SpritePBGuide spritePBGuide = simpleForum.sprite_pb_guide;
            if (spritePBGuide != null) {
                ktc.a(jSONObject, "sprite_pb_guide", s8d.b(spritePBGuide));
            }
            ktc.a(jSONObject, "scheme", simpleForum.scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
