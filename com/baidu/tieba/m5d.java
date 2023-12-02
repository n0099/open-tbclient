package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GameAttr;
import tbclient.Global;
import tbclient.MparrProps;
import tbclient.NewUser;
import tbclient.NoticeMask;
import tbclient.ParrProps;
import tbclient.ParrScores;
import tbclient.Props;
import tbclient.Rpgoldicon;
import tbclient.TbmallMonthIcon;
import tbclient.WapRn;
/* loaded from: classes7.dex */
public class m5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewUser newUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", newUser.user_id);
            ktc.a(jSONObject, "user_name", newUser.user_name);
            ktc.a(jSONObject, IntentConfig.USER_SEX, newUser.user_sex);
            ktc.a(jSONObject, "user_status", newUser.user_status);
            ktc.a(jSONObject, "meizhi_level", newUser.meizhi_level);
            ktc.a(jSONObject, "superboy", newUser.superboy);
            ktc.a(jSONObject, "card", newUser.card);
            ParrProps parrProps = newUser.parr_props;
            if (parrProps != null) {
                ktc.a(jSONObject, "parr_props", w5d.b(parrProps));
            }
            MparrProps mparrProps = newUser.m_parr_props;
            if (mparrProps != null) {
                ktc.a(jSONObject, "m_parr_props", e5d.b(mparrProps));
            }
            WapRn wapRn = newUser.wap_rn;
            if (wapRn != null) {
                ktc.a(jSONObject, "wap_rn", lbd.b(wapRn));
            }
            ktc.a(jSONObject, "is_tenyear", newUser.is_tenyear);
            ktc.a(jSONObject, "is_group_owner", newUser.is_group_owner);
            ParrScores parrScores = newUser.parr_scores;
            if (parrScores != null) {
                ktc.a(jSONObject, "parr_scores", x5d.b(parrScores));
            }
            ktc.a(jSONObject, "user_type", newUser.user_type);
            ktc.a(jSONObject, "use_sig", newUser.use_sig);
            ktc.a(jSONObject, "paper", newUser.paper);
            ktc.a(jSONObject, "bg_id", newUser.bg_id);
            ktc.a(jSONObject, "is_shengyou", newUser.is_shengyou);
            ktc.a(jSONObject, "is_hardworking", newUser.is_hardworking);
            ktc.a(jSONObject, "billboard", newUser.billboard);
            ktc.a(jSONObject, "portrait_time", newUser.portrait_time);
            if (newUser.appraise != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : newUser.appraise) {
                    jSONArray.put(x6d.b(props));
                }
                ktc.a(jSONObject, "appraise", jSONArray);
            }
            ktc.a(jSONObject, "tbscore_repeate_finish_time", newUser.tbscore_repeate_finish_time);
            ktc.a(jSONObject, MissonDetailsActivityConfig.IS_MEMBER, newUser.is_member);
            ktc.a(jSONObject, "is_passer", newUser.is_passer);
            ktc.a(jSONObject, "is_qun_spring", newUser.is_qun_spring);
            if (newUser.notice_mask != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (NoticeMask noticeMask : newUser.notice_mask) {
                    jSONArray2.put(o5d.b(noticeMask));
                }
                ktc.a(jSONObject, "notice_mask", jSONArray2);
            }
            if (newUser.rpgoldicon != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Rpgoldicon rpgoldicon : newUser.rpgoldicon) {
                    jSONArray3.put(w7d.b(rpgoldicon));
                }
                ktc.a(jSONObject, "rpgoldicon", jSONArray3);
            }
            ktc.a(jSONObject, "is_doudizhu", newUser.is_doudizhu);
            ktc.a(jSONObject, "cdn_error", newUser.cdn_error);
            if (newUser.tbmall_month_icon != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (TbmallMonthIcon tbmallMonthIcon : newUser.tbmall_month_icon) {
                    jSONArray4.put(m9d.b(tbmallMonthIcon));
                }
                ktc.a(jSONObject, "tbmall_month_icon", jSONArray4);
            }
            ktc.a(jSONObject, "is_coreuser", newUser.is_coreuser);
            GameAttr gameAttr = newUser.game_attr;
            if (gameAttr != null) {
                ktc.a(jSONObject, "game_attr", m3d.b(gameAttr));
            }
            ktc.a(jSONObject, "is_interestman", newUser.is_interestman);
            Global global = newUser.global;
            if (global != null) {
                ktc.a(jSONObject, "global", p3d.b(global));
            }
            ktc.a(jSONObject, "free_flag", newUser.free_flag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
