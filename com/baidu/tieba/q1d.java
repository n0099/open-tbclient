package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.open.SocialOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Advertisement;
import tbclient.Agree;
import tbclient.AigcFeedbackInfo;
import tbclient.BotReplyContent;
import tbclient.CallRobotEntrance;
import tbclient.CardLinkInfo;
import tbclient.ChatContent;
import tbclient.CustomFigure;
import tbclient.CustomState;
import tbclient.DealInfo;
import tbclient.FestivalTipData;
import tbclient.FullLengthNovel;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.Lbs;
import tbclient.NovelInfo;
import tbclient.NovelRecomCard;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.PbPostZan;
import tbclient.PbPresent;
import tbclient.Post;
import tbclient.RobotSkill;
import tbclient.SignatureData;
import tbclient.SimpleForum;
import tbclient.SkinInfo;
import tbclient.SpriteMemeInfo;
import tbclient.SubPost;
import tbclient.TPointPost;
import tbclient.TailInfo;
import tbclient.ThemeBubble;
import tbclient.TogetherHi;
import tbclient.User;
import tbclient.VideoInfo;
import tbclient.Zan;
/* loaded from: classes7.dex */
public class q1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Post post) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, post)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", post.id);
            qoc.a(jSONObject, "title", post.title);
            qoc.a(jSONObject, "floor", post.floor);
            qoc.a(jSONObject, "time", post.time);
            if (post.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : post.content) {
                    jSONArray.put(x0d.b(pbContent));
                }
                qoc.a(jSONObject, "content", jSONArray);
            }
            if (post.arr_video != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : post.arr_video) {
                    jSONArray2.put(str);
                }
                qoc.a(jSONObject, "arr_video", jSONArray2);
            }
            Lbs lbs = post.lbs_info;
            if (lbs != null) {
                qoc.a(jSONObject, "lbs_info", mzc.b(lbs));
            }
            qoc.a(jSONObject, "is_vote", post.is_vote);
            qoc.a(jSONObject, "is_voice", post.is_voice);
            qoc.a(jSONObject, "is_ntitle", post.is_ntitle);
            qoc.a(jSONObject, "is_bub", post.is_bub);
            qoc.a(jSONObject, "vote_crypt", post.vote_crypt);
            qoc.a(jSONObject, "sub_post_number", post.sub_post_number);
            qoc.a(jSONObject, "time_ex", post.time_ex);
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                qoc.a(jSONObject, "sub_post_list", y3d.b(subPost));
            }
            AddPostList addPostList = post.add_post_list;
            if (addPostList != null) {
                qoc.a(jSONObject, "add_post_list", fpc.b(addPostList));
            }
            qoc.a(jSONObject, "bimg_url", post.bimg_url);
            qoc.a(jSONObject, "ios_bimg_format", post.ios_bimg_format);
            qoc.a(jSONObject, "author_id", post.author_id);
            qoc.a(jSONObject, "add_post_number", post.add_post_number);
            SignatureData signatureData = post.signature;
            if (signatureData != null) {
                qoc.a(jSONObject, SocialOperation.GAME_SIGNATURE, f3d.b(signatureData));
            }
            TailInfo tailInfo = post.tail_info;
            if (tailInfo != null) {
                qoc.a(jSONObject, "tail_info", h4d.b(tailInfo));
            }
            User user = post.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            Zan zan = post.zan;
            if (zan != null) {
                qoc.a(jSONObject, FeedData.TYPE_ZAN, q6d.b(zan));
            }
            qoc.a(jSONObject, "storecount", post.storecount);
            TPointPost tPointPost = post.tpoint_post;
            if (tPointPost != null) {
                qoc.a(jSONObject, "tpoint_post", a4d.b(tPointPost));
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                qoc.a(jSONObject, "act_post", xoc.b(actPost));
            }
            PbPresent pbPresent = post.present;
            if (pbPresent != null) {
                qoc.a(jSONObject, "present", b1d.b(pbPresent));
            }
            VideoInfo videoInfo = post.video_info;
            if (videoInfo != null) {
                qoc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, z5d.b(videoInfo));
            }
            PbPostZan pbPostZan = post.post_zan;
            if (pbPostZan != null) {
                qoc.a(jSONObject, "post_zan", a1d.b(pbPostZan));
            }
            qoc.a(jSONObject, "is_hot_post", post.is_hot_post);
            if (post.ext_tails != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TailInfo tailInfo2 : post.ext_tails) {
                    jSONArray3.put(h4d.b(tailInfo2));
                }
                qoc.a(jSONObject, "ext_tails", jSONArray3);
            }
            TogetherHi togetherHi = post.high_together;
            if (togetherHi != null) {
                qoc.a(jSONObject, "high_together", g5d.b(togetherHi));
            }
            SkinInfo skinInfo = post.skin_info;
            if (skinInfo != null) {
                qoc.a(jSONObject, "skin_info", j3d.b(skinInfo));
            }
            DealInfo dealInfo = post.pb_deal_info;
            if (dealInfo != null) {
                qoc.a(jSONObject, "pb_deal_info", krc.b(dealInfo));
            }
            qoc.a(jSONObject, "lego_card", post.lego_card);
            Agree agree = post.agree;
            if (agree != null) {
                qoc.a(jSONObject, "agree", hpc.b(agree));
            }
            SimpleForum simpleForum = post.from_forum;
            if (simpleForum != null) {
                qoc.a(jSONObject, "from_forum", h3d.b(simpleForum));
            }
            qoc.a(jSONObject, "is_post_visible", post.is_post_visible);
            qoc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, post.need_log);
            qoc.a(jSONObject, "img_num_abtest", post.img_num_abtest);
            OriginThreadInfo originThreadInfo = post.origin_thread_info;
            if (originThreadInfo != null) {
                qoc.a(jSONObject, "origin_thread_info", s0d.b(originThreadInfo));
            }
            qoc.a(jSONObject, "is_fold", post.is_fold);
            qoc.a(jSONObject, "fold_tip", post.fold_tip);
            qoc.a(jSONObject, "is_top_agree_post", post.is_top_agree_post);
            qoc.a(jSONObject, "tid", post.tid);
            qoc.a(jSONObject, "show_squared", post.show_squared);
            qoc.a(jSONObject, ImageViewerConfig.IS_BJH, post.is_bjh);
            qoc.a(jSONObject, "quote_id", post.quote_id);
            qoc.a(jSONObject, "is_wonderful_post", post.is_wonderful_post);
            if (post.item_star != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (HeadItem headItem : post.item_star) {
                    jSONArray4.put(syc.b(headItem));
                }
                qoc.a(jSONObject, "item_star", jSONArray4);
            }
            Item item = post.item;
            if (item != null) {
                qoc.a(jSONObject, "item", zyc.b(item));
            }
            Item item2 = post.outer_item;
            if (item2 != null) {
                qoc.a(jSONObject, "outer_item", zyc.b(item2));
            }
            Advertisement advertisement = post.advertisement;
            if (advertisement != null) {
                qoc.a(jSONObject, "advertisement", gpc.b(advertisement));
            }
            qoc.a(jSONObject, "fold_comment_status", post.fold_comment_status);
            qoc.a(jSONObject, "fold_comment_apply_url", post.fold_comment_apply_url);
            NovelInfo novelInfo = post.novel_info;
            if (novelInfo != null) {
                qoc.a(jSONObject, "novel_info", p0d.b(novelInfo));
            }
            if (post.card_link_info != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (CardLinkInfo cardLinkInfo : post.card_link_info) {
                    jSONArray5.put(tqc.b(cardLinkInfo));
                }
                qoc.a(jSONObject, "card_link_info", jSONArray5);
            }
            CustomFigure customFigure = post.custom_figure;
            if (customFigure != null) {
                qoc.a(jSONObject, "custom_figure", hrc.b(customFigure));
            }
            CustomState customState = post.custom_state;
            if (customState != null) {
                qoc.a(jSONObject, "custom_state", irc.b(customState));
            }
            FullLengthNovel fullLengthNovel = post.full_length_novel;
            if (fullLengthNovel != null) {
                qoc.a(jSONObject, "full_length_novel", jyc.b(fullLengthNovel));
            }
            qoc.a(jSONObject, "dynamic_url", post.dynamic_url);
            ThemeBubble themeBubble = post.bubble_info;
            if (themeBubble != null) {
                qoc.a(jSONObject, "bubble_info", o4d.b(themeBubble));
            }
            qoc.a(jSONObject, "rumor_source_img", post.rumor_source_img);
            FestivalTipData festivalTipData = post.festival_tip_data;
            if (festivalTipData != null) {
                qoc.a(jSONObject, "festival_tip_data", ktc.b(festivalTipData));
            }
            NovelRecomCard novelRecomCard = post.novel_recom_card;
            if (novelRecomCard != null) {
                qoc.a(jSONObject, "novel_recom_card", q0d.b(novelRecomCard));
            }
            qoc.a(jSONObject, "shield_icon", post.shield_icon);
            qoc.a(jSONObject, "icon_url", post.icon_url);
            qoc.a(jSONObject, "toutiao_card_tag", post.toutiao_card_tag);
            qoc.a(jSONObject, "toutiao_card_tag_color", post.toutiao_card_tag_color);
            CallRobotEntrance callRobotEntrance = post.call_robot_entrance;
            if (callRobotEntrance != null) {
                qoc.a(jSONObject, "call_robot_entrance", sqc.b(callRobotEntrance));
            }
            qoc.a(jSONObject, "is_bot_reply", post.is_bot_reply);
            qoc.a(jSONObject, "bot_reply_content", post.bot_reply_content);
            if (post.bot_reply_content_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (BotReplyContent botReplyContent : post.bot_reply_content_list) {
                    jSONArray6.put(nqc.b(botReplyContent));
                }
                qoc.a(jSONObject, "bot_reply_content_list", jSONArray6);
            }
            if (post.robot_skill != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (RobotSkill robotSkill : post.robot_skill) {
                    jSONArray7.put(s2d.b(robotSkill));
                }
                qoc.a(jSONObject, "robot_skill", jSONArray7);
            }
            AigcFeedbackInfo aigcFeedbackInfo = post.aigc_feedback_info;
            if (aigcFeedbackInfo != null) {
                qoc.a(jSONObject, "aigc_feedback_info", ipc.b(aigcFeedbackInfo));
            }
            ChatContent chatContent = post.chat_content;
            if (chatContent != null) {
                qoc.a(jSONObject, ScreenLockActivityConfig.CHAT_CONTENT, wqc.b(chatContent));
            }
            SpriteMemeInfo spriteMemeInfo = post.sprite_meme_info;
            if (spriteMemeInfo != null) {
                qoc.a(jSONObject, "sprite_meme_info", p3d.b(spriteMemeInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
