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
public class t6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Post post) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, post)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", post.id);
            ltc.a(jSONObject, "title", post.title);
            ltc.a(jSONObject, "floor", post.floor);
            ltc.a(jSONObject, "time", post.time);
            if (post.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : post.content) {
                    jSONArray.put(a6d.b(pbContent));
                }
                ltc.a(jSONObject, "content", jSONArray);
            }
            if (post.arr_video != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : post.arr_video) {
                    jSONArray2.put(str);
                }
                ltc.a(jSONObject, "arr_video", jSONArray2);
            }
            Lbs lbs = post.lbs_info;
            if (lbs != null) {
                ltc.a(jSONObject, "lbs_info", p4d.b(lbs));
            }
            ltc.a(jSONObject, "is_vote", post.is_vote);
            ltc.a(jSONObject, "is_voice", post.is_voice);
            ltc.a(jSONObject, "is_ntitle", post.is_ntitle);
            ltc.a(jSONObject, "is_bub", post.is_bub);
            ltc.a(jSONObject, "vote_crypt", post.vote_crypt);
            ltc.a(jSONObject, "sub_post_number", post.sub_post_number);
            ltc.a(jSONObject, "time_ex", post.time_ex);
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                ltc.a(jSONObject, "sub_post_list", b9d.b(subPost));
            }
            AddPostList addPostList = post.add_post_list;
            if (addPostList != null) {
                ltc.a(jSONObject, "add_post_list", auc.b(addPostList));
            }
            ltc.a(jSONObject, "bimg_url", post.bimg_url);
            ltc.a(jSONObject, "ios_bimg_format", post.ios_bimg_format);
            ltc.a(jSONObject, "author_id", post.author_id);
            ltc.a(jSONObject, "add_post_number", post.add_post_number);
            SignatureData signatureData = post.signature;
            if (signatureData != null) {
                ltc.a(jSONObject, SocialOperation.GAME_SIGNATURE, i8d.b(signatureData));
            }
            TailInfo tailInfo = post.tail_info;
            if (tailInfo != null) {
                ltc.a(jSONObject, "tail_info", k9d.b(tailInfo));
            }
            User user = post.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            Zan zan = post.zan;
            if (zan != null) {
                ltc.a(jSONObject, FeedData.TYPE_ZAN, ubd.b(zan));
            }
            ltc.a(jSONObject, "storecount", post.storecount);
            TPointPost tPointPost = post.tpoint_post;
            if (tPointPost != null) {
                ltc.a(jSONObject, "tpoint_post", d9d.b(tPointPost));
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                ltc.a(jSONObject, "act_post", stc.b(actPost));
            }
            PbPresent pbPresent = post.present;
            if (pbPresent != null) {
                ltc.a(jSONObject, "present", e6d.b(pbPresent));
            }
            VideoInfo videoInfo = post.video_info;
            if (videoInfo != null) {
                ltc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, dbd.b(videoInfo));
            }
            PbPostZan pbPostZan = post.post_zan;
            if (pbPostZan != null) {
                ltc.a(jSONObject, "post_zan", d6d.b(pbPostZan));
            }
            ltc.a(jSONObject, "is_hot_post", post.is_hot_post);
            if (post.ext_tails != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TailInfo tailInfo2 : post.ext_tails) {
                    jSONArray3.put(k9d.b(tailInfo2));
                }
                ltc.a(jSONObject, "ext_tails", jSONArray3);
            }
            TogetherHi togetherHi = post.high_together;
            if (togetherHi != null) {
                ltc.a(jSONObject, "high_together", jad.b(togetherHi));
            }
            SkinInfo skinInfo = post.skin_info;
            if (skinInfo != null) {
                ltc.a(jSONObject, "skin_info", m8d.b(skinInfo));
            }
            DealInfo dealInfo = post.pb_deal_info;
            if (dealInfo != null) {
                ltc.a(jSONObject, "pb_deal_info", iwc.b(dealInfo));
            }
            ltc.a(jSONObject, "lego_card", post.lego_card);
            Agree agree = post.agree;
            if (agree != null) {
                ltc.a(jSONObject, "agree", cuc.b(agree));
            }
            SimpleForum simpleForum = post.from_forum;
            if (simpleForum != null) {
                ltc.a(jSONObject, "from_forum", k8d.b(simpleForum));
            }
            ltc.a(jSONObject, "is_post_visible", post.is_post_visible);
            ltc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, post.need_log);
            ltc.a(jSONObject, "img_num_abtest", post.img_num_abtest);
            OriginThreadInfo originThreadInfo = post.origin_thread_info;
            if (originThreadInfo != null) {
                ltc.a(jSONObject, "origin_thread_info", v5d.b(originThreadInfo));
            }
            ltc.a(jSONObject, "is_fold", post.is_fold);
            ltc.a(jSONObject, "fold_tip", post.fold_tip);
            ltc.a(jSONObject, "is_top_agree_post", post.is_top_agree_post);
            ltc.a(jSONObject, "tid", post.tid);
            ltc.a(jSONObject, "show_squared", post.show_squared);
            ltc.a(jSONObject, ImageViewerConfig.IS_BJH, post.is_bjh);
            ltc.a(jSONObject, "quote_id", post.quote_id);
            ltc.a(jSONObject, "is_wonderful_post", post.is_wonderful_post);
            if (post.item_star != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (HeadItem headItem : post.item_star) {
                    jSONArray4.put(v3d.b(headItem));
                }
                ltc.a(jSONObject, "item_star", jSONArray4);
            }
            Item item = post.item;
            if (item != null) {
                ltc.a(jSONObject, "item", c4d.b(item));
            }
            Item item2 = post.outer_item;
            if (item2 != null) {
                ltc.a(jSONObject, "outer_item", c4d.b(item2));
            }
            Advertisement advertisement = post.advertisement;
            if (advertisement != null) {
                ltc.a(jSONObject, "advertisement", buc.b(advertisement));
            }
            ltc.a(jSONObject, "fold_comment_status", post.fold_comment_status);
            ltc.a(jSONObject, "fold_comment_apply_url", post.fold_comment_apply_url);
            NovelInfo novelInfo = post.novel_info;
            if (novelInfo != null) {
                ltc.a(jSONObject, "novel_info", s5d.b(novelInfo));
            }
            if (post.card_link_info != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (CardLinkInfo cardLinkInfo : post.card_link_info) {
                    jSONArray5.put(rvc.b(cardLinkInfo));
                }
                ltc.a(jSONObject, "card_link_info", jSONArray5);
            }
            CustomFigure customFigure = post.custom_figure;
            if (customFigure != null) {
                ltc.a(jSONObject, "custom_figure", fwc.b(customFigure));
            }
            CustomState customState = post.custom_state;
            if (customState != null) {
                ltc.a(jSONObject, "custom_state", gwc.b(customState));
            }
            FullLengthNovel fullLengthNovel = post.full_length_novel;
            if (fullLengthNovel != null) {
                ltc.a(jSONObject, "full_length_novel", m3d.b(fullLengthNovel));
            }
            ltc.a(jSONObject, "dynamic_url", post.dynamic_url);
            ThemeBubble themeBubble = post.bubble_info;
            if (themeBubble != null) {
                ltc.a(jSONObject, "bubble_info", r9d.b(themeBubble));
            }
            ltc.a(jSONObject, "rumor_source_img", post.rumor_source_img);
            FestivalTipData festivalTipData = post.festival_tip_data;
            if (festivalTipData != null) {
                ltc.a(jSONObject, "festival_tip_data", iyc.b(festivalTipData));
            }
            NovelRecomCard novelRecomCard = post.novel_recom_card;
            if (novelRecomCard != null) {
                ltc.a(jSONObject, "novel_recom_card", t5d.b(novelRecomCard));
            }
            ltc.a(jSONObject, "shield_icon", post.shield_icon);
            ltc.a(jSONObject, "icon_url", post.icon_url);
            ltc.a(jSONObject, "toutiao_card_tag", post.toutiao_card_tag);
            ltc.a(jSONObject, "toutiao_card_tag_color", post.toutiao_card_tag_color);
            CallRobotEntrance callRobotEntrance = post.call_robot_entrance;
            if (callRobotEntrance != null) {
                ltc.a(jSONObject, "call_robot_entrance", qvc.b(callRobotEntrance));
            }
            ltc.a(jSONObject, "is_bot_reply", post.is_bot_reply);
            ltc.a(jSONObject, "bot_reply_content", post.bot_reply_content);
            if (post.bot_reply_content_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (BotReplyContent botReplyContent : post.bot_reply_content_list) {
                    jSONArray6.put(kvc.b(botReplyContent));
                }
                ltc.a(jSONObject, "bot_reply_content_list", jSONArray6);
            }
            if (post.robot_skill != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (RobotSkill robotSkill : post.robot_skill) {
                    jSONArray7.put(v7d.b(robotSkill));
                }
                ltc.a(jSONObject, "robot_skill", jSONArray7);
            }
            AigcFeedbackInfo aigcFeedbackInfo = post.aigc_feedback_info;
            if (aigcFeedbackInfo != null) {
                ltc.a(jSONObject, "aigc_feedback_info", fuc.b(aigcFeedbackInfo));
            }
            ChatContent chatContent = post.chat_content;
            if (chatContent != null) {
                ltc.a(jSONObject, ScreenLockActivityConfig.CHAT_CONTENT, uvc.b(chatContent));
            }
            SpriteMemeInfo spriteMemeInfo = post.sprite_meme_info;
            if (spriteMemeInfo != null) {
                ltc.a(jSONObject, "sprite_meme_info", s8d.b(spriteMemeInfo));
            }
            AichatBotCommentCard aichatBotCommentCard = post.aichat_bot_comment_card;
            if (aichatBotCommentCard != null) {
                ltc.a(jSONObject, "aichat_bot_comment_card", euc.b(aichatBotCommentCard));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
