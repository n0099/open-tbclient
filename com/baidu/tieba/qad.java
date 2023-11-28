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
public class qad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, user)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_login", user.is_login);
            ltc.a(jSONObject, "id", user.id);
            ltc.a(jSONObject, "name", user.name);
            ltc.a(jSONObject, "name_show", user.name_show);
            ltc.a(jSONObject, "portrait", user.portrait);
            ltc.a(jSONObject, "no_un", user.no_un);
            ltc.a(jSONObject, "type", user.type);
            NewUser newUser = user.new_user_info;
            if (newUser != null) {
                ltc.a(jSONObject, "new_user_info", n5d.b(newUser));
            }
            ltc.a(jSONObject, "userhide", user.userhide);
            Balv balv = user.balv;
            if (balv != null) {
                ltc.a(jSONObject, "balv", bvc.b(balv));
            }
            ltc.a(jSONObject, "is_manager", user.is_manager);
            ltc.a(jSONObject, MultiRatePlayUrlHelper.RANK, user.rank);
            ltc.a(jSONObject, "bimg_url", user.bimg_url);
            ltc.a(jSONObject, "meizhi_level", user.meizhi_level);
            ltc.a(jSONObject, "is_verify", user.is_verify);
            ltc.a(jSONObject, "is_interestman", user.is_interestman);
            if (user.iconinfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (Icon icon : user.iconinfo) {
                    jSONArray.put(z3d.b(icon));
                }
                ltc.a(jSONObject, "iconinfo", jSONArray);
            }
            if (user.tshow_icon != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TshowInfo tshowInfo : user.tshow_icon) {
                    jSONArray2.put(mad.b(tshowInfo));
                }
                ltc.a(jSONObject, "tshow_icon", jSONArray2);
            }
            ltc.a(jSONObject, "user_type", user.user_type);
            ltc.a(jSONObject, "is_coreuser", user.is_coreuser);
            ltc.a(jSONObject, "is_huinibuke", user.is_huinibuke);
            ltc.a(jSONObject, "ios_bimg_format", user.ios_bimg_format);
            ltc.a(jSONObject, "level_id", user.level_id);
            ltc.a(jSONObject, "is_like", user.is_like);
            ltc.a(jSONObject, "is_bawu", user.is_bawu);
            ltc.a(jSONObject, "bawu_type", user.bawu_type);
            ltc.a(jSONObject, "portraith", user.portraith);
            ltc.a(jSONObject, "ip", user.ip);
            ltc.a(jSONObject, HttpRequest.BDUSS, user.BDUSS);
            ltc.a(jSONObject, PersonInfoActivityConfig.FANS_NUM, user.fans_num);
            ltc.a(jSONObject, "concern_num", user.concern_num);
            ltc.a(jSONObject, "sex", user.sex);
            ltc.a(jSONObject, "my_like_num", user.my_like_num);
            ltc.a(jSONObject, "intro", user.intro);
            ltc.a(jSONObject, "has_concerned", user.has_concerned);
            ltc.a(jSONObject, "passwd", user.passwd);
            ltc.a(jSONObject, "post_num", user.post_num);
            ltc.a(jSONObject, "tb_age", user.tb_age);
            ltc.a(jSONObject, "is_mem", user.is_mem);
            ltc.a(jSONObject, "bimg_end_time", user.bimg_end_time);
            PayMemberInfo payMemberInfo = user.pay_member_info;
            if (payMemberInfo != null) {
                ltc.a(jSONObject, "pay_member_info", z5d.b(payMemberInfo));
            }
            ltc.a(jSONObject, "gender", user.gender);
            ltc.a(jSONObject, "is_mask", user.is_mask);
            if (user.user_pics != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (UserPics userPics : user.user_pics) {
                    jSONArray3.put(sad.b(userPics));
                }
                ltc.a(jSONObject, "user_pics", jSONArray3);
            }
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                ltc.a(jSONObject, "priv_sets", v6d.b(privSets));
            }
            ltc.a(jSONObject, "is_friend", user.is_friend);
            if (user.likeForum != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (LikeForumInfo likeForumInfo : user.likeForum) {
                    jSONArray4.put(r4d.b(likeForumInfo));
                }
                ltc.a(jSONObject, "likeForum", jSONArray4);
            }
            if (user.groupList != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (MyGroupInfo myGroupInfo : user.groupList) {
                    jSONArray5.put(i5d.b(myGroupInfo));
                }
                ltc.a(jSONObject, "groupList", jSONArray5);
            }
            ltc.a(jSONObject, "gift_num", user.gift_num);
            if (user.gift_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GiftInfo giftInfo : user.gift_list) {
                    jSONArray6.put(p3d.b(giftInfo));
                }
                ltc.a(jSONObject, "gift_list", jSONArray6);
            }
            ltc.a(jSONObject, "is_select_tail", user.is_select_tail);
            ltc.a(jSONObject, "is_guanfang", user.is_guanfang);
            ltc.a(jSONObject, "bookmark_count", user.bookmark_count);
            ltc.a(jSONObject, "bookmark_new_count", user.bookmark_new_count);
            if (user.mute_user != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (SimpleUser simpleUser : user.mute_user) {
                    jSONArray7.put(l8d.b(simpleUser));
                }
                ltc.a(jSONObject, "mute_user", jSONArray7);
            }
            ltc.a(jSONObject, "friend_num", user.friend_num);
            ltc.a(jSONObject, "fans_nickname", user.fans_nickname);
            ltc.a(jSONObject, "bg_pic", user.bg_pic);
            NewParrScores newParrScores = user.parr_scores;
            if (newParrScores != null) {
                ltc.a(jSONObject, "parr_scores", m5d.b(newParrScores));
            }
            NovelFansInfo novelFansInfo = user.novel_fans_info;
            if (novelFansInfo != null) {
                ltc.a(jSONObject, "novel_fans_info", r5d.b(novelFansInfo));
            }
            UserVipInfo userVipInfo = user.vipInfo;
            if (userVipInfo != null) {
                ltc.a(jSONObject, "vipInfo", xad.b(userVipInfo));
            }
            GodInfo godInfo = user.god_data;
            if (godInfo != null) {
                ltc.a(jSONObject, "god_data", r3d.b(godInfo));
            }
            ltc.a(jSONObject, "heavy_user", user.heavy_user);
            VipShowInfo vipShowInfo = user.vip_show_info;
            if (vipShowInfo != null) {
                ltc.a(jSONObject, "vip_show_info", gbd.b(vipShowInfo));
            }
            if (user.new_tshow_icon != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (TshowInfo tshowInfo2 : user.new_tshow_icon) {
                    jSONArray8.put(mad.b(tshowInfo2));
                }
                ltc.a(jSONObject, "new_tshow_icon", jSONArray8);
            }
            TwZhiBoUser twZhiBoUser = user.tw_anchor_info;
            if (twZhiBoUser != null) {
                ltc.a(jSONObject, "tw_anchor_info", oad.b(twZhiBoUser));
            }
            if (user.profit_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (TwAnchorProfitItem twAnchorProfitItem : user.profit_list) {
                    jSONArray9.put(nad.b(twAnchorProfitItem));
                }
                ltc.a(jSONObject, "profit_list", jSONArray9);
            }
            ConsumeInfo consumeInfo = user.consume_info;
            if (consumeInfo != null) {
                ltc.a(jSONObject, "consume_info", dwc.b(consumeInfo));
            }
            ThemeCardInUser themeCardInUser = user.theme_card;
            if (themeCardInUser != null) {
                ltc.a(jSONObject, "theme_card", s9d.b(themeCardInUser));
            }
            VipCloseAd vipCloseAd = user.vip_close_ad;
            if (vipCloseAd != null) {
                ltc.a(jSONObject, "vip_close_ad", fbd.b(vipCloseAd));
            }
            ActivitySponsor activitySponsor = user.activity_sponsor;
            if (activitySponsor != null) {
                ltc.a(jSONObject, "activity_sponsor", vtc.b(activitySponsor));
            }
            TbVipInfo tbVipInfo = user.tb_vip;
            if (tbVipInfo != null) {
                ltc.a(jSONObject, "tb_vip", m9d.b(tbVipInfo));
            }
            ltc.a(jSONObject, "no_post_high", user.no_post_high);
            Ecom ecom = user.ecom;
            if (ecom != null) {
                ltc.a(jSONObject, "ecom", qwc.b(ecom));
            }
            ltc.a(jSONObject, "visitor_num", user.visitor_num);
            ltc.a(jSONObject, "total_visitor_num", user.total_visitor_num);
            Pendant pendant = user.pendant;
            if (pendant != null) {
                ltc.a(jSONObject, "pendant", h6d.b(pendant));
            }
            AlaUserInfo alaUserInfo = user.ala_info;
            if (alaUserInfo != null) {
                ltc.a(jSONObject, "ala_info", muc.b(alaUserInfo));
            }
            ltc.a(jSONObject, "seal_prefix", user.seal_prefix);
            ltc.a(jSONObject, "has_bottle_enter", user.has_bottle_enter);
            UserVideoChannelInfo userVideoChannelInfo = user.video_channel_info;
            if (userVideoChannelInfo != null) {
                ltc.a(jSONObject, "video_channel_info", wad.b(userVideoChannelInfo));
            }
            SpringVirtualUser springVirtualUser = user.spring_virtual_user;
            if (springVirtualUser != null) {
                ltc.a(jSONObject, "spring_virtual_user", p8d.b(springVirtualUser));
            }
            ltc.a(jSONObject, "each_other_friend", user.each_other_friend);
            EsportInfo esportInfo = user.esport_data;
            if (esportInfo != null) {
                ltc.a(jSONObject, "esport_data", vwc.b(esportInfo));
            }
            AlaLiveInfo alaLiveInfo = user.ala_live_info;
            if (alaLiveInfo != null) {
                ltc.a(jSONObject, "ala_live_info", iuc.b(alaLiveInfo));
            }
            ltc.a(jSONObject, "nickname_update_time", user.nickname_update_time);
            ltc.a(jSONObject, "thread_num", user.thread_num);
            ltc.a(jSONObject, "agree_num", user.agree_num);
            ltc.a(jSONObject, "left_call_num", user.left_call_num);
            ltc.a(jSONObject, "is_invited", user.is_invited);
            ltc.a(jSONObject, "is_fans", user.is_fans);
            ltc.a(jSONObject, "priv_thread", user.priv_thread);
            ltc.a(jSONObject, "is_videobiggie", user.is_videobiggie);
            ltc.a(jSONObject, "is_show_redpacket", user.is_show_redpacket);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            if (baijiahaoInfo != null) {
                ltc.a(jSONObject, "baijiahao_info", avc.b(baijiahaoInfo));
            }
            BirthdayInfo birthdayInfo = user.birthday_info;
            if (birthdayInfo != null) {
                ltc.a(jSONObject, "birthday_info", hvc.b(birthdayInfo));
            }
            ltc.a(jSONObject, "can_modify_avatar", user.can_modify_avatar);
            ltc.a(jSONObject, "modify_avatar_desc", user.modify_avatar_desc);
            ltc.a(jSONObject, "influence", user.influence);
            ltc.a(jSONObject, "level_influence", user.level_influence);
            NewGodInfo newGodInfo = user.new_god_data;
            if (newGodInfo != null) {
                ltc.a(jSONObject, "new_god_data", l5d.b(newGodInfo));
            }
            BawuThrones bawuThrones = user.bawu_thrones;
            if (bawuThrones != null) {
                ltc.a(jSONObject, "bawu_thrones", fvc.b(bawuThrones));
            }
            CallFansInfo callFansInfo = user.call_fans_info;
            if (callFansInfo != null) {
                ltc.a(jSONObject, "call_fans_info", pvc.b(callFansInfo));
            }
            BazhuSign bazhuSign = user.bazhu_grade;
            if (bazhuSign != null) {
                ltc.a(jSONObject, "bazhu_grade", gvc.b(bazhuSign));
            }
            ltc.a(jSONObject, "is_default_avatar", user.is_default_avatar);
            ltc.a(jSONObject, "uk", user.uk);
            CreationData creationData = user.creation_data;
            if (creationData != null) {
                ltc.a(jSONObject, "creation_data", ewc.b(creationData));
            }
            ltc.a(jSONObject, "favorite_num", user.favorite_num);
            LiveRoomInfo liveRoomInfo = user.live_room_info;
            if (liveRoomInfo != null) {
                ltc.a(jSONObject, "live_room_info", x4d.b(liveRoomInfo));
            }
            BusinessAccountInfo businessAccountInfo = user.business_account_info;
            if (businessAccountInfo != null) {
                ltc.a(jSONObject, "business_account_info", nvc.b(businessAccountInfo));
            }
            ltc.a(jSONObject, "appeal_thread_popover", user.appeal_thread_popover);
            if (user.forum_tool_auth != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ForumToolPerm forumToolPerm : user.forum_tool_auth) {
                    jSONArray10.put(pyc.b(forumToolPerm));
                }
                ltc.a(jSONObject, "forum_tool_auth", jSONArray10);
            }
            ltc.a(jSONObject, "work_num", user.work_num);
            ltc.a(jSONObject, "show_pb_private_flag", user.show_pb_private_flag);
            ltc.a(jSONObject, "total_agree_num", user.total_agree_num);
            CreationData creationData2 = user.workcreation_data;
            if (creationData2 != null) {
                ltc.a(jSONObject, "workcreation_data", ewc.b(creationData2));
            }
            ltc.a(jSONObject, "tieba_uid", user.tieba_uid);
            ltc.a(jSONObject, "follow_from", user.follow_from);
            if (user.manager_forum != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BazhuSign bazhuSign2 : user.manager_forum) {
                    jSONArray11.put(gvc.b(bazhuSign2));
                }
                ltc.a(jSONObject, "manager_forum", jSONArray11);
            }
            ltc.a(jSONObject, "display_auth_type", user.display_auth_type);
            WorkCreatorInfo workCreatorInfo = user.work_creator_info;
            if (workCreatorInfo != null) {
                ltc.a(jSONObject, "work_creator_info", pbd.b(workCreatorInfo));
            }
            ltc.a(jSONObject, "level_name", user.level_name);
            EditConfig editConfig = user.edit_config;
            if (editConfig != null) {
                ltc.a(jSONObject, "edit_config", rwc.b(editConfig));
            }
            ltc.a(jSONObject, PmsConstant.Statistic.STATISTIC_IP, user.ip_address);
            ltc.a(jSONObject, "is_nickname_editing", user.is_nickname_editing);
            ltc.a(jSONObject, "editing_nickname", user.editing_nickname);
            VirtualImageInfo virtualImageInfo = user.virtual_image_info;
            if (virtualImageInfo != null) {
                ltc.a(jSONObject, "virtual_image_info", hbd.b(virtualImageInfo));
            }
            UserGrowth userGrowth = user.user_growth;
            if (userGrowth != null) {
                ltc.a(jSONObject, "user_growth", rad.b(userGrowth));
            }
            ltc.a(jSONObject, "display_intro", user.display_intro);
            if (user.new_icon_url != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (String str : user.new_icon_url) {
                    jSONArray12.put(str);
                }
                ltc.a(jSONObject, "new_icon_url", jSONArray12);
            }
            ltc.a(jSONObject, "dynamic_url", user.dynamic_url);
            ThemeTailInUser themeTailInUser = user.theme_tail;
            if (themeTailInUser != null) {
                ltc.a(jSONObject, "theme_tail", w9d.b(themeTailInUser));
            }
            ThemeBackgroundInUser themeBackgroundInUser = user.theme_background;
            if (themeBackgroundInUser != null) {
                ltc.a(jSONObject, "theme_background", q9d.b(themeBackgroundInUser));
            }
            ThemeMyTab themeMyTab = user.theme_my_tab;
            if (themeMyTab != null) {
                ltc.a(jSONObject, "theme_my_tab", v9d.b(themeMyTab));
            }
            WorldCupInfo worldCupInfo = user.world_cup_info;
            if (worldCupInfo != null) {
                ltc.a(jSONObject, "world_cup_info", rbd.b(worldCupInfo));
            }
            ShakeAdSwitch shakeAdSwitch = user.shake_ad_switch;
            if (shakeAdSwitch != null) {
                ltc.a(jSONObject, "shake_ad_switch", c8d.b(shakeAdSwitch));
            }
            if (user.pendants != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (String str2 : user.pendants) {
                    jSONArray13.put(str2);
                }
                ltc.a(jSONObject, "pendants", jSONArray13);
            }
            ltc.a(jSONObject, "ios_b_url", user.ios_b_url);
            ltc.a(jSONObject, "pa", user.pa);
            ltc.a(jSONObject, "enable_new_homepage", user.enable_new_homepage);
            ltc.a(jSONObject, "target_scheme", user.target_scheme);
            if (user.tags != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (TagsInfo tagsInfo : user.tags) {
                    jSONArray14.put(j9d.b(tagsInfo));
                }
                ltc.a(jSONObject, "tags", jSONArray14);
            }
            ltc.a(jSONObject, "avatar_url", user.avatar_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
