package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.utils.FileUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.IMUserExtraData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.ActivityInfo;
import tbclient.AdInfo;
import tbclient.Agree;
import tbclient.AlaLiveInfo;
import tbclient.AnchorInfo;
import tbclient.AnimationThread;
import tbclient.AppCode;
import tbclient.AppInfo;
import tbclient.Baijiahao;
import tbclient.BookThread;
import tbclient.BusinessMix;
import tbclient.CartoonThread;
import tbclient.ClickBackCard;
import tbclient.CustomFigure;
import tbclient.CustomState;
import tbclient.DealInfo;
import tbclient.DeclareInfo;
import tbclient.DislikeInfo;
import tbclient.EditInfo;
import tbclient.ForumFriendWatchingInfo;
import tbclient.Guess;
import tbclient.HeadItem;
import tbclient.HotTWThreadInfo;
import tbclient.Item;
import tbclient.JNews;
import tbclient.Lbs;
import tbclient.LinkThreadInfo;
import tbclient.Media;
import tbclient.MediaNum;
import tbclient.MultipleForum;
import tbclient.OriForumInfo;
import tbclient.OriginThreadInfo;
import tbclient.PbContent;
import tbclient.PbGoodsInfo;
import tbclient.PbLinkInfo;
import tbclient.PeiwanInfo;
import tbclient.PollInfo;
import tbclient.Post;
import tbclient.PostList;
import tbclient.PsInfo;
import tbclient.PushStatus;
import tbclient.RecommendTip;
import tbclient.ReportInfo;
import tbclient.RobotEntrance;
import tbclient.SimpleForum;
import tbclient.SkinInfo;
import tbclient.SmartApp;
import tbclient.StarRankIcon;
import tbclient.TailInfo;
import tbclient.TaskInfo;
import tbclient.TbreadDispatch;
import tbclient.ThreadAblum;
import tbclient.ThreadInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.ThreadRecommendTag;
import tbclient.TiebaPlusAd;
import tbclient.TogetherHi;
import tbclient.Topic;
import tbclient.TopicModule;
import tbclient.User;
import tbclient.VideoActive;
import tbclient.VideoChannelInfo;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.VoiceRoom;
import tbclient.WorksInfo;
import tbclient.YulePostActivity;
import tbclient.Zan;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes9.dex */
public class y9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", threadInfo.id);
            ltc.a(jSONObject, "tid", threadInfo.tid);
            ltc.a(jSONObject, "title", threadInfo.title);
            ltc.a(jSONObject, "reply_num", threadInfo.reply_num);
            ltc.a(jSONObject, "view_num", threadInfo.view_num);
            ltc.a(jSONObject, "last_time", threadInfo.last_time);
            ltc.a(jSONObject, "last_time_int", threadInfo.last_time_int);
            ltc.a(jSONObject, "thread_types", threadInfo.thread_types);
            ltc.a(jSONObject, "is_top", threadInfo.is_top);
            ltc.a(jSONObject, "is_good", threadInfo.is_good);
            ltc.a(jSONObject, "is_vote", threadInfo.is_vote);
            ltc.a(jSONObject, "is_bakan", threadInfo.is_bakan);
            ltc.a(jSONObject, "is_protal", threadInfo.is_protal);
            ltc.a(jSONObject, "is_meizhi", threadInfo.is_meizhi);
            ltc.a(jSONObject, "is_voice_thread", threadInfo.is_voice_thread);
            ltc.a(jSONObject, "is_activity", threadInfo.is_activity);
            ltc.a(jSONObject, "is_notice", threadInfo.is_notice);
            User user = threadInfo.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            User user2 = threadInfo.last_replyer;
            if (user2 != null) {
                ltc.a(jSONObject, "last_replyer", qad.b(user2));
            }
            ltc.a(jSONObject, "comment_num", threadInfo.comment_num);
            if (threadInfo._abstract != null) {
                JSONArray jSONArray = new JSONArray();
                for (Abstract r3 : threadInfo._abstract) {
                    jSONArray.put(otc.b(r3));
                }
                ltc.a(jSONObject, "abstract", jSONArray);
            }
            if (threadInfo.media != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Media media : threadInfo.media) {
                    jSONArray2.put(c5d.b(media));
                }
                ltc.a(jSONObject, "media", jSONArray2);
            }
            if (threadInfo.voice_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (Voice voice : threadInfo.voice_info) {
                    jSONArray3.put(jbd.b(voice));
                }
                ltc.a(jSONObject, "voice_info", jSONArray3);
            }
            ltc.a(jSONObject, "meizhi_pic", threadInfo.meizhi_pic);
            if (threadInfo.media_num != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (MediaNum mediaNum : threadInfo.media_num) {
                    jSONArray4.put(d5d.b(mediaNum));
                }
                ltc.a(jSONObject, "media_num", jSONArray4);
            }
            ltc.a(jSONObject, "thread_type", threadInfo.thread_type);
            ltc.a(jSONObject, "fid", threadInfo.fid);
            ltc.a(jSONObject, "fname", threadInfo.fname);
            ltc.a(jSONObject, "live_post_type", threadInfo.live_post_type);
            ltc.a(jSONObject, "is_livepost", threadInfo.is_livepost);
            ltc.a(jSONObject, "show_commented", threadInfo.show_commented);
            ltc.a(jSONObject, "click_url", threadInfo.click_url);
            ltc.a(jSONObject, "video", threadInfo.video);
            ltc.a(jSONObject, "video_swf", threadInfo.video_swf);
            ltc.a(jSONObject, FileUtils.VIDEO_COVER_DIR, threadInfo.video_cover);
            ltc.a(jSONObject, "video_id", threadInfo.video_id);
            ltc.a(jSONObject, "video_mobile_url", threadInfo.video_mobile_url);
            ltc.a(jSONObject, "is_ntitle", threadInfo.is_ntitle);
            ltc.a(jSONObject, "is_bub", threadInfo.is_bub);
            ltc.a(jSONObject, "first_post_id", threadInfo.first_post_id);
            Zan zan = threadInfo.zan;
            if (zan != null) {
                ltc.a(jSONObject, FeedData.TYPE_ZAN, ubd.b(zan));
            }
            ltc.a(jSONObject, "is_global_top", threadInfo.is_global_top);
            ltc.a(jSONObject, "is_pic", threadInfo.is_pic);
            if (threadInfo.post_list != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (PostList postList : threadInfo.post_list) {
                    jSONArray5.put(u6d.b(postList));
                }
                ltc.a(jSONObject, "post_list", jSONArray5);
            }
            ltc.a(jSONObject, "create_time", threadInfo.create_time);
            ltc.a(jSONObject, "repost_num", threadInfo.repost_num);
            Topic topic = threadInfo.topic;
            if (topic != null) {
                ltc.a(jSONObject, "topic", kad.b(topic));
            }
            ltc.a(jSONObject, "has_commented", threadInfo.has_commented);
            ltc.a(jSONObject, "from", threadInfo.from);
            ltc.a(jSONObject, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS, threadInfo.collect_status);
            ltc.a(jSONObject, "collect_mark_pid", threadInfo.collect_mark_pid);
            ltc.a(jSONObject, "post_id", threadInfo.post_id);
            ltc.a(jSONObject, "time", threadInfo.time);
            ltc.a(jSONObject, "is_membertop", threadInfo.is_membertop);
            AnchorInfo anchorInfo = threadInfo.anchor_info;
            if (anchorInfo != null) {
                ltc.a(jSONObject, "anchor_info", nuc.b(anchorInfo));
            }
            ltc.a(jSONObject, "author_id", threadInfo.author_id);
            ltc.a(jSONObject, "valid_post_num", threadInfo.valid_post_num);
            ltc.a(jSONObject, "isLzDeleteAll", threadInfo.isLzDeleteAll);
            ltc.a(jSONObject, "is_ad", threadInfo.is_ad);
            ltc.a(jSONObject, "ecom", threadInfo.ecom);
            ltc.a(jSONObject, "pids", threadInfo.pids);
            Lbs lbs = threadInfo.location;
            if (lbs != null) {
                ltc.a(jSONObject, "location", p4d.b(lbs));
            }
            Guess guess = threadInfo.guess;
            if (guess != null) {
                ltc.a(jSONObject, "guess", u3d.b(guess));
            }
            ltc.a(jSONObject, "timeline", threadInfo.timeline);
            if (threadInfo.act_info != null) {
                JSONArray jSONArray6 = new JSONArray();
                for (ActInfo actInfo : threadInfo.act_info) {
                    jSONArray6.put(rtc.b(actInfo));
                }
                ltc.a(jSONObject, "act_info", jSONArray6);
            }
            ltc.a(jSONObject, "hot_weight", threadInfo.hot_weight);
            ltc.a(jSONObject, "livecover_src", threadInfo.livecover_src);
            ltc.a(jSONObject, "storecount", threadInfo.storecount);
            ltc.a(jSONObject, "post_num", threadInfo.post_num);
            HotTWThreadInfo hotTWThreadInfo = threadInfo.hotTWInfo;
            if (hotTWThreadInfo != null) {
                ltc.a(jSONObject, "hotTWInfo", x3d.b(hotTWThreadInfo));
            }
            ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
            if (zhiBoInfoTW != null) {
                ltc.a(jSONObject, "twzhibo_info", vbd.b(zhiBoInfoTW));
            }
            ltc.a(jSONObject, MangaCategoryActivityConfig.CATEGORY_NAME, threadInfo.category_name);
            PollInfo pollInfo = threadInfo.poll_info;
            if (pollInfo != null) {
                ltc.a(jSONObject, "poll_info", n6d.b(pollInfo));
            }
            JNews jNews = threadInfo.jid;
            if (jNews != null) {
                ltc.a(jSONObject, "jid", l4d.b(jNews));
            }
            ltc.a(jSONObject, "is_novel", threadInfo.is_novel);
            ltc.a(jSONObject, "is_novel_thank", threadInfo.is_novel_thank);
            ltc.a(jSONObject, "is_novel_reward", threadInfo.is_novel_reward);
            VideoInfo videoInfo = threadInfo.video_info;
            if (videoInfo != null) {
                ltc.a(jSONObject, WriteActivityConfig.VIDEO_INFO, dbd.b(videoInfo));
            }
            ltc.a(jSONObject, "push_end_time", threadInfo.push_end_time);
            ltc.a(jSONObject, "is_copythread", threadInfo.is_copythread);
            ltc.a(jSONObject, "operator_flag", threadInfo.operator_flag);
            TaskInfo taskInfo = threadInfo.task_info;
            if (taskInfo != null) {
                ltc.a(jSONObject, "task_info", l9d.b(taskInfo));
            }
            ltc.a(jSONObject, "pic_num", threadInfo.pic_num);
            ltc.a(jSONObject, "is_godthread_recommend", threadInfo.is_godthread_recommend);
            YulePostActivity yulePostActivity = threadInfo.yule_post_activity;
            if (yulePostActivity != null) {
                ltc.a(jSONObject, "yule_post_activity", sbd.b(yulePostActivity));
            }
            AppCode appCode = threadInfo.app_code;
            if (appCode != null) {
                ltc.a(jSONObject, "app_code", ruc.b(appCode));
            }
            if (threadInfo.ext_tails != null) {
                JSONArray jSONArray7 = new JSONArray();
                for (TailInfo tailInfo : threadInfo.ext_tails) {
                    jSONArray7.put(k9d.b(tailInfo));
                }
                ltc.a(jSONObject, "ext_tails", jSONArray7);
            }
            PushStatus pushStatus = threadInfo.push_status;
            if (pushStatus != null) {
                ltc.a(jSONObject, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS, c7d.b(pushStatus));
            }
            CartoonThread cartoonThread = threadInfo.cartoon_info;
            if (cartoonThread != null) {
                ltc.a(jSONObject, "cartoon_info", svc.b(cartoonThread));
            }
            ltc.a(jSONObject, "lego_card", threadInfo.lego_card);
            TogetherHi togetherHi = threadInfo.high_together;
            if (togetherHi != null) {
                ltc.a(jSONObject, "high_together", jad.b(togetherHi));
            }
            VideoActive videoActive = threadInfo.videoactive_info;
            if (videoActive != null) {
                ltc.a(jSONObject, "videoactive_info", yad.b(videoActive));
            }
            ltc.a(jSONObject, "is_deal", threadInfo.is_deal);
            DealInfo dealInfo = threadInfo.deal_info;
            if (dealInfo != null) {
                ltc.a(jSONObject, "deal_info", iwc.b(dealInfo));
            }
            AnimationThread animationThread = threadInfo.animation_info;
            if (animationThread != null) {
                ltc.a(jSONObject, LegoListActivityConfig.ANIMATION_INFO, ouc.b(animationThread));
            }
            SkinInfo skinInfo = threadInfo.skin_info;
            if (skinInfo != null) {
                ltc.a(jSONObject, "skin_info", m8d.b(skinInfo));
            }
            PsInfo psInfo = threadInfo.ps_info;
            if (psInfo != null) {
                ltc.a(jSONObject, "ps_info", z6d.b(psInfo));
            }
            BookThread bookThread = threadInfo.book_chapter;
            if (bookThread != null) {
                ltc.a(jSONObject, "book_chapter", jvc.b(bookThread));
            }
            ltc.a(jSONObject, "is_book_chapter", threadInfo.is_book_chapter);
            ltc.a(jSONObject, "recom_source", threadInfo.recom_source);
            ltc.a(jSONObject, TiebaStatic.Params.RECOM_WEIGHT, threadInfo.recom_weight);
            ltc.a(jSONObject, "last_read_pid", threadInfo.last_read_pid);
            ltc.a(jSONObject, "cheak_repeat", threadInfo.cheak_repeat);
            ltc.a(jSONObject, "ab_tag", threadInfo.ab_tag);
            ltc.a(jSONObject, "recom_reason", threadInfo.recom_reason);
            AdInfo adInfo = threadInfo.video_ad_info;
            if (adInfo != null) {
                ltc.a(jSONObject, "video_ad_info", xtc.b(adInfo));
            }
            if (threadInfo.rich_title != null) {
                JSONArray jSONArray8 = new JSONArray();
                for (PbContent pbContent : threadInfo.rich_title) {
                    jSONArray8.put(a6d.b(pbContent));
                }
                ltc.a(jSONObject, "rich_title", jSONArray8);
            }
            if (threadInfo.rich_abstract != null) {
                JSONArray jSONArray9 = new JSONArray();
                for (PbContent pbContent2 : threadInfo.rich_abstract) {
                    jSONArray9.put(a6d.b(pbContent2));
                }
                ltc.a(jSONObject, "rich_abstract", jSONArray9);
            }
            AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
            if (alaLiveInfo != null) {
                ltc.a(jSONObject, "ala_info", iuc.b(alaLiveInfo));
            }
            ltc.a(jSONObject, "is_operate_thread", threadInfo.is_operate_thread);
            ltc.a(jSONObject, "is_tbread_dispatch", threadInfo.is_tbread_dispatch);
            TbreadDispatch tbreadDispatch = threadInfo.tbread_dispatch_info;
            if (tbreadDispatch != null) {
                ltc.a(jSONObject, "tbread_dispatch_info", o9d.b(tbreadDispatch));
            }
            AppInfo appInfo = threadInfo.app_info;
            if (appInfo != null) {
                ltc.a(jSONObject, "app_info", tuc.b(appInfo));
            }
            if (threadInfo.report_info != null) {
                JSONArray jSONArray10 = new JSONArray();
                for (ReportInfo reportInfo : threadInfo.report_info) {
                    jSONArray10.put(r7d.b(reportInfo));
                }
                ltc.a(jSONObject, "report_info", jSONArray10);
            }
            VideoChannelInfo videoChannelInfo = threadInfo.video_channel_info;
            if (videoChannelInfo != null) {
                ltc.a(jSONObject, "video_channel_info", zad.b(videoChannelInfo));
            }
            if (threadInfo.dislike_info != null) {
                JSONArray jSONArray11 = new JSONArray();
                for (DislikeInfo dislikeInfo : threadInfo.dislike_info) {
                    jSONArray11.put(owc.b(dislikeInfo));
                }
                ltc.a(jSONObject, "dislike_info", jSONArray11);
            }
            if (threadInfo.declare_list != null) {
                JSONArray jSONArray12 = new JSONArray();
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    jSONArray12.put(kwc.b(declareInfo));
                }
                ltc.a(jSONObject, "declare_list", jSONArray12);
            }
            if (threadInfo.multiple_forum_list != null) {
                JSONArray jSONArray13 = new JSONArray();
                for (MultipleForum multipleForum : threadInfo.multiple_forum_list) {
                    jSONArray13.put(h5d.b(multipleForum));
                }
                ltc.a(jSONObject, "multiple_forum_list", jSONArray13);
            }
            ltc.a(jSONObject, "is_multiforum_thread", threadInfo.is_multiforum_thread);
            ltc.a(jSONObject, "agree_num", threadInfo.agree_num);
            Post post = threadInfo.top_agree_post;
            if (post != null) {
                ltc.a(jSONObject, "top_agree_post", t6d.b(post));
            }
            Agree agree = threadInfo.agree;
            if (agree != null) {
                ltc.a(jSONObject, "agree", cuc.b(agree));
            }
            ltc.a(jSONObject, "is_partial_visible", threadInfo.is_partial_visible);
            ltc.a(jSONObject, "is_link_thread", threadInfo.is_link_thread);
            LinkThreadInfo linkThreadInfo = threadInfo.link_info;
            if (linkThreadInfo != null) {
                ltc.a(jSONObject, "link_info", v4d.b(linkThreadInfo));
            }
            ltc.a(jSONObject, "freq_num", threadInfo.freq_num);
            ltc.a(jSONObject, IMUserExtraData.KEY_IS_GOD, threadInfo.is_god);
            ActivityInfo activityInfo = threadInfo.activity_info;
            if (activityInfo != null) {
                ltc.a(jSONObject, "activity_info", utc.b(activityInfo));
            }
            Media media2 = threadInfo.pic_info;
            if (media2 != null) {
                ltc.a(jSONObject, "pic_info", c5d.b(media2));
            }
            ltc.a(jSONObject, "is_story_audit", threadInfo.is_story_audit);
            ltc.a(jSONObject, "share_num", threadInfo.share_num);
            ltc.a(jSONObject, "is_called", threadInfo.is_called);
            ltc.a(jSONObject, "tieba_game_information_source", threadInfo.tieba_game_information_source);
            ltc.a(jSONObject, "audit_time", threadInfo.audit_time);
            ltc.a(jSONObject, "middle_page_num", threadInfo.middle_page_num);
            ltc.a(jSONObject, "middle_page_pass_flag", threadInfo.middle_page_pass_flag);
            OriginThreadInfo originThreadInfo = threadInfo.origin_thread_info;
            if (originThreadInfo != null) {
                ltc.a(jSONObject, "origin_thread_info", v5d.b(originThreadInfo));
            }
            if (threadInfo.first_post_content != null) {
                JSONArray jSONArray14 = new JSONArray();
                for (PbContent pbContent3 : threadInfo.first_post_content) {
                    jSONArray14.put(a6d.b(pbContent3));
                }
                ltc.a(jSONObject, "first_post_content", jSONArray14);
            }
            ltc.a(jSONObject, VideoPlayActivityConfig.IS_SHARE_THREAD, threadInfo.is_share_thread);
            ltc.a(jSONObject, TiebaStatic.Params.RECOM_EXTRA, threadInfo.recom_extra);
            ltc.a(jSONObject, "trans_num", threadInfo.trans_num);
            ltc.a(jSONObject, "multi_forum_text", threadInfo.multi_forum_text);
            StarRankIcon starRankIcon = threadInfo.star_rank_icon;
            if (starRankIcon != null) {
                ltc.a(jSONObject, "star_rank_icon", u8d.b(starRankIcon));
            }
            ltc.a(jSONObject, "is_topic", threadInfo.is_topic);
            ltc.a(jSONObject, "topic_user_name", threadInfo.topic_user_name);
            ltc.a(jSONObject, "topic_h5_url", threadInfo.topic_h5_url);
            ltc.a(jSONObject, "presentation_style", threadInfo.presentation_style);
            OriForumInfo oriForumInfo = threadInfo.ori_forum_info;
            if (oriForumInfo != null) {
                ltc.a(jSONObject, "ori_forum_info", u5d.b(oriForumInfo));
            }
            ltc.a(jSONObject, "is_videobiggie_recomthread", threadInfo.is_videobiggie_recomthread);
            ltc.a(jSONObject, "daily_paper_time", threadInfo.daily_paper_time);
            SimpleForum simpleForum = threadInfo.forum_info;
            if (simpleForum != null) {
                ltc.a(jSONObject, "forum_info", k8d.b(simpleForum));
            }
            SmartApp smartApp = threadInfo.naws_info;
            if (smartApp != null) {
                ltc.a(jSONObject, "naws_info", n8d.b(smartApp));
            }
            VideoDesc videoDesc = threadInfo.video_segment;
            if (videoDesc != null) {
                ltc.a(jSONObject, "video_segment", abd.b(videoDesc));
            }
            ltc.a(jSONObject, "is_top_img", threadInfo.is_top_img);
            ltc.a(jSONObject, "t_share_img", threadInfo.t_share_img);
            TopicModule topicModule = threadInfo.topic_module;
            if (topicModule != null) {
                ltc.a(jSONObject, "topic_module", lad.b(topicModule));
            }
            ltc.a(jSONObject, ImageViewerConfig.IS_BJH, threadInfo.is_bjh);
            ltc.a(jSONObject, "article_cover", threadInfo.article_cover);
            ltc.a(jSONObject, "bjh_content_tag", threadInfo.bjh_content_tag);
            ltc.a(jSONObject, "nid", threadInfo.nid);
            ltc.a(jSONObject, "is_headlinepost", threadInfo.is_headlinepost);
            Baijiahao baijiahao = threadInfo.baijiahao;
            if (baijiahao != null) {
                ltc.a(jSONObject, Constants.PAGE_BAIJIAHAO_NAME, zuc.b(baijiahao));
            }
            ltc.a(jSONObject, "is_s_card", threadInfo.is_s_card);
            ltc.a(jSONObject, "scard_packet_id", threadInfo.scard_packet_id);
            ltc.a(jSONObject, "thread_share_link", threadInfo.thread_share_link);
            ltc.a(jSONObject, "if_comment", threadInfo.if_comment);
            ltc.a(jSONObject, "if_comment_info", threadInfo.if_comment_info);
            ltc.a(jSONObject, "tab_id", threadInfo.tab_id);
            ltc.a(jSONObject, "tab_name", threadInfo.tab_name);
            ltc.a(jSONObject, "wonderful_post_info", threadInfo.wonderful_post_info);
            if (threadInfo.pb_link_info != null) {
                JSONArray jSONArray15 = new JSONArray();
                for (PbLinkInfo pbLinkInfo : threadInfo.pb_link_info) {
                    jSONArray15.put(c6d.b(pbLinkInfo));
                }
                ltc.a(jSONObject, "pb_link_info", jSONArray15);
            }
            Item item = threadInfo.item;
            if (item != null) {
                ltc.a(jSONObject, "item", c4d.b(item));
            }
            if (threadInfo.item_star != null) {
                JSONArray jSONArray16 = new JSONArray();
                for (HeadItem headItem : threadInfo.item_star) {
                    jSONArray16.put(v3d.b(headItem));
                }
                ltc.a(jSONObject, "item_star", jSONArray16);
            }
            ltc.a(jSONObject, "is_deleted", threadInfo.is_deleted);
            ltc.a(jSONObject, "hot_num", threadInfo.hot_num);
            if (threadInfo.pb_goods_info != null) {
                JSONArray jSONArray17 = new JSONArray();
                for (PbGoodsInfo pbGoodsInfo : threadInfo.pb_goods_info) {
                    jSONArray17.put(b6d.b(pbGoodsInfo));
                }
                ltc.a(jSONObject, "pb_goods_info", jSONArray17);
            }
            ltc.a(jSONObject, "is_local", threadInfo.is_local);
            ltc.a(jSONObject, "pb_entry", threadInfo.pb_entry);
            ltc.a(jSONObject, "is_author_view", threadInfo.is_author_view);
            ltc.a(jSONObject, "forum_user_live_msg", threadInfo.forum_user_live_msg);
            ForumFriendWatchingInfo forumFriendWatchingInfo = threadInfo.forum_friend_watching_info;
            if (forumFriendWatchingInfo != null) {
                ltc.a(jSONObject, "forum_friend_watching_info", kyc.b(forumFriendWatchingInfo));
            }
            WorksInfo worksInfo = threadInfo.works_info;
            if (worksInfo != null) {
                ltc.a(jSONObject, "works_info", qbd.b(worksInfo));
            }
            ltc.a(jSONObject, "collect_num", threadInfo.collect_num);
            if (threadInfo.thread_recommend_infos != null) {
                JSONArray jSONArray18 = new JSONArray();
                for (ThreadRecommendInfo threadRecommendInfo : threadInfo.thread_recommend_infos) {
                    jSONArray18.put(aad.b(threadRecommendInfo));
                }
                ltc.a(jSONObject, "thread_recommend_infos", jSONArray18);
            }
            ltc.a(jSONObject, "recom_tag_icon", threadInfo.recom_tag_icon);
            ltc.a(jSONObject, "is_tiebaplus_ad", threadInfo.is_tiebaplus_ad);
            ltc.a(jSONObject, "tiebaplus_order_id", threadInfo.tiebaplus_order_id);
            ltc.a(jSONObject, "tiebaplus_token", threadInfo.tiebaplus_token);
            ltc.a(jSONObject, "tiebaplus_extra_param", threadInfo.tiebaplus_extra_param);
            ltc.a(jSONObject, "tiebaplus_cant_delete", threadInfo.tiebaplus_cant_delete);
            ltc.a(jSONObject, "is_frs_mask", threadInfo.is_frs_mask);
            VoiceRoom voiceRoom = threadInfo.voice_room;
            if (voiceRoom != null) {
                ltc.a(jSONObject, "voice_room", kbd.b(voiceRoom));
            }
            ltc.a(jSONObject, "tab_show_mode", threadInfo.tab_show_mode);
            TiebaPlusAd tiebaPlusAd = threadInfo.tiebaplus_ad;
            if (tiebaPlusAd != null) {
                ltc.a(jSONObject, "tiebaplus_ad", dad.b(tiebaPlusAd));
            }
            RecommendTip recommendTip = threadInfo.recommend_tip;
            if (recommendTip != null) {
                ltc.a(jSONObject, "recommend_tip", p7d.b(recommendTip));
            }
            EditInfo editInfo = threadInfo.edit_info;
            if (editInfo != null) {
                ltc.a(jSONObject, "edit_info", swc.b(editInfo));
            }
            ltc.a(jSONObject, "is_pictxt", threadInfo.is_pictxt);
            ltc.a(jSONObject, "exposure_monitor_url", threadInfo.exposure_monitor_url);
            ltc.a(jSONObject, "click_monitor_url", threadInfo.click_monitor_url);
            ThreadRecommendTag threadRecommendTag = threadInfo.thread_recommend_tag;
            if (threadRecommendTag != null) {
                ltc.a(jSONObject, "thread_recommend_tag", bad.b(threadRecommendTag));
            }
            CustomFigure customFigure = threadInfo.custom_figure;
            if (customFigure != null) {
                ltc.a(jSONObject, "custom_figure", fwc.b(customFigure));
            }
            CustomState customState = threadInfo.custom_state;
            if (customState != null) {
                ltc.a(jSONObject, "custom_state", gwc.b(customState));
            }
            ltc.a(jSONObject, "is_highlight", threadInfo.is_highlight);
            ltc.a(jSONObject, "is_xiuxiu_thread", threadInfo.is_xiuxiu_thread);
            ThreadAblum threadAblum = threadInfo.ablum_info;
            if (threadAblum != null) {
                ltc.a(jSONObject, "ablum_info", x9d.b(threadAblum));
            }
            ltc.a(jSONObject, "show_ad_subscript", threadInfo.show_ad_subscript);
            ltc.a(jSONObject, "target_scheme", threadInfo.target_scheme);
            ltc.a(jSONObject, "convert_btn_type", threadInfo.convert_btn_type);
            ltc.a(jSONObject, "is_excellent_thread", threadInfo.is_excellent_thread);
            ltc.a(jSONObject, "literature_flag", threadInfo.literature_flag);
            if (threadInfo.hot_post_list != null) {
                JSONArray jSONArray19 = new JSONArray();
                for (Post post2 : threadInfo.hot_post_list) {
                    jSONArray19.put(t6d.b(post2));
                }
                ltc.a(jSONObject, "hot_post_list", jSONArray19);
            }
            RobotEntrance robotEntrance = threadInfo.robot_entrance;
            if (robotEntrance != null) {
                ltc.a(jSONObject, "robot_entrance", u7d.b(robotEntrance));
            }
            ClickBackCard clickBackCard = threadInfo.click_back_card;
            if (clickBackCard != null) {
                ltc.a(jSONObject, "click_back_card", awc.b(clickBackCard));
            }
            PeiwanInfo peiwanInfo = threadInfo.peiwan_info;
            if (peiwanInfo != null) {
                ltc.a(jSONObject, "peiwan_info", g6d.b(peiwanInfo));
            }
            ltc.a(jSONObject, "head_type", threadInfo.head_type);
            ltc.a(jSONObject, "disable_share", threadInfo.disable_share);
            ltc.a(jSONObject, "disable_share_toast", threadInfo.disable_share_toast);
            ltc.a(jSONObject, "share_url", threadInfo.share_url);
            ltc.a(jSONObject, "top_thread_set_time", threadInfo.top_thread_set_time);
            BusinessMix businessMix = threadInfo.business_mix;
            if (businessMix != null) {
                ltc.a(jSONObject, "business_mix", ovc.c(businessMix));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
