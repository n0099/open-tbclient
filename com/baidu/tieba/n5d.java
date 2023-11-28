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
public class n5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewUser newUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", newUser.user_id);
            ltc.a(jSONObject, "user_name", newUser.user_name);
            ltc.a(jSONObject, IntentConfig.USER_SEX, newUser.user_sex);
            ltc.a(jSONObject, "user_status", newUser.user_status);
            ltc.a(jSONObject, "meizhi_level", newUser.meizhi_level);
            ltc.a(jSONObject, "superboy", newUser.superboy);
            ltc.a(jSONObject, "card", newUser.card);
            ParrProps parrProps = newUser.parr_props;
            if (parrProps != null) {
                ltc.a(jSONObject, "parr_props", x5d.b(parrProps));
            }
            MparrProps mparrProps = newUser.m_parr_props;
            if (mparrProps != null) {
                ltc.a(jSONObject, "m_parr_props", f5d.b(mparrProps));
            }
            WapRn wapRn = newUser.wap_rn;
            if (wapRn != null) {
                ltc.a(jSONObject, "wap_rn", mbd.b(wapRn));
            }
            ltc.a(jSONObject, "is_tenyear", newUser.is_tenyear);
            ltc.a(jSONObject, "is_group_owner", newUser.is_group_owner);
            ParrScores parrScores = newUser.parr_scores;
            if (parrScores != null) {
                ltc.a(jSONObject, "parr_scores", y5d.b(parrScores));
            }
            ltc.a(jSONObject, "user_type", newUser.user_type);
            ltc.a(jSONObject, "use_sig", newUser.use_sig);
            ltc.a(jSONObject, "paper", newUser.paper);
            ltc.a(jSONObject, "bg_id", newUser.bg_id);
            ltc.a(jSONObject, "is_shengyou", newUser.is_shengyou);
            ltc.a(jSONObject, "is_hardworking", newUser.is_hardworking);
            ltc.a(jSONObject, "billboard", newUser.billboard);
            ltc.a(jSONObject, "portrait_time", newUser.portrait_time);
            if (newUser.appraise != null) {
                JSONArray jSONArray = new JSONArray();
                for (Props props : newUser.appraise) {
                    jSONArray.put(y6d.b(props));
                }
                ltc.a(jSONObject, "appraise", jSONArray);
            }
            ltc.a(jSONObject, "tbscore_repeate_finish_time", newUser.tbscore_repeate_finish_time);
            ltc.a(jSONObject, MissonDetailsActivityConfig.IS_MEMBER, newUser.is_member);
            ltc.a(jSONObject, "is_passer", newUser.is_passer);
            ltc.a(jSONObject, "is_qun_spring", newUser.is_qun_spring);
            if (newUser.notice_mask != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (NoticeMask noticeMask : newUser.notice_mask) {
                    jSONArray2.put(p5d.b(noticeMask));
                }
                ltc.a(jSONObject, "notice_mask", jSONArray2);
            }
            if (newUser.rpgoldicon != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Rpgoldicon rpgoldicon : newUser.rpgoldicon) {
                    jSONArray3.put(x7d.b(rpgoldicon));
                }
                ltc.a(jSONObject, "rpgoldicon", jSONArray3);
            }
            ltc.a(jSONObject, "is_doudizhu", newUser.is_doudizhu);
            ltc.a(jSONObject, "cdn_error", newUser.cdn_error);
            if (newUser.tbmall_month_icon != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (TbmallMonthIcon tbmallMonthIcon : newUser.tbmall_month_icon) {
                    jSONArray4.put(n9d.b(tbmallMonthIcon));
                }
                ltc.a(jSONObject, "tbmall_month_icon", jSONArray4);
            }
            ltc.a(jSONObject, "is_coreuser", newUser.is_coreuser);
            GameAttr gameAttr = newUser.game_attr;
            if (gameAttr != null) {
                ltc.a(jSONObject, "game_attr", n3d.b(gameAttr));
            }
            ltc.a(jSONObject, "is_interestman", newUser.is_interestman);
            Global global = newUser.global;
            if (global != null) {
                ltc.a(jSONObject, "global", q3d.b(global));
            }
            ltc.a(jSONObject, "free_flag", newUser.free_flag);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
