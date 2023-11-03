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
public class wuc extends poc {
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
                poc.a(jSONObject, "user", m5d.b(user));
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null) {
                poc.a(jSONObject, "forum", hvc.b(forumInfo));
            }
            StarInfo starInfo = dataRes.frs_star;
            if (starInfo != null) {
                poc.a(jSONObject, "frs_star", dxc.b(starInfo));
            }
            Page page = dataRes.page;
            if (page != null) {
                poc.a(jSONObject, "page", s0d.b(page));
            }
            Anti anti = dataRes.anti;
            if (anti != null) {
                poc.a(jSONObject, SubPbActivityConfig.KEY_ANTI, rpc.b(anti));
            }
            Group group = dataRes.group;
            if (group != null) {
                poc.a(jSONObject, "group", nvc.b(group));
            }
            if (dataRes.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    jSONArray.put(u4d.b(threadInfo));
                }
                poc.a(jSONObject, "thread_list", jSONArray);
            }
            if (dataRes.thread_id_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l : dataRes.thread_id_list) {
                    jSONArray2.put(l.longValue());
                }
                poc.a(jSONObject, "thread_id_list", jSONArray2);
            }
            poc.a(jSONObject, "is_new_url", dataRes.is_new_url);
            poc.a(jSONObject, "fortune_bag", dataRes.fortune_bag);
            poc.a(jSONObject, "time", dataRes.time);
            poc.a(jSONObject, "ctime", dataRes.ctime);
            poc.a(jSONObject, "logid", dataRes.logid);
            poc.a(jSONObject, "server_time", dataRes.server_time);
            Info info = dataRes.info;
            if (info != null) {
                poc.a(jSONObject, "info", uvc.b(info));
            }
            if (dataRes.forum_livegroup_list != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AnchorInfo anchorInfo : dataRes.forum_livegroup_list) {
                    jSONArray3.put(ppc.b(anchorInfo));
                }
                poc.a(jSONObject, "forum_livegroup_list", jSONArray3);
            }
            if (dataRes.user_list != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (User user2 : dataRes.user_list) {
                    jSONArray4.put(m5d.b(user2));
                }
                poc.a(jSONObject, "user_list", jSONArray4);
            }
            GconAccount gconAccount = dataRes.gcon_account;
            if (gconAccount != null) {
                poc.a(jSONObject, "gcon_account", lvc.b(gconAccount));
            }
            poc.a(jSONObject, "fortune_desc", dataRes.fortune_desc);
            if (dataRes.star_enter != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (StarEnter starEnter : dataRes.star_enter) {
                    jSONArray5.put(cxc.b(starEnter));
                }
                poc.a(jSONObject, "star_enter", jSONArray5);
            }
            if (dataRes.color_egg != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    jSONArray6.put(suc.b(colorEgg));
                }
                poc.a(jSONObject, "color_egg", jSONArray6);
            }
            if (dataRes.frs_tab_info != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (FrsTabInfo frsTabInfo : dataRes.frs_tab_info) {
                    jSONArray7.put(eyc.b(frsTabInfo));
                }
                poc.a(jSONObject, "frs_tab_info", jSONArray7);
            }
            ActivityHead activityHead = dataRes.activityhead;
            if (activityHead != null) {
                poc.a(jSONObject, "activityhead", ztc.c(activityHead));
            }
            if (dataRes.twzhibo_info != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (ZhiBoInfoTW zhiBoInfoTW : dataRes.twzhibo_info) {
                    jSONArray8.put(q6d.b(zhiBoInfoTW));
                }
                poc.a(jSONObject, "twzhibo_info", jSONArray8);
            }
            Novel novel = dataRes.novel;
            if (novel != null) {
                poc.a(jSONObject, "novel", m0d.b(novel));
            }
            ZhiBoInfoTW zhiBoInfoTW2 = dataRes.hot_twzhibo_info;
            if (zhiBoInfoTW2 != null) {
                poc.a(jSONObject, "hot_twzhibo_info", q6d.b(zhiBoInfoTW2));
            }
            poc.a(jSONObject, "twzhibo_pos", dataRes.twzhibo_pos);
            if (dataRes.category_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (CategoryInfo categoryInfo : dataRes.category_list) {
                    jSONArray9.put(uqc.b(categoryInfo));
                }
                poc.a(jSONObject, "category_list", jSONArray9);
            }
            PushThreadInfo pushThreadInfo = dataRes.push_thread_info;
            if (pushThreadInfo != null) {
                poc.a(jSONObject, "push_thread_info", nwc.b(pushThreadInfo));
            }
            ThreadInfo threadInfo2 = dataRes.store_card;
            if (threadInfo2 != null) {
                poc.a(jSONObject, "store_card", u4d.b(threadInfo2));
            }
            SdkTopicThread sdkTopicThread = dataRes.sdk_topic_thread;
            if (sdkTopicThread != null) {
                poc.a(jSONObject, "sdk_topic_thread", v2d.b(sdkTopicThread));
            }
            poc.a(jSONObject, "bawu_enter_url", dataRes.bawu_enter_url);
            ClientPlatform clientPlatform = dataRes.client_platform;
            if (clientPlatform != null) {
                poc.a(jSONObject, "client_platform", ruc.b(clientPlatform));
            }
            HeadSdk headSdk = dataRes.head_sdk;
            if (headSdk != null) {
                poc.a(jSONObject, "head_sdk", rvc.b(headSdk));
            }
            if (dataRes.card_shipin_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ThreadInfo threadInfo3 : dataRes.card_shipin_info) {
                    jSONArray10.put(u4d.b(threadInfo3));
                }
                poc.a(jSONObject, "card_shipin_info", jSONArray10);
            }
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo != null) {
                poc.a(jSONObject, "nav_tab_info", bwc.b(navTabInfo));
            }
            poc.a(jSONObject, "frs_tab_default", dataRes.frs_tab_default);
            poc.a(jSONObject, "sort_type", dataRes.sort_type);
            RecommendInfo recommendInfo = dataRes.school_recom_info;
            if (recommendInfo != null) {
                poc.a(jSONObject, "school_recom_info", k2d.b(recommendInfo));
            }
            poc.a(jSONObject, "school_recom_pos", dataRes.school_recom_pos);
            VitalityInfo vitalityInfo = dataRes.vitality_info;
            if (vitalityInfo != null) {
                poc.a(jSONObject, "vitality_info", d6d.b(vitalityInfo));
            }
            CarrierEnter carrierEnter = dataRes.carrier_enter;
            if (carrierEnter != null) {
                poc.a(jSONObject, "carrier_enter", puc.b(carrierEnter));
            }
            if (dataRes.banner_thread_list != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BannerThreadInfo bannerThreadInfo : dataRes.banner_thread_list) {
                    jSONArray11.put(huc.b(bannerThreadInfo));
                }
                poc.a(jSONObject, "banner_thread_list", jSONArray11);
            }
            RecommendBook recommendBook = dataRes.recommend_book;
            if (recommendBook != null) {
                poc.a(jSONObject, "recommend_book", twc.b(recommendBook));
            }
            poc.a(jSONObject, "smart_frs_type", dataRes.smart_frs_type);
            poc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, dataRes.need_log);
            poc.a(jSONObject, "is_auto_play_forumheadvideo", dataRes.is_auto_play_forumheadvideo);
            ForumBookInfo forumBookInfo = dataRes.book_info;
            if (forumBookInfo != null) {
                poc.a(jSONObject, "book_info", bvc.b(forumBookInfo));
            }
            ForumPresentInfo forumPresentInfo = dataRes.forum_present_info;
            if (forumPresentInfo != null) {
                poc.a(jSONObject, "forum_present_info", mtc.b(forumPresentInfo));
            }
            ForumHeadlineImgInfo forumHeadlineImgInfo = dataRes.forum_headline_img_info;
            if (forumHeadlineImgInfo != null) {
                poc.a(jSONObject, "forum_headline_img_info", gvc.b(forumHeadlineImgInfo));
            }
            NtSpreadInfo ntSpreadInfo = dataRes.ntspread;
            if (ntSpreadInfo != null) {
                poc.a(jSONObject, "ntspread", fwc.b(ntSpreadInfo));
            }
            if (dataRes.card_shipin_pos != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (Integer num : dataRes.card_shipin_pos) {
                    jSONArray12.put(num.intValue());
                }
                poc.a(jSONObject, "card_shipin_pos", jSONArray12);
            }
            if (dataRes.card_shipin_new != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (ThreadInfo threadInfo4 : dataRes.card_shipin_new) {
                    jSONArray13.put(u4d.b(threadInfo4));
                }
                poc.a(jSONObject, "card_shipin_new", jSONArray13);
            }
            poc.a(jSONObject, "asp_shown_info", dataRes.asp_shown_info);
            poc.a(jSONObject, "ala_live_count", dataRes.ala_live_count);
            Bottle bottle = dataRes.bottle;
            if (bottle != null) {
                poc.a(jSONObject, "bottle", iuc.b(bottle));
            }
            PopInfo popInfo = dataRes.enter_pop_info;
            if (popInfo != null) {
                poc.a(jSONObject, "enter_pop_info", l1d.b(popInfo));
            }
            poc.a(jSONObject, "partial_visible_toast", dataRes.partial_visible_toast);
            Esport esport = dataRes.esport;
            if (esport != null) {
                poc.a(jSONObject, "esport", vrc.b(esport));
            }
            if (dataRes.thread_id_list_info != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (ThreadIdListInfo threadIdListInfo : dataRes.thread_id_list_info) {
                    jSONArray14.put(jxc.b(threadIdListInfo));
                }
                poc.a(jSONObject, "thread_id_list_info", jSONArray14);
            }
            AgreeBanner agreeBanner = dataRes.agree_banner;
            if (agreeBanner != null) {
                poc.a(jSONObject, "agree_banner", cuc.b(agreeBanner));
            }
            NaGuide naGuide = dataRes.na_guide;
            if (naGuide != null) {
                poc.a(jSONObject, "na_guide", f0d.b(naGuide));
            }
            if (dataRes.frs_game_tab_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (FrsTabInfo frsTabInfo2 : dataRes.frs_game_tab_info) {
                    jSONArray15.put(eyc.b(frsTabInfo2));
                }
                poc.a(jSONObject, "frs_game_tab_info", jSONArray15);
            }
            AlaLiveNotify alaLiveNotify = dataRes.live_frs_notify;
            if (alaLiveNotify != null) {
                poc.a(jSONObject, "live_frs_notify", lpc.b(alaLiveNotify));
            }
            BannerUserStory bannerUserStory = dataRes.banner_user_story;
            if (bannerUserStory != null) {
                poc.a(jSONObject, "banner_user_story", fqc.b(bannerUserStory));
            }
            FrsPageUserExtend frsPageUserExtend = dataRes.user_extend;
            if (frsPageUserExtend != null) {
                poc.a(jSONObject, "user_extend", dyc.b(frsPageUserExtend));
            }
            ForumHeadIcon forumHeadIcon = dataRes.forum_head_icon;
            if (forumHeadIcon != null) {
                poc.a(jSONObject, "forum_head_icon", fvc.b(forumHeadIcon));
            }
            FrsVideo frsVideo = dataRes.video;
            if (frsVideo != null) {
                poc.a(jSONObject, "video", hyc.b(frsVideo));
            }
            poc.a(jSONObject, "game_default_tab_id", dataRes.game_default_tab_id);
            if (dataRes.ala_insert_thread != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (ThreadInfo threadInfo5 : dataRes.ala_insert_thread) {
                    jSONArray16.put(u4d.b(threadInfo5));
                }
                poc.a(jSONObject, "ala_insert_thread", jSONArray16);
            }
            AlaLiveInsert alaLiveInsert = dataRes.ala_live_insert;
            if (alaLiveInsert != null) {
                poc.a(jSONObject, "ala_live_insert", duc.b(alaLiveInsert));
            }
            poc.a(jSONObject, "ala_insert_floor", dataRes.ala_insert_floor);
            ForumArIno forumArIno = dataRes.forum_ar_info;
            if (forumArIno != null) {
                poc.a(jSONObject, "forum_ar_info", ktc.b(forumArIno));
            }
            if (dataRes.ala_stage_list != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (ThreadInfo threadInfo6 : dataRes.ala_stage_list) {
                    jSONArray17.put(u4d.b(threadInfo6));
                }
                poc.a(jSONObject, "ala_stage_list", jSONArray17);
            }
            StarRank starRank = dataRes.star_rank_info;
            if (starRank != null) {
                poc.a(jSONObject, "star_rank_info", exc.b(starRank));
            }
            poc.a(jSONObject, "trends_redpoint", dataRes.trends_redpoint);
            if (dataRes.window_toast != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (WindowToast windowToast : dataRes.window_toast) {
                    jSONArray18.put(j6d.b(windowToast));
                }
                poc.a(jSONObject, "window_toast", jSONArray18);
            }
            RecomPostTopic recomPostTopic = dataRes.recom_post_topic;
            if (recomPostTopic != null) {
                poc.a(jSONObject, "recom_post_topic", rwc.b(recomPostTopic));
            }
            ActivityConfig activityConfig = dataRes.activity_config;
            if (activityConfig != null) {
                poc.a(jSONObject, "activity_config", ytc.b(activityConfig));
            }
            StarVoice starVoice = dataRes.star_voice;
            if (starVoice != null) {
                poc.a(jSONObject, "star_voice", r3d.b(starVoice));
            }
            WorldcupSkin worldcupSkin = dataRes.worldcup_skin;
            if (worldcupSkin != null) {
                poc.a(jSONObject, "worldcup_skin", zxc.b(worldcupSkin));
            }
            RedpacketRain redpacketRain = dataRes.redpacketrain;
            if (redpacketRain != null) {
                poc.a(jSONObject, "redpacketrain", m2d.b(redpacketRain));
            }
            BrandForumInfo brandForumInfo = dataRes.brand_forum_info;
            if (brandForumInfo != null) {
                poc.a(jSONObject, "brand_forum_info", kuc.b(brandForumInfo));
            }
            if (dataRes.bottom_menu != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (BottomMenu bottomMenu : dataRes.bottom_menu) {
                    jSONArray19.put(oqc.b(bottomMenu));
                }
                poc.a(jSONObject, "bottom_menu", jSONArray19);
            }
            poc.a(jSONObject, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_AUTO_PLAY, dataRes.video_auto_play);
            if (dataRes.smart_app_avatar != null) {
                JSONArray jSONArray20 = new JSONArray();
                for (String str : dataRes.smart_app_avatar) {
                    jSONArray20.put(str);
                }
                poc.a(jSONObject, "smart_app_avatar", jSONArray20);
            }
            SmartApp smartApp = dataRes.smart_app;
            if (smartApp != null) {
                poc.a(jSONObject, "smart_app", j3d.b(smartApp));
            }
            NebulaHotThreads nebulaHotThreads = dataRes.nebula_hot_threads;
            if (nebulaHotThreads != null) {
                poc.a(jSONObject, "nebula_hot_threads", dwc.b(nebulaHotThreads));
            }
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                poc.a(jSONObject, "private_forum_info", mwc.b(privateForumTotalInfo));
            }
            ForumActiveInfo forumActiveInfo = dataRes.private_forum_active_info;
            if (forumActiveInfo != null) {
                poc.a(jSONObject, "private_forum_active_info", avc.b(forumActiveInfo));
            }
            BusinessPromot businessPromot = dataRes.business_promot;
            if (businessPromot != null) {
                poc.a(jSONObject, "business_promot", muc.c(businessPromot));
            }
            if (dataRes.service_area != null) {
                JSONArray jSONArray21 = new JSONArray();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    jSONArray21.put(x2d.b(serviceArea));
                }
                poc.a(jSONObject, "service_area", jSONArray21);
            }
            WindowToast windowToast2 = dataRes.bazhu_exam_fail;
            if (windowToast2 != null) {
                poc.a(jSONObject, "bazhu_exam_fail", j6d.b(windowToast2));
            }
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            if (hotUserRankEntry != null) {
                poc.a(jSONObject, "hot_user_entry", uyc.b(hotUserRankEntry));
            }
            ItemInfo itemInfo = dataRes.item_info;
            if (itemInfo != null) {
                poc.a(jSONObject, WriteActivityConfig.ITEM_INFO, zyc.b(itemInfo));
            }
            poc.a(jSONObject, "is_get_horse_race_lamp", dataRes.is_get_horse_race_lamp);
            ForumRuleStatus forumRuleStatus = dataRes.forum_rule;
            if (forumRuleStatus != null) {
                poc.a(jSONObject, "forum_rule", ntc.b(forumRuleStatus));
            }
            SignActivityInfo signActivityInfo = dataRes.sign_activity_info;
            if (signActivityInfo != null) {
                poc.a(jSONObject, "sign_activity_info", c3d.b(signActivityInfo));
            }
            AddBawuPopInfo addBawuPopInfo = dataRes.add_bawu_pop;
            if (addBawuPopInfo != null) {
                poc.a(jSONObject, "add_bawu_pop", dpc.b(addBawuPopInfo));
            }
            poc.a(jSONObject, "show_adsense", dataRes.show_adsense);
            PopInfo popInfo2 = dataRes.frsmask_pop_info;
            if (popInfo2 != null) {
                poc.a(jSONObject, "frsmask_pop_info", l1d.b(popInfo2));
            }
            if (dataRes.voice_room_list != null) {
                JSONArray jSONArray22 = new JSONArray();
                for (ThreadInfo threadInfo7 : dataRes.voice_room_list) {
                    jSONArray22.put(u4d.b(threadInfo7));
                }
                poc.a(jSONObject, "voice_room_list", jSONArray22);
            }
            poc.a(jSONObject, "voice_room_config", dataRes.voice_room_config);
            poc.a(jSONObject, "ad_show_select", dataRes.ad_show_select);
            if (dataRes.ad_mix_list != null) {
                JSONArray jSONArray23 = new JSONArray();
                for (AdMixFloor adMixFloor : dataRes.ad_mix_list) {
                    jSONArray23.put(cpc.b(adMixFloor));
                }
                poc.a(jSONObject, "ad_mix_list", jSONArray23);
            }
            poc.a(jSONObject, "ad_sample_map_key", dataRes.ad_sample_map_key);
            PrivatePopInfo privatePopInfo = dataRes.bawutask_pop;
            if (privatePopInfo != null) {
                poc.a(jSONObject, "bawutask_pop", t1d.b(privatePopInfo));
            }
            if (dataRes.live_fuse_forum != null) {
                JSONArray jSONArray24 = new JSONArray();
                for (LiveFuseForumData liveFuseForumData : dataRes.live_fuse_forum) {
                    jSONArray24.put(vvc.b(liveFuseForumData));
                }
                poc.a(jSONObject, "live_fuse_forum", jSONArray24);
            }
            poc.a(jSONObject, "bawu_unread_notice_num", dataRes.bawu_unread_notice_num);
            RecreationRankInfo recreationRankInfo = dataRes.recreation_rank_info;
            if (recreationRankInfo != null) {
                poc.a(jSONObject, "recreation_rank_info", vwc.b(recreationRankInfo));
            }
            poc.a(jSONObject, "is_member_broadcast_forum", dataRes.is_member_broadcast_forum);
            ForumGroup forumGroup = dataRes.forum_group;
            if (forumGroup != null) {
                poc.a(jSONObject, "forum_group", evc.b(forumGroup));
            }
            FrsBannerHeader frsBannerHeader = dataRes.frs_banner_header;
            if (frsBannerHeader != null) {
                poc.a(jSONObject, "frs_banner_header", ivc.b(frsBannerHeader));
            }
            HeaderCard headerCard = dataRes.header_card;
            if (headerCard != null) {
                poc.a(jSONObject, "header_card", svc.b(headerCard));
            }
            FrsSpriteBubble frsSpriteBubble = dataRes.sprite_bubble_guide;
            if (frsSpriteBubble != null) {
                poc.a(jSONObject, "sprite_bubble_guide", kvc.b(frsSpriteBubble));
            }
            poc.a(jSONObject, "is_need_live_ununiq", dataRes.is_need_live_ununiq);
            BountyCard bountyCard = dataRes.bounty_card;
            if (bountyCard != null) {
                poc.a(jSONObject, "bounty_card", juc.b(bountyCard));
            }
            PageData pageData = dataRes.page_data;
            if (pageData != null) {
                poc.a(jSONObject, "page_data", gwc.b(pageData));
            }
            if (dataRes.frs_main_tab_list != null) {
                JSONArray jSONArray25 = new JSONArray();
                for (FrsTabInfo frsTabInfo3 : dataRes.frs_main_tab_list) {
                    jSONArray25.put(eyc.b(frsTabInfo3));
                }
                poc.a(jSONObject, "frs_main_tab_list", jSONArray25);
            }
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null) {
                poc.a(jSONObject, "frs_bottom", jvc.b(frsBottom));
            }
            poc.a(jSONObject, "frs_common_info", dataRes.frs_common_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
