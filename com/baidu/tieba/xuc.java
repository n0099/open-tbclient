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
/* loaded from: classes9.dex */
public class xuc extends qoc {
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
                qoc.a(jSONObject, "user", n5d.b(user));
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null) {
                qoc.a(jSONObject, "forum", ivc.b(forumInfo));
            }
            StarInfo starInfo = dataRes.frs_star;
            if (starInfo != null) {
                qoc.a(jSONObject, "frs_star", exc.b(starInfo));
            }
            Page page = dataRes.page;
            if (page != null) {
                qoc.a(jSONObject, "page", t0d.b(page));
            }
            Anti anti = dataRes.anti;
            if (anti != null) {
                qoc.a(jSONObject, SubPbActivityConfig.KEY_ANTI, spc.b(anti));
            }
            Group group = dataRes.group;
            if (group != null) {
                qoc.a(jSONObject, "group", ovc.b(group));
            }
            if (dataRes.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : dataRes.thread_list) {
                    jSONArray.put(v4d.b(threadInfo));
                }
                qoc.a(jSONObject, "thread_list", jSONArray);
            }
            if (dataRes.thread_id_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l : dataRes.thread_id_list) {
                    jSONArray2.put(l.longValue());
                }
                qoc.a(jSONObject, "thread_id_list", jSONArray2);
            }
            qoc.a(jSONObject, "is_new_url", dataRes.is_new_url);
            qoc.a(jSONObject, "fortune_bag", dataRes.fortune_bag);
            qoc.a(jSONObject, "time", dataRes.time);
            qoc.a(jSONObject, "ctime", dataRes.ctime);
            qoc.a(jSONObject, "logid", dataRes.logid);
            qoc.a(jSONObject, "server_time", dataRes.server_time);
            Info info = dataRes.info;
            if (info != null) {
                qoc.a(jSONObject, "info", vvc.b(info));
            }
            if (dataRes.forum_livegroup_list != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AnchorInfo anchorInfo : dataRes.forum_livegroup_list) {
                    jSONArray3.put(qpc.b(anchorInfo));
                }
                qoc.a(jSONObject, "forum_livegroup_list", jSONArray3);
            }
            if (dataRes.user_list != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (User user2 : dataRes.user_list) {
                    jSONArray4.put(n5d.b(user2));
                }
                qoc.a(jSONObject, "user_list", jSONArray4);
            }
            GconAccount gconAccount = dataRes.gcon_account;
            if (gconAccount != null) {
                qoc.a(jSONObject, "gcon_account", mvc.b(gconAccount));
            }
            qoc.a(jSONObject, "fortune_desc", dataRes.fortune_desc);
            if (dataRes.star_enter != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (StarEnter starEnter : dataRes.star_enter) {
                    jSONArray5.put(dxc.b(starEnter));
                }
                qoc.a(jSONObject, "star_enter", jSONArray5);
            }
            if (dataRes.color_egg != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    jSONArray6.put(tuc.b(colorEgg));
                }
                qoc.a(jSONObject, "color_egg", jSONArray6);
            }
            if (dataRes.frs_tab_info != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (FrsTabInfo frsTabInfo : dataRes.frs_tab_info) {
                    jSONArray7.put(fyc.b(frsTabInfo));
                }
                qoc.a(jSONObject, "frs_tab_info", jSONArray7);
            }
            ActivityHead activityHead = dataRes.activityhead;
            if (activityHead != null) {
                qoc.a(jSONObject, "activityhead", auc.c(activityHead));
            }
            if (dataRes.twzhibo_info != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (ZhiBoInfoTW zhiBoInfoTW : dataRes.twzhibo_info) {
                    jSONArray8.put(r6d.b(zhiBoInfoTW));
                }
                qoc.a(jSONObject, "twzhibo_info", jSONArray8);
            }
            Novel novel = dataRes.novel;
            if (novel != null) {
                qoc.a(jSONObject, "novel", n0d.b(novel));
            }
            ZhiBoInfoTW zhiBoInfoTW2 = dataRes.hot_twzhibo_info;
            if (zhiBoInfoTW2 != null) {
                qoc.a(jSONObject, "hot_twzhibo_info", r6d.b(zhiBoInfoTW2));
            }
            qoc.a(jSONObject, "twzhibo_pos", dataRes.twzhibo_pos);
            if (dataRes.category_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (CategoryInfo categoryInfo : dataRes.category_list) {
                    jSONArray9.put(vqc.b(categoryInfo));
                }
                qoc.a(jSONObject, "category_list", jSONArray9);
            }
            PushThreadInfo pushThreadInfo = dataRes.push_thread_info;
            if (pushThreadInfo != null) {
                qoc.a(jSONObject, "push_thread_info", owc.b(pushThreadInfo));
            }
            ThreadInfo threadInfo2 = dataRes.store_card;
            if (threadInfo2 != null) {
                qoc.a(jSONObject, "store_card", v4d.b(threadInfo2));
            }
            SdkTopicThread sdkTopicThread = dataRes.sdk_topic_thread;
            if (sdkTopicThread != null) {
                qoc.a(jSONObject, "sdk_topic_thread", w2d.b(sdkTopicThread));
            }
            qoc.a(jSONObject, "bawu_enter_url", dataRes.bawu_enter_url);
            ClientPlatform clientPlatform = dataRes.client_platform;
            if (clientPlatform != null) {
                qoc.a(jSONObject, "client_platform", suc.b(clientPlatform));
            }
            HeadSdk headSdk = dataRes.head_sdk;
            if (headSdk != null) {
                qoc.a(jSONObject, "head_sdk", svc.b(headSdk));
            }
            if (dataRes.card_shipin_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ThreadInfo threadInfo3 : dataRes.card_shipin_info) {
                    jSONArray10.put(v4d.b(threadInfo3));
                }
                qoc.a(jSONObject, "card_shipin_info", jSONArray10);
            }
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo != null) {
                qoc.a(jSONObject, "nav_tab_info", cwc.b(navTabInfo));
            }
            qoc.a(jSONObject, "frs_tab_default", dataRes.frs_tab_default);
            qoc.a(jSONObject, "sort_type", dataRes.sort_type);
            RecommendInfo recommendInfo = dataRes.school_recom_info;
            if (recommendInfo != null) {
                qoc.a(jSONObject, "school_recom_info", l2d.b(recommendInfo));
            }
            qoc.a(jSONObject, "school_recom_pos", dataRes.school_recom_pos);
            VitalityInfo vitalityInfo = dataRes.vitality_info;
            if (vitalityInfo != null) {
                qoc.a(jSONObject, "vitality_info", e6d.b(vitalityInfo));
            }
            CarrierEnter carrierEnter = dataRes.carrier_enter;
            if (carrierEnter != null) {
                qoc.a(jSONObject, "carrier_enter", quc.b(carrierEnter));
            }
            if (dataRes.banner_thread_list != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BannerThreadInfo bannerThreadInfo : dataRes.banner_thread_list) {
                    jSONArray11.put(iuc.b(bannerThreadInfo));
                }
                qoc.a(jSONObject, "banner_thread_list", jSONArray11);
            }
            RecommendBook recommendBook = dataRes.recommend_book;
            if (recommendBook != null) {
                qoc.a(jSONObject, "recommend_book", uwc.b(recommendBook));
            }
            qoc.a(jSONObject, "smart_frs_type", dataRes.smart_frs_type);
            qoc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, dataRes.need_log);
            qoc.a(jSONObject, "is_auto_play_forumheadvideo", dataRes.is_auto_play_forumheadvideo);
            ForumBookInfo forumBookInfo = dataRes.book_info;
            if (forumBookInfo != null) {
                qoc.a(jSONObject, "book_info", cvc.b(forumBookInfo));
            }
            ForumPresentInfo forumPresentInfo = dataRes.forum_present_info;
            if (forumPresentInfo != null) {
                qoc.a(jSONObject, "forum_present_info", ntc.b(forumPresentInfo));
            }
            ForumHeadlineImgInfo forumHeadlineImgInfo = dataRes.forum_headline_img_info;
            if (forumHeadlineImgInfo != null) {
                qoc.a(jSONObject, "forum_headline_img_info", hvc.b(forumHeadlineImgInfo));
            }
            NtSpreadInfo ntSpreadInfo = dataRes.ntspread;
            if (ntSpreadInfo != null) {
                qoc.a(jSONObject, "ntspread", gwc.b(ntSpreadInfo));
            }
            if (dataRes.card_shipin_pos != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (Integer num : dataRes.card_shipin_pos) {
                    jSONArray12.put(num.intValue());
                }
                qoc.a(jSONObject, "card_shipin_pos", jSONArray12);
            }
            if (dataRes.card_shipin_new != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (ThreadInfo threadInfo4 : dataRes.card_shipin_new) {
                    jSONArray13.put(v4d.b(threadInfo4));
                }
                qoc.a(jSONObject, "card_shipin_new", jSONArray13);
            }
            qoc.a(jSONObject, "asp_shown_info", dataRes.asp_shown_info);
            qoc.a(jSONObject, "ala_live_count", dataRes.ala_live_count);
            Bottle bottle = dataRes.bottle;
            if (bottle != null) {
                qoc.a(jSONObject, "bottle", juc.b(bottle));
            }
            PopInfo popInfo = dataRes.enter_pop_info;
            if (popInfo != null) {
                qoc.a(jSONObject, "enter_pop_info", m1d.b(popInfo));
            }
            qoc.a(jSONObject, "partial_visible_toast", dataRes.partial_visible_toast);
            Esport esport = dataRes.esport;
            if (esport != null) {
                qoc.a(jSONObject, "esport", wrc.b(esport));
            }
            if (dataRes.thread_id_list_info != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (ThreadIdListInfo threadIdListInfo : dataRes.thread_id_list_info) {
                    jSONArray14.put(kxc.b(threadIdListInfo));
                }
                qoc.a(jSONObject, "thread_id_list_info", jSONArray14);
            }
            AgreeBanner agreeBanner = dataRes.agree_banner;
            if (agreeBanner != null) {
                qoc.a(jSONObject, "agree_banner", duc.b(agreeBanner));
            }
            NaGuide naGuide = dataRes.na_guide;
            if (naGuide != null) {
                qoc.a(jSONObject, "na_guide", g0d.b(naGuide));
            }
            if (dataRes.frs_game_tab_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (FrsTabInfo frsTabInfo2 : dataRes.frs_game_tab_info) {
                    jSONArray15.put(fyc.b(frsTabInfo2));
                }
                qoc.a(jSONObject, "frs_game_tab_info", jSONArray15);
            }
            AlaLiveNotify alaLiveNotify = dataRes.live_frs_notify;
            if (alaLiveNotify != null) {
                qoc.a(jSONObject, "live_frs_notify", mpc.b(alaLiveNotify));
            }
            BannerUserStory bannerUserStory = dataRes.banner_user_story;
            if (bannerUserStory != null) {
                qoc.a(jSONObject, "banner_user_story", gqc.b(bannerUserStory));
            }
            FrsPageUserExtend frsPageUserExtend = dataRes.user_extend;
            if (frsPageUserExtend != null) {
                qoc.a(jSONObject, "user_extend", eyc.b(frsPageUserExtend));
            }
            ForumHeadIcon forumHeadIcon = dataRes.forum_head_icon;
            if (forumHeadIcon != null) {
                qoc.a(jSONObject, "forum_head_icon", gvc.b(forumHeadIcon));
            }
            FrsVideo frsVideo = dataRes.video;
            if (frsVideo != null) {
                qoc.a(jSONObject, "video", iyc.b(frsVideo));
            }
            qoc.a(jSONObject, "game_default_tab_id", dataRes.game_default_tab_id);
            if (dataRes.ala_insert_thread != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (ThreadInfo threadInfo5 : dataRes.ala_insert_thread) {
                    jSONArray16.put(v4d.b(threadInfo5));
                }
                qoc.a(jSONObject, "ala_insert_thread", jSONArray16);
            }
            AlaLiveInsert alaLiveInsert = dataRes.ala_live_insert;
            if (alaLiveInsert != null) {
                qoc.a(jSONObject, "ala_live_insert", euc.b(alaLiveInsert));
            }
            qoc.a(jSONObject, "ala_insert_floor", dataRes.ala_insert_floor);
            ForumArIno forumArIno = dataRes.forum_ar_info;
            if (forumArIno != null) {
                qoc.a(jSONObject, "forum_ar_info", ltc.b(forumArIno));
            }
            if (dataRes.ala_stage_list != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (ThreadInfo threadInfo6 : dataRes.ala_stage_list) {
                    jSONArray17.put(v4d.b(threadInfo6));
                }
                qoc.a(jSONObject, "ala_stage_list", jSONArray17);
            }
            StarRank starRank = dataRes.star_rank_info;
            if (starRank != null) {
                qoc.a(jSONObject, "star_rank_info", fxc.b(starRank));
            }
            qoc.a(jSONObject, "trends_redpoint", dataRes.trends_redpoint);
            if (dataRes.window_toast != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (WindowToast windowToast : dataRes.window_toast) {
                    jSONArray18.put(k6d.b(windowToast));
                }
                qoc.a(jSONObject, "window_toast", jSONArray18);
            }
            RecomPostTopic recomPostTopic = dataRes.recom_post_topic;
            if (recomPostTopic != null) {
                qoc.a(jSONObject, "recom_post_topic", swc.b(recomPostTopic));
            }
            ActivityConfig activityConfig = dataRes.activity_config;
            if (activityConfig != null) {
                qoc.a(jSONObject, "activity_config", ztc.b(activityConfig));
            }
            StarVoice starVoice = dataRes.star_voice;
            if (starVoice != null) {
                qoc.a(jSONObject, "star_voice", s3d.b(starVoice));
            }
            WorldcupSkin worldcupSkin = dataRes.worldcup_skin;
            if (worldcupSkin != null) {
                qoc.a(jSONObject, "worldcup_skin", ayc.b(worldcupSkin));
            }
            RedpacketRain redpacketRain = dataRes.redpacketrain;
            if (redpacketRain != null) {
                qoc.a(jSONObject, "redpacketrain", n2d.b(redpacketRain));
            }
            BrandForumInfo brandForumInfo = dataRes.brand_forum_info;
            if (brandForumInfo != null) {
                qoc.a(jSONObject, "brand_forum_info", luc.b(brandForumInfo));
            }
            if (dataRes.bottom_menu != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (BottomMenu bottomMenu : dataRes.bottom_menu) {
                    jSONArray19.put(pqc.b(bottomMenu));
                }
                qoc.a(jSONObject, "bottom_menu", jSONArray19);
            }
            qoc.a(jSONObject, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_AUTO_PLAY, dataRes.video_auto_play);
            if (dataRes.smart_app_avatar != null) {
                JSONArray jSONArray20 = new JSONArray();
                for (String str : dataRes.smart_app_avatar) {
                    jSONArray20.put(str);
                }
                qoc.a(jSONObject, "smart_app_avatar", jSONArray20);
            }
            SmartApp smartApp = dataRes.smart_app;
            if (smartApp != null) {
                qoc.a(jSONObject, "smart_app", k3d.b(smartApp));
            }
            NebulaHotThreads nebulaHotThreads = dataRes.nebula_hot_threads;
            if (nebulaHotThreads != null) {
                qoc.a(jSONObject, "nebula_hot_threads", ewc.b(nebulaHotThreads));
            }
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                qoc.a(jSONObject, "private_forum_info", nwc.b(privateForumTotalInfo));
            }
            ForumActiveInfo forumActiveInfo = dataRes.private_forum_active_info;
            if (forumActiveInfo != null) {
                qoc.a(jSONObject, "private_forum_active_info", bvc.b(forumActiveInfo));
            }
            BusinessPromot businessPromot = dataRes.business_promot;
            if (businessPromot != null) {
                qoc.a(jSONObject, "business_promot", nuc.c(businessPromot));
            }
            if (dataRes.service_area != null) {
                JSONArray jSONArray21 = new JSONArray();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    jSONArray21.put(y2d.b(serviceArea));
                }
                qoc.a(jSONObject, "service_area", jSONArray21);
            }
            WindowToast windowToast2 = dataRes.bazhu_exam_fail;
            if (windowToast2 != null) {
                qoc.a(jSONObject, "bazhu_exam_fail", k6d.b(windowToast2));
            }
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            if (hotUserRankEntry != null) {
                qoc.a(jSONObject, "hot_user_entry", vyc.b(hotUserRankEntry));
            }
            ItemInfo itemInfo = dataRes.item_info;
            if (itemInfo != null) {
                qoc.a(jSONObject, WriteActivityConfig.ITEM_INFO, azc.b(itemInfo));
            }
            qoc.a(jSONObject, "is_get_horse_race_lamp", dataRes.is_get_horse_race_lamp);
            ForumRuleStatus forumRuleStatus = dataRes.forum_rule;
            if (forumRuleStatus != null) {
                qoc.a(jSONObject, "forum_rule", otc.b(forumRuleStatus));
            }
            SignActivityInfo signActivityInfo = dataRes.sign_activity_info;
            if (signActivityInfo != null) {
                qoc.a(jSONObject, "sign_activity_info", d3d.b(signActivityInfo));
            }
            AddBawuPopInfo addBawuPopInfo = dataRes.add_bawu_pop;
            if (addBawuPopInfo != null) {
                qoc.a(jSONObject, "add_bawu_pop", epc.b(addBawuPopInfo));
            }
            qoc.a(jSONObject, "show_adsense", dataRes.show_adsense);
            PopInfo popInfo2 = dataRes.frsmask_pop_info;
            if (popInfo2 != null) {
                qoc.a(jSONObject, "frsmask_pop_info", m1d.b(popInfo2));
            }
            if (dataRes.voice_room_list != null) {
                JSONArray jSONArray22 = new JSONArray();
                for (ThreadInfo threadInfo7 : dataRes.voice_room_list) {
                    jSONArray22.put(v4d.b(threadInfo7));
                }
                qoc.a(jSONObject, "voice_room_list", jSONArray22);
            }
            qoc.a(jSONObject, "voice_room_config", dataRes.voice_room_config);
            qoc.a(jSONObject, "ad_show_select", dataRes.ad_show_select);
            if (dataRes.ad_mix_list != null) {
                JSONArray jSONArray23 = new JSONArray();
                for (AdMixFloor adMixFloor : dataRes.ad_mix_list) {
                    jSONArray23.put(dpc.b(adMixFloor));
                }
                qoc.a(jSONObject, "ad_mix_list", jSONArray23);
            }
            qoc.a(jSONObject, "ad_sample_map_key", dataRes.ad_sample_map_key);
            PrivatePopInfo privatePopInfo = dataRes.bawutask_pop;
            if (privatePopInfo != null) {
                qoc.a(jSONObject, "bawutask_pop", u1d.b(privatePopInfo));
            }
            if (dataRes.live_fuse_forum != null) {
                JSONArray jSONArray24 = new JSONArray();
                for (LiveFuseForumData liveFuseForumData : dataRes.live_fuse_forum) {
                    jSONArray24.put(wvc.b(liveFuseForumData));
                }
                qoc.a(jSONObject, "live_fuse_forum", jSONArray24);
            }
            qoc.a(jSONObject, "bawu_unread_notice_num", dataRes.bawu_unread_notice_num);
            RecreationRankInfo recreationRankInfo = dataRes.recreation_rank_info;
            if (recreationRankInfo != null) {
                qoc.a(jSONObject, "recreation_rank_info", wwc.b(recreationRankInfo));
            }
            qoc.a(jSONObject, "is_member_broadcast_forum", dataRes.is_member_broadcast_forum);
            ForumGroup forumGroup = dataRes.forum_group;
            if (forumGroup != null) {
                qoc.a(jSONObject, "forum_group", fvc.b(forumGroup));
            }
            FrsBannerHeader frsBannerHeader = dataRes.frs_banner_header;
            if (frsBannerHeader != null) {
                qoc.a(jSONObject, "frs_banner_header", jvc.b(frsBannerHeader));
            }
            HeaderCard headerCard = dataRes.header_card;
            if (headerCard != null) {
                qoc.a(jSONObject, "header_card", tvc.b(headerCard));
            }
            FrsSpriteBubble frsSpriteBubble = dataRes.sprite_bubble_guide;
            if (frsSpriteBubble != null) {
                qoc.a(jSONObject, "sprite_bubble_guide", lvc.b(frsSpriteBubble));
            }
            qoc.a(jSONObject, "is_need_live_ununiq", dataRes.is_need_live_ununiq);
            BountyCard bountyCard = dataRes.bounty_card;
            if (bountyCard != null) {
                qoc.a(jSONObject, "bounty_card", kuc.b(bountyCard));
            }
            PageData pageData = dataRes.page_data;
            if (pageData != null) {
                qoc.a(jSONObject, "page_data", hwc.b(pageData));
            }
            if (dataRes.frs_main_tab_list != null) {
                JSONArray jSONArray25 = new JSONArray();
                for (FrsTabInfo frsTabInfo3 : dataRes.frs_main_tab_list) {
                    jSONArray25.put(fyc.b(frsTabInfo3));
                }
                qoc.a(jSONObject, "frs_main_tab_list", jSONArray25);
            }
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null) {
                qoc.a(jSONObject, "frs_bottom", kvc.b(frsBottom));
            }
            qoc.a(jSONObject, "frs_common_info", dataRes.frs_common_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
