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
public class pad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, user)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "is_login", user.is_login);
            ktc.a(jSONObject, "id", user.id);
            ktc.a(jSONObject, "name", user.name);
            ktc.a(jSONObject, "name_show", user.name_show);
            ktc.a(jSONObject, "portrait", user.portrait);
            ktc.a(jSONObject, "no_un", user.no_un);
            ktc.a(jSONObject, "type", user.type);
            NewUser newUser = user.new_user_info;
            if (newUser != null) {
                ktc.a(jSONObject, "new_user_info", m5d.b(newUser));
            }
            ktc.a(jSONObject, "userhide", user.userhide);
            Balv balv = user.balv;
            if (balv != null) {
                ktc.a(jSONObject, "balv", avc.b(balv));
            }
            ktc.a(jSONObject, "is_manager", user.is_manager);
            ktc.a(jSONObject, MultiRatePlayUrlHelper.RANK, user.rank);
            ktc.a(jSONObject, "bimg_url", user.bimg_url);
            ktc.a(jSONObject, "meizhi_level", user.meizhi_level);
            ktc.a(jSONObject, "is_verify", user.is_verify);
            ktc.a(jSONObject, "is_interestman", user.is_interestman);
            if (user.iconinfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (Icon icon : user.iconinfo) {
                    jSONArray.put(y3d.b(icon));
                }
                ktc.a(jSONObject, "iconinfo", jSONArray);
            }
            if (user.tshow_icon != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TshowInfo tshowInfo : user.tshow_icon) {
                    jSONArray2.put(lad.b(tshowInfo));
                }
                ktc.a(jSONObject, "tshow_icon", jSONArray2);
            }
            ktc.a(jSONObject, "user_type", user.user_type);
            ktc.a(jSONObject, "is_coreuser", user.is_coreuser);
            ktc.a(jSONObject, "is_huinibuke", user.is_huinibuke);
            ktc.a(jSONObject, "ios_bimg_format", user.ios_bimg_format);
            ktc.a(jSONObject, "level_id", user.level_id);
            ktc.a(jSONObject, "is_like", user.is_like);
            ktc.a(jSONObject, "is_bawu", user.is_bawu);
            ktc.a(jSONObject, "bawu_type", user.bawu_type);
            ktc.a(jSONObject, "portraith", user.portraith);
            ktc.a(jSONObject, "ip", user.ip);
            ktc.a(jSONObject, HttpRequest.BDUSS, user.BDUSS);
            ktc.a(jSONObject, PersonInfoActivityConfig.FANS_NUM, user.fans_num);
            ktc.a(jSONObject, "concern_num", user.concern_num);
            ktc.a(jSONObject, "sex", user.sex);
            ktc.a(jSONObject, "my_like_num", user.my_like_num);
            ktc.a(jSONObject, "intro", user.intro);
            ktc.a(jSONObject, "has_concerned", user.has_concerned);
            ktc.a(jSONObject, "passwd", user.passwd);
            ktc.a(jSONObject, "post_num", user.post_num);
            ktc.a(jSONObject, "tb_age", user.tb_age);
            ktc.a(jSONObject, "is_mem", user.is_mem);
            ktc.a(jSONObject, "bimg_end_time", user.bimg_end_time);
            PayMemberInfo payMemberInfo = user.pay_member_info;
            if (payMemberInfo != null) {
                ktc.a(jSONObject, "pay_member_info", y5d.b(payMemberInfo));
            }
            ktc.a(jSONObject, "gender", user.gender);
            ktc.a(jSONObject, "is_mask", user.is_mask);
            if (user.user_pics != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (UserPics userPics : user.user_pics) {
                    jSONArray3.put(rad.b(userPics));
                }
                ktc.a(jSONObject, "user_pics", jSONArray3);
            }
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                ktc.a(jSONObject, "priv_sets", u6d.b(privSets));
            }
            ktc.a(jSONObject, "is_friend", user.is_friend);
            if (user.likeForum != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (LikeForumInfo likeForumInfo : user.likeForum) {
                    jSONArray4.put(q4d.b(likeForumInfo));
                }
                ktc.a(jSONObject, "likeForum", jSONArray4);
            }
            if (user.groupList != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (MyGroupInfo myGroupInfo : user.groupList) {
                    jSONArray5.put(h5d.b(myGroupInfo));
                }
                ktc.a(jSONObject, "groupList", jSONArray5);
            }
            ktc.a(jSONObject, "gift_num", user.gift_num);
            if (user.gift_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GiftInfo giftInfo : user.gift_list) {
                    jSONArray6.put(o3d.b(giftInfo));
                }
                ktc.a(jSONObject, "gift_list", jSONArray6);
            }
            ktc.a(jSONObject, "is_select_tail", user.is_select_tail);
            ktc.a(jSONObject, "is_guanfang", user.is_guanfang);
            ktc.a(jSONObject, "bookmark_count", user.bookmark_count);
            ktc.a(jSONObject, "bookmark_new_count", user.bookmark_new_count);
            if (user.mute_user != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (SimpleUser simpleUser : user.mute_user) {
                    jSONArray7.put(k8d.b(simpleUser));
                }
                ktc.a(jSONObject, "mute_user", jSONArray7);
            }
            ktc.a(jSONObject, "friend_num", user.friend_num);
            ktc.a(jSONObject, "fans_nickname", user.fans_nickname);
            ktc.a(jSONObject, "bg_pic", user.bg_pic);
            NewParrScores newParrScores = user.parr_scores;
            if (newParrScores != null) {
                ktc.a(jSONObject, "parr_scores", l5d.b(newParrScores));
            }
            NovelFansInfo novelFansInfo = user.novel_fans_info;
            if (novelFansInfo != null) {
                ktc.a(jSONObject, "novel_fans_info", q5d.b(novelFansInfo));
            }
            UserVipInfo userVipInfo = user.vipInfo;
            if (userVipInfo != null) {
                ktc.a(jSONObject, "vipInfo", wad.b(userVipInfo));
            }
            GodInfo godInfo = user.god_data;
            if (godInfo != null) {
                ktc.a(jSONObject, "god_data", q3d.b(godInfo));
            }
            ktc.a(jSONObject, "heavy_user", user.heavy_user);
            VipShowInfo vipShowInfo = user.vip_show_info;
            if (vipShowInfo != null) {
                ktc.a(jSONObject, "vip_show_info", fbd.b(vipShowInfo));
            }
            if (user.new_tshow_icon != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (TshowInfo tshowInfo2 : user.new_tshow_icon) {
                    jSONArray8.put(lad.b(tshowInfo2));
                }
                ktc.a(jSONObject, "new_tshow_icon", jSONArray8);
            }
            TwZhiBoUser twZhiBoUser = user.tw_anchor_info;
            if (twZhiBoUser != null) {
                ktc.a(jSONObject, "tw_anchor_info", nad.b(twZhiBoUser));
            }
            if (user.profit_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (TwAnchorProfitItem twAnchorProfitItem : user.profit_list) {
                    jSONArray9.put(mad.b(twAnchorProfitItem));
                }
                ktc.a(jSONObject, "profit_list", jSONArray9);
            }
            ConsumeInfo consumeInfo = user.consume_info;
            if (consumeInfo != null) {
                ktc.a(jSONObject, "consume_info", cwc.b(consumeInfo));
            }
            ThemeCardInUser themeCardInUser = user.theme_card;
            if (themeCardInUser != null) {
                ktc.a(jSONObject, "theme_card", r9d.b(themeCardInUser));
            }
            VipCloseAd vipCloseAd = user.vip_close_ad;
            if (vipCloseAd != null) {
                ktc.a(jSONObject, "vip_close_ad", ebd.b(vipCloseAd));
            }
            ActivitySponsor activitySponsor = user.activity_sponsor;
            if (activitySponsor != null) {
                ktc.a(jSONObject, "activity_sponsor", utc.b(activitySponsor));
            }
            TbVipInfo tbVipInfo = user.tb_vip;
            if (tbVipInfo != null) {
                ktc.a(jSONObject, "tb_vip", l9d.b(tbVipInfo));
            }
            ktc.a(jSONObject, "no_post_high", user.no_post_high);
            Ecom ecom = user.ecom;
            if (ecom != null) {
                ktc.a(jSONObject, "ecom", pwc.b(ecom));
            }
            ktc.a(jSONObject, "visitor_num", user.visitor_num);
            ktc.a(jSONObject, "total_visitor_num", user.total_visitor_num);
            Pendant pendant = user.pendant;
            if (pendant != null) {
                ktc.a(jSONObject, "pendant", g6d.b(pendant));
            }
            AlaUserInfo alaUserInfo = user.ala_info;
            if (alaUserInfo != null) {
                ktc.a(jSONObject, "ala_info", luc.b(alaUserInfo));
            }
            ktc.a(jSONObject, "seal_prefix", user.seal_prefix);
            ktc.a(jSONObject, "has_bottle_enter", user.has_bottle_enter);
            UserVideoChannelInfo userVideoChannelInfo = user.video_channel_info;
            if (userVideoChannelInfo != null) {
                ktc.a(jSONObject, "video_channel_info", vad.b(userVideoChannelInfo));
            }
            SpringVirtualUser springVirtualUser = user.spring_virtual_user;
            if (springVirtualUser != null) {
                ktc.a(jSONObject, "spring_virtual_user", o8d.b(springVirtualUser));
            }
            ktc.a(jSONObject, "each_other_friend", user.each_other_friend);
            EsportInfo esportInfo = user.esport_data;
            if (esportInfo != null) {
                ktc.a(jSONObject, "esport_data", uwc.b(esportInfo));
            }
            AlaLiveInfo alaLiveInfo = user.ala_live_info;
            if (alaLiveInfo != null) {
                ktc.a(jSONObject, "ala_live_info", huc.b(alaLiveInfo));
            }
            ktc.a(jSONObject, "nickname_update_time", user.nickname_update_time);
            ktc.a(jSONObject, "thread_num", user.thread_num);
            ktc.a(jSONObject, "agree_num", user.agree_num);
            ktc.a(jSONObject, "left_call_num", user.left_call_num);
            ktc.a(jSONObject, "is_invited", user.is_invited);
            ktc.a(jSONObject, "is_fans", user.is_fans);
            ktc.a(jSONObject, "priv_thread", user.priv_thread);
            ktc.a(jSONObject, "is_videobiggie", user.is_videobiggie);
            ktc.a(jSONObject, "is_show_redpacket", user.is_show_redpacket);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            if (baijiahaoInfo != null) {
                ktc.a(jSONObject, "baijiahao_info", zuc.b(baijiahaoInfo));
            }
            BirthdayInfo birthdayInfo = user.birthday_info;
            if (birthdayInfo != null) {
                ktc.a(jSONObject, "birthday_info", gvc.b(birthdayInfo));
            }
            ktc.a(jSONObject, "can_modify_avatar", user.can_modify_avatar);
            ktc.a(jSONObject, "modify_avatar_desc", user.modify_avatar_desc);
            ktc.a(jSONObject, "influence", user.influence);
            ktc.a(jSONObject, "level_influence", user.level_influence);
            NewGodInfo newGodInfo = user.new_god_data;
            if (newGodInfo != null) {
                ktc.a(jSONObject, "new_god_data", k5d.b(newGodInfo));
            }
            BawuThrones bawuThrones = user.bawu_thrones;
            if (bawuThrones != null) {
                ktc.a(jSONObject, "bawu_thrones", evc.b(bawuThrones));
            }
            CallFansInfo callFansInfo = user.call_fans_info;
            if (callFansInfo != null) {
                ktc.a(jSONObject, "call_fans_info", ovc.b(callFansInfo));
            }
            BazhuSign bazhuSign = user.bazhu_grade;
            if (bazhuSign != null) {
                ktc.a(jSONObject, "bazhu_grade", fvc.b(bazhuSign));
            }
            ktc.a(jSONObject, "is_default_avatar", user.is_default_avatar);
            ktc.a(jSONObject, "uk", user.uk);
            CreationData creationData = user.creation_data;
            if (creationData != null) {
                ktc.a(jSONObject, "creation_data", dwc.b(creationData));
            }
            ktc.a(jSONObject, "favorite_num", user.favorite_num);
            LiveRoomInfo liveRoomInfo = user.live_room_info;
            if (liveRoomInfo != null) {
                ktc.a(jSONObject, "live_room_info", w4d.b(liveRoomInfo));
            }
            BusinessAccountInfo businessAccountInfo = user.business_account_info;
            if (businessAccountInfo != null) {
                ktc.a(jSONObject, "business_account_info", mvc.b(businessAccountInfo));
            }
            ktc.a(jSONObject, "appeal_thread_popover", user.appeal_thread_popover);
            if (user.forum_tool_auth != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ForumToolPerm forumToolPerm : user.forum_tool_auth) {
                    jSONArray10.put(oyc.b(forumToolPerm));
                }
                ktc.a(jSONObject, "forum_tool_auth", jSONArray10);
            }
            ktc.a(jSONObject, "work_num", user.work_num);
            ktc.a(jSONObject, "show_pb_private_flag", user.show_pb_private_flag);
            ktc.a(jSONObject, "total_agree_num", user.total_agree_num);
            CreationData creationData2 = user.workcreation_data;
            if (creationData2 != null) {
                ktc.a(jSONObject, "workcreation_data", dwc.b(creationData2));
            }
            ktc.a(jSONObject, "tieba_uid", user.tieba_uid);
            ktc.a(jSONObject, "follow_from", user.follow_from);
            if (user.manager_forum != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BazhuSign bazhuSign2 : user.manager_forum) {
                    jSONArray11.put(fvc.b(bazhuSign2));
                }
                ktc.a(jSONObject, "manager_forum", jSONArray11);
            }
            ktc.a(jSONObject, "display_auth_type", user.display_auth_type);
            WorkCreatorInfo workCreatorInfo = user.work_creator_info;
            if (workCreatorInfo != null) {
                ktc.a(jSONObject, "work_creator_info", obd.b(workCreatorInfo));
            }
            ktc.a(jSONObject, "level_name", user.level_name);
            EditConfig editConfig = user.edit_config;
            if (editConfig != null) {
                ktc.a(jSONObject, "edit_config", qwc.b(editConfig));
            }
            ktc.a(jSONObject, PmsConstant.Statistic.STATISTIC_IP, user.ip_address);
            ktc.a(jSONObject, "is_nickname_editing", user.is_nickname_editing);
            ktc.a(jSONObject, "editing_nickname", user.editing_nickname);
            VirtualImageInfo virtualImageInfo = user.virtual_image_info;
            if (virtualImageInfo != null) {
                ktc.a(jSONObject, "virtual_image_info", gbd.b(virtualImageInfo));
            }
            UserGrowth userGrowth = user.user_growth;
            if (userGrowth != null) {
                ktc.a(jSONObject, "user_growth", qad.b(userGrowth));
            }
            ktc.a(jSONObject, "display_intro", user.display_intro);
            if (user.new_icon_url != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (String str : user.new_icon_url) {
                    jSONArray12.put(str);
                }
                ktc.a(jSONObject, "new_icon_url", jSONArray12);
            }
            ktc.a(jSONObject, "dynamic_url", user.dynamic_url);
            ThemeTailInUser themeTailInUser = user.theme_tail;
            if (themeTailInUser != null) {
                ktc.a(jSONObject, "theme_tail", v9d.b(themeTailInUser));
            }
            ThemeBackgroundInUser themeBackgroundInUser = user.theme_background;
            if (themeBackgroundInUser != null) {
                ktc.a(jSONObject, "theme_background", p9d.b(themeBackgroundInUser));
            }
            ThemeMyTab themeMyTab = user.theme_my_tab;
            if (themeMyTab != null) {
                ktc.a(jSONObject, "theme_my_tab", u9d.b(themeMyTab));
            }
            WorldCupInfo worldCupInfo = user.world_cup_info;
            if (worldCupInfo != null) {
                ktc.a(jSONObject, "world_cup_info", qbd.b(worldCupInfo));
            }
            ShakeAdSwitch shakeAdSwitch = user.shake_ad_switch;
            if (shakeAdSwitch != null) {
                ktc.a(jSONObject, "shake_ad_switch", b8d.b(shakeAdSwitch));
            }
            if (user.pendants != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (String str2 : user.pendants) {
                    jSONArray13.put(str2);
                }
                ktc.a(jSONObject, "pendants", jSONArray13);
            }
            ktc.a(jSONObject, "ios_b_url", user.ios_b_url);
            ktc.a(jSONObject, "pa", user.pa);
            ktc.a(jSONObject, "enable_new_homepage", user.enable_new_homepage);
            ktc.a(jSONObject, "target_scheme", user.target_scheme);
            if (user.tags != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (TagsInfo tagsInfo : user.tags) {
                    jSONArray14.put(i9d.b(tagsInfo));
                }
                ktc.a(jSONObject, "tags", jSONArray14);
            }
            ktc.a(jSONObject, "avatar_url", user.avatar_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
