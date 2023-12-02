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
import tbclient.AichatBotCommentCard;
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
/* loaded from: classes8.dex */
public class s6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Post post) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, post)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", post.id);
            ktc.a(jSONObject, "title", post.title);
            ktc.a(jSONObject, "floor", post.floor);
            ktc.a(jSONObject, "time", post.time);
            if (post.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : post.content) {
                    jSONArray.put(z5d.b(pbContent));
                }
                ktc.a(jSONObject, "content", jSONArray);
            }
            if (post.arr_video != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : post.arr_video) {
                    jSONArray2.put(str);
                }
                ktc.a(jSONObject, "arr_video", jSONArray2);
            }
            Lbs lbs = post.lbs_info;
            if (lbs != null) {
                ktc.a(jSONObject, "lbs_info", o4d.b(lbs));
            }
            ktc.a(jSONObject, "is_vote", post.is_vote);
            ktc.a(jSONObject, "is_voice", post.is_voice);
            ktc.a(jSONObject, "is_ntitle", post.is_ntitle);
            ktc.a(jSONObject, "is_bub", post.is_bub);
            ktc.a(jSONObject, "vote_crypt", post.vote_crypt);
            ktc.a(jSONObject, "sub_post_number", post.sub_post_number);
            ktc.a(jSONObject, "time_ex", post.time_ex);
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                ktc.a(jSONObject, "sub_post_list", a9d.b(subPost));
            }
            AddPostList addPostList = post.add_post_list;
            if (addPostList != null) {
                ktc.a(jSONObject, "add_post_list", ztc.b(addPostList));
            }
            ktc.a(jSONObject, "bimg_url", post.bimg_url);
            ktc.a(jSONObject, "ios_bimg_format", post.ios_bimg_format);
            ktc.a(jSONObject, "author_id", post.author_id);
            ktc.a(jSONObject, "add_post_number", post.add_post_number);
            SignatureData signatureData = post.signature;
            if (signatureData != null) {
                ktc.a(jSONObject, SocialOperation.GAME_SIGNATURE, h8d.b(signatureData));
            }
            TailInfo tailInfo = post.tail_info;
            if (tailInfo != null) {
                ktc.a(jSONObject, "tail_info", j9d.b(tailInfo));
            }
            User user = post.author;
            if (user != null) {
                ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, pad.b(user));
            }
            Zan zan = post.zan;
            if (zan != null) {
                ktc.a(jSONObject, FeedData.TYPE_ZAN, tbd.b(zan));
            }
            ktc.a(jSONObject, "storecount", post.storecount);
            TPointPost tPointPost = post.tpoint_post;
            if (tPointPost != null) {
                ktc.a(jSONObject, "tpoint_post", c9d.b(tPointPost));
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                ktc.a(jSONObject, "act_post", rtc.b(actPost));
            }
            PbPresent pbPresent = post.present;
            if (pbPresent != null) {
                ktc.a(jSONObject, "present", d6d.b(pbPresent));
            }
            VideoInfo videoInfo = post.video_info;
            if (videoInfo != null) {
                ktc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, cbd.b(videoInfo));
            }
            PbPostZan pbPostZan = post.post_zan;
            if (pbPostZan != null) {
                ktc.a(jSONObject, "post_zan", c6d.b(pbPostZan));
            }
            ktc.a(jSONObject, "is_hot_post", post.is_hot_post);
            if (post.ext_tails != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TailInfo tailInfo2 : post.ext_tails) {
                    jSONArray3.put(j9d.b(tailInfo2));
                }
                ktc.a(jSONObject, "ext_tails", jSONArray3);
            }
            TogetherHi togetherHi = post.high_together;
            if (togetherHi != null) {
                ktc.a(jSONObject, "high_together", iad.b(togetherHi));
            }
            SkinInfo skinInfo = post.skin_info;
            if (skinInfo != null) {
                ktc.a(jSONObject, "skin_info", l8d.b(skinInfo));
            }
            DealInfo dealInfo = post.pb_deal_info;
            if (dealInfo != null) {
                ktc.a(jSONObject, "pb_deal_info", hwc.b(dealInfo));
            }
            ktc.a(jSONObject, "lego_card", post.lego_card);
            Agree agree = post.agree;
            if (agree != null) {
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            SimpleForum simpleForum = post.from_forum;
            if (simpleForum != null) {
                ktc.a(jSONObject, "from_forum", j8d.b(simpleForum));
            }
            ktc.a(jSONObject, "is_post_visible", post.is_post_visible);
            ktc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, post.need_log);
            ktc.a(jSONObject, "img_num_abtest", post.img_num_abtest);
            OriginThreadInfo originThreadInfo = post.origin_thread_info;
            if (originThreadInfo != null) {
                ktc.a(jSONObject, "origin_thread_info", u5d.b(originThreadInfo));
            }
            ktc.a(jSONObject, "is_fold", post.is_fold);
            ktc.a(jSONObject, "fold_tip", post.fold_tip);
            ktc.a(jSONObject, "is_top_agree_post", post.is_top_agree_post);
            ktc.a(jSONObject, "tid", post.tid);
            ktc.a(jSONObject, "show_squared", post.show_squared);
            ktc.a(jSONObject, ImageViewerConfig.IS_BJH, post.is_bjh);
            ktc.a(jSONObject, "quote_id", post.quote_id);
            ktc.a(jSONObject, "is_wonderful_post", post.is_wonderful_post);
            if (post.item_star != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (HeadItem headItem : post.item_star) {
                    jSONArray4.put(u3d.b(headItem));
                }
                ktc.a(jSONObject, "item_star", jSONArray4);
            }
            Item item = post.item;
            if (item != null) {
                ktc.a(jSONObject, "item", b4d.b(item));
            }
            Item item2 = post.outer_item;
            if (item2 != null) {
                ktc.a(jSONObject, "outer_item", b4d.b(item2));
            }
            Advertisement advertisement = post.advertisement;
            if (advertisement != null) {
                ktc.a(jSONObject, "advertisement", auc.b(advertisement));
            }
            ktc.a(jSONObject, "fold_comment_status", post.fold_comment_status);
            ktc.a(jSONObject, "fold_comment_apply_url", post.fold_comment_apply_url);
            NovelInfo novelInfo = post.novel_info;
            if (novelInfo != null) {
                ktc.a(jSONObject, "novel_info", r5d.b(novelInfo));
            }
            if (post.card_link_info != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (CardLinkInfo cardLinkInfo : post.card_link_info) {
                    jSONArray5.put(qvc.b(cardLinkInfo));
                }
                ktc.a(jSONObject, "card_link_info", jSONArray5);
            }
            CustomFigure customFigure = post.custom_figure;
            if (customFigure != null) {
                ktc.a(jSONObject, "custom_figure", ewc.b(customFigure));
            }
            CustomState customState = post.custom_state;
            if (customState != null) {
                ktc.a(jSONObject, "custom_state", fwc.b(customState));
            }
            FullLengthNovel fullLengthNovel = post.full_length_novel;
            if (fullLengthNovel != null) {
                ktc.a(jSONObject, "full_length_novel", l3d.b(fullLengthNovel));
            }
            ktc.a(jSONObject, "dynamic_url", post.dynamic_url);
            ThemeBubble themeBubble = post.bubble_info;
            if (themeBubble != null) {
                ktc.a(jSONObject, "bubble_info", q9d.b(themeBubble));
            }
            ktc.a(jSONObject, "rumor_source_img", post.rumor_source_img);
            FestivalTipData festivalTipData = post.festival_tip_data;
            if (festivalTipData != null) {
                ktc.a(jSONObject, "festival_tip_data", hyc.b(festivalTipData));
            }
            NovelRecomCard novelRecomCard = post.novel_recom_card;
            if (novelRecomCard != null) {
                ktc.a(jSONObject, "novel_recom_card", s5d.b(novelRecomCard));
            }
            ktc.a(jSONObject, "shield_icon", post.shield_icon);
            ktc.a(jSONObject, "icon_url", post.icon_url);
            ktc.a(jSONObject, "toutiao_card_tag", post.toutiao_card_tag);
            ktc.a(jSONObject, "toutiao_card_tag_color", post.toutiao_card_tag_color);
            CallRobotEntrance callRobotEntrance = post.call_robot_entrance;
            if (callRobotEntrance != null) {
                ktc.a(jSONObject, "call_robot_entrance", pvc.b(callRobotEntrance));
            }
            ktc.a(jSONObject, "is_bot_reply", post.is_bot_reply);
            ktc.a(jSONObject, "bot_reply_content", post.bot_reply_content);
            if (post.bot_reply_content_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (BotReplyContent botReplyContent : post.bot_reply_content_list) {
                    jSONArray6.put(jvc.b(botReplyContent));
                }
                ktc.a(jSONObject, "bot_reply_content_list", jSONArray6);
            }
            if (post.robot_skill != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (RobotSkill robotSkill : post.robot_skill) {
                    jSONArray7.put(u7d.b(robotSkill));
                }
                ktc.a(jSONObject, "robot_skill", jSONArray7);
            }
            AigcFeedbackInfo aigcFeedbackInfo = post.aigc_feedback_info;
            if (aigcFeedbackInfo != null) {
                ktc.a(jSONObject, "aigc_feedback_info", euc.b(aigcFeedbackInfo));
            }
            ChatContent chatContent = post.chat_content;
            if (chatContent != null) {
                ktc.a(jSONObject, ScreenLockActivityConfig.CHAT_CONTENT, tvc.b(chatContent));
            }
            SpriteMemeInfo spriteMemeInfo = post.sprite_meme_info;
            if (spriteMemeInfo != null) {
                ktc.a(jSONObject, "sprite_meme_info", r8d.b(spriteMemeInfo));
            }
            AichatBotCommentCard aichatBotCommentCard = post.aichat_bot_comment_card;
            if (aichatBotCommentCard != null) {
                ktc.a(jSONObject, "aichat_bot_comment_card", duc.b(aichatBotCommentCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
