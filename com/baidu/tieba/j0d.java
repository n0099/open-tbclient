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
/* loaded from: classes6.dex */
public class j0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewUser newUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", newUser.user_id);
            poc.a(jSONObject, "user_name", newUser.user_name);
            poc.a(jSONObject, IntentConfig.USER_SEX, newUser.user_sex);
            poc.a(jSONObject, "user_status", newUser.user_status);
            poc.a(jSONObject, "meizhi_level", newUser.meizhi_level);
            poc.a(jSONObject, "superboy", newUser.superboy);
            poc.a(jSONObject, "card", newUser.card);
            ParrProps parrProps = newUser.parr_props;
            if (parrProps != null) {
                poc.a(jSONObject, "parr_props", t0d.b(parrProps));
            }
            MparrProps mparrProps = newUser.m_parr_props;
            if (mparrProps != null) {
                poc.a(jSONObject, "m_parr_props", b0d.b(mparrProps));
            }
            WapRn wapRn = newUser.wap_rn;
            if (wapRn != null) {
                poc.a(jSONObject, "wap_rn", h6d.b(wapRn));
            }
            poc.a(jSONObject, "is_tenyear", newUser.is_tenyear);
            poc.a(jSONObject, "is_group_owner", newUser.is_group_owner);
            ParrScores parrScores = newUser.parr_scores;
            if (parrScores != null) {
                poc.a(jSONObject, "parr_scores", u0d.b(parrScores));
            }
            poc.a(jSONObject, "user_type", newUser.user_type);
            poc.a(jSONObject, "use_sig", newUser.use_sig);
            poc.a(jSONObject, "paper", newUser.paper);
            poc.a(jSONObject, "bg_id", newUser.bg_id);
            poc.a(jSONObject, "is_shengyou", newUser.is_shengyou);
            poc.a(jSONObject, "is_hardworking", newUser.is_hardworking);
            poc.a(jSONObject, "billboard", newUser.billboard);
            poc.a(jSONObject, "portrait_time", newUser.portrait_time);
            if (newUser.appraise != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : newUser.appraise) {
                    jSONArray.put(u1d.b(props));
                }
                poc.a(jSONObject, "appraise", jSONArray);
            }
            poc.a(jSONObject, "tbscore_repeate_finish_time", newUser.tbscore_repeate_finish_time);
            poc.a(jSONObject, MissonDetailsActivityConfig.IS_MEMBER, newUser.is_member);
            poc.a(jSONObject, "is_passer", newUser.is_passer);
            poc.a(jSONObject, "is_qun_spring", newUser.is_qun_spring);
            if (newUser.notice_mask != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (NoticeMask noticeMask : newUser.notice_mask) {
                    jSONArray2.put(l0d.b(noticeMask));
                }
                poc.a(jSONObject, "notice_mask", jSONArray2);
            }
            if (newUser.rpgoldicon != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Rpgoldicon rpgoldicon : newUser.rpgoldicon) {
                    jSONArray3.put(t2d.b(rpgoldicon));
                }
                poc.a(jSONObject, "rpgoldicon", jSONArray3);
            }
            poc.a(jSONObject, "is_doudizhu", newUser.is_doudizhu);
            poc.a(jSONObject, "cdn_error", newUser.cdn_error);
            if (newUser.tbmall_month_icon != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (TbmallMonthIcon tbmallMonthIcon : newUser.tbmall_month_icon) {
                    jSONArray4.put(j4d.b(tbmallMonthIcon));
                }
                poc.a(jSONObject, "tbmall_month_icon", jSONArray4);
            }
            poc.a(jSONObject, "is_coreuser", newUser.is_coreuser);
            GameAttr gameAttr = newUser.game_attr;
            if (gameAttr != null) {
                poc.a(jSONObject, "game_attr", jyc.b(gameAttr));
            }
            poc.a(jSONObject, "is_interestman", newUser.is_interestman);
            Global global = newUser.global;
            if (global != null) {
                poc.a(jSONObject, "global", myc.b(global));
            }
            poc.a(jSONObject, "free_flag", newUser.free_flag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
