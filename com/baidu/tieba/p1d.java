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
public class p1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Post post) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, post)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", post.id);
            poc.a(jSONObject, "title", post.title);
            poc.a(jSONObject, "floor", post.floor);
            poc.a(jSONObject, "time", post.time);
            if (post.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : post.content) {
                    jSONArray.put(w0d.b(pbContent));
                }
                poc.a(jSONObject, "content", jSONArray);
            }
            if (post.arr_video != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : post.arr_video) {
                    jSONArray2.put(str);
                }
                poc.a(jSONObject, "arr_video", jSONArray2);
            }
            Lbs lbs = post.lbs_info;
            if (lbs != null) {
                poc.a(jSONObject, "lbs_info", lzc.b(lbs));
            }
            poc.a(jSONObject, "is_vote", post.is_vote);
            poc.a(jSONObject, "is_voice", post.is_voice);
            poc.a(jSONObject, "is_ntitle", post.is_ntitle);
            poc.a(jSONObject, "is_bub", post.is_bub);
            poc.a(jSONObject, "vote_crypt", post.vote_crypt);
            poc.a(jSONObject, "sub_post_number", post.sub_post_number);
            poc.a(jSONObject, "time_ex", post.time_ex);
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                poc.a(jSONObject, "sub_post_list", x3d.b(subPost));
            }
            AddPostList addPostList = post.add_post_list;
            if (addPostList != null) {
                poc.a(jSONObject, "add_post_list", epc.b(addPostList));
            }
            poc.a(jSONObject, "bimg_url", post.bimg_url);
            poc.a(jSONObject, "ios_bimg_format", post.ios_bimg_format);
            poc.a(jSONObject, "author_id", post.author_id);
            poc.a(jSONObject, "add_post_number", post.add_post_number);
            SignatureData signatureData = post.signature;
            if (signatureData != null) {
                poc.a(jSONObject, SocialOperation.GAME_SIGNATURE, e3d.b(signatureData));
            }
            TailInfo tailInfo = post.tail_info;
            if (tailInfo != null) {
                poc.a(jSONObject, "tail_info", g4d.b(tailInfo));
            }
            User user = post.author;
            if (user != null) {
                poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, m5d.b(user));
            }
            Zan zan = post.zan;
            if (zan != null) {
                poc.a(jSONObject, FeedData.TYPE_ZAN, p6d.b(zan));
            }
            poc.a(jSONObject, "storecount", post.storecount);
            TPointPost tPointPost = post.tpoint_post;
            if (tPointPost != null) {
                poc.a(jSONObject, "tpoint_post", z3d.b(tPointPost));
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                poc.a(jSONObject, "act_post", woc.b(actPost));
            }
            PbPresent pbPresent = post.present;
            if (pbPresent != null) {
                poc.a(jSONObject, "present", a1d.b(pbPresent));
            }
            VideoInfo videoInfo = post.video_info;
            if (videoInfo != null) {
                poc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, y5d.b(videoInfo));
            }
            PbPostZan pbPostZan = post.post_zan;
            if (pbPostZan != null) {
                poc.a(jSONObject, "post_zan", z0d.b(pbPostZan));
            }
            poc.a(jSONObject, "is_hot_post", post.is_hot_post);
            if (post.ext_tails != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (TailInfo tailInfo2 : post.ext_tails) {
                    jSONArray3.put(g4d.b(tailInfo2));
                }
                poc.a(jSONObject, "ext_tails", jSONArray3);
            }
            TogetherHi togetherHi = post.high_together;
            if (togetherHi != null) {
                poc.a(jSONObject, "high_together", f5d.b(togetherHi));
            }
            SkinInfo skinInfo = post.skin_info;
            if (skinInfo != null) {
                poc.a(jSONObject, "skin_info", i3d.b(skinInfo));
            }
            DealInfo dealInfo = post.pb_deal_info;
            if (dealInfo != null) {
                poc.a(jSONObject, "pb_deal_info", jrc.b(dealInfo));
            }
            poc.a(jSONObject, "lego_card", post.lego_card);
            Agree agree = post.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            SimpleForum simpleForum = post.from_forum;
            if (simpleForum != null) {
                poc.a(jSONObject, "from_forum", g3d.b(simpleForum));
            }
            poc.a(jSONObject, "is_post_visible", post.is_post_visible);
            poc.a(jSONObject, DownloadStatisticConstants.UBC_SOURCE_NEED_LOG, post.need_log);
            poc.a(jSONObject, "img_num_abtest", post.img_num_abtest);
            OriginThreadInfo originThreadInfo = post.origin_thread_info;
            if (originThreadInfo != null) {
                poc.a(jSONObject, "origin_thread_info", r0d.b(originThreadInfo));
            }
            poc.a(jSONObject, "is_fold", post.is_fold);
            poc.a(jSONObject, "fold_tip", post.fold_tip);
            poc.a(jSONObject, "is_top_agree_post", post.is_top_agree_post);
            poc.a(jSONObject, "tid", post.tid);
            poc.a(jSONObject, "show_squared", post.show_squared);
            poc.a(jSONObject, ImageViewerConfig.IS_BJH, post.is_bjh);
            poc.a(jSONObject, "quote_id", post.quote_id);
            poc.a(jSONObject, "is_wonderful_post", post.is_wonderful_post);
            if (post.item_star != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (HeadItem headItem : post.item_star) {
                    jSONArray4.put(ryc.b(headItem));
                }
                poc.a(jSONObject, "item_star", jSONArray4);
            }
            Item item = post.item;
            if (item != null) {
                poc.a(jSONObject, "item", yyc.b(item));
            }
            Item item2 = post.outer_item;
            if (item2 != null) {
                poc.a(jSONObject, "outer_item", yyc.b(item2));
            }
            Advertisement advertisement = post.advertisement;
            if (advertisement != null) {
                poc.a(jSONObject, "advertisement", fpc.b(advertisement));
            }
            poc.a(jSONObject, "fold_comment_status", post.fold_comment_status);
            poc.a(jSONObject, "fold_comment_apply_url", post.fold_comment_apply_url);
            NovelInfo novelInfo = post.novel_info;
            if (novelInfo != null) {
                poc.a(jSONObject, "novel_info", o0d.b(novelInfo));
            }
            if (post.card_link_info != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (CardLinkInfo cardLinkInfo : post.card_link_info) {
                    jSONArray5.put(sqc.b(cardLinkInfo));
                }
                poc.a(jSONObject, "card_link_info", jSONArray5);
            }
            CustomFigure customFigure = post.custom_figure;
            if (customFigure != null) {
                poc.a(jSONObject, "custom_figure", grc.b(customFigure));
            }
            CustomState customState = post.custom_state;
            if (customState != null) {
                poc.a(jSONObject, "custom_state", hrc.b(customState));
            }
            FullLengthNovel fullLengthNovel = post.full_length_novel;
            if (fullLengthNovel != null) {
                poc.a(jSONObject, "full_length_novel", iyc.b(fullLengthNovel));
            }
            poc.a(jSONObject, "dynamic_url", post.dynamic_url);
            ThemeBubble themeBubble = post.bubble_info;
            if (themeBubble != null) {
                poc.a(jSONObject, "bubble_info", n4d.b(themeBubble));
            }
            poc.a(jSONObject, "rumor_source_img", post.rumor_source_img);
            FestivalTipData festivalTipData = post.festival_tip_data;
            if (festivalTipData != null) {
                poc.a(jSONObject, "festival_tip_data", jtc.b(festivalTipData));
            }
            NovelRecomCard novelRecomCard = post.novel_recom_card;
            if (novelRecomCard != null) {
                poc.a(jSONObject, "novel_recom_card", p0d.b(novelRecomCard));
            }
            poc.a(jSONObject, "shield_icon", post.shield_icon);
            poc.a(jSONObject, "icon_url", post.icon_url);
            poc.a(jSONObject, "toutiao_card_tag", post.toutiao_card_tag);
            poc.a(jSONObject, "toutiao_card_tag_color", post.toutiao_card_tag_color);
            CallRobotEntrance callRobotEntrance = post.call_robot_entrance;
            if (callRobotEntrance != null) {
                poc.a(jSONObject, "call_robot_entrance", rqc.b(callRobotEntrance));
            }
            poc.a(jSONObject, "is_bot_reply", post.is_bot_reply);
            poc.a(jSONObject, "bot_reply_content", post.bot_reply_content);
            if (post.bot_reply_content_list != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (BotReplyContent botReplyContent : post.bot_reply_content_list) {
                    jSONArray6.put(mqc.b(botReplyContent));
                }
                poc.a(jSONObject, "bot_reply_content_list", jSONArray6);
            }
            if (post.robot_skill != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (RobotSkill robotSkill : post.robot_skill) {
                    jSONArray7.put(r2d.b(robotSkill));
                }
                poc.a(jSONObject, "robot_skill", jSONArray7);
            }
            AigcFeedbackInfo aigcFeedbackInfo = post.aigc_feedback_info;
            if (aigcFeedbackInfo != null) {
                poc.a(jSONObject, "aigc_feedback_info", hpc.b(aigcFeedbackInfo));
            }
            ChatContent chatContent = post.chat_content;
            if (chatContent != null) {
                poc.a(jSONObject, ScreenLockActivityConfig.CHAT_CONTENT, vqc.b(chatContent));
            }
            SpriteMemeInfo spriteMemeInfo = post.sprite_meme_info;
            if (spriteMemeInfo != null) {
                poc.a(jSONObject, "sprite_meme_info", o3d.b(spriteMemeInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
