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
public class m5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull User user) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, user)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "is_login", user.is_login);
            poc.a(jSONObject, "id", user.id);
            poc.a(jSONObject, "name", user.name);
            poc.a(jSONObject, "name_show", user.name_show);
            poc.a(jSONObject, "portrait", user.portrait);
            poc.a(jSONObject, "no_un", user.no_un);
            poc.a(jSONObject, "type", user.type);
            NewUser newUser = user.new_user_info;
            if (newUser != null) {
                poc.a(jSONObject, "new_user_info", j0d.b(newUser));
            }
            poc.a(jSONObject, "userhide", user.userhide);
            Balv balv = user.balv;
            if (balv != null) {
                poc.a(jSONObject, "balv", dqc.b(balv));
            }
            poc.a(jSONObject, "is_manager", user.is_manager);
            poc.a(jSONObject, MultiRatePlayUrlHelper.RANK, user.rank);
            poc.a(jSONObject, "bimg_url", user.bimg_url);
            poc.a(jSONObject, "meizhi_level", user.meizhi_level);
            poc.a(jSONObject, "is_verify", user.is_verify);
            poc.a(jSONObject, "is_interestman", user.is_interestman);
            if (user.iconinfo != null) {
                JSONArray jSONArray = new JSONArray();
                for (Icon icon : user.iconinfo) {
                    jSONArray.put(vyc.b(icon));
                }
                poc.a(jSONObject, "iconinfo", jSONArray);
            }
            if (user.tshow_icon != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (TshowInfo tshowInfo : user.tshow_icon) {
                    jSONArray2.put(i5d.b(tshowInfo));
                }
                poc.a(jSONObject, "tshow_icon", jSONArray2);
            }
            poc.a(jSONObject, "user_type", user.user_type);
            poc.a(jSONObject, "is_coreuser", user.is_coreuser);
            poc.a(jSONObject, "is_huinibuke", user.is_huinibuke);
            poc.a(jSONObject, "ios_bimg_format", user.ios_bimg_format);
            poc.a(jSONObject, "level_id", user.level_id);
            poc.a(jSONObject, "is_like", user.is_like);
            poc.a(jSONObject, "is_bawu", user.is_bawu);
            poc.a(jSONObject, "bawu_type", user.bawu_type);
            poc.a(jSONObject, "portraith", user.portraith);
            poc.a(jSONObject, "ip", user.ip);
            poc.a(jSONObject, HttpRequest.BDUSS, user.BDUSS);
            poc.a(jSONObject, PersonInfoActivityConfig.FANS_NUM, user.fans_num);
            poc.a(jSONObject, "concern_num", user.concern_num);
            poc.a(jSONObject, "sex", user.sex);
            poc.a(jSONObject, "my_like_num", user.my_like_num);
            poc.a(jSONObject, "intro", user.intro);
            poc.a(jSONObject, "has_concerned", user.has_concerned);
            poc.a(jSONObject, "passwd", user.passwd);
            poc.a(jSONObject, "post_num", user.post_num);
            poc.a(jSONObject, "tb_age", user.tb_age);
            poc.a(jSONObject, "is_mem", user.is_mem);
            poc.a(jSONObject, "bimg_end_time", user.bimg_end_time);
            PayMemberInfo payMemberInfo = user.pay_member_info;
            if (payMemberInfo != null) {
                poc.a(jSONObject, "pay_member_info", v0d.b(payMemberInfo));
            }
            poc.a(jSONObject, "gender", user.gender);
            poc.a(jSONObject, "is_mask", user.is_mask);
            if (user.user_pics != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (UserPics userPics : user.user_pics) {
                    jSONArray3.put(o5d.b(userPics));
                }
                poc.a(jSONObject, "user_pics", jSONArray3);
            }
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                poc.a(jSONObject, "priv_sets", r1d.b(privSets));
            }
            poc.a(jSONObject, "is_friend", user.is_friend);
            if (user.likeForum != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (LikeForumInfo likeForumInfo : user.likeForum) {
                    jSONArray4.put(nzc.b(likeForumInfo));
                }
                poc.a(jSONObject, "likeForum", jSONArray4);
            }
            if (user.groupList != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (MyGroupInfo myGroupInfo : user.groupList) {
                    jSONArray5.put(e0d.b(myGroupInfo));
                }
                poc.a(jSONObject, "groupList", jSONArray5);
            }
            poc.a(jSONObject, "gift_num", user.gift_num);
            if (user.gift_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (GiftInfo giftInfo : user.gift_list) {
                    jSONArray6.put(lyc.b(giftInfo));
                }
                poc.a(jSONObject, "gift_list", jSONArray6);
            }
            poc.a(jSONObject, "is_select_tail", user.is_select_tail);
            poc.a(jSONObject, "is_guanfang", user.is_guanfang);
            poc.a(jSONObject, "bookmark_count", user.bookmark_count);
            poc.a(jSONObject, "bookmark_new_count", user.bookmark_new_count);
            if (user.mute_user != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (SimpleUser simpleUser : user.mute_user) {
                    jSONArray7.put(h3d.b(simpleUser));
                }
                poc.a(jSONObject, "mute_user", jSONArray7);
            }
            poc.a(jSONObject, "friend_num", user.friend_num);
            poc.a(jSONObject, "fans_nickname", user.fans_nickname);
            poc.a(jSONObject, "bg_pic", user.bg_pic);
            NewParrScores newParrScores = user.parr_scores;
            if (newParrScores != null) {
                poc.a(jSONObject, "parr_scores", i0d.b(newParrScores));
            }
            NovelFansInfo novelFansInfo = user.novel_fans_info;
            if (novelFansInfo != null) {
                poc.a(jSONObject, "novel_fans_info", n0d.b(novelFansInfo));
            }
            UserVipInfo userVipInfo = user.vipInfo;
            if (userVipInfo != null) {
                poc.a(jSONObject, "vipInfo", t5d.b(userVipInfo));
            }
            GodInfo godInfo = user.god_data;
            if (godInfo != null) {
                poc.a(jSONObject, "god_data", nyc.b(godInfo));
            }
            poc.a(jSONObject, "heavy_user", user.heavy_user);
            VipShowInfo vipShowInfo = user.vip_show_info;
            if (vipShowInfo != null) {
                poc.a(jSONObject, "vip_show_info", b6d.b(vipShowInfo));
            }
            if (user.new_tshow_icon != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (TshowInfo tshowInfo2 : user.new_tshow_icon) {
                    jSONArray8.put(i5d.b(tshowInfo2));
                }
                poc.a(jSONObject, "new_tshow_icon", jSONArray8);
            }
            TwZhiBoUser twZhiBoUser = user.tw_anchor_info;
            if (twZhiBoUser != null) {
                poc.a(jSONObject, "tw_anchor_info", k5d.b(twZhiBoUser));
            }
            if (user.profit_list != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (TwAnchorProfitItem twAnchorProfitItem : user.profit_list) {
                    jSONArray9.put(j5d.b(twAnchorProfitItem));
                }
                poc.a(jSONObject, "profit_list", jSONArray9);
            }
            ConsumeInfo consumeInfo = user.consume_info;
            if (consumeInfo != null) {
                poc.a(jSONObject, "consume_info", erc.b(consumeInfo));
            }
            ThemeCardInUser themeCardInUser = user.theme_card;
            if (themeCardInUser != null) {
                poc.a(jSONObject, "theme_card", o4d.b(themeCardInUser));
            }
            VipCloseAd vipCloseAd = user.vip_close_ad;
            if (vipCloseAd != null) {
                poc.a(jSONObject, "vip_close_ad", a6d.b(vipCloseAd));
            }
            ActivitySponsor activitySponsor = user.activity_sponsor;
            if (activitySponsor != null) {
                poc.a(jSONObject, "activity_sponsor", zoc.b(activitySponsor));
            }
            TbVipInfo tbVipInfo = user.tb_vip;
            if (tbVipInfo != null) {
                poc.a(jSONObject, "tb_vip", i4d.b(tbVipInfo));
            }
            poc.a(jSONObject, "no_post_high", user.no_post_high);
            Ecom ecom = user.ecom;
            if (ecom != null) {
                poc.a(jSONObject, "ecom", rrc.b(ecom));
            }
            poc.a(jSONObject, "visitor_num", user.visitor_num);
            poc.a(jSONObject, "total_visitor_num", user.total_visitor_num);
            Pendant pendant = user.pendant;
            if (pendant != null) {
                poc.a(jSONObject, "pendant", d1d.b(pendant));
            }
            AlaUserInfo alaUserInfo = user.ala_info;
            if (alaUserInfo != null) {
                poc.a(jSONObject, "ala_info", opc.b(alaUserInfo));
            }
            poc.a(jSONObject, "seal_prefix", user.seal_prefix);
            poc.a(jSONObject, "has_bottle_enter", user.has_bottle_enter);
            UserVideoChannelInfo userVideoChannelInfo = user.video_channel_info;
            if (userVideoChannelInfo != null) {
                poc.a(jSONObject, "video_channel_info", s5d.b(userVideoChannelInfo));
            }
            SpringVirtualUser springVirtualUser = user.spring_virtual_user;
            if (springVirtualUser != null) {
                poc.a(jSONObject, "spring_virtual_user", l3d.b(springVirtualUser));
            }
            poc.a(jSONObject, "each_other_friend", user.each_other_friend);
            EsportInfo esportInfo = user.esport_data;
            if (esportInfo != null) {
                poc.a(jSONObject, "esport_data", wrc.b(esportInfo));
            }
            AlaLiveInfo alaLiveInfo = user.ala_live_info;
            if (alaLiveInfo != null) {
                poc.a(jSONObject, "ala_live_info", kpc.b(alaLiveInfo));
            }
            poc.a(jSONObject, "nickname_update_time", user.nickname_update_time);
            poc.a(jSONObject, "thread_num", user.thread_num);
            poc.a(jSONObject, "agree_num", user.agree_num);
            poc.a(jSONObject, "left_call_num", user.left_call_num);
            poc.a(jSONObject, "is_invited", user.is_invited);
            poc.a(jSONObject, "is_fans", user.is_fans);
            poc.a(jSONObject, "priv_thread", user.priv_thread);
            poc.a(jSONObject, "is_videobiggie", user.is_videobiggie);
            poc.a(jSONObject, "is_show_redpacket", user.is_show_redpacket);
            BaijiahaoInfo baijiahaoInfo = user.baijiahao_info;
            if (baijiahaoInfo != null) {
                poc.a(jSONObject, "baijiahao_info", cqc.b(baijiahaoInfo));
            }
            BirthdayInfo birthdayInfo = user.birthday_info;
            if (birthdayInfo != null) {
                poc.a(jSONObject, "birthday_info", jqc.b(birthdayInfo));
            }
            poc.a(jSONObject, "can_modify_avatar", user.can_modify_avatar);
            poc.a(jSONObject, "modify_avatar_desc", user.modify_avatar_desc);
            poc.a(jSONObject, "influence", user.influence);
            poc.a(jSONObject, "level_influence", user.level_influence);
            NewGodInfo newGodInfo = user.new_god_data;
            if (newGodInfo != null) {
                poc.a(jSONObject, "new_god_data", h0d.b(newGodInfo));
            }
            BawuThrones bawuThrones = user.bawu_thrones;
            if (bawuThrones != null) {
                poc.a(jSONObject, "bawu_thrones", hqc.b(bawuThrones));
            }
            CallFansInfo callFansInfo = user.call_fans_info;
            if (callFansInfo != null) {
                poc.a(jSONObject, "call_fans_info", qqc.b(callFansInfo));
            }
            BazhuSign bazhuSign = user.bazhu_grade;
            if (bazhuSign != null) {
                poc.a(jSONObject, "bazhu_grade", iqc.b(bazhuSign));
            }
            poc.a(jSONObject, "is_default_avatar", user.is_default_avatar);
            poc.a(jSONObject, "uk", user.uk);
            CreationData creationData = user.creation_data;
            if (creationData != null) {
                poc.a(jSONObject, "creation_data", frc.b(creationData));
            }
            poc.a(jSONObject, "favorite_num", user.favorite_num);
            LiveRoomInfo liveRoomInfo = user.live_room_info;
            if (liveRoomInfo != null) {
                poc.a(jSONObject, "live_room_info", tzc.b(liveRoomInfo));
            }
            BusinessAccountInfo businessAccountInfo = user.business_account_info;
            if (businessAccountInfo != null) {
                poc.a(jSONObject, "business_account_info", pqc.b(businessAccountInfo));
            }
            poc.a(jSONObject, "appeal_thread_popover", user.appeal_thread_popover);
            if (user.forum_tool_auth != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ForumToolPerm forumToolPerm : user.forum_tool_auth) {
                    jSONArray10.put(qtc.b(forumToolPerm));
                }
                poc.a(jSONObject, "forum_tool_auth", jSONArray10);
            }
            poc.a(jSONObject, "work_num", user.work_num);
            poc.a(jSONObject, "show_pb_private_flag", user.show_pb_private_flag);
            poc.a(jSONObject, "total_agree_num", user.total_agree_num);
            CreationData creationData2 = user.workcreation_data;
            if (creationData2 != null) {
                poc.a(jSONObject, "workcreation_data", frc.b(creationData2));
            }
            poc.a(jSONObject, "tieba_uid", user.tieba_uid);
            poc.a(jSONObject, "follow_from", user.follow_from);
            if (user.manager_forum != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (BazhuSign bazhuSign2 : user.manager_forum) {
                    jSONArray11.put(iqc.b(bazhuSign2));
                }
                poc.a(jSONObject, "manager_forum", jSONArray11);
            }
            poc.a(jSONObject, "display_auth_type", user.display_auth_type);
            WorkCreatorInfo workCreatorInfo = user.work_creator_info;
            if (workCreatorInfo != null) {
                poc.a(jSONObject, "work_creator_info", k6d.b(workCreatorInfo));
            }
            poc.a(jSONObject, "level_name", user.level_name);
            EditConfig editConfig = user.edit_config;
            if (editConfig != null) {
                poc.a(jSONObject, "edit_config", src.b(editConfig));
            }
            poc.a(jSONObject, PmsConstant.Statistic.STATISTIC_IP, user.ip_address);
            poc.a(jSONObject, "is_nickname_editing", user.is_nickname_editing);
            poc.a(jSONObject, "editing_nickname", user.editing_nickname);
            VirtualImageInfo virtualImageInfo = user.virtual_image_info;
            if (virtualImageInfo != null) {
                poc.a(jSONObject, "virtual_image_info", c6d.b(virtualImageInfo));
            }
            UserGrowth userGrowth = user.user_growth;
            if (userGrowth != null) {
                poc.a(jSONObject, "user_growth", n5d.b(userGrowth));
            }
            poc.a(jSONObject, "display_intro", user.display_intro);
            if (user.new_icon_url != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (String str : user.new_icon_url) {
                    jSONArray12.put(str);
                }
                poc.a(jSONObject, "new_icon_url", jSONArray12);
            }
            poc.a(jSONObject, "dynamic_url", user.dynamic_url);
            ThemeTailInUser themeTailInUser = user.theme_tail;
            if (themeTailInUser != null) {
                poc.a(jSONObject, "theme_tail", s4d.b(themeTailInUser));
            }
            ThemeBackgroundInUser themeBackgroundInUser = user.theme_background;
            if (themeBackgroundInUser != null) {
                poc.a(jSONObject, "theme_background", m4d.b(themeBackgroundInUser));
            }
            ThemeMyTab themeMyTab = user.theme_my_tab;
            if (themeMyTab != null) {
                poc.a(jSONObject, "theme_my_tab", r4d.b(themeMyTab));
            }
            WorldCupInfo worldCupInfo = user.world_cup_info;
            if (worldCupInfo != null) {
                poc.a(jSONObject, "world_cup_info", m6d.b(worldCupInfo));
            }
            ShakeAdSwitch shakeAdSwitch = user.shake_ad_switch;
            if (shakeAdSwitch != null) {
                poc.a(jSONObject, "shake_ad_switch", y2d.b(shakeAdSwitch));
            }
            if (user.pendants != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (String str2 : user.pendants) {
                    jSONArray13.put(str2);
                }
                poc.a(jSONObject, "pendants", jSONArray13);
            }
            poc.a(jSONObject, "ios_b_url", user.ios_b_url);
            poc.a(jSONObject, "pa", user.pa);
            poc.a(jSONObject, "enable_new_homepage", user.enable_new_homepage);
            poc.a(jSONObject, "target_scheme", user.target_scheme);
            if (user.tags != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (TagsInfo tagsInfo : user.tags) {
                    jSONArray14.put(f4d.b(tagsInfo));
                }
                poc.a(jSONObject, "tags", jSONArray14);
            }
            poc.a(jSONObject, "avatar_url", user.avatar_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
