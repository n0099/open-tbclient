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
/* loaded from: classes8.dex */
public class wzc extends ktc {
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
                ktc.a(jSONObject, "user", pad.b(user));
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null) {
                ktc.a(jSONObject, "forum", h0d.b(forumInfo));
            }
            StarInfo starInfo = dataRes.frs_star;
            if (starInfo != null) {
                ktc.a(jSONObject, "frs_star", e2d.b(starInfo));
            }
            Page page = dataRes.page;
            if (page != null) {
                ktc.a(jSONObject, "page", v5d.b(page));
            }
            Anti anti = dataRes.anti;
            if (anti != null) {
                ktc.a(jSONObject, SubPbActivityConfig.KEY_ANTI, ouc.b(anti));
            }
            Group group = dataRes.group;
            if (group != null) {
                ktc.a(jSONObject, "group", n0d.b(group));
            }
            if (dataRes.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    jSONArray.put(x9d.b(threadInfo));
                }
                ktc.a(jSONObject, "thread_list", jSONArray);
            }
            if (dataRes.thread_id_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l : dataRes.thread_id_list) {
                    jSONArray2.put(l.longValue());
                }
                ktc.a(jSONObject, "thread_id_list", jSONArray2);
            }
            ktc.a(jSONObject, "is_new_url", dataRes.is_new_url);
            ktc.a(jSONObject, "fortune_bag", dataRes.fortune_bag);
            ktc.a(jSONObject, "time", dataRes.time);
            ktc.a(jSONObject, "ctime", dataRes.ctime);
            ktc.a(jSONObject, "logid", dataRes.logid);
            ktc.a(jSONObject, "server_time", dataRes.server_time);
            Info info = dataRes.info;
            if (info != null) {
                ktc.a(jSONObject, "info", u0d.b(info));
            }
            if (dataRes.forum_livegroup_list != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AnchorInfo anchorInfo : dataRes.forum_livegroup_list) {
                    jSONArray3.put(muc.b(anchorInfo));
                }
                ktc.a(jSONObject, "forum_livegroup_list", jSONArray3);
            }
            if (dataRes.user_list != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (User user2 : dataRes.user_list) {
                    jSONArray4.put(pad.b(user2));
                }
                ktc.a(jSONObject, "user_list", jSONArray4);
            }
            GconAccount gconAccount = dataRes.gcon_account;
            if (gconAccount != null) {
                ktc.a(jSONObject, "gcon_account", l0d.b(gconAccount));
            }
            ktc.a(jSONObject, "fortune_desc", dataRes.fortune_desc);
            if (dataRes.star_enter != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (StarEnter starEnter : dataRes.star_enter) {
                    jSONArray5.put(d2d.b(starEnter));
                }
                ktc.a(jSONObject, "star_enter", jSONArray5);
            }
            if (dataRes.color_egg != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    jSONArray6.put(szc.b(colorEgg));
                }
                ktc.a(jSONObject, "color_egg", jSONArray6);
            }
            if (dataRes.frs_tab_info != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (FrsTabInfo frsTabInfo : dataRes.frs_tab_info) {
                    jSONArray7.put(h3d.b(frsTabInfo));
                }
                ktc.a(jSONObject, "frs_tab_info", jSONArray7);
            }
            ActivityHead activityHead = dataRes.activityhead;
            if (activityHead != null) {
                ktc.a(jSONObject, "activityhead", xyc.c(activityHead));
            }
            if (dataRes.twzhibo_info != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (ZhiBoInfoTW zhiBoInfoTW : dataRes.twzhibo_info) {
                    jSONArray8.put(ubd.b(zhiBoInfoTW));
                }
                ktc.a(jSONObject, "twzhibo_info", jSONArray8);
            }
            Novel novel = dataRes.novel;
            if (novel != null) {
                ktc.a(jSONObject, "novel", p5d.b(novel));
            }
            ZhiBoInfoTW zhiBoInfoTW2 = dataRes.hot_twzhibo_info;
            if (zhiBoInfoTW2 != null) {
                ktc.a(jSONObject, "hot_twzhibo_info", ubd.b(zhiBoInfoTW2));
            }
            ktc.a(jSONObject, "twzhibo_pos", dataRes.twzhibo_pos);
            if (dataRes.category_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (CategoryInfo categoryInfo : dataRes.category_list) {
                    jSONArray9.put(svc.b(categoryInfo));
                }
                ktc.a(jSONObject, "category_list", jSONArray9);
            }
            PushThreadInfo pushThreadInfo = dataRes.push_thread_info;
            if (pushThreadInfo != null) {
                ktc.a(jSONObject, "push_thread_info", o1d.b(pushThreadInfo));
            }
            ThreadInfo threadInfo2 = dataRes.store_card;
            if (threadInfo2 != null) {
                ktc.a(jSONObject, "store_card", x9d.b(threadInfo2));
            }
            SdkTopicThread sdkTopicThread = dataRes.sdk_topic_thread;
            if (sdkTopicThread != null) {
                ktc.a(jSONObject, "sdk_topic_thread", y7d.b(sdkTopicThread));
            }
            ktc.a(jSONObject, "bawu_enter_url", dataRes.bawu_enter_url);
            ClientPlatform clientPlatform = dataRes.client_platform;
            if (clientPlatform != null) {
                ktc.a(jSONObject, "client_platform", rzc.b(clientPlatform));
            }
            HeadSdk headSdk = dataRes.head_sdk;
            if (headSdk != null) {
                ktc.a(jSONObject, "head_sdk", r0d.b(headSdk));
            }
            if (dataRes.card_shipin_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ThreadInfo threadInfo3 : dataRes.card_shipin_info) {
                    jSONArray10.put(x9d.b(threadInfo3));
                }
                ktc.a(jSONObject, "card_shipin_info", jSONArray10);
            }
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo != null) {
                ktc.a(jSONObject, "nav_tab_info", c1d.b(navTabInfo));
            }
            ktc.a(jSONObject, "frs_tab_default", dataRes.frs_tab_default);
            ktc.a(jSONObject, "sort_type", dataRes.sort_type);
            RecommendInfo recommendInfo = dataRes.school_recom_info;
            if (recommendInfo != null) {
                ktc.a(jSONObject, "school_recom_info", n7d.b(recommendInfo));
            }
            ktc.a(jSONObject, "school_recom_pos", dataRes.school_recom_pos);
            VitalityInfo vitalityInfo = dataRes.vitality_info;
            if (vitalityInfo != null) {
                ktc.a(jSONObject, "vitality_info", hbd.b(vitalityInfo));
            }
            CarrierEnter carrierEnter = dataRes.carrier_enter;
            if (carrierEnter != null) {
                ktc.a(jSONObject, "carrier_enter", pzc.b(carrierEnter));
            }
            if (dataRes.banner_thread_list != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BannerThreadInfo bannerThreadInfo : dataRes.banner_thread_list) {
                    jSONArray11.put(gzc.b(bannerThreadInfo));
                }
                ktc.a(jSONObject, "banner_thread_list", jSONArray11);
            }
            RecommendBook recommendBook = dataRes.recommend_book;
            if (recommendBook != null) {
                ktc.a(jSONObject, "recommend_book", u1d.b(recommendBook));
            }
            ktc.a(jSONObject, "smart_frs_type", dataRes.smart_frs_type);
            ktc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, dataRes.need_log);
            ktc.a(jSONObject, "is_auto_play_forumheadvideo", dataRes.is_auto_play_forumheadvideo);
            ForumBookInfo forumBookInfo = dataRes.book_info;
            if (forumBookInfo != null) {
                ktc.a(jSONObject, "book_info", b0d.b(forumBookInfo));
            }
            ForumPresentInfo forumPresentInfo = dataRes.forum_present_info;
            if (forumPresentInfo != null) {
                ktc.a(jSONObject, "forum_present_info", kyc.b(forumPresentInfo));
            }
            ForumHeadlineImgInfo forumHeadlineImgInfo = dataRes.forum_headline_img_info;
            if (forumHeadlineImgInfo != null) {
                ktc.a(jSONObject, "forum_headline_img_info", g0d.b(forumHeadlineImgInfo));
            }
            NtSpreadInfo ntSpreadInfo = dataRes.ntspread;
            if (ntSpreadInfo != null) {
                ktc.a(jSONObject, "ntspread", g1d.b(ntSpreadInfo));
            }
            if (dataRes.card_shipin_pos != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (Integer num : dataRes.card_shipin_pos) {
                    jSONArray12.put(num.intValue());
                }
                ktc.a(jSONObject, "card_shipin_pos", jSONArray12);
            }
            if (dataRes.card_shipin_new != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (ThreadInfo threadInfo4 : dataRes.card_shipin_new) {
                    jSONArray13.put(x9d.b(threadInfo4));
                }
                ktc.a(jSONObject, "card_shipin_new", jSONArray13);
            }
            ktc.a(jSONObject, "asp_shown_info", dataRes.asp_shown_info);
            ktc.a(jSONObject, "ala_live_count", dataRes.ala_live_count);
            Bottle bottle = dataRes.bottle;
            if (bottle != null) {
                ktc.a(jSONObject, "bottle", hzc.b(bottle));
            }
            PopInfo popInfo = dataRes.enter_pop_info;
            if (popInfo != null) {
                ktc.a(jSONObject, "enter_pop_info", o6d.b(popInfo));
            }
            ktc.a(jSONObject, "partial_visible_toast", dataRes.partial_visible_toast);
            Esport esport = dataRes.esport;
            if (esport != null) {
                ktc.a(jSONObject, "esport", twc.b(esport));
            }
            if (dataRes.thread_id_list_info != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (ThreadIdListInfo threadIdListInfo : dataRes.thread_id_list_info) {
                    jSONArray14.put(k2d.b(threadIdListInfo));
                }
                ktc.a(jSONObject, "thread_id_list_info", jSONArray14);
            }
            AgreeBanner agreeBanner = dataRes.agree_banner;
            if (agreeBanner != null) {
                ktc.a(jSONObject, "agree_banner", azc.b(agreeBanner));
            }
            NaGuide naGuide = dataRes.na_guide;
            if (naGuide != null) {
                ktc.a(jSONObject, "na_guide", i5d.b(naGuide));
            }
            if (dataRes.frs_game_tab_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (FrsTabInfo frsTabInfo2 : dataRes.frs_game_tab_info) {
                    jSONArray15.put(h3d.b(frsTabInfo2));
                }
                ktc.a(jSONObject, "frs_game_tab_info", jSONArray15);
            }
            AlaLiveNotify alaLiveNotify = dataRes.live_frs_notify;
            if (alaLiveNotify != null) {
                ktc.a(jSONObject, "live_frs_notify", iuc.b(alaLiveNotify));
            }
            BannerUserStory bannerUserStory = dataRes.banner_user_story;
            if (bannerUserStory != null) {
                ktc.a(jSONObject, "banner_user_story", cvc.b(bannerUserStory));
            }
            FrsPageUserExtend frsPageUserExtend = dataRes.user_extend;
            if (frsPageUserExtend != null) {
                ktc.a(jSONObject, "user_extend", g3d.b(frsPageUserExtend));
            }
            ForumHeadIcon forumHeadIcon = dataRes.forum_head_icon;
            if (forumHeadIcon != null) {
                ktc.a(jSONObject, "forum_head_icon", f0d.b(forumHeadIcon));
            }
            FrsVideo frsVideo = dataRes.video;
            if (frsVideo != null) {
                ktc.a(jSONObject, "video", k3d.b(frsVideo));
            }
            ktc.a(jSONObject, "game_default_tab_id", dataRes.game_default_tab_id);
            if (dataRes.ala_insert_thread != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (ThreadInfo threadInfo5 : dataRes.ala_insert_thread) {
                    jSONArray16.put(x9d.b(threadInfo5));
                }
                ktc.a(jSONObject, "ala_insert_thread", jSONArray16);
            }
            AlaLiveInsert alaLiveInsert = dataRes.ala_live_insert;
            if (alaLiveInsert != null) {
                ktc.a(jSONObject, "ala_live_insert", czc.b(alaLiveInsert));
            }
            ktc.a(jSONObject, "ala_insert_floor", dataRes.ala_insert_floor);
            ForumArIno forumArIno = dataRes.forum_ar_info;
            if (forumArIno != null) {
                ktc.a(jSONObject, "forum_ar_info", iyc.b(forumArIno));
            }
            if (dataRes.ala_stage_list != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (ThreadInfo threadInfo6 : dataRes.ala_stage_list) {
                    jSONArray17.put(x9d.b(threadInfo6));
                }
                ktc.a(jSONObject, "ala_stage_list", jSONArray17);
            }
            StarRank starRank = dataRes.star_rank_info;
            if (starRank != null) {
                ktc.a(jSONObject, "star_rank_info", f2d.b(starRank));
            }
            ktc.a(jSONObject, "trends_redpoint", dataRes.trends_redpoint);
            if (dataRes.window_toast != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (WindowToast windowToast : dataRes.window_toast) {
                    jSONArray18.put(nbd.b(windowToast));
                }
                ktc.a(jSONObject, "window_toast", jSONArray18);
            }
            RecomPostTopic recomPostTopic = dataRes.recom_post_topic;
            if (recomPostTopic != null) {
                ktc.a(jSONObject, "recom_post_topic", s1d.b(recomPostTopic));
            }
            ActivityConfig activityConfig = dataRes.activity_config;
            if (activityConfig != null) {
                ktc.a(jSONObject, "activity_config", wyc.b(activityConfig));
            }
            StarVoice starVoice = dataRes.star_voice;
            if (starVoice != null) {
                ktc.a(jSONObject, "star_voice", u8d.b(starVoice));
            }
            WorldcupSkin worldcupSkin = dataRes.worldcup_skin;
            if (worldcupSkin != null) {
                ktc.a(jSONObject, "worldcup_skin", c3d.b(worldcupSkin));
            }
            RedpacketRain redpacketRain = dataRes.redpacketrain;
            if (redpacketRain != null) {
                ktc.a(jSONObject, "redpacketrain", p7d.b(redpacketRain));
            }
            BrandForumInfo brandForumInfo = dataRes.brand_forum_info;
            if (brandForumInfo != null) {
                ktc.a(jSONObject, "brand_forum_info", kzc.b(brandForumInfo));
            }
            if (dataRes.bottom_menu != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (BottomMenu bottomMenu : dataRes.bottom_menu) {
                    jSONArray19.put(lvc.b(bottomMenu));
                }
                ktc.a(jSONObject, "bottom_menu", jSONArray19);
            }
            ktc.a(jSONObject, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_AUTO_PLAY, dataRes.video_auto_play);
            if (dataRes.smart_app_avatar != null) {
                JSONArray jSONArray20 = new JSONArray();
                for (String str : dataRes.smart_app_avatar) {
                    jSONArray20.put(str);
                }
                ktc.a(jSONObject, "smart_app_avatar", jSONArray20);
            }
            SmartApp smartApp = dataRes.smart_app;
            if (smartApp != null) {
                ktc.a(jSONObject, "smart_app", m8d.b(smartApp));
            }
            NebulaHotThreads nebulaHotThreads = dataRes.nebula_hot_threads;
            if (nebulaHotThreads != null) {
                ktc.a(jSONObject, "nebula_hot_threads", e1d.b(nebulaHotThreads));
            }
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                ktc.a(jSONObject, "private_forum_info", n1d.b(privateForumTotalInfo));
            }
            ForumActiveInfo forumActiveInfo = dataRes.private_forum_active_info;
            if (forumActiveInfo != null) {
                ktc.a(jSONObject, "private_forum_active_info", a0d.b(forumActiveInfo));
            }
            BusinessPromot businessPromot = dataRes.business_promot;
            if (businessPromot != null) {
                ktc.a(jSONObject, "business_promot", mzc.c(businessPromot));
            }
            if (dataRes.service_area != null) {
                JSONArray jSONArray21 = new JSONArray();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    jSONArray21.put(a8d.b(serviceArea));
                }
                ktc.a(jSONObject, "service_area", jSONArray21);
            }
            WindowToast windowToast2 = dataRes.bazhu_exam_fail;
            if (windowToast2 != null) {
                ktc.a(jSONObject, "bazhu_exam_fail", nbd.b(windowToast2));
            }
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            if (hotUserRankEntry != null) {
                ktc.a(jSONObject, "hot_user_entry", x3d.b(hotUserRankEntry));
            }
            ItemInfo itemInfo = dataRes.item_info;
            if (itemInfo != null) {
                ktc.a(jSONObject, WriteActivityConfig.ITEM_INFO, c4d.b(itemInfo));
            }
            ktc.a(jSONObject, "is_get_horse_race_lamp", dataRes.is_get_horse_race_lamp);
            ForumRuleStatus forumRuleStatus = dataRes.forum_rule;
            if (forumRuleStatus != null) {
                ktc.a(jSONObject, "forum_rule", lyc.b(forumRuleStatus));
            }
            SignActivityInfo signActivityInfo = dataRes.sign_activity_info;
            if (signActivityInfo != null) {
                ktc.a(jSONObject, "sign_activity_info", f8d.b(signActivityInfo));
            }
            AddBawuPopInfo addBawuPopInfo = dataRes.add_bawu_pop;
            if (addBawuPopInfo != null) {
                ktc.a(jSONObject, "add_bawu_pop", ytc.b(addBawuPopInfo));
            }
            ktc.a(jSONObject, "show_adsense", dataRes.show_adsense);
            PopInfo popInfo2 = dataRes.frsmask_pop_info;
            if (popInfo2 != null) {
                ktc.a(jSONObject, "frsmask_pop_info", o6d.b(popInfo2));
            }
            if (dataRes.voice_room_list != null) {
                JSONArray jSONArray22 = new JSONArray();
                for (ThreadInfo threadInfo7 : dataRes.voice_room_list) {
                    jSONArray22.put(x9d.b(threadInfo7));
                }
                ktc.a(jSONObject, "voice_room_list", jSONArray22);
            }
            ktc.a(jSONObject, "voice_room_config", dataRes.voice_room_config);
            ktc.a(jSONObject, "ad_show_select", dataRes.ad_show_select);
            if (dataRes.ad_mix_list != null) {
                JSONArray jSONArray23 = new JSONArray();
                for (AdMixFloor adMixFloor : dataRes.ad_mix_list) {
                    jSONArray23.put(xtc.b(adMixFloor));
                }
                ktc.a(jSONObject, "ad_mix_list", jSONArray23);
            }
            ktc.a(jSONObject, "ad_sample_map_key", dataRes.ad_sample_map_key);
            PrivatePopInfo privatePopInfo = dataRes.bawutask_pop;
            if (privatePopInfo != null) {
                ktc.a(jSONObject, "bawutask_pop", w6d.b(privatePopInfo));
            }
            if (dataRes.live_fuse_forum != null) {
                JSONArray jSONArray24 = new JSONArray();
                for (LiveFuseForumData liveFuseForumData : dataRes.live_fuse_forum) {
                    jSONArray24.put(v0d.b(liveFuseForumData));
                }
                ktc.a(jSONObject, "live_fuse_forum", jSONArray24);
            }
            ktc.a(jSONObject, "bawu_unread_notice_num", dataRes.bawu_unread_notice_num);
            RecreationRankInfo recreationRankInfo = dataRes.recreation_rank_info;
            if (recreationRankInfo != null) {
                ktc.a(jSONObject, "recreation_rank_info", w1d.b(recreationRankInfo));
            }
            ktc.a(jSONObject, "is_member_broadcast_forum", dataRes.is_member_broadcast_forum);
            ForumGroup forumGroup = dataRes.forum_group;
            if (forumGroup != null) {
                ktc.a(jSONObject, "forum_group", e0d.b(forumGroup));
            }
            FrsBannerHeader frsBannerHeader = dataRes.frs_banner_header;
            if (frsBannerHeader != null) {
                ktc.a(jSONObject, "frs_banner_header", i0d.b(frsBannerHeader));
            }
            HeaderCard headerCard = dataRes.header_card;
            if (headerCard != null) {
                ktc.a(jSONObject, "header_card", s0d.b(headerCard));
            }
            FrsSpriteBubble frsSpriteBubble = dataRes.sprite_bubble_guide;
            if (frsSpriteBubble != null) {
                ktc.a(jSONObject, "sprite_bubble_guide", k0d.b(frsSpriteBubble));
            }
            ktc.a(jSONObject, "is_need_live_ununiq", dataRes.is_need_live_ununiq);
            BountyCard bountyCard = dataRes.bounty_card;
            if (bountyCard != null) {
                ktc.a(jSONObject, "bounty_card", izc.b(bountyCard));
            }
            PageData pageData = dataRes.page_data;
            if (pageData != null) {
                ktc.a(jSONObject, "page_data", h1d.b(pageData));
            }
            if (dataRes.frs_main_tab_list != null) {
                JSONArray jSONArray25 = new JSONArray();
                for (FrsTabInfo frsTabInfo3 : dataRes.frs_main_tab_list) {
                    jSONArray25.put(h3d.b(frsTabInfo3));
                }
                ktc.a(jSONObject, "frs_main_tab_list", jSONArray25);
            }
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null) {
                ktc.a(jSONObject, "frs_bottom", j0d.b(frsBottom));
            }
            ktc.a(jSONObject, "frs_common_info", dataRes.frs_common_info);
            AiChatroomGuide aiChatroomGuide = dataRes.ai_chatroom_guide;
            if (aiChatroomGuide != null) {
                ktc.a(jSONObject, "ai_chatroom_guide", bzc.b(aiChatroomGuide));
            }
            TopLiveData topLiveData = dataRes.top_live_data;
            if (topLiveData != null) {
                ktc.a(jSONObject, "top_live_data", o2d.b(topLiveData));
            }
            if (dataRes.live_module_list != null) {
                JSONArray jSONArray26 = new JSONArray();
                for (LiveModuleList liveModuleList : dataRes.live_module_list) {
                    jSONArray26.put(w0d.b(liveModuleList));
                }
                ktc.a(jSONObject, "live_module_list", jSONArray26);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
