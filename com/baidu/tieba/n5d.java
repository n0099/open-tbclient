package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActivitySponsor;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.BaijiahaoInfo;
import tbclient.Balv;
import tbclient.BawuThrones;
import tbclient.BazhuSign;
import tbclient.BirthdayInfo;
import tbclient.BusinessAccountInfo;
import tbclient.CallFansInfo;
import tbclient.ConsumeInfo;
import tbclient.CreationData;
import tbclient.Ecom;
import tbclient.EditConfig;
import tbclient.EsportInfo;
import tbclient.ForumToolPerm;
import tbclient.GiftInfo;
import tbclient.GodInfo;
import tbclient.Icon;
import tbclient.LikeForumInfo;
import tbclient.LiveRoomInfo;
import tbclient.MyGroupInfo;
import tbclient.NewGodInfo;
import tbclient.NewParrScores;
import tbclient.NewUser;
import tbclient.NovelFansInfo;
import tbclient.PayMemberInfo;
import tbclient.Pendant;
import tbclient.PrivSets;
import tbclient.ShakeAdSwitch;
import tbclient.SimpleUser;
import tbclient.SpringVirtualUser;
import tbclient.TagsInfo;
import tbclient.TbVipInfo;
import tbclient.ThemeBackgroundInUser;
import tbclient.ThemeCardInUser;
import tbclient.ThemeMyTab;
import tbclient.ThemeTailInUser;
import tbclient.TshowInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserPics;
import tbclient.UserVideoChannelInfo;
import tbclient.UserVipInfo;
import tbclient.VipCloseAd;
import tbclient.VipShowInfo;
import tbclient.VirtualImageInfo;
import tbclient.WorkCreatorInfo;
import tbclient.WorldCupInfo;
/* loaded from: classes7.dex */
public class n5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, user)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_login", user.is_login);
            qoc.a(jSONObject, "id", user.id);
            qoc.a(jSONObject, "name", user.name);
            qoc.a(jSONObject, "name_show", user.name_show);
            qoc.a(jSONObject, "portrait", user.portrait);
            qoc.a(jSONObject, "no_un", user.no_un);
            qoc.a(jSONObject, "type", user.type);
            NewUser newUser = user.new_user_info;
            if (newUser != null) {
                qoc.a(jSONObject, "new_user_info", k0d.b(newUser));
            }
            qoc.a(jSONObject, "userhide", user.userhide);
            Balv balv = user.balv;
            if (balv != null) {
                qoc.a(jSONObject, "balv", eqc.b(balv));
            }
            qoc.a(jSONObject, "is_manager", user.is_manager);
            qoc.a(jSONObject, MultiRatePlayUrlHelper.RANK, user.rank);
            qoc.a(jSONObject, "bimg_url", user.bimg_url);
            qoc.a(jSONObject, "meizhi_level", user.meizhi_level);
            qoc.a(jSONObject, "is_verify", user.is_verify);
            qoc.a(jSONObject, "is_interestman", user.is_interestman);
            if (user.iconinfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (Icon icon : user.iconinfo) {
                    jSONArray.put(wyc.b(icon));
                }
                qoc.a(jSONObject, "iconinfo", jSONArray);
            }
            if (user.tshow_icon != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TshowInfo tshowInfo : user.tshow_icon) {
                    jSONArray2.put(j5d.b(tshowInfo));
                }
                qoc.a(jSONObject, "tshow_icon", jSONArray2);
            }
            qoc.a(jSONObject, "user_type", user.user_type);
            qoc.a(jSONObject, "is_coreuser", user.is_coreuser);
            qoc.a(jSONObject, "is_huinibuke", user.is_huinibuke);
            qoc.a(jSONObject, "ios_bimg_format", user.ios_bimg_format);
            qoc.a(jSONObject, "level_id", user.level_id);
            qoc.a(jSONObject, "is_like", user.is_like);
            qoc.a(jSONObject, "is_bawu", user.is_bawu);
            qoc.a(jSONObject, "bawu_type", user.bawu_type);
            qoc.a(jSONObject, "portraith", user.portraith);
            qoc.a(jSONObject, "ip", user.ip);
            qoc.a(jSONObject, HttpRequest.BDUSS, user.BDUSS);
            qoc.a(jSONObject, PersonInfoActivityConfig.FANS_NUM, user.fans_num);
            qoc.a(jSONObject, "concern_num", user.concern_num);
            qoc.a(jSONObject, "sex", user.sex);
            qoc.a(jSONObject, "my_like_num", user.my_like_num);
            qoc.a(jSONObject, "intro", user.intro);
            qoc.a(jSONObject, "has_concerned", user.has_concerned);
            qoc.a(jSONObject, "passwd", user.passwd);
            qoc.a(jSONObject, "post_num", user.post_num);
            qoc.a(jSONObject, "tb_age", user.tb_age);
            qoc.a(jSONObject, "is_mem", user.is_mem);
            qoc.a(jSONObject, "bimg_end_time", user.bimg_end_time);
            PayMemberInfo payMemberInfo = user.pay_member_info;
            if (payMemberInfo != null) {
                qoc.a(jSONObject, "pay_member_info", w0d.b(payMemberInfo));
            }
            qoc.a(jSONObject, "gender", user.gender);
            qoc.a(jSONObject, "is_mask", user.is_mask);
            if (user.user_pics != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (UserPics userPics : user.user_pics) {
                    jSONArray3.put(p5d.b(userPics));
                }
                qoc.a(jSONObject, "user_pics", jSONArray3);
            }
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                qoc.a(jSONObject, "priv_sets", s1d.b(privSets));
            }
            qoc.a(jSONObject, "is_friend", user.is_friend);
            if (user.likeForum != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (LikeForumInfo likeForumInfo : user.likeForum) {
                    jSONArray4.put(ozc.b(likeForumInfo));
                }
                qoc.a(jSONObject, "likeForum", jSONArray4);
            }
            if (user.groupList != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (MyGroupInfo myGroupInfo : user.groupList) {
                    jSONArray5.put(f0d.b(myGroupInfo));
                }
                qoc.a(jSONObject, "groupList", jSONArray5);
            }
            qoc.a(jSONObject, "gift_num", user.gift_num);
            if (user.gift_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GiftInfo giftInfo : user.gift_list) {
                    jSONArray6.put(myc.b(giftInfo));
                }
                qoc.a(jSONObject, "gift_list", jSONArray6);
            }
            qoc.a(jSONObject, "is_select_tail", user.is_select_tail);
            qoc.a(jSONObject, "is_guanfang", user.is_guanfang);
            qoc.a(jSONObject, "bookmark_count", user.bookmark_count);
            qoc.a(jSONObject, "bookmark_new_count", user.bookmark_new_count);
            if (user.mute_user != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (SimpleUser simpleUser : user.mute_user) {
                    jSONArray7.put(i3d.b(simpleUser));
                }
                qoc.a(jSONObject, "mute_user", jSONArray7);
            }
            qoc.a(jSONObject, "friend_num", user.friend_num);
            qoc.a(jSONObject, "fans_nickname", user.fans_nickname);
            qoc.a(jSONObject, "bg_pic", user.bg_pic);
            NewParrScores newParrScores = user.parr_scores;
            if (newParrScores != null) {
                qoc.a(jSONObject, "parr_scores", j0d.b(newParrScores));
            }
            NovelFansInfo novelFansInfo = user.novel_fans_info;
            if (novelFansInfo != null) {
                qoc.a(jSONObject, "novel_fans_info", o0d.b(novelFansInfo));
            }
            UserVipInfo userVipInfo = user.vipInfo;
            if (userVipInfo != null) {
                qoc.a(jSONObject, "vipInfo", u5d.b(userVipInfo));
            }
            GodInfo godInfo = user.god_data;
            if (godInfo != null) {
                qoc.a(jSONObject, "god_data", oyc.b(godInfo));
            }
            qoc.a(jSONObject, "heavy_user", user.heavy_user);
            VipShowInfo vipShowInfo = user.vip_show_info;
            if (vipShowInfo != null) {
                qoc.a(jSONObject, "vip_show_info", c6d.b(vipShowInfo));
            }
            if (user.new_tshow_icon != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (TshowInfo tshowInfo2 : user.new_tshow_icon) {
                    jSONArray8.put(j5d.b(tshowInfo2));
                }
                qoc.a(jSONObject, "new_tshow_icon", jSONArray8);
            }
            TwZhiBoUser twZhiBoUser = user.tw_anchor_info;
            if (twZhiBoUser != null) {
                qoc.a(jSONObject, "tw_anchor_info", l5d.b(twZhiBoUser));
            }
            if (user.profit_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (TwAnchorProfitItem twAnchorProfitItem : user.profit_list) {
                    jSONArray9.put(k5d.b(twAnchorProfitItem));
                }
                qoc.a(jSONObject, "profit_list", jSONArray9);
            }
            ConsumeInfo consumeInfo = user.consume_info;
            if (consumeInfo != null) {
                qoc.a(jSONObject, "consume_info", frc.b(consumeInfo));
            }
            ThemeCardInUser themeCardInUser = user.theme_card;
            if (themeCardInUser != null) {
                qoc.a(jSONObject, "theme_card", p4d.b(themeCardInUser));
            }
            VipCloseAd vipCloseAd = user.vip_close_ad;
            if (vipCloseAd != null) {
                qoc.a(jSONObject, "vip_close_ad", b6d.b(vipCloseAd));
            }
            ActivitySponsor activitySponsor = user.activity_sponsor;
            if (activitySponsor != null) {
                qoc.a(jSONObject, "activity_sponsor", apc.b(activitySponsor));
            }
            TbVipInfo tbVipInfo = user.tb_vip;
            if (tbVipInfo != null) {
                qoc.a(jSONObject, "tb_vip", j4d.b(tbVipInfo));
            }
            qoc.a(jSONObject, "no_post_high", user.no_post_high);
            Ecom ecom = user.ecom;
            if (ecom != null) {
                qoc.a(jSONObject, "ecom", src.b(ecom));
            }
            qoc.a(jSONObject, "visitor_num", user.visitor_num);
            qoc.a(jSONObject, "total_visitor_num", user.total_visitor_num);
            Pendant pendant = user.pendant;
            if (pendant != null) {
                qoc.a(jSONObject, "pendant", e1d.b(pendant));
            }
            AlaUserInfo alaUserInfo = user.ala_info;
            if (alaUserInfo != null) {
                qoc.a(jSONObject, "ala_info", ppc.b(alaUserInfo));
            }
            qoc.a(jSONObject, "seal_prefix", user.seal_prefix);
            qoc.a(jSONObject, "has_bottle_enter", user.has_bottle_enter);
            UserVideoChannelInfo userVideoChannelInfo = user.video_channel_info;
            if (userVideoChannelInfo != null) {
                qoc.a(jSONObject, "video_channel_info", t5d.b(userVideoChannelInfo));
            }
            SpringVirtualUser springVirtualUser = user.spring_virtual_user;
            if (springVirtualUser != null) {
                qoc.a(jSONObject, "spring_virtual_user", m3d.b(springVirtualUser));
            }
            qoc.a(jSONObject, "each_other_friend", user.each_other_friend);
            EsportInfo esportInfo = user.esport_data;
            if (esportInfo != null) {
                qoc.a(jSONObject, "esport_data", xrc.b(esportInfo));
            }
            AlaLiveInfo alaLiveInfo = user.ala_live_info;
            if (alaLiveInfo != null) {
                qoc.a(jSONObject, "ala_live_info", lpc.b(alaLiveInfo));
            }
            qoc.a(jSONObject, "nickname_update_time", user.nickname_update_time);
            qoc.a(jSONObject, "thread_num", user.thread_num);
            qoc.a(jSONObject, "agree_num", user.agree_num);
            qoc.a(jSONObject, "left_call_num", user.left_call_num);
            qoc.a(jSONObject, "is_invited", user.is_invited);
            qoc.a(jSONObject, "is_fans", user.is_fans);
            qoc.a(jSONObject, "priv_thread", user.priv_thread);
            qoc.a(jSONObject, "is_videobiggie", user.is_videobiggie);
            qoc.a(jSONObject, "is_show_redpacket", user.is_show_redpacket);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            if (baijiahaoInfo != null) {
                qoc.a(jSONObject, "baijiahao_info", dqc.b(baijiahaoInfo));
            }
            BirthdayInfo birthdayInfo = user.birthday_info;
            if (birthdayInfo != null) {
                qoc.a(jSONObject, "birthday_info", kqc.b(birthdayInfo));
            }
            qoc.a(jSONObject, "can_modify_avatar", user.can_modify_avatar);
            qoc.a(jSONObject, "modify_avatar_desc", user.modify_avatar_desc);
            qoc.a(jSONObject, "influence", user.influence);
            qoc.a(jSONObject, "level_influence", user.level_influence);
            NewGodInfo newGodInfo = user.new_god_data;
            if (newGodInfo != null) {
                qoc.a(jSONObject, "new_god_data", i0d.b(newGodInfo));
            }
            BawuThrones bawuThrones = user.bawu_thrones;
            if (bawuThrones != null) {
                qoc.a(jSONObject, "bawu_thrones", iqc.b(bawuThrones));
            }
            CallFansInfo callFansInfo = user.call_fans_info;
            if (callFansInfo != null) {
                qoc.a(jSONObject, "call_fans_info", rqc.b(callFansInfo));
            }
            BazhuSign bazhuSign = user.bazhu_grade;
            if (bazhuSign != null) {
                qoc.a(jSONObject, "bazhu_grade", jqc.b(bazhuSign));
            }
            qoc.a(jSONObject, "is_default_avatar", user.is_default_avatar);
            qoc.a(jSONObject, "uk", user.uk);
            CreationData creationData = user.creation_data;
            if (creationData != null) {
                qoc.a(jSONObject, "creation_data", grc.b(creationData));
            }
            qoc.a(jSONObject, "favorite_num", user.favorite_num);
            LiveRoomInfo liveRoomInfo = user.live_room_info;
            if (liveRoomInfo != null) {
                qoc.a(jSONObject, "live_room_info", uzc.b(liveRoomInfo));
            }
            BusinessAccountInfo businessAccountInfo = user.business_account_info;
            if (businessAccountInfo != null) {
                qoc.a(jSONObject, "business_account_info", qqc.b(businessAccountInfo));
            }
            qoc.a(jSONObject, "appeal_thread_popover", user.appeal_thread_popover);
            if (user.forum_tool_auth != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ForumToolPerm forumToolPerm : user.forum_tool_auth) {
                    jSONArray10.put(rtc.b(forumToolPerm));
                }
                qoc.a(jSONObject, "forum_tool_auth", jSONArray10);
            }
            qoc.a(jSONObject, "work_num", user.work_num);
            qoc.a(jSONObject, "show_pb_private_flag", user.show_pb_private_flag);
            qoc.a(jSONObject, "total_agree_num", user.total_agree_num);
            CreationData creationData2 = user.workcreation_data;
            if (creationData2 != null) {
                qoc.a(jSONObject, "workcreation_data", grc.b(creationData2));
            }
            qoc.a(jSONObject, "tieba_uid", user.tieba_uid);
            qoc.a(jSONObject, "follow_from", user.follow_from);
            if (user.manager_forum != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BazhuSign bazhuSign2 : user.manager_forum) {
                    jSONArray11.put(jqc.b(bazhuSign2));
                }
                qoc.a(jSONObject, "manager_forum", jSONArray11);
            }
            qoc.a(jSONObject, "display_auth_type", user.display_auth_type);
            WorkCreatorInfo workCreatorInfo = user.work_creator_info;
            if (workCreatorInfo != null) {
                qoc.a(jSONObject, "work_creator_info", l6d.b(workCreatorInfo));
            }
            qoc.a(jSONObject, "level_name", user.level_name);
            EditConfig editConfig = user.edit_config;
            if (editConfig != null) {
                qoc.a(jSONObject, "edit_config", trc.b(editConfig));
            }
            qoc.a(jSONObject, PmsConstant.Statistic.STATISTIC_IP, user.ip_address);
            qoc.a(jSONObject, "is_nickname_editing", user.is_nickname_editing);
            qoc.a(jSONObject, "editing_nickname", user.editing_nickname);
            VirtualImageInfo virtualImageInfo = user.virtual_image_info;
            if (virtualImageInfo != null) {
                qoc.a(jSONObject, "virtual_image_info", d6d.b(virtualImageInfo));
            }
            UserGrowth userGrowth = user.user_growth;
            if (userGrowth != null) {
                qoc.a(jSONObject, "user_growth", o5d.b(userGrowth));
            }
            qoc.a(jSONObject, "display_intro", user.display_intro);
            if (user.new_icon_url != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (String str : user.new_icon_url) {
                    jSONArray12.put(str);
                }
                qoc.a(jSONObject, "new_icon_url", jSONArray12);
            }
            qoc.a(jSONObject, "dynamic_url", user.dynamic_url);
            ThemeTailInUser themeTailInUser = user.theme_tail;
            if (themeTailInUser != null) {
                qoc.a(jSONObject, "theme_tail", t4d.b(themeTailInUser));
            }
            ThemeBackgroundInUser themeBackgroundInUser = user.theme_background;
            if (themeBackgroundInUser != null) {
                qoc.a(jSONObject, "theme_background", n4d.b(themeBackgroundInUser));
            }
            ThemeMyTab themeMyTab = user.theme_my_tab;
            if (themeMyTab != null) {
                qoc.a(jSONObject, "theme_my_tab", s4d.b(themeMyTab));
            }
            WorldCupInfo worldCupInfo = user.world_cup_info;
            if (worldCupInfo != null) {
                qoc.a(jSONObject, "world_cup_info", n6d.b(worldCupInfo));
            }
            ShakeAdSwitch shakeAdSwitch = user.shake_ad_switch;
            if (shakeAdSwitch != null) {
                qoc.a(jSONObject, "shake_ad_switch", z2d.b(shakeAdSwitch));
            }
            if (user.pendants != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (String str2 : user.pendants) {
                    jSONArray13.put(str2);
                }
                qoc.a(jSONObject, "pendants", jSONArray13);
            }
            qoc.a(jSONObject, "ios_b_url", user.ios_b_url);
            qoc.a(jSONObject, "pa", user.pa);
            qoc.a(jSONObject, "enable_new_homepage", user.enable_new_homepage);
            qoc.a(jSONObject, "target_scheme", user.target_scheme);
            if (user.tags != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (TagsInfo tagsInfo : user.tags) {
                    jSONArray14.put(g4d.b(tagsInfo));
                }
                qoc.a(jSONObject, "tags", jSONArray14);
            }
            qoc.a(jSONObject, "avatar_url", user.avatar_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
