package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.BannerList;
import tbclient.DeletedReasonInfo;
import tbclient.FrsPage.AcrossForumIcon;
import tbclient.FrsPage.Adkiller;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.Badges;
import tbclient.FrsPage.Banner;
import tbclient.FrsPage.Calendar;
import tbclient.FrsPage.Classify;
import tbclient.FrsPage.ForumButton;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.Manager;
import tbclient.FrsPage.MemberShowIcon;
import tbclient.FrsPage.PostPrefix;
import tbclient.FrsPage.PostTopic;
import tbclient.FrsPage.RealTime;
import tbclient.FrsPage.RecomUserInfo;
import tbclient.FrsPage.RecommendForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.TagInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsPage.TopCode;
import tbclient.FrsPage.TopNews;
import tbclient.FrsPage.TopNotice;
import tbclient.FrsPage.WorldCup;
import tbclient.FrsPage.Yule;
import tbclient.FrsPage.Zhibo;
import tbclient.GameInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public class ivc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumInfo forumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", forumInfo.id);
            qoc.a(jSONObject, "name", forumInfo.name);
            qoc.a(jSONObject, "first_class", forumInfo.first_class);
            qoc.a(jSONObject, "second_class", forumInfo.second_class);
            qoc.a(jSONObject, "is_exists", forumInfo.is_exists);
            qoc.a(jSONObject, "is_like", forumInfo.is_like);
            qoc.a(jSONObject, IntentConfig.USER_LEVEL, forumInfo.user_level);
            qoc.a(jSONObject, "level_name", forumInfo.level_name);
            qoc.a(jSONObject, "member_num", forumInfo.member_num);
            qoc.a(jSONObject, "thread_num", forumInfo.thread_num);
            qoc.a(jSONObject, "post_num", forumInfo.post_num);
            qoc.a(jSONObject, "has_frs_star", forumInfo.has_frs_star);
            qoc.a(jSONObject, "cur_score", forumInfo.cur_score);
            qoc.a(jSONObject, "levelup_score", forumInfo.levelup_score);
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                qoc.a(jSONObject, "sign_in_info", zwc.b(signInfo));
            }
            Zhibo zhibo = forumInfo.zhibo;
            if (zhibo != null) {
                qoc.a(jSONObject, "zhibo", dyc.b(zhibo));
            }
            if (forumInfo.managers != null) {
                JSONArray jSONArray = new JSONArray();
                for (Manager manager : forumInfo.managers) {
                    jSONArray.put(xvc.b(manager));
                }
                qoc.a(jSONObject, "managers", jSONArray);
            }
            if (forumInfo.forum_sign_calendar != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Calendar calendar : forumInfo.forum_sign_calendar) {
                    jSONArray2.put(ouc.b(calendar));
                }
                qoc.a(jSONObject, "forum_sign_calendar", jSONArray2);
            }
            qoc.a(jSONObject, "is_search_people", forumInfo.is_search_people);
            qoc.a(jSONObject, "tids", forumInfo.tids);
            if (forumInfo.good_classify != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Classify classify : forumInfo.good_classify) {
                    jSONArray3.put(ruc.b(classify));
                }
                qoc.a(jSONObject, "good_classify", jSONArray3);
            }
            qoc.a(jSONObject, "is_readonly", forumInfo.is_readonly);
            qoc.a(jSONObject, "album_open_photo_frs", forumInfo.album_open_photo_frs);
            qoc.a(jSONObject, "avatar", forumInfo.avatar);
            qoc.a(jSONObject, "slogan", forumInfo.slogan);
            qoc.a(jSONObject, "has_postpre", forumInfo.has_postpre);
            ForumButton forumButton = forumInfo.forum_button;
            if (forumButton != null) {
                qoc.a(jSONObject, "forum_button", dvc.b(forumButton));
            }
            TopNotice topNotice = forumInfo.top_notice;
            if (topNotice != null) {
                qoc.a(jSONObject, "top_notice", pxc.b(topNotice));
            }
            qoc.a(jSONObject, "has_paper", forumInfo.has_paper);
            qoc.a(jSONObject, "is_stage_forum", forumInfo.is_stage_forum);
            qoc.a(jSONObject, "meizhi_tag", forumInfo.meizhi_tag);
            Banner banner = forumInfo.banner;
            if (banner != null) {
                qoc.a(jSONObject, "banner", huc.b(banner));
            }
            BannerList bannerList = forumInfo.banner_list;
            if (bannerList != null) {
                qoc.a(jSONObject, "banner_list", fqc.b(bannerList));
            }
            if (forumInfo.badges != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Badges badges : forumInfo.badges) {
                    jSONArray4.put(guc.b(badges));
                }
                qoc.a(jSONObject, "badges", jSONArray4);
            }
            qoc.a(jSONObject, "level_id", forumInfo.level_id);
            qoc.a(jSONObject, "is_forbidden", forumInfo.is_forbidden);
            qoc.a(jSONObject, "favo_type", forumInfo.favo_type);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                qoc.a(jSONObject, "tag_info", jxc.b(tagInfo));
            }
            PostPrefix postPrefix = forumInfo.post_prefix;
            if (postPrefix != null) {
                qoc.a(jSONObject, "post_prefix", kwc.b(postPrefix));
            }
            qoc.a(jSONObject, "superboy", forumInfo.superboy);
            qoc.a(jSONObject, "is_support_local", forumInfo.is_support_local);
            qoc.a(jSONObject, "is_local_effect", forumInfo.is_local_effect);
            if (forumInfo.recommend_forum != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (RecommendForum recommendForum : forumInfo.recommend_forum) {
                    jSONArray5.put(vwc.b(recommendForum));
                }
                qoc.a(jSONObject, "recommend_forum", jSONArray5);
            }
            AnchorPower anchorPower = forumInfo.anchor_power;
            if (anchorPower != null) {
                qoc.a(jSONObject, "anchor_power", fuc.b(anchorPower));
            }
            WorldCup worldCup = forumInfo.worldcupinfo;
            if (worldCup != null) {
                qoc.a(jSONObject, "worldcupinfo", uxc.b(worldCup));
            }
            qoc.a(jSONObject, "has_game", forumInfo.has_game);
            qoc.a(jSONObject, "game_url", forumInfo.game_url);
            RecomUserInfo recomUserInfo = forumInfo.recommend_user_info;
            if (recomUserInfo != null) {
                qoc.a(jSONObject, "recommend_user_info", twc.b(recomUserInfo));
            }
            qoc.a(jSONObject, "can_use_accelerate", forumInfo.can_use_accelerate);
            qoc.a(jSONObject, "accelerate_cotent", forumInfo.accelerate_cotent);
            TopCode topCode = forumInfo.top_code;
            if (topCode != null) {
                qoc.a(jSONObject, "top_code", nxc.b(topCode));
            }
            TopNews topNews = forumInfo.news_info;
            if (topNews != null) {
                qoc.a(jSONObject, "news_info", oxc.b(topNews));
            }
            if (forumInfo.game_card != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GameInfo gameInfo : forumInfo.game_card) {
                    jSONArray6.put(lyc.b(gameInfo));
                }
                qoc.a(jSONObject, "game_card", jSONArray6);
            }
            qoc.a(jSONObject, "game_name", forumInfo.game_name);
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                qoc.a(jSONObject, "forumvip_show_icon", awc.b(memberShowIcon));
            }
            Adkiller adkiller = forumInfo.adkiller_data;
            if (adkiller != null) {
                qoc.a(jSONObject, "adkiller_data", cuc.b(adkiller));
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                qoc.a(jSONObject, "yule", cyc.b(yule));
            }
            RealTime realTime = forumInfo.realtime_data;
            if (realTime != null) {
                qoc.a(jSONObject, "realtime_data", qwc.b(realTime));
            }
            AcrossForumIcon acrossForumIcon = forumInfo.across_forum_show;
            if (acrossForumIcon != null) {
                qoc.a(jSONObject, "across_forum_show", ytc.b(acrossForumIcon));
            }
            PostTopic postTopic = forumInfo.post_topic;
            if (postTopic != null) {
                qoc.a(jSONObject, "post_topic", lwc.b(postTopic));
            }
            AcrossForumIcon acrossForumIcon2 = forumInfo.across_forum_hide;
            if (acrossForumIcon2 != null) {
                qoc.a(jSONObject, "across_forum_hide", ytc.b(acrossForumIcon2));
            }
            qoc.a(jSONObject, "is_live_game_forum", forumInfo.is_live_game_forum);
            qoc.a(jSONObject, "is_live_game", forumInfo.is_live_game);
            qoc.a(jSONObject, "is_new_game_forum", forumInfo.is_new_game_forum);
            qoc.a(jSONObject, "forum_game_label", forumInfo.forum_game_label);
            qoc.a(jSONObject, "warning_msg", forumInfo.warning_msg);
            qoc.a(jSONObject, AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE, forumInfo.special_forum_type);
            qoc.a(jSONObject, "topic_special_icon", forumInfo.topic_special_icon);
            qoc.a(jSONObject, "topic_special_icon_right", forumInfo.topic_special_icon_right);
            qoc.a(jSONObject, "is_brand_forum", forumInfo.is_brand_forum);
            qoc.a(jSONObject, "is_show_all_top_thread", forumInfo.is_show_all_top_thread);
            ThemeColorInfo themeColorInfo = forumInfo.theme_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "theme_color", q4d.b(themeColorInfo));
            }
            qoc.a(jSONObject, "is_top_img", forumInfo.is_top_img);
            qoc.a(jSONObject, "is_private_forum", forumInfo.is_private_forum);
            qoc.a(jSONObject, "is_show_bawutask", forumInfo.is_show_bawutask);
            qoc.a(jSONObject, "f_share_img", forumInfo.f_share_img);
            qoc.a(jSONObject, "forum_share_link", forumInfo.forum_share_link);
            qoc.a(jSONObject, "risk_tip_pop", forumInfo.risk_tip_pop);
            qoc.a(jSONObject, "risk_tip_notice", forumInfo.risk_tip_notice);
            qoc.a(jSONObject, "risk_tip_pop_title", forumInfo.risk_tip_pop_title);
            if (forumInfo.tip_list != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TipInfo tipInfo : forumInfo.tip_list) {
                    jSONArray7.put(mxc.b(tipInfo));
                }
                qoc.a(jSONObject, "tip_list", jSONArray7);
            }
            qoc.a(jSONObject, "is_show_forumrule", forumInfo.is_show_forumrule);
            DeletedReasonInfo deletedReasonInfo = forumInfo.deleted_reason_info;
            if (deletedReasonInfo != null) {
                qoc.a(jSONObject, "deleted_reason_info", orc.b(deletedReasonInfo));
            }
            qoc.a(jSONObject, "is_frs_mask", forumInfo.is_frs_mask);
            qoc.a(jSONObject, "msg_bubble_guide_frequency", forumInfo.msg_bubble_guide_frequency);
            qoc.a(jSONObject, "be_top_limit_time", forumInfo.be_top_limit_time);
            qoc.a(jSONObject, "msg_bubble_guide_frequency_unread", forumInfo.msg_bubble_guide_frequency_unread);
            qoc.a(jSONObject, "msg_bubble_guide_frequency_special", forumInfo.msg_bubble_guide_frequency_special);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
