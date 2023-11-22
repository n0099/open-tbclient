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
public class k0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewUser newUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", newUser.user_id);
            qoc.a(jSONObject, "user_name", newUser.user_name);
            qoc.a(jSONObject, IntentConfig.USER_SEX, newUser.user_sex);
            qoc.a(jSONObject, "user_status", newUser.user_status);
            qoc.a(jSONObject, "meizhi_level", newUser.meizhi_level);
            qoc.a(jSONObject, "superboy", newUser.superboy);
            qoc.a(jSONObject, "card", newUser.card);
            ParrProps parrProps = newUser.parr_props;
            if (parrProps != null) {
                qoc.a(jSONObject, "parr_props", u0d.b(parrProps));
            }
            MparrProps mparrProps = newUser.m_parr_props;
            if (mparrProps != null) {
                qoc.a(jSONObject, "m_parr_props", c0d.b(mparrProps));
            }
            WapRn wapRn = newUser.wap_rn;
            if (wapRn != null) {
                qoc.a(jSONObject, "wap_rn", i6d.b(wapRn));
            }
            qoc.a(jSONObject, "is_tenyear", newUser.is_tenyear);
            qoc.a(jSONObject, "is_group_owner", newUser.is_group_owner);
            ParrScores parrScores = newUser.parr_scores;
            if (parrScores != null) {
                qoc.a(jSONObject, "parr_scores", v0d.b(parrScores));
            }
            qoc.a(jSONObject, "user_type", newUser.user_type);
            qoc.a(jSONObject, "use_sig", newUser.use_sig);
            qoc.a(jSONObject, "paper", newUser.paper);
            qoc.a(jSONObject, "bg_id", newUser.bg_id);
            qoc.a(jSONObject, "is_shengyou", newUser.is_shengyou);
            qoc.a(jSONObject, "is_hardworking", newUser.is_hardworking);
            qoc.a(jSONObject, "billboard", newUser.billboard);
            qoc.a(jSONObject, "portrait_time", newUser.portrait_time);
            if (newUser.appraise != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : newUser.appraise) {
                    jSONArray.put(v1d.b(props));
                }
                qoc.a(jSONObject, "appraise", jSONArray);
            }
            qoc.a(jSONObject, "tbscore_repeate_finish_time", newUser.tbscore_repeate_finish_time);
            qoc.a(jSONObject, MissonDetailsActivityConfig.IS_MEMBER, newUser.is_member);
            qoc.a(jSONObject, "is_passer", newUser.is_passer);
            qoc.a(jSONObject, "is_qun_spring", newUser.is_qun_spring);
            if (newUser.notice_mask != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (NoticeMask noticeMask : newUser.notice_mask) {
                    jSONArray2.put(m0d.b(noticeMask));
                }
                qoc.a(jSONObject, "notice_mask", jSONArray2);
            }
            if (newUser.rpgoldicon != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Rpgoldicon rpgoldicon : newUser.rpgoldicon) {
                    jSONArray3.put(u2d.b(rpgoldicon));
                }
                qoc.a(jSONObject, "rpgoldicon", jSONArray3);
            }
            qoc.a(jSONObject, "is_doudizhu", newUser.is_doudizhu);
            qoc.a(jSONObject, "cdn_error", newUser.cdn_error);
            if (newUser.tbmall_month_icon != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (TbmallMonthIcon tbmallMonthIcon : newUser.tbmall_month_icon) {
                    jSONArray4.put(k4d.b(tbmallMonthIcon));
                }
                qoc.a(jSONObject, "tbmall_month_icon", jSONArray4);
            }
            qoc.a(jSONObject, "is_coreuser", newUser.is_coreuser);
            GameAttr gameAttr = newUser.game_attr;
            if (gameAttr != null) {
                qoc.a(jSONObject, "game_attr", kyc.b(gameAttr));
            }
            qoc.a(jSONObject, "is_interestman", newUser.is_interestman);
            Global global = newUser.global;
            if (global != null) {
                qoc.a(jSONObject, "global", nyc.b(global));
            }
            qoc.a(jSONObject, "free_flag", newUser.free_flag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
