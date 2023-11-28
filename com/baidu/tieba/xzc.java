package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AdMixFloor;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.AnchorInfo;
import tbclient.Anti;
import tbclient.BannerUserStory;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.Esport;
import tbclient.ForumArIno;
import tbclient.ForumPresentInfo;
import tbclient.ForumRuleStatus;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.ActivityHead;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.AiChatroomGuide;
import tbclient.FrsPage.AlaLiveInsert;
import tbclient.FrsPage.BannerThreadInfo;
import tbclient.FrsPage.Bottle;
import tbclient.FrsPage.BountyCard;
import tbclient.FrsPage.BrandForumInfo;
import tbclient.FrsPage.BusinessPromot;
import tbclient.FrsPage.CarrierEnter;
import tbclient.FrsPage.ClientPlatform;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumBookInfo;
import tbclient.FrsPage.ForumGroup;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.ForumHeadlineImgInfo;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.FrsPage.GconAccount;
import tbclient.FrsPage.Group;
import tbclient.FrsPage.HeadSdk;
import tbclient.FrsPage.HeaderCard;
import tbclient.FrsPage.Info;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.FrsPage.LiveModuleList;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.NtSpreadInfo;
import tbclient.FrsPage.PageData;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.FrsPage.PushThreadInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.RecommendBook;
import tbclient.FrsPage.RecreationRankInfo;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarInfo;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.ThreadIdListInfo;
import tbclient.FrsPage.TopLiveData;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsPageUserExtend;
import tbclient.FrsTabInfo;
import tbclient.FrsVideo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.NaGuide;
import tbclient.Novel;
import tbclient.Page;
import tbclient.PopInfo;
import tbclient.PrivatePopInfo;
import tbclient.RecommendInfo;
import tbclient.RedpacketRain;
import tbclient.SdkTopicThread;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.SmartApp;
import tbclient.StarVoice;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.VitalityInfo;
import tbclient.WindowToast;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes9.dex */
public class xzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dataRes)) == null) {
            JSONObject jSONObject = new JSONObject();
            User user = dataRes.user;
            if (user != null) {
                ltc.a(jSONObject, "user", qad.b(user));
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null) {
                ltc.a(jSONObject, "forum", i0d.b(forumInfo));
            }
            StarInfo starInfo = dataRes.frs_star;
            if (starInfo != null) {
                ltc.a(jSONObject, "frs_star", f2d.b(starInfo));
            }
            Page page = dataRes.page;
            if (page != null) {
                ltc.a(jSONObject, "page", w5d.b(page));
            }
            Anti anti = dataRes.anti;
            if (anti != null) {
                ltc.a(jSONObject, SubPbActivityConfig.KEY_ANTI, puc.b(anti));
            }
            Group group = dataRes.group;
            if (group != null) {
                ltc.a(jSONObject, "group", o0d.b(group));
            }
            if (dataRes.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    jSONArray.put(y9d.b(threadInfo));
                }
                ltc.a(jSONObject, "thread_list", jSONArray);
            }
            if (dataRes.thread_id_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l : dataRes.thread_id_list) {
                    jSONArray2.put(l.longValue());
                }
                ltc.a(jSONObject, "thread_id_list", jSONArray2);
            }
            ltc.a(jSONObject, "is_new_url", dataRes.is_new_url);
            ltc.a(jSONObject, "fortune_bag", dataRes.fortune_bag);
            ltc.a(jSONObject, "time", dataRes.time);
            ltc.a(jSONObject, "ctime", dataRes.ctime);
            ltc.a(jSONObject, "logid", dataRes.logid);
            ltc.a(jSONObject, "server_time", dataRes.server_time);
            Info info = dataRes.info;
            if (info != null) {
                ltc.a(jSONObject, "info", v0d.b(info));
            }
            if (dataRes.forum_livegroup_list != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AnchorInfo anchorInfo : dataRes.forum_livegroup_list) {
                    jSONArray3.put(nuc.b(anchorInfo));
                }
                ltc.a(jSONObject, "forum_livegroup_list", jSONArray3);
            }
            if (dataRes.user_list != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (User user2 : dataRes.user_list) {
                    jSONArray4.put(qad.b(user2));
                }
                ltc.a(jSONObject, "user_list", jSONArray4);
            }
            GconAccount gconAccount = dataRes.gcon_account;
            if (gconAccount != null) {
                ltc.a(jSONObject, "gcon_account", m0d.b(gconAccount));
            }
            ltc.a(jSONObject, "fortune_desc", dataRes.fortune_desc);
            if (dataRes.star_enter != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (StarEnter starEnter : dataRes.star_enter) {
                    jSONArray5.put(e2d.b(starEnter));
                }
                ltc.a(jSONObject, "star_enter", jSONArray5);
            }
            if (dataRes.color_egg != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    jSONArray6.put(tzc.b(colorEgg));
                }
                ltc.a(jSONObject, "color_egg", jSONArray6);
            }
            if (dataRes.frs_tab_info != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (FrsTabInfo frsTabInfo : dataRes.frs_tab_info) {
                    jSONArray7.put(i3d.b(frsTabInfo));
                }
                ltc.a(jSONObject, "frs_tab_info", jSONArray7);
            }
            ActivityHead activityHead = dataRes.activityhead;
            if (activityHead != null) {
                ltc.a(jSONObject, "activityhead", yyc.c(activityHead));
            }
            if (dataRes.twzhibo_info != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (ZhiBoInfoTW zhiBoInfoTW : dataRes.twzhibo_info) {
                    jSONArray8.put(vbd.b(zhiBoInfoTW));
                }
                ltc.a(jSONObject, "twzhibo_info", jSONArray8);
            }
            Novel novel = dataRes.novel;
            if (novel != null) {
                ltc.a(jSONObject, "novel", q5d.b(novel));
            }
            ZhiBoInfoTW zhiBoInfoTW2 = dataRes.hot_twzhibo_info;
            if (zhiBoInfoTW2 != null) {
                ltc.a(jSONObject, "hot_twzhibo_info", vbd.b(zhiBoInfoTW2));
            }
            ltc.a(jSONObject, "twzhibo_pos", dataRes.twzhibo_pos);
            if (dataRes.category_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (CategoryInfo categoryInfo : dataRes.category_list) {
                    jSONArray9.put(tvc.b(categoryInfo));
                }
                ltc.a(jSONObject, "category_list", jSONArray9);
            }
            PushThreadInfo pushThreadInfo = dataRes.push_thread_info;
            if (pushThreadInfo != null) {
                ltc.a(jSONObject, "push_thread_info", p1d.b(pushThreadInfo));
            }
            ThreadInfo threadInfo2 = dataRes.store_card;
            if (threadInfo2 != null) {
                ltc.a(jSONObject, "store_card", y9d.b(threadInfo2));
            }
            SdkTopicThread sdkTopicThread = dataRes.sdk_topic_thread;
            if (sdkTopicThread != null) {
                ltc.a(jSONObject, "sdk_topic_thread", z7d.b(sdkTopicThread));
            }
            ltc.a(jSONObject, "bawu_enter_url", dataRes.bawu_enter_url);
            ClientPlatform clientPlatform = dataRes.client_platform;
            if (clientPlatform != null) {
                ltc.a(jSONObject, "client_platform", szc.b(clientPlatform));
            }
            HeadSdk headSdk = dataRes.head_sdk;
            if (headSdk != null) {
                ltc.a(jSONObject, "head_sdk", s0d.b(headSdk));
            }
            if (dataRes.card_shipin_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ThreadInfo threadInfo3 : dataRes.card_shipin_info) {
                    jSONArray10.put(y9d.b(threadInfo3));
                }
                ltc.a(jSONObject, "card_shipin_info", jSONArray10);
            }
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo != null) {
                ltc.a(jSONObject, "nav_tab_info", d1d.b(navTabInfo));
            }
            ltc.a(jSONObject, "frs_tab_default", dataRes.frs_tab_default);
            ltc.a(jSONObject, "sort_type", dataRes.sort_type);
            RecommendInfo recommendInfo = dataRes.school_recom_info;
            if (recommendInfo != null) {
                ltc.a(jSONObject, "school_recom_info", o7d.b(recommendInfo));
            }
            ltc.a(jSONObject, "school_recom_pos", dataRes.school_recom_pos);
            VitalityInfo vitalityInfo = dataRes.vitality_info;
            if (vitalityInfo != null) {
                ltc.a(jSONObject, "vitality_info", ibd.b(vitalityInfo));
            }
            CarrierEnter carrierEnter = dataRes.carrier_enter;
            if (carrierEnter != null) {
                ltc.a(jSONObject, "carrier_enter", qzc.b(carrierEnter));
            }
            if (dataRes.banner_thread_list != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BannerThreadInfo bannerThreadInfo : dataRes.banner_thread_list) {
                    jSONArray11.put(hzc.b(bannerThreadInfo));
                }
                ltc.a(jSONObject, "banner_thread_list", jSONArray11);
            }
            RecommendBook recommendBook = dataRes.recommend_book;
            if (recommendBook != null) {
                ltc.a(jSONObject, "recommend_book", v1d.b(recommendBook));
            }
            ltc.a(jSONObject, "smart_frs_type", dataRes.smart_frs_type);
            ltc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, dataRes.need_log);
            ltc.a(jSONObject, "is_auto_play_forumheadvideo", dataRes.is_auto_play_forumheadvideo);
            ForumBookInfo forumBookInfo = dataRes.book_info;
            if (forumBookInfo != null) {
                ltc.a(jSONObject, "book_info", c0d.b(forumBookInfo));
            }
            ForumPresentInfo forumPresentInfo = dataRes.forum_present_info;
            if (forumPresentInfo != null) {
                ltc.a(jSONObject, "forum_present_info", lyc.b(forumPresentInfo));
            }
            ForumHeadlineImgInfo forumHeadlineImgInfo = dataRes.forum_headline_img_info;
            if (forumHeadlineImgInfo != null) {
                ltc.a(jSONObject, "forum_headline_img_info", h0d.b(forumHeadlineImgInfo));
            }
            NtSpreadInfo ntSpreadInfo = dataRes.ntspread;
            if (ntSpreadInfo != null) {
                ltc.a(jSONObject, "ntspread", h1d.b(ntSpreadInfo));
            }
            if (dataRes.card_shipin_pos != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (Integer num : dataRes.card_shipin_pos) {
                    jSONArray12.put(num.intValue());
                }
                ltc.a(jSONObject, "card_shipin_pos", jSONArray12);
            }
            if (dataRes.card_shipin_new != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (ThreadInfo threadInfo4 : dataRes.card_shipin_new) {
                    jSONArray13.put(y9d.b(threadInfo4));
                }
                ltc.a(jSONObject, "card_shipin_new", jSONArray13);
            }
            ltc.a(jSONObject, "asp_shown_info", dataRes.asp_shown_info);
            ltc.a(jSONObject, "ala_live_count", dataRes.ala_live_count);
            Bottle bottle = dataRes.bottle;
            if (bottle != null) {
                ltc.a(jSONObject, "bottle", izc.b(bottle));
            }
            PopInfo popInfo = dataRes.enter_pop_info;
            if (popInfo != null) {
                ltc.a(jSONObject, "enter_pop_info", p6d.b(popInfo));
            }
            ltc.a(jSONObject, "partial_visible_toast", dataRes.partial_visible_toast);
            Esport esport = dataRes.esport;
            if (esport != null) {
                ltc.a(jSONObject, "esport", uwc.b(esport));
            }
            if (dataRes.thread_id_list_info != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (ThreadIdListInfo threadIdListInfo : dataRes.thread_id_list_info) {
                    jSONArray14.put(l2d.b(threadIdListInfo));
                }
                ltc.a(jSONObject, "thread_id_list_info", jSONArray14);
            }
            AgreeBanner agreeBanner = dataRes.agree_banner;
            if (agreeBanner != null) {
                ltc.a(jSONObject, "agree_banner", bzc.b(agreeBanner));
            }
            NaGuide naGuide = dataRes.na_guide;
            if (naGuide != null) {
                ltc.a(jSONObject, "na_guide", j5d.b(naGuide));
            }
            if (dataRes.frs_game_tab_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (FrsTabInfo frsTabInfo2 : dataRes.frs_game_tab_info) {
                    jSONArray15.put(i3d.b(frsTabInfo2));
                }
                ltc.a(jSONObject, "frs_game_tab_info", jSONArray15);
            }
            AlaLiveNotify alaLiveNotify = dataRes.live_frs_notify;
            if (alaLiveNotify != null) {
                ltc.a(jSONObject, "live_frs_notify", juc.b(alaLiveNotify));
            }
            BannerUserStory bannerUserStory = dataRes.banner_user_story;
            if (bannerUserStory != null) {
                ltc.a(jSONObject, "banner_user_story", dvc.b(bannerUserStory));
            }
            FrsPageUserExtend frsPageUserExtend = dataRes.user_extend;
            if (frsPageUserExtend != null) {
                ltc.a(jSONObject, "user_extend", h3d.b(frsPageUserExtend));
            }
            ForumHeadIcon forumHeadIcon = dataRes.forum_head_icon;
            if (forumHeadIcon != null) {
                ltc.a(jSONObject, "forum_head_icon", g0d.b(forumHeadIcon));
            }
            FrsVideo frsVideo = dataRes.video;
            if (frsVideo != null) {
                ltc.a(jSONObject, "video", l3d.b(frsVideo));
            }
            ltc.a(jSONObject, "game_default_tab_id", dataRes.game_default_tab_id);
            if (dataRes.ala_insert_thread != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (ThreadInfo threadInfo5 : dataRes.ala_insert_thread) {
                    jSONArray16.put(y9d.b(threadInfo5));
                }
                ltc.a(jSONObject, "ala_insert_thread", jSONArray16);
            }
            AlaLiveInsert alaLiveInsert = dataRes.ala_live_insert;
            if (alaLiveInsert != null) {
                ltc.a(jSONObject, "ala_live_insert", dzc.b(alaLiveInsert));
            }
            ltc.a(jSONObject, "ala_insert_floor", dataRes.ala_insert_floor);
            ForumArIno forumArIno = dataRes.forum_ar_info;
            if (forumArIno != null) {
                ltc.a(jSONObject, "forum_ar_info", jyc.b(forumArIno));
            }
            if (dataRes.ala_stage_list != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (ThreadInfo threadInfo6 : dataRes.ala_stage_list) {
                    jSONArray17.put(y9d.b(threadInfo6));
                }
                ltc.a(jSONObject, "ala_stage_list", jSONArray17);
            }
            StarRank starRank = dataRes.star_rank_info;
            if (starRank != null) {
                ltc.a(jSONObject, "star_rank_info", g2d.b(starRank));
            }
            ltc.a(jSONObject, "trends_redpoint", dataRes.trends_redpoint);
            if (dataRes.window_toast != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (WindowToast windowToast : dataRes.window_toast) {
                    jSONArray18.put(obd.b(windowToast));
                }
                ltc.a(jSONObject, "window_toast", jSONArray18);
            }
            RecomPostTopic recomPostTopic = dataRes.recom_post_topic;
            if (recomPostTopic != null) {
                ltc.a(jSONObject, "recom_post_topic", t1d.b(recomPostTopic));
            }
            ActivityConfig activityConfig = dataRes.activity_config;
            if (activityConfig != null) {
                ltc.a(jSONObject, "activity_config", xyc.b(activityConfig));
            }
            StarVoice starVoice = dataRes.star_voice;
            if (starVoice != null) {
                ltc.a(jSONObject, "star_voice", v8d.b(starVoice));
            }
            WorldcupSkin worldcupSkin = dataRes.worldcup_skin;
            if (worldcupSkin != null) {
                ltc.a(jSONObject, "worldcup_skin", d3d.b(worldcupSkin));
            }
            RedpacketRain redpacketRain = dataRes.redpacketrain;
            if (redpacketRain != null) {
                ltc.a(jSONObject, "redpacketrain", q7d.b(redpacketRain));
            }
            BrandForumInfo brandForumInfo = dataRes.brand_forum_info;
            if (brandForumInfo != null) {
                ltc.a(jSONObject, "brand_forum_info", lzc.b(brandForumInfo));
            }
            if (dataRes.bottom_menu != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (BottomMenu bottomMenu : dataRes.bottom_menu) {
                    jSONArray19.put(mvc.b(bottomMenu));
                }
                ltc.a(jSONObject, "bottom_menu", jSONArray19);
            }
            ltc.a(jSONObject, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_AUTO_PLAY, dataRes.video_auto_play);
            if (dataRes.smart_app_avatar != null) {
                JSONArray jSONArray20 = new JSONArray();
                for (String str : dataRes.smart_app_avatar) {
                    jSONArray20.put(str);
                }
                ltc.a(jSONObject, "smart_app_avatar", jSONArray20);
            }
            SmartApp smartApp = dataRes.smart_app;
            if (smartApp != null) {
                ltc.a(jSONObject, "smart_app", n8d.b(smartApp));
            }
            NebulaHotThreads nebulaHotThreads = dataRes.nebula_hot_threads;
            if (nebulaHotThreads != null) {
                ltc.a(jSONObject, "nebula_hot_threads", f1d.b(nebulaHotThreads));
            }
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                ltc.a(jSONObject, "private_forum_info", o1d.b(privateForumTotalInfo));
            }
            ForumActiveInfo forumActiveInfo = dataRes.private_forum_active_info;
            if (forumActiveInfo != null) {
                ltc.a(jSONObject, "private_forum_active_info", b0d.b(forumActiveInfo));
            }
            BusinessPromot businessPromot = dataRes.business_promot;
            if (businessPromot != null) {
                ltc.a(jSONObject, "business_promot", nzc.c(businessPromot));
            }
            if (dataRes.service_area != null) {
                JSONArray jSONArray21 = new JSONArray();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    jSONArray21.put(b8d.b(serviceArea));
                }
                ltc.a(jSONObject, "service_area", jSONArray21);
            }
            WindowToast windowToast2 = dataRes.bazhu_exam_fail;
            if (windowToast2 != null) {
                ltc.a(jSONObject, "bazhu_exam_fail", obd.b(windowToast2));
            }
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            if (hotUserRankEntry != null) {
                ltc.a(jSONObject, "hot_user_entry", y3d.b(hotUserRankEntry));
            }
            ItemInfo itemInfo = dataRes.item_info;
            if (itemInfo != null) {
                ltc.a(jSONObject, WriteActivityConfig.ITEM_INFO, d4d.b(itemInfo));
            }
            ltc.a(jSONObject, "is_get_horse_race_lamp", dataRes.is_get_horse_race_lamp);
            ForumRuleStatus forumRuleStatus = dataRes.forum_rule;
            if (forumRuleStatus != null) {
                ltc.a(jSONObject, "forum_rule", myc.b(forumRuleStatus));
            }
            SignActivityInfo signActivityInfo = dataRes.sign_activity_info;
            if (signActivityInfo != null) {
                ltc.a(jSONObject, "sign_activity_info", g8d.b(signActivityInfo));
            }
            AddBawuPopInfo addBawuPopInfo = dataRes.add_bawu_pop;
            if (addBawuPopInfo != null) {
                ltc.a(jSONObject, "add_bawu_pop", ztc.b(addBawuPopInfo));
            }
            ltc.a(jSONObject, "show_adsense", dataRes.show_adsense);
            PopInfo popInfo2 = dataRes.frsmask_pop_info;
            if (popInfo2 != null) {
                ltc.a(jSONObject, "frsmask_pop_info", p6d.b(popInfo2));
            }
            if (dataRes.voice_room_list != null) {
                JSONArray jSONArray22 = new JSONArray();
                for (ThreadInfo threadInfo7 : dataRes.voice_room_list) {
                    jSONArray22.put(y9d.b(threadInfo7));
                }
                ltc.a(jSONObject, "voice_room_list", jSONArray22);
            }
            ltc.a(jSONObject, "voice_room_config", dataRes.voice_room_config);
            ltc.a(jSONObject, "ad_show_select", dataRes.ad_show_select);
            if (dataRes.ad_mix_list != null) {
                JSONArray jSONArray23 = new JSONArray();
                for (AdMixFloor adMixFloor : dataRes.ad_mix_list) {
                    jSONArray23.put(ytc.b(adMixFloor));
                }
                ltc.a(jSONObject, "ad_mix_list", jSONArray23);
            }
            ltc.a(jSONObject, "ad_sample_map_key", dataRes.ad_sample_map_key);
            PrivatePopInfo privatePopInfo = dataRes.bawutask_pop;
            if (privatePopInfo != null) {
                ltc.a(jSONObject, "bawutask_pop", x6d.b(privatePopInfo));
            }
            if (dataRes.live_fuse_forum != null) {
                JSONArray jSONArray24 = new JSONArray();
                for (LiveFuseForumData liveFuseForumData : dataRes.live_fuse_forum) {
                    jSONArray24.put(w0d.b(liveFuseForumData));
                }
                ltc.a(jSONObject, "live_fuse_forum", jSONArray24);
            }
            ltc.a(jSONObject, "bawu_unread_notice_num", dataRes.bawu_unread_notice_num);
            RecreationRankInfo recreationRankInfo = dataRes.recreation_rank_info;
            if (recreationRankInfo != null) {
                ltc.a(jSONObject, "recreation_rank_info", x1d.b(recreationRankInfo));
            }
            ltc.a(jSONObject, "is_member_broadcast_forum", dataRes.is_member_broadcast_forum);
            ForumGroup forumGroup = dataRes.forum_group;
            if (forumGroup != null) {
                ltc.a(jSONObject, "forum_group", f0d.b(forumGroup));
            }
            FrsBannerHeader frsBannerHeader = dataRes.frs_banner_header;
            if (frsBannerHeader != null) {
                ltc.a(jSONObject, "frs_banner_header", j0d.b(frsBannerHeader));
            }
            HeaderCard headerCard = dataRes.header_card;
            if (headerCard != null) {
                ltc.a(jSONObject, "header_card", t0d.b(headerCard));
            }
            FrsSpriteBubble frsSpriteBubble = dataRes.sprite_bubble_guide;
            if (frsSpriteBubble != null) {
                ltc.a(jSONObject, "sprite_bubble_guide", l0d.b(frsSpriteBubble));
            }
            ltc.a(jSONObject, "is_need_live_ununiq", dataRes.is_need_live_ununiq);
            BountyCard bountyCard = dataRes.bounty_card;
            if (bountyCard != null) {
                ltc.a(jSONObject, "bounty_card", jzc.b(bountyCard));
            }
            PageData pageData = dataRes.page_data;
            if (pageData != null) {
                ltc.a(jSONObject, "page_data", i1d.b(pageData));
            }
            if (dataRes.frs_main_tab_list != null) {
                JSONArray jSONArray25 = new JSONArray();
                for (FrsTabInfo frsTabInfo3 : dataRes.frs_main_tab_list) {
                    jSONArray25.put(i3d.b(frsTabInfo3));
                }
                ltc.a(jSONObject, "frs_main_tab_list", jSONArray25);
            }
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null) {
                ltc.a(jSONObject, "frs_bottom", k0d.b(frsBottom));
            }
            ltc.a(jSONObject, "frs_common_info", dataRes.frs_common_info);
            AiChatroomGuide aiChatroomGuide = dataRes.ai_chatroom_guide;
            if (aiChatroomGuide != null) {
                ltc.a(jSONObject, "ai_chatroom_guide", czc.b(aiChatroomGuide));
            }
            TopLiveData topLiveData = dataRes.top_live_data;
            if (topLiveData != null) {
                ltc.a(jSONObject, "top_live_data", p2d.b(topLiveData));
            }
            if (dataRes.live_module_list != null) {
                JSONArray jSONArray26 = new JSONArray();
                for (LiveModuleList liveModuleList : dataRes.live_module_list) {
                    jSONArray26.put(x0d.b(liveModuleList));
                }
                ltc.a(jSONObject, "live_module_list", jSONArray26);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
